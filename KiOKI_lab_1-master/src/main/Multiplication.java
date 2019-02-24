package main;

public class Multiplication {
    static int   kd;
    static int  c;
    String res;
    int []arr=new int[255];
    String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";

    public Multiplication()
    {
        kd=0;
        c=0;

    }

    public String Encryption(String str, int ke) {
        res="";

            for (int i = 1; i <= 53; i++) {
                if ((i == 1) || (i % 2 == 0) || (i == 26) || (i == ke)) continue;
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

    public String Decryption (String str) {
        res="";
        c = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    arr[c] = j;
                    c++;
                }
            }
        }
        for (int i = 0; i < c; i++) {
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
