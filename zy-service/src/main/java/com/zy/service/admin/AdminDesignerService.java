package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zy.dao.mapper.ZYDesignerMapper;
import com.zy.dao.model.ZYDesigner;
import com.zy.dao.model.ZYDesignerExample;
import com.zy.dao.model.ZYImg;
import com.zy.service.admin.form.DesignerForm;

@Service
public class AdminDesignerService {

	@Autowired
	private ZYDesignerMapper designerMapper;
	
	@Autowired
	private AdminImgService adminImgService;
	
	@Transactional
	public void addDesigner(DesignerForm form) {
		ZYDesigner designer = new ZYDesigner();
		designer.setConcept(form.getDesign_concept());
//		designer.setDesignerId(designerId);
		designer.setHonor(form.getHonor());
		designer.setName(form.getName());
		designer.setPhotoPath(form.getDesigner_img());
		designer.setWorks(form.getWorks());
		designer.setWorktime(form.getWorking_time());
		Date now = new Date();
		designer.setInsertTime(now);
		designer.setUpdateTime(now);
		designerMapper.insert(designer);
		
		int refrenceId = designer.getDesignerId();
		String workShows = form.getWorks_show();
		if(null != workShows && !"".equals(workShows)) {
			String[] workShowArray = workShows.split(",");
			for(String work_show : workShowArray) {
				adminImgService.insertSingleImg(refrenceId, "desinger", work_show);
			}
		}
		
	}
	
	@Transactional
	public void editDesigner(DesignerForm form) {
		ZYDesigner designer = new ZYDesigner();
		int designerId = form.getDesigner_id();
		designer.setConcept(form.getDesign_concept());
		designer.setDesignerId(form.getDesigner_id());
		designer.setHonor(form.getHonor());
		designer.setName(form.getName());
		designer.setPhotoPath(form.getDesigner_img());
		designer.setWorks(form.getWorks());
		designer.setWorktime(form.getWorking_time());
		Date now = new Date();
		designer.setUpdateTime(now);
		designerMapper.updateByPrimaryKey(designer);
		
		adminImgService.delImgByReferenceId(designerId);
		
		String workShows = form.getWorks_show();
		if(null != workShows && !"".equals(workShows)) {
			String[] workShowArray = workShows.split(",");
			for(String work_show : workShowArray) {
				adminImgService.insertSingleImg(designerId, "desinger", work_show);
			}
		}
		
		
	}
	
	public List<DesignerForm> findAllDesigner() {
		ZYDesignerExample exmaple = new ZYDesignerExample();
		exmaple.setOrderByClause(" designer_id asc");
		List<ZYDesigner> list = designerMapper.selectByExample(exmaple);
		
		List<DesignerForm> result = new ArrayList<DesignerForm>();
		for(ZYDesigner zyDesigner : list) {
			DesignerForm form = new DesignerForm();
			form.setDesigner_id(zyDesigner.getDesignerId());
			form.setDesign_concept(zyDesigner.getConcept());
			form.setDesigner_img(zyDesigner.getPhotoPath());
			form.setHonor(zyDesigner.getHonor());
			form.setName(zyDesigner.getName());
			form.setWorking_time(zyDesigner.getWorktime());
			form.setWorks(zyDesigner.getWorks());
			
			List<ZYImg> imgList = adminImgService.findImgByReferenceId(zyDesigner.getDesignerId());
			if(null != imgList && imgList.size() > 0) {
				for(ZYImg img : imgList) {
					form.getShows().add(img.getPath());
				}
			}
			
			result.add(form);
		}
		return result;
	}
	
	public DesignerForm findDesignerById(int designerId) {
		ZYDesigner zyDesigner =  designerMapper.selectByPrimaryKey(designerId);
		
		DesignerForm form = new DesignerForm();
		form.setDesigner_id(zyDesigner.getDesignerId());
		form.setDesign_concept(zyDesigner.getConcept());
		form.setDesigner_img(zyDesigner.getPhotoPath());
		form.setHonor(zyDesigner.getHonor());
		form.setName(zyDesigner.getName());
		form.setWorking_time(zyDesigner.getWorktime());
		form.setWorks(zyDesigner.getWorks());
		
		List<ZYImg> imgList = adminImgService.findImgByReferenceId(designerId);
		if(null != imgList && imgList.size() > 0) {
			for(ZYImg img : imgList) {
				form.getShows().add(img.getPath());
			}
		}
		return form;
	}
	
	@Transactional
	public void delDesignerById(int designerId) {
		designerMapper.deleteByPrimaryKey(designerId);
		adminImgService.delImgByReferenceId(designerId);
	}
	
}
