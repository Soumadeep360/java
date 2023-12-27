import java.util.*;
class p5{


    static void strcmp(String s1,String s2){
        if(s1.compareTo(s2)==0)
        System.out.println("Both strings are equal");
        else
        System.out.println("Both strings are not equal");


    }
    static void strcmp(String s1,String s2,int n){
        int i=0;
        for(i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i))break;
        }
        if(i==n)System.out.println("Substring of length n is equal");
        else
        System.out.println("nOT equal");




    }
    public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
        String s1,s2;
        int n;
        System.out.println("Enter 2 strings");
        s1=sc.next();
        s2=sc.next();
        System.out.println("Enter the number:");
        n=sc.nextInt();


        strcmp(s1,s2);
        strcmp(s1,s2,n);        
    }
}
