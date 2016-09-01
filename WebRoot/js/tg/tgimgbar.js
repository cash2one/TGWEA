(function ($) {
    $.ImgBar = function (arg) {
        var name = "你好";     //这个是私有变量，外部无法访问
        this.testFun = function () {     //加上了this，就是公有方法了，外部可以访问。
            alert(arg.title + "," + name);
        };
    };
})(jQuery);