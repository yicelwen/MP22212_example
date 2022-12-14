package course.c15.inherit;

import java.util.Map;

public final class PasswordManagerV3 {
	private Map<String, String> passwordRepo;

	public boolean isPasswordValid(String account, String password) {
		var pwd = passwordRepo.get(account);
		return password.equals(pwd);
	}

}
