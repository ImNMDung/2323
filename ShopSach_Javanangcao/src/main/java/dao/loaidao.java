package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import bean.loaibean;


public class loaidao {
   public ArrayList<loaibean> getloai(){
    	
    	 
    	 try {
    		 //Tao 1 mang luu all loai
        	 ArrayList<loaibean> ds= new ArrayList<loaibean>();
        	 
        	 //ketnoicosodu lieu
        	 ketnoi kn= new ketnoi();
        	 kn.ketnoi();

        	 String sql = "Select * from loai";
        		PreparedStatement cmd = kn.cn.prepareStatement(sql);
        		ResultSet rs=cmd.executeQuery();
        		 while (rs.next()) {
 					String maloai = rs.getString("maloai");

 					String tenloai = rs.getString("tenloai");
 					ds.add(new loaibean(maloai,tenloai));
 					
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
   
   
   
   public int  ThemLoai(String maloai ,String tenloai ) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="insert into loai(maloai,tenloai) values(?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
   
   public int  XoaLoai(String maloai  ) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="DELETE FROM loai WHERE maloai = ?  ";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
   public int  SuaLoai(String maloai,String tenloai) {
		try {
			ketnoi kn= new ketnoi();
			
			kn.ketnoi();
			String sql="UPDATE sach SET tensach = ?  , soluong = ? , gia = ? , anh = ? , tacgia = ? WHERE masach = ? ";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			
			cmd.setString(1, maloai);
			cmd.setString(2,tenloai);
			cmd.setString(3, maloai);
		
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	} 
}
