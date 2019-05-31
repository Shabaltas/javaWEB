package test.task1.parser;

import by.training.task1.parser.Parser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ParserTest {

    @DataProvider(name = "wrongFile")
    public static Object[][] createIncorrestFileNames() {
        return new Object[][]{
                {"dat\\input.txt", },
                {"", }
        };
    }
    @Test(dataProvider = "wrongFile")
    public static void parseFromBufExepTest(String filename) {
        assertThrows(IOException.class, () -> new Parser().parseFromBuf(filename));
    }

    @DataProvider(name = "rightFile")
    public static Object[][] createCorrestFileNames() {
        List<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> line1 = new ArrayList<>(Arrays.asList("PASSENGER", "4", "2", "12000", "A", "SEDAN"));
        expected.add(line1);
        ArrayList<String> line2 = new ArrayList<>(Arrays.asList("AUTOTRUCK", "7", "12", "15000.200", "LOOSE", "4", "MINITRUCKBUS"));
        expected.add(line2);
        ArrayList<String> line3 = new ArrayList<>(Arrays.asList("AUTOTRUCK", "7", "9LOOSE", "2", "MINRUCKBUS"));
        expected.add(line3);
        ArrayList<String> line4 = new ArrayList<>(Arrays.asList("CARGOPASSENGER", "6", "8", "17500", "OVERALL", "PICKUP"));
        expected.add(line4);
        return new Object[][]{
                {"data\\forParserTest.txt", expected},
                {"data\\empty.txt", new ArrayList<>()}
        };
    }
    @Test(dataProvider = "rightFile")
    public static void parseFromBufTest(String filename, List<ArrayList<String>> params) {
        try {
            assertEquals(new Parser().parseFromBuf(filename), params);
        } catch (IOException e) {
            fail();
        }
    }
}
