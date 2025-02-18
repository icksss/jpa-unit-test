package jpastart.reserve.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jpastart.jpa.BooleanYesNoConverter;

@Entity
@DynamicUpdate // 변경된 필드만 업데이트
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    @Column(name = "open_yn")
    @Convert(converter = BooleanYesNoConverter.class)
    private boolean opened;

    public Notice() {}

    public Notice(String title, String content, boolean opened) {
        this.title = title;
        this.content = content;
        this.opened = opened;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", opened=" + opened + "]";
    }
}
