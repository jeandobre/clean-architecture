package clean_code.refinamento;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static clean_code.refinamento.ArgsException.ErrorCode.INVALID_INTEGER;
import static clean_code.refinamento.ArgsException.ErrorCode.MISSING_STRING;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {

    private int intValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try{
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e){
            throw new ArgsException(MISSING_STRING);
        } catch (NumberFormatException e){
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am){
        if(am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}
