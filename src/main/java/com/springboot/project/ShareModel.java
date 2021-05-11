package com.springboot.project;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ShareModel {
    
    
	private String longDynamicLink;
	

	public String getLongDynamicLink() {
		return longDynamicLink;
	}

	public void setLongDynamicLink(String longDynamicLink) {
		this.longDynamicLink = longDynamicLink;
	}

	

	
}
