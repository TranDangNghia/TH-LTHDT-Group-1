import java.util.Scanner;
public class SachTieuThuyet extends Sach{
    private String theLoai;
    private boolean laSachSeries;     
    
    public String gettheLoai(){
        return theLoai;
    }
    public void settheLoai(String theLoai){
        this.theLoai=theLoai;
    }
    public boolean getlaSachSeries(){
        return laSachSeries;
    }
    public void setlaSachSeries( boolean laSachSeries){
        this.laSachSeries=laSachSeries;
    }
    public SachTieuThuyet(String maSach,String tieuDe,  String tacGia,int namXuatBan,int soLuong,String theLoai, boolean laSachSeries){
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong);
        this.theLoai=theLoai;
        this.laSachSeries=laSachSeries;
    }
    public SachTieuThuyet(){
        super();
    }
    public void nhap(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập thông tin thêm cho sách tiểu thuyết");
        System.out.println("thể loại sách là:"+theLoai);
        this.theLoai=scanner.nextLine();
        System.out.println("Đây là sách Series(true/fales):");
        this.laSachSeries=scanner.nextBoolean();
    }
    public String toString() {
        String seriesStatus = laSachSeries ? "Có" : "Không";
        return "Sách Tiểu Thuyết [" + super.toString() +  ", Thể loại: " + theLoai + ", Là series: " + seriesStatus + "]";
    }
    public void hienThiThongTin() {
        System.out.println(toString());
    }
}

