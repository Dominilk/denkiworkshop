public class Hexagon {

    /**
     * @param width     width in segments
     * @param height    height in segments
     * @param cellLabels    coordinate info on cells.
     * @return the assembled hexagon flower.
     */
    private static StringBuilder hexagonFlower(int width, int height, boolean cellLabels) {
        final StringBuilder output = new StringBuilder();
        // loops going through all possible graphic places (one hexagon is 4 high & 7 wide)
        for(int y = 0; y < 1 + height * 4; y++) {
            for(int x = 0; x < width * 7 + 2; x++) {
                int horizontal = x / 7; // current hexagon index (horizontal)
                final int centerDistance = Math.abs(width / 2 - horizontal); // distance to center hexagon

                // dirty offset fix determined through playing around
                final int offset = horizontal <= width / 2 ? (x % 7 == 1 ? 1 : 0) : (x % 7 == 0 ? -1 : 0);
                final int bottomOffset = horizontal <= width / 2 ? 0 : (x % 7 == 0 || x % 7 == 1 ? 2 : 0);

                // if these conditions are met we are outside our hexagon group so output is space.
                if(y < offset + centerDistance * 2 || y > bottomOffset + centerDistance * 2 + (height - centerDistance) * 4) {
                    // output.append(centerDistance % 10);
                    output.append(' ');
                    continue;
                }

                /*   _____
                 *  /
                 * /
                 *
                 * top left of hexagon seven long, two are the incline.
                 * if following conditions met, we are at a straight
                 */
                if(x % 7 >= 2) {
                    if(y % 2 == 0) { // account for two lines of inclines
                        // if(y == centerDistance * 2 || y == centerDistance * 2 + 4 || y == centerDistance * 2 + 4 * 2) {
                        if((y - centerDistance * 2) % 4 == 0) {
                            // we are at a straight
                            output.append('_');
                            continue;
                        } else if(cellLabels && (y - centerDistance * 2) % 4 == 2) {
                            // trivial cell label logic from inspiration
                            if((x % 7 == 4)) { // label for row index
                                int row = (y - centerDistance * 2) / 4 + 1;
                                if(horizontal < width / 2) row += centerDistance;

                                output.append(row % 10);

                                continue;
                            } else if((x % 7 == 3)) { // label for column index
                                output.append((horizontal + 1) % 10);

                                continue;
                            } else if((x % 7 == 5)) { // label for diagonal index (reversed)
                                int row = (y - centerDistance * 2) / 4 + 1;
                                if(horizontal > width / 2) row += centerDistance;

                                output.append(row % 10);

                                continue;
                            }

                        }
                    }
                } else {
                    // if(y - 1 - ((x % 7 + 1) % 2) == centerDistance * 2) {
                    // are we at a border? based on upper straight check:
                    if((y - 1 - ((x % 7 + 1) % 2) - centerDistance * 2) % 4 == 0) {
                        output.append('/');
                        continue;
                    } else if((y - 1 - 2 - (x % 7) - centerDistance * 2) % 4 == 0) {
                        output.append('\\');
                        continue;
                    }
                }
                output.append(' ');
            }
            output.append('\n');
        }

        return output;
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(hexagonFlower(5, 5));
        System.out.println(hexagonFlower(3, 3, false));
        System.out.println();
        System.out.println(hexagonFlower(5, 5, false));
        System.out.println();
        System.out.println(hexagonFlower(9, 8, true));
    }

}