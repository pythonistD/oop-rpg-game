package cheboksarov.gameEntities.TextGameView;

import cheboksarov.gameEntities.TextGameView.message.Message;

abstract public class State {
    private Message msg;
    private State prevState;
    private State nextState;
    private State specificState;


    public State(Message msg,State prevState, State nextState, State specificState){
        this.msg = msg;
        this.prevState= prevState;
        this.nextState= nextState;
        this.specificState= specificState;
    }

    public State(Message msg){
        this.msg = msg;
    }

    public void printMsg(){
        System.out.println(msg.getMsg());
    }

    public  void validate(String input){
        msg.selectAction(input);
    }
    // If there is any changes to the Model needs to be applied
    public Directions apply(String input){
        return msg.applyAction(input);
    }
    public State switchState(Directions currentSwitch){
        State state2Switch = null;
        switch (currentSwitch) {
            case NEXT -> {
                state2Switch = nextState;
            }
            case PREVIOUS  ->  {
                state2Switch = prevState;
            }
            case SPECIFIC   ->  {
                return specificState;
            }
            default -> {
                throw new IllegalArgumentException("Invalid state");
            }
        }
        return state2Switch;
    }

    public Message getMsg() {
        return msg;
    }

    public State getPrevState() {
        return prevState;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public void setSpecificState(State specificState) {
        this.specificState = specificState;
    }
}
