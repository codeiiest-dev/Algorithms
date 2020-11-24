
/**
 * Write a description of class Selection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Selection
{
   
    public static void sort(Comparable a[])
    {
        // initialise instance variables
        for(int i=0;i<a.length;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            exch(a,i,min);
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
