package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("构件分类DTO类")
public class MesArtifactClassificationDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "classification", value = "构件分类", notes = "构件分类")
   private String classification;
   @ApiModelProperty(name = "artifactType", value = "构件类型", notes = "构件类型")
   private Integer artifactType;
   @ApiModelProperty(name = "nameIndexList", value = "清单构件名称索引", notes = "清单构件名称索引")
   private List<String> nameIndexList;
   @ApiModelProperty(name = "nameIndexNameInfoList", value = "清单构件名称索引", notes = "清单构件名称索引")
   private List<NameInfo> nameIndexNameInfoList;
   @ApiModelProperty(name = "typeIndexNameList", value = "截面类型索引", notes = "截面类型索引")
   private List<String> typeIndexList;
   @ApiModelProperty(name = "typeIndexNameInfoList", value = "截面类型索引", notes = "截面类型索引")
   private List<NameInfo> typeIndexNameInfoList;

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

   public List<NameInfo> getNameIndexNameInfoList() {
      return this.nameIndexNameInfoList;
   }

   public List<String> getTypeIndexList() {
      return this.typeIndexList;
   }

   public List<NameInfo> getTypeIndexNameInfoList() {
      return this.typeIndexNameInfoList;
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

   public void setNameIndexNameInfoList(final List<NameInfo> nameIndexNameInfoList) {
      this.nameIndexNameInfoList = nameIndexNameInfoList;
   }

   public void setTypeIndexList(final List<String> typeIndexList) {
      this.typeIndexList = typeIndexList;
   }

   public void setTypeIndexNameInfoList(final List<NameInfo> typeIndexNameInfoList) {
      this.typeIndexNameInfoList = typeIndexNameInfoList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClassificationDTO)) {
         return false;
      }

      MesArtifactClassificationDTO other = (MesArtifactClassificationDTO)o;
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
                  Object this$nameIndexNameInfoList = this.getNameIndexNameInfoList();
                  Object other$nameIndexNameInfoList = other.getNameIndexNameInfoList();
                  if (this$nameIndexNameInfoList == null ? other$nameIndexNameInfoList == null : this$nameIndexNameInfoList.equals(other$nameIndexNameInfoList)
                     )
                   {
                     Object this$typeIndexList = this.getTypeIndexList();
                     Object other$typeIndexList = other.getTypeIndexList();
                     if (this$typeIndexList == null ? other$typeIndexList == null : this$typeIndexList.equals(other$typeIndexList)) {
                        Object this$typeIndexNameInfoList = this.getTypeIndexNameInfoList();
                        Object other$typeIndexNameInfoList = other.getTypeIndexNameInfoList();
                        return this$typeIndexNameInfoList == null
                           ? other$typeIndexNameInfoList == null
                           : this$typeIndexNameInfoList.equals(other$typeIndexNameInfoList);
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
      return other instanceof MesArtifactClassificationDTO;
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
      Object $nameIndexNameInfoList = this.getNameIndexNameInfoList();
      result = result * 59 + ($nameIndexNameInfoList == null ? 43 : $nameIndexNameInfoList.hashCode());
      Object $typeIndexList = this.getTypeIndexList();
      result = result * 59 + ($typeIndexList == null ? 43 : $typeIndexList.hashCode());
      Object $typeIndexNameInfoList = this.getTypeIndexNameInfoList();
      return result * 59 + ($typeIndexNameInfoList == null ? 43 : $typeIndexNameInfoList.hashCode());
   }

   @Override
   public String toString() {
      return "MesArtifactClassificationDTO(id="
         + this.getId()
         + ", classification="
         + this.getClassification()
         + ", artifactType="
         + this.getArtifactType()
         + ", nameIndexList="
         + this.getNameIndexList()
         + ", nameIndexNameInfoList="
         + this.getNameIndexNameInfoList()
         + ", typeIndexList="
         + this.getTypeIndexList()
         + ", typeIndexNameInfoList="
         + this.getTypeIndexNameInfoList()
         + ")";
   }
}
