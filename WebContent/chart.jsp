<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言报表</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="amcharts_3.14.4.free/amcharts/amcharts.js"
	type="text/javascript"></script>
<script src="amcharts_3.14.4.free/amcharts/serial.js"
	type="text/javascript"></script>
<script src="bootstrap/js/jquery.js"></script>
<script>
	// 注意,ajax的异步需要将请求函数包装成一个函数
	var chartData = null;
	// 同步请求数据
	function getData() {
		var ret = "";
		var msg = null;
		$.ajax({
			type : "GET",
			url : "/lyb/AjaxServlet?operator=title",
			async : false, // 同步
			dataType : "json",
			success : function(data) {
				msg = data;
			},
			error : function(xhr, error) {
				alert(error);
			}
		});
		return msg;
	}
	// 这个chart需要的是json**对象**
	chartData = getData();

	AmCharts.ready(function() {
		// SERIAL CHART
		chart = new AmCharts.AmSerialChart();
		chart.dataProvider = chartData;
		chart.categoryField = "name";
		chart.startDuration = 1;

		// AXES
		// category
		var categoryAxis = chart.categoryAxis;
		categoryAxis.labelRotation = 90;
		categoryAxis.gridPosition = "start";

		// value
		// in case you don't want to change default settings of value axis,
		// you don't need to create it, as one value axis is created automatically.

		// GRAPH
		var graph = new AmCharts.AmGraph();
		graph.valueField = "count";
		graph.balloonText = "[[category]]: <b>[[value]]</b>";
		graph.type = "column";
		graph.lineAlpha = 0;
		graph.fillAlphas = 0.8;
		chart.addGraph(graph);

		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.cursorAlpha = 0;
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonEnabled = false;
		chart.addChartCursor(chartCursor);

		chart.creditsPosition = "top-right";

		chart.write("chartdiv");
	});
	
	// 返回到上一个页面
	function goback(){
		window.history.back(-1); 
	}
</script>
</head>

<body>
	<h1 align="center">标题统计分析</h1>
	<div id="chartdiv" style="width: 80%; height: 400px; margin-left: 10%;"></div>
	<a class="btn btn-default" href="regist.jsp" role="button" style="margin-left: 45%;" onclick="goback()">返回</a>
</body>
</head>
</html>