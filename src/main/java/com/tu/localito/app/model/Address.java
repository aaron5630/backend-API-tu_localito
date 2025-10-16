package com.tu.localito.app.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="addresses")
public class Address {
    @Id
    private Long id;
    @Column(name="country", length=100, nullable=false)
    private String country;
    @Column(name="state", length=45, nullable=false)
    private String state;
    @Column(name="postal_code", length=5, nullable=false)
    private String postalCode;
    @Column(name="street", length=50, nullable=false)
    private String street;
    @Column(name="street_number", length=50, nullable=false)
    private Long streetNumber;
    @Column(name="apartment_number", length=50, nullable=false)
    private Long apartmentNumber;
    
    @ManyToOne()
    private Users user;
    
    //===============================
    public Address() {}

    public Address(Long id, String country, String state, String postalCode, String street, Long streetNumber, Long apartmentNumber) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.postalCode = postalCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }


    //==============================================
    //get y set
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Long streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Long getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(Long apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
    
    //============================================
 
	 @Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Address [id=");
			builder.append(id);
			builder.append(", country=");
			builder.append(country);
			builder.append(", state=");
			builder.append(state);
			builder.append(", postalCode=");
			builder.append(postalCode);
			builder.append(", street=");
			builder.append(street);
			builder.append(", streetNumber=");
			builder.append(streetNumber);
			builder.append(", apartmentNumber=");
			builder.append(apartmentNumber);
			builder.append("]");
			return builder.toString();
		}


	//========================================
 
	@Override
	public int hashCode() {
		return Objects.hash( apartmentNumber, country, id, postalCode, state, street, streetNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return  Objects.equals(apartmentNumber, other.apartmentNumber)
				&& Objects.equals(country, other.country) && Objects.equals(id, other.id)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(streetNumber, other.streetNumber);
	}

    
}
