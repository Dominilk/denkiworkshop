import javax.imageio.ImageIO;

public class AsciiArt {

    private static final char[] ASCII_BRIGHTNESS_CHARACTERS = "@%#*+=-:. ".toCharArray();

    // https://en.wikipedia.org/wiki/ANSI_escape_code#SGR
    private static String ansiColorSequence(int color) {
        return "\033[38;2;%d;%d;%dm".formatted((color >>> 16) & 0xFF, (color >>>  8) & 0xFF, color & 0xFF);
    }

    // https://stackoverflow.com/questions/21205871/java-bufferedimage-get-single-pixel-brightness
    private static float calculateBrightness(int color) {
        // extract each color component
        int red   = (color >>> 16) & 0xFF;
        int green = (color >>>  8) & 0xFF;
        int blue  = color & 0xFF;

        // calc luminance in range 0.0 to 1.0; using SRGB luminance constants
        return (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;
    }

    private static String toAscii(boolean ansiColor, BufferedImage image) {
        final StringBuilder output = new StringBuilder(image.getWidth() * image.getHeight());

        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                final int color = image.getRGB(x, y);
                final float brightness = calculateBrightness(color);

                if(ansiColor) {
                    output.append(ansiColorSequence(color));
                }

                output.append(ASCII_BRIGHTNESS_CHARACTERS[Math.round((ASCII_BRIGHTNESS_CHARACTERS.length - 1) * brightness)]);
            }
            output.append("\n");
        }

        if(ansiColor) output.append("\033[m"); // reset color (optional)

        return output.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toAscii(true, ImageIO.read(new File("path/to/file"))));
    }
}
