/*
 * ContentHelper.java 2012-2-6
 * 智域工作室
 */
package net.intellizone.coupon.msg.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.msg.model.MMS;
import net.intellizone.coupon.msg.template.services.MsgTemplateService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.coupon.util.web.TemplateHelper;
import net.intellizone.utils.DateUtils;

/**
 * 信息内容帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class ContentHelper {
	private static final Logger logger = Logger.getLogger(ContentHelper.class.getSimpleName());

	// 信息模板服务
	private static MsgTemplateService msgTemplateService = new MsgTemplateService();

	// 获取模板内容，并替换成短信内容
	public static String getSMSContent(User user, String msgTempleteCode, Goods coupon) {
		Map<String, Object> contextValues = new HashMap<String, Object>();
		contextValues.put("user", user);
		contextValues.put("coupon", coupon);
		contextValues.put("time", DateUtils.formatCurrentDateTime());

		String templateContent = msgTemplateService.getMsgTemplateByCode(msgTempleteCode)
				.getTemplateContent();

		String result = TemplateHelper.INSTANCE.merge(templateContent, contextValues);

		if ("".equals(result)) {
			return "系统暂不可用，请稍后再试。";
		}

		return result;
	}

	// 获取模板内容，并替换成彩信内容
	public static MMS getMMS(User user, String msgTempleteCode, Goods coupon) {
		Map<String, Object> contextValues = new HashMap<String, Object>();
		contextValues.put("user", user);
		contextValues.put("coupon", coupon);
		contextValues.put("time", DateUtils.formatCurrentDateTime());

		MMS mms;

		String templateContent = msgTemplateService.getMsgTemplateByCode(msgTempleteCode)
				.getTemplateContent();

		if ("".equals(templateContent)) {
			mms = new MMS();
			mms.setContent("系统暂不可用，请稍后再试。");
			return mms;
		}

		String result = TemplateHelper.INSTANCE.merge(templateContent, contextValues);

		return getMMSContent(result);
	}

	// 获取附件列表，并将模板替换为实际文件
	private static MMS getMMSContent(String templateContent) {
		String realPath = AppContext.getInstance().getAPP_PATH();
		// 获取所有文字
		String[] textArr = templateContent.split("<img\\ssrc=\"(.*?)/>");

		// 获取所有图片
		Pattern mmsPat = Pattern.compile("<img\\ssrc=\"(.*?)\"");
		Matcher mmsMat = mmsPat.matcher(templateContent);
		List<String> mmsList = new ArrayList<String>();
		while (mmsMat.find()) {
			String currentFile = mmsMat.group(1);
			currentFile = currentFile.replaceAll(AppContext.getInstance().getAPP_CONTEXT(), "");
			String fullPath = realPath + currentFile;
			mmsList.add(fullPath);
		}

		String fileRoot = realPath + "mms" + File.separator;
		// 组装smil文件内容
		String smil = getSmil(fileRoot, textArr, mmsList);

		// 新建彩信
		MMS mms = new MMS();
		mms.setContent("彩信标题");
		try {
			// 写smil文件
			String smilPath = fileRoot + System.currentTimeMillis() + ".smil";
			FileUtils.write(new File(smilPath), smil);
			// 将.smil也作为附件发送
			mmsList.add(smilPath);

			mms.setAttachmentList(mmsList);
		} catch (IOException e) {
			logger.warn("将短信内容写成附件失败", e);
		}

		return mms;
	}

	private static String getSmil(String fileRoot, String[] textArr, List<String> mmsList) {
		try {

			// 以当时的毫秒数作为文件前缀
			long filePrefix = System.currentTimeMillis();
			// 头部字符串构造器
			StringBuilder head = new StringBuilder();
			head.append("<smil xmlns=\"http://www.w3.org/2000/SMIL20/CR/Language\">").append(
					"<head><layout><root-layout/>");
			// body字符串构造器
			StringBuilder body = new StringBuilder();
			body.append("<body><seq>");

			for (int i = 0, length = textArr.length; i < length; i++) {
				head.append("<region id=\"text").append(i).append("\"/>");

				String textFilePath = fileRoot + filePrefix + i + ".text";
				FileUtils.write(new File(textFilePath), textArr[i]);
				body.append("<text src=\"").append(textFilePath).append("\" region=\"text").append(
						i).append("\"/>");

				// 处理图片
				if (i != length - 1) {
					head.append("<region id=\"img").append(i).append("\"/>");
					body.append("<img src=\"").append(mmsList.get(i)).append("\" region=\"img")
							.append(i).append("\"/>");
				}
			}

			head.append("</layout></head>");
			body.append("</seq></body></smil>");

			return head.append(body).toString();
		} catch (IOException e) {
			logger.warn("将短信内容写成附件失败", e);
		}

		return "";
	}

	public static void main(String[] args) {
	}
}
