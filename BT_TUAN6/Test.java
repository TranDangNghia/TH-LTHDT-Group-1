import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        QuanLySach quanLy = new QuanLySach();


        Sach s1 = new Sach("S01", "Lập Trình Java", "Nguyễn Văn A", 2020, 10);
        Sach s2 = new Sach("S02", "Cấu Trúc Dữ Liệu", "Trần Thị B", 2019, 5);
        Sach s3 = new Sach("S03", "Thuật Toán Cơ Bản", "Lê Văn C", 2021, 7);
        quanLy.themSachCoSan(s1);
        quanLy.themSachCoSan(s2);
        quanLy.themSachCoSan(s3);
        quanLy.hienThiDanhSach();


        Scanner mainScanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm kiếm sách theo Mã sách");
            System.out.println("4. Cập nhật thông tin sách theo Mã sách");
            System.out.println("5. Xóa sách theo Mã sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            if (mainScanner.hasNextInt()) {
                choice = mainScanner.nextInt();
                mainScanner.nextLine();

                switch (choice) {
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
                        System.out.println("Đã thoát chương trình. Tạm biệt!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } else {
                System.out.println("Lỗi nhập liệu. Vui lòng nhập số.");
                mainScanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);

        mainScanner.close();
    }
}