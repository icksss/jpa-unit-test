package jpastart.reserve.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq_gen")
    private Long id;

    @Column(name = "hotel_id")
    private Long hotelId;
    private int mark;


    @Column(name = "writer_name")
    private String writerName;

    private String comment;
    private Date created;
    
    protected Review(){}

    public Review(Long hotelId, int mark, String writerName, String comment, Date created){
        this.hotelId = hotelId;
        this.mark = mark;
        this.writerName = writerName;
        this.comment = comment;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public int getMark() {
        return mark;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
