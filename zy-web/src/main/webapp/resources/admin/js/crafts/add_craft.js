$(function(){
	var isEdit = $('#craft_id').val() !== '';
	var postURL = isEdit ? '/zy/admin/crafts/a_edit' : '/zy/admin/crafts/a_add';
	var allImgObj = [];
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
			$('#craft_show').val(res.data.imgs.join(','));
			// allImgObj.push(???);
		});
	});
	ZY.initMultiUpload(100,function(imgArray,uploader,imgObj){
		// console.log(res);
		// sort(imgObj);
		allImgObj.push(imgObj);
	});
	function sort(imgObj){
		var imgArrayL = [],imgArrayM = [],imgArrayAll = [];
		var lengthL, lengthM,sum = 0,l = 0;
		// if(isEdit){imgObj.push(????)}
		if(imgObj.length < 4){
			for(var n;n<imgObj.length;n++){
				imgArrayAll.push(imgObj[n].url);
			}
			$('#craft_show').val(imgArrayAll.join(','));
			return;
		}
		for(var i;i<imgObj.length;i++){
			var item = imgObj[i];
			if(item.size === 'm'){
				imgArrayM.push(item.url);
			}else {
				imgArrayL.push(item.url);
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
			for(var m;m<lengthM;m++){
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
		$('#craft_show').val(imgArrayAll.join(','));
	}
	// sort(allImgObj);
	$('.j_craft_form').on('submit', function(e){
		e.preventDefault();
		var $form = $(this);
		var $submitButton = $form.find('.j_submit');
		if(ZY.button.isLoading($form) || !$form.isValid()){
			return;
		}
		ZY.button.addLoading($submitButton, isEdit?'保存中' :'新增中', 'loading');
		var data;

		isEdit ? data = $form.serialize() : data = {
			craft_name: $('#craft_name').val(),
			craft_show: $('#craft_show').val()
		};
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