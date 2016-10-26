package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.mapper.ZYImgMapper;
import com.zy.dao.model.ZYImg;
import com.zy.dao.model.ZYImgExample;
import com.zy.service.admin.form.ImgForm;

@Service
public class AdminImgService {

	@Autowired
	private ZYImgMapper imgMapper;
	
	
	
	public List<ZYImg> findImg(int referenceId,String desc) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId).andDesEqualTo(desc);
		return imgMapper.selectByExample(example);
	}
	
	public void insertSingleImg(int referenceId,String desc,String path) {
		ZYImg img = new ZYImg();
		img.setPath(path);
		img.setReferenceId(referenceId);
		img.setDes(desc);
		Date now = new Date();
		img.setInsertTime(now);
		img.setUpdateTime(now);
		imgMapper.insert(img);
	}
	
	public void insertSingleImg(int referenceId,String desc,ImgForm imgForm) {
		ZYImg img = new ZYImg();
		img.setPath(imgForm.getUrl());
		img.setHeight(imgForm.getHeight());
		img.setWidth(imgForm.getWidth());
		img.setReferenceId(referenceId);
		img.setDes(desc);
		Date now = new Date();
		img.setInsertTime(now);
		img.setUpdateTime(now);
		imgMapper.insert(img);
	}
	
	public void delImgByReferenceId(int referenceId,String desc) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId).andDesEqualTo(desc);
		imgMapper.deleteByExample(example);
	}
	
	public void delImgByCondition(int referenceId,String img_path) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId).andPathEqualTo(img_path);
		imgMapper.deleteByExample(example);
	}
	
	public ZYImg findImgByCondition(int referenceId,String img_path) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId).andPathEqualTo(img_path);
		
		List<ZYImg> imgs = imgMapper.selectByExample(example);
		if(null == imgs || imgs.size() < 1) {
			return null;
		}
		return imgs.get(0);
	}
	
	public List<String> findImgByReferenceId(int referenceId,String desc) {
		List<ZYImg> imgList = findImg(referenceId,desc);
		List<String> pathList = new ArrayList<String>();
		if(null != imgList && imgList.size() > 0) {
			for(ZYImg img : imgList) {
				if(null != img.getPath() && !"".equals(img.getPath())) {
					pathList.add(img.getPath());
				}
			}
		}
		return pathList;
	}
	
	public List<ImgForm> findImgObjByReferenceId(int referenceId,String desc) {
		List<ZYImg> imgList = findImg(referenceId,desc);
		List<ImgForm> pathList = new ArrayList<ImgForm>();
		if(null != imgList && imgList.size() > 0) {
			for(ZYImg img : imgList) {
				if(null != img.getPath() && !"".equals(img.getPath())) {
					ImgForm temp = new ImgForm();
					temp.setHeight(img.getHeight());
					temp.setUrl(img.getPath());
					temp.setWidth(img.getWidth());
					pathList.add(temp);
				}
			}
		}
		return pathList;
	}
}
