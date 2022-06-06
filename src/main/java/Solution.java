public class Solution {
    //Поле 4*4
    public static final byte x = 4;
    public static final byte y = 4;
    public static int getResult(String string, String race) {
        //Преобразуем строчку в массив символов, одновременно в том же цикле преобразуем
        // его в двухмерный массив стоимости перемещения в клетку
        char[][] playField = new char[x][y];
        int[][] playFieldNum = new int[x][y];
        int index = 0;
        char[] stringArr = string.toCharArray();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                playField[i][j] = stringArr[index];
                if (race.equals("Human")) {
                    switch (stringArr[index]) {
                        case ('S'):
                            playFieldNum[i][j] = 5;
                            break;
                        case ('W'):
                            playFieldNum[i][j] = 2;
                            break;
                        case ('T'):
                            playFieldNum[i][j] = 3;
                            break;
                        case ('P'):
                            playFieldNum[i][j] = 1;
                            break;
                    }
                }
                if (race.equals("Swamper")) {
                    switch (stringArr[index]) {
                        case ('S'):
                            playFieldNum[i][j] = 2;
                            break;
                        case ('W'):
                            playFieldNum[i][j] = 2;
                            break;
                        case ('T'):
                            playFieldNum[i][j] = 5;
                            break;
                        case ('P'):
                            playFieldNum[i][j] = 2;
                            break;
                    }
                }
                if (race.equals("Woodman")) {
                    switch (stringArr[index]) {
                        case ('S'):
                            playFieldNum[i][j] = 3;
                            break;
                        case ('W'):
                            playFieldNum[i][j] = 3;
                            break;
                        case ('T'):
                            playFieldNum[i][j] = 2;
                            break;
                        case ('P'):
                            playFieldNum[i][j] = 2;
                            break;
                    }
                }
                index++;
            }
        }
        //Алгоритм перебора и накопления суммы минимальных затрат на перемещение
        int[][] rightWayNum = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    rightWayNum[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    rightWayNum[i][j] = playFieldNum[i][j] + rightWayNum[i][j - 1];
                } else if (i != 0 && j == 0) {
                    rightWayNum[i][j] = playFieldNum[i][j] + rightWayNum[i - 1][j];
                } else {
                    if (rightWayNum[i - 1][j] < rightWayNum[i][j - 1]) {
                        rightWayNum[i][j] = playFieldNum[i][j] + rightWayNum[i - 1][j];
                    } else {
                        rightWayNum[i][j] = playFieldNum[i][j] + rightWayNum[i][j - 1];
                    }
                }
            }
        }
        return rightWayNum[x - 1][y - 1];
    }
}
