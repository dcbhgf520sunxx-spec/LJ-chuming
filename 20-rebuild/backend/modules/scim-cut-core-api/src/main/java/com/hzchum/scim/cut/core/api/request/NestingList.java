package com.hzchum.scim.cut.core.api.request;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "NestingList", description = "项目+钢板清单")
public class NestingList {
   private Long projectId;
   private String projectName;
   private String projectNumber;
   private Integer plateNum;
   private BigDecimal plateWeight;
   private Integer distributionNum;
   private BigDecimal distributionWeight;
   private Integer partNum;
   private BigDecimal partWeight;
   private Integer distributionPartNum;
   private BigDecimal distributionPartWeight;
   private Integer cuttingNum;
   private String reportUrl;
   private Integer nestingState;
   private Integer cutState;

   NestingList(
      final Long projectId,
      final String projectName,
      final String projectNumber,
      final Integer plateNum,
      final BigDecimal plateWeight,
      final Integer distributionNum,
      final BigDecimal distributionWeight,
      final Integer partNum,
      final BigDecimal partWeight,
      final Integer distributionPartNum,
      final BigDecimal distributionPartWeight,
      final Integer cuttingNum,
      final String reportUrl,
      final Integer nestingState,
      final Integer cutState
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.projectNumber = projectNumber;
      this.plateNum = plateNum;
      this.plateWeight = plateWeight;
      this.distributionNum = distributionNum;
      this.distributionWeight = distributionWeight;
      this.partNum = partNum;
      this.partWeight = partWeight;
      this.distributionPartNum = distributionPartNum;
      this.distributionPartWeight = distributionPartWeight;
      this.cuttingNum = cuttingNum;
      this.reportUrl = reportUrl;
      this.nestingState = nestingState;
      this.cutState = cutState;
   }

