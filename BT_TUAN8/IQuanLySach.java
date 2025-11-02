public interface IQuanLySach {
    void themSach();          // nhập từ bàn phím
    void themSach(Sach s);    // thêm có sẵn
    void hienThiDanhSach();
    Sach timKiemSach(String maSach);
    boolean xoaSach(String maSach);
}