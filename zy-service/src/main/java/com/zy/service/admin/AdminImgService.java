package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.mapper.ZYImgMapper;
import com.zy.dao.model.ZYImg;
import com.zy.dao.model.ZYImgExample;

@Service
public class AdminImgService {

	@Autowired
	private ZYImgMapper imgMapper;
	
	public List<ZYImg> findImg(int referenceId) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId);
		return imgMapper.selectByExample(example);
	}
	
	public void insertSingleImg(int referenceId,String desc,String path) {
		ZYImg img = new ZYImg();
		img.setPath(path);
		img.setReferenceId(referenceId);
		Date now = new Date();
		img.setInsertTime(now);
		img.setUpdateTime(now);
		imgMapper.insert(img);
	}
	
	public void delImgByReferenceId(int referenceId) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId);
		imgMapper.deleteByExample(example);
	}
	
	public void delImgByCondition(int referenceId,String img_path) {
		ZYImgExample example = new ZYImgExample();
		example.createCriteria().andReferenceIdEqualTo(referenceId).andPathEqualTo(img_path);
		imgMapper.deleteByExample(example);
	}
	
	public List<String> findImgByReferenceId(int referenceId) {
		List<ZYImg> imgList = findImg(referenceId);
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
}
