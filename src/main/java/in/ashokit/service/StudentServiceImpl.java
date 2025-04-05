/*

🔹 Issues & Improvements:
1️⃣ Fix deleteStudent Return Type

Currently: Returns a String message.

Best Practice: Change to void, as DELETE operations usually don’t return messages.

Why? This aligns with REST principles and lets the controller return 204 No Content.

2️⃣ Fix upsertStudent Condition (std.getId() == null)

If std.getId() == null, it means a new record is being inserted, but save() sets the ID automatically.

Instead, check repository.existsById(std.getId()) to determine if it’s an insert or update.

3️⃣ Method Naming Consistency

getStudentByBranch(String str) → getStudentsByBranch(String branch)

getStudentByCGPA(Double cgpa) → getStudentsByCGPA(Double cgpa)




 */

package in.ashokit.service;

import in.ashokit.entity.Student;
import in.ashokit.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    // Constructor Injection
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String upsertStudent(Student std) {
        boolean exists = (std.getId() != null) && repository.existsById(std.getId());
        repository.save(std);
        return exists ? "Record Updated" : "Record Inserted";
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        repository.deleteById(studentId);
    }

    @Override
    public List<Student> getStudentsByBranch(String branch) {
        return repository.findByBranch(branch);
    }

    @Override
    public List<Student> getStudentsByCGPA(Double cgpa) {
        return repository.findByCgpaGreaterThan(cgpa);
    }

    public List<Student> updateStdCGPaByBranch(String branch, Double cgpa) {
        List<Student> students = repository.findByBranch(branch);
        for (Student student : students) {
            student.setCgpa(cgpa);
        }
        return repository.saveAll(students);
    }


}
