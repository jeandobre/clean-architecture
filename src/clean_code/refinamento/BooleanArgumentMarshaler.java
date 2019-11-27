package clean_code.refinamento;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {

    private boolean booleanValue = false;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaler am){
        if(am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}
