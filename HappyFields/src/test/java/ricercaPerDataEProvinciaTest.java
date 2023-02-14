import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import model.*;
import model.Sport;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import model.Campo ;
import java.sql.Date;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ricercaPerDataEProvinciaTest {

    gestioneEventiService ge = new gestioneEventiServiceImpl();

    public static Stream<Arguments> provideDataProvinciaInfo() {
        //String str="2023-04-01";
       // String str2="2021-02-15";
        //java.sql.Date dateT = java.sql.Date.valueOf(str2);
        //java.sql.Date dateT2 = java.sql.Date.valueOf(str);

        String prov= "SA";
        return Stream.of(
                Arguments.of("2022-04-01", "AV"),
                Arguments.of("2023-04-01", "Avv"),
                Arguments.of("2023-04-01", prov)
        );
    };

    @ParameterizedTest
    @MethodSource("provideDataProvinciaInfo")
    public void  testRicerca(Date data, String provincia){

        assertNotNull(ge.doRetriveBySearch(data, provincia));

    }


}
