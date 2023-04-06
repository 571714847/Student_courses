/* 用户 */
$(function () {
    $('#user-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('用户信息')
    })
    $('#user-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('账号信息')
    })
    $('#user-a3').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加账号')
    })
})
/* 学生 */
$(function () {
    $('#student-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1-1').text('>')
        $('#p').html('<a th:href="@{/admin/getAllStudent}">学生信息</a>')
    })
    $('#student-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('账号信息')
    })
    $('#student-a3').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加学生')
    })
    $('#student-a4').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加账号')
    })
})
/* 教师 */
$(function () {
    $('#teacher-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('教师信息')
    })
    $('#teacher-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('账号信息')
    })
    $('#teacher-a3').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加教师')
    })
    $('#teacher-a4').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加账号')
    })
})
/* 课程 */
$(function () {
    $('#course-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1-1').text('>');
        $('#p1').html('<a href="" target="mains">课程信息</a>');
    })
    $('#course-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p2-1').text('>')
        $('#p2').html('<a href="" target="mains">添加课程</a>')
    })
})
/* 选课 */
$(function () {
    $('#course-selection-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('选课信息')
    })
    $('#course-selection-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p2').text('添加选课')
    })
})
/* 通知 */
$(function () {
    $('#intro-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('通知信息')
    })
    $('#intro-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1').text('添加通知')
    })
})
/* 级班 */
$(function () {
    $('#class-a1').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p1-1').text('>');
        $('#p1').html('<a href="" target="mains">级班信息</a>');
    })
    $('#class-a2').click(function(){
        console.log(
            document.getElementsByTagName('p')[0].innerText,$('p').text()
        )
        $('#p2-1').text('>')
        $('#p2').html('<a href="" target="mains">添加级班</a>')
    })
})