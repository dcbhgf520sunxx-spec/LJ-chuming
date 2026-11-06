package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MesBeginConvertArtifactDO", description = "期初构件半成品构件汇总")
public class MesBeginConvertDO {
   private Long taskId;
   private String structureType;
   private Long productId;
   private Long processId;
   private String processTypeName;
   private Integer taskQuantity;
   private Integer completeQuantity;
   private Integer sequence;
   private BigDecimal grossWeight;

   public static MesBeginConvertDO.MesBeginConvertDOBuilder builder() {
      return new MesBeginConvertDO.MesBeginConvertDOBuilder();
   }

   public MesBeginConvertDO() {
   }

   public MesBeginConvertDO(
      final Long taskId,
      final String structureType,
      final Long productId,
      final Long processId,
      final String processTypeName,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer sequence,
      final BigDecimal grossWeight
   ) {
      this.taskId = taskId;
      this.structureType = structureType;
      this.productId = productId;
      this.processId = processId;
      this.processTypeName = processTypeName;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.sequence = sequence;
      this.grossWeight = grossWeight;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessTypeName() {
      return this.processTypeName;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public MesBeginConvertDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBeginConvertDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public MesBeginConvertDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBeginConvertDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBeginConvertDO setProcessTypeName(final String processTypeName) {
      this.processTypeName = processTypeName;
      return this;
   }

   public MesBeginConvertDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public MesBeginConvertDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public MesBeginConvertDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   public MesBeginConvertDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBeginConvertDO)) {
         return false;
      }

      MesBeginConvertDO other = (MesBeginConvertDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$sequence = this.getSequence();
                     Object other$sequence = other.getSequence();
                     if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$processTypeName = this.getProcessTypeName();
                           Object other$processTypeName = other.getProcessTypeName();
                           if (this$processTypeName == null ? other$processTypeName == null : this$processTypeName.equals(other$processTypeName)) {
                              Object this$grossWeight = this.getGrossWeight();
                              Object other$grossWeight = other.getGrossWeight();
                              return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof MesBeginConvertDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $processTypeName = this.getProcessTypeName();
      result = result * 59 + ($processTypeName == null ? 43 : $processTypeName.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBeginConvertDO(taskId="
         + this.getTaskId()
         + ", structureType="
         + this.getStructureType()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", processTypeName="
         + this.getProcessTypeName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", sequence="
         + this.getSequence()
         + ", grossWeight="
         + this.getGrossWeight()
         + ")";
   }

   public static class MesBeginConvertDOBuilder {
      private Long taskId;
      private String structureType;
      private Long productId;
      private Long processId;
      private String processTypeName;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer sequence;
      private BigDecimal grossWeight;

      MesBeginConvertDOBuilder() {
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder processTypeName(final String processTypeName) {
         this.processTypeName = processTypeName;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBeginConvertDO.MesBeginConvertDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBeginConvertDO build() {
         return new MesBeginConvertDO(
            this.taskId,
            this.structureType,
            this.productId,
            this.processId,
            this.processTypeName,
            this.taskQuantity,
            this.completeQuantity,
            this.sequence,
            this.grossWeight
         );
      }

      @Override
      public String toString() {
         return "MesBeginConvertDO.MesBeginConvertDOBuilder(taskId="
            + this.taskId
            + ", structureType="
            + this.structureType
            + ", productId="
            + this.productId
            + ", processId="
            + this.processId
            + ", processTypeName="
            + this.processTypeName
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", sequence="
            + this.sequence
            + ", grossWeight="
            + this.grossWeight
            + ")";
      }
   }
}
