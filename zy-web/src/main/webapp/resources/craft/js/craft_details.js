$(function () {
    function resizeRender(){
       $('.content').css('min-height', Math.max($(window).height() - 90 - 40, $('.menu').height()));
    }
    resizeRender();
    
    var $sortsList = $('.c-sorts-li');
    $sortsList.hover(function () {
        $(this).addClass('hover');
    }, function () {
        $(this).removeClass('hover');
    });
    $sortsList.on('click',function(){
        window.open('/zy/craft/details');
    });
});