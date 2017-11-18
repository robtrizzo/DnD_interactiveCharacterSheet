package characterSheet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by Robert on 10/15/2017.
 */
public class AbilityScoreDetailWindow {

    Stage window;
    Scene scene;
    GridPane grid;
    VBox vbox;
    Button addColumnButton;
    AbilityScoreBlock strBlock;
    AbilityScoreBlock conBlock;
    AbilityScoreBlock dexBlock;
    AbilityScoreBlock intBlock;
    AbilityScoreBlock wisBlock;
    AbilityScoreBlock chaBlock;


    public AbilityScoreDetailWindow (ArrayList<AbilityScoreBlock> mainPageScores) {

        //TODO: need to clean this up a lot and centralize things properly

        //Open second window
        window = new Stage();
        window.setTitle("Ability Score Details");
        grid = new GridPane();
        vbox = new VBox();



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
        strBlock = new AbilityScoreBlock("STR");
        conBlock = new AbilityScoreBlock("CON");
        dexBlock = new AbilityScoreBlock("DEX");
        intBlock = new AbilityScoreBlock("INT");
        wisBlock = new AbilityScoreBlock("WIS");
        chaBlock = new AbilityScoreBlock("CHA");

        // Add AbilityScoreBlocks to Grid
        addAbilityScoreBlockToGrid(strBlock, 1);
        addAbilityScoreBlockToGrid(conBlock, 2);
        addAbilityScoreBlockToGrid(dexBlock, 3);
        addAbilityScoreBlockToGrid(intBlock, 4);
        addAbilityScoreBlockToGrid(wisBlock, 5);
        addAbilityScoreBlockToGrid(chaBlock, 6);

        // Add connections between DetailWindow and Main window
        // for updated scores
        addUpdateConnection(strBlock, mainPageScores.get(0));
        addUpdateConnection(conBlock, mainPageScores.get(1));
        addUpdateConnection(dexBlock, mainPageScores.get(2));
        addUpdateConnection(intBlock, mainPageScores.get(3));
        addUpdateConnection(wisBlock, mainPageScores.get(4));
        addUpdateConnection(chaBlock, mainPageScores.get(5));

        //Create addColumnButton
        addColumnButton = new Button("Add a new field");
        addColumnButton.setOnAction( e -> {
            strBlock.addBonusField(strBlock.getBonusFieldLength() + 3, 1, grid);
            conBlock.addBonusField(conBlock.getBonusFieldLength() + 3, 2, grid);
            dexBlock.addBonusField(dexBlock.getBonusFieldLength() + 3, 3, grid);
            intBlock.addBonusField(intBlock.getBonusFieldLength() + 3, 4, grid);
            wisBlock.addBonusField(wisBlock.getBonusFieldLength() + 3, 5, grid);
            chaBlock.addBonusField(chaBlock.getBonusFieldLength() + 3, 6, grid);
        });

    }

    public void showWindow() {
        vbox.getChildren().addAll(grid, addColumnButton);
        scene = new Scene(vbox, 400, 350);
        window.setScene(scene);
        window.show();
    }

    private void addAbilityScoreBlockToGrid(AbilityScoreBlock asb, int row) {
        GridPane.setConstraints(asb.getLabel(), 0, row);
        GridPane.setConstraints(asb.getTotalScoreField(), 1, row);
        GridPane.setConstraints(asb.getModifierField(), 2, row);
        grid.getChildren().addAll(asb.getLabel(), asb.getTotalScoreField(), asb.getModifierField());
    }

    public void updateTotalScores(String str, String con, String dex, String intl, String wis, String cha) {
        strBlock.getTotalScoreField().setText(str);
        conBlock.getTotalScoreField().setText(con);
        dexBlock.getTotalScoreField().setText(dex);
        intBlock.getTotalScoreField().setText(intl);
        wisBlock.getTotalScoreField().setText(wis);
        chaBlock.getTotalScoreField().setText(cha);
    }

    public Stage getWindow() { return window; }

    public GridPane getGrid() { return grid; }

    private void addUpdateConnection(AbilityScoreBlock detailBlock, AbilityScoreBlock mainBlock) {
        detailBlock.getTotalScoreField().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                mainBlock.getTotalScoreField().setText(detailBlock.getTotalScoreField().getText());
            }
        });
    }

}
