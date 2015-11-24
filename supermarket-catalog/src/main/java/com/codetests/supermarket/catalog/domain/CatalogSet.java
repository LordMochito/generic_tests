package com.codetests.supermarket.catalog.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article_sets")
/**
 * Catalog set domain object
 * 
 * @author pablogutierrez
 *
 */
public class CatalogSet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ARTCL_SET_NAME")
	private String name;
	
	@Column(name = "ARTCL_SET_DESC")
	private String description;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="articleSet")
	private List<CatalogItem> catalogItem;

	//GETTTERS & SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<CatalogItem> getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogItem(List<CatalogItem> catalogItem) {
		this.catalogItem = catalogItem;
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
		CatalogSet other = (CatalogSet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
