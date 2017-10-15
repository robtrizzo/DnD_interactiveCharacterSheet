package characterSheet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Created by Robert on 10/14/2017.
 *
 * A grid layout that allows for easy communication between ability score fields and
 * ability modifier fields.
 */
public class AbilityScoreBlock {

    private Label label;
    private IntField scoreField;
    private TextField modifierField;

    public AbilityScoreBlock(String name) {

        //Label
        label = new Label(name);

        //Ability Score Field
        scoreField = new IntField();
        scoreField.setMaxWidth(35);
        scoreField.setPromptText("10");

        //Ability Score Modifier Field
        modifierField = new TextField();
        modifierField.setMaxWidth(35);
        modifierField.setPromptText("0");
        modifierField.setEditable(false);

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
    }

    private String calculateModifier(String score) {
        if (score.isEmpty()) {
            return "";
        }
        int scoreVal = Integer.parseInt(score);
        int modifierVal = (scoreVal - 10) / 2;
        return Integer.toString(modifierVal);
    }


    public Label getLabel() { return label; }

    public IntField getScoreField() { return scoreField; }

    public TextField getModifierField() { return modifierField; }
}
