package bo;

import dao.billdao;

import java.util.ArrayList;

import bean.billbean;

public class billbo {
	  billdao ldao=new billdao();
	   ArrayList<billbean> ds;
	   public  ArrayList<billbean> getbill(String tdn){
		   ds=ldao.getbill(tdn);
		   return ds;
	   }
}
