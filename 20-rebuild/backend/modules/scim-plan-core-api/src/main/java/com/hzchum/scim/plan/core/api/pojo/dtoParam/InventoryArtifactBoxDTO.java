package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "构零件清单审核列表DTO", description = "构零件清单审核列表DTO ")
public class InventoryArtifactBoxDTO extends ArtifactPartCommonDTO {
   @ApiModelProperty("构件操作记录表Id")
   private Long id;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 true 排产 false 不排产")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁")
   private Integer buildingType;
   @ApiModelProperty(name = "是否涂装(Y/N)", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolComposeAssemble", value = "是否组合部件 true 是 false 否")
   private Boolean boolComposeAssemble;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人名称")
   private String userName;
   @ApiModelProperty(name = "topPaintArea", value = "桥顶面油漆(单)面积(mm2)")
   private BigDecimal topPaintArea;
   @ApiModelProperty(name = "innerPaintArea", value = "内表面油漆(单)面积(mm2)")
   private BigDecimal innerPaintArea;
   @ApiModelProperty(name = "outerPaintArea", value = "外表面油漆(单)面积(mm2)")
   private BigDecimal outerPaintArea;
   @ApiModelProperty(name = "uRibPaintArea", value = "U肋油漆(单)面积(mm2)")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   private String printedCode;
   @ApiModelProperty(name = "assembleImportDtoParamList", value = "部件(单元件)列表")
   private List<InventoryAssembleDTO> assembleDTOList;
   @ApiModelProperty(name = "machinePartImportDtoParamList", value = "零件列表")
   private List<InventoryMachinePartDTO> machinePartDTOList;
   @ApiModelProperty(name = "standardPartImportDTOParamList", value = "标准件(配套件)列表")
   private List<InventoryStandardPartDTO> standardPartDTOS;

   public static InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder builder() {
      return new InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryArtifactBoxDTO)) {
         return false;
      }

      InventoryArtifactBoxDTO other = (InventoryArtifactBoxDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
            Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
            if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
               Object this$codingType = this.getCodingType();
               Object other$codingType = other.getCodingType();
               if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                  Object this$structureClassId = this.getStructureClassId();
                  Object other$structureClassId = other.getStructureClassId();
                  if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                     Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                     Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                     if (this$boolSinglePartEnum == null ? other$boolSinglePartEnum == null : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                        Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                        Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                        if (this$boolAllPartSendDirectly == null
                           ? other$boolAllPartSendDirectly == null
                           : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                           Object this$boolSendDirectly = this.getBoolSendDirectly();
                           Object other$boolSendDirectly = other.getBoolSendDirectly();
                           if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                              Object this$buildingType = this.getBuildingType();
                              Object other$buildingType = other.getBuildingType();
                              if (this$buildingType == null ? other$buildingType == null : this$buildingType.equals(other$buildingType)) {
                                 Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                                 Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                                 if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                                    Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                                    Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                                    if (this$boolComposeAssemble == null
                                       ? other$boolComposeAssemble == null
                                       : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$drawingNumber = this.getDrawingNumber();
                                          Object other$drawingNumber = other.getDrawingNumber();
                                          if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                Object this$topPaintArea = this.getTopPaintArea();
                                                Object other$topPaintArea = other.getTopPaintArea();
                                                if (this$topPaintArea == null ? other$topPaintArea == null : this$topPaintArea.equals(other$topPaintArea)) {
                                                   Object this$innerPaintArea = this.getInnerPaintArea();
                                                   Object other$innerPaintArea = other.getInnerPaintArea();
                                                   if (this$innerPaintArea == null
                                                      ? other$innerPaintArea == null
                                                      : this$innerPaintArea.equals(other$innerPaintArea)) {
                                                      Object this$outerPaintArea = this.getOuterPaintArea();
                                                      Object other$outerPaintArea = other.getOuterPaintArea();
                                                      if (this$outerPaintArea == null
                                                         ? other$outerPaintArea == null
                                                         : this$outerPaintArea.equals(other$outerPaintArea)) {
                                                         Object this$uRibPaintArea = this.getURibPaintArea();
                                                         Object other$uRibPaintArea = other.getURibPaintArea();
                                                         if (this$uRibPaintArea == null
                                                            ? other$uRibPaintArea == null
                                                            : this$uRibPaintArea.equals(other$uRibPaintArea)) {
                                                            Object this$printedCode = this.getPrintedCode();
                                                            Object other$printedCode = other.getPrintedCode();
                                                            if (this$printedCode == null
                                                               ? other$printedCode == null
                                                               : this$printedCode.equals(other$printedCode)) {
                                                               Object this$assembleDTOList = this.getAssembleDTOList();
                                                               Object other$assembleDTOList = other.getAssembleDTOList();
                                                               if (this$assembleDTOList == null
                                                                  ? other$assembleDTOList == null
                                                                  : this$assembleDTOList.equals(other$assembleDTOList)) {
                                                                  Object this$machinePartDTOList = this.getMachinePartDTOList();
                                                                  Object other$machinePartDTOList = other.getMachinePartDTOList();
                                                                  if (this$machinePartDTOList == null
                                                                     ? other$machinePartDTOList == null
                                                                     : this$machinePartDTOList.equals(other$machinePartDTOList)) {
                                                                     Object this$standardPartDTOS = this.getStandardPartDTOS();
                                                                     Object other$standardPartDTOS = other.getStandardPartDTOS();
                                                                     return this$standardPartDTOS == null
                                                                        ? other$standardPartDTOS == null
                                                                        : this$standardPartDTOS.equals(other$standardPartDTOS);
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
      return other instanceof InventoryArtifactBoxDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $assembleDTOList = this.getAssembleDTOList();
      result = result * 59 + ($assembleDTOList == null ? 43 : $assembleDTOList.hashCode());
      Object $machinePartDTOList = this.getMachinePartDTOList();
      result = result * 59 + ($machinePartDTOList == null ? 43 : $machinePartDTOList.hashCode());
      Object $standardPartDTOS = this.getStandardPartDTOS();
      return result * 59 + ($standardPartDTOS == null ? 43 : $standardPartDTOS.hashCode());
   }

   public InventoryArtifactBoxDTO() {
   }

   public InventoryArtifactBoxDTO(
      final Long id,
      final Integer artifactType,
      final Boolean boolSchedulingEnum,
      final Integer codingType,
      final Long structureClassId,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSendDirectly,
      final String drawingNumber,
      final Integer buildingType,
      final Boolean boolCoatingEnum,
      final Boolean boolComposeAssemble,
      final Long userId,
      final String userName,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final String printedCode,
      final List<InventoryAssembleDTO> assembleDTOList,
      final List<InventoryMachinePartDTO> machinePartDTOList,
      final List<InventoryStandardPartDTO> standardPartDTOS
   ) {
      this.id = id;
      this.artifactType = artifactType;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.codingType = codingType;
      this.structureClassId = structureClassId;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSendDirectly = boolSendDirectly;
      this.drawingNumber = drawingNumber;
      this.buildingType = buildingType;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolComposeAssemble = boolComposeAssemble;
      this.userId = userId;
      this.userName = userName;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.printedCode = printedCode;
      this.assembleDTOList = assembleDTOList;
      this.machinePartDTOList = machinePartDTOList;
      this.standardPartDTOS = standardPartDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   @Override
   public BigDecimal getTopPaintArea() {
      return this.topPaintArea;
   }

   @Override
   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   @Override
   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   @Override
   public BigDecimal getURibPaintArea() {
      return this.uRibPaintArea;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public List<InventoryAssembleDTO> getAssembleDTOList() {
      return this.assembleDTOList;
   }

   public List<InventoryMachinePartDTO> getMachinePartDTOList() {
      return this.machinePartDTOList;
   }

   public List<InventoryStandardPartDTO> getStandardPartDTOS() {
      return this.standardPartDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public void setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
   }

   @Override
   public void setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
   }

   @Override
   public void setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
   }

   @Override
   public void setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   public void setAssembleDTOList(final List<InventoryAssembleDTO> assembleDTOList) {
      this.assembleDTOList = assembleDTOList;
   }

   public void setMachinePartDTOList(final List<InventoryMachinePartDTO> machinePartDTOList) {
      this.machinePartDTOList = machinePartDTOList;
   }

   public void setStandardPartDTOS(final List<InventoryStandardPartDTO> standardPartDTOS) {
      this.standardPartDTOS = standardPartDTOS;
   }

   @Override
   public String toString() {
      return "InventoryArtifactBoxDTO(id="
         + this.getId()
         + ", artifactType="
         + this.getArtifactType()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", codingType="
         + this.getCodingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", buildingType="
         + this.getBuildingType()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", printedCode="
         + this.getPrintedCode()
         + ", assembleDTOList="
         + this.getAssembleDTOList()
         + ", machinePartDTOList="
         + this.getMachinePartDTOList()
         + ", standardPartDTOS="
         + this.getStandardPartDTOS()
         + ")";
   }

   public static class InventoryArtifactBoxDTOBuilder {
      private Long id;
      private Integer artifactType;
      private Boolean boolSchedulingEnum;
      private Integer codingType;
      private Long structureClassId;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSendDirectly;
      private String drawingNumber;
      private Integer buildingType;
      private Boolean boolCoatingEnum;
      private Boolean boolComposeAssemble;
      private Long userId;
      private String userName;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private String printedCode;
      private List<InventoryAssembleDTO> assembleDTOList;
      private List<InventoryMachinePartDTO> machinePartDTOList;
      private List<InventoryStandardPartDTO> standardPartDTOS;

      InventoryArtifactBoxDTOBuilder() {
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder buildingType(final Integer buildingType) {
         this.buildingType = buildingType;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder assembleDTOList(final List<InventoryAssembleDTO> assembleDTOList) {
         this.assembleDTOList = assembleDTOList;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder machinePartDTOList(final List<InventoryMachinePartDTO> machinePartDTOList) {
         this.machinePartDTOList = machinePartDTOList;
         return this;
      }

      public InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder standardPartDTOS(final List<InventoryStandardPartDTO> standardPartDTOS) {
         this.standardPartDTOS = standardPartDTOS;
         return this;
      }

      public InventoryArtifactBoxDTO build() {
         return new InventoryArtifactBoxDTO(
            this.id,
            this.artifactType,
            this.boolSchedulingEnum,
            this.codingType,
            this.structureClassId,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.boolSendDirectly,
            this.drawingNumber,
            this.buildingType,
            this.boolCoatingEnum,
            this.boolComposeAssemble,
            this.userId,
            this.userName,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.printedCode,
            this.assembleDTOList,
            this.machinePartDTOList,
            this.standardPartDTOS
         );
      }

      @Override
      public String toString() {
         return "InventoryArtifactBoxDTO.InventoryArtifactBoxDTOBuilder(id="
            + this.id
            + ", artifactType="
            + this.artifactType
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", codingType="
            + this.codingType
            + ", structureClassId="
            + this.structureClassId
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", drawingNumber="
            + this.drawingNumber
            + ", buildingType="
            + this.buildingType
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", printedCode="
            + this.printedCode
            + ", assembleDTOList="
            + this.assembleDTOList
            + ", machinePartDTOList="
            + this.machinePartDTOList
            + ", standardPartDTOS="
            + this.standardPartDTOS
            + ")";
      }
   }
}
