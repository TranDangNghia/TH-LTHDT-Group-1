package BT_Chương;

import java.util.Scanner;

public abstract class Sach implements IGiaBan,IKiemKe {
   protected String maSach;
   protected String tieuDe;
   protected String tacGia;
   protected int namXuatBan;
   protected int soLuong;
   protected int soLuongToiThieu = 9;
   protected String viTri;
   protected double giaCoBan;
   public Sach() {}
   public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String viTri) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong =soLuong;
        this.giaCoBan = giaCoBan;
        this.viTri = viTri;
    }
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    public int getSoLuongToiThieu() {
        return soLuongToiThieu;
    }
    public void setSoLuongToiThieu(int soLuongToiThieu) {
        this.soLuongToiThieu = soLuongToiThieu;
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public double getGiaCoBan() {
        return giaCoBan;
    }

    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan;
    }
    
    public abstract double tinhGiaBan();

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void nhap() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Nhập thông tin Sách Cơ Bản ---");
            System.out.print("Mã sách: ");
            maSach=scanner.nextLine(); 
            System.out.print("Tiêu đề: ");
            tieuDe=scanner.nextLine(); 
            System.out.print("Tác giả: ");
            tacGia=scanner.nextLine(); 
            System.out.print("Năm xuất bản: ");
            namXuatBan=scanner.nextInt(); 
            System.out.print("Số lượng: ");
            soLuong=scanner.nextInt(); 
            System.out.println("nhap gia ban cua cuon sach nay:");
            giaCoBan=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("vi tri trong kho:");
            viTri=scanner.nextLine();
        }
    }

    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tiêu đề: " + tieuDe);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Giá bán của cuốn sách này là "+ giaCoBan);
        System.out.println("VỊ trí trong kho là :" + viTri);
        System.out.println("----------------------");
    }
    
    @Override
    public abstract boolean kiemTraTonKho (int soLuongToiThieu);

    @Override
    public abstract void capNhatViTri (String viTriMoi);
}
