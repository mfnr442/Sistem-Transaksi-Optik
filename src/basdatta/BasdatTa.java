package basdatta;

import Database.Koneksi;
import View.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasdatTa {

    public static void main(String[] args) {
        try {
            new Menu().show();
        } catch (Exception ex) {
            Logger.getLogger(BasdatTa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
