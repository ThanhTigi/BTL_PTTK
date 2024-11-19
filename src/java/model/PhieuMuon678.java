package model;

import java.util.Date;
import java.util.List;

public class PhieuMuon678 {
    private int maPhieuMuon;
    private Date thoiGianMuon;
    private Date thoiHanTra;
    private BanDoc678 banDoc;
    private NhanVienThuVien678 nvThuVien;
    private List<PhieuMuonChiTiet678> dsPhieuMuonCT;

    // Constructor
    public PhieuMuon678(int maPhieuMuon, Date thoiGianMuon, Date thoiHanTra, BanDoc678 banDoc, NhanVienThuVien678 nvThuVien, List<PhieuMuonChiTiet678> dsPhieuMuonCT) {
        this.maPhieuMuon = maPhieuMuon;
        this.thoiGianMuon = thoiGianMuon;
        this.thoiHanTra = thoiHanTra;
        this.banDoc = banDoc;
        this.nvThuVien = nvThuVien;
        this.dsPhieuMuonCT = dsPhieuMuonCT;
    }

    // Getters and Setters
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public Date getThoiGianMuon() {
        return thoiGianMuon;
    }

    public void setThoiGianMuon(Date thoiGianMuon) {
        this.thoiGianMuon = thoiGianMuon;
    }

    public Date getThoiHanTra() {
        return thoiHanTra;
    }

    public void setThoiHanTra(Date hanTra) {
        this.thoiHanTra = hanTra;
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

    public List<PhieuMuonChiTiet678> getDsPhieuMuonCT() {
        return dsPhieuMuonCT;
    }

    public void setDsPhieuMuonCT(List<PhieuMuonChiTiet678> dsPhieuMuonCT) {
        this.dsPhieuMuonCT = dsPhieuMuonCT;
    }
}

