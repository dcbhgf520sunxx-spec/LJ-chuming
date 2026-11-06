package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "WmsMoveMaterial对象", description = "物料移库表")
@Entity
@TableName("wms_move_material")
@Table(name = "wms_move_material")
public class MoveMaterial extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "移库单号", notes = "移库单号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '移库单号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(128)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewerIds", value = "审核人ID集合", notes = "审核人ID集合")
   @TableField("reviewer_ids")
   @Column(name = "reviewer_ids", columnDefinition = "varchar(500)  COMMENT '审核人ID集合'", nullable = true)
   private String reviewerIds;
   @ApiModelProperty(name = "reviewerNames", value = "审核人名称集合", notes = "审核人名称集合")
   @TableField("reviewer_names")
   @Column(name = "reviewer_names", columnDefinition = "varchar(500)  COMMENT '审核人名称集合'", nullable = true)
   private String reviewerNames;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型[位运算]", notes = "物料基础类型[位运算]")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型[位运算]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "sourceWorkshopIds", value = "原仓库ID集合 -> wms", notes = "原仓库ID集合 -> wms")
   @TableField("source_workshop_ids")
   @Column(name = "source_workshop_ids", columnDefinition = "varchar(255)  COMMENT '原仓库ID -> wms'", nullable = true)
   private String sourceWorkshopIds;
   @ApiModelProperty(name = "directionWorkshopId", value = "目标仓库ID -> wms", notes = "目标仓库ID -> wms")
   @TableField("direction_workshop_id")
   @Column(name = "direction_workshop_id", columnDefinition = "bigint  COMMENT '目标仓库ID -> wms'", nullable = true)
   private Long directionWorkshopId;
   @ApiModelProperty(name = "sourceWarehouseIds", value = "原存储位置ID集合 -> wms", notes = "原存储位置ID集合 -> wms")
   @TableField("source_warehouse_ids")
   @Column(name = "source_warehouse_ids", columnDefinition = "varchar(255)  COMMENT '原存储位置ID集合 -> wms'", nullable = true)
   private String sourceWarehouseIds;
   @ApiModelProperty(name = "directionWarehouseId", value = "目标存储位置ID -> wms", notes = "目标存储位置ID -> wms")
   @TableField("direction_warehouse_id")
   @Column(name = "direction_warehouse_id", columnDefinition = "bigint  COMMENT '目标存储位置ID -> wms'", nullable = true)
   private Long directionWarehouseId;
   @ApiModelProperty(name = "projectIds", value = "关联项目ID集合", notes = "关联项目ID集合")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '关联项目ID集合'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "reviewStatus", value = "状态  ReviewStatusEnum", notes = "状态  ReviewStatusEnum")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '状态  ReviewStatusEnum'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewEndTime", value = "审核结束时间", notes = "审核结束时间")
   @TableField("review_end_time")
   @Column(name = "review_end_time", columnDefinition = "datetime  COMMENT '审核结束时间'", nullable = true)
   private LocalDateTime reviewEndTime;
   @ApiModelProperty(name = "approvalComments", value = "审批意见", notes = "审批意见")
   @TableField("approval_comments")
   @Column(name = "approval_comments", columnDefinition = "varchar(255)  COMMENT '审批意见'", nullable = true)
   private String approvalComments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;

   public static MoveMaterial.MoveMaterialBuilder builder() {
      return new MoveMaterial.MoveMaterialBuilder();
   }

   public MoveMaterial() {
   }

   public MoveMaterial(
      final Long id,
      final String serialNumber,
      final Long applicantId,
      final String applicantName,
      final String reviewerIds,
      final String reviewerNames,
      final Integer basicClass,
      final String sourceWorkshopIds,
      final Long directionWorkshopId,
      final String sourceWarehouseIds,
      final Long directionWarehouseId,
      final String projectIds,
      final Integer reviewStatus,
      final LocalDateTime reviewEndTime,
      final String approvalComments,
      final String remark,
      final Boolean boolPartyA,
      final Long approveRecordId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerIds = reviewerIds;
      this.reviewerNames = reviewerNames;
      this.basicClass = basicClass;
      this.sourceWorkshopIds = sourceWorkshopIds;
      this.directionWorkshopId = directionWorkshopId;
      this.sourceWarehouseIds = sourceWarehouseIds;
      this.directionWarehouseId = directionWarehouseId;
      this.projectIds = projectIds;
      this.reviewStatus = reviewStatus;
      this.reviewEndTime = reviewEndTime;
      this.approvalComments = approvalComments;
      this.remark = remark;
      this.boolPartyA = boolPartyA;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerIds() {
      return this.reviewerIds;
   }

   public String getReviewerNames() {
      return this.reviewerNames;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSourceWorkshopIds() {
      return this.sourceWorkshopIds;
   }

   public Long getDirectionWorkshopId() {
      return this.directionWorkshopId;
   }

   public String getSourceWarehouseIds() {
      return this.sourceWarehouseIds;
   }

   public Long getDirectionWarehouseId() {
      return this.directionWarehouseId;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewEndTime() {
      return this.reviewEndTime;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public MoveMaterial setId(final Long id) {
      this.id = id;
      return this;
   }

   public MoveMaterial setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MoveMaterial setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public MoveMaterial setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public MoveMaterial setReviewerIds(final String reviewerIds) {
      this.reviewerIds = reviewerIds;
      return this;
   }

   public MoveMaterial setReviewerNames(final String reviewerNames) {
      this.reviewerNames = reviewerNames;
      return this;
   }

   public MoveMaterial setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public MoveMaterial setSourceWorkshopIds(final String sourceWorkshopIds) {
      this.sourceWorkshopIds = sourceWorkshopIds;
      return this;
   }

   public MoveMaterial setDirectionWorkshopId(final Long directionWorkshopId) {
      this.directionWorkshopId = directionWorkshopId;
      return this;
   }

   public MoveMaterial setSourceWarehouseIds(final String sourceWarehouseIds) {
      this.sourceWarehouseIds = sourceWarehouseIds;
      return this;
   }

   public MoveMaterial setDirectionWarehouseId(final Long directionWarehouseId) {
      this.directionWarehouseId = directionWarehouseId;
      return this;
   }

   public MoveMaterial setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   public MoveMaterial setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public MoveMaterial setReviewEndTime(final LocalDateTime reviewEndTime) {
      this.reviewEndTime = reviewEndTime;
      return this;
   }

   public MoveMaterial setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
      return this;
   }

   public MoveMaterial setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MoveMaterial setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("approveRecordId")
   public MoveMaterial setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "MoveMaterial(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerIds="
         + this.getReviewerIds()
         + ", reviewerNames="
         + this.getReviewerNames()
         + ", basicClass="
         + this.getBasicClass()
         + ", sourceWorkshopIds="
         + this.getSourceWorkshopIds()
         + ", directionWorkshopId="
         + this.getDirectionWorkshopId()
         + ", sourceWarehouseIds="
         + this.getSourceWarehouseIds()
         + ", directionWarehouseId="
         + this.getDirectionWarehouseId()
         + ", projectIds="
         + this.getProjectIds()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewEndTime="
         + this.getReviewEndTime()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", remark="
         + this.getRemark()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterial)) {
         return false;
      }

      MoveMaterial other = (MoveMaterial)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$directionWorkshopId = this.getDirectionWorkshopId();
               Object other$directionWorkshopId = other.getDirectionWorkshopId();
               if (this$directionWorkshopId == null ? other$directionWorkshopId == null : this$directionWorkshopId.equals(other$directionWorkshopId)) {
                  Object this$directionWarehouseId = this.getDirectionWarehouseId();
                  Object other$directionWarehouseId = other.getDirectionWarehouseId();
                  if (this$directionWarehouseId == null ? other$directionWarehouseId == null : this$directionWarehouseId.equals(other$directionWarehouseId)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$boolPartyA = this.getBoolPartyA();
                        Object other$boolPartyA = other.getBoolPartyA();
                        if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                           Object this$approveRecordId = this.getApproveRecordId();
                           Object other$approveRecordId = other.getApproveRecordId();
                           if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$applicantName = this.getApplicantName();
                                 Object other$applicantName = other.getApplicantName();
                                 if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                    Object this$reviewerIds = this.getReviewerIds();
                                    Object other$reviewerIds = other.getReviewerIds();
                                    if (this$reviewerIds == null ? other$reviewerIds == null : this$reviewerIds.equals(other$reviewerIds)) {
                                       Object this$reviewerNames = this.getReviewerNames();
                                       Object other$reviewerNames = other.getReviewerNames();
                                       if (this$reviewerNames == null ? other$reviewerNames == null : this$reviewerNames.equals(other$reviewerNames)) {
                                          Object this$sourceWorkshopIds = this.getSourceWorkshopIds();
                                          Object other$sourceWorkshopIds = other.getSourceWorkshopIds();
                                          if (this$sourceWorkshopIds == null
                                             ? other$sourceWorkshopIds == null
                                             : this$sourceWorkshopIds.equals(other$sourceWorkshopIds)) {
                                             Object this$sourceWarehouseIds = this.getSourceWarehouseIds();
                                             Object other$sourceWarehouseIds = other.getSourceWarehouseIds();
                                             if (this$sourceWarehouseIds == null
                                                ? other$sourceWarehouseIds == null
                                                : this$sourceWarehouseIds.equals(other$sourceWarehouseIds)) {
                                                Object this$projectIds = this.getProjectIds();
                                                Object other$projectIds = other.getProjectIds();
                                                if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                   Object this$reviewEndTime = this.getReviewEndTime();
                                                   Object other$reviewEndTime = other.getReviewEndTime();
                                                   if (this$reviewEndTime == null
                                                      ? other$reviewEndTime == null
                                                      : this$reviewEndTime.equals(other$reviewEndTime)) {
                                                      Object this$approvalComments = this.getApprovalComments();
                                                      Object other$approvalComments = other.getApprovalComments();
                                                      if (this$approvalComments == null
                                                         ? other$approvalComments == null
                                                         : this$approvalComments.equals(other$approvalComments)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MoveMaterial;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $directionWorkshopId = this.getDirectionWorkshopId();
      result = result * 59 + ($directionWorkshopId == null ? 43 : $directionWorkshopId.hashCode());
      Object $directionWarehouseId = this.getDirectionWarehouseId();
      result = result * 59 + ($directionWarehouseId == null ? 43 : $directionWarehouseId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerIds = this.getReviewerIds();
      result = result * 59 + ($reviewerIds == null ? 43 : $reviewerIds.hashCode());
      Object $reviewerNames = this.getReviewerNames();
      result = result * 59 + ($reviewerNames == null ? 43 : $reviewerNames.hashCode());
      Object $sourceWorkshopIds = this.getSourceWorkshopIds();
      result = result * 59 + ($sourceWorkshopIds == null ? 43 : $sourceWorkshopIds.hashCode());
      Object $sourceWarehouseIds = this.getSourceWarehouseIds();
      result = result * 59 + ($sourceWarehouseIds == null ? 43 : $sourceWarehouseIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $reviewEndTime = this.getReviewEndTime();
      result = result * 59 + ($reviewEndTime == null ? 43 : $reviewEndTime.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MoveMaterialBuilder {
      private Long id;
      private String serialNumber;
      private Long applicantId;
      private String applicantName;
      private String reviewerIds;
      private String reviewerNames;
      private Integer basicClass;
      private String sourceWorkshopIds;
      private Long directionWorkshopId;
      private String sourceWarehouseIds;
      private Long directionWarehouseId;
      private String projectIds;
      private Integer reviewStatus;
      private LocalDateTime reviewEndTime;
      private String approvalComments;
      private String remark;
      private Boolean boolPartyA;
      private Long approveRecordId;

      MoveMaterialBuilder() {
      }

      public MoveMaterial.MoveMaterialBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder reviewerIds(final String reviewerIds) {
         this.reviewerIds = reviewerIds;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder reviewerNames(final String reviewerNames) {
         this.reviewerNames = reviewerNames;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder sourceWorkshopIds(final String sourceWorkshopIds) {
         this.sourceWorkshopIds = sourceWorkshopIds;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder directionWorkshopId(final Long directionWorkshopId) {
         this.directionWorkshopId = directionWorkshopId;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder sourceWarehouseIds(final String sourceWarehouseIds) {
         this.sourceWarehouseIds = sourceWarehouseIds;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder directionWarehouseId(final Long directionWarehouseId) {
         this.directionWarehouseId = directionWarehouseId;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder reviewEndTime(final LocalDateTime reviewEndTime) {
         this.reviewEndTime = reviewEndTime;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MoveMaterial.MoveMaterialBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("approveRecordId")
      public MoveMaterial.MoveMaterialBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public MoveMaterial build() {
         return new MoveMaterial(
            this.id,
            this.serialNumber,
            this.applicantId,
            this.applicantName,
            this.reviewerIds,
            this.reviewerNames,
            this.basicClass,
            this.sourceWorkshopIds,
            this.directionWorkshopId,
            this.sourceWarehouseIds,
            this.directionWarehouseId,
            this.projectIds,
            this.reviewStatus,
            this.reviewEndTime,
            this.approvalComments,
            this.remark,
            this.boolPartyA,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "MoveMaterial.MoveMaterialBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerIds="
            + this.reviewerIds
            + ", reviewerNames="
            + this.reviewerNames
            + ", basicClass="
            + this.basicClass
            + ", sourceWorkshopIds="
            + this.sourceWorkshopIds
            + ", directionWorkshopId="
            + this.directionWorkshopId
            + ", sourceWarehouseIds="
            + this.sourceWarehouseIds
            + ", directionWarehouseId="
            + this.directionWarehouseId
            + ", projectIds="
            + this.projectIds
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewEndTime="
            + this.reviewEndTime
            + ", approvalComments="
            + this.approvalComments
            + ", remark="
            + this.remark
            + ", boolPartyA="
            + this.boolPartyA
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
