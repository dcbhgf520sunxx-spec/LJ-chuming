package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "部件(单元件)导入记录DTO", description = "部件(单元件)导入记录DTO")
public class InventoryAssembleDTO extends ArtifactPartCommonDTO {
   @ApiModelProperty(name = "booPanel", value = "部件操作记录表Id")
   private Long id;
   @ApiModelProperty(name = "booPanel", value = "是否拼板")
   private Boolean booPanel;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   private Boolean boolMainAssemble;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty("部件配置表id")
   private Long assembleConfigId;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("部件(单元件)类型 16 焊接部件(单元件)")
   private Integer assembleType;
   @ApiModelProperty(name = "userId", value = "导入人id")
   private Long userId;
   @ApiModelProperty(name = "elementMachinePartList", value = "部件(单元件)使用的零件(板材/型材)列表")
   private List<InventoryMachinePartDTO> assembleElementMachinePartList;

   public static InventoryAssembleDTO.InventoryAssembleDTOBuilder builder() {
      return new InventoryAssembleDTO.InventoryAssembleDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryAssembleDTO)) {
         return false;
      }

      InventoryAssembleDTO other = (InventoryAssembleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$booPanel = this.getBooPanel();
         Object other$booPanel = other.getBooPanel();
         if (this$booPanel == null ? other$booPanel == null : this$booPanel.equals(other$booPanel)) {
            Object this$boolMainAssemble = this.getBoolMainAssemble();
            Object other$boolMainAssemble = other.getBoolMainAssemble();
            if (this$boolMainAssemble == null ? other$boolMainAssemble == null : this$boolMainAssemble.equals(other$boolMainAssemble)) {
               Object this$assembleConfigId = this.getAssembleConfigId();
               Object other$assembleConfigId = other.getAssembleConfigId();
               if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
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
                           Object this$assembleType = this.getAssembleType();
                           Object other$assembleType = other.getAssembleType();
                           if (this$assembleType == null ? other$assembleType == null : this$assembleType.equals(other$assembleType)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$drawingNumber = this.getDrawingNumber();
                                 Object other$drawingNumber = other.getDrawingNumber();
                                 if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                    Object this$assembleElementMachinePartList = this.getAssembleElementMachinePartList();
                                    Object other$assembleElementMachinePartList = other.getAssembleElementMachinePartList();
                                    return this$assembleElementMachinePartList == null
                                       ? other$assembleElementMachinePartList == null
                                       : this$assembleElementMachinePartList.equals(other$assembleElementMachinePartList);
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
      return other instanceof InventoryAssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $booPanel = this.getBooPanel();
      result = result * 59 + ($booPanel == null ? 43 : $booPanel.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $assembleType = this.getAssembleType();
      result = result * 59 + ($assembleType == null ? 43 : $assembleType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $assembleElementMachinePartList = this.getAssembleElementMachinePartList();
      return result * 59 + ($assembleElementMachinePartList == null ? 43 : $assembleElementMachinePartList.hashCode());
   }

   public InventoryAssembleDTO() {
   }

   public InventoryAssembleDTO(
      final Long id,
      final Boolean booPanel,
      final Boolean boolMainAssemble,
      final String drawingNumber,
      final Long assembleConfigId,
      final Boolean boolSendDirectly,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Integer assembleType,
      final Long userId,
      final List<InventoryMachinePartDTO> assembleElementMachinePartList
   ) {
      this.id = id;
      this.booPanel = booPanel;
      this.boolMainAssemble = boolMainAssemble;
      this.drawingNumber = drawingNumber;
      this.assembleConfigId = assembleConfigId;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.assembleType = assembleType;
      this.userId = userId;
      this.assembleElementMachinePartList = assembleElementMachinePartList;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBooPanel() {
      return this.booPanel;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
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

   public Integer getAssembleType() {
      return this.assembleType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public List<InventoryMachinePartDTO> getAssembleElementMachinePartList() {
      return this.assembleElementMachinePartList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBooPanel(final Boolean booPanel) {
      this.booPanel = booPanel;
   }

   public void setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
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

   public void setAssembleType(final Integer assembleType) {
      this.assembleType = assembleType;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setAssembleElementMachinePartList(final List<InventoryMachinePartDTO> assembleElementMachinePartList) {
      this.assembleElementMachinePartList = assembleElementMachinePartList;
   }

   @Override
   public String toString() {
      return "InventoryAssembleDTO(id="
         + this.getId()
         + ", booPanel="
         + this.getBooPanel()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", assembleType="
         + this.getAssembleType()
         + ", userId="
         + this.getUserId()
         + ", assembleElementMachinePartList="
         + this.getAssembleElementMachinePartList()
         + ")";
   }

   public static class InventoryAssembleDTOBuilder {
      private Long id;
      private Boolean booPanel;
      private Boolean boolMainAssemble;
      private String drawingNumber;
      private Long assembleConfigId;
      private Boolean boolSendDirectly;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Integer assembleType;
      private Long userId;
      private List<InventoryMachinePartDTO> assembleElementMachinePartList;

      InventoryAssembleDTOBuilder() {
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder booPanel(final Boolean booPanel) {
         this.booPanel = booPanel;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder assembleType(final Integer assembleType) {
         this.assembleType = assembleType;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public InventoryAssembleDTO.InventoryAssembleDTOBuilder assembleElementMachinePartList(final List<InventoryMachinePartDTO> assembleElementMachinePartList) {
         this.assembleElementMachinePartList = assembleElementMachinePartList;
         return this;
      }

      public InventoryAssembleDTO build() {
         return new InventoryAssembleDTO(
            this.id,
            this.booPanel,
            this.boolMainAssemble,
            this.drawingNumber,
            this.assembleConfigId,
            this.boolSendDirectly,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.assembleType,
            this.userId,
            this.assembleElementMachinePartList
         );
      }

      @Override
      public String toString() {
         return "InventoryAssembleDTO.InventoryAssembleDTOBuilder(id="
            + this.id
            + ", booPanel="
            + this.booPanel
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", drawingNumber="
            + this.drawingNumber
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", assembleType="
            + this.assembleType
            + ", userId="
            + this.userId
            + ", assembleElementMachinePartList="
            + this.assembleElementMachinePartList
            + ")";
      }
   }
}
