package main;

import java.util.Arrays;

public class PassPhrase {

    public String cipherEncryption(String input, String key)
    {
        int tableLength = CalculateTableLength(input.length(), key.length());
        ResultAccumulator encryptionResultAccumulator = new EncryptResultAccumulator(input, tableLength);
        ExchangeColumns(tableLength, key, encryptionResultAccumulator);
        return encryptionResultAccumulator.GetResult();
    }

    public String cipherDecryption(String input, String key)
    {
        int tableLength = CalculateTableLength(input.length(), key.length());
        ResultAccumulator decryptionResultAccumulator = new DecryptResultAccumulator(input, tableLength);
        ExchangeColumns(tableLength, key, decryptionResultAccumulator);
        return decryptionResultAccumulator.GetResult();
    }

    abstract class ResultAccumulator
    {
        protected char[] input;
        protected char[] result;

        public ResultAccumulator(String input, int tableLength)
        {
            this.input = InitializeInputCharTable(input, tableLength);
            this.result = InitializeCharTable(input.length(), tableLength);
        }

        public abstract void Accumulate(int p1, int p2);

        public String GetResult()
        {
            return new String(result);
        }

        private char[] InitializeCharTable(int inputSize, int tableLength)
        {
            char[] result = new char[tableLength];
            for (int i = 0; i < result.length; i++) { result[i] = ' '; }
            return result;
        }

        private char[] InitializeInputCharTable(String input, int tableLength)
        {
            char[] result = Arrays.copyOf(input.toCharArray(), tableLength);;
            for (int i = input.length(); i < result.length; i++) { result[i] = ' '; }
            return result;
        }
    }

    class EncryptResultAccumulator extends ResultAccumulator {

        public EncryptResultAccumulator(String input, int blockSize) {
            super(input, blockSize);
        }

        public void Accumulate(int p1, int p2) {
            this.result[p1] = this.input[p2];
        }
    }

    class DecryptResultAccumulator extends ResultAccumulator {

        public DecryptResultAccumulator(String input, int blockSize) {
            super(input, blockSize);
        }

        public void Accumulate(int p1, int p2) {
            this.result[p2] = this.input[p1];
        }
    }

    private int CalculateTableLength(int inputSize, int rowSize)
    {
        int resultSize = (int)Math.ceil((double)inputSize / rowSize) * rowSize;
        return resultSize;
    }

    private void ExchangeColumns(int tableLength, String key, ResultAccumulator accumulator)
    {
        int[] exchanges = GetExchanges(key);
        for (int i = 0; i < tableLength; i++)
        {
            int row = i / exchanges.length;
            int currentOffset = i % exchanges.length;
            int destinationIndex = row * exchanges.length + exchanges[currentOffset];
            accumulator.Accumulate(i, destinationIndex);
        }
    }

    private int[] GetExchanges(String encryptionKey)
    {
        int[] exchanges = new int[encryptionKey.length()];
        for (int i = 0; i < encryptionKey.length(); i++)
        {
            exchanges[i] = i;
        }
        char[] symbols = encryptionKey.toCharArray();
        return sortByVal(exchanges, symbols);
    }


    static int[] sortByVal(int[] arr, char[] val) {

        for (int i = 0; i < val.length; i++) {
            for (int j = 1; j < (val.length - i); j++) {
                if (val[j - 1] > val[j]) {

                    char temp1 = val[j - 1];
                    val[j - 1] = val[j];
                    val[j] = temp1;

                    int temp2 = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp2;
                }
            }
        }
        return arr;
    }

}
