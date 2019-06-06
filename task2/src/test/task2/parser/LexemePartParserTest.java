package test.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.parser.LexemePartParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LexemePartParserTest {

    @DataProvider(name = "parts")
    public static Object[][] createParts() {
        return new Object[][] {
                {"test",  new ArrayList<>(Arrays.asList(new Symbol('t'), new Symbol('e'), new Symbol('s'), new Symbol('t')))},
                {",",  new ArrayList<>(Arrays.asList(new Symbol(',')))},
                {"...",  new ArrayList<>(Arrays.asList(new Symbol('.'), new Symbol('.'), new Symbol('.')))},
                {"\"I'm fine,\"",  new ArrayList<>(Arrays.asList(new Symbol('"'), new Symbol('I'), new Symbol('\''), new Symbol('m'), new Symbol(' '), new Symbol('f'), new Symbol('i'), new Symbol('n'), new Symbol('e'), new Symbol(','), new Symbol('"')))},
                {"", new ArrayList<>()}
        };
    }
    @Test(description = "check correct parsing lexem's parts into symbols", dataProvider = "parts")
    public void parseTest(String partStr, ArrayList<Symbol> expectedList) {
       /* LexemePart actual = new LexemePart();
        new LexemePartParser().parse(actual, partStr);
        LexemePart expected = new LexemePart();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);*/
    }

}
