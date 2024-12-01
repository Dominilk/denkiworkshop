public class Project {

    public static void main(String[] args) {
        int size = 800;
        CodeDraw project = new CodeDraw(size, size);

        double startSmallRecatanglesX = size * 0.4375;
        double startSmallRecatanglesY = size / 8;
        double startSmallRecatanglesWidth = size / 8;
        int time = 0;
        TextFormat format = project.getTextFormat();
        format.setBold(true);
        format.setFontSize((int) (size * 0.0625));
        String placeholder = "";

        project.setAlwaysOnTop(true);
        project.setInstantDraw(true);

        project.setColor(Palette.BLACK); //Background
        project.fillSquare(0, 0, size);

        project.setLineWidth(size * 0.0175); //Line
        project.setColor(Palette.LIGHT_CORAL);
        project.drawLine(0, 0, size, size);

        project.setLineWidth(size / 10); //Border
        project.setColor(Palette.STEEL_BLUE);
        project.drawRectangle(0, 0, size, size);

        project.setLineWidth(size / 100);


        for (int i = 0; i < 13; i++) {
            project.setColor(Palette.CADET_BLUE);
            project.drawRectangle(startSmallRecatanglesX, startSmallRecatanglesY, startSmallRecatanglesWidth,
                    startSmallRecatanglesWidth);

            placeholder = "" + time;
            project.setColor(Palette.ALICE_BLUE);
            if (placeholder.length() == 1 && time != 0) { //Nummer != 0 damit die Null nicht als erstes gezeichnet wird
                project.drawText(startSmallRecatanglesX + size * 0.0475, startSmallRecatanglesY +
                        size * 0.0375, placeholder);
                             } else if (time != 0) {
                project.drawText(startSmallRecatanglesX + size * 0.0275, startSmallRecatanglesY +
                        size * 0.0375, placeholder);
            }

            if (0 <= time && time <= 2) { //Position der Rahmen für die Zahlen
                startSmallRecatanglesX += size / 10;
                startSmallRecatanglesY += size / 10;
            } else if (3 <= time && time <= 5) {
                startSmallRecatanglesX -= size / 10;
                startSmallRecatanglesY += size / 10;
            } else if (6 <= time && time <= 8) {
                startSmallRecatanglesX -= size / 10;
                startSmallRecatanglesY -= size / 10;
            } else if (9 <= time && time <= 11) {
                startSmallRecatanglesX += size / 10;
                startSmallRecatanglesY -= size / 10;
            }
            time++;
        }
        project.setColor(Palette.LIGHT_CORAL); //Konzentrische Kreise
        project.setLineWidth(size * 0.0175);
        project.fillCircle(size / 2, size / 2 – size * 0.0125, size / 10);
        project.drawCircle(size / 2, size / 2, size * 0.4);
        project.drawCircle(size / 2, size / 2, size * 0.425);

        project.setColor(Palette.LIGHT_SALMON);
        project.fillTriangle(size / 2 - size * 0.0125, size / 2, size / 2 + size * 0.0125, size / 2,
                size / 2, size / 8); //Großer Zeiger

        project.fillTriangle(size / 2, size / 2 - size * 0.0125, size / 2, size / 2 + size * 0.0125,
                size * 0.6925, size / 2); //Kleiner Zeiger

        project.fillCircle(size / 2, size / 2 – size * 0.0125, size / 20);


        project.show();

    }
}