   public static NestingList.NestingListBuilder builder() {
      return new NestingList.NestingListBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectNumber() {
      return this.projectNumber;
   }

   public Integer getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getPlateWeight() {
      return this.plateWeight;
   }

   public Integer getDistributionNum() {
      return this.distributionNum;
   }

   public BigDecimal getDistributionWeight() {
      return this.distributionWeight;
   }

   public Integer getPartNum() {
      return this.partNum;
   }

   public BigDecimal getPartWeight() {
      return this.partWeight;
   }

   public Integer getDistributionPartNum() {
      return this.distributionPartNum;
   }

   public BigDecimal getDistributionPartWeight() {
      return this.distributionPartWeight;
   }

   public Integer getCuttingNum() {
      return this.cuttingNum;
   }

   public String getReportUrl() {
      return this.reportUrl;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public Integer getCutState() {
      return this.cutState;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProjectNumber(final String projectNumber) {
      this.projectNumber = projectNumber;
   }

   public void setPlateNum(final Integer plateNum) {
      this.plateNum = plateNum;
   }

   public void setPlateWeight(final BigDecimal plateWeight) {
      this.plateWeight = plateWeight;
   }

   public void setDistributionNum(final Integer distributionNum) {
      this.distributionNum = distributionNum;
   }

   public void setDistributionWeight(final BigDecimal distributionWeight) {
      this.distributionWeight = distributionWeight;
   }

   public void setPartNum(final Integer partNum) {
      this.partNum = partNum;
   }

   public void setPartWeight(final BigDecimal partWeight) {
      this.partWeight = partWeight;
   }

   public void setDistributionPartNum(final Integer distributionPartNum) {
      this.distributionPartNum = distributionPartNum;
   }

   public void setDistributionPartWeight(final BigDecimal distributionPartWeight) {
      this.distributionPartWeight = distributionPartWeight;
   }

   public void setCuttingNum(final Integer cuttingNum) {
      this.cuttingNum = cuttingNum;
   }

   public void setReportUrl(final String reportUrl) {
      this.reportUrl = reportUrl;
   }

   public void setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
   }

   public void setCutState(final Integer cutState) {
      this.cutState = cutState;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestingList)) {
         return false;
      }

      NestingList other = (NestingList)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$plateNum = this.getPlateNum();
         Object other$plateNum = other.getPlateNum();
         if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
            Object this$distributionNum = this.getDistributionNum();
            Object other$distributionNum = other.getDistributionNum();
            if (this$distributionNum == null ? other$distributionNum == null : this$distributionNum.equals(other$distributionNum)) {
               Object this$partNum = this.getPartNum();
               Object other$partNum = other.getPartNum();
               if (this$partNum == null ? other$partNum == null : this$partNum.equals(other$partNum)) {
                  Object this$distributionPartNum = this.getDistributionPartNum();
                  Object other$distributionPartNum = other.getDistributionPartNum();
                  if (this$distributionPartNum == null ? other$distributionPartNum == null : this$distributionPartNum.equals(other$distributionPartNum)) {
                     Object this$cuttingNum = this.getCuttingNum();
                     Object other$cuttingNum = other.getCuttingNum();
                     if (this$cuttingNum == null ? other$cuttingNum == null : this$cuttingNum.equals(other$cuttingNum)) {
                        Object this$nestingState = this.getNestingState();
                        Object other$nestingState = other.getNestingState();
                        if (this$nestingState == null ? other$nestingState == null : this$nestingState.equals(other$nestingState)) {
                           Object this$cutState = this.getCutState();
                           Object other$cutState = other.getCutState();
                           if (this$cutState == null ? other$cutState == null : this$cutState.equals(other$cutState)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$projectNumber = this.getProjectNumber();
                                 Object other$projectNumber = other.getProjectNumber();
                                 if (this$projectNumber == null ? other$projectNumber == null : this$projectNumber.equals(other$projectNumber)) {
                                    Object this$plateWeight = this.getPlateWeight();
                                    Object other$plateWeight = other.getPlateWeight();
                                    if (this$plateWeight == null ? other$plateWeight == null : this$plateWeight.equals(other$plateWeight)) {
                                       Object this$distributionWeight = this.getDistributionWeight();
                                       Object other$distributionWeight = other.getDistributionWeight();
                                       if (this$distributionWeight == null
                                          ? other$distributionWeight == null
                                          : this$distributionWeight.equals(other$distributionWeight)) {
                                          Object this$partWeight = this.getPartWeight();
                                          Object other$partWeight = other.getPartWeight();
                                          if (this$partWeight == null ? other$partWeight == null : this$partWeight.equals(other$partWeight)) {
                                             Object this$distributionPartWeight = this.getDistributionPartWeight();
                                             Object other$distributionPartWeight = other.getDistributionPartWeight();
                                             if (this$distributionPartWeight == null
                                                ? other$distributionPartWeight == null
                                                : this$distributionPartWeight.equals(other$distributionPartWeight)) {
                                                Object this$reportUrl = this.getReportUrl();
                                                Object other$reportUrl = other.getReportUrl();
                                                return this$reportUrl == null ? other$reportUrl == null : this$reportUrl.equals(other$reportUrl);
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
      return other instanceof NestingList;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $distributionNum = this.getDistributionNum();
      result = result * 59 + ($distributionNum == null ? 43 : $distributionNum.hashCode());
      Object $partNum = this.getPartNum();
      result = result * 59 + ($partNum == null ? 43 : $partNum.hashCode());
      Object $distributionPartNum = this.getDistributionPartNum();
      result = result * 59 + ($distributionPartNum == null ? 43 : $distributionPartNum.hashCode());
      Object $cuttingNum = this.getCuttingNum();
      result = result * 59 + ($cuttingNum == null ? 43 : $cuttingNum.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $cutState = this.getCutState();
      result = result * 59 + ($cutState == null ? 43 : $cutState.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectNumber = this.getProjectNumber();
      result = result * 59 + ($projectNumber == null ? 43 : $projectNumber.hashCode());
      Object $plateWeight = this.getPlateWeight();
      result = result * 59 + ($plateWeight == null ? 43 : $plateWeight.hashCode());
      Object $distributionWeight = this.getDistributionWeight();
      result = result * 59 + ($distributionWeight == null ? 43 : $distributionWeight.hashCode());
      Object $partWeight = this.getPartWeight();
      result = result * 59 + ($partWeight == null ? 43 : $partWeight.hashCode());
      Object $distributionPartWeight = this.getDistributionPartWeight();
      result = result * 59 + ($distributionPartWeight == null ? 43 : $distributionPartWeight.hashCode());
      Object $reportUrl = this.getReportUrl();
      return result * 59 + ($reportUrl == null ? 43 : $reportUrl.hashCode());
   }

   @Override
   public String toString() {
      return "NestingList(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectNumber="
         + this.getProjectNumber()
         + ", plateNum="
         + this.getPlateNum()
         + ", plateWeight="
         + this.getPlateWeight()
         + ", distributionNum="
         + this.getDistributionNum()
         + ", distributionWeight="
         + this.getDistributionWeight()
         + ", partNum="
         + this.getPartNum()
         + ", partWeight="
         + this.getPartWeight()
         + ", distributionPartNum="
         + this.getDistributionPartNum()
         + ", distributionPartWeight="
         + this.getDistributionPartWeight()
         + ", cuttingNum="
         + this.getCuttingNum()
         + ", reportUrl="
         + this.getReportUrl()
         + ", nestingState="
         + this.getNestingState()
         + ", cutState="
         + this.getCutState()
         + ")";
   }

   public static class NestingListBuilder {
      private Long projectId;
      private String projectName;
      private String projectNumber;
      private Integer plateNum;
      private BigDecimal plateWeight;
      private Integer distributionNum;
      private BigDecimal distributionWeight;
      private Integer partNum;
      private BigDecimal partWeight;
      private Integer distributionPartNum;
      private BigDecimal distributionPartWeight;
      private Integer cuttingNum;
      private String reportUrl;
      private Integer nestingState;
      private Integer cutState;

      NestingListBuilder() {
      }

      public NestingList.NestingListBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public NestingList.NestingListBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public NestingList.NestingListBuilder projectNumber(final String projectNumber) {
         this.projectNumber = projectNumber;
         return this;
      }

      public NestingList.NestingListBuilder plateNum(final Integer plateNum) {
         this.plateNum = plateNum;
         return this;
      }

      public NestingList.NestingListBuilder plateWeight(final BigDecimal plateWeight) {
         this.plateWeight = plateWeight;
         return this;
      }

      public NestingList.NestingListBuilder distributionNum(final Integer distributionNum) {
         this.distributionNum = distributionNum;
         return this;
      }

      public NestingList.NestingListBuilder distributionWeight(final BigDecimal distributionWeight) {
         this.distributionWeight = distributionWeight;
         return this;
      }

      public NestingList.NestingListBuilder partNum(final Integer partNum) {
         this.partNum = partNum;
         return this;
      }

      public NestingList.NestingListBuilder partWeight(final BigDecimal partWeight) {
         this.partWeight = partWeight;
         return this;
      }

      public NestingList.NestingListBuilder distributionPartNum(final Integer distributionPartNum) {
         this.distributionPartNum = distributionPartNum;
         return this;
      }

      public NestingList.NestingListBuilder distributionPartWeight(final BigDecimal distributionPartWeight) {
         this.distributionPartWeight = distributionPartWeight;
         return this;
      }

      public NestingList.NestingListBuilder cuttingNum(final Integer cuttingNum) {
         this.cuttingNum = cuttingNum;
         return this;
      }

      public NestingList.NestingListBuilder reportUrl(final String reportUrl) {
         this.reportUrl = reportUrl;
         return this;
      }

      public NestingList.NestingListBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      public NestingList.NestingListBuilder cutState(final Integer cutState) {
         this.cutState = cutState;
         return this;
      }

      public NestingList build() {
         return new NestingList(
            this.projectId,
            this.projectName,
            this.projectNumber,
            this.plateNum,
            this.plateWeight,
            this.distributionNum,
            this.distributionWeight,
            this.partNum,
            this.partWeight,
            this.distributionPartNum,
            this.distributionPartWeight,
            this.cuttingNum,
            this.reportUrl,
            this.nestingState,
            this.cutState
         );
      }

      @Override
      public String toString() {
         return "NestingList.NestingListBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", projectNumber="
            + this.projectNumber
            + ", plateNum="
            + this.plateNum
            + ", plateWeight="
            + this.plateWeight
            + ", distributionNum="
            + this.distributionNum
            + ", distributionWeight="
            + this.distributionWeight
            + ", partNum="
            + this.partNum
            + ", partWeight="
            + this.partWeight
            + ", distributionPartNum="
            + this.distributionPartNum
            + ", distributionPartWeight="
            + this.distributionPartWeight
            + ", cuttingNum="
            + this.cuttingNum
            + ", reportUrl="
            + this.reportUrl
            + ", nestingState="
            + this.nestingState
            + ", cutState="
            + this.cutState
            + ")";
      }
   }
}
