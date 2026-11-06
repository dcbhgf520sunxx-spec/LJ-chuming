package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "构件导入中间转换类", description = "构件导入中间转换类 ")
public class ArtifactBoxImportDTO extends ArtifactPartImportCommonDTO {
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁 4网架")
   private Integer buildingType;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 true 排产 false 不排产")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "sendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolPurlineClass", value = "是否檩条")
   private Boolean boolPurlineClass;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否只有一行零件")
   private Boolean boolOnePartLine;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   private String printedCode;
   @ApiModelProperty(name = "assembleImportDtoParamList", value = "部件(单元件)列表")
   private List<InventoryAssembleImportDTO> assembleImportDtoParamList;
   @ApiModelProperty(name = "machinePartImportDtoParamList", value = "零件列表")
   private List<MachinePartImportDtoParam> machinePartImportDtoParamList;
   @ApiModelProperty(name = "standardPartImportDTOParamList", value = "标准件(配套件)列表")
   private List<StandardPartImportDTOParam> standardPartImportDTOParamList;
   @ApiModelProperty(name = "boolSameNumber", value = "书否存在相同编号构件(已存在的构件数量为1)")
   private Boolean boolSameNumber;

   public static ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder builder() {
      return new ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBoxImportDTO)) {
         return false;
      }

      ArtifactBoxImportDTO other = (ArtifactBoxImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$buildingType = this.getBuildingType();
      Object other$buildingType = other.getBuildingType();
      if (this$buildingType == null ? other$buildingType == null : this$buildingType.equals(other$buildingType)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$codingType = this.getCodingType();
               Object other$codingType = other.getCodingType();
               if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                  Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                  Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                  if (this$boolAllPartSendDirectly == null
                     ? other$boolAllPartSendDirectly == null
                     : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                     Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                     Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                     if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                        Object this$boolSendDirectly = this.getBoolSendDirectly();
                        Object other$boolSendDirectly = other.getBoolSendDirectly();
                        if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                           Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                           Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                           if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                              Object this$boolPurlineClass = this.getBoolPurlineClass();
                              Object other$boolPurlineClass = other.getBoolPurlineClass();
                              if (this$boolPurlineClass == null ? other$boolPurlineClass == null : this$boolPurlineClass.equals(other$boolPurlineClass)) {
                                 Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                                 Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                                 if (this$boolSinglePartEnum == null
                                    ? other$boolSinglePartEnum == null
                                    : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                                    Object this$boolOnePartLine = this.getBoolOnePartLine();
                                    Object other$boolOnePartLine = other.getBoolOnePartLine();
                                    if (this$boolOnePartLine == null ? other$boolOnePartLine == null : this$boolOnePartLine.equals(other$boolOnePartLine)) {
                                       Object this$boolSameNumber = this.getBoolSameNumber();
                                       Object other$boolSameNumber = other.getBoolSameNumber();
                                       if (this$boolSameNumber == null ? other$boolSameNumber == null : this$boolSameNumber.equals(other$boolSameNumber)) {
                                          Object this$drawingNumber = this.getDrawingNumber();
                                          Object other$drawingNumber = other.getDrawingNumber();
                                          if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                             Object this$printedCode = this.getPrintedCode();
                                             Object other$printedCode = other.getPrintedCode();
                                             if (this$printedCode == null ? other$printedCode == null : this$printedCode.equals(other$printedCode)) {
                                                Object this$assembleImportDtoParamList = this.getAssembleImportDtoParamList();
                                                Object other$assembleImportDtoParamList = other.getAssembleImportDtoParamList();
                                                if (this$assembleImportDtoParamList == null
                                                   ? other$assembleImportDtoParamList == null
                                                   : this$assembleImportDtoParamList.equals(other$assembleImportDtoParamList)) {
                                                   Object this$machinePartImportDtoParamList = this.getMachinePartImportDtoParamList();
                                                   Object other$machinePartImportDtoParamList = other.getMachinePartImportDtoParamList();
                                                   if (this$machinePartImportDtoParamList == null
                                                      ? other$machinePartImportDtoParamList == null
                                                      : this$machinePartImportDtoParamList.equals(other$machinePartImportDtoParamList)) {
                                                      Object this$standardPartImportDTOParamList = this.getStandardPartImportDTOParamList();
                                                      Object other$standardPartImportDTOParamList = other.getStandardPartImportDTOParamList();
                                                      return this$standardPartImportDTOParamList == null
                                                         ? other$standardPartImportDTOParamList == null
                                                         : this$standardPartImportDTOParamList.equals(other$standardPartImportDTOParamList);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactBoxImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolPurlineClass = this.getBoolPurlineClass();
      result = result * 59 + ($boolPurlineClass == null ? 43 : $boolPurlineClass.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolOnePartLine = this.getBoolOnePartLine();
      result = result * 59 + ($boolOnePartLine == null ? 43 : $boolOnePartLine.hashCode());
      Object $boolSameNumber = this.getBoolSameNumber();
      result = result * 59 + ($boolSameNumber == null ? 43 : $boolSameNumber.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $assembleImportDtoParamList = this.getAssembleImportDtoParamList();
      result = result * 59 + ($assembleImportDtoParamList == null ? 43 : $assembleImportDtoParamList.hashCode());
      Object $machinePartImportDtoParamList = this.getMachinePartImportDtoParamList();
      result = result * 59 + ($machinePartImportDtoParamList == null ? 43 : $machinePartImportDtoParamList.hashCode());
      Object $standardPartImportDTOParamList = this.getStandardPartImportDTOParamList();
      return result * 59 + ($standardPartImportDTOParamList == null ? 43 : $standardPartImportDTOParamList.hashCode());
   }

   public ArtifactBoxImportDTO() {
   }

   public ArtifactBoxImportDTO(
      final String drawingNumber,
      final Integer buildingType,
      final Long structureClassId,
      final Integer artifactType,
      final Integer codingType,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSchedulingEnum,
      final Boolean boolSendDirectly,
      final Boolean boolCoatingEnum,
      final Boolean boolPurlineClass,
      final Boolean boolSinglePartEnum,
      final Boolean boolOnePartLine,
      final String printedCode,
      final List<InventoryAssembleImportDTO> assembleImportDtoParamList,
      final List<MachinePartImportDtoParam> machinePartImportDtoParamList,
      final List<StandardPartImportDTOParam> standardPartImportDTOParamList,
      final Boolean boolSameNumber
   ) {
      this.drawingNumber = drawingNumber;
      this.buildingType = buildingType;
      this.structureClassId = structureClassId;
      this.artifactType = artifactType;
      this.codingType = codingType;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.boolSendDirectly = boolSendDirectly;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolPurlineClass = boolPurlineClass;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolOnePartLine = boolOnePartLine;
      this.printedCode = printedCode;
      this.assembleImportDtoParamList = assembleImportDtoParamList;
      this.machinePartImportDtoParamList = machinePartImportDtoParamList;
      this.standardPartImportDTOParamList = standardPartImportDTOParamList;
      this.boolSameNumber = boolSameNumber;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   @Override
   public Boolean getBoolPurlineClass() {
      return this.boolPurlineClass;
   }

   @Override
   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolOnePartLine() {
      return this.boolOnePartLine;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public List<InventoryAssembleImportDTO> getAssembleImportDtoParamList() {
      return this.assembleImportDtoParamList;
   }

   public List<MachinePartImportDtoParam> getMachinePartImportDtoParamList() {
      return this.machinePartImportDtoParamList;
   }

   public List<StandardPartImportDTOParam> getStandardPartImportDTOParamList() {
      return this.standardPartImportDTOParamList;
   }

   public Boolean getBoolSameNumber() {
      return this.boolSameNumber;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   @Override
   public void setBoolPurlineClass(final Boolean boolPurlineClass) {
      this.boolPurlineClass = boolPurlineClass;
   }

   @Override
   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setBoolOnePartLine(final Boolean boolOnePartLine) {
      this.boolOnePartLine = boolOnePartLine;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   public void setAssembleImportDtoParamList(final List<InventoryAssembleImportDTO> assembleImportDtoParamList) {
      this.assembleImportDtoParamList = assembleImportDtoParamList;
   }

   public void setMachinePartImportDtoParamList(final List<MachinePartImportDtoParam> machinePartImportDtoParamList) {
      this.machinePartImportDtoParamList = machinePartImportDtoParamList;
   }

   public void setStandardPartImportDTOParamList(final List<StandardPartImportDTOParam> standardPartImportDTOParamList) {
      this.standardPartImportDTOParamList = standardPartImportDTOParamList;
   }

   public void setBoolSameNumber(final Boolean boolSameNumber) {
      this.boolSameNumber = boolSameNumber;
   }

   @Override
   public String toString() {
      return "ArtifactBoxImportDTO(drawingNumber="
         + this.getDrawingNumber()
         + ", buildingType="
         + this.getBuildingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", artifactType="
         + this.getArtifactType()
         + ", codingType="
         + this.getCodingType()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolPurlineClass="
         + this.getBoolPurlineClass()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolOnePartLine="
         + this.getBoolOnePartLine()
         + ", printedCode="
         + this.getPrintedCode()
         + ", assembleImportDtoParamList="
         + this.getAssembleImportDtoParamList()
         + ", machinePartImportDtoParamList="
         + this.getMachinePartImportDtoParamList()
         + ", standardPartImportDTOParamList="
         + this.getStandardPartImportDTOParamList()
         + ", boolSameNumber="
         + this.getBoolSameNumber()
         + ")";
   }

   public static class ArtifactBoxImportDTOBuilder {
      private String drawingNumber;
      private Integer buildingType;
      private Long structureClassId;
      private Integer artifactType;
      private Integer codingType;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSchedulingEnum;
      private Boolean boolSendDirectly;
      private Boolean boolCoatingEnum;
      private Boolean boolPurlineClass;
      private Boolean boolSinglePartEnum;
      private Boolean boolOnePartLine;
      private String printedCode;
      private List<InventoryAssembleImportDTO> assembleImportDtoParamList;
      private List<MachinePartImportDtoParam> machinePartImportDtoParamList;
      private List<StandardPartImportDTOParam> standardPartImportDTOParamList;
      private Boolean boolSameNumber;

      ArtifactBoxImportDTOBuilder() {
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder buildingType(final Integer buildingType) {
         this.buildingType = buildingType;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolPurlineClass(final Boolean boolPurlineClass) {
         this.boolPurlineClass = boolPurlineClass;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolOnePartLine(final Boolean boolOnePartLine) {
         this.boolOnePartLine = boolOnePartLine;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder assembleImportDtoParamList(final List<InventoryAssembleImportDTO> assembleImportDtoParamList) {
         this.assembleImportDtoParamList = assembleImportDtoParamList;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder machinePartImportDtoParamList(final List<MachinePartImportDtoParam> machinePartImportDtoParamList) {
         this.machinePartImportDtoParamList = machinePartImportDtoParamList;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder standardPartImportDTOParamList(
         final List<StandardPartImportDTOParam> standardPartImportDTOParamList
      ) {
         this.standardPartImportDTOParamList = standardPartImportDTOParamList;
         return this;
      }

      public ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder boolSameNumber(final Boolean boolSameNumber) {
         this.boolSameNumber = boolSameNumber;
         return this;
      }

      public ArtifactBoxImportDTO build() {
         return new ArtifactBoxImportDTO(
            this.drawingNumber,
            this.buildingType,
            this.structureClassId,
            this.artifactType,
            this.codingType,
            this.boolAllPartSendDirectly,
            this.boolSchedulingEnum,
            this.boolSendDirectly,
            this.boolCoatingEnum,
            this.boolPurlineClass,
            this.boolSinglePartEnum,
            this.boolOnePartLine,
            this.printedCode,
            this.assembleImportDtoParamList,
            this.machinePartImportDtoParamList,
            this.standardPartImportDTOParamList,
            this.boolSameNumber
         );
      }

      @Override
      public String toString() {
         return "ArtifactBoxImportDTO.ArtifactBoxImportDTOBuilder(drawingNumber="
            + this.drawingNumber
            + ", buildingType="
            + this.buildingType
            + ", structureClassId="
            + this.structureClassId
            + ", artifactType="
            + this.artifactType
            + ", codingType="
            + this.codingType
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", boolPurlineClass="
            + this.boolPurlineClass
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolOnePartLine="
            + this.boolOnePartLine
            + ", printedCode="
            + this.printedCode
            + ", assembleImportDtoParamList="
            + this.assembleImportDtoParamList
            + ", machinePartImportDtoParamList="
            + this.machinePartImportDtoParamList
            + ", standardPartImportDTOParamList="
            + this.standardPartImportDTOParamList
            + ", boolSameNumber="
            + this.boolSameNumber
            + ")";
      }
   }
}
