package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Customer> table;
    TextField firstInput, lastInput, emailInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Customer");

        //first column
        TableColumn<Customer, String> firstColumn = new TableColumn<>("First");
        firstColumn.setMinWidth(200);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("first"));

        //last column
        TableColumn<Customer, String> lastColumn = new TableColumn<>("Last");
        lastColumn.setMinWidth(100);
        lastColumn.setCellValueFactory(new PropertyValueFactory<>("last"));

        //email column
        TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //First input
        firstInput = new TextField();
        firstInput.setPromptText("Name");
        firstInput.setMinWidth(100);

        //Last input
        lastInput = new TextField();
        lastInput.setPromptText("surname");
        lastInput.setMinWidth(100);

        //Email input
        emailInput = new TextField();
        emailInput.setPromptText("Email");
        emailInput.setMinWidth(100);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(firstInput, lastInput, emailInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getCustomer());
        table.getColumns().addAll(firstColumn, lastColumn, emailColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        Customer customer = new Customer();
        customer.setFirst(firstInput.getText());
        customer.setLast(lastInput.getText());
        customer.setEmail(emailInput.getText());
        table.getItems().add(customer);
        firstInput.clear();
        lastInput.clear();
        emailInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Customer> customerSelected, allCustomers;
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }

    //Get all of the customer
    public ObservableList<Customer> getCustomer() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        customers.add(new Customer("talha", "eroglu", "asd@ad.com"));

        return customers;
    }
}