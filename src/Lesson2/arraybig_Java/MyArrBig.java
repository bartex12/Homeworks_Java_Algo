package Lesson2.arraybig_Java;

import java.util.Random;

 class MyArrBig {

     private int size;
     private int[] arr;

     MyArrBig(int size){
         this.size = 0;
         arr = new int[size];
     }

      int[] getArr() {
         return arr;
     }

      int getSize() {
         return size;
     }

    //заполнение массива случайными числами без сортировки
     void initArray(){
        int length = arr.length;
        Random random = new Random();
        for (int i = 0; i<length; i++){
            insertElement(random.nextInt(length));
        }
    }

     //заполнение массива случайными числами с сортировкой
     void initArrayWithSorting(){
         int length = arr.length;
         Random random = new Random();
         for (int i = 0; i<length; i++){
             insertElementWithSortingUp(random.nextInt(length));
         }
     }

    //вставка элемента  в конец массива
    private void insertElement(int value){
        arr[size] = value;
        size++;
    }

     //вставка элемента  с сортировкой от меньшего к большему
     private void insertElementWithSortingUp(int value){
         int i;
         for (i =0; i<size; i++ ){
             if (arr[i]>value){
                 break;
             }
         }
         for (int n=size; n>i; n-- ){
             arr[n] = arr[n-1];
         }
         arr[i]=value;
         size++;
     }

     //вывод данных для большого массива
     void reportShort(){
         System.out.println("Элементов в массиве: " + size);

     }
      //вывод данных для небольшого массива
      void reportFull(){
        System.out.println("Элементов в массиве: " + size);
         for(int i = 0; i < size; i++) {
             System.out.print(arr[i]+ " ");
         }
         System.out.println();
     }

     //поиск перебором элементов массива
     void findSimple(int value){
         int i;
         for (i =0; i<size; i++ ){
             if (arr[i] == value){
                 System.out.println("Поиск выбором. Элемент = " + value + " находится по индексу = " + i);
                 break;
             }
         }
         if (i == size){
             System.out.println("Поиск выбором. Элемент " +  value + " не обнаружен.");
         }
     }

     // Бинарный поиск  элемента  в отсортированном  массиве
     boolean findBinary(int value){
         int in = 0;
         int out = size-1;
         int middle;

         while (in <= out){
             middle = (in + out)/2;
             if (arr[middle] == value){
                 System.out.println("Бинарный поиск. Элемент = " + value + " находится по индексу = " + middle);
                 return true;
             }else if (arr[middle] < value){
                 in = middle+1;
             }else {
                 out =  middle-1;
             }
         }
         System.out.println("Бинарный поиск. Элемент " +  value + " не обнаружен.");
         return false;
     }

     //удаление элемента массива
    void delete (int value){
        int i;
        for (i =0; i<size; i++ ){
            if (arr[i] == value){
                System.out.println("Удаляем элемент = " + value + " индекс = " + i);
                break;
            }
        }
            if (i == size){
                System.out.println("Элемент " +  value + " не обнаружен. Удаление невозможно");
            }else {
                for (int n=i; n<size-1; n++ ){
                    arr[n] = arr[n+1];
                }
                size--;
            }

    }

    //пузырьковая сортировка
    void sortBubble(){
        int in;
        int out;
        for (out = size-1; out>=1; out--){  // Внешний цикл (обратный)
            for (in = 0; in<out; in++){     // Внутренний цикл (прямой)
                if (arr[in]>arr[in+1]){     // Порядок нарушен?
                    exchange(in, (in+1));   // Поменять местами
                }
            }
        }
    }

    //обмен элементами
    private void exchange(int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    //сортировка выбором
      void sortSelect(){
         int in;
         int out;
         int mark;
         for (out = 0; out<size; out++){            // Внешний цикл
             mark = out;                            // Минимум
             for (in = out+1; in<size; in++){       // Внутренний цикл
                 if (arr[in]<arr[mark]){            // Если значение mark больше,
                     mark = in;                     // значит, найден новый минимум
                 }
             }
             exchange(out, mark);                   // Поменять их местами
         }
     }

         //быстрая сортировка
     void quickSort(int[] array, int low, int high) {
         if (array.length == 0)
             return;//завершить выполнение если длина массива равна 0
         if (low >= high)
             return;//завершить выполнение если уже нечего делить
         // выбрать опорный элемент
         int middle = low + (high - low) / 2;
         int opora = array[middle];

         // разделить на подмассивы, который больше и меньше опорного элемента
         int i = low, j = high;
         while (i <= j) {
             while (array[i] < opora) {
                 i++;
             }
             while (array[j] > opora) {
                 j--;
             }
             if (i <= j) {//меняем местами
                 int temp = array[i];
                 array[i] = array[j];
                 array[j] = temp;
                 i++;
                 j--;
             }
         }
         // вызов рекурсии для сортировки левой и правой части
         if (low < j)
             quickSort(array, low, j);
         if (high > i)
             quickSort(array, i, high);
     }

}
