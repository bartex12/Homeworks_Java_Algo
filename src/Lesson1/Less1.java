package Lesson1;

/*1. Прочитать в книге Grokking Algorithms:
An illustrated guide for programmers and other curious people
про алгоритмы и О-большое.
*/
public class Less1 {
    public static void main(String[] args) {
        showResume();
    }


    private static void showResume(){
        String s =new StringBuilder()
                .append("Ниже перечислены пять разновидностей о-большого, которые будут встречаться\n")
                .append("особенно часто, в порядке убывания скорости выполнения:\n")
                .append("    -  O(log n), или логарифмическое время, пример - бинарный поиск\n")
                .append("    -  O(n), или линейное время, пример - простой поиск\n")
                .append("    -  O(n log n), эффективные алгоритмы сортировки, пример - быстрая сортировка\n")
                .append("    -  O(n*n), медленные алгоритмы сортировки, пример - сортировка выбором\n")
                .append("    -  O(n!), очень медленные алгоритмы , пример - задача о коммивояжере").toString();
        System.out.println(s);
    }
}
