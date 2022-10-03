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

