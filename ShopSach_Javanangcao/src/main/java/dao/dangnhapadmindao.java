package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bean.dangnhapadminbean;

public class dangnhapadmindao {

	
	public dangnhapadminbean ktdnadm(String tendn, String pass) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs= cmd.executeQuery();
			dangnhapadminbean dn=null;
			if(rs.next()) {//Dang nhap thanh cong
				
				String TenDangNhap=rs.getString("TenDangNhap");
				String MatKhau=rs.getString("MatKhau");
					int quyen=rs.getInt("quyen");
				dn= new dangnhapadminbean( tendn, pass,quyen);
			}
			rs.close();kn.cn.close();
			return dn;
		} catch (Exception e) {
			e.printStackTrace();return null;
		}
	}
	

	
	
	public boolean checkAccountadm(String userName, String email) {
		ketnoi cs = new ketnoi();
		try {
			cs.ketnoi();
			String sql = " SELECT * FROM DangNhap WHERE TenDangNhap=? or MatKhau=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, userName);
			cmd.setString(2, email);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return true; // duyet vong lap dau tien --
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}
}
