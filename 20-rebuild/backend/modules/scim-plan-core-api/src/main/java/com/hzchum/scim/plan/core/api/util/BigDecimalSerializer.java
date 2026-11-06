package com.hzchum.scim.plan.core.api.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
   public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
      if (value != null && !"".equals(value)) {
         gen.writeString(value.setScale(3, 5) + "");
      } else {
         gen.writeString(value + "");
      }
   }
}
