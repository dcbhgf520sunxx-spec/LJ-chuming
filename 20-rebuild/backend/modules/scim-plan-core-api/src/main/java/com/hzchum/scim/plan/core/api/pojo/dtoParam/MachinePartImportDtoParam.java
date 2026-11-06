package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "零件(板材/型材)DTO", description = "零件(板材/型材)DTO")
public class MachinePartImportDtoParam extends ArtifactPartImportCommonDTO {
   @ApiModelProperty("零件类型定义Id")
   private Long steelId;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "钢板类型 1.零件板 2.翼腹板 4 成品型材")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   private Integer relationType;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "quantityRatio", value = "部件零件数量比例")
   private Integer quantityRatio;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartImportDtoParam)) {
         return false;
      }

      MachinePartImportDtoParam other = (MachinePartImportDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$steelId = this.getSteelId();
      Object other$steelId = other.getSteelId();
      if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
         Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
         Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
         if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
               Object this$boolSendDirectly = this.getBoolSendDirectly();
               Object other$boolSendDirectly = other.getBoolSendDirectly();
               if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                  Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                  Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                  if (this$boolAllPartSendDirectly == null
                     ? other$boolAllPartSendDirectly == null
                     : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                     Object this$quantityRatio = this.getQuantityRatio();
                     Object other$quantityRatio = other.getQuantityRatio();
                     return this$quantityRatio == null ? other$quantityRatio == null : this$quantityRatio.equals(other$quantityRatio);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartImportDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $quantityRatio = this.getQuantityRatio();
      return result * 59 + ($quantityRatio == null ? 43 : $quantityRatio.hashCode());
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getQuantityRatio() {
      return this.quantityRatio;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setQuantityRatio(final Integer quantityRatio) {
      this.quantityRatio = quantityRatio;
   }

   @Override
   public String toString() {
      return "MachinePartImportDtoParam(steelId="
         + this.getSteelId()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", relationType="
         + this.getRelationType()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", quantityRatio="
         + this.getQuantityRatio()
         + ")";
   }
}
