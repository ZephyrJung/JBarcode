package org.b3log.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yu
 * Date: 17年12月11日
 * Email: yu.zhang@7fresh.com
 */
public class FileHelper {
    private static String path = System.getProperty("user.dir") + File.separator + "barcodes";

    public static void init() {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static String getImagePath(String name) {
        System.out.println(path + File.separator + name + ".png");
        return path + File.separator + name + ".png";
    }

    public static List<String> getImageNames() {
        File file = new File(path);
        List<String> names = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                names.add(f.getName().substring(0,f.getName().indexOf(".png")));
            }
            return names;
        } else {
            return null;
        }
    }
}
