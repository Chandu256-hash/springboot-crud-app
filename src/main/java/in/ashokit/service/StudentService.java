package in.ashokit.service;

import in.ashokit.entity.Student;
import java.util.List;

public interface StudentService {

    String upsertStudent(Student std);  // Insert or Update Student

    List<Student> getAllStudents();  // Retrieve all students

    void deleteStudent(Integer studentId);  // Delete student by ID (return void for better practice)

    List<Student> getStudentsByBranch(String branch);  // Find students by branch

    List<Student> getStudentsByCGPA(Double cgpa);  // Find students with CGPA > given value

    List<Student> updateStdCGPaByBranch(String branch, Double cgpa);
}
