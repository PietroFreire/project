package com.pietrofreire.project.repository;

import com.pietrofreire.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{

}
