package test.task2.reader;

import by.training.task2.reader.Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class ReaderTest {

    @DataProvider(name = "okFiles")
    public static Object[][] createGoodNames(){
        return new Object[][]{
                {"data\\dots.txt", "\t\tSomoo0oething g-j,\"I k,\",gfd-f . Gad-ljh - good-selling, any ,do!\r\n" +
                        "\t\tBye."},
                {"data\\input.txt", "\t\t\"It has,\" - survived not only five centuries , but also the leap into electronic\r\n" +
                        "typesetting, remaining essentially unchanged. It was popularised in the with the\r\n" +
                        "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\r\n" +
                        "desktop publishing software like Aldus PageMaker including versions of \"Lorem Ipsum...\"\r\n" +
                        "\t\tIt is \"a long??\" Established fact that a reader will be distracted by the readable\r\n" +
                        "content of a page when looking at its layout. The point of using Ipsum is that it has a\r\n" +
                        "more-or-less normal distribution of letters, as opposed to using 'Content here, content\r\n" +
                        "here', making it look like readable English.\r\n" +
                        "\t\tIt is a established fact that a reader will be of a page when looking \"at its\r\n" +
                        "layout.\"\r\n" +
                        "\t\tBye."},
                {"data\\empty.txt", ""}
        };
    }

    @DataProvider(name = "with Exception")
    public static Object[] createBadNames(){
        return new Object[]{"data\\dot.txt", ""};
    }

    @Test(dataProvider = "okFiles", description = "check correct reading file into string")
    public void readFileToStringTest(String fname, String expected) throws IOException {
        String actual = new Reader().readFileToString(fname);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "with Exception", description = "check to see if an exception is thrown")
    public void readFileToStringExceptionTest(String fname) {
        assertThrows(IOException.class, () -> new Reader().readFileToString(fname));
    }
}
