import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuanLySachImpl quanly = new QuanLySachImpl();
        quanly.themSach(new Sach("S001", "Lập trình Java", "Nguyễn Văn A", 2020, 10, 150000) {
            @Override
            public double tinhGiaBan() {
                return 150000;
            }

            @Override
            public void hienThiThongTin() {
                System.out.println(this);
            }
        });
        quanly.themSach(new SachGiaoTrinh("SGT001", "Toán Cao Cấp", "Trần Thị B", 2018, 5, "Toán", "Nâng cao", 120000));
        quanly.themSach(new SachTieuThuyet("STT001", "Harry Potter", "J.K. Rowling", 2005, 8, "Fantasy", true, 200000));
        int chon = -1;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm sách");
            System.out.println("4. Xóa sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số: ");
                sc.nextLine();
            }
            chon = sc.nextInt();
            sc.nextLine(); // clear bộ đệm

            switch (chon) {
                case 1 -> quanly.themSach();
                case 2 -> quanly.hienThiDanhSach();

                case 3 -> {
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maSach = sc.nextLine();
                    Sach s = quanly.timKiemSach(maSach);
                    if (s != null)
                        System.out.println("Tìm thấy: " + s);
                    else
                        System.out.println("Không tìm thấy sách!");
                }

                case 4 -> {
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maSach = sc.nextLine();
                    if (quanly.xoaSach(maSach))
                        System.out.println("✅ Xóa thành công!");
                    else
                        System.out.println("❌ Không tìm thấy sách để xóa!");
                }

                case 0 -> System.out.println("Thoát chương trình...");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);

        sc.close();
    }
}
