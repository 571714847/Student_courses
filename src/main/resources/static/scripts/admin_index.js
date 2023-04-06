$(function () {
    $('#nav_dot>li').hover(function () {
        $(this).children('div').stop().slideToggle()
    })
})