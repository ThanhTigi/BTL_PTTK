package model;


import java.util.Date;
import model.BanDoc678;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thanh
 */
public class TKBanDoc678 extends BanDoc678{
    private int soLuongMuon;

    public TKBanDoc678(int soLuongMuon, int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String sdt, int maBanDoc) {
        super(id, ten, tenDangNhap, matKhau, ngaySinh, sdt, maBanDoc);
        this.soLuongMuon = soLuongMuon;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    // Setter cho soLuongMuon (nếu cần)
    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }
}
