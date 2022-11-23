package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import bean.UserBean;


public class UserDao {

	public UserBean ktdn(String tendn, String pass) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="select * from KhachHang where tendn=? and pass=?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs= cmd.executeQuery();
			UserBean kh=null;
			if(rs.next()) {//Dang nhap thanh cong
				int makh=rs.getInt("makh");
				String hoten=rs.getString("hoten");
				String diachi=rs.getString("diachi");
				String sodt=rs.getString("sodt");
				String email=rs.getString("email");
				kh= new UserBean(makh, hoten, diachi, sodt, email, tendn, pass);
			}
			rs.close();kn.cn.close();
			return kh;
		} catch (Exception e) {
			e.printStackTrace();return null;
		}
	}

	
	
	public boolean checkAccount(String userName, String email) {
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
	public boolean addAccount(UserBean user) throws Exception {
		ketnoi cs = new ketnoi();
		cs.ketnoi();
		String sql = "INSERT INTO KhachHang(tendn, pass) VALUES(?, ?)";
		try {
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, user.getTendan());
			cmd.setString(2, user.getPass());
			cmd.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cs.cn.close();
		return false;
	}
}
