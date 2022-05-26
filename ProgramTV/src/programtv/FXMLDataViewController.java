/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import programtv.db.DBHandler;
import programtv.model.TvProperty;


public class FXMLDataViewController implements Initializable {

    @FXML
    private TableView<TvProperty> tblTv;

    @FXML
    private TableColumn<TvProperty, String> colUkuran;

    @FXML
    private TableColumn<TvProperty, String> colMerk;

    @FXML
    private TableColumn<TvProperty, String> colKd_tv;

    @FXML
    private TableColumn<TvProperty, String> colNama_produk;

    @FXML
    private TableColumn<TvProperty, String> colHarga;

    @FXML
    private TableColumn<TvProperty, String> colTglProduksi;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }
    
    @FXML
    void viewEditDataTv(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLEditForm.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataTv(ActionEvent event) {
        TvProperty t = tblTv.getSelectionModel().getSelectedItem();
        int ans = JOptionPane.showConfirmDialog(null, "Yakin Akan Menghapus?");
        if (ans == JOptionPane.YES_OPTION) {
            DBHandler dh = new DBHandler("MYSQL");
            dh.deleteTv(t);
            showDataTv();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataTv();
        tblTv.getSelectionModel().selectedIndexProperty().addListener(evt -> {
//            JOptionPane.showMessageDialog(null,"Test Klik");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataTv() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<TvProperty> data = dh.getTv();
        colMerk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        colKd_tv.setCellValueFactory(new PropertyValueFactory<>("kd_tv"));
        colNama_produk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colUkuran.setCellValueFactory(new PropertyValueFactory<>("ukuran"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colTglProduksi.setCellValueFactory(new PropertyValueFactory<>("tgl_produksi"));
        tblTv.setItems(null);
        tblTv.setItems(data);
    }   
    
}

