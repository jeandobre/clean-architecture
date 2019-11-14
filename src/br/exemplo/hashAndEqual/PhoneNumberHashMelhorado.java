package br.exemplo.hashAndEqual;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public final class PhoneNumberHashMelhorado implements Comparable<PhoneNumberHashMelhorado> {
    private final short areaCode;
    private final int prefix;
    private final short lineNumber;

    public PhoneNumberHashMelhorado(int areaCode, int prefix, int lineNumber) {
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
        if (!(o instanceof PhoneNumberHashMelhorado)) return false;
        PhoneNumberHashMelhorado that = (PhoneNumberHashMelhorado) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    private volatile int hashCode; //Armazenado em cache, inicializado preguiçosamente

    @Override
    public int hashCode() {
       int result = Short.hashCode(areaCode);
       result = 31 * result + Integer.hashCode(prefix);
       result = 31 * result + Short.hashCode(lineNumber);
       return result;
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

    private static final Comparator<PhoneNumberHashMelhorado> COMPARATOR = comparingInt((PhoneNumberHashMelhorado pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNumber);

    //Melhorado usado o método de construção estático
    @Override
    public int compareTo(PhoneNumberHashMelhorado pn){
        return COMPARATOR.compare(this, pn);
    }
}
