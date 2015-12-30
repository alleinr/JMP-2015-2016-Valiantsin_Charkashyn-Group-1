package com.epam.jmp.flyweight.factory;

import java.util.HashMap;

import com.epam.jmp.flyweight.model.CustomFileList;
import com.epam.jmp.flyweight.model.FileList;

public class FileListFactory {
	
	private static final HashMap<String, FileList> addressMap = new HashMap<>();
	
	public static FileList getFileList(String address){
		CustomFileList fileList = (CustomFileList)addressMap.get(address);
		
		if (fileList == null) {
			fileList = new CustomFileList(address);
			addressMap.put(address, fileList);
			System.out.println("Creating fileList: " + address);
		}
		
		return fileList;
	}
}
