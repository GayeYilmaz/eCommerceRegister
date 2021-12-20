package eCommerceRegister.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceRegister.core.abstracts.RegisterService;
import eCommerceRegister.dataAccess.abstracts.UserDao;
import eCommerceRegister.entities.concretes.User;
import eCommerceRegister.googleRegister.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements RegisterService{
	UserDao userDao;
	public GoogleRegisterManagerAdapter() {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean register(User user) {

		GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
		if(passwordCheck(user.getPassword())&& emailCheck(user)) {
			googleRegisterManager.register(user);
			if(user.getRegisteredUsers()!=null) {
				user.getRegisteredUsers().add(user);
				
			
			}
			
			
		}
		else {
			System.out.println("Regsiter gone wrong control your information and try again!");
			return false;
		}
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

}
