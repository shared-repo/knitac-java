<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<% String webAppName = "team-four"; %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <jsp:include page="/WEB-INF/views/modules/common-css.jsp" />

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/<%= webAppName %>/static/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <jsp:include page="/WEB-INF/views/modules/navbar.jsp"></jsp:include>

  <jsp:include page="/WEB-INF/views/modules/main-sidebar.jsp"></jsp:include>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

	<jsp:include page="/WEB-INF/views/modules/content-header.jsp">
  	  <jsp:param name="title" value="게시글 목록" />
  	</jsp:include>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  
  </div>
  <!-- /.content-wrapper -->
  
  <jsp:include page="/WEB-INF/views/modules/footer.jsp"></jsp:include>

  <jsp:include page="/WEB-INF/views/modules/control-sidebar.jsp"></jsp:include>

</div>
<!-- ./wrapper -->

<jsp:include page="/WEB-INF/views/modules/common-js.jsp"></jsp:include>

</body>
</html>

