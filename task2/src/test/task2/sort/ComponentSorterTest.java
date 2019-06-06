package test.task2.sort;

import by.training.task2.composite.*;
import by.training.task2.sort.ComponentSorter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ComponentSorterTest {

    @DataProvider(name = "4sortByComponents")
    public static Object[][] createListsByComponents() {
        Paragraph paragraph1 = new Paragraph();
        Paragraph paragraph2 = new Paragraph();
        Paragraph paragraph3 = new Paragraph();
        paragraph1.addComponent(new Sequence());
        paragraph2.addComponents(Arrays.asList(new Sequence(), new Sequence()));
        paragraph3.addComponents(Arrays.asList(new Sequence(), new Sequence(), new Sequence()));
        Word word1 = new Word();
        Word word2 = new Word();
        word1.addComponent(new Symbol('f'));
        word2.addComponents(Arrays.asList(new Symbol('g'), new Symbol('k')));
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(paragraph3, paragraph2, paragraph1)), new ArrayList<>(Arrays.asList(paragraph1, paragraph2, paragraph3))},
                {new ArrayList<>(), new ArrayList<>()},
                {new ArrayList<>(Arrays.asList(word2, word1)), new ArrayList<>(Arrays.asList(word1, word2))}
        };
    }

    @Test(description = "check correct sorting composits by the count of their \"children\"", dataProvider = "4sortByComponents")
    public <T extends Composite> void sortByComponentsTest(List<T> compositeList, List<T> expected) {
        new ComponentSorter().sortByComponents(compositeList);
        assertEquals(expected, compositeList);
    }

    @DataProvider(name = "4sortComponents")
    public static Object[][] createComposites() {
        Text text = new Text();
        Paragraph paragraph1 = new Paragraph();
        Paragraph paragraph2 = new Paragraph();
        Paragraph paragraph3 = new Paragraph();
        paragraph1.addComponent(new Sequence());
        paragraph2.addComponents(Arrays.asList(new Sequence(), new Sequence()));
        paragraph3.addComponents(Arrays.asList(new Sequence(), new Sequence(), new Sequence()));
        text.addComponents(Arrays.asList(paragraph3, paragraph1, paragraph2));
        return new Object[][]{
                {text, new ArrayList<>(Arrays.asList(paragraph1, paragraph2, paragraph3))},
                {new Text(), new ArrayList<>()},
        };
    }

    @Test(description = "check correct sorting composite's \"children\" by the count of their \"children\"", dataProvider = "4sortComponents")
    public void sortComponentsTest(Text composite, List<Paragraph> expectedList) {
        new ComponentSorter().sortComponents(composite);
        Text expected = new Text();
        expected.addComponents(expectedList);
        assertEquals(composite, expected);
    }

    @DataProvider(name = "4sortWords")
    public static Object[][] createLexemes() {
        Lexeme lexeme1 = new Lexeme();
        Lexeme lexeme2 = new Lexeme();
        Lexeme lexeme3 = new Lexeme();
        Lexeme lexeme4 = new Lexeme();
        Lexeme lexeme5 = new Lexeme();
        Word word1 = new Word();
        Word word2 = new Word();
        Word word3 = new Word();
        Word word4 = new Word();
        PunctualMark mark1 = new PunctualMark();
        PunctualMark mark2 = new PunctualMark();
        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');
        Symbol c = new Symbol('c');
        Symbol dot = new Symbol('.');
        Symbol coma = new Symbol(',');
        word1.addComponent(b);
        word2.addComponents(Arrays.asList(a, b));
        word3.addComponents(Arrays.asList(a, b, c));
        word4.addComponents(Arrays.asList(c, b, a));
        mark1.addComponents(Arrays.asList(dot, dot, dot));
        mark2.addComponent(coma);
        lexeme1.addComponents(Arrays.asList(word1, mark1));
        lexeme2.addComponent(word2);
        lexeme3.addComponent(word3);
        lexeme4.addComponents(Arrays.asList(word4, mark2));
        lexeme5.addComponent(mark2);
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(lexeme3, lexeme1, lexeme5, lexeme4, lexeme2)), new ArrayList<>(Arrays.asList(lexeme1, lexeme2, lexeme5, lexeme3, lexeme4))},
                {new ArrayList<>(), new ArrayList<>()}
        };
    }
    @Test(description = "check correct sorting lexemes by their words", dataProvider = "4sortWords")
    public void sortWordsTest(List<Lexeme> lexemes, List<Lexeme> expectedList) {
        new ComponentSorter().sortWords(lexemes);
        assertEquals(expectedList, lexemes);
    }

    @DataProvider(name = "4sortSequence")
    public static Object[][] createSequences() {
            Object[][] prev = createLexemes();
            Sequence sequence1 = new Sequence();
            sequence1.addComponents((ArrayList) prev[0][0]);
            return new Object[][]{
                    {sequence1, prev[0][1]},
                    {new Sequence(), new ArrayList<>()}
            };
    }
    @Test(description = "check correct sorting sequence's lexemes by their words", dataProvider = "4sortSequence")
    public void sortSequenceTest(Sequence sequence, List<Lexeme> expectedList) {
        new ComponentSorter().sortSequence(sequence);
        Sequence expected = new Sequence();
        expected.addComponents(expectedList);
        assertEquals(sequence, expected);
    }
}
