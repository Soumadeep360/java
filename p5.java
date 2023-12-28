import java.util.*;
class p5{

    static void strcmp(String s1,String s2){
        if(s1.compareTo(s2)==0)
        System.out.println("Both strings are equal");
        else
        System.out.println("Both strings are not equal");

    }
    static void strcmp(String s1,String s2,int n){
        if(s1.substring(0,n).equals(s2.substring(0,n)))
        System.out.println("Equal upto length "+n);
        else
        System.out.println("not equal!!");
    }
    public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
        String s1,s2;
        int n;
        System.out.println("Enter 2 strings");
        s1=sc.next();
        s2=sc.next();
        System.out.println("Enter the number upto which charecters to be checked:");
        n=sc.nextInt();
        
        strcmp(s1,s2);
        strcmp(s1,s2,n);        
    }
}
