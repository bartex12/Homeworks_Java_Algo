package Lesson2.arraybig_Java;

public class Less2Demo {

    private static final int initSizeBig = 1000000;
    private static final int initSizeMiddle= 100000;
    private static final int initSizeSmall = 20;

    public static void main(String[] args) {

        //Заполнение массива без сортировки, поиск, удаление
        initArrayWithoutSort();

        //Заполнение массива  с сортировкой при вставке элемента
        // у меня 100 000 элементов заполняются примерно 3 сек
        initArrayWithSortByInsert();
        System.out.println();

        //Сортировка разными способами массива на 100 000 элементов

        //быстрая сортировка - (у меня 100 000 элементов за 0,02 сек)
        initArrayWith_QuickSort();
        //сортировка выбором - (у меня 100 000 элементов за 7 сек)
        initArrayWith_SelectSort();
        //пузырьковая сортировка - (у меня 100 000 элементов за 27 сек)
        initArrayWith_BubbleSort();
    }

    private static void initArrayWith_BubbleSort() {
        MyArrBig myArrSortBubble = new MyArrBig(initSizeMiddle);
        myArrSortBubble.initArray();
        System.out.println();
        System.out.println("Пузырьковая сортировка  массива на 100 000 элементов. Ждите...");
        long timeRunSort = System.currentTimeMillis();
        myArrSortBubble.sortBubble();
        System.out.println("Время пузырьковой сортировки  массива на 100 000 элементов = " +
                (System.currentTimeMillis()-timeRunSort) + " mcek"  );
    }

    private static void initArrayWith_SelectSort() {
        System.out.println();
        MyArrBig myArrSortSelect = new MyArrBig(initSizeMiddle);
        myArrSortSelect.initArray();
        System.out.println("Сортировка выбором  массива на 100 000 элементов. Ждите...");
        long timeRunSortSel = System.currentTimeMillis();
        myArrSortSelect.sortSelect();
        System.out.println("Время  сортировки  массива выбором на 100 000 элементов = " +
                (System.currentTimeMillis()-timeRunSortSel) + " mcek"  );
    }

    private static void initArrayWith_QuickSort() {
        MyArrBig myArrSortQuick = new MyArrBig(initSizeMiddle);
        myArrSortQuick.initArray();
        System.out.println("Быстрая сортировка  массива на 100 000 элементов. Ждите...");
        long timeRunSortQuick = System.currentTimeMillis();
        myArrSortQuick.quickSort(myArrSortQuick.getArr(), 0, myArrSortQuick.getSize()-1);
        System.out.println("Время  быстрой сортировки  массива на 100 000 элементов = " +
                (System.currentTimeMillis()-timeRunSortQuick) + " mcek"  );
    }

    private static void initArrayWithSortByInsert() {
        System.out.println();
        MyArrBig myArrSort = new MyArrBig(initSizeMiddle);
        System.out.println("Заполнение массива  с сортировкой. Ждите...");
        long timeRun = System.currentTimeMillis();
        myArrSort.initArrayWithSorting();
        System.out.println("Время заполнения  массива  с сортировкой = " +
                (System.currentTimeMillis()-timeRun) + " mcek"  );
        myArrSort.reportShort();
        //если рядом стоят два одинаковых элемента, полученный индекс у методов findSimple и findBinary
        // может отличаться, поскольку получаем индекс первого найденного элемента
        myArrSort.findSimple(123);
        myArrSort.findBinary(321);
    }

    private static void initArrayWithoutSort() {
        MyArrBig myArrBig = new MyArrBig(initSizeBig);
        myArrBig.initArray();
        myArrBig.reportShort();

        System.out.println();
        System.out.println("Поиск элемента перебором в несортированном массиве");
        myArrBig.findSimple(15);

        System.out.println();
        System.out.println("Удаление элемента ");
        myArrBig.delete(12);
        myArrBig.delete(55555);
        myArrBig.reportShort();
    }
}
