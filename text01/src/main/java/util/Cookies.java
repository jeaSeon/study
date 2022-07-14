package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;	//한글일 때 사용!  
import java.net.URLEncoder;


public class Cookies {

		private Map<String,Cookie> cookieMap=new HashMap<String, Cookie>();
		public Cookies(HttpServletRequest request) {
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					cookieMap.put(cookies[i].getName(),cookies[i]);
				//기존에 있는 쿠키값을 리퀘스트를 통해 가져오고, 그걸 맵에 넣는다???
				}
			}
		}
		
		public Cookie getCookie(String name) {
			return cookieMap.get(name);
			
			//이름에 해당하는 쿠키가 있으면 그걸 가져오겠다.
		}
		public String getValue(String name) throws UnsupportedEncodingException {
			Cookie cookie=cookieMap.get(name);
			if(cookie==null) {
				return null;
			}
			return URLDecoder.decode(cookie.getValue(), "utf-8");
		}
		public boolean exists(String name) {
			return cookieMap.get(name)!=null;
		}
		public static Cookie createCookie(String name,String value) throws UnsupportedEncodingException {
			return new Cookie(name,URLEncoder.encode(value, "utf-8"));
		}
		public static Cookie createCookie(String name,String value,String path, int maxAge) throws UnsupportedEncodingException {
			Cookie cookie= new Cookie(name,URLEncoder.encode(value, "utf-8"));
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
			return cookie;
		}
		public static Cookie createCookie(String name,String value,String path, int maxAge,String domain) throws UnsupportedEncodingException {
			Cookie cookie= new Cookie(name,URLEncoder.encode(value, "utf-8"));
			cookie.setDomain(domain);
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
			return cookie;
		}
	}
	
