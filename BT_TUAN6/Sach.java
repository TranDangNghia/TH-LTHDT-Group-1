import java.util.Scanner;
class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
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
     public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Nhập thông tin Sách Cơ Bản ---");
        System.out.print("Mã sách: ");
        this.maSach=scanner.nextLine(); 
        System.out.print("Tiêu đề: ");
        this.tieuDe=scanner.nextLine(); 
        System.out.print("Tác giả: ");
        this.tacGia=scanner.nextLine(); 
        System.out.print("Năm xuất bản: ");
        this.namXuatBan=scanner.nextInt(); 
        System.out.print("Số lượng: ");
        this.soLuong=scanner.nextInt();   
    }
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("tieu de: " + tieuDe);
        System.out.println("tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
}
}