package kalyan.algo;

public class MaxSubSumDPNonContinuousWithoutExtraSpace {
    public static void main(String s[]){
        int c[] = new int[] {10,5,20,40,70};
        int prevMax=c[0], max=Math.max(c[0],c[1]);
        for(int i=2;i<c.length;i++){

            if(prevMax+c[i] > max){
                int tempMax = max;
                max = prevMax + c[i];
                prevMax = tempMax;

            } else {
            }

        }
        System.out.println(max);
    }

}
