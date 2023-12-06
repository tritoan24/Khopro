package com.ph32395.khopro.Database;

public class DataSql {
    public static final String INSERT_TB_NHANVIEN = "INSERT INTO NhanVien(maNhanVien, hoTen,tuoi,gioiTinh,soDienThoai, matKhau, loaiTaiKhoan) VALUES" +
            "('admin', 'Nguyen Toan',18,'Nam','0862613348', '123456789', 'Admin')," +
            "('nhanvien1', 'NguyenTriToan',18,'Nữ','0862613348', '123456789', 'Admin')," +
            "('nhanvien2', 'Toan',18,'Nữ','0862613348', '123456789', 'NhanVien'),"+
            "('a','a',18,'Nam','0862613348','123456789','a')";

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
    public static final String INSERT_TB_GIAMGIA = "INSERT INTO GiamGia(maGiamGia, phanTramGiam, soLuotDung) VALUES" +
            "('GG1', 10, 1)," +
            "('GG2', 20, 0)," +
            "('GG3', 15, 1),"+
            "('GG4',33, 2)";
    public static final String INSERT_TB_HOADON = "INSERT INTO HOADON(id_HoaDon, id_NhanVien, soBan, ngayGio, kieuThanhToan, tongTien) VALUES " +
            "(1, 'admin', 1, '2023-01-01 12:00:00', 'Cash', 50000.0)," +
            "(2, 'nhanvien1', 2, '2023-01-02 14:30:00', 'Card', 100000.0)," +
            "(3, 'nhanvien2', 3, '2023-01-03 18:45:00', 'Cash', 60000.0)," +
            "(4, 'a', 1, '2023-01-04 20:00:00', 'Card', 15000.0)";


}

