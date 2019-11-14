package br.exemplo.enums;

enum PayrollDayRuim {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate){
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch (this){
            case SATURDAY:
            case SUNDAY: // FINAL DE SEMANA
                overtimePay = basePay / 2;
                break;
            default: // dia da semana
                overtimePay = minutesWorked <= MINS_PER_SHIFT ?
                        0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overtimePay;
    }

}
