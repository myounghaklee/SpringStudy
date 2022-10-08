# Recursion
자기자신을 다시 호출하는 메서드를 재귀메서드라고한다. 
```java
public class Test(){
    public static void main(String[] args) {
        recur();
    }
    public void recur(){
        return recur();
    }
}
```

대표적인 재귀함수로는 팩토리얼, 조합, 순열을 예로 들 수 있다 
```java
public class FatoTest(){
    public int factorial(int n){
        if( n == 0) return 1; 
        
        return n*factorial(n-1);
    }
}
```

## 순환적 알고리즘 설계
- 적어도 하나의 기저조건 (base case)가 있어야 된다. (종료조건)
- 모든 경우의 수는 기저조건으로 수렴해야만 한다. -> 그래야 예외가 발생하지 않는다.
- 암시적 매개변수를 명시적 매개변수로 바꿔라 
```java
public class explicitSearch(){
    public int search(int data[], int begin, int end, int target){
        if(begin>end)return -1;
        else if(target == items[begin])return begin;
        else return search(data, begin+1, end, target;
    }
}
```
위 코드에서처럼 begin, end변수를 명시적으로 표현해주는것이 재귀함수를 이해할때 좋은 방법이다.

### Binary Search
이진탐색은 기본적으로 배열에 데이터가 정렬되어있다는 가정하에 탐색하는 방법이다. 
```java
public class binaryTest() {

    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) return -1;
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0) return middle;
            else if (compResult < 0) { // 내가 찾으려고 하는 타겟이 더 작을 때 
                return binarySearch(items, target, begin, middle - 1);
            }
            else
                return binarySearch(items, target, middle + 1, end);
        }
    }
}
```

### 미로찾기
```
//수도코트 
boolean findPath(x,y)
    if (x,y)is the exit
        return ture;
    else 
        mark(x,y) as a visited cell;
        for each neighbouring cell(x',y')of(x,y) do
            if(x',y') is on the pathway and  not visited
                if findPath(x',y')
                    return true;
        return false;
```


### counting cells in a blob
blob은 2차원 배열(0,1로 이루어진)이 주어졌을때 연속된 셀들을 말한다.
조건으로 보통 상하죄우, 대각선까지 를 이어진 셀이라고 할 수 있다.





