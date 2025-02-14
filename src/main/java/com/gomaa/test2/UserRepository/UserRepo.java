package com.gomaa.test2.UserRepository;

import com.gomaa.test2.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
