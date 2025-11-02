package BT_Chương;

public class SachGiaoTrinh extends Sach {
    protected String monHoc;
    protected String capDo;

    public SachGiaoTrinh() {}

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String viTri, String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getCapDo() {
        return capDo;
    }

    public void setCapDo(String capDo) {
        this.capDo = capDo;
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
        int soNam = 2025 - namXuatBan;
        return giaCoBan + (soNam * 5000);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Môn học: " + monHoc);
        System.out.println("Cấp độ: " + capDo);
        System.out.println("Giá bán của cuốn sách này là : " + giaCoBan + " VNĐ");
        System.out.println("Số lượng tối thiểu tồn kho là :"+ soLuongToiThieu);

        System.out.println("Giá bán: " + tinhGiaBan() + " VNĐ");
        System.out.println("----------------------");
    }

    @Override
    public String toString(){
        return "Sách giáo trình [" +
                "Mã sách=" + getMaSach() +
                ", Tiêu đề=" + getTieuDe() +
                ", Tác giả=" + getTacGia() +
                ", Năm xuất bản=" + getNamXuatBan() +
                ", Số lượng=" + getSoLuong() +
                ", Giá cơ bản=" + getGiaCoBan() +
                ",vi tri sach="+getViTri()+
                ", Tồn kho đủ tối thiểu=" + kiemTraTonKho( getSoLuongToiThieu() ) +
                ", Môn học=" + monHoc +
                ", Cấp độ=" + capDo +
                ", Giá bán=" + tinhGiaBan() +
                "]";
    }
}
