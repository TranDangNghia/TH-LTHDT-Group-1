import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public boolean xoaSach(String maSach) {
        return danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
    }

    public boolean capNhatSach(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSachSach.set(i, sachMoi);
                return true;
            }
        }
        return false;
    }

    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }
    }
}
