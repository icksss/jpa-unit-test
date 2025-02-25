package jpastart.reserve.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "addr1")
    private String address1;

    @Column(name = "addr2")
    private String address2;

    @Column(name = "zipcode")
    private String zipcode;
    
    protected Address(){}

    public Address(String address1, String address2, String zipcode){
        this.address1 = address1;
        this.address2 = address2;
        this.zipcode = zipcode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }   

    public String getZipcode() {
        return zipcode;
    }       

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }   

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }   

    @Override   
    public String toString() {
        return "Address [address1=" + address1 + ", address2=" + address2 + ", zipcode=" + zipcode + "]";
    }   
    
}
