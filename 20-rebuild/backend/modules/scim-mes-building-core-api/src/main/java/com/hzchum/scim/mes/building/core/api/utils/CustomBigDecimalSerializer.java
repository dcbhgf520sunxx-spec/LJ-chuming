package com.hzchum.scim.mes.building.core.api.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;

public class CustomBigDecimalSerializer extends JsonSerializer<BigDecimal> {
   public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
      if (value != null && !"".equals(value)) {
         gen.writeString(value.setScale(5, 5) + "");
      } else {
         gen.writeString(value + "");
      }
   }
}
