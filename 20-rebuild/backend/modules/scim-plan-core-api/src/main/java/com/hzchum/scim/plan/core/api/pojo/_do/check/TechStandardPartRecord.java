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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechStandardPartRecord对象", description = "标准件(配套件)审核表")
@Entity
@TableName("tech_standard_part_record")
@Table(name = "tech_standard_part_record")
@org.hibernate.annotations.Table(appliesTo = "tech_standard_part_record", comment = "标准件(配套件)审核表")
public class TechStandardPartRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次id", notes = "批次id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单操作记录表Id")
   @JsonProperty("inventoryOperationId")
   @JSONField(name = "inventoryOperationId")
   @TableField("inventory_operation_id")
   @Column(name = "inventory_operation_id", columnDefinition = "bigint(20)  COMMENT '清单操作记录表Id'", nullable = false)
   private Long inventoryOperationId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) DEFAULT NULL comment '围护分类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件'")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) DEFAULT NULL comment '围护计划表id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2  COMMENT '关联类型 2构件 4围护'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   @TableField("use_property")
   @Column(name = "use_property", columnDefinition = "int(11)  COMMENT '使用属性 1工地 2工厂'")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(16)  COMMENT '计量单位'", nullable = false)
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(18,4) DEFAULT 0 COMMENT '核算量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(16)  COMMENT '单位'")
   private String accountingUnit;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   @TableField("bool_weight_type_enum")
   @Column(name = "bool_weight_type_enum", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '(核算单位)是否重量类型 1是 0否'", nullable = false)
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "boolArtifactImport", value = "是否关联清单 true是 false否", notes = "是否关联清单 true是 false否")
   @TableField("bool_artifact_import")
   @Column(name = "bool_artifact_import", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否构件清单导入 1是 0否'", nullable = false)
   private Boolean boolArtifactImport;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传用户Id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '上传用户Id'", nullable = false)
   private Long userId;
   @ApiModelProperty("标准件(配套件)类型 32 标准件(配套件)")
   @TableField("standard_part_type")
   @Column(name = "standard_part_type", columnDefinition = "int(11) default 32 comment '标准件(配套件)类型'", nullable = false)
   private Integer standardPartType;

   public static TechStandardPartRecord.TechStandardPartRecordBuilder builder() {
      return new TechStandardPartRecord.TechStandardPartRecordBuilder();
   }

   public TechStandardPartRecord() {
   }

   public TechStandardPartRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long inventoryOperationId,
      final String name,
      final Integer category,
      final Long enclosurePlanId,
      final Integer relationType,
      final Integer useProperty,
      final String specification,
      final Integer quantity,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final Boolean boolWeightTypeEnum,
      final Boolean boolArtifactImport,
      final String remark,
      final Long userId,
      final Integer standardPartType
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.inventoryOperationId = inventoryOperationId;
      this.name = name;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.relationType = relationType;
      this.useProperty = useProperty;
      this.specification = specification;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      this.boolArtifactImport = boolArtifactImport;
      this.remark = remark;
      this.userId = userId;
      this.standardPartType = standardPartType;
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

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public Boolean getBoolArtifactImport() {
      return this.boolArtifactImport;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getStandardPartType() {
      return this.standardPartType;
   }

   public TechStandardPartRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechStandardPartRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechStandardPartRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechStandardPartRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechStandardPartRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechStandardPartRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechStandardPartRecord setName(final String name) {
      this.name = name;
      return this;
   }

   public TechStandardPartRecord setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public TechStandardPartRecord setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public TechStandardPartRecord setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public TechStandardPartRecord setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public TechStandardPartRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechStandardPartRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechStandardPartRecord setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public TechStandardPartRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public TechStandardPartRecord setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public TechStandardPartRecord setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      return this;
   }

   public TechStandardPartRecord setBoolArtifactImport(final Boolean boolArtifactImport) {
      this.boolArtifactImport = boolArtifactImport;
      return this;
   }

   public TechStandardPartRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechStandardPartRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechStandardPartRecord setStandardPartType(final Integer standardPartType) {
      this.standardPartType = standardPartType;
      return this;
   }

   @Override
   public String toString() {
      return "TechStandardPartRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", name="
         + this.getName()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", boolArtifactImport="
         + this.getBoolArtifactImport()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", standardPartType="
         + this.getStandardPartType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartRecord)) {
         return false;
      }

      TechStandardPartRecord other = (TechStandardPartRecord)o;
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
                     Object this$inventoryOperationId = this.getInventoryOperationId();
                     Object other$inventoryOperationId = other.getInventoryOperationId();
                     if (this$inventoryOperationId == null ? other$inventoryOperationId == null : this$inventoryOperationId.equals(other$inventoryOperationId)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$enclosurePlanId = this.getEnclosurePlanId();
                           Object other$enclosurePlanId = other.getEnclosurePlanId();
                           if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                              Object this$relationType = this.getRelationType();
                              Object other$relationType = other.getRelationType();
                              if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                 Object this$useProperty = this.getUseProperty();
                                 Object other$useProperty = other.getUseProperty();
                                 if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                                       Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                                       if (this$boolWeightTypeEnum == null
                                          ? other$boolWeightTypeEnum == null
                                          : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                                          Object this$boolArtifactImport = this.getBoolArtifactImport();
                                          Object other$boolArtifactImport = other.getBoolArtifactImport();
                                          if (this$boolArtifactImport == null
                                             ? other$boolArtifactImport == null
                                             : this$boolArtifactImport.equals(other$boolArtifactImport)) {
                                             Object this$userId = this.getUserId();
                                             Object other$userId = other.getUserId();
                                             if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                Object this$standardPartType = this.getStandardPartType();
                                                Object other$standardPartType = other.getStandardPartType();
                                                if (this$standardPartType == null
                                                   ? other$standardPartType == null
                                                   : this$standardPartType.equals(other$standardPartType)) {
                                                   Object this$name = this.getName();
                                                   Object other$name = other.getName();
                                                   if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                      Object this$specification = this.getSpecification();
                                                      Object other$specification = other.getSpecification();
                                                      if (this$specification == null
                                                         ? other$specification == null
                                                         : this$specification.equals(other$specification)) {
                                                         Object this$measureUnit = this.getMeasureUnit();
                                                         Object other$measureUnit = other.getMeasureUnit();
                                                         if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                               if (this$accountingUnit == null
                                                                  ? other$accountingUnit == null
                                                                  : this$accountingUnit.equals(other$accountingUnit)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechStandardPartRecord;
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
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $boolArtifactImport = this.getBoolArtifactImport();
      result = result * 59 + ($boolArtifactImport == null ? 43 : $boolArtifactImport.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $standardPartType = this.getStandardPartType();
      result = result * 59 + ($standardPartType == null ? 43 : $standardPartType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechStandardPartRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long inventoryOperationId;
      private String name;
      private Integer category;
      private Long enclosurePlanId;
      private Integer relationType;
      private Integer useProperty;
      private String specification;
      private Integer quantity;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private Boolean boolWeightTypeEnum;
      private Boolean boolArtifactImport;
      private String remark;
      private Long userId;
      private Integer standardPartType;

      TechStandardPartRecordBuilder() {
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechStandardPartRecord.TechStandardPartRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder boolArtifactImport(final Boolean boolArtifactImport) {
         this.boolArtifactImport = boolArtifactImport;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechStandardPartRecord.TechStandardPartRecordBuilder standardPartType(final Integer standardPartType) {
         this.standardPartType = standardPartType;
         return this;
      }

      public TechStandardPartRecord build() {
         return new TechStandardPartRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.inventoryOperationId,
            this.name,
            this.category,
            this.enclosurePlanId,
            this.relationType,
            this.useProperty,
            this.specification,
            this.quantity,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.boolWeightTypeEnum,
            this.boolArtifactImport,
            this.remark,
            this.userId,
            this.standardPartType
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartRecord.TechStandardPartRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", name="
            + this.name
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", relationType="
            + this.relationType
            + ", useProperty="
            + this.useProperty
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", boolWeightTypeEnum="
            + this.boolWeightTypeEnum
            + ", boolArtifactImport="
            + this.boolArtifactImport
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", standardPartType="
            + this.standardPartType
            + ")";
      }
   }
}
