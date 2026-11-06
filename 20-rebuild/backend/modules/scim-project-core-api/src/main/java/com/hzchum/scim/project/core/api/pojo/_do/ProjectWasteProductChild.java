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
@ApiModel(value = "ProjectWasteProductChild对象", description = "废品库子表")
@Table(appliesTo = "project_waste_product_child", comment = "废品库子表 ")
@TableName("project_waste_product_child")
public class ProjectWasteProductChild extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'", nullable = true)
   private Long planId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mainId", value = "主表id", notes = "主表id")
   @TableField("main_id")
   @Column(name = "main_id", columnDefinition = "bigint(20)  COMMENT '主表id'", nullable = false)
   private Long mainId;
   @ApiModelProperty(name = "mesBuildingWarehouseRecordId", value = "入库记录id", notes = "入库记录id")
   @TableField("mes_building_warehouse_record_id")
   @Column(name = "mes_building_warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '入库记录id'", nullable = false)
   private Long mesBuildingWarehouseRecordId;
   @ApiModelProperty(name = "mesBuildingReturnWarehouseRecordId", value = "制成品退货记录id", notes = "制成品退货记录id")
   @TableField("mes_building_return_warehouse_record_id")
   @Column(name = "mes_building_return_warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '制成品退货记录id'", nullable = false)
   private Long mesBuildingReturnWarehouseRecordId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "useProjectId", value = "利用或者报废项目", notes = "利用或者报废项目")
   @TableField("use_project_id")
   @Column(name = "use_project_id", columnDefinition = "bigint(20)  COMMENT '利用或者报废项目'", nullable = true)
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
   @ApiModelProperty(name = "wasteHandleMethod", value = "废品处理方式 1二次利用 2废品出售 ", notes = "废品处理方式 1二次利用 2废品出售")
   @TableField("waste_handle_method")
   @Column(name = "waste_handle_method", columnDefinition = "tinyint(1) default 0 COMMENT '废品处理方式 1二次利用 2废品出售'", nullable = false)
   private Integer wasteHandleMethod;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "tinyint(1) default 1 COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;

   public static ProjectWasteProductChild.ProjectWasteProductChildBuilder builder() {
      return new ProjectWasteProductChild.ProjectWasteProductChildBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getMainId() {
      return this.mainId;
   }

   public Long getMesBuildingWarehouseRecordId() {
      return this.mesBuildingWarehouseRecordId;
   }

   public Long getMesBuildingReturnWarehouseRecordId() {
      return this.mesBuildingReturnWarehouseRecordId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Integer getWasteHandleMethod() {
      return this.wasteHandleMethod;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMainId(final Long mainId) {
      this.mainId = mainId;
   }

   public void setMesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
   }

   public void setMesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   public void setWasteHandleMethod(final Integer wasteHandleMethod) {
      this.wasteHandleMethod = wasteHandleMethod;
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

      if (!(o instanceof ProjectWasteProductChild)) {
         return false;
      }

      ProjectWasteProductChild other = (ProjectWasteProductChild)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$planId = this.getPlanId();
                  Object other$planId = other.getPlanId();
                  if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$mainId = this.getMainId();
                        Object other$mainId = other.getMainId();
                        if (this$mainId == null ? other$mainId == null : this$mainId.equals(other$mainId)) {
                           Object this$mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
                           Object other$mesBuildingWarehouseRecordId = other.getMesBuildingWarehouseRecordId();
                           if (this$mesBuildingWarehouseRecordId == null
                              ? other$mesBuildingWarehouseRecordId == null
                              : this$mesBuildingWarehouseRecordId.equals(other$mesBuildingWarehouseRecordId)) {
                              Object this$mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
                              Object other$mesBuildingReturnWarehouseRecordId = other.getMesBuildingReturnWarehouseRecordId();
                              if (this$mesBuildingReturnWarehouseRecordId == null
                                 ? other$mesBuildingReturnWarehouseRecordId == null
                                 : this$mesBuildingReturnWarehouseRecordId.equals(other$mesBuildingReturnWarehouseRecordId)) {
                                 Object this$productType = this.getProductType();
                                 Object other$productType = other.getProductType();
                                 if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                    Object this$useProjectId = this.getUseProjectId();
                                    Object other$useProjectId = other.getUseProjectId();
                                    if (this$useProjectId == null ? other$useProjectId == null : this$useProjectId.equals(other$useProjectId)) {
                                       Object this$branchCompanyId = this.getBranchCompanyId();
                                       Object other$branchCompanyId = other.getBranchCompanyId();
                                       if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                          Object this$contractWasteId = this.getContractWasteId();
                                          Object other$contractWasteId = other.getContractWasteId();
                                          if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)
                                             )
                                           {
                                             Object this$wasteHandleMethod = this.getWasteHandleMethod();
                                             Object other$wasteHandleMethod = other.getWasteHandleMethod();
                                             if (this$wasteHandleMethod == null
                                                ? other$wasteHandleMethod == null
                                                : this$wasteHandleMethod.equals(other$wasteHandleMethod)) {
                                                Object this$auditStatus = this.getAuditStatus();
                                                Object other$auditStatus = other.getAuditStatus();
                                                if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$purchaser = this.getPurchaser();
                                                      Object other$purchaser = other.getPurchaser();
                                                      if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
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
      return other instanceof ProjectWasteProductChild;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $mainId = this.getMainId();
      result = result * 59 + ($mainId == null ? 43 : $mainId.hashCode());
      Object $mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
      result = result * 59 + ($mesBuildingWarehouseRecordId == null ? 43 : $mesBuildingWarehouseRecordId.hashCode());
      Object $mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
      result = result * 59 + ($mesBuildingReturnWarehouseRecordId == null ? 43 : $mesBuildingReturnWarehouseRecordId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $useProjectId = this.getUseProjectId();
      result = result * 59 + ($useProjectId == null ? 43 : $useProjectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $wasteHandleMethod = this.getWasteHandleMethod();
      result = result * 59 + ($wasteHandleMethod == null ? 43 : $wasteHandleMethod.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductChild(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", mainId="
         + this.getMainId()
         + ", mesBuildingWarehouseRecordId="
         + this.getMesBuildingWarehouseRecordId()
         + ", mesBuildingReturnWarehouseRecordId="
         + this.getMesBuildingReturnWarehouseRecordId()
         + ", productType="
         + this.getProductType()
         + ", useProjectId="
         + this.getUseProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", purchaser="
         + this.getPurchaser()
         + ", wasteHandleMethod="
         + this.getWasteHandleMethod()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public ProjectWasteProductChild() {
   }

   public ProjectWasteProductChild(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long planId,
      final Long productId,
      final BigDecimal quantity,
      final Long mainId,
      final Long mesBuildingWarehouseRecordId,
      final Long mesBuildingReturnWarehouseRecordId,
      final Integer productType,
      final Long useProjectId,
      final Long branchCompanyId,
      final Long contractWasteId,
      final String purchaser,
      final Integer wasteHandleMethod,
      final Integer auditStatus,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.planId = planId;
      this.productId = productId;
      this.quantity = quantity;
      this.mainId = mainId;
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
      this.productType = productType;
      this.useProjectId = useProjectId;
      this.branchCompanyId = branchCompanyId;
      this.contractWasteId = contractWasteId;
      this.purchaser = purchaser;
      this.wasteHandleMethod = wasteHandleMethod;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
   }

   public static class ProjectWasteProductChildBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long planId;
      private Long productId;
      private BigDecimal quantity;
      private Long mainId;
      private Long mesBuildingWarehouseRecordId;
      private Long mesBuildingReturnWarehouseRecordId;
      private Integer productType;
      private Long useProjectId;
      private Long branchCompanyId;
      private Long contractWasteId;
      private String purchaser;
      private Integer wasteHandleMethod;
      private Integer auditStatus;
      private LocalDateTime auditTime;

      ProjectWasteProductChildBuilder() {
      }

      @JsonProperty("id")
      public ProjectWasteProductChild.ProjectWasteProductChildBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder mainId(final Long mainId) {
         this.mainId = mainId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder mesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
         this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder mesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
         this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder useProjectId(final Long useProjectId) {
         this.useProjectId = useProjectId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder wasteHandleMethod(final Integer wasteHandleMethod) {
         this.wasteHandleMethod = wasteHandleMethod;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectWasteProductChild.ProjectWasteProductChildBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectWasteProductChild build() {
         return new ProjectWasteProductChild(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.planId,
            this.productId,
            this.quantity,
            this.mainId,
            this.mesBuildingWarehouseRecordId,
            this.mesBuildingReturnWarehouseRecordId,
            this.productType,
            this.useProjectId,
            this.branchCompanyId,
            this.contractWasteId,
            this.purchaser,
            this.wasteHandleMethod,
            this.auditStatus,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ProjectWasteProductChild.ProjectWasteProductChildBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", mainId="
            + this.mainId
            + ", mesBuildingWarehouseRecordId="
            + this.mesBuildingWarehouseRecordId
            + ", mesBuildingReturnWarehouseRecordId="
            + this.mesBuildingReturnWarehouseRecordId
            + ", productType="
            + this.productType
            + ", useProjectId="
            + this.useProjectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", contractWasteId="
            + this.contractWasteId
            + ", purchaser="
            + this.purchaser
            + ", wasteHandleMethod="
            + this.wasteHandleMethod
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
