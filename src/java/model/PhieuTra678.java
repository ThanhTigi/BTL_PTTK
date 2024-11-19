package model;

import java.util.Date;
import java.util.List;

public class PhieuTra678 {
    private int maPhieuTra;
    private Date ngayGioTra;
    private BanDoc678 banDoc;
    private NhanVienThuVien678 nvThuVien;
    private List<PhieuTraChiTiet678> dsPhieuTraCT;

    // Constructor
    public PhieuTra678(int maPhieuTra, Date ngayGioTra, BanDoc678 banDoc, NhanVienThuVien678 nvThuVien, List<PhieuTraChiTiet678> dsPhieuTraCT) {
        this.maPhieuTra = maPhieuTra;
        this.ngayGioTra = ngayGioTra;
        this.banDoc = banDoc;
        this.nvThuVien = nvThuVien;
        this.dsPhieuTraCT = dsPhieuTraCT;
    }

    // Getters and Setters
    public int getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(int maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
    }

    public Date getNgayGioTra() {
        return ngayGioTra;
    }

    public void setNgayGioTra(Date ngayGioTra) {
        this.ngayGioTra = ngayGioTra;
    }

    public BanDoc678 getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc678 banDoc) {
        this.banDoc = banDoc;
    }

    public NhanVienThuVien678 getNvThuVien() {
        return nvThuVien;
    }

    public void setNvThuVien(NhanVienThuVien678 nvThuVien) {
        this.nvThuVien = nvThuVien;
    }

    public List<PhieuTraChiTiet678> getDsPhieuTraCT() {
        return dsPhieuTraCT;
    }

    public void setDsPhieuTraCT(List<PhieuTraChiTiet678> dsPhieuTraCT) {
        this.dsPhieuTraCT = dsPhieuTraCT;
    }
}
