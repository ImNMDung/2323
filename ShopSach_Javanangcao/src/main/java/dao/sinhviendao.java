package dao;

import java.util.ArrayList;


import bean.sinhvienbean;

public class sinhviendao {
	 public ArrayList<sinhvienbean> getsinhvien(){
	    	ArrayList<sinhvienbean> ds= new ArrayList<sinhvienbean>();
	    	ds.add(new sinhvienbean("20T1080029", "Nguyễn Mạnh Dũng", "Quảng Bình","20T1080029@husc.edu.vn",  "at1.jpg", "T11"));
	    	ds.add(new sinhvienbean("20T1080023", "Cù Lặc", "Huế","20T1080023@husc.edu.vn", "at2.jpg", "T11"));
	    	ds.add(new sinhvienbean("20T1380022", "Củ Khoai", "Huế","20T1380022@husc.edu", "at3.jpg", "T22"));
	    	ds.add(new sinhvienbean("1", "Pro Ma", "Quảng Bình","pr@gmai.com", "at4.jpg", "T22"));
	    	ds.add(new sinhvienbean("2", "HenNiA", "Lê Tứ","10", "at5.jpg", "T33"));
	    	ds.add(new sinhvienbean("3", "Okaasi", "Lê Tứ","10", "at6.jpg", "T44"));
	    	return ds;
	    }
}
