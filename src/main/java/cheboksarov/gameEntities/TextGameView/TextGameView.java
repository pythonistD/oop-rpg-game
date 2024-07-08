package cheboksarov.gameEntities.TextGameView;

import cheboksarov.gameEntities.TextGameView.action.Action;
import cheboksarov.gameEntities.TextGameView.action.ActionWithContext;
import cheboksarov.gameEntities.TextGameView.action.ButtonActions;
import cheboksarov.gameEntities.TextGameView.message.BtnMessage;
import cheboksarov.gameEntities.TextGameView.message.Message;
import cheboksarov.gameEntities.TextGameView.message.TextFieldMessage;
import cheboksarov.gameEntities.TextGameView.message.WithAutoLoadActionsMessage;
import cheboksarov.gameEntities.dto.Bundle;
import cheboksarov.gameEntities.hero.Hero;
import cheboksarov.gameEntities.hero.HeroCharacteristicsTypes;
import cheboksarov.gameEntities.hero.HeroFactory;

import java.util.*;
import java.util.function.Consumer;

public class TextGameView {
    State currentState;
    ViewModel model;

    public TextGameView(){
        currentState = createScript();
        this.model = new ViewModel();
    }
    private void isValueInSet(String input, Set<String> set){
        if(set.contains(input)){
            return;
        }
        throw new IllegalArgumentException("Value is not in set");
    }

    private State createScript(){
        ViewModel viewModel = new ViewModel();
        //Welcome state
        Action createHeroBtn = new ButtonActions("(1)", "Create Hero", Directions.NEXT);
        Action goToBattleBtn = new ButtonActions("(2)", "Go to BattleGround", Directions.SPECIFIC);
        Action exitBtn = new ButtonActions("(3)", "Quit the Game", Directions.PREVIOUS);
        BtnMessage welcomeMessage  = new BtnMessage("Welcome to the game");
        welcomeMessage.setNav(List.of(createHeroBtn, goToBattleBtn, exitBtn));
        State welcomeState= new BasicState(welcomeMessage);
        //Create Hero state
        Action createDefaultBtn = new ButtonActions("(1)", "Create from Default Setup", Directions.NEXT);
        Action createCustomBtn = new ButtonActions("(2)", "Create Custom Hero", Directions.SPECIFIC);
        BtnMessage createHeroMethodMessage  = new BtnMessage("Choose method of Hero Creation");
        createHeroMethodMessage.setNav(List.of(createDefaultBtn, createCustomBtn));
        State createHeroMethodState = new BasicState(createHeroMethodMessage);
        // Create Hero Name
        ActionWithContext acceptName = new ActionWithContext(Directions.NEXT,
                (Bundle<String, ViewModel> bundle) -> bundle.getSecondValue().setName(bundle.getFirstValue()), viewModel);
        TextFieldMessage createHeroNameMessage   = new TextFieldMessage("Enter Hero Name", acceptName);
        State createHeroNameState = new BasicState(createHeroNameMessage);
        // Choose default setup
        Consumer<Bundle<String, ViewModel>> createHeroFunc =
                (Bundle<String, ViewModel> bundle) -> {
                    HeroCharacteristicsTypes type = HeroCharacteristicsTypes.valueOf(bundle.getFirstValue());
                    Hero newHero = HeroFactory.createHero(bundle.getSecondValue().getName(), type);
                    bundle.getSecondValue().addNewHero(newHero);
                };

        Action warriorCreation = new ActionWithContext(HeroCharacteristicsTypes.WARRIOR_BASE.name(), "", Directions.NEXT,
                createHeroFunc, viewModel);
        Action mageCreation = new ActionWithContext(HeroCharacteristicsTypes.MAGE_BASE.name(), "", Directions.NEXT,
                createHeroFunc, viewModel);
        BtnMessage heroFromSetupCreationMessage  = new BtnMessage("Choose Hero Setup");
        heroFromSetupCreationMessage.setBody(List.of(warriorCreation, mageCreation));
        State createHeroFromSetupState  = new BasicState(heroFromSetupCreationMessage);
        // Ready to battle
        WithAutoLoadActionsMessage chooseHeroMsg = new WithAutoLoadActionsMessage(
                "Choose Hero",
                () -> {
                    List<Action> actions = new ArrayList<>();
                    Set<Hero> heroes  =  viewModel.getHeroes();
                    heroes.forEach(
                            hero -> {
                                Action newAction = new ActionWithContext(String.valueOf(hero.getHeroId()), hero.getName(), Directions.NEXT,
                                        (Bundle<String, ViewModel> bundle) -> {
                                            ViewModel curViewModel  = bundle.getSecondValue();
                                            curViewModel.setCurrentHero(curViewModel.findGeroById(Integer.parseInt(bundle.getFirstValue())));
                                        }, viewModel);
                                actions.add(newAction);
                            }
                    );
                    return actions;
                }
        );
        State readyToBattleState = new BasicState(chooseHeroMsg);

        //Linking
        welcomeState.setPrevState(null);
        welcomeState.setNextState(createHeroMethodState);
        welcomeState.setSpecificState(null);

        createHeroMethodState.setNextState(createHeroNameState);
        createHeroMethodState.setPrevState(welcomeState);
        createHeroMethodState.setSpecificState(null);

        createHeroNameState.setNextState(createHeroFromSetupState);

        createHeroFromSetupState.setNextState(readyToBattleState);



        return welcomeState;

    }

    public void runGame(){
        Scanner in = new Scanner(System.in);

        boolean stopGame = false;

        while (!stopGame){
            if(currentState!=null){
                try {
                    currentState.printMsg();
                    String input  = in.nextLine();
                    currentState.validate(input);
                    Directions switchDirection =  currentState.apply(input);
                    currentState= currentState.switchState(switchDirection);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("Game Ended!");
                stopGame  = true;
            }
        }
    }
}
