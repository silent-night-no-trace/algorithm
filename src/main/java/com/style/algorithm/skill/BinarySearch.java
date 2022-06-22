package com.style.algorithm.skill;

/**
 * 二分搜索
 *
 * @author leon
 * @date 2021-12-24 10:50:32
 */
@SuppressWarnings("all")
public class BinarySearch {

    /**
     * 普通二分查找法
     * 1. 为什么 while 循环的条件中是 <=，而不是 < ？
     * <p>
     * <p>
     * <p>
     * 答：因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
     * <p>
     * <p>
     * <p>
     * 这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间 [left, right]，后者相当于左闭右开区间 [left, right)，因为索引大小为 nums.length 是越界的。
     * <p>
     * <p>
     * <p>
     * 我们这个算法中使用的是 [left, right] 两端都闭的区间。这个区间就是每次进行搜索的区间，我们不妨称为「搜索区间」。
     * <p>
     * <p>
     * <p>
     * 什么时候应该停止搜索呢？当然，找到了目标值的时候可以终止：
     * <p>
     * <p>
     * <p>
     * if(nums[mid] == target)
     * return mid;
     * <p>
     * <p>
     * 但如果没找到，就需要 while 循环终止，然后返回 -1。那 while 循环什么时候应该终止？搜索区间为空的时候应该终止，意味着你没得找了，就等于没找到嘛。
     * <p>
     * <p>
     * <p>
     * while(left <= right)的终止条件是 left == right + 1，写成区间的形式就是 [right + 1, right]，或者带个具体的数字进去 [3, 2]，可见这时候搜索区间为空，因为没有数字既大于等于 3 又小于等于 2 的吧。所以这时候 while 循环终止是正确的，直接返回 -1 即可。
     * <p>
     * <p>
     * <p>
     * while(left < right)的终止条件是 left == right，写成区间的形式就是 [right, right]，或者带个具体的数字进去 [2, 2]，这时候搜索区间非空，还有一个数 2，但此时 while 循环终止了。也就是说这区间 [2, 2] 被漏掉了，索引 2 没有被搜索，如果这时候直接返回 -1 就可能出现错误。
     * <p>
     * <p>
     * <p>
     * 当然，如果你非要用 while(left < right) 也可以，我们已经知道了出错的原因，就打个补丁好了：
     * <p>
     * <p>
     * <p>
     * //...
     * while(left < right) {
     * // ...
     * }
     * return nums[left] == target ? left : -1;
     * <p>
     * <p>
     * 2. 为什么 left = mid + 1，right = mid - 1？我看有的代码是 right = mid 或者 left = mid，没有这些加加减减，到底怎么回事，怎么判断？
     * <p>
     * <p>
     * <p>
     * 答：这也是二分查找的一个难点，不过只要你能理解前面的内容，就能够很容易判断。
     * <p>
     * <p>
     * <p>
     * 刚才明确了「搜索区间」这个概念，而且本算法的搜索区间是两端都闭的，即 [left, right]。那么当我们发现索引 mid 不是要找的 target 时，如何确定下一步的搜索区间呢？
     * <p>
     * <p>
     * <p>
     * 当然是去搜索 [left, mid - 1] 或者 [mid + 1, right] 对不对？因为 mid 已经搜索过，应该从搜索区间中去除。
     * <p>
     * <p>
     * <p>
     * 3. 此算法有什么缺陷？
     * <p>
     * <p>
     * <p>
     * 答：至此，你应该已经掌握了该算法的所有细节，以及这样处理的原因。但是，这个算法存在局限性。
     * <p>
     * <p>
     * <p>
     * 比如说给你有序数组 nums = [1,2,2,2,3]，target = 2，此算法返回的索引是 2，没错。但是如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
     *
     * @param nums   nums
     * @param target target
     * @return target
     */
    public static int binarySearch(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 左匹配
     * 速记 right = nums.length();
     * left < right
     * >= 更新 right right = mid;
     * < 更新 左  left = mid+1
     * <p>
     * 为什么 left = mid + 1，right = mid ？和之前的算法不⼀样？
     * 答：这个很好解释，因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之 后，下⼀步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)。
     * <p>
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     * 因为我们需找到 target 的最左侧索引 所以当 nums[mid] == target 时不要⽴即返回 ⽽要收紧右侧边界以锁定左侧边界
     *
     * @param nums   nums
     * @param target target
     * @return int
     */
    public static int leftBound(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * {1,2,3,4,5,5}
     *
     * @param nums   nums
     * @param target target
     * @return int
     */
    public static int leftBound2(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        //// 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 右匹配
     * left ,right = nums.length();
     * left < right
     * <= 更新左 left = mid+1;
     * > 更新右 right = mid;
     * <p>
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     * 因为我们需找到 target 的最右侧索引 所以当 nums[mid] == target 时不要⽴即返回 ⽽要收紧左侧边界以锁定右侧边界 ⼜因为收紧左侧边界时必须 left = mid + 1 所以最后⽆论返回 left 还是 right，必须减⼀
     *
     * @param nums   nums
     * @param target target
     * @return int
     */
    public static int rightBound(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        //注意 right 开区间
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        //返回  left = mid + 1 mid = left -1
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static int rightBound2(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        //注意 right 闭区间
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    /**
     * 最后总结
     * <p>
     * <p>
     * <p>
     * 先来梳理一下这些细节差异的因果逻辑：
     * <p>
     * <p>
     * <p>
     * 第一个，最基本的二分查找算法：
     * <p>
     * <p>
     * <p>
     * 因为我们初始化 right = nums.length - 1
     * 所以决定了我们的「搜索区间」是 [left, right]
     * 所以决定了 while (left <= right)
     * 同时也决定了 left = mid+1 和 right = mid-1
     * <p>
     * 因为我们只需找到一个 target 的索引即可
     * 所以当 nums[mid] == target 时可以立即返回
     * <p>
     * <p>
     * 第二个，寻找左侧边界的二分查找：
     * <p>
     * <p>
     * <p>
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid+1 和 right = mid
     * <p>
     * 因为我们需找到 target 的最左侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧右侧边界以锁定左侧边界
     * <p>
     * <p>
     * 第三个，寻找右侧边界的二分查找：
     * <p>
     * <p>
     * <p>
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid+1 和 right = mid
     * <p>
     * 因为我们需找到 target 的最右侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧左侧边界以锁定右侧边界
     * <p>
     * 又因为收紧左侧边界时必须 left = mid + 1
     * 所以最后无论返回 left 还是 right，必须减一
     *
     * @param args args
     */
    public static void main(String[] args) {
        // left 1
        // (7+0)/2 mid  = 3
        // right = mid - 1  2
        // 0+2/2 mid = 1
        // nums[mid] = 1
        // right = mid - 1 =0
        // 0+0/2 mid = 0
        //
        int[] nums = {1, 1, 2, 12, 32, 45, 56};

        //right 56
        //mid = (0+8)/2 = 4
        //nums[mid] = nums[4] =  32
        //nums[4] = 32 < 56
        //left = mid +1 = 5
        //mid = (5+8)/2 = 6
        //nums[mid] = nums[6] = 56;
        //nums[mid] = 56 == 56
        //left = mid+1 = 7
        // mid = (7+8)/2 = 7
        //nums[7] = 56 ==56
        //left = 7+1 =8
        // (8+8)/2 = mid[8] = 56 ==56
        //

        int[] nums1 = {1, 2, 2, 12, 32, 45, 56, 56};
        int[] nums2 = {1, 2, 2, 12, 32, 45, 56, 56, 56};
        int[] nums3 = {1, 2, 2, 12, 32, 45, 56, 56, 56, 56};

        System.out.println(leftBound(nums, 1));
        System.out.println(leftBound2(nums, 1));
        System.out.println(rightBound(nums1, 56));
        System.out.println(rightBound(nums2, 56));
        System.out.println(rightBound(nums3, 56));
        System.out.println(rightBound2(nums3, 56));
    }

}
