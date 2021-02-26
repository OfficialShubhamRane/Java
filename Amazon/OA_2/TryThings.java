import java.util.PriorityQueue;

public class TryThings {
    public static void main(String[] args) {
    //     var unsinged = Integer.parseUnsignedInt("3000000000");
    //     System.out.println("unsigned value is: " + unsinged);

    //     var result = Integer.divideUnsigned(unsinged, 2);
    //     System.out.println("Result: " + result);
        
        int[][] points = {{1,3},{-2,2}};
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]) );

        for (int[] point : points) {
            System.out.println("Point in start of the loop: " + point[0] + ", " + point[1]);
            maxHeap.add(point);
            
        }
        System.out.println("Size: " + maxHeap.size());

        int[][] result = new int[2][2];
        
        result[0] = maxHeap.peek();
        System.out.println(result[0]);


    }
}
