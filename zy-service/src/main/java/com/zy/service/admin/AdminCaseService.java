package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zy.dao.mapper.ZYCaseMapper;
import com.zy.dao.mapper.ZYDesignerMapper;
import com.zy.dao.model.ZYCase;
import com.zy.dao.model.ZYCaseExample;
import com.zy.dao.model.ZYDesigner;
import com.zy.dao.model.ZYDesignerExample;
import com.zy.service.admin.form.CaseForm;
import com.zy.service.admin.form.DesignerForm;

@Service
public class AdminCaseService {

	@Autowired
	private ZYDesignerMapper designerMapper;
	
	@Autowired
	private AdminImgService adminImgService;
	
	@Autowired
	private ZYCaseMapper caseMapper;
	
	@Autowired
	private AdminDesignerService designerService;

	@Autowired
	private AdminStyleService styleService;
	
	private static final String CASE_CATEGRY = "case";
	
	@Transactional
	public void addCase(CaseForm form) {
		ZYCase zyCase = new ZYCase();
//		zyCase.setCaseId(caseId);
		zyCase.setName(form.getName());
		zyCase.setDes(form.getDesc());
		zyCase.setAddress(form.getBuild());
		zyCase.setDesignerId(form.getDesigner_id());
		zyCase.setStyleId(form.getStyle_id());
		Date now = new Date();
		zyCase.setInsertTime(now);
		zyCase.setUpdateTime(now);
		
		caseMapper.insert(zyCase);
		
		int refrenceId = zyCase.getCaseId();
		String imgs = form.getAimgs();
		if(null != imgs && !"".equals(imgs)) {
			String[] imgArray = imgs.split(",");
			for(String img : imgArray) {
				if(null != img && !"".equals(img)) {
					adminImgService.insertSingleImg(refrenceId,CASE_CATEGRY, img);
				}
			}
		}
		
	}
	
	@Transactional
	public void editCase(CaseForm form) {
		int caseId = form.getCase_id();
		ZYCase zyCase = new ZYCase();
		zyCase.setCaseId(caseId);
		zyCase.setName(form.getName());
		zyCase.setDes(form.getDesc());
		zyCase.setAddress(form.getBuild());
		zyCase.setDesignerId(form.getDesigner_id());
		zyCase.setStyleId(form.getStyle_id());
		Date now = new Date();
		zyCase.setUpdateTime(now);
		caseMapper.updateByPrimaryKeySelective(zyCase);
		
		adminImgService.delImgByReferenceId(caseId,"case");
		
		int refrenceId = zyCase.getCaseId();
		String imgs = form.getAimgs();
		if(null != imgs && !"".equals(imgs)) {
			String[] imgArray = imgs.split(",");
			for(String img : imgArray) {
				if(null != img && !"".equals(img)) {
					adminImgService.insertSingleImg(refrenceId, CASE_CATEGRY, img);
				}
			}
		}
	}
	
	public List<CaseForm> findCaseByStyleId(int styleId) {
		ZYCaseExample exmaple = new ZYCaseExample();
		exmaple.createCriteria().andStyleIdEqualTo(styleId);
		exmaple.setOrderByClause(" case_id asc");
		List<ZYCase> list = caseMapper.selectByExample(exmaple);
		
		return changeCaseForm(list);
	}
	
	public List<CaseForm> findAllCase() {
		ZYCaseExample exmaple = new ZYCaseExample();
		exmaple.setOrderByClause(" case_id asc");
		List<ZYCase> list = caseMapper.selectByExample(exmaple);
		
		return changeCaseForm(list);
	}
	
	public CaseForm findCaseById(int caseId) {
		ZYCase zyCase = caseMapper.selectByPrimaryKey(caseId);
		
		CaseForm form = new CaseForm();
		form.setCase_id(zyCase.getCaseId());
		form.setName(zyCase.getName());
		form.setDesc(zyCase.getDes());
		form.setBuild(zyCase.getAddress());
		form.setStyle_id(zyCase.getStyleId());
		form.setDesigner_id(zyCase.getDesignerId());
		
		form.setDesignerForm(designerService.findDesignerById(zyCase.getDesignerId()));
		form.setStyleForm(styleService.findStyleById(zyCase.getStyleId()));
		form.getCaseImgs().addAll(adminImgService.findImgByReferenceId(zyCase.getCaseId(),CASE_CATEGRY));
		
		if(form.getCaseImgs().size() > 0) {
			form.setCase_cover(form.getCaseImgs().get(0));
		}

		return form;
	}
	
	private List<CaseForm> changeCaseForm(List<ZYCase> list) {
		List<CaseForm> result = new ArrayList<CaseForm>();
		for(ZYCase zyCase : list) {
			CaseForm form = new CaseForm();
			form.setCase_id(zyCase.getCaseId());
			form.setName(zyCase.getName());
			form.setDesc(zyCase.getDes());
			form.setBuild(zyCase.getAddress());
			form.setStyle_id(zyCase.getStyleId());
			form.setDesigner_id(zyCase.getDesignerId());
			
			form.setDesignerForm(designerService.findDesignerById(zyCase.getDesignerId()));
			form.setStyleForm(styleService.findStyleById(zyCase.getStyleId()));
			form.getCaseImgs().addAll(adminImgService.findImgByReferenceId(zyCase.getCaseId(),CASE_CATEGRY));
			
			if(form.getCaseImgs().size() > 0) {
				form.setCase_cover(form.getCaseImgs().get(0));
				List<String> imgs = form.getCaseImgs();
				StringBuffer strBuff = new StringBuffer();
				for(int i=0;i<imgs.size();i++) {
					strBuff.append(imgs.get(i));
					if(i < imgs.size() -1) {
						strBuff.append(",");
					}
				}
				form.setAimgs(strBuff.toString());
			}
			
			result.add(form);
		}
		return result;
	}
	
	@Transactional
	public void delCaseById(int caseId) {
		caseMapper.deleteByPrimaryKey(caseId);
		adminImgService.delImgByReferenceId(caseId,CASE_CATEGRY);
	}
	
}
