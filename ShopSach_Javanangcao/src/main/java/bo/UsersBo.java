package bo;

import dao.UserDao;
import bean.UserBean;

public class UsersBo {

	UserDao khdao = new UserDao();
	public boolean checkAccount(String userName, String email) {
		return khdao.checkAccount(userName, email);
	}
	public boolean addAccount(UserBean user) throws Exception {
		return khdao.addAccount(user);
	}
	
	public UserBean ktdn(String tendn, String pass) {
		return khdao.ktdn(tendn, pass);

}
}
