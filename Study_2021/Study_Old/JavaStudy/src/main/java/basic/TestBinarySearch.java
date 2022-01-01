package basic;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 41, 43};
        int value = 11;

        System.out.println(binarySearch(values, value));
    }

    public static int binarySearch (int[] values, int value){
        int low = 0;
        int high = values.length -1;
        int mid = 0;
        while (true){
            mid = (low + high) /2;
            if (values[mid] == value) return mid;
            if (values[mid] > value) {
                high = mid -1;
            } else {
                low = mid +1;
            }
            if (low >high) return -1;
            Integer var = 0;
            Integer a = Integer.valueOf(1);
            Long b = Long.valueOf(123L);
            Character c = Character.valueOf('a');
            String d = "biangi";
        }
    }
}
