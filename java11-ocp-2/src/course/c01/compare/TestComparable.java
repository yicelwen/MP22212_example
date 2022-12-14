package course.c01.compare;

import java.util.*;

public class TestComparable {

	public static void main(String[] args) {
		System.out.println("----- Before Sort -----");
		Set<Student> studentList = new HashSet<>();
		studentList.add(new Student("John", 2, 3.9));
		studentList.add(new Student("Thomas", 1, 3.8));
		studentList.add(new Student("George", 3, 3.4));
		for (Student student : studentList) {
			System.out.println(student);
		}

		// if Student doesn't implement Comparable, 
		// will java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable
		System.out.println("----- After Sort -----");
		Set<Student> sortedStudentList = new TreeSet<>();
		sortedStudentList.add(new Student("John", 2, 3.9));
		sortedStudentList.add(new Student("Thomas", 1, 3.8));
		sortedStudentList.add(new Student("George", 3, 3.4));
		for (Student student : sortedStudentList) {
			System.out.println(student);
		}
	}
}