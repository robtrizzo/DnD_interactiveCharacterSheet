package sample3;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.ConfirmBox;

public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hello World");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button = new Button();
        button.setText("Close Program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = (new Scene(layout, 300, 275));
        window.setScene(scene);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Stupid title", "You sure you want to exit?");
        if (answer)
            window.close();
    }
}
