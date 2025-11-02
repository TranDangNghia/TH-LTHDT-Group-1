package BT_Chương;

import java.util.Scanner;

public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public SachTieuThuyet() {}

    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan,  int soLuong, double giaCoBan, String viTri, String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public boolean isLaSachSeries() {
        return laSachSeries;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setLaSachSeries(boolean laSachSeries) {
        this.laSachSeries = laSachSeries;
    }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return soLuong >= soLuongToiThieu;
    }

    @Override
    public void capNhatViTri(String viTriMoi) {
        this.viTri = viTriMoi;
        System.out.println("Đã chuyển sách \"" + tieuDe + "\" đến khu vực: " + viTriMoi);
    }

    @Override
    public double tinhGiaBan() {
        return giaCoBan + (laSachSeries ? 15000 : 0);
    }

    public void nhap(){
        super.nhap();
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập thông tin thêm cho sách tiểu thuyết");
        System.out.println("nhập thể loại sách");
        this.theLoai=scanner.nextLine();
        System.out.println("Đây là sách Series(true/fales):");
        this.laSachSeries=scanner.nextBoolean();
        scanner.close();
    }
    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("the loai cua cuon sach nay la:"+theLoai);
        System.out.println("Là sách series: " + (laSachSeries ? "Có" : "Không"));
        System.out.println("gia tien cua cuon sach nay la:"+tinhGiaBan());
        System.out.println("Tồn kho đủ tối thiểu? " + kiemTraTonKho( getSoLuongToiThieu() ));
    }
    @Override
   public String toString() {
        return super.toString() + 
               ", Thể loại: " + theLoai + 
               ", Là series: " + laSachSeries + 
               ", Giá bán: " + tinhGiaBan()+
               ", Tồn kho đủ tối thiểu=" + kiemTraTonKho( getSoLuongToiThieu() );
    }
}
