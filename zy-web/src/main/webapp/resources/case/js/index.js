/**
 * Created by Karl on 2016/8/10.
 */
$(function () {
    function resizeRender(){
       $('.content').css('min-height', Math.max($(window).height() - 90 - 40, $('.menu').height()));
    }
    resizeRender();
    function getUrlParam(name){
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i'),
            r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return (r[2]);
        }else{
            return null;
        }
    }
    var thisId = getUrlParam('style_id'),
        $styleList = $('.j-style-class a');
        if( thisId ){ 
            $styleList.removeClass('active'); 
            for(var i = 0; i < $styleList.length; i++){
                var $thisStyle = $($styleList[i]);
                if(thisId == $thisStyle.data('style-id')){
                    $thisStyle.addClass('active');
                }
            }
        }
    var $topLis = $('.c-top-li');
    $topLis.hover(function () {
        $(this).addClass('hover');
    }, function () {
        $(this).removeClass('hover');
    });

    $topLis.on('click', function () {
        var thiz = $(this), 
            flag = thiz.data('type'), 
            caseObj = {
                build : thiz.data('build'),
                styleName : thiz.data('style-name'),
                designer : thiz.data('designer-name'),
                desc : thiz.data('desc'),
                caseImgs : thiz.data('aimgs').split(","),
            },
            dom = renderDom(caseObj);
        var dialog = new ZY.Dialog({
            title: '', //窗口标题的html，如果不设置则无标题
            content: dom,
            //窗口内容的html，必须是html格式不能是无格式纯文本，如果不设置则无内容
            beforeClose: null, //调用close方法时执行的callback，如果此callback返回false则会阻止窗口的关闭
            showClose: true,
            showFooter: false,
            className: 'dialog-box', //窗口最外层容器的类名
            cache: false, //是否缓存。若为false则close()的时候会remove掉对话框对应的dom元素
            width: '1040px' //窗口宽度，如不传递默认为40%
        });
        dialog.open();
    });
    function renderDom(obj) {
        var list = ['<div class="text-wrapper"><div>楼盘名称：'+obj.build+'<span class="style-label">'+obj.styleName+'<span></div><div>设计师：'+obj.designer+'</div><div>详细描述：'+obj.desc+'</div></div>'];
        var sum = 0;
        for (var i = 0, size = obj.caseImgs.length; i < size; i++) {
            var item = obj.caseImgs;
            sum += 1;
            list.push('<div class="case-img"><img src="' + item[i] + '"/></div>');
            if(sum === 8){break;}
        }
        return list.join('');
    }
    /*$('.icon-wechat').on('click', function () {
        var dialog = new ZY.Dialog({
            title: '', //窗口标题的html，如果不设置则无标题
            content: '<div><img src="/zy/resources/static/files/wechat.png" /></div>',
            //窗口内容的html，必须是html格式不能是无格式纯文本，如果不设置则无内容
            beforeClose: null, //调用close方法时执行的callback，如果此callback返回false则会阻止窗口的关闭
            showClose: true,
            showFooter: false, 
            className: '', //窗口最外层容器的类名
            cache: false, //是否缓存。若为false则close()的时候会remove掉对话框对应的dom元素
            width: '311px' //窗口宽度，如不传递默认为40%
        });
        dialog.open();
    });*/
});