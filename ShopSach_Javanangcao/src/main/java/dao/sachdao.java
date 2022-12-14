package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.loaibean;
import bean.sachbean;

public class sachdao {
    public ArrayList<sachbean> getsach(){
  
    try {
		 //Tao 1 mang luu all loai
   	 ArrayList<sachbean> ds= new ArrayList<sachbean>();
   	 
   	 //ketnoicosodu lieu
   	 ketnoi kn= new ketnoi();
   	 kn.ketnoi();

   	 String sql = "Select * from sach";
   		PreparedStatement cmd = kn.cn.prepareStatement(sql);
   		ResultSet rs=cmd.executeQuery();
   		 while (rs.next()) {
				String masach = rs.getString("masach");

				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");

				int soluong = rs.getInt("soluong");
				String anh = rs.getString("anh");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach,  tensach,  tacgia,  soluong,  gia,  anh, maloai));
				
   		 }
   		 	// dongketnoi
   		 rs.close();
   		 kn.cn.close();
   		 
   	
   	 return ds;
   	 
   	 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;

	
	
	
	
}
    
    public int  ThemSach(String masach ,String tensach ,String soluong ,String gia ,String anh, String tacgia) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="insert into sach(masach,tensach,soluong,gia,anh,tacgia) values(?,?,?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setString(2, tensach);
			cmd.setString(3, soluong);
			cmd.setString(4, gia);
			cmd.setString(5, anh);
			cmd.setString(6, tacgia);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
    
    public int  XoaSach(String masach  ) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="DELETE FROM sach WHERE masach = ?  ";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
    public int  SuaSach(String masach ,String tensach ,String soluong ,String gia ,String anh, String tacgia ) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="UPDATE sach SET tensach = ?  , soluong = ? , gia = ? , anh = ? , tacgia = ? WHERE masach = ? ";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			
			cmd.setString(1, tensach);
			cmd.setString(2,soluong);
			cmd.setString(3, gia);
			cmd.setString(4, anh);
			cmd.setString(5, tacgia);
			cmd.setString(6, masach);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
    
}
