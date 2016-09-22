/**
 * Created with JetBrains PhpStorm.
 * @Author: karl (luolinjia@iot.chinamobile.com)
 * @Date: 15-08-20
 * @Time: 11:15
 * @Desc: The tool regarding formatting the JSON for Rainbow or other features.
 */
(function(){
    /**
     * 判断数据类型
     * @param v
     * @returns {*}
     */
    var realTypeOf = function (v) {
        if (typeof(v) == "object") {
            if (v === null) return "null";
            if (v.constructor == ([]).constructor) return "array";
            if (v.constructor == (new Date).constructor) return "date";
            if (v.constructor == (new RegExp).constructor) return "regex";
            return "object";
        }
        return typeof(v);
    };
    /**
     * 通过返回JSON数据，进行格式化
     * @param {Object} oData
     * @param {String} sIndent
     * @returns {*}
     */
    var formatJSON = function (oData, sIndent) {
        if (!oData) {
            return '';
        }
        var sHTML,
            iCount;
        if (arguments.length < 2) {
            sIndent = "";
        }
        var sIndentStyle = "    ",
            sDataType = realTypeOf(oData);

        // open object
        if (sDataType === "array") {
            if (oData.length === 0) {
                return "[]";
            }
            sHTML = "[";
        } else {
            iCount = 0;
            $.each(oData, function () {
                iCount++;
            });
            if (iCount === 0) { // object is empty
                return "{}";
            }
            sHTML = "{";
        }
        // loop through items
        iCount = 0;
        $.each(oData, function (sKey, vValue) {
            if (iCount > 0) {
                sHTML += ",";
            }
            if (sDataType === "array") {
                sHTML += ("\n" + sIndent + sIndentStyle);
            } else {
                sHTML += ("\n" + sIndent + sIndentStyle + "\"" + s.escapeHTML(sKey) + "\"" + ": ");
            }

            // display relevant data type
            switch (realTypeOf(vValue)) {
                case "array":
                case "object": {
                    sHTML += formatJSON(vValue, (sIndent + sIndentStyle));
                }
                    break;
                case "boolean":
                case "number": {
                    sHTML += vValue.toString();
                }
                    break;
                case "null": {
                    sHTML += "null";
                }
                    break;
                case "string": {
                    sHTML += ("\"" + s.escapeHTML(vValue) + "\"");
                }
                    break;
                default: {
                    sHTML += ("TYPEOF: " + typeof(vValue));
                }
            }

            // loop
            iCount++;
        });

        // close object
        if (sDataType === "array") {
            sHTML += ("\n" + sIndent + "]");
        } else {
            sHTML += ("\n" + sIndent + "}");
        }
        // return
        return sHTML;
    };
    /**
     * 对日期进行格式化,
     * @param {Object} date
     * @returns {string} 2015-08-20 11:39:20
     */
    var formatDate = function (date) {
        var year = date.getFullYear(),
            month = date.getMonth() + 1,
            day = date.getDate(),
            hours = date.getHours() >= 10 ? date.getHours() : '0' + date.getHours(),
            mins = date.getMinutes() >= 10 ? date.getMinutes() : '0' + date.getMinutes(),
            secs = date.getSeconds() >= 10 ? date.getSeconds() : '0' + date.getSeconds();
        return year + '-' + month + '-' + day + '  ' + hours + ':' + mins + ':' + secs;
    };
    IOT.formatJSON = formatJSON;
    IOT.formatDate = formatDate;
})();