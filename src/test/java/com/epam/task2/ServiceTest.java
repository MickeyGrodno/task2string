package com.epam.task2;

import com.epam.task2.entity.Text;
import com.epam.task2.parser.TextToWordParserImpl;
import com.epam.task2.service.TextFromFileReaderImpl;
import com.epam.task2.service.TextManipulationServiceImpl;
import com.epam.task2.service.interfaces.TextManipulationService;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;

public class ServiceTest {
    private static final String correctSortedWords = "Java  Smalltalk  абсолютно  академический  Алан  быть  в  виде  Все  вы  вывел  выполнить  данные  задачи  запросами  здание  и  из  итог  к  к  как  Кей  компонент  любой  может  можете  над  него  но  обращаться  объект  объекта  объектно-ориентированного  объектно-ориентированному  объектом  объекту  одного  он  операции  основных  первого  переменную  подвел  подход  представлен  Представляйте  представляют  предшественников  программированию  пять  решаемой  с  себе  собака  собой  Теоретически  требуя  у  удачного  услуга  усовершенствованную  характеристики  хранит  черт  чистый  Эти  является  языка  языка ";
    private static final String correctTextWithSortedSentencesByWordCount = """
            \s• Все является объектом.
            \sЭти характеристики представляют «чистый», академический подход к объектно-ориентированному программированию:
            \sТеоретически абсолютно любой компонент решаемой задачи (собака, здание, услуга) может быть представлен в виде объекта.
            \sАлан Кей подвел итог и вывел пять основных черт языка Smalltalk — первого удачного объектно-ориентированного языка, одного из предшественников Java.
            \sПредставляйте себе объект как усовершенствованную переменную; он хранит данные, но вы можете «обращаться с запросами» к объекту, требуя у него выполнить операции над собой.""";
    private static final String correctTextInString = """
            Алан Кей подвел итог и вывел пять основных черт языка Smalltalk — перво¬го удачного объектно-ориентированного языка, одного из предшественников Java. Эти характеристики представляют «чистый», академический подход к объектно-ориентированному программированию:
            • Все является объектом. Представляйте себе объект как усовершенство¬ванную переменную; он хранит данные, но вы можете «обращаться с за¬просами» к объекту, требуя у него выполнить операции над собой. Теоре¬тически абсолютно любой компонент решаемой задачи (собака, здание, услуга) может быть представлен в виде объекта.
            """;
    private static final String textFileAdress = "src\\test\\resources\\testData.txt";
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTest.class);
    private static Text text;
    private static PrintStream stream;

    @BeforeAll
    public static void createTestData() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("src\\test\\resources\\testData.txt"), StandardCharsets.UTF_8));
            writer.write(correctTextInString);
            writer.close();
        }
        catch (FileNotFoundException e) {
            LOGGER.error("Не удалось создать файл", e);
        }
        catch (IOException e) {
            LOGGER.error("Не удалось произвести запись в файл", e);
        }
            text = new TextToWordParserImpl().parseTextToWord(correctTextInString);
    }
    @BeforeEach
    public void cleanStream(){
        stream = mock(PrintStream.class);
        System.setOut(stream);
    }
    @Test
    public void readTextFromFileTest() {
        String textFromFileInString = TextFromFileReaderImpl.readTextFromFile(textFileAdress);
        Assertions.assertEquals(correctTextInString, textFromFileInString);

    }
    @Test
    public void printSortedSentencesByWordCountTest() {
        TextManipulationService service = new TextManipulationServiceImpl();
        service.printSortedSentencesByWordCount(text);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream, times(5)).println(captor.capture());
        String textInConsole = String.join("\n", captor.getAllValues());
        Assertions.assertEquals(correctTextWithSortedSentencesByWordCount, textInConsole);
    }
    @Test
    public void printAllSortedWordsTest() {
        TextManipulationService service = new TextManipulationServiceImpl();
        service.printAllSortedWords(text);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream, times(70)).print(captor.capture());
        String textInConsole = String.join(" ", captor.getAllValues());
        Assertions.assertEquals(correctSortedWords, textInConsole);
    }
    @AfterAll
    public static void deleteTestData() {
        File file = new File("src\\test\\resources\\testData.txt");
        if (file.delete()) {
            LOGGER.info("Файл testData.txt был удален.");
        }
        else {
            LOGGER.info("Не удалось удалить файл testData.txt");
        }
    }
}