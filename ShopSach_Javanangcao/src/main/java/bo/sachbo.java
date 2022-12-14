package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	ArrayList<sachbean> ds;
	sachdao sdao= new sachdao();
	public ArrayList<sachbean> getsach(){
		ds=sdao.getsach();
		return ds;
	}
public ArrayList<sachbean> TimMa(String maloai){
		ArrayList<sachbean> tam= new ArrayList<sachbean>();
		for(sachbean s: ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam;
	}
	public ArrayList<sachbean> Tim(String key){
		ArrayList<sachbean> tam= new ArrayList<sachbean>();
		for(sachbean s: ds)
			if(s.getTensach().toLowerCase().contains(
					key.toLowerCase())||
			s.getTacgia().toLowerCase().contains(
					key.toLowerCase())||
			s.getMaloai().toLowerCase().contains(
					key.toLowerCase()))
				tam.add(s);
		return tam;
	}
	public int  ThemSach(String masach ,String tensach ,String soluong ,String gia,String anh, String tacgia) {
		return sdao.ThemSach(masach,tensach,soluong,gia,anh,tacgia);		
	}
	public int XoaSach(String masach) {
		return sdao.XoaSach(masach);		
	}
	public int SuaSach(String masach ,String tensach ,String soluong ,String gia,String anh, String tacgia) {
		return sdao.SuaSach(masach,tensach,soluong,gia,anh,tacgia);		
	}
	
}
