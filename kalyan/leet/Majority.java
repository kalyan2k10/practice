package kalyan.leet;

public class Majority {
    public static void main(String[] args){
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(findMajority(a));
    }

    private static int findMajority(int[] a) {
        int res = 0;
        int cnt = 1;
        for(int i=0;i<a.length;i++){
            if(a[i] == a[res]) cnt++;
            else cnt--;
            if(cnt==0) {res = i;cnt=1;}
        }
        return a[res];
    }
}
