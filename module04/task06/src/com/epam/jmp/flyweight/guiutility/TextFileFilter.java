package com.epam.jmp.flyweight.guiutility;

import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        String name = file.getName().toLowerCase();
        return name.length()<20;
    }
}
