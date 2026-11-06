package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("型材套料清单")
public class AssembleNestingDTO {
   @ApiModelProperty(name = "id", value = "部件id")
   private Long id;
   @ApiModelProperty(name = "assembleDetailId", value = "部件关联表id")
   private Long assembleDetailId;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "部件数量")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "bool_have_nc1", value = "是否导入NC1文件 ture有 false无")
   private Boolean boolHaveNC1;
   @ApiModelProperty(name = "typesettingAssembleTypeEnum", value = "材料属性 [1 焊接型材, 2 成品型材]")
   private Integer typesettingAssembleTypeEnum;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("部件配置表id")
   private Long assembleConfigId;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   private Boolean boolMainAssemble;
   @ApiModelProperty(name = "artifactTypesettingDTO", value = "构件信息")
   private ArtifactTypesettingDTO artifactTypesettingDTO;

   public Long getId() {
      return this.id;
   }

   public Long getAssembleDetailId() {
      return this.assembleDetailId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Boolean getBoolHaveNC1() {
      return this.boolHaveNC1;
   }

   public Integer getTypesettingAssembleTypeEnum() {
      return this.typesettingAssembleTypeEnum;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
   }

   public ArtifactTypesettingDTO getArtifactTypesettingDTO() {
      return this.artifactTypesettingDTO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAssembleDetailId(final Long assembleDetailId) {
      this.assembleDetailId = assembleDetailId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setBoolHaveNC1(final Boolean boolHaveNC1) {
      this.boolHaveNC1 = boolHaveNC1;
   }

   public void setTypesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
   }

   public void setArtifactTypesettingDTO(final ArtifactTypesettingDTO artifactTypesettingDTO) {
      this.artifactTypesettingDTO = artifactTypesettingDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleNestingDTO)) {
         return false;
      }

      AssembleNestingDTO other = (AssembleNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleDetailId = this.getAssembleDetailId();
         Object other$assembleDetailId = other.getAssembleDetailId();
         if (this$assembleDetailId == null ? other$assembleDetailId == null : this$assembleDetailId.equals(other$assembleDetailId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$boolHaveNC1 = this.getBoolHaveNC1();
               Object other$boolHaveNC1 = other.getBoolHaveNC1();
               if (this$boolHaveNC1 == null ? other$boolHaveNC1 == null : this$boolHaveNC1.equals(other$boolHaveNC1)) {
                  Object this$typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
                  Object other$typesettingAssembleTypeEnum = other.getTypesettingAssembleTypeEnum();
                  if (this$typesettingAssembleTypeEnum == null
                     ? other$typesettingAssembleTypeEnum == null
                     : this$typesettingAssembleTypeEnum.equals(other$typesettingAssembleTypeEnum)) {
                     Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                     Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                     if (this$productionLineTypeEnum == null
                        ? other$productionLineTypeEnum == null
                        : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                        Object this$assembleConfigId = this.getAssembleConfigId();
                        Object other$assembleConfigId = other.getAssembleConfigId();
                        if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                           Object this$boolMainAssemble = this.getBoolMainAssemble();
                           Object other$boolMainAssemble = other.getBoolMainAssemble();
                           if (this$boolMainAssemble == null ? other$boolMainAssemble == null : this$boolMainAssemble.equals(other$boolMainAssemble)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$netWeight = this.getNetWeight();
                                                      Object other$netWeight = other.getNetWeight();
                                                      if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                         Object this$totalNetWeight = this.getTotalNetWeight();
                                                         Object other$totalNetWeight = other.getTotalNetWeight();
                                                         if (this$totalNetWeight == null
                                                            ? other$totalNetWeight == null
                                                            : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                            Object this$artifactTypesettingDTO = this.getArtifactTypesettingDTO();
                                                            Object other$artifactTypesettingDTO = other.getArtifactTypesettingDTO();
                                                            return this$artifactTypesettingDTO == null
                                                               ? other$artifactTypesettingDTO == null
                                                               : this$artifactTypesettingDTO.equals(other$artifactTypesettingDTO);
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
      return other instanceof AssembleNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleDetailId = this.getAssembleDetailId();
      result = result * 59 + ($assembleDetailId == null ? 43 : $assembleDetailId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolHaveNC1 = this.getBoolHaveNC1();
      result = result * 59 + ($boolHaveNC1 == null ? 43 : $boolHaveNC1.hashCode());
      Object $typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
      result = result * 59 + ($typesettingAssembleTypeEnum == null ? 43 : $typesettingAssembleTypeEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $artifactTypesettingDTO = this.getArtifactTypesettingDTO();
      return result * 59 + ($artifactTypesettingDTO == null ? 43 : $artifactTypesettingDTO.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleNestingDTO(id="
         + this.getId()
         + ", assembleDetailId="
         + this.getAssembleDetailId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", remark="
         + this.getRemark()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", boolHaveNC1="
         + this.getBoolHaveNC1()
         + ", typesettingAssembleTypeEnum="
         + this.getTypesettingAssembleTypeEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", artifactTypesettingDTO="
         + this.getArtifactTypesettingDTO()
         + ")";
   }
}
