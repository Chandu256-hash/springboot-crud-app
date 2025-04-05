/*
*
* 🔹 Issues & Improvements:
1️⃣ Fix Path Conflict (/{studentBranch} may clash with /{studentId})

Since both branch name and student ID are dynamic @PathVariables, Spring may misinterpret them.

Solution: Change /getAllStudents to /all, and use /branch/{studentBranch} for clarity.

2️⃣ Use HttpStatus.NO_CONTENT (204) for Delete API

Instead of HttpStatus.OK (200), NO_CONTENT (204) is better when a resource is deleted.
* */

package in.ashokit.rest;

import in.ashokit.entity.Student;
import in.ashokit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")  // Base URL for all endpoints
public class StudentRestController {

    @Autowired
    private StudentService service;

    // ✅ Create or Update a Student
    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateStudent(@RequestBody Student std) {
        String msg = service.upsertStudent(std);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    // ✅ Get All Students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // ✅ Delete Student by ID (Better HTTP Status Code)
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        service.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content
    }

    // ✅ Get Students by Branch (Avoids Path Conflict)
    @GetMapping("/branch/{studentBranch}")
    public ResponseEntity<List<Student>> getStudentByBranch(@PathVariable String studentBranch) {
        List<Student> students = service.getStudentsByBranch(studentBranch);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // ✅ Get Students with CGPA greater than given value
    @GetMapping("/byCGPA")
    public ResponseEntity<List<Student>> getStudentByCGPA(@RequestParam("cgpa") Double cgpa) {
        List<Student> students = service.getStudentsByCGPA(cgpa);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @PutMapping("/{branch}")
    public ResponseEntity<List<Student>> updateStdCGPAByBranch(
            @PathVariable String branch,
            @RequestBody Double cgpa) {

        List<Student> students = service.updateStdCGPaByBranch(branch, cgpa);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }



}
