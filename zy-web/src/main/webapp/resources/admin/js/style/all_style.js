$(function(){
	$('#all_designers').DataTable({
		"paging": true,
	    "lengthChange": false,
	    "searching": false,
	    "ordering": false,
	    "info": true,
	    "autoWidth": false
	});

	$('.j_style_del').on('click', function () {
		var style_id = $(this).data('id');
		ZY.Dialog.confirm('您确认要删除此项内容？', function(){
			ZY.post('/zy/admin/style/del', {style_id: style_id}, function(res){
				if(res === false){
					return;
				}
				if(res.code == 0){
					ZY.tips('删除成功！', 'success', 1000);
					setTimeout(function () {
						location.href = '/zy/admin/style/all';
					}, 1500);
				}else{
					ZY.showPostError(res.msg);
				}
			}, 'json');
		}, function(){

		});
	});


});