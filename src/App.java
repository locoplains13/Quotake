import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class App extends Application{

    Button addButton;
    Button confirmButton;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Quotake");
        addButton = new Button("+");
        Label authorLabel = new Label("Author: ");
        Label quoteLabel = new Label("Quote: ");

        TextField authorTextField = new TextField();
        TextField quoteTextField = new TextField();

        confirmButton = new Button("Confirm");

        /*
         * this method asks the user for author and quote to submit it
         */
        addButton.setOnAction(e -> {
            GridPane root = new GridPane();
            root.addRow(0, authorLabel, authorTextField);
            root.addRow(1, quoteLabel, quoteTextField);
            root.addRow(2, confirmButton);
            Scene quoteInputs = new Scene(root, 250, 100);
            Stage addButtonStage = new Stage();
            addButtonStage.setTitle("Add Quote");
            addButtonStage.setScene(quoteInputs);
            addButtonStage.show();
        });

        /*
         * this method will add author and quote objects and print what the user input
         */
        confirmButton.setOnAction(e -> {
            Author a = new Author(authorTextField.getText());
            Quotes q = new Quotes(quoteTextField.getText(), a.getAuthor());
            System.out.println(q.toString());

        });
        
        StackPane layout = new StackPane();
        layout.getChildren().add(addButton);

        Scene scene = new Scene(layout, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
