package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Repository
public class StudentRepository {
    HashMap<String, Student> studentRecord = new HashMap<>();
    HashMap<String, Teacher> teacherRecord = new HashMap<>();
    HashMap<String, List<String>> pairOfTeacherStudent = new HashMap<>();


    // 1. Add a student
    public void addStudentRepository(Student student){
        studentRecord.put(student.getName(), student);
    }

    // 2. Add a teacher
    public void addTeacherRepository(Teacher teacher){
        teacherRecord.put(teacher.getName(), teacher);
    }

    // 3. Pair student and teacher
    public void addStudentTeacherPairRepository(String studentName, String teacherName){
        if(studentRecord.containsKey(studentName) && teacherRecord.containsKey(teacherName)){
            if(!pairOfTeacherStudent.containsKey(teacherName)){
                pairOfTeacherStudent.put(teacherName, new ArrayList<>());
            }
            pairOfTeacherStudent.get(teacherName).add(studentName);
        }
    }


    // 4. Get Student by student name
    public Student getStudentByNameRepository(String studentName){
        return studentRecord.get(studentName);
    }

    // 5. Get Teacher by teacher name

    public Teacher getTeacherByNameRepository(String teacherName){
        return teacherRecord.get(teacherName);
    }

    // 6. List of students name from given teacher name
    public List<String> getStudentsByTeacherNameRepository(String teacherName){
        List<String> studentList = new ArrayList<>();
        if(pairOfTeacherStudent.containsKey(teacherName)){
            studentList.addAll(pairOfTeacherStudent.get(teacherName));
        }
        return studentList;
    }

    // 7. List of all students added
    public List<String> getAllStudentsRepository(){
        return new ArrayList<>(studentRecord.keySet());
    }

    // 8. Delete teacher and its students from records
    public void deleteTeacherByNameRepository(String teacherName){
        List<String> temp = new ArrayList<>();
        if(pairOfTeacherStudent.containsKey(teacherName)){
            temp = pairOfTeacherStudent.get(teacherName);
            pairOfTeacherStudent.remove(teacherName);

            for (String names : temp){
                if(studentRecord.containsKey(names)){
                    studentRecord.remove(names);
                }
            }
        }
        teacherRecord.remove(teacherName);
    }


    // 9. Delete All teachers and their students
    public void deleteAllTeachersRepository(){
        HashSet<String> studentNamesTemp = new HashSet<>();
        teacherRecord.clear();

        for(String teacherName : pairOfTeacherStudent.keySet()){
            for (String studentName : pairOfTeacherStudent.get(teacherName)){
                studentNamesTemp.add(studentName);
            }
        }

        for(String studentName : studentNamesTemp){
            if(studentRecord.containsKey(studentName)){
                studentRecord.remove(studentName);
            }
        }

        pairOfTeacherStudent.clear();
    }
}
