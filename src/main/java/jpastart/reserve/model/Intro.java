package jpastart.reserve.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Intro {
    @Column(name = "content_type", table = "writer_intro")
    private String contentType;

    @Column(name = "content", table = "writer_intro")
    private String content;

    protected Intro(){}

    public Intro(String contentType, String content){
        this.contentType = contentType;
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "Intro [contentType=" + contentType + ", content=" + content + "]";
    }
}