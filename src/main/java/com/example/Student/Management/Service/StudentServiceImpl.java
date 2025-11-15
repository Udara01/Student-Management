package com.example.Student.Management.Service;
import com.example.Student.Management.Model.StudentModel;
import com.example.Student.Management.reposotory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class  StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentModel createStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    /*public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }*/

    public Page<StudentModel> getAllStudents(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable);
    }

    @Override
    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public StudentModel updateStudent(Long id, StudentModel studentDetails) {
        StudentModel existingStudent = getStudentById(id); // reuse method

        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setCourse(studentDetails.getCourse());
        existingStudent.setAge(studentDetails.getAge());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentModel existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }


    public Page<StudentModel> searchStudents(String keyword, int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return studentRepository.findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(
                keyword, keyword, pageable);
    }
}
