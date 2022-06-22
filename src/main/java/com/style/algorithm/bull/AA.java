package com.style.algorithm.bull;

import java.util.*;

public class AA {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.nextLine();
            //拆分为数组
            String [] array = input.split(",");
            LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
            for(String s: array){
                //记录每个字符出现的数量
                int key = Integer.parseInt(s);
                map.put(key,map.getOrDefault(key,0)+1);
            }
            //更新最大值
            int max = 0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int value = entry.getValue();
                if(value > max){
                    max = value;
                }
            }

            int size = map.size();

            StringBuilder sb = new StringBuilder();
            while(max > 0){
                //搜索符合要求的数值
                for(Map.Entry<Integer,Integer> entry:map.entrySet()){

                    int value = entry.getValue();
                    if(value == max){
                        sb.append(entry.getKey()+",");
                    }

                }
                max --;
            }
            //判断最后一个字符是不是，是则进行去掉
            String res = sb.toString();
            int len = res.length();
            if(res.charAt(len - 1) == ','){
                res = res.substring(0,len -1 );
            }
            System.out.println(res);


        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //创建 升序降序排列set
            TreeSet<Integer> asc = new TreeSet<>((a, b) -> {
                return a - b;
            });
            ;
            TreeSet<Integer> desc = new TreeSet<>((a, b) -> {
                return b - a;
            });
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                asc.add(num);
                desc.add(num);
            }
            int k = in.nextInt();
            //set 转list
            List<Integer> ascList = new ArrayList<>(asc);
            List<Integer> descList = new ArrayList<>(desc);
            List<Integer> newAsc = new ArrayList<>();
            List<Integer> newDesc = new ArrayList<>();
            int res = 0;
            for (int i =0;i< k;i++){
                if(i < ascList.size()){
                    int a = ascList.get(i);
                    newAsc.add(a);
                    res += a;
                }
                if(i < descList.size()){
                    int b = descList.get(i);
                    newDesc.add(b);
                    res +=b;
                }
            }
            boolean repeat = false;
            for (Integer newA:newAsc){
                if(newDesc.contains(newA)){
                    System.out.println(-1);
                    repeat = true;
                    break;
                }
            }

            if(!repeat){
                System.out.println(res);
            }
        }
    }


    public static void main(String[] args) {
        int[] weights = new int[3];
        weights[0] = 3;
        weights[1] = 5;
        weights[2] = 6;
        Map<Integer,String> map = new HashMap<>();
        Map<String,Integer> stringIntegerMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int len = Integer.toBinaryString(weights[i]).length();
            max = Math.max(max,len);
            map.put(weights[i],Integer.toBinaryString(weights[i]));
            stringIntegerMap.put(Integer.toBinaryString(weights[i]),weights[i]);
        }

        for(Map.Entry<Integer,String> entry:map.entrySet()){
            String value = entry.getValue();
            Integer key = entry.getKey();
            int len = value.length();
            StringBuilder sb = new StringBuilder();
            for(int i = len;i < max;i++){
                sb.append("0");
            }
            sb.append(value);
            map.put(key,sb.toString());
        }
        System.out.println(calc("110","101"));

    }
    public static String calc(String s1,String s2){
        int len = s1.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            char c1 = s2.charAt(i);
            if(c == '0' && c1 == '0'){
                sb.append("0");
            }else if(c == '1' && c1 == '1'){
                sb.append("0");
            }else if(c == '1' && c1 == '0'){
                sb.append("1");
            }else if(c == '0' && c1 == '1'){
                sb.append("1");
            }
        }
        String res = sb.toString();
        int index = res.indexOf("1");
        return res.substring(index);
    }


}
