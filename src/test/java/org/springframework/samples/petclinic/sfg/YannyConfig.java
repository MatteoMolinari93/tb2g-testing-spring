package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YannyConfig {

	@Bean
	HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
		return new HearingInterpreter(wordProducer);
	}
	
}
