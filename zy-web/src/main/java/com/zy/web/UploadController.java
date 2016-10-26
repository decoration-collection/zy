package com.zy.web;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zy.service.admin.form.ImgForm;
import com.zy.util.DateFormatUtil;
import com.zy.util.ResultMap;

/**
 * @ClassName: UploadController
 * @Description: 文件上传控制器
 * @author chenrui
 * @date 2016年9月20日 下午4:58:45
 */
@Controller
@RequestMapping("/admin")
public class UploadController {

	private static final String FILE_BASE_PATH = "http://112.74.219.224:8081/zy/";

	private static final Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	@RequestMapping("/upload")
	@ResponseBody
	public Object singleUpload(@RequestParam("file") CommonsMultipartFile[] files,
			HttpServletRequest request) {
		FileOutputStream os = null;
		InputStream inputStream = null;
		try {
			String ctxPath = request.getSession().getServletContext()
					.getRealPath("/");
			String filePath = "resources/files/"
					+ DateFormatUtil.dtSimpleFormat(new Date()) + "/";
			String fileBasePath = ctxPath + filePath;
			File file = new File(fileBasePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			StringBuffer resUrlBuffer = new StringBuffer();
			for (int i = 0; i < files.length; i++) {
				logger.info("fileName---------->"
						+ files[i].getOriginalFilename());
				if (!files[i].isEmpty()) {
					long pre = System.currentTimeMillis();
					String filename = System.currentTimeMillis() + "_"
							+ files[i].getOriginalFilename();
					// 拿到输出流，同时重命名上传的文件
					os = new FileOutputStream(fileBasePath+ filename);
					// 拿到上传文件的输入流
					inputStream = files[i].getInputStream();
					if(inputStream instanceof FileInputStream) {
						inputStream = (FileInputStream) files[i].getInputStream();
					} else {
						inputStream = (ByteArrayInputStream) files[i].getInputStream();
					}

					// 以写字节的方式写文件
					int b = 0;
					while ((b = inputStream.read()) != -1) {
						os.write(b);
					}
					os.flush();
					os.close();
					inputStream.close();
					long finaltime = System.currentTimeMillis();
					resUrlBuffer.append(FILE_BASE_PATH).append(filePath)
							.append(filename);
					if (i + 1 < files.length) {
						resUrlBuffer.append(",");
					}
					logger.info("耗时：" + (finaltime - pre) + "毫秒");
				}
			}
			Map<String, Object> urlMap = new HashMap<String, Object>();
			urlMap.put("url", resUrlBuffer.toString());

			return ResultMap.buildMap(0, "success", urlMap);
		} catch (Exception e) {
			logger.error("上传文件异常", e);
			return ResultMap.buildMap(500, "fail", null);
		} finally {
				if(os != null) {
					try {
						os.close();
					} catch (Exception e) {
						logger.error("关闭流异常",e);
					}
				}
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (Exception e) {
						logger.error("关闭流异常",e);
					}
				}
			
		}
	}

	@RequestMapping("/multi_upload")
	@ResponseBody
	public Object upload2(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		try {
			List<ImgForm> imgList = new ArrayList<ImgForm>();
			String ctxPath = request.getSession().getServletContext()
					.getRealPath("/");
			String filePath = "resources/files/"
					+ DateFormatUtil.dtSimpleFormat(new Date()) + "/";
			String fileBasePath = ctxPath + filePath;
			File fileTemp = new File(fileBasePath);
			if (!fileTemp.exists()) {
				fileTemp.mkdirs();
			}
			StringBuffer resUrlBuffer = new StringBuffer();

			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						// 取得当前上传文件的文件名称
						String myFileName = file.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (myFileName.trim() != "") {
							logger.info("fileName=" + myFileName);
							// 重命名上传后的文件名
							String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
							// 定义上传路径
							String path = fileBasePath + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);
							resUrlBuffer.append(FILE_BASE_PATH).append(filePath).append(fileName).append(",");
							
							BufferedImage bufferedImage = ImageIO.read(localFile);   
							int width = bufferedImage.getWidth();   
							int height = bufferedImage.getHeight();
							
							ImgForm imgForm = new ImgForm();
							imgForm.setUrl(FILE_BASE_PATH + filePath + fileName);
							imgForm.setHeight(height);
							imgForm.setWidth(width);
							
							imgList.add(imgForm);
						}
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				}

			}
			Map<String, Object> urlMap = new HashMap<String, Object>();
			int urlLength = resUrlBuffer.toString().length();
			urlMap.put("url", resUrlBuffer.toString().substring(0, urlLength - 1));
			urlMap.put("imglist", imgList);
			logger.info("urlMap=" + urlMap);
			return ResultMap.buildMap(0, "success", urlMap);
		} catch (Exception e) {
			logger.error("上传文件异常", e);
			return ResultMap.buildMap(500, "fail", null);
		} 
	}

	@RequestMapping("/toUpload")
	public String toUpload() {

		return "/upload";
	}

}
