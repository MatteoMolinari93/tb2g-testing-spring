package org.springframework.samples.petclinic.sfg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = HearingInterpreterInnerClassTest.TestConfig.class)
public class HearingInterpreterInnerClassTest {
	
	static class TestConfig {
		@Bean
		HearingInterpreter hearingInterpreter() {
			return new HearingInterpreter(new LaurelWordProducer());
		}
	}
	
	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	public void whatIHeard() {
		assertEquals("Laurel", hearingInterpreter.whatIHeard());
	}

}
