package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.apache.commons.math3.analysis.function.Add;

@ApiModel(value = "ProjectManageAttendanceConfigDTOParam", description = "考勤配置参数")
public class ProjectManageAttendanceConfigDTOParam {
   @ApiModelProperty(name = "id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(groups = Add.class, message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "morningWorkingTime", value = "上午上班打卡时间", notes = "上午上班打卡时间")
   @JsonProperty("morningWorkingTime")
   @JSONField(name = "morningWorkingTime")
   @javax.validation.constraints.NotNull.List({@NotNull(groups = Add.class, message = "打卡时间不能为空"), @NotNull(groups = Update.class, message = "打卡时间不能为空")})
   private LocalDateTime morningWorkingTime;
   @ApiModelProperty(name = "morningClosingTime", value = "上午下班打卡时间", notes = "上午下班打卡时间")
   @JsonProperty("morningClosingTime")
   @JSONField(name = "morningClosingTime")
   @javax.validation.constraints.NotNull.List({@NotNull(groups = Add.class, message = "打卡时间不能为空"), @NotNull(groups = Update.class, message = "打卡时间不能为空")})
   private LocalDateTime morningClosingTime;
   @ApiModelProperty(name = "afternoonWorkingTime", value = "下午上班打卡时间", notes = "下午上班打卡时间")
   @JsonProperty("afternoonWorkingTime")
   @JSONField(name = "afternoonWorkingTime")
   @javax.validation.constraints.NotNull.List({@NotNull(groups = Add.class, message = "打卡时间不能为空"), @NotNull(groups = Update.class, message = "打卡时间不能为空")})
   private LocalDateTime afternoonWorkingTime;
   @ApiModelProperty(name = "afternoonClosingTime", value = "下午下班打卡时间", notes = "下午下班打卡时间")
   @JsonProperty("afternoonClosingTime")
   @JSONField(name = "afternoonClosingTime")
   @javax.validation.constraints.NotNull.List({@NotNull(groups = Add.class, message = "打卡时间不能为空"), @NotNull(groups = Update.class, message = "打卡时间不能为空")})
   private LocalDateTime afternoonClosingTime;
   @ApiModelProperty(name = "isClose", value = "是否关闭", notes = "是否关闭")
   @NotNull(groups = Add.class, message = "是否关闭为空")
   private Boolean isClose;
   @ApiModelProperty(name = "isOutScope", value = "允许迟到早退", notes = "允许迟到早退")
   @NotNull(groups = Add.class, message = "是否允许迟到早退不能为空")
   private Boolean isOutScope;
   @ApiModelProperty(name = "isNeedPicture", value = "是否需要拍照", notes = "是否需要拍照")
   @NotNull(groups = Add.class, message = "是否需要拍照不能为空")
   private Boolean isNeedPicture;
   @ApiModelProperty(name = "isNeedFence", value = "是否需要电子围栏", notes = "是否需要电子围栏")
   @NotNull(groups = Add.class, message = "否需要电子围栏不能为空")
   private Boolean isNeedFence;
   @ApiModelProperty(name = "supplierScope", value = "需要打卡分包商", notes = "需要打卡分包商")
   @NotEmpty(groups = Add.class, message = "打卡分包商不能为空！")
   private List<Long> supplierScope;
   @ApiModelProperty(name = "projectManageAttendanceFenceDTOParamList", notes = "考勤围栏")
   private ProjectManageAttendanceFenceDTOParam projectManageAttendanceFenceDTOParamList;

   public static ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder builder() {
      return new ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder();
   }

   public ProjectManageAttendanceConfigDTOParam() {
   }

   public ProjectManageAttendanceConfigDTOParam(
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
      final ProjectManageAttendanceFenceDTOParam projectManageAttendanceFenceDTOParamList
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
      this.projectManageAttendanceFenceDTOParamList = projectManageAttendanceFenceDTOParamList;
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

   public ProjectManageAttendanceFenceDTOParam getProjectManageAttendanceFenceDTOParamList() {
      return this.projectManageAttendanceFenceDTOParamList;
   }

   public ProjectManageAttendanceConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("morningWorkingTime")
   public ProjectManageAttendanceConfigDTOParam setMorningWorkingTime(final LocalDateTime morningWorkingTime) {
      this.morningWorkingTime = morningWorkingTime;
      return this;
   }

   @JsonProperty("morningClosingTime")
   public ProjectManageAttendanceConfigDTOParam setMorningClosingTime(final LocalDateTime morningClosingTime) {
      this.morningClosingTime = morningClosingTime;
      return this;
   }

   @JsonProperty("afternoonWorkingTime")
   public ProjectManageAttendanceConfigDTOParam setAfternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
      this.afternoonWorkingTime = afternoonWorkingTime;
      return this;
   }

   @JsonProperty("afternoonClosingTime")
   public ProjectManageAttendanceConfigDTOParam setAfternoonClosingTime(final LocalDateTime afternoonClosingTime) {
      this.afternoonClosingTime = afternoonClosingTime;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setIsClose(final Boolean isClose) {
      this.isClose = isClose;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setIsOutScope(final Boolean isOutScope) {
      this.isOutScope = isOutScope;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setIsNeedPicture(final Boolean isNeedPicture) {
      this.isNeedPicture = isNeedPicture;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setIsNeedFence(final Boolean isNeedFence) {
      this.isNeedFence = isNeedFence;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setSupplierScope(final List<Long> supplierScope) {
      this.supplierScope = supplierScope;
      return this;
   }

   public ProjectManageAttendanceConfigDTOParam setProjectManageAttendanceFenceDTOParamList(
      final ProjectManageAttendanceFenceDTOParam projectManageAttendanceFenceDTOParamList
   ) {
      this.projectManageAttendanceFenceDTOParamList = projectManageAttendanceFenceDTOParamList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceConfigDTOParam)) {
         return false;
      }

      ProjectManageAttendanceConfigDTOParam other = (ProjectManageAttendanceConfigDTOParam)o;
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
                                       Object this$projectManageAttendanceFenceDTOParamList = this.getProjectManageAttendanceFenceDTOParamList();
                                       Object other$projectManageAttendanceFenceDTOParamList = other.getProjectManageAttendanceFenceDTOParamList();
                                       return this$projectManageAttendanceFenceDTOParamList == null
                                          ? other$projectManageAttendanceFenceDTOParamList == null
                                          : this$projectManageAttendanceFenceDTOParamList.equals(other$projectManageAttendanceFenceDTOParamList);
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
      return other instanceof ProjectManageAttendanceConfigDTOParam;
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
      Object $projectManageAttendanceFenceDTOParamList = this.getProjectManageAttendanceFenceDTOParamList();
      return result * 59 + ($projectManageAttendanceFenceDTOParamList == null ? 43 : $projectManageAttendanceFenceDTOParamList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceConfigDTOParam(id="
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
         + ", projectManageAttendanceFenceDTOParamList="
         + this.getProjectManageAttendanceFenceDTOParamList()
         + ")";
   }

   public static class ProjectManageAttendanceConfigDTOParamBuilder {
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
      private ProjectManageAttendanceFenceDTOParam projectManageAttendanceFenceDTOParamList;

      ProjectManageAttendanceConfigDTOParamBuilder() {
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("morningWorkingTime")
      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder morningWorkingTime(final LocalDateTime morningWorkingTime) {
         this.morningWorkingTime = morningWorkingTime;
         return this;
      }

      @JsonProperty("morningClosingTime")
      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder morningClosingTime(final LocalDateTime morningClosingTime) {
         this.morningClosingTime = morningClosingTime;
         return this;
      }

      @JsonProperty("afternoonWorkingTime")
      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder afternoonWorkingTime(final LocalDateTime afternoonWorkingTime) {
         this.afternoonWorkingTime = afternoonWorkingTime;
         return this;
      }

      @JsonProperty("afternoonClosingTime")
      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder afternoonClosingTime(final LocalDateTime afternoonClosingTime) {
         this.afternoonClosingTime = afternoonClosingTime;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder isClose(final Boolean isClose) {
         this.isClose = isClose;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder isOutScope(final Boolean isOutScope) {
         this.isOutScope = isOutScope;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder isNeedPicture(final Boolean isNeedPicture) {
         this.isNeedPicture = isNeedPicture;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder isNeedFence(final Boolean isNeedFence) {
         this.isNeedFence = isNeedFence;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder supplierScope(final List<Long> supplierScope) {
         this.supplierScope = supplierScope;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder projectManageAttendanceFenceDTOParamList(
         final ProjectManageAttendanceFenceDTOParam projectManageAttendanceFenceDTOParamList
      ) {
         this.projectManageAttendanceFenceDTOParamList = projectManageAttendanceFenceDTOParamList;
         return this;
      }

      public ProjectManageAttendanceConfigDTOParam build() {
         return new ProjectManageAttendanceConfigDTOParam(
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
            this.projectManageAttendanceFenceDTOParamList
         );
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceConfigDTOParam.ProjectManageAttendanceConfigDTOParamBuilder(id="
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
            + ", projectManageAttendanceFenceDTOParamList="
            + this.projectManageAttendanceFenceDTOParamList
            + ")";
      }
   }
}
