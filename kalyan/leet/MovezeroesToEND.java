package kalyan.leet;

public class MovezeroesToEND {
    public static void main(String[] args){
        int a[] = {1,6,2,3,4};
        //{0,0,1u,1,1i,1,2,2,2,2,3,3,3}
        leftRotate(a,2);
        for(int i=0;i<a.length;i++)
            System.out.print(" " + a[i]);
    }

    private static void moveZeroes(int[] a) {
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                int temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
    }

    private static void leftRotate(int[] a, int i){

    }
}
