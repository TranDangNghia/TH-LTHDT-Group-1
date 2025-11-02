import java.io.*;
import java.util.*;

public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> danhSachSach;
    private Scanner scanner;

    public QuanLySachImpl() {
        this.danhSachSach = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public void themSach() {
        System.out.println("\n--- THÊM SÁCH MỚI ---");
        System.out.println("1. Sách Giáo Trình");
        System.out.println("2. Sách Tiểu Thuyết");
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
            case 1 -> newSach = new SachGiaoTrinh();
            case 2 -> newSach = new SachTieuThuyet();
            default -> {
                System.out.println("Lựa chọn không hợp lệ. Thêm sách thất bại.");
                return;
            }
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
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            System.out.println(ketQua); 
        } else {
            System.out.println(" Không tìm thấy sách có mã: " + maSach);
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
                System.out.println(" Đã xóa sách có mã " + maSach + " thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy sách với Mã Sách: " + maSach);
    }
    public void capNhatSach() {
        System.out.println("\n--- CẬP NHẬT SÁCH ---");
        System.out.print("Nhập Mã Sách cần cập nhật: ");
        String maSach = scanner.nextLine();

        Sach sach = timKiemTheoMa(maSach);
        if (sach == null) {
            System.out.println(" Không tìm thấy sách với Mã Sách: " + maSach);
            return;
        }

        System.out.println("Tìm thấy sách:\n" + sach);

        System.out.println("\nChọn thông tin cần cập nhật (cách nhau bằng dấu cách):");
        System.out.println("1. Tiêu đề");
        System.out.println("2. Tác giả");
        System.out.println("3. Năm xuất bản");
        System.out.println("4. Số lượng");
        System.out.println("5. Giá cơ bản");
        System.out.println("6. Vị trí trong kho");
        System.out.print("Nhập lựa chọn (vd: 1 3 5): ");

        String[] luaChon = scanner.nextLine().split("\\s+");

        for (String lc : luaChon) {
            try {
                int chon = Integer.parseInt(lc);
                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhập tiêu đề mới: ");
                        sach.settieuDe(scanner.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nhập tác giả mới: ");
                        sach.settacGia(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhập năm xuất bản mới: ");
                        sach.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                    }
                    case 4 -> {
                        System.out.print("Nhập số lượng mới: ");
                        sach.setSoLuong(Integer.parseInt(scanner.nextLine()));
                    }
                    case 5 -> {
                        System.out.print("Nhập giá cơ bản mới: ");
                        sach.setgiaCoBan(Double.parseDouble(scanner.nextLine()));
                    }
                    case 6 -> {
                        System.out.print("Nhập vị trí mới trong kho: ");
                        String viTriMoi = scanner.nextLine();
                        sach.setviTri(viTriMoi);
                        System.out.println(" Đã chuyển sách \"" + sach.gettieuDe() + "\" đến khu vực: " + viTriMoi);
                    }
                    default -> System.out.println(" Bỏ qua lựa chọn không hợp lệ: " + lc);
                }
            } catch (NumberFormatException e) {
                System.out.println(" Bỏ qua lựa chọn không hợp lệ: " + lc);
            }
        }

        System.out.println(" Đã cập nhật thông tin sách thành công!");
    }

    public void hienThiDanhSach() {
        System.out.println("\n--- DANH SÁCH TẤT CẢ SÁCH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách sách trống.");
            return;
        }

        for (Sach sach : danhSachSach) {
            System.out.println(sach);
            System.out.println("----------------------------------------");
        }
    }
    public void themSachCoSan(Sach s) {
        danhSachSach.add(s);
    }
}


