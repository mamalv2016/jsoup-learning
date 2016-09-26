package com.renjie120.jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.renjie120.jsoup.dto.DataInfo;

public abstract class ParseTable implements IParseTable {
	protected Element table;
	protected List<String> allCity;
	protected int year;
	protected int month;
	protected List<DataInfo> dataes;
	protected Map<String, DataInfo> maps;

	public ParseTable(Element table) {
		this.table = table;
		dataes = new ArrayList<DataInfo>();
		allCity = new ArrayList<String>();
		maps = new HashMap<String, DataInfo>();
		parseTable();

	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public List<String> getAllCity() {
		return allCity;
	}

	public List<DataInfo> getDataes() {
		return dataes;
	}

	public Map<String, DataInfo> getMaps() {
		return maps;
	}

	private void parseYearAndMonth(String str) {
		Pattern pattern = Pattern.compile("([0-9]+)年([0-9]+)月");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			year = Integer.parseInt(matcher.group(1));
			month = Integer.parseInt(matcher.group(2));
		}
	}

	abstract List<DataInfo> parseCityAndData(Element tr);

	public void parseTable() {
		if (table.tagName().equals("table")) {
			Elements trs = table.select("tr");
			int row = 1;
			String title = trs.get(0).text();
			parseYearAndMonth(title);

			for (Element tr : trs) {
				if (row > 4) {
					dataes.addAll(parseCityAndData(tr));
				}
				row++;
			}
		}
	}

	public void saveToDb() {
		if (dataes != null && dataes.size() > 0) { 
			for (DataInfo data : dataes) {

			}
		}
	}
}
