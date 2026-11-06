package com.hzchum.pangu.common.config;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class JacksonCustomizerConfig {
   private static final Logger log = LoggerFactory.getLogger(JacksonCustomizerConfig.class);

   @Bean
   public Converter<String, LocalDateTime> localDateTimeConverter() {
      return new Converter<String, LocalDateTime>() {
         public LocalDateTime convert(String s) {
            return StringUtils.isBlank(s) ? null : Instant.ofEpochMilli(Long.parseLong(s)).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
         }
      };
   }

   @Bean
   public Converter<String, LocalDate> localDateConverter() {
      return new Converter<String, LocalDate>() {
         public LocalDate convert(String s) {
            return StringUtils.isBlank(s) ? null : Instant.ofEpochMilli(Long.parseLong(s)).atZone(ZoneOffset.ofHours(8)).toLocalDate();
         }
      };
   }

   @Bean
   public Converter<String, String> strConverter() {
      return new Converter<String, String>() {
         public String convert(String s) {
            return s.trim();
         }
      };
   }

   @Bean
   public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
      return builder -> {
         builder.serializerByType(LocalDateTime.class, new JacksonCustomizerConfig.LocalDateTimeSerializer());
         builder.deserializerByType(LocalDateTime.class, new JacksonCustomizerConfig.LocalDateTimeDeserializer());
         builder.serializerByType(LocalDate.class, new JacksonCustomizerConfig.LocalDateSerializer());
         builder.deserializerByType(LocalDate.class, new JacksonCustomizerConfig.LocalDateDeserializer());
      };
   }

   public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
      public LocalDate deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
         long timestamp = p.getValueAsLong();
         return timestamp > 0L ? LocalDateTimeUtil.of(timestamp, ZoneOffset.of("+8")).toLocalDate() : null;
      }
   }

   public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
      public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
         if (value != null) {
            long timestamp = LocalDateTimeUtil.toEpochMilli(value);
            gen.writeNumber(timestamp);
         }
      }
   }

   public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
      public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
         long timestamp = p.getValueAsLong();
         return timestamp > 0L ? LocalDateTimeUtil.of(timestamp, ZoneOffset.of("+8")) : null;
      }
   }

   public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
      public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
         if (value != null) {
            long timestamp = LocalDateTimeUtil.toEpochMilli(value);
            gen.writeNumber(timestamp);
         }
      }
   }
}
