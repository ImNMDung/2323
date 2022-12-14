package bo;

import java.util.ArrayList;

import bean.lichsubean;
import dao.lichsuadmindao;


public class lichsuboadminbo {

	lichsuadmindao lsdao = new lichsuadmindao();
	ArrayList<lichsubean> ls;
	public ArrayList<lichsubean> getlichsu(){
		ls=lsdao.getlichsu();
		return ls;
	}

}