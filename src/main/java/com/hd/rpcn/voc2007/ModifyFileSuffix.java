package com.hd.rpcn.voc2007;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 修改文件后缀
 * @author hzhh123
 *
 */
public class ModifyFileSuffix {
	public static void main(String[] args) {
		modify("D:\\hzhh123\\AI\\input\\1.png", "jpg");
	}
	/**
	 * 修改文件后缀名
	 * @param path 待修改的文件目录
	 * @param suffix 文件后缀
	 */
	public static void modify(String path,String suffix){
		File f=new File(path);
		if(f.exists() && f.isDirectory()){
			File[] childFiles = f.listFiles();
			if(childFiles.length >0){
				for(File file:childFiles){
					String fileName = file.getName();
					String FileSuffix=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
					System.out.println("文件后缀名"+FileSuffix);
					if(!FileSuffix.equals(suffix)){
						String newFileName=fileName.substring(0,fileName.lastIndexOf(".")+1)+suffix;
						System.out.println("新文件名1："+newFileName);
						File newFile=new File(path,newFileName);
						file.renameTo(newFile);
					}
				}
			}
		}

		if (f.exists() && f.isFile()){
			String fileName = f.getName();
			String FileSuffix=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
			System.out.println("文件后缀名"+FileSuffix);
			if(!FileSuffix.equals(suffix)){
				String newFileName=fileName.substring(0,fileName.lastIndexOf(".")+1)+suffix;
				System.out.println("新文件名1："+newFileName);
				String newPath=path.replace(fileName,newFileName);
				File newFile=new File(newPath);
				System.out.println(newFile.getPath());
				f.renameTo(newFile);
			}
		}
	}

}
