package bo;

import dao.*;
import bean.*;

public class dangnhapadminbo {
	 dangnhapadmindao admindao = new dangnhapadmindao ();
	 
	public boolean checkAccountadm(String userName, String email) {
		return admindao.checkAccountadm(userName, email);
		}
	
	
	public dangnhapadminbean ktdnadm(String tendn, String pass) {
		return admindao.ktdnadm(tendn, pass);
	}
	
	
	
	
	
	
	
	
	
	
	
}
