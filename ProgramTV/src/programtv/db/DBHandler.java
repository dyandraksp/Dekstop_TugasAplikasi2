
package programtv.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programtv.model.Tv;
import programtv.model.TvProperty;


public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addTv(Tv t){
        String insertTv = "INSERT INTO `produk`(`kd_tv`, `nama_produk`, `tgl_produksi`, `harga`)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertTv);
            stmtInsert.setString(1, t.getKd_tv());
            stmtInsert.setString(2, t.getNama());
            stmtInsert.setString(3, t.getTglProduksi());
            stmtInsert.setString(4, t.getHarga());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<TvProperty> getTv(){
        ObservableList<TvProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT `kd_tv`, `nama_produk`, `tgl_produksi`, `merk`, `ukuran`, `harga` FROM `produk` ORDER BY `kd_tv`";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                TvProperty t = new TvProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                data.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public void deleteTv(TvProperty t){
        String deleteTv = "DELETE FROM produk WHERE `produk`.`kd_tv` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteTv);
            stmtDelete.setString(1, t.getKd_tv());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTv(TvProperty t){
        String updateTv = "UPDATE `produk` SET `produk`.`kd_tv` = ?, `produk`.`nama_produk` = ?,`produk`.`tgl_produksi` = ?,`produk`.`merk` = ?,`produk`.`ukuran` = ?,`produk`.`harga` = ? WHERE `produk`.`kd_tv` = ?";
        try {
            PreparedStatement stmtUpdate = conn.prepareStatement(updateTv);
            stmtUpdate.setString(1, t.getKd_tv());
            stmtUpdate.setString(2, t.getNama_produk());
            stmtUpdate.setString(3, t.getTgl_produksi());
            stmtUpdate.setString(4, t.getMerk());
            stmtUpdate.setString(5, t.getUkuran());
            stmtUpdate.setString(6, t.getHarga());
            stmtUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
