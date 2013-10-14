/*
 * WaterMark.java
 * 智域工作室
 */
package net.intellizone.coupon.util.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.intellizone.coupon.admin.model.CouponDemo;

/**
 * 打印图图片处理类
 * 
 * @author mass
 * @version 1.0
 */
public class WaterMark {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(WaterMark.class.getSimpleName());

	/**
	 * 根据ORDERID输出POS打印图
	 * 
	 * @param response
	 *            响应
	 * @param couponDemo
	 */
	@SuppressWarnings("deprecation")
	public static void outMarkLogo(HttpServletResponse response, CouponDemo couponDemo) {
		try {
			// 新建黑白图片
			BufferedImage img = generateCouponImg(couponDemo, false);

			OutputStream respStream = response.getOutputStream();
			ImageIO.write(img, "BMP", respStream);
			respStream.flush();
			respStream.close();
		} catch (Exception e) {
			logger.warn("生成打印图失败", e);
		}
	}

	/**
	 * @param localPath
	 *            添加水印LOGO路径
	 * @param request
	 *            请求流对象
	 * @param request
	 *            响应流对象
	 */
	@SuppressWarnings("deprecation")
	public static File createMarkLogo(String yqpath, CouponDemo couponDemo) {
		try {
			BufferedImage img = generateCouponImg(couponDemo, true);

			File fo = new File(yqpath);

			ImageIO.write(img, "jpeg", fo);
			return fo;
		} catch (Exception e) {
			logger.warn("生成样券图失败", e);
		}

		return null;
	}

	// 生成优惠劵打印图
	private static BufferedImage generateCouponImg(CouponDemo couponDemo, boolean isYq) {
		int currentHeight = 0;
		try {
			// 写入订单编号
			// 如果是样券，就是灰度图，如果不是样券，就是黑白图
			BufferedImage img = new BufferedImage(384, 950, isYq ? BufferedImage.TYPE_BYTE_GRAY
					: BufferedImage.TYPE_BYTE_BINARY);
			Graphics2D g = img.createGraphics();
			// 填充背景
			g.setBackground(Color.white);
			g.clearRect(0, 0, 384, 950);

			g.setColor(Color.black);
			g.drawRect(1, 1, 381, 947);// 绘制边框

			currentHeight += 1;

			if (isYq) {
				// 样券背景logo
				FileInputStream yqBgLogo = new FileInputStream(couponDemo.getYqMarkPath());
				Image yqBgImg = ImageIO.read(yqBgLogo);
				g.drawImage(yqBgImg, 50, 270, 300, 150, null);
			}

			// 绘制编号背景
			g.setBackground(Color.black);
			g.clearRect(35, 1, 315, 40);

			// 绘制编号
			g.setColor(Color.white);
			g.setFont(new Font("simsun", Font.BOLD, 24));
			g.drawString("No. " + couponDemo.getNo(), 38, 30); // 添加文字

			currentHeight += 40;

			// 绘制商户logo
			FileInputStream shopLogo = new FileInputStream(couponDemo.getShopLogoPath());
			Image logoimg = ImageIO.read(shopLogo);
			double fw = logoimg.getWidth(null) == 0 ? 1 : logoimg.getWidth(null);
			double fh = logoimg.getHeight(null) == 0 ? 1 : logoimg.getHeight(null);

			int height = (int) (fh / fw * 315);
			height = height > 190 ? 190 : height; // 最高不能超过190
			logoimg = logoimg.getScaledInstance(315, height, Image.SCALE_AREA_AVERAGING);

			currentHeight += 10;// 板块间隙
			g.drawImage(logoimg, 35, currentHeight, 315, height, null);// 把logo图片写入画板
			currentHeight += height;

			// 绘制优惠劵名称
			g.setColor(Color.black);
			g.setFont(new Font("simhei", Font.BOLD, 32));
			String title = couponDemo.getTitle();
			List<String> lineList = getLineList(title, 10, 4);
			for (String line : lineList) {
				currentHeight += 10;// 间隙
				currentHeight += 32;
				g.drawString(line, 35, currentHeight); // 添加文字
			}

			// 生成截止日期
			g.setFont(new Font("simsun", Font.BOLD, 20));
			String period = "".equals(couponDemo.getBeginTime()) ? "有效期至："
					+ couponDemo.getEndTime() : "有效期：" + couponDemo.getBeginTime() + "至"
					+ couponDemo.getEndTime();
			currentHeight += 10; // 板块间隙
			currentHeight += 20;
			g.drawString(period, 35, currentHeight); // 添加文字

			// 绘制使用规则
			currentHeight += 10; // 板块间隙
			currentHeight += 20;
			g.drawString("使用规则：", 150, currentHeight); // 添加文字

			currentHeight += 20;
			String useInfo = couponDemo.getUserInfo();
			lineList = getLineList(useInfo, 16, 10);
			for (String line : lineList) {
				currentHeight += 5;// 间隙
				currentHeight += 20;
				g.drawString(line, 35, currentHeight); // 添加文字
			}

			// 电话
			currentHeight += 10;// 间隙
			currentHeight += 20;
			g.drawString("电话：" + couponDemo.getTelphone(), 35, currentHeight); // 添加文字
			// 使用地址
			currentHeight += 5;// 间隙
			String useAddress = "地址：" + couponDemo.getUseAddress();
			lineList = getLineList(useAddress, 16, 3);
			for (String line : lineList) {
				currentHeight += 5;// 间隙
				currentHeight += 20;
				g.drawString(line, 35, currentHeight); // 添加文字
			}

			// 固定尾部
			g.drawString("详情请咨询商户或10000号客服", 40, 875);// 券尾

			// 绘制底部logo
			FileInputStream logoBtm = new FileInputStream(couponDemo.getBtmLogoPath());
			Image logoBtmimg = ImageIO.read(logoBtm);
			g.drawImage(logoBtmimg, 10, 880, 360, 60, null);

			g.dispose();// 生成图片

			return img;
		} catch (Exception e) {
			logger.warn("生成打印图失败", e);
			return null;
		}
	}

	// 拆分字符串
	private static List<String> getLineList(String line, int charPerLine, int max) {
		boolean exceeded = false; // 是否超长

		int length = line.length();
		int lines; // 总行数

		if (length > charPerLine * max) {
			exceeded = true;
			line = line.substring(0, charPerLine * max - 2); // 去掉超长部分，额外去掉2个字
			lines = max;
			length = line.length();
		} else {
			lines = length / charPerLine + (length % charPerLine == 0 ? 0 : 1);
		}

		List<String> lineList = new ArrayList<String>();
		for (int i = 0; i < lines; i++) {
			if (i == (lines - 1)) {
				lineList.add(line.substring(i * charPerLine, length) + (exceeded ? "..." : ""));
			} else {
				lineList.add(line.substring(i * charPerLine, (i + 1) * charPerLine));
			}
		}

		return lineList;
	}
}