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
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_1.txt")));
	}
	
	@Test
	public void test2() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_2.txt")));
	}
	
	@Test
	public void test3() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_3.txt")));
	}
	
	@Test
	public void test4() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_4.txt")));
	}
	
	@Test
	public void test5() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_5.txt")));
	}
	
	@Test
	public void test6() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_6.txt")));
	}
	
	@Test
	public void test7() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_7.txt")));
	}
	
	@Test
	public void test8() throws IOException {
		String result = new String(Files.readAllBytes(Paths.get("testcases/expected_output_8.txt")));
	}

}
