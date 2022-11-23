package bo;

import java.util.ArrayList;

import bean.sachbean;
import bean.sinhvienbean;

import dao.sinhviendao;

public class sinhvienbo {
	ArrayList<sinhvienbean> ds;
	sinhviendao sdao= new sinhviendao();
	public ArrayList<sinhvienbean> getsinhvien(){
		ds=sdao.getsinhvien();
		return ds;
	}

	public ArrayList<sinhvienbean> TimMa(String masv){
		ArrayList<sinhvienbean> tam= new ArrayList<sinhvienbean>();
		ds = sdao.getsinhvien();
		for(sinhvienbean s: ds)
			if(s.getMasingvien().equals(masv))
				tam.add(s);
		return tam;
	}
	public ArrayList<sinhvienbean> Tim(String key){
		ArrayList<sinhvienbean> tam= new ArrayList<sinhvienbean>();
		for(sinhvienbean s: ds)
			if(s.getHoten().toLowerCase().contains(
					key.toLowerCase())||
			s.getDiachi().toLowerCase().contains(
					key.toLowerCase())||
			s.getMamon().toLowerCase().contains(
					key.toLowerCase())||
			s.getMasingvien().toLowerCase().contains(
					key.toLowerCase()))
				tam.add(s);
		return tam;
	}
}