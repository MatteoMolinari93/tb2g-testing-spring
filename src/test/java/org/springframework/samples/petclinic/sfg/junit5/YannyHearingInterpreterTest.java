package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.YannyConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("base-test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BaseConfig.class, YannyConfig.class})
public class YannyHearingInterpreterTest {
	
	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	public void whatIHeard() {
		assertEquals("Yanny", hearingInterpreter.whatIHeard());
	}

}
