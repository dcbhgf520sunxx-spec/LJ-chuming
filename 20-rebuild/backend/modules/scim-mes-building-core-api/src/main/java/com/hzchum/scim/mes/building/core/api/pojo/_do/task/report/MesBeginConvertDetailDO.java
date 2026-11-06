package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MesBeginConvertArtifactDO", description = "期初构件半成品构件汇总")
public class MesBeginConvertDetailDO {
   private Long projectId;
   private String projectName;
   private Long taskId;
   private Long productId;
   private Long processId;
   private String processTypeName;
   private Integer taskQuantity;
   private Integer completeQuantity;
   private Integer sequence;
   private BigDecimal grossWeight;
   private String structureType;

   public static MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder builder() {
      return new MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder();
   }

   public MesBeginConvertDetailDO() {
   }

   public MesBeginConvertDetailDO(
      final Long projectId,
      final String projectName,
      final Long taskId,
      final Long productId,
      final Long processId,
      final String processTypeName,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer sequence,
      final BigDecimal grossWeight,
      final String structureType
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.taskId = taskId;
      this.productId = productId;
      this.processId = processId;
      this.processTypeName = processTypeName;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.sequence = sequence;
      this.grossWeight = grossWeight;
      this.structureType = structureType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getTaskId() {
      return this.taskId;
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

   public String getStructureType() {
      return this.structureType;
   }

   public MesBeginConvertDetailDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBeginConvertDetailDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesBeginConvertDetailDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBeginConvertDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBeginConvertDetailDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBeginConvertDetailDO setProcessTypeName(final String processTypeName) {
      this.processTypeName = processTypeName;
      return this;
   }

   public MesBeginConvertDetailDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public MesBeginConvertDetailDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public MesBeginConvertDetailDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   public MesBeginConvertDetailDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public MesBeginConvertDetailDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBeginConvertDetailDO)) {
         return false;
      }

      MesBeginConvertDetailDO other = (MesBeginConvertDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBeginConvertDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      return "MesBeginConvertDetailDO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", taskId="
         + this.getTaskId()
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
         + ", structureType="
         + this.getStructureType()
         + ")";
   }

   public static class MesBeginConvertDetailDOBuilder {
      private Long projectId;
      private String projectName;
      private Long taskId;
      private Long productId;
      private Long processId;
      private String processTypeName;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer sequence;
      private BigDecimal grossWeight;
      private String structureType;

      MesBeginConvertDetailDOBuilder() {
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder processTypeName(final String processTypeName) {
         this.processTypeName = processTypeName;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesBeginConvertDetailDO build() {
         return new MesBeginConvertDetailDO(
            this.projectId,
            this.projectName,
            this.taskId,
            this.productId,
            this.processId,
            this.processTypeName,
            this.taskQuantity,
            this.completeQuantity,
            this.sequence,
            this.grossWeight,
            this.structureType
         );
      }

      @Override
      public String toString() {
         return "MesBeginConvertDetailDO.MesBeginConvertDetailDOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", taskId="
            + this.taskId
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
            + ", structureType="
            + this.structureType
            + ")";
      }
   }
}
