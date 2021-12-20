package eCommerceRegister;

import java.util.ArrayList;
import java.util.List;

import eCommerceRegister.business.abstracts.UserService;
import eCommerceRegister.business.concretes.UserManager;
import eCommerceRegister.core.concretes.EmailRegisterManager;
import eCommerceRegister.core.concretes.EmailVerificationManager;
import eCommerceRegister.core.concretes.GoogleRegisterManagerAdapter;
import eCommerceRegister.dataAccess.concretes.HibernateUserDao;
import eCommerceRegister.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		List<User> registeredUser = new ArrayList<User>();
		UserService userService = new UserManager(new HibernateUserDao() ,new GoogleRegisterManagerAdapter(),new EmailVerificationManager());
		UserService userServicex = new UserManager(new HibernateUserDao() ,new EmailRegisterManager(),new EmailVerificationManager());
		User user1 = new User("Gaye","Yýlmaz","gaye3545@gmail.com","Gaye1234",registeredUser);
		userService.register(user1);
		User user2 = new User("Elif","Yýlmaz","gaye354558@gmail.com","Elif1234",registeredUser);
		userServicex.register(user2);
		for(User userx:registeredUser) {
			System.out.println(userx.getEmail());
		}

	}

}
