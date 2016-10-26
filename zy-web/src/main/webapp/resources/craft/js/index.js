/**
 * Created by Zhang on 2016/10/25
 */
$(function () {
    var allClass = ['<label>工艺标准分类：</label><a href="/zy/craft/index" class="j_getall">全部工艺</a>'];
    var allImg = [];
    var list = JSON.parse($('#craftList').text());
    console.log(list);
    function layout(list,id){
            allClass.splice(1,allImg.length);//清空图片数组
            allImg.splice(0,allImg.length);//清空图片数组
        for(var i=0;i<list.length;i++){
            var item = list[i];
            
            if (item.craft_id === id) {
                allClass.push('<a href="javascript:;" data-craft-id="'+item.craft_id+'" class="active">'+item.craft_name+'</a>');
            } else {
                allClass.push('<a href="javascript:;" data-craft-id="'+item.craft_id+'">'+item.craft_name+'</a>');
            }

            if(item.craft_id === id){
                for(var k=0;k<item.imgs.length;k++){
                    var imgItem = item.imgs[k];
                    (351 > Number(imgItem.width)) ? allImg.push('<div class="img-wrapper parent-3"><img src="'+imgItem.url+'" alt="" title=""/><p>'+item.craft_name+'</p></div>') : allImg.push('<div class="img-wrapper parent-7"><img src="'+imgItem.url+'" alt="" title=""/><p>'+item.craft_name+'</p></div>');
                }
            }else if (!id){
                for(var k=0;k<item.imgs.length;k++){
                    var imgItem = item.imgs[k];
                    (351 > Number(imgItem.width)) ? allImg.push('<div class="img-wrapper parent-3"><img src="'+imgItem.url+'" alt="" title=""/><p>'+item.craft_name+'</p></div>') : allImg.push('<div class="img-wrapper parent-7"><img src="'+imgItem.url+'" alt="" title=""/><p>'+item.craft_name+'</p></div>');
                }
            allImg.push('<br/>');
            }
            
        }
        $('.j-craft-class').html(allClass.join(""));
        $('.j_list').html(allImg.join(""));
    }
    layout(list,null);
    $('.j_getall').addClass('active');

    var bindEvent = function () {
        var $classList = $('.j-craft-class a');
        $classList.off('click').on('click',function(e){
            var thiz = $(this),craftId = thiz.data('craft-id');
            layout(list,craftId);
            bindEvent();
        });
    };

    bindEvent();
});