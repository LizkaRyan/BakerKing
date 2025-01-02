<%
    String body=(String)request.getAttribute("body");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Skydash Admin</title>
    <link rel="stylesheet" href="/public/vendors/feather/feather.css">
    <link rel="stylesheet" href="/public/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="/public/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="/public/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="/public/bootstrap-5/css/bootstrap.min.css">
    <link rel="stylesheet" href="/public/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="/public/js/select.dataTables.min.css">
    <link rel="stylesheet" href="/public/css/vertical-layout-light/style.css">
</head>
<body>
<div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="navbar.jsp"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <jsp:include page="sidebar.jsp"/>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <jsp:include page="<%= body %>"/>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:partials/_footer.html -->
            <footer class="footer">
                <div class="d-sm-flex justify-content-center justify-content-sm-between">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2021.  Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash. All rights reserved.</span>
                    <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="ti-heart text-danger ml-1"></i></span>
                </div>
                <div class="d-sm-flex justify-content-center justify-content-sm-between">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Distributed by <a href="https://www.themewagon.com/" target="_blank">Themewagon</a></span>
                </div>
            </footer>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->

<!-- plugins:js -->
<script src="/public/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="/public/vendors/chart.js/Chart.min.js"></script>
<script src="/public/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="/public/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<script src="/public/js/dataTables.select.min.js"></script>

<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="/public/js/off-canvas.js"></script>
<script src="/public/js/hoverable-collapse.js"></script>
<script src="/public/js/template.js"></script>
<script src="/public/js/settings.js"></script>
<script src="/public/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="/public/js/dashboard.js"></script>
<script src="/public/js/Chart.roundedBarCharts.js"></script>
<!-- End custom js for this page-->
</body>

</html>

