/**
Integer -> Roman

### 3100 을 바꾸는 경우

몇자리수인지 구한다.

4자리 : M

3 자리 
-> 500 ~ 800 : D / 900 : XC
-> 100 ~ 300 : C / 400 : CD

2 자리
-> 50 ~ 80 : L / 90 : XC
-> 10 ~ 30 : X / 40 : XL

1 자리
-> 5 ~ 8 : V / 9 : IX
-> 1 ~ 3 : I / 4 : IV

 */

class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder("");

        while(num > 0) {
            num = convert(sb, num);
        }

        return sb.toString();
    }

    public int convert(StringBuilder sb, int num) {
            // 자릿수를 알아낸다.
            if(num / 1000 >= 1) {
                int qt = num / 1000;
                num = num % 1000;

                for(int i=0; i<qt; i++) sb.append("M");

                return num;
            }

            if(num / 100 >= 1) {
                int qt = num / 100;
                if(qt == 9) { // 900
                    sb.append("CM");
                    return num - 900;
                }

                if(qt == 4) { // 400
                    sb.append("CD");
                    return num - 400;
                }

                if(qt >= 5) { // 500
                    sb.append("D");
                    qt -= 5;
                    num -= 500;
                }

                for(int i=0; i<qt; i++) { // 100
                    sb.append("C");
                    num -= 100;
                }

                return num;
            }

            if(num / 10 >= 1) {
                int qt = num / 10;
                if(qt == 9) { // 90
                    sb.append("XC");
                    return num - 90;
                }

                if(qt == 4) { // 40
                    sb.append("XL");
                    return num - 40;
                }

                if(qt >= 5) { // 50
                    sb.append("L");
                    qt -= 5;
                    num -= 50;
                }

                for(int i=0; i<qt; i++) { // 10
                    sb.append("X");
                    num -= 10;
                }

                return num;
            }


            int qt = num / 1;
            if(qt == 9) { // 9
                sb.append("IX");
                return num - 9;
            }

            if(qt == 4) { // 4
                sb.append("IV");
                return num - 4;
            }

            if(qt >= 5) { // 5
                sb.append("V");
                qt -= 5;
                num -= 5;
            }

            for(int i=0; i<qt; i++) { // 1
                sb.append("I");
                num -= 1;
            }

            return num;
    }
}