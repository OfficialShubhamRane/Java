package AlgoMonster;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class HighestProfit {

    private static int seqSum(int start, int stop) {
        return (start + stop - 1) * (stop - start) / 2;
    }

    public static int findProfit(int numSuppliers, List<Integer> inventory, int order) {

        // WRITE YOUR BRILLIANT CODE HERE

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int item : inventory)
            counter.merge(item, 1, Integer::sum);

        // (stock, suppliers count) in stock desc

        List<Entry<Integer, Integer>> count = counter.entrySet().stream()
                .sorted(Comparator.comparingInt(Entry<Integer, Integer>::getKey).reversed())
                .collect(Collectors.toList());

        int suppliers = 0;
        int profit = 0;
        int left = order;

        for (int i = 0; i < count.size() && left > 0; i++) {
            int stock = count.get(i).getKey();
            int nextStock = i < count.size() - 1 ? count.get(i + 1).getKey() : 0;
            suppliers += count.get(i).getValue();
            int supply = suppliers * (stock - nextStock);
            int full = Math.min(left, supply) / suppliers;
            int part = Math.min(left, supply) % suppliers;
            profit += suppliers * seqSum(stock - full + 1, stock + 1) + part * (stock - full);
            left -= supply;
        }
        return profit;
    }

    public static void main(String[] args) {
        //Driver Code
        Scanner scanner = new Scanner(System.in);
        int numSuppliers = Integer.parseInt(scanner.nextLine());
        List<Integer> inventory = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int order = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findProfit(numSuppliers, inventory, order);
        System.out.println(res);
    }
}