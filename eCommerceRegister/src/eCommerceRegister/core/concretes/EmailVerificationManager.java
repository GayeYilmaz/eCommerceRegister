package eCommerceRegister.core.concretes;

import eCommerceRegister.core.abstracts.VerificationService;
import eCommerceRegister.entities.concretes.User;

public class EmailVerificationManager implements VerificationService{
	@Override
	public void sendMessage(User user) {
		System.out.println("Message send the "+user.getEmail()+" mail address.Control your mail.");
		
	}

}
