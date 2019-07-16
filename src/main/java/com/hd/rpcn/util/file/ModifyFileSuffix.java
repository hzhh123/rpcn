package com.hd.rpcn.util.file;

import java.io.File;

/**
 * 修改文件后缀
 * @author hzhh123
 *
 */
public class ModifyFileSuffix {
	public static void main(String[] args) {
		ModifyFileSuffixMethod("D:\\训练素材样本库\\工地裸土覆盖情况图库\\demo2", "jpg");
	}
	/**
	 * 修改文件后缀名
	 * @param path 待修改的文件目录
	 * @param suffix 文件后缀
	 */
	public static void ModifyFileSuffixMethod(String path,String suffix){
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
						System.out.println("新文件名："+newFileName);
						File newFile=new File(path,newFileName);
						file.renameTo(newFile);
					}
				}
			}
		}
	}
}
