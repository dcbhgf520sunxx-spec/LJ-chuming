package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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

@ApiModel(value = "MesBuildingNestingApprove对象", description = "MesBuildingNestingApprove对象")
@Entity
@TableName("mes_building_nesting_approve")
@Table(name = "mes_building_nesting_approve")
public class MesBuildingNestingApprove extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20) COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "wmsApproveRecordId", value = "审批记录id", notes = "审批记录id")
   @JsonProperty("wmsApproveRecordId")
   @JSONField(name = "wmsApproveRecordId")
   @TableField("wms_approve_record_id")
   @Column(name = "wms_approve_record_id", columnDefinition = "bigint(20) COMMENT '审批记录id'", nullable = false)
   private Long wmsApproveRecordId;
   @ApiModelProperty(name = "orderNumber", value = "工单编号", notes = "工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @TableField("order_number")
   @Column(name = "order_number", columnDefinition = "varchar(255) COMMENT '工单编号'", nullable = false)
   private String orderNumber;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "bigint(20) COMMENT '作业id'", nullable = false)
   private Long jobId;

   public static MesBuildingNestingApprove.MesBuildingNestingApproveBuilder builder() {
      return new MesBuildingNestingApprove.MesBuildingNestingApproveBuilder();
   }

   public MesBuildingNestingApprove() {
   }

   public MesBuildingNestingApprove(final Long id, final Long schedulingId, final Long wmsApproveRecordId, final String orderNumber, final Long jobId) {
      this.id = id;
      this.schedulingId = schedulingId;
      this.wmsApproveRecordId = wmsApproveRecordId;
      this.orderNumber = orderNumber;
      this.jobId = jobId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getWmsApproveRecordId() {
      return this.wmsApproveRecordId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getJobId() {
      return this.jobId;
   }

   @JsonProperty("id")
   public MesBuildingNestingApprove setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingNestingApprove setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("wmsApproveRecordId")
   public MesBuildingNestingApprove setWmsApproveRecordId(final Long wmsApproveRecordId) {
      this.wmsApproveRecordId = wmsApproveRecordId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingNestingApprove setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingNestingApprove setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestingApprove(id="
         + this.getId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", wmsApproveRecordId="
         + this.getWmsApproveRecordId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", jobId="
         + this.getJobId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingApprove)) {
         return false;
      }

      MesBuildingNestingApprove other = (MesBuildingNestingApprove)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$schedulingId = this.getSchedulingId();
         Object other$schedulingId = other.getSchedulingId();
         if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
            Object this$wmsApproveRecordId = this.getWmsApproveRecordId();
            Object other$wmsApproveRecordId = other.getWmsApproveRecordId();
            if (this$wmsApproveRecordId == null ? other$wmsApproveRecordId == null : this$wmsApproveRecordId.equals(other$wmsApproveRecordId)) {
               Object this$jobId = this.getJobId();
               Object other$jobId = other.getJobId();
               if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                  Object this$orderNumber = this.getOrderNumber();
                  Object other$orderNumber = other.getOrderNumber();
                  return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof MesBuildingNestingApprove;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $wmsApproveRecordId = this.getWmsApproveRecordId();
      result = result * 59 + ($wmsApproveRecordId == null ? 43 : $wmsApproveRecordId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class MesBuildingNestingApproveBuilder {
      private Long id;
      private Long schedulingId;
      private Long wmsApproveRecordId;
      private String orderNumber;
      private Long jobId;

      MesBuildingNestingApproveBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestingApprove.MesBuildingNestingApproveBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingNestingApprove.MesBuildingNestingApproveBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("wmsApproveRecordId")
      public MesBuildingNestingApprove.MesBuildingNestingApproveBuilder wmsApproveRecordId(final Long wmsApproveRecordId) {
         this.wmsApproveRecordId = wmsApproveRecordId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingNestingApprove.MesBuildingNestingApproveBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingNestingApprove.MesBuildingNestingApproveBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingNestingApprove build() {
         return new MesBuildingNestingApprove(this.id, this.schedulingId, this.wmsApproveRecordId, this.orderNumber, this.jobId);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingApprove.MesBuildingNestingApproveBuilder(id="
            + this.id
            + ", schedulingId="
            + this.schedulingId
            + ", wmsApproveRecordId="
            + this.wmsApproveRecordId
            + ", orderNumber="
            + this.orderNumber
            + ", jobId="
            + this.jobId
            + ")";
      }
   }
}
