/*
 * @Author: smile丶
 * @Date:   2020-01-23 13:03:25
 * @Last Modified by:   smile丶
 * @Last Modified time: 2020-01-23 13:07:27
 */

import java.util.*;

public class algo {

    // 这里传参数字符数组，还可以是字符串
    public static int[][] getMaxLCSLength2(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        // 下面完全是根据LCS定义而走；首先处理边界的问题，需要存储0行0列；所以这里动态规划数组长度比原长度多1
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) // 处理边界，注意是<=号
        {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= len1; i++) //第i行，第0列全部为0 //这里是<=号
        {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= len1; i++) //这里是<=号
        {
            for (int j = 1; j <= len2; j++) //这里是<=号
            {
                if (arr1[i - 1] == arr2[j - 1]) //注意这里若是arr1[i] == arr2[j]，就会发生数组越界
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //return dp[len1][len2]; 返回最长子序列长度
        return dp;
    }

    static ArrayList<String> set = new ArrayList<>();
    static ArrayList<List> index = new ArrayList<>();
    static ArrayList<List> index2 = new ArrayList<>();

    public static void traceBack(int[][] dp, char[] arr1, char[] arr2, int i, int j, String lcs_str, ArrayList preList1, ArrayList preList2) {
        ArrayList<Integer> tindex = new ArrayList<>();
        ArrayList<Integer> uindex = new ArrayList<>();
        tindex.addAll(preList1);
        uindex.addAll(preList2);
        while (i > 0 && j > 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                lcs_str += arr1[i - 1];
                tindex.add(i - 1);
                uindex.add(j - 1);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j])
                    j--;
                else if (dp[i][j - 1] < dp[i - 1][j])
                    i--;
                else   // 相等的情况；说明是相等
                {
                    traceBack(dp, arr1, arr2, i - 1, j, lcs_str, tindex, uindex);
                    traceBack(dp, arr1, arr2, i, j - 1, lcs_str, tindex, uindex);
                    return;
                }
            }
        }
        set.add(reverse(lcs_str));
        Collections.reverse(tindex);
        Collections.reverse(uindex);
        index.add(tindex);
        index2.add(uindex);
        //输出最长公共子序列
//		for(String s : set)
//		{
//			System.out.println(s);
//		}
    }


    public static String reverse(String str) {
        StringBuffer strBuf = new StringBuffer(str).reverse();
        return strBuf.toString();
    }


    // 这个函数只是输出最长子序列；显然如果只是记录长度，则直接判断else(xi != yj) dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j])
    public static int maxlongest(String x, String y) {
        int xlen = x.length();
        int ylen = y.length();
        int[][] dp = new int[xlen + 1][ylen + 1];
        int[][] dir = new int[xlen + 1][ylen + 1];
        for (int i = 1; i <= xlen; i++) {
            char xi = x.charAt(i - 1);
            for (int j = 1; j <= ylen; j++) {
                char xj = y.charAt(j - 1);
                if (xi == xj) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dir[i][j] = 2; // 2代表是左上
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    dir[i][j] = 1; //1代表是向上
                } else {
                    dp[i][j] = dp[i][j - 1];
                    dir[i][j] = 3; //3代表是向左
                }
            }
        }


        int i = xlen;
        int j = ylen;
        StringBuffer sb = new StringBuffer();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j])  //找大的那个方向，此处是左边大于上面，则该处的结果是来自左边
                {
                    j--;
                } else if (dp[i][j - 1] < dp[i - 1][j]) {
                    i--;
                } else if (dp[i][j - 1] == dp[i - 1][j]) {
                    // 如果是要打印所有的最长公共子序列，在这里进行保存，详细的见最上面
                    i--; //此结果对于结果1所选取方向，str1的下标左移一位.替换为j--，则结果对应与结果2选取的方向
                }
            }
        }
        //由于是从后往前加入字符的，需要反转才能得到正确结果
        System.out.println(sb.reverse().toString());
        return dp[xlen][ylen];
    }

    public static void main(String[] args) {
        // 测试一：只打印一个最长公共子序列
        String x = "abcbdab";
        String y = "bdcaba";
        int len = maxlongest(x, y);
        System.out.print(len);

        // 测试二：打印所有最长公共子序列
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] numsA = str1.toCharArray();
        char[] numsB = str2.toCharArray();
        int[][] dp = getMaxLCSLength2(numsA, numsB);
        int len1 = dp[numsA.length][numsB.length];
        String lcs_str = "";
        ArrayList<Integer> tindex = new ArrayList<>();
        ArrayList<Integer> uindex = new ArrayList<>();
        traceBack(dp, numsA, numsB, numsA.length, numsB.length, lcs_str, tindex, uindex);
        HashSet<String> resSet = new HashSet<>();
        HashSet<List> respoint1 = new HashSet<>();
        HashSet<List> respoint2 = new HashSet<>();
        resSet.addAll(set);
        System.out.println(resSet.toString());
        respoint1.addAll(index);
        respoint2.addAll(index2);
        System.out.println(respoint1.toString());
        System.out.println(respoint2.toString());
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        for (List list : respoint1) {
            StringBuffer a1 = new StringBuffer();
            for (Object o : list) {
                a1.append(str1.charAt((Integer) o));
            }
            a.add(a1.toString());
        }
        for (List list : respoint2) {
            StringBuffer a2 = new StringBuffer();
            for (Object o : list) {
                a2.append(str2.charAt((Integer) o));
            }
            b.add(a2.toString());
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(len1);


    }

}