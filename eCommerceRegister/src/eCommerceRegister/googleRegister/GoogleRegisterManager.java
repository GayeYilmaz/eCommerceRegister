package eCommerceRegister.googleRegister;

import eCommerceRegister.entities.concretes.User;

public class GoogleRegisterManager {
	public void register(User user) {
		System.out.println(user.getName()+" "+user.getSurname()+" registered with Google");
		
	}

}
