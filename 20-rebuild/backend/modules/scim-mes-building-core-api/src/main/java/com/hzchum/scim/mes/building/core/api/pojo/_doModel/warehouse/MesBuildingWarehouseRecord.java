package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWarehouseRecord对象", description = "出入库记录表")
@Entity
@TableName("mes_building_warehouse_record")
@Table(
   name = "mes_building_warehouse_record",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id, number"),
         @Index(name = "type_status_index", columnList = "`type`, `status`"),
         @Index(name = "projectId_index", columnList = "project_id, monomer_id, area_id"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date"),
         @Index(name = "complete_id", columnList = "complete_id"),
         @Index(name = "productAndType_index", columnList = "product_id,product_type,number,type")
   }
)
public class MesBuildingWarehouseRecord extends BaseEntity<Long> {
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
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型 2结构4围护8配套件", notes = "产品类型 2结构4围护8配套件")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 2结构4围护8配套件'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "type", value = "出入库类型 1入库2出库", notes = "出入库类型 1入库2出库")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '0' COMMENT '出入库类型 1入库2出库'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "出入库数量", notes = "出入库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '出入库数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) default '0' COMMENT '操作人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '操作人名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "completeId")
   @JsonProperty("completeId")
   @JSONField(name = "completeId")
   @TableField("complete_id")
   @Column(name = "complete_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = true)
   private Long completeId;
   @ApiModelProperty(name = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField(value = "number", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '一物一码号'", nullable = true)
   private Integer number;
   @ApiModelProperty(name = "status")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态 1 入库 2 打包 4装车 8 发运 '", nullable = false)
   private Integer status;
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

   public static MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder builder() {
      return new MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder();
   }

   public MesBuildingWarehouseRecord() {
   }

   public MesBuildingWarehouseRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final BigDecimal quantity,
      final Long userId,
      final String userName,
      final Long completeId,
      final Integer number,
      final Integer status,
      final Integer warehouseType,
      final String inYearMonthDayDate,
      final String inYearMonthDate
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productId = productId;
      this.productType = productType;
      this.type = type;
      this.quantity = quantity;
      this.userId = userId;
      this.userName = userName;
      this.completeId = completeId;
      this.number = number;
      this.status = status;
      this.warehouseType = warehouseType;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getCompleteId() {
      return this.completeId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getStatus() {
      return this.status;
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

   @JsonProperty("id")
   public MesBuildingWarehouseRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingWarehouseRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingWarehouseRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingWarehouseRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingWarehouseRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("planId")
   public MesBuildingWarehouseRecord setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingWarehouseRecord setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingWarehouseRecord setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingWarehouseRecord setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingWarehouseRecord setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingWarehouseRecord setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingWarehouseRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingWarehouseRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingWarehouseRecord setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("completeId")
   public MesBuildingWarehouseRecord setCompleteId(final Long completeId) {
      this.completeId = completeId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingWarehouseRecord setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingWarehouseRecord setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("warehouseType")
   public MesBuildingWarehouseRecord setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingWarehouseRecord setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingWarehouseRecord setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", completeId="
         + this.getCompleteId()
         + ", number="
         + this.getNumber()
         + ", status="
         + this.getStatus()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseRecord)) {
         return false;
      }

      MesBuildingWarehouseRecord other = (MesBuildingWarehouseRecord)o;
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
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$productType = this.getProductType();
                                 Object other$productType = other.getProductType();
                                 if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                    Object this$type = this.getType();
                                    Object other$type = other.getType();
                                    if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$completeId = this.getCompleteId();
                                          Object other$completeId = other.getCompleteId();
                                          if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                                             Object this$number = this.getNumber();
                                             Object other$number = other.getNumber();
                                             if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                Object this$status = this.getStatus();
                                                Object other$status = other.getStatus();
                                                if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                   Object this$warehouseType = this.getWarehouseType();
                                                   Object other$warehouseType = other.getWarehouseType();
                                                   if (this$warehouseType == null
                                                      ? other$warehouseType == null
                                                      : this$warehouseType.equals(other$warehouseType)) {
                                                      Object this$quantity = this.getQuantity();
                                                      Object other$quantity = other.getQuantity();
                                                      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                         Object this$userName = this.getUserName();
                                                         Object other$userName = other.getUserName();
                                                         if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                            Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                            Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                            if (this$inYearMonthDayDate == null
                                                               ? other$inYearMonthDayDate == null
                                                               : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)) {
                                                               Object this$inYearMonthDate = this.getInYearMonthDate();
                                                               Object other$inYearMonthDate = other.getInYearMonthDate();
                                                               return this$inYearMonthDate == null
                                                                  ? other$inYearMonthDate == null
                                                                  : this$inYearMonthDate.equals(other$inYearMonthDate);
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
      return other instanceof MesBuildingWarehouseRecord;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      return result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
   }

   public static class MesBuildingWarehouseRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private BigDecimal quantity;
      private Long userId;
      private String userName;
      private Long completeId;
      private Integer number;
      private Integer status;
      private Integer warehouseType;
      private String inYearMonthDayDate;
      private String inYearMonthDate;

      MesBuildingWarehouseRecordBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("planId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("completeId")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("warehouseType")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      public MesBuildingWarehouseRecord build() {
         return new MesBuildingWarehouseRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productId,
            this.productType,
            this.type,
            this.quantity,
            this.userId,
            this.userName,
            this.completeId,
            this.number,
            this.status,
            this.warehouseType,
            this.inYearMonthDayDate,
            this.inYearMonthDate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseRecord.MesBuildingWarehouseRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", completeId="
            + this.completeId
            + ", number="
            + this.number
            + ", status="
            + this.status
            + ", warehouseType="
            + this.warehouseType
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ")";
      }
   }
}
