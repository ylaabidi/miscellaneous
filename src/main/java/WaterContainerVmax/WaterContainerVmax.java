package WaterContainerVmax;

public class WaterContainerVmax {
    public int maxArea(int[] height) {
        int Vmax = 0;
        int left = 0;
        int right = height.length - 1;
        while(left != right) {
            int max = Math.min(height[left], height[right]) * (right-left);
            Vmax = Math.max(Vmax, max);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return Vmax;
    }
}
