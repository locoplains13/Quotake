import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class App extends Application{

    Button addButton;
    Button confirmButton;
    Stage window;
    Boolean addedNewAuthor = false;
    Button collectionButton;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        String css = this.getClass().getResource("app.css").toExternalForm();

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER_LEFT);

        VBox authorsBox = new VBox(10);
        authorsBox.setAlignment(Pos.TOP_RIGHT);

        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<Quotes> quoteList = new ArrayList<Quotes>();

        window.setTitle("Quotake");
        addButton = new Button("+");
        collectionButton = new Button("+C");

        
        BorderPane layout = new BorderPane();
    

        Label emptyListLabel = new Label("No quotes registered at this time");

        /*
         * this method asks the user for author and quote to submit it
         */
        addButton.setOnAction(e -> {
            GridPane root = new GridPane();

            Label authorLabel = new Label("Author: ");
            Label quoteLabel = new Label("Quote: ");
    
            // fields of text where the second scene will ask the user for the inputs
            TextField authorTextField = new TextField();
            TextField quoteTextField = new TextField();

            confirmButton = new Button("Confirm");
    
            root.addRow(0, authorLabel, authorTextField);

            root.addRow(1, quoteLabel, quoteTextField);
            root.addRow(2, confirmButton);

            Scene quoteInputs = new Scene(root, 250, 100);
            Stage addButtonStage = new Stage();
            
            addButtonStage.setTitle("Add Quote");
            addButtonStage.setScene(quoteInputs);
            addButtonStage.show();
            /*
            * this method will add author and quote objects and print what the user input
            */
            confirmButton.setOnAction(e1 -> {
                String authorText;
                authorText = authorTextField.getText();

                Author a = new Author(authorText);

                if(!authorList.contains(a)) authorList.add(a);

                Quotes q = new Quotes(quoteTextField.getText(), a.getAuthor());
                quoteList.add(q);
                
                layout.getChildren().remove(emptyListLabel);

                Label displayQuoteLabel = new Label(quoteList.get(quoteList.size()-1).toString());
                authorsBox.getChildren().add(displayQuoteLabel);

                addButtonStage.close();
                
            });
        });

        // how the contents of the scene are ordered
        

        vbox.getChildren().addAll(addButton, collectionButton);
        layout.setLeft(vbox);
        layout.setCenter(authorsBox);
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(layout);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        
        Scene scene = new Scene(scrollPane, 1000, 800);
        scene.getStylesheets().add(css);
        // adds css to the app
        
        // adding scene to the stage
        window.setScene(scene);

        //showing the contents of the scene
        window.show();
    }
}
