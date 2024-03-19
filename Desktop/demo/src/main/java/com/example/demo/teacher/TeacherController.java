package com.example.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/student")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){

        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getTeachers(){

        return teacherService.getTeachers();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long teacherId){
        teacherService.deleteStudent(teacherId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("teacherId ") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        teacherService.updateTeacher(studentId, name, email);
    }
}
