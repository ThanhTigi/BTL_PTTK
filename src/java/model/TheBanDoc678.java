package model;

import java.util.Date;

public class TheBanDoc678 extends BanDoc678{
    private int maThe;
    private Date hanSuDung;

    // Constructor


    public TheBanDoc678(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String sdt, int maBanDoc, int maThe, Date hanSuDung) {
        super(id, ten, tenDangNhap, matKhau, ngaySinh, sdt, maBanDoc);
        this.maThe = maThe;
        this.hanSuDung = hanSuDung;
    }

    // Getters and Setters
    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

}
