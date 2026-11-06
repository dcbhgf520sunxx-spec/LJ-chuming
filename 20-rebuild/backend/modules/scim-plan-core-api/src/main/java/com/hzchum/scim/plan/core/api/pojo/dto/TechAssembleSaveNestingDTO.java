package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechAssembleSaveNestingDTO对象", description = "开始套料的型材清单DTO")
public class TechAssembleSaveNestingDTO {
   @ApiModelProperty(name = "id", value = "部件id")
   private Long id;
   @ApiModelProperty(name = "id", value = "部件关联表id")
   private Long assembleDetailId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "assembleQuantity", value = "组立数量(构件对应的组立总数量)")
   private Integer assembleQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty("部件配置表id")
   private Long assembleConfigId;
   @ApiModelProperty("构件配置表id")
   private Long structureClassId;
   @ApiModelProperty("构件配置种类名称")
   private String classificationName;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("是否导入NC1文件")
   private Boolean boolHaveNC1;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   private Boolean boolMainAssemble;
   @ApiModelProperty("构件编号")
   private String artifactSerialNumber;
   @ApiModelProperty("构件id")
   private Long artifactId;

   public static TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder builder() {
      return new TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder();
   }

   public TechAssembleSaveNestingDTO() {
   }

   public TechAssembleSaveNestingDTO(
      final Long id,
      final Long assembleDetailId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer assembleQuantity,
      final BigDecimal netWeight,
      final String specPrefix,
      final Long assembleConfigId,
      final Long structureClassId,
      final String classificationName,
      final Integer productionLineTypeEnum,
      final Boolean boolHaveNC1,
      final Boolean boolProcess,
      final Boolean boolMainAssemble,
      final String artifactSerialNumber,
      final Long artifactId
   ) {
      this.id = id;
      this.assembleDetailId = assembleDetailId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.assembleQuantity = assembleQuantity;
      this.netWeight = netWeight;
      this.specPrefix = specPrefix;
      this.assembleConfigId = assembleConfigId;
      this.structureClassId = structureClassId;
      this.classificationName = classificationName;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.boolHaveNC1 = boolHaveNC1;
      this.boolProcess = boolProcess;
      this.boolMainAssemble = boolMainAssemble;
      this.artifactSerialNumber = artifactSerialNumber;
      this.artifactId = artifactId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleDetailId() {
      return this.assembleDetailId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getAssembleQuantity() {
      return this.assembleQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Boolean getBoolHaveNC1() {
      return this.boolHaveNC1;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAssembleDetailId(final Long assembleDetailId) {
      this.assembleDetailId = assembleDetailId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setAssembleQuantity(final Integer assembleQuantity) {
      this.assembleQuantity = assembleQuantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setBoolHaveNC1(final Boolean boolHaveNC1) {
      this.boolHaveNC1 = boolHaveNC1;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
   }

   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleSaveNestingDTO)) {
         return false;
      }

      TechAssembleSaveNestingDTO other = (TechAssembleSaveNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleDetailId = this.getAssembleDetailId();
         Object other$assembleDetailId = other.getAssembleDetailId();
         if (this$assembleDetailId == null ? other$assembleDetailId == null : this$assembleDetailId.equals(other$assembleDetailId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$assembleQuantity = this.getAssembleQuantity();
                        Object other$assembleQuantity = other.getAssembleQuantity();
                        if (this$assembleQuantity == null ? other$assembleQuantity == null : this$assembleQuantity.equals(other$assembleQuantity)) {
                           Object this$assembleConfigId = this.getAssembleConfigId();
                           Object other$assembleConfigId = other.getAssembleConfigId();
                           if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                              Object this$structureClassId = this.getStructureClassId();
                              Object other$structureClassId = other.getStructureClassId();
                              if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                                 Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                 Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                 if (this$productionLineTypeEnum == null
                                    ? other$productionLineTypeEnum == null
                                    : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                    Object this$boolHaveNC1 = this.getBoolHaveNC1();
                                    Object other$boolHaveNC1 = other.getBoolHaveNC1();
                                    if (this$boolHaveNC1 == null ? other$boolHaveNC1 == null : this$boolHaveNC1.equals(other$boolHaveNC1)) {
                                       Object this$boolProcess = this.getBoolProcess();
                                       Object other$boolProcess = other.getBoolProcess();
                                       if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                          Object this$boolMainAssemble = this.getBoolMainAssemble();
                                          Object other$boolMainAssemble = other.getBoolMainAssemble();
                                          if (this$boolMainAssemble == null
                                             ? other$boolMainAssemble == null
                                             : this$boolMainAssemble.equals(other$boolMainAssemble)) {
                                             Object this$artifactId = this.getArtifactId();
                                             Object other$artifactId = other.getArtifactId();
                                             if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$netWeight = this.getNetWeight();
                                                            Object other$netWeight = other.getNetWeight();
                                                            if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                               Object this$specPrefix = this.getSpecPrefix();
                                                               Object other$specPrefix = other.getSpecPrefix();
                                                               if (this$specPrefix == null
                                                                  ? other$specPrefix == null
                                                                  : this$specPrefix.equals(other$specPrefix)) {
                                                                  Object this$classificationName = this.getClassificationName();
                                                                  Object other$classificationName = other.getClassificationName();
                                                                  if (this$classificationName == null
                                                                     ? other$classificationName == null
                                                                     : this$classificationName.equals(other$classificationName)) {
                                                                     Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                                                     Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                                                     return this$artifactSerialNumber == null
                                                                        ? other$artifactSerialNumber == null
                                                                        : this$artifactSerialNumber.equals(other$artifactSerialNumber);
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

   protected boolean canEqual(final Object other) {
      return other instanceof TechAssembleSaveNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleDetailId = this.getAssembleDetailId();
      result = result * 59 + ($assembleDetailId == null ? 43 : $assembleDetailId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assembleQuantity = this.getAssembleQuantity();
      result = result * 59 + ($assembleQuantity == null ? 43 : $assembleQuantity.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $boolHaveNC1 = this.getBoolHaveNC1();
      result = result * 59 + ($boolHaveNC1 == null ? 43 : $boolHaveNC1.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      return result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechAssembleSaveNestingDTO(id="
         + this.getId()
         + ", assembleDetailId="
         + this.getAssembleDetailId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", assembleQuantity="
         + this.getAssembleQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", classificationName="
         + this.getClassificationName()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", boolHaveNC1="
         + this.getBoolHaveNC1()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", artifactId="
         + this.getArtifactId()
         + ")";
   }

   public static class TechAssembleSaveNestingDTOBuilder {
      private Long id;
      private Long assembleDetailId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer assembleQuantity;
      private BigDecimal netWeight;
      private String specPrefix;
      private Long assembleConfigId;
      private Long structureClassId;
      private String classificationName;
      private Integer productionLineTypeEnum;
      private Boolean boolHaveNC1;
      private Boolean boolProcess;
      private Boolean boolMainAssemble;
      private String artifactSerialNumber;
      private Long artifactId;

      TechAssembleSaveNestingDTOBuilder() {
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder assembleDetailId(final Long assembleDetailId) {
         this.assembleDetailId = assembleDetailId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder assembleQuantity(final Integer assembleQuantity) {
         this.assembleQuantity = assembleQuantity;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder boolHaveNC1(final Boolean boolHaveNC1) {
         this.boolHaveNC1 = boolHaveNC1;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      public TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechAssembleSaveNestingDTO build() {
         return new TechAssembleSaveNestingDTO(
            this.id,
            this.assembleDetailId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.assembleQuantity,
            this.netWeight,
            this.specPrefix,
            this.assembleConfigId,
            this.structureClassId,
            this.classificationName,
            this.productionLineTypeEnum,
            this.boolHaveNC1,
            this.boolProcess,
            this.boolMainAssemble,
            this.artifactSerialNumber,
            this.artifactId
         );
      }

      @Override
      public String toString() {
         return "TechAssembleSaveNestingDTO.TechAssembleSaveNestingDTOBuilder(id="
            + this.id
            + ", assembleDetailId="
            + this.assembleDetailId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", assembleQuantity="
            + this.assembleQuantity
            + ", netWeight="
            + this.netWeight
            + ", specPrefix="
            + this.specPrefix
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", structureClassId="
            + this.structureClassId
            + ", classificationName="
            + this.classificationName
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", boolHaveNC1="
            + this.boolHaveNC1
            + ", boolProcess="
            + this.boolProcess
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", artifactId="
            + this.artifactId
            + ")";
      }
   }
}
