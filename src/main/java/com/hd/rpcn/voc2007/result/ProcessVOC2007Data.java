package com.hd.rpcn.voc2007.result;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import cn.hutool.core.io.FileUtil;
import com.hd.rpcn.voc2007.DomParser;
import com.hd.rpcn.voc2007.annotation;

public class ProcessVOC2007Data {

	static String objNames = "|aqm|person|car|";

	public static void main(String[] args) throws Exception {
//		processAnnotation();
		resize();//删除990045 990226
		check();
//		find();
//		findAno();
//		check();// 009498 009947 009683
//		findTooSmall();
	}

	/**
	 * 太小的box
	 * @throws Exception
	 */
	public static void findTooSmall() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007"; 
		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
			String content = FileUtil.readString(file.getAbsolutePath(), Charset.forName("UTF-8"));
			int length = content.length();
			while (true) { 
				int objStart = content.indexOf("<bndbox>");
				if (objStart < 0)
					break;
				int objEnd = content.indexOf("</bndbox>"); 
				String bndbox = content.substring(objStart, objEnd );
				
				int xmin = getVal(bndbox, "xmin");
				int xmax = getVal(bndbox, "xmax");
				int ymin = getVal(bndbox, "ymin");
				int ymax = getVal(bndbox, "ymax");
				
				if(xmax - xmin < 10 && ymax - ymin < 10){
					System.out.println(file.getAbsolutePath());
//					System.out.println(xmin + ":" + xmax);
//				}
//				if(ymax - ymin < 10){
//					System.out.println(ymin + "::::" + ymax);
				}
				
				content = content.substring(objEnd + "</bndbox>".length());
			} 
			
			 
		}
	}
	
	private static int getVal(String seg, String property) throws Exception{
		Pattern p = Pattern.compile("(<" + property + ">)([0-9]+)(</" + property + ">)");
		Matcher m = p.matcher(seg);
		Map<String, String> repMap = new HashMap<String, String>();
		if (m.find()) {
			String val = m.group(2); 
			return Integer.valueOf(val);
		}
		throw new Exception("error");
	}

	public static void find() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";

		File dir = new File(path + "\\JPEGImages");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) { 
			InputStream is = new FileInputStream(file);         
	        BufferedImage prevImage = ImageIO.read(is);
	        is.close();
	        System.out.print(1);
	        int width = prevImage.getWidth();
	        int height = prevImage.getHeight();
	        if((width == 300 && height == 448) || (width == 448 && height == 300) ){
	        	System.out.println(file.getName());
	        }
	        
		} 
	}

	public static void findAno() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";

		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
			
//			if( !file.getName().startsWith("99"))continue;

			String content = FileUtil.readString(file,Charset.forName("UTF-8"));
//			if( content.indexOf("59") > 0 && content.indexOf("117") > 0 && content.indexOf("138") > 0 
//					&& content.indexOf("154") > 0 && content.indexOf("91") > 0){
//				System.out.println(file.getName());
////				System.out.println(content);
//			}
//			System.out.println(1);
			if( 
					( content.indexOf("98") > 0) 
					&&( content.indexOf("57") > 0) 
					&&( content.indexOf("68") > 0)  
					){
				System.out.println(file.getName());
			}
		}
	}
	
	private static void delImg(File file){
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";
		String jpgName = file.getName().replace(".xml", ".jpg");
		File jpgFile = (new File(path + "\\JPEGImages\\" + jpgName));
		// System.out.println("删除" + jpgFile.getPath());
		if (jpgFile.exists()) {
			System.out.println("删除" + jpgFile.getName());
			jpgFile.delete();
			file.delete();
		}
	}
	

	public static void check() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";

		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
			
//			if( !file.getName().startsWith("99"))continue;
			String content = FileUtil.readString(file,Charset.forName("UTF-8"));
//			if( content.indexOf("59") > 0 && content.indexOf("117") > 0 && content.indexOf("138") > 0 
//					&& content.indexOf("154") > 0 && content.indexOf("91") > 0){
//				System.out.println(file.getName());
////				System.out.println(content);
//			}
			
//			content = content.replaceAll("<pose>[a-zA-Z0-9]+</pose>", "<pose>Unspecified</pose>");
			
