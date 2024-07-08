package cheboksarov.gameEntities.TextGameView;

import cheboksarov.gameEntities.TextGameView.message.Message;

import java.util.function.Consumer;
import java.util.function.Function;

public class BasicState extends State{
    public BasicState(Message msg, State prevState, State nextState, State specificState) {
        super(msg, prevState, nextState, specificState);
    }

    public BasicState(Message msg) {
        super(msg);
    }
}
