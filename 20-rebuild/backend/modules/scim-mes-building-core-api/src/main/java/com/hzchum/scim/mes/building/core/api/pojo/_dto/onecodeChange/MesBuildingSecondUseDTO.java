package com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingSecondUseDTO", description = "二次利用任务追加数据详情")
public class MesBuildingSecondUseDTO {
   private Long productId;
   private Integer number;
   private Long taskId;
   private Long taskProcessId;
   private Boolean boolArtifactReport;
   private Boolean boolArtifactInspection;
   private Boolean boolArtifactComplete;
   private Boolean boolArtifactInproduce;
   private Boolean boolOneArtifactInproduce;
   private Boolean boolOnecode;
   private Integer taskProcessIdIndex;
   private Boolean boolHaveNextProcess;

   public static MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder builder() {
      return new MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder();
   }

   public MesBuildingSecondUseDTO() {
   }

   public MesBuildingSecondUseDTO(
      final Long productId,
      final Integer number,
      final Long taskId,
      final Long taskProcessId,
      final Boolean boolArtifactReport,
      final Boolean boolArtifactInspection,
      final Boolean boolArtifactComplete,
      final Boolean boolArtifactInproduce,
      final Boolean boolOneArtifactInproduce,
      final Boolean boolOnecode,
      final Integer taskProcessIdIndex,
      final Boolean boolHaveNextProcess
   ) {
      this.productId = productId;
      this.number = number;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.boolArtifactReport = boolArtifactReport;
      this.boolArtifactInspection = boolArtifactInspection;
      this.boolArtifactComplete = boolArtifactComplete;
      this.boolArtifactInproduce = boolArtifactInproduce;
      this.boolOneArtifactInproduce = boolOneArtifactInproduce;
      this.boolOnecode = boolOnecode;
      this.taskProcessIdIndex = taskProcessIdIndex;
      this.boolHaveNextProcess = boolHaveNextProcess;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Boolean getBoolArtifactReport() {
      return this.boolArtifactReport;
   }

   public Boolean getBoolArtifactInspection() {
      return this.boolArtifactInspection;
   }

   public Boolean getBoolArtifactComplete() {
      return this.boolArtifactComplete;
   }

   public Boolean getBoolArtifactInproduce() {
      return this.boolArtifactInproduce;
   }

   public Boolean getBoolOneArtifactInproduce() {
      return this.boolOneArtifactInproduce;
   }

   public Boolean getBoolOnecode() {
      return this.boolOnecode;
   }

   public Integer getTaskProcessIdIndex() {
      return this.taskProcessIdIndex;
   }

   public Boolean getBoolHaveNextProcess() {
      return this.boolHaveNextProcess;
   }

   public MesBuildingSecondUseDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingSecondUseDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingSecondUseDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingSecondUseDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolArtifactReport(final Boolean boolArtifactReport) {
      this.boolArtifactReport = boolArtifactReport;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolArtifactInspection(final Boolean boolArtifactInspection) {
      this.boolArtifactInspection = boolArtifactInspection;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolArtifactComplete(final Boolean boolArtifactComplete) {
      this.boolArtifactComplete = boolArtifactComplete;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolArtifactInproduce(final Boolean boolArtifactInproduce) {
      this.boolArtifactInproduce = boolArtifactInproduce;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolOneArtifactInproduce(final Boolean boolOneArtifactInproduce) {
      this.boolOneArtifactInproduce = boolOneArtifactInproduce;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolOnecode(final Boolean boolOnecode) {
      this.boolOnecode = boolOnecode;
      return this;
   }

   public MesBuildingSecondUseDTO setTaskProcessIdIndex(final Integer taskProcessIdIndex) {
      this.taskProcessIdIndex = taskProcessIdIndex;
      return this;
   }

   public MesBuildingSecondUseDTO setBoolHaveNextProcess(final Boolean boolHaveNextProcess) {
      this.boolHaveNextProcess = boolHaveNextProcess;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSecondUseDTO(productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", boolArtifactReport="
         + this.getBoolArtifactReport()
         + ", boolArtifactInspection="
         + this.getBoolArtifactInspection()
         + ", boolArtifactComplete="
         + this.getBoolArtifactComplete()
         + ", boolArtifactInproduce="
         + this.getBoolArtifactInproduce()
         + ", boolOneArtifactInproduce="
         + this.getBoolOneArtifactInproduce()
         + ", boolOnecode="
         + this.getBoolOnecode()
         + ", taskProcessIdIndex="
         + this.getTaskProcessIdIndex()
         + ", boolHaveNextProcess="
         + this.getBoolHaveNextProcess()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSecondUseDTO)) {
         return false;
      }

      MesBuildingSecondUseDTO other = (MesBuildingSecondUseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$taskProcessId = this.getTaskProcessId();
               Object other$taskProcessId = other.getTaskProcessId();
               if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                  Object this$boolArtifactReport = this.getBoolArtifactReport();
                  Object other$boolArtifactReport = other.getBoolArtifactReport();
                  if (this$boolArtifactReport == null ? other$boolArtifactReport == null : this$boolArtifactReport.equals(other$boolArtifactReport)) {
                     Object this$boolArtifactInspection = this.getBoolArtifactInspection();
                     Object other$boolArtifactInspection = other.getBoolArtifactInspection();
                     if (this$boolArtifactInspection == null
                        ? other$boolArtifactInspection == null
                        : this$boolArtifactInspection.equals(other$boolArtifactInspection)) {
                        Object this$boolArtifactComplete = this.getBoolArtifactComplete();
                        Object other$boolArtifactComplete = other.getBoolArtifactComplete();
                        if (this$boolArtifactComplete == null
                           ? other$boolArtifactComplete == null
                           : this$boolArtifactComplete.equals(other$boolArtifactComplete)) {
                           Object this$boolArtifactInproduce = this.getBoolArtifactInproduce();
                           Object other$boolArtifactInproduce = other.getBoolArtifactInproduce();
                           if (this$boolArtifactInproduce == null
                              ? other$boolArtifactInproduce == null
                              : this$boolArtifactInproduce.equals(other$boolArtifactInproduce)) {
                              Object this$boolOneArtifactInproduce = this.getBoolOneArtifactInproduce();
                              Object other$boolOneArtifactInproduce = other.getBoolOneArtifactInproduce();
                              if (this$boolOneArtifactInproduce == null
                                 ? other$boolOneArtifactInproduce == null
                                 : this$boolOneArtifactInproduce.equals(other$boolOneArtifactInproduce)) {
                                 Object this$boolOnecode = this.getBoolOnecode();
                                 Object other$boolOnecode = other.getBoolOnecode();
                                 if (this$boolOnecode == null ? other$boolOnecode == null : this$boolOnecode.equals(other$boolOnecode)) {
                                    Object this$taskProcessIdIndex = this.getTaskProcessIdIndex();
                                    Object other$taskProcessIdIndex = other.getTaskProcessIdIndex();
                                    if (this$taskProcessIdIndex == null
                                       ? other$taskProcessIdIndex == null
                                       : this$taskProcessIdIndex.equals(other$taskProcessIdIndex)) {
                                       Object this$boolHaveNextProcess = this.getBoolHaveNextProcess();
                                       Object other$boolHaveNextProcess = other.getBoolHaveNextProcess();
                                       return this$boolHaveNextProcess == null
                                          ? other$boolHaveNextProcess == null
                                          : this$boolHaveNextProcess.equals(other$boolHaveNextProcess);
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
      return other instanceof MesBuildingSecondUseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $boolArtifactReport = this.getBoolArtifactReport();
      result = result * 59 + ($boolArtifactReport == null ? 43 : $boolArtifactReport.hashCode());
      Object $boolArtifactInspection = this.getBoolArtifactInspection();
      result = result * 59 + ($boolArtifactInspection == null ? 43 : $boolArtifactInspection.hashCode());
      Object $boolArtifactComplete = this.getBoolArtifactComplete();
      result = result * 59 + ($boolArtifactComplete == null ? 43 : $boolArtifactComplete.hashCode());
      Object $boolArtifactInproduce = this.getBoolArtifactInproduce();
      result = result * 59 + ($boolArtifactInproduce == null ? 43 : $boolArtifactInproduce.hashCode());
      Object $boolOneArtifactInproduce = this.getBoolOneArtifactInproduce();
      result = result * 59 + ($boolOneArtifactInproduce == null ? 43 : $boolOneArtifactInproduce.hashCode());
      Object $boolOnecode = this.getBoolOnecode();
      result = result * 59 + ($boolOnecode == null ? 43 : $boolOnecode.hashCode());
      Object $taskProcessIdIndex = this.getTaskProcessIdIndex();
      result = result * 59 + ($taskProcessIdIndex == null ? 43 : $taskProcessIdIndex.hashCode());
      Object $boolHaveNextProcess = this.getBoolHaveNextProcess();
      return result * 59 + ($boolHaveNextProcess == null ? 43 : $boolHaveNextProcess.hashCode());
   }

   public static class MesBuildingSecondUseDTOBuilder {
      private Long productId;
      private Integer number;
      private Long taskId;
      private Long taskProcessId;
      private Boolean boolArtifactReport;
      private Boolean boolArtifactInspection;
      private Boolean boolArtifactComplete;
      private Boolean boolArtifactInproduce;
      private Boolean boolOneArtifactInproduce;
      private Boolean boolOnecode;
      private Integer taskProcessIdIndex;
      private Boolean boolHaveNextProcess;

      MesBuildingSecondUseDTOBuilder() {
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolArtifactReport(final Boolean boolArtifactReport) {
         this.boolArtifactReport = boolArtifactReport;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolArtifactInspection(final Boolean boolArtifactInspection) {
         this.boolArtifactInspection = boolArtifactInspection;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolArtifactComplete(final Boolean boolArtifactComplete) {
         this.boolArtifactComplete = boolArtifactComplete;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolArtifactInproduce(final Boolean boolArtifactInproduce) {
         this.boolArtifactInproduce = boolArtifactInproduce;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolOneArtifactInproduce(final Boolean boolOneArtifactInproduce) {
         this.boolOneArtifactInproduce = boolOneArtifactInproduce;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolOnecode(final Boolean boolOnecode) {
         this.boolOnecode = boolOnecode;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder taskProcessIdIndex(final Integer taskProcessIdIndex) {
         this.taskProcessIdIndex = taskProcessIdIndex;
         return this;
      }

      public MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder boolHaveNextProcess(final Boolean boolHaveNextProcess) {
         this.boolHaveNextProcess = boolHaveNextProcess;
         return this;
      }

      public MesBuildingSecondUseDTO build() {
         return new MesBuildingSecondUseDTO(
            this.productId,
            this.number,
            this.taskId,
            this.taskProcessId,
            this.boolArtifactReport,
            this.boolArtifactInspection,
            this.boolArtifactComplete,
            this.boolArtifactInproduce,
            this.boolOneArtifactInproduce,
            this.boolOnecode,
            this.taskProcessIdIndex,
            this.boolHaveNextProcess
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSecondUseDTO.MesBuildingSecondUseDTOBuilder(productId="
            + this.productId
            + ", number="
            + this.number
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", boolArtifactReport="
            + this.boolArtifactReport
            + ", boolArtifactInspection="
            + this.boolArtifactInspection
            + ", boolArtifactComplete="
            + this.boolArtifactComplete
            + ", boolArtifactInproduce="
            + this.boolArtifactInproduce
            + ", boolOneArtifactInproduce="
            + this.boolOneArtifactInproduce
            + ", boolOnecode="
            + this.boolOnecode
            + ", taskProcessIdIndex="
            + this.taskProcessIdIndex
            + ", boolHaveNextProcess="
            + this.boolHaveNextProcess
            + ")";
      }
   }
}
