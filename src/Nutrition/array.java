package Nutrition;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/**
 * @ClassName array
 * @Description TODO
 * @Author gy
 * @Date 2021/7/25 11:47
 */
public class array {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int[] res = new int[nums1.length];
        Map<Integer, Integer> num_count = new HashMap<>();
        for (int num : nums1) {
            if (num_count.containsKey(num)) {
                int count = num_count.get(num) + 1;
                num_count.put(num, count);
            } else {
                num_count.put(num, 1);
            }
        }
        int index = 0;
        for (int num : nums2) {
            if (num_count.containsKey(num) && num_count.get(num) > 0) {
                res[index++] = num;
                int count = num_count.get(num);
                num_count.put(num, --count);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> subString = new HashMap<>();
        int length = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ) {
            if (subString.isEmpty()) {
                start = i;
            }
            if (!subString.containsKey(s.charAt(i))) {
                subString.put(s.charAt(i), i);
                i++;
            } else {
                int k = subString.get(s.charAt(i)) - start + 1;
                subString.clear();
                ;
                i = k;
            }

            length = length < subString.size() ? subString.size() : length;
        }
        return length;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        int k = 0;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[k++] = nums[right] * nums[right];
                right--;
            } else {
                res[k++] = nums[left] * nums[left];
                left++;
            }
        }
        for (int i = 0; i < res.length / 2; i++) {
            int temp = res[i];
            res[i] = res[n - 1 - i];
            res[n - 1 - i] = temp;
        }
        return res;
    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            String s1 = new StringBuilder(ss[i]).reverse().toString();
            if (i != ss.length - 1) {
                str.append(ss + " ");
            } else
                str.append(ss);
        }
        return str.toString();
    }

    public void timeprint() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }
    public static void main(String args[]) {
        array a = new array();
        a.compareVersion("1.01","1.001");
    }
}
