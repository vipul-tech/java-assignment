public class palindrome {
    public static void main(String args[]){
	boolean a=isPalindrome(11);
	boolean b=isPalindrome(-222);
	System.out.println(a);
	System.out.println(b);
    }
    public static boolean isPalindrome(int number){
        int reverse=0;
        int digit;
        int num=number;
        while(number!=0){
            digit=number%10;
            reverse=reverse*10+digit;
            number/=10;
        }
        if(num==reverse)
            return true;
        else
            return false;
    }
}

