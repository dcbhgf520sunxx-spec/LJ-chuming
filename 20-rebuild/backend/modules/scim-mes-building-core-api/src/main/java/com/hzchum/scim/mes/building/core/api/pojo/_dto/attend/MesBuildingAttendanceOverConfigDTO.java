package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ExcelTarget("MesBuildingAttendanceOverConfigDTO")
@ApiModel("考勤基础配置返回类")
public class MesBuildingAttendanceOverConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;
   @ApiModelProperty(name = "departmentId", value = "部门ID", notes = "部门ID")
   private Long departmentId;
   @ApiModelProperty(name = "deptName", value = "部门", notes = "部门")
   private String deptName;
   @ApiModelProperty(name = "overtimeWorkingTime", value = "加班开始时间", notes = "加班开始时间")
   private LocalDateTime overtimeWorkingTime;
   @ApiModelProperty(name = "overtimeClosingTime", value = "加班结束时间", notes = "加班结束时间")
   private LocalDateTime overtimeClosingTime;
   @ApiModelProperty(name = "isCanDelay", value = "是否允许迟到", notes = "是否允许迟到")
   private Boolean isCanDelay;
   @ApiModelProperty(name = "isCanEarly", value = "是否允许早退", notes = "是否允许早退")
   private Boolean isCanEarly;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "rosterList", value = "劳务信息", notes = "劳务信息")
   private List<IdAndNameDTO> rosterList;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "rosterIds", value = "劳务信息", notes = "劳务信息")
   private List<Long> rosterIds;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "workingTime", value = "上班打卡时间", notes = "上班打卡时间")
   private LocalDateTime workingTime;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "closingTime", value = "下班打卡时间", notes = "下班打卡时间")
   private LocalDateTime closingTime;

   public static MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder builder() {
      return new MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public LocalDateTime getOvertimeWorkingTime() {
      return this.overtimeWorkingTime;
   }

   public LocalDateTime getOvertimeClosingTime() {
      return this.overtimeClosingTime;
   }

   public Boolean getIsCanDelay() {
      return this.isCanDelay;
   }

   public Boolean getIsCanEarly() {
      return this.isCanEarly;
   }

   public List<IdAndNameDTO> getRosterList() {
      return this.rosterList;
   }

   public List<Long> getRosterIds() {
      return this.rosterIds;
   }

   public LocalDateTime getWorkingTime() {
      return this.workingTime;
   }

   public LocalDateTime getClosingTime() {
      return this.closingTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setOvertimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
      this.overtimeWorkingTime = overtimeWorkingTime;
   }

   public void setOvertimeClosingTime(final LocalDateTime overtimeClosingTime) {
      this.overtimeClosingTime = overtimeClosingTime;
   }

   public void setIsCanDelay(final Boolean isCanDelay) {
      this.isCanDelay = isCanDelay;
   }

   public void setIsCanEarly(final Boolean isCanEarly) {
      this.isCanEarly = isCanEarly;
   }

   public void setRosterList(final List<IdAndNameDTO> rosterList) {
      this.rosterList = rosterList;
   }

   public void setRosterIds(final List<Long> rosterIds) {
      this.rosterIds = rosterIds;
   }

   public void setWorkingTime(final LocalDateTime workingTime) {
      this.workingTime = workingTime;
   }

   public void setClosingTime(final LocalDateTime closingTime) {
      this.closingTime = closingTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAttendanceOverConfigDTO)) {
         return false;
      }

      MesBuildingAttendanceOverConfigDTO other = (MesBuildingAttendanceOverConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$departmentId = this.getDepartmentId();
            Object other$departmentId = other.getDepartmentId();
            if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
               Object this$isCanDelay = this.getIsCanDelay();
               Object other$isCanDelay = other.getIsCanDelay();
               if (this$isCanDelay == null ? other$isCanDelay == null : this$isCanDelay.equals(other$isCanDelay)) {
                  Object this$isCanEarly = this.getIsCanEarly();
                  Object other$isCanEarly = other.getIsCanEarly();
                  if (this$isCanEarly == null ? other$isCanEarly == null : this$isCanEarly.equals(other$isCanEarly)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$deptName = this.getDeptName();
                        Object other$deptName = other.getDeptName();
                        if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                           Object this$overtimeWorkingTime = this.getOvertimeWorkingTime();
                           Object other$overtimeWorkingTime = other.getOvertimeWorkingTime();
                           if (this$overtimeWorkingTime == null
                              ? other$overtimeWorkingTime == null
                              : this$overtimeWorkingTime.equals(other$overtimeWorkingTime)) {
                              Object this$overtimeClosingTime = this.getOvertimeClosingTime();
                              Object other$overtimeClosingTime = other.getOvertimeClosingTime();
                              if (this$overtimeClosingTime == null
                                 ? other$overtimeClosingTime == null
                                 : this$overtimeClosingTime.equals(other$overtimeClosingTime)) {
                                 Object this$rosterList = this.getRosterList();
                                 Object other$rosterList = other.getRosterList();
                                 if (this$rosterList == null ? other$rosterList == null : this$rosterList.equals(other$rosterList)) {
                                    Object this$rosterIds = this.getRosterIds();
                                    Object other$rosterIds = other.getRosterIds();
                                    if (this$rosterIds == null ? other$rosterIds == null : this$rosterIds.equals(other$rosterIds)) {
                                       Object this$workingTime = this.getWorkingTime();
                                       Object other$workingTime = other.getWorkingTime();
                                       if (this$workingTime == null ? other$workingTime == null : this$workingTime.equals(other$workingTime)) {
                                          Object this$closingTime = this.getClosingTime();
                                          Object other$closingTime = other.getClosingTime();
                                          return this$closingTime == null ? other$closingTime == null : this$closingTime.equals(other$closingTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAttendanceOverConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $isCanDelay = this.getIsCanDelay();
      result = result * 59 + ($isCanDelay == null ? 43 : $isCanDelay.hashCode());
      Object $isCanEarly = this.getIsCanEarly();
      result = result * 59 + ($isCanEarly == null ? 43 : $isCanEarly.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $overtimeWorkingTime = this.getOvertimeWorkingTime();
      result = result * 59 + ($overtimeWorkingTime == null ? 43 : $overtimeWorkingTime.hashCode());
      Object $overtimeClosingTime = this.getOvertimeClosingTime();
      result = result * 59 + ($overtimeClosingTime == null ? 43 : $overtimeClosingTime.hashCode());
      Object $rosterList = this.getRosterList();
      result = result * 59 + ($rosterList == null ? 43 : $rosterList.hashCode());
      Object $rosterIds = this.getRosterIds();
      result = result * 59 + ($rosterIds == null ? 43 : $rosterIds.hashCode());
      Object $workingTime = this.getWorkingTime();
      result = result * 59 + ($workingTime == null ? 43 : $workingTime.hashCode());
      Object $closingTime = this.getClosingTime();
      return result * 59 + ($closingTime == null ? 43 : $closingTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAttendanceOverConfigDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", deptName="
         + this.getDeptName()
         + ", overtimeWorkingTime="
         + this.getOvertimeWorkingTime()
         + ", overtimeClosingTime="
         + this.getOvertimeClosingTime()
         + ", isCanDelay="
         + this.getIsCanDelay()
         + ", isCanEarly="
         + this.getIsCanEarly()
         + ", rosterList="
         + this.getRosterList()
         + ", rosterIds="
         + this.getRosterIds()
         + ", workingTime="
         + this.getWorkingTime()
         + ", closingTime="
         + this.getClosingTime()
         + ")";
   }

   public MesBuildingAttendanceOverConfigDTO() {
   }

   public MesBuildingAttendanceOverConfigDTO(
      final Long id,
      final Long userId,
      final String userName,
      final Long departmentId,
      final String deptName,
      final LocalDateTime overtimeWorkingTime,
      final LocalDateTime overtimeClosingTime,
      final Boolean isCanDelay,
      final Boolean isCanEarly,
      final List<IdAndNameDTO> rosterList,
      final List<Long> rosterIds,
      final LocalDateTime workingTime,
      final LocalDateTime closingTime
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.departmentId = departmentId;
      this.deptName = deptName;
      this.overtimeWorkingTime = overtimeWorkingTime;
      this.overtimeClosingTime = overtimeClosingTime;
      this.isCanDelay = isCanDelay;
      this.isCanEarly = isCanEarly;
      this.rosterList = rosterList;
      this.rosterIds = rosterIds;
      this.workingTime = workingTime;
      this.closingTime = closingTime;
   }

   public static class MesBuildingAttendanceOverConfigDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long departmentId;
      private String deptName;
      private LocalDateTime overtimeWorkingTime;
      private LocalDateTime overtimeClosingTime;
      private Boolean isCanDelay;
      private Boolean isCanEarly;
      private List<IdAndNameDTO> rosterList;
      private List<Long> rosterIds;
      private LocalDateTime workingTime;
      private LocalDateTime closingTime;

      MesBuildingAttendanceOverConfigDTOBuilder() {
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder overtimeWorkingTime(final LocalDateTime overtimeWorkingTime) {
         this.overtimeWorkingTime = overtimeWorkingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder overtimeClosingTime(final LocalDateTime overtimeClosingTime) {
         this.overtimeClosingTime = overtimeClosingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder isCanDelay(final Boolean isCanDelay) {
         this.isCanDelay = isCanDelay;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder isCanEarly(final Boolean isCanEarly) {
         this.isCanEarly = isCanEarly;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder rosterList(final List<IdAndNameDTO> rosterList) {
         this.rosterList = rosterList;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder rosterIds(final List<Long> rosterIds) {
         this.rosterIds = rosterIds;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder workingTime(final LocalDateTime workingTime) {
         this.workingTime = workingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder closingTime(final LocalDateTime closingTime) {
         this.closingTime = closingTime;
         return this;
      }

      public MesBuildingAttendanceOverConfigDTO build() {
         return new MesBuildingAttendanceOverConfigDTO(
            this.id,
            this.userId,
            this.userName,
            this.departmentId,
            this.deptName,
            this.overtimeWorkingTime,
            this.overtimeClosingTime,
            this.isCanDelay,
            this.isCanEarly,
            this.rosterList,
            this.rosterIds,
            this.workingTime,
            this.closingTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAttendanceOverConfigDTO.MesBuildingAttendanceOverConfigDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", departmentId="
            + this.departmentId
            + ", deptName="
            + this.deptName
            + ", overtimeWorkingTime="
            + this.overtimeWorkingTime
            + ", overtimeClosingTime="
            + this.overtimeClosingTime
            + ", isCanDelay="
            + this.isCanDelay
            + ", isCanEarly="
            + this.isCanEarly
            + ", rosterList="
            + this.rosterList
            + ", rosterIds="
            + this.rosterIds
            + ", workingTime="
            + this.workingTime
            + ", closingTime="
            + this.closingTime
            + ")";
      }
   }
}
