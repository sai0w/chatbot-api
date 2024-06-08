package org.sai.chatbot.api.domain.ai.model.aggregates;

import org.sai.chatbot.api.domain.ai.model.vo.Choices;

import java.util.List;

public class AIAnswer {
    private String id;

    private String model;

    private String object;

    private int created;

    private List<Choices> choices;



    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObject(){
        return this.object;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }

}

