import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import persistenza.persistenzaServiceImpl;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.Instant;
import java.util.stream.Stream;

public class creazioneEventoTest {
    persistenzaServiceImpl ps = new persistenzaServiceImpl();



    public static Stream<Arguments> provideUserInfo() {
        Campo ca = new Campo("San Siro","SA","Salerno","Alfani",50.00,100,50,11);
        Sport spo = new Sport("Basket");
        java.sql.Date dateT1 = new java.sql.Date(5000,8,07);
        String str="2023-02-15";
        java.sql.Date dateT2 = java.sql.Date.valueOf(str);


        return Stream.of(
                //Nome troppo lungo
               // Arguments.of("Coppa con nome troppo lungo perp assare il testcase", spo,ca,dateT1, 20.00)//Funziona bisogna solo risolvere data
               // Il campo “data”  viene prima della data attuale
                Arguments.of("Coppa", spo,ca, dateT2, 20.00)

                /* La creazione va a buon fine
                Arguments.of("Coppa", "Basket", "San Siro", "07/08/23", 20.00 )**/

        );

    }

    @ParameterizedTest
    @MethodSource("provideUserInfo")
    public void testCreazioneEvento(String nome,Sport sport, Campo campo , java.sql.Date dateAttuale, double ora){
        //campo = new Campo("San Paolo","SA","Salerno","Alfani",50.00,100,50,11);
        //sport = new Sport("Calcio");
        Evento e = new Evento(nome,sport, campo, dateAttuale, ora);
        assertTrue(ps.doAddEvento(e));

    }


}