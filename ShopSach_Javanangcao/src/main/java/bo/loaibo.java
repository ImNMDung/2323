package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
   loaidao ldao=new loaidao();
   ArrayList<loaibean> ds;
   public  ArrayList<loaibean> getloai(){
	   ds=ldao.getloai();
	   return ds;
   }
   
   
   public int  ThemLoai(String maloai ,String tenloai) {
		return ldao.ThemLoai(maloai,tenloai);		
	}
	public int XoaLoai(String maloai) {
		return ldao.XoaLoai(maloai);		
	}
	public int SuaLoai(String maloai ,String tenloai) {
		return ldao.SuaLoai(maloai,tenloai );		
	}
}
