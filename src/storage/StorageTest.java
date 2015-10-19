package storage;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StorageTest {

	@Test
	public void textfiletest() throws IOException {
		Storage storage = new Storage();
		assertEquals("planner.txt", storage.getFileName());
		storage.changeFileName("hello.txt");
		assertEquals("hello.txt", storage.getFileName());
	}

}
