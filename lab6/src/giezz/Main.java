package giezz;

public class Main {
    static final int SIZE = 50000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        //method1();
        method2();
    }

    static void method1 () {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr [i]=(float )(arr [i ]*Math . sin (0.2f+i /5)*Math . cos (0.2f+i  /5)*Math . cos (0.4f+i  /2));
        }
        System.out.println(System.currentTimeMillis() - a);
        System.out.println(arr[SIZE - 1]);
    }

    static void method2 () {
        float[] arr = new float[SIZE];
        float[] arrFinal = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i]=(float )(arr1 [i]*Math . sin (0.2f+i /5)*Math . cos (0.2f+i  /5)*Math . cos (0.4f+i  /2));
            }
        });

        Thread thread2 = new Thread((() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr2[i]=(float )(arr2[i]*Math . sin (0.2f+ (i + HALF) /5)*Math . cos (0.2f+(i + HALF)  /5)*Math . cos (0.4f+(i + HALF)  /2));
            }
        }));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arrFinal, 0, arr1.length);
        System.arraycopy(arr2, 0, arrFinal, arr2.length, HALF);
        System.out.println(System.currentTimeMillis() - a);
        System.out.println(arrFinal[SIZE - 1]);
    }
}
