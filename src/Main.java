import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int[] numbers = RANDOM.ints(21, 1, 100).toArray();
        int[] numbers2 = RANDOM.ints(21, 1, 100).toArray();

       printArray(numbers);

        //1)
        findMyNumber(numbers);

        //2)
        findLargestNumber(numbers);

        //4)
        System.out.println("os números do vetor em ordem crescente são:");
        printArray(putInAscendingOrder(numbers));

        //5)
        System.out.println("os números do vetor em ordem decrescente são:");
        printArray(putInDescendingOrder(numbers));

        //6)
        printInfoAboutAverage(numbers);

        //7)
        System.out.println("O vetor composto por dois vetores é:");
        printArray(mergeArrays(numbers, numbers2));

        //9
        System.out.println("A mediana do primeiro vetor é: "+ findMedian(numbers));

    }


    private static void findMyNumber(int[] numbers) {
        Scanner scanner = new Scanner(System.in);
        boolean numberWasFound = false;
        int myNumber;

        System.out.println("\ndigite o valor a ser buscado no nosso vetor: ");
        myNumber = scanner.nextInt();
        int i = 0;
        while (i < 21) {
            if (numbers[i] == myNumber) {
                numberWasFound = true;
                break;
            }
            ++i;
        }
        if (numberWasFound) {
            System.out.println("O valor pedido foi encontrado no vetor. ");
        } else {
            System.out.println("O valor pedido não foi encontrado no vetor.");
        }
    }

    private static void findLargestNumber(int[] numbers) {

        int largestNumber = numbers[0];

        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] > largestNumber) {
                largestNumber = numbers[i];
            }
        }

        System.out.println("o maior número no vetor é " + largestNumber);
    }

    private static int[] putInAscendingOrder(int[] numbers) {

        int [] copiedNumbers = numbers.clone();
        int aux;
        for (int i = 0; i < copiedNumbers.length; ++i) {
            for (int j = 0; j < copiedNumbers.length - 1 - i; ++j) {
                if (copiedNumbers[j] > copiedNumbers[j + 1]) {
                    aux = copiedNumbers[j];
                    copiedNumbers[j] = copiedNumbers[j + 1];
                    copiedNumbers[j + 1] = aux;
                }
            }
        }
       return copiedNumbers;
    }

    private static int[] putInDescendingOrder(int[] numbers) {

        int [] copiedNumbers = numbers.clone();
        int aux;
        for (int i = 0; i < copiedNumbers.length; ++i) {
            for (int j = 0; j < copiedNumbers.length - 1 - i; ++j) {
                if (copiedNumbers[j] < copiedNumbers[j + 1]) {
                    aux = copiedNumbers[j];
                    copiedNumbers[j] = copiedNumbers[j + 1];
                    copiedNumbers[j + 1] = aux;
                }
            }
        }
        return copiedNumbers;
    }

    private static void printInfoAboutAverage(int[] numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.length; ++i){
            sum+= numbers[i];
        }
        double average = (double)sum/numbers.length;
        int aboveAverage = 0;
        int bellowAverage = 0;
        for(int i = 0; i < numbers.length; ++i){
            if(numbers[i]>average)
                ++aboveAverage;

            if(numbers[i]<average)
                ++bellowAverage;
        }

        int [] numbersAboveAverage = new int [aboveAverage];

        int [] numbersBellowAverage = new int [bellowAverage];

        int j = 0;
        int k = 0;
        for(int i = 0; i < numbers.length; ++i){
            if(numbers[i]>average)
                numbersAboveAverage[j++] = numbers[i];

            if(numbers[i]<average)
                numbersBellowAverage[k++] = numbers[i];
        }

        System.out.println("a média do vetor é "+average);
        if(aboveAverage > 0){
            System.out.println("há "+aboveAverage+" números acima da média. Eles são:");
            printArray(numbersAboveAverage);
        }
        else{
            System.out.println("não há números acima da média.");
        }

        if(bellowAverage > 0){
            System.out.println("há "+bellowAverage+" números abaixo da média. Eles são:");
            printArray(numbersBellowAverage);
        }
        else{
            System.out.println("não há números abaixo da média.");
        }
    }


    private static int[] mergeArrays(int[] numbers, int[] numbers2) {

        int bigArrayLength = numbers.length + numbers2.length;
        int [] bigArray =  new int[bigArrayLength];

        for(int i=0; i<numbers.length; ++i){
            bigArray[i] = numbers[i];
        }

        int j=0;
        for(int i=numbers.length; i<bigArrayLength; ++i){
            bigArray[i] = numbers2[j];
            ++j;
        }
        return bigArray;

    }

    private static double findMedian(int[] numbers) {
        int[] orderedNumbers = putInAscendingOrder(numbers);
        double median;
        if(orderedNumbers.length%2 == 0)
            median= (double)(orderedNumbers[numbers.length/2-1] + orderedNumbers[numbers.length/2])/2;
        else{
            median = orderedNumbers[numbers.length/2];
        }
        return median;
    }

    public static void printArray(int[] array){

        for(int i=0; i<array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}













































































































































































































