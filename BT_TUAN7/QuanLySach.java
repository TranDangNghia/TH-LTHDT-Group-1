package CODETH1.src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach;
    private Scanner scanner;

    public QuanLySach() {
        this.danhSachSach = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void themSach() {
    System.out.println("\n--- THÊM SÁCH MỚI ---");
    System.out.println("Chọn loại sách muốn thêm:");
    System.out.println("1. Sách Giáo Trình (SachGiaoTrinh)");
    System.out.println("2. Sách Tiểu Thuyết (SachTieuThuyet)");
    System.out.print("Nhập lựa chọn: ");

    if (!scanner.hasNextInt()) {
        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
        scanner.nextLine();
        return;
    }

    int chon = scanner.nextInt();
    scanner.nextLine();

    Sach newSach = null;

    switch (chon) {
        case 1:
            newSach = new SachGiaoTrinh();
            break;
        case 2:
            newSach = new SachTieuThuyet();
            break;
        default:
            System.out.println("Lựa chọn không hợp lệ. Thêm sách thất bại.");
            return;
    }

    newSach.nhap();
    danhSachSach.add(newSach);
    System.out.println(" Đã thêm sách mới thành công!");
}


    private Sach timKiemTheoMa(String maSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getmaSach().equalsIgnoreCase(maSach)) {
                return sach;
            }
        }
        return null;
    }

    public void timKiemSach() {
        System.out.println("\n--- TÌM KIẾM SÁCH ---");
        System.out.print("Nhập Mã Sách cần tìm: ");
        String maSach = scanner.nextLine();
        Sach ketQua = timKiemTheoMa(maSach);

        if (ketQua != null) {
            System.out.println("--- KẾT QUẢ TÌM KIẾM ---");
            ketQua.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy sách với Mã Sách: " + maSach);
        }
    }

    public void xoaSach() {
        System.out.println("\n--- XÓA SÁCH ---");
        System.out.print("Nhập Mã Sách cần xóa: ");
        String maSach = scanner.nextLine();

        Iterator<Sach> it = danhSachSach.iterator();
        while (it.hasNext()) {
            Sach sach = it.next();
            if (sach.getmaSach().equalsIgnoreCase(maSach)) {
                it.remove();
                System.out.println("Đã xóa sách có Mã Sách " + maSach + " thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với Mã Sách: " + maSach + ". Xóa thất bại.");
    }

    public void capNhatSach() {
        System.out.println("\n--- CẬP NHẬT SÁCH ---");
        System.out.print("Nhập Mã Sách cần cập nhật: ");
        String maSach = scanner.nextLine();

        Sach sachCanCapNhat = timKiemTheoMa(maSach);

        if (sachCanCapNhat != null) {
            System.out.println("Tìm thấy sách. Vui lòng nhập thông tin mới:");
            sachCanCapNhat.nhap();
            System.out.println("Cập nhật sách có Mã Sách " + maSach + " thành công!");
        } else {
            System.out.println("Không tìm thấy sách với Mã Sách: " + maSach + ". Cập nhật thất bại.");
        }
    }

    public void hienThiDanhSach() {
        System.out.println("\n--- HIỂN THỊ DANH SÁCH TẤT CẢ SÁCH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách sách hiện đang trống.");
            return;
        }

        for (Sach sach : danhSachSach) {
            sach.hienThiThongTin();
            System.out.println("----------------------------------------");
        }
    }
    public void themSachCoSan(Sach s) {
        danhSachSach.add(s);
    }
}