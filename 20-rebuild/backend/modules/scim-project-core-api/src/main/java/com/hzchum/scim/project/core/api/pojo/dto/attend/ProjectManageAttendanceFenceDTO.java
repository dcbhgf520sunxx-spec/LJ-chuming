package com.hzchum.scim.project.core.api.pojo.dto.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("考勤围栏点位")
public class ProjectManageAttendanceFenceDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   private Long projectId;
   @ApiModelProperty(name = "lng", value = "经度", notes = "经度")
   private String lng;
   @ApiModelProperty(name = "lat", value = "纬度", notes = "纬度")
   private String lat;
   @ApiModelProperty(name = "sort", value = "序号", notes = "序号")
   private Integer sort;

   public static ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder builder() {
      return new ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder();
   }

   public ProjectManageAttendanceFenceDTO() {
   }

   public ProjectManageAttendanceFenceDTO(final Long id, final Long projectId, final String lng, final String lat, final Integer sort) {
      this.id = id;
      this.projectId = projectId;
      this.lng = lng;
      this.lat = lat;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getLng() {
      return this.lng;
   }

   public String getLat() {
      return this.lat;
   }

   public Integer getSort() {
      return this.sort;
   }

   public ProjectManageAttendanceFenceDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendanceFenceDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageAttendanceFenceDTO setLng(final String lng) {
      this.lng = lng;
      return this;
   }

   public ProjectManageAttendanceFenceDTO setLat(final String lat) {
      this.lat = lat;
      return this;
   }

   public ProjectManageAttendanceFenceDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceFenceDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", lng="
         + this.getLng()
         + ", lat="
         + this.getLat()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceFenceDTO)) {
         return false;
      }

      ProjectManageAttendanceFenceDTO other = (ProjectManageAttendanceFenceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$lng = this.getLng();
               Object other$lng = other.getLng();
               if (this$lng == null ? other$lng == null : this$lng.equals(other$lng)) {
                  Object this$lat = this.getLat();
                  Object other$lat = other.getLat();
                  return this$lat == null ? other$lat == null : this$lat.equals(other$lat);
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
      return other instanceof ProjectManageAttendanceFenceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $lng = this.getLng();
      result = result * 59 + ($lng == null ? 43 : $lng.hashCode());
      Object $lat = this.getLat();
      return result * 59 + ($lat == null ? 43 : $lat.hashCode());
   }

   public static class ProjectManageAttendanceFenceDTOBuilder {
      private Long id;
      private Long projectId;
      private String lng;
      private String lat;
      private Integer sort;

      ProjectManageAttendanceFenceDTOBuilder() {
      }

      public ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder lng(final String lng) {
         this.lng = lng;
         return this;
      }

      public ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder lat(final String lat) {
         this.lat = lat;
         return this;
      }

      public ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ProjectManageAttendanceFenceDTO build() {
         return new ProjectManageAttendanceFenceDTO(this.id, this.projectId, this.lng, this.lat, this.sort);
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceFenceDTO.ProjectManageAttendanceFenceDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", lng="
            + this.lng
            + ", lat="
            + this.lat
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
