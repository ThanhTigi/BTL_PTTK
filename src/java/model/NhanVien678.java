package model;

import java.util.Date;

public class NhanVien678 extends ThanhVien678 {
    private int maNV;
    private String chucVu;

    // Constructor
    public NhanVien678(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String sdt, int maNV, String chucVu) {
        super(id, ten, tenDangNhap, matKhau, ngaySinh, sdt);
        this.maNV = maNV;
        this.chucVu = chucVu;
    }

    // Getters and Setters
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
