package eCommerceRegister.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceRegister.core.abstracts.RegisterService;
import eCommerceRegister.dataAccess.abstracts.UserDao;
import eCommerceRegister.entities.concretes.User;

public class EmailRegisterManager implements RegisterService{
	 UserDao userDao;
		public EmailRegisterManager() {
			super();
			this.userDao = userDao;
		}
	@Override
	public boolean register(User user) {
		
			if(passwordCheck(user.getPassword()) && emailCheck(user) && nameCheck(user.getName()) && nameCheck(user.getSurname())) {
				System.out.println(user.getName() +" "+user.getSurname()+" registered with email and passowrd!");
			}else {
				System.out.println("Regsiter gone wrong control your information and try again!");
				return false;
			}
			
			user.getRegisteredUsers().add(user);
			
			return true;
		
		
	}

	@Override
	public boolean passwordCheck(String password) {
		if(password.length()>=6) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailCheck(User user) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if(user.getRegisteredUsers()!=null) {
			for(User eachUser : user.getRegisteredUsers()) {
				if(eachUser.getEmail()==user.getEmail()) {
					return false;
				}
			}
			
		}
		
		return matcher.matches();
	}
	
	public boolean nameCheck(String name) {
		if(name.length()>=2) {
			return true;
		}
		return false;
	}

}
