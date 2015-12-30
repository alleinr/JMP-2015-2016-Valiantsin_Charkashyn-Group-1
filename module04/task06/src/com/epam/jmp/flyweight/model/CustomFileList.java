package com.epam.jmp.flyweight.model;

import java.io.File;
import javax.swing.JList;
import com.epam.jmp.flyweight.guiutility.TextFileFilter;

public class CustomFileList implements FileList {

	private JList<File> files;

	public CustomFileList(String address) {
		File f = new File(address);
        File[] fileList = f.listFiles(new TextFileFilter());
        files = new JList<>(fileList);
	}

	public JList<File> getFiles() {
		return files;
	}

	public void setFiles(JList<File> files) {
		this.files = files;
	}

}
