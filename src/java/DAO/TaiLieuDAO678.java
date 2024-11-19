package DAO;

import model.TaiLieu678;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaiLieuDAO678 extends DAO{
    
    public TaiLieuDAO678() throws SQLException, ClassNotFoundException {
    }


    public List<TaiLieu678> getDSTaiLieu(String tenTaiLieu) throws SQLException {
        String query = "SELECT * FROM tblTaiLieu678 WHERE tenTL LIKE ?";
        List<TaiLieu678> dsTaiLieu = new ArrayList<>();

        // Sử dụng PreparedStatement thay vì Statement
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            // Thiết lập tham số cho câu lệnh SQL
            stmt.setString(1, "%" + tenTaiLieu + "%");

            // Thực thi truy vấn
            try (ResultSet rs = stmt.executeQuery()) {
                // Duyệt qua kết quả và tạo đối tượng TaiLieu678
                while (rs.next()) {
                    TaiLieu678 taiLieu = new TaiLieu678(
                            rs.getInt("maTL"),
                            rs.getString("tenTL"),
                            rs.getString("tacGia"),
                            rs.getString("nhaCungCap"),
                            rs.getString("trangThai")
                    );
                    dsTaiLieu.add(taiLieu);
                }
            }
        }
        System.out.println("Check:" + dsTaiLieu.size());
        return dsTaiLieu;
    }

}

