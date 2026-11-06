package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(description = "项目计划DTO类")
public class EnclosureProjectPlanDTO {
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
   @ApiModelProperty("结构类型")
   private Integer structureType;
   @ApiModelProperty("创建时间")
   private LocalDate createDate;
   @ApiModelProperty("创建用户")
   private String createUser;
   @ApiModelProperty("开工时间")
   private LocalDate startDate;
   @ApiModelProperty("完工时间")
   private LocalDate endDate;
   @ApiModelProperty("工期(天)")
   private Integer duration;

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

   public Integer getStructureType() {
      return this.structureType;
   }

   public LocalDate getCreateDate() {
      return this.createDate;
   }

   public String getCreateUser() {
      return this.createUser;
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

   public void setStructureType(final Integer structureType) {
      this.structureType = structureType;
   }

   public void setCreateDate(final LocalDate createDate) {
      this.createDate = createDate;
   }

   public void setCreateUser(final String createUser) {
      this.createUser = createUser;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProjectPlanDTO)) {
         return false;
      }

      EnclosureProjectPlanDTO other = (EnclosureProjectPlanDTO)o;
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
                  Object this$duration = this.getDuration();
                  Object other$duration = other.getDuration();
                  if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                     Object this$projectSerialNumber = this.getProjectSerialNumber();
                     Object other$projectSerialNumber = other.getProjectSerialNumber();
                     if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                        Object this$projectShortName = this.getProjectShortName();
                        Object other$projectShortName = other.getProjectShortName();
                        if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                           Object this$createDate = this.getCreateDate();
                           Object other$createDate = other.getCreateDate();
                           if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                              Object this$createUser = this.getCreateUser();
                              Object other$createUser = other.getCreateUser();
                              if (this$createUser == null ? other$createUser == null : this$createUser.equals(other$createUser)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof EnclosureProjectPlanDTO;
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
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $createUser = this.getCreateUser();
      result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProjectPlanDTO(projectId="
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
         + ", createDate="
         + this.getCreateDate()
         + ", createUser="
         + this.getCreateUser()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", duration="
         + this.getDuration()
         + ")";
   }
}
