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

@ApiModel(value = "TechEnclosureChangeRecord对象", description = "")
@Entity
@TableName("tech_enclosure_change_record")
@Table(name = "tech_enclosure_change_record")
@org.hibernate.annotations.Table(appliesTo = "tech_enclosure_change_record")
public class TechEnclosureChangeRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "sortNumber", value = "流水号", notes = "流水号")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11)  COMMENT '流水号'", nullable = false)
   private Integer sortNumber;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "变更编号", notes = "变更编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '变更编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "userId", value = "变更人ID", notes = "变更人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '变更人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "yearMonthDay", value = "变更年月日 例:20231111", notes = "变更年月日 例:20231111")
   @TableField("year_month_day")
   @Column(name = "year_month_day", columnDefinition = "varchar(16)  COMMENT '变更年月日 例:20231111'", nullable = false)
   private String yearMonthDay;
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   @TableField("check_status")
   @Column(name = "check_status", columnDefinition = "int default '1' COMMENT '审核状态'", nullable = false)
   private Integer checkStatus;
   @ApiModelProperty(name = "checkUserId", value = "审核人ID", notes = "审核人ID")
   @TableField("check_user_id")
   @Column(name = "check_user_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long checkUserId;
   @ApiModelProperty(name = "checkTime", value = "审核时间", notes = "审核时间")
   @TableField("check_time")
   @Column(name = "check_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime checkTime;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)", notes = "构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)'", nullable = false)
   private Integer type;

   public static TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder builder() {
      return new TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder();
   }

   public TechEnclosureChangeRecord() {
   }

   public TechEnclosureChangeRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Integer sortNumber,
      final Long areaId,
      final String serialNumber,
      final String remark,
      final Long userId,
      final String yearMonthDay,
      final Integer checkStatus,
      final Long checkUserId,
      final LocalDateTime checkTime,
      final Integer type
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.sortNumber = sortNumber;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.remark = remark;
      this.userId = userId;
      this.yearMonthDay = yearMonthDay;
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

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public TechEnclosureChangeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureChangeRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechEnclosureChangeRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechEnclosureChangeRecord setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public TechEnclosureChangeRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechEnclosureChangeRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechEnclosureChangeRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechEnclosureChangeRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechEnclosureChangeRecord setYearMonthDay(final String yearMonthDay) {
      this.yearMonthDay = yearMonthDay;
      return this;
   }

   public TechEnclosureChangeRecord setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
      return this;
   }

   public TechEnclosureChangeRecord setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
      return this;
   }

   public TechEnclosureChangeRecord setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
      return this;
   }

   public TechEnclosureChangeRecord setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", sortNumber="
         + this.getSortNumber()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", yearMonthDay="
         + this.getYearMonthDay()
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

      if (!(o instanceof TechEnclosureChangeRecord)) {
         return false;
      }

      TechEnclosureChangeRecord other = (TechEnclosureChangeRecord)o;
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
               Object this$sortNumber = this.getSortNumber();
               Object other$sortNumber = other.getSortNumber();
               if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechEnclosureChangeRecord;
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
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
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
      Object $checkTime = this.getCheckTime();
      return result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
   }

   public static class TechEnclosureChangeRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer sortNumber;
      private Long areaId;
      private String serialNumber;
      private String remark;
      private Long userId;
      private String yearMonthDay;
      private Integer checkStatus;
      private Long checkUserId;
      private LocalDateTime checkTime;
      private Integer type;

      TechEnclosureChangeRecordBuilder() {
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder yearMonthDay(final String yearMonthDay) {
         this.yearMonthDay = yearMonthDay;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder checkStatus(final Integer checkStatus) {
         this.checkStatus = checkStatus;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      public TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechEnclosureChangeRecord build() {
         return new TechEnclosureChangeRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.sortNumber,
            this.areaId,
            this.serialNumber,
            this.remark,
            this.userId,
            this.yearMonthDay,
            this.checkStatus,
            this.checkUserId,
            this.checkTime,
            this.type
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChangeRecord.TechEnclosureChangeRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", sortNumber="
            + this.sortNumber
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", yearMonthDay="
            + this.yearMonthDay
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
