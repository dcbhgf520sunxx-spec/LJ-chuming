package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("部件列表")
public class TechUnitRecordVO {
   @ApiModelProperty(name = "id", value = "部件Id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "comboId", value = "组合Id")
   @JsonProperty("comboId")
   @JSONField(name = "comboId")
   private long comboId;
   @ApiModelProperty(name = "artifactId", value = "构件审核表Id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   private Long artifactId;
   @ApiModelProperty(name = "name", value = "零件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "newSpecification", value = "新规格")
   @JsonProperty("newSpecification")
   @JSONField(name = "newSpecification")
   private String newSpecification;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "unitQuantity", value = "数量")
   @JsonProperty("unitQuantity")
   @JSONField(name = "unitQuantity")
   private Integer unitQuantity;
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置表id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   private Long assembleConfigId;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   private String specPrefix;
   @ApiModelProperty(name = "techPartRecordVOList", value = "零件列表", notes = "零件列表")
   private List<TechPartRecordVO> techPartRecordVOList;

   public Long getId() {
      return this.id;
   }

   public long getComboId() {
      return this.comboId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getUnitQuantity() {
      return this.unitQuantity;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public List<TechPartRecordVO> getTechPartRecordVOList() {
      return this.techPartRecordVOList;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("comboId")
   public void setComboId(final long comboId) {
      this.comboId = comboId;
   }

   @JsonProperty("artifactId")
   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("newSpecification")
   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("unitQuantity")
   public void setUnitQuantity(final Integer unitQuantity) {
      this.unitQuantity = unitQuantity;
   }

   @JsonProperty("assembleConfigId")
   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   @JsonProperty("specPrefix")
   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setTechPartRecordVOList(final List<TechPartRecordVO> techPartRecordVOList) {
      this.techPartRecordVOList = techPartRecordVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechUnitRecordVO)) {
         return false;
      }

      TechUnitRecordVO other = (TechUnitRecordVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getComboId() != other.getComboId()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$unitQuantity = this.getUnitQuantity();
               Object other$unitQuantity = other.getUnitQuantity();
               if (this$unitQuantity == null ? other$unitQuantity == null : this$unitQuantity.equals(other$unitQuantity)) {
                  Object this$assembleConfigId = this.getAssembleConfigId();
                  Object other$assembleConfigId = other.getAssembleConfigId();
                  if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$newSpecification = this.getNewSpecification();
                              Object other$newSpecification = other.getNewSpecification();
                              if (this$newSpecification == null ? other$newSpecification == null : this$newSpecification.equals(other$newSpecification)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$specPrefix = this.getSpecPrefix();
                                       Object other$specPrefix = other.getSpecPrefix();
                                       if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                          Object this$techPartRecordVOList = this.getTechPartRecordVOList();
                                          Object other$techPartRecordVOList = other.getTechPartRecordVOList();
                                          return this$techPartRecordVOList == null
                                             ? other$techPartRecordVOList == null
                                             : this$techPartRecordVOList.equals(other$techPartRecordVOList);
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
      return other instanceof TechUnitRecordVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $comboId = this.getComboId();
      result = result * 59 + (int)($comboId >>> 32 ^ $comboId);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $unitQuantity = this.getUnitQuantity();
      result = result * 59 + ($unitQuantity == null ? 43 : $unitQuantity.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $techPartRecordVOList = this.getTechPartRecordVOList();
      return result * 59 + ($techPartRecordVOList == null ? 43 : $techPartRecordVOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechUnitRecordVO(id="
         + this.getId()
         + ", comboId="
         + this.getComboId()
         + ", artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", productType="
         + this.getProductType()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", unitQuantity="
         + this.getUnitQuantity()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", techPartRecordVOList="
         + this.getTechPartRecordVOList()
         + ")";
   }
}
