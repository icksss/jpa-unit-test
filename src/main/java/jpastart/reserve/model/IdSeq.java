package jpastart.reserve.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "id_seq")
public class IdSeq {
    @Id
    @Column(name = "entity")
    private String entity;

    @Column(name = "next_val")
    private BigInteger nextVal;

    public IdSeq(){}

    public IdSeq(String entity, BigInteger nextVal){
        this.entity = entity;
        this.nextVal = nextVal;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public BigInteger getNextVal() {
        return nextVal;
    }

    public void setNextVal(BigInteger nextVal) {
        this.nextVal = nextVal;
    }
}
