package characterSheet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


/**
 * Created by Robert on 10/14/2017.
 *
 * A grid layout that allows for easy communication between ability score fields and
 * ability modifier fields.
 */
public class AbilityScoreBlock {

    private Label label;
    private IntField totalScoreField;
    private IntField baseScoreField;
    private TextField modifierField;
    private ArrayList<IntField> bonusFields;

    public AbilityScoreBlock(String name) {

        //Label
        label = new Label(name);

        //Ability Base Score Field
        baseScoreField = new IntField();
        baseScoreField.setMaxWidth(35);
        baseScoreField.setPromptText("10");

        //Ability Total Score Field
        totalScoreField = new IntField();
        totalScoreField.setMaxWidth(35);
        totalScoreField.setPromptText("10");
        totalScoreField.setEditable(false);

        //Ability Score Modifier Field
        modifierField = new TextField();
        modifierField.setMaxWidth(35);
        modifierField.setPromptText("0");
        modifierField.setEditable(false);

        //Initialize bonusFields
        bonusFields = new ArrayList<IntField>();

        /**
         * checks for changes in the ability score field and updates the ability
         * modifier field in real time
         */
        totalScoreField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                modifierField.setText(calculateModifier(totalScoreField.getText()));
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

    public void addBonusField(int column, int row, GridPane grid) {
        IntField newField = new IntField();
        newField.setMaxWidth(35);
        newField.setPromptText("0");
        bonusFields.add(newField);
        newField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                totalScoreField.setText(totalBonusFields());
            }
        });
        setPositionAndAddToGrid(newField, grid, column, row);
    }

    public Label getLabel() { return label; }

    public IntField getTotalScoreField() { return totalScoreField; }

    public TextField getModifierField() { return modifierField; }

    public int getBonusFieldLength() {  return bonusFields.size();  }

    private String totalBonusFields() {
        int total = 0;
        for (IntField field : bonusFields) {
            if (!field.getText().equals("")) {
                total += Integer.parseInt(field.getText());
            }
        }
        return Integer.toString(total);
    }


    public void setPositionAndAddToGrid(IntField node, GridPane grid, int column, int row) {
        GridPane.setConstraints(node, column, row);
        grid.getChildren().addAll(node);
    }
}
