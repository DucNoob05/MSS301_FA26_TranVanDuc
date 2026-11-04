package com.mss301.watch.service.saga;

// [TODO-6.9: kết quả thực hiện Saga]
public record SagaOutcome(String sagaId, Integer watchId, SagaStatus status) {
}
