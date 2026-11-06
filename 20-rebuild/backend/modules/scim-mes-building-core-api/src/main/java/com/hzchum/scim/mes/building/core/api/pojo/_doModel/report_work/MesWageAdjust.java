package com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work;

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

@ApiModel(value = "MesWageAdjust对象", description = "工价调整表")
@Entity
@TableName("mes_wage_adjust")
@Table(name = "mes_wage_adjust")
@org.hibernate.annotations.Table(appliesTo = "mes_wage_adjust", comment = "工价调整表")
public class MesWageAdjust extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty("产品类型")
   @TableField("product_type_enum")
   @Column(name = "product_type_enum", columnDefinition = "int(11) COMMENT '产品类型'", nullable = true)
   private Integer productTypeEnum;
   @ApiModelProperty("车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("班组ids")
   @TableField("team_ids")
   @Column(name = "team_ids", columnDefinition = "varchar(255) COMMENT '班组ids'", nullable = true)
   private String teamIds;
   @ApiModelProperty("创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty("审批人id")
   @TableField("approve_user_id")
   @Column(name = "approve_user_id", columnDefinition = "bigint(20) COMMENT '审批人id'", nullable = true)
   private Long approveUserId;
   @ApiModelProperty("审批日期")
   @TableField("approve_date")
   @Column(name = "approve_date", columnDefinition = "datetime COMMENT '审批日期'", nullable = true)
   private LocalDateTime approveDate;
   @ApiModelProperty("审批状态")
   @TableField("approval_status")
   @Column(name = "approval_status", columnDefinition = "int(11) COMMENT '审批状态'", nullable = true)
   private Integer approvalStatus;
   @ApiModelProperty("审批日志ID")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20) COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty("审批日志编号")
   @TableField("approve_record_serial_number")
   @Column(name = "approve_record_serial_number", columnDefinition = "varchar(255) COMMENT '审批日志编号'", nullable = true)
   private String approveRecordSerialNumber;

   public static MesWageAdjust.MesWageAdjustBuilder builder() {
      return new MesWageAdjust.MesWageAdjustBuilder();
   }

   public MesWageAdjust() {
   }

   public MesWageAdjust(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Integer productTypeEnum,
      final Long workshopId,
      final Long processId,
      final String teamIds,
      final Long createUserId,
      final Long approveUserId,
      final LocalDateTime approveDate,
      final Integer approvalStatus,
      final Long approveRecordId,
      final String approveRecordSerialNumber
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productTypeEnum = productTypeEnum;
      this.workshopId = workshopId;
      this.processId = processId;
      this.teamIds = teamIds;
      this.createUserId = createUserId;
      this.approveUserId = approveUserId;
      this.approveDate = approveDate;
      this.approvalStatus = approvalStatus;
      this.approveRecordId = approveRecordId;
      this.approveRecordSerialNumber = approveRecordSerialNumber;
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

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getTeamIds() {
      return this.teamIds;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getApproveUserId() {
      return this.approveUserId;
   }

   public LocalDateTime getApproveDate() {
      return this.approveDate;
   }

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getApproveRecordSerialNumber() {
      return this.approveRecordSerialNumber;
   }

   public MesWageAdjust setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesWageAdjust setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesWageAdjust setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesWageAdjust setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   public MesWageAdjust setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesWageAdjust setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesWageAdjust setTeamIds(final String teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   public MesWageAdjust setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public MesWageAdjust setApproveUserId(final Long approveUserId) {
      this.approveUserId = approveUserId;
      return this;
   }

   public MesWageAdjust setApproveDate(final LocalDateTime approveDate) {
      this.approveDate = approveDate;
      return this;
   }

   public MesWageAdjust setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
      return this;
   }

   public MesWageAdjust setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public MesWageAdjust setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesWageAdjust(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamIds="
         + this.getTeamIds()
         + ", createUserId="
         + this.getCreateUserId()
         + ", approveUserId="
         + this.getApproveUserId()
         + ", approveDate="
         + this.getApproveDate()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjust)) {
         return false;
      }

      MesWageAdjust other = (MesWageAdjust)o;
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
               Object this$productTypeEnum = this.getProductTypeEnum();
               Object other$productTypeEnum = other.getProductTypeEnum();
               if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$createUserId = this.getCreateUserId();
                        Object other$createUserId = other.getCreateUserId();
                        if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                           Object this$approveUserId = this.getApproveUserId();
                           Object other$approveUserId = other.getApproveUserId();
                           if (this$approveUserId == null ? other$approveUserId == null : this$approveUserId.equals(other$approveUserId)) {
                              Object this$approvalStatus = this.getApprovalStatus();
                              Object other$approvalStatus = other.getApprovalStatus();
                              if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
                                 Object this$approveRecordId = this.getApproveRecordId();
                                 Object other$approveRecordId = other.getApproveRecordId();
                                 if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                    Object this$teamIds = this.getTeamIds();
                                    Object other$teamIds = other.getTeamIds();
                                    if (this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds)) {
                                       Object this$approveDate = this.getApproveDate();
                                       Object other$approveDate = other.getApproveDate();
                                       if (this$approveDate == null ? other$approveDate == null : this$approveDate.equals(other$approveDate)) {
                                          Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
                                          Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
                                          return this$approveRecordSerialNumber == null
                                             ? other$approveRecordSerialNumber == null
                                             : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber);
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
      return other instanceof MesWageAdjust;
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
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $approveUserId = this.getApproveUserId();
      result = result * 59 + ($approveUserId == null ? 43 : $approveUserId.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $teamIds = this.getTeamIds();
      result = result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
      Object $approveDate = this.getApproveDate();
      result = result * 59 + ($approveDate == null ? 43 : $approveDate.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      return result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
   }

   public static class MesWageAdjustBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer productTypeEnum;
      private Long workshopId;
      private Long processId;
      private String teamIds;
      private Long createUserId;
      private Long approveUserId;
      private LocalDateTime approveDate;
      private Integer approvalStatus;
      private Long approveRecordId;
      private String approveRecordSerialNumber;

      MesWageAdjustBuilder() {
      }

      public MesWageAdjust.MesWageAdjustBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder teamIds(final String teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder approveUserId(final Long approveUserId) {
         this.approveUserId = approveUserId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder approveDate(final LocalDateTime approveDate) {
         this.approveDate = approveDate;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public MesWageAdjust.MesWageAdjustBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public MesWageAdjust build() {
         return new MesWageAdjust(
            this.id,
            this.projectId,
            this.monomerId,
            this.productTypeEnum,
            this.workshopId,
            this.processId,
            this.teamIds,
            this.createUserId,
            this.approveUserId,
            this.approveDate,
            this.approvalStatus,
            this.approveRecordId,
            this.approveRecordSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesWageAdjust.MesWageAdjustBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productTypeEnum="
            + this.productTypeEnum
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", teamIds="
            + this.teamIds
            + ", createUserId="
            + this.createUserId
            + ", approveUserId="
            + this.approveUserId
            + ", approveDate="
            + this.approveDate
            + ", approvalStatus="
            + this.approvalStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ")";
      }
   }
}
