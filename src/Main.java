public class Main {

    //" 100 5,100 5, 53 5, 76 3|0,100,5"
    public static void main(String[] args) {
      Aided a  = new Aided();
      SelfFinance f= new SelfFinance();
      String acgpa = a.result("67 4,34 2,54 5,100 2|1,100,5|0,100,5");
      String scgpa = f.result("100 5,100 5, 53 5, 76 3|0,100,5");
      System.out.println(acgpa);
      System.out.println(scgpa);

    }
}
