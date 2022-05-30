<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<% String webAppName = "team-one"; %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Top Navigation</title>

  <jsp:include page="/WEB-INF/views/modules/common-css.jsp" />
  
</head>
<body class="hold-transition layout-top-nav">
<div class="wrapper">

  <jsp:include page="/WEB-INF/views/modules/navbar.jsp" />
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    
    <jsp:include page="/WEB-INF/views/modules/content-header.jsp">
      <jsp:param name="title" value="Top Navigation <small>Example 3.0</small>" />
    </jsp:include>

    <!-- Main content -->
    <div class="content">
      <div class="container">
        
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <jsp:include page="/WEB-INF/views/modules/control-sidebar.jsp" />

  <jsp:include page="/WEB-INF/views/modules/footer.jsp" />
  
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<jsp:include page="/WEB-INF/views/modules/common-js.jsp" />

</body>
</html>
