package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("质检人的关联信息")
public class MesInspectUserInfoDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件", notes = "构件类型 1普通构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "teamIdLinks", value = "关联班组ids", notes = "关联班组ids")
   @JsonProperty("teamIdLinks")
   @JSONField(name = "teamIdLinks")
   private List<Long> teamIdLinks;
   @ApiModelProperty(name = "classificationIdLinks", value = "关联", notes = "关联班组ids")
   @JsonProperty("classificationIdLinks")
   @JSONField(name = "classificationIdLinks")
   private List<Long> classificationIdLinks;
   @ApiModelProperty(name = "inspectUsers", value = "质检用户", notes = "质检用户")
   @JsonProperty("inspectUsers")
   @JSONField(name = "inspectUsers")
   private List<Long> inspectUsers;

   MesInspectUserInfoDTO(
      final Long id,
      final Long workshopId,
      final Integer artifactType,
      final Integer taskTypeEnum,
      final List<Long> teamIdLinks,
      final List<Long> classificationIdLinks,
      final List<Long> inspectUsers
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.artifactType = artifactType;
      this.taskTypeEnum = taskTypeEnum;
      this.teamIdLinks = teamIdLinks;
      this.classificationIdLinks = classificationIdLinks;
      this.inspectUsers = inspectUsers;
   }

   public static MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder builder() {
      return new MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public List<Long> getTeamIdLinks() {
      return this.teamIdLinks;
   }

   public List<Long> getClassificationIdLinks() {
      return this.classificationIdLinks;
   }

   public List<Long> getInspectUsers() {
      return this.inspectUsers;
   }

   @JsonProperty("id")
   public MesInspectUserInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesInspectUserInfoDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("artifactType")
   public MesInspectUserInfoDTO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesInspectUserInfoDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("teamIdLinks")
   public MesInspectUserInfoDTO setTeamIdLinks(final List<Long> teamIdLinks) {
      this.teamIdLinks = teamIdLinks;
      return this;
   }

   @JsonProperty("classificationIdLinks")
   public MesInspectUserInfoDTO setClassificationIdLinks(final List<Long> classificationIdLinks) {
      this.classificationIdLinks = classificationIdLinks;
      return this;
   }

   @JsonProperty("inspectUsers")
   public MesInspectUserInfoDTO setInspectUsers(final List<Long> inspectUsers) {
      this.inspectUsers = inspectUsers;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectUserInfoDTO)) {
         return false;
      }

      MesInspectUserInfoDTO other = (MesInspectUserInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$teamIdLinks = this.getTeamIdLinks();
                  Object other$teamIdLinks = other.getTeamIdLinks();
                  if (this$teamIdLinks == null ? other$teamIdLinks == null : this$teamIdLinks.equals(other$teamIdLinks)) {
                     Object this$classificationIdLinks = this.getClassificationIdLinks();
                     Object other$classificationIdLinks = other.getClassificationIdLinks();
                     if (this$classificationIdLinks == null
                        ? other$classificationIdLinks == null
                        : this$classificationIdLinks.equals(other$classificationIdLinks)) {
                        Object this$inspectUsers = this.getInspectUsers();
                        Object other$inspectUsers = other.getInspectUsers();
                        return this$inspectUsers == null ? other$inspectUsers == null : this$inspectUsers.equals(other$inspectUsers);
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
      return other instanceof MesInspectUserInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $teamIdLinks = this.getTeamIdLinks();
      result = result * 59 + ($teamIdLinks == null ? 43 : $teamIdLinks.hashCode());
      Object $classificationIdLinks = this.getClassificationIdLinks();
      result = result * 59 + ($classificationIdLinks == null ? 43 : $classificationIdLinks.hashCode());
      Object $inspectUsers = this.getInspectUsers();
      return result * 59 + ($inspectUsers == null ? 43 : $inspectUsers.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectUserInfoDTO(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", artifactType="
         + this.getArtifactType()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", teamIdLinks="
         + this.getTeamIdLinks()
         + ", classificationIdLinks="
         + this.getClassificationIdLinks()
         + ", inspectUsers="
         + this.getInspectUsers()
         + ")";
   }

   public static class MesInspectUserInfoDTOBuilder {
      private Long id;
      private Long workshopId;
      private Integer artifactType;
      private Integer taskTypeEnum;
      private List<Long> teamIdLinks;
      private List<Long> classificationIdLinks;
      private List<Long> inspectUsers;

      MesInspectUserInfoDTOBuilder() {
      }

      @JsonProperty("id")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("artifactType")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("teamIdLinks")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder teamIdLinks(final List<Long> teamIdLinks) {
         this.teamIdLinks = teamIdLinks;
         return this;
      }

      @JsonProperty("classificationIdLinks")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder classificationIdLinks(final List<Long> classificationIdLinks) {
         this.classificationIdLinks = classificationIdLinks;
         return this;
      }

      @JsonProperty("inspectUsers")
      public MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder inspectUsers(final List<Long> inspectUsers) {
         this.inspectUsers = inspectUsers;
         return this;
      }

      public MesInspectUserInfoDTO build() {
         return new MesInspectUserInfoDTO(
            this.id, this.workshopId, this.artifactType, this.taskTypeEnum, this.teamIdLinks, this.classificationIdLinks, this.inspectUsers
         );
      }

      @Override
      public String toString() {
         return "MesInspectUserInfoDTO.MesInspectUserInfoDTOBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", artifactType="
            + this.artifactType
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", teamIdLinks="
            + this.teamIdLinks
            + ", classificationIdLinks="
            + this.classificationIdLinks
            + ", inspectUsers="
            + this.inspectUsers
            + ")";
      }
   }
}
