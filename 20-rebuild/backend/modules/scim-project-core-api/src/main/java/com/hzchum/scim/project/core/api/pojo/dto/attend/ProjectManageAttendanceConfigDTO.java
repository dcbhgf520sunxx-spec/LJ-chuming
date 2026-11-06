package com.hzchum.scim.project.core.api.pojo.dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ExcelTarget("AttendanceTimeConfigurationDTO")
@ApiModel("考勤配置返回类")
public class ProjectManageAttendanceConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   @JsonProperty("morningWorkingTime")
   @JSONField(name = "morningWorkingTime")
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   @JsonProperty("morningClosingTime")
   @JSONField(name = "morningClosingTime")
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   @JsonProperty("afternoonWorkingTime")
   @JSONField(name = "afternoonWorkingTime")
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   @JsonProperty("afternoonClosingTime")
   @JSONField(name = "afternoonClosingTime")
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "isClose", value = "是否关闭", notes = "是否关闭")
   private Boolean isClose;
   @ApiModelProperty(name = "isOutScope", value = "允许迟到早退", notes = "允许迟到早退")
   private Boolean isOutScope;
   @ApiModelProperty(name = "isNeedPicture", value = "是否需要拍照", notes = "是否需要拍照")
   private Boolean isNeedPicture;
   @ApiModelProperty(name = "isNeedFence", value = "是否需要电子围栏", notes = "是否需要电子围栏")
   private Boolean isNeedFence;
   @ApiModelProperty(name = "supplierScope", value = "需要打卡分包商", notes = "需要打卡分包商")
   private List<Long> supplierScope;
   @ApiModelProperty(name = "projectManageAttendanceFenceDTOParamList", notes = "考勤围栏")
   private List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOList;

   public static ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder builder() {
      return new ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Boolean getIsClose() {
      return this.isClose;
   }

   public Boolean getIsOutScope() {
      return this.isOutScope;
   }

   public Boolean getIsNeedPicture() {
      return this.isNeedPicture;
   }

   public Boolean getIsNeedFence() {
      return this.isNeedFence;
   }

   public List<Long> getSupplierScope() {
      return this.supplierScope;
   }

   public List<ProjectManageAttendanceFenceDTO> getProjectManageAttendanceFenceDTOList() {
      return this.projectManageAttendanceFenceDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("morningWorkingTime")
   public void setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
   }

   @JsonProperty("morningClosingTime")
   public void setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
   }

   @JsonProperty("afternoonWorkingTime")
   public void setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
   }

   @JsonProperty("afternoonClosingTime")
   public void setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
   }

   public void setIsClose(final Boolean isClose) {
      this.isClose = isClose;
   }

   public void setIsOutScope(final Boolean isOutScope) {
      this.isOutScope = isOutScope;
   }

   public void setIsNeedPicture(final Boolean isNeedPicture) {
      this.isNeedPicture = isNeedPicture;
   }

   public void setIsNeedFence(final Boolean isNeedFence) {
      this.isNeedFence = isNeedFence;
   }

   public void setSupplierScope(final List<Long> supplierScope) {
      this.supplierScope = supplierScope;
   }

   public void setProjectManageAttendanceFenceDTOList(final List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOList) {
      this.projectManageAttendanceFenceDTOList = projectManageAttendanceFenceDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceConfigDTO)) {
         return false;
      }

      ProjectManageAttendanceConfigDTO other = (ProjectManageAttendanceConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$isClose = this.getIsClose();
            Object other$isClose = other.getIsClose();
            if (this$isClose == null ? other$isClose == null : this$isClose.equals(other$isClose)) {
               Object this$isOutScope = this.getIsOutScope();
               Object other$isOutScope = other.getIsOutScope();
               if (this$isOutScope == null ? other$isOutScope == null : this$isOutScope.equals(other$isOutScope)) {
                  Object this$isNeedPicture = this.getIsNeedPicture();
                  Object other$isNeedPicture = other.getIsNeedPicture();
                  if (this$isNeedPicture == null ? other$isNeedPicture == null : this$isNeedPicture.equals(other$isNeedPicture)) {
                     Object this$isNeedFence = this.getIsNeedFence();
                     Object other$isNeedFence = other.getIsNeedFence();
                     if (this$isNeedFence == null ? other$isNeedFence == null : this$isNeedFence.equals(other$isNeedFence)) {
                        Object this$morningWorkingTime = this.getMorningWorkingTime();
                        Object other$morningWorkingTime = other.getMorningWorkingTime();
                        if (this$morningWorkingTime == null ? other$morningWorkingTime == null : this$morningWorkingTime.equals(other$morningWorkingTime)) {
                           Object this$morningClosingTime = this.getMorningClosingTime();
                           Object other$morningClosingTime = other.getMorningClosingTime();
                           if (this$morningClosingTime == null ? other$morningClosingTime == null : this$morningClosingTime.equals(other$morningClosingTime)) {
                              Object this$afternoonWorkingTime = this.getAfternoonWorkingTime();
                              Object other$afternoonWorkingTime = other.getAfternoonWorkingTime();
                              if (this$afternoonWorkingTime == null
                                 ? other$afternoonWorkingTime == null
                                 : this$afternoonWorkingTime.equals(other$afternoonWorkingTime)) {
                                 Object this$afternoonClosingTime = this.getAfternoonClosingTime();
                                 Object other$afternoonClosingTime = other.getAfternoonClosingTime();
                                 if (this$afternoonClosingTime == null
                                    ? other$afternoonClosingTime == null
                                    : this$afternoonClosingTime.equals(other$afternoonClosingTime)) {
                                    Object this$supplierScope = this.getSupplierScope();
                                    Object other$supplierScope = other.getSupplierScope();
                                    if (this$supplierScope == null ? other$supplierScope == null : this$supplierScope.equals(other$supplierScope)) {
                                       Object this$projectManageAttendanceFenceDTOList = this.getProjectManageAttendanceFenceDTOList();
                                       Object other$projectManageAttendanceFenceDTOList = other.getProjectManageAttendanceFenceDTOList();
                                       return this$projectManageAttendanceFenceDTOList == null
                                          ? other$projectManageAttendanceFenceDTOList == null
                                          : this$projectManageAttendanceFenceDTOList.equals(other$projectManageAttendanceFenceDTOList);
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
      return other instanceof ProjectManageAttendanceConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $isClose = this.getIsClose();
      result = result * 59 + ($isClose == null ? 43 : $isClose.hashCode());
      Object $isOutScope = this.getIsOutScope();
      result = result * 59 + ($isOutScope == null ? 43 : $isOutScope.hashCode());
      Object $isNeedPicture = this.getIsNeedPicture();
      result = result * 59 + ($isNeedPicture == null ? 43 : $isNeedPicture.hashCode());
      Object $isNeedFence = this.getIsNeedFence();
      result = result * 59 + ($isNeedFence == null ? 43 : $isNeedFence.hashCode());
      Object $morningWorkingTime = this.getMorningWorkingTime();
      result = result * 59 + ($morningWorkingTime == null ? 43 : $morningWorkingTime.hashCode());
      Object $morningClosingTime = this.getMorningClosingTime();
      result = result * 59 + ($morningClosingTime == null ? 43 : $morningClosingTime.hashCode());
      Object $afternoonWorkingTime = this.getAfternoonWorkingTime();
      result = result * 59 + ($afternoonWorkingTime == null ? 43 : $afternoonWorkingTime.hashCode());
      Object $afternoonClosingTime = this.getAfternoonClosingTime();
      result = result * 59 + ($afternoonClosingTime == null ? 43 : $afternoonClosingTime.hashCode());
      Object $supplierScope = this.getSupplierScope();
      result = result * 59 + ($supplierScope == null ? 43 : $supplierScope.hashCode());
      Object $projectManageAttendanceFenceDTOList = this.getProjectManageAttendanceFenceDTOList();
      return result * 59 + ($projectManageAttendanceFenceDTOList == null ? 43 : $projectManageAttendanceFenceDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceConfigDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", morningWorkingTime="
         + this.getMorningWorkingTime()
         + ", morningClosingTime="
         + this.getMorningClosingTime()
         + ", afternoonWorkingTime="
         + this.getAfternoonWorkingTime()
         + ", afternoonClosingTime="
         + this.getAfternoonClosingTime()
         + ", isClose="
         + this.getIsClose()
         + ", isOutScope="
         + this.getIsOutScope()
         + ", isNeedPicture="
         + this.getIsNeedPicture()
         + ", isNeedFence="
         + this.getIsNeedFence()
         + ", supplierScope="
         + this.getSupplierScope()
         + ", projectManageAttendanceFenceDTOList="
         + this.getProjectManageAttendanceFenceDTOList()
         + ")";
   }

   public ProjectManageAttendanceConfigDTO() {
   }

   public ProjectManageAttendanceConfigDTO(
      final Long id,
      final Long projectId,
      final LocalDateTime morningWorkingTime,
      final LocalDateTime morningClosingTime,
      final LocalDateTime afternoonWorkingTime,
      final LocalDateTime afternoonClosingTime,
      final Boolean isClose,
      final Boolean isOutScope,
      final Boolean isNeedPicture,
      final Boolean isNeedFence,
      final List<Long> supplierScope,
      final List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.morningWorkingTime = morningWorkingTime;
      this.morningClosingTime = morningClosingTime;
      this.afternoonWorkingTime = afternoonWorkingTime;
      this.afternoonClosingTime = afternoonClosingTime;
      this.isClose = isClose;
      this.isOutScope = isOutScope;
      this.isNeedPicture = isNeedPicture;
      this.isNeedFence = isNeedFence;
      this.supplierScope = supplierScope;
      this.projectManageAttendanceFenceDTOList = projectManageAttendanceFenceDTOList;
   }

   public static class ProjectManageAttendanceConfigDTOBuilder {
      private Long id;
      private Long projectId;
      private LocalDateTime morningWorkingTime;
      private LocalDateTime morningClosingTime;
      private LocalDateTime afternoonWorkingTime;
      private LocalDateTime afternoonClosingTime;
      private Boolean isClose;
      private Boolean isOutScope;
      private Boolean isNeedPicture;
      private Boolean isNeedFence;
      private List<Long> supplierScope;
      private List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOList;

      ProjectManageAttendanceConfigDTOBuilder() {
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("morningWorkingTime")
      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      @JsonProperty("morningClosingTime")
      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      @JsonProperty("afternoonWorkingTime")
      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      @JsonProperty("afternoonClosingTime")
      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder isClose(final Boolean isClose) {
         this.isClose = isClose;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder isOutScope(final Boolean isOutScope) {
         this.isOutScope = isOutScope;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder isNeedPicture(final Boolean isNeedPicture) {
         this.isNeedPicture = isNeedPicture;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder isNeedFence(final Boolean isNeedFence) {
         this.isNeedFence = isNeedFence;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder supplierScope(final List<Long> supplierScope) {
         this.supplierScope = supplierScope;
         return this;
      }

      public ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder projectManageAttendanceFenceDTOList(
         final List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOList
      ) {
         this.projectManageAttendanceFenceDTOList = projectManageAttendanceFenceDTOList;
         return this;
      }

      public ProjectManageAttendanceConfigDTO build() {
         return new ProjectManageAttendanceConfigDTO(
            this.id,
            this.projectId,
            this.morningWorkingTime,
            this.morningClosingTime,
            this.afternoonWorkingTime,
            this.afternoonClosingTime,
            this.isClose,
            this.isOutScope,
            this.isNeedPicture,
            this.isNeedFence,
            this.supplierScope,
            this.projectManageAttendanceFenceDTOList
         );
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceConfigDTO.ProjectManageAttendanceConfigDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", morningWorkingTime="
            + this.morningWorkingTime
            + ", morningClosingTime="
            + this.morningClosingTime
            + ", afternoonWorkingTime="
            + this.afternoonWorkingTime
            + ", afternoonClosingTime="
            + this.afternoonClosingTime
            + ", isClose="
            + this.isClose
            + ", isOutScope="
            + this.isOutScope
            + ", isNeedPicture="
            + this.isNeedPicture
            + ", isNeedFence="
            + this.isNeedFence
            + ", supplierScope="
            + this.supplierScope
            + ", projectManageAttendanceFenceDTOList="
            + this.projectManageAttendanceFenceDTOList
            + ")";
      }
   }
}
