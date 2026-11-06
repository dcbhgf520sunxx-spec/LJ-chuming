package com.hzchum.scim.mes.building.core.api.pojo._doParam.attend;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockInTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MES花名册打卡")
public class MesBuildingAttendanceDTOParam {
   @ApiModelProperty(name = "clockInTypeEnum", notes = "打卡所属类型")
   @EnumValidator(value = ClockInTypeEnum.class, message = "打卡类型不正确！")
   private Integer clockInTypeEnum;
   @ApiModelProperty(name = "point", notes = "打卡点位")
   private String point;
   @ApiModelProperty(name = "overConfigId", notes = "加班配置id")
   private Long overConfigId;

   public Integer getClockInTypeEnum() {
      return this.clockInTypeEnum;
   }

   public String getPoint() {
      return this.point;
   }

   public Long getOverConfigId() {
      return this.overConfigId;
   }

   public void setClockInTypeEnum(final Integer clockInTypeEnum) {
      this.clockInTypeEnum = clockInTypeEnum;
   }

   public void setPoint(final String point) {
      this.point = point;
   }

   public void setOverConfigId(final Long overConfigId) {
      this.overConfigId = overConfigId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceDTOParam)) {
         return false;
      }

      MesBuildingAttendanceDTOParam other = (MesBuildingAttendanceDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$clockInTypeEnum = this.getClockInTypeEnum();
      Object other$clockInTypeEnum = other.getClockInTypeEnum();
      if (this$clockInTypeEnum == null ? other$clockInTypeEnum == null : this$clockInTypeEnum.equals(other$clockInTypeEnum)) {
         Object this$overConfigId = this.getOverConfigId();
         Object other$overConfigId = other.getOverConfigId();
         if (this$overConfigId == null ? other$overConfigId == null : this$overConfigId.equals(other$overConfigId)) {
            Object this$point = this.getPoint();
            Object other$point = other.getPoint();
            return this$point == null ? other$point == null : this$point.equals(other$point);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAttendanceDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $clockInTypeEnum = this.getClockInTypeEnum();
      result = result * 59 + ($clockInTypeEnum == null ? 43 : $clockInTypeEnum.hashCode());
      Object $overConfigId = this.getOverConfigId();
      result = result * 59 + ($overConfigId == null ? 43 : $overConfigId.hashCode());
      Object $point = this.getPoint();
      return result * 59 + ($point == null ? 43 : $point.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceDTOParam(clockInTypeEnum="
         + this.getClockInTypeEnum()
         + ", point="
         + this.getPoint()
         + ", overConfigId="
         + this.getOverConfigId()
         + ")";
   }
}
