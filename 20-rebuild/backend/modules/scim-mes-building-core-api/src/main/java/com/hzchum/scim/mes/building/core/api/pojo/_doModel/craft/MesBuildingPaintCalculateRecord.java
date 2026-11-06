package com.hzchum.scim.mes.building.core.api.pojo._doModel.craft;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPaintCalculateRecord对象", description = "油漆计算记录表")
@Entity
@TableName("mes_building_paint_calculate_record")
@Table(
   name = "mes_building_paint_calculate_record",
   indexes = {
         @Index(name = "project_id", columnList = "project_id, paint_technology_id"),
         @Index(name = "paint_technology_id", columnList = "paint_technology_id, serial_number", unique = true)
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_paint_calculate_record", comment = "油漆计算记录表")
public class MesBuildingPaintCalculateRecord extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "paintTechnologyId", value = "喷漆工艺id", notes = "喷漆工艺id")
   @TableField("paint_technology_id")
   @Column(name = "paint_technology_id", columnDefinition = "bigint(20)  COMMENT '喷漆工艺id'", nullable = false)
   private Long paintTechnologyId;
   @ApiModelProperty(name = "serialNumber", value = "计算记录编号", notes = "计算记录编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '计算记录编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(64)  COMMENT '创建人名称'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "removeUserId", value = "删除人id", notes = "删除人id")
   @TableField("remove_user_id")
   @Column(name = "remove_user_id", columnDefinition = "bigint(20)  COMMENT '删除人id'", nullable = true)
   private Long removeUserId;
   @ApiModelProperty(name = "removeUserName", value = "删除人名称", notes = "删除人名称")
   @TableField("remove_user_name")
   @Column(name = "remove_user_name", columnDefinition = "varchar(64)  COMMENT '删除人名称'", nullable = true)
   private String removeUserName;
   @ApiModelProperty(name = "removeTime", value = "删除时间", notes = "删除时间")
   @TableField("remove_time")
   @Column(name = "remove_time", columnDefinition = "datetime(6)  COMMENT '删除时间'", nullable = true)
   private LocalDateTime removeTime;

   public static MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder builder() {
      return new MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder();
   }

   public MesBuildingPaintCalculateRecord() {
   }

   public MesBuildingPaintCalculateRecord(
      final Long id,
      final Long projectId,
      final Long paintTechnologyId,
      final String serialNumber,
      final Long createUserId,
      final String createUserName,
      final Long removeUserId,
      final String removeUserName,
      final LocalDateTime removeTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.paintTechnologyId = paintTechnologyId;
      this.serialNumber = serialNumber;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.removeUserId = removeUserId;
      this.removeUserName = removeUserName;
      this.removeTime = removeTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getRemoveUserId() {
      return this.removeUserId;
   }

   public String getRemoveUserName() {
      return this.removeUserName;
   }

   public LocalDateTime getRemoveTime() {
      return this.removeTime;
   }

   public MesBuildingPaintCalculateRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingPaintCalculateRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingPaintCalculateRecord setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
      return this;
   }

   public MesBuildingPaintCalculateRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingPaintCalculateRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public MesBuildingPaintCalculateRecord setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public MesBuildingPaintCalculateRecord setRemoveUserId(final Long removeUserId) {
      this.removeUserId = removeUserId;
      return this;
   }

   public MesBuildingPaintCalculateRecord setRemoveUserName(final String removeUserName) {
      this.removeUserName = removeUserName;
      return this;
   }

   public MesBuildingPaintCalculateRecord setRemoveTime(final LocalDateTime removeTime) {
      this.removeTime = removeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", removeUserId="
         + this.getRemoveUserId()
         + ", removeUserName="
         + this.getRemoveUserName()
         + ", removeTime="
         + this.getRemoveTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateRecord)) {
         return false;
      }

      MesBuildingPaintCalculateRecord other = (MesBuildingPaintCalculateRecord)o;
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
            Object this$paintTechnologyId = this.getPaintTechnologyId();
            Object other$paintTechnologyId = other.getPaintTechnologyId();
            if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$removeUserId = this.getRemoveUserId();
                  Object other$removeUserId = other.getRemoveUserId();
                  if (this$removeUserId == null ? other$removeUserId == null : this$removeUserId.equals(other$removeUserId)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$createUserName = this.getCreateUserName();
                        Object other$createUserName = other.getCreateUserName();
                        if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                           Object this$removeUserName = this.getRemoveUserName();
                           Object other$removeUserName = other.getRemoveUserName();
                           if (this$removeUserName == null ? other$removeUserName == null : this$removeUserName.equals(other$removeUserName)) {
                              Object this$removeTime = this.getRemoveTime();
                              Object other$removeTime = other.getRemoveTime();
                              return this$removeTime == null ? other$removeTime == null : this$removeTime.equals(other$removeTime);
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
      return other instanceof MesBuildingPaintCalculateRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $removeUserId = this.getRemoveUserId();
      result = result * 59 + ($removeUserId == null ? 43 : $removeUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $removeUserName = this.getRemoveUserName();
      result = result * 59 + ($removeUserName == null ? 43 : $removeUserName.hashCode());
      Object $removeTime = this.getRemoveTime();
      return result * 59 + ($removeTime == null ? 43 : $removeTime.hashCode());
   }

   public static class MesBuildingPaintCalculateRecordBuilder {
      private Long id;
      private Long projectId;
      private Long paintTechnologyId;
      private String serialNumber;
      private Long createUserId;
      private String createUserName;
      private Long removeUserId;
      private String removeUserName;
      private LocalDateTime removeTime;

      MesBuildingPaintCalculateRecordBuilder() {
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder removeUserId(final Long removeUserId) {
         this.removeUserId = removeUserId;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder removeUserName(final String removeUserName) {
         this.removeUserName = removeUserName;
         return this;
      }

      public MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder removeTime(final LocalDateTime removeTime) {
         this.removeTime = removeTime;
         return this;
      }

      public MesBuildingPaintCalculateRecord build() {
         return new MesBuildingPaintCalculateRecord(
            this.id,
            this.projectId,
            this.paintTechnologyId,
            this.serialNumber,
            this.createUserId,
            this.createUserName,
            this.removeUserId,
            this.removeUserName,
            this.removeTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPaintCalculateRecord.MesBuildingPaintCalculateRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", serialNumber="
            + this.serialNumber
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", removeUserId="
            + this.removeUserId
            + ", removeUserName="
            + this.removeUserName
            + ", removeTime="
            + this.removeTime
            + ")";
      }
   }
}
