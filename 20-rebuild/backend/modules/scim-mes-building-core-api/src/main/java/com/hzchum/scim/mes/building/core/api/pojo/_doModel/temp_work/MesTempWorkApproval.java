package com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesTempWorkApproval对象", description = "点工审批表")
@Entity
@TableName("mes_temp_work_approval")
@Table(name = "mes_temp_work_approval")
@org.hibernate.annotations.Table(appliesTo = "mes_temp_work_approval", comment = "点工审批表")
public class MesTempWorkApproval extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("点工ID")
   @TableField("temp_work_id")
   @Column(name = "temp_work_id", columnDefinition = "bigint(20) COMMENT '点工ID'", nullable = true)
   private Long tempWorkId;
   @ApiModelProperty("审批人ID")
   @TableField("approver_id")
   @Column(name = "approver_id", columnDefinition = "bigint(20) COMMENT '审批人ID'", nullable = true)
   private Long approverId;
   @ApiModelProperty("审批结果")
   @TableField("approval_result")
   @Column(name = "approval_result", columnDefinition = "int(11) COMMENT '审批结果'", nullable = true)
   private Integer approvalResult;
   @ApiModelProperty("审批时间")
   @TableField("approval_time")
   @Column(name = "approval_time", columnDefinition = "datetime COMMENT '审批时间'", nullable = true)
   private LocalDateTime approvalTime;
   @ApiModelProperty("备注")
   @TableField(value = "remark", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "remark", columnDefinition = "varchar(255) COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty("排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) COMMENT '排序'", nullable = true)
   private Integer sort;

   public static MesTempWorkApproval.MesTempWorkApprovalBuilder builder() {
      return new MesTempWorkApproval.MesTempWorkApprovalBuilder();
   }

   public MesTempWorkApproval() {
   }

   public MesTempWorkApproval(
      final Long id,
      final Long tempWorkId,
      final Long approverId,
      final Integer approvalResult,
      final LocalDateTime approvalTime,
      final String remark,
      final Integer sort
   ) {
      this.id = id;
      this.tempWorkId = tempWorkId;
      this.approverId = approverId;
      this.approvalResult = approvalResult;
      this.approvalTime = approvalTime;
      this.remark = remark;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTempWorkId() {
      return this.tempWorkId;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public Integer getApprovalResult() {
      return this.approvalResult;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public MesTempWorkApproval setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesTempWorkApproval setTempWorkId(final Long tempWorkId) {
      this.tempWorkId = tempWorkId;
      return this;
   }

   public MesTempWorkApproval setApproverId(final Long approverId) {
      this.approverId = approverId;
      return this;
   }

   public MesTempWorkApproval setApprovalResult(final Integer approvalResult) {
      this.approvalResult = approvalResult;
      return this;
   }

   public MesTempWorkApproval setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
      return this;
   }

   public MesTempWorkApproval setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesTempWorkApproval setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "MesTempWorkApproval(id="
         + this.getId()
         + ", tempWorkId="
         + this.getTempWorkId()
         + ", approverId="
         + this.getApproverId()
         + ", approvalResult="
         + this.getApprovalResult()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkApproval)) {
         return false;
      }

      MesTempWorkApproval other = (MesTempWorkApproval)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$tempWorkId = this.getTempWorkId();
         Object other$tempWorkId = other.getTempWorkId();
         if (this$tempWorkId == null ? other$tempWorkId == null : this$tempWorkId.equals(other$tempWorkId)) {
            Object this$approverId = this.getApproverId();
            Object other$approverId = other.getApproverId();
            if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
               Object this$approvalResult = this.getApprovalResult();
               Object other$approvalResult = other.getApprovalResult();
               if (this$approvalResult == null ? other$approvalResult == null : this$approvalResult.equals(other$approvalResult)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$approvalTime = this.getApprovalTime();
                     Object other$approvalTime = other.getApprovalTime();
                     if (this$approvalTime == null ? other$approvalTime == null : this$approvalTime.equals(other$approvalTime)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesTempWorkApproval;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $tempWorkId = this.getTempWorkId();
      result = result * 59 + ($tempWorkId == null ? 43 : $tempWorkId.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $approvalResult = this.getApprovalResult();
      result = result * 59 + ($approvalResult == null ? 43 : $approvalResult.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $approvalTime = this.getApprovalTime();
      result = result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesTempWorkApprovalBuilder {
      private Long id;
      private Long tempWorkId;
      private Long approverId;
      private Integer approvalResult;
      private LocalDateTime approvalTime;
      private String remark;
      private Integer sort;

      MesTempWorkApprovalBuilder() {
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder tempWorkId(final Long tempWorkId) {
         this.tempWorkId = tempWorkId;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder approvalResult(final Integer approvalResult) {
         this.approvalResult = approvalResult;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder approvalTime(final LocalDateTime approvalTime) {
         this.approvalTime = approvalTime;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesTempWorkApproval.MesTempWorkApprovalBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesTempWorkApproval build() {
         return new MesTempWorkApproval(this.id, this.tempWorkId, this.approverId, this.approvalResult, this.approvalTime, this.remark, this.sort);
      }

      @Override
      public String toString() {
         return "MesTempWorkApproval.MesTempWorkApprovalBuilder(id="
            + this.id
            + ", tempWorkId="
            + this.tempWorkId
            + ", approverId="
            + this.approverId
            + ", approvalResult="
            + this.approvalResult
            + ", approvalTime="
            + this.approvalTime
            + ", remark="
            + this.remark
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
