package main;

public class Multiplication {
    String res;
    String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";


    public String Encryption(String str, int ke) {
        int  c = 0;
        int []arr=new int[255];
        res="";

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    arr[c] = j;
                    c++;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            arr[i] = (arr[i] * ke) % 53;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (arr[i] == j) {
                    res = res + alphabet.charAt(j);
                }
            }
        }
        return res;
    }

    public String Decryption (String str, int ke) {
        res="";
        int  c = 0;
        int  kd = 0;
        int []arr=new int[str.length()];
        for (int i = 1; i < 53; i++) {
            if ((i == 1) || (i == ke)){}
            else {
                if ((i * ke) % 53 == 1) kd = i;
            }
            if (kd != 0) break;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    arr[c] = j;
                    c++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] * kd) % 53;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (arr[i] == j) {
                    res = res + alphabet.charAt(j);
                }
            }
        }
        return res;
    }

}
