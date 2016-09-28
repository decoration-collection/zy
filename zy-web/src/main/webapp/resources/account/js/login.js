/**
 * Login JS
 * @module Login
 * @author Karl Luo
 * @Date 2016-09-27
 */
$(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' // optional
    });
    $('.j_login_form').on('submit', function(e){
        e.preventDefault();
        var $form = $(this);
        var $submitButton = $form.find('.j_submit');
        if(ZY.button.isLoading($form) || !$form.isValid()){
            return;
        }
        ZY.button.addLoading($submitButton, '登录中', 'loading');
        ZY.post('/zy/admin/signin', $form.serialize(), function(res){
            ZY.button.removeLoading($submitButton, '登&nbsp;&nbsp;录');
            if(res === false){
                return;
            }
            if(res.code == 0){
                location.href = '/zy/admin';
            }else{
                ZY.showPostError(res.msg);
            }
        }, 'json');
    });
});