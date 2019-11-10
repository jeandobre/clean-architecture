package br.edu.ufgd.exemplo.hashAndEqual;

import java.util.Objects;

public final class PhoneNumberComHashCode implements Comparable<PhoneNumberComHashCode> {
    private final short areaCode;
    private final int prefix;
    private final short lineNumber;

    public PhoneNumberComHashCode(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 99, "area code");
        rangeCheck(prefix, 99999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = prefix;
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

    /**
     * Returns the string representation of this phone number.
     * The string constists of fourteen characters whise format
     * is "(xx) yyyyy-zzzz", where xx is the area code, yyyyy is
     * the prefix, and zzzz is the line number. (each of the
     * captal letters represents a single decimal digit.)
     *
     * if anu of the thre parts of this phone number is too small
     * to fill up ts field, the field is padded with leading zeros.
     * For exemaple, if the value of the line number is 123, the last
     * four characters of the string representation will be "0123".
     *
     * Note that threre is a single space separating the closing
     * parenthesis after the area code from the first digit of the
     * prefix.
     */
    @Override
    public String toString() {
        //return "(" + areaCode + ") " + prefix + "-" + lineNumber;
        return String.format("(%02d) %05d-%04d", areaCode, prefix, lineNumber);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            throw new AssertionError(); //Não pode acontecer
        }
    }
/* Versão anterior ao Java 7
    @Override
    public int compareTo(PhoneNumberComHashCode pn) {
        // Compare area codes
        if(areaCode < pn.areaCode) return -1;
        if(areaCode > pn.areaCode) return 1;

        // Area codes are equal, compare prefixes

        if(prefix < pn.prefix) return -1;
        if(prefix > pn.prefix) return  1;

        // area codes and prefixes are equal, compare line numbers

        if(lineNumber < pn.lineNumber) return -1;
        if(lineNumber > pn.lineNumber) return 1;

        return 0; // All fields are equal
    }

    */
    /**
     * Método melhorado, usado a compare os objects ao invés de > ou <
     * @param pn
     * @return
     */
    @Override
    public int compareTo(PhoneNumberComHashCode pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if(result == 0) {
            result = Integer.compare(prefix, pn.prefix);
            if(result == 0)
                result = Short.compare(lineNumber, pn.lineNumber);
        }
        return result;
    }

}
