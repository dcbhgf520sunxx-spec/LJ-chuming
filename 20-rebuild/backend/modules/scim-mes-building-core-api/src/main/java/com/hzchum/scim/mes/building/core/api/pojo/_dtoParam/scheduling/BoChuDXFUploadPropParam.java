package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import cn.hutool.core.annotation.Alias;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoChuDXFUploadPropParam", description = "柏楚作业上传DXF数据接口参数")
public class BoChuDXFUploadPropParam {
   @JsonProperty("班组")
   @JSONField(name = "班组")
   private String 班组;
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @JsonProperty("techDrawingId")
   @JSONField(name = "techDrawingId")
   private Long techDrawingId;
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   private Long teamId;
   private String teamName;
   private String taskNeedMachinePartSchedulingIds;
   @ApiModelProperty("是否直发件(0:否,1:是)")
   private Boolean boolSendDirectly;
   @JSONField(name = "是否直发件")
   @Alias("是否直发件")
   private String boolSendDirectlyStr;
   @Alias("要求完成日期")
   @JsonProperty("要求完成日期")
   @JSONField(name = "要求完成日期")
   private String requiredCompletionDate;
   @Alias("提示")
   @JsonProperty("提示")
   @JSONField(name = "提示")
   @ApiModelProperty("提示")
   private String prompt;

   public static BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder builder() {
      return new BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder();
   }

   public BoChuDXFUploadPropParam(
      final String 班组,
      final Long productId,
      final Long taskOrderId,
      final Long techDrawingId,
      final Long projectId,
      final Long teamId,
      final String teamName,
      final String taskNeedMachinePartSchedulingIds,
      final Boolean boolSendDirectly,
      final String boolSendDirectlyStr,
      final String requiredCompletionDate,
      final String prompt
   ) {
      this.班组 = 班组;
      this.productId = productId;
      this.taskOrderId = taskOrderId;
      this.techDrawingId = techDrawingId;
      this.projectId = projectId;
      this.teamId = teamId;
      this.teamName = teamName;
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSendDirectlyStr = boolSendDirectlyStr;
      this.requiredCompletionDate = requiredCompletionDate;
      this.prompt = prompt;
   }

   public BoChuDXFUploadPropParam() {
   }

