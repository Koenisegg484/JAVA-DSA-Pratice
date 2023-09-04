import java.util.*;

public class Project01_Arrays{

    // Function to return the average temperature 
    float AverageTemperature(int sum, int nofdays){  //O(1)
        float avgtmp = sum / nofdays;
        return avgtmp;
    }

    // Function to find how many days had higher temperature than the average temperature
    int higherThanAverage(int sum, int nofdays, int n[]){ // O(N)
        int days = 0;
        float avgtmp = AverageTemperature(sum, nofdays);
        for(int j = 0; j < n.length; j++){
            if(n[j] < avgtmp){
                days++;
            }
        }
        return days;
    }

    static Scanner sc = new Scanner(System.in);
    public static void main (String args[]){
        System.out.print("This is my frirst program on the codespaces.");
        System.out.println("\nHow many day's are to be processed : ");
        int numberOfDays = sc.nextInt();
        int sum = 0;
        int temperatures[] = new int [numberOfDays];
        for (int i = 0; i<numberOfDays; i++){//O(N)
            System.out.print("Enter the temperature on day" + (i+1) + " : ");
            temperatures[i] = sc.nextInt();
            sum += temperatures[i];
        }
        Project01_Arrays pa = new Project01_Arrays();
        System.out.println("The average temperature as recorded was : " + pa.AverageTemperature(sum, numberOfDays));
        System.out.println("The number of days haigher than the average temperature were: "+ pa.higherThanAverage(sum, numberOfDays, temperatures));

    }
}