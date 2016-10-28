$(function(){
	var uploaderPicture = function(){
		var $list = $('#fileList'),
		        // 优化retina, 在retina下这个值是2
		        ratio = window.devicePixelRatio || 1,
		        // 缩略图大小
		        thumbnailWidth = 200 * ratio,
		        thumbnailHeight = 200 * ratio,
		        // Web Uploader实例
		        uploader;
		    // 初始化Web Uploader
		    uploader = WebUploader.create({
		        // 自动上传。
		        auto: true,
		        // swf文件路径
		        swf: '/zy/resources/static/admin_common/plugins/webuploader/Uploader.swf',
		        // 文件接收服务端。
		        server: '/zy/admin/upload',
		        // 选择文件的按钮。可选。
		        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		        pick: '#filePicker',
		        // 只允许选择文件，可选。
		        accept: {
		            title: 'Images',
		            extensions: 'gif,jpg,jpeg,bmp,png',
		            mimeTypes: 'image/*'
		        }
		    });

		    // 当有文件添加进来的时候
		    uploader.on( 'fileQueued', function( file ) {
		    	$('#fileList').empty();
		        var $img = $('<img>');

		        $list.append( $img );

		        // 创建缩略图
		        uploader.makeThumb( file, function( error, src ) {
		            if ( error ) {
		                $img.replaceWith('<span>不能预览</span>');
		                return;
		            }

		            $img.attr( 'src', src );
		        }, thumbnailWidth, thumbnailHeight );
		    });

		    // 文件上传过程中创建进度条实时显示。
		    uploader.on( 'uploadProgress', function( file, percentage ) {
		        var $li = $( '#'+file.id ),
		            $percent = $li.find('.progress span');

		        // 避免重复创建
		        if ( !$percent.length ) {
		            $percent = $('<p class="progress"><span></span></p>')
		                    .appendTo( $li )
		                    .find('span');
		        }

		        $percent.css( 'width', percentage * 100 + '%' );
		    });

		    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
		    uploader.on( 'uploadSuccess', function( file, response ) {
		        $( '#'+file.id ).addClass('upload-state-done');
				// console.log(file);
				// console.log(response);
				$('#img_cover').val(response.data.url);
		    });

		    // 文件上传失败，现实上传出错。
		    uploader.on( 'uploadError', function( file ) {
		        var $li = $( '#'+file.id ),
		            $error = $li.find('div.error');

		        // 避免重复创建
		        if ( !$error.length ) {
		            $error = $('<div class="error"></div>').appendTo( $li );
		        }

		        $error.text('上传失败');
		    });

		    // 完成上传完了，成功或者失败，先删除进度条。
		    uploader.on( 'uploadComplete', function( file ) {
		        $( '#'+file.id ).find('.progress').remove();
		    });
	};
	uploaderPicture();
	var isEdit = $('#style_id').val() === '';
	var postURL = isEdit ? '/zy/admin/style/a_add' : '/zy/admin/style/a_edit';
	$('.j_style_form').on('submit', function(e){
		e.preventDefault();
		var $form = $(this);
		var $submitButton = $form.find('.j_submit');
		if(ZY.button.isLoading($form) || !$form.isValid()){
			return;
		}
		ZY.button.addLoading($submitButton, isEdit? '添加中':'修改中', 'loading');
		var data;

		isEdit ? data = {
			name: $('#style_name').val(),
			desc: $('#style_desc').val(),
			img_path: $('#img_cover').val()
		} : data = $form.serialize();
		ZY.post(postURL, data, function(res){
			ZY.button.removeLoading($submitButton, isEdit? '新增':'编辑');
			if(res === false){
				return;
			}
			if(res.code == 0){
				ZY.tips(isEdit? '新增成功！':'编辑成功！', 'success', 1000);
				setTimeout(function () {
					location.href = '/zy/admin/style/all';
				}, 1500);
			}else{
				ZY.showPostError(res.msg);
			}
		}, 'json');
	});
});