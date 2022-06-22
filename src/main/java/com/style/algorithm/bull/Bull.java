package com.style.algorithm.bull;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.*;

/**
 * @author leon
 * @date 2022-02-10 20:34:11
 */
public class Bull {

    public static void main0(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            int len = input.length();
            int remain = len % 8;
            if (remain != 0) {
                int need = 8 - remain;
                for (int i = 0; i < need; i++) {
                    input += "0";
                }
            }
            int count = input.length() / 8;
            for (int i = 0; i < count; i++) {
                System.out.println(input.substring(i * 8, (i + 1) * 8));
            }
        }

    }


    public static void main01(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine().toLowerCase();
            String val = in.nextLine().toLowerCase();
            int length = input.length();
            int newLength = input.replaceAll(val, "").length();
            System.out.println(length - newLength);
        }
    }

    private static Map<Character, Integer> characterIntegerMap;

    static {
        characterIntegerMap = new HashMap<>();
        characterIntegerMap.put('0', 0);
        characterIntegerMap.put('1', 1);
        characterIntegerMap.put('2', 2);
        characterIntegerMap.put('3', 3);
        characterIntegerMap.put('4', 4);
        characterIntegerMap.put('5', 5);
        characterIntegerMap.put('6', 6);
        characterIntegerMap.put('7', 7);
        characterIntegerMap.put('8', 8);
        characterIntegerMap.put('9', 9);
        characterIntegerMap.put('a', 10);
        characterIntegerMap.put('b', 11);
        characterIntegerMap.put('c', 12);
        characterIntegerMap.put('d', 13);
        characterIntegerMap.put('e', 14);
        characterIntegerMap.put('f', 15);
        characterIntegerMap.put('A', 10);
        characterIntegerMap.put('B', 11);
        characterIntegerMap.put('C', 12);
        characterIntegerMap.put('D', 13);
        characterIntegerMap.put('E', 14);
        characterIntegerMap.put('F', 15);
    }

    public static void main02(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            input = input.substring(2);
            int res = 0;
            for (char c : input.toCharArray()) {
                res = res * 16 + characterIntegerMap.get(c);
            }
            System.out.println(res);
        }
    }

    public static void main2(String[] args) {
        //HJ6 质数因子
        //描述
        //功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
        //
        //
        //数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
        //9
        // +14
        //输入描述：
        //输入一个整数
        //
        //输出描述：
        //按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
        //
        //示例1
        //输入：
        //180
        //复制
        //输出：
        //2 2 3 3 5

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long num = in.nextLong();
            //正整数的质数因子只有一个大于等于其平方值
            long k = (long) Math.sqrt(num);
            for (int i = 2; i <= k; i++) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    //更新num
                    num /= i;
                }
            }
            System.out.print(num == 1 ? "" : num + " ");
        }
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> {
            return a - b;
        });

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            //从缓存中判断是否 存在 存在的 新的值加上旧的值
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        //循环输出
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static void main4(String[] args) {
        //描述
        //输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
        //保证输入的整数最后一位不是 0 。
        //
        //数据范围： 1 \le n \le 10^{8} \1≤n≤10
        //8
        //
        //输入描述：
        //输入一个int型整数
        //
        //输出描述：
        //按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
        //
        //示例1
        //输入：
        //9876673
        //复制
        //输出：
        //37689
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            int n = s.length();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (int i = n - 1; i >= 0; i--) {
                set.add(s.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : set) {
                sb.append(c);
            }
            System.out.println(sb.toString());

        }
    }

    public static void main5(String[] args) {
        //描述
        //给定 n 个字符串，请对 n 个字符串按照字典序排列。
        //
        //数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
        //输入描述：
        //输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
        //输出描述：
        //数据输出n行，输出结果为按照字典序排列的字符串。
        //示例1
        //输入：
        //9
        //cap
        //to
        //cat
        //card
        //two
        //too
        //up
        //boat
        //boot
        //复制
        //输出：
        //boat
        //boot
        //cap
        //card
        //cat
        //to
        //too
        //two
        //up
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            int n = Integer.parseInt(in.readLine());
//            //直接使用Arrays工具排序排序
//            String[] array = new String[n];
//            for (int i = 0; i < n; i++) {
//                String s = in.readLine();
//                //System.out.println("ss : " + s);
//                array[i] = s;
//            }
//            Arrays.sort(array);
//
//            for (String s : array) {
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        //直接使用Arrays工具排序排序
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            array[i] = s;
        }
        Arrays.sort(array);

        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void main6(String[] args) {
        //描述
        //输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
        //
        //数据范围：保证在 32 位整型数字范围内
        //输入描述：
        // 输入一个整数（int类型）
        //
        //输出描述：
        // 这个数转换成2进制后，输出1的个数
        //
        //示例1
        //输入：
        //5
        //复制
        //输出：
        //2
        //复制
        //示例2
        //输入：
        //0
        //复制
        //输出：
        //0
        //19934318
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println("i: " + i);
            if ((num & 1) == 1) {
                n++;
            }
            //无符号右移
            num = num >>> 1;
        }
        System.out.println(n);
    }

    public static void main7(String[] args) {
        //开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
        //
        //输入：
        //
        //合法坐标为A(或者D或者W或者S) + 数字（两位以内）
        //
        //坐标之间以;分隔。
        //
        //非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
        //
        //下面是一个简单的例子 如：
        //
        //A10;S20;W10;D30;X;A1A;B10A11;;A10;
        //
        //处理过程：
        //
        //起点（0,0）
        //
        //+   A10   =  （-10,0）
        //
        //+   S20   =  (-10,-20)
        //
        //+   W10  =  (-10,-10)
        //
        //+   D30  =  (20,-10)
        //
        //+   x    =  无效
        //
        //+   A1A   =  无效
        //
        //+   B10A11   =  无效
        //
        //+  一个空 不影响
        //
        //+   A10  =  (10,-10)
        //
        //结果 （10， -10）
        //
        //数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \−2
        //31
        // ≤x,y≤2
        //31
        // −1  ，且数字部分仅含正数
        //
        //注意请处理多组输入输出
        //
        //输入描述：
        //一行字符串
        //
        //输出描述：
        //最终坐标，以逗号分隔
        //
        //示例1
        //输入：
        //A10;S20;W10;D30;X;A1A;B10A11;;A10;
        //复制
        //输出：
        //10,-10
        //复制
        //示例2
        //输入：
        //ABC;AKL;DA1;
        //复制
        //输出：
        //0,0

        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        int x = 0, y = 0;
        String[] array = target.split(";");
        for (String s : array) {
            if (!s.matches("[WASD][0-9]{1,2}")) {
                continue;
            }
            String flag = s.substring(0, 1);
            int val = Integer.parseInt(s.substring(1));
            switch (flag) {
                case "W":
                    y += val;
                    break;
                case "A":
                    x -= val;
                    break;
                case "S":
                    y -= val;
                    break;
                case "D":
                    x += val;
                    break;
                default:
            }
            System.out.println(x + "," + y);

        }
    }

    public static void main8(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new LinkedHashMap<>();
        while (in.hasNext()) {
            String s = in.next();
            int line = in.nextInt();
            String[] split = s.split("\\\\");
            String fileName = split[split.length - 1];
            int length = fileName.length();
            fileName = length > 16 ? fileName.substring(length - 16) : fileName;
            String key = fileName + " " + line;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }


        }
        int size = map.size();
        int count = 0;

        //int count=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count++;
            if (count > (size - 8)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

    }

    public static void main9(String[] args) {
        System.out.println(Character.isWhitespace(' '));
        ;
        System.out.println(Character.isSpaceChar(' '));
        ;
        System.out.println(Character.isLetter(' '));
        ;
        System.out.println(Character.isDigit('6'));
        ;
        System.out.println(Character.isWhitespace('6'));
        ;
    }

    public static void main10(String[] args) {
        //描述
        //对字符串中的所有单词进行倒排。
        //
        //说明：
        //
        //1、构成单词的字符只有26个大写或小写英文字母；
        //
        //2、非构成单词的字符均视为单词间隔符；
        //
        //3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
        //
        //4、每个单词最长20个字母；
        //
        //数据范围：字符串长度满足 1 \le n \le 10000 \1≤n≤10000
        //输入描述：
        //输入一行以空格来分隔的句子
        //
        //输出描述：
        //输出句子的逆序
        //
        //示例1
        //输入：
        //I am a student
        //复制
        //输出：
        //student a am I
        //复制
        //示例2
        //输入：
        //$bo*y gi!r#l
        //复制
        //输出：
        //l r gi y bo

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] array = s.split("[^a-zA-Z]");
            int length = array.length - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = length; i >= 0; i--) {
                sb.append(array[i]).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }

    public static void main11(String[] args) {
        //描述
        //王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
        //
        //主件	附件
        //电脑	打印机，扫描仪
        //书柜	图书
        //书桌	台灯，文具
        //工作椅	无
        //
        //如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
        //设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
        //v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
        //请你帮助王强设计一个满足要求的购物单。
        //
        //
        //输入描述：
        //输入的第 1 行，为两个正整数，用一个空格隔开：N m
        //
        //（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
        //
        //
        //从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
        //
        //
        //（其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
        //
        //
        //
        //
        //输出描述：
        // 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
        //示例1
        //输入：
        //1000 5
        //800 2 0
        //400 5 1
        //300 5 1
        //400 3 0
        //500 2 0
        //复制
        //输出：
        //2200
        //复制
        //示例2
        //输入：
        //50 5
        //20 3 5
        //20 3 5
        //10 3 0
        //10 2 0
        //10 1 0
        //复制
        //输出：
        //130
        //复制
        //说明：
        //由第1行可知总钱数N为50以及希望购买的物品个数m为5；
        //第2和第3行的q为5，说明它们都是编号为5的物品的附件；
        //第4~6行的q都为0，说明它们都是主件，它们的编号依次为3~5；
        //所以物品的价格与重要度乘积的总和的最大值为10*1+20*3+20*3=130

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int amount = in.nextInt();
            int m = in.nextInt();
            amount /= 10;
            //存储每个商品的 重量 和 价格
            int[][] weights = new int[m + 1][3];
            int[][] prices = new int[m + 1][3];
            for (int i = 1; i <= m; i++) {
                int price = in.nextInt();
                int weight = in.nextInt();
                int q = in.nextInt();
                //缩小
                price /= 10;
                //重量 = 价格 * weight
                weight = price * weight;
                if (q == 0) {
                    //主件
                    weights[i][0] = weight;
                    prices[i][0] = price;
                } else if (prices[q][1] == 0) {
                    weights[q][1] = weight;
                    prices[q][1] = price;
                } else {
                    weights[q][2] = weight;
                    prices[q][2] = price;
                }
            }
            System.out.println("weights: " + Arrays.deepToString(weights));
            System.out.println("prices: " + Arrays.deepToString(prices));
            int[][] dp = new int[m + 1][amount + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= amount; j++) {
                    //主件
                    int price1 = prices[i][0];
                    int weight1 = weights[i][0];
                    //附件1
                    int price2 = prices[i][1];
                    int weight2 = weights[i][1];
                    //附件2
                    int price3 = prices[i][2];
                    int weight3 = weights[i][2];
                    //四种购买方式
                    //主件
                    dp[i][j] = j - price1 >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - price1] + weight1) : dp[i - 1][j];
                    //主件+附件1
                    dp[i][j] = j - price1 - price2 >= 0 ? Math.max(dp[i][j], dp[i - 1][j - price1 - price2] + weight1 + weight2) : dp[i][j];
                    //主件 + 附件 2
                    dp[i][j] = j - price1 - price3 >= 0 ? Math.max(dp[i][j], dp[i - 1][j - price1 - price3] + weight1 + weight3) : dp[i][j];
                    //主件 + 附件1 + 附件2
                    dp[i][j] = j - price1 - price2 - price3 >= 0 ? Math.max(dp[i][j], dp[i - 1][j - price1 - price2 - price3] + weight1 + weight2 + weight3) : dp[i][j];
                }
            }
            System.out.println(dp[m][amount] * 10);

        }
    }

    public static void main12(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            s = s.replaceAll("\\{", "(")
                    .replaceAll("}", ")")
                    .replaceAll("\\[", "(")
                    .replaceAll("]", ")");
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            System.out.println(engine.eval(s));
            System.out.println(3 + 2 * (1 + 2 * (-4 / (8 - 6) + 7)));
        }

        //硬来
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int n = s.length();
//        int num1 = 0;
//        int o1 = 1;
//        int num2 = 1;
//        int o2 = 1;
//        Stack<Integer> stk = new Stack<>();
//
//        for(int i=0; i<n; i++){
//            char c = s.charAt(i);
//            if(Character.isDigit(c)){
//                //遇到数字则定义num2
//                int cur = 0;
//                while(i<n && Character.isDigit(s.charAt(i))){
//                    cur = cur * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                i--;
//                num2 = o2 == 1 ? num2 * cur : num2 / cur;
//            }else if(c=='*' || c=='/'){
//                //遇到×÷定义o2
//                o2 = c == '*' ? 1 : -1;
//            }else if(c == '(' || c=='{' || c=='['){
//                //遇到括号则保存当前结果，并初始化
//                stk.push(num1);
//                stk.push(o1);
//                stk.push(num2);
//                stk.push(o2);
//
//                num1 = 0;
//                o1 = 1;
//                num2 = 1;
//                o2 = 1;
//            }else if(c == '+' || c=='-'){
//                //遇到加减，说明可以开始计算，计算num1并对定义其他几个变量
//                if(c=='-' && (i==0 || s.charAt(i-1)=='(' || s.charAt(i-1)=='[' || s.charAt(i-1)=='{')){
//                    o1 = -1;
//                    continue;
//                }
//                num1 = num1 + o1 * num2;
//                o1 = (c == '+' ? 1 : -1);
//                num2 = 1;
//                o2 = 1;
//            }else{  //遇到右括号，则出栈，并计算num2
//                int cur = num1 + o1 * num2;
//                o2 = stk.pop();
//                num2 = stk.pop();
//                o1 = stk.pop();
//                num1 = stk.pop();
//
//                num2 = o2 == 1 ? num2 * cur : num2 / cur;
//            }
//        }
//        System.out.println(num1 + o1 * num2);
    }


    public static void main13(String[] args) {
        //有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是 5 瓶，方法如下：先用 9 个空瓶子换3瓶汽水，喝掉 3 瓶满的，喝完以后 4 个空瓶子，用 3 个再换一瓶，喝掉这瓶满的，这时候剩 2 个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用 3 个空瓶子换一瓶满的还给老板。如果小张手上有 n 个空汽水瓶，最多可以换多少瓶汽水喝？
        //
        //数据范围：输入的正 整数满足 1 \le n \le 100 \1≤n≤100
        //
        //注意：本题存在多组输入。
        //允许如题面所述向老板借汽水。
        //输入的 0 仅表示输入结束，并不用输出结果
        //输入描述：
        //输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
        //
        //输出描述：
        //对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
        //
        //示例1
        //输入：
        //3
        //10
        //81
        //0
        //复制
        //输出：
        //1
        //5
        //40
        //复制
        //说明：
        //样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
        //样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一瓶汽水喝完得三个空瓶换一瓶汽水还给老板
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            //3换1
            int res = 0;
            if (num == 0) {
                //借一个 刚好可以 换一瓶
                break;
            }
            //特殊情况 刚刚=2 ;
            if (num == 2) {
                //借一个 刚好可以 换一瓶
                System.out.println(1);
                break;
            }

            while (num / 3 > 0) {
                int can = num / 3;
                int remain = num % 3;
                num = can + remain;
                if (num == 2) {
                    //有两个瓶子 可以借一个
                    num = num + 1;
                }
                res += can;
            }

            System.out.println(res);

//            int num = in.nextInt();
//            if (num == 0) {
//                return;
//            }
//            int count = 0;
//            while (num / 3 > 0) {
//                count += num / 3;
//                //此时还有多少瓶盖
//                num = num / 3 + num % 3;
//                //可以向老板借一个
//                if (num == 2) {
//                    num = num + 1;
//                }
//            }
//            System.out.println(count);

        }

    }

    private static Map<List<Character>, Character> map;

    static {
        map = new HashMap<>();
        map.put(Arrays.asList('a', 'b', 'c'), '2');
        map.put(Arrays.asList('d', 'e', 'f'), '3');
        map.put(Arrays.asList('g', 'h', 'i'), '4');
        map.put(Arrays.asList('j', 'k', 'l'), '5');
        map.put(Arrays.asList('m', 'n', 'o'), '6');
        map.put(Arrays.asList('p', 'q', 'r', 's'), '7');
        map.put(Arrays.asList('t', 'u', 'v'), '8');
        map.put(Arrays.asList('w', 'x', 'y', 'z'), '9');
    }

    public static void main14(String[] args) {
        //密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
        //
        //
        //假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
        //
        //
        //他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
        //
        //
        //声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，不就是 y 了嘛，简单吧。记住，Z 往后移是 a 哦。
        //
        //数据范围： 输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
        //
        //本题有多组样例输入
        //输入描述：
        //输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
        //
        //输出描述：
        //输出渊子真正的密文
        //
        //示例1
        //输入：
        //YUANzhi1987
        //复制
        //输出：
        //zvbo9441987
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            if (null == s || "".equals(s)) {
                continue;
            }
            int length = s.length();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Y') {
                    sb.setCharAt(i, c += 32 + 1);
                } else if (c == 'Z') {
                    sb.setCharAt(i, 'a');
                } else if (c >= 'a' && c <= 'z') {
                    //Character.
                    c = getLetterCode(c);
                    sb.setCharAt(i, c);
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static char getLetterCode(char c) {
        for (List<Character> list : map.keySet()) {
            if (list.contains(c)) {
                return map.get(list);
            }
        }
        return '0';
    }

    public static void main15(String[] args) {
        //密码要求:
        //
        //1.长度超过8位
        //
        //2.包括大小写字母.数字.其它符号,以上四种至少三种
        //
        //3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
        //
        //数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
        //
        //本题有多组输入
        //输入描述：
        //一组或多组字符串。每组占一行
        //
        //输出描述：
        //如果符合要求输出：OK，否则输出NG
        //
        //示例1
        //输入：
        //021Abc9000
        //021Abc9Abc1
        //021ABC9000
        //021$bc9000
        //复制
        //输出：
        //OK
        //NG
        //NG
        //OK

        //^Awsl7w222*hV
        //0p^6#HJ5v4@3zxQv#~1q85
        //$5^$q6
        //s*z8F1O~7~3%83~y46~6&5w15)F46-7483
        //z(9Zh+$ZT*8(9c9&P202*CFM
        //pYr71#@nG5@)
        //8#I682T090!32gth&Wl)O*!H-&-%$En^2*3S$-
        //w3214(08$*o*7j$I-6!5$1b90974b25)p550#D*)@^SU%
        //W(4+1Q2#*&*aX3+02ig8m
        //W!8nDUP0l$m6!k1en8)j4-JQ+
        //5o04ac-l#$-eM021$6*66n9b#o7d06~)^f4
        //6~@
        //Yw-09-Q78G**81O&J210
        //))20Uq%0
        //L83M!g!$~!7&u2B-#ovw~7LKRz5+!
        //!3^@^%45*892nv&50~0S6e2y9U!&i~8iWu2K8z
        //~32@M#
        //3&!8-~6c1-0l#!ommNW%2dJ6U)0JmdR@586!7#+4+-e^)2$
        //++^(348~8N^d$19@2GU3&(3$07i@tt1#)S-*6!(+!34u
        //$y2*+@^7w8~4^0+EN7%1#n94Fpdb4&
        //55
        //a
        //R!g9FpT78$F8WAq~!#(491#F67bf*23X6^48Q
        //00W^20&+L$+B&tH!12^%))4@3F^*OVK(6l6#%27ja
        //(-%&5Et6-2n&%#Tk38(iz&0A7qa8u9((
        //&-4d3$)9&9nMA3@%J0@#~X8wi17kv1V*88%9X2$h+R3@#5v
        //b225H04-!~33#
        //31L$(!i2^8m$2^p
        //p3L^04Pg5923!2$$9pE&009Kjm&1d5(
        //r-^$t6@9O)ReC(8^7b9!T-g0+y+5!
        //n6$++Us66h20!E61$%E%3gMw#-0!
        //^-$ezL%-$30k2plAN9+i8544$B-($aS611#H*0
        //*+5B459-u17&s9$6JRJ@%MD07-5^03^806SN44I@$(*y5-~$2(
        //05ag
        //-CUuJ5Pg39~Wby@^$093Y)kdQ8&Zg51*
        //)-q4(@~l~)ATN
        //)37^%%
        //jC0$4T003#v6*@65&w87a6r3^!x(r%OA28540G33Nl!3
        //&Lh3bvG@!2mGk%+3k57N8s
        //$##467F61vI5JN204oB@hK!0
        //35HI^k89&x4)+107~cJ-5d258Y*)4%mPHs^8
        //07A4D8$X9C8pZ*4v690y#W5#@0$0-+B99Jfd
        //ZH^7%0k3(n5460217!-41H%
        //dSwg*6r$%6tQr(
        //z5!hn%&1$67s*c
        //-&~OBtk#$UCI1-q!Dc(nx43!W8Up!*4-6&12&ba$3~4-
        //80-K!+@#y67854*7%GbB1(*~b2I^u9jCE5~999N0$%~
        //#~5^R7G!&k(7P-%48@m
        //-59V*R(j+~*
        //7!(@0f#+C0$(7$00-A#A4+-KxH8M&^l-8-%9+MB+g4X+b%-*
        //#Z@#!xu6x9
        //A!(630sKb06$#bI12~!4!3%%Sa1H+2%(~8G-3A4#)
        //@+##+*#g534+$+05$D@4~%Z5370
        //F858@TG%&Y0@2$Ba0C&g
        //6V1W49o~ow%S@W8@@
        //z87
        //47$Z^
        //&+36grQ7%9+6g0D*925oBp
        //+19%55@+2oW^i79R)&JGL8&64@836~%%H318l@5G1I)&&@54&1
        //I@4-(85$-6!B@4+j)@
        //CS6(5%x50v%#3D686&7@C!1!-kd-pf7r16

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            if (null == input || "".equals(input)) {
                continue;
            }
            if (valid(input)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean valid(String input) {
        int length = input.length();
        if (length <= 8) {
            return false;
        }
        //大小写字符 数字和 其他 数量
        int upLetter = 0;
        int lowLetter = 0;
        int digit = 0;
        int other = 0;
        for (Character c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lowLetter = 1;
            } else if (c >= 'A' && c <= 'Z') {
                upLetter = 1;
            } else if (Character.isDigit(c)) {
                digit = 1;
            } else {
                other = 1;
            }
        }
        int all = upLetter + lowLetter + digit + other;
        if (all < 3) {
            //小于3种
            return false;
        }

        for (int i = 3; i < length; i++) {
            String substring = input.substring(i);
            if (substring.contains(input.substring(i - 3, i))) {
                return false;
            }
        }
        return true;
    }

    public static void main16(String[] args) {
        ///描述
        //请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
        //
        //所有的IP地址划分为 A,B,C,D,E五类
        //
        //A类地址1.0.0.0~126.255.255.255;
        //
        //B类地址128.0.0.0~191.255.255.255;
        //
        //C类地址192.0.0.0~223.255.255.255;
        //
        //D类地址224.0.0.0~239.255.255.255；
        //
        //E类地址240.0.0.0~255.255.255.255
        //
        //
        //私网IP范围是：
        //
        //10.0.0.0-10.255.255.255
        //
        //172.16.0.0-172.31.255.255
        //
        //192.168.0.0-192.168.255.255
        //
        //
        //子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
        //（注意二进制下全是1或者全是0均为非法子网掩码）
        //
        //注意：
        //1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
        //2. 私有IP地址和A,B,C,D,E类地址是不冲突的
        //
        //输入描述：
        //多行字符串。每行一个IP地址和掩码，用~隔开。
        //
        //输出描述：
        //统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
        //
        //示例1
        //输入：
        //10.70.44.68~255.254.255.0
        //1.0.0.1~255.0.0.0
        //192.168.0.2~255.255.255.0
        //19..0.~255.255.255.0
        //复制
        //输出：
        //1 0 1 0 0 2 1
        //复制
        //说明：
        //10.70.44.68~255.254.255.0的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
        //1.0.0.1~255.0.0.0是无误的A类地址；
        //192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
        //所以最终的结果为1 0 1 0 0 2 1
        //示例2
        //输入：
        //0.201.56.50~255.255.111.255
        //127.201.56.50~255.255.111.255
        //复制
        //输出：
        //0 0 0 0 0 0 0
        //复制
        //说明：
        //类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
        //自测输入
        //10.70.44.68~255.254.255.0
        //1.0.0.1~255.0.0.0
        //192.168.0.2~255.255.255.0
        //19..0.~255.255.255.0
        Scanner in = new Scanner(System.in);
        //a b c d e 类IP 以及错误IP或者掩码 以及私有IP数量
        int a = 0, b = 0, c = 0, d = 0, e = 0, errIpOrMask = 0, privateIp = 0;
        while (in.hasNext()) {
            String input = in.nextLine();
            if (null == input || "".equals(input)) {
                continue;
            }
            String[] ipAndMask = input.split("~");
            String[] ipTable = ipAndMask[0].split("\\.");

            if ("0".equals(ipTable[0]) || "127".equals(ipTable[0])) {
                //去掉 0.0.0.0 和 127.0.0.1
                continue;
            }
            if (!isValidMask(ipAndMask[1])) {
                //判断掩码是否有效
                errIpOrMask++;
            } else {
                if (!isValidIp(ipAndMask[0])) {
                    errIpOrMask++;
                } else {
                    //第一位
                    int first = Integer.parseInt(ipTable[0]);
                    int second = Integer.parseInt(ipTable[1]);

                    if (first >= 1 && first <= 126) {
                        //A类 1.0.0.0~126.255.255.255;
                        if (first == 10) {
                            //私有地址 10.0.0.0-10.255.255.255
                            privateIp++;
                        }
                        a++;
                    } else if (first >= 128 && first <= 191) {
                        //B类地址128.0.0.0~191.255.255.255;
                        if (first == 172 && second >= 16 && second <= 31) {
                            ////172.16.0.0-172.31.255.255
                            privateIp++;
                        }
                        b++;
                    } else if (first >= 192 && first <= 223) {
                        //C类地址192.0.0.0~223.255.255.255;
                        if (first == 192 && second == 168) {
                            //192.168.0.0-192.168.255.255
                            privateIp++;
                        }
                        c++;
                    } else if (first >= 224 && first <= 239) {
                        //D类224.0.0.0~239.255.255.255；
                        d++;
                    } else if (first >= 240 && first <= 255) {
                        //E类240.0.0.0~255
                        e++;
                    }
                }

            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + errIpOrMask + " " + privateIp + " ");
    }

    private static boolean isValidMask(String mask) {
        if (null == mask || "".equals(mask)) {
            return false;
        }
        if (!isValidIp(mask)) {
            return false;
        }
        String[] masks = mask.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String m : masks) {
            String value = Integer.toBinaryString(Integer.parseInt(m));
            int length = value.length();
            if (length < 8) {
                //不足8位 都补上0
                for (int i = 0; i < 8 - length; i++) {
                    sb.append("0");
                }
            }
            sb.append(value);
        }
        //最后一个1在第一个0之前  有效 否则无效
        String res = sb.toString();
        //[1]+[0]+
        return res.lastIndexOf("1") < res.indexOf("0");
    }

    private static boolean isValidIp(String ip) {
        if (null == ip || "".equals(ip)) {
            return false;
        }
        String[] ipTable = ip.split("\\.");
        if (ipTable.length != 4) {
            return false;
        }
        for (String s : ipTable) {
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255) {
                return false;
            }
        }

        return true;
    }

    public static void main17(String[] args) {
        //HJ25 数据分类处理
        //
        //描述
        //信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
        //
        //采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
        //
        //请注意本题有多组输入用例。
        //
        //数据范围：1 \le I,R \le 100 \1≤I,R≤100  ，输入的整数大小满足 0 \le val \le 2^{31}-1\0≤val≤2
        //31
        // −1
        //输入描述：
        //﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限
        //
        //输出描述：
        //﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
        //
        //I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
        //
        //按R<i>从小到大的顺序:
        //
        //(1)先输出R<i>；
        //
        //(2)再输出满足条件的I的个数；
        //
        //(3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
        //
        //(4)最后再输出I。
        //
        //附加条件：
        //
        //(1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
        //
        //(2)如果没有满足条件的I，对应的R<i>不用输出
        //
        //(3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
        //
        //
        //
        //序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
        //
        //序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
        //
        //输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
        //
        //说明：
        //
        //30----后续有30个整数
        //
        //3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
        //
        //6--- 存在6个包含3的I
        //
        //0--- 123所在的原序号为0
        //
        //123--- 123包含3，满足条件
        //
        //示例1
        //输入：
        //15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
        //5 6 3 6 3 0
        //复制
        //输出：
        //30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
        //复制
        //说明：
        //将序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）排序去重后，可得0,3,6。
        //序列I没有包含0的元素。
        //序列I中包含3的元素有：I[0]的值为123、I[3]的值为453、I[7]的值为3、I[9]的值为453456、I[13]的值为453、I[14]的值为123。
        //序列I中包含6的元素有：I[1]的值为456、I[2]的值为786、I[4]的值为46、I[8]的值为665、I[9]的值为453456、I[11]的值为456、I[12]的值为786。
        //最后按题目要求的格式进行输出即可。
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sNum = in.nextInt();
            int[] sArray = new int[sNum];
            for (int i = 0; i < sNum; i++) {
                sArray[i] = in.nextInt();
            }

            int rNum = in.nextInt();
            //对R 进行去重 升序
            TreeSet<Integer> rSet = new TreeSet<>();

            for (int i = 0; i < rNum; i++) {
                rSet.add(in.nextInt());
            }
            //记录索引以及元素
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (Integer num : rSet) {
                //有效数量
                int validCount = 0;
                //存储索引和数据记录
                StringBuilder index = new StringBuilder();
                for (int i = 0; i < sArray.length; i++) {
                    Integer s = sArray[i];
                    if (s.equals(num) || String.valueOf(s).contains(String.valueOf(num))) {
                        //相等 或者 包含 记录下来 索引
                        index.append(i).append(" ").append(s).append(" ");
                        validCount++;
                        count += 2;
                    }
                }
                if (validCount > 0) {
                    //有效数量大于0 拼接有效数量和 有效数目
                    sb.append(num).append(" ").append(validCount).append(" ").append(index);
                    count += 2;
                }
            }

            if (count > 0) {
                System.out.println(count + " " + sb.toString());
            }
        }
    }

    public static void main18(String[] args) {
        //描述
        //定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
        //兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
        //现在给定你 n 个单词，另外再给你一个单词 str ，让你寻找 str 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
        //注意：字典中可能有重复单词。本题含有多组输入数据。
        //
        //数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
        //输入描述：
        //先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
        //输出描述：
        //输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
        //示例1
        //输入：
        //3 abc bca cab abc 1
        //复制
        //输出：
        //2
        //bca
        //复制
        //示例2
        //输入：
        //6 cab ad abcd cba abc bca abc 1
        //复制
        //输出：
        //3
        //bca
        //复制
        //说明：
        //abc的兄弟单词有cab cba bca，所以输出3
        //经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca

        //3 abc bca cab abc 1
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            if (null == s || "".equals(s)) {
                continue;
            }
            String[] split = s.split(" ");
            int num = Integer.parseInt(split[0]);
            int length = split.length;
            String target = split[length - 2];
            int k = Integer.parseInt(split[length - 1]);

            List<String> list = new ArrayList<>();

            for (int i = 1; i <= num; i++) {
                if (isBrother(split[i], target)) {
                    list.add(split[i]);
                }
            }
            int size = list.size();
            //字典排序
            Collections.sort(list);
            System.out.println(size);
            if (size >= k) {
                System.out.println(list.get(k - 1));
            }
        }

    }

    private static boolean isBrother(String s, String target) {
        int length = s.length();
        int targetLength = target.length();
        if (length != targetLength || s.equals(target)) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] targetArray = target.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(targetArray);
        return new String(chars).equals(new String(targetArray));
    }

    public static void main19(String[] args) {
        //HJ29
        //描述
        //1、对输入的字符串进行加解密，并输出。
        //
        //2、加密方法为：
        //
        //当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
        //
        //当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
        //
        //其他字符不做变化。
        //
        //3、解密方法为加密的逆过程。
        //
        //本题含有多组样例输入。
        //
        //数据范围：输入的两个字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，保证输入的字符串都是大小写字母或者数字
        //输入描述：
        //输入说明
        //输入一串要加密的密码
        //输入一串加过密的密码
        //
        //输出描述：
        //

        //输出加密后的字符
        //输出解密后的字符
        //
        //示例1
        //输入：
        //abcdefg
        //BCDEFGH
        //复制
        //输出：
        //BCDEFGH
        //abcdefg

        //2OA92AptLq5G1lW8564qC4nKMjv8C
        //B5WWIj56vu72GzRja7j5
        //2gRSPzofpXZc8EHc5D3c2a5M04M47CAcVbjiCBjatOtM99W64
        //2LQL3p4bf3k006a2YODG0r6fpeKohN4aY27ZImecaGArf2VzXM104Y3O7XiwuqmV

        //3pb03bQUmR6h2Mx9675Rd5OlnKW9d
        //a4vvhI45UT61fYqIZ6I4
        //3HstqAPGQyaD9fiD6e4D3B6n15n58dbDwCKJdcKBUpUn00x75
        //1kpk2O3AE2J995Z1xncf9Q5EODjNGm3Zx16yhLDBZfzQE1uYwl093x2n6wHVTPLu

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //明文
            String source = in.nextLine();
            //密文
            String ciphertext = in.nextLine();
            ////当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
            //当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
            StringBuilder sb = new StringBuilder(source);
            for (int i = 0; i < source.length(); i++) {
                char c = source.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    if (c == 'z') {
                        sb.setCharAt(i, 'A');
                    } else {
                        sb.setCharAt(i, c -= 32 - 1);
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    if (c == 'Z') {
                        sb.setCharAt(i, 'a');
                    } else {
                        sb.setCharAt(i, c += 32 + 1);
                    }
                } else if (Character.isDigit(c)) {
                    if (c == '9') {
                        sb.setCharAt(i, '0');
                    } else {
                        char c1 = (char) ((int) c + 1);
                        sb.setCharAt(i, c1);
                    }
                }
            }
            System.out.println(sb.toString());
            StringBuilder cipher = new StringBuilder(ciphertext);
            for (int j = 0; j < ciphertext.length(); j++) {
                char c = ciphertext.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    if (c == 'a') {
                        cipher.setCharAt(j, 'Z');
                    } else {
                        cipher.setCharAt(j, c -= 32 + 1);
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    if (c == 'A') {
                        cipher.setCharAt(j, 'z');
                    } else {
                        cipher.setCharAt(j, c += 32 - 1);
                    }
                } else if (Character.isDigit(c)) {
                    if (c == '0') {
                        cipher.setCharAt(j, '9');
                    } else {
                        char c1 = (char) ((int) c - 1);
                        cipher.setCharAt(j, c1);
                    }


                }
            }
            //
            System.out.println(cipher.toString());
        }
    }

    public static void main20(String[] args) {
        //HJ39 判断两个IP是否属于同一子网
        //描述
        //子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
        //子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
        //
        //示例：
        //I P 地址　 192.168.0.1
        //子网掩码　 255.255.255.0
        //
        //转化为二进制进行运算：
        //
        //I P 地址　  11000000.10101000.00000000.00000001
        //子网掩码　11111111.11111111.11111111.00000000
        //
        //AND运算   11000000.10101000.00000000.00000000
        //
        //转化为十进制后为：
        //192.168.0.0
        //
        //
        //I P 地址　 192.168.0.254
        //子网掩码　 255.255.255.0
        //
        //
        //转化为二进制进行运算：
        //
        //I P 地址　11000000.10101000.00000000.11111110
        //子网掩码  11111111.11111111.11111111.00000000
        //
        //AND运算  11000000.10101000.00000000.00000000
        //
        //转化为十进制后为：
        //192.168.0.0
        //
        //通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
        //
        //输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
        //若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
        //
        //注:
        //有效掩码与IP的性质为：
        //1. 掩码与IP每一段在 0 - 255 之间
        //2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
        //
        //本题有多组输入
        //
        //输入描述：
        //多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
        //
        //输出描述：
        //若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
        //
        //示例1
        //输入：
        //255.255.255.0
        //192.168.224.256
        //192.168.10.4
        //255.0.0.0
        //193.194.202.15
        //232.43.7.59
        //255.255.255.0
        //192.168.0.254
        //192.168.0.1
        //复制
        //输出：
        //1
        //2
        //0
        //复制
        //说明：
        //对于第一个例子:
        //255.255.255.0
        //192.168.224.256
        //192.168.10.4
        //其中IP:192.168.224.256不合法，输出1
        //
        //对于第二个例子:
        //255.0.0.0
        //193.194.202.15
        //232.43.7.59
        //2个与运算之后，不在同一个子网，输出2
        //
        //对于第三个例子，2个与运算之后，如题目描述所示，在同一个子网，输出0
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String mask = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            if (!isValidMask(mask) || !isValidIp(ip1) || !isValidIp(ip1)) {
                System.out.println(1);
                continue;
            }
            long maskConvert = convert2Long(mask);
            long convert1 = convert2Long(ip1);
            long convert2 = convert2Long(ip2);
            long res1 = maskConvert & convert1;
            long res2 = maskConvert & convert2;

            System.out.println(res1 == res2 ? 0 : 2);

        }
    }


    private static long convert2Long(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        String[] ss = s.split("\\.");

        long sum = 0L;
        long mul = 1L;
        for (int i = ss.length - 1; i >= 0; i--) {
            long seg = Long.parseLong(ss[i]);
            sum += seg * mul;
            mul *= 256;
        }
        System.out.println("sum: " + sum);
        return sum;
    }

    public static void main21(String[] args) {
        //HJ24 合唱队
        //描述
        //计算最少出列多少位同学，使得剩下的同学排成合唱队形
        //
        //说明：
        //
        //N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，使得剩下的 K 位同学排成合唱队形。
        //合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 T1，T2，…，TK ，   则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
        //
        //你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
        //
        //注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
        //请注意处理多组输入输出！
        //
        //数据范围： 1 \le n \le 3000 \1≤n≤3000
        //
        //输入描述：
        //有多组用例，每组都包含两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
        //
        //输出描述：
        //最少需要几位同学出列
        //
        //示例1
        //输入：
        //8
        //186 186 150 200 160 130 197 200
        //复制
        //输出：
        //4
        //复制
        //说明：
        //由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            //左边小于i 数量
            int[] numsLeft = new int[n];
            //右边大于i 数量
            int[] numsRight = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                numsLeft[i] = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        numsLeft[i] = Math.max(numsLeft[j] + 1, numsLeft[i]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                numsRight[i] = 0;
                for (int j = n - 1; j > i; j--) {
                    if (nums[i] > nums[j]) {
                        numsRight[i] = Math.max(numsRight[j] + 1, numsRight[i]);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, numsLeft[i] + numsRight[i] + 1);
            }
            System.out.println(n - max);
        }
    }

    private static final Map<Character, Character> letter216;

    static {
        letter216 = new HashMap<>();
        letter216.put('0', '0');
        letter216.put('1', '8');
        letter216.put('2', '4');
        letter216.put('3', 'C');
        letter216.put('4', '2');
        letter216.put('5', 'A');
        letter216.put('6', '6');
        letter216.put('7', 'E');
        letter216.put('8', '1');
        letter216.put('9', '9');
        //5D37BF
        letter216.put('a', '5');
        letter216.put('b', 'D');
        letter216.put('c', '3');
        letter216.put('d', 'B');
        letter216.put('e', '7');
        letter216.put('f', 'F');

        letter216.put('A', '5');
        letter216.put('B', 'D');
        letter216.put('C', '3');
        letter216.put('D', 'B');
        letter216.put('E', '7');
        letter216.put('F', 'F');
    }

    public static void main22(String[] args) {
        //HJ30 字符串合并处理

        //描述
        //按照指定规则对输入的字符串进行处理。
        //
        //详细描述：
        //
        //第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
        //
        //第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
        //
        //第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
        //转换规则如下：
        //对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
        //如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
        //如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
        //如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
        //根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"
        //
        //
        //注意本题含有多组样例输入。
        //
        //数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
        //
        //输入描述：
        //本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
        //
        //输出描述：
        //输出转化后的结果。每组样例输出一行。
        //
        //示例1
        //输入：
        //dec fab
        //复制
        //输出：
        //5D37BF
        //复制
        //示例2
        //输入：
        //ab CD
        //复制
        //输出：
        //3B5D
        //复制
        //说明：
        //合并后为abCD，按奇数位和偶数位排序后是CDab（请注意要按ascii码进行排序，所以C在a前面，D在b前面），转换后为3B5D
        //示例3
        //输入：
        //123 15
        //复制
        //输出：
        //88C4A
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            input = input.replaceAll(" ", "");
            int length = input.length();
            //偶数数组
            char[] even = new char[length / 2];
            //奇数数组
            char[] odd = new char[length - length / 2];
            for (int i = 0, j = 0, k = 0; i < length; i++) {
                if (i % 2 == 0) {
                    //奇数
                    odd[j] = input.charAt(i);
                    j++;
                } else {
                    //奇数
                    even[k] = input.charAt(i);
                    k++;
                }
            }

            Arrays.sort(even);
            Arrays.sort(odd);
            char[] chars = input.toCharArray();

            for (int i = 0, j = 0, k = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    chars[i] = letter216.getOrDefault(odd[j], odd[j]);
                    j++;
                } else {
                    chars[i] = letter216.getOrDefault(even[k], even[k]);
                    k++;
                }
            }
            System.out.println(new String(chars));

        }

    }

    public static void main23(String[] args) {
        //HJ28 素数伴侣
        //描述
        //题目描述
        //若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
        //
        //输入:
        //
        //有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
        //
        //输出:
        //
        //输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
        //
        //
        //数据范围： 1 \le n \le 100 \1≤n≤100  ，输入的数据大小满足 2 \le val \le 30000 \2≤val≤30000
        //
        //本题有多组输入
        //输入描述：
        //输入说明
        //1 输入一个正偶数 n
        //2 输入 n 个整数
        //题目有多组输入
        //
        //输出描述：
        //求得的“最佳方案”组成“素数伴侣”的对数。
        //
        //示例1
        //输入：
        //4
        //2 5 6 13
        //2
        //3 6
        //复制
        //输出：
        //2
        //0
        //复制
        //示例2
        //输入：
        //2
        //3 6
        //复制
        //输出：
        //0
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            //偶数
            List<Integer> evens = new ArrayList<>();
            //奇数
            List<Integer> odds = new ArrayList<>();

            for (int num : nums) {
                if (num % 2 == 0) {
                    //偶数
                    evens.add(num);
                } else {
                    odds.add(num);
                }
            }
            //偶数的匹配结果
            int[] matchEvens = new int[evens.size()];
            int count = 0;
            //循环奇数 一个一个匹配
            for (int odd : odds) {
                //记录每个偶数是否被访问
                boolean[] match = new boolean[evens.size()];
                //让每个奇数都和 每个偶数进行匹配
                if (find(odd, matchEvens, match, evens)) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    private static boolean find(int odd, int[] matchEvens, boolean[] match, List<Integer> evens) {
        for (int i = 0; i < evens.size(); i++) {
            int even = evens.get(i);
            if (!match[i] && isPrime(odd + even)) {
                //偶数没有被访问 且 两数之和是素数
                //修改访问标记
                match[i] = true;
                //matchEvens[i] 不存在伴侣
                if (matchEvens[i] == 0 || find(matchEvens[i], matchEvens, match, evens)) {
                    //则 将 odd 作为 matchEvent[i] 伴侣
                    matchEvens[i] = odd;
                    return true;
                }
            }
        }


        return false;
    }

    private static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main24(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            List<Character> list = new ArrayList<>();
            //将字母存入list
            for (char c : input.toCharArray()) {
                if (Character.isLetter(c)) {
                    list.add(c);
                }
            }
            //都转为小写 进行排序
            list.sort((a, b) -> {
                return Character.toLowerCase(a) - Character.toLowerCase(b);
            });

            //非字母不变
            StringBuilder sb = new StringBuilder();
            for (int i = 0, j = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isLetter(c)) {
                    sb.append(list.get(j));
                    j++;
                } else {
                    sb.append(c);
                }

            }
            System.out.println(sb.toString());
        }
    }

    public static void main25(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            int length = input.length();

            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length - 1; i++) {
                dp[i][i] = true;
            }
            int max = 0;
            //从左到右 开始转移
            //当 左右字符而且  i+i,j-1 为回文时 i,j肯定也是回文
            ///如 ABBA ABBBA 这两种类型

            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    //j+1,i-1 是回文字符串 则 j,i 也是
                    if (input.charAt(i) == input.charAt(j) && ((i - j <= 2) || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        max = Math.max(max, i - j + 1);
                    }
                }
            }
            System.out.println(max);
        }
    }


    /**
     * 获取 最长回文字符串 长度
     *
     * @param s s
     * @return int
     */
    public static int solution(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            //ABA
            int one = longestLength(s, i, i);
            //ABBA
            int two = longestLength(s, i, i + 1);
            max = Math.max(max, Math.max(one, two));
        }
        return max;
    }

    private static int longestLength(String s, int l, int r) {
        //左边和右边同时开工
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


    public static void main26(String[] args) {
        //HJ33 整数与IP地址间的转换
        //描述
        //原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
        //一个长整数。
        //举例：一个ip地址为10.0.3.193
        //每段数字             相对应的二进制数
        //10                   00001010
        //0                    00000000
        //3                    00000011
        //193                  11000001
        //
        //组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
        //
        //本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
        //
        //数据范围：保证输入的是合法的 IP 序列
        //
        //
        //输入描述：
        //输入
        //1 输入IP地址
        //2 输入10进制型的IP地址
        //
        //输出描述：
        //输出
        //1 输出转换成10进制的IP地址
        //2 输出转换后的IP地址
        //
        //示例1
        //输入：
        //10.0.3.193
        //167969729
        //复制
        //输出：
        //167773121
        //10.3.3.193
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            long num = in.nextLong();
            System.out.println(convertIp2Long(ip));
            System.out.println(convertLong2Ip(num));

        }
    }

    private static long convertIp2Long(String ip) {
        String[] ipTable = ip.split("\\.");
        long res = 0;
        long base = 1;
        int len = ipTable.length;
        if (len >= 1) {
            for (int i = len - 1; i >= 0; i--) {
                long num = Long.parseLong(ipTable[i]);
                res += num * base;
                base *= 256;
            }
        }
        return res;
    }

    private static String convertLong2Ip(long ip) {
        String[] ans = new String[4];
        for (int i = 3; i >= 0; i--) {
            ans[i] = Long.toString(ip % 256);
            ip = ip / 256;
        }
        return String.join(".", ans);
    }

    public static void main27(String[] args) {
        //描述
        //Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
        //
        //本题含有多组样例输入。
        //
        //数据范围：每组输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
        //
        //输入描述：
        //Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
        //
        //输出描述：
        //Lily的所有图片按照从小到大的顺序输出
        //
        //示例1
        //输入：
        //Ihave1nose2hands10fingers
        //复制
        //输出：
        //0112Iaadeeefghhinnnorsssv
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }

    public static void main28(String[] args) {
        //HJ35 蛇形矩阵
        //描述
        //蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
        //
        //例如，当输入5时，应该输出的三角形为：
        //
        //1 3 6 10 15
        //
        //2 5 9 14
        //
        //4 8 13
        //
        //7 12
        //
        //11
        //
        //
        //请注意本题含有多组样例输入。
        //
        //输入描述：
        //输入正整数N（N不大于100）
        //
        //输出描述：
        //输出一个N行的蛇形矩阵。
        //
        //示例1
        //输入：
        //4
        //复制
        //输出：
        //1 3 6 10
        //2 5 9
        //4 8
        //7
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            ////列的方向第一个肯定是1
            int y = 1, xCount, yCount = 1;
            for (int i = 1; i <= num; i++) {
                //第i行的第一个数就是列的第i个数
                int x = y;
                //第一行第一个列的差值 就是i+1
                xCount = i + 1;
                for (int j = 1; j <= num - i + 1; j++) {
                    System.out.print(x + " ");
                    //这一行后面每一个数 差值都 差第一个+1
                    x += xCount++;
                }
                System.out.println("");
                y += yCount++;
            }
        }
    }

    public static void main29(String[] args) {
        //HJ36 字符串加密
        //描述
        //有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。如下所示：
        //A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
        //
        //T R A I L B Z E S C D F G H J K M N O P Q U V W X Y (实际需建立小写字母的字母表，此字母表仅为方便演示）
        //
        //上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙， Attack AT DAWN (黎明时攻击)就会被加密为Tpptad TP ITVH。
        //
        //请实现下述接口，通过指定的密匙和明文得到密文。
        //
        //
        //本题有多组输入数据。
        //
        //数据范围：1 \le n \le 100 \1≤n≤100  ，保证输入的字符串中仅包含小写字母
        //
        //输入描述：
        //先输入key和要加密的字符串
        //
        //输出描述：
        //返回加密后的字符串
        //
        //示例1
        //输入：
        //nihao
        //ni
        //复制
        //输出：
        //le
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String key = in.nextLine();
            String source = in.nextLine();
            //转为大写
            key = key.toUpperCase();
            char[] keyChar = key.toCharArray();
            char[] sourceChar = source.toCharArray();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (char c : keyChar) {
                set.add(c);
            }

            int k = 0;
            while (set.size() < 26) {
                char c = (char) ('A' + k);
                set.add(c);
                k++;
            }

            List<Character> list = new ArrayList<>(set);
            StringBuilder sb = new StringBuilder();
            for (char c : sourceChar) {
                if (Character.isLowerCase(c)) {
                    //小写字幕
                    int index = (int) (c - 'a');
                    char c1 = list.get(index);
                    char c2 = (char) (c1 + 'a' - 'A');
                    sb.append(c2);
                } else if (Character.isUpperCase(c)) {
                    //大写字母
                    int index = c - 'A';
                    Character character = list.get(index);
                    sb.append(character);
                } else {
                    System.out.println(1111);
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }

    }

    // 备忘录，减少重叠子问题
    private static int[] memo;

    public static void main30(String[] args) {
        //HJ37 统计每个月兔子的总数
        //描述
        //有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
        //
        //本题有多组数据。
        //
        //数据范围：每组输入满足 1 \le n \le 31 \1≤n≤31
        //输入描述：
        //多行输入，一行输入一个int型整数表示第n个月
        //
        //输出描述：
        //每一行输出对应的兔子总数
        //
        //示例10
        //输入：
        //1
        //2
        //3
        //4
        //5
        //9
        //复制
        //输出：
        //1
        //1
        //2
        //3
        //5
        //34
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            System.out.println(dp(n));
        }

    }

    // 返回第n个月兔子总量
    private static int dp(int n) {
        // 递归终止条件
        if (n <= 2) {
            return 1;
        }
        // 使用备忘录
        if (memo[n] != -1) {
            return memo[n];
        }
        // 递归调用，满足规律
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }


    private static int solution(int month) {
        // 第一个月初始化
        // 一月龄兔子总数
        int oneMonth = 1;
        // 二月龄兔子总数
        int twoMonth = 0;
        // 三月龄及以上兔子总数
        int threeMonth = 0;
        // 下个月将繁殖的兔子数量
        int addVal = 0;
        // 第二个月开始递推, i表示第i个月
        for (int i = 2; i <= month; i++) {
            // 三月龄及以上兔子总数 = 二月龄兔子总数 + 原本三月龄及以上兔子总数
            threeMonth += twoMonth;
            // 二月龄兔子总数 = 上个月的一月龄兔子总数
            twoMonth = oneMonth;
            // 一月龄（即这个月出生）兔子总数 = 上个月将繁殖的兔子数量
            oneMonth = addVal;
            // 下个月将出生的兔子 = 下个月成为三月龄及以上的兔子数量
            addVal = twoMonth + threeMonth;
        }
        return (oneMonth + twoMonth + threeMonth);
    }


    public static void main31(String[] args) {
        //HJ41 称砝码
        //描述
        //现有一组砝码，重量互不相等，分别为 m1,m2,m3…mn ；
        //每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
        //
        //
        //注：
        //
        //称重重量包括 0
        //
        //本题有多组输入
        //
        //数据范围：每组输入数据满足 1 \le n \le 10 \1≤n≤10  ， 1 \le m_i \le 2000 \1≤m
        //i
        //
        // ≤2000  ， 1 \le x_i \le 10 \1≤x
        //i
        //
        // ≤10
        //输入描述：
        //输入包含多组测试数据。
        //对于每组测试数据：
        //第一行：n --- 砝码数(范围[1,10])
        //第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
        //第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
        //输出描述：
        //利用给定的砝码可以称出的不同的重量数
        //
        //示例1
        //输入：
        //2
        //1 2
        //2 1
        //10
        //4 185 35 191 26 148 149 3 172 147
        //3 5 2 1 5 5 3 1 4 2
        //复制
        //输出：
        //5
        //3375
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //重量 数量
            int[] weights = new int[n];
            int[] amounts = new int[n];

            for (int i = 0; i < n; i++) {
                weights[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                amounts[i] = in.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < n; i++) {
                //遍历砝码
                ArrayList<Integer> list = new ArrayList<>(set);
                for (int j = 1; j <= amounts[i]; j++) {
                    for (Integer integer : list) {
                        //将存的结果和 每个砝码重量*数量 相加
                        set.add(integer + weights[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }

    }

    public static void main32(String[] args) {
        //HJ42 学英语
        //描述
        //Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
        //
        //具体规则如下:
        //1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
        //2.每三位数后记得带上计数单位 分别是thousand, million, billion.
        //3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
        //4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
        //
        //下面再看几个数字例句：
        //22: twenty two
        //100:  one hundred
        //145:  one hundred and forty five
        //1,234:  one thousand two hundred and thirty four
        //8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
        //486,669:  four hundred and eighty six thousand six hundred and sixty nine
        //1,652,510:  one million six hundred and fifty two thousand five hundred and ten
        //
        //说明：
        //数字为正整数，不考虑小数，转化结果为英文小写；
        //保证输入的数据合法
        //关键字提示：and，billion，million，thousand，hundred。
        //
        //数据范围：1 \le n \le 2000000 \1≤n≤2000000
        //
        //本题含有多组输入数据。
        //
        //输入描述：
        //输入多行long型整数
        //
        //输出描述：
        //输出相应的英文写法
        //
        //示例1
        //输入：
        //22
        //100
        //145
        //1234
        //8088
        //486669
        //1652510
        //复制
        //输出：
        //twenty two
        //one hundred
        //one hundred and forty five
        //one thousand two hundred and thirty four
        //eight thousand eighty eight
        //four hundred and eighty six thousand six hundred and sixty nine
        //one million six hundred and fifty two thousand five hundred and ten
        Scanner in = new Scanner(System.in);
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen", "twenty"};

        String[] tenNums = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String[] POWER = {"", "hundred", "thousand", "million", "billion"};
        while (in.hasNext()) {
            long num = in.nextLong();
            int power = 1;
            List<String> list = new ArrayList<>();
            while (num != 0) {
                if (power != 1) {
                    list.add(POWER[power]);
                }
                //记录余数 取第三位
                long t = num % 1000;

                if (t % 100 <= 20) {
                    if (t % 100 != 0) {
                        //余数有效
                        list.add(nums[(int) (t % 100)]);
                    }

                    if (t / 100 != 0) {
                        //存在百位
                        if (t % 100 != 0) {
                            list.add("and");
                        }
                        list.add("hundred");
                        list.add(nums[(int) (t / 100)]);
                    }

                } else {

                    if (t % 10 != 0) {
                        //存在个位
                        list.add(nums[Math.toIntExact(num % 10)]);
                    }
                    t /= 10;
                    if (t % 10 != 0) {
                        //存在十位
                        list.add(tenNums[Math.toIntExact(t % 10)]);
                    }

                    t /= 10;
                    if (t % 10 != 0) {
                        //存在百位
                        list.add("and");
                        list.add("hundred");
                        list.add(nums[(int) (t % 10)]);
                    }
                }
                num /= 1000;
                power++;
            }
            int size = list.size();
            System.out.println(list.toString());
            StringBuilder sb = new StringBuilder();
            for (int i = size - 1; i >= 0; i--) {
                if (i != 0) {
                    sb.append(list.get(i)).append(" ");
                } else {
                    sb.append(list.get(i));
                }
            }
            System.out.println(sb.toString());

        }
    }


    public static void main33(String[] args) {
        //HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
        //描述
        //假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
        //
        //最后的误差判断是小数点6位
        //
        //
        //数据范围：输入的小球初始高度满足 1 \le n \le 1000 \1≤n≤1000  ，且保证是一个整数
        //
        //输入描述：
        //输入起始高度，int型
        //
        //输出描述：
        //分别输出第5次落地时，共经过多少米第5次反弹多高
        //
        //示例1
        //输入：
        //1
        //复制
        //输出：
        //2.875
        //0.03125
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double startHeight = in.nextDouble();
            int n = 5;
            double all = 0.0;
            while (n > 0) {
                all += startHeight;
                System.out.println("开始位置 startHeight: " + startHeight);

                startHeight /= 2;
                if (n != 1) {
                    //最后一次不用计算
                    all += startHeight;
                }
                n--;
            }
            System.out.println(all);
            System.out.println(startHeight);
        }

    }

    public static void main34(String[] args) {
        //HJ43 迷宫问题
        //描述
        //定义一个二维数组 N*M ，如 5 × 5 数组下所示：
        //
        //
        //int maze[5][5] = {
        //0, 1, 0, 0, 0,
        //0, 1, 1, 1, 0,
        //0, 0, 0, 0, 0,
        //0, 1, 1, 1, 0,
        //0, 0, 0, 1, 0,
        //};
        //
        //
        //它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
        //
        //
        //本题含有多组数据。
        //
        //数据范围： 2 \le n,m \le 10 \2≤n,m≤10  ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1
        //
        //输入描述：
        //输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
        //
        //输出描述：
        //左上角到右下角的最短路径，格式如样例所示。
        //
        //示例1
        //输入：
        //5 5
        //0 1 0 0 0
        //0 1 1 1 0
        //0 0 0 0 0
        //0 1 1 1 0
        //0 0 0 1 0
        //复制
        //输出：
        //(0,0)
        //(1,0)
        //(2,0)
        //(2,1)
        //(2,2)
        //(2,3)
        //(2,4)
        //(3,4)
        //(4,4)
        //复制
        //示例2
        //输入：
        //5 5
        //0 1 0 0 0
        //0 1 0 1 0
        //0 0 0 0 1
        //0 1 1 1 0
        //0 0 0 0 0
        //复制
        //输出：
        //(0,0)
        //(1,0)
        //(2,0)
        //(3,0)
        //(4,0)
        //(4,1)
        //(4,2)
        //(4,3)
        //(4,4)
        //
        //复制
        //说明：
        //注意：不能斜着走！！
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            //开始dfs
            List<State> list = new ArrayList<>();

            dfs(arr, 0, 0, list);
            for (State state : list) {
                System.out.println(state.toString());

            }
        }
    }

    private static boolean dfs(int[][] arr, int x, int y, List<State> list) {
        //选择
        int m = arr.length;
        int n = arr[0].length;
        list.add(new State(x, y));
        arr[x][y] = 1;
        //base case
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        //上 位置有效且没有被选中
        if (x - 1 > -1 && arr[x - 1][y] == 0) {
            if (dfs(arr, x - 1, y, list)) {
                return true;
            }

        }
        //下
        if (x + 1 < m && arr[x + 1][y] == 0) {
            if (dfs(arr, x + 1, y, list)) {
                return true;
            }

        }
        //左
        if (y - 1 > -1 && arr[x][y - 1] == 0) {
            if (dfs(arr, x, y - 1, list)) {
                return true;
            }
        }
        //右
        if (y + 1 < n && arr[x][y + 1] == 0) {
            if (dfs(arr, x, y + 1, list)) {
                return true;
            }
        }

        //撤销选择
        list.remove(list.size() - 1);
        arr[x][y] = 0;
        return false;
    }

    static class State {
        public int x;
        public int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }


    public static void main35(String[] args) {
        //HJ44 Sudoku
        //描述
        //问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，
        // 推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[][] board = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = in.nextInt();
                }
            }

            solveSudoku2(board);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println(board[i][8]);
            }
        }
    }

    private static boolean solveSudoku2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    //从1到9开始尝试
                    if (!isValid(i, j, k, board)) {
                        continue;
                    }
                    //选择
                    board[i][j] = k;
                    if (solveSudoku2(board)) {
                        return true;
                    }
                    //撤销
                    board[i][j] = 0;
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, int k, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }
        //列上是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }
        ///3* 3 宫格是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        if (startRow >= m || startCol >= n) {
            return false;
        }
        int endRow = startRow + 3;
        int endCol = startCol + 3;

        if (endRow >= m || endCol >= n) {
            return false;
        }

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }


    public static boolean solveSudoku(int[][] board) {
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一***定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                if (board[i][j] != 0) { // 跳过原始数字
                    continue;
                }
                for (int k = 1; k <= 9; k++) { // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i, j, k, board)) {
                        board[i][j] = k;//将k放在（i，j）
                        if (solveSudoku(board)) { // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = 0;//回溯
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一***定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    public static boolean isValidSudoku(int row, int col, int val, int[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main36(String[] args) {
        //HJ45 名字的漂亮度
        //描述
        //给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
        //每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
        //
        //给出多个名字，计算每个名字最大可能的“漂亮度”。
        //
        //本题含有多组数据。
        //
        //数据范围：输入的名字长度满足 1 \le n \le 10000 \1≤n≤10000
        //
        //输入描述：
        //整数N，后续N个名字
        //
        //输出描述：
        //每个名称可能的最大漂亮程度
        //
        //示例1
        //输入：
        //2
        //zhangsan
        //lisi
        //复制
        //输出：
        //192
        //101
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                //转小写
                String name = in.nextLine().toLowerCase();
                System.out.println(count(name));
            }
        }
    }

    private static Integer count(String name) {
        char[] chars = new char[26];
        for (char c : name.toCharArray()) {
            chars[c - 'a']++;
        }

        Arrays.sort(chars);

        int res = 0;

        for (int weight = 26, i = 26 - 1; i >= 0; i--) {
            if (chars[i] != 0) {
                res += weight * chars[i];
                weight--;
            }
        }
        return res;
    }


    public static void main37(String[] args) {
        //HJ48 从单向链表中删除指定值的节点
        //描述
        //输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
        //
        //链表的值不能重复。
        //
        //构造过程，例如输入一行数据为:
        //6 2 1 2 3 2 5 1 4 5 7 2 2
        //则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
        //1 2 表示为
        //2->1
        //链表为2->1
        //
        //3 2表示为
        //2->3
        //链表为2->3->1
        //
        //5 1表示为
        //1->5
        //链表为2->3->1->5
        //
        //4 5表示为
        //5->4
        //链表为2->3->1->5->4
        //
        //7 2表示为
        //2->7
        //链表为2->7->3->1->5->4
        //
        //最后的链表的顺序为 2 7 3 1 5 4
        //
        //最后一个参数为2，表示要删掉节点为2的值
        //删除 结点 2
        //
        //则结果为 7 3 1 5 4
        //
        //数据范围：链表长度满足 1 \le n \le 1000 \1≤n≤1000  ，节点中的值满足 0 \le val \le 10000 \0≤val≤10000
        //
        //测试用例保证输入合法
        //
        //
        //输入描述：
        //输入一行，有以下4个部分：
        //1 输入链表结点个数
        //2 输入头结点的值
        //3 按照格式插入各个结点
        //4 输入要删除的结点的值
        //
        //输出描述：
        //输出一行
        //输出删除结点后的序列，每个数后都要加空格
        //
        //示例1
        //输入：
        //5 2 3 2 4 3 5 2 1 4 3
        // 2->3  3->4 2->5 4->1

        //复制
        //输出：
        //2 5 4 1
        //复制
        //说明：
        //形成的链表为2->5->3->4->1
        //删掉节点3，返回的就是2->5->4->1
        //示例2
        //输入：
        //6 2 1 2 3 2 5 1 4 5 7 2 2
        //
        //复制
        //输出：
        //7 3 1 5 4
        //复制
        //说明：
        //如题

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            int n = in.nextInt();
            int val = in.nextInt();
            head = new ListNode(val);
            for (int i = 0; i < n - 1; i++) {
                int front = in.nextInt();
                int behind = in.nextInt();
                insert(front, behind);
            }
            System.out.println(head.toString());
            int del = in.nextInt();
            delete(del);

            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    }

    private static ListNode head;

    private static void insert(int val, int node) {
        ListNode root = head;
        while (root.val != node) {
            root = root.next;
        }
        root.next = new ListNode(val, root.next);
    }

    private static void delete(int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = dummy.next;
    }


    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main38(String[] args) {
        //https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484484&idx=1&sn=74594297022c84952162a68b7f739133&chksm=9bd7fa4caca0735a1364dd13901311ecd6ec4913c8db05a1ff6cae8f069627eebe8d651bbeb1&cur_album_id=1318896187793260544&scene=189#wechat_redirect
        //HJ52 计算字符串的编辑距离
        //描述
        //Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
        //
        //Ex：
        //
        //字符串A: abcdefg
        //
        //字符串B: abcdef
        //
        //通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
        //
        //要求：
        //
        //给定任意两个字符串，写出一个算法计算它们的编辑距离。
        //
        //
        //数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
        //
        //本题含有多组输入数据。
        //
        //
        //输入描述：
        //每组用例一共2行，为输入的两个字符串
        //
        //输出描述：
        //每组用例输出一行，代表字符串的距离
        //
        //示例1
        //输入：
        //abcdefg
        //abcdef
        //复制
        //输出：
        //1
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String source = in.next();
            String target = in.next();
            int m = source.length();
            int n = target.length();
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;

            for (int i = 1; i < m + 1; i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i < n + 1; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (source.charAt(i - 1) == target.charAt(j - 1)) {
                        //字符相等
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //看哪个最小
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));

                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }

    public static void main39(String[] args) {
        //
        //HJ51 输出单向链表中倒数第k个结点
        //本题有多组样例输入。
        //
        //
        //输入描述：
        //输入说明
        //1 输入链表结点个数
        //2 输入链表的值
        //3 输入k的值
        //
        //输出描述：
        //输出一个整数
        //
        //示例1
        //输入：
        //8
        //1 2 3 4 5 6 7 8
        //4
        //复制
        //输出：
        //5

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //构造空节点
            ListNode head = new ListNode();

            for (int i = 0; i < n; i++) {
                //0 -> 1 ->null
                //0->2->1->null
                int val = in.nextInt();
                head.next = new ListNode(val, head.next);
            }
            int k = in.nextInt();
            while (k > 0) {
                head = head.next;
                k--;
            }
            System.out.println(head.val);
        }
    }


    public static void main40(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(longestPalindrome(s));
        }
    }

    public static int longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            String palindrome = palindrome(s, i, i);
            String next = palindrome(s, i, i + 1);
            int length = palindrome.length();
            int nextLength = next.length();
            res = Math.max(res, Math.max(length, nextLength));
        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        while (l >= 0 && r < length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        int begin = l + 1;

        return s.substring(begin, r);
    }

    public static void main41(String[] args) {
        //HJ75 公共子串计算
        //描述
        //给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
        //
        //注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
        //数据范围：字符串长度：1\le s\le 150\1≤s≤150
        //进阶：时间复杂度：O(n^3)\O(n
        //3
        // ) ，空间复杂度：O(n)\O(n)
        //输入描述：
        //输入两个只包含小写字母的字符串
        //
        //输出描述：
        //输出一个整数，代表最大公共子串的长度
        //
        //示例1
        //输入：
        //asdfas
        //werasdfaswer
        //复制
        //输出：
        //6
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.next();
            String s2 = in.next();
            String shortStr = s1.length() > s2.length() ? s2 : s1;
            String longStr = s1.length() > s2.length() ? s1 : s2;
            int n = shortStr.length();
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    System.out.println("j: " + j);
                    String newStr = shortStr.substring(i, j);
                    if (longStr.contains(newStr)) {
                        max = Math.max(max, newStr.length());
                    }
                }
            }
            System.out.println(max);

        }
    }




    public static void main43(String[] args) {
        //描述
        //输入一个正整数，计算它在二进制下的1的个数。
        //注意多组输入输出！！！！！！
        //
        //数据范围： 1 \le n \le 2^{31}-1 \1≤n≤2
        //31
        // −1
        //输入描述：
        //输入一个整数
        //
        //输出描述：
        //计算整数二进制中1的个数
        //
        //示例1
        //输入：
        //5
        //复制
        //输出：
        //2
        //复制
        //说明：
        //5的二进制表示是101，有2个1
        //示例2
        //输入：
        //0
        //复制
        //输出：
        //0
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            String binaryString = Integer.toBinaryString(num);
            System.out.println(binaryString.replaceAll("0", "").length());
        }
    }

    public static void main53(String[] args) {
        //HJ53 杨辉三角的变形
        //描述
        //
        //
        //以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
        //
        //求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
        //
        //数据范围： 1 \le n \le 10^9 \1≤n≤10
        //9
        //
        //
        //输入描述：
        //输入一个int整数
        //
        //输出描述：
        //输出返回的int值
        //
        //示例1
        //输入：
        //4
        //复制
        //输出：
        //3
        //3 2 4 2
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num == 1 || num == 2) {
                System.out.println(-1);
                continue;
            }
            int remain = num % 4;
            if (remain == 1 || remain == 3) {
                System.out.println(2);
            } else if (remain == 2) {
                System.out.println(4);
            } else {
                System.out.println(3);
            }
        }
    }

    public static void main54(String[] args) {
        //HJ54 表达式求值
        //描述
        //给定一个字符串描述的算术表达式，计算出结果值。
        //
        //输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
        //
        //数据范围：运算过程中和最终结果均满足 |val| \le 2^{31}-1 \∣val∣≤2
        //31
        // −1  ，即只进行整型运算，确保输入的表达式合法
        //输入描述：
        //输入算术表达式
        //
        //输出描述：
        //计算出结果值
        //
        //示例1
        //输入：
        //400+5
        //复制
        //输出：
        //405
    }

    public static void main55(String[] args) {
        //HJ55 挑7
        //描述
        //输出 1到n之间 的与 7 有关数字的个数。
        //一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
        //
        //数据范围： 1 \le n \le 30000 \1≤n≤30000
        //输入描述：
        //一个正整数 n 。( n 不大于 30000 )
        //
        //输出描述：
        //一个整数，表示1到n之间的与7有关的数字个数。
        //
        //示例1
        //输入：
        //20
        //复制
        //输出：
        //3
        //复制
        //说明：
        //输入20，1到20之间有关的数字包括7,14,17共3个。
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int count = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 7 == 0) {
                    count++;
                } else {
                    if (String.valueOf(i).contains("7")) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }


    public static void main56(String[] args) {
        //HJ56 完全数计算
        //描述
        //完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
        //
        //它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
        //
        //例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
        //
        //输入n，请输出n以内(含n)完全数的个数。
        //
        //数据范围： 1 \le n \le 5 \times 10^{5} \1≤n≤5×10
        //5
        //
        //输入描述：
        //输入一个数字n
        //
        //输出描述：
        //输出不超过n的完全数的个数
        //
        //示例1
        //输入：
        //1000
        //复制
        //输出：
        //3
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num < 6) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            for (int i = 6; i <= num; i++) {
                int sum = 0;
                for (int j = 1; j <= i / 2; j++) {
                    if (i % j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    public static void main(String[] args) {

    }

    public static void main59(String[] args) {
        //HJ59 找出字符串中第一个只出现一次的字符
        //描述
        //找出字符串中第一个只出现一次的字符
        //
        //
        //数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
        //
        //
        //输入描述：
        //输入一个非空字符串
        //
        //输出描述：
        //输出第一个只出现一次的字符，如果不存在输出-1
        //
        //示例1
        //输入：
        //asdfasdfo
        //
        //复制
        //输出：
        //o
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (Character c : next.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean exist = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                Character key = entry.getKey();
                if (value == 1) {
                    System.out.println(key);
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                System.out.println("-1");
            }
        }
    }


    public static void main102(String[] args) {
        //HJ102 字符统计

        //描述
        //输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
        //数据范围：字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
        //
        //输入描述：
        //一个只包含小写英文字母和数字的字符串。
        //
        //输出描述：
        //一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
        //
        //示例1
        //输入：
        //aaddccdc
        //复制
        //输出：
        //cda
        //复制
        //说明：
        //样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            //字符对应ASCLL码值下标元素自增来统计数量
            int[] charCount = new int[129];
            for (char c : s.toCharArray()) {
                charCount[(int) c]++;
            }
            //更新最大值
            int max = 0;
            for (int count : charCount) {
                if (count > max) {
                    max = count;
                }
            }
            StringBuilder sb = new StringBuilder();
            //从大到小添加到sb
            while (max > 0) {
                for (int i = 0; i < charCount.length; i++) {
                    if (charCount[i] == max) {
                        sb.append((char) i);
                    }
                }
                max--;
            }
            System.out.println(sb.toString());
        }

    }
}

