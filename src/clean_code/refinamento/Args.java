package clean_code.refinamento;

import java.util.*;

import static clean_code.refinamento.ArgsException.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static clean_code.refinamento.ArgsException.ErrorCode.UNESPECTED_ARGUMENT;

public class Args {
    private Map<Character, ArgumentMarshaler> marsharlers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public Args(String schema, String[] args) throws ArgsException {
        marsharlers = new HashMap<>();
        argsFound = new HashSet<>();

        parseSchema(schema);
        parseArgumentStrings(Arrays.asList(args));
    }

    private void parseSchema(String schema) throws ArgsException{
        for(String element : schema.split(","))
            if(element.length() > 0)
                parseSchemaElement(element.trim());
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if(elementTail.length() == 0)
            marsharlers.put(elementId, new BooleanArgumentMarshaler());
        else if(elementTail.equals("*"))
            marsharlers.put(elementId, new StringArgumentMarshaler());
        else if(elementTail.equals("#"))
            marsharlers.put(elementId, new IntegerArgumentMarshaler());
        else if(elementTail.equals("##"))
            marsharlers.put(elementId, new DoubleArgumentMarshaler());
      //  else if(elementTail.equals("[*]"))
     //       marsharlers.put(elementId, new StringArrayArgumentMarshaler());
        else
            throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementTail, elementId);
    }

    private void validateSchemaElementId(char elementId) throws ArgsException{
        if(!Character.isLetter(elementId))
            throw new ArgsException(INVALID_ARGUMENT_FORMAT, null, elementId);
    }

    private void parseArgumentStrings(List<String> argsList) throws ArgsException{
        for(currentArgument = argsList.listIterator(); currentArgument.hasNext();){
            String argString = currentArgument.next();
            if(argString.startsWith("-")){
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException{
        for(int i = 0; i< argChars.length(); i++)
            parseArgumentCharacter(argChars.charAt(1));
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException{
        ArgumentMarshaler m = marsharlers.get(argChar);
        if(m == null){
            throw new ArgsException(UNESPECTED_ARGUMENT, null, argChar);
        } else {
            argsFound.add(argChar);
            try{
                m.set(currentArgument);
            } catch (ArgsException e){
                e.setErrorArgumentId(argChar);
                throw e;
            }
        }
    }

    public boolean has(char arg){
        return argsFound.contains(arg);
    }

    public int nextArgument(){
        return currentArgument.nextIndex();
    }

    public boolean getBoolean(char arg){
        return BooleanArgumentMarshaler.getValue(marsharlers.get(arg));
    }

    public String getString(char arg){
        return StringArgumentMarshaler.getValue(marsharlers.get(arg));
    }

    public int getInt(char arg){
        return IntegerArgumentMarshaler.getValue(marsharlers.get(arg));
    }

    public double getDouble(char arg){
        return DoubleArgumentMarshaler.getValue(marsharlers.get(arg));
    }
/*
    public String[] getStringArray(char arg){
        return StringArrayArgumentMarshaler.getValue(marsharlers.get(arg));
    }
    */

}
