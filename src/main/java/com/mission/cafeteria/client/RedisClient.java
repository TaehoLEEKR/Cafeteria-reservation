//package com.mission.cafeteria.client;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mission.cafeteria.exception.ErrorCode;
//import com.mission.cafeteria.exception.PartnerException;
//import com.mission.domain.Redis.Reservation;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class RedisClient {
//    private final RedisTemplate<String,Object> redisTemplate;
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    public <T> T get(Long key,Class<T> classType){
//        return get(key.toString(),classType);
//    }
//
//    private <T> T get(String key,Class<T> classType){
//        String redisValue = (String) redisTemplate.opsForValue().get(key);
//        if(ObjectUtils.isEmpty(redisValue)){
//            return null;
//        }else{
//            try {
//                return mapper.readValue(redisValue,classType);
//            } catch (JsonProcessingException e) {
//                log.error("Parsing error",e);
//                return null;
//            }
//        }
//    }
//
//    public void put(Long key, Reservation reservation){
//        put(key.toString(),reservation);
//    }
//    private void put(String key,Reservation reservation){
//        try {
//            redisTemplate.opsForValue().set(key,mapper.writeValueAsString(reservation));
//        } catch (JsonProcessingException e) {
//            throw new PartnerException(ErrorCode.Booking_FAIL);
//        }
//    }
//}
