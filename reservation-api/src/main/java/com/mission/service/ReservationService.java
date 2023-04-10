package com.mission.service;

import com.mission.cafeteria.client.RedisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {
    private final RedisClient redisClient;
}
