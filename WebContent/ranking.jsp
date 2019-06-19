<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>
<%@ page import="javaCode.ModelControlDB" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>랭킹보기</title>

<!-- Custom fonts for this template-->
<link href="template1/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="template1/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="template1/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<%
	ModelControlDB db = new ModelControlDB();
	String[] name = new String[3];
	int[] count = new int[3];
	name = db.seeRank();
	count = db.seeRankcnt();



%>
	<div id="content-wrapper">
		<div class="container-fluid">
			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-chart-area"></i> Area Chart Example
				</div>
				<div class="card-body">
					<canvas id="myAreaChart" width="100%" height="30"></canvas>
				</div>
				<div class="card-footer small text-muted">추천 많이 된 휴대폰 상위 3개</div>
			</div>

			<div class="row">
				<div class="col-lg-8">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-chart-bar"></i> 막대 그래프
						</div>
						<div class="card-body">
							<canvas id="myBarChart" width="100%" height="50"></canvas>
						</div>
						<div class="card-footer small text-muted">추천 많이 된 휴대폰 상위 3개</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-chart-pie"></i> 원형 그래프
						</div>
						<div class="card-body">
							<canvas id="myPieChart" width="100%" height="100"></canvas>
						</div>
						<div class="card-footer small text-muted">추천 많이 된 휴대폰 상위 3개</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

		<!-- Sticky Footer -->


	</div>
	<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="template1/vendor/jquery/jquery.min.js"></script>
	<script src="template1/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="template1/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="template1/vendor/chart.js/Chart.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="template1/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="template1/js/demo/chart-area-demo.js"></script>
	<script src="template1/js/demo/chart-bar-demo.js"></script>
	<script src="template1/js/demo/chart-pie-demo.js"></script>


	<style type="text/css">
@import
	url("https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css")
	;
</style>
	<style type="text/css">
@import
	url("https://cdnjs.cloudflare.com/ajax/libs/handsontable/5.0.0/handsontable.full.min.css")
	;

.handsontable td, .handsontable tr, .handsontable th {
	border: 0 !important;
}

.handsontable th {
	background-color: #ffffff;
}

.sans {
	font: 0.8em sans-serif;
}
</style>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handsontable/5.0.0/handsontable.full.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/web-animations/2.3.1/web-animations.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/muuri/0.5.4/muuri.min.js"></script>

	<div class="grid">
		<div class="item">
			<div class="item-content">

				<div id="7lfxIhp2GiscHjEmabeklB"></div>
			</div>
		</div>
	</div>

	<script>
        var data = [{
            city: '갤럭시2',
            value: 991,
            percent: '<div class="progress"><div title="tooltip" class="progress-bar progress-bar-striped progress-bar-animated bg-primary" role="progressbar" style="width: 19.15%" aria-valuenow="19.15" aria-valuemin="0" aria-valuemax="100">19.15%</div></div>'
        }, {
            city: '아이폰4',
            value: 348,
            percent: '<div class="progress"><div title="tooltip" class="progress-bar progress-bar-striped progress-bar-animated bg-primary" role="progressbar" style="width: 6.72%" aria-valuenow="6.72" aria-valuemin="0" aria-valuemax="100">6.72%</div></div>'
        }, {
            city: '아이폰9',
            value: 295,
            percent: '<div class="progress"><div title="tooltip" class="progress-bar progress-bar-striped progress-bar-animated bg-primary" role="progressbar" style="width: 5.70%" aria-valuenow="5.70" aria-valuemin="0" aria-valuemax="100">5.70%</div></div>'
        }];
        var hot = new Handsontable(document.getElementById('7lfxIhp2GiscHjEmabeklB'), {
            data: data,
            rowHeaders: true,
            colWidths: [100, 100, 600],
            colHeaders: false,
            columns: [{
                data: "city",
                renderer: "numeric",
                className: "htMiddle sans",
                readOnly: true
            }, {
                data: "value",
                renderer: "numeric",
                className: "htMiddle sans",
                readOnly: true
            }, {
                data: "percent",
                renderer: "html",
                className: "htMiddle sans",
                readOnly: true
            }]
        });
        var grid = new Muuri('.grid', {
            dragEnabled: false,
            dragContainer: document.body,
            dragSort: function() {
                return [grid]
            }
        });
        
    
        
        
        
        
        
        
        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
        Chart.defaults.global.defaultFontColor = '#292b2c';

        // Bar Chart Example
        var ctx = document.getElementById("myBarChart");
        var myLineChart = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: [<%=name[0]%>, <%=name[1]%>, <%=name[2]%>],
            datasets: [{
              label: "Revenue",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<%=count[0]%>, <%=count[1]%>,<%=count[2]%>],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'month'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 6
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 15000,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
        Chart.defaults.global.defaultFontColor = '#292b2c';

        // Pie Chart Example
        var ctx = document.getElementById("myPieChart");
        var myPieChart = new Chart(ctx, {
          type: 'pie',
          data: {
            labels: ["갤럭시", "아이폰", "샤오미"],
            datasets: [{
              data: [100, 50, 200],
              backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
            }],
          },
        });

        
        
    </script>
</body>

</html>
