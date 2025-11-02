
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
        super();
    }
    public SachGiaoTrinh(String maSach,String tieuDe,  String tacGia,int namXuatBan,int soLuong,String MonHoc,String CapDo){
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong);
        this.MonHoc=MonHoc;
        this.CapDo=CapDo;
    }
    public void nhap(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap thông tin thêm của sách giáo trinh:");
        System.out.println("môn học nay la:");
        this.MonHoc=scanner.nextLine();
        System.out.println("cấp độ của sách giáo trình là:");
        this.CapDo=scanner.nextLine();
    }
    public String toString() {
        String thongTinCha = super.toString(); 
        return thongTinCha +    
            ", Môn học: " + MonHoc + 
            ", Cấp độ: " + CapDo;
    }
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("môn học:"+MonHoc);
        System.out.println("Cấp độ:"+CapDo);
    }

  
}
