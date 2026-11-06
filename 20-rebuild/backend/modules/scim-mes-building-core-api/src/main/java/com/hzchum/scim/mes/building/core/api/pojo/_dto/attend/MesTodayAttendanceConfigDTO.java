package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.OvertimeClockDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ExcelTarget("MesBuildingAttendanceStandConfigDTO")
@ApiModel("当日考勤配置和已考勤信息返回类")
public class MesTodayAttendanceConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "rosterId", value = "花名册id", notes = "花名册id")
   private Long rosterId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   private Long userId;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "standConfigDTO", value = "标准配置", notes = "标准配置")
   private MesBuildingAttendanceStandConfigDTO standConfigDTO;
   @ApiModelProperty(name = "overConfigDTO", value = "加班配置列表", notes = "加班配置列表")
   private List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList;
   @ApiModelProperty(name = "overClockList", value = "加班打卡列表", notes = "加班打卡列表")
   private List<OvertimeClockDTO> overClockList;
   @ApiModelProperty(name = "pointDTOList", notes = "电子围栏")
   @JsonInclude(Include.NON_NULL)
   private List<PointDTO> pointDTOList;

   public static MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder builder() {
      return new MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getMorningWorkingTime() {
      return this.morningWorkingTime;
   }

   public LocalDateTime getMorningClosingTime() {
      return this.morningClosingTime;
   }

   public LocalDateTime getAfternoonWorkingTime() {
      return this.afternoonWorkingTime;
   }

   public LocalDateTime getAfternoonClosingTime() {
      return this.afternoonClosingTime;
   }

   public MesBuildingAttendanceStandConfigDTO getStandConfigDTO() {
      return this.standConfigDTO;
   }

   public List<MesBuildingAttendanceOverConfigDTO> getOverConfigDTOList() {
      return this.overConfigDTOList;
   }

   public List<OvertimeClockDTO> getOverClockList() {
      return this.overClockList;
   }

   public List<PointDTO> getPointDTOList() {
      return this.pointDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
   }

   public void setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
   }

   public void setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
   }

   public void setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
   }

   public void setStandConfigDTO(final MesBuildingAttendanceStandConfigDTO standConfigDTO) {
      this.standConfigDTO = standConfigDTO;
   }

   public void setOverConfigDTOList(final List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList) {
      this.overConfigDTOList = overConfigDTOList;
   }

   public void setOverClockList(final List<OvertimeClockDTO> overClockList) {
      this.overClockList = overClockList;
   }

   public void setPointDTOList(final List<PointDTO> pointDTOList) {
      this.pointDTOList = pointDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTodayAttendanceConfigDTO)) {
         return false;
      }

      MesTodayAttendanceConfigDTO other = (MesTodayAttendanceConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rosterId = this.getRosterId();
         Object other$rosterId = other.getRosterId();
         if (this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$morningWorkingTime = this.getMorningWorkingTime();
               Object other$morningWorkingTime = other.getMorningWorkingTime();
               if (this$morningWorkingTime == null ? other$morningWorkingTime == null : this$morningWorkingTime.equals(other$morningWorkingTime)) {
                  Object this$morningClosingTime = this.getMorningClosingTime();
                  Object other$morningClosingTime = other.getMorningClosingTime();
                  if (this$morningClosingTime == null ? other$morningClosingTime == null : this$morningClosingTime.equals(other$morningClosingTime)) {
                     Object this$afternoonWorkingTime = this.getAfternoonWorkingTime();
                     Object other$afternoonWorkingTime = other.getAfternoonWorkingTime();
                     if (this$afternoonWorkingTime == null ? other$afternoonWorkingTime == null : this$afternoonWorkingTime.equals(other$afternoonWorkingTime)) {
                        Object this$afternoonClosingTime = this.getAfternoonClosingTime();
                        Object other$afternoonClosingTime = other.getAfternoonClosingTime();
                        if (this$afternoonClosingTime == null
                           ? other$afternoonClosingTime == null
                           : this$afternoonClosingTime.equals(other$afternoonClosingTime)) {
                           Object this$standConfigDTO = this.getStandConfigDTO();
                           Object other$standConfigDTO = other.getStandConfigDTO();
                           if (this$standConfigDTO == null ? other$standConfigDTO == null : this$standConfigDTO.equals(other$standConfigDTO)) {
                              Object this$overConfigDTOList = this.getOverConfigDTOList();
                              Object other$overConfigDTOList = other.getOverConfigDTOList();
                              if (this$overConfigDTOList == null ? other$overConfigDTOList == null : this$overConfigDTOList.equals(other$overConfigDTOList)) {
                                 Object this$overClockList = this.getOverClockList();
                                 Object other$overClockList = other.getOverClockList();
                                 if (this$overClockList == null ? other$overClockList == null : this$overClockList.equals(other$overClockList)) {
                                    Object this$pointDTOList = this.getPointDTOList();
                                    Object other$pointDTOList = other.getPointDTOList();
                                    return this$pointDTOList == null ? other$pointDTOList == null : this$pointDTOList.equals(other$pointDTOList);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesTodayAttendanceConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rosterId = this.getRosterId();
      result = result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $standConfigDTO = this.getStandConfigDTO();
      result = result * 59 + ($standConfigDTO == null ? 43 : $standConfigDTO.hashCode());
      Object $overConfigDTOList = this.getOverConfigDTOList();
      result = result * 59 + ($overConfigDTOList == null ? 43 : $overConfigDTOList.hashCode());
      Object $overClockList = this.getOverClockList();
      result = result * 59 + ($overClockList == null ? 43 : $overClockList.hashCode());
      Object $pointDTOList = this.getPointDTOList();
      return result * 59 + ($pointDTOList == null ? 43 : $pointDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "MesTodayAttendanceConfigDTO(id="
         + this.getId()
         + ", rosterId="
         + this.getRosterId()
         + ", userId="
         + this.getUserId()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", standConfigDTO="
         + this.getStandConfigDTO()
         + ", overConfigDTOList="
         + this.getOverConfigDTOList()
         + ", overClockList="
         + this.getOverClockList()
         + ", pointDTOList="
         + this.getPointDTOList()
         + ")";
   }

   public MesTodayAttendanceConfigDTO() {
   }

   public MesTodayAttendanceConfigDTO(
      final Long id,
      final Long rosterId,
      final Long userId,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final MesBuildingAttendanceStandConfigDTO standConfigDTO,
      final List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList,
      final List<OvertimeClockDTO> overClockList,
      final List<PointDTO> pointDTOList
   ) {
      this.id = id;
      this.rosterId = rosterId;
      this.userId = userId;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.standConfigDTO = standConfigDTO;
      this.overConfigDTOList = overConfigDTOList;
      this.overClockList = overClockList;
      this.pointDTOList = pointDTOList;
   }

   public static class MesTodayAttendanceConfigDTOBuilder {
      private Long id;
      private Long rosterId;
      private Long userId;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private MesBuildingAttendanceStandConfigDTO standConfigDTO;
      private List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList;
      private List<OvertimeClockDTO> overClockList;
      private List<PointDTO> pointDTOList;

      MesTodayAttendanceConfigDTOBuilder() {
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder standConfigDTO(final MesBuildingAttendanceStandConfigDTO standConfigDTO) {
         this.standConfigDTO = standConfigDTO;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder overConfigDTOList(final List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList) {
         this.overConfigDTOList = overConfigDTOList;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder overClockList(final List<OvertimeClockDTO> overClockList) {
         this.overClockList = overClockList;
         return this;
      }

      public MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder pointDTOList(final List<PointDTO> pointDTOList) {
         this.pointDTOList = pointDTOList;
         return this;
      }

      public MesTodayAttendanceConfigDTO build() {
         return new MesTodayAttendanceConfigDTO(
            this.id,
            this.rosterId,
            this.userId,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.standConfigDTO,
            this.overConfigDTOList,
            this.overClockList,
            this.pointDTOList
         );
      }

      @Override
      public String toString() {
         return "MesTodayAttendanceConfigDTO.MesTodayAttendanceConfigDTOBuilder(id="
            + this.id
            + ", rosterId="
            + this.rosterId
            + ", userId="
            + this.userId
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", standConfigDTO="
            + this.standConfigDTO
            + ", overConfigDTOList="
            + this.overConfigDTOList
            + ", overClockList="
            + this.overClockList
            + ", pointDTOList="
            + this.pointDTOList
            + ")";
      }
   }
}
