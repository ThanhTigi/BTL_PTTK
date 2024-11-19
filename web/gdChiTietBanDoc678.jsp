<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="DAO.PhieuMuonDAO678, model.PhieuMuon678, java.util.List, java.sql.Date" %>

<html>
<head>
    <title>Chi tiết các lần mượn của bạn đọc</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        table th {
            background-color: #007bff;
            color: #fff;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #007bff;
            text-decoration: none;
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
    <h2>Chi tiết các lần mượn</h2>

    <%
        String maBanDoc = request.getParameter("maBanDoc");
        String tenBanDoc = request.getParameter("tenBanDoc");
        List<PhieuMuon678> listPhieuMuon = null;

        if (maBanDoc != null && request.getParameter("ngayBatDau") != null && request.getParameter("ngayKetThuc") != null) {
            try {
                Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
                Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));

                PhieuMuonDAO678 phieuMuonDAO = new PhieuMuonDAO678();
                listPhieuMuon = phieuMuonDAO.getDSPhieuMuon(maBanDoc, ngayBatDau, ngayKetThuc);
                request.setAttribute("maBanDoc", maBanDoc);
                request.setAttribute("ngayBatDau", ngayBatDau);
                request.setAttribute("ngayKetThuc", ngayKetThuc);
                request.setAttribute("tenBanDoc", tenBanDoc);
                request.setAttribute("listPhieuMuon", listPhieuMuon);
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p style='color: red;'>Lỗi khi lấy dữ liệu từ cơ sở dữ liệu</p>");
            }
        }
    %>

    <!-- Kiểm tra và hiển thị dữ liệu -->
    <c:if test="${not empty listPhieuMuon}">
        <h3>Danh sách các lần mượn của bạn đọc <b>${tenBanDoc}</b> từ ${ngayBatDau} đến ${ngayKetThuc}:</h3>
        <table>
            <thead>
                <tr>
                    <th>Mã phiếu mượn</th>
                    <th>Ngày mượn</th>
                    <th>Ngày hẹn trả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="phieuMuon" items="${listPhieuMuon}">
                    <tr>
                        <td><a href="gdChiTietPhieuMuon678.jsp?maPhieuMuon=${phieuMuon.maPhieuMuon}">${phieuMuon.maPhieuMuon}</a></td>
                        <td>${phieuMuon.thoiGianMuon}</td>
                        <td>${phieuMuon.thoiHanTra}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Thông báo khi không có dữ liệu -->
    <c:if test="${empty listPhieuMuon}">
        <p>Không tìm thấy phiếu mượn nào trong khoảng thời gian đã chọn.</p>
    </c:if>
</body>
</html>
