package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo.dto.common.IdAndNameConvertDTO;
import java.util.List;

public class ConvertConfig {
   private List<IdAndNameConvertDTO> classifyColorRollIds;
   private IdAndNameConvertDTO classifySteelPlateId;

   public static ConvertConfig.ConvertConfigBuilder builder() {
      return new ConvertConfig.ConvertConfigBuilder();
   }

   public List<IdAndNameConvertDTO> getClassifyColorRollIds() {
      return this.classifyColorRollIds;
   }

   public IdAndNameConvertDTO getClassifySteelPlateId() {
      return this.classifySteelPlateId;
   }

   public void setClassifyColorRollIds(final List<IdAndNameConvertDTO> classifyColorRollIds) {
      this.classifyColorRollIds = classifyColorRollIds;
   }

   public void setClassifySteelPlateId(final IdAndNameConvertDTO classifySteelPlateId) {
      this.classifySteelPlateId = classifySteelPlateId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ConvertConfig)) {
         return false;
      } else {
         ConvertConfig other = (ConvertConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$classifyColorRollIds = this.getClassifyColorRollIds();
            Object other$classifyColorRollIds = other.getClassifyColorRollIds();
            if (this$classifyColorRollIds == null ? other$classifyColorRollIds == null : this$classifyColorRollIds.equals(other$classifyColorRollIds)) {
               Object this$classifySteelPlateId = this.getClassifySteelPlateId();
               Object other$classifySteelPlateId = other.getClassifySteelPlateId();
               return this$classifySteelPlateId == null ? other$classifySteelPlateId == null : this$classifySteelPlateId.equals(other$classifySteelPlateId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConvertConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyColorRollIds = this.getClassifyColorRollIds();
      result = result * 59 + ($classifyColorRollIds == null ? 43 : $classifyColorRollIds.hashCode());
      Object $classifySteelPlateId = this.getClassifySteelPlateId();
      return result * 59 + ($classifySteelPlateId == null ? 43 : $classifySteelPlateId.hashCode());
   }

   @Override
   public String toString() {
      return "ConvertConfig(classifyColorRollIds=" + this.getClassifyColorRollIds() + ", classifySteelPlateId=" + this.getClassifySteelPlateId() + ")";
   }

   public ConvertConfig(final List<IdAndNameConvertDTO> classifyColorRollIds, final IdAndNameConvertDTO classifySteelPlateId) {
      this.classifyColorRollIds = classifyColorRollIds;
      this.classifySteelPlateId = classifySteelPlateId;
   }

   public ConvertConfig() {
   }

   public static class ConvertConfigBuilder {
      private List<IdAndNameConvertDTO> classifyColorRollIds;
      private IdAndNameConvertDTO classifySteelPlateId;

      ConvertConfigBuilder() {
      }

      public ConvertConfig.ConvertConfigBuilder classifyColorRollIds(final List<IdAndNameConvertDTO> classifyColorRollIds) {
         this.classifyColorRollIds = classifyColorRollIds;
         return this;
      }

      public ConvertConfig.ConvertConfigBuilder classifySteelPlateId(final IdAndNameConvertDTO classifySteelPlateId) {
         this.classifySteelPlateId = classifySteelPlateId;
         return this;
      }

      public ConvertConfig build() {
         return new ConvertConfig(this.classifyColorRollIds, this.classifySteelPlateId);
      }

      @Override
      public String toString() {
         return "ConvertConfig.ConvertConfigBuilder(classifyColorRollIds="
            + this.classifyColorRollIds
            + ", classifySteelPlateId="
            + this.classifySteelPlateId
            + ")";
      }
   }
}
