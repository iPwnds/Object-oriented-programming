package Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Examen {
	int score;
}

class Student {
	String naam;
	int credits;
	List<Examen> examens;
}

class MasterStudent extends Student {
	
}

class StreamsTest {
	
	List<Student> students = null;

	@Test
	void test() {
		students.stream().allMatch(student -> student.examens.size() >= 5);
		students.stream().anyMatch(student -> student.examens.size() >= 5);
		List<Student> studentsWith5Exams = students.stream().filter(student -> student.examens.size() >= 5).collect(Collectors.toList());
		List<Student> studentsSorted = students.stream().sorted((s1, s2) -> Integer.compare(s1.credits, s2.credits)).collect(Collectors.toList());
		List<String> namen = students.stream().map(student -> student.naam).collect(Collectors.toList());
		int totaalCredits = students.stream().mapToInt(student -> student.credits).sum();
		int productCredits = students.stream().mapToInt(student -> student.credits).reduce(1, (c1, c2) -> c1 * c2);
		List<Examen> exams = students.stream().flatMap(student -> student.examens.stream()).collect(Collectors.toList());
		List<MasterStudent> masterStudents = students.stream().flatMap(s ->
			s instanceof MasterStudent ? Stream.of((MasterStudent)s) : Stream.of()
		).collect(Collectors.toList());
		Student student100credits = students.stream().filter(s -> s.credits >= 100).findAny().orElse(null);
		Student firstStudent100credits = students.stream().filter(s -> s.credits >= 100).findFirst().orElse(null);
		List<MasterStudent> firstTenMasterStudents = students.stream().flatMap(s ->
			s instanceof MasterStudent ? Stream.of((MasterStudent)s) : Stream.of()
		).limit(10).collect(Collectors.toList());
		Student[] studentsArray = students.stream().toArray(n -> new Student[n]);
	}

}