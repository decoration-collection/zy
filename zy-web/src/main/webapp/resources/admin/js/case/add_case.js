$(function(){

	var isEdit = $('#case_id').val() !== '';
	var postURL = isEdit ? '/zy/admin/case/a_edit' : '/zy/admin/case/a_add';

    var initFunc = function () {
        var exist = $('.finish-works-list .show-item').length;
        isEdit ? $('.limit').html(8 - parseInt(exist)) : '';
        ZY.initMultiUpload(isEdit ? 8 - parseInt(exist) : 8, function (arr, uploader) {
            var listImg = [];
            for (var i = 0, size = arr.length; i < size; i++) {
                listImg.push('<div class="show-item delete-box"><img src="' + arr[i] + '"><span title="删除" class="fa fa-trash-o delete-work"></span></div>');
            }
            $('.finish-works-list').append(listImg.join(''));
            ZY.initFunc();
        });
    };

    ZY.initFunc = initFunc;
    ZY.initFunc();

	// 删除已上传图片,更新列表中的已上传图片列表字符串
	$('.delete-work').on('click',function(){
		var thiz = this;
		var data = {
			rid: $('#case_id').val(),
			img_path: $(this).siblings('img').attr('src')
		};
		ZY.post('/zy/admin/single_del',data,function(res){
			// console.log(res);
			$(thiz).parent().remove();
			$('#works_show').val(res.data.imgs.join(','));
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
			aimgs: $('#works_show').val()
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