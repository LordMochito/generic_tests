package com.codetest.pojos;


/**
 * Catalog Item domain object
 * 
 * @author pablogutierrez
 *
 */
public class ReceiptItem implements Comparable<ReceiptItem>{
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double itemPrice;
	
	private Double totalItemsPrice;
	
	private Integer quantity;
	
	private String itemSet;

	
	//GETTERS & SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getTotalItemsPrice() {
		return totalItemsPrice;
	}

	public void setTotalItemsPrice(Double totalItemsPrice) {
		this.totalItemsPrice = totalItemsPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemSet() {
		return itemSet;
	}

	public void setItemSet(String itemSet) {
		this.itemSet = itemSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiptItem other = (ReceiptItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ReceiptItem item) {
		 return this.getName().compareTo(item.getName());
	}
}
