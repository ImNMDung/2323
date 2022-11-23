package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> getlichsu(int makhDangNhap){
		try {
			ArrayList<lichsubean> ds= new ArrayList<lichsubean>();
			//b1 kết nối vào csdl
			ketnoi kn = new ketnoi();
			kn.ketnoi();
			//b2 lấy dữ liệu về
			String sql ="SELECT dbo.KhachHang.makh, dbo.hoadon.NgayMua, dbo.hoadon.damua, dbo.ChiTietHoaDon.SoLuongMua, dbo.sach.tensach, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua * dbo.sach.gia AS thanhtien\r\n"
					+ "FROM     dbo.ChiTietHoaDon INNER JOIN\r\n"
					+ "                  dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN\r\n"
					+ "                  dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN\r\n"
					+ "                  dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach WHERE KhachHang.makh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makhDangNhap);
			ResultSet rs = cmd.executeQuery();
			//b3 đưa dữ liệu vào mảng ds
			while (rs.next()) {
				String makh = rs.getString("makh");
				String tensach = rs.getString("tensach");
				int soluongmua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("gia");
				int thanhtien = rs.getInt("thanhtien");
				Date ngaymua = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				ds.add(new lichsubean(makh,tensach,soluongmua,gia,thanhtien,ngaymua,damua));
			}
			//b4 đóng kết nối
			rs.close(); kn.cn.close();
			return ds;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	

	}
}
