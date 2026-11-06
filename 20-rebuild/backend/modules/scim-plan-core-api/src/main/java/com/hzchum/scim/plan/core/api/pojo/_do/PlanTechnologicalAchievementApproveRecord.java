package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "PlanTechnologicalAchievementApproveRecord对象", description = "计划管理-技术成果-审批")
@Entity
@TableName("plan_technological_achievement_approve_record")
@Table(name = "plan_technological_achievement_approve_record")
@org.hibernate.annotations.Table(appliesTo = "plan_technological_achievement_approve_record", comment = "计划管理-技术成果-审批")
public class PlanTechnologicalAchievementApproveRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "moduleType", value = "例:1  枚举PlanModuleTypeEnum", notes = "例:1  枚举PlanModuleTypeEnum")
   @TableField("module_type")
   @Column(name = "module_type", columnDefinition = "int  COMMENT '例:1  枚举PlanModuleTypeEnum'", nullable = true)
   private Integer moduleType;
   @ApiModelProperty(name = "productType", value = "例:1  productTypeEnumm枚举，1.零件，2.构件，16.部件", notes = "例:1  productTypeEnumm枚举")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int  COMMENT '例:1   productTypeEnumm枚举，1.零件，2.构件，16.部件'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "dataId", value = "数据ID 例模型文件数据的id", notes = "例模型文件数据的id")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint  COMMENT '数据ID'", nullable = true)
   private Long dataId;
   @ApiModelProperty(name = "deleId", value = "删除储存的id 可能是模型(monomerId)可能是drawingId(用于校验审批中的数据不可以删除)", notes = "删除储存的id 可能是模型(monomerId)可能是drawingId")
   @TableField("dele_id")
   @Column(name = "dele_id", columnDefinition = "bigint  COMMENT '删除储存的id'", nullable = true)
   private Long deleId;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志Id", notes = "审批日志Id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志Id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "approveStatus", value = "", notes = "ReviewStatusEnum枚举")
   @TableField("approve_status")
   @Column(name = "approve_status", columnDefinition = "int default '16' COMMENT 'ReviewStatusEnum'", nullable = true)
   private Integer approveStatus;
   @ApiModelProperty(name = "remark", value = "文件上传备注", notes = "文件上传备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(2000)  COMMENT '文件上传备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "opinion", value = "审核意见", notes = "审核意见")
   @TableField("opinion")
   @Column(name = "opinion", columnDefinition = "varchar(1000)  COMMENT '审核意见'", nullable = true)
   private String opinion;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids", notes = "附件ids")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(30)   COMMENT '附件ids'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "fileNames", value = "文件名称", notes = "文件名称")
   @TableField("file_names")
   @Column(name = "file_names", columnDefinition = "varchar(300)  COMMENT '文件名称'", nullable = true)
   private String fileNames;
   @ApiModelProperty(name = "applicantId", value = " 申请人ID", notes = " 申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT ' 申请人ID'", nullable = true)
   private Long applicantId;

   public static PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder builder() {
      return new PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder();
   }

   public PlanTechnologicalAchievementApproveRecord() {
   }

   public PlanTechnologicalAchievementApproveRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer moduleType,
      final Integer productType,
      final Long dataId,
      final Long deleId,
      final Long approveRecordId,
      final Integer approveStatus,
      final String remark,
      final String opinion,
      final String attachmentIds,
      final String fileNames,
      final Long applicantId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.moduleType = moduleType;
      this.productType = productType;
      this.dataId = dataId;
      this.deleId = deleId;
      this.approveRecordId = approveRecordId;
      this.approveStatus = approveStatus;
      this.remark = remark;
      this.opinion = opinion;
      this.attachmentIds = attachmentIds;
      this.fileNames = fileNames;
      this.applicantId = applicantId;
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

   public Integer getModuleType() {
      return this.moduleType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Long getDeleId() {
      return this.deleId;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Integer getApproveStatus() {
      return this.approveStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getFileNames() {
      return this.fileNames;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public PlanTechnologicalAchievementApproveRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setDeleId(final Long deleId) {
      this.deleId = deleId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setApproveStatus(final Integer approveStatus) {
      this.approveStatus = approveStatus;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setOpinion(final String opinion) {
      this.opinion = opinion;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setFileNames(final String fileNames) {
      this.fileNames = fileNames;
      return this;
   }

   public PlanTechnologicalAchievementApproveRecord setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @Override
   public String toString() {
      return "PlanTechnologicalAchievementApproveRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", moduleType="
         + this.getModuleType()
         + ", productType="
         + this.getProductType()
         + ", dataId="
         + this.getDataId()
         + ", deleId="
         + this.getDeleId()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", approveStatus="
         + this.getApproveStatus()
         + ", remark="
         + this.getRemark()
         + ", opinion="
         + this.getOpinion()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", fileNames="
         + this.getFileNames()
         + ", applicantId="
         + this.getApplicantId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanTechnologicalAchievementApproveRecord)) {
         return false;
      }

      PlanTechnologicalAchievementApproveRecord other = (PlanTechnologicalAchievementApproveRecord)o;
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
                  Object this$moduleType = this.getModuleType();
                  Object other$moduleType = other.getModuleType();
                  if (this$moduleType == null ? other$moduleType == null : this$moduleType.equals(other$moduleType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$dataId = this.getDataId();
                        Object other$dataId = other.getDataId();
                        if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                           Object this$deleId = this.getDeleId();
                           Object other$deleId = other.getDeleId();
                           if (this$deleId == null ? other$deleId == null : this$deleId.equals(other$deleId)) {
                              Object this$approveRecordId = this.getApproveRecordId();
                              Object other$approveRecordId = other.getApproveRecordId();
                              if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                 Object this$approveStatus = this.getApproveStatus();
                                 Object other$approveStatus = other.getApproveStatus();
                                 if (this$approveStatus == null ? other$approveStatus == null : this$approveStatus.equals(other$approveStatus)) {
                                    Object this$applicantId = this.getApplicantId();
                                    Object other$applicantId = other.getApplicantId();
                                    if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$opinion = this.getOpinion();
                                          Object other$opinion = other.getOpinion();
                                          if (this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion)) {
                                             Object this$attachmentIds = this.getAttachmentIds();
                                             Object other$attachmentIds = other.getAttachmentIds();
                                             if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                                Object this$fileNames = this.getFileNames();
                                                Object other$fileNames = other.getFileNames();
                                                return this$fileNames == null ? other$fileNames == null : this$fileNames.equals(other$fileNames);
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
      return other instanceof PlanTechnologicalAchievementApproveRecord;
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
      Object $moduleType = this.getModuleType();
      result = result * 59 + ($moduleType == null ? 43 : $moduleType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $deleId = this.getDeleId();
      result = result * 59 + ($deleId == null ? 43 : $deleId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $approveStatus = this.getApproveStatus();
      result = result * 59 + ($approveStatus == null ? 43 : $approveStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $opinion = this.getOpinion();
      result = result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $fileNames = this.getFileNames();
      return result * 59 + ($fileNames == null ? 43 : $fileNames.hashCode());
   }

   public static class PlanTechnologicalAchievementApproveRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer moduleType;
      private Integer productType;
      private Long dataId;
      private Long deleId;
      private Long approveRecordId;
      private Integer approveStatus;
      private String remark;
      private String opinion;
      private String attachmentIds;
      private String fileNames;
      private Long applicantId;

      PlanTechnologicalAchievementApproveRecordBuilder() {
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder moduleType(final Integer moduleType) {
         this.moduleType = moduleType;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder deleId(final Long deleId) {
         this.deleId = deleId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder approveStatus(final Integer approveStatus) {
         this.approveStatus = approveStatus;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder opinion(final String opinion) {
         this.opinion = opinion;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder fileNames(final String fileNames) {
         this.fileNames = fileNames;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public PlanTechnologicalAchievementApproveRecord build() {
         return new PlanTechnologicalAchievementApproveRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.moduleType,
            this.productType,
            this.dataId,
            this.deleId,
            this.approveRecordId,
            this.approveStatus,
            this.remark,
            this.opinion,
            this.attachmentIds,
            this.fileNames,
            this.applicantId
         );
      }

      @Override
      public String toString() {
         return "PlanTechnologicalAchievementApproveRecord.PlanTechnologicalAchievementApproveRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", moduleType="
            + this.moduleType
            + ", productType="
            + this.productType
            + ", dataId="
            + this.dataId
            + ", deleId="
            + this.deleId
            + ", approveRecordId="
            + this.approveRecordId
            + ", approveStatus="
            + this.approveStatus
            + ", remark="
            + this.remark
            + ", opinion="
            + this.opinion
            + ", attachmentIds="
            + this.attachmentIds
            + ", fileNames="
            + this.fileNames
            + ", applicantId="
            + this.applicantId
            + ")";
      }
   }
}
