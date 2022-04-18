package com.mouritech.onlinefoodorderapplication.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "total_price")
    private double totalPrice;

//    @Column(name = "session_id")
//    private String sessionId;

//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    private List<OrderItem> orderItems;
//    , fetch = FetchType.LAZY
   // @JsonIgnore
    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.REMOVE )
	private List<OrderItem> items;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	 @JsonIgnore
	private Customer customer;


//    @ManyToOne()
//    @JsonIgnore
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
    
    

    public Order(Date createdDate, double totalPrice, List<OrderItem> items, Customer customer) {
		super();
		this.createdDate = createdDate;
		this.totalPrice = totalPrice;
		this.items = items;
		this.customer = customer;
	}






	public Order() {
    }


    
   


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

  

    public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}






	public double getTotalPrice() {
		return totalPrice;
	}






	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}






//	public String getSessionId() {
//        return sessionId;
//    }
//
//    public void setSessionId(String sessionId) {
//        this.sessionId = sessionId;
//    }


	public List<OrderItem> getItems() {
		return items;
	}


	public void setItems(List<OrderItem> items) {
		this.items = items;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

   

}
