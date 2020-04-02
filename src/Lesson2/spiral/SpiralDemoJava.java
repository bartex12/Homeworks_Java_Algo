package Lesson2.spiral;

public class SpiralDemoJava {
    public static void main(String[] args) {

        System.out.println("*** Вариант1 ***");
        int lines = 5;  //количество строк
        int columns = 7; //количество столбцов
        int[][] a = new int[lines][columns];
        a = spiral(a);
        showMatrix(a);

        System.out.println();
        System.out.println("*** Вариант2 ***");
        //Для большой матрицы
        lines =30;
        columns =20;
        int[][] a1 = new int[lines][columns];
        a1 = spiral(a1);
        showMatrix(a1);

        System.out.println();
        System.out.println("*** Вариант3 ***");
        //для выявления ошибки
        lines = 0;
        columns =2;
        int[][] a2 = new int[lines][columns];
        a2 = spiral(a2);
        showMatrix(a2);
    }

    private static int [][] spiral(int [][] a){
        //************* подготовка ****************
        int k = 1;       // значение первого элемента
        int y = a.length;   //количество строк
        int x = 0;          //количество столбцов
        if (y > 0){
            x = a[0].length;
            if (x < 1){
                showMessage();
                return a;
            }
        }else {
            showMessage();
            return a;
        }
        int[][] aa = new int [x][y]; //матрица с размерами для обработки поворота
        int min = y <= x ? y : x;  // определение меньшего размера матрицы
        if (min == 2){
            min = min-1;
        }else if (min > 2){
            min = min-2;
        }

        //************* вычисления ****************
        int ii = 0;
        while (ii < min){
            for (int i = 0; i < 4; i++){
                if (i%2 == 0){                  //еcли 0 или 2,
                    k = fill(k, a[ii]);         // то заполняем строку массива a
                    aa = turnToLeft(a);         //поворот на 90 градусов
                }else {                         //еcли 1 или 3,
                    k = fill(k, aa[ii]);        //то заполняем строку массива aa
                    a = turnToLeft(aa);         //поворот на 90 градусов
                }
            }
            ii++;
        }
        return a;
    }

    //заполнение строки матрицы
    private static int fill(int k, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = k;
                k++;
            }
        }
        return k;
    }

    //поворот влево
    private static int[][] turnToLeft(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr[i].length - 1 - j][i] = arr[i][j];
            }
        }
        return result;
    }

    //показать матрицу
    private static void showMatrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%4d", ints[j]);
            }
            System.out.println();
        }
    }

    private static void showMessage() {
        System.out.println("Минимальный размер матрицы должен быть 1х1\n" +
                "Желательно - не меньше, чем 2х2" );
    }
}
