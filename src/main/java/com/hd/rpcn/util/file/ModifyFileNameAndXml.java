package com.hd.rpcn.util.file;

import cn.hutool.core.io.FileUtil;
import com.hd.rpcn.voc2007.DomParser;

import java.io.File;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 修改样本图片文件名和标注样本XML文件名及元素
 * @author hzh123
 *
 */
public class ModifyFileNameAndXml {
	public static void main(String[] args) {
		modify("D:\\训练素材样本库\\工地裸土覆盖情况图库\\裸土-已标注 - 副本","98",1);
	}
	/**
	 * 修改样本图片文件名以及XML元素
	 * @param path 源目录
	 * @param prefix 命名前缀 
	 * @param startNum 命名后缀从某个数字开始
	 */
	public static void modify(String path,String prefix,int startNum){
		File f=new File(path);
		if(f.exists() && f.isDirectory()){
			File[] childFiles = f.listFiles();
			DomParser d = new DomParser();
			if(childFiles.length >0){
				for(File file:childFiles){
					String fileName = file.getName();
					String FileSuffix=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
					String name=fileName.substring(0,fileName.lastIndexOf("."));
					if(!fileName.startsWith(prefix) && !FileSuffix.equals("xml")){
						String newFileName=generatorFileName(prefix, startNum, FileSuffix);
						File newFile=new File(path,newFileName);
						file.renameTo(newFile);
						//修改对应的XML
						File xmlFile=new File(path,name+".xml");
						if(xmlFile.exists()){
							startNum++;
							String content = FileUtil.readString(xmlFile, Charset.forName("UTF-8"));
							String regex="<filename>([a-zA-Z0-9]+.jpg)</filename>";
							Pattern p = Pattern.compile(regex);
							Matcher m = p.matcher(content);
							while (m.find()) {
								String val = m.group(1); 
								content = content.replaceAll(val, newFileName);
							}
							FileUtil.writeString(content,xmlFile,Charset.forName("UTF-8"));
							//修改文件名称
							String newXmlFileName=newFileName.substring(0,newFileName.lastIndexOf("."))+".xml";
							File newXmlFile=new File(path,newXmlFileName);
							xmlFile.renameTo(newXmlFile);
						}
					}
				}
			}
		}
	}
	
	public static String generatorFileName(String prefix,int startNum,String suffix){
		String newFileName="";
		if(startNum<10){
			newFileName=prefix+"000"+startNum+"."+suffix;
		}
		if(startNum<100 && startNum>=10){
			newFileName=prefix+"00"+startNum+"."+suffix;
		}
		if(startNum<1000 && startNum>=100){
			newFileName=prefix+"0"+startNum+"."+suffix;
		}
		if(startNum<10000 && startNum>=1000){
			newFileName=prefix+startNum+"."+suffix;
		}
		return newFileName;
		
	}
}
