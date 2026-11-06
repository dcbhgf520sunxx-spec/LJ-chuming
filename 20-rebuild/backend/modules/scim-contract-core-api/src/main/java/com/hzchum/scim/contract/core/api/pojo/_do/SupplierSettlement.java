package com.hzchum.scim.contract.core.api.pojo._do;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SupplierSettlement对象", description = "供应商结算表 ")
@Entity
@TableName("contract_supplier_settlement")
@Table(name = "contract_supplier_settlement")
public class SupplierSettlement extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("订单id")
   @Column
   private Long orderId;
   @ApiModelProperty(name = "supplierId", value = "供应商ID")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20) DEFAULT '0' comment '供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty("订单类别 1原材料订单 2制成品订单 4分包订单")
   @TableField
   @Column(name = "order_class", columnDefinition = "int(11) default 1 comment '订单类别 1原材料订单 2制成品订单 4分包订单'", nullable = false)
   private Integer orderClass;
   @ApiModelProperty("结算金额")
   @TableField
   @Column
   private BigDecimal amount;
   @ApiModelProperty("是否预结算")
   @TableField
   @Column(name = "bool_pre_settlement", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否预结算 1预结算 0非预结算(原结算)'")
   private Boolean boolPreSettlement;
   @ApiModelProperty("是否扣除违约金 true 扣除 false 不扣除")
   @Column(name = "bool_deduct", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否扣除 1扣除 0不扣除'")
   private Boolean boolDeduct;
   @ApiModelProperty("申请日期")
   @TableField("apply_date")
   @Column(name = "apply_date", columnDefinition = "date comment '申请日期'")
   private LocalDate applyDate;
   @ApiModelProperty("申请人id")
   @Column
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   @Column
   private String applyUserName;
   @ApiModelProperty("附件id字符串")
   @Column
   private String attachmentIds;
   @ApiModelProperty("备注")
   @Column
   private String remark;
   @ApiModelProperty("审核人id")
   @Column
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   @Column
   private String auditUserName;
   @ApiModelProperty("审核时间")
   @Column
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回,8撤回")
   @Column
   private Integer auditStatus;
   @ApiModelProperty("创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '创建人id'", nullable = false)
   private Long createUserId;

   public static SupplierSettlement.SupplierSettlementBuilder builder() {
      return new SupplierSettlement.SupplierSettlementBuilder();
   }

   public SupplierSettlement() {
   }

   public SupplierSettlement(
      final Long id,
      final Long orderId,
      final Long supplierId,
      final Integer orderClass,
      final BigDecimal amount,
      final Boolean boolPreSettlement,
      final Boolean boolDeduct,
      final LocalDate applyDate,
      final Long applyUserId,
      final String applyUserName,
      final String attachmentIds,
      final String remark,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final Long createUserId
   ) {
      this.id = id;
      this.orderId = orderId;
      this.supplierId = supplierId;
      this.orderClass = orderClass;
      this.amount = amount;
      this.boolPreSettlement = boolPreSettlement;
      this.boolDeduct = boolDeduct;
      this.applyDate = applyDate;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getOrderClass() {
      return this.orderClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolPreSettlement() {
      return this.boolPreSettlement;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   @JsonProperty("id")
   public SupplierSettlement setId(final Long id) {
      this.id = id;
      return this;
   }

   public SupplierSettlement setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SupplierSettlement setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SupplierSettlement setOrderClass(final Integer orderClass) {
      this.orderClass = orderClass;
      return this;
   }

   public SupplierSettlement setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public SupplierSettlement setBoolPreSettlement(final Boolean boolPreSettlement) {
      this.boolPreSettlement = boolPreSettlement;
      return this;
   }

   public SupplierSettlement setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
      return this;
   }

   public SupplierSettlement setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
      return this;
   }

   public SupplierSettlement setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierSettlement setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierSettlement setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SupplierSettlement setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierSettlement setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public SupplierSettlement setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public SupplierSettlement setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public SupplierSettlement setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public SupplierSettlement setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @Override
   public String toString() {
      return "SupplierSettlement(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", supplierId="
         + this.getSupplierId()
         + ", orderClass="
         + this.getOrderClass()
         + ", amount="
         + this.getAmount()
         + ", boolPreSettlement="
         + this.getBoolPreSettlement()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", applyDate="
         + this.getApplyDate()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlement)) {
         return false;
      }

      SupplierSettlement other = (SupplierSettlement)o;
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
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$orderClass = this.getOrderClass();
               Object other$orderClass = other.getOrderClass();
               if (this$orderClass == null ? other$orderClass == null : this$orderClass.equals(other$orderClass)) {
                  Object this$boolPreSettlement = this.getBoolPreSettlement();
                  Object other$boolPreSettlement = other.getBoolPreSettlement();
                  if (this$boolPreSettlement == null ? other$boolPreSettlement == null : this$boolPreSettlement.equals(other$boolPreSettlement)) {
                     Object this$boolDeduct = this.getBoolDeduct();
                     Object other$boolDeduct = other.getBoolDeduct();
                     if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
                        Object this$applyUserId = this.getApplyUserId();
                        Object other$applyUserId = other.getApplyUserId();
                        if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                           Object this$auditUserId = this.getAuditUserId();
                           Object other$auditUserId = other.getAuditUserId();
                           if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                              Object this$auditStatus = this.getAuditStatus();
                              Object other$auditStatus = other.getAuditStatus();
                              if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                 Object this$createUserId = this.getCreateUserId();
                                 Object other$createUserId = other.getCreateUserId();
                                 if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                       Object this$applyDate = this.getApplyDate();
                                       Object other$applyDate = other.getApplyDate();
                                       if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                          Object this$applyUserName = this.getApplyUserName();
                                          Object other$applyUserName = other.getApplyUserName();
                                          if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                             Object this$attachmentIds = this.getAttachmentIds();
                                             Object other$attachmentIds = other.getAttachmentIds();
                                             if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$auditUserName = this.getAuditUserName();
                                                   Object other$auditUserName = other.getAuditUserName();
                                                   if (this$auditUserName == null
                                                      ? other$auditUserName == null
                                                      : this$auditUserName.equals(other$auditUserName)) {
                                                      Object this$auditTime = this.getAuditTime();
                                                      Object other$auditTime = other.getAuditTime();
                                                      return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof SupplierSettlement;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $orderClass = this.getOrderClass();
      result = result * 59 + ($orderClass == null ? 43 : $orderClass.hashCode());
      Object $boolPreSettlement = this.getBoolPreSettlement();
      result = result * 59 + ($boolPreSettlement == null ? 43 : $boolPreSettlement.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class SupplierSettlementBuilder {
      private Long id;
      private Long orderId;
      private Long supplierId;
      private Integer orderClass;
      private BigDecimal amount;
      private Boolean boolPreSettlement;
      private Boolean boolDeduct;
      private LocalDate applyDate;
      private Long applyUserId;
      private String applyUserName;
      private String attachmentIds;
      private String remark;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private Long createUserId;

      SupplierSettlementBuilder() {
      }

      @JsonProperty("id")
      public SupplierSettlement.SupplierSettlementBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder orderClass(final Integer orderClass) {
         this.orderClass = orderClass;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder boolPreSettlement(final Boolean boolPreSettlement) {
         this.boolPreSettlement = boolPreSettlement;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder boolDeduct(final Boolean boolDeduct) {
         this.boolDeduct = boolDeduct;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierSettlement.SupplierSettlementBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SupplierSettlement build() {
         return new SupplierSettlement(
            this.id,
            this.orderId,
            this.supplierId,
            this.orderClass,
            this.amount,
            this.boolPreSettlement,
            this.boolDeduct,
            this.applyDate,
            this.applyUserId,
            this.applyUserName,
            this.attachmentIds,
            this.remark,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.createUserId
         );
      }

      @Override
      public String toString() {
         return "SupplierSettlement.SupplierSettlementBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", supplierId="
            + this.supplierId
            + ", orderClass="
            + this.orderClass
            + ", amount="
            + this.amount
            + ", boolPreSettlement="
            + this.boolPreSettlement
            + ", boolDeduct="
            + this.boolDeduct
            + ", applyDate="
            + this.applyDate
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
