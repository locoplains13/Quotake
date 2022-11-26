import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class App extends Application{

    Button addButton;
    Button confirmButton;
    Stage window;
    Boolean addedNewAuthor = false;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<Quotes> quoteList = new ArrayList<Quotes>();

        window.setTitle("Quotake");
        addButton = new Button("+");

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

            ChoiceBox<String> authorsChoiceBox = new ChoiceBox<>();
            
            for(int i = 0; i < authorList.size(); i++){
                authorsChoiceBox.getItems().add(authorList.get(i).getAuthor());
            }
            authorsChoiceBox.getItems().add("Add new author");
            confirmButton = new Button("Confirm");
    
            root.addRow(0, authorLabel, authorsChoiceBox);

            authorsChoiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
                if(newValue == "Add new author"){
                    root.getChildren().remove(authorsChoiceBox);
                    root.addRow(0, authorTextField);
                }
            });

            root.addRow(1, quoteLabel, quoteTextField);
            root.addRow(2, confirmButton);

            if(root.getChildren().contains(authorTextField)){
                addedNewAuthor = true;
            }

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
                if(addedNewAuthor){
                    authorText = authorsChoiceBox.getValue();
                }else{
                    authorText = authorTextField.getText();
                }

                Author a = new Author(authorText);

                if(!authorList.contains(a)) authorList.add(a);

                Quotes q = new Quotes(quoteTextField.getText(), a.getAuthor());
                quoteList.add(q);
                
                addButtonStage.close();
                
            });
        });

        // how the contents of the scene are ordered
        GridPane layout = new GridPane();
        
        layout.addRow(0, addButton);

        Label emptyListLabel = new Label("No quotes registered at this time");

        if(quoteList.isEmpty()){
            layout.addColumn(1, emptyListLabel);
        }else{
            for(int i = 0; i < quoteList.size(); i++){
                Label displayQuoteLabel = new Label(quoteList.get(i).getQuote());
                layout.addColumn((i), displayQuoteLabel);
            }
        }

        Scene scene = new Scene(layout, 500, 300);

        // adding scene to the stage
        window.setScene(scene);

        //showing the contents of the scene
        window.show();
    }
}
