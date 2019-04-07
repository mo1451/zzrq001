$.ajax({
    type: "get",
    url: "alarm/history/by/month/by/control",
    dataType: "json",
    success: function (data) {
        // 基于准备好的dom，初始化echarts实例
        let leftBomChart = echarts.init(document.getElementById('leftBom'));
        let legend = [];
        let series = [];
        let rows = data.rows[0];
        for(let key in rows) {
            legend.push(key);
            let seriesData = {};
            seriesData.name = key;
            seriesData.type = 'bar';
            seriesData.data = rows[key];
            series.push(seriesData);
        }
        // 指定图表的配置项和数据
        let leftBomOption = {
            title: {
                text: '月报警数'
            },
            tooltip: {},
            legend: {
                data:legend,
                top: '90%'
            },
            xAxis: {
                data: ["第一周", "第二周", "第三周", "第四周"]
            },
            yAxis: {},
            series: series
        };
        // 使用刚指定的配置项和数据显示图表。
        leftBomChart.setOption(leftBomOption);
    }
});





$.ajax({
    type: "get",
    url: "alarm/history/by/year/by/control",
    dataType: "json",
    success: function (data) {
        // 基于准备好的dom，初始化echarts实例
        let leftTopChart = echarts.init(document.getElementById('leftTop'));
        let legend = [];
        let series = [];
        let rows = data.rows[0];
        for(let key in rows) {
            legend.push(key);
            let seriesData = {};
            seriesData.name = key;
            seriesData.type = 'bar';
            seriesData.data = rows[key];
            series.push(seriesData);
        }
        // 指定图表的配置项和数据
        let leftTopOption = {
            title: {
                text: '年报警数'
            },
            tooltip: {},
            legend: {
                data: legend,
                top: '90%'
            },
            xAxis: {
                data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
            },
            yAxis: {},
            series: series
        };

        // 使用刚指定的配置项和数据显示图表。
        leftTopChart.setOption(leftTopOption);

    }
});

$.ajax({
    type: "get",
    url: "alarm/history/by/year/by/gateway",
    dataType: "json",
    success: function (data) {
        let legend = [];
        let series = [];
        let rows = data.rows[0];
        for (let key in rows) {
            legend.push(key);
            let seriesData = {};
            seriesData.name = key;
            seriesData.type = 'bar';
            seriesData.data = rows[key];
            series.push(seriesData);
        }


// 基于准备好的dom，初始化echarts实例
        let rightTopChart = echarts.init(document.getElementById('rightTop'));

// 指定图表的配置项和数据
        let rightTopOption = {
            title: {
                text: '年报警数'
            },
            tooltip: {},
            legend: {
                data: legend,
                top: '90%'
            },
            xAxis: {
                data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
            },
            yAxis: {},
            series: series
        };

// 使用刚指定的配置项和数据显示图表。
        rightTopChart.setOption(rightTopOption);

    }
});