//			FileUtil.writeFile(file.getAbsolutePath(), content);
//
			if( 
//			content.indexOf("<truncated>1</truncated>")> 0 
					  content.indexOf("<ymin>0</ymin>") > 0 
//					&& content.indexOf("<truncated>0</truncated>") < 0 
//						&& content.indexOf("<difficult>0</difficult>") < 0 
					){
				content = content.replace("<ymin>0</ymin>", "<ymin>1</ymin>");
				//FileUtil.writeFile(file.getAbsolutePath(), content);
				FileUtil.writeString(content,file,Charset.forName("UTF-8"));
//				delImg(file);
//				file.delete();
				System.out.println(file.getName());
			}

			if( 
//			content.indexOf("<truncated>1</truncated>")> 0 
					  content.indexOf("<xmin>0</xmin>") > 0 
//					&& content.indexOf("<truncated>0</truncated>") < 0 
//						&& content.indexOf("<difficult>0</difficult>") < 0 
					){
				content = content.replace("<xmin>0</xmin>", "<xmin>1</xmin>");
				//FileUtil.writeFile(file.getAbsolutePath(), content);
				FileUtil.writeString(content,file,Charset.forName("UTF-8"));
//				delImg(file);
//				file.delete();
				System.out.println(file.getName());
			}
			
			
			
		}
	}

	public static void main() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";

		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
			annotation a = (annotation) d.parseObject(file, annotation.class);
			// System.out.println(a.getFolder());
			// System.out.println(a.getFilename());
			// System.out.println(a.getSource().getFlickrid());

			List<String> notUse = new ArrayList<String>();
			for (int i = a.getObject().size(); i > 0; i--) {
				String name = a.getObject().get(i - 1).getName();
				if (objNames.indexOf("|" + name + "|") < 0) {
					notUse.add(name);
					a.getObject().remove(i - 1);
				}
				// System.out.println(name);
			}

			System.out.println(file.getName());
			if (a.getObject().size() == 0) {// 删除数据
				String jpgName = file.getName().replace(".xml", ".jpg");
				File jpgFile = (new File(path + "\\JPEGImages\\" + jpgName));
				// System.out.println("删除" + jpgFile.getPath());
				if (jpgFile.exists()) {
					System.out.println("删除" + jpgFile.getName());
					jpgFile.delete();
					file.delete();
				}
			} else {
				if (notUse.isEmpty())
					continue;
				String content = FileUtil.readString(file,Charset.forName("UTF-8"));
//				String content = FileUtil.readFile(file.getAbsolutePath());
				System.out.println(content);
				for (String n : notUse) {
					int objStart = content.indexOf("<object>");
					int objEnd = content.indexOf("</object>");
					content = content.substring(0, objStart) + content.substring(objEnd + "</object>".length());
				}
				System.out.println(content);
				//FileUtil.writeFile(file.getAbsolutePath(), content);
				FileUtil.writeString(content,file,Charset.forName("UTF-8"));
			}
			// break;
		}

	}

	public static void processAnnotation() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";

		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
//			String jpgName = file.getName().replace(".xml", ".jpg");
//			File jpgFile = (new File(path + "\\JPEGImages\\" + jpgName));
//			// System.out.println("删除" + jpgFile.getPath());
//			if (!jpgFile.exists()) {
//				file.delete();
//				continue;
//			}

			//String content = FileUtil.readFile(file.getAbsolutePath());
			String content = FileUtil.readString(file,Charset.forName("UTF-8"));
			int length = content.length();
			// System.out.println(content);
			int startIndex = 0;
			while (true) {

				int objStart = content.indexOf("<object>", startIndex);
				if (objStart < 0)
					break;
				int objEnd = content.indexOf("</object>", startIndex);
				
				String obj = content.substring(objStart, objEnd );
				
				if (obj.indexOf("car") > 0 || obj.indexOf("person") > 0 || obj.indexOf("aqm") > 0) {
					startIndex = objEnd + 8;
				} else {
					content = content.substring(0, objStart) + content.substring(objEnd + "</object>".length());
					startIndex = objStart;
				}
				
			}
			// System.out.println(content);
			if (length != content.length())
				//FileUtil.writeFile(file.getAbsolutePath(), content);
				FileUtil.writeString(content,file,Charset.forName("UTF-8"));
		}
	}
	
    /**
     * 改变图片的大小到宽为size，然后高随着宽等比例变化
     * @param size 新图片的宽
     * @param format 新图片的格式
     * @throws IOException
     */
    public static double resizeImage(File jpgFile, int size, String format) throws IOException {
    	

		InputStream is = new FileInputStream(jpgFile);         
        BufferedImage prevImage = ImageIO.read(is);
        is.close();
        
        double width = prevImage.getWidth();
        double height = prevImage.getHeight();
        
//        System.out.println(width + ":" + height);
        double percent;
        if( width <= size && height <=size){
        	return 1;
        }else if( width > height){
        	percent = size/width;
        }else{
        	percent = size/height;
        }
        
        if( percent == 1){
        	return 1;
        }
         
        int newWidth = (int)(width * percent);
        int newHeight = (int)(height * percent);
        
      

        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
        OutputStream os = new FileOutputStream(jpgFile);
        Graphics graphics = image.createGraphics();
        graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
        ImageIO.write(image, format, os);
        os.flush();
        os.close(); 
        return percent;
    }
	

	public static void resize() throws Exception {
		String path = "D:\\tensorflow\\rcnn\\data\\VOCDevkit2007\\VOC2007";
		File dir = new File(path + "\\Annotations");
		DomParser d = new DomParser();
		for (File file : dir.listFiles()) {
			if( !file.getName().startsWith("99"))continue;
			String jpgName = file.getName().replace(".xml", ".jpg");
			File jpgFile = (new File(path + "\\JPEGImages\\" + jpgName)); 
			
            double rate = resizeImage(jpgFile, 500, "jpg");
//			System.out.println(rate);
            if( rate == 1){
            	continue;
            }
			

			String content = FileUtil.readString(file.getAbsolutePath(),Charset.forName("UTF-8"));
		//	String content = FileUtil.readFile(file.getAbsolutePath());
//			System.out.println(content);

			Pattern p = Pattern.compile("(<[xy]m[ia][nx]>)([0-9]+)(</[xy]m[ia][nx]>)");
			Matcher m = p.matcher(content);
			Map<String, String> repMap = new HashMap<String, String>();
			while (m.find()) {
				String val = m.group(2); 
				int newVal = (int)(Integer.valueOf(val) * rate);
				System.out.println( m.group() + ":" + val);
				repMap.put(m.group(), m.group(1) + newVal + m.group(3));
			}
			for( String key: repMap.keySet()){
				content = content.replace(key, repMap.get(key));
			}
			FileUtil.writeString(content,file.getAbsolutePath(), Charset.forName("UTF-8"));
		}
	}
}
