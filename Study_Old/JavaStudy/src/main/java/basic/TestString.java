package basic;

public class TestString {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0;i<26;i++){
            sb.append((char)('a'+i));
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(2, '高');
        System.out.println(sb);
        char a = '高';

    }
}
