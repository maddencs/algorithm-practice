import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static int count(List<Integer> ints){
        int sum;
        int count = 0;
        for(int i = 0; i < ints.size() - 1; i++){
            for(int j = i+1; j < ints.size(); j++){
                sum = ints.get(i) + ints.get(j);
                if(BinarySearch.search(ints.subList(j+1, ints.size()), -sum) != -1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(new File("textfiles/threesum.txt"));
            List<Integer> ints = new ArrayList<>();
            while(scanner.hasNext()){
                ints.add(scanner.nextInt());
            }
            System.out.println("Total triples that sum to 0: " + count(ints));
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
