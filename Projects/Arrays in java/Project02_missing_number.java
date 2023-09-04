public class Project02_missing_number{
    public static void main(String [] aStrings){
        int total = 1+2+3+4+5+6+7+8+9;
        int numbers [] = new int [8];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        numbers[5] = 6;
        numbers[6] = 8;
        numbers[7] = 9;
        int sum = 0;
        for (int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        if (sum != total){
            System.out.println("The missing number is : "+ (total - sum));
        }
    }
}