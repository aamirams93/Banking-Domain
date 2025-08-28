package com.excelsoft.enties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@XmlRootElement
@Entity
@Data
@Table(name = "Accounts")
public class Account {
	@Id
	private long accountNumber;

	private String accountType;

	private String name;

	private int balanceAmount;

	@OneToOne
	@JoinColumn(name = "cid")
	@JsonBackReference
	private Customer customer;

}
