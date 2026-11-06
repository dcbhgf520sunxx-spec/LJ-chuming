package com.hzchum.scim.mes.building.core.api.pojo._doModel.craft;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesPaintingCraft对象", description = "涂装工艺表")
@Entity
@TableName("mes_painting_craft")
@Table(name = "mes_painting_craft")
@org.hibernate.annotations.Table(appliesTo = "mes_painting_craft", comment = "涂装工艺表")
public class MesPaintingCraft extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(225) COMMENT '编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体ids")
   @TableField(value = "monomer_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "monomer_ids", columnDefinition = "varchar(500) COMMENT '单体id'", nullable = true)
   private String monomerIds;
   @ApiModelProperty("表面积(㎡)")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) COMMENT '表面积(㎡)'", nullable = true)
   private BigDecimal surfaceArea;
   @ApiModelProperty("备注")
   @TableField(value = "remark", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "remark", columnDefinition = "varchar(225) COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty("创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty("创建日期")
   @TableField("create_date")
   @Column(name = "create_date", columnDefinition = "datetime COMMENT '创建日期'", nullable = true)
   private LocalDateTime createDate;
   @ApiModelProperty("审批人id")
   @TableField(value = "approval_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "approval_user_id", columnDefinition = "bigint(20) COMMENT '审批人id'", nullable = true)
   private Long approvalUserId;
   @ApiModelProperty("审批时间")
   @TableField(value = "approval_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "approval_time", columnDefinition = "datetime COMMENT '审批日期'", nullable = true)
   private LocalDateTime approvalTime;
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
   @ApiModelProperty("是否作废(1: 已作废, 0: 未作废)")
   @TableField("bool_invalid")
   @Column(name = "bool_invalid", columnDefinition = "tinyint(1) default 0 COMMENT '是否作废(1: 已作废, 0: 未作废)'", nullable = true)
   private Boolean boolInvalid;
   @ApiModelProperty("旧数据id")
   @TableField(value = "old_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "old_id", columnDefinition = "bigint(20) COMMENT '旧数据id'", nullable = true)
   private Long oldId;
   @ApiModelProperty("是否审批中(1:是, 0:否)")
   @TableField("bool_in_approval")
   @Column(name = "bool_in_approval", columnDefinition = "tinyint(1) default 0 COMMENT '是否审批中(1:是, 0:否)'", nullable = true)
   private Boolean boolInApproval;
   @ApiModelProperty("旧数据")
   @TableField(value = "old_data", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "old_data", columnDefinition = "text COMMENT '旧数据'", nullable = true)
   private String oldData;

   public static MesPaintingCraft.MesPaintingCraftBuilder builder() {
      return new MesPaintingCraft.MesPaintingCraftBuilder();
   }

   public MesPaintingCraft() {
   }

   public MesPaintingCraft(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final String monomerIds,
      final BigDecimal surfaceArea,
      final String remark,
      final Long createUserId,
      final LocalDateTime createDate,
      final Long approvalUserId,
      final LocalDateTime approvalTime,
      final Integer approvalStatus,
      final Long approveRecordId,
      final String approveRecordSerialNumber,
      final Boolean boolInvalid,
      final Long oldId,
      final Boolean boolInApproval,
      final String oldData
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.monomerIds = monomerIds;
      this.surfaceArea = surfaceArea;
      this.remark = remark;
      this.createUserId = createUserId;
      this.createDate = createDate;
      this.approvalUserId = approvalUserId;
      this.approvalTime = approvalTime;
      this.approvalStatus = approvalStatus;
      this.approveRecordId = approveRecordId;
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      this.boolInvalid = boolInvalid;
      this.oldId = oldId;
      this.boolInApproval = boolInApproval;
      this.oldData = oldData;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getMonomerIds() {
      return this.monomerIds;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public Long getApprovalUserId() {
      return this.approvalUserId;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
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

   public Boolean getBoolInvalid() {
      return this.boolInvalid;
   }

   public Long getOldId() {
      return this.oldId;
   }

   public Boolean getBoolInApproval() {
      return this.boolInApproval;
   }

   public String getOldData() {
      return this.oldData;
   }

   public MesPaintingCraft setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPaintingCraft setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesPaintingCraft setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesPaintingCraft setMonomerIds(final String monomerIds) {
      this.monomerIds = monomerIds;
      return this;
   }

   public MesPaintingCraft setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MesPaintingCraft setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesPaintingCraft setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public MesPaintingCraft setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
      return this;
   }

   public MesPaintingCraft setApprovalUserId(final Long approvalUserId) {
      this.approvalUserId = approvalUserId;
      return this;
   }

   public MesPaintingCraft setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
      return this;
   }

   public MesPaintingCraft setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
      return this;
   }

   public MesPaintingCraft setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public MesPaintingCraft setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      return this;
   }

   public MesPaintingCraft setBoolInvalid(final Boolean boolInvalid) {
      this.boolInvalid = boolInvalid;
      return this;
   }

   public MesPaintingCraft setOldId(final Long oldId) {
      this.oldId = oldId;
      return this;
   }

   public MesPaintingCraft setBoolInApproval(final Boolean boolInApproval) {
      this.boolInApproval = boolInApproval;
      return this;
   }

   public MesPaintingCraft setOldData(final String oldData) {
      this.oldData = oldData;
      return this;
   }

   @Override
   public String toString() {
      return "MesPaintingCraft(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", monomerIds="
         + this.getMonomerIds()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createDate="
         + this.getCreateDate()
         + ", approvalUserId="
         + this.getApprovalUserId()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ", boolInvalid="
         + this.getBoolInvalid()
         + ", oldId="
         + this.getOldId()
         + ", boolInApproval="
         + this.getBoolInApproval()
         + ", oldData="
         + this.getOldData()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraft)) {
         return false;
      }

      MesPaintingCraft other = (MesPaintingCraft)o;
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
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$approvalUserId = this.getApprovalUserId();
               Object other$approvalUserId = other.getApprovalUserId();
               if (this$approvalUserId == null ? other$approvalUserId == null : this$approvalUserId.equals(other$approvalUserId)) {
                  Object this$approvalStatus = this.getApprovalStatus();
                  Object other$approvalStatus = other.getApprovalStatus();
                  if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$boolInvalid = this.getBoolInvalid();
                        Object other$boolInvalid = other.getBoolInvalid();
                        if (this$boolInvalid == null ? other$boolInvalid == null : this$boolInvalid.equals(other$boolInvalid)) {
                           Object this$oldId = this.getOldId();
                           Object other$oldId = other.getOldId();
                           if (this$oldId == null ? other$oldId == null : this$oldId.equals(other$oldId)) {
                              Object this$boolInApproval = this.getBoolInApproval();
                              Object other$boolInApproval = other.getBoolInApproval();
                              if (this$boolInApproval == null ? other$boolInApproval == null : this$boolInApproval.equals(other$boolInApproval)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$monomerIds = this.getMonomerIds();
                                    Object other$monomerIds = other.getMonomerIds();
                                    if (this$monomerIds == null ? other$monomerIds == null : this$monomerIds.equals(other$monomerIds)) {
                                       Object this$surfaceArea = this.getSurfaceArea();
                                       Object other$surfaceArea = other.getSurfaceArea();
                                       if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$createDate = this.getCreateDate();
                                             Object other$createDate = other.getCreateDate();
                                             if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                                                Object this$approvalTime = this.getApprovalTime();
                                                Object other$approvalTime = other.getApprovalTime();
                                                if (this$approvalTime == null ? other$approvalTime == null : this$approvalTime.equals(other$approvalTime)) {
                                                   Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
                                                   Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
                                                   if (this$approveRecordSerialNumber == null
                                                      ? other$approveRecordSerialNumber == null
                                                      : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber)) {
                                                      Object this$oldData = this.getOldData();
                                                      Object other$oldData = other.getOldData();
                                                      return this$oldData == null ? other$oldData == null : this$oldData.equals(other$oldData);
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
      return other instanceof MesPaintingCraft;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $approvalUserId = this.getApprovalUserId();
      result = result * 59 + ($approvalUserId == null ? 43 : $approvalUserId.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $boolInvalid = this.getBoolInvalid();
      result = result * 59 + ($boolInvalid == null ? 43 : $boolInvalid.hashCode());
      Object $oldId = this.getOldId();
      result = result * 59 + ($oldId == null ? 43 : $oldId.hashCode());
      Object $boolInApproval = this.getBoolInApproval();
      result = result * 59 + ($boolInApproval == null ? 43 : $boolInApproval.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $monomerIds = this.getMonomerIds();
      result = result * 59 + ($monomerIds == null ? 43 : $monomerIds.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $approvalTime = this.getApprovalTime();
      result = result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      result = result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
      Object $oldData = this.getOldData();
      return result * 59 + ($oldData == null ? 43 : $oldData.hashCode());
   }

   public static class MesPaintingCraftBuilder {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private String monomerIds;
      private BigDecimal surfaceArea;
      private String remark;
      private Long createUserId;
      private LocalDateTime createDate;
      private Long approvalUserId;
      private LocalDateTime approvalTime;
      private Integer approvalStatus;
      private Long approveRecordId;
      private String approveRecordSerialNumber;
      private Boolean boolInvalid;
      private Long oldId;
      private Boolean boolInApproval;
      private String oldData;

      MesPaintingCraftBuilder() {
      }

      public MesPaintingCraft.MesPaintingCraftBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder monomerIds(final String monomerIds) {
         this.monomerIds = monomerIds;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder createDate(final LocalDateTime createDate) {
         this.createDate = createDate;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder approvalUserId(final Long approvalUserId) {
         this.approvalUserId = approvalUserId;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder approvalTime(final LocalDateTime approvalTime) {
         this.approvalTime = approvalTime;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder boolInvalid(final Boolean boolInvalid) {
         this.boolInvalid = boolInvalid;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder oldId(final Long oldId) {
         this.oldId = oldId;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder boolInApproval(final Boolean boolInApproval) {
         this.boolInApproval = boolInApproval;
         return this;
      }

      public MesPaintingCraft.MesPaintingCraftBuilder oldData(final String oldData) {
         this.oldData = oldData;
         return this;
      }

      public MesPaintingCraft build() {
         return new MesPaintingCraft(
            this.id,
            this.serialNumber,
            this.projectId,
            this.monomerIds,
            this.surfaceArea,
            this.remark,
            this.createUserId,
            this.createDate,
            this.approvalUserId,
            this.approvalTime,
            this.approvalStatus,
            this.approveRecordId,
            this.approveRecordSerialNumber,
            this.boolInvalid,
            this.oldId,
            this.boolInApproval,
            this.oldData
         );
      }

      @Override
      public String toString() {
         return "MesPaintingCraft.MesPaintingCraftBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", monomerIds="
            + this.monomerIds
            + ", surfaceArea="
            + this.surfaceArea
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", createDate="
            + this.createDate
            + ", approvalUserId="
            + this.approvalUserId
            + ", approvalTime="
            + this.approvalTime
            + ", approvalStatus="
            + this.approvalStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ", boolInvalid="
            + this.boolInvalid
            + ", oldId="
            + this.oldId
            + ", boolInApproval="
            + this.boolInApproval
            + ", oldData="
            + this.oldData
            + ")";
      }
   }
}
