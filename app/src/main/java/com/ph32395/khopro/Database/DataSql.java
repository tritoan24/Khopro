package com.ph32395.khopro.Database;

public class DataSql {
    public static final String INSERT_TB_NHANVIEN = "INSERT INTO NhanVien(maNhanVien, hoTen,tuoi,gioiTinh,soDienThoai, matKhau, loaiTaiKhoan) VALUES" +
            "('admin', 'Nguyen Toan',18,'nam','0862613348', 'admin', 'Admin')," +
            "('nhanvien1', 'NguyenTriToan',18,'nam','0862613348', '12345678', 'Admin')," +
            "('nhanvien2', 'Toan',18,'nam','0862613348', '12345678', 'NhanVien'),"+
            "('a','a',18,'nam','0862613348','a','a')";

    public static final String INSERT_TB_DANHMUC = "INSERT INTO DanhMuc(tenDanhMuc) VALUES" +
            "('Món Chính')," +
            "('Món Phụ')," +
            "('Đồ Uống')";

    public static final String INSERT_TB_MONAN = "INSERT INTO MonAn(tenMonAn, id_DanhMuc, id_GiamGia, giaTien) VALUES" +
            "('Bún Chả Băm', 1, 1, 50000.0)," +
            "('Nem Hải Sản', 2, 2, 25000.0)," +
            "('Bún Chả Chan', 1, NULL, 60000.0)";

    public static final String INSERT_TB_BANAN = "INSERT INTO BanAn(soBan) VALUES" +
            "(1)," +
            "(2)," +
            "(3)";

    public static final String INSERT_TB_HOADON = "INSERT INTO HoaDon(id_MonAn, id_NhanVien, id_BanAn, id_GiamGia, soLuong, ngayGio, giaTien, kieuThanhToan, tongTien) VALUES" +
            "(1, 'nhanvien2', 1, 1, 2, '2023-11-27 10:30:00', 100000, 'Tiền mặt', 180000)," +
            "(2, 'nhanvien1', 2, 2, 1, '2023-11-27 12:45:00', 75000, 'Chuyển Khoản', 75000)";

    public static final String INSERT_TB_GIAMGIA = "INSERT INTO GiamGia(maGiamGia, phanTramGiam) VALUES" +
            "('GG1', 10)," +
            "('GG2', 20)," +
            "('GG3', 15)";
}

