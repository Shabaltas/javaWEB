package test.task2;

import by.training.task2.composite.Text;
import by.training.task2.parser.*;
import by.training.task2.reader.Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class MainTest {

    @DataProvider(name = "data")
    public static Object[][] createData(){
        return new Object[][]{
                {"data\\input.txt", "\t\"It has,\" - survived not only five centuries , but also the leap into electronic " +
                        "typesetting, remaining essentially unchanged. It was popularised in the with the " +
                        "release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                        "desktop publishing software like Aldus PageMaker including versions of \"Lorem Ipsum...\" \r\n" +
                        "\tIt is \"a long??\" Established fact that a reader will be distracted by the readable " +
                        "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
                        "more-or-less normal distribution of letters, as opposed to using \"Content here, content " +
                        "here\", making it look like readable English. \r\n" +
                        "\tIt is a established fact that a reader will be of a page when looking \"at its " +
                        "layout.\" \r\n" +
                        "\tBye. \r\n"},
                {"data\\empty.txt", ""},
                {"data\\dots.txt", "\tSomoooething g-j,\"I k,\",gfd-f . Gad-ljh - good-selling, any ,do! \r\n" +
                        "\tBye. \r\n"}
        };
    }

    @Test(description = "check correct parsing & compose method", dataProvider = "data")
    public void mainTest(String fname, String expected) throws IOException {
        String textStr = new Reader().readFileToString(fname);
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = (ParagraphParser)textParser.setNext(new ParagraphParser());
        SequenceParser sequenceParser = (SequenceParser)paragraphParser.setNext(new SequenceParser());
        LexemeParser lexemeParser = (LexemeParser)sequenceParser.setNext(new LexemeParser());
        LexemePartParser lexemePartParser = (LexemePartParser)lexemeParser.setNext(new LexemePartParser());

        Text text = new Text();
        textParser.parse(text, textStr);

        assertEquals(text.compose().toString(), expected);
    }
}
