package eCommerceRegister.core.abstracts;

import eCommerceRegister.entities.concretes.User;

public interface VerificationService {
	void sendMessage(User user);

}
