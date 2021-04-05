package com.epam.task2;

import com.epam.task2.entity.Sentence;
import com.epam.task2.entity.Text;
import com.epam.task2.parser.ParagraphToSentenceParserImpl;
import com.epam.task2.parser.SentenceToWordAndMarkParserImpl;
import com.epam.task2.parser.TextToParagraphParserImpl;
import com.epam.task2.parser.TextToWordParserImpl;
import com.epam.task2.parser.interfaces.ParagraphToSentenceParser;
import com.epam.task2.parser.interfaces.SentenceToWordAndMarkParser;
import com.epam.task2.parser.interfaces.TextToParagraphParser;
import com.epam.task2.parser.interfaces.TextToWordParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {
    String sentenceString = "Алан Кей подвел итог и вывел пять основных черт языка Smalltalk — первого удачного объектно-ориентированного языка, одного из предшественников Java.";
    String textOneParagraphString = "Алан Кей подвел итог и вывел пять основных черт языка Smalltalk — первого удачного объектно-ориентированного языка, одного из предшественников Java. Эти характеристики представляют «чистый», академический подход к объектно-ориентированному программированию." +
            "• Все является объектом. Представляйте себе объект как усовершенство¬ванную переменную; он хранит данные, но вы можете «обращаться с за¬просами» к объекту, требуя у него выполнить операции над собой. Теоре¬тически абсолютно любой компонент решаемой задачи (собака, здание, услуга и т. п.) может быть представлен в виде объекта. " +
            "• Программа — это группа объектов, указывающих друг другу, что де¬лать, посредством сообщений. Чтобы обратиться с запросом к объекту, вы «посылаете ему сообщение». Более наглядно можно представить сооб¬щение как вызов метода, принадлежащего определенному объекту. " +
            "• Каждый объект имеет собственную «память», состоящую из других объектов. Иными словами, вы создаете новый объект с помощью встраи¬вания в него уже существующих объектов. Таким образом, можно сконст¬руировать сколь угодно сложную программу, скрыв общую сложность за простотой отдельных объектов. " +
            "• У каждого объекта есть тип. В других терминах, каждый объект являет¬ся экземпляром класса, где «класс» является аналогом слова «тип». Важ¬нейшее отличие классов друг от друга как раз и заключается в ответе на вопрос: «Какие сообщения можно посылать объекту?» " +
            "• Все объекты определенного типа могут получать одинаковые сообще¬ния. Как мы вскоре убедимся, это очень важное обстоятельство. Так как объект типа «круг» также является объектом типа «фигура», справедливо утверждение, что «круг» заведомо способен принимать сообщения для «фигуры». А это значит, что можно писать код для фигур и быть уверен¬ным в том, что он подойдет для всего, что попадает под понятие фигуры. Взаимозаменяемость представляет одно из самых мощных понятий ООП. " +
            "Буч предложил еще более лаконичное описание объекта." +
            "Объект обладает состоянием, поведением и индивидуальностью.";
    String textThreeParagraphString = "Алан Кей подвел итог и вывел пять основных черт языка Smalltalk — перво¬го удачного объектно-ориентированного языка, одного из предшественников Java. Эти характеристики представляют «чистый», академический подход к объектно-ориентированному программированию:\n" +
            "• Все является объектом. Представляйте себе объект как усовершенство¬ванную переменную; он хранит данные, но вы можете «обращаться с за¬просами» к объекту, требуя у него выполнить операции над собой. Теоре¬тически абсолютно любой компонент решаемой задачи (собака, здание, услуга и т. п.) может быть представлен в виде объекта.\n" +
            "• Программа — это группа объектов, указывающих друг другу, что де¬лать, посредством сообщений. Чтобы обратиться с запросом к объекту, вы «посылаете ему сообщение». Более наглядно можно представить сооб¬щение как вызов метода, принадлежащего определенному объекту.";
    @Test
    public void parseParagraphToSentenceTest() {
        String correctValue = "Взаимозаменяемость представляет одно из самых мощных понятий ООП.";
        ParagraphToSentenceParser parser = new ParagraphToSentenceParserImpl();
        String[] sentence = parser.parseParagraphToSentence(textOneParagraphString);
        Assertions.assertEquals(correctValue, sentence[14]);
    }
    @Test
    public void parseSentenceToWordAndMarkTest() {
        SentenceToWordAndMarkParser parser = new SentenceToWordAndMarkParserImpl();
        Sentence sentence = parser.parseSentenceToWordAndMark(sentenceString);
        Assertions.assertEquals("Smalltalk", sentence.getListOfComponents().get(20).returnString());
    }
    @Test
    public void parseTextToParagraphTest() {
        String correctValue = "• Программа — это группа объектов, указывающих друг другу, что де¬лать, посредством сообщений. Чтобы обратиться с запросом к объекту, вы «посылаете ему сообщение». Более наглядно можно представить сооб¬щение как вызов метода, принадлежащего определенному объекту.";
        TextToParagraphParser parser = new TextToParagraphParserImpl();
        String[] paragraphs = parser.parseTextToParagraph(textThreeParagraphString);
        Assertions.assertEquals(3, paragraphs.length);
        Assertions.assertEquals(correctValue, paragraphs[2]);
    }
    @Test
    public void parseTextToWordAndMarkTest() {
        String correctValue = "Кей";
        TextToWordParser parser = new TextToWordParserImpl();
        Text text = parser.parseTextToWord(textThreeParagraphString);
        String value = text.getListOfComponents().get(0).getListOfComponents().get(0).getListOfComponents().get(2).returnString();
        Assertions.assertEquals(3, text.getListOfComponents().size());
        Assertions.assertEquals(correctValue, value);
    }
}
