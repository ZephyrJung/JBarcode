package org.b3log.barcode;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.krysalis.barcode4j.BarcodeException;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.xml.sax.SAXException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Zhang Yu
 * Date: 17年12月11日
 * Email: yu.zhang@7fresh.com
 */
public class BarCodeBuilder {
    public static void buildBarCode(String msg, OutputStream out) {
        DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        try {
            Configuration cfg = builder.build(BarCodeBuilder.class.getResourceAsStream("/barcode/barcode-cfg.xml"));
            BarcodeGenerator gen = BarcodeUtil.getInstance().createBarcodeGenerator(cfg);
            BitmapCanvasProvider provider = new BitmapCanvasProvider(out, "image/x-png", 300, BufferedImage.TYPE_BYTE_GRAY, true, 0);
            gen.generateBarcode(provider, msg);
            provider.finish();
        } catch (SAXException | IOException | ConfigurationException | BarcodeException e) {
            e.printStackTrace();
        }
    }
}
