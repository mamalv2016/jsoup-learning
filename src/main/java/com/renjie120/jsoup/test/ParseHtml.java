package com.renjie120.jsoup.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.renjie120.jsoup.ParseNewHouseTable;
import com.renjie120.jsoup.dto.ReadFromUrl;

public class ParseHtml {
	final static String url = "http://www.stats.gov.cn/tjsj/zxfb/201503/t20150318_696253.html";
	private List<String> allCity = new ArrayList<String>();
	 

	public static void main(String[] args) throws IOException {
		ReadFromUrl readFromUrl = new ReadFromUrl(url, "d:\\tongji.html");
		String content = readFromUrl.readFromUrl();
 
		Document doc = Jsoup.parse(content);
		Elements allP = doc.select("table.MsoNormalTable");
		int temp = 1;
		for (Element e : allP) {
			if(temp==1){
				ParseNewHouseTable t = new ParseNewHouseTable(e);
				System.out.println(t.getYear());
				System.out.println(t.getMonth());
				System.out.println(t.getAllCity());
				System.out.println(t.getDataes());
			}
			temp++;
		}
	}
}
