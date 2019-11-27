package clean_code.teste_aprendizagem;

import org.junit.Test;

import java.util.logging.Logger;

public class TesteLog4J {

    @Test
    public void testLogCreate(){
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("hello");
    }

    @Test
    public void testLogAddAppender(){
        Logger logger = Logger.getLogger("MyLogger");
        //ConsoleAppender appender = new ConsoleAppender();
        //logger.addAppender(appender);
        logger.info("oi");
    }
}
