package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(value = "ProjectConstructionLog对象dto", description = "施工日志表")
public class ProjectConstructionLogDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "constructionDate", value = "施工日期", notes = "施工日期")
   private LocalDate constructionDate;
   @ApiModelProperty(name = "morningWeather", value = "上午天气", notes = "上午天气")
   private String morningWeather;
   @ApiModelProperty(name = "afternoonWeather", value = "下午天气", notes = "下午天气")
   private String afternoonWeather;
   @ApiModelProperty(name = "morningWind", value = "上午风力", notes = "上午风力")
   private String morningWind;
   @ApiModelProperty(name = "afternoonWind", value = "下午风力", notes = "下午风力")
   private String afternoonWind;
   @ApiModelProperty(name = "morningTemperature", value = "上午温度", notes = "上午温度")
   private String morningTemperature;
   @ApiModelProperty(name = "afternoonTemperature", value = "下午温度", notes = "下午温度")
   private String afternoonTemperature;
   @ApiModelProperty(name = "constructionDesc", value = "施工部分描述", notes = "施工部分描述")
   private String constructionDesc;
   @ApiModelProperty(name = "machineWorkDesc", value = "机械作业描述", notes = "机械作业描述")
   private String machineWorkDesc;
   @ApiModelProperty(name = "groupWorkDesc", value = "班组上岗情况", notes = "班组上岗情况")
   private String groupWorkDesc;
   @ApiModelProperty(name = "qualityInspectionDesc", value = "质量检查情况", notes = "质量检查情况")
   private String qualityInspectionDesc;
   @ApiModelProperty(name = "safetyInspectionDesc", value = "安全检查情况", notes = "安全检查情况")
   private String safetyInspectionDesc;
   @ApiModelProperty(name = "siteImportantEvent", value = "工地重大事件", notes = "工地重大事件")
   private String siteImportantEvent;
   @ApiModelProperty(name = "existingProblemDesc", value = "存在问题描述", notes = "存在问题描述")
   private String existingProblemDesc;
   @ApiModelProperty(name = "recorderId", value = "记录用户id", notes = "记录用户id")
   private Long recorderId;
   @ApiModelProperty(name = "recorderName", value = "记录用户", notes = "记录用户")
   private String recorderName;
   @ApiModelProperty(name = "managerId", value = "负责人id", notes = "负责人id")
   private Long managerId;
   @ApiModelProperty(name = "managerName", value = "负责人", notes = "负责人")
   private String managerName;
   @ApiModelProperty(name = "userId", value = "填写人id", notes = "填写人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "填写人", notes = "填写人")
   private String userName;

   public static ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder builder() {
      return new ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder();
   }

   public ProjectConstructionLogDTO() {
   }

   public ProjectConstructionLogDTO(
      final Long id,
      final Long projectId,
      final LocalDate constructionDate,
      final String morningWeather,
      final String afternoonWeather,
      final String morningWind,
      final String afternoonWind,
      final String morningTemperature,
      final String afternoonTemperature,
      final String constructionDesc,
      final String machineWorkDesc,
      final String groupWorkDesc,
      final String qualityInspectionDesc,
      final String safetyInspectionDesc,
      final String siteImportantEvent,
      final String existingProblemDesc,
      final Long recorderId,
      final String recorderName,
      final Long managerId,
      final String managerName,
      final Long userId,
      final String userName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.constructionDate = constructionDate;
      this.morningWeather = morningWeather;
      this.afternoonWeather = afternoonWeather;
      this.morningWind = morningWind;
      this.afternoonWind = afternoonWind;
      this.morningTemperature = morningTemperature;
      this.afternoonTemperature = afternoonTemperature;
      this.constructionDesc = constructionDesc;
      this.machineWorkDesc = machineWorkDesc;
      this.groupWorkDesc = groupWorkDesc;
      this.qualityInspectionDesc = qualityInspectionDesc;
      this.safetyInspectionDesc = safetyInspectionDesc;
      this.siteImportantEvent = siteImportantEvent;
      this.existingProblemDesc = existingProblemDesc;
      this.recorderId = recorderId;
      this.recorderName = recorderName;
      this.managerId = managerId;
      this.managerName = managerName;
      this.userId = userId;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getConstructionDate() {
      return this.constructionDate;
   }

   public String getMorningWeather() {
      return this.morningWeather;
   }

   public String getAfternoonWeather() {
      return this.afternoonWeather;
   }

   public String getMorningWind() {
      return this.morningWind;
   }

   public String getAfternoonWind() {
      return this.afternoonWind;
   }

   public String getMorningTemperature() {
      return this.morningTemperature;
   }

   public String getAfternoonTemperature() {
      return this.afternoonTemperature;
   }

   public String getConstructionDesc() {
      return this.constructionDesc;
   }

   public String getMachineWorkDesc() {
      return this.machineWorkDesc;
   }

   public String getGroupWorkDesc() {
      return this.groupWorkDesc;
   }

   public String getQualityInspectionDesc() {
      return this.qualityInspectionDesc;
   }

   public String getSafetyInspectionDesc() {
      return this.safetyInspectionDesc;
   }

   public String getSiteImportantEvent() {
      return this.siteImportantEvent;
   }

   public String getExistingProblemDesc() {
      return this.existingProblemDesc;
   }

   public Long getRecorderId() {
      return this.recorderId;
   }

   public String getRecorderName() {
      return this.recorderName;
   }

   public Long getManagerId() {
      return this.managerId;
   }

   public String getManagerName() {
      return this.managerName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setConstructionDate(final LocalDate constructionDate) {
      this.constructionDate = constructionDate;
   }

   public void setMorningWeather(final String morningWeather) {
      this.morningWeather = morningWeather;
   }

   public void setAfternoonWeather(final String afternoonWeather) {
      this.afternoonWeather = afternoonWeather;
   }

   public void setMorningWind(final String morningWind) {
      this.morningWind = morningWind;
   }

   public void setAfternoonWind(final String afternoonWind) {
      this.afternoonWind = afternoonWind;
   }

   public void setMorningTemperature(final String morningTemperature) {
      this.morningTemperature = morningTemperature;
   }

   public void setAfternoonTemperature(final String afternoonTemperature) {
      this.afternoonTemperature = afternoonTemperature;
   }

   public void setConstructionDesc(final String constructionDesc) {
      this.constructionDesc = constructionDesc;
   }

   public void setMachineWorkDesc(final String machineWorkDesc) {
      this.machineWorkDesc = machineWorkDesc;
   }

   public void setGroupWorkDesc(final String groupWorkDesc) {
      this.groupWorkDesc = groupWorkDesc;
   }

   public void setQualityInspectionDesc(final String qualityInspectionDesc) {
      this.qualityInspectionDesc = qualityInspectionDesc;
   }

   public void setSafetyInspectionDesc(final String safetyInspectionDesc) {
      this.safetyInspectionDesc = safetyInspectionDesc;
   }

   public void setSiteImportantEvent(final String siteImportantEvent) {
      this.siteImportantEvent = siteImportantEvent;
   }

   public void setExistingProblemDesc(final String existingProblemDesc) {
      this.existingProblemDesc = existingProblemDesc;
   }

   public void setRecorderId(final Long recorderId) {
      this.recorderId = recorderId;
   }

   public void setRecorderName(final String recorderName) {
      this.recorderName = recorderName;
   }

   public void setManagerId(final Long managerId) {
      this.managerId = managerId;
   }

   public void setManagerName(final String managerName) {
      this.managerName = managerName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConstructionLogDTO)) {
         return false;
      }

      ProjectConstructionLogDTO other = (ProjectConstructionLogDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$recorderId = this.getRecorderId();
            Object other$recorderId = other.getRecorderId();
            if (this$recorderId == null ? other$recorderId == null : this$recorderId.equals(other$recorderId)) {
               Object this$managerId = this.getManagerId();
               Object other$managerId = other.getManagerId();
               if (this$managerId == null ? other$managerId == null : this$managerId.equals(other$managerId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$constructionDate = this.getConstructionDate();
                     Object other$constructionDate = other.getConstructionDate();
                     if (this$constructionDate == null ? other$constructionDate == null : this$constructionDate.equals(other$constructionDate)) {
                        Object this$morningWeather = this.getMorningWeather();
                        Object other$morningWeather = other.getMorningWeather();
                        if (this$morningWeather == null ? other$morningWeather == null : this$morningWeather.equals(other$morningWeather)) {
                           Object this$afternoonWeather = this.getAfternoonWeather();
                           Object other$afternoonWeather = other.getAfternoonWeather();
                           if (this$afternoonWeather == null ? other$afternoonWeather == null : this$afternoonWeather.equals(other$afternoonWeather)) {
                              Object this$morningWind = this.getMorningWind();
                              Object other$morningWind = other.getMorningWind();
                              if (this$morningWind == null ? other$morningWind == null : this$morningWind.equals(other$morningWind)) {
                                 Object this$afternoonWind = this.getAfternoonWind();
                                 Object other$afternoonWind = other.getAfternoonWind();
                                 if (this$afternoonWind == null ? other$afternoonWind == null : this$afternoonWind.equals(other$afternoonWind)) {
                                    Object this$morningTemperature = this.getMorningTemperature();
                                    Object other$morningTemperature = other.getMorningTemperature();
                                    if (this$morningTemperature == null
                                       ? other$morningTemperature == null
                                       : this$morningTemperature.equals(other$morningTemperature)) {
                                       Object this$afternoonTemperature = this.getAfternoonTemperature();
                                       Object other$afternoonTemperature = other.getAfternoonTemperature();
                                       if (this$afternoonTemperature == null
                                          ? other$afternoonTemperature == null
                                          : this$afternoonTemperature.equals(other$afternoonTemperature)) {
                                          Object this$constructionDesc = this.getConstructionDesc();
                                          Object other$constructionDesc = other.getConstructionDesc();
                                          if (this$constructionDesc == null
                                             ? other$constructionDesc == null
                                             : this$constructionDesc.equals(other$constructionDesc)) {
                                             Object this$machineWorkDesc = this.getMachineWorkDesc();
                                             Object other$machineWorkDesc = other.getMachineWorkDesc();
                                             if (this$machineWorkDesc == null
                                                ? other$machineWorkDesc == null
                                                : this$machineWorkDesc.equals(other$machineWorkDesc)) {
                                                Object this$groupWorkDesc = this.getGroupWorkDesc();
                                                Object other$groupWorkDesc = other.getGroupWorkDesc();
                                                if (this$groupWorkDesc == null ? other$groupWorkDesc == null : this$groupWorkDesc.equals(other$groupWorkDesc)) {
                                                   Object this$qualityInspectionDesc = this.getQualityInspectionDesc();
                                                   Object other$qualityInspectionDesc = other.getQualityInspectionDesc();
                                                   if (this$qualityInspectionDesc == null
                                                      ? other$qualityInspectionDesc == null
                                                      : this$qualityInspectionDesc.equals(other$qualityInspectionDesc)) {
                                                      Object this$safetyInspectionDesc = this.getSafetyInspectionDesc();
                                                      Object other$safetyInspectionDesc = other.getSafetyInspectionDesc();
                                                      if (this$safetyInspectionDesc == null
                                                         ? other$safetyInspectionDesc == null
                                                         : this$safetyInspectionDesc.equals(other$safetyInspectionDesc)) {
                                                         Object this$siteImportantEvent = this.getSiteImportantEvent();
                                                         Object other$siteImportantEvent = other.getSiteImportantEvent();
                                                         if (this$siteImportantEvent == null
                                                            ? other$siteImportantEvent == null
                                                            : this$siteImportantEvent.equals(other$siteImportantEvent)) {
                                                            Object this$existingProblemDesc = this.getExistingProblemDesc();
                                                            Object other$existingProblemDesc = other.getExistingProblemDesc();
                                                            if (this$existingProblemDesc == null
                                                               ? other$existingProblemDesc == null
                                                               : this$existingProblemDesc.equals(other$existingProblemDesc)) {
                                                               Object this$recorderName = this.getRecorderName();
                                                               Object other$recorderName = other.getRecorderName();
                                                               if (this$recorderName == null
                                                                  ? other$recorderName == null
                                                                  : this$recorderName.equals(other$recorderName)) {
                                                                  Object this$managerName = this.getManagerName();
                                                                  Object other$managerName = other.getManagerName();
                                                                  if (this$managerName == null
                                                                     ? other$managerName == null
                                                                     : this$managerName.equals(other$managerName)) {
                                                                     Object this$userName = this.getUserName();
                                                                     Object other$userName = other.getUserName();
                                                                     return this$userName == null
                                                                        ? other$userName == null
                                                                        : this$userName.equals(other$userName);
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
      return other instanceof ProjectConstructionLogDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $recorderId = this.getRecorderId();
      result = result * 59 + ($recorderId == null ? 43 : $recorderId.hashCode());
      Object $managerId = this.getManagerId();
      result = result * 59 + ($managerId == null ? 43 : $managerId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $constructionDate = this.getConstructionDate();
      result = result * 59 + ($constructionDate == null ? 43 : $constructionDate.hashCode());
      Object $morningWeather = this.getMorningWeather();
      result = result * 59 + ($morningWeather == null ? 43 : $morningWeather.hashCode());
      Object $afternoonWeather = this.getAfternoonWeather();
      result = result * 59 + ($afternoonWeather == null ? 43 : $afternoonWeather.hashCode());
      Object $morningWind = this.getMorningWind();
      result = result * 59 + ($morningWind == null ? 43 : $morningWind.hashCode());
      Object $afternoonWind = this.getAfternoonWind();
      result = result * 59 + ($afternoonWind == null ? 43 : $afternoonWind.hashCode());
      Object $morningTemperature = this.getMorningTemperature();
      result = result * 59 + ($morningTemperature == null ? 43 : $morningTemperature.hashCode());
      Object $afternoonTemperature = this.getAfternoonTemperature();
      result = result * 59 + ($afternoonTemperature == null ? 43 : $afternoonTemperature.hashCode());
      Object $constructionDesc = this.getConstructionDesc();
      result = result * 59 + ($constructionDesc == null ? 43 : $constructionDesc.hashCode());
      Object $machineWorkDesc = this.getMachineWorkDesc();
      result = result * 59 + ($machineWorkDesc == null ? 43 : $machineWorkDesc.hashCode());
      Object $groupWorkDesc = this.getGroupWorkDesc();
      result = result * 59 + ($groupWorkDesc == null ? 43 : $groupWorkDesc.hashCode());
      Object $qualityInspectionDesc = this.getQualityInspectionDesc();
      result = result * 59 + ($qualityInspectionDesc == null ? 43 : $qualityInspectionDesc.hashCode());
      Object $safetyInspectionDesc = this.getSafetyInspectionDesc();
      result = result * 59 + ($safetyInspectionDesc == null ? 43 : $safetyInspectionDesc.hashCode());
      Object $siteImportantEvent = this.getSiteImportantEvent();
      result = result * 59 + ($siteImportantEvent == null ? 43 : $siteImportantEvent.hashCode());
      Object $existingProblemDesc = this.getExistingProblemDesc();
      result = result * 59 + ($existingProblemDesc == null ? 43 : $existingProblemDesc.hashCode());
      Object $recorderName = this.getRecorderName();
      result = result * 59 + ($recorderName == null ? 43 : $recorderName.hashCode());
      Object $managerName = this.getManagerName();
      result = result * 59 + ($managerName == null ? 43 : $managerName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConstructionLogDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", constructionDate="
         + this.getConstructionDate()
         + ", morningWeather="
         + this.getMorningWeather()
         + ", afternoonWeather="
         + this.getAfternoonWeather()
         + ", morningWind="
         + this.getMorningWind()
         + ", afternoonWind="
         + this.getAfternoonWind()
         + ", morningTemperature="
         + this.getMorningTemperature()
         + ", afternoonTemperature="
         + this.getAfternoonTemperature()
         + ", constructionDesc="
         + this.getConstructionDesc()
         + ", machineWorkDesc="
         + this.getMachineWorkDesc()
         + ", groupWorkDesc="
         + this.getGroupWorkDesc()
         + ", qualityInspectionDesc="
         + this.getQualityInspectionDesc()
         + ", safetyInspectionDesc="
         + this.getSafetyInspectionDesc()
         + ", siteImportantEvent="
         + this.getSiteImportantEvent()
         + ", existingProblemDesc="
         + this.getExistingProblemDesc()
         + ", recorderId="
         + this.getRecorderId()
         + ", recorderName="
         + this.getRecorderName()
         + ", managerId="
         + this.getManagerId()
         + ", managerName="
         + this.getManagerName()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class ProjectConstructionLogDTOBuilder {
      private Long id;
      private Long projectId;
      private LocalDate constructionDate;
      private String morningWeather;
      private String afternoonWeather;
      private String morningWind;
      private String afternoonWind;
      private String morningTemperature;
      private String afternoonTemperature;
      private String constructionDesc;
      private String machineWorkDesc;
      private String groupWorkDesc;
      private String qualityInspectionDesc;
      private String safetyInspectionDesc;
      private String siteImportantEvent;
      private String existingProblemDesc;
      private Long recorderId;
      private String recorderName;
      private Long managerId;
      private String managerName;
      private Long userId;
      private String userName;

      ProjectConstructionLogDTOBuilder() {
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder constructionDate(final LocalDate constructionDate) {
         this.constructionDate = constructionDate;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder morningWeather(final String morningWeather) {
         this.morningWeather = morningWeather;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder afternoonWeather(final String afternoonWeather) {
         this.afternoonWeather = afternoonWeather;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder morningWind(final String morningWind) {
         this.morningWind = morningWind;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder afternoonWind(final String afternoonWind) {
         this.afternoonWind = afternoonWind;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder morningTemperature(final String morningTemperature) {
         this.morningTemperature = morningTemperature;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder afternoonTemperature(final String afternoonTemperature) {
         this.afternoonTemperature = afternoonTemperature;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder constructionDesc(final String constructionDesc) {
         this.constructionDesc = constructionDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder machineWorkDesc(final String machineWorkDesc) {
         this.machineWorkDesc = machineWorkDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder groupWorkDesc(final String groupWorkDesc) {
         this.groupWorkDesc = groupWorkDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder qualityInspectionDesc(final String qualityInspectionDesc) {
         this.qualityInspectionDesc = qualityInspectionDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder safetyInspectionDesc(final String safetyInspectionDesc) {
         this.safetyInspectionDesc = safetyInspectionDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder siteImportantEvent(final String siteImportantEvent) {
         this.siteImportantEvent = siteImportantEvent;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder existingProblemDesc(final String existingProblemDesc) {
         this.existingProblemDesc = existingProblemDesc;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder recorderId(final Long recorderId) {
         this.recorderId = recorderId;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder recorderName(final String recorderName) {
         this.recorderName = recorderName;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder managerId(final Long managerId) {
         this.managerId = managerId;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder managerName(final String managerName) {
         this.managerName = managerName;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectConstructionLogDTO build() {
         return new ProjectConstructionLogDTO(
            this.id,
            this.projectId,
            this.constructionDate,
            this.morningWeather,
            this.afternoonWeather,
            this.morningWind,
            this.afternoonWind,
            this.morningTemperature,
            this.afternoonTemperature,
            this.constructionDesc,
            this.machineWorkDesc,
            this.groupWorkDesc,
            this.qualityInspectionDesc,
            this.safetyInspectionDesc,
            this.siteImportantEvent,
            this.existingProblemDesc,
            this.recorderId,
            this.recorderName,
            this.managerId,
            this.managerName,
            this.userId,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "ProjectConstructionLogDTO.ProjectConstructionLogDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", constructionDate="
            + this.constructionDate
            + ", morningWeather="
            + this.morningWeather
            + ", afternoonWeather="
            + this.afternoonWeather
            + ", morningWind="
            + this.morningWind
            + ", afternoonWind="
            + this.afternoonWind
            + ", morningTemperature="
            + this.morningTemperature
            + ", afternoonTemperature="
            + this.afternoonTemperature
            + ", constructionDesc="
            + this.constructionDesc
            + ", machineWorkDesc="
            + this.machineWorkDesc
            + ", groupWorkDesc="
            + this.groupWorkDesc
            + ", qualityInspectionDesc="
            + this.qualityInspectionDesc
            + ", safetyInspectionDesc="
            + this.safetyInspectionDesc
            + ", siteImportantEvent="
            + this.siteImportantEvent
            + ", existingProblemDesc="
            + this.existingProblemDesc
            + ", recorderId="
            + this.recorderId
            + ", recorderName="
            + this.recorderName
            + ", managerId="
            + this.managerId
            + ", managerName="
            + this.managerName
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
