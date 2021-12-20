package eCommerceRegister.business.abstracts;

import java.util.List;

import eCommerceRegister.entities.concretes.User;

public interface UserService {
	void register(User user);
	User get(String email,String password);
	List<User> getAll();
	void login(User user);
	

}
