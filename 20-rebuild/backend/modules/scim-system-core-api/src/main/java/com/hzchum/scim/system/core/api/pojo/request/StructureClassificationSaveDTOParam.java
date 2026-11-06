package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("构件类型配置新增类")
public class StructureClassificationSaveDTOParam {
   @ApiModelProperty("mes分类")
   @NotNull(message = "mes分类不能为空")
   @EnumValidator(value = MesProductEnum.class, message = "mes分类不存在!")
   private Integer mesProductEnum;
   @ApiModelProperty("种类名称")
   @NotBlank(message = "构件种类名称不能为空")
   @Size(min = 1, max = 32, message = "构件类型名称长度超出范围")
   private String classificationName;
   @ApiModelProperty("构件类型 1.普通构件 2.次构件")
   private Integer artifactType;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 smallArtifactClassEnumEnum")
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("打码方式")
   private Integer codingType;
   @ApiModelProperty("排序")
   private Integer sort;
   @Valid
   @NotEmpty(message = "构件规格前缀列表不能为空")
   private Set<String> specPrefixList;
   @ApiModelProperty("是否需组立")
   private Boolean boolComposeAssemble;
   @Valid
   private Set<StructureSerialNumberPrefixDTOParam> serialNumberPrefixList;

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Set<String> getSpecPrefixList() {
      return this.specPrefixList;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public Set<StructureSerialNumberPrefixDTOParam> getSerialNumberPrefixList() {
      return this.serialNumberPrefixList;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setSpecPrefixList(final Set<String> specPrefixList) {
      this.specPrefixList = specPrefixList;
   }

   public void setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public void setSerialNumberPrefixList(final Set<StructureSerialNumberPrefixDTOParam> serialNumberPrefixList) {
      this.serialNumberPrefixList = serialNumberPrefixList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureClassificationSaveDTOParam)) {
         return false;
      }

      StructureClassificationSaveDTOParam other = (StructureClassificationSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mesProductEnum = this.getMesProductEnum();
      Object other$mesProductEnum = other.getMesProductEnum();
      if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
            Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
            if (this$smallArtifactClassEnum == null ? other$smallArtifactClassEnum == null : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
               Object this$codingType = this.getCodingType();
               Object other$codingType = other.getCodingType();
               if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                     Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                     if (this$boolComposeAssemble == null ? other$boolComposeAssemble == null : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                        Object this$classificationName = this.getClassificationName();
                        Object other$classificationName = other.getClassificationName();
                        if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                           Object this$specPrefixList = this.getSpecPrefixList();
                           Object other$specPrefixList = other.getSpecPrefixList();
                           if (this$specPrefixList == null ? other$specPrefixList == null : this$specPrefixList.equals(other$specPrefixList)) {
                              Object this$serialNumberPrefixList = this.getSerialNumberPrefixList();
                              Object other$serialNumberPrefixList = other.getSerialNumberPrefixList();
                              return this$serialNumberPrefixList == null
                                 ? other$serialNumberPrefixList == null
                                 : this$serialNumberPrefixList.equals(other$serialNumberPrefixList);
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
      return other instanceof StructureClassificationSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $specPrefixList = this.getSpecPrefixList();
      result = result * 59 + ($specPrefixList == null ? 43 : $specPrefixList.hashCode());
      Object $serialNumberPrefixList = this.getSerialNumberPrefixList();
      return result * 59 + ($serialNumberPrefixList == null ? 43 : $serialNumberPrefixList.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassificationSaveDTOParam(mesProductEnum="
         + this.getMesProductEnum()
         + ", classificationName="
         + this.getClassificationName()
         + ", artifactType="
         + this.getArtifactType()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", codingType="
         + this.getCodingType()
         + ", sort="
         + this.getSort()
         + ", specPrefixList="
         + this.getSpecPrefixList()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ", serialNumberPrefixList="
         + this.getSerialNumberPrefixList()
         + ")";
   }
}
