import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class QuanLySachImpl implements IQuanLySach{
    private ArrayList<Sach> danhSachSach;
    private Scanner scanner;
    public QuanLySachImpl() {
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
        System.out.println("Tìm thấy sách:");
        sachCanCapNhat.hienThiThongTin();

        System.out.println("\nChọn thông tin cần cập nhật (có thể chọn nhiều, cách nhau bằng dấu cách):");
        System.out.println("1. Tiêu đề");
        System.out.println("2. Tác giả");
        System.out.println("3. Năm xuất bản");
        System.out.println("4. Số lượng");
        System.out.println("5. Giá bán");
        System.out.println("6. Vị trí trong kho");
        System.out.print("Nhập lựa chọn (vd: 1 3 5): ");

        String[] luaChon = scanner.nextLine().split("\\s+");

        for (String lc : luaChon) {
            int chon;
            try {
                chon = Integer.parseInt(lc);
            } catch (NumberFormatException e) {
                System.out.println("Bỏ qua lựa chọn không hợp lệ: " + lc);
                continue;
            }

            switch (chon) {
                case 1:
                    System.out.print("Nhập tiêu đề mới: ");
                    sachCanCapNhat.settieuDe(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập tác giả mới: ");
                    sachCanCapNhat.settacGia(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Nhập năm xuất bản mới: ");
                    sachCanCapNhat.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhập số lượng mới: ");
                    sachCanCapNhat.setSoLuong(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập giá bán mới: ");
                    sachCanCapNhat.setgiaCoBan(Double.parseDouble(scanner.nextLine()));
                    break;
                case 6:
                    System.out.print("Nhập vị trí mới trong kho: ");
                    String viTriMoi = scanner.nextLine();
                    sachCanCapNhat.setviTri(viTriMoi);
                    System.out.println("Đã chuyển sách \"" 
                        + sachCanCapNhat.gettieuDe() 
                        + "\" đến khu vực: " + viTriMoi + ".");
                    break;
                default:
                    System.out.println("Bỏ qua lựa chọn không hợp lệ: " + chon);
                    break;
            }
        }

        System.out.println("✅ Đã cập nhật các thông tin được chọn thành công!");
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

