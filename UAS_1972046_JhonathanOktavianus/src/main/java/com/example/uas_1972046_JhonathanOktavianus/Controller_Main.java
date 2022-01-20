package com.example.uas_1972046_JhonathanOktavianus;

import com.example.uas_1972046_JhonathanOktavianus.DAO.MemberDaoImpl;
import com.example.uas_1972046_JhonathanOktavianus.DAO.PointDaoImpl;
import com.example.uas_1972046_JhonathanOktavianus.DAO.TransactionDaoImpl;
import com.example.uas_1972046_JhonathanOktavianus.Entity.FeMember;
import com.example.uas_1972046_JhonathanOktavianus.Entity.FePoint;
import com.example.uas_1972046_JhonathanOktavianus.Entity.FeTransaction;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * 1972046 - Jhonathan Oktavianus
 */

public class Controller_Main implements Initializable {
    public Label label1;
    public Label label2;
    public Label label3;
    public TextField txtCitizen;
    public TextField txtName;
    public TextArea txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public TextField txtUsername;
    public DatePicker txtBirthDate;
    public Button btnSave;
    public Button btnReset;
    public Button btnUpdate;
    public TableView<FeMember> tableView;
    public TableColumn<FeMember, String> colCitizen;
    public TableColumn<FeMember, String> colName;
    public TableColumn<FeMember, String> colPhone;
    public TableColumn<FeMember, String> colBirth;
    public TextField txtNominal;
    public DatePicker txtTransaction;
    public Button btnTransaction;
    public TableView<FeTransaction> tableView2;
    public TableColumn<FeTransaction, String> colTransaction;
    public TableColumn<FeTransaction, String> colNominal;
    public TableView<FePoint> tableview3;
    public TableColumn<FePoint,String> colIdPoint;
    public TableColumn<FePoint,String> colPoint;

    private Controller_Login ctrl1;
    private ObservableList<FeMember> mlist;
    private ObservableList<FeTransaction> tlist;
    private ObservableList<FePoint> plist;
    private FeMember selectedItem;
    private FeTransaction selectedItem2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtNominal.setDisable(true);
        txtTransaction.setDisable(true);
        btnTransaction.setDisable(true);
        btnUpdate.setDisable(true);
        MemberDaoImpl memberDao = new MemberDaoImpl();
        mlist = (ObservableList<FeMember>) memberDao.showData();
        tableView.setItems(mlist);
        colCitizen.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getCitizenId())));
        colName.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getName()));
        colPhone.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getPhone()));
        colBirth.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getBirthdate())));

        label1.setText(String.valueOf(mlist.stream().count()));
        label2.setText("0");
        label3.setText("0");
    }

    public void setController(Controller_Login ctrl1){
        this.ctrl1 = ctrl1;
    }

    public void cellSelected(MouseEvent mouseEvent) {
        selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            btnSave.setDisable(true);
            btnUpdate.setDisable(false);
            txtCitizen.setDisable(true);
            txtCitizen.setText(String.valueOf(selectedItem.getCitizenId()));
            txtName.setText(selectedItem.getName());
            txtAddress.setText(selectedItem.getAddress());
            txtPhone.setText(selectedItem.getPhone());
            txtEmail.setText(selectedItem.getEmail());
            txtUsername.setText(selectedItem.getUsername());;
            txtBirthDate.setValue(LocalDate.parse(String.valueOf(selectedItem.getBirthdate())));

            txtNominal.setDisable(false);
            txtTransaction.setDisable(false);
            btnTransaction.setDisable(false);

            TransactionDaoImpl transactionDao = new TransactionDaoImpl();
            tlist = (ObservableList<FeTransaction>) transactionDao.showData();
            tableView2.setItems(tlist);
            colTransaction.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getTransDate())));
            colNominal.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getNominal())));

            PointDaoImpl pointDao = new PointDaoImpl();
            plist = (ObservableList<FePoint>) pointDao.showData();
            tableview3.setItems(plist);
            colIdPoint.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getId())));
            colPoint.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getValue())));
        }
    }

    public void saveMemberAction(ActionEvent event) {
        if (txtCitizen.getText().isEmpty() || txtName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtPhone.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all data needed");
            alert.showAndWait();

        }
        else {
            FeMember m1 = new FeMember();
            m1.setCitizenId(txtCitizen.getText());
            m1.setName(txtName.getText());
            m1.setAddress(txtAddress.getText());
            m1.setPhone(txtPhone.getText());
            m1.setEmail(txtEmail.getText());
            m1.setUsername(txtUsername.getText());
            m1.setBirthdate(Date.valueOf(txtBirthDate.getValue()));

            MemberDaoImpl memberDao = new MemberDaoImpl();
            memberDao.addData(m1);
            mlist.clear();
            mlist.addAll(memberDao.showData());
        }
        txtCitizen.clear();
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtUsername.clear();
        txtBirthDate.setValue(null);

        label1.setText(String.valueOf(mlist.stream().count()));
    }

    public void resetAction(ActionEvent event) {
        txtCitizen.clear();
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtUsername.clear();
        txtBirthDate.setValue(null);
    }

    public void updateAction(ActionEvent event) {
        btnSave.setDisable(false);
//        btnUpdate.setDisable(true);

        FeMember selected;
        selected = tableView.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        selected.setCitizenId(txtCitizen.getText());
        selected.setName(txtName.getText());
        selected.setAddress(txtAddress.getText());
        selected.setPhone(txtPhone.getText());
        selected.setEmail(txtEmail.getText());
        selected.setUsername(txtUsername.getText());
        selected.setBirthdate(Date.valueOf(txtBirthDate.getValue()));

        MemberDaoImpl memberDao = new MemberDaoImpl();
        memberDao.updateData(selected);
        mlist.clear();
        mlist.addAll(memberDao.showData());
        txtCitizen.clear();
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtUsername.clear();
        txtBirthDate.setValue(null);
    }

    public void saveTransAction(ActionEvent event) {
        selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (txtNominal.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all data needed");
            alert.showAndWait();

        }
        else {
            FeTransaction t1 = new FeTransaction();
            t1.setTransDate(Date.valueOf(txtTransaction.getValue()));
            t1.setNominal(Long.parseLong(txtNominal.getText()));

            TransactionDaoImpl transactionDao = new TransactionDaoImpl();
            transactionDao.addData(t1);
            tlist.clear();
            tlist.addAll(transactionDao.showData());
        }
        txtTransaction.setValue(null);
        txtNominal.clear();
    }
}