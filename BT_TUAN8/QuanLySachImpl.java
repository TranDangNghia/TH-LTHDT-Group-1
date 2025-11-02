import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySachImpl implements IQuanLySach {

    private ArrayList<Sach> danhSach = new ArrayList<>();

    // ===== THÊM SÁCH NHẬP TAY =====
    @Override
    public void themSach() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tiêu đề: ");
        String tieuDe = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Năm xuất bản: ");
        int nam = Integer.parseInt(sc.nextLine());

        System.out.print("Số lượng: ");
        int sl = Integer.parseInt(sc.nextLine());

        System.out.print("Giá cơ bản: ");
        double gia = Double.parseDouble(sc.nextLine());

        Sach s = new Sach(ma, tieuDe, tacGia, nam, sl, gia) {
    @Override
    public double tinhGiaBan() {
        return gia;   // hoặc tính toán gì đó
    }

    @Override
    public void hienThiThongTin() {
        System.out.println(this);
    }
};

        danhSach.add(s);
        System.out.println("✅ Thêm sách thành công!");
        sc.close();
    }

    // ===== THÊM SÁCH CÓ SẴN =====
    @Override
    public void themSach(Sach s) {
        danhSach.add(s);
    }

    // ===== TÌM SÁCH =====
    @Override
    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    // ===== XÓA SÁCH =====
    @Override
    public boolean xoaSach(String maSach) {
        Sach s = timKiemSach(maSach);
        if (s != null) {
            danhSach.remove(s);
            return true;
        }
        return false;
    }

    // ===== HIỂN THỊ DANH SÁCH =====
    @Override
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách đang trống!");
            return;
        }

        for (Sach s : danhSach) {
            System.out.println(s);
        }
    }
}
