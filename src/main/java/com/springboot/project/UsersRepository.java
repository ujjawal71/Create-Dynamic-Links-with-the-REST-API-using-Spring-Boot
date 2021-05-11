package com.springboot.project;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsersRepository extends JpaRepository<UsersModel,Integer> {

	public UsersModel findById(int id);

	

}
