package test.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.parser.LexemeParser;
import by.training.task2.parser.LexemePartParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class LexemeParserTest {

    @DataProvider(name = "lexems4empty")
    public static Object[][] createLexems(){
        return new Object[][]{
                {"test,",  new ArrayList<>(Arrays.asList(new Word(), new PunctualMark()))},
                {",test",  new ArrayList<>(Arrays.asList(new PunctualMark(), new Word()))},
                {"test",  new ArrayList<>(Arrays.asList(new Word()))},
                {",",  new ArrayList<>(Arrays.asList(new PunctualMark()))},
                {"\"I'm fine,\".",  new ArrayList<>(Arrays.asList(new Word(), new PunctualMark()))},
                {"", new ArrayList<>()}
        };
    }
    @Test(description = "check correct parsing lexems into words&punctual marks without next parsing", dataProvider = "lexems4empty")
    public void parseTest(String lexemStr, ArrayList<LexemePart> expectedList){
        Lexeme actual = new Lexeme();
        LexemeParser lexemeParser = new LexemeParser();
        lexemeParser.parse(actual, lexemStr);
        Lexeme expected = new Lexeme();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "full lexems")
    public static Object[][] createFullLexems(){
        Word word = new Word();
        word.addComponents(Arrays.asList(new Symbol('t'), new Symbol('e'), new Symbol('s'), new Symbol('t')));
        PunctualMark coma = new PunctualMark();
        coma.addComponent(new Symbol(','));
        Word speach = new Word();
        speach.addComponents(Arrays.asList(new Symbol('\"'), new Symbol('I'), new Symbol('\''), new Symbol('m'), new Symbol(' '), new Symbol('f'), new Symbol(','), new Symbol('\"')));
        PunctualMark dots = new PunctualMark();
        dots.addComponents(Arrays.asList(new Symbol('.'), new Symbol('.'), new Symbol('.')));
        return new Object[][]{
                {"test,",  new ArrayList<>(Arrays.asList(word, coma))},
                {",test",  new ArrayList<>(Arrays.asList(coma, word))},
                {"test",  new ArrayList<>(Collections.singletonList(word))},
                {",",  new ArrayList<>(Collections.singletonList(coma))},
                {"\"I'm f,\"...",  new ArrayList<>(Arrays.asList(speach, dots))},
                {"", new ArrayList<>()}
        };
    }
    @Test(description = "check correct parsing lexems into words&punctual marks without next parsing", dataProvider = "full lexems")
    public void parseFullyTest(String lexemStr, ArrayList<LexemePart> expectedList){
        Lexeme actual = new Lexeme();
        LexemeParser lexemeParser = new LexemeParser();
        lexemeParser.setNext(new LexemePartParser());
        lexemeParser.parse(actual, lexemStr);
        Lexeme expected = new Lexeme();
        expected.addComponents(expectedList);
        assertEquals(actual, expected);
    }
}
