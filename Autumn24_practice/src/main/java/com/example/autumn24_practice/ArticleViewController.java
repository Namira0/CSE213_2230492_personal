package com.example.autumn24_practice;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleViewController
{
    @javafx.fxml.FXML
    private DatePicker PublicationDateDP;
    @javafx.fxml.FXML
    private CheckBox FilterCitationStatusCheckbox;
    @javafx.fxml.FXML
    private TextField TitleTF;
    @javafx.fxml.FXML
    private TextField NoOfAuthorTF;
    @javafx.fxml.FXML
    private TextField FilterLastYearTF;
    @javafx.fxml.FXML
    private TableView<Article> ArticleTableView;
    @javafx.fxml.FXML
    private CheckBox CitationStatusCheckbox;
    @javafx.fxml.FXML
    private TextField AuthorTF;
    @javafx.fxml.FXML
    private TextField FilterFirstYearTF;
    @javafx.fxml.FXML
    private TextArea TextAreaTA;
    @javafx.fxml.FXML
    private TableColumn<Article,LocalDate> PublicationDateColumnTableView;
    @javafx.fxml.FXML
    private TableColumn<Article,String> CitationStatusColumnTableView;
    @javafx.fxml.FXML
    private TableColumn<Article,String> TitleColumnTableView;
    @javafx.fxml.FXML
    private TableColumn<Article,String> AuthorColumnTableView;
    @javafx.fxml.FXML
    private TableColumn<Article,Integer> NoOfAuthorColumnTableView;
    @javafx.fxml.FXML
    private TableColumn<Article,String> ArticleTypeColumnTableView;

    private ArrayList<Article>ArticleList = new ArrayList<>();
    @javafx.fxml.FXML
    private ComboBox<String> ArticleTypeCB;
    @javafx.fxml.FXML
    private ComboBox<String> FilterArticleTypeCB;
    @javafx.fxml.FXML
    private Label ErrorLable;

    @javafx.fxml.FXML
    public void initialize() {
        AuthorColumnTableView.setCellValueFactory(new PropertyValueFactory<>("Author"));
        ArticleTypeColumnTableView.setCellValueFactory(new PropertyValueFactory<>("ArticleType"));
        CitationStatusColumnTableView.setCellValueFactory(new PropertyValueFactory<>("CitationStatus"));
        NoOfAuthorColumnTableView.setCellValueFactory(new PropertyValueFactory<>("NoOfAuthors"));
        PublicationDateColumnTableView.setCellValueFactory(new PropertyValueFactory<>("PublicationDate"));
        TitleColumnTableView.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ArticleTypeCB.getItems().addAll("Review","Book","case");
        FilterArticleTypeCB.getItems().addAll("Review","Book","case");

    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        try {
            int No_of_Author = Integer.parseInt(NoOfAuthorTF.getText());
        } catch (Exception e){
            ErrorLable.setText("No of Author must be a number");
            return;
        }
        for (Article article: ArticleList){
            if (article.getTitle().equals(TitleTF.getText())){
                ErrorLable.setText("Title is Duplicate");
                return;
            }
        }

        String CS = "";
        if (CitationStatusCheckbox.isSelected()){
            CS ="Yes";
        } else {
            CS = "No";
        }
        Article a = new Article(
                //String title, String author, String articleType, String citationStatus, int noOfAuthors, LocalDate publicationDate) {
                TitleTF.getText(),
                AuthorTF.getText(),
                ArticleTypeCB.getValue(),
                CS,
                Integer.parseInt(NoOfAuthorTF.getText()),
                PublicationDateDP.getValue()
        );
        ArticleList.add(a);
        ArticleTableView.getItems().clear();
        ArticleTableView.getItems().addAll(ArticleList);
    }

    @javafx.fxml.FXML
    public void YearFilterButtonOA(ActionEvent actionEvent) {
        ArticleTableView.getItems().clear();
        for (Article article : ArticleList){
            if(FilterFirstYearTF.getText()) <= article.getPublicationDate()
            }
        }


    }
    @javafx.fxml.FXML
    public void SearchArticleButtonOA(ActionEvent actionEvent) {
        String CS = "";
        if (FilterCitationStatusCheckbox.isSelected()){
            CS ="Yes";
        } else {
            CS = "No";
        }
        ArticleTableView.getItems().clear();
        for (Article article : ArticleList){
            if (FilterArticleTypeCB.getValue().equals(article.getArticleType())   &&  CS.equals(article.getCitationStatus())){
                ArticleTableView.getItems().addAll(article);
            }
        }
    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
    }
}