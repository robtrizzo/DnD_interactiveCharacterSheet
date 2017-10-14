package characterSheet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Created by Robert on 10/14/2017.
 *
 * A grid layout that allows for easy communication between ability score fields and
 * ability modifier fields.
 */
public class AbilityScoreBlock {

    private GridPane grid;

    public AbilityScoreBlock(String name) {
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 0, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Label
        Label label = new Label(name);
        GridPane.setConstraints(label, 0, 0);

        //Ability Score Field
        IntField scoreField = new IntField();
        scoreField.setMaxWidth(35);
        scoreField.setPromptText("10");
        GridPane.setConstraints(scoreField, 1, 0);

        //Ability Score Modifier Field
        TextField modifierField = new TextField();
        modifierField.setMaxWidth(35);
        modifierField.setPromptText("0");
        modifierField.setEditable(false);
        GridPane.setConstraints(modifierField, 2, 0);

        /**
         * checks for changes in the ability score field and updates the ability
         * modifier field in real time
         */
        scoreField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                modifierField.setText(calculateModifier(scoreField.getText()));
            }
        });

        grid.getChildren().addAll(label, scoreField, modifierField);
    }

    private String calculateModifier(String score) {
        if (score.isEmpty()) {
            return "";
        }
        int scoreVal = Integer.parseInt(score);
        int modifierVal = (scoreVal - 10) / 2;
        return Integer.toString(modifierVal);
    }

    /**
     * A getter for the grid is necessary for adding the AbilityScoreBlocks to other layouts
     * @return the grid layout containing the label and fields for the ability score
     */
    public GridPane getGrid() {
        return grid;
    }
}
