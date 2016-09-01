package com.etaoguan.wea.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileOperation {
	private transient static Log logger = LogFactory
			.getLog(FileOperation.class);

	public static File openDeployLogFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			if (!file.isFile()) {
				return null;
			}
			return file;
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.error("create log file " + fileName + "error");
			return null;
		}
		return file;
	}

	public static void write(File file, String comment) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
			fw.write(new Date().toString() + "   " + comment + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use
									// File | Settings | File Templates.
		}
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}

	/**
	 * 
	 * usage:
	 * getFileStr(".\\trb\\src\\main\\java\\com\\cybernaut\\slim\\util\\test.jsp");
	 * SystemInfo.out.println(test.getFileStr());
	 * 
	 * note: different os use different separator.
	 * 
	 * @return if exception happens it will return null; otherwise return the
	 *         full file's content
	 * @throws Exception
	 */
	public static String getFileStr(String filePath) throws Exception {
		StringBuffer sb = new StringBuffer("");
		FileInputStream fInStream = null;
		DataInputStream in = null;
		try {
			fInStream = new FileInputStream(filePath);
			in = new DataInputStream(fInStream);
			byte[] buff = new byte[1024];
			while (in.available() != 0) {
				in.read(buff);
				sb.append(new String(buff));
				buff = new byte[1024];
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		} finally {
			if (in != null) {
				fInStream.close();
				in.close();
			}
		}
	}
	/**
	 * @通过随机数命名图片
	 * @param imagesName,destPath
	 * @return imagesName
	 */
	public static String produceFileName(String destPath,String imagesName){
		File dir = new File(destPath);
		if (!dir.exists())
			dir.mkdir();
		if(!imagesName.equals("")){
		int pos=0; //.的位置 
		long seed=0; //随机种子数 
		String ext=""; //存入文件扩展名 		
		pos=imagesName.lastIndexOf("."); //得到位置
		ext=imagesName.substring(pos); //得到扩展名 
		seed=new java.util.Date().getTime(); //取得系统当前时间
		Random rand=new Random(seed);//以时间为种子产生随机数作为文件名 
		imagesName=Long.toString(Math.abs(rand.nextInt()))+ext; //生成新的文件名 
		}
		String imageName = imagesName;
		return imageName;
	}
	/*public static boolean move(File file, String destPath, String newFileName) {
		File destFile = new File(destPath);
		if(!destFile.exists())
			destFile.mkdirs();
			
		// File (or directory) to be moved
//		File file = new File(srcFile);
		// Destination directory
		File dir = new File(destPath+File.separator+newFileName);
		// Move file to new directory
		boolean success = file.renameTo(new File(destPath, newFileName));
		file.delete();
		return success;
	}*/

	/**
	 * 
	 * @param filePathAndName
	 * @return
	 */
	public static String readFile(String filePathAndName) {
		String fileContent = "";
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(f), "UTF-8");
				BufferedReader reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					fileContent += line;
				}
				read.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	/**
	 * Copy a File The renameTo method does not allow action across NFS mounted
	 * filesystems this method is the workaround
	 * 
	 * @param fromFile
	 *            The existing File
	 * @param toFile
	 *            The new File
	 * @return <code>true</code> if and only if the renaming succeeded;
	 *         <code>false</code> otherwise
	 */
	public final static boolean copy(File fromFile, File toFile) {
		try {
			FileInputStream in = new FileInputStream(fromFile);
			FileOutputStream out = new FileOutputStream(toFile);
			BufferedInputStream inBuffer = new BufferedInputStream(in);
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);

			int theByte = 0;

			while ((theByte = inBuffer.read()) > -1) {
				outBuffer.write(theByte);
			}

			outBuffer.close();
			inBuffer.close();
			out.close();
			in.close();

			// cleanupif files are not the same length
			if (fromFile.length() != toFile.length()) {
				toFile.delete();

				return false;
			}

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Move a File The renameTo method does not allow action across NFS mounted
	 * filesystems this method is the workaround
	 * 
	 * @param fromFile
	 *            The existing File
	 * @param toFile
	 *            The new File
	 * @return <code>true</code> if and only if the renaming succeeded;
	 *         <code>false</code> otherwise
	 */
	public final static boolean move(File fromFile, String destPath, String newFileName) {
		File destFile = new File(destPath);
//		System.out.println(destFile.isFile());
		if (!destFile.exists())
			destFile.mkdirs();
		File toFile = new File(destFile, newFileName);
//		System.out.println(toFile.isDirectory());
//		System.out.println(toFile.isFile());
//		if(!toFile.exists()&&toFile.isFile()){
//			try {
//				toFile.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		if (fromFile.renameTo(toFile)) {
			return true;
		}
		// delete if copy was successful, otherwise move will fail
		if (copy(fromFile,toFile)) {
			return fromFile.delete();
		}
		return false;
	}
	
	public final static void rename(String srcPath, String destPath) {
		
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		srcFile.renameTo(destFile);
	}
	//图片压缩
	//图片压缩
	public static String cutImagestr(String srcPath, int width, int height)
	   throws IOException {
	  File srcFile = new File(srcPath);
	  BufferedImage image = ImageIO.read(srcFile);
	  int srcWidth = image.getWidth(null);
	  int srcHeight = image.getHeight(null);
	  int newWidth = 0, newHeight = 0;
	  int x = 0, y = 0;
	  double scale_w = (double) width / srcWidth;
	  double scale_h = (double) height / srcHeight;
	  //System.out.println("scale_w=" + scale_w + ",scale_h=" + scale_h);
	  // 按原比例缩放图片
	  if (scale_w < scale_h) {
	   newHeight = height;
	   newWidth = (int) (srcWidth * scale_h);
	   x = (newWidth - width) / 2;
	  } else {
	   newHeight = (int) (srcHeight * scale_w);
	   newWidth = width;
	   y = (newHeight - height) / 2;
	  }
	  BufferedImage newImage = new BufferedImage(newWidth, newHeight,
	    BufferedImage.TYPE_INT_RGB);
	  newImage.getGraphics().drawImage(
	    image
	      .getScaledInstance(newWidth, newHeight,
	        Image.SCALE_SMOOTH), 0, 0, null);
	  // 保存缩放后的图片
	  String fileSufix = srcFile.getName().substring(
	    srcFile.getName().lastIndexOf(".") + 1);
	  
	  String aa = srcFile.getName().substring(0,
			    srcFile.getName().lastIndexOf(".")) + "L." + fileSufix;
	  File destFile = new File(srcFile.getParent(), aa);
	  // ImageIO.write(newImage, fileSufix, destFile);
	  // 保存裁剪后的图片
	  //System.out.println("fileSufix====" + fileSufix);
	  //System.out.println("image=====" + srcPath + aa);
	  ImageIO.write(newImage.getSubimage(x, y, width, height), fileSufix,
	    destFile);
	  return aa;
	 }
	//图片压缩
	public static File  cutImage(File srcFile, int width, int height,String lastname)
	   throws IOException {
	  //File srcFile = new File(path);
	  String path=srcFile.getAbsolutePath();
	  String name=srcFile.getName();
	  int index=path.indexOf(name);
	  String newpath=path.substring(0,index);
	  File toFile = new File(newpath+"newImg."+lastname);
	  srcFile.renameTo(toFile);
	  copy(srcFile,toFile);
	  BufferedImage image = ImageIO.read(toFile);
	  int srcWidth = image.getWidth(null);
	  int srcHeight = image.getHeight(null);
	  int newWidth = 0, newHeight = 0;
	  int x = 0, y = 0;
	  double scale_w = (double) width / srcWidth;
	  double scale_h = (double) height / srcHeight;
	  //System.out.println("scale_w=" + scale_w + ",scale_h=" + scale_h);
	  // 按原比例缩放图片
	  if (scale_w < scale_h) {
	   newHeight = height;
	   newWidth = (int) (srcWidth * scale_h);
	   x = (newWidth - width) / 2;
	  } else {
	   newHeight = (int) (srcHeight * scale_w);
	   newWidth = width;
	   y = (newHeight - height) / 2;
	  }
	  BufferedImage newImage = new BufferedImage(newWidth, newHeight,
	    BufferedImage.TYPE_INT_RGB);
	  newImage.getGraphics().drawImage(
	    image
	      .getScaledInstance(newWidth, newHeight,
	        Image.SCALE_SMOOTH), 0, 0, null);
	  // 保存缩放后的图片
	  String fileSufix = toFile.getName().substring(
			  toFile.getName().lastIndexOf(".") + 1);
	  
	  String aa = toFile.getName().substring(0,
			  toFile.getName().lastIndexOf("."))+"."+fileSufix;
	  File destFile = new File(toFile.getParent(),aa);
	   ImageIO.write(newImage,fileSufix,destFile);
	  //保存裁剪后的图片
	    //System.out.println("fileSufix====" + fileSufix);
	    //System.out.println("image=====" + path + aa);
	    ImageIO.write(newImage.getSubimage(x, y, width, height), fileSufix,
	    destFile);
	  return destFile;
	 }
		
	public static File  cutImage(File srcFile, int width, int height,String lastname,String p)
	   throws IOException {
	  //File srcFile = new File(path);
	  String path=srcFile.getAbsolutePath();
	  String name=srcFile.getName();
	  int index=path.indexOf(name);
	  String newpath=path.substring(0,index);
	  File toFile = new File(newpath+"newImg."+lastname);
	  //srcFile.renameTo(toFile);
	  //copy(srcFile,toFile);
	  BufferedImage image = ImageIO.read(srcFile);
//	  int srcWidth = image.getWidth(null);
//	  int srcHeight = image.getHeight(null);
//	  int newWidth = 0, newHeight = 0;
//	  int x = 0, y = 0;
//	  double scale_w = (double) width / srcWidth;
//	  double scale_h = (double) height / srcHeight;
	  //System.out.println("scale_w=" + scale_w + ",scale_h=" + scale_h);
	  // 按原比例缩放图片
//	  if (scale_w < scale_h) {
//	   newHeight = height;
//	   newWidth = (int) (srcWidth * scale_h);
//	   x = (newWidth - width) / 2;
//	  } else {
//	   newHeight = (int) (srcHeight * scale_w);
//	   newWidth = width;
//	   y = (newHeight - height) / 2;
//	  }
	  BufferedImage newImage = new BufferedImage(width, height,
	    BufferedImage.TYPE_INT_RGB);
	  newImage.getGraphics().drawImage(
	    image
	      .getScaledInstance(width, height,
	        Image.SCALE_SMOOTH), 0, 0, null);
	  // 保存缩放后的图片
	  String fileSufix = toFile.getName().substring(
			  toFile.getName().lastIndexOf(".") + 1);
	  File destFile =new File(p+"."+fileSufix);
	   ImageIO.write(newImage,fileSufix,destFile);
	  //保存裁剪后的图片
	    //System.out.println("fileSufix====" + fileSufix);
	    //System.out.println("image=====" + path + aa);
//	    ImageIO.write(newImage.getSubimage(x, y, width, height), fileSufix,
//	    destFile);
	   ImageIO.write(newImage, fileSufix,
		    destFile);
	  return destFile;
	 }


}
