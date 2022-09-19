public class combiNpermu {
    private static int[] numbers;

    /**
     * input : {1,2,3,4,5}
     조합 : 5C3 : 순서 필요없음
     1,2,3
     3,2,1

     중복조합
     1,1,1
     1,1,2
     2,1,1

     순열 5P3
     1,2,3
     3,2,1

     중복순열
     1,1,1,
     1,1,2,
     2,1,1,
     */
    public static void main(String[] args) {
        /* 5개중에 3개를 뽑아라 */
        numbers = new int [3];
        combination(0 ,1);
    }

    private static void combination(int cnt, int start) {
        if(cnt ==3){ //기저 조건
            for(int i =0; i<3; i++){
                System.out.print(numbers[i] + " " );
            }
            System.out.println();
            return ;
        }
        for(int i= start; i<=5; i++){
            numbers[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}
