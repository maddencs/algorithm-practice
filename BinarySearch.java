import java.util.*;

public class BinarySearch {
    public static int search(List<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;
        int mid = high / 2; 
        while(low < high){
            if(list.size() == 0){
                return - 1;
            }
            if(list.get(mid) < num){
                list = list.subList(mid, list.size());
                mid = list.size() / 2;
            } else if(list.get(mid) > num){
                list = list.subList(0, mid);
                mid = list.size() / 2;
            } else if(list.get(mid) == num){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        List<Integer> testArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(search(testArray, 8));
    }
}
