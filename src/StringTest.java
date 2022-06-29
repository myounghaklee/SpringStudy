public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("asdf");
        String str2 = new String("asdf");
        System.out.println(str1 ==str2);

        String str3 = "asdf";
        String str4 = "asdf";
        System.out.println(str3 ==str4);
        System.out.println(str1 ==str3);
    }
}
