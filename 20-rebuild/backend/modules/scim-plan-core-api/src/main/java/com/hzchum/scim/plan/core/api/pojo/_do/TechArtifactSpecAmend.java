package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechArtifactSpecAmend对象", description = "构件规格修正表 ")
@Entity
@TableName("tech_artifact_spec_amend")
@Table(
   name = "tech_artifact_spec_amend",
   indexes = {
         @Index(name = "idx_project_monomer_area", columnList = "project_id,monomer_id,area_id"),
         @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_spec_amend", comment = "构件规格修正表 ")
public class TechArtifactSpecAmend extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单导入记录Id", notes = "清单导入记录Id")
   @TableField("inventory_operation_id")
   @Column(name = "inventory_operation_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '清单导入记录Id'", nullable = false)
   private Long inventoryOperationId;
   @ApiModelProperty(name = "artifactId", value = "构件审核表Id", notes = "构件审核表Id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件审核表Id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '长度(mm)'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '材质'")
   private String material;
   @ApiModelProperty("原构件种类表Id")
   @TableField("old_structure_class_id")
   @Column(name = "old_structure_class_id", columnDefinition = "bigint(20)  comment '原构件种类表Id'")
   private Long oldStructureClassId;
   @ApiModelProperty(name = "oldSpecification", value = "原来规格", notes = "原来规格")
   @TableField("old_specification")
   @Column(name = "old_specification", columnDefinition = "varchar(255)  COMMENT '原来规格'", nullable = false)
   private String oldSpecification;
   @ApiModelProperty(name = "oldSpecPrefix", value = "原规格前缀", notes = "原规格前缀")
   @TableField("old_spec_prefix")
   @Column(name = "old_spec_prefix", columnDefinition = "varchar(255)  COMMENT '原规格前缀'", nullable = false)
   private String oldSpecPrefix;
   @ApiModelProperty(name = "oldName", value = "原名称")
   @JsonProperty("oldName")
   @JSONField(name = "oldName")
   @TableField("old_name")
   @Column(name = "old_name", columnDefinition = "varchar(255)  COMMENT '原名称'", nullable = false)
   private String oldName;
   @ApiModelProperty("修正后构件种类表Id")
   @TableField("new_structure_class_id")
   @Column(name = "new_structure_class_id", columnDefinition = "bigint(20)  comment '修正后构件种类表Id'")
   private Long newStructureClassId;
   @ApiModelProperty(name = "newSpecification", value = "修正规格", notes = "修正规格")
   @TableField("new_specification")
   @Column(name = "new_specification", columnDefinition = "varchar(255)  COMMENT '修正规格'")
   private String newSpecification;
   @ApiModelProperty(name = "newSpecPrefix", value = "修正规格前缀", notes = "修正规格前缀")
   @TableField("new_spec_prefix")
   @Column(name = "new_spec_prefix", columnDefinition = "varchar(255)  COMMENT '修正规格前缀'")
   private String newSpecPrefix;
   @ApiModelProperty(name = "newName", value = "修正后名称")
   @JsonProperty("newName")
   @JSONField(name = "newName")
   @TableField("new_name")
   @Column(name = "new_name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '修正后名称'")
   private String newName;
   @ApiModelProperty(name = "boolAmendStatus", value = "修正状态 1已修正 0未修正", notes = "修正状态 1已修正 0未修正")
   @TableField("bool_amend_status")
   @Column(name = "bool_amend_status", columnDefinition = "tinyint(1) default '0' COMMENT '修正状态 1已修正 0未修正'", nullable = false)
   private Boolean boolAmendStatus;
   @ApiModelProperty(name = "userId", value = "修正人ID", notes = "修正人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) default '0' COMMENT '修正人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "projectMode", value = "项目模式 1简约模式 2标准模式", notes = "项目模式 1简约模式 2标准模式")
   @TableField("project_mode")
   @Column(name = "project_mode", columnDefinition = "tinyint(1) default '0' COMMENT '项目模式 1简约模式 2标准模式'", nullable = false)
   private Integer projectMode;

   public static TechArtifactSpecAmend.TechArtifactSpecAmendBuilder builder() {
      return new TechArtifactSpecAmend.TechArtifactSpecAmendBuilder();
   }

   public TechArtifactSpecAmend() {
   }

   public TechArtifactSpecAmend(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long inventoryOperationId,
      final Long artifactId,
      final String serialNumber,
      final Integer quantity,
      final BigDecimal length,
      final String material,
      final Long oldStructureClassId,
      final String oldSpecification,
      final String oldSpecPrefix,
      final String oldName,
      final Long newStructureClassId,
      final String newSpecification,
      final String newSpecPrefix,
      final String newName,
      final Boolean boolAmendStatus,
      final Long userId,
      final Integer projectMode
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.inventoryOperationId = inventoryOperationId;
      this.artifactId = artifactId;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.length = length;
      this.material = material;
      this.oldStructureClassId = oldStructureClassId;
      this.oldSpecification = oldSpecification;
      this.oldSpecPrefix = oldSpecPrefix;
      this.oldName = oldName;
      this.newStructureClassId = newStructureClassId;
      this.newSpecification = newSpecification;
      this.newSpecPrefix = newSpecPrefix;
      this.newName = newName;
      this.boolAmendStatus = boolAmendStatus;
      this.userId = userId;
      this.projectMode = projectMode;
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

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getOldStructureClassId() {
      return this.oldStructureClassId;
   }

   public String getOldSpecification() {
      return this.oldSpecification;
   }

   public String getOldSpecPrefix() {
      return this.oldSpecPrefix;
   }

   public String getOldName() {
      return this.oldName;
   }

   public Long getNewStructureClassId() {
      return this.newStructureClassId;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public String getNewName() {
      return this.newName;
   }

   public Boolean getBoolAmendStatus() {
      return this.boolAmendStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProjectMode() {
      return this.projectMode;
   }

   public TechArtifactSpecAmend setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactSpecAmend setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechArtifactSpecAmend setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechArtifactSpecAmend setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechArtifactSpecAmend setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechArtifactSpecAmend setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechArtifactSpecAmend setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechArtifactSpecAmend setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public TechArtifactSpecAmend setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public TechArtifactSpecAmend setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechArtifactSpecAmend setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechArtifactSpecAmend setOldStructureClassId(final Long oldStructureClassId) {
      this.oldStructureClassId = oldStructureClassId;
      return this;
   }

   public TechArtifactSpecAmend setOldSpecification(final String oldSpecification) {
      this.oldSpecification = oldSpecification;
      return this;
   }

   public TechArtifactSpecAmend setOldSpecPrefix(final String oldSpecPrefix) {
      this.oldSpecPrefix = oldSpecPrefix;
      return this;
   }

   @JsonProperty("oldName")
   public TechArtifactSpecAmend setOldName(final String oldName) {
      this.oldName = oldName;
      return this;
   }

   public TechArtifactSpecAmend setNewStructureClassId(final Long newStructureClassId) {
      this.newStructureClassId = newStructureClassId;
      return this;
   }

   public TechArtifactSpecAmend setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
      return this;
   }

   public TechArtifactSpecAmend setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
      return this;
   }

   @JsonProperty("newName")
   public TechArtifactSpecAmend setNewName(final String newName) {
      this.newName = newName;
      return this;
   }

   public TechArtifactSpecAmend setBoolAmendStatus(final Boolean boolAmendStatus) {
      this.boolAmendStatus = boolAmendStatus;
      return this;
   }

   public TechArtifactSpecAmend setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechArtifactSpecAmend setProjectMode(final Integer projectMode) {
      this.projectMode = projectMode;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactSpecAmend(id="
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
         + ", artifactId="
         + this.getArtifactId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", oldStructureClassId="
         + this.getOldStructureClassId()
         + ", oldSpecification="
         + this.getOldSpecification()
         + ", oldSpecPrefix="
         + this.getOldSpecPrefix()
         + ", oldName="
         + this.getOldName()
         + ", newStructureClassId="
         + this.getNewStructureClassId()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", newName="
         + this.getNewName()
         + ", boolAmendStatus="
         + this.getBoolAmendStatus()
         + ", userId="
         + this.getUserId()
         + ", projectMode="
         + this.getProjectMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactSpecAmend)) {
         return false;
      }

      TechArtifactSpecAmend other = (TechArtifactSpecAmend)o;
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
                        Object this$artifactId = this.getArtifactId();
                        Object other$artifactId = other.getArtifactId();
                        if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$oldStructureClassId = this.getOldStructureClassId();
                              Object other$oldStructureClassId = other.getOldStructureClassId();
                              if (this$oldStructureClassId == null
                                 ? other$oldStructureClassId == null
                                 : this$oldStructureClassId.equals(other$oldStructureClassId)) {
                                 Object this$newStructureClassId = this.getNewStructureClassId();
                                 Object other$newStructureClassId = other.getNewStructureClassId();
                                 if (this$newStructureClassId == null
                                    ? other$newStructureClassId == null
                                    : this$newStructureClassId.equals(other$newStructureClassId)) {
                                    Object this$boolAmendStatus = this.getBoolAmendStatus();
                                    Object other$boolAmendStatus = other.getBoolAmendStatus();
                                    if (this$boolAmendStatus == null ? other$boolAmendStatus == null : this$boolAmendStatus.equals(other$boolAmendStatus)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$projectMode = this.getProjectMode();
                                          Object other$projectMode = other.getProjectMode();
                                          if (this$projectMode == null ? other$projectMode == null : this$projectMode.equals(other$projectMode)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$oldSpecification = this.getOldSpecification();
                                                      Object other$oldSpecification = other.getOldSpecification();
                                                      if (this$oldSpecification == null
                                                         ? other$oldSpecification == null
                                                         : this$oldSpecification.equals(other$oldSpecification)) {
                                                         Object this$oldSpecPrefix = this.getOldSpecPrefix();
                                                         Object other$oldSpecPrefix = other.getOldSpecPrefix();
                                                         if (this$oldSpecPrefix == null
                                                            ? other$oldSpecPrefix == null
                                                            : this$oldSpecPrefix.equals(other$oldSpecPrefix)) {
                                                            Object this$oldName = this.getOldName();
                                                            Object other$oldName = other.getOldName();
                                                            if (this$oldName == null ? other$oldName == null : this$oldName.equals(other$oldName)) {
                                                               Object this$newSpecification = this.getNewSpecification();
                                                               Object other$newSpecification = other.getNewSpecification();
                                                               if (this$newSpecification == null
                                                                  ? other$newSpecification == null
                                                                  : this$newSpecification.equals(other$newSpecification)) {
                                                                  Object this$newSpecPrefix = this.getNewSpecPrefix();
                                                                  Object other$newSpecPrefix = other.getNewSpecPrefix();
                                                                  if (this$newSpecPrefix == null
                                                                     ? other$newSpecPrefix == null
                                                                     : this$newSpecPrefix.equals(other$newSpecPrefix)) {
                                                                     Object this$newName = this.getNewName();
                                                                     Object other$newName = other.getNewName();
                                                                     return this$newName == null ? other$newName == null : this$newName.equals(other$newName);
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
      return other instanceof TechArtifactSpecAmend;
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
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $oldStructureClassId = this.getOldStructureClassId();
      result = result * 59 + ($oldStructureClassId == null ? 43 : $oldStructureClassId.hashCode());
      Object $newStructureClassId = this.getNewStructureClassId();
      result = result * 59 + ($newStructureClassId == null ? 43 : $newStructureClassId.hashCode());
      Object $boolAmendStatus = this.getBoolAmendStatus();
      result = result * 59 + ($boolAmendStatus == null ? 43 : $boolAmendStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectMode = this.getProjectMode();
      result = result * 59 + ($projectMode == null ? 43 : $projectMode.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $oldSpecification = this.getOldSpecification();
      result = result * 59 + ($oldSpecification == null ? 43 : $oldSpecification.hashCode());
      Object $oldSpecPrefix = this.getOldSpecPrefix();
      result = result * 59 + ($oldSpecPrefix == null ? 43 : $oldSpecPrefix.hashCode());
      Object $oldName = this.getOldName();
      result = result * 59 + ($oldName == null ? 43 : $oldName.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      result = result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
      Object $newName = this.getNewName();
      return result * 59 + ($newName == null ? 43 : $newName.hashCode());
   }

   public static class TechArtifactSpecAmendBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long inventoryOperationId;
      private Long artifactId;
      private String serialNumber;
      private Integer quantity;
      private BigDecimal length;
      private String material;
      private Long oldStructureClassId;
      private String oldSpecification;
      private String oldSpecPrefix;
      private String oldName;
      private Long newStructureClassId;
      private String newSpecification;
      private String newSpecPrefix;
      private String newName;
      private Boolean boolAmendStatus;
      private Long userId;
      private Integer projectMode;

      TechArtifactSpecAmendBuilder() {
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder oldStructureClassId(final Long oldStructureClassId) {
         this.oldStructureClassId = oldStructureClassId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder oldSpecification(final String oldSpecification) {
         this.oldSpecification = oldSpecification;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder oldSpecPrefix(final String oldSpecPrefix) {
         this.oldSpecPrefix = oldSpecPrefix;
         return this;
      }

      @JsonProperty("oldName")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder oldName(final String oldName) {
         this.oldName = oldName;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder newStructureClassId(final Long newStructureClassId) {
         this.newStructureClassId = newStructureClassId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder newSpecification(final String newSpecification) {
         this.newSpecification = newSpecification;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder newSpecPrefix(final String newSpecPrefix) {
         this.newSpecPrefix = newSpecPrefix;
         return this;
      }

      @JsonProperty("newName")
      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder newName(final String newName) {
         this.newName = newName;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder boolAmendStatus(final Boolean boolAmendStatus) {
         this.boolAmendStatus = boolAmendStatus;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactSpecAmend.TechArtifactSpecAmendBuilder projectMode(final Integer projectMode) {
         this.projectMode = projectMode;
         return this;
      }

      public TechArtifactSpecAmend build() {
         return new TechArtifactSpecAmend(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.inventoryOperationId,
            this.artifactId,
            this.serialNumber,
            this.quantity,
            this.length,
            this.material,
            this.oldStructureClassId,
            this.oldSpecification,
            this.oldSpecPrefix,
            this.oldName,
            this.newStructureClassId,
            this.newSpecification,
            this.newSpecPrefix,
            this.newName,
            this.boolAmendStatus,
            this.userId,
            this.projectMode
         );
      }

      @Override
      public String toString() {
         return "TechArtifactSpecAmend.TechArtifactSpecAmendBuilder(id="
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
            + ", artifactId="
            + this.artifactId
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", oldStructureClassId="
            + this.oldStructureClassId
            + ", oldSpecification="
            + this.oldSpecification
            + ", oldSpecPrefix="
            + this.oldSpecPrefix
            + ", oldName="
            + this.oldName
            + ", newStructureClassId="
            + this.newStructureClassId
            + ", newSpecification="
            + this.newSpecification
            + ", newSpecPrefix="
            + this.newSpecPrefix
            + ", newName="
            + this.newName
            + ", boolAmendStatus="
            + this.boolAmendStatus
            + ", userId="
            + this.userId
            + ", projectMode="
            + this.projectMode
            + ")";
      }
   }
}
