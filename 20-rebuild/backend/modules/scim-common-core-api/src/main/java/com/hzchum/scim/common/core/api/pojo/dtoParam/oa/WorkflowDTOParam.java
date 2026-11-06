package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("OaWorkflowDTOParam")
public class WorkflowDTOParam {
   @ApiModelProperty(name = "流程ID", value = "流程ID", required = true)
   private String requestId;
   @ApiModelProperty(name = "业务类型，", value = "1，创建合同，2，合同付款，3合同结算 4 深化图纸导入", required = true)
   private Integer businessType;
   @ApiModelProperty(name = "modeOperation", value = "经营方式：1，自营，2，合营", required = true)
   private Integer modeOperation;
   @ApiModelProperty(name = "requestName，", value = "流程名称", required = true)
   private String requestName;
   @ApiModelProperty(name = "id", value = "数据id")
   private Long id;
   @ApiModelProperty(name = "applicationTime", value = "申请时间", notes = "申请时间")
   private LocalDateTime applicationTime;
   @ApiModelProperty(name = "applicantId", value = "发起人id", notes = "发起人id")
   private Long applicationId;

   public static WorkflowDTOParam.WorkflowDTOParamBuilder builder() {
      return new WorkflowDTOParam.WorkflowDTOParamBuilder();
   }

   public WorkflowDTOParam(
      final String requestId,
      final Integer businessType,
      final Integer modeOperation,
      final String requestName,
      final Long id,
      final LocalDateTime applicationTime,
      final Long applicationId
   ) {
      this.requestId = requestId;
      this.businessType = businessType;
      this.modeOperation = modeOperation;
      this.requestName = requestName;
      this.id = id;
      this.applicationTime = applicationTime;
      this.applicationId = applicationId;
   }

   public WorkflowDTOParam() {
   }

   public String getRequestId() {
      return this.requestId;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getModeOperation() {
      return this.modeOperation;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public Long getApplicationId() {
      return this.applicationId;
   }

   public WorkflowDTOParam setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   public WorkflowDTOParam setBusinessType(final Integer businessType) {
      this.businessType = businessType;
      return this;
   }

   public WorkflowDTOParam setModeOperation(final Integer modeOperation) {
      this.modeOperation = modeOperation;
      return this;
   }

   public WorkflowDTOParam setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   public WorkflowDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public WorkflowDTOParam setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
      return this;
   }

   public WorkflowDTOParam setApplicationId(final Long applicationId) {
      this.applicationId = applicationId;
      return this;
   }

   @Override
   public String toString() {
      return "WorkflowDTOParam(requestId="
         + this.getRequestId()
         + ", businessType="
         + this.getBusinessType()
         + ", modeOperation="
         + this.getModeOperation()
         + ", requestName="
         + this.getRequestName()
         + ", id="
         + this.getId()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", applicationId="
         + this.getApplicationId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkflowDTOParam)) {
         return false;
      }

      WorkflowDTOParam other = (WorkflowDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$modeOperation = this.getModeOperation();
         Object other$modeOperation = other.getModeOperation();
         if (this$modeOperation == null ? other$modeOperation == null : this$modeOperation.equals(other$modeOperation)) {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$applicationId = this.getApplicationId();
               Object other$applicationId = other.getApplicationId();
               if (this$applicationId == null ? other$applicationId == null : this$applicationId.equals(other$applicationId)) {
                  Object this$requestId = this.getRequestId();
                  Object other$requestId = other.getRequestId();
                  if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
                     Object this$requestName = this.getRequestName();
                     Object other$requestName = other.getRequestName();
                     if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
                        Object this$applicationTime = this.getApplicationTime();
                        Object other$applicationTime = other.getApplicationTime();
                        return this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime);
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
      return other instanceof WorkflowDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $modeOperation = this.getModeOperation();
      result = result * 59 + ($modeOperation == null ? 43 : $modeOperation.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicationId = this.getApplicationId();
      result = result * 59 + ($applicationId == null ? 43 : $applicationId.hashCode());
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $applicationTime = this.getApplicationTime();
      return result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
   }

   public static class WorkflowDTOParamBuilder {
      private String requestId;
      private Integer businessType;
      private Integer modeOperation;
      private String requestName;
      private Long id;
      private LocalDateTime applicationTime;
      private Long applicationId;

      WorkflowDTOParamBuilder() {
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder modeOperation(final Integer modeOperation) {
         this.modeOperation = modeOperation;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      public WorkflowDTOParam.WorkflowDTOParamBuilder applicationId(final Long applicationId) {
         this.applicationId = applicationId;
         return this;
      }

      public WorkflowDTOParam build() {
         return new WorkflowDTOParam(this.requestId, this.businessType, this.modeOperation, this.requestName, this.id, this.applicationTime, this.applicationId);
      }

      @Override
      public String toString() {
         return "WorkflowDTOParam.WorkflowDTOParamBuilder(requestId="
            + this.requestId
            + ", businessType="
            + this.businessType
            + ", modeOperation="
            + this.modeOperation
            + ", requestName="
            + this.requestName
            + ", id="
            + this.id
            + ", applicationTime="
            + this.applicationTime
            + ", applicationId="
            + this.applicationId
            + ")";
      }
   }
}
