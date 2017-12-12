# JBarcode
条码生成工具，基于Java 8 FX

![barcode1](https://user-images.githubusercontent.com/2569600/33868435-f8cb17aa-df3d-11e7-8ee3-23744cedeb2f.png)

生成的图片将保存在当前目录下的barcodes文件夹中
左侧的列表可以进行切换
![barcode2](https://user-images.githubusercontent.com/2569600/33868436-f8f8f602-df3d-11e7-9ad9-9f1171f100d5.png)

二维码功能没有实现，如果需要可以再进行补充

条码生成的规则配置文件为`barcode-cfg.xml`，目前为`code39`，其他规范可以参照官方文档 -> [GO!](http://barcode4j.sourceforge.net/2.1/barcode-xml.html)

主要依赖：
- [Barcode4J](http://barcode4j.sourceforge.net/)
