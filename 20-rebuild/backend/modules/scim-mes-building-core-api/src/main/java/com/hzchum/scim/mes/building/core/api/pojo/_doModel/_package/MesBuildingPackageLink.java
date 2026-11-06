package com.hzchum.scim.mes.building.core.api.pojo._doModel._package;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPackageLink对象", description = "包的产品关联表")
@Entity
@TableName("mes_building_package_link")
@Table(
   name = "mes_building_package_link",
   indexes = {
         @Index(name = "monomerId", columnList = "monomer_id"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date")
   }
)
public class MesBuildingPackageLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体Id", notes = "单体Id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体Id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'")
   private Long planId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   @JsonProperty("packageId")
   @JSONField(name = "packageId")
   @TableField("package_id")
   @Column(name = "package_id", columnDefinition = "bigint(20)  COMMENT '包id'", nullable = false)
   private Long packageId;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id", notes = "出入库id")
   @JsonProperty("warehouseRecordId")
   @JSONField(name = "warehouseRecordId")
   @TableField("warehouse_record_id")
   @Column(name = "warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '出入库id'", nullable = false)
   private Long warehouseRecordId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) COMMENT '数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "warehouseType")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int(11) default '0' COMMENT ''", nullable = false)
   private Integer warehouseType;
   @ApiModelProperty(name = "inYearMonthDayDate")
   @JsonProperty("inYearMonthDayDate")
   @JSONField(name = "inYearMonthDayDate")
   @TableField(value = "in_year_month_day_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_day_date", columnDefinition = "varchar(564) COMMENT '日期(年-月-日)'")
   private String inYearMonthDayDate;
   @ApiModelProperty(name = "inYearMonthDate")
   @JsonProperty("inYearMonthDate")
   @JSONField(name = "inYearMonthDate")
   @TableField(value = "in_year_month_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_date", columnDefinition = "varchar(564) COMMENT '日期(年-月)'")
   private String inYearMonthDate;
   @ApiModelProperty(name = "createUserNames")
   @JsonProperty("createUserNames")
   @JSONField(name = "createUserNames")
   @TableField("create_user_names")
   @Column(name = "create_user_names", columnDefinition = "varchar(1024)  COMMENT ''", nullable = true)
   private String createUserNames;

   public static MesBuildingPackageLink.MesBuildingPackageLinkBuilder builder() {
      return new MesBuildingPackageLink.MesBuildingPackageLinkBuilder();
   }

   public MesBuildingPackageLink() {
   }

   public MesBuildingPackageLink(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long planId,
      final Long areaBatchId,
      final Long workshopId,
      final Long packageId,
      final Long warehouseRecordId,
      final Long productId,
      final Integer productType,
      final BigDecimal quantity,
      final Integer warehouseType,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final String createUserNames
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.planId = planId;
      this.areaBatchId = areaBatchId;
      this.workshopId = workshopId;
      this.packageId = packageId;
      this.warehouseRecordId = warehouseRecordId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.warehouseType = warehouseType;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.createUserNames = createUserNames;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   public String getCreateUserNames() {
      return this.createUserNames;
   }

   @JsonProperty("id")
   public MesBuildingPackageLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingPackageLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingPackageLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingPackageLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("planId")
   public MesBuildingPackageLink setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingPackageLink setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingPackageLink setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("packageId")
   public MesBuildingPackageLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("warehouseRecordId")
   public MesBuildingPackageLink setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingPackageLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingPackageLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPackageLink setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("warehouseType")
   public MesBuildingPackageLink setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingPackageLink setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingPackageLink setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("createUserNames")
   public MesBuildingPackageLink setCreateUserNames(final String createUserNames) {
      this.createUserNames = createUserNames;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageLink(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", packageId="
         + this.getPackageId()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ", createUserNames="
         + this.getCreateUserNames()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageLink)) {
         return false;
      }

      MesBuildingPackageLink other = (MesBuildingPackageLink)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$planId = this.getPlanId();
                  Object other$planId = other.getPlanId();
                  if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                     Object this$areaBatchId = this.getAreaBatchId();
                     Object other$areaBatchId = other.getAreaBatchId();
                     if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$packageId = this.getPackageId();
                           Object other$packageId = other.getPackageId();
                           if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                              Object this$warehouseRecordId = this.getWarehouseRecordId();
                              Object other$warehouseRecordId = other.getWarehouseRecordId();
                              if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$productType = this.getProductType();
                                    Object other$productType = other.getProductType();
                                    if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                       Object this$warehouseType = this.getWarehouseType();
                                       Object other$warehouseType = other.getWarehouseType();
                                       if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                             Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                             if (this$inYearMonthDayDate == null
                                                ? other$inYearMonthDayDate == null
                                                : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)) {
                                                Object this$inYearMonthDate = this.getInYearMonthDate();
                                                Object other$inYearMonthDate = other.getInYearMonthDate();
                                                if (this$inYearMonthDate == null
                                                   ? other$inYearMonthDate == null
                                                   : this$inYearMonthDate.equals(other$inYearMonthDate)) {
                                                   Object this$createUserNames = this.getCreateUserNames();
                                                   Object other$createUserNames = other.getCreateUserNames();
                                                   return this$createUserNames == null
                                                      ? other$createUserNames == null
                                                      : this$createUserNames.equals(other$createUserNames);
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
      return other instanceof MesBuildingPackageLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      result = result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
      Object $createUserNames = this.getCreateUserNames();
      return result * 59 + ($createUserNames == null ? 43 : $createUserNames.hashCode());
   }

   public static class MesBuildingPackageLinkBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long planId;
      private Long areaBatchId;
      private Long workshopId;
      private Long packageId;
      private Long warehouseRecordId;
      private Long productId;
      private Integer productType;
      private BigDecimal quantity;
      private Integer warehouseType;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private String createUserNames;

      MesBuildingPackageLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("planId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("packageId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("warehouseRecordId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("warehouseType")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("createUserNames")
      public MesBuildingPackageLink.MesBuildingPackageLinkBuilder createUserNames(final String createUserNames) {
         this.createUserNames = createUserNames;
         return this;
      }

      public MesBuildingPackageLink build() {
         return new MesBuildingPackageLink(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.planId,
            this.areaBatchId,
            this.workshopId,
            this.packageId,
            this.warehouseRecordId,
            this.productId,
            this.productType,
            this.quantity,
            this.warehouseType,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.createUserNames
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPackageLink.MesBuildingPackageLinkBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", areaBatchId="
            + this.areaBatchId
            + ", workshopId="
            + this.workshopId
            + ", packageId="
            + this.packageId
            + ", warehouseRecordId="
            + this.warehouseRecordId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", warehouseType="
            + this.warehouseType
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ", createUserNames="
            + this.createUserNames
            + ")";
      }
   }
}
