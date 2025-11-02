package CODETH1.src;
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
    public SachTieuThuyet(String maSach,String tieuDe,  String tacGia,int namXuatBan,int soLuong, Double giaCoBan,String theLoai, boolean laSachSeries){
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong, giaCoBan);
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
    public void nhap(){
        super.nhap();
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập thông tin thêm cho sách tiểu thuyết");
        System.out.println("thể loại sách là:"+theLoai);
        this.theLoai=scanner.nextLine();
        System.out.println("Đây là sách Series(true/fales):");
        this.laSachSeries=scanner.nextBoolean();
    }
    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("the loai cua cuon sach nay la:"+theLoai);
        System.out.println("Là sách series: " + (laSachSeries ? "Có" : "Không"));
        System.out.println("gia tien cua cuon sach nay la:"+tinhGiaBan());
    }
    @Override
   public String toString() {
        return super.toString() + 
               ", Thể loại: " + theLoai + 
               ", Là series: " + laSachSeries + 
               ", Giá bán: " + tinhGiaBan();
    }
    
}

