package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

				int soluong = rs.getInt("gia");
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
}
