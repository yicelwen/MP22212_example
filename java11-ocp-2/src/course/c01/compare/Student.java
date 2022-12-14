package course.c01.compare;

public class Student implements Comparable<Student> {
	
	private String name;
	private long id;
	private double score;

	public Student(String name, long id, double score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public double getScore() {
		return this.score;
	}

	public String toString() {
		return this.name + "\t" + this.id + "\t" + this.score;
	}

	@Override
	public int compareTo(Student s) {
		// use method dedication
		int sortById = Long.valueOf(this.id).compareTo(s.id);
		int sortByName = this.name.compareTo(s.getName());
		int sortByScore = Double.valueOf(this.score).compareTo(s.score);

		return sortById;
	}
}