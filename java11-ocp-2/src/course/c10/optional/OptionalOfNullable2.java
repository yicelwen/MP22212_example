package course.c10.optional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class OptionalOfNullable2 {

	public static void main(String[] args) {
		
		List<User> userList = List.of(new User("jim"), new User("duke"));
		List<User> emptyList = List.of();
		List<User> nullList = null;
		
		// 空集合可以，null不行
		printFirstUserName1(userList);
		printFirstUserName1(emptyList);
		printFirstUserName1(nullList);
		System.out.println("-------------------------");

		// 空集合不行，null可以
		printFirstUserName2(userList);
		printFirstUserName2(emptyList);
		printFirstUserName2(nullList);
		System.out.println("-------------------------");

		// 空集合可以，null可以
		printFirstUserName3(userList);
		printFirstUserName3(emptyList);
		printFirstUserName3(nullList);
		System.out.println("-------------------------");

	}
	
	private static void printFirstUserName1(List<User> users) {
		try {
			String name = 
					users.stream()
					.findFirst()
					.map(User::getName)
					.orElse("user not found");
			System.out.println("Option1 = " + name);
		} catch (Exception e) {
			System.err.println("Option1 throws " + e.getClass());
		//	e.printStackTrace();
		}
	}

	
	private static void printFirstUserName2(List<User> users) {
		try {
			String name = 
					Optional.ofNullable(users)
					.map(list -> list.get(0))
					.map(User::getName)
					.orElse("user not found");
			System.out.println("Option2 = " + name);
		} catch (Exception e) {
			System.err.println("Option2 throws " + e.getClass());
		//	e.printStackTrace();
		}
	}
	
	
	private static void printFirstUserName3(List<User> users) {
		try {
			String name = 
					Optional.ofNullable(users)		// Optional<List<User>>
					.stream()						// Stream<List<User>>
		            .flatMap(Collection::stream)	// Stream<User>
		            .findFirst()					// Optional<User> 
		            .map(User::getName)				// Optional<String>
		            .orElse("user not found");
			System.out.println("Option3 = " + name);
		} catch (Exception e) {
			System.err.println("Option3 throws " + e.getClass());
		//	e.printStackTrace();
		}
	}


	private static void printFirstUserName4(List<User> users) {
		try {
			String name = 
					Optional.ofNullable(users)					// Optional<List<User>> 
					.map(list -> list.stream().findFirst())		// Optional<Optional<User>> 
					.filter(Optional::isPresent)				// Optional<Optional<User>> 
					.map(Optional::get)							// Optional<User>
					.map(User::getName)							// Optional<String>
					.orElse("user not found");
			System.out.println("Option3 = " + name);
		} catch (Exception e) {
			System.err.println("Option3 throws " + e.getClass());
		}
	}


}
