

package com.beauto.iiotconnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


	User getUserByEmail(String email);

	

	boolean existsByEmail(String email);

	


}
