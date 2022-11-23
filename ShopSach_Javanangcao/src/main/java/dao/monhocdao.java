package dao;

import java.util.ArrayList;

import bean.monhocbean;


public class monhocdao {
	 public ArrayList<monhocbean> getmonhoc(){
	    	ArrayList<monhocbean> ds= new ArrayList<monhocbean>();
	    	ds.add(new monhocbean("T11", "Tin Đại Cương"));
	    	ds.add(new monhocbean("T22", "Toán Đại Cương"));
	    	ds.add(new monhocbean("T22", "Tiểu Thuyết Học" ));
	    	return ds;
	    }


}
