package com.hzchum.scim.contract.core.api.pojo._do;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SupplierInvoice对象", description = "供应商开票")
@Entity
@TableName("contract_supplier_invoice")
@Table(name = "contract_supplier_invoice")
public class SupplierInvoice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("属性 1.原材料-采购费 2.运输费 4.制成品-采购费 8.分包费")
   @Column(name = "property_type", columnDefinition = "int(11) comment '属性 1.原材料-采购费 2.运输费 4.制成品-采购费 8.分包费'", nullable = false)
   private Integer propertyType;
   @ApiModelProperty("订单id")
   @Column(name = "order_id", columnDefinition = "bigint(20) comment '订单id'")
   private Long orderId;
   @ApiModelProperty("OA编号")
   @Column(name = "oa_number", columnDefinition = "varchar(255) comment 'OA编号'")
   private String oaNumber;
   @ApiModelProperty("项目id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'")
   private Long projectId;
   @ApiModelProperty("项目经理id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20) comment '项目经理id'")
   private Long projectManagerId;
   @ApiModelProperty("收票日期")
   @Column(name = "receive_invoice_date", columnDefinition = "date comment '收票日期'", nullable = false)
   private LocalDate receiveInvoiceDate;
   @ApiModelProperty("发票面额")
   @Column(name = "invoice_amount", columnDefinition = "decimal(32,8) default 0 comment '发票面额'", nullable = false)
   private BigDecimal invoiceAmount;
   @ApiModelProperty("实开发票金额")
   @Column(name = "actual_invoice_amount", columnDefinition = "decimal(32,8) default 0 comment '实开发票金额'", nullable = false)
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty("发票类型 1增值专用票 2增值普发票 4收据")
   @Column(name = "invoice_type", columnDefinition = "int(11) comment '发票类型 1增值专用票 2增值普发票 4收据'", nullable = false)
   private Integer invoiceType;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   @TableField("bool_include_tax")
   @Column(name = "bool_include_tax", columnDefinition = "tinyint(1) default 1 COMMENT '是否含税 1含税 0免税'", nullable = false)
   private Boolean boolIncludeTax;
   @ApiModelProperty("税率")
   @Column(name = "tax_rate", columnDefinition = "decimal(12,8) default 0 comment '税率'")
   private BigDecimal taxRate;
   @ApiModelProperty("购方单位id(签订主体id)")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) comment '购方单位(签订主体id)'")
   private Long branchCompanyId;
   @ApiModelProperty("购方单位(签订主体名称)")
   @Column(name = "branch_company_name", columnDefinition = "varchar(255) comment '购方单位(签订主体名称)'")
   private String branchCompanyName;
   @ApiModelProperty("销售单位(供应商id)")
   @Column(name = "supplier_id", columnDefinition = "bigint(20) comment '销售单位(供应商id)'", nullable = false)
   private Long supplierId;
   @ApiModelProperty("销售单位(供应商名称)")
   @Column(name = "supplier_name", columnDefinition = "varchar(255) comment '销售单位(供应商名称)'")
   private String supplierName;
   @ApiModelProperty("发票号码")
   @Column(name = "invoice_serial_number", columnDefinition = "varchar(255) comment '发票号码'", nullable = false)
   private String invoiceSerialNumber;
   @ApiModelProperty("申请人id")
   @Column(name = "apply_user_id", columnDefinition = "bigint(20) comment '申请人id'", nullable = false)
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   @Column(name = "apply_user_name", columnDefinition = "varchar(64) comment '申请人名称'")
   private String applyUserName;
   @ApiModelProperty("审核人")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20) comment '审核人id'")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   @Column(name = "audit_user_name", columnDefinition = "varchar(64) comment '审核人名字'")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   @Column(name = "audit_time", columnDefinition = "datetime(6) comment '审核时间'")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态1 未审核(审核中、待审核) 2审核通过 4驳回")
   @Column(name = "audit_status", columnDefinition = "int(11) default 1 comment '审核状态1 未审核(审核中、待审核) 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty("附件id字符串")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024) comment '附件id字符串'")
   private String attachmentIds;
   @ApiModelProperty("备注")
   @Column(name = "remark", columnDefinition = "text comment '备注'")
   private String remark;

   public static SupplierInvoice.SupplierInvoiceBuilder builder() {
      return new SupplierInvoice.SupplierInvoiceBuilder();
   }

   public SupplierInvoice() {
   }

   public SupplierInvoice(
      final Long id,
      final Integer propertyType,
      final Long orderId,
      final String oaNumber,
      final Long projectId,
      final Long projectManagerId,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final BigDecimal actualInvoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final String invoiceSerialNumber,
      final Long applyUserId,
      final String applyUserName,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final String attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.propertyType = propertyType;
      this.orderId = orderId;
      this.oaNumber = oaNumber;
      this.projectId = projectId;
      this.projectManagerId = projectManagerId;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPropertyType() {
      return this.propertyType;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public LocalDate getReceiveInvoiceDate() {
      return this.receiveInvoiceDate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
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

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public SupplierInvoice setId(final Long id) {
      this.id = id;
      return this;
   }

   public SupplierInvoice setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
      return this;
   }

   public SupplierInvoice setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SupplierInvoice setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
      return this;
   }

   public SupplierInvoice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SupplierInvoice setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public SupplierInvoice setReceiveInvoiceDate(final LocalDate receiveInvoiceDate) {
      this.receiveInvoiceDate = receiveInvoiceDate;
      return this;
   }

   public SupplierInvoice setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public SupplierInvoice setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
      return this;
   }

   public SupplierInvoice setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public SupplierInvoice setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
      return this;
   }

   public SupplierInvoice setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public SupplierInvoice setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public SupplierInvoice setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public SupplierInvoice setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SupplierInvoice setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public SupplierInvoice setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
      return this;
   }

   public SupplierInvoice setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierInvoice setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierInvoice setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public SupplierInvoice setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public SupplierInvoice setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public SupplierInvoice setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public SupplierInvoice setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SupplierInvoice setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "SupplierInvoice(id="
         + this.getId()
         + ", propertyType="
         + this.getPropertyType()
         + ", orderId="
         + this.getOrderId()
         + ", oaNumber="
         + this.getOaNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", receiveInvoiceDate="
         + this.getReceiveInvoiceDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoice)) {
         return false;
      }

      SupplierInvoice other = (SupplierInvoice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$propertyType = this.getPropertyType();
         Object other$propertyType = other.getPropertyType();
         if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$invoiceType = this.getInvoiceType();
                     Object other$invoiceType = other.getInvoiceType();
                     if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                        Object this$boolIncludeTax = this.getBoolIncludeTax();
                        Object other$boolIncludeTax = other.getBoolIncludeTax();
                        if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                           Object this$branchCompanyId = this.getBranchCompanyId();
                           Object other$branchCompanyId = other.getBranchCompanyId();
                           if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$applyUserId = this.getApplyUserId();
                                 Object other$applyUserId = other.getApplyUserId();
                                 if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                                    Object this$auditUserId = this.getAuditUserId();
                                    Object other$auditUserId = other.getAuditUserId();
                                    if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                       Object this$auditStatus = this.getAuditStatus();
                                       Object other$auditStatus = other.getAuditStatus();
                                       if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                          Object this$oaNumber = this.getOaNumber();
                                          Object other$oaNumber = other.getOaNumber();
                                          if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
                                             Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
                                             Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
                                             if (this$receiveInvoiceDate == null
                                                ? other$receiveInvoiceDate == null
                                                : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
                                                Object this$invoiceAmount = this.getInvoiceAmount();
                                                Object other$invoiceAmount = other.getInvoiceAmount();
                                                if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                   Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                                   Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                                   if (this$actualInvoiceAmount == null
                                                      ? other$actualInvoiceAmount == null
                                                      : this$actualInvoiceAmount.equals(other$actualInvoiceAmount)) {
                                                      Object this$taxRate = this.getTaxRate();
                                                      Object other$taxRate = other.getTaxRate();
                                                      if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                         Object this$branchCompanyName = this.getBranchCompanyName();
                                                         Object other$branchCompanyName = other.getBranchCompanyName();
                                                         if (this$branchCompanyName == null
                                                            ? other$branchCompanyName == null
                                                            : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                            Object this$supplierName = this.getSupplierName();
                                                            Object other$supplierName = other.getSupplierName();
                                                            if (this$supplierName == null
                                                               ? other$supplierName == null
                                                               : this$supplierName.equals(other$supplierName)) {
                                                               Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                                                               Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                                                               if (this$invoiceSerialNumber == null
                                                                  ? other$invoiceSerialNumber == null
                                                                  : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                                                                  Object this$applyUserName = this.getApplyUserName();
                                                                  Object other$applyUserName = other.getApplyUserName();
                                                                  if (this$applyUserName == null
                                                                     ? other$applyUserName == null
                                                                     : this$applyUserName.equals(other$applyUserName)) {
                                                                     Object this$auditUserName = this.getAuditUserName();
                                                                     Object other$auditUserName = other.getAuditUserName();
                                                                     if (this$auditUserName == null
                                                                        ? other$auditUserName == null
                                                                        : this$auditUserName.equals(other$auditUserName)) {
                                                                        Object this$auditTime = this.getAuditTime();
                                                                        Object other$auditTime = other.getAuditTime();
                                                                        if (this$auditTime == null
                                                                           ? other$auditTime == null
                                                                           : this$auditTime.equals(other$auditTime)) {
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
      return other instanceof SupplierInvoice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      result = result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SupplierInvoiceBuilder {
      private Long id;
      private Integer propertyType;
      private Long orderId;
      private String oaNumber;
      private Long projectId;
      private Long projectManagerId;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private BigDecimal actualInvoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private String invoiceSerialNumber;
      private Long applyUserId;
      private String applyUserName;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private String attachmentIds;
      private String remark;

      SupplierInvoiceBuilder() {
      }

      @JsonProperty("id")
      public SupplierInvoice.SupplierInvoiceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder propertyType(final Integer propertyType) {
         this.propertyType = propertyType;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder oaNumber(final String oaNumber) {
         this.oaNumber = oaNumber;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierInvoice.SupplierInvoiceBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoice build() {
         return new SupplierInvoice(
            this.id,
            this.propertyType,
            this.orderId,
            this.oaNumber,
            this.projectId,
            this.projectManagerId,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.actualInvoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.invoiceSerialNumber,
            this.applyUserId,
            this.applyUserName,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoice.SupplierInvoiceBuilder(id="
            + this.id
            + ", propertyType="
            + this.propertyType
            + ", orderId="
            + this.orderId
            + ", oaNumber="
            + this.oaNumber
            + ", projectId="
            + this.projectId
            + ", projectManagerId="
            + this.projectManagerId
            + ", receiveInvoiceDate="
            + this.receiveInvoiceDate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
