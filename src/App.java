import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class App extends Application{

    Button button;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    Author sKing = new Author("Stephen King");
    Quotes q = new Quotes("i wrote it", sKing.getAuthor());
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Quotake");
        button = new Button("print author saved");

        sKing.addQuote(q);

        button.setOnAction(e ->  {
        System.out.println(sKing.toString());

    });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
