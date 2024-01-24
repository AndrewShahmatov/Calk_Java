import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите значения");
        String scann = scan.nextLine();
        String math = scann.replaceAll(" ", "");
        String p = testRomeOrArab(math);
        System.out.println(p);


    }

    public static String testRomeOrArab(String math) {
        RomeNum[] values = RomeNum.values();
        String[] mathem = math.split("[+-/*]");
        if (RomeOrNotRome(mathem[0]) && ArabOrNotArab(mathem[1])) {
            return "Невозможно использовать римские и арабские цифры в одном примере";
        } else if (RomeOrNotRome(mathem[1]) && ArabOrNotArab(mathem[0])) {
            return "Невозможно использовать римские и арабские цифры в одном примере";
        } else {
            if (mathem.length == 2 && RomeOrNotRome(mathem[0]) && RomeOrNotRome(mathem[1])) {
                if (RomeNum.valueOf(mathem[0]).ordinal() > -1 && RomeNum.valueOf(mathem[0]).ordinal() < 11 && RomeNum.valueOf(mathem[1]).ordinal() > -1 && RomeNum.valueOf(mathem[1]).ordinal() < 11) {
                    int f = RomeNum.valueOf(mathem[0]).ordinal();
                    int s = RomeNum.valueOf(mathem[1]).ordinal();
                    if (math.contains("+")) {
                        int a = f + s;
                        if (a > 0) {
                            return String.valueOf(values[a]);
                        }
                        return "Ошибка, нельзя дать отрицательное значение";
                    } else if (math.contains("-")) {
                        int a = f - s;
                        if (a > 0) {
                            return String.valueOf(values[a]);
                        }
                        return "Ошибка, нельзя дать отрицательное значение";
                    } else if (math.contains("*")) {
                        int a = f * s;
                        if (a > 0) {
                            return String.valueOf(values[a]);
                        }
                        return "Ошибка, нельзя дать отрицательное значение";
                    } else if (math.contains("/")) {
                        int a = f / s;
                        if (a > 0) {
                            return String.valueOf(values[a]);
                        }
                        return "Ошибка, нельзя дать отрицательное значение";
                    } else {
                        return "Ошибка, недопустимый оператор";
                    }
                } else {
                    return "Невозможно использовать числа меньше 0 и больше 10";
                }
            } else if (mathem.length == 2 && Integer.parseInt(mathem[0]) < 11 && Integer.parseInt(mathem[0]) >= 0 && Integer.parseInt(mathem[1]) < 11 && Integer.parseInt(mathem[1]) >= 0) {
                String A = Arab(mathem, math);
                System.out.println(A);
            } else {
                return "Ошибка, неверное количество элементов или данные больше 11 и меньше 0";
            }
            return "Конец программы";
        }
    }

    public static boolean RomeOrNotRome(String value) {
        try {
            RomeNum.valueOf(value);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
    public static boolean ArabOrNotArab(String value){
        try {
            Integer.valueOf(value);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
    public static String Arab(String[]mathem, String math){
        int x = Integer.parseInt(mathem[0]);
        int y = Integer.parseInt(mathem[1]);
        if (math.contains("+")) {
            return String.valueOf(x + y);
        } else if (math.contains("-")) {
            return String.valueOf(x - y);
        } else if (math.contains("*")) {
            return String.valueOf(x * y);
        } else if (math.contains("/")) {
            return String.valueOf(x / y);
        } else {
            return "Ошибка, недопустимый оператор";
        }
    }

}