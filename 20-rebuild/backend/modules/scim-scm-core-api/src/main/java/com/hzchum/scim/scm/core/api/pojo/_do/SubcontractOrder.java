package com.hzchum.scim.scm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SubcontractOrder对象", description = "分包订单表 ")
@Entity
@TableName("scm_subcontract_order")
@Table(name = "scm_subcontract_order")
@org.hibernate.annotations.Table(appliesTo = "scm_subcontract_order", comment = "分包订单表 ")
public class SubcontractOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '订单编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   @JsonProperty("projectManagerId")
   @JSONField(name = "projectManagerId")
   @TableField(value = "project_manager_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理id'", nullable = true)
   private Long projectManagerId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包单位(供应商)id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '分包单位(供应商)'")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @JsonProperty("subcontractClassId")
   @JSONField(name = "subcontractClassId")
   @TableField("subcontract_class_id")
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20)  COMMENT '分包类别id'", nullable = false)
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   @JsonProperty("subcontractClassName")
   @JSONField(name = "subcontractClassName")
   @TableField("subcontract_class_name")
   @Column(name = "subcontract_class_name", columnDefinition = "varchar(128)  COMMENT '分包类别名称'")
   private String subcontractClassName;
   @ApiModelProperty(name = "amount", value = "合同金额", notes = "合同金额")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '合同金额'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int(11)  COMMENT '发票类型'", nullable = false)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典税率value值", notes = "字典税率value值")
   @TableField("tax_rate_type_value")
   @Column(name = "tax_rate_type_value", columnDefinition = "varchar(16) COMMENT '字典税率value值'")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(10,5) default 0.0  COMMENT '税率'")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "orderStatus", value = "订单状态 1进行中2暂停4已完成", notes = "订单状态 1进行中2暂停4已完成8已结算")
   @JsonProperty("orderStatus")
   @JSONField(name = "orderStatus")
   @TableField("order_status")
   @Column(name = "order_status", columnDefinition = "int(11) default '1' COMMENT '订单状态 1进行中2暂停4已完成'", nullable = false)
   private Integer orderStatus;
   @ApiModelProperty(name = "boolSettlementStatus", value = "结算状态 true 已结算 false 未结算", notes = "结算状态 true 已结算 false 未结算")
   @JsonProperty("boolSettlementStatus")
   @JSONField(name = "boolSettlementStatus")
   @TableField("bool_settlement_status")
   @Column(name = "bool_settlement_status", columnDefinition = "tinyint(1) default '0' COMMENT '结算状态 1已结算 0未结算'", nullable = false)
   private Boolean boolSettlementStatus;
   @ApiModelProperty(name = "settlementAmount", value = "结算额", notes = "结算额")
   @JsonProperty("settlementAmount")
   @JSONField(name = "settlementAmount")
   @TableField("settlement_amount")
   @Column(name = "settlement_amount", columnDefinition = "decimal(32,8)  COMMENT '结算额'")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   @JsonProperty("signDate")
   @JSONField(name = "signDate")
   @TableField("sign_date")
   @Column(name = "sign_date", columnDefinition = "date COMMENT '签订日期'", nullable = false)
   private LocalDate signDate;
   @ApiModelProperty(name = "userId", value = "创建人ID", notes = "创建人ID")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(128)  COMMENT '创建人'")
   private String userName;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField(value = "attachment_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "auditTypeEnum", value = "审核状态 1审核中 2已通过 4已驳回", notes = "审核状态")
   @JsonProperty("auditTypeEnum")
   @JSONField(name = "auditTypeEnum")
   @TableField("audit_type_enum")
   @Column(name = "audit_type_enum", columnDefinition = "int(11) DEFAULT 2 COMMENT '审核状态 1审核中 2已通过 4已驳回'", nullable = false)
   private Integer auditTypeEnum;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @JsonProperty("projectAttribute")
   @JSONField(name = "projectAttribute")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) DEFAULT 1 comment '项目属性: 1.自营 2.合营 3.包干制'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "level", value = "单位等级", notes = "单位等级")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) default '0' COMMENT '单位等级'", nullable = false)
   private Integer level;

   public static SubcontractOrder.SubcontractOrderBuilder builder() {
      return new SubcontractOrder.SubcontractOrderBuilder();
   }

   public SubcontractOrder() {
   }

   public SubcontractOrder(
      final Long id,
      final String serialNumber,
      final Long projectManagerId,
      final Long projectId,
      final Long branchCompanyId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal amount,
      final Integer invoiceType,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final Integer orderStatus,
      final Boolean boolSettlementStatus,
      final BigDecimal settlementAmount,
      final LocalDate signDate,
      final Long userId,
      final String userName,
      final String attachmentIds,
      final String remark,
      final Integer auditTypeEnum,
      final Integer projectAttribute,
      final Integer status,
      final Integer level
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectManagerId = projectManagerId;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.amount = amount;
      this.invoiceType = invoiceType;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.orderStatus = orderStatus;
      this.boolSettlementStatus = boolSettlementStatus;
      this.settlementAmount = settlementAmount;
      this.signDate = signDate;
      this.userId = userId;
      this.userName = userName;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.auditTypeEnum = auditTypeEnum;
      this.projectAttribute = projectAttribute;
      this.status = status;
      this.level = level;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getOrderStatus() {
      return this.orderStatus;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditTypeEnum() {
      return this.auditTypeEnum;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getLevel() {
      return this.level;
   }

   @JsonProperty("id")
   public SubcontractOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public SubcontractOrder setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("projectManagerId")
   public SubcontractOrder setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   @JsonProperty("projectId")
   public SubcontractOrder setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public SubcontractOrder setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("supplierId")
   public SubcontractOrder setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public SubcontractOrder setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("subcontractClassId")
   public SubcontractOrder setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @JsonProperty("subcontractClassName")
   public SubcontractOrder setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
      return this;
   }

   @JsonProperty("amount")
   public SubcontractOrder setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("invoiceType")
   public SubcontractOrder setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public SubcontractOrder setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
      return this;
   }

   @JsonProperty("taxRate")
   public SubcontractOrder setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("orderStatus")
   public SubcontractOrder setOrderStatus(final Integer orderStatus) {
      this.orderStatus = orderStatus;
      return this;
   }

   @JsonProperty("boolSettlementStatus")
   public SubcontractOrder setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
      return this;
   }

   @JsonProperty("settlementAmount")
   public SubcontractOrder setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   @JsonProperty("signDate")
   public SubcontractOrder setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
      return this;
   }

   @JsonProperty("userId")
   public SubcontractOrder setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public SubcontractOrder setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public SubcontractOrder setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("remark")
   public SubcontractOrder setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("auditTypeEnum")
   public SubcontractOrder setAuditTypeEnum(final Integer auditTypeEnum) {
      this.auditTypeEnum = auditTypeEnum;
      return this;
   }

   @JsonProperty("projectAttribute")
   public SubcontractOrder setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   @JsonProperty("status")
   public SubcontractOrder setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public SubcontractOrder setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @Override
   public String toString() {
      return "SubcontractOrder(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", amount="
         + this.getAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", orderStatus="
         + this.getOrderStatus()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", signDate="
         + this.getSignDate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", auditTypeEnum="
         + this.getAuditTypeEnum()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", status="
         + this.getStatus()
         + ", level="
         + this.getLevel()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrder)) {
         return false;
      }

      SubcontractOrder other = (SubcontractOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$subcontractClassId = this.getSubcontractClassId();
                     Object other$subcontractClassId = other.getSubcontractClassId();
                     if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$orderStatus = this.getOrderStatus();
                           Object other$orderStatus = other.getOrderStatus();
                           if (this$orderStatus == null ? other$orderStatus == null : this$orderStatus.equals(other$orderStatus)) {
                              Object this$boolSettlementStatus = this.getBoolSettlementStatus();
                              Object other$boolSettlementStatus = other.getBoolSettlementStatus();
                              if (this$boolSettlementStatus == null
                                 ? other$boolSettlementStatus == null
                                 : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$auditTypeEnum = this.getAuditTypeEnum();
                                    Object other$auditTypeEnum = other.getAuditTypeEnum();
                                    if (this$auditTypeEnum == null ? other$auditTypeEnum == null : this$auditTypeEnum.equals(other$auditTypeEnum)) {
                                       Object this$projectAttribute = this.getProjectAttribute();
                                       Object other$projectAttribute = other.getProjectAttribute();
                                       if (this$projectAttribute == null
                                          ? other$projectAttribute == null
                                          : this$projectAttribute.equals(other$projectAttribute)) {
                                          Object this$status = this.getStatus();
                                          Object other$status = other.getStatus();
                                          if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                             Object this$level = this.getLevel();
                                             Object other$level = other.getLevel();
                                             if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$supplierName = this.getSupplierName();
                                                   Object other$supplierName = other.getSupplierName();
                                                   if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                      Object this$subcontractClassName = this.getSubcontractClassName();
                                                      Object other$subcontractClassName = other.getSubcontractClassName();
                                                      if (this$subcontractClassName == null
                                                         ? other$subcontractClassName == null
                                                         : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                         Object this$amount = this.getAmount();
                                                         Object other$amount = other.getAmount();
                                                         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                            Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                            Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                            if (this$taxRateTypeValue == null
                                                               ? other$taxRateTypeValue == null
                                                               : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$settlementAmount = this.getSettlementAmount();
                                                                  Object other$settlementAmount = other.getSettlementAmount();
                                                                  if (this$settlementAmount == null
                                                                     ? other$settlementAmount == null
                                                                     : this$settlementAmount.equals(other$settlementAmount)) {
                                                                     Object this$signDate = this.getSignDate();
                                                                     Object other$signDate = other.getSignDate();
                                                                     if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                                                        Object this$userName = this.getUserName();
                                                                        Object other$userName = other.getUserName();
                                                                        if (this$userName == null
                                                                           ? other$userName == null
                                                                           : this$userName.equals(other$userName)) {
                                                                           Object this$attachmentIds = this.getAttachmentIds();
                                                                           Object other$attachmentIds = other.getAttachmentIds();
                                                                           if (this$attachmentIds == null
                                                                              ? other$attachmentIds == null
                                                                              : this$attachmentIds.equals(other$attachmentIds)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              return this$remark == null
                                                                                 ? other$remark == null
                                                                                 : this$remark.equals(other$remark);
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
      return other instanceof SubcontractOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $orderStatus = this.getOrderStatus();
      result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditTypeEnum = this.getAuditTypeEnum();
      result = result * 59 + ($auditTypeEnum == null ? 43 : $auditTypeEnum.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SubcontractOrderBuilder {
      private Long id;
      private String serialNumber;
      private Long projectManagerId;
      private Long projectId;
      private Long branchCompanyId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal amount;
      private Integer invoiceType;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private Integer orderStatus;
      private Boolean boolSettlementStatus;
      private BigDecimal settlementAmount;
      private LocalDate signDate;
      private Long userId;
      private String userName;
      private String attachmentIds;
      private String remark;
      private Integer auditTypeEnum;
      private Integer projectAttribute;
      private Integer status;
      private Integer level;

      SubcontractOrderBuilder() {
      }

      @JsonProperty("id")
      public SubcontractOrder.SubcontractOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public SubcontractOrder.SubcontractOrderBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("projectManagerId")
      public SubcontractOrder.SubcontractOrderBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      @JsonProperty("projectId")
      public SubcontractOrder.SubcontractOrderBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public SubcontractOrder.SubcontractOrderBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("supplierId")
      public SubcontractOrder.SubcontractOrderBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public SubcontractOrder.SubcontractOrderBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("subcontractClassId")
      public SubcontractOrder.SubcontractOrderBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      @JsonProperty("subcontractClassName")
      public SubcontractOrder.SubcontractOrderBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      @JsonProperty("amount")
      public SubcontractOrder.SubcontractOrderBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("invoiceType")
      public SubcontractOrder.SubcontractOrderBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SubcontractOrder.SubcontractOrderBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      @JsonProperty("taxRate")
      public SubcontractOrder.SubcontractOrderBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("orderStatus")
      public SubcontractOrder.SubcontractOrderBuilder orderStatus(final Integer orderStatus) {
         this.orderStatus = orderStatus;
         return this;
      }

      @JsonProperty("boolSettlementStatus")
      public SubcontractOrder.SubcontractOrderBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      @JsonProperty("settlementAmount")
      public SubcontractOrder.SubcontractOrderBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      @JsonProperty("signDate")
      public SubcontractOrder.SubcontractOrderBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      @JsonProperty("userId")
      public SubcontractOrder.SubcontractOrderBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public SubcontractOrder.SubcontractOrderBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrder.SubcontractOrderBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("remark")
      public SubcontractOrder.SubcontractOrderBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("auditTypeEnum")
      public SubcontractOrder.SubcontractOrderBuilder auditTypeEnum(final Integer auditTypeEnum) {
         this.auditTypeEnum = auditTypeEnum;
         return this;
      }

      @JsonProperty("projectAttribute")
      public SubcontractOrder.SubcontractOrderBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      @JsonProperty("status")
      public SubcontractOrder.SubcontractOrderBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SubcontractOrder.SubcontractOrderBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SubcontractOrder build() {
         return new SubcontractOrder(
            this.id,
            this.serialNumber,
            this.projectManagerId,
            this.projectId,
            this.branchCompanyId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.amount,
            this.invoiceType,
            this.taxRateTypeValue,
            this.taxRate,
            this.orderStatus,
            this.boolSettlementStatus,
            this.settlementAmount,
            this.signDate,
            this.userId,
            this.userName,
            this.attachmentIds,
            this.remark,
            this.auditTypeEnum,
            this.projectAttribute,
            this.status,
            this.level
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrder.SubcontractOrderBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", amount="
            + this.amount
            + ", invoiceType="
            + this.invoiceType
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", orderStatus="
            + this.orderStatus
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", signDate="
            + this.signDate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", auditTypeEnum="
            + this.auditTypeEnum
            + ", projectAttribute="
            + this.projectAttribute
            + ", status="
            + this.status
            + ", level="
            + this.level
            + ")";
      }
   }
}
