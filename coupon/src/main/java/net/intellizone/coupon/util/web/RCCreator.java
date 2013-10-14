package net.intellizone.coupon.util.web;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.isloop.qrcode;

public class RCCreator {
	public static File createRC(String name,String id,String file){
		try {

		qrcode testQrcode =new qrcode();
        testQrcode.setQrcodeErrorCorrect('M');
        testQrcode.setQrcodeEncodeMode('B');
        testQrcode.setQrcodeVersion(1000);

        String content="这是中国电信的优惠券的二维码这是中国电信的优惠券的二维码这是中国电信的优惠券的二维码这是中国电信的优惠券的二维码这是中国电信的优惠券中国电信的优惠券的优惠券这是中国电信的优惠券中国电信的优惠券的优惠券这是中国电信---888---id="+id;
        byte[] d = content.getBytes("utf-8");
        System.out.println(d.length);
        BufferedImage bi = new BufferedImage(230,230, BufferedImage.TYPE_INT_RGB);
        //如果内容比较多，需要将图片的大小进行调整。
        Graphics2D g = bi.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 230, 230);
        g.setColor(Color.BLACK);
        
        // 设置偏移量 不设置可能导致解析出错  
        int pixoff = 4;  
        // 输出内容 > 二维码  
        if (d.length > 0 && d.length < 350) {  
            boolean[][] codeOut = testQrcode.calQrcode(d);  
            for (int i = 0; i < codeOut.length; i++) {  
                for (int j = 0; j < codeOut.length; j++) {  
                    if (codeOut[j][i]) {  
                        g.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                    }  
                }  
            }  
        } else {  
            System.err.println("QRCode content bytes length = "  
                    + d.length + " not in [ 0,350 ]. ");  
        } 
        g.dispose();
        bi.flush();
        File f = new File(file);
        if(!f.exists()){
				f.createNewFile();
			
        }
        
			ImageIO.write(bi, "jpg", f);
	
			return  f;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
