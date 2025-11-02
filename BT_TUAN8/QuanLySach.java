package BT_Chương;

import java.util.ArrayList;

public class QuanLySach {
    protected ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach sach) {
        if (sach == null) {
            System.out.println(" Sách không hợp lệ, không thể thêm.");
            return;
        }

        // Kiểm tra trùng mã sách
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                System.out.println(" Mã sách '" + sach.getMaSach() + "' đã tồn tại, không thể thêm trùng!");
                return;
            }
        }

        danhSachSach.add(sach);
        System.out.println(" Đã thêm sách: " + sach.getTieuDe());
    }

    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println(" Danh sách sách trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH TẤT CẢ CÁC SÁCH =====");
        for (Sach sach : danhSachSach) {
            sach.hienThiThongTin();
            System.out.println("---------------------------");
        }
    }

    public Sach timKiemTheoTieuDe(String tieuDe) {
        if (tieuDe == null || tieuDe.trim().isEmpty()) {
            System.out.println(" Tiêu đề không hợp lệ!");
            return null;
        }

        for (Sach sach : danhSachSach) {
            if (sach.getTieuDe().toLowerCase().contains(tieuDe.toLowerCase())) {
                System.out.println(" Đã tìm thấy sách: " + sach.getTieuDe());
                sach.hienThiThongTin();
                return sach;
            }
        }

        System.out.println(" Không tìm thấy sách với tiêu đề: " + tieuDe);
        return null;
    }

    public void xoaSach(String maSach) {
        if (maSach == null || maSach.trim().isEmpty()) {
            System.out.println(" Mã sách không hợp lệ.");
            return;
        }

        Sach sachCanXoa = null;
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                sachCanXoa = sach;
                break;
            }
        }

        if (sachCanXoa != null) {
            danhSachSach.remove(sachCanXoa);
            System.out.println(" Đã xóa sách có mã: " + maSach);
        } else {
            System.out.println(" Không tìm thấy sách có mã: " + maSach);
        }
    }

    public void capNhatSach(String maSach, String tieuDe, String tacGia, int soLuongMoi, double giaMoi) {
        if (maSach == null || maSach.trim().isEmpty()) {
            System.out.println(" Mã sách không hợp lệ!");
            return;
        }

        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                s.setTieuDe(tieuDe);
                s.setTacGia(tacGia);
                s.setSoLuong(soLuongMoi);
                s.setGiaCoBan(giaMoi);
                System.out.println("✅ Đã cập nhật sách có mã: " + maSach);
                return;
            }
        }

        System.out.println(" Không tìm thấy sách có mã: " + maSach);
    }

    public void hienThiSachTonKhoThap(int soLuongToiThieu) {
        System.out.println("\n===== SÁCH CÓ TỒN KHO DƯỚI " + soLuongToiThieu + " =====");
        boolean coSachThap = false;

        for (Sach sach : danhSachSach) {
            if (!sach.kiemTraTonKho(soLuongToiThieu)) {
                System.out.println("- " + sach.getTieuDe() + " (Số lượng: " + sach.getSoLuong() + ")");
                coSachThap = true;
            }
        }

        if (!coSachThap)
            System.out.println("✅ Tất cả sách đều đủ tồn kho.");
    }
}
