package in.ashokit.repo;

import in.ashokit.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByBranch(String branch);

    // ✅ Find students with CGPA greater than a given value
    List<Student> findByCgpaGreaterThan(Double cgpa);








}

