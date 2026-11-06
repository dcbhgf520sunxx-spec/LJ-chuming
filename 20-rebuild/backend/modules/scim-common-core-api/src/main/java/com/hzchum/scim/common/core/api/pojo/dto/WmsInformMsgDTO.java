package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo._do.WmsInformMsg;
import java.io.Serializable;

public class WmsInformMsgDTO extends WmsInformMsg implements Serializable {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsInformMsgDTO)) {
         return false;
      }

      WmsInformMsgDTO other = (WmsInformMsgDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsInformMsgDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WmsInformMsgDTO()";
   }
}
