package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("单体区域")
public class MonomerAndArea {
   @ApiModelProperty(name = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "区域名称")
   private String areaName;

   public static MonomerAndArea.MonomerAndAreaBuilder builder() {
      return new MonomerAndArea.MonomerAndAreaBuilder();
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerAndArea)) {
         return false;
      }

      MonomerAndArea other = (MonomerAndArea)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$monomerName = this.getMonomerName();
            Object other$monomerName = other.getMonomerName();
            if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
               Object this$areaName = this.getAreaName();
               Object other$areaName = other.getAreaName();
               return this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerAndArea;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      return result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerAndArea(monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ")";
   }

   public MonomerAndArea() {
   }

   public MonomerAndArea(final Long monomerId, final String monomerName, final Long areaId, final String areaName) {
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
   }

   public static class MonomerAndAreaBuilder {
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;

      MonomerAndAreaBuilder() {
      }

      public MonomerAndArea.MonomerAndAreaBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MonomerAndArea.MonomerAndAreaBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MonomerAndArea.MonomerAndAreaBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MonomerAndArea.MonomerAndAreaBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MonomerAndArea build() {
         return new MonomerAndArea(this.monomerId, this.monomerName, this.areaId, this.areaName);
      }

      @Override
      public String toString() {
         return "MonomerAndArea.MonomerAndAreaBuilder(monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ")";
      }
   }
}
