package com.example.demo.repository;

import com.example.demo.domain.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Collection<User>> findAllByName(String name);

}
