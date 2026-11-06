package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "项目计划DTO类")
public class ProjectPlanDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("计划状态(0: 未创建, 1: 已创建)")
   private Integer planStatus;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目简称")
   private String projectShortName;
   @ApiModelProperty("订单类型")
   private Integer orderType;
   @Deprecated
   @ApiModelProperty("结构类型")
   private Integer structureType;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   private Long structureTypeId;
   @ApiModelProperty(name = "structureTypeName", value = "结构类型名称")
   private String structureTypeName;
   @ApiModelProperty("开工时间")
   private LocalDate startDate;
   @ApiModelProperty("完工时间")
   private LocalDate endDate;
   @ApiModelProperty("工期(天)")
   private Integer duration;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("用户id")
   private Integer userId;
   @ApiModelProperty("用户")
   private String user;
   @ApiModelProperty("预算量")
   private BigDecimal budgetVolume;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getPlanStatus() {
      return this.planStatus;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public Integer getOrderType() {
      return this.orderType;
   }

   @Deprecated
   public Integer getStructureType() {
      return this.structureType;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public String getStructureTypeName() {
      return this.structureTypeName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getDuration() {
      return this.duration;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public String getUser() {
      return this.user;
   }

   public BigDecimal getBudgetVolume() {
      return this.budgetVolume;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPlanStatus(final Integer planStatus) {
      this.planStatus = planStatus;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setOrderType(final Integer orderType) {
      this.orderType = orderType;
   }

   @Deprecated
   public void setStructureType(final Integer structureType) {
      this.structureType = structureType;
   }

   public void setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
   }

   public void setStructureTypeName(final String structureTypeName) {
      this.structureTypeName = structureTypeName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setDuration(final Integer duration) {
      this.duration = duration;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserId(final Integer userId) {
      this.userId = userId;
   }

   public void setUser(final String user) {
      this.user = user;
   }

   public void setBudgetVolume(final BigDecimal budgetVolume) {
      this.budgetVolume = budgetVolume;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPlanDTO)) {
         return false;
      }

      ProjectPlanDTO other = (ProjectPlanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$planStatus = this.getPlanStatus();
         Object other$planStatus = other.getPlanStatus();
         if (this$planStatus == null ? other$planStatus == null : this$planStatus.equals(other$planStatus)) {
            Object this$orderType = this.getOrderType();
            Object other$orderType = other.getOrderType();
            if (this$orderType == null ? other$orderType == null : this$orderType.equals(other$orderType)) {
               Object this$structureType = this.getStructureType();
               Object other$structureType = other.getStructureType();
               if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                  Object this$structureTypeId = this.getStructureTypeId();
                  Object other$structureTypeId = other.getStructureTypeId();
                  if (this$structureTypeId == null ? other$structureTypeId == null : this$structureTypeId.equals(other$structureTypeId)) {
                     Object this$duration = this.getDuration();
                     Object other$duration = other.getDuration();
                     if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$projectSerialNumber = this.getProjectSerialNumber();
                           Object other$projectSerialNumber = other.getProjectSerialNumber();
                           if (this$projectSerialNumber == null
                              ? other$projectSerialNumber == null
                              : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                              Object this$projectShortName = this.getProjectShortName();
                              Object other$projectShortName = other.getProjectShortName();
                              if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                                 Object this$structureTypeName = this.getStructureTypeName();
                                 Object other$structureTypeName = other.getStructureTypeName();
                                 if (this$structureTypeName == null ? other$structureTypeName == null : this$structureTypeName.equals(other$structureTypeName)) {
                                    Object this$startDate = this.getStartDate();
                                    Object other$startDate = other.getStartDate();
                                    if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                       Object this$endDate = this.getEndDate();
                                       Object other$endDate = other.getEndDate();
                                       if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$user = this.getUser();
                                             Object other$user = other.getUser();
                                             if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                                Object this$budgetVolume = this.getBudgetVolume();
                                                Object other$budgetVolume = other.getBudgetVolume();
                                                return this$budgetVolume == null ? other$budgetVolume == null : this$budgetVolume.equals(other$budgetVolume);
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
      return other instanceof ProjectPlanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $planStatus = this.getPlanStatus();
      result = result * 59 + ($planStatus == null ? 43 : $planStatus.hashCode());
      Object $orderType = this.getOrderType();
      result = result * 59 + ($orderType == null ? 43 : $orderType.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $structureTypeName = this.getStructureTypeName();
      result = result * 59 + ($structureTypeName == null ? 43 : $structureTypeName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $budgetVolume = this.getBudgetVolume();
      return result * 59 + ($budgetVolume == null ? 43 : $budgetVolume.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPlanDTO(projectId="
         + this.getProjectId()
         + ", planStatus="
         + this.getPlanStatus()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", orderType="
         + this.getOrderType()
         + ", structureType="
         + this.getStructureType()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", structureTypeName="
         + this.getStructureTypeName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", duration="
         + this.getDuration()
         + ", createTime="
         + this.getCreateTime()
         + ", userId="
         + this.getUserId()
         + ", user="
         + this.getUser()
         + ", budgetVolume="
         + this.getBudgetVolume()
         + ")";
   }
}
