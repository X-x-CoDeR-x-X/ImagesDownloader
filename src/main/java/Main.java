import dowloader.ImageDownloader;
import dowloader.WebScraper;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String url = "https://skillbox.ru/";

        String dirPath = "src/main/java/images";

        WebScraper webScraper = new WebScraper(url);
        Set<String> links = webScraper.getImagesLinks();

        ImageDownloader imageDownloader = new ImageDownloader(dirPath);
        for (String link : links) {
            download(imageDownloader,link);
        }
    }

    private static void download(ImageDownloader imageDownloader, String link) {
        try {
            String dwonloadedFilePath = imageDownloader.download(link);
            System.out.println("Downloaded image at " + link + " dowloaded successfully to file " + dwonloadedFilePath);
            } catch (RuntimeException e) {
            System.err.println("Failed to download image at " + link+"to directory"+imageDownloader.getDirPath());
            e.printStackTrace();
        }
    }
}
