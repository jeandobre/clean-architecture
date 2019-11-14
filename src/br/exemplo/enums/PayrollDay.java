package br.exemplo.enums;

// Padrão enum estratégico
enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY); //Padrão
    }

    private enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorkd, int payRate) {
                return minsWorkd <= MINS_PER_SHIFT ? 0 : (minsWorkd - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorkd, int payRate){
            int basePay = minsWorkd * payRate;
            return basePay + overtimePay(minsWorkd, payRate);
        }
    }
}
