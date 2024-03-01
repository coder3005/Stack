import java.util.Stack;

public class StackB {

    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;

        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < n) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop(); 
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1; // Calculate the distance between the current bar and the bar at the top of the stack
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top]; // Calculate the height of the water trapped between the bars
                water += distance * boundedHeight; // Calculate the amount of water trapped and add it to the total water
            }
            stack.push(current++); // Push the current bar's index onto the stack
        }

        return water; // Return the total water trapped
    }

    public static void main(String[] args) {
        int[] height = {7,0,4,2,5,0,6,4,0,6};
        int trappedWater = trap(height);
        System.out.println("Total trapped water: " + trappedWater); // Output: 6
    }
}
