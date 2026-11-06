package com.hzchum.scim.scm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "SubcontractOrderTemp对象", description = "分包订单表-临时表 ")
@Entity
@TableName("scm_subcontract_order_temp")
@Table(name = "scm_subcontract_order_temp")
@org.hibernate.annotations.Table(appliesTo = "scm_subcontract_order_temp", comment = "分包订单表-临时表 ")
public class SubcontractOrderTemp extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(
      name = "changeTypeEnum",
      value = "分包订单-变更类型 SubOrderChangeTypeEnum 1.新增 2.修改 4.删除",
      notes = "分包订单-变更类型 SubOrderChangeTypeEnum 1.新增 2.修改 4.删除"
   )
   @TableField("change_type_enum")
   @Column(name = "change_type_enum", columnDefinition = "int  COMMENT '分包订单-变更类型 SubOrderChangeTypeEnum 1.新增 2.修改 4.删除'", nullable = false)
   private Integer changeTypeEnum;
   @ApiModelProperty(name = "orderId", value = "分包订单id", notes = "分包订单id")
   @TableField("order_id")
   @Column(name = "order_id", columnDefinition = "bigint default '0' COMMENT '分包订单id'", nullable = false)
   private Long orderId;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '订单编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) DEFAULT 1 comment '项目属性: 1.自营 2.合营 3.包干制'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '项目经理id'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   @TableField(value = "project_manager_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理id'", nullable = true)
   private Long projectManagerId;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint  COMMENT '分包单位(供应商)id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '分包单位(供应商)'", nullable = false)
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @TableField("subcontract_class_id")
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20)  COMMENT '分包类别id'", nullable = false)
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   @TableField("subcontract_class_name")
   @Column(name = "subcontract_class_name", columnDefinition = "varchar(128)  COMMENT '分包类别名称'", nullable = false)
   private String subcontractClassName;
   @ApiModelProperty(name = "amount", value = "合同金额", notes = "合同金额")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '合同金额'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   @TableField("sign_date")
   @Column(name = "sign_date", columnDefinition = "date  COMMENT '签订日期'", nullable = false)
   private LocalDate signDate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int(11)  COMMENT '发票类型'", nullable = false)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典税率value值", notes = "字典税率value值")
   @TableField("tax_rate_type_value")
   @Column(name = "tax_rate_type_value", columnDefinition = "varchar(16) COMMENT '字典税率value值'")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(10,5) default '0.00000' COMMENT '税率'", nullable = false)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "userId", value = "创建人ID", notes = "创建人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(128)  COMMENT '创建人'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "level", value = "单位等级", notes = "单位等级")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) default '0' COMMENT '单位等级'", nullable = false)
   private Integer level;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1待审核 2已通过 4已驳回", notes = "审核状态 1待审核 2已通过 4已驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审核状态 1待审核 2已通过4已驳回'", nullable = false)
   private Integer auditStatusEnum;
   @ApiModelProperty("审核人id")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20) COMMENT '审核人id'")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   @TableField("audit_user_name")
   @Column(name = "audit_user_name", columnDefinition = "varchar(32) COMMENT '审核人'")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6) COMMENT '审核时间'")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "operationUserId", value = "变更操作人ID", notes = "变更操作人ID")
   @TableField("operation_user_id")
   @Column(name = "operation_user_id", columnDefinition = "bigint(20)  COMMENT '变更操作人ID'", nullable = false)
   private Long operationUserId;

   public static SubcontractOrderTemp.SubcontractOrderTempBuilder builder() {
      return new SubcontractOrderTemp.SubcontractOrderTempBuilder();
   }

   public SubcontractOrderTemp() {
   }

   public SubcontractOrderTemp(
      final Long id,
      final Integer changeTypeEnum,
      final Long orderId,
      final String serialNumber,
      final Long projectId,
      final Integer projectAttribute,
      final Long branchCompanyId,
      final Long projectManagerId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal amount,
      final LocalDate signDate,
      final Integer invoiceType,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final Long userId,
      final String userName,
      final String remark,
      final String attachmentIds,
      final Integer level,
      final Integer auditStatusEnum,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Long operationUserId
   ) {
      this.id = id;
      this.changeTypeEnum = changeTypeEnum;
      this.orderId = orderId;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.branchCompanyId = branchCompanyId;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.amount = amount;
      this.signDate = signDate;
      this.invoiceType = invoiceType;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.level = level;
      this.auditStatusEnum = auditStatusEnum;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.operationUserId = operationUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getChangeTypeEnum() {
      return this.changeTypeEnum;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
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

   public LocalDate getSignDate() {
      return this.signDate;
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

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
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

   public Long getOperationUserId() {
      return this.operationUserId;
   }

   public SubcontractOrderTemp setId(final Long id) {
      this.id = id;
      return this;
   }

   public SubcontractOrderTemp setChangeTypeEnum(final Integer changeTypeEnum) {
      this.changeTypeEnum = changeTypeEnum;
      return this;
   }

   public SubcontractOrderTemp setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SubcontractOrderTemp setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SubcontractOrderTemp setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SubcontractOrderTemp setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SubcontractOrderTemp setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public SubcontractOrderTemp setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public SubcontractOrderTemp setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SubcontractOrderTemp setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public SubcontractOrderTemp setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   public SubcontractOrderTemp setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
      return this;
   }

   public SubcontractOrderTemp setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public SubcontractOrderTemp setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
      return this;
   }

   public SubcontractOrderTemp setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public SubcontractOrderTemp setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
      return this;
   }

   public SubcontractOrderTemp setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public SubcontractOrderTemp setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SubcontractOrderTemp setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public SubcontractOrderTemp setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SubcontractOrderTemp setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SubcontractOrderTemp setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public SubcontractOrderTemp setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public SubcontractOrderTemp setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public SubcontractOrderTemp setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public SubcontractOrderTemp setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public SubcontractOrderTemp setOperationUserId(final Long operationUserId) {
      this.operationUserId = operationUserId;
      return this;
   }

   @Override
   public String toString() {
      return "SubcontractOrderTemp(id="
         + this.getId()
         + ", changeTypeEnum="
         + this.getChangeTypeEnum()
         + ", orderId="
         + this.getOrderId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectManagerId="
         + this.getProjectManagerId()
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
         + ", signDate="
         + this.getSignDate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", level="
         + this.getLevel()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", operationUserId="
         + this.getOperationUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderTemp)) {
         return false;
      }

      SubcontractOrderTemp other = (SubcontractOrderTemp)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeTypeEnum = this.getChangeTypeEnum();
         Object other$changeTypeEnum = other.getChangeTypeEnum();
         if (this$changeTypeEnum == null ? other$changeTypeEnum == null : this$changeTypeEnum.equals(other$changeTypeEnum)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectAttribute = this.getProjectAttribute();
                  Object other$projectAttribute = other.getProjectAttribute();
                  if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$supplierId = this.getSupplierId();
                           Object other$supplierId = other.getSupplierId();
                           if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                              Object this$subcontractClassId = this.getSubcontractClassId();
                              Object other$subcontractClassId = other.getSubcontractClassId();
                              if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)
                                 )
                               {
                                 Object this$invoiceType = this.getInvoiceType();
                                 Object other$invoiceType = other.getInvoiceType();
                                 if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$level = this.getLevel();
                                       Object other$level = other.getLevel();
                                       if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                          Object this$auditStatusEnum = this.getAuditStatusEnum();
                                          Object other$auditStatusEnum = other.getAuditStatusEnum();
                                          if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)
                                             )
                                           {
                                             Object this$auditUserId = this.getAuditUserId();
                                             Object other$auditUserId = other.getAuditUserId();
                                             if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                                Object this$operationUserId = this.getOperationUserId();
                                                Object other$operationUserId = other.getOperationUserId();
                                                if (this$operationUserId == null
                                                   ? other$operationUserId == null
                                                   : this$operationUserId.equals(other$operationUserId)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$supplierName = this.getSupplierName();
                                                      Object other$supplierName = other.getSupplierName();
                                                      if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)
                                                         )
                                                       {
                                                         Object this$subcontractClassName = this.getSubcontractClassName();
                                                         Object other$subcontractClassName = other.getSubcontractClassName();
                                                         if (this$subcontractClassName == null
                                                            ? other$subcontractClassName == null
                                                            : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                            Object this$amount = this.getAmount();
                                                            Object other$amount = other.getAmount();
                                                            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                               Object this$signDate = this.getSignDate();
                                                               Object other$signDate = other.getSignDate();
                                                               if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                                                  Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                                  Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                                  if (this$taxRateTypeValue == null
                                                                     ? other$taxRateTypeValue == null
                                                                     : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                                     Object this$taxRate = this.getTaxRate();
                                                                     Object other$taxRate = other.getTaxRate();
                                                                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                        Object this$userName = this.getUserName();
                                                                        Object other$userName = other.getUserName();
                                                                        if (this$userName == null
                                                                           ? other$userName == null
                                                                           : this$userName.equals(other$userName)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$attachmentIds = this.getAttachmentIds();
                                                                              Object other$attachmentIds = other.getAttachmentIds();
                                                                              if (this$attachmentIds == null
                                                                                 ? other$attachmentIds == null
                                                                                 : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                 Object this$auditUserName = this.getAuditUserName();
                                                                                 Object other$auditUserName = other.getAuditUserName();
                                                                                 if (this$auditUserName == null
                                                                                    ? other$auditUserName == null
                                                                                    : this$auditUserName.equals(other$auditUserName)) {
                                                                                    Object this$auditTime = this.getAuditTime();
                                                                                    Object other$auditTime = other.getAuditTime();
                                                                                    return this$auditTime == null
                                                                                       ? other$auditTime == null
                                                                                       : this$auditTime.equals(other$auditTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractOrderTemp;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeTypeEnum = this.getChangeTypeEnum();
      result = result * 59 + ($changeTypeEnum == null ? 43 : $changeTypeEnum.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $operationUserId = this.getOperationUserId();
      result = result * 59 + ($operationUserId == null ? 43 : $operationUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class SubcontractOrderTempBuilder {
      private Long id;
      private Integer changeTypeEnum;
      private Long orderId;
      private String serialNumber;
      private Long projectId;
      private Integer projectAttribute;
      private Long branchCompanyId;
      private Long projectManagerId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal amount;
      private LocalDate signDate;
      private Integer invoiceType;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private Long userId;
      private String userName;
      private String remark;
      private String attachmentIds;
      private Integer level;
      private Integer auditStatusEnum;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Long operationUserId;

      SubcontractOrderTempBuilder() {
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder changeTypeEnum(final Integer changeTypeEnum) {
         this.changeTypeEnum = changeTypeEnum;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SubcontractOrderTemp.SubcontractOrderTempBuilder operationUserId(final Long operationUserId) {
         this.operationUserId = operationUserId;
         return this;
      }

      public SubcontractOrderTemp build() {
         return new SubcontractOrderTemp(
            this.id,
            this.changeTypeEnum,
            this.orderId,
            this.serialNumber,
            this.projectId,
            this.projectAttribute,
            this.branchCompanyId,
            this.projectManagerId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.amount,
            this.signDate,
            this.invoiceType,
            this.taxRateTypeValue,
            this.taxRate,
            this.userId,
            this.userName,
            this.remark,
            this.attachmentIds,
            this.level,
            this.auditStatusEnum,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.operationUserId
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderTemp.SubcontractOrderTempBuilder(id="
            + this.id
            + ", changeTypeEnum="
            + this.changeTypeEnum
            + ", orderId="
            + this.orderId
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", projectManagerId="
            + this.projectManagerId
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
            + ", signDate="
            + this.signDate
            + ", invoiceType="
            + this.invoiceType
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", level="
            + this.level
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", operationUserId="
            + this.operationUserId
            + ")";
      }
   }
}
