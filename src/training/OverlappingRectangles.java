package training;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class OverlappingRectangles {

    public static boolean overlap(int xLeft, int yTop, int xRight, int yBottom,
                                  int x1Left, int y1Top, int x1Right, int y1Bottom) {
        int temp;
        // invert
        if (xLeft > xRight) {
            temp = xRight;
            xRight = xLeft;
            xLeft = temp;
/*            temp = yTop;
            yTop = yBottom;
            yBottom = temp;*/
        }
        if (x1Left > x1Right) {
            temp = x1Right;
            x1Right = x1Left;
            x1Left = temp;
/*            temp = y1Top;
            y1Top = y1Bottom;
            y1Bottom = temp;*/
        }

        return !(x1Left > xRight|| x1Right < xLeft || y1Top < yBottom || y1Bottom > yTop);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int xLeftTop = sc.nextInt();
            int yLeftTop = sc.nextInt();
            int xRightBottom = sc.nextInt();
            int yRightBottom = sc.nextInt();
            int x1LeftTop = sc.nextInt();
            int y1LeftTop = sc.nextInt();
            int x1RightBottom = sc.nextInt();
            int y1RightBottom = sc.nextInt();

            boolean ret = overlap(xLeftTop, yLeftTop, xRightBottom, yRightBottom,
                x1LeftTop, y1LeftTop, x1RightBottom, y1RightBottom);

            System.out.println(ret ? 1 : 0);
        }
    }

}
