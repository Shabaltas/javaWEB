package test.task2.parser;

import by.training.task2.composite.Paragraph;
import by.training.task2.composite.Text;
import by.training.task2.parser.TextParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    @DataProvider(name = "text4empty")
    public static Object[][] createTexts() {
        return new Object[][]{
                {"",  new ArrayList<>()},
                {" ",  new ArrayList<>(Arrays.asList(new Paragraph()))},
                {"\tHi... \r\n",  new ArrayList<>(Arrays.asList(new Paragraph()))},
                {"\tWhat \r\nis \r\n\tyour name?  ",  new ArrayList<>(Arrays.asList(new Paragraph(), new Paragraph()))},
        };
    }
    @Test(description = "check correct parsing text into paragraphs without next parsing", dataProvider = "text4empty")
    public void parseTest(String textStr, ArrayList<Paragraph> expectedList) {
        Text actual = new Text();
        TextParser textParser = new TextParser();
        textParser.parse(actual, textStr);
        Text expected = new Text();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);
    }
}
