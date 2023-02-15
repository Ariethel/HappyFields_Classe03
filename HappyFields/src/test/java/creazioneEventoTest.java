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
        String str="2023-03-15";
        String str2="2021-02-15";
        java.sql.Date dateT = java.sql.Date.valueOf(str2);
        java.sql.Date dateT2 = java.sql.Date.valueOf(str);

        return Stream.of(
                //Nome troppo lungo
                Arguments.of("Coppa con nome troppo lungo non entra      ok", spo,ca,dateT2, 20.00),//Funziona bisogna solo risolvere data
                //Il campo “data” viene prima della data attuale
                Arguments.of("Coppa1", spo,ca, dateT, 20.00),
                //L' orario è null
                Arguments.of("Coppa2", spo,ca, dateT2, 0.00),
                //La creazione va a buon fine
                Arguments.of("Coppa3", spo ,ca, dateT2, 20.00)

        );

    }

    @ParameterizedTest
    @MethodSource("provideUserInfo")
    public void testCreazioneEvento(String nome,Sport sport, Campo campo , java.sql.Date dateAttuale, double ora){
        Evento e = new Evento(nome,sport, campo, dateAttuale, ora);
        assertTrue(ps.doAddEventoAttesa(e));

    }


}