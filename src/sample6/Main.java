package sample6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Robert on 7/31/2017.
 */
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hello World");

        //Form
        TextField nameInput = new TextField();
        button = new Button("Click me");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(nameInput, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch(NumberFormatException e) {
            System.out.println("Error: '" + message + "' is not a number");
            return false;
        }
    }
}
