package com.springboot.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShareModel {
    
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String longDynamicLink;

	public String getLongDynamicLink() {
		return longDynamicLink;
	}

	public void setLongDynamicLink(String longDynamicLink) {
		this.longDynamicLink = longDynamicLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
