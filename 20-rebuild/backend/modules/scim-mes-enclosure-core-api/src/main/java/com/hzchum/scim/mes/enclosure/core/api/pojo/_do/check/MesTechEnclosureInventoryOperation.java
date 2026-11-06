package com.hzchum.scim.mes.enclosure.core.api.pojo._do.check;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesTechEnclosureInventoryOperation对象", description = "")
@Entity
@TableName("mes_tech_enclosure_inventory_operation")
@Table(name = "mes_tech_enclosure_inventory_operation")
@org.hibernate.annotations.Table(appliesTo = "mes_tech_enclosure_inventory_operation")
public class MesTechEnclosureInventoryOperation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint default '0' COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint default '0' COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint default '0' COMMENT '区域ID'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "importType", value = "导入类型: 1增量导入 2覆盖导入", notes = "导入类型: 1增量导入 2覆盖导入")
   @TableField("import_type")
   @Column(name = "import_type", columnDefinition = "int  COMMENT '导入类型: 1增量导入 2覆盖导入'", nullable = false)
   private Integer importType;
   @ApiModelProperty(name = "operationTypeEnum", value = "操作类型: 1清导入单 2清单变更", notes = "操作类型: 1清导入单 2清单变更")
   @TableField("operation_type_enum")
   @Column(name = "operation_type_enum", columnDefinition = "int  COMMENT '操作类型: 1清导入单 2清单变更'", nullable = false)
   private Integer operationTypeEnum;
   @ApiModelProperty(name = "importUserId")
   @TableField("import_user_id")
   @Column(name = "import_user_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long importUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "inventoryReviewedEnum", value = "审核状态", notes = "审核状态")
   @TableField("inventory_reviewed_enum")
   @Column(name = "inventory_reviewed_enum", columnDefinition = "int default '2' COMMENT '审核状态'", nullable = false)
   private Integer inventoryReviewedEnum;
   @ApiModelProperty(name = "reviewedBy", value = "审核人id", notes = "审核人id")
   @TableField("reviewed_by")
   @Column(name = "reviewed_by", columnDefinition = "bigint  COMMENT '审核人id'", nullable = true)
   private Long reviewedBy;
   @ApiModelProperty(name = "reviewedTime", value = "审核时间", notes = "审核时间")
   @TableField("reviewed_time")
   @Column(name = "reviewed_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewedTime;
   @ApiModelProperty(name = "reviewedName", value = "审核人名称", notes = "审核人名称")
   @TableField("reviewed_name")
   @Column(name = "reviewed_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewedName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder builder() {
      return new MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder();
   }

   public MesTechEnclosureInventoryOperation() {
   }

   public MesTechEnclosureInventoryOperation(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer importType,
      final Integer operationTypeEnum,
      final Long importUserId,
      final String createUserName,
      final Integer inventoryReviewedEnum,
      final Long reviewedBy,
      final LocalDateTime reviewedTime,
      final String reviewedName,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.importType = importType;
      this.operationTypeEnum = operationTypeEnum;
      this.importUserId = importUserId;
      this.createUserName = createUserName;
      this.inventoryReviewedEnum = inventoryReviewedEnum;
      this.reviewedBy = reviewedBy;
      this.reviewedTime = reviewedTime;
      this.reviewedName = reviewedName;
      this.remark = remark;
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

   public Integer getImportType() {
      return this.importType;
   }

   public Integer getOperationTypeEnum() {
      return this.operationTypeEnum;
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

   public MesTechEnclosureInventoryOperation setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesTechEnclosureInventoryOperation setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesTechEnclosureInventoryOperation setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesTechEnclosureInventoryOperation setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesTechEnclosureInventoryOperation setImportType(final Integer importType) {
      this.importType = importType;
      return this;
   }

   public MesTechEnclosureInventoryOperation setOperationTypeEnum(final Integer operationTypeEnum) {
      this.operationTypeEnum = operationTypeEnum;
      return this;
   }

   public MesTechEnclosureInventoryOperation setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
      return this;
   }

   public MesTechEnclosureInventoryOperation setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public MesTechEnclosureInventoryOperation setInventoryReviewedEnum(final Integer inventoryReviewedEnum) {
      this.inventoryReviewedEnum = inventoryReviewedEnum;
      return this;
   }

   public MesTechEnclosureInventoryOperation setReviewedBy(final Long reviewedBy) {
      this.reviewedBy = reviewedBy;
      return this;
   }

   public MesTechEnclosureInventoryOperation setReviewedTime(final LocalDateTime reviewedTime) {
      this.reviewedTime = reviewedTime;
      return this;
   }

   public MesTechEnclosureInventoryOperation setReviewedName(final String reviewedName) {
      this.reviewedName = reviewedName;
      return this;
   }

   public MesTechEnclosureInventoryOperation setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MesTechEnclosureInventoryOperation(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", importType="
         + this.getImportType()
         + ", operationTypeEnum="
         + this.getOperationTypeEnum()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTechEnclosureInventoryOperation)) {
         return false;
      }

      MesTechEnclosureInventoryOperation other = (MesTechEnclosureInventoryOperation)o;
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
                  Object this$importType = this.getImportType();
                  Object other$importType = other.getImportType();
                  if (this$importType == null ? other$importType == null : this$importType.equals(other$importType)) {
                     Object this$operationTypeEnum = this.getOperationTypeEnum();
                     Object other$operationTypeEnum = other.getOperationTypeEnum();
                     if (this$operationTypeEnum == null ? other$operationTypeEnum == null : this$operationTypeEnum.equals(other$operationTypeEnum)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesTechEnclosureInventoryOperation;
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
      Object $importType = this.getImportType();
      result = result * 59 + ($importType == null ? 43 : $importType.hashCode());
      Object $operationTypeEnum = this.getOperationTypeEnum();
      result = result * 59 + ($operationTypeEnum == null ? 43 : $operationTypeEnum.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $inventoryReviewedEnum = this.getInventoryReviewedEnum();
      result = result * 59 + ($inventoryReviewedEnum == null ? 43 : $inventoryReviewedEnum.hashCode());
      Object $reviewedBy = this.getReviewedBy();
      result = result * 59 + ($reviewedBy == null ? 43 : $reviewedBy.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $reviewedTime = this.getReviewedTime();
      result = result * 59 + ($reviewedTime == null ? 43 : $reviewedTime.hashCode());
      Object $reviewedName = this.getReviewedName();
      result = result * 59 + ($reviewedName == null ? 43 : $reviewedName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesTechEnclosureInventoryOperationBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer importType;
      private Integer operationTypeEnum;
      private Long importUserId;
      private String createUserName;
      private Integer inventoryReviewedEnum;
      private Long reviewedBy;
      private LocalDateTime reviewedTime;
      private String reviewedName;
      private String remark;

      MesTechEnclosureInventoryOperationBuilder() {
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder importType(final Integer importType) {
         this.importType = importType;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder operationTypeEnum(final Integer operationTypeEnum) {
         this.operationTypeEnum = operationTypeEnum;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder importUserId(final Long importUserId) {
         this.importUserId = importUserId;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder inventoryReviewedEnum(final Integer inventoryReviewedEnum) {
         this.inventoryReviewedEnum = inventoryReviewedEnum;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder reviewedBy(final Long reviewedBy) {
         this.reviewedBy = reviewedBy;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder reviewedTime(final LocalDateTime reviewedTime) {
         this.reviewedTime = reviewedTime;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder reviewedName(final String reviewedName) {
         this.reviewedName = reviewedName;
         return this;
      }

      public MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesTechEnclosureInventoryOperation build() {
         return new MesTechEnclosureInventoryOperation(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.importType,
            this.operationTypeEnum,
            this.importUserId,
            this.createUserName,
            this.inventoryReviewedEnum,
            this.reviewedBy,
            this.reviewedTime,
            this.reviewedName,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "MesTechEnclosureInventoryOperation.MesTechEnclosureInventoryOperationBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", importType="
            + this.importType
            + ", operationTypeEnum="
            + this.operationTypeEnum
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
            + ")";
      }
   }
}
