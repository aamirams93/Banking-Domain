package com.excelsoft.enties;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@XmlRootElement
@Entity
@Table(name = "Customers_info")
@Data
public class Customer {

	@Id
	private int userId;

	private long accountNumber;

	private String name;

	private String gender;

	private String email;

	private String contact;

	private String aadharNo;

	// use one to one mapping
	@OneToOne(mappedBy = "customer")
	@JsonManagedReference
	private Account account;
	@OneToMany(mappedBy = "cust")
	@JsonManagedReference
	private List<Transaction> tran;

}
