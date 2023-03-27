package com.weiwei.siemens;
import java.util.ArrayList;


 class Program {
     public static void main(String[] args) {
         String input = "!-U-.-Ni-!-X-:-33-66-100-1-!-a-b-c-1-2-3-:-26-6-.-j-:-37-74-!-d-.-b-:-1-31-34-24-4-37";
         String output = decodeMessage(input);
         System.out.println(output);
     }

     public static String decodeMessage(String input) {
         String[] segments = input.split("[.,:]");
         StringBuilder result = new StringBuilder();
         ArrayList<String> list = new ArrayList<>();

         for (int i = 0;i<segments.length;i++) {

             String segment = segments[i];
             //去除无效字符
             if(segment.startsWith("!")){
                 segments[i] = "";
                 continue;
             }

             for(int j = 0; j < segment.length();j++){
                 if(segment.charAt(j) != '!'){
                 }else{
                     segments[i] = segment.substring(0,j);
                 }
             }
             String segment2 = segments[i];
             //去除空白字符串

             if(!segment2.equals("")){
                 list.add(segment2);
             }



         }
         ArrayList<ArrayList<String>> list2 = new ArrayList<>();


         for (String s : list) {
             String[] segs = s.split("-");
             ArrayList<String> templist = new ArrayList<>();
             for (String seg : segs) {
                 if ("".equals(seg)) {
                 } else {
                     templist.add(seg);
                 }
             }
             list2.add(templist);
         }




        //识别数字字符数组
         for (ArrayList<String> temp : list2) {
             if (Character.isDigit(temp.get(0).charAt(0))) {
                 String numbersString = getStrByNumber(temp);
                 result.append(numbersString);
             } else {
                 for (String s : temp) {

                     result.append(s);
                 }
             }

         }

         return result.toString();
     }

     private static String getStrByNumber(ArrayList<String> s) {

         StringBuilder result = new StringBuilder();

         int count = s.size()/2;

         for (int i = 0; i < count ; i++) {
             Integer a = Integer.parseInt(s.get(2*i));
             Integer b = Integer.parseInt(s.get(2*i+1));

             int c = a+b;
             char character = (char)c;
             result.append(character);
         }

         return result.toString();
     }


 }
