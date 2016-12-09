$(".tab a").click(function() {
    $(".tabcontent .tabitem").eq($(this).index()).show().siblings().hide();
    $(this).addClass("on").siblings().removeClass("on");
})