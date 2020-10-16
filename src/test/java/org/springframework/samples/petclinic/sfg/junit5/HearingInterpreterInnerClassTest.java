package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ActiveProfiles("inner-class")
@SpringJUnitConfig(classes = HearingInterpreterInnerClassTest.TestConfig.class)
public class HearingInterpreterInnerClassTest {
	
	@Profile("inner-class")
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
