/**
 * Created by Zhang on 2016/8/13.
 */
$(function () {
    function resizeRender(){
       $('.content-wrapper').css('min-height', Math.max($(window).height() - 90 - 40, $('.menu').height()));
    }
    resizeRender();
    var $list = $('.j-designer-li');
    $list.on('click',function(){
        var thiz = $(this),
            designerObj = {
                name : thiz.data('name'),
                designerImg : thiz.data('designer-img'),
                workingTime : thiz.data('working-time'),
                designConcept : thiz.data('design-concept'),
                honor : thiz.data('honor'),
                works : thiz.data('works'),
                shows : thiz.data('shows').split(",")
            };
        dom = renderDom(designerObj);
        var dialog = new ZY.Dialog({
            title: '', //窗口标题的html，如果不设置则无标题
            content: dom,
            //窗口内容的html，必须是html格式不能是无格式纯文本，如果不设置则无内容
            beforeClose: null, //调用close方法时执行的callback，如果此callback返回false则会阻止窗口的关闭
            showClose: true,
            showFooter: false,
            className: 'dialog-wrapper', //窗口最外层容器的类名
            cache: true, //是否缓存。若为false则close()的时候会remove掉对话框对应的dom元素
            width: '1185px' //窗口宽度，如不传递默认为40%
        });
        dialog.open();
    });
    function renderDom(obj) {
        var list = ['<div class="designer-detail"><div class="designer-img"><img src="'+obj.designerImg+'"></div><div class="designer-intro"><h3>'+obj.name+'</h3><p>从业时间：'+obj.workingTime+'</p><p>设计理念：'+obj.designConcept+'</p><p>擅长风格：欧式、现代、地中海、美式、等…</p><p>获得荣誉：'+obj.honor+'</p><p>代表作品：'+obj.works+'</p><div class="works">'];
        for (var i = 0, size = obj.shows.length; i < size; i++) {
            var item = obj.shows;
            list.push('<div class="works-showr"><img src="' + item[i]+ '"/></div>');
        }
        list.push('</div></div></div>');
        return list.join('');
    }
});