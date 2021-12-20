package eCommerceRegister.dataAccess.abstracts;

import java.util.List;

import eCommerceRegister.entities.concretes.User;

public interface UserDao {
	void add(User user);
	User get(String email,String password);
	List<User> getAll();

}
