package com.hzchum.scim.plan.core.api.pojo._do.change;

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

@ApiModel(value = "TechChangeRecord对象", description = "构件变更记录表 ")
@Entity
@TableName("tech_change_record")
@Table(name = "tech_change_record")
@org.hibernate.annotations.Table(appliesTo = "tech_change_record", comment = "构件变更记录表 ")
public class TechChangeRecord extends BaseEntity<Long> {
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
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "changeScopeEnum", value = "变更范围 1当前区域 2当前单体", notes = "变更范围 1当前区域 2当前单体")
   @TableField("change_scope_enum")
   @Column(name = "change_scope_enum", columnDefinition = "int(11)  COMMENT '变更范围 1当前区域 2当前单体'", nullable = false)
   private Integer changeScopeEnum;
   @ApiModelProperty(name = "serialNumber", value = "变更编号", notes = "变更编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '变更编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "changeReasonId", value = "变更原因ID", notes = "变更原因ID")
   @TableField("change_reason_id")
   @Column(name = "change_reason_id", columnDefinition = "bigint(20)  COMMENT '变更原因ID'", nullable = false)
   private Long changeReasonId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "userId", value = "变更人ID", notes = "变更人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '变更人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "yearMonthDay", value = "变更年月日 例:20231111", notes = "变更年月日 例:20231111")
   @TableField("year_month_day")
   @Column(name = "year_month_day", columnDefinition = "varchar(16)  COMMENT '变更年月日 例:20231111'", nullable = false)
   private String yearMonthDay;
   @ApiModelProperty(name = "sortNumber", value = "流水号", notes = "流水号")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11)  COMMENT '流水号'", nullable = false)
   private Integer sortNumber;
   @ApiModelProperty(name = "changeAttachmentIds", value = "变更图纸ID字符串", notes = "变更图纸ID字符串")
   @TableField("change_attachment_ids")
   @Column(name = "change_attachment_ids", columnDefinition = "varchar(1024)  COMMENT '变更图纸ID字符串'", nullable = true)
   private String changeAttachmentIds;
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   @TableField("check_status")
   @Column(name = "check_status", columnDefinition = "int(11) default '1' COMMENT '审核状态'", nullable = false)
   private Integer checkStatus;
   @ApiModelProperty(name = "checkUserId", value = "审核人ID", notes = "审核人ID")
   @TableField("check_user_id")
   @Column(name = "check_user_id", columnDefinition = "bigint(20)  COMMENT '审核人ID'")
   private Long checkUserId;
   @ApiModelProperty(name = "checkTime", value = "审核时间", notes = "审核时间")
   @TableField("check_time")
   @Column(name = "check_time", columnDefinition = "datetime(6)  COMMENT '审核时间'")
   private LocalDateTime checkTime;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)", notes = "构件变更类型 1修改(二次利用) 2删除  4变更(基础信息)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)'", nullable = false)
   private Integer type;

   public static TechChangeRecord.TechChangeRecordBuilder builder() {
      return new TechChangeRecord.TechChangeRecordBuilder();
   }

   public TechChangeRecord() {
   }

   public TechChangeRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Integer changeScopeEnum,
      final String serialNumber,
      final Long changeReasonId,
      final String remark,
      final Long userId,
      final String yearMonthDay,
      final Integer sortNumber,
      final String changeAttachmentIds,
      final Integer checkStatus,
      final Long checkUserId,
      final LocalDateTime checkTime,
      final Integer type
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.changeScopeEnum = changeScopeEnum;
      this.serialNumber = serialNumber;
      this.changeReasonId = changeReasonId;
      this.remark = remark;
      this.userId = userId;
      this.yearMonthDay = yearMonthDay;
      this.sortNumber = sortNumber;
      this.changeAttachmentIds = changeAttachmentIds;
      this.checkStatus = checkStatus;
      this.checkUserId = checkUserId;
      this.checkTime = checkTime;
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

   public Integer getChangeScopeEnum() {
      return this.changeScopeEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getChangeReasonId() {
      return this.changeReasonId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getYearMonthDay() {
      return this.yearMonthDay;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public String getChangeAttachmentIds() {
      return this.changeAttachmentIds;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public Integer getType() {
      return this.type;
   }

   public TechChangeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechChangeRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechChangeRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechChangeRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechChangeRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechChangeRecord setChangeScopeEnum(final Integer changeScopeEnum) {
      this.changeScopeEnum = changeScopeEnum;
      return this;
   }

   public TechChangeRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechChangeRecord setChangeReasonId(final Long changeReasonId) {
      this.changeReasonId = changeReasonId;
      return this;
   }

   public TechChangeRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechChangeRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechChangeRecord setYearMonthDay(final String yearMonthDay) {
      this.yearMonthDay = yearMonthDay;
      return this;
   }

   public TechChangeRecord setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public TechChangeRecord setChangeAttachmentIds(final String changeAttachmentIds) {
      this.changeAttachmentIds = changeAttachmentIds;
      return this;
   }

   public TechChangeRecord setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
      return this;
   }

   public TechChangeRecord setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
      return this;
   }

   public TechChangeRecord setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
      return this;
   }

   public TechChangeRecord setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "TechChangeRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", changeScopeEnum="
         + this.getChangeScopeEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", changeReasonId="
         + this.getChangeReasonId()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", yearMonthDay="
         + this.getYearMonthDay()
         + ", sortNumber="
         + this.getSortNumber()
         + ", changeAttachmentIds="
         + this.getChangeAttachmentIds()
         + ", checkStatus="
         + this.getCheckStatus()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkTime="
         + this.getCheckTime()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeRecord)) {
         return false;
      }

      TechChangeRecord other = (TechChangeRecord)o;
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
                     Object this$changeScopeEnum = this.getChangeScopeEnum();
                     Object other$changeScopeEnum = other.getChangeScopeEnum();
                     if (this$changeScopeEnum == null ? other$changeScopeEnum == null : this$changeScopeEnum.equals(other$changeScopeEnum)) {
                        Object this$changeReasonId = this.getChangeReasonId();
                        Object other$changeReasonId = other.getChangeReasonId();
                        if (this$changeReasonId == null ? other$changeReasonId == null : this$changeReasonId.equals(other$changeReasonId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$sortNumber = this.getSortNumber();
                              Object other$sortNumber = other.getSortNumber();
                              if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                                 Object this$checkStatus = this.getCheckStatus();
                                 Object other$checkStatus = other.getCheckStatus();
                                 if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
                                    Object this$checkUserId = this.getCheckUserId();
                                    Object other$checkUserId = other.getCheckUserId();
                                    if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$yearMonthDay = this.getYearMonthDay();
                                                Object other$yearMonthDay = other.getYearMonthDay();
                                                if (this$yearMonthDay == null ? other$yearMonthDay == null : this$yearMonthDay.equals(other$yearMonthDay)) {
                                                   Object this$changeAttachmentIds = this.getChangeAttachmentIds();
                                                   Object other$changeAttachmentIds = other.getChangeAttachmentIds();
                                                   if (this$changeAttachmentIds == null
                                                      ? other$changeAttachmentIds == null
                                                      : this$changeAttachmentIds.equals(other$changeAttachmentIds)) {
                                                      Object this$checkTime = this.getCheckTime();
                                                      Object other$checkTime = other.getCheckTime();
                                                      return this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime);
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
      return other instanceof TechChangeRecord;
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
      Object $changeScopeEnum = this.getChangeScopeEnum();
      result = result * 59 + ($changeScopeEnum == null ? 43 : $changeScopeEnum.hashCode());
      Object $changeReasonId = this.getChangeReasonId();
      result = result * 59 + ($changeReasonId == null ? 43 : $changeReasonId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $yearMonthDay = this.getYearMonthDay();
      result = result * 59 + ($yearMonthDay == null ? 43 : $yearMonthDay.hashCode());
      Object $changeAttachmentIds = this.getChangeAttachmentIds();
      result = result * 59 + ($changeAttachmentIds == null ? 43 : $changeAttachmentIds.hashCode());
      Object $checkTime = this.getCheckTime();
      return result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
   }

   public static class TechChangeRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Integer changeScopeEnum;
      private String serialNumber;
      private Long changeReasonId;
      private String remark;
      private Long userId;
      private String yearMonthDay;
      private Integer sortNumber;
      private String changeAttachmentIds;
      private Integer checkStatus;
      private Long checkUserId;
      private LocalDateTime checkTime;
      private Integer type;

      TechChangeRecordBuilder() {
      }

      public TechChangeRecord.TechChangeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder changeScopeEnum(final Integer changeScopeEnum) {
         this.changeScopeEnum = changeScopeEnum;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder changeReasonId(final Long changeReasonId) {
         this.changeReasonId = changeReasonId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder yearMonthDay(final String yearMonthDay) {
         this.yearMonthDay = yearMonthDay;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder changeAttachmentIds(final String changeAttachmentIds) {
         this.changeAttachmentIds = changeAttachmentIds;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder checkStatus(final Integer checkStatus) {
         this.checkStatus = checkStatus;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      public TechChangeRecord.TechChangeRecordBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechChangeRecord build() {
         return new TechChangeRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.changeScopeEnum,
            this.serialNumber,
            this.changeReasonId,
            this.remark,
            this.userId,
            this.yearMonthDay,
            this.sortNumber,
            this.changeAttachmentIds,
            this.checkStatus,
            this.checkUserId,
            this.checkTime,
            this.type
         );
      }

      @Override
      public String toString() {
         return "TechChangeRecord.TechChangeRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", changeScopeEnum="
            + this.changeScopeEnum
            + ", serialNumber="
            + this.serialNumber
            + ", changeReasonId="
            + this.changeReasonId
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", yearMonthDay="
            + this.yearMonthDay
            + ", sortNumber="
            + this.sortNumber
            + ", changeAttachmentIds="
            + this.changeAttachmentIds
            + ", checkStatus="
            + this.checkStatus
            + ", checkUserId="
            + this.checkUserId
            + ", checkTime="
            + this.checkTime
            + ", type="
            + this.type
            + ")";
      }
   }
}
