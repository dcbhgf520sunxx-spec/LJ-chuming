package com.hzchum.scim.scm.core.api.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;

@ApiModel("构件类型基础配置类dto")
public class StructureClassificationBasicDTO {
   @ApiModelProperty("主键ID 构件种类id")
   private Long id;
   @ApiModelProperty("构件类型")
   private String classificationName;
   @ApiModelProperty("构件类型 1.普通构件 2.次构件")
   private Integer artifactType;
   @ApiModelProperty("构件前缀列表")
   List<String> specPrefixList;
   @ApiModelProperty("mes分类 1建钢构件 2桥梁构件")
   private Integer mesProductEnum;
   @ApiModelProperty("PL构件是否组合部件")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", columnDefinition = "tinyint(1) default 1  COMMENT 'PL构件是否组合部件'")
   private Boolean boolComposeAssemble;

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public List<String> getSpecPrefixList() {
      return this.specPrefixList;
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

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setSpecPrefixList(final List<String> specPrefixList) {
      this.specPrefixList = specPrefixList;
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

      if (!(o instanceof StructureClassificationBasicDTO)) {
         return false;
      }

      StructureClassificationBasicDTO other = (StructureClassificationBasicDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$boolComposeAssemble = this.getBoolComposeAssemble();
               Object other$boolComposeAssemble = other.getBoolComposeAssemble();
               if (this$boolComposeAssemble == null ? other$boolComposeAssemble == null : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                  Object this$classificationName = this.getClassificationName();
                  Object other$classificationName = other.getClassificationName();
                  if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                     Object this$specPrefixList = this.getSpecPrefixList();
                     Object other$specPrefixList = other.getSpecPrefixList();
                     return this$specPrefixList == null ? other$specPrefixList == null : this$specPrefixList.equals(other$specPrefixList);
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
      return other instanceof StructureClassificationBasicDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $specPrefixList = this.getSpecPrefixList();
      return result * 59 + ($specPrefixList == null ? 43 : $specPrefixList.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassificationBasicDTO(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", artifactType="
         + this.getArtifactType()
         + ", specPrefixList="
         + this.getSpecPrefixList()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ")";
   }
}
