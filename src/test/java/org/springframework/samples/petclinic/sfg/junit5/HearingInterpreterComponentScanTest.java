package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(HearingInterpreterComponentScanTest.TestConfig.class)
class HearingInterpreterComponentScanTest {
	
	@Configuration
	@ComponentScan("org.springframework.samples.petclinic.sfg")
	static class TestConfig {
		
	}
	
	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	void whatIHeard() {
		assertEquals("Laurel", hearingInterpreter.whatIHeard());
	}

}
