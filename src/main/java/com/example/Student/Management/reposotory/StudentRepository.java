package com.example.Student.Management.reposotory;
import com.example.Student.Management.Model.StudentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    Page<StudentModel> findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(
            String nameKeyword, String courseKeyword, Pageable pageable);
}
