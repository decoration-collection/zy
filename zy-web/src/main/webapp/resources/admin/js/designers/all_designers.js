$(function(){
	$('#all_designers').DataTable({
		"paging": true,
	    "lengthChange": false,
	    "searching": false,
	    "ordering": false,
	    "info": true,
	    "autoWidth": false
	});
	$('.j_designer_del').on('click', function () {
		var designer_id = $(this).data('id');
		ZY.Dialog.confirm('您确认要删除此项内容？', function(){
			ZY.post('/zy/admin/designers/del', {designer_id: designer_id}, function(res){
				if(res === false){
					return;
				}
				if(res.code == 0){
					ZY.tips('删除成功！', 'success', 1000);
					setTimeout(function () {
						location.href = '/zy/admin/designers/all';
					}, 1500);
				}else{
					ZY.showPostError(res.msg);
				}
			}, 'json');
		});
	});
});