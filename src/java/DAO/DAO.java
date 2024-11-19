package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String URL = "jdbc:mysql://localhost:3306/btl_pttk?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    protected Connection con;

    public DAO() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công tới cơ sở dữ liệu.");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            throw e;
        }
    }

    // Đóng kết nối khi không còn sử dụng
    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Kết nối cơ sở dữ liệu đã đóng.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối cơ sở dữ liệu: " + e.getMessage());
            }
        }
    }
}
