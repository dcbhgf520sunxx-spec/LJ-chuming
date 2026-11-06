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

@Entity
@ApiModel(value = "ProjectWasteProductMain对象", description = "废品库主表 ")
@Table(appliesTo = "project_waste_product_main", comment = "废品库主表 ")
@TableName("project_waste_product_main")
public class ProjectWasteProductMain extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "productType", value = "制品类型", notes = "制品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '制品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "总数量", notes = "总数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '总数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "totalAmount", value = "金额", notes = "金额")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(30,8)  COMMENT '金额'", nullable = true)
   private BigDecimal totalAmount;
   @Deprecated
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   @TableField("handle_method")
   @Column(name = "handle_method", columnDefinition = "tinyint(1) default 1 COMMENT '处理方式'", nullable = true)
   private Integer handleMethod;
   @ApiModelProperty(name = "wasteHandleMethod", value = "废品处理方式 1二次利用 2废品出售 ", notes = "废品处理方式 1二次利用 2废品出售")
   @TableField("waste_handle_method")
   @Column(name = "waste_handle_method", columnDefinition = "tinyint(1) default 0 COMMENT '废品处理方式 1二次利用 2废品出售'", nullable = false)
   private Integer wasteHandleMethod;
   @ApiModelProperty(name = "useProjectId", value = "二次利用项目id", notes = "二次利用项目id")
   @TableField("use_project_id")
   @Column(name = "use_project_id", columnDefinition = "bigint(20)  COMMENT '二次利用项目id'", nullable = true)
   private Long useProjectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(出售方)", notes = "分支机构id(出售方)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构id(出售方)'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "contractWasteId", value = "废料出售合同id", notes = "废料出售合同id")
   @TableField("contract_waste_id")
   @Column(name = "contract_waste_id", columnDefinition = "bigint(20)  COMMENT '废料出售合同id'", nullable = true)
   private Long contractWasteId;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   @TableField("purchaser")
   @Column(name = "purchaser", columnDefinition = "varchar(64)  COMMENT '购买方'", nullable = true)
   private String purchaser;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "auditRemark", value = "审核备注", notes = "审核备注")
   @TableField("audit_remark")
   @Column(name = "audit_remark", columnDefinition = "varchar(255)  COMMENT '审核备注'", nullable = true)
   private String auditRemark;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "tinyint(1) default 1 COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;

   public static ProjectWasteProductMain.ProjectWasteProductMainBuilder builder() {
      return new ProjectWasteProductMain.ProjectWasteProductMainBuilder();
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   @Deprecated
   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Integer getWasteHandleMethod() {
      return this.wasteHandleMethod;
   }

   public Long getUseProjectId() {
      return this.useProjectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAuditRemark() {
      return this.auditRemark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   @Deprecated
   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setWasteHandleMethod(final Integer wasteHandleMethod) {
      this.wasteHandleMethod = wasteHandleMethod;
   }

   public void setUseProjectId(final Long useProjectId) {
      this.useProjectId = useProjectId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditRemark(final String auditRemark) {
      this.auditRemark = auditRemark;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWasteProductMain)) {
         return false;
      }

      ProjectWasteProductMain other = (ProjectWasteProductMain)o;
      if (!other.canEqual(this)) {
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
               Object this$handleMethod = this.getHandleMethod();
               Object other$handleMethod = other.getHandleMethod();
               if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                  Object this$wasteHandleMethod = this.getWasteHandleMethod();
                  Object other$wasteHandleMethod = other.getWasteHandleMethod();
                  if (this$wasteHandleMethod == null ? other$wasteHandleMethod == null : this$wasteHandleMethod.equals(other$wasteHandleMethod)) {
                     Object this$useProjectId = this.getUseProjectId();
                     Object other$useProjectId = other.getUseProjectId();
                     if (this$useProjectId == null ? other$useProjectId == null : this$useProjectId.equals(other$useProjectId)) {
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                           Object this$contractWasteId = this.getContractWasteId();
                           Object other$contractWasteId = other.getContractWasteId();
                           if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                              Object this$createUserId = this.getCreateUserId();
                              Object other$createUserId = other.getCreateUserId();
                              if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                 Object this$auditUserId = this.getAuditUserId();
                                 Object other$auditUserId = other.getAuditUserId();
                                 if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                    Object this$auditStatus = this.getAuditStatus();
                                    Object other$auditStatus = other.getAuditStatus();
                                    if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$totalAmount = this.getTotalAmount();
                                             Object other$totalAmount = other.getTotalAmount();
                                             if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                                Object this$purchaser = this.getPurchaser();
                                                Object other$purchaser = other.getPurchaser();
                                                if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$auditRemark = this.getAuditRemark();
                                                      Object other$auditRemark = other.getAuditRemark();
                                                      if (this$auditRemark == null ? other$auditRemark == null : this$auditRemark.equals(other$auditRemark)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectWasteProductMain;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $wasteHandleMethod = this.getWasteHandleMethod();
      result = result * 59 + ($wasteHandleMethod == null ? 43 : $wasteHandleMethod.hashCode());
      Object $useProjectId = this.getUseProjectId();
      result = result * 59 + ($useProjectId == null ? 43 : $useProjectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditRemark = this.getAuditRemark();
      result = result * 59 + ($auditRemark == null ? 43 : $auditRemark.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductMain(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", wasteHandleMethod="
         + this.getWasteHandleMethod()
         + ", useProjectId="
         + this.getUseProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", purchaser="
         + this.getPurchaser()
         + ", remark="
         + this.getRemark()
         + ", auditRemark="
         + this.getAuditRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public ProjectWasteProductMain() {
   }

   public ProjectWasteProductMain(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final Integer productType,
      final BigDecimal quantity,
      final BigDecimal totalAmount,
      final Integer handleMethod,
      final Integer wasteHandleMethod,
      final Long useProjectId,
      final Long branchCompanyId,
      final Long contractWasteId,
      final String purchaser,
      final String remark,
      final String auditRemark,
      final Long createUserId,
      final Long auditUserId,
      final Integer auditStatus,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.productType = productType;
      this.quantity = quantity;
      this.totalAmount = totalAmount;
      this.handleMethod = handleMethod;
      this.wasteHandleMethod = wasteHandleMethod;
      this.useProjectId = useProjectId;
      this.branchCompanyId = branchCompanyId;
      this.contractWasteId = contractWasteId;
      this.purchaser = purchaser;
      this.remark = remark;
      this.auditRemark = auditRemark;
      this.createUserId = createUserId;
      this.auditUserId = auditUserId;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
   }

   public static class ProjectWasteProductMainBuilder {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private Integer productType;
      private BigDecimal quantity;
      private BigDecimal totalAmount;
      private Integer handleMethod;
      private Integer wasteHandleMethod;
      private Long useProjectId;
      private Long branchCompanyId;
      private Long contractWasteId;
      private String purchaser;
      private String remark;
      private String auditRemark;
      private Long createUserId;
      private Long auditUserId;
      private Integer auditStatus;
      private LocalDateTime auditTime;

      ProjectWasteProductMainBuilder() {
      }

      @JsonProperty("id")
      public ProjectWasteProductMain.ProjectWasteProductMainBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      @Deprecated
      public ProjectWasteProductMain.ProjectWasteProductMainBuilder handleMethod(final Integer handleMethod) {
         this.handleMethod = handleMethod;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder wasteHandleMethod(final Integer wasteHandleMethod) {
         this.wasteHandleMethod = wasteHandleMethod;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder useProjectId(final Long useProjectId) {
         this.useProjectId = useProjectId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder auditRemark(final String auditRemark) {
         this.auditRemark = auditRemark;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectWasteProductMain.ProjectWasteProductMainBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectWasteProductMain build() {
         return new ProjectWasteProductMain(
            this.id,
            this.serialNumber,
            this.projectId,
            this.productType,
            this.quantity,
            this.totalAmount,
            this.handleMethod,
            this.wasteHandleMethod,
            this.useProjectId,
            this.branchCompanyId,
            this.contractWasteId,
            this.purchaser,
            this.remark,
            this.auditRemark,
            this.createUserId,
            this.auditUserId,
            this.auditStatus,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ProjectWasteProductMain.ProjectWasteProductMainBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", totalAmount="
            + this.totalAmount
            + ", handleMethod="
            + this.handleMethod
            + ", wasteHandleMethod="
            + this.wasteHandleMethod
            + ", useProjectId="
            + this.useProjectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", contractWasteId="
            + this.contractWasteId
            + ", purchaser="
            + this.purchaser
            + ", remark="
            + this.remark
            + ", auditRemark="
            + this.auditRemark
            + ", createUserId="
            + this.createUserId
            + ", auditUserId="
            + this.auditUserId
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
