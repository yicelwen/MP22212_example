package course.c10.stream;

import java.util.List;

public class Blog {
	private String authorName;
	private List<String> comments;
	private Integer age;

	public Blog(String authorName, String... comments) {
		super();
		this.authorName = authorName;
		this.comments = List.of(comments);
	}

	public String getAuthorName() {
		return authorName;
	}

	public List<String> getComments() {
		return comments;
	}
	
	@Override
	public String toString() {
		return "Blog [authorName=" + authorName + ", comments=" + comments + "]";
	}

	static List<Blog> getBlogs() {
		Blog blog1 = new Blog("Duke", "Nice", "Very Nice", "Great");
		Blog blog2 = new Blog("Gary", "Not bad", "Ok", "Just fine", "all right");
		return List.of(blog1, blog2);
	}

	public Integer getAge() {
		return age;
	}


}
