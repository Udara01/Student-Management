package com.example.Student.Management.Service;
import com.example.Student.Management.Model.StudentModel;
import org.springframework.data.domain.Page;

public interface StudentService {
    StudentModel createStudent(StudentModel student);
    //List<Student> getAllStudents();
    Page<StudentModel> getAllStudents(int page, int size, String sortBy, String direction);

    StudentModel getStudentById(Long id);
    StudentModel updateStudent(Long id, StudentModel student);
    void deleteStudent(Long id);
    Page<StudentModel> searchStudents(String keyword, int page, int size, String sortBy, String direction);
}
