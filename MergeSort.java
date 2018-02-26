import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] S) {
        int[] left = Arrays.copyOfRange(S, 0, S.length / 2);
        int[] right = Arrays.copyOfRange(S, S.length / 2, S.length);
        return realSort(left, right);
    }

    private static int[] realSort(int[] left, int[] right) {
        if (left.length > 1) {
            left = realSort(Arrays.copyOfRange(left, 0, left.length / 2),
                    Arrays.copyOfRange(left, left.length / 2, left.length));
        }
        if (right.length > 1) {
            right = realSort(Arrays.copyOfRange(right, 0, right.length / 2),
                    Arrays.copyOfRange(right, right.length / 2, right.length));
        }
        int[] sorted = new int[left.length + right.length];
        int i, j, idx;
        i = j = idx = 0;
        while (idx < sorted.length) {
            if (i == left.length) {
                sorted[idx++] = right[j++];
            } else if (j == right.length) {
                sorted[idx++] = left[i++];
            } else if (left[i] < right[j]) {
                sorted[idx++] = left[i++];
            } else if (left[i] > right[j]) {
                sorted[idx++] = right[j++];
            } else {
                sorted[idx++] = left[i++];
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 3, -6, 6, 5, 4, 83, 74, 1, 3, 9, 20, 6};
        int[] sorted = sort(test);
        Arrays.sort(test);
        System.out.println("Success: " + Arrays.equals(test, sorted));
    }
}
