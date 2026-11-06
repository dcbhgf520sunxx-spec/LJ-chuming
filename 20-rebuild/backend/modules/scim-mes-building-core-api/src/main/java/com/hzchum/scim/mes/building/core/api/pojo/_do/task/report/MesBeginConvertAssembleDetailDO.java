package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MesBeginConvertAssembleDO", description = "期初构件半成品部件汇总")
public class MesBeginConvertAssembleDetailDO {
   private Long projectId;
   private String projectName;
   private Long linkId;
   private Long taskId;
   private Long assembleTaskProcessId;
   private String processTypeName;
   private Long processId;
   private Integer sequence;
   private BigDecimal grossWeight;
   private Integer assembleNumber;
   private Long assembleId;
   private String structureType;

   public static MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder builder() {
      return new MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder();
   }

   public MesBeginConvertAssembleDetailDO() {
   }

   public MesBeginConvertAssembleDetailDO(
      final Long projectId,
      final String projectName,
      final Long linkId,
      final Long taskId,
      final Long assembleTaskProcessId,
      final String processTypeName,
      final Long processId,
      final Integer sequence,
      final BigDecimal grossWeight,
      final Integer assembleNumber,
      final Long assembleId,
      final String structureType
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.linkId = linkId;
      this.taskId = taskId;
      this.assembleTaskProcessId = assembleTaskProcessId;
      this.processTypeName = processTypeName;
      this.processId = processId;
      this.sequence = sequence;
      this.grossWeight = grossWeight;
      this.assembleNumber = assembleNumber;
      this.assembleId = assembleId;
      this.structureType = structureType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
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

   public String getStructureType() {
      return this.structureType;
   }

   public MesBeginConvertAssembleDetailDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setAssembleTaskProcessId(final Long assembleTaskProcessId) {
      this.assembleTaskProcessId = assembleTaskProcessId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setProcessTypeName(final String processTypeName) {
      this.processTypeName = processTypeName;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setAssembleNumber(final Integer assembleNumber) {
      this.assembleNumber = assembleNumber;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   public MesBeginConvertAssembleDetailDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBeginConvertAssembleDetailDO)) {
         return false;
      }

      MesBeginConvertAssembleDetailDO other = (MesBeginConvertAssembleDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$processTypeName = this.getProcessTypeName();
                                 Object other$processTypeName = other.getProcessTypeName();
                                 if (this$processTypeName == null ? other$processTypeName == null : this$processTypeName.equals(other$processTypeName)) {
                                    Object this$grossWeight = this.getGrossWeight();
                                    Object other$grossWeight = other.getGrossWeight();
                                    if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                       Object this$structureType = this.getStructureType();
                                       Object other$structureType = other.getStructureType();
                                       return this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType);
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
      return other instanceof MesBeginConvertAssembleDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $processTypeName = this.getProcessTypeName();
      result = result * 59 + ($processTypeName == null ? 43 : $processTypeName.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $structureType = this.getStructureType();
      return result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
   }

   @Override
   public String toString() {
      return "MesBeginConvertAssembleDetailDO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", linkId="
         + this.getLinkId()
         + ", taskId="
         + this.getTaskId()
         + ", assembleTaskProcessId="
         + this.getAssembleTaskProcessId()
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
         + ", structureType="
         + this.getStructureType()
         + ")";
   }

   public static class MesBeginConvertAssembleDetailDOBuilder {
      private Long projectId;
      private String projectName;
      private Long linkId;
      private Long taskId;
      private Long assembleTaskProcessId;
      private String processTypeName;
      private Long processId;
      private Integer sequence;
      private BigDecimal grossWeight;
      private Integer assembleNumber;
      private Long assembleId;
      private String structureType;

      MesBeginConvertAssembleDetailDOBuilder() {
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder assembleTaskProcessId(final Long assembleTaskProcessId) {
         this.assembleTaskProcessId = assembleTaskProcessId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder processTypeName(final String processTypeName) {
         this.processTypeName = processTypeName;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder assembleNumber(final Integer assembleNumber) {
         this.assembleNumber = assembleNumber;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesBeginConvertAssembleDetailDO build() {
         return new MesBeginConvertAssembleDetailDO(
            this.projectId,
            this.projectName,
            this.linkId,
            this.taskId,
            this.assembleTaskProcessId,
            this.processTypeName,
            this.processId,
            this.sequence,
            this.grossWeight,
            this.assembleNumber,
            this.assembleId,
            this.structureType
         );
      }

      @Override
      public String toString() {
         return "MesBeginConvertAssembleDetailDO.MesBeginConvertAssembleDetailDOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", linkId="
            + this.linkId
            + ", taskId="
            + this.taskId
            + ", assembleTaskProcessId="
            + this.assembleTaskProcessId
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
            + ", structureType="
            + this.structureType
            + ")";
      }
   }
}
