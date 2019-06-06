package test.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.parser.SequenceParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SequenceParserTest {
    @DataProvider(name = "sequence4empty")
    public static Object[][] createSequences() {
        return new Object[][]{
                {" ",  new ArrayList<>()},
                {"Hi...  ",  new ArrayList<>(Arrays.asList(new Lexeme()))},
                {"What is your name?  ",  new ArrayList<>(Arrays.asList(new Lexeme(), new Lexeme(), new Lexeme(), new Lexeme()))},
                {"LAalal,la ...  ",  new ArrayList<>(Arrays.asList(new Lexeme(), new Lexeme()))},
                {"\"I'm fine,thanks,\" - she said.  ",  new ArrayList<>(Arrays.asList(new Lexeme(), new Lexeme(), new Lexeme(), new Lexeme()))},
        };
    }
    @Test(description = "check correct parsing sequences into lexems without next parsing", dataProvider = "sequence4empty")
    public void parseTest(String sequenceStr, ArrayList<Lexeme> expectedList) {
        Sequence actual = new Sequence();
        SequenceParser sequenceParser = new SequenceParser();
        sequenceParser.parse(actual, sequenceStr);
        Sequence expected = new Sequence();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);
    }
}
