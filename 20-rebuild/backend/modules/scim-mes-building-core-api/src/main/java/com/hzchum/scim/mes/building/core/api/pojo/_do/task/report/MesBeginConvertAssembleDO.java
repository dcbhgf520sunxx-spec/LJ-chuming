package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MesBeginConvertAssembleDO", description = "期初构件半成品部件汇总")
public class MesBeginConvertAssembleDO {
   private Long linkId;
   private Long taskId;
   private Long assembleTaskProcessId;
   private String structureType;
   private String processTypeName;
   private Long processId;
   private Integer sequence;
   private BigDecimal grossWeight;
   private Integer assembleNumber;
   private Long assembleId;

   public static MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder builder() {
      return new MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder();
   }

   public MesBeginConvertAssembleDO() {
   }

   public MesBeginConvertAssembleDO(
      final Long linkId,
      final Long taskId,
      final Long assembleTaskProcessId,
      final String structureType,
      final String processTypeName,
      final Long processId,
      final Integer sequence,
      final BigDecimal grossWeight,
      final Integer assembleNumber,
      final Long assembleId
   ) {
      this.linkId = linkId;
      this.taskId = taskId;
      this.assembleTaskProcessId = assembleTaskProcessId;
      this.structureType = structureType;
      this.processTypeName = processTypeName;
      this.processId = processId;
      this.sequence = sequence;
      this.grossWeight = grossWeight;
      this.assembleNumber = assembleNumber;
      this.assembleId = assembleId;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getAssembleTaskProcessId() {
      return this.assembleTaskProcessId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getProcessTypeName() {
      return this.processTypeName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getAssembleNumber() {
      return this.assembleNumber;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public MesBeginConvertAssembleDO setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   public MesBeginConvertAssembleDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBeginConvertAssembleDO setAssembleTaskProcessId(final Long assembleTaskProcessId) {
      this.assembleTaskProcessId = assembleTaskProcessId;
      return this;
   }

   public MesBeginConvertAssembleDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public MesBeginConvertAssembleDO setProcessTypeName(final String processTypeName) {
      this.processTypeName = processTypeName;
      return this;
   }

   public MesBeginConvertAssembleDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBeginConvertAssembleDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   public MesBeginConvertAssembleDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public MesBeginConvertAssembleDO setAssembleNumber(final Integer assembleNumber) {
      this.assembleNumber = assembleNumber;
      return this;
   }

   public MesBeginConvertAssembleDO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBeginConvertAssembleDO)) {
         return false;
      }

      MesBeginConvertAssembleDO other = (MesBeginConvertAssembleDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$assembleTaskProcessId = this.getAssembleTaskProcessId();
            Object other$assembleTaskProcessId = other.getAssembleTaskProcessId();
            if (this$assembleTaskProcessId == null ? other$assembleTaskProcessId == null : this$assembleTaskProcessId.equals(other$assembleTaskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$sequence = this.getSequence();
                  Object other$sequence = other.getSequence();
                  if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                     Object this$assembleNumber = this.getAssembleNumber();
                     Object other$assembleNumber = other.getAssembleNumber();
                     if (this$assembleNumber == null ? other$assembleNumber == null : this$assembleNumber.equals(other$assembleNumber)) {
                        Object this$assembleId = this.getAssembleId();
                        Object other$assembleId = other.getAssembleId();
                        if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBeginConvertAssembleDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $assembleTaskProcessId = this.getAssembleTaskProcessId();
      result = result * 59 + ($assembleTaskProcessId == null ? 43 : $assembleTaskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $assembleNumber = this.getAssembleNumber();
      result = result * 59 + ($assembleNumber == null ? 43 : $assembleNumber.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $processTypeName = this.getProcessTypeName();
      result = result * 59 + ($processTypeName == null ? 43 : $processTypeName.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBeginConvertAssembleDO(linkId="
         + this.getLinkId()
         + ", taskId="
         + this.getTaskId()
         + ", assembleTaskProcessId="
         + this.getAssembleTaskProcessId()
         + ", structureType="
         + this.getStructureType()
         + ", processTypeName="
         + this.getProcessTypeName()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", assembleNumber="
         + this.getAssembleNumber()
         + ", assembleId="
         + this.getAssembleId()
         + ")";
   }

   public static class MesBeginConvertAssembleDOBuilder {
      private Long linkId;
      private Long taskId;
      private Long assembleTaskProcessId;
      private String structureType;
      private String processTypeName;
      private Long processId;
      private Integer sequence;
      private BigDecimal grossWeight;
      private Integer assembleNumber;
      private Long assembleId;

      MesBeginConvertAssembleDOBuilder() {
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder assembleTaskProcessId(final Long assembleTaskProcessId) {
         this.assembleTaskProcessId = assembleTaskProcessId;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder processTypeName(final String processTypeName) {
         this.processTypeName = processTypeName;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder assembleNumber(final Integer assembleNumber) {
         this.assembleNumber = assembleNumber;
         return this;
      }

      public MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public MesBeginConvertAssembleDO build() {
         return new MesBeginConvertAssembleDO(
            this.linkId,
            this.taskId,
            this.assembleTaskProcessId,
            this.structureType,
            this.processTypeName,
            this.processId,
            this.sequence,
            this.grossWeight,
            this.assembleNumber,
            this.assembleId
         );
      }

      @Override
      public String toString() {
         return "MesBeginConvertAssembleDO.MesBeginConvertAssembleDOBuilder(linkId="
            + this.linkId
            + ", taskId="
            + this.taskId
            + ", assembleTaskProcessId="
            + this.assembleTaskProcessId
            + ", structureType="
            + this.structureType
            + ", processTypeName="
            + this.processTypeName
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ", grossWeight="
            + this.grossWeight
            + ", assembleNumber="
            + this.assembleNumber
            + ", assembleId="
            + this.assembleId
            + ")";
      }
   }
}
