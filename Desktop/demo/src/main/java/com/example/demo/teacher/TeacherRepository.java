package com.example.demo.teacher;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TeacherRepository
        extends JpaRepository<Teacher, Long> {

    @Query("SELECT s FROM Teacher s WHERE s.email = ?1")
    Optional<Teacher> findTeacherByEmail(String email);
}
