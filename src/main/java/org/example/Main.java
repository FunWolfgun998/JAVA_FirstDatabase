import org.example.Database;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static java.lang.IO.println;
import static java.lang.IO.readln;

void main(){
    Database database = null;
    try {
        database = Database.getInstance();
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();
        Database database3 = Database.getInstance();
        println(database);
        println(database1);
        println(database2);
        println(database3);
        /*
        Senza singleton
        org.example.Database@42f30e0a
        org.example.Database@24273305
        org.example.Database@5b1d2887
        org.example.Database@46f5f779
        Con il singleton
        org.example.Database@66133adc
        org.example.Database@66133adc
        org.example.Database@66133adc
        org.example.Database@66133adc
        */
    } catch (SQLException e) {
        println("Impossibile connettersi al database: " + e.getMessage());
        System.exit(-1);
    }
    println("Connessione database avvenuta con successo");
    database.insertPiatto(
    readln("Inserisci nome piatto"),
            Double.parseDouble(readln("Inserisci prezzo")),
            Integer.parseInt(readln("Inserisci quantità"))
    );

    //database.insertPiatto("urama mura", 4.5, 5);
}