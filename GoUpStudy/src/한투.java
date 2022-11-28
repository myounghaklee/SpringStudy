public class 한투 {
    private static char[] charArray;
    static String regex = "/(([가-힣A-Za-z·\\d~\\-\\.]{2,}(로|길).[\\d]+)|([가-힣A-Za-z·\\d~\\-\\.]+(읍|동)\\s)[\\d]+)/";

    public static void main(String[] args) {
        String s = "성남, 분당 백 현 로 265, 푸른마을 아파트로 보내주세요!!";
        String s2 = "마포구 도화-2길 코끼리분식";
        s = s.replace(" ", "");
        s.
        s = String.valueOf(s.matches(regex));
//        charArray = s.toCharArray();
//        for (char tmp: s.toCharArray()) {
//
//        }
        System.out.println(s);
    }
}
