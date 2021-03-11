
/**
 * 283.移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0; // 用来记录不为0的数字下标
        for (int i = 0; i < nums.length; i++) {
            // 不为0的时候才能操作
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MoveZeroes move = new MoveZeroes();
        int testCase[] = { 0, 1, 0, 3, 12 };
        System.out.print("操作前：");
        move.printArray(testCase);
        move.moveZeroes(testCase);
        System.out.print("操作后：");
        move.printArray(testCase);
    }
}
