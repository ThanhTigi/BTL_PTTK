<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chi tiết tài liệu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 60%;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: left;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.1em;
            margin: 10px 0;
            line-height: 1.5;
        }

        strong {
            color: #555;
        }

        .button-back {
            display: block;
            width: 100%;
            text-align: center;
            margin-top: 20px;
        }

        .button-back a {
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            transition: 0.3s;
        }

    </style>
</head>
<body>
    <div class="container">
        <h2>Chi tiết tài liệu</h2>

        <c:if test="${not empty param.maTL}">
            <p><strong>Mã tài liệu:</strong> ${param.maTL}</p>
            <p><strong>Tên tài liệu:</strong> ${param.tenTL}</p>
            <p><strong>Tác giả:</strong> ${param.tacGia}</p>
            <p><strong>Nhà cung cấp:</strong> ${param.nhaCungCap}</p>
            <p><strong>Trạng thái:</strong> ${param.trangThai}</p>
        </c:if>

    </div>
</body>
</html>
