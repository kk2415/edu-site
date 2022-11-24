package com.onoffmix.yonsei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class YonseiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() throws IOException {
		File originFile = new File("C:\\onoffmix\\yonsei-custom\\file\\test2.txt");
		File newFile = new File("C:\\onoffmix\\yonsei-custom\\file\\user\\test.txt");

		Files.move(originFile.toPath(), newFile.toPath());

//		Path file = Files.createFile(Paths.get("C:\\onoffmix\\yonsei-custom\\file\\test2.txt"));
	}

	@Test
	public void test2() throws IOException {
		String str = "Hello, World!";
		byte[] bytes = str.getBytes();

		Path path = Paths.get("C:\\onoffmix\\yonsei-custom\\file\\sample.txt");
		Files.write(path, bytes);
	}
}
