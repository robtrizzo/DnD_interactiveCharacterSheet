package characterSheet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Robert on 10/14/2017.
 * Creates the window for ability scores and adds the relevant layouts
 */
public class Main extends Application{

    Stage window, abilityScoreWindow;
    Scene scene, abilityScoreScene;
    GridPane grid, abilityScoreWindowGrid;
    AbilityScoreDetailWindow abilityScoreDetailWindow;

    ArrayList<AbilityScoreBlock> scoreArray = new ArrayList<AbilityScoreBlock>();

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ability Scores Example");

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 0, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Top row labels
        Label scoreLabel = new Label("Score");
        GridPane.setConstraints(scoreLabel, 1, 0);
        Label modLabel = new Label("Mod");
        GridPane.setConstraints(modLabel, 2, 0);

        //Create ability score fields
        AbilityScoreBlock strBlock = new AbilityScoreBlock("STR");
        AbilityScoreBlock conBlock = new AbilityScoreBlock("CON");
        AbilityScoreBlock dexBlock = new AbilityScoreBlock("DEX");
        AbilityScoreBlock intBlock = new AbilityScoreBlock("INT");
        AbilityScoreBlock wisBlock = new AbilityScoreBlock("WIS");
        AbilityScoreBlock chaBlock = new AbilityScoreBlock("CHA");

        // Add AbilityScoreBlocks to Grid
        addAbilityScoreBlockToGrid(strBlock, 1);
        addAbilityScoreBlockToGrid(conBlock, 2);
        addAbilityScoreBlockToGrid(dexBlock, 3);
        addAbilityScoreBlockToGrid(intBlock, 4);
        addAbilityScoreBlockToGrid(wisBlock, 5);
        addAbilityScoreBlockToGrid(chaBlock, 6);

        // Add AbilityScoreBlocks to ArrayList
        scoreArray.add(strBlock);
        scoreArray.add(conBlock);
        scoreArray.add(dexBlock);
        scoreArray.add(intBlock);
        scoreArray.add(wisBlock);
        scoreArray.add(chaBlock);

        //Add 'More Details' Button
        Button moreDetailsButton = new Button("More Details");
        moreDetailsButton.setOnAction( e -> {
            if (abilityScoreDetailWindow == null) {
                abilityScoreDetailWindow = new AbilityScoreDetailWindow(scoreArray);
                abilityScoreDetailWindow.updateTotalScores(strBlock.getTotalScoreField().getText(), conBlock.getTotalScoreField().getText(),
                        dexBlock.getTotalScoreField().getText(), intBlock.getTotalScoreField().getText(),
                        wisBlock.getTotalScoreField().getText(), chaBlock.getTotalScoreField().getText());
                abilityScoreDetailWindow.showWindow();
            }
            abilityScoreDetailWindow.updateTotalScores(strBlock.getTotalScoreField().getText(), conBlock.getTotalScoreField().getText(),
                    dexBlock.getTotalScoreField().getText(), intBlock.getTotalScoreField().getText(),
                    wisBlock.getTotalScoreField().getText(), chaBlock.getTotalScoreField().getText());
            abilityScoreDetailWindow.getWindow().show();
        });
        GridPane.setConstraints(moreDetailsButton, 2, 7);

        //Add misc items
        grid.getChildren().addAll(scoreLabel, modLabel, moreDetailsButton);


        window.setX(200);
        window.setY(200);
        scene = new Scene(grid, 400, 350);
        window.setScene(scene);
        window.show();

    }

    private void addAbilityScoreBlockToGrid(AbilityScoreBlock asb, int row) {
        GridPane.setConstraints(asb.getLabel(), 0, row);
        GridPane.setConstraints(asb.getTotalScoreField(), 1, row);
        GridPane.setConstraints(asb.getModifierField(), 2, row);
        grid.getChildren().addAll(asb.getLabel(), asb.getTotalScoreField(), asb.getModifierField());
    }

}