   public String get班组() {
      return this.班组;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTechDrawingId() {
      return this.techDrawingId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getTaskNeedMachinePartSchedulingIds() {
      return this.taskNeedMachinePartSchedulingIds;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public String getBoolSendDirectlyStr() {
      return this.boolSendDirectlyStr;
   }

   public String getRequiredCompletionDate() {
      return this.requiredCompletionDate;
   }

   public String getPrompt() {
      return this.prompt;
   }

   @JsonProperty("班组")
   public BoChuDXFUploadPropParam set班组(final String 班组) {
      this.班组 = 班组;
      return this;
   }

   @JsonProperty("productId")
   public BoChuDXFUploadPropParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public BoChuDXFUploadPropParam setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("techDrawingId")
   public BoChuDXFUploadPropParam setTechDrawingId(final Long techDrawingId) {
      this.techDrawingId = techDrawingId;
      return this;
   }

   @JsonProperty("projectId")
   public BoChuDXFUploadPropParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BoChuDXFUploadPropParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public BoChuDXFUploadPropParam setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public BoChuDXFUploadPropParam setTaskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      return this;
   }

   public BoChuDXFUploadPropParam setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public BoChuDXFUploadPropParam setBoolSendDirectlyStr(final String boolSendDirectlyStr) {
      this.boolSendDirectlyStr = boolSendDirectlyStr;
      return this;
   }

   @JsonProperty("要求完成日期")
   public BoChuDXFUploadPropParam setRequiredCompletionDate(final String requiredCompletionDate) {
      this.requiredCompletionDate = requiredCompletionDate;
      return this;
   }

   @JsonProperty("提示")
   public BoChuDXFUploadPropParam setPrompt(final String prompt) {
      this.prompt = prompt;
      return this;
   }

   @Override
   public String toString() {
      return "BoChuDXFUploadPropParam(班组="
         + this.get班组()
         + ", productId="
         + this.getProductId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", techDrawingId="
         + this.getTechDrawingId()
         + ", projectId="
         + this.getProjectId()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", taskNeedMachinePartSchedulingIds="
         + this.getTaskNeedMachinePartSchedulingIds()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSendDirectlyStr="
         + this.getBoolSendDirectlyStr()
         + ", requiredCompletionDate="
         + this.getRequiredCompletionDate()
         + ", prompt="
         + this.getPrompt()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuDXFUploadPropParam)) {
         return false;
      }

      BoChuDXFUploadPropParam other = (BoChuDXFUploadPropParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$techDrawingId = this.getTechDrawingId();
            Object other$techDrawingId = other.getTechDrawingId();
            if (this$techDrawingId == null ? other$techDrawingId == null : this$techDrawingId.equals(other$techDrawingId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$boolSendDirectly = this.getBoolSendDirectly();
                     Object other$boolSendDirectly = other.getBoolSendDirectly();
                     if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                        Object this$班组 = this.get班组();
                        Object other$班组 = other.get班组();
                        if (this$班组 == null ? other$班组 == null : this$班组.equals(other$班组)) {
                           Object this$teamName = this.getTeamName();
                           Object other$teamName = other.getTeamName();
                           if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                              Object this$taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
                              Object other$taskNeedMachinePartSchedulingIds = other.getTaskNeedMachinePartSchedulingIds();
                              if (this$taskNeedMachinePartSchedulingIds == null
                                 ? other$taskNeedMachinePartSchedulingIds == null
                                 : this$taskNeedMachinePartSchedulingIds.equals(other$taskNeedMachinePartSchedulingIds)) {
                                 Object this$boolSendDirectlyStr = this.getBoolSendDirectlyStr();
                                 Object other$boolSendDirectlyStr = other.getBoolSendDirectlyStr();
                                 if (this$boolSendDirectlyStr == null
                                    ? other$boolSendDirectlyStr == null
                                    : this$boolSendDirectlyStr.equals(other$boolSendDirectlyStr)) {
                                    Object this$requiredCompletionDate = this.getRequiredCompletionDate();
                                    Object other$requiredCompletionDate = other.getRequiredCompletionDate();
                                    if (this$requiredCompletionDate == null
                                       ? other$requiredCompletionDate == null
                                       : this$requiredCompletionDate.equals(other$requiredCompletionDate)) {
                                       Object this$prompt = this.getPrompt();
                                       Object other$prompt = other.getPrompt();
                                       return this$prompt == null ? other$prompt == null : this$prompt.equals(other$prompt);
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
      return other instanceof BoChuDXFUploadPropParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $techDrawingId = this.getTechDrawingId();
      result = result * 59 + ($techDrawingId == null ? 43 : $techDrawingId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $班组 = this.get班组();
      result = result * 59 + ($班组 == null ? 43 : $班组.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
      result = result * 59 + ($taskNeedMachinePartSchedulingIds == null ? 43 : $taskNeedMachinePartSchedulingIds.hashCode());
      Object $boolSendDirectlyStr = this.getBoolSendDirectlyStr();
      result = result * 59 + ($boolSendDirectlyStr == null ? 43 : $boolSendDirectlyStr.hashCode());
      Object $requiredCompletionDate = this.getRequiredCompletionDate();
      result = result * 59 + ($requiredCompletionDate == null ? 43 : $requiredCompletionDate.hashCode());
      Object $prompt = this.getPrompt();
      return result * 59 + ($prompt == null ? 43 : $prompt.hashCode());
   }

   public static class BoChuDXFUploadPropParamBuilder {
      private String 班组;
      private Long productId;
      private Long taskOrderId;
      private Long techDrawingId;
      private Long projectId;
      private Long teamId;
      private String teamName;
      private String taskNeedMachinePartSchedulingIds;
      private Boolean boolSendDirectly;
      private String boolSendDirectlyStr;
      private String requiredCompletionDate;
      private String prompt;

      BoChuDXFUploadPropParamBuilder() {
      }

      @JsonProperty("班组")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder 班组(final String 班组) {
         this.班组 = 班组;
         return this;
      }

      @JsonProperty("productId")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("techDrawingId")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder techDrawingId(final Long techDrawingId) {
         this.techDrawingId = techDrawingId;
         return this;
      }

      @JsonProperty("projectId")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder taskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
         this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
         return this;
      }

      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder boolSendDirectlyStr(final String boolSendDirectlyStr) {
         this.boolSendDirectlyStr = boolSendDirectlyStr;
         return this;
      }

      @JsonProperty("要求完成日期")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder requiredCompletionDate(final String requiredCompletionDate) {
         this.requiredCompletionDate = requiredCompletionDate;
         return this;
      }

      @JsonProperty("提示")
      public BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder prompt(final String prompt) {
         this.prompt = prompt;
         return this;
      }

      public BoChuDXFUploadPropParam build() {
         return new BoChuDXFUploadPropParam(
            this.班组,
            this.productId,
            this.taskOrderId,
            this.techDrawingId,
            this.projectId,
            this.teamId,
            this.teamName,
            this.taskNeedMachinePartSchedulingIds,
            this.boolSendDirectly,
            this.boolSendDirectlyStr,
            this.requiredCompletionDate,
            this.prompt
         );
      }

      @Override
      public String toString() {
         return "BoChuDXFUploadPropParam.BoChuDXFUploadPropParamBuilder(班组="
            + this.班组
            + ", productId="
            + this.productId
            + ", taskOrderId="
            + this.taskOrderId
            + ", techDrawingId="
            + this.techDrawingId
            + ", projectId="
            + this.projectId
            + ", teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", taskNeedMachinePartSchedulingIds="
            + this.taskNeedMachinePartSchedulingIds
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSendDirectlyStr="
            + this.boolSendDirectlyStr
            + ", requiredCompletionDate="
            + this.requiredCompletionDate
            + ", prompt="
            + this.prompt
            + ")";
      }
   }
}
