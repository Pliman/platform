package net.intellizone.coupon.util.web;


/**
 * ImageCompress JPG
**/

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class ImageCompress 
//	extends Frame 
	{
	private static final long serialVersionUID = 48L;
	

	private static final String version = "ImageCompress v1.0";
	public ImageCompress(){
		
	}
	
  
  public  static boolean ImageCut(String path,String fileName,String toFileName,int x,int y,int width,int height){
	    try {
		    Image image = javax.imageio.ImageIO.read(new File(path + fileName));
		    int imageWidth = image.getWidth(null);
	    	int imageHeight = image.getHeight(null);
		    
		    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		    // Make a BufferedImage from the Image.
		    BufferedImage mBufferedImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		    Graphics2D g2 = mBufferedImage.createGraphics();
				

		   
		    g2.drawImage(image, (0-x),(0-y), imageWidth,imageHeight, Color.white,null);
		    g2.dispose();

		    g2.drawImage(image,0,0, width, height,x,y,(x+width),(y+height), Color.white, null);
		    g2.dispose();
		    
				float[] kernelData2 = { 
						-0.125f, -0.125f, -0.125f,
	          -0.125f,2, -0.125f,
	          -0.125f,-0.125f, -0.125f };
		    Kernel kernel = new Kernel(3, 3, kernelData2);
		    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		    mBufferedImage = cOp.filter(mBufferedImage, null);

		    File fo = new File(path + toFileName);
            ImageIO.write(mBufferedImage, "jpeg", fo);
			return true;
	    }catch (FileNotFoundException fnf){
	    	return false;
	    }catch (IOException ioe){
	    	return false;
	    }finally{
	    
	    }
  }
  
  
  
  public static void ImageScale(String path,String fileName,String toFileName){
    try {
	    Image image = javax.imageio.ImageIO.read(new File(path + fileName));
	    int imageWidth = image.getWidth(null);
    	int imageHeight = image.getHeight(null);
	    float scale = getRatio(imageWidth,imageHeight,130,130);
	    imageWidth = (int)(scale*imageWidth);
	    imageHeight = (int)(scale*imageHeight);
	    
	    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
	    // Make a BufferedImage from the Image.
	    BufferedImage mBufferedImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = mBufferedImage.createGraphics();
			
	    //Map readeringHint = new HashMap();
			//readeringHint.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	    //readeringHint.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    //readeringHint.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	    //readeringHint.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	    //readeringHint.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);//VALUE_INTERPOLATION_BICUBIC
	    //readeringHint.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    //g.setRenderingHints(readeringHint);
			
	    g2.drawImage(image, 0, 0,imageWidth, imageHeight, Color.white,null);
	    g2.dispose();
	    
			float[] kernelData2 = { 
					-0.125f, -0.125f, -0.125f,
          -0.125f,2, -0.125f,
          -0.125f,-0.125f, -0.125f };
	    Kernel kernel = new Kernel(3, 3, kernelData2);
	    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
	    mBufferedImage = cOp.filter(mBufferedImage, null);

	    File fo = new File(path + toFileName);
        ImageIO.write(mBufferedImage, "jpeg", fo);
    }catch (FileNotFoundException fnf){
    	fnf.printStackTrace();
    }catch (IOException ioe){
    	ioe.printStackTrace();
    }finally{
    
    }
  }
  public static void ImageScale(String path,String fileName,String subFolder,String toFileName,int maxWidth,int maxHeight){
	    try {
		    Image image = javax.imageio.ImageIO.read(new File(path + fileName));
		    int imageWidth = image.getWidth(null);
	    	int imageHeight = image.getHeight(null);
		    float scale = getRatio(imageWidth,imageHeight,maxWidth,maxHeight);
		    imageWidth = (int)(scale*imageWidth);
		    imageHeight = (int)(scale*imageHeight);
		    
		    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		    // Make a BufferedImage from the Image.
		    BufferedImage mBufferedImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
		    Graphics2D g2 = mBufferedImage.createGraphics();
				
		    //Map readeringHint = new HashMap();
				//readeringHint.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    //readeringHint.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		    //readeringHint.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);//VALUE_INTERPOLATION_BICUBIC
		    //readeringHint.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		    //g.setRenderingHints(readeringHint);
				
		    g2.drawImage(image, 0, 0,imageWidth, imageHeight, Color.white,null);
		    g2.dispose();
		    
				float[] kernelData2 = { 
						-0.125f, -0.125f, -0.125f,
	          -0.125f,2, -0.125f,
	          -0.125f,-0.125f, -0.125f };
		    Kernel kernel = new Kernel(3, 3, kernelData2);
		    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		    mBufferedImage = cOp.filter(mBufferedImage, null);

		    File fo = new File(path +"/"+subFolder+"/"+ toFileName);
            ImageIO.write(mBufferedImage, "jpeg", fo);
	    }catch (FileNotFoundException fnf){
	    }catch (IOException ioe){
	    }finally{
	    }
	  }
  
  public static void ImageScale(String path,String toFileName,int maxWidth,int maxHeight){
	    try {
		    Image image = javax.imageio.ImageIO.read(new File(path));
		    int imageWidth = image.getWidth(null);
	    	int imageHeight = image.getHeight(null);
		    float scale = getRatio(imageWidth,imageHeight,maxWidth,maxHeight);
		    imageWidth = (int)(scale*imageWidth);
		    imageHeight = (int)(scale*imageHeight);
		    
		    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		    // Make a BufferedImage from the Image.
		    BufferedImage mBufferedImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
		    Graphics2D g2 = mBufferedImage.createGraphics();
				
		    //Map readeringHint = new HashMap();
				//readeringHint.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    //readeringHint.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		    //readeringHint.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);//VALUE_INTERPOLATION_BICUBIC
		    //readeringHint.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		    //g.setRenderingHints(readeringHint);
				
		    g2.drawImage(image, 0, 0,imageWidth, imageHeight, Color.white,null);
		    g2.dispose();
		    
				float[] kernelData2 = { 
						-0.125f, -0.125f, -0.125f,
	          -0.125f,2, -0.125f,
	          -0.125f,-0.125f, -0.125f };
		    Kernel kernel = new Kernel(3, 3, kernelData2);
		    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		    mBufferedImage = cOp.filter(mBufferedImage, null);

		    File fo = new File(path);
        ImageIO.write(mBufferedImage, "jpeg", fo);
	    }catch (FileNotFoundException fnf){
	    }catch (IOException ioe){
	    }finally{
	    }
	  }
  public static void ImageScale(String path,int maxWidth,int maxHeight){
	    try {
		    Image image = javax.imageio.ImageIO.read(new File(path));
		    int imageWidth = image.getWidth(null);
	    	int imageHeight = image.getHeight(null);
		    float scale = getRatio(imageWidth,imageHeight,maxWidth,maxHeight);
		    imageWidth = (int)(scale*imageWidth);
		    imageHeight = (int)(scale*imageHeight);
		    
		    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		    // Make a BufferedImage from the Image.
		    BufferedImage mBufferedImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
		    Graphics2D g2 = mBufferedImage.createGraphics();
				
		    //Map readeringHint = new HashMap();
				//readeringHint.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    //readeringHint.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		    //readeringHint.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		    //readeringHint.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);//VALUE_INTERPOLATION_BICUBIC
		    //readeringHint.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		    //g.setRenderingHints(readeringHint);
				
		    g2.drawImage(image, 0, 0,imageWidth, imageHeight, Color.white,null);
		    g2.dispose();
		    
				float[] kernelData2 = { 
						-0.125f, -0.125f, -0.125f,
	          -0.125f,2, -0.125f,
	          -0.125f,-0.125f, -0.125f };
		    Kernel kernel = new Kernel(3, 3, kernelData2);
		    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		    mBufferedImage = cOp.filter(mBufferedImage, null);

		    File fo = new File(path);
          ImageIO.write(mBufferedImage, "jpeg", fo);
	    }catch (FileNotFoundException fnf){
	    }catch (IOException ioe){
	    }finally{
	    }
	  }
  public static float getRatio(int width,int height,int maxWidth,int maxHeight){
  	float Ratio = 1.0f;
  	float widthRatio ;
  	float heightRatio ;
    widthRatio = (float)maxWidth/width;
    heightRatio = (float)maxHeight/height;
    if(widthRatio<1.0 || heightRatio<1.0){
      Ratio = widthRatio<=heightRatio?widthRatio:heightRatio;
    }
    return Ratio;
  }
  
  public static String getFileExt(String filePath) {
    String tmp = filePath.substring(filePath.lastIndexOf(".") + 1);
    return tmp.toUpperCase();
  }

  public static String getFileName(String filePath) {
    int pos = -1;
    int endPos = -1;
    if (!filePath.equals("")) {
      if (filePath.lastIndexOf("/") != -1) {
        pos = filePath.lastIndexOf("/") + 1;
      } else if (filePath.lastIndexOf("\\") != -1) {
        pos = filePath.lastIndexOf("\\") + 1;
      }
      if (pos == -1)
        pos = 0;
      filePath = filePath.substring(pos);
      endPos = filePath.lastIndexOf(".");
      if (endPos == -1) {
        return filePath;
      } else {
        return filePath.substring(0, endPos);
      }
    } else {
      return "";
    }
  }

  public static String getFileFullName(String filePath) {
    int pos = -1;
    if (!filePath.equals("")) {
      if (filePath.lastIndexOf("/") != -1) {
        pos = filePath.lastIndexOf("/") + 1;
      } else if (filePath.lastIndexOf("\\") != -1) {
        pos = filePath.lastIndexOf("\\") + 1;
      }
      if (pos == -1)
        pos = 0;
      return filePath.substring(pos);
    } else {
      return "";
    }
  }
  
  public static String getFilePath(String filePath) {
    int pos = -1;
    if (!filePath.equals("")) {
      if (filePath.lastIndexOf("/") != -1) {
        pos = filePath.lastIndexOf("/") + 1;
      } else if (filePath.lastIndexOf("\\") != -1) {
        pos = filePath.lastIndexOf("\\") + 1;
      }
      if (pos != -1) {
        return filePath.substring(0, pos);
      } else {
        return "";
      }
    } else {
      return "";
    }
  }
}
