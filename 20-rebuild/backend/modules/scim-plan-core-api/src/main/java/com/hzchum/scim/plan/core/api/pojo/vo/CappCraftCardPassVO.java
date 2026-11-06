package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(description = "CAPP 焊接产品焊道列表 响应参数")
public class CappCraftCardPassVO {
   @ApiModelProperty(name = "passId", value = "道次id", notes = "道次id")
   private Long passId;
   @ApiModelProperty(name = "passName", value = "道次名称", notes = "道次名称")
   private String passName;
   @ApiModelProperty(name = "equimentSerialNumber", value = "设备编号", notes = "设备编号")
   private String equimentSerialNumber;
   @ApiModelProperty(name = "equimentName", value = "设备名称", notes = "设备名称")
   private String equimentName;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   private String equimentCode;
   @ApiModelProperty(name = "weldUserName", value = "实际焊接人名称", notes = "实际焊接人名称")
   private String weldUserName;
   @ApiModelProperty(name = "startTime", value = "焊接开始时间", notes = "焊接开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "焊接结束时间", notes = "焊接结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "actualTime", value = "焊接实际时长 h:mm", notes = "焊接实际时长 h:mm")
   private String actualTime;

   public static CappCraftCardPassVO.CappCraftCardPassVOBuilder builder() {
      return new CappCraftCardPassVO.CappCraftCardPassVOBuilder();
   }

   public Long getPassId() {
      return this.passId;
   }

   public String getPassName() {
      return this.passName;
   }

   public String getEquimentSerialNumber() {
      return this.equimentSerialNumber;
   }

   public String getEquimentName() {
      return this.equimentName;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getWeldUserName() {
      return this.weldUserName;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public String getActualTime() {
      return this.actualTime;
   }

   public void setPassId(final Long passId) {
      this.passId = passId;
   }

   public void setPassName(final String passName) {
      this.passName = passName;
   }

   public void setEquimentSerialNumber(final String equimentSerialNumber) {
      this.equimentSerialNumber = equimentSerialNumber;
   }

   public void setEquimentName(final String equimentName) {
      this.equimentName = equimentName;
   }

   public void setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
   }

   public void setWeldUserName(final String weldUserName) {
      this.weldUserName = weldUserName;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setActualTime(final String actualTime) {
      this.actualTime = actualTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardPassVO)) {
         return false;
      }

      CappCraftCardPassVO other = (CappCraftCardPassVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$passId = this.getPassId();
      Object other$passId = other.getPassId();
      if (this$passId == null ? other$passId == null : this$passId.equals(other$passId)) {
         Object this$passName = this.getPassName();
         Object other$passName = other.getPassName();
         if (this$passName == null ? other$passName == null : this$passName.equals(other$passName)) {
            Object this$equimentSerialNumber = this.getEquimentSerialNumber();
            Object other$equimentSerialNumber = other.getEquimentSerialNumber();
            if (this$equimentSerialNumber == null ? other$equimentSerialNumber == null : this$equimentSerialNumber.equals(other$equimentSerialNumber)) {
               Object this$equimentName = this.getEquimentName();
               Object other$equimentName = other.getEquimentName();
               if (this$equimentName == null ? other$equimentName == null : this$equimentName.equals(other$equimentName)) {
                  Object this$equimentCode = this.getEquimentCode();
                  Object other$equimentCode = other.getEquimentCode();
                  if (this$equimentCode == null ? other$equimentCode == null : this$equimentCode.equals(other$equimentCode)) {
                     Object this$weldUserName = this.getWeldUserName();
                     Object other$weldUserName = other.getWeldUserName();
                     if (this$weldUserName == null ? other$weldUserName == null : this$weldUserName.equals(other$weldUserName)) {
                        Object this$startTime = this.getStartTime();
                        Object other$startTime = other.getStartTime();
                        if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                           Object this$endTime = this.getEndTime();
                           Object other$endTime = other.getEndTime();
                           if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                              Object this$actualTime = this.getActualTime();
                              Object other$actualTime = other.getActualTime();
                              return this$actualTime == null ? other$actualTime == null : this$actualTime.equals(other$actualTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardPassVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $passId = this.getPassId();
      result = result * 59 + ($passId == null ? 43 : $passId.hashCode());
      Object $passName = this.getPassName();
      result = result * 59 + ($passName == null ? 43 : $passName.hashCode());
      Object $equimentSerialNumber = this.getEquimentSerialNumber();
      result = result * 59 + ($equimentSerialNumber == null ? 43 : $equimentSerialNumber.hashCode());
      Object $equimentName = this.getEquimentName();
      result = result * 59 + ($equimentName == null ? 43 : $equimentName.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $weldUserName = this.getWeldUserName();
      result = result * 59 + ($weldUserName == null ? 43 : $weldUserName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $actualTime = this.getActualTime();
      return result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardPassVO(passId="
         + this.getPassId()
         + ", passName="
         + this.getPassName()
         + ", equimentSerialNumber="
         + this.getEquimentSerialNumber()
         + ", equimentName="
         + this.getEquimentName()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", weldUserName="
         + this.getWeldUserName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", actualTime="
         + this.getActualTime()
         + ")";
   }

   public CappCraftCardPassVO(
      final Long passId,
      final String passName,
      final String equimentSerialNumber,
      final String equimentName,
      final String equimentCode,
      final String weldUserName,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final String actualTime
   ) {
      this.passId = passId;
      this.passName = passName;
      this.equimentSerialNumber = equimentSerialNumber;
      this.equimentName = equimentName;
      this.equimentCode = equimentCode;
      this.weldUserName = weldUserName;
      this.startTime = startTime;
      this.endTime = endTime;
      this.actualTime = actualTime;
   }

   public CappCraftCardPassVO() {
   }

   public static class CappCraftCardPassVOBuilder {
      private Long passId;
      private String passName;
      private String equimentSerialNumber;
      private String equimentName;
      private String equimentCode;
      private String weldUserName;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private String actualTime;

      CappCraftCardPassVOBuilder() {
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder passId(final Long passId) {
         this.passId = passId;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder passName(final String passName) {
         this.passName = passName;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder equimentSerialNumber(final String equimentSerialNumber) {
         this.equimentSerialNumber = equimentSerialNumber;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder equimentName(final String equimentName) {
         this.equimentName = equimentName;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder equimentCode(final String equimentCode) {
         this.equimentCode = equimentCode;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder weldUserName(final String weldUserName) {
         this.weldUserName = weldUserName;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public CappCraftCardPassVO.CappCraftCardPassVOBuilder actualTime(final String actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      public CappCraftCardPassVO build() {
         return new CappCraftCardPassVO(
            this.passId,
            this.passName,
            this.equimentSerialNumber,
            this.equimentName,
            this.equimentCode,
            this.weldUserName,
            this.startTime,
            this.endTime,
            this.actualTime
         );
      }

      @Override
      public String toString() {
         return "CappCraftCardPassVO.CappCraftCardPassVOBuilder(passId="
            + this.passId
            + ", passName="
            + this.passName
            + ", equimentSerialNumber="
            + this.equimentSerialNumber
            + ", equimentName="
            + this.equimentName
            + ", equimentCode="
            + this.equimentCode
            + ", weldUserName="
            + this.weldUserName
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", actualTime="
            + this.actualTime
            + ")";
      }
   }
}
