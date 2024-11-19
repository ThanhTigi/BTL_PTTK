<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Xem Báo Cáo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 50%;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        nav {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        nav a {
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px;
            border-radius: 5px;
            font-size: 1em;
            font-weight: bold;
            transition: 0.3s;
        }

        nav a:hover {
            background-color: #0056b3;
        }

        nav a:active {
            background-color: #003f80;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Xem Báo Cáo</h2>
        <nav>
            <a href="gdTKBanDoc678.jsp">Thống kê độc giả theo số lần mượn</a>
            <a href="">Thống kê tài liệu theo số lần mượn</a>
            <a href="">Thống kê nhà cung cấp theo số lượng tài liệu nhập</a>
        </nav>
    </div>
</body>
</html>
