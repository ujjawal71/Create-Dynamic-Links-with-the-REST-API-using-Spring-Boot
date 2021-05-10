package com.springboot.project;
import org.springframework.data.repository.CrudRepository;
public interface LinkRepository extends CrudRepository<ShareModel,Integer> {

	public ShareModel findById(int id);

}
