package CODETH1.src;
import java.util.Scanner;
 public abstract class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    protected double giaCoBan;

    // Constructor
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaCoBan=giaCoBan;
    }
    public Sach()
    {
        
    }
    // Getters and Setters
    public String getmaSach() {
        return maSach;
    }

    public void setmaSach(String maSach) {
        this.maSach = maSach;
    }

    public String gettieuDe() {
        return tieuDe;
    }

    public void settieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String gettacGia() {
        return tacGia;
    }

    public void settacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getnamXuatBan() {
        return namXuatBan;
    }

    public void setnamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getsoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double getgiaCoBan(){
        return giaCoBan;
    }
    public void setgiaCoBan( double giaCoBan){
        this.giaCoBan=giaCoBan;
    }
     public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Nhập thông tin Sách Cơ Bản ---");
        System.out.print("Mã sách: ");
        maSach=sc.nextLine(); 
        System.out.print("Tiêu đề: ");
        tieuDe=sc.nextLine(); 
        System.out.print("Tác giả: ");
        tacGia=sc.nextLine(); 
        System.out.print("Năm xuất bản: ");
        namXuatBan=sc.nextInt(); 
        System.out.print("Số lượng: ");
        soLuong=sc.nextInt(); 
        System.out.println("nhap gia ban cua cuon sach nay:");
        giaCoBan=sc.nextDouble();
    }
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("tieu de: " + tieuDe);
        System.out.println("tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("gia ban:"+giaCoBan);
    }
    public abstract double tinhGiaBan();

}