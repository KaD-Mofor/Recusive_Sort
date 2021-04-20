import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab10_Ex18_13 {
    public static int sort(int[] list){

        sort(list, 0, list.length-1);

        return list[list.length-1];
    }

    private static void sort(int[] list, int low, int high){

        if (low < high){
            //Find the largest number and its index in list[high ... low]
            int indexOfMin = low;
            int min = list[low];
            for (int i = low +1; i <= high; i++){
                if (list[i] < min){
                  min = list[i];
                  indexOfMin = i;
                }
            }

            //Swap the largest in the list[high ... low]
            list[indexOfMin] = list[low];
            list[low] = min;

            //Sort the remaining list
            sort(list, low +1, high );
        }
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        boolean goAgain = true;    //To do another sort
        do {
            try {
                System.out.println("\n      **********************\n");
                System.out.println("Enter a series integers, and the\n" +
                        "program will display the largest.\n");
                System.out.println("How many numbers do you want to enter? ");
                int num = input.nextInt();

                int []arr = new int[num];   //Creating an array

                for(int i = 0; i < num; i++){
                    System.out.print("Enter #"+(i+1)+": ");
                    arr[i] = input.nextInt();
                }

                System.out.println("The largest number is: "+ sort(arr));

            }catch (Exception e){
                System.out.println("\nInvalid Entry!\n" +
                        "Enter ONLY integers.");
            }
            System.out.println("\nDo you want to try again? \n" +
                    "[1] - Yes\n" +
                    "[0] - No");
            int another = input.nextInt();
            if (another == 0)
                goAgain = false;
        }while (goAgain);

    }
}
