<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<% String webAppName = "team-three"; %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <jsp:include page="/WEB-INF/views/modules/common-css.jsp" />
</head>

<body class="animsition">
    <div class="page-wrapper">
        <jsp:include page="/WEB-INF/views/modules/mobile-header.jsp" />

        <jsp:include page="/WEB-INF/views/modules/sidebar-menu.jsp" />

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            
            <jsp:include page="/WEB-INF/views/modules/desktop-header.jsp" />

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    <!-- main content area -->
                    
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

    <jsp:include page="/WEB-INF/views/modules/common-js.jsp" />

</body>

</html>
<!-- end document-->
