package course.c15.access;

import java.util.Map;

public class PasswordManagerV2 {
	private Map<String, String> passwordRepo;

	public boolean isPasswordValid(String account, String password) {
		var pwd = passwordRepo.get(account);
		return password.equals(pwd);
	}

}
