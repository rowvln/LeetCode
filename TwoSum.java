/*
    Two Sums:

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
 */

class Solution {
    // Create a function that returns the indices of two numbers that add up to the target value
    public int[] twoSum(int[] nums, int target){
        // Create a Hashmap that holds a calculated value
        Map<Integer, Integer> map = new Hashmap<>();
        
        // Find the complement of every number in the array and if it matches a number that has already been found, return the indices of both numbers
        for(int i = 0; i < nums.length; i++){
            // complement value
            int complement = target - nums[i];
            
            // if found get the key-pair values for the complement
            if(map.containsKey(complement)){
                return new int[]{ map.get((complement), i) };
            }
            
            map.put(nums[i], i);
        }
        // If no complement is found, then throw an error that "No Two Sum Solutions Exist."
        throw new IllegalArgumentException("No Two Sum Solutions Exist.");
    }
}