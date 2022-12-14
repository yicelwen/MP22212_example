package course.c01.compare;

import java.util.*;

class NameSorter implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

class ScoreSorter implements Comparator<Student> {
	public int compare(Student s1, Student s2) {		
		return Double.valueOf(s1.getScore()).compareTo(s2.getScore());	
	}
}

public class TestComparator {
	
	private static void showList(List<Student> studentList) {
		for (int i=0; i<studentList.size(); i++) {
			System.out.println("index#" + i + ": " + studentList.get(i));
		}
	}

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>(3);
		studentList.add(new Student("Thomas", 1, 3.8));
		studentList.add(new Student("John", 2, 3.9));
		studentList.add(new Student("George", 3, 3.4));
		
		System.out.println("\n--- Original ------------ ");
		showList(studentList);		
		
		System.out.println("\n--- Sort by name ------------ ");
		Comparator<Student> sortName = new NameSorter();
		Collections.sort(studentList, sortName);
		showList(studentList);
		
		System.out.println("\n--- Sort by score ------------ ");
		Comparator<Student> sortScore = new ScoreSorter();
		Collections.sort(studentList, sortScore);
		showList(studentList);
	}
}
