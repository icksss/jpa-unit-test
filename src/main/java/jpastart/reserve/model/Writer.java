package jpastart.reserve.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;    
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;

@Entity
@SecondaryTables({
    @SecondaryTable(
        name = "writer_intro", 
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "writer_id" , 
                                              referencedColumnName = "id")),
    @SecondaryTable(
        name = "writer_address", 
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "writer_id" , 
                                              referencedColumnName = "id"))
})
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "writer_seq_gen")
    private Long id;
    private String name;

    @Embedded
    private Intro intro;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "address1", column = @Column(table = "writer_address", name = "addr1")),
        @AttributeOverride(name = "address2", column = @Column(table = "writer_address", name = "addr2")),
        @AttributeOverride(name = "zipcode", column = @Column(table = "writer_address", name = "zipcode"))
    })
    private Address address;
    
    protected Writer(){}

    public Writer(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }   

    public Intro getIntro() {
        return intro;
    }

    public Address getAddress() {
        return address;
    }   

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {  
        this.name = name;
    }

    public void setIntro(Intro intro) {
        this.intro = intro;
    }       

    public void setAddress(Address address) {
        this.address = address;
    }   

    @Override
    public String toString() {
        return "Writer [id=" + id + ", name=" + name + ", intro=" + intro + ", address=" + address + "]";
    }   
    
    
    
}
