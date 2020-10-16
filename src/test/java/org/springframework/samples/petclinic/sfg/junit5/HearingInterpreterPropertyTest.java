package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@TestPropertySource("classpath:yanny.properties")
@ActiveProfiles("externalized")
@SpringJUnitConfig(HearingInterpreterPropertyTest.TestConfig.class)
class HearingInterpreterPropertyTest {
	
	@Configuration
	@ComponentScan("org.springframework.samples.petclinic.sfg")
	static class TestConfig {
		
	}
	
	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	void whatIHeard() {
		assertEquals("Yanny", hearingInterpreter.whatIHeard());
	}

}
