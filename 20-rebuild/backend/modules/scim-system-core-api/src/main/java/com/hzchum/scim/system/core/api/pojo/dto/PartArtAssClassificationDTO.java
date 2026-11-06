package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class PartArtAssClassificationDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("种类名称")
   private String className;
   @ApiModelProperty(name = "taskTypeEnum", notes = "产品类型")
   private Integer taskTypeEnum;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   private Integer artifactType;

   public Long getId() {
      return this.id;
   }

   public String getClassName() {
      return this.className;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartArtAssClassificationDTO)) {
         return false;
      }

      PartArtAssClassificationDTO other = (PartArtAssClassificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$className = this.getClassName();
               Object other$className = other.getClassName();
               return this$className == null ? other$className == null : this$className.equals(other$className);
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
      return other instanceof PartArtAssClassificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $className = this.getClassName();
      return result * 59 + ($className == null ? 43 : $className.hashCode());
   }

   @Override
   public String toString() {
      return "PartArtAssClassificationDTO(id="
         + this.getId()
         + ", className="
         + this.getClassName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ")";
   }
}
