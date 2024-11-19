package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BanDoc678;
import model.NhanVienThuVien678;
import model.PhieuMuon678;
import model.PhieuMuonChiTiet678;
import model.TaiLieu678;

public class PhieuMuonDAO678 extends DAO {

    public PhieuMuonDAO678() throws SQLException, ClassNotFoundException {
    }

    public List<PhieuMuon678> getDSPhieuMuon(String maBanDoc, Date ngayBatDau, Date ngayKetThuc) {
        List<PhieuMuon678> listPhieuMuon = new ArrayList<>();
        String sqlPhieuMuon = "SELECT * FROM tblPhieuMuon678 pm "
                + "WHERE pm.maBanDoc = ? AND pm.thoiGianMuon BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sqlPhieuMuon)) {
            ps.setString(1, maBanDoc);  // Thiết lập tham số maBanDoc
            ps.setDate(2, ngayBatDau);   // Thiết lập tham số ngày bắt đầu
            ps.setDate(3, ngayKetThuc);  // Thiết lập tham số ngày kết thúc

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int maPhieuMuon = rs.getInt("maPhieuMuon");
                Date thoiGianMuon = rs.getDate("thoiGianMuon");
                Date hanTra = rs.getDate("thoiHanTra");
                PhieuMuon678 phieuMuon = new PhieuMuon678(maPhieuMuon, thoiGianMuon, hanTra, null, null, null);
                listPhieuMuon.add(phieuMuon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Checkkk: " + listPhieuMuon.size());
        return listPhieuMuon;
    }

    public PhieuMuon678 getPhieuMuon(int maPhieuMuon) {
        // Khai báo đối tượng PhieuMuon678 để lưu thông tin phiếu mượn
        PhieuMuon678 phieuMuon = null;

        // Kết nối tới cơ sở dữ liệu
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            // SQL query để lấy thông tin phiếu mượn theo mã phiếu
            String sql = "SELECT * FROM tblPhieuMuon678 WHERE maPhieuMuon = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);  // Set giá trị tham số mã phiếu mượn

            // Thực thi truy vấn
            rs = stmt.executeQuery();

            // Nếu có kết quả trả về, tạo đối tượng PhieuMuon678
            if (rs.next()) {
                Date thoiGianMuon = rs.getDate("thoiGianMuon");
                Date thoiHanTra = rs.getDate("thoiHanTra");
                int maBanDoc = rs.getInt("maBanDoc");

                // Lấy thông tin bạn đọc từ cơ sở dữ liệu
                String sqlBanDoc = "SELECT * FROM tblBanDoc678 bd "
                        + "JOIN tblThanhVien678 tv ON bd.id = tv.id "
                        + "WHERE bd.maBanDoc = ?";
                PreparedStatement psBanDoc = con.prepareStatement(sqlBanDoc);
                psBanDoc.setInt(1, maBanDoc);
                ResultSet rsBanDoc = psBanDoc.executeQuery();

                BanDoc678 banDoc = null;
                if (rsBanDoc.next()) {
                    // Lấy thông tin từ bảng tblBanDoc678 và tblThanhVien678
                    int idBanDoc = rsBanDoc.getInt("id");
                    String tenBanDoc = rsBanDoc.getString("ten");
                    String tenDangNhap = rsBanDoc.getString("tenDangNhap");
                    String matKhau = rsBanDoc.getString("matKhau");
                    Date ngaySinh = rsBanDoc.getDate("ngaySinh");
                    String sdt = rsBanDoc.getString("sdt");

                    // Tạo đối tượng BanDoc678 với thông tin từ bảng tblBanDoc678
                    banDoc = new BanDoc678(idBanDoc, tenBanDoc, tenDangNhap, matKhau, ngaySinh, sdt, maBanDoc);
                }

                // Lấy thông tin nhân viên thư viện từ cơ sở dữ liệu
                int maNV = rs.getInt("maNV");
                System.out.println("AAAA" + maNV);
                String sqlNhanVien = "SELECT t.ten, t.tenDangNhap, t.matKhau, t.ngaySinh, t.sdt, n.maNV, n.chucVu "
                        + "FROM tblThanhVien678 t "
                        + "JOIN tblNhanVien678 n ON n.id = t.id "
                        + // Join với bảng tblNhanVien678 dựa trên maNV
                        "WHERE n.maNV = ?"; // Sử dụng maNV từ bảng tblNhanVien678
                PreparedStatement psNhanVien = con.prepareStatement(sqlNhanVien);
                psNhanVien.setInt(1, maNV);  // Truyền maNV vào câu lệnh SQL
                ResultSet rsNhanVien = psNhanVien.executeQuery();
                NhanVienThuVien678 nvThuVien = null;

                if (rsNhanVien.next()) {
                    // Lấy dữ liệu từ ResultSet và tạo đối tượng NhanVienThuVien678
                    nvThuVien = new NhanVienThuVien678(
                            maNV,
                            rsNhanVien.getString("ten"),
                            rsNhanVien.getString("tenDangNhap"),
                            rsNhanVien.getString("matKhau"),
                            rsNhanVien.getDate("ngaySinh"),
                            rsNhanVien.getString("sdt"),
                            rsNhanVien.getInt("maNV"),
                            rsNhanVien.getString("chucVu")
                    );
                }

                // Lấy chi tiết phiếu mượn từ cơ sở dữ liệu
                String sqlChiTiet = "SELECT * FROM tblPhieuMuonChiTiet678 WHERE maPhieuMuon = ?";
                PreparedStatement psChiTiet = con.prepareStatement(sqlChiTiet);
                psChiTiet.setInt(1, maPhieuMuon);
                ResultSet rsChiTiet = psChiTiet.executeQuery();
                List<PhieuMuonChiTiet678> dsPhieuMuonCT = new ArrayList<>();
                while (rsChiTiet.next()) {
                    int maPhieuMuonChiTiet = rsChiTiet.getInt("ma");
                    String maTL = rsChiTiet.getString("maTL");

                    // Lấy thông tin tài liệu từ cơ sở dữ liệu
                    String sqlTaiLieu = "SELECT * FROM tblTaiLieu678 WHERE maTL = ?";
                    PreparedStatement psTaiLieu = con.prepareStatement(sqlTaiLieu);
                    psTaiLieu.setString(1, maTL);
                    ResultSet rsTaiLieu = psTaiLieu.executeQuery();
                    TaiLieu678 taiLieu = null;
                    if (rsTaiLieu.next()) {
                        taiLieu = new TaiLieu678(
                                rsTaiLieu.getInt("maTL"),
                                rsTaiLieu.getString("tenTL"),
                                rsTaiLieu.getString("tacGia"),
                                rsTaiLieu.getString("nhaCungCap"),
                                rsTaiLieu.getString("trangThai")
                        );
                    }

                    // Khởi tạo chi tiết phiếu mượn với tài liệu
                    PhieuMuonChiTiet678 chiTiet = new PhieuMuonChiTiet678(maPhieuMuonChiTiet, taiLieu);
                    dsPhieuMuonCT.add(chiTiet);
                }

                phieuMuon = new PhieuMuon678(maPhieuMuon, thoiGianMuon, thoiHanTra, banDoc, nvThuVien, dsPhieuMuonCT);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng ResultSet, Statement
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return phieuMuon;  // Trả về đối tượng PhieuMuon678 (hoặc null nếu không tìm thấy)
    }

}
