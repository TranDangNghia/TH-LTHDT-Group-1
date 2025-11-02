
import java.io.*;
import java.util.Scanner;
public class SachGiaoTrinh extends Sach{
    private String MonHoc;
    private String CapDo;

    public String getMonHoc(){
        return MonHoc;
    }
    public void setMonHoc(String MonHoc){
        this.MonHoc=MonHoc;
    }
    public String getCapDo(){
        return CapDo;
    }
    public void setCapDo(String CapDo){
        this.CapDo=CapDo;
    }
    public SachGiaoTrinh(){
    }
    public SachGiaoTrinh(String maSach,String tieuDe,  String tacGia,int namXuatBan,int soLuong,Double giaCoBan,String viTri,String MonHoc,String CapDo){
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong, giaCoBan,viTri);
        this.MonHoc=MonHoc;
        this.CapDo=CapDo;
    }
       @Override
    public void nhap() {
        super.nhap(); 
        Scanner sc = new Scanner(System.in);
        System.out.print("Môn học: ");
        MonHoc = sc.nextLine();
        System.out.print("Cấp độ: ");
        CapDo = sc.nextLine();
    }
    @Override
    public double tinhGiaBan(){
        int soNam=2025-getnamXuatBan();
        return giaCoBan+(soNam * 5000);
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
    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Mon hoc:"+MonHoc);
        System.out.println("Cap do cua mon nay :"+CapDo);
        System.out.println("gia ban cua cuon sach nay la:"+tinhGiaBan());
         System.out.println("Tồn kho đủ tối thiểu? " + kiemTraTonKho(getsoLuongToiThieu()));
    }
    public String toString(){
        return "Sách giáo trình [" +
                "Mã sách=" + getmaSach() +
                ", Tiêu đề=" + gettieuDe() +
                ", Tác giả=" + gettacGia() +
                ", Năm xuất bản=" + getnamXuatBan() +
                ", Số lượng=" + getsoLuong() +
                ", Giá cơ bản=" + getgiaCoBan() +
                ",vi tri sach="+getviTri()+
                ", Tồn kho đủ tối thiểu=" + kiemTraTonKho(getsoLuongToiThieu()) +
                ", Môn học=" + MonHoc +
                ", Cấp độ=" + CapDo +
                ", Giá bán=" + tinhGiaBan() +
                "]";
    }
    
  
}
