package eCommerceRegister.business.concretes;

import java.util.List;

import eCommerceRegister.business.abstracts.UserService;
import eCommerceRegister.core.abstracts.RegisterService;
import eCommerceRegister.core.abstracts.VerificationService;
import eCommerceRegister.dataAccess.abstracts.UserDao;
import eCommerceRegister.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
    private RegisterService registerService;
    private VerificationService verificationService;
   
	public UserManager(UserDao userDao,RegisterService registerService,VerificationService verificationService) {
		super();
		this.userDao = userDao;
		this.registerService=registerService;
		this.verificationService=verificationService;
				
	}

	@Override
	public void register(User user) {
		
		if(this.registerService.register(user)) {
			this.userDao.add(user);
			verificationService.sendMessage(user);
		}
			
			
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

	

	@Override
	public void login(User user) {
		for(User eachuser:user.getRegisteredUsers()) {
			if((user.getEmail().equals(eachuser.getEmail()) )&& (user.getPassword().equals(eachuser.getPassword()))) {
				System.out.println("You login successfully!");
				return;
			}
		}
	
			System.out.println("Somethig is wrong check your information and try again!");
		
	
		
	}

}
