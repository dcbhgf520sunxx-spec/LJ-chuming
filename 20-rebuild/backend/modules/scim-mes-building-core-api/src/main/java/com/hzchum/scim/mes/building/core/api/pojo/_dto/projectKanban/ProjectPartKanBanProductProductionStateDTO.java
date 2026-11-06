package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectPartKanBanProductProductionStateDTO", description = "项目生产看板-产品生产列表DTO")
public class ProjectPartKanBanProductProductionStateDTO {
   @ApiModelProperty(name = "taskProcessId", notes = "工序任务Id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "processName", notes = "工序名称(生产方式)")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productClassificationEnum", notes = "产品类型 4成品型材 8 板材零件 ")
   @JsonProperty("productClassificationEnum")
   @JSONField(name = "productClassificationEnum")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "remainingQuantity", notes = "未生产数 ")
   @JsonProperty("remainingQuantity")
   @JSONField(name = "remainingQuantity")
   private Integer remainingQuantity;
   @ApiModelProperty(name = "userName", notes = "班组长名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;

   public static ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder builder() {
      return new ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder();
   }

   public ProjectPartKanBanProductProductionStateDTO() {
   }

   public ProjectPartKanBanProductProductionStateDTO(
      final Long taskProcessId, final String processName, final Integer productClassificationEnum, final Integer remainingQuantity, final String userName
   ) {
      this.taskProcessId = taskProcessId;
      this.processName = processName;
      this.productClassificationEnum = productClassificationEnum;
      this.remainingQuantity = remainingQuantity;
      this.userName = userName;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getRemainingQuantity() {
      return this.remainingQuantity;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("taskProcessId")
   public ProjectPartKanBanProductProductionStateDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processName")
   public ProjectPartKanBanProductProductionStateDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public ProjectPartKanBanProductProductionStateDTO setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("remainingQuantity")
   public ProjectPartKanBanProductProductionStateDTO setRemainingQuantity(final Integer remainingQuantity) {
      this.remainingQuantity = remainingQuantity;
      return this;
   }

   @JsonProperty("userName")
   public ProjectPartKanBanProductProductionStateDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectPartKanBanProductProductionStateDTO(taskProcessId="
         + this.getTaskProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", remainingQuantity="
         + this.getRemainingQuantity()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPartKanBanProductProductionStateDTO)) {
         return false;
      }

      ProjectPartKanBanProductProductionStateDTO other = (ProjectPartKanBanProductProductionStateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$productClassificationEnum = this.getProductClassificationEnum();
         Object other$productClassificationEnum = other.getProductClassificationEnum();
         if (this$productClassificationEnum == null
            ? other$productClassificationEnum == null
            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
            Object this$remainingQuantity = this.getRemainingQuantity();
            Object other$remainingQuantity = other.getRemainingQuantity();
            if (this$remainingQuantity == null ? other$remainingQuantity == null : this$remainingQuantity.equals(other$remainingQuantity)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof ProjectPartKanBanProductProductionStateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $remainingQuantity = this.getRemainingQuantity();
      result = result * 59 + ($remainingQuantity == null ? 43 : $remainingQuantity.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class ProjectPartKanBanProductProductionStateDTOBuilder {
      private Long taskProcessId;
      private String processName;
      private Integer productClassificationEnum;
      private Integer remainingQuantity;
      private String userName;

      ProjectPartKanBanProductProductionStateDTOBuilder() {
      }

      @JsonProperty("taskProcessId")
      public ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processName")
      public ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder productClassificationEnum(
         final Integer productClassificationEnum
      ) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("remainingQuantity")
      public ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder remainingQuantity(final Integer remainingQuantity) {
         this.remainingQuantity = remainingQuantity;
         return this;
      }

      @JsonProperty("userName")
      public ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectPartKanBanProductProductionStateDTO build() {
         return new ProjectPartKanBanProductProductionStateDTO(
            this.taskProcessId, this.processName, this.productClassificationEnum, this.remainingQuantity, this.userName
         );
      }

      @Override
      public String toString() {
         return "ProjectPartKanBanProductProductionStateDTO.ProjectPartKanBanProductProductionStateDTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", processName="
            + this.processName
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", remainingQuantity="
            + this.remainingQuantity
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
