package course.c10.optional;

import java.util.Optional;

public class OptionalOfNullable {

	public static void main(String[] args) {

		User u1 = new User("Jim");
		System.out.println(findUserName(u1, "impossible to orElse"));
		
		User u2 = new User(null);
		System.out.println(findUserName(u2, "name not found"));

		User u3 = null;
		System.out.println(findUserName(u3, "user not found"));
	}

	private static String findUserName(User user, String orElse) {
		return Optional.ofNullable(user)		// Optional<User>
				.map(User::getName)				// Optional<String>
				.orElse(orElse);				// String
	}

}
