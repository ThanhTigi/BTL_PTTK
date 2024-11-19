package model;

import java.util.Date;

public class BanDoc678 extends ThanhVien678{
    private int maBanDoc;

    public BanDoc678(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String sdt, int maBanDoc) {
        super(id, ten, tenDangNhap, matKhau, ngaySinh, sdt);
        this.maBanDoc = maBanDoc;
    }

    // Getters and Setters
    public int getMaBanDoc() {
        return maBanDoc;
    }

    public void setMaBanDoc(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }
}

