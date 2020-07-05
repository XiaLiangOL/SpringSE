/**
 * 
 */
package cn.smbms.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.aspectj.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 用于文件上传
 * 
 * @author 梁
 *
 */
public class FileUpload {
	
	private long fileSize;
	
	/**
	 * 设置对文件限制
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	private List<String> fileSuffix;
	
	/**
	 * 文件规定后缀
	 */
	public void setFileSuffix(List<String> fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	
	/**
	 * 保存地址
	 */
	private String saveAddress;
	
	/**
	 * 
	 * 判断文件能否上传 先设置FileSize
	 */
	public boolean determineIfTheFileCanBeUploaded(MultipartFile attach) {
		if (!attach.isEmpty()) {
			/* 原文件名 */
			String originalFilename = attach.getOriginalFilename();
			/* 原文件后缀 */
			String extension = FilenameUtils.getExtension(originalFilename);
			/* 判断原文件大小 */
			if (attach.getSize() < fileSize) {
				for (String name : fileSuffix) {
					if (name.equalsIgnoreCase(extension)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 自定义名字上传文件
	 * 
	 * @param parent
	 *            保存路径
	 * @param child
	 *            文件名字
	 * @param attach
	 */
	public boolean uploadFiles(String path, String child, MultipartFile attach) {
		File targetFile = new File(path, child);
		if (determineIfTheFileCanBeUploaded(attach)) {
			/* 是否存在文件路径 */
			if (!targetFile.exists()) {
				/* 创建路径文件夹及子文件夹 */
				targetFile.mkdirs();
			}
			try {
				attach.transferTo(targetFile);
				saveAddress = path + File.separator + child;
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		return false;
	}
	
	/**
	 * 上传文件名： 时间戳+随机数+后缀名
	 * 
	 * @param parent
	 *            保存路径 *
	 * @param attach
	 */
	public boolean uploadFiles(String path, MultipartFile attach) {
		/* 时间戳+随机数+后缀名 */
		String child = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + FilenameUtils.getExtension(attach.getOriginalFilename());
		return uploadFiles(path, child, attach);
	}
	
	/**
	 * 多文件上传<br>
	 * 上传文件名： 时间戳+随机数+后缀名
	 * 
	 * @param parent
	 *            保存路径 *
	 * @param attach
	 */
	public boolean uploadFiles(String path, MultipartFile[] attachs) {
		saveAddressArray = new ArrayList<String>();
		for (MultipartFile attach : attachs) {
			if (!uploadFiles(path, attach)) {
				saveAddressArray = null;
				return false;
			}
			saveAddressArray.add(saveAddress);
		}
		return true;
	}
	
	private List<String> saveAddressArray;
	
	/**
	 * 保存地址
	 */
	public List<String> getSaveAddressArray() {
		return saveAddressArray;
	}
	
	/**
	 * 上传和获取文件保存地址
	 * 
	 * @param parent
	 *            保存路径
	 * @param attach
	 */
	public String getTheFileName(String path, MultipartFile attach) {
		if (uploadFiles(path, attach))
			return saveAddress;
		else
			return null;
	}
	
}
