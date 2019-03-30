// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    let o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

let zoomLevel = 14;

function markDetail(data) {
    //   console.log(data);
    debugger;
    console.log(this);
    if (this.alarmProcessingStatus === 1) {
        let alarmDate = new Date(this.alarmDate);

        layer.alert("报警器：" + this.sensorNumber + ",于" + alarmDate.Format("yyyy-MM-dd hh:mm:ss") + "开始报警", {
            skin: 'layui-layer-molv' //样式类名
            ,closeBtn: 0
        });

     //   alert("报警器：" + this.sensorNumber + ",于" + alarmDate.Format("yyyy-MM-dd hh:mm:ss") + "开始报警");
    }

}

let icon_r = new AMap.Icon({
    size: new AMap.Size(30, 20),    // 图标尺寸
    image: 'img/mark_r.png',  // Icon的图像
    //    imageOffset: new AMap.Pixel(0, -60),  // 图像相对展示区域的偏移量，适于雪碧图等
    imageSize: new AMap.Size(15, 20)   // 根据所设置的大小拉伸或压缩图片
});

let icon_b = new AMap.Icon({
    size: new AMap.Size(30, 20),    // 图标尺寸
    image: 'img/mark_b.png',  // Icon的图像
    //     imageOffset: new AMap.Pixel(0, -60),  // 图像相对展示区域的偏移量，适于雪碧图等
    imageSize: new AMap.Size(15, 20)   // 根据所设置的大小拉伸或压缩图片
});


window.onload = function () {

    let map = new AMap.Map('container', {
        zoom: zoomLevel,
        center: [119.9358300000, 32.1560600000]
    });


    $.ajax({
        type: "Post",
        url: "alarm/detail/query",
        dataType: "json",
        success: function (data) {
          //  debugger;
            for (let i = 0; i < data.rows.length; i++) {
                let sensorNumber = data.rows[i].sensorNumber;
                let longitude = data.rows[i].longitude;
                let latitude = data.rows[i].latitude;
                let alarmProcessingStatus = data.rows[i].alarmProcessingStatus;
                let marker;


                if (alarmProcessingStatus === 1) {
                    // 创建一个 Marker 实例：
                    marker = new AMap.Marker({
                        position: new AMap.LngLat(longitude, latitude),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                        title: sensorNumber,
                        label: '1',
                        //      content:'1',
                        //     offset: new AMap.Pixel(-30, -30),
                        icon: icon_r, // 添加 Icon 图标 URL
                        /* iconStyle: {

                             src: '//webapi.amap.com/theme/v1.3/markers/b/mark_b.png',
                             style: {
                                 width: '20px',
                                 height: '30px'
                             }
                         },*/
                        style: {
                            width: '5px',
                            height: '10px'
                        },
                        zoom: zoomLevel
                    });
                } else {
                    marker = new AMap.Marker({
                        position: new AMap.LngLat(longitude, latitude),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                        title: sensorNumber,
                        label: '1',
                        offset: new AMap.Pixel(-30, -30),
                        icon: icon_b, // 添加 Icon 图标 URL
                        /* iconStyle: {

                             src: '//webapi.amap.com/theme/v1.3/markers/b/mark_b.png',
                             style: {
                                 width: '20px',
                                 height: '30px'
                             }
                         },*/
                        style: {
                            width: '5px',
                            height: '10px'
                        },
                        zoom: zoomLevel
                    });
                }

                marker.on('click', markDetail, data.rows[i]);
                // 将创建的点标记添加到已有的地图实例：
                map.add(marker);
            }

        }
    });


    //   map.remove(marker);
    AMap.plugin('AMap.ElasticMarker', function () {//异步加载插件
        /*let marker = new AMap.Marker({
            position: new AMap.LngLat(118.9334800000, 32.1560600000),
            offset: new AMap.Pixel(-10, -10),
            icon: 'img/redMarker.png', // 添加 Icon 图标 URL
            title: '家'
        });
        map.add(marker);*/


    });



}
