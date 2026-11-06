package com.hzchum.scim.contract.core.api.pojo._do.finance;

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

@ApiModel(value = "SupplierPaymentAuditDetail对象", description = "审核流详情表 ")
@Entity
@TableName("supplier_payment_audit_detail")
@Table(name = "supplier_payment_audit_detail")
@org.hibernate.annotations.Table(appliesTo = "supplier_payment_audit_detail", comment = "审核流详情表 ")
public class SupplierPaymentAuditDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "sort", value = "节点", notes = "节点")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '节点'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "approverId", value = "审批人", notes = "审批人")
   @TableField("approver_id")
   @Column(name = "approver_id", columnDefinition = "bigint(20)  COMMENT '审批人'", nullable = false)
   private Long approverId;
   @ApiModelProperty(name = "arrivalTime", value = "到达时间", notes = "到达时间")
   @TableField("arrival_time")
   @Column(name = "arrival_time", columnDefinition = "datetime(6)  COMMENT '到达时间'", nullable = false)
   private LocalDateTime arrivalTime;
   @ApiModelProperty(name = "handleTime", value = "处理时间", notes = "处理时间")
   @TableField("handle_time")
   @Column(name = "handle_time", columnDefinition = "datetime(6)  COMMENT '处理时间'", nullable = false)
   private LocalDateTime handleTime;
   @ApiModelProperty(name = "remark", value = "处理意见", notes = "处理意见")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '处理意见'", nullable = false)
   private String remark;
   @ApiModelProperty(name = "handleStatusEnum", value = "审核状态", notes = "审核状态")
   @TableField("handle_status_enum")
   @Column(name = "handle_status_enum", columnDefinition = "int(11)  COMMENT '审核状态'", nullable = false)
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "auditId", value = "审核id", notes = "审核id")
   @TableField("audit_id")
   @Column(name = "audit_id", columnDefinition = "bigint(20)  COMMENT '审核id'", nullable = false)
   private Long auditId;
   @ApiModelProperty(name = "auditType", value = "审核类型 内包制、自合营、物流、分包", notes = "审核类型 内包制、自合营、物流、分包")
   @TableField("audit_type")
   @Column(name = "audit_type", columnDefinition = "int(11)  COMMENT '审核类型 内包制、自合营、物流、分包'", nullable = false)
   private Integer auditType;
   @ApiModelProperty(name = "invoiceOrPaymentType", value = "开票付款类型 付款审核1、开票审核2", notes = "开票付款类型 付款审核1、开票审核2")
   @TableField("invoice_or_payment_type")
   @Column(name = "invoice_or_payment_type", columnDefinition = "int(11)  COMMENT '开票付款类型 付款审核1、开票审核2'", nullable = false)
   private Integer invoiceOrPaymentType;

   public static SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder builder() {
      return new SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder();
   }

   public SupplierPaymentAuditDetail() {
   }

   public SupplierPaymentAuditDetail(
      final Long id,
      final Long userId,
      final Integer sort,
      final Long approverId,
      final LocalDateTime arrivalTime,
      final LocalDateTime handleTime,
      final String remark,
      final Integer handleStatusEnum,
      final Long auditId,
      final Integer auditType,
      final Integer invoiceOrPaymentType
   ) {
      this.id = id;
      this.userId = userId;
      this.sort = sort;
      this.approverId = approverId;
      this.arrivalTime = arrivalTime;
      this.handleTime = handleTime;
      this.remark = remark;
      this.handleStatusEnum = handleStatusEnum;
      this.auditId = auditId;
      this.auditType = auditType;
      this.invoiceOrPaymentType = invoiceOrPaymentType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public LocalDateTime getHandleTime() {
      return this.handleTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public Integer getAuditType() {
      return this.auditType;
   }

   public Integer getInvoiceOrPaymentType() {
      return this.invoiceOrPaymentType;
   }

   public SupplierPaymentAuditDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public SupplierPaymentAuditDetail setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SupplierPaymentAuditDetail setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public SupplierPaymentAuditDetail setApproverId(final Long approverId) {
      this.approverId = approverId;
      return this;
   }

   public SupplierPaymentAuditDetail setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
      return this;
   }

   public SupplierPaymentAuditDetail setHandleTime(final LocalDateTime handleTime) {
      this.handleTime = handleTime;
      return this;
   }

   public SupplierPaymentAuditDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierPaymentAuditDetail setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
      return this;
   }

   public SupplierPaymentAuditDetail setAuditId(final Long auditId) {
      this.auditId = auditId;
      return this;
   }

   public SupplierPaymentAuditDetail setAuditType(final Integer auditType) {
      this.auditType = auditType;
      return this;
   }

   public SupplierPaymentAuditDetail setInvoiceOrPaymentType(final Integer invoiceOrPaymentType) {
      this.invoiceOrPaymentType = invoiceOrPaymentType;
      return this;
   }

   @Override
   public String toString() {
      return "SupplierPaymentAuditDetail(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", approverId="
         + this.getApproverId()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", handleTime="
         + this.getHandleTime()
         + ", remark="
         + this.getRemark()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", auditId="
         + this.getAuditId()
         + ", auditType="
         + this.getAuditType()
         + ", invoiceOrPaymentType="
         + this.getInvoiceOrPaymentType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentAuditDetail)) {
         return false;
      }

      SupplierPaymentAuditDetail other = (SupplierPaymentAuditDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$approverId = this.getApproverId();
               Object other$approverId = other.getApproverId();
               if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
                  Object this$handleStatusEnum = this.getHandleStatusEnum();
                  Object other$handleStatusEnum = other.getHandleStatusEnum();
                  if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
                     Object this$auditId = this.getAuditId();
                     Object other$auditId = other.getAuditId();
                     if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
                        Object this$auditType = this.getAuditType();
                        Object other$auditType = other.getAuditType();
                        if (this$auditType == null ? other$auditType == null : this$auditType.equals(other$auditType)) {
                           Object this$invoiceOrPaymentType = this.getInvoiceOrPaymentType();
                           Object other$invoiceOrPaymentType = other.getInvoiceOrPaymentType();
                           if (this$invoiceOrPaymentType == null
                              ? other$invoiceOrPaymentType == null
                              : this$invoiceOrPaymentType.equals(other$invoiceOrPaymentType)) {
                              Object this$arrivalTime = this.getArrivalTime();
                              Object other$arrivalTime = other.getArrivalTime();
                              if (this$arrivalTime == null ? other$arrivalTime == null : this$arrivalTime.equals(other$arrivalTime)) {
                                 Object this$handleTime = this.getHandleTime();
                                 Object other$handleTime = other.getHandleTime();
                                 if (this$handleTime == null ? other$handleTime == null : this$handleTime.equals(other$handleTime)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPaymentAuditDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditType = this.getAuditType();
      result = result * 59 + ($auditType == null ? 43 : $auditType.hashCode());
      Object $invoiceOrPaymentType = this.getInvoiceOrPaymentType();
      result = result * 59 + ($invoiceOrPaymentType == null ? 43 : $invoiceOrPaymentType.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $handleTime = this.getHandleTime();
      result = result * 59 + ($handleTime == null ? 43 : $handleTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SupplierPaymentAuditDetailBuilder {
      private Long id;
      private Long userId;
      private Integer sort;
      private Long approverId;
      private LocalDateTime arrivalTime;
      private LocalDateTime handleTime;
      private String remark;
      private Integer handleStatusEnum;
      private Long auditId;
      private Integer auditType;
      private Integer invoiceOrPaymentType;

      SupplierPaymentAuditDetailBuilder() {
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder arrivalTime(final LocalDateTime arrivalTime) {
         this.arrivalTime = arrivalTime;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder handleTime(final LocalDateTime handleTime) {
         this.handleTime = handleTime;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder handleStatusEnum(final Integer handleStatusEnum) {
         this.handleStatusEnum = handleStatusEnum;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder auditId(final Long auditId) {
         this.auditId = auditId;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder auditType(final Integer auditType) {
         this.auditType = auditType;
         return this;
      }

      public SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder invoiceOrPaymentType(final Integer invoiceOrPaymentType) {
         this.invoiceOrPaymentType = invoiceOrPaymentType;
         return this;
      }

      public SupplierPaymentAuditDetail build() {
         return new SupplierPaymentAuditDetail(
            this.id,
            this.userId,
            this.sort,
            this.approverId,
            this.arrivalTime,
            this.handleTime,
            this.remark,
            this.handleStatusEnum,
            this.auditId,
            this.auditType,
            this.invoiceOrPaymentType
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentAuditDetail.SupplierPaymentAuditDetailBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", approverId="
            + this.approverId
            + ", arrivalTime="
            + this.arrivalTime
            + ", handleTime="
            + this.handleTime
            + ", remark="
            + this.remark
            + ", handleStatusEnum="
            + this.handleStatusEnum
            + ", auditId="
            + this.auditId
            + ", auditType="
            + this.auditType
            + ", invoiceOrPaymentType="
            + this.invoiceOrPaymentType
            + ")";
      }
   }
}
