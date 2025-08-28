package com.excelsoft.enties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//For security .........
@XmlRootElement
@Entity
@Data
@Table(name = "User_info")
public class User {
	@Id
	private int id;
	private String userName;
	private String password;
	private String roles;
	private boolean enabled;


}
