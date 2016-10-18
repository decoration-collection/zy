$(function(){

	ZY.initMultiUpload(8);

	var isEdit = $('#case_id').val() !== '';
	var postURL = isEdit ? '/zy/admin/case/a_edit' : '/zy/admin/case/a_add';
	var finishUpload = $('#works_show').data('finish-uploader');
	// 删除已上传图片,更新列表中的已上传图片列表字符串
	$('.delete-work').on('click',function(){
		var data = {
			rid: $('#case_id').val(),
			img_path: $(this).siblings('img').attr('src')
		};
		ZY.post('/zy/admin/single_del',data,function(res){
			console.log(res);
			finishUpload = res.data.works.join(',');
		});
	});
	$('.j_case_form').on('submit', function(e){
		e.preventDefault();
		var $form = $(this);
		var $submitButton = $form.find('.j_submit');
		if(ZY.button.isLoading($form) || !$form.isValid()){
			return;
		}
		ZY.button.addLoading($submitButton, isEdit?'保存中' :'添加中', 'loading');
		var data;

		isEdit ? data = $form.serialize() : data = {
			name: $('#name').val(),
			desc: $('#desc').val(),
			build: $('#build').val(),
			style_id: $('#style_id').val(),
			designer_id: $('#designer_id').val(),
			aimgs: $('#works_show').val() + finishUpload
		};
		ZY.post(postURL, data, function(res){
			ZY.button.removeLoading($submitButton, isEdit? '保存':'新增');
			if(res === false){
				return;
			}
			if(res.code == 0){
				ZY.tips(isEdit? '保存成功！':'新增成功！', 'success', 1000);
				setTimeout(function () {
					location.href = '/zy/admin/case/all';
				}, 1500);
			}else{
				ZY.showPostError(res.msg);
			}
		}, 'json');
	});

});