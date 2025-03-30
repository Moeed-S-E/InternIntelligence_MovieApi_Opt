package com.movieapp.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class HealthCheck {
	@ApiResponses({
        @ApiResponse(responseCode = "201", description = "Movie created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid movie data provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@GetMapping("/health_check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<String>("Health check successful", HttpStatus.OK);
	}
}
