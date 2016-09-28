package com.demo.im.model.core.util;

public class UrlPathMatcher {
public boolean pathMatchesUrl(String url,String resURL){
		
		if(url.equals(resURL)){
			return true;
		}		
		return false;
	}
}
