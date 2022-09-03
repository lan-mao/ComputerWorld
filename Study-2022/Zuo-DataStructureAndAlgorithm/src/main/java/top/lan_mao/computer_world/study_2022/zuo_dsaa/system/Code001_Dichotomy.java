package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import top.lan_mao.computer_world.study_2022.zuo_dsaa.novice.Code002_Sort;
import top.lan_mao.computer_world.study_2022.zuo_dsaa.utill.UtillTool;

import java.util.Arrays;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/06 18:14 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 二分法 <br>
 */
public class Code001_Dichotomy {

    /**
     * 找到大于或等于number的最左位置
     */
    public static int findLeftmostPositionOfGreaterThanOrEqual(int[] array, int number) {
        if (array == null) {
            return -1;
        }

        int point = array.length / 2;

        int begin = 0;
        int end = array.length - 1;

        int result = -1;

        while (begin <= end) {
            if (array[point] >= number) {
                result = point;
                end = point - 1;
            } else {
                begin = point + 1;
            }
            // 不要使用：point = ( end + begin) >> 2; 因为可能溢出
            point = ((end - begin) >> 1) + begin;
        }

        return result;
    }

    /**
     * 一个任意两相邻位置不相等的无序数组中，找到一个比他左右两边的数都小的数。
     */
    public static int findLocalMinimumNumber(int[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        if (array[0] < array[1]) {
            return 0;
        }
        if (array[array.length - 2] > array[array.length - 1]) {
            return array.length - 1;
        }

        int left = 0;
        int right = array.length - 1;
        int point = 0;

        while (left <= right) {
            point = left + (right - left) >> 2;
            if (array[point] > array[point - 1]) {
                right = point - 1;
            } else if (array[point] > array[point + 1]) {
                left = point + 1;
            } else {
                return point;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = UtillTool.generateArray(2, 100, 0);
        Code002_Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(findLeftmostPositionOfGreaterThanOrEqual(array, 50));
    }
}