package ca.jonathonho.shelf;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import ca.jonathonho.shelf.controller.SFXController;

@ActiveProfiles("test")
@SpringBootTest()
class ShelfApplicationTests {

	@Autowired
	private SFXController controller;

	@Test
	public void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}
}
