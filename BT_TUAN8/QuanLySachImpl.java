package BT_Chương;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuanLySachImpl {
    private ArrayList<Sach> danhSachSach;
    private Scanner scanner;

    public QuanLySachImpl() {
        danhSachSach = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void themSach() {
        System.out.println("\n--- THÊM SÁCH MỚI ---");
        System.out.println("1. Sách Giáo Trình");
        System.out.println("2. Sách Tiểu Thuyết");
        System.out.print("Chọn loại sách muốn thêm: ");

        int chon;
        try {
            chon = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Lựa chọn không hợp lệ!");
            return;
        }

        Sach newSach = switch (chon) {
            case 1 -> new SachGiaoTrinh();
            case 2 -> new SachTieuThuyet();
            default -> null;
        };

        if (newSach == null) {
            System.out.println(" Lựa chọn không hợp lệ. Thêm sách thất bại!");
            return;
        }

        newSach.nhap();
        danhSachSach.add(newSach);
        System.out.println(" Đã thêm sách mới thành công!");
    }

    private Sach timKiemTheoMa(String maSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                return sach;
            }
        }
        return null;
    }

    public void timKiemSach() {
        System.out.println("\n--- TÌM KIẾM SÁCH ---");
        System.out.print("Nhập mã sách cần tìm: ");
        String maSach = scanner.nextLine();

        Sach ketQua = timKiemTheoMa(maSach);
        if (ketQua != null) {
            System.out.println(" Đã tìm thấy sách:");
            ketQua.hienThiThongTin();
        } else {
            System.out.println(" Không tìm thấy sách với mã: " + maSach);
        }
    }

    public void xoaSach() {
        System.out.println("\n--- XÓA SÁCH ---");
        System.out.print("Nhập mã sách cần xóa: ");
        String maSach = scanner.nextLine();

        Iterator<Sach> iterator = danhSachSach.iterator();
        while (iterator.hasNext()) {
            Sach sach = iterator.next();
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                iterator.remove();
                System.out.println(" Đã xóa sách có mã: " + maSach);
                return;
            }
        }
        System.out.println(" Không tìm thấy sách có mã: " + maSach);
    }

    public void capNhatSach() {
        System.out.println("\n--- CẬP NHẬT THÔNG TIN SÁCH ---");
        System.out.print("Nhập mã sách cần cập nhật: ");
        String maSach = scanner.nextLine();

        Sach sach = timKiemTheoMa(maSach);
        if (sach == null) {
            System.out.println(" Không tìm thấy sách có mã: " + maSach);
            return;
        }

        System.out.println("Sách cần cập nhật:");
        sach.hienThiThongTin();

        System.out.println("\nChọn thông tin cần cập nhật (có thể nhập nhiều, cách nhau bằng dấu cách):");
        System.out.println("1. Tiêu đề");
        System.out.println("2. Tác giả");
        System.out.println("3. Năm xuất bản");
        System.out.println("4. Số lượng");
        System.out.println("5. Giá cơ bản");
        System.out.println("6. Vị trí trong kho");
        System.out.print("Lựa chọn: ");

        String[] luaChon = scanner.nextLine().split("\\s+");
        for (String lc : luaChon) {
            switch (lc) {
                case "1" -> {
                    System.out.print("Nhập tiêu đề mới: ");
                    sach.setTieuDe(scanner.nextLine());
                }
                case "2" -> {
                    System.out.print("Nhập tác giả mới: ");
                    sach.setTacGia(scanner.nextLine());
                }
                case "3" -> {
                    System.out.print("Nhập năm xuất bản mới: ");
                    sach.setNamXuatBan(Integer.parseInt(scanner.nextLine()));
                }
                case "4" -> {
                    System.out.print("Nhập số lượng mới: ");
                    sach.setSoLuong(Integer.parseInt(scanner.nextLine()));
                }
                case "5" -> {
                    System.out.print("Nhập giá cơ bản mới: ");
                    sach.setGiaCoBan(Double.parseDouble(scanner.nextLine()));
                }
                case "6" -> {
                    System.out.print("Nhập vị trí mới trong kho: ");
                    String viTriMoi = scanner.nextLine();
                    sach.capNhatViTri(viTriMoi);
                }
                default -> System.out.println(" Bỏ qua lựa chọn không hợp lệ: " + lc);
            }
        }

        System.out.println(" Đã cập nhật sách thành công!");
    }

    public void hienThiDanhSach() {
        System.out.println("\n--- DANH SÁCH TẤT CẢ SÁCH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(" Danh sách trống.");
            return;
        }
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
            System.out.println("----------------------------------------");
        }
    }

    public void themSachCoSan(Sach s) {
        danhSachSach.add(s);
    }
    
}
