package com.hzchum.scim.bid.core.api.pojo.dto;

public class TendQueryConditionsDTO {
   private String contractNo;
   private String name;
   private Integer projectType;
   private Integer biddingType;
   private Integer projectProgress;
   private Integer status;
   private String biddingUnit;
   private String founder;
   private String verifier;
   private Long startDateVerifier;
   private Long endDateVerifier;
   private Long startDate;
   private Long endDate;

   public String getContractNo() {
      return this.contractNo;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public Integer getProjectProgress() {
      return this.projectProgress;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getBiddingUnit() {
      return this.biddingUnit;
   }

   public String getFounder() {
      return this.founder;
   }

   public String getVerifier() {
      return this.verifier;
   }

   public Long getStartDateVerifier() {
      return this.startDateVerifier;
   }

   public Long getEndDateVerifier() {
      return this.endDateVerifier;
   }

   public Long getStartDate() {
      return this.startDate;
   }

   public Long getEndDate() {
      return this.endDate;
   }

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
   }

   public void setProjectProgress(final Integer projectProgress) {
      this.projectProgress = projectProgress;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setBiddingUnit(final String biddingUnit) {
      this.biddingUnit = biddingUnit;
   }

   public void setFounder(final String founder) {
      this.founder = founder;
   }

   public void setVerifier(final String verifier) {
      this.verifier = verifier;
   }

   public void setStartDateVerifier(final Long startDateVerifier) {
      this.startDateVerifier = startDateVerifier;
   }

   public void setEndDateVerifier(final Long endDateVerifier) {
      this.endDateVerifier = endDateVerifier;
   }

   public void setStartDate(final Long startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final Long endDate) {
      this.endDate = endDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TendQueryConditionsDTO)) {
         return false;
      }

      TendQueryConditionsDTO other = (TendQueryConditionsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectType = this.getProjectType();
      Object other$projectType = other.getProjectType();
      if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
         Object this$biddingType = this.getBiddingType();
         Object other$biddingType = other.getBiddingType();
         if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
            Object this$projectProgress = this.getProjectProgress();
            Object other$projectProgress = other.getProjectProgress();
            if (this$projectProgress == null ? other$projectProgress == null : this$projectProgress.equals(other$projectProgress)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$startDateVerifier = this.getStartDateVerifier();
                  Object other$startDateVerifier = other.getStartDateVerifier();
                  if (this$startDateVerifier == null ? other$startDateVerifier == null : this$startDateVerifier.equals(other$startDateVerifier)) {
                     Object this$endDateVerifier = this.getEndDateVerifier();
                     Object other$endDateVerifier = other.getEndDateVerifier();
                     if (this$endDateVerifier == null ? other$endDateVerifier == null : this$endDateVerifier.equals(other$endDateVerifier)) {
                        Object this$startDate = this.getStartDate();
                        Object other$startDate = other.getStartDate();
                        if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                              Object this$contractNo = this.getContractNo();
                              Object other$contractNo = other.getContractNo();
                              if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$biddingUnit = this.getBiddingUnit();
                                    Object other$biddingUnit = other.getBiddingUnit();
                                    if (this$biddingUnit == null ? other$biddingUnit == null : this$biddingUnit.equals(other$biddingUnit)) {
                                       Object this$founder = this.getFounder();
                                       Object other$founder = other.getFounder();
                                       if (this$founder == null ? other$founder == null : this$founder.equals(other$founder)) {
                                          Object this$verifier = this.getVerifier();
                                          Object other$verifier = other.getVerifier();
                                          return this$verifier == null ? other$verifier == null : this$verifier.equals(other$verifier);
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
      return other instanceof TendQueryConditionsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $projectProgress = this.getProjectProgress();
      result = result * 59 + ($projectProgress == null ? 43 : $projectProgress.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $startDateVerifier = this.getStartDateVerifier();
      result = result * 59 + ($startDateVerifier == null ? 43 : $startDateVerifier.hashCode());
      Object $endDateVerifier = this.getEndDateVerifier();
      result = result * 59 + ($endDateVerifier == null ? 43 : $endDateVerifier.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $biddingUnit = this.getBiddingUnit();
      result = result * 59 + ($biddingUnit == null ? 43 : $biddingUnit.hashCode());
      Object $founder = this.getFounder();
      result = result * 59 + ($founder == null ? 43 : $founder.hashCode());
      Object $verifier = this.getVerifier();
      return result * 59 + ($verifier == null ? 43 : $verifier.hashCode());
   }

   @Override
   public String toString() {
      return "TendQueryConditionsDTO(contractNo="
         + this.getContractNo()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", biddingType="
         + this.getBiddingType()
         + ", projectProgress="
         + this.getProjectProgress()
         + ", status="
         + this.getStatus()
         + ", biddingUnit="
         + this.getBiddingUnit()
         + ", founder="
         + this.getFounder()
         + ", verifier="
         + this.getVerifier()
         + ", startDateVerifier="
         + this.getStartDateVerifier()
         + ", endDateVerifier="
         + this.getEndDateVerifier()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }
}
