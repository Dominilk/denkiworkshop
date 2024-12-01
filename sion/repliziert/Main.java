import codedraw.*;

public class Main {
    public static void main(String[] args) {

        double size = (600);
        CodeDraw canvas = new CodeDraw((int) size, (int) size);
        double startX = 0;
        double startY = 0;

        canvas.setAlwaysOnTop(true);
        canvas.setInstantDraw(true);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {

                if (j == i) {
                    canvas.setColor(Palette.STEEL_BLUE);
                } else if (j == i - 1 || j == i + 2) {
                    canvas.setColor(Palette.ORANGE);
                } else if (j == i - 2 || j == i + 1) {
                    canvas.setColor(Palette.DARK_BLUE);
                }
                canvas.fillRectangle(startX, startY, size / 3, size / 3);

                if (j == i) {
                    canvas.setColor(Palette.ORANGE);
                } else if (j == i - 1 || j == i + 2) {
                    canvas.setColor(Palette.DARK_BLUE);
                } else if (j == i - 2 || j == i + 1) {
                    canvas.setColor(Palette.STEEL_BLUE);
                }
                canvas.fillCircle(startX + size / 6, startY + size / 6, size / 6 - size / 200);

                startX += size / 3;
            }
            startX = 0;
            startY += size / 3;
        }
        canvas.show();
    }
}
