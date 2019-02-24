package main;

import java.util.List;

public class RotatingGrid {
    private char arr[][] = new char[4][4];

    public RotatingGrid() {
        arr[0][0] = arr[0][3] = arr[3][0] = arr[3][3] = '1';
        arr[0][1] = arr[1][3] = arr[2][0] = arr[3][2] = '2';
        arr[0][2] = arr[1][0] = arr[2][3] = arr[3][1] = '3';
        arr[1][1] = arr[1][2] = arr[2][1] = arr[2][2] = '4';
    }

    public String cipherEncryption(String input, List<int[]> holes)
    {
        int block, pos = 0;
        char[] char_input = input.toCharArray();
        char[] str1, res;
        if(char_input.length % 16 != 0) {
            str1 = new char[char_input.length + 16 - char_input.length % 16];
            res = new char[char_input.length + 16 - char_input.length % 16];
            int k = 16 - char_input.length % 16;
            for (int i = 0; i < char_input.length; i++) {
                str1[i] = char_input[i];
            }
            for (int i = char_input.length; i < char_input.length + k; i++) {
                str1[i] = ' ';
            }
        } else {
            str1 = char_input;
            res = new char[char_input.length];
        }
        block = str1.length / 16;
        for (int m = 0; m < block; m++) {
            for (int n = 0; n < 4; n++) {
                arr[holes.get(0)[0]][holes.get(1)[0]] = str1[4 * n + 16 * m];
                arr[holes.get(0)[1]][holes.get(1)[1]] = str1[4 * n + 16 * m + 1];
                arr[holes.get(0)[2]][holes.get(1)[2]] = str1[4 * n + 16 * m + 2];
                arr[holes.get(0)[3]][holes.get(1)[3]] = str1[4 * n + 16 * m + 3];
                swap(arr, 0, 0, 0, 3);
                swap(arr, 3, 0, 3, 3);
                swap(arr, 0, 0, 3, 3);

                swap(arr, 0, 1, 1, 3);
                swap(arr, 3, 2, 2, 0);
                swap(arr, 0, 1, 3, 2);

                swap(arr, 0, 2, 2, 3);
                swap(arr, 3, 1, 1, 0);
                swap(arr, 0, 2, 3, 1);

                swap(arr, 1, 1, 1, 2);
                swap(arr, 2, 1, 2, 2);
                swap(arr, 1, 1, 2, 2);

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("-------------------------------------");
                if (n == 3) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            res[pos] = arr[i][j];
                            pos++;
                        }
                    }
                }
            }
        }
        return new String(res);
    }

    public String cipherDecryption(String input, List<int[]> holes)
    {
        int block, pos = 0, c=0;
        char[] char_input = input.toCharArray();
        char[] str1, str2, res;
        if(char_input.length % 16 != 0) {
            str1 = new char[char_input.length + 16 - char_input.length % 16];
            str2 = new char[char_input.length + 16 - char_input.length % 16];
            res = new char[char_input.length + 16 - char_input.length % 16];
            int k = 16 - char_input.length % 16;
            for (int i = 0; i < char_input.length; i++) {
                str1[i] = char_input[i];
            }
            for (int i = char_input.length; i < char_input.length + k; i++) {
                str1[i] = ' ';
            }
        } else{
            str1 = char_input;
            str2 = new char[char_input.length];
            res = new char[char_input.length];
        }
        block = str1.length / 16;
        for (int m = block - 1; m > -1; m--)
        {
            for (int a = 0; a < 4; a++)
            {
                for (int b = 0; b < 4; b++)
                {
                    arr[a][b] = str1[16 * m + 4 * a + b];
                }
            }
            for (int n = 3; n > -1; n--)
            {
                swap(arr, 0, 0, 0, 3);
                swap(arr, 3, 0, 3, 3);
                swap(arr, 3, 0, 0, 3);

                swap(arr, 0, 1, 1, 3);
                swap(arr, 3, 2, 2, 0);
                swap(arr, 1, 3, 2, 0);

                swap(arr, 0, 2, 2, 3);
                swap(arr, 3, 1, 1, 0);
                swap(arr, 2, 3, 1, 0);

                swap(arr, 1, 1, 1, 2);
                swap(arr, 2, 1, 2, 2);
                swap(arr, 1, 2, 2, 1);

                str2[pos] = arr[holes.get(0)[3]][holes.get(1)[3]];
                pos++;
                str2[pos] = arr[holes.get(0)[2]][holes.get(1)[2]];
                pos++;
                str2[pos] = arr[holes.get(0)[1]][holes.get(1)[1]];
                pos++;
                str2[pos] = arr[holes.get(0)[0]][holes.get(1)[0]];
                pos++;
                arr[holes.get(0)[0]][holes.get(1)[0]] = '0';
                arr[holes.get(0)[1]][holes.get(1)[1]] = '0';
                arr[holes.get(0)[2]][holes.get(1)[2]] = '0';
                arr[holes.get(0)[3]][holes.get(1)[3]] = '0';
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        System.out.print( arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("-------------------------------------");
            }
        }
        for (int i = str1.length - 1 ; i > -1; i--)
        {
            res[c] = str2[i];
            c++;
        }
        return new String(res);
    }


    void swap(char[][] array, int i1, int j1, int i2, int j2) {
        char temp = array[i1][j1];
        array[i1][j1] = array[i2][j2];
        array[i2][j2] = temp;
    }
}
