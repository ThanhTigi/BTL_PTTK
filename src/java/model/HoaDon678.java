package model;

import java.util.Date;
import java.util.List;

public class HoaDon678 {
    private int maHoaDon;
    private float tien;
    private Date ngayCungCap;
    private NhanVienThuVien678 nhanVien;
    private NhaCungCap678 nhaCungCap;
    private List<HoaDonChiTiet678> dsHoaDonCT;

    // Constructor
    public HoaDon678(int maHoaDon, float tien, Date ngayCungCap, NhanVienThuVien678 nhanVien, NhaCungCap678 nhaCungCap, List<HoaDonChiTiet678> dsHoaDonCT) {
        this.maHoaDon = maHoaDon;
        this.tien = tien;
        this.ngayCungCap = ngayCungCap;
        this.nhanVien = nhanVien;
        this.nhaCungCap = nhaCungCap;
        this.dsHoaDonCT = dsHoaDonCT;
    }

    // Getters and Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }

    public Date getNgayCungCap() {
        return ngayCungCap;
    }

    public void setNgayCungCap(Date ngayCungCap) {
        this.ngayCungCap = ngayCungCap;
    }

    public NhanVienThuVien678 getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienThuVien678 nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaCungCap678 getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap678 nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public List<HoaDonChiTiet678> getDsHoaDonCT() {
        return dsHoaDonCT;
    }

    public void setDsHoaDonCT(List<HoaDonChiTiet678> dsHoaDonCT) {
        this.dsHoaDonCT = dsHoaDonCT;
    }
}
