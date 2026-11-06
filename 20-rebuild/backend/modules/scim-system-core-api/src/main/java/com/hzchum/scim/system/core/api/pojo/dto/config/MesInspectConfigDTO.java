package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MesInspectConfigDTO {
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
   @ApiModelProperty(name = "inspectType", value = "质检方式[0 全检 1抽检]", notes = "质检方式[0 全检 1抽检]")
   @NotNull(message = "质检方式不能为空")
   private Integer inspectType;
   @ApiModelProperty(name = "firstInspectRate", value = "首检率", notes = "首检率")
   @NotNull(message = "首检率不能为空")
   private Integer firstInspectRate;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   private Boolean status;
   @ApiModelProperty(name = "inspectMethod", value = "检查方式[0 扫码检验 1不扫码检验]", notes = "检查方式[0 扫码检验 1不扫码检验]")
   private Integer inspectMethod;
   @ApiModelProperty(name = "teamLink", value = "关联班组")
   @NotEmpty(message = "关联班组不能为空")
   private List<MesInspectConfigTeamLinkDTO> teamLink;
   @ApiModelProperty(name = "classificationList", value = "关联零部构件种类")
   @NotEmpty(message = "关联零部构件种类不能为空")
   private List<MesInspectClassificationConfigLinkDTO> classificationList;
   @ApiModelProperty(name = "insepectUserList", value = "关联质检人员")
   @NotEmpty(message = "关联质检人员不能为空")
   private List<MesInspectConfigUserLinkDTO> insepectUserList;
   @ApiModelProperty(name = "mesProductEnum", notes = "mes产品分类")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;

   public static MesInspectConfigDTO.MesInspectConfigDTOBuilder builder() {
      return new MesInspectConfigDTO.MesInspectConfigDTOBuilder();
   }

   public MesInspectConfigDTO() {
   }

   public MesInspectConfigDTO(
      final Long id,
      final Long workshopId,
      final String workshopName,
      final Integer taskTypeEnum,
      final Integer artifactType,
      final Long processId,
      final String processName,
      final Integer inspectType,
      final Integer firstInspectRate,
      final Boolean status,
      final Integer inspectMethod,
      final List<MesInspectConfigTeamLinkDTO> teamLink,
      final List<MesInspectClassificationConfigLinkDTO> classificationList,
      final List<MesInspectConfigUserLinkDTO> insepectUserList,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.taskTypeEnum = taskTypeEnum;
      this.artifactType = artifactType;
      this.processId = processId;
      this.processName = processName;
      this.inspectType = inspectType;
      this.firstInspectRate = firstInspectRate;
      this.status = status;
      this.inspectMethod = inspectMethod;
      this.teamLink = teamLink;
      this.classificationList = classificationList;
      this.insepectUserList = insepectUserList;
      this.mesProductEnum = mesProductEnum;
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

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Integer getFirstInspectRate() {
      return this.firstInspectRate;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getInspectMethod() {
      return this.inspectMethod;
   }

   public List<MesInspectConfigTeamLinkDTO> getTeamLink() {
      return this.teamLink;
   }

   public List<MesInspectClassificationConfigLinkDTO> getClassificationList() {
      return this.classificationList;
   }

   public List<MesInspectConfigUserLinkDTO> getInsepectUserList() {
      return this.insepectUserList;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
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

   public void setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
   }

   public void setFirstInspectRate(final Integer firstInspectRate) {
      this.firstInspectRate = firstInspectRate;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setInspectMethod(final Integer inspectMethod) {
      this.inspectMethod = inspectMethod;
   }

   public void setTeamLink(final List<MesInspectConfigTeamLinkDTO> teamLink) {
      this.teamLink = teamLink;
   }

   public void setClassificationList(final List<MesInspectClassificationConfigLinkDTO> classificationList) {
      this.classificationList = classificationList;
   }

   public void setInsepectUserList(final List<MesInspectConfigUserLinkDTO> insepectUserList) {
      this.insepectUserList = insepectUserList;
   }

   @JsonProperty("mesProductEnum")
   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigDTO)) {
         return false;
      }

      MesInspectConfigDTO other = (MesInspectConfigDTO)o;
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
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$inspectMethod = this.getInspectMethod();
                              Object other$inspectMethod = other.getInspectMethod();
                              if (this$inspectMethod == null ? other$inspectMethod == null : this$inspectMethod.equals(other$inspectMethod)) {
                                 Object this$mesProductEnum = this.getMesProductEnum();
                                 Object other$mesProductEnum = other.getMesProductEnum();
                                 if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$processName = this.getProcessName();
                                       Object other$processName = other.getProcessName();
                                       if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                          Object this$teamLink = this.getTeamLink();
                                          Object other$teamLink = other.getTeamLink();
                                          if (this$teamLink == null ? other$teamLink == null : this$teamLink.equals(other$teamLink)) {
                                             Object this$classificationList = this.getClassificationList();
                                             Object other$classificationList = other.getClassificationList();
                                             if (this$classificationList == null
                                                ? other$classificationList == null
                                                : this$classificationList.equals(other$classificationList)) {
                                                Object this$insepectUserList = this.getInsepectUserList();
                                                Object other$insepectUserList = other.getInsepectUserList();
                                                return this$insepectUserList == null
                                                   ? other$insepectUserList == null
                                                   : this$insepectUserList.equals(other$insepectUserList);
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
      return other instanceof MesInspectConfigDTO;
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
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $inspectMethod = this.getInspectMethod();
      result = result * 59 + ($inspectMethod == null ? 43 : $inspectMethod.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamLink = this.getTeamLink();
      result = result * 59 + ($teamLink == null ? 43 : $teamLink.hashCode());
      Object $classificationList = this.getClassificationList();
      result = result * 59 + ($classificationList == null ? 43 : $classificationList.hashCode());
      Object $insepectUserList = this.getInsepectUserList();
      return result * 59 + ($insepectUserList == null ? 43 : $insepectUserList.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectConfigDTO(id="
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
         + ", inspectType="
         + this.getInspectType()
         + ", firstInspectRate="
         + this.getFirstInspectRate()
         + ", status="
         + this.getStatus()
         + ", inspectMethod="
         + this.getInspectMethod()
         + ", teamLink="
         + this.getTeamLink()
         + ", classificationList="
         + this.getClassificationList()
         + ", insepectUserList="
         + this.getInsepectUserList()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class MesInspectConfigDTOBuilder {
      private Long id;
      private Long workshopId;
      private String workshopName;
      private Integer taskTypeEnum;
      private Integer artifactType;
      private Long processId;
      private String processName;
      private Integer inspectType;
      private Integer firstInspectRate;
      private Boolean status;
      private Integer inspectMethod;
      private List<MesInspectConfigTeamLinkDTO> teamLink;
      private List<MesInspectClassificationConfigLinkDTO> classificationList;
      private List<MesInspectConfigUserLinkDTO> insepectUserList;
      private Integer mesProductEnum;

      MesInspectConfigDTOBuilder() {
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder firstInspectRate(final Integer firstInspectRate) {
         this.firstInspectRate = firstInspectRate;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder inspectMethod(final Integer inspectMethod) {
         this.inspectMethod = inspectMethod;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder teamLink(final List<MesInspectConfigTeamLinkDTO> teamLink) {
         this.teamLink = teamLink;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder classificationList(final List<MesInspectClassificationConfigLinkDTO> classificationList) {
         this.classificationList = classificationList;
         return this;
      }

      public MesInspectConfigDTO.MesInspectConfigDTOBuilder insepectUserList(final List<MesInspectConfigUserLinkDTO> insepectUserList) {
         this.insepectUserList = insepectUserList;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesInspectConfigDTO.MesInspectConfigDTOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesInspectConfigDTO build() {
         return new MesInspectConfigDTO(
            this.id,
            this.workshopId,
            this.workshopName,
            this.taskTypeEnum,
            this.artifactType,
            this.processId,
            this.processName,
            this.inspectType,
            this.firstInspectRate,
            this.status,
            this.inspectMethod,
            this.teamLink,
            this.classificationList,
            this.insepectUserList,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesInspectConfigDTO.MesInspectConfigDTOBuilder(id="
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
            + ", inspectType="
            + this.inspectType
            + ", firstInspectRate="
            + this.firstInspectRate
            + ", status="
            + this.status
            + ", inspectMethod="
            + this.inspectMethod
            + ", teamLink="
            + this.teamLink
            + ", classificationList="
            + this.classificationList
            + ", insepectUserList="
            + this.insepectUserList
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
