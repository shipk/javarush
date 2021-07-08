package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        if (imageType == BMP) {
            return new BmpReader();
        } else if (imageType == JPG) {
            return new JpgReader();
        } else if (imageType == PNG) {
            return new PngReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
