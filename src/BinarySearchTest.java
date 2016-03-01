import java.util.Scanner;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-22 14:18
 */
public class BinarySearchTest {
    public static int rank(int[] from, int k) {
        int length = from.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k > from[mid]) {
                left = mid + 1;
            } else if (k < from[mid]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /** test **/
        Scanner scanner = new Scanner(System.in);
        int maxn = scanner.nextInt();
        for(int i = 0; i < maxn;i++){
            int [] x = new int [i];
        }
    }
}
