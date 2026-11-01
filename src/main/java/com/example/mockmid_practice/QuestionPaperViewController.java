package com.example.mockmid_practice;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class QuestionPaperViewController {
    @javafx.fxml.FXML
    private ComboBox<String> semesterComboBox;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, LocalDate> ExamDateTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> FilterQpTypeCombobox;
    @javafx.fxml.FXML
    private TextField descriptionTF;
    @javafx.fxml.FXML
    private ComboBox<String> courseidComboBox;
    @javafx.fxml.FXML
    private DatePicker examdateDatepicker;
    @javafx.fxml.FXML
    private ComboBox<String> qpTypeComboBox;
    @javafx.fxml.FXML
    private TextField durationInMInTF;
    @javafx.fxml.FXML
    private Label ShowQpcountTF;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, String> examTypeTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> FilterCourseidComboBox;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, Integer> TotalMarkTableColumn;
    @javafx.fxml.FXML
    private CheckBox ToBeConductedQPTF;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, String> courseidTableColumn;
    @javafx.fxml.FXML
    private TextField yearTF;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, Integer> yearTableColumn;
    @javafx.fxml.FXML
    private TextField totalmarkTF;
    @javafx.fxml.FXML
    private TableView<QuestionPaper> QuestionPaperTableView;
    @javafx.fxml.FXML
    private TableColumn<QuestionPaper, String> SemesterTableColumn;

    private ArrayList<QuestionPaper> questionpaperList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        courseidComboBox.getItems().addAll("CSE213", "CSE315", "CSE310", "MAT203");
        semesterComboBox.getItems().addAll("Spring", "Summer", "Autumn");
        qpTypeComboBox.getItems().addAll("Quiz", "Mid", "final");
        FilterCourseidComboBox.getItems().addAll("CSE213", "CSE315", "CSE310", "MAT203");
        FilterQpTypeCombobox.getItems().addAll("Quiz", "Mid", "final");
        courseidTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        examTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("qpType"));
        SemesterTableColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        ExamDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("examdate"));
        TotalMarkTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalMark"));
        TotalMarkTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalMark"));

    }

    public void Showaleart(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);

        a.setContentText(s);
        a.showAndWait();

    }

    public void showAleart(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);

        a.setContentText(s);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void ValidateandaddnewobjecttoarraylistButtonOA(ActionEvent actionEvent) {
        if (Integer.parseInt(totalmarkTF.getText()) < 10 ||
                Integer.parseInt(totalmarkTF.getText()) > 100) {
            showAleart("Total mark can not be less than 10 and can not be more than 100 ");
            return;
        }

        if (!(Integer.parseInt(durationInMInTF.getText()) >= 15 &&
                Integer.parseInt(durationInMInTF.getText()) <= 90) ||
                Integer.parseInt(durationInMInTF.getText()) % 15 != 0) {
            showAleart("duration must be within 15-90 min and multiple of 15");
            return;

        }
        if (examdateDatepicker.getValue().isBefore(LocalDate.now())) {
            showAleart("exam date can not be past date");
            return;
        }

        QuestionPaper qp = new QuestionPaper(
                courseidComboBox.getValue(),
                semesterComboBox.getValue(),
                descriptionTF.getText(),
                qpTypeComboBox.getValue(),
                Integer.parseInt(yearTF.getText()),
                Integer.parseInt(durationInMInTF.getText()),
                Float.parseFloat(totalmarkTF.getText()),
                examdateDatepicker.getValue()
        );
        questionpaperList.add(qp);
    }
    @javafx.fxml.FXML
    public void ProcessTableButtonOA(ActionEvent actionEvent) {
        QuestionPaperTableView.getItems().clear();

        for (QuestionPaper qp : questionpaperList) {
            if (ToBeConductedQPTF.isSelected()) {
                // only papers not yet conducted (exam date today or later)
                if (!qp.getExamdate().isBefore(LocalDate.now())) {
                    QuestionPaperTableView.getItems().add(qp);
                }
            } else {
                QuestionPaperTableView.getItems().add(qp);
            }
        }

        ShowQpcountTF.setText("Count: " + QuestionPaperTableView.getItems().size());
    }

    @javafx.fxml.FXML
    public void filterandloadtableButtonOA(ActionEvent actionEvent) {
        QuestionPaperTableView.getItems().clear();
        for (QuestionPaper qp : questionpaperList) {
            if (FilterCourseidComboBox.getValue() != null &&
                    FilterQpTypeCombobox.getValue() != null &&
                    FilterCourseidComboBox.getValue().equals(qp.getCourseId()) &&
                    FilterQpTypeCombobox.getValue().equals(qp.getQpType())) {
                QuestionPaperTableView.getItems().add(qp);
            }
        }
        ShowQpcountTF.setText("Count: " + QuestionPaperTableView.getItems().size());
    }
}