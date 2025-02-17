package jpastart.reserve.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "access_log")
public class AccessLog {
    @Id
    @TableGenerator(
        name = "accessIdGen", 
        table = "id_seq", 
        pkColumnName = "entity", 
        pkColumnValue = "accesslog",
        valueColumnName = "next_val",
        initialValue = 0,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.TABLE, generator = "accessIdGen")
    private Long id;

    private String path;
    private LocalDateTime accessed;
    
    protected AccessLog(){}

    public AccessLog(String path){
        this.path = path;
        this.accessed = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
    public LocalDateTime getAccessed() {
        return accessed;
    }

    public void setId(Long id) {
        this.id = id;
    }       

    public void setPath(String path) {
        this.path = path;
    }

    public void setAccessed(LocalDateTime accessed) {
        this.accessed = accessed;
    }

    @Override
    public String toString() {
        return "AccessLog [id=" + id + ", path=" + path + ", accessed=" + accessed + "]";
    }
}
