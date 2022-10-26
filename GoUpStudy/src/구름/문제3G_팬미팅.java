package 구름;

import java.util.Scanner;

public class 문제3G_팬미팅 {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getUniqueRangeNumber(int[] birthDate, int n, int k)
    {
        int answer = 0; //모든 원소가 서로 다른 범위의 수

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] birthDate = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            birthDate[i] = scanner.nextInt();
        }

        int answer = getUniqueRangeNumber(birthDate, n, k);

        System.out.println(answer);
    }

}

class FrequencyTable
{
    public static final int MAX_SIZE = 1000000;

    int uniqueElements; //현재 중복이 존재하지 않는 unique한 생일의 수
    int[] frequency;    //frequency[b] := 생일이 b인 정보의 수

    FrequencyTable(){
        this.uniqueElements = 0;
        this.frequency = new int[MAX_SIZE];
    }

    /**
     * 새로운 생일을 등록하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void addBirthDate(int birthDate)
    {

    }

    /**
     * 기존의 생일을 제거하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void removeBirthDate(int birthDate)
    {
    }

}
