public class Merge{
    public static Comparable[] theArray;
    public static Comparable[] sort(Comparable[] a){
        theArray= new Comparable[a.length];
        theArray=a;
        for(int i=0;i<a.length;i++){
            System.out.print(theArray[i]+"  ");
        }
        System.out.println();
        Comparable[] workplace=new Comparable[a.length];
        mergesort(workplace,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(theArray[i]+"  ");
        }
        System.out.println();
        return theArray;
    }
    
    public static void mergesort(Comparable[] workplace,int lowerbound,int upperbound){
        if(lowerbound==upperbound){
            return;
        }
        else{
        int mid=(lowerbound+upperbound)/2;
        mergesort(workplace,lowerbound,mid);
        mergesort(workplace,mid+1,upperbound);
        merge(workplace,lowerbound,mid+1,upperbound);
        }
    }
    
    public static void merge(Comparable[] workplace,int lowPtr,int highPtr,int upperbound)
    {
        int low=lowPtr;
        int mid=highPtr-1;
        int j=0;
        int n=upperbound-low+1;
        while(low<=mid && highPtr<=upperbound){
           if(theArray[low].compareTo(theArray[highPtr])<0){
               workplace[j++]=theArray[low++];
            }else{
                workplace[j++]=theArray[highPtr++];
            }
        }
        
        while(low<=mid){
            workplace[j++]=theArray[low++];
        }
        
        while(highPtr<=upperbound){
            workplace[j++]=theArray[highPtr++];
        }
        
        for(j=0;j<n;j++){
            theArray[lowPtr+j]=workplace[j];
        }
    }
}