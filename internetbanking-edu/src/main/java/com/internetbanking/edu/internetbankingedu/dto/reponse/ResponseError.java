package com.internetbanking.edu.internetbankingedu.dto.reponse;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class ResponseError {
	
	public ResponseError() {
		super( );
	}
	
	@NotNull(message="Timestamp cannot be null")
	private LocalDateTime timestamp;
	
	@NotNull(message="Details cannot be null")
    private String details;
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}