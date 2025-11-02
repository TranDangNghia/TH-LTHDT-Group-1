import java.io.*;
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
    public SachTieuThuyet(String maSach,String tieuDe,  String tacGia,int namXuatBan,int soLuong, Double giaCoBan,String viTri,String theLoai, boolean laSachSeries){
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong, giaCoBan, viTri);
        this.theLoai=theLoai;
        this.laSachSeries=laSachSeries;
    }
    public SachTieuThuyet(){
    }
    @Override
    public double tinhGiaBan(){
        if(laSachSeries)
            return giaCoBan+15000;
        else
            return giaCoBan;    
        
    }
        @Override
    public boolean kiemTraTonKho( int soLuongToiThieu){
        return getsoLuong()>=soLuongToiThieu;
    }
    @Override
    public void capNhatViTri(String viTriMoi){
        setviTri(viTriMoi);
        System.out.println("Đã chuyển tiểu thuyết \"" + gettieuDe() + "\" đến khu vực: " + viTriMoi);
    }
    public void nhap(){
        super.nhap();
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập thông tin thêm cho sách tiểu thuyết");
        System.out.println("nhập thể loại sách");
        this.theLoai=scanner.nextLine();
        System.out.println("Đây là sách Series(true/fales):");
        this.laSachSeries=scanner.nextBoolean();
    }
    @Override
   public String toString() {
        return super.toString() + 
               "\n Thể loại: " + theLoai + 
               "\n Là series: " + laSachSeries + 
               "\n Giá bán: " + tinhGiaBan()+
               "\n Tồn kho đủ tối thiểu? " + kiemTraTonKho(getsoLuongToiThieu());
    }
    
}

