package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Une classe utilitaire pour l'interopérabilité entre les paramètres JAX-RS
 * et les champs de formulaire html <input type="date">
 */
public class HtmlDate extends java.util.Date {
	private static final String FORMAT = "yyyy-MM-dd";
	private static final SimpleDateFormat format = new SimpleDateFormat(FORMAT);
	
	public HtmlDate() { super(); }
	
	public HtmlDate(String htmlParam) throws ParseException {
		super(format.parse(htmlParam).getTime());
	}
	
	public String getHtmlValue() {
		return format.format(this);
	}
}
