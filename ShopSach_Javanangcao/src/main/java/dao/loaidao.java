package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
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
}
