package com.excelsoft.enties;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@XmlRootElement
@Entity
@Data
@Table(name = "Transactions")
public class Transaction {
	@Id
	@GeneratedValue
	private int transactionId;

	private String beneficiaryName;

	private long fromAccountNumber;

	private long beneficiaryAccountNumber;

	private int amount;

	private float balanceAmount;
	@ManyToOne
	@JoinColumn(name = "cid")
	@JsonBackReference
	private Customer cust;

}
