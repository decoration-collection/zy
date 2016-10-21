$(function(){
	var isEdit = $('#craft_id').val() !== '';
	var postURL = isEdit ? '/zy/admin/crafts/a_edit' : '/zy/admin/crafts/a_add';
	var allImgObj = [],imgArrayAll = [],finishImgObj = [];
	//获取已经上传的图片信息
	$.ajax({
		type: "post",
	    url: "/zy/admin/crafts/getImgObj",
	    data: {craft_id: $('#craft_id').val()},
	    dataType: "json",
	    success: function(data){
	    	console.log(data);
	    	finishImgObj = data.data;
	    }
	});
	//删除已上传图片,更新列表中的已上传图片列表字符串
	$('.delete-work').on('click',function(){
		var thiz = $(this);
		var data = {
			rid: $('#craft_id').val(),
			img_path: thiz.siblings('img').attr('src')
		};
		ZY.post('/zy/admin/single_del',data,function(res){
			console.log(res);
			$(thiz).parent().remove();
			finishImgObj.splice(0,finishImgObj.length);
			// $('#craft_show').val(res.data.imgs.join(','));
			// allImgObj.push(???);
			var surplusImgObj = res.data.imglist;
			
			finishImgObj =surplusImgObj;
		});
	});
	ZY.initMultiUpload(100,function(imgArray,uploader,imgObj){
		console.log(imgObj);
		// sort(imgObj);
		for(var k = 0;k<imgObj.length;k++){
			allImgObj.push(imgObj[k]);
		}
		console.log(allImgObj);
	});
	var sortImg = function(imgObj){
		var imgArrayL = [],imgArrayM = [];
		var lengthL, lengthM,sum = 0,l = 0;
		imgObj = imgObj.concat(finishImgObj);
		if(imgObj.length < 4){
			for(var n = 0;n<imgObj.length;n++){
				imgArrayAll.push(imgObj[n]);
			}
			// $('#craft_show').val(imgArrayAll.join(','));
			return;
		}
		for(var i = 0;i<imgObj.length;i++){
			var item = imgObj[i];
			if(item.width < 351){
				imgArrayM.push(item);
			}else {
				imgArrayL.push(item);
			}
		}
		lengthL = imgArrayL.length;
		lengthM = imgArrayM.length;
		if(lengthM > lengthL){
			for(var m;m<lengthM;m++){
				sum++;
				if(sum > 3 && l < lengthL){
					imgArrayAll.push(imgArrayL[l]);
					l++;
					sum = 0;
				}
				imgArrayAll.push(imgArrayM[m]);
			}
		}else {
			for(var m = 0;m<lengthM;m++){
				sum++;
				if(sum > 3 && l < lengthL){
					imgArrayAll.push(imgArrayL[l]);
					l++;
					sum = 0;
				}
				imgArrayAll.push(imgArrayM[m]);
			}
			for(l;l<lengthL;l++){
				imgArrayAll.push(imgArrayL[l]);
			}
		}
		// $('#craft_show').val(imgArrayAll.join(','));
		console.log(imgArrayAll);
	}
	$('.j_craft_form').on('submit', function(e){
		e.preventDefault();
		sortImg(allImgObj);
		var $form = $(this);
		var $submitButton = $form.find('.j_submit');
		if(ZY.button.isLoading($form) || !$form.isValid()){
			return;
		}
		ZY.button.addLoading($submitButton, isEdit?'保存中' :'新增中', 'loading');
		var data;

		isEdit ? data = {
			craft_id: $('#craft_id').val(),
			craft_name: $('#craft_name').val(),
			craft_show: JSON.stringify(imgArrayAll)
		} : data = {
			craft_name: $('#craft_name').val(),
			craft_show: JSON.stringify(imgArrayAll)

		};
		console.log(data);
		ZY.post(postURL, data, function(res){
			ZY.button.removeLoading($submitButton, isEdit? '保存':'新增');
			if(res === false){
				return;
			}
			if(res.code == 0){
				ZY.tips(isEdit? '保存成功！':'新增成功！', 'success', 1000);
				setTimeout(function () {
					location.href = '/zy/admin/crafts/all';
				}, 1500);
			}else{
				ZY.showPostError(res.msg);
			}
		}, 'json');
	});
});