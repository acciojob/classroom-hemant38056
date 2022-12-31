package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // 1. Add a student
    public void addStudentService(Student student){
        studentRepository.addStudentRepository(student);
    }



    // 2. Add a teacher
    public void addTeacherService(Teacher teacher){
        studentRepository.addTeacherRepository(teacher);
    }



    // 3. Pair student and teacher
    public void addStudentTeacherPairService(String studentName, String teacherName){
        studentRepository.addStudentTeacherPairRepository(studentName, teacherName);
    }



    // 4. Get Student by student name
    public Student getStudentByNameService(String studentName){
        return studentRepository.getStudentByNameRepository(studentName);
    }



    // 5. Get Teacher by teacher name
    public Teacher getTeacherByNameService(String teacherName){
        return studentRepository.getTeacherByNameRepository(teacherName);
    }



    // 6. List of students name from given teacher name
    public List<String> getStudentsByTeacherNameService(String teacherName){
        return studentRepository.getStudentsByTeacherNameRepository(teacherName);
    }



    // 7. List of all students added
    public List<String> getAllStudentsService(){
        return studentRepository.getAllStudentsRepository();
    }



    // 8. Delete teacher and its students from records
    public void deleteTeacherByNameService(String teacherName){
        studentRepository.deleteTeacherByNameRepository(teacherName);
    }



    // 9. Delete All teachers and their students
    public void deleteAllTeachersService(){
        studentRepository.deleteAllTeachersRepository();
    }


}
