package com.restfox.rest.data.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(Include.NON_NULL)
public class Item {

	@XmlElement(name = "id")
	private long itemId;

	@XmlElement(name = "item-name")
	@NotNull
	private String name;

	@XmlElement(name = "medicine")
	private boolean medicine;

	@XmlElement(name = "price")
	@NotNull
	private double price;

	@XmlElement(name = "tax")
	private double tax = 0;

	@XmlElement(name = "gross-price")
	private double grossPrice;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(final long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public boolean isMedicine() {
		return medicine;
	}

	public void setMedicine(final boolean medicine) {
		this.medicine = medicine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(final double tax) {
		this.tax = tax;
	}

	public double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}

	public void updateGrossPrice() {
		double taxAmount = 0;
		if (this.tax > 0) {
			taxAmount = this.price / this.tax;
		}
		this.grossPrice = this.price + taxAmount;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", medicine=" + medicine + ", price=" + price + ", tax="
				+ tax + ", grossPrice=" + grossPrice + "]";
	}

}
