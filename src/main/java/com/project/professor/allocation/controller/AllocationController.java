package com.project.professor.allocation.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;

@RestController
public class AllocationController {

	private final AllocationService allocationService;

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/allocations", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Allocation>> findAll() {

		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/allocations/{allocation_id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Allocation> faindById(@PathVariable(name = "allocation_id") Long id) {

		Allocation allocation = allocationService.findById(id);

		if (allocation != null) {
			return new ResponseEntity<>(allocation, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
