$(document).ready(function () {
    $("#numberDiv").hide();     //存放号码的div，界面初始化时设置div不可见
});

function order(doctorAccount, date, week, time, patient) {
    $("#numberDiv").show();     //请求查询号码时，设置div可见
    $.ajax({
        async: false,           //取消异步（即同步），异步会使下面的代码在接收结果之前运行
        type: "get",            //发送方式
        url: "/allOrderNumber",//发送的地址
        data: {                 //发送的数据
            "doctorAccount":doctorAccount,
            "date":date,
            "time":time
        },
        datatype: "json",       //接收的数据
        success: function (data) {
            $("#orderNum").empty();
            $("select[name = select]").append("<option name='' value=''>请选择</option>");
            $.each(data, function (i,number) {//解析json数据
                console.log("i:" + i + " name:" + number);
                var html ="<li class=\"box-child\">";//设置html样式
                html += "<div class=\"number number-hover\">";
                html += "<a onclick=\"areYouSure(" + doctorAccount + ",'" + date + "'," + time + "," + week + "," + number + "," + patient + ")\" >" +
                    "<label>" + number + "号</label></a>";
                html += "</div>";
                html += "</li>";
                $("#orderNum").append(html);
            });
        },
        error: function () {
            alert("请求失败。。。");
        }
    });
}

function areYouSure(doctorAccount, date, time, week, number, patient) {
    var t;
    if(time == 1)
        t = "上午";
    else
        t = "下午";

    layer.confirm("预约号码为：" + doctorAccount + " " + date + " " + t  + " " + number + "号", {
        btn: ['确认','取消'] //按钮
    }, function(){
        $(location).attr('href','/doOrder?doctorAccount=' + doctorAccount + '&date=' + date + '&time=' + time + '&week=' + week + '&number=' + number + '&patient=' + patient);
    }, function(){
        window.pener = null;
        window.close();
    });
}