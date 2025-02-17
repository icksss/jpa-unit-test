package jpastart.reserve.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Choice {
    
    private String text;
    private boolean input;

    public Choice(){}

    public Choice(String text, boolean input){
        this.text = text;
        this.input = input;
    }

    public String getText() {
        return text;
    }

    public boolean getInput() {
        return input;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Choice [text=" + text + ", input=" + input + "]";
    }
}