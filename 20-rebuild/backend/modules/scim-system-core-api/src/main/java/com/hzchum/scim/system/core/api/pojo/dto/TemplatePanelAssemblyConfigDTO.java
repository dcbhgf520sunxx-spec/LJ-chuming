package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class TemplatePanelAssemblyConfigDTO {
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   private Long id;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty(name = "structureClassificationId", value = "构件特征定义Id")
   private Long structureClassificationId;
   @ApiModelProperty(name = "structureClassificationName", value = "构件特征定义名称")
   private String structureClassificationName;
   @ApiModelProperty(name = "artifactPartNumberPrefix", value = "零件编号前缀列表(用于判断构件特征定义归属)")
   private List<String> artifactPartNumberPrefixList;
   @ApiModelProperty(name = "webPartNumberPrefixList", value = "零件编号前缀列表(用于判断构件特征定义归属)")
   private List<String> webPartNumberPrefixList;
   @ApiModelProperty(name = "sailPartNumberPrefixList", value = "翼板零件编号前缀列表")
   private List<String> sailPartNumberPrefixList;

   public static TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder builder() {
      return new TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public String getStructureClassificationName() {
      return this.structureClassificationName;
   }

   public List<String> getArtifactPartNumberPrefixList() {
      return this.artifactPartNumberPrefixList;
   }

   public List<String> getWebPartNumberPrefixList() {
      return this.webPartNumberPrefixList;
   }

   public List<String> getSailPartNumberPrefixList() {
      return this.sailPartNumberPrefixList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
   }

   public void setStructureClassificationName(final String structureClassificationName) {
      this.structureClassificationName = structureClassificationName;
   }

   public void setArtifactPartNumberPrefixList(final List<String> artifactPartNumberPrefixList) {
      this.artifactPartNumberPrefixList = artifactPartNumberPrefixList;
   }

   public void setWebPartNumberPrefixList(final List<String> webPartNumberPrefixList) {
      this.webPartNumberPrefixList = webPartNumberPrefixList;
   }

   public void setSailPartNumberPrefixList(final List<String> sailPartNumberPrefixList) {
      this.sailPartNumberPrefixList = sailPartNumberPrefixList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TemplatePanelAssemblyConfigDTO)) {
         return false;
      }

      TemplatePanelAssemblyConfigDTO other = (TemplatePanelAssemblyConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$structureClassificationId = this.getStructureClassificationId();
            Object other$structureClassificationId = other.getStructureClassificationId();
            if (this$structureClassificationId == null
               ? other$structureClassificationId == null
               : this$structureClassificationId.equals(other$structureClassificationId)) {
               Object this$structureClassificationName = this.getStructureClassificationName();
               Object other$structureClassificationName = other.getStructureClassificationName();
               if (this$structureClassificationName == null
                  ? other$structureClassificationName == null
                  : this$structureClassificationName.equals(other$structureClassificationName)) {
                  Object this$artifactPartNumberPrefixList = this.getArtifactPartNumberPrefixList();
                  Object other$artifactPartNumberPrefixList = other.getArtifactPartNumberPrefixList();
                  if (this$artifactPartNumberPrefixList == null
                     ? other$artifactPartNumberPrefixList == null
                     : this$artifactPartNumberPrefixList.equals(other$artifactPartNumberPrefixList)) {
                     Object this$webPartNumberPrefixList = this.getWebPartNumberPrefixList();
                     Object other$webPartNumberPrefixList = other.getWebPartNumberPrefixList();
                     if (this$webPartNumberPrefixList == null
                        ? other$webPartNumberPrefixList == null
                        : this$webPartNumberPrefixList.equals(other$webPartNumberPrefixList)) {
                        Object this$sailPartNumberPrefixList = this.getSailPartNumberPrefixList();
                        Object other$sailPartNumberPrefixList = other.getSailPartNumberPrefixList();
                        return this$sailPartNumberPrefixList == null
                           ? other$sailPartNumberPrefixList == null
                           : this$sailPartNumberPrefixList.equals(other$sailPartNumberPrefixList);
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
      return other instanceof TemplatePanelAssemblyConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $structureClassificationName = this.getStructureClassificationName();
      result = result * 59 + ($structureClassificationName == null ? 43 : $structureClassificationName.hashCode());
      Object $artifactPartNumberPrefixList = this.getArtifactPartNumberPrefixList();
      result = result * 59 + ($artifactPartNumberPrefixList == null ? 43 : $artifactPartNumberPrefixList.hashCode());
      Object $webPartNumberPrefixList = this.getWebPartNumberPrefixList();
      result = result * 59 + ($webPartNumberPrefixList == null ? 43 : $webPartNumberPrefixList.hashCode());
      Object $sailPartNumberPrefixList = this.getSailPartNumberPrefixList();
      return result * 59 + ($sailPartNumberPrefixList == null ? 43 : $sailPartNumberPrefixList.hashCode());
   }

   @Override
   public String toString() {
      return "TemplatePanelAssemblyConfigDTO(id="
         + this.getId()
         + ", artifactType="
         + this.getArtifactType()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", structureClassificationName="
         + this.getStructureClassificationName()
         + ", artifactPartNumberPrefixList="
         + this.getArtifactPartNumberPrefixList()
         + ", webPartNumberPrefixList="
         + this.getWebPartNumberPrefixList()
         + ", sailPartNumberPrefixList="
         + this.getSailPartNumberPrefixList()
         + ")";
   }

   public TemplatePanelAssemblyConfigDTO() {
   }

   public TemplatePanelAssemblyConfigDTO(
      final Long id,
      final Integer artifactType,
      final Long structureClassificationId,
      final String structureClassificationName,
      final List<String> artifactPartNumberPrefixList,
      final List<String> webPartNumberPrefixList,
      final List<String> sailPartNumberPrefixList
   ) {
      this.id = id;
      this.artifactType = artifactType;
      this.structureClassificationId = structureClassificationId;
      this.structureClassificationName = structureClassificationName;
      this.artifactPartNumberPrefixList = artifactPartNumberPrefixList;
      this.webPartNumberPrefixList = webPartNumberPrefixList;
      this.sailPartNumberPrefixList = sailPartNumberPrefixList;
   }

   public static class TemplatePanelAssemblyConfigDTOBuilder {
      private Long id;
      private Integer artifactType;
      private Long structureClassificationId;
      private String structureClassificationName;
      private List<String> artifactPartNumberPrefixList;
      private List<String> webPartNumberPrefixList;
      private List<String> sailPartNumberPrefixList;

      TemplatePanelAssemblyConfigDTOBuilder() {
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder structureClassificationName(final String structureClassificationName) {
         this.structureClassificationName = structureClassificationName;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder artifactPartNumberPrefixList(final List<String> artifactPartNumberPrefixList) {
         this.artifactPartNumberPrefixList = artifactPartNumberPrefixList;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder webPartNumberPrefixList(final List<String> webPartNumberPrefixList) {
         this.webPartNumberPrefixList = webPartNumberPrefixList;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder sailPartNumberPrefixList(final List<String> sailPartNumberPrefixList) {
         this.sailPartNumberPrefixList = sailPartNumberPrefixList;
         return this;
      }

      public TemplatePanelAssemblyConfigDTO build() {
         return new TemplatePanelAssemblyConfigDTO(
            this.id,
            this.artifactType,
            this.structureClassificationId,
            this.structureClassificationName,
            this.artifactPartNumberPrefixList,
            this.webPartNumberPrefixList,
            this.sailPartNumberPrefixList
         );
      }

      @Override
      public String toString() {
         return "TemplatePanelAssemblyConfigDTO.TemplatePanelAssemblyConfigDTOBuilder(id="
            + this.id
            + ", artifactType="
            + this.artifactType
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", structureClassificationName="
            + this.structureClassificationName
            + ", artifactPartNumberPrefixList="
            + this.artifactPartNumberPrefixList
            + ", webPartNumberPrefixList="
            + this.webPartNumberPrefixList
            + ", sailPartNumberPrefixList="
            + this.sailPartNumberPrefixList
            + ")";
      }
   }
}
