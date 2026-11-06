package com.hzchum.scim.cut.core.api.param;

import java.math.BigDecimal;

public class AssignTaskParam {
   private String cutTaskId;
   private String importTime;
   private Integer relationType;
   private BigDecimal thick;
   private String material;
   private Integer partNum;
   private BigDecimal partWeight;
   private Integer plateNum;
   private BigDecimal plateWeight;

   AssignTaskParam(
      final String cutTaskId,
      final String importTime,
      final Integer relationType,
      final BigDecimal thick,
      final String material,
      final Integer partNum,
      final BigDecimal partWeight,
      final Integer plateNum,
      final BigDecimal plateWeight
   ) {
      this.cutTaskId = cutTaskId;
      this.importTime = importTime;
      this.relationType = relationType;
      this.thick = thick;
      this.material = material;
      this.partNum = partNum;
      this.partWeight = partWeight;
      this.plateNum = plateNum;
      this.plateWeight = plateWeight;
   }

   public static AssignTaskParam.AssignTaskParamBuilder builder() {
      return new AssignTaskParam.AssignTaskParamBuilder();
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getImportTime() {
      return this.importTime;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getPartNum() {
      return this.partNum;
   }

   public BigDecimal getPartWeight() {
      return this.partWeight;
   }

   public Integer getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getPlateWeight() {
      return this.plateWeight;
   }

   public void setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
   }

   public void setImportTime(final String importTime) {
      this.importTime = importTime;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setPartNum(final Integer partNum) {
      this.partNum = partNum;
   }

   public void setPartWeight(final BigDecimal partWeight) {
      this.partWeight = partWeight;
   }

   public void setPlateNum(final Integer plateNum) {
      this.plateNum = plateNum;
   }

   public void setPlateWeight(final BigDecimal plateWeight) {
      this.plateWeight = plateWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssignTaskParam)) {
         return false;
      }

      AssignTaskParam other = (AssignTaskParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$relationType = this.getRelationType();
      Object other$relationType = other.getRelationType();
      if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
         Object this$partNum = this.getPartNum();
         Object other$partNum = other.getPartNum();
         if (this$partNum == null ? other$partNum == null : this$partNum.equals(other$partNum)) {
            Object this$plateNum = this.getPlateNum();
            Object other$plateNum = other.getPlateNum();
            if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
               Object this$cutTaskId = this.getCutTaskId();
               Object other$cutTaskId = other.getCutTaskId();
               if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
                  Object this$importTime = this.getImportTime();
                  Object other$importTime = other.getImportTime();
                  if (this$importTime == null ? other$importTime == null : this$importTime.equals(other$importTime)) {
                     Object this$thick = this.getThick();
                     Object other$thick = other.getThick();
                     if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$partWeight = this.getPartWeight();
                           Object other$partWeight = other.getPartWeight();
                           if (this$partWeight == null ? other$partWeight == null : this$partWeight.equals(other$partWeight)) {
                              Object this$plateWeight = this.getPlateWeight();
                              Object other$plateWeight = other.getPlateWeight();
                              return this$plateWeight == null ? other$plateWeight == null : this$plateWeight.equals(other$plateWeight);
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
      return other instanceof AssignTaskParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $partNum = this.getPartNum();
      result = result * 59 + ($partNum == null ? 43 : $partNum.hashCode());
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $partWeight = this.getPartWeight();
      result = result * 59 + ($partWeight == null ? 43 : $partWeight.hashCode());
      Object $plateWeight = this.getPlateWeight();
      return result * 59 + ($plateWeight == null ? 43 : $plateWeight.hashCode());
   }

   @Override
   public String toString() {
      return "AssignTaskParam(cutTaskId="
         + this.getCutTaskId()
         + ", importTime="
         + this.getImportTime()
         + ", relationType="
         + this.getRelationType()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", partNum="
         + this.getPartNum()
         + ", partWeight="
         + this.getPartWeight()
         + ", plateNum="
         + this.getPlateNum()
         + ", plateWeight="
         + this.getPlateWeight()
         + ")";
   }

   public static class AssignTaskParamBuilder {
      private String cutTaskId;
      private String importTime;
      private Integer relationType;
      private BigDecimal thick;
      private String material;
      private Integer partNum;
      private BigDecimal partWeight;
      private Integer plateNum;
      private BigDecimal plateWeight;

      AssignTaskParamBuilder() {
      }

      public AssignTaskParam.AssignTaskParamBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder importTime(final String importTime) {
         this.importTime = importTime;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder partNum(final Integer partNum) {
         this.partNum = partNum;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder partWeight(final BigDecimal partWeight) {
         this.partWeight = partWeight;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder plateNum(final Integer plateNum) {
         this.plateNum = plateNum;
         return this;
      }

      public AssignTaskParam.AssignTaskParamBuilder plateWeight(final BigDecimal plateWeight) {
         this.plateWeight = plateWeight;
         return this;
      }

      public AssignTaskParam build() {
         return new AssignTaskParam(
            this.cutTaskId, this.importTime, this.relationType, this.thick, this.material, this.partNum, this.partWeight, this.plateNum, this.plateWeight
         );
      }

      @Override
      public String toString() {
         return "AssignTaskParam.AssignTaskParamBuilder(cutTaskId="
            + this.cutTaskId
            + ", importTime="
            + this.importTime
            + ", relationType="
            + this.relationType
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", partNum="
            + this.partNum
            + ", partWeight="
            + this.partWeight
            + ", plateNum="
            + this.plateNum
            + ", plateWeight="
            + this.plateWeight
            + ")";
      }
   }
}
