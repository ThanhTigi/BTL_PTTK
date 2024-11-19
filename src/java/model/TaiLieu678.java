package model;

public class TaiLieu678 {
    private int maTL;
    private String tenTL;
    private String tacGia;
    private String nhaCungCap;
    private String trangThai;

    // Constructor
    public TaiLieu678(int maTL, String tenTL, String tacGia, String nhaCungCap, String trangThai) {
        this.maTL = maTL;
        this.tenTL = tenTL;
        this.tacGia = tacGia;
        this.nhaCungCap = nhaCungCap;
        this.trangThai = trangThai;
    }
    
   

    // Getters and Setters
    public int getMaTL() {
        return maTL;
    }

    public void setMaTL(int maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

