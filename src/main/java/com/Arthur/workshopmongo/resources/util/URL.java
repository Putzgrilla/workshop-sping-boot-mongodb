package com.Arthur.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
public static  String decodeParan(String text) {
	
	try {
		return URLDecoder.decode(text,"UTF-8");
	} catch (UnsupportedEncodingException e) {
		return "";
	}
}
}
