package com.ph32395.khopro.Database;

public class DataSql {
    public static final String INSERT_TB_NHANVIEN = "INSERT INTO NhanVien(maNhanVien, hoTen,tuoi,gioiTinh,soDienThoai, matKhau, loaiTaiKhoan) VALUES" +
            "('admin', 'Nguyen Toan',18,'Nam','0862613348', 'admin', 'Admin')," +
            "('nhanvien1', 'NguyenTriToan',18,'Nữ','0862613348', '12345678', 'Admin')," +
            "('nhanvien2', 'Toan',18,'Nữ','0862613348', '12345678', 'NhanVien'),"+
            "('a','a',18,'Nam','0862613348','a','a')";

    public static final String INSERT_TB_DANHMUC = "INSERT INTO DanhMuc(tenDanhMuc) VALUES" +
            "('Món Chính')," +
            "('Món Phụ')," +
            "('Đồ Uống')";

    public static final String INSERT_TB_MONAN = "INSERT INTO MonAn(tenMonAn, id_DanhMuc, id_GiamGia, giaTien) VALUES" +
            "('Bún Chả Băm', 1, 1, 50000.0)," +
            "('Nem Hải Sản', 2, 2, 100000.0)," +
            "('Bún Chả Chan', 1, NULL, 60000.0),"+
            "('Coca cola',3,4,15000.0)";

    public static final String INSERT_TB_BANAN = "INSERT INTO BanAn(soBan) VALUES" +
            "(1)," +
            "(2)," +
            "(3)";

    public static final String INSERT_TB_HOADON = "INSERT INTO HoaDon(id_MonAn, id_NhanVien, id_BanAn, id_GiamGia, soLuong, ngayGio, kieuThanhToan, tongTien) VALUES" +
            "(1, 'nhanvien2', 1, 1, 2, '2023-11-27 10:30:00', 'Tiền mặt',  50000.0)," +
            "(2, 'nhanvien1', 2, 2, 1, '2023-11-27 12:45:00', 'Chuyển Khoản',  90000.0)";

    public static final String INSERT_TB_GIAMGIA = "INSERT INTO GiamGia(maGiamGia, phanTramGiam) VALUES" +
            "('GG1', 10)," +
            "('GG2', 20)," +
            "('GG3', 15),"+
            "('GG4',33)";
    public static final String INSERT_TB_CHITIETHOADON = "INSERT INTO ChiTietHoaDon (id_HoaDon, id_MonAn, soLuong,giaTien, tongTien) VALUES" +
            "(1, 1, 2,20000, 80000)," +
            "(2, 2, 1,10000, 40000)";
}

