package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "ProjectInspectionDTOParam", description = "巡检点")
public class ProjectInspectionDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "巡检点名字", notes = "巡检点名字")
   private String name;
   @ApiModelProperty(name = "status", value = "巡检点状态", notes = "巡检点状态")
   private Integer status;
   @ApiModelProperty(name = "point", value = "点位坐标", notes = "点位坐标")
   @NotBlank
   private String point;
   @ApiModelProperty(name = "pointName", value = "点位坐标名称", notes = "点位坐标名称")
   @NotBlank
   private String pointName;
   @ApiModelProperty(name = "aroundRadius", notes = "点位半径")
   @NotBlank
   private Long aroundRadius;
   @ApiModelProperty(name = "attachmentId", notes = "附件id")
   private Long attachmentId;
   @ApiModelProperty(name = "nfcSoleId", value = "nfc唯一id", notes = "nfc唯一id")
   private String nfcSoleId;

   public static ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder builder() {
      return new ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder();
   }

   public ProjectInspectionDTOParam() {
   }

   public ProjectInspectionDTOParam(
      final Long id,
      final String name,
      final Integer status,
      final String point,
      final String pointName,
      final Long aroundRadius,
      final Long attachmentId,
      final String nfcSoleId
   ) {
      this.id = id;
      this.name = name;
      this.status = status;
      this.point = point;
      this.pointName = pointName;
      this.aroundRadius = aroundRadius;
      this.attachmentId = attachmentId;
      this.nfcSoleId = nfcSoleId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getPoint() {
      return this.point;
   }

   public String getPointName() {
      return this.pointName;
   }

   public Long getAroundRadius() {
      return this.aroundRadius;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getNfcSoleId() {
      return this.nfcSoleId;
   }

   public ProjectInspectionDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectInspectionDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectInspectionDTOParam setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectInspectionDTOParam setPointName(final String pointName) {
      this.pointName = pointName;
      return this;
   }

   public ProjectInspectionDTOParam setAroundRadius(final Long aroundRadius) {
      this.aroundRadius = aroundRadius;
      return this;
   }

   public ProjectInspectionDTOParam setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ProjectInspectionDTOParam setNfcSoleId(final String nfcSoleId) {
      this.nfcSoleId = nfcSoleId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionDTOParam)) {
         return false;
      }

      ProjectInspectionDTOParam other = (ProjectInspectionDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$aroundRadius = this.getAroundRadius();
            Object other$aroundRadius = other.getAroundRadius();
            if (this$aroundRadius == null ? other$aroundRadius == null : this$aroundRadius.equals(other$aroundRadius)) {
               Object this$attachmentId = this.getAttachmentId();
               Object other$attachmentId = other.getAttachmentId();
               if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$point = this.getPoint();
                     Object other$point = other.getPoint();
                     if (this$point == null ? other$point == null : this$point.equals(other$point)) {
                        Object this$pointName = this.getPointName();
                        Object other$pointName = other.getPointName();
                        if (this$pointName == null ? other$pointName == null : this$pointName.equals(other$pointName)) {
                           Object this$nfcSoleId = this.getNfcSoleId();
                           Object other$nfcSoleId = other.getNfcSoleId();
                           return this$nfcSoleId == null ? other$nfcSoleId == null : this$nfcSoleId.equals(other$nfcSoleId);
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
      return other instanceof ProjectInspectionDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $aroundRadius = this.getAroundRadius();
      result = result * 59 + ($aroundRadius == null ? 43 : $aroundRadius.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $pointName = this.getPointName();
      result = result * 59 + ($pointName == null ? 43 : $pointName.hashCode());
      Object $nfcSoleId = this.getNfcSoleId();
      return result * 59 + ($nfcSoleId == null ? 43 : $nfcSoleId.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInspectionDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", status="
         + this.getStatus()
         + ", point="
         + this.getPoint()
         + ", pointName="
         + this.getPointName()
         + ", aroundRadius="
         + this.getAroundRadius()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", nfcSoleId="
         + this.getNfcSoleId()
         + ")";
   }

   public static class ProjectInspectionDTOParamBuilder {
      private Long id;
      private String name;
      private Integer status;
      private String point;
      private String pointName;
      private Long aroundRadius;
      private Long attachmentId;
      private String nfcSoleId;

      ProjectInspectionDTOParamBuilder() {
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder pointName(final String pointName) {
         this.pointName = pointName;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder aroundRadius(final Long aroundRadius) {
         this.aroundRadius = aroundRadius;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder nfcSoleId(final String nfcSoleId) {
         this.nfcSoleId = nfcSoleId;
         return this;
      }

      public ProjectInspectionDTOParam build() {
         return new ProjectInspectionDTOParam(this.id, this.name, this.status, this.point, this.pointName, this.aroundRadius, this.attachmentId, this.nfcSoleId);
      }

      @Override
      public String toString() {
         return "ProjectInspectionDTOParam.ProjectInspectionDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", status="
            + this.status
            + ", point="
            + this.point
            + ", pointName="
            + this.pointName
            + ", aroundRadius="
            + this.aroundRadius
            + ", attachmentId="
            + this.attachmentId
            + ", nfcSoleId="
            + this.nfcSoleId
            + ")";
      }
   }
}
