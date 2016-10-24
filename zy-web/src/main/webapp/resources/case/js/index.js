/**
 * Created by Karl on 2016/8/10.
 */
$(function () {
    function resizeRender(){
       $('.content').css('min-height', Math.max($(window).height() - 90 - 40, $('.menu').height()));
    }
    resizeRender();

    var imgs = {
        'fr': [
            '/zy/resources/static/files/case/topFrance.jpg',
            '/zy/resources/static/files/case/topFrance1.jpg',
            '/zy/resources/static/files/case/topFrance2.jpg',
            '/zy/resources/static/files/case/topFrance3.jpg',
            '/zy/resources/static/files/case/topFrance4.jpg'
        ],
        'am': [
            '/zy/resources/static/files/case/topAmerica.jpg',
            '/zy/resources/static/files/case/topAmerica2.jpg',
            '/zy/resources/static/files/case/topAmerica3.jpg',
            '/zy/resources/static/files/case/topAmerica4.jpg',
            '/zy/resources/static/files/case/topAmerica5.jpg',
            '/zy/resources/static/files/case/topAmerica6.jpg',
            '/zy/resources/static/files/case/topAmerica7.jpg',
            '/zy/resources/static/files/case/topAmerica8.jpg'
        ],
        'ch': [
            '/zy/resources/static/files/case/topChinese.jpg',
            '/zy/resources/static/files/case/topChinese2.jpg',
            '/zy/resources/static/files/case/topChinese3.jpg',
            '/zy/resources/static/files/case/topChinese4.jpg',
            '/zy/resources/static/files/case/topChinese5.jpg',
            '/zy/resources/static/files/case/topChinese6.jpg',
            '/zy/resources/static/files/case/topChinese7.jpg',
            '/zy/resources/static/files/case/topChinese8.jpg'
        ]
    };

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
        for (var i = 0, size = obj.caseImgs.length; i < size; i++) {
            var item = obj.caseImgs;
            list.push('<div class="case-img"><img src="' + item[i] + '"/></div>');
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