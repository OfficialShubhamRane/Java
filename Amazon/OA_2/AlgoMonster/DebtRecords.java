package AlgoMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class DebtRecords {

    public static List<String> debtRecords(List<List<String>> debts) {

        HashMap<String, Integer> bals = new HashMap<>();

        for (List<String> record : debts) {
            int amount = Integer.parseInt(record.get(2));
            bals.merge(record.get(0), -amount, Integer::sum);
            bals.merge(record.get(1), amount, Integer::sum);
        }

        int minBal = -1;
        ArrayList<String> minMems = new ArrayList<>();

        for (Map.Entry<String, Integer> e : bals.entrySet()) {
            int bal = e.getValue();

            if (bal > minBal)
                continue;

            if (bal < minBal) {
                minBal = bal;
                minMems.clear();
            }
            minMems.add(e.getKey());
        }

        if (minMems.isEmpty())
            return List.of("Nobody has a negative balance");
        minMems.sort(null);
        return minMems;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int debtsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> debts = new ArrayList<>();

        for (int i = 0; i < debtsLength; i++) {
            debts.add(Arrays.asList(scanner.nextLine().split(" ")));
        }

        scanner.close();
        List<String> res = debtRecords(debts);
        System.out.println(String.join(" ", res));
    }

}
