<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="DAO.PhieuMuonDAO678, model.PhieuMuon678, java.util.List, java.sql.Date" %>

<html>
<head>
    <title>Chi tiết phiếu mượn</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        .container {
            width: 80%;
            max-width: 900px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            font-size: 28px;
        }

        .error {
            color: red;
            font-size: 16px;
            margin-top: 20px;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            text-align: left;
        }

        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #e1e1e1;
        }

        p {
            color: #666;
            font-size: 16px;
        }

        .section-header {
            margin-top: 30px;
            font-size: 20px;
            color: #333;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Chi tiết phiếu mượn</h2>

        <%
            // Lấy mã phiếu mượn từ tham số URL
            String maPhieuMuon = request.getParameter("maPhieuMuon");

            PhieuMuon678 phieuMuon = null;
            if (maPhieuMuon != null && !maPhieuMuon.isEmpty()) {
                try {
                    // Kiểm tra nếu mã phiếu mượn là một số hợp lệ
                    int maPhieuMuonInt;
                    try {
                        maPhieuMuonInt = Integer.parseInt(maPhieuMuon);
                    } catch (NumberFormatException e) {
                        out.println("<p class='error'>Mã phiếu mượn không hợp lệ.</p>");
                        return;
                    }

                    // Tạo đối tượng DAO để lấy thông tin phiếu mượn
                    PhieuMuonDAO678 phieuMuonDAO = new PhieuMuonDAO678();
                    // Lấy chi tiết phiếu mượn
                    phieuMuon = phieuMuonDAO.getPhieuMuon(maPhieuMuonInt);
                    // Tìm phiếu mượn có mã phù hợp
                    if (phieuMuon == null) {
                        out.println("<p class='error'>Không tìm thấy phiếu mượn với mã " + maPhieuMuon + ".</p>");
                        return;
                    }
                    request.setAttribute("phieuMuon", phieuMuon);
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p class='error'>Lỗi khi lấy dữ liệu phiếu mượn.</p>");
                }
            } else {
                out.println("<p class='error'>Mã phiếu mượn không hợp lệ hoặc bị thiếu.</p>");
            }
        %>

        <!-- Hiển thị thông tin phiếu mượn -->
        <c:if test="${not empty phieuMuon}">
            <h3>Chi tiết phiếu mượn mã: ${phieuMuon.maPhieuMuon}</h3>
            <p><strong>Ngày mượn:</strong> ${phieuMuon.thoiGianMuon}</p>
            <p><strong>Ngày hẹn trả:</strong> ${phieuMuon.thoiHanTra}</p>

            <div class="section-header">Thông tin bạn đọc:</div>
            <p><strong>Mã bạn đọc:</strong> ${phieuMuon.banDoc.maBanDoc}</p>
            <p><strong>Tên:</strong> ${phieuMuon.banDoc.ten}</p>

            <div class="section-header">Thông tin nhân viên thư viện:</div>
            <p><strong>Mã nhân viên:</strong> ${phieuMuon.nvThuVien.id}</p>
            <p><strong>Tên:</strong> ${phieuMuon.nvThuVien.ten}</p>

            <div class="section-header">Danh sách mượn:</div>
            <table>
                <thead>
                    <tr>
                        <th>Mã tài liệu</th>
                        <th>Tên tài liệu</th>
                        <th>Tác giả</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="chiTiet" items="${phieuMuon.dsPhieuMuonCT}">
                        <tr>
                            <td>${chiTiet.taiLieu.maTL}</td>
                            <td>${chiTiet.taiLieu.tenTL}</td>
                            <td>${chiTiet.taiLieu.tacGia}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
