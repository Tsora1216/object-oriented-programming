// Listing 14-1 TableViewTest1

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewTest1 extends Application {

    TableView table = new TableView();

    @Override
    public void start(Stage stage) {

        Label label = new Label("Address Book");

        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        VBox vbox = new VBox(10, label, table);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("TableViewTest1");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TableViewTest1");
    }
}
