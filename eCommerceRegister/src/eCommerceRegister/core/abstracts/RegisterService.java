package eCommerceRegister.core.abstracts;

import eCommerceRegister.entities.concretes.User;

public interface RegisterService {
	boolean register(User user);
	boolean passwordCheck(String password);
	boolean emailCheck(User user);


}
