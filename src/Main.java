import Controllers.ApplicationController;
import Database.DB;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
//        DB db = DB.getInstance();
//        System.out.println(db.getCount("customers"));
//        db.closeConnection();
        ApplicationController app = new ApplicationController();
        app.startApp();
    }
}
