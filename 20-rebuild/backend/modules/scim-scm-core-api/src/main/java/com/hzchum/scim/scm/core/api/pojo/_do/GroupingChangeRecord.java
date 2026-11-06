package com.hzchum.scim.scm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "GroupingChangeRecord对象", description = "分组变更记录表 ")
@Entity
@TableName("scm_grouping_change_record")
@Table(name = "scm_grouping_change_record")
public class GroupingChangeRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "orderId", value = "订单ID", notes = "订单ID")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   @TableField("order_id")
   @Column(name = "order_id", columnDefinition = "bigint(20)  COMMENT '订单ID'", nullable = true)
   private Long orderId;
   @ApiModelProperty(name = "changeType", value = "变更类型", notes = "变更类型")
   @JsonProperty("changeType")
   @JSONField(name = "changeType")
   @TableField("change_type")
   @Column(name = "change_type", columnDefinition = "int(11)  COMMENT '变更类型'", nullable = true)
   private Integer changeType;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "groupingId", value = "现在的分组ID", notes = "现在的分组ID")
   @JsonProperty("groupingId")
   @JSONField(name = "groupingId")
   @TableField("grouping_id")
   @Column(name = "grouping_id", columnDefinition = "bigint(20)  COMMENT '现在的分组ID'", nullable = true)
   private Long groupingId;
   @ApiModelProperty(name = "addGroupingName", value = "新增的分组名称", notes = "新增的分组名称")
   @JsonProperty("addGroupingName")
   @JSONField(name = "addGroupingName")
   @TableField("add_grouping_name")
   @Column(name = "add_grouping_name", columnDefinition = "varchar(255)  COMMENT '新增的分组名称'", nullable = true)
   private String addGroupingName;
   @ApiModelProperty(name = "transferAdd", value = "调整-增加构件ID集", notes = "调整-增加构件ID集")
   @JsonProperty("transferAdd")
   @JSONField(name = "transferAdd")
   @TableField("transfer_add")
   @Column(name = "transfer_add", columnDefinition = "varchar(255)  COMMENT '调整-增加构件ID集'", nullable = true)
   private String transferAdd;
   @ApiModelProperty(name = "transferReduce", value = "调整-减少构件ID集", notes = "调整-减少构件ID集")
   @JsonProperty("transferReduce")
   @JSONField(name = "transferReduce")
   @TableField("transfer_reduce")
   @Column(name = "transfer_reduce", columnDefinition = "varchar(255)  COMMENT '调整-减少构件ID集'", nullable = true)
   private String transferReduce;
   @ApiModelProperty(name = "deleteGroupingName", value = "删除的分组名称", notes = "删除的分组名称")
   @JsonProperty("deleteGroupingName")
   @JSONField(name = "deleteGroupingName")
   @TableField("delete_grouping_name")
   @Column(name = "delete_grouping_name", columnDefinition = "varchar(255)  COMMENT '删除的分组名称'", nullable = true)
   private String deleteGroupingName;
   @ApiModelProperty(name = "updateGroupingName", value = "修改前的分组名称", notes = "修改前的分组名称")
   @JsonProperty("updateGroupingName")
   @JSONField(name = "updateGroupingName")
   @TableField("update_grouping_name")
   @Column(name = "update_grouping_name", columnDefinition = "varchar(255)  COMMENT '修改前的分组名称'", nullable = true)
   private String updateGroupingName;
   @ApiModelProperty(name = "originalGroupingCondition", value = "重置前分组条件", notes = "重置前分组条件")
   @JsonProperty("originalGroupingCondition")
   @JSONField(name = "originalGroupingCondition")
   @TableField("original_grouping_condition")
   @Column(name = "original_grouping_condition", columnDefinition = "varchar(255)  COMMENT '重置前分组条件'", nullable = true)
   private String originalGroupingCondition;
   @ApiModelProperty(name = "originalAmount", value = "变更前价格", notes = "变更前价格")
   @JsonProperty("originalAmount")
   @JSONField(name = "originalAmount")
   @TableField("original_amount")
   @Column(name = "original_amount", columnDefinition = "decimal(32,8)  COMMENT '变更前价格'", nullable = true)
   private BigDecimal originalAmount;
   @ApiModelProperty(name = "reviewStatus", value = "变更审核状态", notes = "变更审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11)  COMMENT '变更审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "applicantId", value = "创建人ID", notes = "创建人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint(20)  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static GroupingChangeRecord.GroupingChangeRecordBuilder builder() {
      return new GroupingChangeRecord.GroupingChangeRecordBuilder();
   }

   public GroupingChangeRecord() {
   }

   public GroupingChangeRecord(
      final Long id,
      final Long orderId,
      final Integer changeType,
      final Integer basicClass,
      final Long groupingId,
      final String addGroupingName,
      final String transferAdd,
      final String transferReduce,
      final String deleteGroupingName,
      final String updateGroupingName,
      final String originalGroupingCondition,
      final BigDecimal originalAmount,
      final Integer reviewStatus,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final String remark
   ) {
      this.id = id;
      this.orderId = orderId;
      this.changeType = changeType;
      this.basicClass = basicClass;
      this.groupingId = groupingId;
      this.addGroupingName = addGroupingName;
      this.transferAdd = transferAdd;
      this.transferReduce = transferReduce;
      this.deleteGroupingName = deleteGroupingName;
      this.updateGroupingName = updateGroupingName;
      this.originalGroupingCondition = originalGroupingCondition;
      this.originalAmount = originalAmount;
      this.reviewStatus = reviewStatus;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getGroupingId() {
      return this.groupingId;
   }

   public String getAddGroupingName() {
      return this.addGroupingName;
   }

   public String getTransferAdd() {
      return this.transferAdd;
   }

   public String getTransferReduce() {
      return this.transferReduce;
   }

   public String getDeleteGroupingName() {
      return this.deleteGroupingName;
   }

   public String getUpdateGroupingName() {
      return this.updateGroupingName;
   }

   public String getOriginalGroupingCondition() {
      return this.originalGroupingCondition;
   }

   public BigDecimal getOriginalAmount() {
      return this.originalAmount;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public GroupingChangeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("orderId")
   public GroupingChangeRecord setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("changeType")
   public GroupingChangeRecord setChangeType(final Integer changeType) {
      this.changeType = changeType;
      return this;
   }

   @JsonProperty("basicClass")
   public GroupingChangeRecord setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("groupingId")
   public GroupingChangeRecord setGroupingId(final Long groupingId) {
      this.groupingId = groupingId;
      return this;
   }

   @JsonProperty("addGroupingName")
   public GroupingChangeRecord setAddGroupingName(final String addGroupingName) {
      this.addGroupingName = addGroupingName;
      return this;
   }

   @JsonProperty("transferAdd")
   public GroupingChangeRecord setTransferAdd(final String transferAdd) {
      this.transferAdd = transferAdd;
      return this;
   }

   @JsonProperty("transferReduce")
   public GroupingChangeRecord setTransferReduce(final String transferReduce) {
      this.transferReduce = transferReduce;
      return this;
   }

   @JsonProperty("deleteGroupingName")
   public GroupingChangeRecord setDeleteGroupingName(final String deleteGroupingName) {
      this.deleteGroupingName = deleteGroupingName;
      return this;
   }

   @JsonProperty("updateGroupingName")
   public GroupingChangeRecord setUpdateGroupingName(final String updateGroupingName) {
      this.updateGroupingName = updateGroupingName;
      return this;
   }

   @JsonProperty("originalGroupingCondition")
   public GroupingChangeRecord setOriginalGroupingCondition(final String originalGroupingCondition) {
      this.originalGroupingCondition = originalGroupingCondition;
      return this;
   }

   @JsonProperty("originalAmount")
   public GroupingChangeRecord setOriginalAmount(final BigDecimal originalAmount) {
      this.originalAmount = originalAmount;
      return this;
   }

   @JsonProperty("reviewStatus")
   public GroupingChangeRecord setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("applicantId")
   public GroupingChangeRecord setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public GroupingChangeRecord setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerId")
   public GroupingChangeRecord setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public GroupingChangeRecord setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewTime")
   public GroupingChangeRecord setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("remark")
   public GroupingChangeRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "GroupingChangeRecord(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", changeType="
         + this.getChangeType()
         + ", basicClass="
         + this.getBasicClass()
         + ", groupingId="
         + this.getGroupingId()
         + ", addGroupingName="
         + this.getAddGroupingName()
         + ", transferAdd="
         + this.getTransferAdd()
         + ", transferReduce="
         + this.getTransferReduce()
         + ", deleteGroupingName="
         + this.getDeleteGroupingName()
         + ", updateGroupingName="
         + this.getUpdateGroupingName()
         + ", originalGroupingCondition="
         + this.getOriginalGroupingCondition()
         + ", originalAmount="
         + this.getOriginalAmount()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GroupingChangeRecord)) {
         return false;
      }

      GroupingChangeRecord other = (GroupingChangeRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$changeType = this.getChangeType();
            Object other$changeType = other.getChangeType();
            if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$groupingId = this.getGroupingId();
                  Object other$groupingId = other.getGroupingId();
                  if (this$groupingId == null ? other$groupingId == null : this$groupingId.equals(other$groupingId)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$applicantId = this.getApplicantId();
                        Object other$applicantId = other.getApplicantId();
                        if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                           Object this$reviewerId = this.getReviewerId();
                           Object other$reviewerId = other.getReviewerId();
                           if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                              Object this$addGroupingName = this.getAddGroupingName();
                              Object other$addGroupingName = other.getAddGroupingName();
                              if (this$addGroupingName == null ? other$addGroupingName == null : this$addGroupingName.equals(other$addGroupingName)) {
                                 Object this$transferAdd = this.getTransferAdd();
                                 Object other$transferAdd = other.getTransferAdd();
                                 if (this$transferAdd == null ? other$transferAdd == null : this$transferAdd.equals(other$transferAdd)) {
                                    Object this$transferReduce = this.getTransferReduce();
                                    Object other$transferReduce = other.getTransferReduce();
                                    if (this$transferReduce == null ? other$transferReduce == null : this$transferReduce.equals(other$transferReduce)) {
                                       Object this$deleteGroupingName = this.getDeleteGroupingName();
                                       Object other$deleteGroupingName = other.getDeleteGroupingName();
                                       if (this$deleteGroupingName == null
                                          ? other$deleteGroupingName == null
                                          : this$deleteGroupingName.equals(other$deleteGroupingName)) {
                                          Object this$updateGroupingName = this.getUpdateGroupingName();
                                          Object other$updateGroupingName = other.getUpdateGroupingName();
                                          if (this$updateGroupingName == null
                                             ? other$updateGroupingName == null
                                             : this$updateGroupingName.equals(other$updateGroupingName)) {
                                             Object this$originalGroupingCondition = this.getOriginalGroupingCondition();
                                             Object other$originalGroupingCondition = other.getOriginalGroupingCondition();
                                             if (this$originalGroupingCondition == null
                                                ? other$originalGroupingCondition == null
                                                : this$originalGroupingCondition.equals(other$originalGroupingCondition)) {
                                                Object this$originalAmount = this.getOriginalAmount();
                                                Object other$originalAmount = other.getOriginalAmount();
                                                if (this$originalAmount == null
                                                   ? other$originalAmount == null
                                                   : this$originalAmount.equals(other$originalAmount)) {
                                                   Object this$applicantName = this.getApplicantName();
                                                   Object other$applicantName = other.getApplicantName();
                                                   if (this$applicantName == null
                                                      ? other$applicantName == null
                                                      : this$applicantName.equals(other$applicantName)) {
                                                      Object this$reviewerName = this.getReviewerName();
                                                      Object other$reviewerName = other.getReviewerName();
                                                      if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)
                                                         )
                                                       {
                                                         Object this$reviewTime = this.getReviewTime();
                                                         Object other$reviewTime = other.getReviewTime();
                                                         if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
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
      return other instanceof GroupingChangeRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $groupingId = this.getGroupingId();
      result = result * 59 + ($groupingId == null ? 43 : $groupingId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $addGroupingName = this.getAddGroupingName();
      result = result * 59 + ($addGroupingName == null ? 43 : $addGroupingName.hashCode());
      Object $transferAdd = this.getTransferAdd();
      result = result * 59 + ($transferAdd == null ? 43 : $transferAdd.hashCode());
      Object $transferReduce = this.getTransferReduce();
      result = result * 59 + ($transferReduce == null ? 43 : $transferReduce.hashCode());
      Object $deleteGroupingName = this.getDeleteGroupingName();
      result = result * 59 + ($deleteGroupingName == null ? 43 : $deleteGroupingName.hashCode());
      Object $updateGroupingName = this.getUpdateGroupingName();
      result = result * 59 + ($updateGroupingName == null ? 43 : $updateGroupingName.hashCode());
      Object $originalGroupingCondition = this.getOriginalGroupingCondition();
      result = result * 59 + ($originalGroupingCondition == null ? 43 : $originalGroupingCondition.hashCode());
      Object $originalAmount = this.getOriginalAmount();
      result = result * 59 + ($originalAmount == null ? 43 : $originalAmount.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class GroupingChangeRecordBuilder {
      private Long id;
      private Long orderId;
      private Integer changeType;
      private Integer basicClass;
      private Long groupingId;
      private String addGroupingName;
      private String transferAdd;
      private String transferReduce;
      private String deleteGroupingName;
      private String updateGroupingName;
      private String originalGroupingCondition;
      private BigDecimal originalAmount;
      private Integer reviewStatus;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private String remark;

      GroupingChangeRecordBuilder() {
      }

      @JsonProperty("id")
      public GroupingChangeRecord.GroupingChangeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("orderId")
      public GroupingChangeRecord.GroupingChangeRecordBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("changeType")
      public GroupingChangeRecord.GroupingChangeRecordBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      @JsonProperty("basicClass")
      public GroupingChangeRecord.GroupingChangeRecordBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("groupingId")
      public GroupingChangeRecord.GroupingChangeRecordBuilder groupingId(final Long groupingId) {
         this.groupingId = groupingId;
         return this;
      }

      @JsonProperty("addGroupingName")
      public GroupingChangeRecord.GroupingChangeRecordBuilder addGroupingName(final String addGroupingName) {
         this.addGroupingName = addGroupingName;
         return this;
      }

      @JsonProperty("transferAdd")
      public GroupingChangeRecord.GroupingChangeRecordBuilder transferAdd(final String transferAdd) {
         this.transferAdd = transferAdd;
         return this;
      }

      @JsonProperty("transferReduce")
      public GroupingChangeRecord.GroupingChangeRecordBuilder transferReduce(final String transferReduce) {
         this.transferReduce = transferReduce;
         return this;
      }

      @JsonProperty("deleteGroupingName")
      public GroupingChangeRecord.GroupingChangeRecordBuilder deleteGroupingName(final String deleteGroupingName) {
         this.deleteGroupingName = deleteGroupingName;
         return this;
      }

      @JsonProperty("updateGroupingName")
      public GroupingChangeRecord.GroupingChangeRecordBuilder updateGroupingName(final String updateGroupingName) {
         this.updateGroupingName = updateGroupingName;
         return this;
      }

      @JsonProperty("originalGroupingCondition")
      public GroupingChangeRecord.GroupingChangeRecordBuilder originalGroupingCondition(final String originalGroupingCondition) {
         this.originalGroupingCondition = originalGroupingCondition;
         return this;
      }

      @JsonProperty("originalAmount")
      public GroupingChangeRecord.GroupingChangeRecordBuilder originalAmount(final BigDecimal originalAmount) {
         this.originalAmount = originalAmount;
         return this;
      }

      @JsonProperty("reviewStatus")
      public GroupingChangeRecord.GroupingChangeRecordBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("applicantId")
      public GroupingChangeRecord.GroupingChangeRecordBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public GroupingChangeRecord.GroupingChangeRecordBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerId")
      public GroupingChangeRecord.GroupingChangeRecordBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public GroupingChangeRecord.GroupingChangeRecordBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewTime")
      public GroupingChangeRecord.GroupingChangeRecordBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("remark")
      public GroupingChangeRecord.GroupingChangeRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public GroupingChangeRecord build() {
         return new GroupingChangeRecord(
            this.id,
            this.orderId,
            this.changeType,
            this.basicClass,
            this.groupingId,
            this.addGroupingName,
            this.transferAdd,
            this.transferReduce,
            this.deleteGroupingName,
            this.updateGroupingName,
            this.originalGroupingCondition,
            this.originalAmount,
            this.reviewStatus,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "GroupingChangeRecord.GroupingChangeRecordBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", changeType="
            + this.changeType
            + ", basicClass="
            + this.basicClass
            + ", groupingId="
            + this.groupingId
            + ", addGroupingName="
            + this.addGroupingName
            + ", transferAdd="
            + this.transferAdd
            + ", transferReduce="
            + this.transferReduce
            + ", deleteGroupingName="
            + this.deleteGroupingName
            + ", updateGroupingName="
            + this.updateGroupingName
            + ", originalGroupingCondition="
            + this.originalGroupingCondition
            + ", originalAmount="
            + this.originalAmount
            + ", reviewStatus="
            + this.reviewStatus
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
