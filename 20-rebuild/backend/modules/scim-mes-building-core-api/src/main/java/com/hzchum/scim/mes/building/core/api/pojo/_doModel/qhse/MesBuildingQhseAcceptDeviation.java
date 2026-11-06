package com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse;

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

@ApiModel(value = "MesBuildingQhseAcceptDeviation对象", description = "让步接收表 ")
@Entity
@TableName("mes_building_qhse_accept_deviation")
@Table(name = "mes_building_qhse_accept_deviation")
public class MesBuildingQhseAcceptDeviation extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id", notes = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   @TableField("qhse_id")
   @Column(name = "qhse_id", columnDefinition = "bigint(20)  COMMENT '问题曝光id'", nullable = false)
   private Long qhseId;
   @ApiModelProperty(name = "approvalRemark", value = "", notes = "")
   @JsonProperty("approvalRemark")
   @JSONField(name = "approvalRemark")
   @TableField("approval_remark")
   @Column(name = "approval_remark", columnDefinition = "varchar(1024)  COMMENT '提交让步接收理由'", nullable = true)
   private String approvalRemark;
   @ApiModelProperty(name = "submitRemark", value = "提交让步接收理由", notes = "提交让步接收理由")
   @JsonProperty("submitRemark")
   @JSONField(name = "submitRemark")
   @TableField("submit_remark")
   @Column(name = "submit_remark", columnDefinition = "varchar(1024)  COMMENT '提交让步接收理由'", nullable = true)
   private String submitRemark;
   @ApiModelProperty(name = "status", value = "状态 [0未审核1未通过收2已通过]", notes = "状态 [0未审核1未通过收2已通过]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态 [0未审核1未通过收2已通过]'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'")
   private Long userId;

   public static MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder builder() {
      return new MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder();
   }

   public MesBuildingQhseAcceptDeviation() {
   }

   public MesBuildingQhseAcceptDeviation(
      final Long id, final Long qhseId, final String approvalRemark, final String submitRemark, final Integer status, final Long userId
   ) {
      this.id = id;
      this.qhseId = qhseId;
      this.approvalRemark = approvalRemark;
      this.submitRemark = submitRemark;
      this.status = status;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public String getApprovalRemark() {
      return this.approvalRemark;
   }

   public String getSubmitRemark() {
      return this.submitRemark;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingQhseAcceptDeviation setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseAcceptDeviation setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("approvalRemark")
   public MesBuildingQhseAcceptDeviation setApprovalRemark(final String approvalRemark) {
      this.approvalRemark = approvalRemark;
      return this;
   }

   @JsonProperty("submitRemark")
   public MesBuildingQhseAcceptDeviation setSubmitRemark(final String submitRemark) {
      this.submitRemark = submitRemark;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhseAcceptDeviation setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseAcceptDeviation setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseAcceptDeviation(id="
         + this.getId()
         + ", qhseId="
         + this.getQhseId()
         + ", approvalRemark="
         + this.getApprovalRemark()
         + ", submitRemark="
         + this.getSubmitRemark()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseAcceptDeviation)) {
         return false;
      }

      MesBuildingQhseAcceptDeviation other = (MesBuildingQhseAcceptDeviation)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseId = this.getQhseId();
         Object other$qhseId = other.getQhseId();
         if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$approvalRemark = this.getApprovalRemark();
                  Object other$approvalRemark = other.getApprovalRemark();
                  if (this$approvalRemark == null ? other$approvalRemark == null : this$approvalRemark.equals(other$approvalRemark)) {
                     Object this$submitRemark = this.getSubmitRemark();
                     Object other$submitRemark = other.getSubmitRemark();
                     return this$submitRemark == null ? other$submitRemark == null : this$submitRemark.equals(other$submitRemark);
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
      return other instanceof MesBuildingQhseAcceptDeviation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $approvalRemark = this.getApprovalRemark();
      result = result * 59 + ($approvalRemark == null ? 43 : $approvalRemark.hashCode());
      Object $submitRemark = this.getSubmitRemark();
      return result * 59 + ($submitRemark == null ? 43 : $submitRemark.hashCode());
   }

   public static class MesBuildingQhseAcceptDeviationBuilder {
      private Long id;
      private Long qhseId;
      private String approvalRemark;
      private String submitRemark;
      private Integer status;
      private Long userId;

      MesBuildingQhseAcceptDeviationBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("approvalRemark")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder approvalRemark(final String approvalRemark) {
         this.approvalRemark = approvalRemark;
         return this;
      }

      @JsonProperty("submitRemark")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder submitRemark(final String submitRemark) {
         this.submitRemark = submitRemark;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingQhseAcceptDeviation build() {
         return new MesBuildingQhseAcceptDeviation(this.id, this.qhseId, this.approvalRemark, this.submitRemark, this.status, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseAcceptDeviation.MesBuildingQhseAcceptDeviationBuilder(id="
            + this.id
            + ", qhseId="
            + this.qhseId
            + ", approvalRemark="
            + this.approvalRemark
            + ", submitRemark="
            + this.submitRemark
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
