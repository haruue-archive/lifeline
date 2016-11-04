import java.util.HashSet;
import java.util.Set;

/**
 * Created by hasee on 2016/11/4.
 */
public  class Bagson{
    public static void main(String[] args) {
        Set<Bag> allSet=new HashSet<Bag>();
        allSet.add(new Bag("windos"));
        allSet.add(new Bag("10"));
        System.out.print(allSet);
        allSet.remove(new Bag("10"));
        System.out.print(allSet);
        allSet.add(new Bag("10"));
        allSet.add(new Bag("10"));
        System.out.print(allSet);
        System.out.print(allSet.contains("10"));
        System.out.print(allSet.isEmpty());

    }
}