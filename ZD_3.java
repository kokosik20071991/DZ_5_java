/**Написать метод, который переводит число из римского формата записи в арабский.
Например, MMXXII = 2022 */

import java.util.*;

public class ZD_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число: 1 - перевод в арабские цифры; 2 - перевод в римские цифры :");
        Integer choise = sc.nextInt();
        if (choise == 1) {
            System.out.printf("Введите римское число: ");
            Scanner f = new Scanner(System.in);
            String word = f.nextLine();
            Integer result = numberTranslation(word);
            System.out.println(result);
            f.close();

        } else if(choise == 2) {
            System.out.printf("Введите арабское число: ");
            Integer word = sc.nextInt();
            String result = numberTranslation2(word);
            System.out.println(result);
        } else {
            System.out.println("Работа окончена");
        }

        sc.close();
    }

    private static Integer numberTranslation(String word) {
        int result = 0;
        int number = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = word.length() - 1; i >= 0; i--) {
            int current = map.get(word.charAt(i));
            if (current < number) {
                result -= current;
            } else {
                result += current;
            }
            number = current;
        }
        return result;
    }

    private static String numberTranslation2(Integer number) {
        String result = "";
        while (number != 0) {
            if (number >= 1000) {
                number -= 1000;
                result += "M";
            } else if (number<1000 && number>900) {
                number -=900;
                result += "CM";
            } else if (number >= 500) {
                number -=500;
                result += "D";
            } else if (number >= 100) {
                number -= 100;
                result += "C";
            } else if (number >= 50) {
                number -= 50;
                result += "L";
            } else if (number >= 10) {
                number -= 10;
                result += "X";
            }else if (number == 9) {
                number -= 9;
                result += "IX";
            }else if (number >= 5) {
                number -= 5;
                result += "V";
            } else if(number == 4){
                number -= 4;
                result+="IV";
            }else if(number > 0){
                number -= 1;
                result+="I";
            } else number = 0;
        }
        return result;
    }
}
