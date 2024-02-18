package com.job.tracker.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse<T> {
    private String message;
    private T data;

    public JobResponse(String message) {
        this.message = message;
    }
}
