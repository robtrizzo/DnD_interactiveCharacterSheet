package characterSheet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Robert on 10/14/2017.
 * Creates the window for ability scores and adds the relevant layouts
 */
public class Main extends Application{

    Stage window;
    Scene scene;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ability Scores Example");

        VBox vBox = new VBox(0);
        vBox.setPadding(new Insets(0, 10, 0, 10));

        //Top row labels
        Label topLabel = new Label("    Score    Mod");

        //Add ability score fields
        AbilityScoreBlock strBlock = new AbilityScoreBlock("STR");
        AbilityScoreBlock conBlock = new AbilityScoreBlock("CON");
        AbilityScoreBlock dexBlock = new AbilityScoreBlock("DEX");
        AbilityScoreBlock intBlock = new AbilityScoreBlock("INT");
        AbilityScoreBlock wisBlock = new AbilityScoreBlock("WIS");
        AbilityScoreBlock chaBlock = new AbilityScoreBlock("CHA");

        //Add items to grid
        vBox.getChildren().addAll(topLabel, strBlock.getGrid(), conBlock.getGrid(), dexBlock.getGrid(),
                intBlock.getGrid(), wisBlock.getGrid(), chaBlock.getGrid());

        scene = new Scene(vBox, 400, 350);
        window.setScene(scene);
        window.show();

    }

}
