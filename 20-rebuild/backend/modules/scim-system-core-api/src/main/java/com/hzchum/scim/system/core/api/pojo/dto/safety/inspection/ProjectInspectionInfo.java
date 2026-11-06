package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("巡检点简单信息")
@JsonInclude(Include.NON_NULL)
public class ProjectInspectionInfo {
   @ApiModelProperty(name = "id", notes = "巡检点id")
   private Long id;
   @ApiModelProperty(name = "name", value = "巡检点名字", notes = "巡检点名字")
   private String name;

   public static ProjectInspectionInfo.ProjectInspectionInfoBuilder builder() {
      return new ProjectInspectionInfo.ProjectInspectionInfoBuilder();
   }

   public ProjectInspectionInfo() {
   }

   public ProjectInspectionInfo(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public ProjectInspectionInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionInfo setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionInfo(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectInspectionInfo)) {
         return false;
      } else {
         ProjectInspectionInfo other = (ProjectInspectionInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProjectInspectionInfoBuilder {
      private Long id;
      private String name;

      ProjectInspectionInfoBuilder() {
      }

      public ProjectInspectionInfo.ProjectInspectionInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionInfo.ProjectInspectionInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInspectionInfo build() {
         return new ProjectInspectionInfo(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectInspectionInfo.ProjectInspectionInfoBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
