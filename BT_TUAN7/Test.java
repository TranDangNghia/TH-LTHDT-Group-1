package CODETH1.src;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        QuanLySach quanLy = new QuanLySach();

   
        Sach s1 = new SachGiaoTrinh("S01", "Lập Trình Java", "Nguyễn Văn A", 2020, 10, 50000.0, "Công nghệ thông tin", "Đại học");
        Sach s2 = new SachGiaoTrinh("S02", "Cấu Trúc Dữ Liệu", "Trần Thị B", 2019, 5, 60000.0, "Tin học", "Cao đẳng");
        Sach s3 = new SachTieuThuyet("S03", "Thuật Toán Cơ Bản", "Lê Văn C", 2021, 7, 55000.0, "Phiêu lưu", true);

        quanLy.themSachCoSan(s1);
        quanLy.themSachCoSan(s2);
        quanLy.themSachCoSan(s3);
        Scanner scanner = new Scanner(System.in);
        int chon=-1;
        do {
            System.out.println("\n========== CHƯƠNG TRÌNH QUẢN LÝ SÁCH ==========");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm kiếm sách theo Mã sách");
            System.out.println("4. Cập nhật thông tin sách theo Mã sách");
            System.out.println("5. Xóa sách theo Mã sách");
            System.out.println("0. Thoát chương trình");
            System.out.println("===============================================");
            System.out.print("Nhập lựa chọn của bạn: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
                scanner.nextLine();
                continue;
            }
             chon = scanner.nextInt();
            scanner.nextLine(); 

            switch (chon) {
                case 1:
                    quanLy.themSach();
                    break;
                case 2:
                    quanLy.hienThiDanhSach();
                    break;
                case 3:
                    quanLy.timKiemSach();
                    break;
                case 4:
                    quanLy.capNhatSach();
                    break;
                case 5:
                    quanLy.xoaSach();
                    break;
                case 0:
                    System.out.println(" Đã thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ, vui lòng thử lại!");
                    break;
            }

        } while (chon != 0);

        scanner.close();
    }
}
