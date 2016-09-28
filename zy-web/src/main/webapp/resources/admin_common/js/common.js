/**
 * Created by Karl on 2016/9/28.
 */
(function () {
    if (!window.ZY) {
        window.ZY = {};
    }
    ZY.post = function () {
        var len = 0;
        var callBack; //回调函数
        var args = [];
        while (arguments[len]) {
            if (typeof arguments[len] == 'function') { //找到了callback
                callBack = arguments[len++];
                args.push(function () {
                }); //必须第三个参数为function否则第四个参数(json)不会被识别
            } else {
                args.push(arguments[len++]);
            }
        }
        callBack = callBack || function () {}; //若没有回到函数，则默认为空
        $.post.apply($, args).done(function (res) {
            callBack.call(this, res);
        }).fail(function (res) {
            ZY.tips('请求失败，请稍后再试', 'warning', 3000);
            callBack.call(this, false);
        });
    };
    ZY.button = {
        /**
         * addLoading form提交的时候给按钮加上laoding图标，更改按钮文字为提交状态，给$button打上正在提交的标签
         * @param $button 提交按钮
         * @param buttonContent 提交按钮的innerHTML（不包含图标）
         * @param buttonIcon 提交按钮图标 如果不传此参数则没有提交按钮。 loading：菊花按钮(目前就只有菊花按钮)
         * */
        addLoading: function ($button, buttonContent, buttonIcon) {
            $button.data('isloading', true);

            buttonContent && ($button.html(buttonContent));

            if (buttonIcon) {
                var iconHtml = {
                    'loading': '<i class="icon-spin5 animate-spin"></i>'
                };
                if (iconHtml[buttonIcon]) {
                    $(iconHtml[buttonIcon]).prependTo($button);
                }
            }
        },

        /**
         * removeLoading form提交后取消laoding图标，更改按钮文字为默认状态，取消$button正在提交的标签
         * @param $button 提交按钮
         * @param buttonContent 提交按钮的innerHTML（不包含图标）
         * @param buttonIcon 提交按钮图标 如果不传此参数则没有提交按钮。 loading：菊花按钮(目前就只有菊花按钮)
         * */
        removeLoading: function ($button, buttonContent, buttonIcon) {
            $button.data('isloading', false);

            buttonContent && ($button.html(buttonContent));

            if (buttonIcon) {
                var iconHtml = {
                    'loading': '<i class="icon-spin5 animate-spin"></i>'
                };
                if (iconHtml[buttonIcon]) {
                    $(iconHtml[buttonIcon]).prependTo($button);
                }
            }
        },
        /**
         * isLoading 是否正在提交中
         * @param $button 提交的button
         * */
        isLoading: function ($button) {
            return $button.data('isloading');
        }
    };

    /**
     * 显示服务器报错，服务器返回的错误信息可以是字符串或者对象，如果是对象则包含了错误字段及其对应错误值。目前只显示第一个错误值，忽略其他信息
     * */
    ZY.showPostError = function (resultMessage, defaultMessage, $postForm, type, during) {
        resultMessage = resultMessage || '';
        defaultMessage = defaultMessage || '操作失败,请稍后再试';
        type = type || 'error';
        during = during || 2000;

        //如果服务器返回的resultMessage是对象，显示第一个属性对应的值
        if (typeof resultMessage == 'object') {
            for (var i in resultMessage) {
                ZY.tips(resultMessage[i], type, during);
                $postForm && $postForm.find('[name="' + i + '"]').focus();
                return;
            }
        }

        //15823505830

        //如果服务器返回的resultMessage是字符串，直接显示
        if (typeof resultMessage == 'string' && resultMessage != '') {
            defaultMessage = resultMessage;
        }

        ZY.tips(defaultMessage, type, during);

    };
})();
(function () {
    function Tips(options) {
        this.content = options.content;
        this.type = options.type;
        this.width = options.width;
        this._config = {
            iconFont: {
                'info': 'fa fa-info-circle',
                'error': 'fa fa-info-circle',
                'warning': 'fa fa-exclamation-triangle',
                'success': 'fa fa-check-circle',
                'welcome': 'fa fa-check-circle',
                'loading': 'fa fa-refresh fa-spin'
            },
            className: {
                'info': 'info',
                'error': 'alert',
                'warning': 'warning',
                'success': 'success',
                'welcome': 'success',
                'loading': 'loading'
            }
        };
    }

    Tips.prototype = {
        create: function () {
            var ctml = [];
            ctml = ['<div class="alert-box alert-box-pop ' + this._config.className[this.type] + '">'];
            ctml.push('<i class="' + this._config.iconFont[this.type] + '"></i>');
            ctml.push(this.content);
            ctml.push('</div>');

            var objHtml = $(ctml.join(''));
            objHtml.appendTo(document.body);
            return objHtml;
        },
        resetPosition: function (obj) {
            var width = obj.width();
            var height = obj.height();
            var scroll = $(window).height() / 2;
            obj.css({
                'margin-left': -width / 2 - 45 / 2,
                'top': -height / 2 + scroll + 15,
                position: 'fixed',
                left: '50%'
            });
            obj.animate({
                top: -height / 2 + scroll
            }, 400);
        },
        hideClose: function (obj) {
            obj.remove();
        }
    };
    //创建弹窗主体
    //外部可以扩展
    ZY.tips = function (content, type, timeout) {
        typeof timeout === 'number' || (timeout = 2000);
        if (/^\s*$/.test(content) || !content) return false;
        var tip = new Tips({content: content, type: type || "success", timeout: timeout});
        tip.hideClose($('.tisp-' + type));
        var $tip_box = tip.create();
        tip.resetPosition($tip_box);
        if (timeout) setTimeout(function () {
            tip.hideClose($tip_box);
        }, timeout);
        else {
            var $doc = $(document), onClick;
            $doc.click(onClick = function (e) {
                var tip_box = $tip_box.get(0), target = e.target;
                if (tip_box !== target && !$.contains(tip_box, target)) {
                    $doc.unbind('click', onClick);
                    tip.hideClose($tip_box);
                }
            });
        }
    };
})();
