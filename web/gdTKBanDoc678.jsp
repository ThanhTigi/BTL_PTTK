<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="DAO.TKBanDocDAO678, model.TKBanDoc678, java.util.List, java.sql.Date" %>

<html>
<head>
    <title>Thống kê bạn đọc</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-bottom: 20px;
        }

        input[type="date"], button {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        p {
            text-align: center;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Thống kê bạn đọc theo số lần mượn</h2>

        <!-- Form nhập ngày tháng -->
        <form method="get">
            <label>Từ ngày:</label>
            <input type="date" name="startDate" required>
            <label>Đến ngày:</label>
            <input type="date" name="endDate" required>
            <button type="submit">Thống kê</button>
        </form>

        <%
            List<TKBanDoc678> listBanDoc = null;

            if (request.getParameter("startDate") != null && request.getParameter("endDate") != null) {
                try {
                    Date ngayBatDau = Date.valueOf(request.getParameter("startDate"));
                    Date ngayKetThuc = Date.valueOf(request.getParameter("endDate"));

                    TKBanDocDAO678 tkBanDocDAO = new TKBanDocDAO678();
                    listBanDoc = tkBanDocDAO.getDSTKBanDoc(ngayBatDau, ngayKetThuc);
                    request.setAttribute("listBanDoc", listBanDoc);
                    request.setAttribute("ngayBatDau", ngayBatDau);
                    request.setAttribute("ngayKetThuc", ngayKetThuc);
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p>Lỗi khi lấy dữ liệu từ cơ sở dữ liệu</p>");
                }
            }
        %>

        <!-- Hiển thị thông tin về ngày thống kê -->
        <c:if test="${not empty ngayBatDau and not empty ngayKetThuc}">
            <h3>Kết quả thống kê từ ${ngayBatDau} đến ${ngayKetThuc}:</h3>
            <c:if test="${not empty listBanDoc}">
                <table>
                    <thead>
                        <tr>
                            <th>Mã bạn đọc</th>
                            <th>Tên bạn đọc</th>
                            <th>Số lần mượn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="banDoc" items="${listBanDoc}">
                            <tr>
                                <td>${banDoc.maBanDoc}</td>
                                <td>
                                    <a href="gdChiTietBanDoc678.jsp?maBanDoc=${banDoc.maBanDoc}&tenBanDoc=${banDoc.ten}&ngayBatDau=${ngayBatDau}&ngayKetThuc=${ngayKetThuc}">
                                        ${banDoc.ten}
                                    </a>
                                </td>
                                <td>${banDoc.soLuongMuon}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <!-- Thông báo nếu không có dữ liệu -->
            <c:if test="${empty listBanDoc}">
                <p>Không tìm thấy bạn đọc nào trong khoảng thời gian đã chọn.</p>
            </c:if>
        </c:if>
    </div>
</body>
</html>
