package com.hzchum.scim.plan.core.api.pojo._do.check;

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
import javax.persistence.Table;

@ApiModel(value = "MesTechInventoryOperation对象", description = "清单操作记录表")
@Entity
@TableName("mes_tech_inventory_operation")
@Table(name = "mes_tech_inventory_operation")
public class MesTechInventoryOperation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "importType", value = "导入类型: 1增量导入 2覆盖导入 4变更导入")
   @TableField("import_type")
   @Column(name = "import_type", columnDefinition = "int(11) comment '导入类型: 1增量导入 2覆盖导入'", nullable = false)
   private Integer importType;
   @ApiModelProperty(name = "operationTypeEnum", value = "操作类型: 1清单导入 2清单变更")
   @TableField("operation_type_enum")
   @Column(name = "operation_type_enum", columnDefinition = "int(11) comment '操作类型: 1清导入单 2清单变更'", nullable = false)
   private Integer operationTypeEnum;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁 4围护 8 网架 16配套制品")
   @TableField("building_type")
   @Column(name = "building_type", columnDefinition = "int(11) comment '建筑类型 1建钢 2桥梁 4围护 8网架 16配套制品'", nullable = false)
   private Integer buildingType;
   @ApiModelProperty(name = "totalWeight", value = "总重量")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,4) default 0.0 comment '总重量'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "importUserId", value = "导入人")
   @JsonProperty("importUserId")
   @JSONField(name = "importUserId")
   @TableField("import_user_id")
   @Column(name = "import_user_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = true)
   private Long importUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("createUserName")
   @JSONField(name = "createUserName")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "inventoryReviewedEnum", value = "审核状态", notes = "审核状态")
   @JsonProperty("inventoryReviewedEnum")
   @JSONField(name = "inventoryReviewedEnum")
   @TableField("inventory_reviewed_enum")
   @Column(name = "inventory_reviewed_enum", columnDefinition = "int(11) default '2' COMMENT '审核状态'", nullable = false)
   private Integer inventoryReviewedEnum;
   @ApiModelProperty(name = "reviewedBy", value = "审核人id", notes = "审核人id")
   @JsonProperty("reviewedBy")
   @JSONField(name = "reviewedBy")
   @TableField("reviewed_by")
   @Column(name = "reviewed_by", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long reviewedBy;
   @ApiModelProperty(name = "reviewedTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewedTime")
   @JSONField(name = "reviewedTime")
   @TableField("reviewed_time")
   @Column(name = "reviewed_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewedTime;
   @ApiModelProperty(name = "reviewedName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewedName")
   @JSONField(name = "reviewedName")
   @TableField("reviewed_name")
   @Column(name = "reviewed_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewedName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "batchNumber", value = "导入批次编号", notes = "导入批次编号")
   @JsonProperty("batchNumber")
   @JSONField(name = "batchNumber")
   @TableField("batch_number")
   @Column(name = "batch_number", columnDefinition = "varchar(255)  COMMENT '导入批次编号'", nullable = true)
   private String batchNumber;
   @ApiModelProperty(name = "type", value = "导入类型: 1建刚桥梁网架 2 围护")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' COMMENT '导入类型: 1建刚桥梁网架 2 围护'", nullable = false)
   private Integer type;

   public static MesTechInventoryOperation.MesTechInventoryOperationBuilder builder() {
      return new MesTechInventoryOperation.MesTechInventoryOperationBuilder();
   }

   public MesTechInventoryOperation() {
   }

   public MesTechInventoryOperation(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Integer importType,
      final Integer operationTypeEnum,
      final Integer buildingType,
      final BigDecimal totalWeight,
      final Long importUserId,
      final String createUserName,
      final Integer inventoryReviewedEnum,
      final Long reviewedBy,
      final LocalDateTime reviewedTime,
      final String reviewedName,
      final String remark,
      final String batchNumber,
      final Integer type
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.importType = importType;
      this.operationTypeEnum = operationTypeEnum;
      this.buildingType = buildingType;
      this.totalWeight = totalWeight;
      this.importUserId = importUserId;
      this.createUserName = createUserName;
      this.inventoryReviewedEnum = inventoryReviewedEnum;
      this.reviewedBy = reviewedBy;
      this.reviewedTime = reviewedTime;
      this.reviewedName = reviewedName;
      this.remark = remark;
      this.batchNumber = batchNumber;
      this.type = type;
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

   public Integer getImportType() {
      return this.importType;
   }

   public Integer getOperationTypeEnum() {
      return this.operationTypeEnum;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Long getImportUserId() {
      return this.importUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getInventoryReviewedEnum() {
      return this.inventoryReviewedEnum;
   }

   public Long getReviewedBy() {
      return this.reviewedBy;
   }

   public LocalDateTime getReviewedTime() {
      return this.reviewedTime;
   }

   public String getReviewedName() {
      return this.reviewedName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public MesTechInventoryOperation setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesTechInventoryOperation setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesTechInventoryOperation setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesTechInventoryOperation setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesTechInventoryOperation setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesTechInventoryOperation setImportType(final Integer importType) {
      this.importType = importType;
      return this;
   }

   public MesTechInventoryOperation setOperationTypeEnum(final Integer operationTypeEnum) {
      this.operationTypeEnum = operationTypeEnum;
      return this;
   }

   public MesTechInventoryOperation setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
      return this;
   }

   public MesTechInventoryOperation setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("importUserId")
   public MesTechInventoryOperation setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
      return this;
   }

   @JsonProperty("createUserName")
   public MesTechInventoryOperation setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @JsonProperty("inventoryReviewedEnum")
   public MesTechInventoryOperation setInventoryReviewedEnum(final Integer inventoryReviewedEnum) {
      this.inventoryReviewedEnum = inventoryReviewedEnum;
      return this;
   }

   @JsonProperty("reviewedBy")
   public MesTechInventoryOperation setReviewedBy(final Long reviewedBy) {
      this.reviewedBy = reviewedBy;
      return this;
   }

   @JsonProperty("reviewedTime")
   public MesTechInventoryOperation setReviewedTime(final LocalDateTime reviewedTime) {
      this.reviewedTime = reviewedTime;
      return this;
   }

   @JsonProperty("reviewedName")
   public MesTechInventoryOperation setReviewedName(final String reviewedName) {
      this.reviewedName = reviewedName;
      return this;
   }

   @JsonProperty("remark")
   public MesTechInventoryOperation setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("batchNumber")
   public MesTechInventoryOperation setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
   }

   public MesTechInventoryOperation setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesTechInventoryOperation(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", importType="
         + this.getImportType()
         + ", operationTypeEnum="
         + this.getOperationTypeEnum()
         + ", buildingType="
         + this.getBuildingType()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", importUserId="
         + this.getImportUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", inventoryReviewedEnum="
         + this.getInventoryReviewedEnum()
         + ", reviewedBy="
         + this.getReviewedBy()
         + ", reviewedTime="
         + this.getReviewedTime()
         + ", reviewedName="
         + this.getReviewedName()
         + ", remark="
         + this.getRemark()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTechInventoryOperation)) {
         return false;
      }

      MesTechInventoryOperation other = (MesTechInventoryOperation)o;
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
                     Object this$importType = this.getImportType();
                     Object other$importType = other.getImportType();
                     if (this$importType == null ? other$importType == null : this$importType.equals(other$importType)) {
                        Object this$operationTypeEnum = this.getOperationTypeEnum();
                        Object other$operationTypeEnum = other.getOperationTypeEnum();
                        if (this$operationTypeEnum == null ? other$operationTypeEnum == null : this$operationTypeEnum.equals(other$operationTypeEnum)) {
                           Object this$buildingType = this.getBuildingType();
                           Object other$buildingType = other.getBuildingType();
                           if (this$buildingType == null ? other$buildingType == null : this$buildingType.equals(other$buildingType)) {
                              Object this$importUserId = this.getImportUserId();
                              Object other$importUserId = other.getImportUserId();
                              if (this$importUserId == null ? other$importUserId == null : this$importUserId.equals(other$importUserId)) {
                                 Object this$inventoryReviewedEnum = this.getInventoryReviewedEnum();
                                 Object other$inventoryReviewedEnum = other.getInventoryReviewedEnum();
                                 if (this$inventoryReviewedEnum == null
                                    ? other$inventoryReviewedEnum == null
                                    : this$inventoryReviewedEnum.equals(other$inventoryReviewedEnum)) {
                                    Object this$reviewedBy = this.getReviewedBy();
                                    Object other$reviewedBy = other.getReviewedBy();
                                    if (this$reviewedBy == null ? other$reviewedBy == null : this$reviewedBy.equals(other$reviewedBy)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$totalWeight = this.getTotalWeight();
                                          Object other$totalWeight = other.getTotalWeight();
                                          if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                             Object this$createUserName = this.getCreateUserName();
                                             Object other$createUserName = other.getCreateUserName();
                                             if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                                Object this$reviewedTime = this.getReviewedTime();
                                                Object other$reviewedTime = other.getReviewedTime();
                                                if (this$reviewedTime == null ? other$reviewedTime == null : this$reviewedTime.equals(other$reviewedTime)) {
                                                   Object this$reviewedName = this.getReviewedName();
                                                   Object other$reviewedName = other.getReviewedName();
                                                   if (this$reviewedName == null ? other$reviewedName == null : this$reviewedName.equals(other$reviewedName)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$batchNumber = this.getBatchNumber();
                                                         Object other$batchNumber = other.getBatchNumber();
                                                         return this$batchNumber == null
                                                            ? other$batchNumber == null
                                                            : this$batchNumber.equals(other$batchNumber);
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
      return other instanceof MesTechInventoryOperation;
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
      Object $importType = this.getImportType();
      result = result * 59 + ($importType == null ? 43 : $importType.hashCode());
      Object $operationTypeEnum = this.getOperationTypeEnum();
      result = result * 59 + ($operationTypeEnum == null ? 43 : $operationTypeEnum.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $inventoryReviewedEnum = this.getInventoryReviewedEnum();
      result = result * 59 + ($inventoryReviewedEnum == null ? 43 : $inventoryReviewedEnum.hashCode());
      Object $reviewedBy = this.getReviewedBy();
      result = result * 59 + ($reviewedBy == null ? 43 : $reviewedBy.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $reviewedTime = this.getReviewedTime();
      result = result * 59 + ($reviewedTime == null ? 43 : $reviewedTime.hashCode());
      Object $reviewedName = this.getReviewedName();
      result = result * 59 + ($reviewedName == null ? 43 : $reviewedName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $batchNumber = this.getBatchNumber();
      return result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
   }

   public static class MesTechInventoryOperationBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Integer importType;
      private Integer operationTypeEnum;
      private Integer buildingType;
      private BigDecimal totalWeight;
      private Long importUserId;
      private String createUserName;
      private Integer inventoryReviewedEnum;
      private Long reviewedBy;
      private LocalDateTime reviewedTime;
      private String reviewedName;
      private String remark;
      private String batchNumber;
      private Integer type;

      MesTechInventoryOperationBuilder() {
      }

      @JsonProperty("id")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesTechInventoryOperation.MesTechInventoryOperationBuilder importType(final Integer importType) {
         this.importType = importType;
         return this;
      }

      public MesTechInventoryOperation.MesTechInventoryOperationBuilder operationTypeEnum(final Integer operationTypeEnum) {
         this.operationTypeEnum = operationTypeEnum;
         return this;
      }

      public MesTechInventoryOperation.MesTechInventoryOperationBuilder buildingType(final Integer buildingType) {
         this.buildingType = buildingType;
         return this;
      }

      public MesTechInventoryOperation.MesTechInventoryOperationBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("importUserId")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder importUserId(final Long importUserId) {
         this.importUserId = importUserId;
         return this;
      }

      @JsonProperty("createUserName")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      @JsonProperty("inventoryReviewedEnum")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder inventoryReviewedEnum(final Integer inventoryReviewedEnum) {
         this.inventoryReviewedEnum = inventoryReviewedEnum;
         return this;
      }

      @JsonProperty("reviewedBy")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder reviewedBy(final Long reviewedBy) {
         this.reviewedBy = reviewedBy;
         return this;
      }

      @JsonProperty("reviewedTime")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder reviewedTime(final LocalDateTime reviewedTime) {
         this.reviewedTime = reviewedTime;
         return this;
      }

      @JsonProperty("reviewedName")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder reviewedName(final String reviewedName) {
         this.reviewedName = reviewedName;
         return this;
      }

      @JsonProperty("remark")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("batchNumber")
      public MesTechInventoryOperation.MesTechInventoryOperationBuilder batchNumber(final String batchNumber) {
         this.batchNumber = batchNumber;
         return this;
      }

      public MesTechInventoryOperation.MesTechInventoryOperationBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesTechInventoryOperation build() {
         return new MesTechInventoryOperation(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.importType,
            this.operationTypeEnum,
            this.buildingType,
            this.totalWeight,
            this.importUserId,
            this.createUserName,
            this.inventoryReviewedEnum,
            this.reviewedBy,
            this.reviewedTime,
            this.reviewedName,
            this.remark,
            this.batchNumber,
            this.type
         );
      }

      @Override
      public String toString() {
         return "MesTechInventoryOperation.MesTechInventoryOperationBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", importType="
            + this.importType
            + ", operationTypeEnum="
            + this.operationTypeEnum
            + ", buildingType="
            + this.buildingType
            + ", totalWeight="
            + this.totalWeight
            + ", importUserId="
            + this.importUserId
            + ", createUserName="
            + this.createUserName
            + ", inventoryReviewedEnum="
            + this.inventoryReviewedEnum
            + ", reviewedBy="
            + this.reviewedBy
            + ", reviewedTime="
            + this.reviewedTime
            + ", reviewedName="
            + this.reviewedName
            + ", remark="
            + this.remark
            + ", batchNumber="
            + this.batchNumber
            + ", type="
            + this.type
            + ")";
      }
   }
}
