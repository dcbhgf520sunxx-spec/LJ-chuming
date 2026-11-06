package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "UserProductionSummaryDTO", description = " ")
public class UserProductionSummaryDTO {
   @ApiModelProperty(name = "project", notes = "车间")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "userId", value = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private BigDecimal taskQuantity;
   @ApiModelProperty(name = "reportQuantity", value = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private BigDecimal reportQuantity;
   @ApiModelProperty(name = "reportNetWeight", value = "上报产量(净重)")
   @JsonProperty("reportNetWeight")
   @JSONField(name = "reportNetWeight")
   private BigDecimal reportNetWeight;

   public static UserProductionSummaryDTO.UserProductionSummaryDTOBuilder builder() {
      return new UserProductionSummaryDTO.UserProductionSummaryDTOBuilder();
   }

   public UserProductionSummaryDTO() {
   }

   public UserProductionSummaryDTO(
      final ProjectDetailDO project,
      final NameInfo monomer,
      final Long userId,
      final String userName,
      final BigDecimal taskQuantity,
      final BigDecimal reportQuantity,
      final BigDecimal reportNetWeight
   ) {
      this.project = project;
      this.monomer = monomer;
      this.userId = userId;
      this.userName = userName;
      this.taskQuantity = taskQuantity;
      this.reportQuantity = reportQuantity;
      this.reportNetWeight = reportNetWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public BigDecimal getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportNetWeight() {
      return this.reportNetWeight;
   }

   @JsonProperty("project")
   public UserProductionSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public UserProductionSummaryDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("userId")
   public UserProductionSummaryDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public UserProductionSummaryDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("taskQuantity")
   public UserProductionSummaryDTO setTaskQuantity(final BigDecimal taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("reportQuantity")
   public UserProductionSummaryDTO setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportNetWeight")
   public UserProductionSummaryDTO setReportNetWeight(final BigDecimal reportNetWeight) {
      this.reportNetWeight = reportNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "UserProductionSummaryDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportNetWeight="
         + this.getReportNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserProductionSummaryDTO)) {
         return false;
      }

      UserProductionSummaryDTO other = (UserProductionSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$monomer = this.getMonomer();
            Object other$monomer = other.getMonomer();
            if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$reportQuantity = this.getReportQuantity();
                     Object other$reportQuantity = other.getReportQuantity();
                     if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                        Object this$reportNetWeight = this.getReportNetWeight();
                        Object other$reportNetWeight = other.getReportNetWeight();
                        return this$reportNetWeight == null ? other$reportNetWeight == null : this$reportNetWeight.equals(other$reportNetWeight);
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
      return other instanceof UserProductionSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportNetWeight = this.getReportNetWeight();
      return result * 59 + ($reportNetWeight == null ? 43 : $reportNetWeight.hashCode());
   }

   public static class UserProductionSummaryDTOBuilder {
      private ProjectDetailDO project;
      private NameInfo monomer;
      private Long userId;
      private String userName;
      private BigDecimal taskQuantity;
      private BigDecimal reportQuantity;
      private BigDecimal reportNetWeight;

      UserProductionSummaryDTOBuilder() {
      }

      @JsonProperty("project")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("userId")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("taskQuantity")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder taskQuantity(final BigDecimal taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("reportQuantity")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder reportQuantity(final BigDecimal reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportNetWeight")
      public UserProductionSummaryDTO.UserProductionSummaryDTOBuilder reportNetWeight(final BigDecimal reportNetWeight) {
         this.reportNetWeight = reportNetWeight;
         return this;
      }

      public UserProductionSummaryDTO build() {
         return new UserProductionSummaryDTO(
            this.project, this.monomer, this.userId, this.userName, this.taskQuantity, this.reportQuantity, this.reportNetWeight
         );
      }

      @Override
      public String toString() {
         return "UserProductionSummaryDTO.UserProductionSummaryDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", taskQuantity="
            + this.taskQuantity
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportNetWeight="
            + this.reportNetWeight
            + ")";
      }
   }
}
