package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.zy.dao.mapper.ZYCraftMapper;
import com.zy.dao.model.ZYCraft;
import com.zy.dao.model.ZYCraftExample;
import com.zy.service.admin.form.CraftForm;
import com.zy.service.admin.form.ImgForm;

@Service
public class AdminCraftService {

	@Autowired
	private ZYCraftMapper craftMapper;
	
	@Autowired
	private AdminImgService adminImgService;
	
	private static final String CRAFT_CATEGRY = "craft";
	
	private Gson gson = new Gson();
	
	@Transactional
	public void addCraft(CraftForm form) {
		ZYCraft craft = new ZYCraft();
//		craft.setCraftId(CraftId);
		craft.setName(form.getCraft_name());
		Date now = new Date();
		craft.setInsertTime(now);
		craft.setUpdateTime(now);
		craftMapper.insert(craft);
		
		int refrenceId = craft.getCraftId();
		
		String imgStr = form.getCraft_show();
		if(imgStr != null && !"".equals(imgStr)) {
			JSONArray array = JSONArray.fromObject(imgStr);
			 
			List<ImgForm> imgs = JSONArray.toList(array, new ImgForm(), new JsonConfig());
			for(ImgForm imgForm : imgs) {
				adminImgService.insertSingleImg(refrenceId, CRAFT_CATEGRY, imgForm);
			}
		}
		
		
	}
	
	@Transactional
	public void editCraft(CraftForm form) {
		ZYCraft craft = new ZYCraft();
		int craftId = form.getCraft_id();
		craft.setName(form.getCraft_name());
		Date now = new Date();
		craft.setUpdateTime(now);
		craftMapper.updateByPrimaryKey(craft);
		
		adminImgService.delImgByReferenceId(craftId,CRAFT_CATEGRY);
		
		String imgStr = form.getCraft_show();
		if(imgStr != null && !"".equals(imgStr)) {
			JSONArray array = JSONArray.fromObject(imgStr);
			 
			List<ImgForm> imgs = JSONArray.toList(array, new ImgForm(), new JsonConfig());
			for(ImgForm imgForm : imgs) {
				adminImgService.insertSingleImg(craftId, CRAFT_CATEGRY, imgForm);
			}
		}
		
	}
	
	public List<CraftForm> findAllCraft() {
		ZYCraftExample exmaple = new ZYCraftExample();
		exmaple.setOrderByClause(" craft_id asc");
		List<ZYCraft> list = craftMapper.selectByExample(exmaple);
		
		List<CraftForm> result = new ArrayList<CraftForm>();
		for(ZYCraft zyCraft : list) {
			CraftForm form = new CraftForm();
			form.setCraft_id(zyCraft.getCraftId());
			form.setCraft_name(zyCraft.getName());
			
			form.getShows().addAll(adminImgService.findImgByReferenceId(zyCraft.getCraftId(),CRAFT_CATEGRY));
			form.getImgs().addAll(adminImgService.findImgObjByReferenceId(zyCraft.getCraftId(),CRAFT_CATEGRY));
			
			result.add(form);
		}
		return result;
	}
	
	public CraftForm findCraftById(int craftId) {
		ZYCraft zyCraft = craftMapper.selectByPrimaryKey(craftId);
		
		CraftForm form = new CraftForm();
		form.setCraft_id(zyCraft.getCraftId());
		form.setCraft_name(zyCraft.getName());
		
		form.getShows().addAll(adminImgService.findImgByReferenceId(craftId,CRAFT_CATEGRY));
		form.getImgs().addAll(adminImgService.findImgObjByReferenceId(zyCraft.getCraftId(),CRAFT_CATEGRY));
		return form;
	}
	
	@Transactional
	public void delCraftById(int craftId) {
		craftMapper.deleteByPrimaryKey(craftId);
		adminImgService.delImgByReferenceId(craftId,CRAFT_CATEGRY);
	}
	
}
