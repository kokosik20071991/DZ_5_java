/** Пусть дан список сотрудников:

Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Иван Иванов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Иван Иванов
Мария Рыкова
Анна Крутова
Марина Лугова
Анна Владимирова
Петр Лыков
Иван Мечников
Петр Петин
Петр Лыков
Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. */

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ZD_2 {
    public static void main(String[] args) {
        List<String> workers = List.of("Иван", "Светлана", "Кристина", "Анна", "Анна", "Иван", "Петр", "Павел", "Иван", "Петр", "Мария", "Марина", "Мария", "Иван","Мария", "Анна", 
        "Марина","Анна", "Петр", "Иван","Петр","Петр","Иван"); 
        System.out.println(repeat(workers));
    }

    public static Map<String, Integer> repeat(List<String> workers) {
        Map<String, Integer> repeatNameCount = new LinkedHashMap<>();

        for (int i = 0; i < workers.size(); i++) {
            if (repeatNameCount.containsKey(workers.get(i))) {
                repeatNameCount.put(workers.get(i), repeatNameCount.get(workers.get(i)) + 1);
            } else {
                repeatNameCount.put(workers.get(i), 1);
            }
        }

        Map<String, Integer> sortedMap = repeatNameCount.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }

}