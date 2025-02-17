package jpastart.reserve.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_gen")
    private Long id;
    private String text;


    @ElementCollection
    @CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
    private List<Choice> choices = new ArrayList<>();

    public Question(){}

    public Question(String text){
        this.text = text;
    }   

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Choice> getChoices() {
        return choices;
    }   

    public void addChoice(Choice choice){
        choices.add(choice);
    }

    public void setText(String text) {
        this.text = text;
    }   

    @Override
    public String toString() {
        return "Question [id=" + id + ", text=" + text + ", choices=" + choices + "]";
    }   
    
    
    
    
}
