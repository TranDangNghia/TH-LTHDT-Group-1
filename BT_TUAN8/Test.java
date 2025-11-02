package BT_Chương;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySachImpl qlSach = new QuanLySachImpl();

        Sach s1 = new SachGiaoTrinh("S01", "Lập Trình Java", "Nguyễn Văn A", 2020, 10, 50000.0,"ke 61", "Công nghệ thông tin", "Đại học");
        Sach s2 = new SachGiaoTrinh("S02", "Cấu Trúc Dữ Liệu", "Trần Thị B", 2019, 5, 60000.0,"tu duoi 12", "Tin học", "Cao đẳng");
        Sach s3 = new SachTieuThuyet("S03", "Thuật Toán Cơ Bản", "Lê Văn C", 2021, 7, 55000.0,"tu_09", "Phiêu lưu", true);

        qlSach.themSachCoSan(s1);
        qlSach.themSachCoSan(s2);
        qlSach.themSachCoSan(s3);

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật sách");
            System.out.println("4. Tìm kiếm sách theo mã");
            System.out.println("5. Xóa sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> qlSach.hienThiDanhSach();

                case 2 -> qlSach.themSach();

                case 3 -> qlSach.capNhatSach();

                case 4 -> qlSach.timKiemSach();

                case 5 -> qlSach.xoaSach();

                case 0 -> System.out.println("Thoát chương trình.");

                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }

        } while (choice != 0);

        sc.close();
    }
}
