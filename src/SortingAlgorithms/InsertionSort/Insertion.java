
/**
 * Write a description of class Insertion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Insertion
{
   public static void sort(Comparable a[])
    {
        // initialise instance variables
        for(int i=0;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    
    public static boolean less(Comparable v , Comparable w){
        return v.compareTo(w)<0 ;
    }
    
    public static void exch(Comparable a[], int i, int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
