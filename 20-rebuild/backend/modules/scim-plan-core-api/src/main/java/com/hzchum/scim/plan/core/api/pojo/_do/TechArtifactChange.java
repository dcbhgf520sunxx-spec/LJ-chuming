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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechArtifactChange对象", description = "构件变更表 ")
@Entity
@TableName("tech_artifact_change")
@Table(name = "tech_artifact_change")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_change", comment = "构件变更表 ")
public class TechArtifactChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "oldQuantity", value = "原数量", notes = "原数量")
   @TableField("old_quantity")
   @Column(name = "old_quantity", columnDefinition = "int(11)  COMMENT '原数量'", nullable = false)
   private Integer oldQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量", notes = "变更后数量")
   @TableField("new_quantity")
   @Column(name = "new_quantity", columnDefinition = "int(11)  COMMENT '变更后数量'", nullable = false)
   private Integer newQuantity;
   @ApiModelProperty(name = "oldNetWeight", value = "原单净重（kg）")
   @TableField("old_net_weight")
   @Column(name = "old_net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '原单净重(kg)'", nullable = false)
   private BigDecimal oldNetWeight;
   @ApiModelProperty(name = "newNetWeight", value = "变更单净重（kg）")
   @TableField("new_net_weight")
   @Column(name = "new_net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '变更后单净重(kg)'", nullable = false)
   private BigDecimal newNetWeight;
   @ApiModelProperty(name = "oldGrossWeight", value = "原单毛重（kg）")
   @TableField("old_gross_weight")
   @Column(name = "old_gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '原单毛重(kg)'", nullable = false)
   private BigDecimal oldGrossWeight;
   @ApiModelProperty(name = "newGrossWeight", value = "变更单毛重（kg）")
   @TableField("new_gross_weight")
   @Column(name = "new_gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '变更后单毛重(kg)'", nullable = false)
   private BigDecimal newGrossWeight;
   @ApiModelProperty(name = "name", value = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64) COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64) COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(65) COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "userId", value = "变更提交人id", notes = "变更提交人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '变更提交人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "handleStatusEnum", value = "处理状态 1未处理 2处理通过 4驳回 HandleStatusEnum", notes = "处理状态 1未处理 2处理通过 4驳回")
   @TableField("handle_status_enum")
   @Column(name = "handle_status_enum", columnDefinition = "int(11) default '1' COMMENT '处理状态 1未处理 2处理通过 4驳回'", nullable = false)
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "handleUserId", value = "处理人", notes = "处理人")
   @TableField("handle_user_id")
   @Column(name = "handle_user_id", columnDefinition = "bigint(20)  COMMENT '处理人'", nullable = true)
   private Long handleUserId;
   @ApiModelProperty(name = "handleTime", value = "处理时间", notes = "处理时间")
   @TableField("handle_time")
   @Column(name = "handle_time", columnDefinition = "datetime(6)  COMMENT '处理时间'", nullable = true)
   private LocalDateTime handleTime;
   @ApiModelProperty(name = "reasonId", value = "变更原因id", notes = "变更原因id")
   @TableField("reason_id")
   @Column(name = "reason_id", columnDefinition = "bigint(20)  COMMENT '变更原因id'", nullable = false)
   private Long reasonId;
   @ApiModelProperty(name = "change_remark", value = "备注", notes = "备注")
   @TableField("change_remark")
   @Column(name = "change_remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String changeRemark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件id字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "boolDataSynchronism", value = "是否同步到新变更")
   @JsonProperty("boolDataSynchronism")
   @JSONField(name = "boolDataSynchronism")
   @TableField("bool_data_synchronism")
   @Column(name = "bool_data_synchronism", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '状态 是否同步到新变更'", nullable = false)
   private Boolean boolDataSynchronism;

   public static TechArtifactChange.TechArtifactChangeBuilder builder() {
      return new TechArtifactChange.TechArtifactChangeBuilder();
   }

   public TechArtifactChange() {
   }

   public TechArtifactChange(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long artifactId,
      final Integer oldQuantity,
      final Integer newQuantity,
      final BigDecimal oldNetWeight,
      final BigDecimal newNetWeight,
      final BigDecimal oldGrossWeight,
      final BigDecimal newGrossWeight,
      final String name,
      final String serialNumber,
      final String specification,
      final Long userId,
      final Integer handleStatusEnum,
      final Long handleUserId,
      final LocalDateTime handleTime,
      final Long reasonId,
      final String changeRemark,
      final String attachmentIds,
      final Boolean boolDataSynchronism
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.artifactId = artifactId;
      this.oldQuantity = oldQuantity;
      this.newQuantity = newQuantity;
      this.oldNetWeight = oldNetWeight;
      this.newNetWeight = newNetWeight;
      this.oldGrossWeight = oldGrossWeight;
      this.newGrossWeight = newGrossWeight;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.userId = userId;
      this.handleStatusEnum = handleStatusEnum;
      this.handleUserId = handleUserId;
      this.handleTime = handleTime;
      this.reasonId = reasonId;
      this.changeRemark = changeRemark;
      this.attachmentIds = attachmentIds;
      this.boolDataSynchronism = boolDataSynchronism;
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

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public BigDecimal getOldNetWeight() {
      return this.oldNetWeight;
   }

   public BigDecimal getNewNetWeight() {
      return this.newNetWeight;
   }

   public BigDecimal getOldGrossWeight() {
      return this.oldGrossWeight;
   }

   public BigDecimal getNewGrossWeight() {
      return this.newGrossWeight;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public Long getHandleUserId() {
      return this.handleUserId;
   }

   public LocalDateTime getHandleTime() {
      return this.handleTime;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Boolean getBoolDataSynchronism() {
      return this.boolDataSynchronism;
   }

   public TechArtifactChange setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactChange setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechArtifactChange setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechArtifactChange setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechArtifactChange setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechArtifactChange setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public TechArtifactChange setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   public TechArtifactChange setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
      return this;
   }

   public TechArtifactChange setOldNetWeight(final BigDecimal oldNetWeight) {
      this.oldNetWeight = oldNetWeight;
      return this;
   }

   public TechArtifactChange setNewNetWeight(final BigDecimal newNetWeight) {
      this.newNetWeight = newNetWeight;
      return this;
   }

   public TechArtifactChange setOldGrossWeight(final BigDecimal oldGrossWeight) {
      this.oldGrossWeight = oldGrossWeight;
      return this;
   }

   public TechArtifactChange setNewGrossWeight(final BigDecimal newGrossWeight) {
      this.newGrossWeight = newGrossWeight;
      return this;
   }

   public TechArtifactChange setName(final String name) {
      this.name = name;
      return this;
   }

   public TechArtifactChange setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechArtifactChange setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechArtifactChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechArtifactChange setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
      return this;
   }

   public TechArtifactChange setHandleUserId(final Long handleUserId) {
      this.handleUserId = handleUserId;
      return this;
   }

   public TechArtifactChange setHandleTime(final LocalDateTime handleTime) {
      this.handleTime = handleTime;
      return this;
   }

   public TechArtifactChange setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
      return this;
   }

   public TechArtifactChange setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
      return this;
   }

   public TechArtifactChange setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("boolDataSynchronism")
   public TechArtifactChange setBoolDataSynchronism(final Boolean boolDataSynchronism) {
      this.boolDataSynchronism = boolDataSynchronism;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactChange(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactId="
         + this.getArtifactId()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", oldNetWeight="
         + this.getOldNetWeight()
         + ", newNetWeight="
         + this.getNewNetWeight()
         + ", oldGrossWeight="
         + this.getOldGrossWeight()
         + ", newGrossWeight="
         + this.getNewGrossWeight()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", userId="
         + this.getUserId()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", handleUserId="
         + this.getHandleUserId()
         + ", handleTime="
         + this.getHandleTime()
         + ", reasonId="
         + this.getReasonId()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", boolDataSynchronism="
         + this.getBoolDataSynchronism()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactChange)) {
         return false;
      }

      TechArtifactChange other = (TechArtifactChange)o;
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
                     Object this$artifactId = this.getArtifactId();
                     Object other$artifactId = other.getArtifactId();
                     if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                        Object this$oldQuantity = this.getOldQuantity();
                        Object other$oldQuantity = other.getOldQuantity();
                        if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                           Object this$newQuantity = this.getNewQuantity();
                           Object other$newQuantity = other.getNewQuantity();
                           if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$handleStatusEnum = this.getHandleStatusEnum();
                                 Object other$handleStatusEnum = other.getHandleStatusEnum();
                                 if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
                                    Object this$handleUserId = this.getHandleUserId();
                                    Object other$handleUserId = other.getHandleUserId();
                                    if (this$handleUserId == null ? other$handleUserId == null : this$handleUserId.equals(other$handleUserId)) {
                                       Object this$reasonId = this.getReasonId();
                                       Object other$reasonId = other.getReasonId();
                                       if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                                          Object this$boolDataSynchronism = this.getBoolDataSynchronism();
                                          Object other$boolDataSynchronism = other.getBoolDataSynchronism();
                                          if (this$boolDataSynchronism == null
                                             ? other$boolDataSynchronism == null
                                             : this$boolDataSynchronism.equals(other$boolDataSynchronism)) {
                                             Object this$oldNetWeight = this.getOldNetWeight();
                                             Object other$oldNetWeight = other.getOldNetWeight();
                                             if (this$oldNetWeight == null ? other$oldNetWeight == null : this$oldNetWeight.equals(other$oldNetWeight)) {
                                                Object this$newNetWeight = this.getNewNetWeight();
                                                Object other$newNetWeight = other.getNewNetWeight();
                                                if (this$newNetWeight == null ? other$newNetWeight == null : this$newNetWeight.equals(other$newNetWeight)) {
                                                   Object this$oldGrossWeight = this.getOldGrossWeight();
                                                   Object other$oldGrossWeight = other.getOldGrossWeight();
                                                   if (this$oldGrossWeight == null
                                                      ? other$oldGrossWeight == null
                                                      : this$oldGrossWeight.equals(other$oldGrossWeight)) {
                                                      Object this$newGrossWeight = this.getNewGrossWeight();
                                                      Object other$newGrossWeight = other.getNewGrossWeight();
                                                      if (this$newGrossWeight == null
                                                         ? other$newGrossWeight == null
                                                         : this$newGrossWeight.equals(other$newGrossWeight)) {
                                                         Object this$name = this.getName();
                                                         Object other$name = other.getName();
                                                         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$specification = this.getSpecification();
                                                               Object other$specification = other.getSpecification();
                                                               if (this$specification == null
                                                                  ? other$specification == null
                                                                  : this$specification.equals(other$specification)) {
                                                                  Object this$handleTime = this.getHandleTime();
                                                                  Object other$handleTime = other.getHandleTime();
                                                                  if (this$handleTime == null
                                                                     ? other$handleTime == null
                                                                     : this$handleTime.equals(other$handleTime)) {
                                                                     Object this$changeRemark = this.getChangeRemark();
                                                                     Object other$changeRemark = other.getChangeRemark();
                                                                     if (this$changeRemark == null
                                                                        ? other$changeRemark == null
                                                                        : this$changeRemark.equals(other$changeRemark)) {
                                                                        Object this$attachmentIds = this.getAttachmentIds();
                                                                        Object other$attachmentIds = other.getAttachmentIds();
                                                                        return this$attachmentIds == null
                                                                           ? other$attachmentIds == null
                                                                           : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof TechArtifactChange;
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
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $handleUserId = this.getHandleUserId();
      result = result * 59 + ($handleUserId == null ? 43 : $handleUserId.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $boolDataSynchronism = this.getBoolDataSynchronism();
      result = result * 59 + ($boolDataSynchronism == null ? 43 : $boolDataSynchronism.hashCode());
      Object $oldNetWeight = this.getOldNetWeight();
      result = result * 59 + ($oldNetWeight == null ? 43 : $oldNetWeight.hashCode());
      Object $newNetWeight = this.getNewNetWeight();
      result = result * 59 + ($newNetWeight == null ? 43 : $newNetWeight.hashCode());
      Object $oldGrossWeight = this.getOldGrossWeight();
      result = result * 59 + ($oldGrossWeight == null ? 43 : $oldGrossWeight.hashCode());
      Object $newGrossWeight = this.getNewGrossWeight();
      result = result * 59 + ($newGrossWeight == null ? 43 : $newGrossWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $handleTime = this.getHandleTime();
      result = result * 59 + ($handleTime == null ? 43 : $handleTime.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class TechArtifactChangeBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long artifactId;
      private Integer oldQuantity;
      private Integer newQuantity;
      private BigDecimal oldNetWeight;
      private BigDecimal newNetWeight;
      private BigDecimal oldGrossWeight;
      private BigDecimal newGrossWeight;
      private String name;
      private String serialNumber;
      private String specification;
      private Long userId;
      private Integer handleStatusEnum;
      private Long handleUserId;
      private LocalDateTime handleTime;
      private Long reasonId;
      private String changeRemark;
      private String attachmentIds;
      private Boolean boolDataSynchronism;

      TechArtifactChangeBuilder() {
      }

      public TechArtifactChange.TechArtifactChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder oldNetWeight(final BigDecimal oldNetWeight) {
         this.oldNetWeight = oldNetWeight;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder newNetWeight(final BigDecimal newNetWeight) {
         this.newNetWeight = newNetWeight;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder oldGrossWeight(final BigDecimal oldGrossWeight) {
         this.oldGrossWeight = oldGrossWeight;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder newGrossWeight(final BigDecimal newGrossWeight) {
         this.newGrossWeight = newGrossWeight;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder handleStatusEnum(final Integer handleStatusEnum) {
         this.handleStatusEnum = handleStatusEnum;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder handleUserId(final Long handleUserId) {
         this.handleUserId = handleUserId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder handleTime(final LocalDateTime handleTime) {
         this.handleTime = handleTime;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechArtifactChange.TechArtifactChangeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("boolDataSynchronism")
      public TechArtifactChange.TechArtifactChangeBuilder boolDataSynchronism(final Boolean boolDataSynchronism) {
         this.boolDataSynchronism = boolDataSynchronism;
         return this;
      }

      public TechArtifactChange build() {
         return new TechArtifactChange(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.artifactId,
            this.oldQuantity,
            this.newQuantity,
            this.oldNetWeight,
            this.newNetWeight,
            this.oldGrossWeight,
            this.newGrossWeight,
            this.name,
            this.serialNumber,
            this.specification,
            this.userId,
            this.handleStatusEnum,
            this.handleUserId,
            this.handleTime,
            this.reasonId,
            this.changeRemark,
            this.attachmentIds,
            this.boolDataSynchronism
         );
      }

      @Override
      public String toString() {
         return "TechArtifactChange.TechArtifactChangeBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", artifactId="
            + this.artifactId
            + ", oldQuantity="
            + this.oldQuantity
            + ", newQuantity="
            + this.newQuantity
            + ", oldNetWeight="
            + this.oldNetWeight
            + ", newNetWeight="
            + this.newNetWeight
            + ", oldGrossWeight="
            + this.oldGrossWeight
            + ", newGrossWeight="
            + this.newGrossWeight
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", userId="
            + this.userId
            + ", handleStatusEnum="
            + this.handleStatusEnum
            + ", handleUserId="
            + this.handleUserId
            + ", handleTime="
            + this.handleTime
            + ", reasonId="
            + this.reasonId
            + ", changeRemark="
            + this.changeRemark
            + ", attachmentIds="
            + this.attachmentIds
            + ", boolDataSynchronism="
            + this.boolDataSynchronism
            + ")";
      }
   }
}
