package bo;

import java.util.ArrayList;

import bean.monhocbean;
import dao.monhocdao;

public class monhocbo {
	ArrayList<monhocbean> ds;
	monhocdao sdao= new monhocdao();
	public ArrayList<monhocbean> getmonhoc(){
		ds=sdao.getmonhoc();
		return ds;
}}
