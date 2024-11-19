package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TKBanDoc678;

public class TKBanDocDAO678 extends DAO {
    
    public TKBanDocDAO678() throws SQLException, ClassNotFoundException {
        // Gọi constructor của lớp cha để thiết lập kết nối cơ sở dữ liệu
        super();
    }

    public List<TKBanDoc678> getDSTKBanDoc(Date ngayBatDau, Date ngayKetThuc) throws SQLException {
        List<TKBanDoc678> danhSachBanDoc = new ArrayList<>();
        
        String sql = """
    SELECT b.maBanDoc, t.ten, COUNT(pm.maPhieuMuon) AS soLuongMuon
    FROM tblBanDoc678 b
    JOIN tblThanhVien678 t ON b.id = t.id
    JOIN tblPhieuMuon678 pm ON b.maBanDoc = pm.maBanDoc
    WHERE pm.thoiGianMuon BETWEEN ? AND ?
    GROUP BY b.maBanDoc, t.ten
    ORDER BY soLuongMuon DESC
    """;
        
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDate(1, ngayBatDau);
            stmt.setDate(2, ngayKetThuc);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int maBanDoc = rs.getInt("maBanDoc");
                String ten = rs.getString("ten");
                int soLuongMuon = rs.getInt("soLuongMuon");
                
                // Khởi tạo đối tượng TKBanDoc678 và thêm vào danh sách
                TKBanDoc678 tkBanDoc = new TKBanDoc678(soLuongMuon, maBanDoc, ten, null, null, null, null, maBanDoc);
                danhSachBanDoc.add(tkBanDoc);
            }
        }
        
        return danhSachBanDoc;
    }
}
