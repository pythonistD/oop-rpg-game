package cheboksarov.gameEntities.TextGameView.action;

import cheboksarov.gameEntities.TextGameView.Directions;

public abstract class Action {
    private String id;
    private String text;
    private Directions direction;

    public abstract Directions doAction(String input);

    public Action(String id, String text, Directions direction) {
        this.id = id;
        this.text = text;
        this.direction = direction;
    }
    public Action(Directions direction){
        id = "1";
        text  = " ";
        this.direction  = direction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return id + " " + text;
    }
}
