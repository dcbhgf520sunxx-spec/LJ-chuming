package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "零件(板材/型材)导入记录DTO", description = "零件(板材/型材)导入记录DTO")
public class InventoryMachinePartDTO extends ArtifactPartCommonDTO {
   @ApiModelProperty(name = "id", value = "id")
   private Long id;
   @ApiModelProperty(name = "thick", value = "厚")
   private String thick;
   @ApiModelProperty(name = "width", value = "宽")
   private String width;
   @ApiModelProperty("零件厚度/规格")
   private String steelSpec;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("零件类型定义Id")
   private Long steelId;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("零件类型  8.钢板")
   private Integer machinePartType;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "钢板类型 1.零件板 2.翼腹板")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   private Integer relationType;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty("零件分类  4 成品型材 8.钢板")
   private Integer productClassificationEnum;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryMachinePartDTO)) {
         return false;
      }

      InventoryMachinePartDTO other = (InventoryMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
         Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
         if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
            Object this$steelId = this.getSteelId();
            Object other$steelId = other.getSteelId();
            if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
               Object this$boolProcess = this.getBoolProcess();
               Object other$boolProcess = other.getBoolProcess();
               if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                  Object this$boolSendDirectly = this.getBoolSendDirectly();
                  Object other$boolSendDirectly = other.getBoolSendDirectly();
                  if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                     Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                     Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                     if (this$boolSinglePartEnum == null ? other$boolSinglePartEnum == null : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                        Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                        Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                        if (this$boolAllPartSendDirectly == null
                           ? other$boolAllPartSendDirectly == null
                           : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                           Object this$machinePartType = this.getMachinePartType();
                           Object other$machinePartType = other.getMachinePartType();
                           if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
                              Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                              Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                              if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)
                                 )
                               {
                                 Object this$relationType = this.getRelationType();
                                 Object other$relationType = other.getRelationType();
                                 if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$productClassificationEnum = this.getProductClassificationEnum();
                                       Object other$productClassificationEnum = other.getProductClassificationEnum();
                                       if (this$productClassificationEnum == null
                                          ? other$productClassificationEnum == null
                                          : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                          Object this$thick = this.getThick();
                                          Object other$thick = other.getThick();
                                          if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$steelSpec = this.getSteelSpec();
                                                Object other$steelSpec = other.getSteelSpec();
                                                return this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec);
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
      return other instanceof InventoryMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public Long getId() {
      return this.id;
   }

   public String getThick() {
      return this.thick;
   }

   public String getWidth() {
      return this.width;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setThick(final String thick) {
      this.thick = thick;
   }

   public void setWidth(final String width) {
      this.width = width;
   }

   public void setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   @Override
   public String toString() {
      return "InventoryMachinePartDTO(id="
         + this.getId()
         + ", thick="
         + this.getThick()
         + ", width="
         + this.getWidth()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", steelId="
         + this.getSteelId()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", relationType="
         + this.getRelationType()
         + ", userId="
         + this.getUserId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ")";
   }
}
