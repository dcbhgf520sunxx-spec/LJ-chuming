package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("构件分类新增类")
public class MesArtifactClassificationSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotBlank(groups = {Add.class, Update.class}, message = "构件分类不能为空")
   @Size(max = 20, groups = {Add.class, Update.class}, message = "构件分类名称过长")
   @ApiModelProperty(name = "classification", value = "构件分类", notes = "构件分类")
   private String classification;
   @NotNull(groups = {Add.class, Update.class}, message = "构件类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = ArtifactTypeEnum.class, message = "构件类型不存在")
   @ApiModelProperty(name = "artifactType", value = "构件类型(1: 主构件, 2: 次构件)", notes = "构件类型")
   private Integer artifactType;
   @NotEmpty(groups = {Add.class, Update.class}, message = "清单构件名称索引不能为空")
   @ApiModelProperty(name = "nameIndexList", value = "清单构件名称索引", notes = "清单构件名称索引")
   private List<String> nameIndexList;
   @NotEmpty(groups = {Add.class, Update.class}, message = "截面类型索引不能为空")
   @ApiModelProperty(name = "typeIndexList", value = "截面类型索引", notes = "截面类型索引")
   private List<String> typeIndexList;

   public Long getId() {
      return this.id;
   }

   public String getClassification() {
      return this.classification;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public List<String> getNameIndexList() {
      return this.nameIndexList;
   }

   public List<String> getTypeIndexList() {
      return this.typeIndexList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassification(final String classification) {
      this.classification = classification;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setNameIndexList(final List<String> nameIndexList) {
      this.nameIndexList = nameIndexList;
   }

   public void setTypeIndexList(final List<String> typeIndexList) {
      this.typeIndexList = typeIndexList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClassificationSaveDTOParam)) {
         return false;
      }

      MesArtifactClassificationSaveDTOParam other = (MesArtifactClassificationSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$classification = this.getClassification();
            Object other$classification = other.getClassification();
            if (this$classification == null ? other$classification == null : this$classification.equals(other$classification)) {
               Object this$nameIndexList = this.getNameIndexList();
               Object other$nameIndexList = other.getNameIndexList();
               if (this$nameIndexList == null ? other$nameIndexList == null : this$nameIndexList.equals(other$nameIndexList)) {
                  Object this$typeIndexList = this.getTypeIndexList();
                  Object other$typeIndexList = other.getTypeIndexList();
                  return this$typeIndexList == null ? other$typeIndexList == null : this$typeIndexList.equals(other$typeIndexList);
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
      return other instanceof MesArtifactClassificationSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $classification = this.getClassification();
      result = result * 59 + ($classification == null ? 43 : $classification.hashCode());
      Object $nameIndexList = this.getNameIndexList();
      result = result * 59 + ($nameIndexList == null ? 43 : $nameIndexList.hashCode());
      Object $typeIndexList = this.getTypeIndexList();
      return result * 59 + ($typeIndexList == null ? 43 : $typeIndexList.hashCode());
   }

   @Override
   public String toString() {
      return "MesArtifactClassificationSaveDTOParam(id="
         + this.getId()
         + ", classification="
         + this.getClassification()
         + ", artifactType="
         + this.getArtifactType()
         + ", nameIndexList="
         + this.getNameIndexList()
         + ", typeIndexList="
         + this.getTypeIndexList()
         + ")";
   }
}
