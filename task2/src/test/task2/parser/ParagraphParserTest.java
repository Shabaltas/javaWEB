package test.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.parser.LexemeParser;
import by.training.task2.parser.LexemePartParser;
import by.training.task2.parser.ParagraphParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {

    @DataProvider(name = "paragraph4empty")
    public static Object[][] createParagraphs(){
        return new Object[][]{
                {"",  new ArrayList<>()},
                {"Hi...",  new ArrayList<>(Arrays.asList(new Sequence()))},
                {"Hi. What is your name?",  new ArrayList<>(Arrays.asList(new Sequence(), new Sequence()))},
                {"Hi. \nWhat is your name?",  new ArrayList<>(Arrays.asList(new Sequence(), new Sequence()))},
                {"\"I'm fine,thanks!\" ",  new ArrayList<>(Arrays.asList(new Sequence()))},
                {"He asked:\"You?\"  She answered: \" Yes...\"", new ArrayList<>(Arrays.asList(new Sequence(), new Sequence()))}
        };
    }
    @Test(description = "check correct parsing paragraphs into sequences without next parsing", dataProvider = "paragraph4empty")
    public void parseTest(String paragraphStr, ArrayList<Sequence> expectedList){
        Paragraph actual = new Paragraph();
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.parse(actual, paragraphStr);
        Paragraph expected = new Paragraph();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);
    }
}
