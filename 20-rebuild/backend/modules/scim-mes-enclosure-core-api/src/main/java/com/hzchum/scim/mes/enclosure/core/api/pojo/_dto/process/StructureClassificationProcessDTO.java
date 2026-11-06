package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("构件类型配置类dto")
public class StructureClassificationProcessDTO {
   @ApiModelProperty("主键ID 构件种类id")
   private Long id;
   @ApiModelProperty("构件类型")
   private String classificationName;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("父类型 1.梁 2.柱(智能线时有父类型)")
   private Integer parentType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("最小长度值(mm)")
   private BigDecimal minLength;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("最大长度值(mm)")
   private BigDecimal maxLength;
   @ApiModelProperty("构件类型 1.普通构件 2.次构件")
   private Integer artifactType;
   @ApiModelProperty("打码方式")
   private Integer codingType;
   @ApiModelProperty("定义代码")
   private String definitionWord;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("构件前缀列表")
   List<com.hzchum.scim.system.core.api.pojo.dto.StructureSpecDTO> specPrefixList;
   @ApiModelProperty("构件编号前缀列表")
   List<com.hzchum.scim.system.core.api.pojo.dto.StructureSerialNumberPrefixDTO> serialNumberPrefixList;
   @ApiModelProperty(name = "productProcessLinkList", notes = "工序详情")
   @JsonProperty("productProcessLinkList")
   @JSONField(name = "productProcessLinkList")
   @JsonInclude(Include.NON_NULL)
   private List<MesEnclosureProductProcessLinkDTO> productProcessLinkList;

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public String getDefinitionWord() {
      return this.definitionWord;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<com.hzchum.scim.system.core.api.pojo.dto.StructureSpecDTO> getSpecPrefixList() {
      return this.specPrefixList;
   }

   public List<com.hzchum.scim.system.core.api.pojo.dto.StructureSerialNumberPrefixDTO> getSerialNumberPrefixList() {
      return this.serialNumberPrefixList;
   }

   public List<MesEnclosureProductProcessLinkDTO> getProductProcessLinkList() {
      return this.productProcessLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setParentType(final Integer parentType) {
      this.parentType = parentType;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setDefinitionWord(final String definitionWord) {
      this.definitionWord = definitionWord;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setSpecPrefixList(final List<com.hzchum.scim.system.core.api.pojo.dto.StructureSpecDTO> specPrefixList) {
      this.specPrefixList = specPrefixList;
   }

   public void setSerialNumberPrefixList(final List<com.hzchum.scim.system.core.api.pojo.dto.StructureSerialNumberPrefixDTO> serialNumberPrefixList) {
      this.serialNumberPrefixList = serialNumberPrefixList;
   }

   @JsonProperty("productProcessLinkList")
   public void setProductProcessLinkList(final List<MesEnclosureProductProcessLinkDTO> productProcessLinkList) {
      this.productProcessLinkList = productProcessLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureClassificationProcessDTO)) {
         return false;
      }

      StructureClassificationProcessDTO other = (StructureClassificationProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$parentType = this.getParentType();
            Object other$parentType = other.getParentType();
            if (this$parentType == null ? other$parentType == null : this$parentType.equals(other$parentType)) {
               Object this$artifactType = this.getArtifactType();
               Object other$artifactType = other.getArtifactType();
               if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                  Object this$codingType = this.getCodingType();
                  Object other$codingType = other.getCodingType();
                  if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$classificationName = this.getClassificationName();
                        Object other$classificationName = other.getClassificationName();
                        if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                           Object this$minLength = this.getMinLength();
                           Object other$minLength = other.getMinLength();
                           if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                              Object this$maxLength = this.getMaxLength();
                              Object other$maxLength = other.getMaxLength();
                              if (this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength)) {
                                 Object this$definitionWord = this.getDefinitionWord();
                                 Object other$definitionWord = other.getDefinitionWord();
                                 if (this$definitionWord == null ? other$definitionWord == null : this$definitionWord.equals(other$definitionWord)) {
                                    Object this$specPrefixList = this.getSpecPrefixList();
                                    Object other$specPrefixList = other.getSpecPrefixList();
                                    if (this$specPrefixList == null ? other$specPrefixList == null : this$specPrefixList.equals(other$specPrefixList)) {
                                       Object this$serialNumberPrefixList = this.getSerialNumberPrefixList();
                                       Object other$serialNumberPrefixList = other.getSerialNumberPrefixList();
                                       if (this$serialNumberPrefixList == null
                                          ? other$serialNumberPrefixList == null
                                          : this$serialNumberPrefixList.equals(other$serialNumberPrefixList)) {
                                          Object this$productProcessLinkList = this.getProductProcessLinkList();
                                          Object other$productProcessLinkList = other.getProductProcessLinkList();
                                          return this$productProcessLinkList == null
                                             ? other$productProcessLinkList == null
                                             : this$productProcessLinkList.equals(other$productProcessLinkList);
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
      return other instanceof StructureClassificationProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $parentType = this.getParentType();
      result = result * 59 + ($parentType == null ? 43 : $parentType.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $definitionWord = this.getDefinitionWord();
      result = result * 59 + ($definitionWord == null ? 43 : $definitionWord.hashCode());
      Object $specPrefixList = this.getSpecPrefixList();
      result = result * 59 + ($specPrefixList == null ? 43 : $specPrefixList.hashCode());
      Object $serialNumberPrefixList = this.getSerialNumberPrefixList();
      result = result * 59 + ($serialNumberPrefixList == null ? 43 : $serialNumberPrefixList.hashCode());
      Object $productProcessLinkList = this.getProductProcessLinkList();
      return result * 59 + ($productProcessLinkList == null ? 43 : $productProcessLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassificationProcessDTO(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", parentType="
         + this.getParentType()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", artifactType="
         + this.getArtifactType()
         + ", codingType="
         + this.getCodingType()
         + ", definitionWord="
         + this.getDefinitionWord()
         + ", sort="
         + this.getSort()
         + ", specPrefixList="
         + this.getSpecPrefixList()
         + ", serialNumberPrefixList="
         + this.getSerialNumberPrefixList()
         + ", productProcessLinkList="
         + this.getProductProcessLinkList()
         + ")";
   }
}
