package characterSheet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Created by Robert on 10/14/2017.
 */
public class IntField extends TextField {

    public IntField () {
        super();
        IntField intField = this;
        intField.textProperty().addListener(new ChangeListener<String>() {
            /**
             * Masks key input into the intField to deny the use of anything except numbers
             * and functional keys
             * @param observable
             * @param oldValue
             * @param newValue
             */
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //TODO need to verify that negative integers work as well
                    if (!newValue.matches("\\d*")) {
                        intField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
            }
        });
    }

}
