public class Test2{
	 public static void main(String[] args){
         /*問1*/
         int[] a = new int[]{1,2,3};//①
         int[] b = a;               //②  
         b[0] = 5;                  //③
         System.out.println(a[0]);

         /*問2*/
         int c = 1;                 //④
         int d = c;                 //⑤
         d = 5;                     //⑥
         System.out.println(c);
    }
}