import java.util.Scanner;

public class crypto {
    public static String keyWord = "hello";
    //ключ к шифру вводится тут^
    public static String initialWord;//слово для шифровки вводится с консоли.

    public static void main(String[] args) {
        while (true) {
            System.out.println("What do you wnat to do ? 1)Crypting ,2) Decrypring. Enter 1 or 2 or 0 to escape.");
            //ввод 1 или 2 или 0 что бы выполнить операции шифрования или дешифровки. 0 для выхода из цикла
            int choose = new Scanner(System.in).nextInt();
            if (choose == 1) {
                System.out.println("Enter the word for crypting:");
                initialWord = initialWordNormalizer(initialWord);
                //System.out.println("Word for crypting is: " + initialWord);
                System.out.println("Crypted variant is: " + cryptograph());
            } else if (choose == 2) {
                System.out.println("Enter the word for decrypting");
                System.out.println("Decrypted word is:  " + decryptograph());
            } else if (choose == 0) {
                break;
            }
        }
    }

    public static String cryptograph() {
        char[][] matrix = matrixCreate();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initialWord.length(); i++) {
            coder(matrix, sb, i);
        }
        return sb.toString();
    }

    private static void coder(char[][] matrix, StringBuilder sb, int i) {
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (initialWord.charAt(i) == matrix[j][k]) {
                    if (initialWord.charAt(i) != matrix[6][k]) {
                        sb.append(matrix[j + 1][k]);
                    } else {
                        sb.append(matrix[j - 6][k]);
                    }
                }
            }
        }
    }

    public static String keyNormalizer(String keyWord) {
        keyWord = keyNormer();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < keyWord.length(); i++) {
            if (result.indexOf(String.valueOf(keyWord.charAt(i))) == -1) {
                result.append(keyWord.charAt(i));
            }
        }
        return result.toString();
    }

    public static String cryptoWord() {
        StringBuilder matrixPreform = new StringBuilder();
        StringBuilder alphabet = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.append(i);
        }
        for (int i = 1; i < 10; i++) {
            numbers.append(i);
        }
        String codealphabet = keyNormalizer(keyWord) + alphabet + numbers;
        for (int i = 0; i < codealphabet.length(); i++) {
            if (matrixPreform.indexOf(String.valueOf(codealphabet.charAt(i))) == -1) {
                matrixPreform.append(codealphabet.charAt(i));
            }
        }
        return matrixPreform.toString();
    }

    public static char[][] matrixCreate() {
        int columnCount = 5;
        int rowCount = 7;
        char[] inputCharArray = cryptoWord().toCharArray();
        char[][] matrix = new char[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++)
                matrix[i][j] = inputCharArray[columnCount * i + j];
        }
        return matrix;
    }

    public static String decryptograph() {
        String wordToUncrypt = new Scanner(System.in).nextLine();
        char[][] matrix = matrixCreate();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToUncrypt.length(); i++) {
            decoder(wordToUncrypt, matrix, sb, i);
        }
        return sb.toString();
    }

    private static void decoder(String wordToUncrypt, char[][] matrix, StringBuilder sb, int i) {
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (wordToUncrypt.charAt(i) == matrix[j][k]) {
                    if (wordToUncrypt.charAt(i) != matrix[0][k]) {
                        sb.append(matrix[j - 1][k]);
                    } else {
                        sb.append(matrix[j + 6][k]);
                    }
                }
            }
        }
    }

    public static String initialWordNormalizer(String initialWord) {
        initialWord = new Scanner(System.in).nextLine();
        initialWord = initialWord.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initialWord.length(); i++) {
            if (initialWord.charAt(i) != ' ' && initialWord.charAt(i) != '.' && initialWord.charAt(i) != ',') {
                sb.append(initialWord.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String keyNormer() {
        keyWord = keyWord.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyWord.length(); i++) {
            if (keyWord.charAt(i) != ' ' && keyWord.charAt(i) != '.' && keyWord.charAt(i) != ',') {
                sb.append(keyWord.charAt(i));
            }
        }
        return sb.toString();
    }
}