package clean_code.refinamento;

import junit.framework.TestCase;
import org.junit.Test;

public class ArgsTest extends TestCase {

    public void testCreateWithNoSchemOrArguments() throws Exception{
        Args args = new Args("", new String[0]);
      //  assertEquals(0, args.);
    }

    @Test
    public void testInvalidDouble() throws Exception{
        Args args = new Args("x##", new String[] {"-x", "Forty two"});
      //  assertFalse(args.isValid());
        //assertEquals(0, args.ca
    }
}
