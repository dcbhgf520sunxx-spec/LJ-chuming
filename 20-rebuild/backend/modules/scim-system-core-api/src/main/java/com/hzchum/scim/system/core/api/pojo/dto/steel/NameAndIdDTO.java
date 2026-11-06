package com.hzchum.scim.system.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;

public class NameAndIdDTO {
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("类型截面库库id")
   private Long sectionWarehouseConfigId;

   public String getName() {
      return this.name;
   }

   public Long getSectionWarehouseConfigId() {
      return this.sectionWarehouseConfigId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSectionWarehouseConfigId(final Long sectionWarehouseConfigId) {
      this.sectionWarehouseConfigId = sectionWarehouseConfigId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof NameAndIdDTO)) {
         return false;
      } else {
         NameAndIdDTO other = (NameAndIdDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$sectionWarehouseConfigId = this.getSectionWarehouseConfigId();
            Object other$sectionWarehouseConfigId = other.getSectionWarehouseConfigId();
            if (this$sectionWarehouseConfigId == null
               ? other$sectionWarehouseConfigId == null
               : this$sectionWarehouseConfigId.equals(other$sectionWarehouseConfigId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NameAndIdDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sectionWarehouseConfigId = this.getSectionWarehouseConfigId();
      result = result * 59 + ($sectionWarehouseConfigId == null ? 43 : $sectionWarehouseConfigId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "NameAndIdDTO(name=" + this.getName() + ", sectionWarehouseConfigId=" + this.getSectionWarehouseConfigId() + ")";
   }
}
