package com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesMaterialFeedingReport对象", description = "投料填报表")
@Entity
@TableName("mes_material_feeding_report")
@Table(name = "mes_material_feeding_report")
@org.hibernate.annotations.Table(appliesTo = "mes_material_feeding_report", comment = "投料填报表")
public class MesMaterialFeedingReport extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("车间ids")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(500) COMMENT '车间ids'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("投料量(吨)")
   @TableField("feeding_quantity")
   @Column(name = "feeding_quantity", columnDefinition = "decimal(32,8) COMMENT '投料量(吨)'", nullable = true)
   private BigDecimal feedingQuantity;
   @ApiModelProperty("办理人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '办理人id'", nullable = true)
   private Long userId;

   public static MesMaterialFeedingReport.MesMaterialFeedingReportBuilder builder() {
      return new MesMaterialFeedingReport.MesMaterialFeedingReportBuilder();
   }

   public MesMaterialFeedingReport() {
   }

   public MesMaterialFeedingReport(final Long id, final Long projectId, final String workshopIds, final BigDecimal feedingQuantity, final Long userId) {
      this.id = id;
      this.projectId = projectId;
      this.workshopIds = workshopIds;
      this.feedingQuantity = feedingQuantity;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public BigDecimal getFeedingQuantity() {
      return this.feedingQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public MesMaterialFeedingReport setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMaterialFeedingReport setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesMaterialFeedingReport setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesMaterialFeedingReport setFeedingQuantity(final BigDecimal feedingQuantity) {
      this.feedingQuantity = feedingQuantity;
      return this;
   }

   public MesMaterialFeedingReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReport(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", feedingQuantity="
         + this.getFeedingQuantity()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReport)) {
         return false;
      }

      MesMaterialFeedingReport other = (MesMaterialFeedingReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$workshopIds = this.getWorkshopIds();
               Object other$workshopIds = other.getWorkshopIds();
               if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                  Object this$feedingQuantity = this.getFeedingQuantity();
                  Object other$feedingQuantity = other.getFeedingQuantity();
                  return this$feedingQuantity == null ? other$feedingQuantity == null : this$feedingQuantity.equals(other$feedingQuantity);
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
      return other instanceof MesMaterialFeedingReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $feedingQuantity = this.getFeedingQuantity();
      return result * 59 + ($feedingQuantity == null ? 43 : $feedingQuantity.hashCode());
   }

   public static class MesMaterialFeedingReportBuilder {
      private Long id;
      private Long projectId;
      private String workshopIds;
      private BigDecimal feedingQuantity;
      private Long userId;

      MesMaterialFeedingReportBuilder() {
      }

      public MesMaterialFeedingReport.MesMaterialFeedingReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMaterialFeedingReport.MesMaterialFeedingReportBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesMaterialFeedingReport.MesMaterialFeedingReportBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesMaterialFeedingReport.MesMaterialFeedingReportBuilder feedingQuantity(final BigDecimal feedingQuantity) {
         this.feedingQuantity = feedingQuantity;
         return this;
      }

      public MesMaterialFeedingReport.MesMaterialFeedingReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesMaterialFeedingReport build() {
         return new MesMaterialFeedingReport(this.id, this.projectId, this.workshopIds, this.feedingQuantity, this.userId);
      }

      @Override
      public String toString() {
         return "MesMaterialFeedingReport.MesMaterialFeedingReportBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", workshopIds="
            + this.workshopIds
            + ", feedingQuantity="
            + this.feedingQuantity
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
