package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "projectInspection对象", description = "巡检点表")
@Entity
@TableName("project_inspection")
@Table(name = "project_inspection")
@org.hibernate.annotations.Table(appliesTo = "project_inspection", comment = "巡检点表 ")
public class ProjectInspection extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "巡检点名称", notes = "巡检点名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '巡检点名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "status", value = "巡检点状态 1.启用 0.关闭", notes = "巡检点状态 1.启用 0.关闭")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default'1'  COMMENT '巡检点状态 1.启用 0.关闭'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "point", value = "巡检点坐标", notes = "巡检点坐标")
   @JsonProperty("point")
   @JSONField(name = "point")
   @TableField("point")
   @Column(name = "point", columnDefinition = "varchar(255)  COMMENT '巡检点坐标'", nullable = false)
   private String point;
   @ApiModelProperty(name = "pointName", value = "点位名称", notes = "点位名称")
   @JsonProperty("pointName")
   @JSONField(name = "pointName")
   @TableField("point_name")
   @Column(name = "point_name", columnDefinition = "varchar(255)  COMMENT '点位名称'", nullable = false)
   private String pointName;
   @ApiModelProperty(name = "aroundRadius", value = "点位半径", notes = "点位半径")
   @JsonProperty("aroundRadius")
   @JSONField(name = "aroundRadius")
   @TableField("around_radius")
   @Column(name = "around_radius", columnDefinition = "int(11)  COMMENT '点位半径'", nullable = false)
   private Long aroundRadius;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @JsonProperty("attachmentId")
   @JSONField(name = "attachmentId")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "int(11)  COMMENT '附件id'", nullable = true)
   private Long attachmentId;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "nfcSoleId", value = "nfc唯一id", notes = "nfc唯一id")
   @TableField("nfc_sole_id")
   @Column(name = "nfc_sole_id", columnDefinition = "varchar(255)  COMMENT 'nfc唯一id'", nullable = true)
   private String nfcSoleId;

   public static ProjectInspection.ProjectInspectionBuilder builder() {
      return new ProjectInspection.ProjectInspectionBuilder();
   }

   public ProjectInspection() {
   }

   public ProjectInspection(
      final Long id,
      final String name,
      final Integer status,
      final String point,
      final String pointName,
      final Long aroundRadius,
      final Long attachmentId,
      final Long createUserId,
      final String nfcSoleId
   ) {
      this.id = id;
      this.name = name;
      this.status = status;
      this.point = point;
      this.pointName = pointName;
      this.aroundRadius = aroundRadius;
      this.attachmentId = attachmentId;
      this.createUserId = createUserId;
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

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getNfcSoleId() {
      return this.nfcSoleId;
   }

   @JsonProperty("id")
   public ProjectInspection setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProjectInspection setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("status")
   public ProjectInspection setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("point")
   public ProjectInspection setPoint(final String point) {
      this.point = point;
      return this;
   }

   @JsonProperty("pointName")
   public ProjectInspection setPointName(final String pointName) {
      this.pointName = pointName;
      return this;
   }

   @JsonProperty("aroundRadius")
   public ProjectInspection setAroundRadius(final Long aroundRadius) {
      this.aroundRadius = aroundRadius;
      return this;
   }

   @JsonProperty("attachmentId")
   public ProjectInspection setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ProjectInspection setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectInspection setNfcSoleId(final String nfcSoleId) {
      this.nfcSoleId = nfcSoleId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspection(id="
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
         + ", createUserId="
         + this.getCreateUserId()
         + ", nfcSoleId="
         + this.getNfcSoleId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspection)) {
         return false;
      }

      ProjectInspection other = (ProjectInspection)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspection;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $aroundRadius = this.getAroundRadius();
      result = result * 59 + ($aroundRadius == null ? 43 : $aroundRadius.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $pointName = this.getPointName();
      result = result * 59 + ($pointName == null ? 43 : $pointName.hashCode());
      Object $nfcSoleId = this.getNfcSoleId();
      return result * 59 + ($nfcSoleId == null ? 43 : $nfcSoleId.hashCode());
   }

   public static class ProjectInspectionBuilder {
      private Long id;
      private String name;
      private Integer status;
      private String point;
      private String pointName;
      private Long aroundRadius;
      private Long attachmentId;
      private Long createUserId;
      private String nfcSoleId;

      ProjectInspectionBuilder() {
      }

      @JsonProperty("id")
      public ProjectInspection.ProjectInspectionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectInspection.ProjectInspectionBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("status")
      public ProjectInspection.ProjectInspectionBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("point")
      public ProjectInspection.ProjectInspectionBuilder point(final String point) {
         this.point = point;
         return this;
      }

      @JsonProperty("pointName")
      public ProjectInspection.ProjectInspectionBuilder pointName(final String pointName) {
         this.pointName = pointName;
         return this;
      }

      @JsonProperty("aroundRadius")
      public ProjectInspection.ProjectInspectionBuilder aroundRadius(final Long aroundRadius) {
         this.aroundRadius = aroundRadius;
         return this;
      }

      @JsonProperty("attachmentId")
      public ProjectInspection.ProjectInspectionBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectInspection.ProjectInspectionBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectInspection.ProjectInspectionBuilder nfcSoleId(final String nfcSoleId) {
         this.nfcSoleId = nfcSoleId;
         return this;
      }

      public ProjectInspection build() {
         return new ProjectInspection(
            this.id, this.name, this.status, this.point, this.pointName, this.aroundRadius, this.attachmentId, this.createUserId, this.nfcSoleId
         );
      }

      @Override
      public String toString() {
         return "ProjectInspection.ProjectInspectionBuilder(id="
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
            + ", createUserId="
            + this.createUserId
            + ", nfcSoleId="
            + this.nfcSoleId
            + ")";
      }
   }
}
