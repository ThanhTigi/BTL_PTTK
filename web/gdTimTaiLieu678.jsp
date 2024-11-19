<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="DAO.TaiLieuDAO678, model.TaiLieu678, java.util.List, javax.servlet.RequestDispatcher" %>

<html>
    <head>
        <title>Tìm Tài Liệu</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                line-height: 1.6;
                margin: 20px;
                background-color: #f9f9f9;
            }

            h2, h3 {
                text-align: center;
                color: #333;
            }

            form {
                margin: 20px auto;
                text-align: center;
            }

            form label {
                font-size: 1.1em;
                margin-right: 10px;
            }

            form input[type="text"] {
                padding: 8px;
                width: 300px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            form button {
                padding: 8px 15px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1em;
            }

            form button:hover {
                background-color: #0056b3;
            }

            table {
                margin: 20px auto;
                width: 80%;
                border-collapse: collapse;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            table th, table td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: center;
            }

            table th {
                background-color: #007bff;
                color: white;
                font-weight: bold;
            }

            table tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            table tr:hover {
                background-color: #ddd;
            }

            .no-results {
                text-align: center;
                color: #ff0000;
                font-size: 1.2em;
            }
        </style>
    </head>
    <body>
        <h2>Tìm kiếm tài liệu</h2>

        <!-- Form tìm kiếm -->
        <form method="get">
            <label>Nhập tên tài liệu:</label>
            <input type="text" name="tenTaiLieu" required>
            <button type="submit">Tìm Kiếm</button>
        </form>

        <%
            String tenTaiLieu = request.getParameter("tenTaiLieu");
            List<TaiLieu678> dsTaiLieu = null;

            if (tenTaiLieu != null && !tenTaiLieu.trim().isEmpty()) {
                try {
                    TaiLieuDAO678 taiLieuDAO = new TaiLieuDAO678();
                    dsTaiLieu = taiLieuDAO.getDSTaiLieu(tenTaiLieu);
                    request.setAttribute("tenTaiLieu", tenTaiLieu);
                    request.setAttribute("dsTaiLieu", dsTaiLieu);
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p style='color:red; text-align:center;'>Lỗi khi lấy dữ liệu từ cơ sở dữ liệu</p>");
                }
            }
        %>

        <c:if test="${not empty tenTaiLieu}">
            <h3>Kết quả tìm kiếm cho "${tenTaiLieu}":</h3>
            <c:if test="${not empty dsTaiLieu}">
                <table>
                    <thead>
                        <tr>
                            <th>Mã Tài Liệu</th>
                            <th>Tên Tài Liệu</th>
                            <th>Trạng Thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="taiLieu" items="${dsTaiLieu}">
                            <tr>
                                <td>${taiLieu.maTL}</td>
                                <td>
                                    <form action="gdChiTietTaiLieu678.jsp" method="get" style="display:inline;">
                                        <input type="hidden" name="maTL" value="${taiLieu.maTL}">
                                        <input type="hidden" name="tenTL" value="${taiLieu.tenTL}">
                                        <input type="hidden" name="tacGia" value="${taiLieu.tacGia}">
                                        <input type="hidden" name="nhaCungCap" value="${taiLieu.nhaCungCap}">
                                        <input type="hidden" name="trangThai" value="${taiLieu.trangThai}">
                                        <button type="submit" style="background:none; border:none; color:blue; text-decoration:underline; cursor:pointer;">
                                            ${taiLieu.tenTL}
                                        </button>
                                    </form>
                                </td>
                                <td>${taiLieu.trangThai}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty dsTaiLieu}">
                <p class="no-results">Không tìm thấy tài liệu nào phù hợp.</p>
            </c:if>
        </c:if>
    </body>
</html>
