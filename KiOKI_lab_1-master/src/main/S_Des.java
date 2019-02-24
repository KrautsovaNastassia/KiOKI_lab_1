package main;


public class S_Des {
    int  k=0;
    int i=0;
    static int c;
    String res = "";
    int []arr = new int[255];
    String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";

    public String Encryption (String str, int k) {
        res="";
        c=0;
        for (i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    arr[c] = j;
                    c++;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            arr[i] = (arr[i] + k) % 53;
        }
        c = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (arr[i] == j) {
                    res = res + alphabet.charAt(j);
                    c++;
                }
            }
        }
        System.out.println("Result line");
        System.out.println(res);
        return res;
    }

    public String Decryption (String str, int k) {
        System.out.println("Deshifrator");
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
            arr[i] = (arr[i] + 53 - k) % 53;
        }
        c = 0;
        System.out.println(str.length());
        System.out.println(arr[254]);
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 53; j++) {
                if (arr[i] == j) {
                    res = res + alphabet.charAt(j);
                    System.out.print(res);
                    c++;
                }
            }
        }
        return res;
    }
}
