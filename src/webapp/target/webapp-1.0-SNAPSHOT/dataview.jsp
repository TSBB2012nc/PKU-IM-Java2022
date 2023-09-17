<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Enitiy.CountryIndex" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>国家科研能力数据展示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap 的 CSS 文件 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <!--    Bootstrap的图标库-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- 选项 1：包含 Popper 的 Bootstrap 集成包 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="echarts.js"></script>
    <script type="text/javascript">
        function modifyInput(country, d11, d111, d112, d12, d121, d122, year) {
            document.getElementById("input-COUNTRY").value = country;
            document.getElementById("input-D11").value = d11;
            document.getElementById("input-D111").value = d111;
            document.getElementById("input-D112").value = d112;
            document.getElementById("input-D12").value = d12;
            document.getElementById("input-D121").value = d121;
            document.getElementById("input-D122").value = d122;
            document.getElementById("input-YEAR").value = year;
        }
    </script>
</head>
<body>
<div class="container">
    <header class="navbar navbar-expand-md navbar-light d-print-none">
        <div class="container-xl">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu">
                <span class="navbar-toggler-icon"></span>
            </button>
            <h1 class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pe-0 pe-md-3">
                国家科研能力数据展示
            </h1>
            <div class="navbar-nav flex-row order-md-last">
                <div class="nav-item d-none d-md-flex me-3">
                    <div class="btn-list">
                        <a href="https://github.com/TSBB2012nc/PKU-IM-Java2022" class="btn btn-outline-white" target="_blank" rel="noreferrer">
                            <!-- Download SVG icon from http://tabler-icons.io/i/brand-github -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon text-github" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M9 19c-4.3 1.4 -4.3 -2.5 -6 -3m12 5v-3.5c0 -1 .1 -1.4 -.5 -2c2.8 -.3 5.5 -1.4 5.5 -6a4.6 4.6 0 0 0 -1.3 -3.2a4.2 4.2 0 0 0 -.1 -3.2s-1.1 -.3 -3.5 1.3a12.3 12.3 0 0 0 -6.2 0c-2.4 -1.6 -3.5 -1.3 -3.5 -1.3a4.2 4.2 0 0 0 -.1 3.2a4.6 4.6 0 0 0 -1.3 3.2c0 4.6 2.7 5.7 5.5 6c-.6 .6 -.6 1.2 -.5 2v3.5"></path></svg>
                            Source code
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="navbar-expand-md">
        <div class="collapse navbar-collapse" id="navbar-menu">
            <div class="navbar navbar-light">
                <div class="container-xl">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index">
                                <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/home -->
                                  <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="5 12 3 12 12 3 21 12 19 12"></polyline><path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7"></path><path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6"></path></svg>
                                </span>
                                <span class="nav-link-title">首页</span>
                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="dataview">
                                <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/package -->
                                  <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="12 3 20 7.5 20 16.5 12 21 4 16.5 4 7.5 12 3"></polyline><line x1="12" y1="12" x2="20" y2="7.5"></line><line x1="12" y1="12" x2="12" y2="21"></line><line x1="12" y1="12" x2="4" y2="7.5"></line><line x1="16" y1="5.25" x2="8" y2="9.75"></line></svg>
                                </span>
                                <span class="nav-link-title">
                                  数据
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
<%--    modal1--%>
    <div class="modal fade" id="modifyModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="modifyModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">修改</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form id="modify" name="modify" method="post" class="form-floating" action="UpdateServlet">
                <div class="modal-body">
                    <div class="form-floating">
                        <input class="form-control" id="input-COUNTRY" placeholder="国家" value="">
                        <label for="input-COUNTRY">国家</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D11" placeholder="D11" value="">
                        <label for="input-COUNTRY">D11</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D111" placeholder="D111" value="">
                        <label for="input-COUNTRY">D111</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D112" placeholder="D112" value="">
                        <label for="input-COUNTRY">D112</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D12" placeholder="D12" value="">
                        <label for="input-COUNTRY">D12</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D121" placeholder="D121" value="">
                        <label for="input-COUNTRY">D121</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-D122" placeholder="D122" value="">
                        <label for="input-COUNTRY">D122</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" id="input-YEAR" placeholder="年份" value="">
                        <label for="input-COUNTRY">年份</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="addModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="addModalLabel">添加</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form id="add" name="add" method="post" class="form-floating" action="InsertServerlet">
                    <div class="modal-body">
                        <div class="form-floating">
                            <input class="form-control" id="add-COUNTRY" name="add-COUNTRY" placeholder="国家" value="">
                            <label for="input-COUNTRY">国家</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D11" name="add-D11" placeholder="D11" value="">
                            <label for="input-COUNTRY">D11</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D111" name="add-D111" placeholder="D111" value="">
                            <label for="input-COUNTRY">D111</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D112" name="add-D112" placeholder="D112" value="">
                            <label for="input-COUNTRY">D112</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D12" name="add-D12" placeholder="D12" value="">
                            <label for="input-COUNTRY">D12</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D121" name="add-D121" placeholder="D121" value="">
                            <label for="input-COUNTRY">D121</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-D122" name="add-D122" placeholder="D122" value="">
                            <label for="input-COUNTRY">D122</label>
                        </div>
                        <div class="form-floating">
                            <input class="form-control" id="add-YEAR" name="add-YEAR" placeholder="年份" value="">
                            <label for="input-COUNTRY">年份</label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <button class="btn btn-primary" style="width: 200px" data-bs-toggle="modal" data-bs-target="#addModal">添加</button>
        <table class="table  table-hover">
            <thead>
                <tr>
                    <th>国家</th>
                    <th>D11</th>
                    <th>D111</th>
                    <th>D112</th>
                    <th>D12</th>
                    <th>D121</th>
                    <th>D122</th>
                    <th>年份</th>
                    <th>操作</th>
                </tr>
                </thead>
            <tbody>
            <c:forEach var="ci" items="${list}">
                <tr>
                    <td>${ci.getCOUNTRY()}</td>
                    <td>${ci.getD11()}</td>
                    <td>${ci.getD111()}</td>
                    <td>${ci.getD112()}</td>
                    <td>${ci.getD12()}</td>
                    <td>${ci.getD121()}</td>
                    <td>${ci.getD122()}</td>
                    <td>${ci.getYEAR()}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modifyModal"
                                onclick="modifyInput('${ci.getCOUNTRY()}', ${ci.getD11()},${ci.getD111()}, ${ci.getD112()}, ${ci.getD12()}, ${ci.getD121()}, ${ci.getD122()}, '${ci.getYEAR()}');">修改</button>
                        <a class="btn btn-danger" href="DeleteServlet?COUNTRY=${ci.getCOUNTRY()}&YEAR=${ci.getYEAR()}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>