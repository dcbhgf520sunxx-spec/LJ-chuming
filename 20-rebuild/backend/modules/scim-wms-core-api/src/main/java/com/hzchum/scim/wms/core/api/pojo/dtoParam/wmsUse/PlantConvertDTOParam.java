package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class PlantConvertDTOParam {
   private String receiptSerialNumber;
   private String operatorName;
   private Long projectId;
   private String taskOrderNumber;
   private Integer basicClass;
   private List<LocalDateTime> createTime;

   public static PlantConvertDTOParam.PlantConvertDTOParamBuilder builder() {
      return new PlantConvertDTOParam.PlantConvertDTOParamBuilder();
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public void setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlantConvertDTOParam)) {
         return false;
      }

      PlantConvertDTOParam other = (PlantConvertDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$receiptSerialNumber = this.getReceiptSerialNumber();
            Object other$receiptSerialNumber = other.getReceiptSerialNumber();
            if (this$receiptSerialNumber == null ? other$receiptSerialNumber == null : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
               Object this$operatorName = this.getOperatorName();
               Object other$operatorName = other.getOperatorName();
               if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                  Object this$taskOrderNumber = this.getTaskOrderNumber();
                  Object other$taskOrderNumber = other.getTaskOrderNumber();
                  if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof PlantConvertDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "PlantConvertDTOParam(receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectId="
         + this.getProjectId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public PlantConvertDTOParam(
      final String receiptSerialNumber,
      final String operatorName,
      final Long projectId,
      final String taskOrderNumber,
      final Integer basicClass,
      final List<LocalDateTime> createTime
   ) {
      this.receiptSerialNumber = receiptSerialNumber;
      this.operatorName = operatorName;
      this.projectId = projectId;
      this.taskOrderNumber = taskOrderNumber;
      this.basicClass = basicClass;
      this.createTime = createTime;
   }

   public PlantConvertDTOParam() {
   }

   public static class PlantConvertDTOParamBuilder {
      private String receiptSerialNumber;
      private String operatorName;
      private Long projectId;
      private String taskOrderNumber;
      private Integer basicClass;
      private List<LocalDateTime> createTime;

      PlantConvertDTOParamBuilder() {
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PlantConvertDTOParam.PlantConvertDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public PlantConvertDTOParam build() {
         return new PlantConvertDTOParam(this.receiptSerialNumber, this.operatorName, this.projectId, this.taskOrderNumber, this.basicClass, this.createTime);
      }

      @Override
      public String toString() {
         return "PlantConvertDTOParam.PlantConvertDTOParamBuilder(receiptSerialNumber="
            + this.receiptSerialNumber
            + ", operatorName="
            + this.operatorName
            + ", projectId="
            + this.projectId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", basicClass="
            + this.basicClass
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
