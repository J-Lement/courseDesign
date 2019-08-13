<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.sql.*"%>
<%@ page import="util.*, bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改书籍</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    <script type="text/javascript">
    function ret() {
		history.back(-1);
	}
</script>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <div class="page-header">
        <nav class="navbar page-header">
            <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
                <i class="fa fa-bars"></i>
            </a>

            <a class="navbar-brand" href="#">
                <img src="./imgs/logo.png" alt="logo">
            </a>

            <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
                <i class="fa fa-bars"></i>
            </a>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-bell"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-envelope-open"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="./imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                        <span class="small ml-1 d-md-down-none">John Smith</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-right">
                        <<a href="logout.jsp" class="dropdown-item">
                            <i class="fa fa-lock"></i> 退出系统
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="AdminIndex" class="nav-link">
                            <i class="icon icon-speedometer"></i> 书籍管理
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a href="UserList" class="nav-link">
                            <i class="icon icon-speedometer"></i> 用户管理
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 学校专业课程管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="SchManage" class="nav-link">
                                    <i class="icon icon-target"></i> 学校管理
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="MajManage" class="nav-link">
                                    <i class="icon icon-target"></i> 专业管理
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="SubManage" class="nav-link">
                                    <i class="icon icon-target"></i> 课程管理
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="CheckBook" class="nav-link">
                            <i class="icon icon-puzzle"></i> 上传书籍审核
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="webSocketS.jsp" class="nav-link">
                            <i class="icon icon-grid"></i> 发送广播
                        </a>
                    </li>

                    
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                        <form action="BookEditDo" class="form" method="post">
                            <div class="card-body p-0">
                            <div class="card-body">
                                <div class="row">
                                <div class="col-md-8">
                           			<div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">书籍ID(不可修改)</span>
                                            </div>
                                            <input type="text" name="bookId" readonly="true" class="form-control" value="${bean.bookId }">
                                    </div>
                                    <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">书籍名称</span>
                                            </div>
                                            <input type="text" name="bookName" class="form-control" value="${bean.bookName }">
                                    </div>
                                    <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">所属课程</span>
                                            </div>
                                            <input type="text" name="bookSub" class="form-control" value="${bean.bookSub }">
                                    </div>
                                    <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">书籍作者</span>
                                            </div>
                                            <input type="text" name="bookAuthor" class="form-control" value="${bean.bookAuthor }">
                                    </div>
                                    <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">书籍简介</span>
                                            </div>
                                            <input type="text" name="bookInfo" class="form-control" value="${bean.bookInfo }">
                                    </div>
                                    <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">书籍文件(不可 修改)</span>
                                            </div>
                                            <input type="text" name="bookAttach" class="form-control" value="${bean.bookAttach }" readonly="true">
                                    </div>
                                    <div class="card-body">
                            			<div class=" text-right mb-4">
                                    		<button type="submit" class="btn btn-primary"> 保存修改 </button>
											<button type="button" class="btn btn-default" onclick="ret()"> 返回 </button>
										</div>
									</div>
                                            </tbody>
                                        </table>
                                    </div>
                                    </div>
                                </div>

                                </div>
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="./vendor/jquery/jquery.min.js"></script>
<script src="./vendor/popper.js/popper.min.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="./vendor/chart.js/chart.min.js"></script>
<script src="./js/carbon.js"></script>
<script src="./js/demo.js"></script>
</body>
</html>
