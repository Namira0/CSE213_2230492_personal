package com.example.midterm_2230492_sec02;

import javafx.scene.control.*;

public class CreditCardViewController
{
    @javafx.fxml.FXML
    private TableColumn<CreditCard,String> gateawayNameTF;
    @javafx.fxml.FXML
    private TextField holderNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> gateawayNamecombobox;
    @javafx.fxml.FXML
    private TextField CreditLimitTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard,Integer> cardLimitTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard,String> HolderNameTableViewTF;
    @javafx.fxml.FXML
    private TextField CardNoTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard,Integer> cardNoTableViewTF;
    @javafx.fxml.FXML
    private DatePicker dateofExpiryTF;
    @javafx.fxml.FXML
    private ComboBox<String> creditTypecombobox;
    @javafx.fxml.FXML
    private TableView<CreditCard> TableviewTF;

    @javafx.fxml.FXML
    public void initialize() {
        gateawayNamecombobox.getItems().addAll("Visa","MasterCard");
        creditTypecombobox.getItems().addAll("Silver","Gold","Diamond","platinum");


    }
}