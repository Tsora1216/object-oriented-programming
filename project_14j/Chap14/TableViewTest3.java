// Listing 14-4 TableViewTest3: Editable table

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewTest3 extends Application {

    private TableView<Person> table = new TableView<>();
    private ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com"));

    @Override
    public void start(Stage stage) {

        Label label = new Label("Address Book");

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        table.setItems(data);

        TextField addFirstName = new TextField();
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        addFirstName.setPromptText("First Name");
        TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            if (!addEmail.getText().isEmpty()) {
                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            int index = table.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                data.remove(index);
            }
        });

        HBox hbox = new HBox(10, addFirstName, addLastName, addEmail,
                addButton, deleteButton);
        VBox vbox = new VBox(10, label, table, hbox);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("TableViewTest3");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TableViewTest3");
    }
}
