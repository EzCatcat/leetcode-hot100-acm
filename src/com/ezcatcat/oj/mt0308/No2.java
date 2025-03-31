package com.ezcatcat.oj.mt0308;

import java.util.*;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/14 20:39
 */
public class No2 {
    /**
     * 放入 n 个大炮，grid[][]
     * 遍历每个大炮，从该大炮的上下左右方向找架子，攻击架子后面的一个炮
     * 如果不要数组，用什么记录？map
     * 一个x，对应多少ys
     * 注意：不能用 y-1 y-2 找，没说要挨着，能看见就行。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        List<int[]> p = new ArrayList<>();

        // 读取并存储所有点的坐标
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xMap.putIfAbsent(x,  new ArrayList<>());
            yMap.putIfAbsent(y,  new ArrayList<>());
            xMap.get(x).add(y);
            yMap.get(y).add(x);
            p.add(new  int[]{x, y});
        }
        // list 排序
        for (List<Integer> list : xMap.values()) {
            Collections.sort(list);
        }
        for (List<Integer> list : yMap.values()) {
            Collections.sort(list);
        }

        // 从每个点开始，向四个方向寻找架子，并攻击架子后面的一个炮
        for (int[] point : p) {
            int cnt = 0;
            int x = point[0];
            int y = point[1];
            // 看上下是否满足，在(x, y) 的上下，是否有2个炮
            List<Integer> upAndDown = xMap.get(x);
            int upAndDownSize = upAndDown.size();
            int idx = upAndDown.indexOf(y);
            if (idx >= 2) {
                cnt++;
            }
            if (upAndDownSize - 1 - idx >= 2) {
                cnt++;
            }
            // 看左右是否满足，在(x, y) 的左右，是否有2个炮
            List<Integer> leftAndRight = yMap.get(y);
            int leftAndRightSize = leftAndRight.size();
            int idx2 = leftAndRight.indexOf(x);
            if (idx2 >= 2) {
                cnt++;
            }
            if (leftAndRightSize - 1 - idx2 >= 2) {
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
