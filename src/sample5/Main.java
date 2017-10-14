package sample5;

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

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hello World");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name label
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);

        //name input
        TextField nameInput = new TextField("Sample Name");
        GridPane.setConstraints(nameInput, 1, 0);

        //password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1);

        //password input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        //login button
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
