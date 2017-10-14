package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hello World");

        button = new Button();
        button.setText("Click me!");
        //button.setOnAction(e -> AlertBox.display("Title of the window", "wow i made a cool alert box"));
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of window", "Are you sure you want to do this?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = (new Scene(layout, 300, 275));
        window.setScene(scene);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
