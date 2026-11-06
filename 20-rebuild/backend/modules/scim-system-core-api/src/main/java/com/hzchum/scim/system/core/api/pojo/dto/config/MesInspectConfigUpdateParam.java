package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MesInspectConfigUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @NotNull(message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @NotNull(message = "类型不能为空")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件", notes = "构件类型 1普通构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @NotNull(message = "工序不能为空")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "inspectUserId", value = "质检人id", notes = "质检人id")
   @NotNull(message = "质检人不能为空")
   private List<Long> inspectUserIds;
   @ApiModelProperty(name = "inspectUserName", value = "质检人", notes = "质检人")
   private String inspectUserName;
   @ApiModelProperty(name = "inspectType", value = "质检方式[0 全检 1抽检]", notes = "质检方式[0 全检 1抽检]")
   @NotNull(message = "质检方式不能为空")
   private Integer inspectType;
   @ApiModelProperty(name = "firstInspectRate", value = "首检率", notes = "首检率")
   private Integer firstInspectRate;
   @ApiModelProperty(name = "inspectMethod", value = "检查方式[0 扫码检验 1不扫码检验]", notes = "检查方式[0 扫码检验 1不扫码检验]")
   private Integer inspectMethod;
   @ApiModelProperty(name = "teamLink", value = "关联班组")
   @NotEmpty(message = "关联班组不能为空")
   private List<Long> teamLink;
   @ApiModelProperty(name = "classificationId", value = "关联零部构件种类")
   @NotEmpty(message = "关联零部构件种类不能为空")
   private List<Long> classificationId;

   public static MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder builder() {
      return new MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder();
   }

   public MesInspectConfigUpdateParam() {
   }

   public MesInspectConfigUpdateParam(
      final Long id,
      final Long workshopId,
      final String workshopName,
      final Integer taskTypeEnum,
      final Integer artifactType,
      final Long processId,
      final String processName,
      final List<Long> inspectUserIds,
      final String inspectUserName,
      final Integer inspectType,
      final Integer firstInspectRate,
      final Integer inspectMethod,
      final List<Long> teamLink,
      final List<Long> classificationId
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.taskTypeEnum = taskTypeEnum;
      this.artifactType = artifactType;
      this.processId = processId;
      this.processName = processName;
      this.inspectUserIds = inspectUserIds;
      this.inspectUserName = inspectUserName;
      this.inspectType = inspectType;
      this.firstInspectRate = firstInspectRate;
      this.inspectMethod = inspectMethod;
      this.teamLink = teamLink;
      this.classificationId = classificationId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public List<Long> getInspectUserIds() {
      return this.inspectUserIds;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Integer getFirstInspectRate() {
      return this.firstInspectRate;
   }

   public Integer getInspectMethod() {
      return this.inspectMethod;
   }

   public List<Long> getTeamLink() {
      return this.teamLink;
   }

   public List<Long> getClassificationId() {
      return this.classificationId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setInspectUserIds(final List<Long> inspectUserIds) {
      this.inspectUserIds = inspectUserIds;
   }

   public void setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
   }

   public void setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
   }

   public void setFirstInspectRate(final Integer firstInspectRate) {
      this.firstInspectRate = firstInspectRate;
   }

   public void setInspectMethod(final Integer inspectMethod) {
      this.inspectMethod = inspectMethod;
   }

   public void setTeamLink(final List<Long> teamLink) {
      this.teamLink = teamLink;
   }

   public void setClassificationId(final List<Long> classificationId) {
      this.classificationId = classificationId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigUpdateParam)) {
         return false;
      }

      MesInspectConfigUpdateParam other = (MesInspectConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$artifactType = this.getArtifactType();
               Object other$artifactType = other.getArtifactType();
               if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$inspectType = this.getInspectType();
                     Object other$inspectType = other.getInspectType();
                     if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
                        Object this$firstInspectRate = this.getFirstInspectRate();
                        Object other$firstInspectRate = other.getFirstInspectRate();
                        if (this$firstInspectRate == null ? other$firstInspectRate == null : this$firstInspectRate.equals(other$firstInspectRate)) {
                           Object this$inspectMethod = this.getInspectMethod();
                           Object other$inspectMethod = other.getInspectMethod();
                           if (this$inspectMethod == null ? other$inspectMethod == null : this$inspectMethod.equals(other$inspectMethod)) {
                              Object this$workshopName = this.getWorkshopName();
                              Object other$workshopName = other.getWorkshopName();
                              if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                    Object this$inspectUserIds = this.getInspectUserIds();
                                    Object other$inspectUserIds = other.getInspectUserIds();
                                    if (this$inspectUserIds == null ? other$inspectUserIds == null : this$inspectUserIds.equals(other$inspectUserIds)) {
                                       Object this$inspectUserName = this.getInspectUserName();
                                       Object other$inspectUserName = other.getInspectUserName();
                                       if (this$inspectUserName == null ? other$inspectUserName == null : this$inspectUserName.equals(other$inspectUserName)) {
                                          Object this$teamLink = this.getTeamLink();
                                          Object other$teamLink = other.getTeamLink();
                                          if (this$teamLink == null ? other$teamLink == null : this$teamLink.equals(other$teamLink)) {
                                             Object this$classificationId = this.getClassificationId();
                                             Object other$classificationId = other.getClassificationId();
                                             return this$classificationId == null
                                                ? other$classificationId == null
                                                : this$classificationId.equals(other$classificationId);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesInspectConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $firstInspectRate = this.getFirstInspectRate();
      result = result * 59 + ($firstInspectRate == null ? 43 : $firstInspectRate.hashCode());
      Object $inspectMethod = this.getInspectMethod();
      result = result * 59 + ($inspectMethod == null ? 43 : $inspectMethod.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $inspectUserIds = this.getInspectUserIds();
      result = result * 59 + ($inspectUserIds == null ? 43 : $inspectUserIds.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      result = result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
      Object $teamLink = this.getTeamLink();
      result = result * 59 + ($teamLink == null ? 43 : $teamLink.hashCode());
      Object $classificationId = this.getClassificationId();
      return result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectConfigUpdateParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", inspectUserIds="
         + this.getInspectUserIds()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ", inspectType="
         + this.getInspectType()
         + ", firstInspectRate="
         + this.getFirstInspectRate()
         + ", inspectMethod="
         + this.getInspectMethod()
         + ", teamLink="
         + this.getTeamLink()
         + ", classificationId="
         + this.getClassificationId()
         + ")";
   }

   public static class MesInspectConfigUpdateParamBuilder {
      private Long id;
      private Long workshopId;
      private String workshopName;
      private Integer taskTypeEnum;
      private Integer artifactType;
      private Long processId;
      private String processName;
      private List<Long> inspectUserIds;
      private String inspectUserName;
      private Integer inspectType;
      private Integer firstInspectRate;
      private Integer inspectMethod;
      private List<Long> teamLink;
      private List<Long> classificationId;

      MesInspectConfigUpdateParamBuilder() {
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder inspectUserIds(final List<Long> inspectUserIds) {
         this.inspectUserIds = inspectUserIds;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder inspectUserName(final String inspectUserName) {
         this.inspectUserName = inspectUserName;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder firstInspectRate(final Integer firstInspectRate) {
         this.firstInspectRate = firstInspectRate;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder inspectMethod(final Integer inspectMethod) {
         this.inspectMethod = inspectMethod;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder teamLink(final List<Long> teamLink) {
         this.teamLink = teamLink;
         return this;
      }

      public MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder classificationId(final List<Long> classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesInspectConfigUpdateParam build() {
         return new MesInspectConfigUpdateParam(
            this.id,
            this.workshopId,
            this.workshopName,
            this.taskTypeEnum,
            this.artifactType,
            this.processId,
            this.processName,
            this.inspectUserIds,
            this.inspectUserName,
            this.inspectType,
            this.firstInspectRate,
            this.inspectMethod,
            this.teamLink,
            this.classificationId
         );
      }

      @Override
      public String toString() {
         return "MesInspectConfigUpdateParam.MesInspectConfigUpdateParamBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", artifactType="
            + this.artifactType
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", inspectUserIds="
            + this.inspectUserIds
            + ", inspectUserName="
            + this.inspectUserName
            + ", inspectType="
            + this.inspectType
            + ", firstInspectRate="
            + this.firstInspectRate
            + ", inspectMethod="
            + this.inspectMethod
            + ", teamLink="
            + this.teamLink
            + ", classificationId="
            + this.classificationId
            + ")";
      }
   }
}
