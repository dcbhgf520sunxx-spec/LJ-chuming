package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel("问题分页返回类")
public class ProjectSafetyProblemDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "number", notes = "流水编号")
   private String number;
   @ApiModelProperty(name = "siteId", notes = "问题id")
   private Long siteId;
   @ApiModelProperty(name = "remark", notes = "问题详情")
   private String remark;
   @ApiModelProperty(name = "description", notes = "问题描述")
   private String description;
   @ApiModelProperty(name = "dutyId", value = "责任人id", notes = "责任人id")
   private Long dutyId;
   @ApiModelProperty(name = "dutyName", value = "责任人名称", notes = "责任人名称")
   private String dutyName;
   @ApiModelProperty(name = "overseerUserId", value = "督办人", notes = "督办人")
   private Long overseerUserId;
   @ApiModelProperty(name = "overseerUserName", value = "督办人名称", notes = "督办人名称")
   private String overseerUserName;
   @ApiModelProperty(name = "powerType", notes = "人员权限 1查看 2整改 4审核")
   private Integer powerType;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "problemStatus", notes = "问题状态")
   private Integer problemStatus;
   @ApiModelProperty(name = "problemDate", value = "问题发生日期", notes = "问题发生日期")
   private LocalDateTime problemDate;
   @ApiModelProperty(name = "createUserName", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "createUserId", notes = "创建人")
   private Long createUserId;
   @ApiModelProperty(name = "askRectifyTime", value = "要求整改日期", notes = "要求整改日期")
   private LocalDate askRectifyTime;
   @ApiModelProperty(name = "projectManageInstallRecordId", notes = "安装记录表id")
   private Long projectManageInstallRecordId;
   @ApiModelProperty(name = "detectionType", notes = "检测类型")
   private Integer detectionType;
   @ApiModelProperty(name = "productQuantity", notes = "产品数量")
   private Integer productQuantity;

   public static ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder builder() {
      return new ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder();
   }

   public ProjectSafetyProblemDTO() {
   }

   public ProjectSafetyProblemDTO(
      final Long id,
      final String number,
      final Long siteId,
      final String remark,
      final String description,
      final Long dutyId,
      final String dutyName,
      final Long overseerUserId,
      final String overseerUserName,
      final Integer powerType,
      final Long projectId,
      final String projectName,
      final Integer problemStatus,
      final LocalDateTime problemDate,
      final String createUserName,
      final Long createUserId,
      final LocalDate askRectifyTime,
      final Long projectManageInstallRecordId,
      final Integer detectionType,
      final Integer productQuantity
   ) {
      this.id = id;
      this.number = number;
      this.siteId = siteId;
      this.remark = remark;
      this.description = description;
      this.dutyId = dutyId;
      this.dutyName = dutyName;
      this.overseerUserId = overseerUserId;
      this.overseerUserName = overseerUserName;
      this.powerType = powerType;
      this.projectId = projectId;
      this.projectName = projectName;
      this.problemStatus = problemStatus;
      this.problemDate = problemDate;
      this.createUserName = createUserName;
      this.createUserId = createUserId;
      this.askRectifyTime = askRectifyTime;
      this.projectManageInstallRecordId = projectManageInstallRecordId;
      this.detectionType = detectionType;
      this.productQuantity = productQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public Long getSiteId() {
      return this.siteId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getDescription() {
      return this.description;
   }

   public Long getDutyId() {
      return this.dutyId;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public Long getOverseerUserId() {
      return this.overseerUserId;
   }

   public String getOverseerUserName() {
      return this.overseerUserName;
   }

   public Integer getPowerType() {
      return this.powerType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getProblemStatus() {
      return this.problemStatus;
   }

   public LocalDateTime getProblemDate() {
      return this.problemDate;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public LocalDate getAskRectifyTime() {
      return this.askRectifyTime;
   }

   public Long getProjectManageInstallRecordId() {
      return this.projectManageInstallRecordId;
   }

   public Integer getDetectionType() {
      return this.detectionType;
   }

   public Integer getProductQuantity() {
      return this.productQuantity;
   }

   public ProjectSafetyProblemDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectSafetyProblemDTO setNumber(final String number) {
      this.number = number;
      return this;
   }

   public ProjectSafetyProblemDTO setSiteId(final Long siteId) {
      this.siteId = siteId;
      return this;
   }

   public ProjectSafetyProblemDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectSafetyProblemDTO setDescription(final String description) {
      this.description = description;
      return this;
   }

   public ProjectSafetyProblemDTO setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   public ProjectSafetyProblemDTO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   public ProjectSafetyProblemDTO setOverseerUserId(final Long overseerUserId) {
      this.overseerUserId = overseerUserId;
      return this;
   }

   public ProjectSafetyProblemDTO setOverseerUserName(final String overseerUserName) {
      this.overseerUserName = overseerUserName;
      return this;
   }

   public ProjectSafetyProblemDTO setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   public ProjectSafetyProblemDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectSafetyProblemDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectSafetyProblemDTO setProblemStatus(final Integer problemStatus) {
      this.problemStatus = problemStatus;
      return this;
   }

   public ProjectSafetyProblemDTO setProblemDate(final LocalDateTime problemDate) {
      this.problemDate = problemDate;
      return this;
   }

   public ProjectSafetyProblemDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ProjectSafetyProblemDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectSafetyProblemDTO setAskRectifyTime(final LocalDate askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   public ProjectSafetyProblemDTO setProjectManageInstallRecordId(final Long projectManageInstallRecordId) {
      this.projectManageInstallRecordId = projectManageInstallRecordId;
      return this;
   }

   public ProjectSafetyProblemDTO setDetectionType(final Integer detectionType) {
      this.detectionType = detectionType;
      return this;
   }

   public ProjectSafetyProblemDTO setProductQuantity(final Integer productQuantity) {
      this.productQuantity = productQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemDTO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", siteId="
         + this.getSiteId()
         + ", remark="
         + this.getRemark()
         + ", description="
         + this.getDescription()
         + ", dutyId="
         + this.getDutyId()
         + ", dutyName="
         + this.getDutyName()
         + ", overseerUserId="
         + this.getOverseerUserId()
         + ", overseerUserName="
         + this.getOverseerUserName()
         + ", powerType="
         + this.getPowerType()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", problemStatus="
         + this.getProblemStatus()
         + ", problemDate="
         + this.getProblemDate()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createUserId="
         + this.getCreateUserId()
         + ", askRectifyTime="
         + this.getAskRectifyTime()
         + ", projectManageInstallRecordId="
         + this.getProjectManageInstallRecordId()
         + ", detectionType="
         + this.getDetectionType()
         + ", productQuantity="
         + this.getProductQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemDTO)) {
         return false;
      }

      ProjectSafetyProblemDTO other = (ProjectSafetyProblemDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$siteId = this.getSiteId();
         Object other$siteId = other.getSiteId();
         if (this$siteId == null ? other$siteId == null : this$siteId.equals(other$siteId)) {
            Object this$dutyId = this.getDutyId();
            Object other$dutyId = other.getDutyId();
            if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
               Object this$overseerUserId = this.getOverseerUserId();
               Object other$overseerUserId = other.getOverseerUserId();
               if (this$overseerUserId == null ? other$overseerUserId == null : this$overseerUserId.equals(other$overseerUserId)) {
                  Object this$powerType = this.getPowerType();
                  Object other$powerType = other.getPowerType();
                  if (this$powerType == null ? other$powerType == null : this$powerType.equals(other$powerType)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$problemStatus = this.getProblemStatus();
                        Object other$problemStatus = other.getProblemStatus();
                        if (this$problemStatus == null ? other$problemStatus == null : this$problemStatus.equals(other$problemStatus)) {
                           Object this$createUserId = this.getCreateUserId();
                           Object other$createUserId = other.getCreateUserId();
                           if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                              Object this$projectManageInstallRecordId = this.getProjectManageInstallRecordId();
                              Object other$projectManageInstallRecordId = other.getProjectManageInstallRecordId();
                              if (this$projectManageInstallRecordId == null
                                 ? other$projectManageInstallRecordId == null
                                 : this$projectManageInstallRecordId.equals(other$projectManageInstallRecordId)) {
                                 Object this$detectionType = this.getDetectionType();
                                 Object other$detectionType = other.getDetectionType();
                                 if (this$detectionType == null ? other$detectionType == null : this$detectionType.equals(other$detectionType)) {
                                    Object this$productQuantity = this.getProductQuantity();
                                    Object other$productQuantity = other.getProductQuantity();
                                    if (this$productQuantity == null ? other$productQuantity == null : this$productQuantity.equals(other$productQuantity)) {
                                       Object this$number = this.getNumber();
                                       Object other$number = other.getNumber();
                                       if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$description = this.getDescription();
                                             Object other$description = other.getDescription();
                                             if (this$description == null ? other$description == null : this$description.equals(other$description)) {
                                                Object this$dutyName = this.getDutyName();
                                                Object other$dutyName = other.getDutyName();
                                                if (this$dutyName == null ? other$dutyName == null : this$dutyName.equals(other$dutyName)) {
                                                   Object this$overseerUserName = this.getOverseerUserName();
                                                   Object other$overseerUserName = other.getOverseerUserName();
                                                   if (this$overseerUserName == null
                                                      ? other$overseerUserName == null
                                                      : this$overseerUserName.equals(other$overseerUserName)) {
                                                      Object this$projectName = this.getProjectName();
                                                      Object other$projectName = other.getProjectName();
                                                      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                         Object this$problemDate = this.getProblemDate();
                                                         Object other$problemDate = other.getProblemDate();
                                                         if (this$problemDate == null ? other$problemDate == null : this$problemDate.equals(other$problemDate)) {
                                                            Object this$createUserName = this.getCreateUserName();
                                                            Object other$createUserName = other.getCreateUserName();
                                                            if (this$createUserName == null
                                                               ? other$createUserName == null
                                                               : this$createUserName.equals(other$createUserName)) {
                                                               Object this$askRectifyTime = this.getAskRectifyTime();
                                                               Object other$askRectifyTime = other.getAskRectifyTime();
                                                               return this$askRectifyTime == null
                                                                  ? other$askRectifyTime == null
                                                                  : this$askRectifyTime.equals(other$askRectifyTime);
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
      return other instanceof ProjectSafetyProblemDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $siteId = this.getSiteId();
      result = result * 59 + ($siteId == null ? 43 : $siteId.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $overseerUserId = this.getOverseerUserId();
      result = result * 59 + ($overseerUserId == null ? 43 : $overseerUserId.hashCode());
      Object $powerType = this.getPowerType();
      result = result * 59 + ($powerType == null ? 43 : $powerType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $problemStatus = this.getProblemStatus();
      result = result * 59 + ($problemStatus == null ? 43 : $problemStatus.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $projectManageInstallRecordId = this.getProjectManageInstallRecordId();
      result = result * 59 + ($projectManageInstallRecordId == null ? 43 : $projectManageInstallRecordId.hashCode());
      Object $detectionType = this.getDetectionType();
      result = result * 59 + ($detectionType == null ? 43 : $detectionType.hashCode());
      Object $productQuantity = this.getProductQuantity();
      result = result * 59 + ($productQuantity == null ? 43 : $productQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $dutyName = this.getDutyName();
      result = result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
      Object $overseerUserName = this.getOverseerUserName();
      result = result * 59 + ($overseerUserName == null ? 43 : $overseerUserName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $problemDate = this.getProblemDate();
      result = result * 59 + ($problemDate == null ? 43 : $problemDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $askRectifyTime = this.getAskRectifyTime();
      return result * 59 + ($askRectifyTime == null ? 43 : $askRectifyTime.hashCode());
   }

   public static class ProjectSafetyProblemDTOBuilder {
      private Long id;
      private String number;
      private Long siteId;
      private String remark;
      private String description;
      private Long dutyId;
      private String dutyName;
      private Long overseerUserId;
      private String overseerUserName;
      private Integer powerType;
      private Long projectId;
      private String projectName;
      private Integer problemStatus;
      private LocalDateTime problemDate;
      private String createUserName;
      private Long createUserId;
      private LocalDate askRectifyTime;
      private Long projectManageInstallRecordId;
      private Integer detectionType;
      private Integer productQuantity;

      ProjectSafetyProblemDTOBuilder() {
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder siteId(final Long siteId) {
         this.siteId = siteId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder description(final String description) {
         this.description = description;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder overseerUserId(final Long overseerUserId) {
         this.overseerUserId = overseerUserId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder overseerUserName(final String overseerUserName) {
         this.overseerUserName = overseerUserName;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder problemStatus(final Integer problemStatus) {
         this.problemStatus = problemStatus;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder problemDate(final LocalDateTime problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder askRectifyTime(final LocalDate askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder projectManageInstallRecordId(final Long projectManageInstallRecordId) {
         this.projectManageInstallRecordId = projectManageInstallRecordId;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder detectionType(final Integer detectionType) {
         this.detectionType = detectionType;
         return this;
      }

      public ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder productQuantity(final Integer productQuantity) {
         this.productQuantity = productQuantity;
         return this;
      }

      public ProjectSafetyProblemDTO build() {
         return new ProjectSafetyProblemDTO(
            this.id,
            this.number,
            this.siteId,
            this.remark,
            this.description,
            this.dutyId,
            this.dutyName,
            this.overseerUserId,
            this.overseerUserName,
            this.powerType,
            this.projectId,
            this.projectName,
            this.problemStatus,
            this.problemDate,
            this.createUserName,
            this.createUserId,
            this.askRectifyTime,
            this.projectManageInstallRecordId,
            this.detectionType,
            this.productQuantity
         );
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemDTO.ProjectSafetyProblemDTOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", siteId="
            + this.siteId
            + ", remark="
            + this.remark
            + ", description="
            + this.description
            + ", dutyId="
            + this.dutyId
            + ", dutyName="
            + this.dutyName
            + ", overseerUserId="
            + this.overseerUserId
            + ", overseerUserName="
            + this.overseerUserName
            + ", powerType="
            + this.powerType
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", problemStatus="
            + this.problemStatus
            + ", problemDate="
            + this.problemDate
            + ", createUserName="
            + this.createUserName
            + ", createUserId="
            + this.createUserId
            + ", askRectifyTime="
            + this.askRectifyTime
            + ", projectManageInstallRecordId="
            + this.projectManageInstallRecordId
            + ", detectionType="
            + this.detectionType
            + ", productQuantity="
            + this.productQuantity
            + ")";
      }
   }
}
