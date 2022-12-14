package course.c15.inherit;

import course.c15.access.PasswordManagerV2;

public class MaliciousPasswordManager extends PasswordManagerV2 {
	@Override
	public boolean isPasswordValid(String account, String password) {
		var valid = super.isPasswordValid(account, password);
		if (valid) {
			// email the password to Hacker Harry
		}
		return valid;
	}
}
