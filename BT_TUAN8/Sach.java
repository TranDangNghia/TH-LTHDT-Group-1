import java.io.*;
import java.util.Scanner;
 public abstract class Sach implements IGiaban,IKiemKe{
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    protected double giaCoBan;
    protected int soLuongToiThieu=10;
    private String viTri;

    // Constructor
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String viTri) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaCoBan=giaCoBan;
        this.viTri=viTri;
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
    public int getsoLuongToiThieu(){
        return soLuongToiThieu;
    }
    public void setsoLuongToiThieu(int soLuongToiThieu){
        this.soLuongToiThieu=soLuongToiThieu;
    }
    public String getviTri(){
        return viTri;
    }
    public void setviTri( String viTri){
        this.viTri=viTri;
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
        sc.nextLine();
        System.out.println("vi tri trong kho:");
        viTri=sc.nextLine();
    }
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("tieu de: " + tieuDe);
        System.out.println("tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("gia ban:"+giaCoBan);
        System.out.println("vi tri trong kho la:"+viTri);
    }
    @Override
    public abstract double tinhGiaBan();
    @Override
    public abstract boolean kiemTraTonKho(int soLuongToiThieu);
    @Override
    public abstract void capNhatViTri( String viTriMoi);

}