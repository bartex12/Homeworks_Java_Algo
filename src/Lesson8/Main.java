package Lesson8;

public class Main {
    public static void main(String[] args) {

        final int delKey = 1; //ключ элемента для удаления
        final int capacity = 7; //размер массива списков

        ChainingHashMap<Integer ,String> map = new ChainingHashMap<>(capacity); //создание массива списков

        fillHashMap(map); //заполнение массива в соответствии с хэшами ключей

        System.out.println("Первоначальный массив списков:");
        System.out.println(map);
        System.out.print("Удаляем элемент с ключом " + delKey+ ": -> ");
        System.out.println(map.delete(delKey));
        System.out.println("Массив списков после удаления:");
        System.out.println(map);
    }

    private static void fillHashMap(ChainingHashMap<Integer, String> map) {
        map.put(0,"0");
        map.put(1,"cat");
        map.put(2,"dog");
        map.put(3,"3");
        map.put(4,"4");
        map.put(5,"5");
        map.put(6,"6");
        map.put(7,"7");
        map.put(8,"8");
        map.put(22,"man");
        map.put(15,"woman");
        map.put(12,"12");
    }

}
