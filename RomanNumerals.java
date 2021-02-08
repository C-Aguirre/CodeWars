import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Scanner scanner = new Scanner(System.in);
        try {
            Scanner scanner = new Scanner(new File(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
         */

//        1db7^14+egg^18-hi32^20+3876^9-321^4=^7
        System.out.println(toBase10("1db7", 14));
        System.out.println(toBase10("egg", 18));
        System.out.println(toBase10("hi32", 20));
        System.out.println(toBase10("3876", 9));
        System.out.println(toBase10("321", 4));

        int ggi = 5453+4840-143262+2904-57;
        System.out.println(fromBase10(ggi, 7));

        Scanner scanner = new Scanner(System.in);

//        while (scanner.hasNextInt()) System.out.println(fromBase10(scanner.nextInt(), 2));

        System.out.println(romanToInt("MCMLXXXV"));




        Scanner s = new Scanner(new File("numeralstest.txt"));
        for (int i = 1; i < 4000; i++) {
            String roman = intToRoman(i);
            if (!s.hasNext()) return;
            String test=s.nextLine();
            String testRoman = test.substring(test.indexOf('=')+2);

//            System.out.println(test);
//            System.out.println(roman);
//            System.out.println(testRoman);
//            if (!testRoman.equals(roman)) {
//                System.out.println(roman);
//                System.out.println(testRoman);
//            }

            System.out.println(i +" = "+romanToInt(intToRoman(i)) + ": "+intToRoman(i));
        }
    }

    public static int toBase10(String binaryInput, int inputBase){
        binaryInput = binaryInput.toUpperCase();
        char[] chars = binaryInput.toCharArray();
        int[] ints = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>=48 && chars[i]<=57) ints[chars.length-i-1] = chars[i]-48;
            else ints[chars.length-1-i] = chars[i] - 55;
        }

        int multiplier = 1;
        int sum=0;
        for (int i : ints) {
            sum += multiplier*i;
            multiplier*=inputBase;
        }
        return sum;
    }

    public static String fromBase10(int input, int outputBase){
        if (input==0) return "0";
        String output = "";
        int currentBase = 1;
        while (currentBase<input){
            currentBase*=outputBase;
        }

        while (currentBase!=0){
            int current = input/currentBase;
            if (current<=9) output += current;
            else output += (char)(current+55);

            input%=currentBase;
            currentBase/=outputBase;
        }

        while (output.charAt(0)=='0') output = output.substring(1);
        return output;
    }

    public static String baseToBase(String input, int inputBase, int outputBase){
        return fromBase10(toBase10(input, inputBase), outputBase);
    }

    public static String[] readFile(String fileName) {
        try {
            Scanner s = new Scanner(new File(fileName));
            ArrayList<String> list = new ArrayList<>();
            while (s.hasNext()){
                list.add(s.nextLine());
            }
            return (String[]) list.toArray();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static int romanToInt(String input){
        input = input.toUpperCase();
        char[] chars=input.toCharArray();
        int[] ints=new int[chars.length+1];
        for (int i=0;i<chars.length;i++){
            int x;
            switch (chars[i]){
                case 'I':x=1;break;
                case 'V':x=5;break;
                case 'X':x=10;break;
                case 'L':x=50;break;
                case 'C':x=100;break;
                case 'D':x=500;break;
                case 'M':x=1000;break;
                default:x=-1;break;
            }
            ints[i]=x;
        }

        int output=0;
        for (int i=0;i<ints.length-1;i++){
            if (ints[i]<ints[i+1]) output-=ints[i];
            else output+=ints[i];
        }
        return output;
    }

    public static String intToRoman(int input){
        String output = "";
        while (input>=1000) {
            output+= 'M';
            input-=1000;
        }
        if (input>=900){
            output+="CM";
            input-=900;
        }

        while (input>=500) {
            output+= 'D';
            input-=500;
        }
        if (input>=400){
            output+="CD";
            input-=400;
        }

        while (input>=100) {
            output+= 'C';
            input-=100;
        }
        if (input>=90){
            output+="XC";
            input-=90;
        }

        while (input>=50) {
            output+= 'L';
            input-=50;
        }
        if (input>=40){
            output+="XL";
            input-=40;
        }

        while (input>=10) {
            output+= 'X';
            input-=10;
        }
        if (input>=9){
            output+="IX";
            input-=9;
        }

        while (input>=5) {
            output+= 'V';
            input-=5;
        }
        if (input>=4){
            output+="IV";
            input-=4;
        }

        while (input>=1) {
            output+= 'I';
            input-=1;
        }
        return output;
    }
}
