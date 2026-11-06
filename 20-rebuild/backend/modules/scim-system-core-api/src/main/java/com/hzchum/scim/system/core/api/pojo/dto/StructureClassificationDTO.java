package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("构件类型配置类dto")
public class StructureClassificationDTO {
   @ApiModelProperty("主键ID 构件种类id")
   private Long id;
   @ApiModelProperty("构件类型")
   private String classificationName;
   @ApiModelProperty("构件类型（新）")
   private String newClassificationName;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("父类型 1.梁 2.柱(智能线时有父类型)")
   private Integer parentType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("父类型 1.梁 2.柱(智能线时有父类型)（新）")
   private Integer newParentType;
   @ApiModelProperty("构件类型 1.普通构件 2.次构件")
   private Integer artifactType;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 ")
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类（新） ")
   private Integer newSmallArtifactClassEnum;
   @ApiModelProperty("打码方式")
   private Integer codingType;
   @ApiModelProperty("打码方式（新）")
   private Integer newCodingType;
   @ApiModelProperty("定义代码")
   private String definitionWord;
   @ApiModelProperty("定义代码（新）")
   private String newDefinitionWord;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("排序（新）")
   private Integer newSort;
   @ApiModelProperty("最新变更记录id")
   private Long lastChangeId;
   @ApiModelProperty("构件前缀列表")
   List<StructureSpecDTO> specPrefixList;
   @ApiModelProperty("构件前缀列表（新）")
   List<StructureSpecDTO> newSpecPrefixList;
   @ApiModelProperty("构件编号前缀列表")
   List<StructureSerialNumberPrefixDTO> serialNumberPrefixList;
   @ApiModelProperty("构件编号前缀列表（新）")
   List<StructureSerialNumberPrefixDTO> newSerialNumberPrefixList;
   @ApiModelProperty("审核状态 1审核中 2同意 3拒绝")
   private Integer auditStatus;
   @ApiModelProperty("构件清单数量")
   private Integer artifactQuantity;
   @ApiModelProperty("已关联涂装工艺的构件清单数量")
   private Integer associatedPaintingArtifactQuantity;
   @ApiModelProperty("审核人名称")
   private String auditName;
   @ApiModelProperty(name = "auditTime", value = "审批时间", notes = "审批时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("mes分类 1建钢构件 2桥梁构件")
   private Integer mesProductEnum;
   @ApiModelProperty("PL构件是否组合部件")
   private Boolean boolComposeAssemble;

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public String getNewClassificationName() {
      return this.newClassificationName;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public Integer getNewParentType() {
      return this.newParentType;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getNewSmallArtifactClassEnum() {
      return this.newSmallArtifactClassEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Integer getNewCodingType() {
      return this.newCodingType;
   }

   public String getDefinitionWord() {
      return this.definitionWord;
   }

   public String getNewDefinitionWord() {
      return this.newDefinitionWord;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getNewSort() {
      return this.newSort;
   }

   public Long getLastChangeId() {
      return this.lastChangeId;
   }

   public List<StructureSpecDTO> getSpecPrefixList() {
      return this.specPrefixList;
   }

   public List<StructureSpecDTO> getNewSpecPrefixList() {
      return this.newSpecPrefixList;
   }

   public List<StructureSerialNumberPrefixDTO> getSerialNumberPrefixList() {
      return this.serialNumberPrefixList;
   }

   public List<StructureSerialNumberPrefixDTO> getNewSerialNumberPrefixList() {
      return this.newSerialNumberPrefixList;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public Integer getAssociatedPaintingArtifactQuantity() {
      return this.associatedPaintingArtifactQuantity;
   }

   public String getAuditName() {
      return this.auditName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setNewClassificationName(final String newClassificationName) {
      this.newClassificationName = newClassificationName;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setParentType(final Integer parentType) {
      this.parentType = parentType;
   }

   public void setNewParentType(final Integer newParentType) {
      this.newParentType = newParentType;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   public void setNewSmallArtifactClassEnum(final Integer newSmallArtifactClassEnum) {
      this.newSmallArtifactClassEnum = newSmallArtifactClassEnum;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setNewCodingType(final Integer newCodingType) {
      this.newCodingType = newCodingType;
   }

   public void setDefinitionWord(final String definitionWord) {
      this.definitionWord = definitionWord;
   }

   public void setNewDefinitionWord(final String newDefinitionWord) {
      this.newDefinitionWord = newDefinitionWord;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setNewSort(final Integer newSort) {
      this.newSort = newSort;
   }

   public void setLastChangeId(final Long lastChangeId) {
      this.lastChangeId = lastChangeId;
   }

   public void setSpecPrefixList(final List<StructureSpecDTO> specPrefixList) {
      this.specPrefixList = specPrefixList;
   }

   public void setNewSpecPrefixList(final List<StructureSpecDTO> newSpecPrefixList) {
      this.newSpecPrefixList = newSpecPrefixList;
   }

   public void setSerialNumberPrefixList(final List<StructureSerialNumberPrefixDTO> serialNumberPrefixList) {
      this.serialNumberPrefixList = serialNumberPrefixList;
   }

   public void setNewSerialNumberPrefixList(final List<StructureSerialNumberPrefixDTO> newSerialNumberPrefixList) {
      this.newSerialNumberPrefixList = newSerialNumberPrefixList;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setAssociatedPaintingArtifactQuantity(final Integer associatedPaintingArtifactQuantity) {
      this.associatedPaintingArtifactQuantity = associatedPaintingArtifactQuantity;
   }

   public void setAuditName(final String auditName) {
      this.auditName = auditName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureClassificationDTO)) {
         return false;
      }

      StructureClassificationDTO other = (StructureClassificationDTO)o;
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
               Object this$newParentType = this.getNewParentType();
               Object other$newParentType = other.getNewParentType();
               if (this$newParentType == null ? other$newParentType == null : this$newParentType.equals(other$newParentType)) {
                  Object this$artifactType = this.getArtifactType();
                  Object other$artifactType = other.getArtifactType();
                  if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                     Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
                     Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
                     if (this$smallArtifactClassEnum == null
                        ? other$smallArtifactClassEnum == null
                        : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
                        Object this$newSmallArtifactClassEnum = this.getNewSmallArtifactClassEnum();
                        Object other$newSmallArtifactClassEnum = other.getNewSmallArtifactClassEnum();
                        if (this$newSmallArtifactClassEnum == null
                           ? other$newSmallArtifactClassEnum == null
                           : this$newSmallArtifactClassEnum.equals(other$newSmallArtifactClassEnum)) {
                           Object this$codingType = this.getCodingType();
                           Object other$codingType = other.getCodingType();
                           if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                              Object this$newCodingType = this.getNewCodingType();
                              Object other$newCodingType = other.getNewCodingType();
                              if (this$newCodingType == null ? other$newCodingType == null : this$newCodingType.equals(other$newCodingType)) {
                                 Object this$sort = this.getSort();
                                 Object other$sort = other.getSort();
                                 if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                    Object this$newSort = this.getNewSort();
                                    Object other$newSort = other.getNewSort();
                                    if (this$newSort == null ? other$newSort == null : this$newSort.equals(other$newSort)) {
                                       Object this$lastChangeId = this.getLastChangeId();
                                       Object other$lastChangeId = other.getLastChangeId();
                                       if (this$lastChangeId == null ? other$lastChangeId == null : this$lastChangeId.equals(other$lastChangeId)) {
                                          Object this$auditStatus = this.getAuditStatus();
                                          Object other$auditStatus = other.getAuditStatus();
                                          if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                             Object this$artifactQuantity = this.getArtifactQuantity();
                                             Object other$artifactQuantity = other.getArtifactQuantity();
                                             if (this$artifactQuantity == null
                                                ? other$artifactQuantity == null
                                                : this$artifactQuantity.equals(other$artifactQuantity)) {
                                                Object this$associatedPaintingArtifactQuantity = this.getAssociatedPaintingArtifactQuantity();
                                                Object other$associatedPaintingArtifactQuantity = other.getAssociatedPaintingArtifactQuantity();
                                                if (this$associatedPaintingArtifactQuantity == null
                                                   ? other$associatedPaintingArtifactQuantity == null
                                                   : this$associatedPaintingArtifactQuantity.equals(other$associatedPaintingArtifactQuantity)) {
                                                   Object this$mesProductEnum = this.getMesProductEnum();
                                                   Object other$mesProductEnum = other.getMesProductEnum();
                                                   if (this$mesProductEnum == null
                                                      ? other$mesProductEnum == null
                                                      : this$mesProductEnum.equals(other$mesProductEnum)) {
                                                      Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                                                      Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                                                      if (this$boolComposeAssemble == null
                                                         ? other$boolComposeAssemble == null
                                                         : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                                         Object this$classificationName = this.getClassificationName();
                                                         Object other$classificationName = other.getClassificationName();
                                                         if (this$classificationName == null
                                                            ? other$classificationName == null
                                                            : this$classificationName.equals(other$classificationName)) {
                                                            Object this$newClassificationName = this.getNewClassificationName();
                                                            Object other$newClassificationName = other.getNewClassificationName();
                                                            if (this$newClassificationName == null
                                                               ? other$newClassificationName == null
                                                               : this$newClassificationName.equals(other$newClassificationName)) {
                                                               Object this$definitionWord = this.getDefinitionWord();
                                                               Object other$definitionWord = other.getDefinitionWord();
                                                               if (this$definitionWord == null
                                                                  ? other$definitionWord == null
                                                                  : this$definitionWord.equals(other$definitionWord)) {
                                                                  Object this$newDefinitionWord = this.getNewDefinitionWord();
                                                                  Object other$newDefinitionWord = other.getNewDefinitionWord();
                                                                  if (this$newDefinitionWord == null
                                                                     ? other$newDefinitionWord == null
                                                                     : this$newDefinitionWord.equals(other$newDefinitionWord)) {
                                                                     Object this$specPrefixList = this.getSpecPrefixList();
                                                                     Object other$specPrefixList = other.getSpecPrefixList();
                                                                     if (this$specPrefixList == null
                                                                        ? other$specPrefixList == null
                                                                        : this$specPrefixList.equals(other$specPrefixList)) {
                                                                        Object this$newSpecPrefixList = this.getNewSpecPrefixList();
                                                                        Object other$newSpecPrefixList = other.getNewSpecPrefixList();
                                                                        if (this$newSpecPrefixList == null
                                                                           ? other$newSpecPrefixList == null
                                                                           : this$newSpecPrefixList.equals(other$newSpecPrefixList)) {
                                                                           Object this$serialNumberPrefixList = this.getSerialNumberPrefixList();
                                                                           Object other$serialNumberPrefixList = other.getSerialNumberPrefixList();
                                                                           if (this$serialNumberPrefixList == null
                                                                              ? other$serialNumberPrefixList == null
                                                                              : this$serialNumberPrefixList.equals(other$serialNumberPrefixList)) {
                                                                              Object this$newSerialNumberPrefixList = this.getNewSerialNumberPrefixList();
                                                                              Object other$newSerialNumberPrefixList = other.getNewSerialNumberPrefixList();
                                                                              if (this$newSerialNumberPrefixList == null
                                                                                 ? other$newSerialNumberPrefixList == null
                                                                                 : this$newSerialNumberPrefixList.equals(other$newSerialNumberPrefixList)) {
                                                                                 Object this$auditName = this.getAuditName();
                                                                                 Object other$auditName = other.getAuditName();
                                                                                 if (this$auditName == null
                                                                                    ? other$auditName == null
                                                                                    : this$auditName.equals(other$auditName)) {
                                                                                    Object this$auditTime = this.getAuditTime();
                                                                                    Object other$auditTime = other.getAuditTime();
                                                                                    return this$auditTime == null
                                                                                       ? other$auditTime == null
                                                                                       : this$auditTime.equals(other$auditTime);
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
      return other instanceof StructureClassificationDTO;
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
      Object $newParentType = this.getNewParentType();
      result = result * 59 + ($newParentType == null ? 43 : $newParentType.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $newSmallArtifactClassEnum = this.getNewSmallArtifactClassEnum();
      result = result * 59 + ($newSmallArtifactClassEnum == null ? 43 : $newSmallArtifactClassEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $newCodingType = this.getNewCodingType();
      result = result * 59 + ($newCodingType == null ? 43 : $newCodingType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $newSort = this.getNewSort();
      result = result * 59 + ($newSort == null ? 43 : $newSort.hashCode());
      Object $lastChangeId = this.getLastChangeId();
      result = result * 59 + ($lastChangeId == null ? 43 : $lastChangeId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $associatedPaintingArtifactQuantity = this.getAssociatedPaintingArtifactQuantity();
      result = result * 59 + ($associatedPaintingArtifactQuantity == null ? 43 : $associatedPaintingArtifactQuantity.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $newClassificationName = this.getNewClassificationName();
      result = result * 59 + ($newClassificationName == null ? 43 : $newClassificationName.hashCode());
      Object $definitionWord = this.getDefinitionWord();
      result = result * 59 + ($definitionWord == null ? 43 : $definitionWord.hashCode());
      Object $newDefinitionWord = this.getNewDefinitionWord();
      result = result * 59 + ($newDefinitionWord == null ? 43 : $newDefinitionWord.hashCode());
      Object $specPrefixList = this.getSpecPrefixList();
      result = result * 59 + ($specPrefixList == null ? 43 : $specPrefixList.hashCode());
      Object $newSpecPrefixList = this.getNewSpecPrefixList();
      result = result * 59 + ($newSpecPrefixList == null ? 43 : $newSpecPrefixList.hashCode());
      Object $serialNumberPrefixList = this.getSerialNumberPrefixList();
      result = result * 59 + ($serialNumberPrefixList == null ? 43 : $serialNumberPrefixList.hashCode());
      Object $newSerialNumberPrefixList = this.getNewSerialNumberPrefixList();
      result = result * 59 + ($newSerialNumberPrefixList == null ? 43 : $newSerialNumberPrefixList.hashCode());
      Object $auditName = this.getAuditName();
      result = result * 59 + ($auditName == null ? 43 : $auditName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassificationDTO(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", newClassificationName="
         + this.getNewClassificationName()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", parentType="
         + this.getParentType()
         + ", newParentType="
         + this.getNewParentType()
         + ", artifactType="
         + this.getArtifactType()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", newSmallArtifactClassEnum="
         + this.getNewSmallArtifactClassEnum()
         + ", codingType="
         + this.getCodingType()
         + ", newCodingType="
         + this.getNewCodingType()
         + ", definitionWord="
         + this.getDefinitionWord()
         + ", newDefinitionWord="
         + this.getNewDefinitionWord()
         + ", sort="
         + this.getSort()
         + ", newSort="
         + this.getNewSort()
         + ", lastChangeId="
         + this.getLastChangeId()
         + ", specPrefixList="
         + this.getSpecPrefixList()
         + ", newSpecPrefixList="
         + this.getNewSpecPrefixList()
         + ", serialNumberPrefixList="
         + this.getSerialNumberPrefixList()
         + ", newSerialNumberPrefixList="
         + this.getNewSerialNumberPrefixList()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", associatedPaintingArtifactQuantity="
         + this.getAssociatedPaintingArtifactQuantity()
         + ", auditName="
         + this.getAuditName()
         + ", auditTime="
         + this.getAuditTime()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ")";
   }
}
