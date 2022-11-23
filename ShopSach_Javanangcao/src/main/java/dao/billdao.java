package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.billbean;


public class billdao {
	public ArrayList<billbean> getbill(String tdn){
    	
   	 
   	 try {
   		 //Tao 1 mang luu all loai
       	 ArrayList<billbean> ds= new ArrayList<billbean>();
       	 
       	 //ketnoicosodu lieu
       	 ketnoi kn= new ketnoi();
       	 kn.ketnoi();

       	 String sql = "SELECT h.MaHoaDon, k.hoten, h.NgayMua\r\n"
       	 		+ "FROM hoadon AS h\r\n"
       	 		+ "	JOIN KhachHang AS k ON k.makh = h.makh\r\n"
       	 		+ "WHERE k.tendn = ? AND h.damua = 1";
       		PreparedStatement cmd = kn.cn.prepareStatement(sql);
       		cmd.setString(1,tdn);
       		ResultSet rs=cmd.executeQuery();
       		 while (rs.next()) {
					String maHoaDon = rs.getString("MaHoaDon");
					String makh = rs.getString("hoten");
					String ngayMua = rs.getString("NgayMua");
					ds.add(new billbean(maHoaDon,makh,ngayMua));
					
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