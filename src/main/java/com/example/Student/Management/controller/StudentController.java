package com.example.Student.Management.controller;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.example.Student.Management.Model.StudentModel;
import com.example.Student.Management.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // Marks this class as a REST controller -- To mark this as a restapi controller class
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 1️ Create Student (POST)
    @PostMapping
    public ResponseEntity<StudentModel> createStudent(@Valid @RequestBody StudentModel student) {
        StudentModel createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // 2️ Get All Students (GET)
    /*@GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }*/
    @GetMapping
    public ResponseEntity<Page<StudentModel>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Page<StudentModel> students = studentService.getAllStudents(page, size, sortBy, direction);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // 3️ Get Student by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Long id) {
        StudentModel student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // 4️ Update Student (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentModel student) {
        StudentModel updatedStudent = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // 5️ Delete Student (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }





    @GetMapping("/search")
    public ResponseEntity<Page<StudentModel>> searchStudents(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Page<StudentModel> students = studentService.searchStudents(keyword, page, size, sortBy, direction);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
