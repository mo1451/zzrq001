


// 基于准备好的dom，初始化echarts实例
let leftTopChart = echarts.init(document.getElementById('leftTop'));

// 指定图表的配置项和数据
let leftTopOption = {
    title: {
        text: '年报警数'
    },
    tooltip: {},
    legend: {
        data: ['一号探头', '二号探头', '三号探头'],
        top: '90%'
    },
    xAxis: {
        data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
    },
    yAxis: {},
    series: [
        {
            name: '一号探头',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20, 5, 20, 36, 10, 10, 20]
        },
        {
            name: '二号探头',
            type: 'bar',
            data: [10, 15, 13, 15, 23, 16, 4, 12, 35, 12, 32, 45]
        },
        {
            name: '三号探头',
            type: 'bar',
            data: [6, 7, 4, 9, 12, 15, 14, 13, 8, 21, 23, 12]
        }]
};

// 使用刚指定的配置项和数据显示图表。
leftTopChart.setOption(leftTopOption);


// 基于准备好的dom，初始化echarts实例
let leftBomChart = echarts.init(document.getElementById('leftBom'));

// 指定图表的配置项和数据
let leftBomOption = {
    title: {
        text: '月报警数'
    },
    tooltip: {},
    legend: {
        data: ['一号探头', '二号探头', '三号探头'],
        top: '90%'
    },
    xAxis: {
        data: ["第一周", "第二周", "第三周", "第四周"]
    },
    yAxis: {},
    series: [
        {
            name: '一号探头',
            type: 'bar',
            data: [5, 20, 36, 10]
        },
        {
            name: '二号探头',
            type: 'bar',
            data: [10, 6, 14, 20]
        },
        {
            name: '三号探头',
            type: 'bar',
            data: [12, 16, 4, 27]
        }]
};

// 使用刚指定的配置项和数据显示图表。
leftBomChart.setOption(leftBomOption);



// 基于准备好的dom，初始化echarts实例
let rightTopChart = echarts.init(document.getElementById('rightTop'));

// 指定图表的配置项和数据
let rightTopOption = {
    title: {
        text: '年报警数'
    },
    tooltip: {},
    legend: {
        data: ['1号楼', '2号楼', '3号楼'],
        top: '90%'
    },
    xAxis: {
        data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
    },
    yAxis: {},
    series: [
        {
            name: '1号楼',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20, 5, 20, 36, 10, 10, 20]
        },
        {
            name: '2号楼',
            type: 'bar',
            data: [10, 15, 13, 15, 23, 16, 4, 12, 35, 12, 32, 45]
        },
        {
            name: '3号楼',
            type: 'bar',
            data: [6, 7, 4, 9, 12, 15, 14, 13, 8, 21, 23, 12]
        }]
};

// 使用刚指定的配置项和数据显示图表。
rightTopChart.setOption(rightTopOption);