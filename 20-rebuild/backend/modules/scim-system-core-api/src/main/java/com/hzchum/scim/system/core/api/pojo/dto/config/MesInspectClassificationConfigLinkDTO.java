package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesInspectClassificationConfigLinkDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "inspectConfigId", value = "质检配置id", notes = "质检配置id")
   private Long inspectConfigId;
   @ApiModelProperty(name = "classificationId", value = "零部构件类型id", notes = "零部构件类型id")
   private Long classificationId;
   @ApiModelProperty(name = "classificationName", value = "零部构件种类名称", notes = "零部构件种类名称")
   private String classificationName;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   private Integer taskTypeEnum;

   public static MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder builder() {
      return new MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder();
   }

   public MesInspectClassificationConfigLinkDTO() {
   }

   public MesInspectClassificationConfigLinkDTO(
      final Long id, final Long inspectConfigId, final Long classificationId, final String classificationName, final Integer taskTypeEnum
   ) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.classificationId = classificationId;
      this.classificationName = classificationName;
      this.taskTypeEnum = taskTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectConfigId() {
      return this.inspectConfigId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
   }

   public void setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectClassificationConfigLinkDTO)) {
         return false;
      }

      MesInspectClassificationConfigLinkDTO other = (MesInspectClassificationConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectConfigId = this.getInspectConfigId();
         Object other$inspectConfigId = other.getInspectConfigId();
         if (this$inspectConfigId == null ? other$inspectConfigId == null : this$inspectConfigId.equals(other$inspectConfigId)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$classificationName = this.getClassificationName();
                  Object other$classificationName = other.getClassificationName();
                  return this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName);
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
      return other instanceof MesInspectClassificationConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $classificationName = this.getClassificationName();
      return result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectClassificationConfigLinkDTO(id="
         + this.getId()
         + ", inspectConfigId="
         + this.getInspectConfigId()
         + ", classificationId="
         + this.getClassificationId()
         + ", classificationName="
         + this.getClassificationName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   public static class MesInspectClassificationConfigLinkDTOBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long classificationId;
      private String classificationName;
      private Integer taskTypeEnum;

      MesInspectClassificationConfigLinkDTOBuilder() {
      }

      public MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesInspectClassificationConfigLinkDTO build() {
         return new MesInspectClassificationConfigLinkDTO(this.id, this.inspectConfigId, this.classificationId, this.classificationName, this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "MesInspectClassificationConfigLinkDTO.MesInspectClassificationConfigLinkDTOBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", classificationId="
            + this.classificationId
            + ", classificationName="
            + this.classificationName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
