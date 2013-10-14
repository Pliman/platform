/**
 * FileUtils.java 2011-4-16
 * 智域工作室
 */
package net.intellizone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * 文件处理实用类
 * 
 * @version 1.0 2011-4-16
 * @author Pliman Sun
 * @since utils 1.0
 */
public class FileUtils {

	private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

	/**
	 * 
	 * 删除文件或文件夹
	 * 
	 * @param filePath
	 *            待删除的文件名
	 * 
	 * @return 文件删除成功返回true,否则返回false
	 * 
	 */
	public static boolean delete(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			if (logger.isDebugEnabled()) {
				logger.debug("删除文件失败：" + filePath + "文件不存在");
			}
			return false;
		} else {
			if (file.isFile()) {
				return deleteFile(filePath);
			} else {
				return deleteDirectory(filePath);
			}
		}
	}

	/**
	 * 
	 * 删除文件
	 * 
	 * @param filePath
	 *            被删除文件的路径
	 * 
	 * @return 单个文件删除成功返回true,否则返回false
	 * 
	 */
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.delete()) {
			if (logger.isDebugEnabled()) {
				logger.debug("删除单个文件" + filePath + " 成功");
			}
			return true;
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("删除单个文件" + filePath + " 失败");
			}
			return false;
		}
	}

	/**
	 * 
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * 
	 * @return 目录删除成功返回true,否则返回false
	 * 
	 */
	public static boolean deleteDirectory(String dir) {
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			if (logger.isDebugEnabled()) {
				logger.debug("删除目录失败" + dir + " 目录不存在");
			}
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0, length = files.length; i < length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			if (logger.isDebugEnabled()) {
				logger.debug("删除目录失败");
			}
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			if (logger.isDebugEnabled()) {
				logger.debug("删除目录" + dir + " 成功");
			}
			return true;
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("删除目录" + dir + " 失败");
			}
			return false;
		}
	}

	/**
	 * 根据输入流，写入文件
	 * 
	 * @param is
	 *            输入流
	 * @param filePath
	 *            文件名称
	 * @return 保存的文件名称
	 */
	public static String writeFile(InputStream is, String filePath) {
		try {
			// 输入输出缓存
			byte[] date = new byte[8000];
			OutputStream os = new FileOutputStream(filePath);
			int read = is.read(date);
			// 写入文件
			while (read != -1) {
				os.write(date, 0, read);
				read = is.read(date);
			}
			// 关闭资源
			is.close();
			os.close();

			return filePath;
		} catch (IOException e) {
			logger.warn("写入文件 " + filePath + " 失败");
			return "";
		}
	}

	/**
	 * 根据文件路径，获取文件名称
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileNameByPath(String filePath) {
		File file = new File(filePath);
		return file.getName();
	}

	/**
	 * 确保文件路径的有效性，不存在则创建
	 * 
	 * @param filePath
	 *            文件字符串路径
	 */
	public static void ensurePath(String filePath) {
		File file = new File(filePath);
		ensurePath(file);
	}

	/**
	 * 确保文件路径的有效性，不存在则创建
	 * 
	 * @param file
	 *            文件
	 */
	public static void ensurePath(File file) {
		File parentFile = file.getParentFile();
		if (parentFile.exists() == false) {
			boolean madeDir = parentFile.mkdirs();
			if (madeDir) {
				logger.warn("创建路径 : " + file.getParent() + " 成功");
			} else {
				logger.warn("创建路径 : " + file.getParent() + " 失败");
			}
		}
	}

	/**
	 * 使用字节流拷贝文件
	 * 
	 * @param fromFilePath
	 *            来源文件
	 * @param toFilePath
	 *            目标文件
	 */
	public static void copyFile(String fromFilePath, String toFilePath) {
		try {
			FileInputStream fis = new FileInputStream(fromFilePath);

			File toFile = new File(toFilePath);
			ensurePath(toFile);

			FileOutputStream fos = new FileOutputStream(toFile);

			byte[] buffer = new byte[8192];
			while (fis.read(buffer) > 0) {
				fos.write(buffer);
			}

			if (logger.isDebugEnabled()) {
				logger.debug(String.format("拷贝 %s 为 %s", fromFilePath, toFilePath));
			}

			fis.close();
			fos.close();

			buffer = null;
		} catch (FileNotFoundException e) {
			logger.warn("拷贝文件失败，输入文件路径无效", e);
		} catch (IOException e) {
			logger.error("拷贝文件失败，读取文件错误", e);
		}
	}

	/**
	 * 获取文件名字符串的后缀名
	 * 
	 * @param fileName
	 *            文件名字符串
	 * @return 后缀名字符串
	 */
	public static String getFilePostfix(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
	}
	
	/**
	 * 获取不包括后缀的文件名
	 * 
	 * @param fileName
	 *            文件名全名
	 * @return 不包括后缀的文件名
	 */
	public static String getOnlyFileName(String fileName) {
		return fileName.substring(0,fileName.lastIndexOf("."));
	}

	/**
	 * 生成唯一文件名
	 * 
	 * @param postFix
	 *            后缀名
	 * @return 带后缀的文件名
	 */
	public static String generateUniqueFileName(String postFix) {
		return UUID.randomUUID() + "." + postFix;
	}
	
	/**
	 * 获取文件夹下面的文件，
	 * @param dir
	 * @return
	 */
	public static String[] getFolderFileStr(String dir){
		File file = new File(dir);
		
		return file.list();
	}

	public static void main(String[] args) {
		// String fileDir = "C:\\TEMP\\temp0";
		// FileUtils.delete(fileDir);

		//copyFile("D:\\log\\abbp.log", "D:\\log_archive\\abbp.error_log.archive.log");
		
		getFolderFileStr("C:\\ftp");
	}
}
