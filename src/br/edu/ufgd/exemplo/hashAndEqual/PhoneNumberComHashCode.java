package br.edu.ufgd.exemplo.hashAndEqual;

import java.util.Objects;

public final class PhoneNumberComHashCode {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumberComHashCode(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 99, "area code");
        rangeCheck(prefix, 99999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name){
        if(arg < 0 || arg > max) throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumberComHashCode)) return false;
        PhoneNumberComHashCode that = (PhoneNumberComHashCode) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    private volatile int hashCode; //Armazenado em cache, inicializado preguiçosamente

    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0){
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }

        return result;
        //return Objects.hash(areaCode, prefix, lineNumber);
    }
}
