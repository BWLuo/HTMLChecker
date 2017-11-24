package html;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class HtmlValidatorTest {

	@Test
	public void test1() throws IOException {
		String result = "<b>\n" + "\t<i>\n" + "\t</i>\n" + "</b>\n";
		HtmlValidator test = new HtmlValidator(HtmlTag.tokenize(ValidatorMain.readCompleteFileOrURL(
				"https://raw.githubusercontent.com/CPEN-221/f17-mp2b-Bowen9822/master/testcases/test1.html?token=AeK3A2VjpcpY7NQiFDvdcA5oDSvUHovcks5aIOFkwA%3D%3D")));
		assertEquals(result, test.validate());

	}

	@Test
	public void test2() {
		HtmlValidator test = new HtmlValidator();
		assertTrue(test.getTags().isEmpty());
	}

	@Test
	public void test3() throws IOException {
		HtmlValidator test = new HtmlValidator(HtmlTag.tokenize(ValidatorMain.readCompleteFileOrURL(
				"https://raw.githubusercontent.com/CPEN-221/f17-mp2b-Bowen9822/master/testcases/test1.html?token=AeK3A2VjpcpY7NQiFDvdcA5oDSvUHovcks5aIOFkwA%3D%3D")));
		test.addTag(new HtmlTag("b"));
		test.removeAll("i");
		test.removeAll("b");
		assertTrue(test.getTags().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		HtmlValidator test = new HtmlValidator(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		HtmlValidator test = new HtmlValidator();
		test.addTag(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test6() {
		HtmlValidator test = new HtmlValidator();
		test.removeAll(null);
	}

	@Test
	public void test7() throws IOException {
		String result = "<!doctype>\n" + "<!-- -->\n" + "<html>\n" + "\t<head>\n" + "\t\t<title>\n" + "\t\t\t<meta>\n"
				+ "\t\t\t<link>\n" + "ERROR unexpected tag: </head>\n" + "ERROR unexpected tag: </head>\n"
				+ "\t\t\t<body>\n" + "\t\t\t\t<p>\n" + "\t\t\t\t\t<a>\n" + "\t\t\t\t\t</a>\n" + "\t\t\t\t</p>\n"
				+ "\t\t\t\t</br>\n" + "\t\t\t\t<p>\n" + "\t\t\t\t\t<img>\n" + "\t\t\t\t</p>\n"
				+ "ERROR unexpected tag: </html>\n" + "ERROR unclosed tag: <body>\n" + "ERROR unclosed tag: <title>\n"
				+ "ERROR unclosed tag: <head>\n" + "ERROR unclosed tag: <html>\n";

		HtmlValidator test = new HtmlValidator(HtmlTag.tokenize(ValidatorMain.readCompleteFileOrURL(
				"https://raw.githubusercontent.com/CPEN-221/f17-mp2b-Bowen9822/master/testcases/test8.html?token=AeK3A31_ZUFkWPoU7fHa71O-KfeJ5V64ks5aIOh4wA%3D%3D")));
		assertEquals(result, test.validate());

	}
}