package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

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

@ApiModel(value = "MesBuildingAttendanceOverConfigUserLink对象", description = "")
@Entity
@TableName("mes_building_attendance_over_config_user_link")
@Table(name = "mes_building_attendance_over_config_user_link")
@org.hibernate.annotations.Table(appliesTo = "mes_building_attendance_over_config_user_link")
public class MesBuildingAttendanceOverConfigUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "overConfigId", value = "加班配置id", notes = "加班配置id")
   @TableField("over_config_id")
   @Column(name = "over_config_id", columnDefinition = "bigint(20)  COMMENT '加班配置id'", nullable = true)
   private Long overConfigId;
   @ApiModelProperty(name = "rosterId", value = "劳务id", notes = "劳务id")
   @TableField("roster_id")
   @Column(name = "roster_id", columnDefinition = "bigint(20)  COMMENT '劳务id'", nullable = true)
   private Long rosterId;

   public static MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder builder() {
      return new MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder();
   }

   public MesBuildingAttendanceOverConfigUserLink() {
   }

   public MesBuildingAttendanceOverConfigUserLink(final Long id, final Long overConfigId, final Long rosterId) {
      this.id = id;
      this.overConfigId = overConfigId;
      this.rosterId = rosterId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOverConfigId() {
      return this.overConfigId;
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public MesBuildingAttendanceOverConfigUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAttendanceOverConfigUserLink setOverConfigId(final Long overConfigId) {
      this.overConfigId = overConfigId;
      return this;
   }

   public MesBuildingAttendanceOverConfigUserLink setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceOverConfigUserLink(id="
         + this.getId()
         + ", overConfigId="
         + this.getOverConfigId()
         + ", rosterId="
         + this.getRosterId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceOverConfigUserLink)) {
         return false;
      }

      MesBuildingAttendanceOverConfigUserLink other = (MesBuildingAttendanceOverConfigUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$overConfigId = this.getOverConfigId();
         Object other$overConfigId = other.getOverConfigId();
         if (this$overConfigId == null ? other$overConfigId == null : this$overConfigId.equals(other$overConfigId)) {
            Object this$rosterId = this.getRosterId();
            Object other$rosterId = other.getRosterId();
            return this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAttendanceOverConfigUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $overConfigId = this.getOverConfigId();
      result = result * 59 + ($overConfigId == null ? 43 : $overConfigId.hashCode());
      Object $rosterId = this.getRosterId();
      return result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
   }

   public static class MesBuildingAttendanceOverConfigUserLinkBuilder {
      private Long id;
      private Long overConfigId;
      private Long rosterId;

      MesBuildingAttendanceOverConfigUserLinkBuilder() {
      }

      public MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder overConfigId(final Long overConfigId) {
         this.overConfigId = overConfigId;
         return this;
      }

      public MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesBuildingAttendanceOverConfigUserLink build() {
         return new MesBuildingAttendanceOverConfigUserLink(this.id, this.overConfigId, this.rosterId);
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceOverConfigUserLink.MesBuildingAttendanceOverConfigUserLinkBuilder(id="
            + this.id
            + ", overConfigId="
            + this.overConfigId
            + ", rosterId="
            + this.rosterId
            + ")";
      }
   }
}
