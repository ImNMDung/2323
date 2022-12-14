package bo;

import java.util.ArrayList;

import bean.lichsubean;
import bean.loaibean;
import dao.lichsudao;
import dao.loaidao;

public class lichsubo {
	lichsudao lsdao = new lichsudao();
	ArrayList<lichsubean> ls;
	public ArrayList<lichsubean> getlichsu(int makhDangNhap){
		ls=lsdao.getlichsu(makhDangNhap);
		
		
		return ls;
	}

}