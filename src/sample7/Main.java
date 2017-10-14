package sample7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Robert on 10/14/2017.
 */
public class Main extends Application{

    Stage window;
    Scene scene;
    Button button;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Checkbox Example");

        //Checkboxes
        CheckBox box1 = new CheckBox("box1");
        CheckBox box2 = new CheckBox("box2");
        box2.setSelected(true);

        //Button
        button = new Button("Order Now!");
        button.setOnAction(e -> handleOptions(box1, box2));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Handle checkbox options
    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "User selected: ";

        if (box1.isSelected())
            message += "box1 ";
        if (box2.isSelected())
            message += "box2 ";

        System.out.println(message);
    }
}
