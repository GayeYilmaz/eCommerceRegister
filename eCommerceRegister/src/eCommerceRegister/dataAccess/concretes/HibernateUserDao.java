package eCommerceRegister.dataAccess.concretes;

import java.util.List;

import eCommerceRegister.dataAccess.abstracts.UserDao;
import eCommerceRegister.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	@Override
	public void add(User user) {
		
	    System.out.println("Hibernate ile "+user.getName()+" "+user.getSurname()+" eklendi.");
		
		
	}

	@Override
	public User get(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
