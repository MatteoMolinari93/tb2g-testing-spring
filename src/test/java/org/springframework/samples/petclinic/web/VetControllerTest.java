package org.springframework.samples.petclinic.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

@ExtendWith(MockitoExtension.class)
public class VetControllerTest {

	@Mock
    ClinicService clinicService;
	
	@Mock
	Map<String, Object> model;
	
	@InjectMocks
	VetController controller;
	
	List<Vet> vetsList = new ArrayList();
	
	@BeforeEach
	void setUp() {
		Vet vet = new Vet();
		vetsList.add(vet);
		when(clinicService.findVets()).thenReturn(vetsList);
	}

	@Test
	void showVetList() {
		String view = controller.showVetList(model);
		verify(clinicService).findVets();
		verify(model).put(anyString(),  any());
		assertEquals("vets/vetList", view);
	}
	
	@Test
	void showResourcesVetList() {
		Vets vets = controller.showResourcesVetList();
		
		verify(clinicService).findVets();
		assertEquals(1, vets.getVetList().size());
	}

}
