package com.hzchum.scim.project.core.api.pojo._do;

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
import org.hibernate.annotations.Table;

@ApiModel(value = "ProjectReturnProductMain对象", description = "制成品退货主表 ")
@Entity
@TableName("project_return_product_main")
@Table(appliesTo = "project_return_product_main", comment = "制成品退货主表 ")
public class ProjectReturnProductMain extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "productType", value = "制成品类型", notes = "制成品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '制品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "relationType", value = "关联类型", notes = "关联类型")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 0 COMMENT '关联类型'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "quantity", value = "总数量", notes = "总数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '总数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "totalAmount", value = "金额", notes = "金额")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(30,8)  COMMENT '金额'", nullable = false)
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "tinyint(1) default 1 COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   @TableField("handle_method")
   @Column(name = "handle_method", columnDefinition = "tinyint(1) default 1 COMMENT '处理方式'", nullable = false)
   private Integer handleMethod;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(购买方)", notes = "分支机构id(购买方)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构id(购买方)'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "customerUnit", value = "客户单位(出售方)", notes = "客户单位(出售方)")
   @TableField("customer_unit")
   @Column(name = "customer_unit", columnDefinition = "varchar(64)  COMMENT '客户单位(出售方)'", nullable = true)
   private String customerUnit;
   @ApiModelProperty(name = "status", value = "产品状态 1已发运 2已入库 4已排产", notes = "产品状态 1已发运 2已入库 4已排产")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '处理方式'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "warehouseId", value = "存放仓库id", notes = "存放仓库id")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '存放仓库id'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "freight", value = "运费", notes = "运费")
   @TableField("freight")
   @Column(name = "freight", columnDefinition = "decimal(32,8) DEFAULT 0 COMMENT '运费'", nullable = true)
   private BigDecimal freight;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id字符串'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "auditRemark", value = "审核备注", notes = "审核备注")
   @TableField("audit_remark")
   @Column(name = "audit_remark", columnDefinition = "varchar(255)  COMMENT '审核备注'", nullable = true)
   private String auditRemark;

   public static ProjectReturnProductMain.ProjectReturnProductMainBuilder builder() {
      return new ProjectReturnProductMain.ProjectReturnProductMainBuilder();
   }

   public ProjectReturnProductMain() {
   }

   public ProjectReturnProductMain(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final Integer productType,
      final Integer relationType,
      final BigDecimal quantity,
      final BigDecimal totalAmount,
      final Long createUserId,
      final LocalDateTime auditTime,
      final Long auditUserId,
      final Integer auditStatus,
      final Integer handleMethod,
      final Long branchCompanyId,
      final String customerUnit,
      final Integer status,
      final Long warehouseId,
      final BigDecimal freight,
      final String remark,
      final String attachmentIds,
      final String auditRemark
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.productType = productType;
      this.relationType = relationType;
      this.quantity = quantity;
      this.totalAmount = totalAmount;
      this.createUserId = createUserId;
      this.auditTime = auditTime;
      this.auditUserId = auditUserId;
      this.auditStatus = auditStatus;
      this.handleMethod = handleMethod;
      this.branchCompanyId = branchCompanyId;
      this.customerUnit = customerUnit;
      this.status = status;
      this.warehouseId = warehouseId;
      this.freight = freight;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.auditRemark = auditRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductMain)) {
         return false;
      }

      ProjectReturnProductMain other = (ProjectReturnProductMain)o;
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
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$relationType = this.getRelationType();
               Object other$relationType = other.getRelationType();
               if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$auditUserId = this.getAuditUserId();
                     Object other$auditUserId = other.getAuditUserId();
                     if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$handleMethod = this.getHandleMethod();
                           Object other$handleMethod = other.getHandleMethod();
                           if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                              Object this$branchCompanyId = this.getBranchCompanyId();
                              Object other$branchCompanyId = other.getBranchCompanyId();
                              if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$totalAmount = this.getTotalAmount();
                                             Object other$totalAmount = other.getTotalAmount();
                                             if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                   Object this$customerUnit = this.getCustomerUnit();
                                                   Object other$customerUnit = other.getCustomerUnit();
                                                   if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                                                      Object this$freight = this.getFreight();
                                                      Object other$freight = other.getFreight();
                                                      if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$attachmentIds = this.getAttachmentIds();
                                                            Object other$attachmentIds = other.getAttachmentIds();
                                                            if (this$attachmentIds == null
                                                               ? other$attachmentIds == null
                                                               : this$attachmentIds.equals(other$attachmentIds)) {
                                                               Object this$auditRemark = this.getAuditRemark();
                                                               Object other$auditRemark = other.getAuditRemark();
                                                               return this$auditRemark == null
                                                                  ? other$auditRemark == null
                                                                  : this$auditRemark.equals(other$auditRemark);
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
      return other instanceof ProjectReturnProductMain;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $auditRemark = this.getAuditRemark();
      return result * 59 + ($auditRemark == null ? 43 : $auditRemark.hashCode());
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAuditRemark() {
      return this.auditRemark;
   }

   @JsonProperty("id")
   public ProjectReturnProductMain setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectReturnProductMain setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectReturnProductMain setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectReturnProductMain setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectReturnProductMain setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public ProjectReturnProductMain setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectReturnProductMain setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   public ProjectReturnProductMain setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectReturnProductMain setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ProjectReturnProductMain setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public ProjectReturnProductMain setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ProjectReturnProductMain setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
      return this;
   }

   public ProjectReturnProductMain setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ProjectReturnProductMain setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
      return this;
   }

   public ProjectReturnProductMain setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectReturnProductMain setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public ProjectReturnProductMain setFreight(final BigDecimal freight) {
      this.freight = freight;
      return this;
   }

   public ProjectReturnProductMain setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectReturnProductMain setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ProjectReturnProductMain setAuditRemark(final String auditRemark) {
      this.auditRemark = auditRemark;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectReturnProductMain(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", relationType="
         + this.getRelationType()
         + ", quantity="
         + this.getQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", createUserId="
         + this.getCreateUserId()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", status="
         + this.getStatus()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", freight="
         + this.getFreight()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", auditRemark="
         + this.getAuditRemark()
         + ")";
   }

   public static class ProjectReturnProductMainBuilder {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private Integer productType;
      private Integer relationType;
      private BigDecimal quantity;
      private BigDecimal totalAmount;
      private Long createUserId;
      private LocalDateTime auditTime;
      private Long auditUserId;
      private Integer auditStatus;
      private Integer handleMethod;
      private Long branchCompanyId;
      private String customerUnit;
      private Integer status;
      private Long warehouseId;
      private BigDecimal freight;
      private String remark;
      private String attachmentIds;
      private String auditRemark;

      ProjectReturnProductMainBuilder() {
      }

      @JsonProperty("id")
      public ProjectReturnProductMain.ProjectReturnProductMainBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder handleMethod(final Integer handleMethod) {
         this.handleMethod = handleMethod;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectReturnProductMain.ProjectReturnProductMainBuilder auditRemark(final String auditRemark) {
         this.auditRemark = auditRemark;
         return this;
      }

      public ProjectReturnProductMain build() {
         return new ProjectReturnProductMain(
            this.id,
            this.serialNumber,
            this.projectId,
            this.productType,
            this.relationType,
            this.quantity,
            this.totalAmount,
            this.createUserId,
            this.auditTime,
            this.auditUserId,
            this.auditStatus,
            this.handleMethod,
            this.branchCompanyId,
            this.customerUnit,
            this.status,
            this.warehouseId,
            this.freight,
            this.remark,
            this.attachmentIds,
            this.auditRemark
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnProductMain.ProjectReturnProductMainBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ", relationType="
            + this.relationType
            + ", quantity="
            + this.quantity
            + ", totalAmount="
            + this.totalAmount
            + ", createUserId="
            + this.createUserId
            + ", auditTime="
            + this.auditTime
            + ", auditUserId="
            + this.auditUserId
            + ", auditStatus="
            + this.auditStatus
            + ", handleMethod="
            + this.handleMethod
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", customerUnit="
            + this.customerUnit
            + ", status="
            + this.status
            + ", warehouseId="
            + this.warehouseId
            + ", freight="
            + this.freight
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", auditRemark="
            + this.auditRemark
            + ")";
      }
   }
}
