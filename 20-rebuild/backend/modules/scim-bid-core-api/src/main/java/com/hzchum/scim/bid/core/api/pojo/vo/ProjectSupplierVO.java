package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectSupplierVO {
   private Long id;
   private String name;
   private Integer projectType;
   private String companyName;
   private String projectTypeName;
   private Integer projectProgress;
   private String contractNo;
   private Integer round;
   private Integer biddingType;
   private Date releaseDate;
   private Date bidDeadline;
   private Date bidOpeningTime;
   private Integer bidStatus;
   private Integer number;
   private Integer followNumber;
   private BigDecimal bidGrossAmount;
   private Date createTime;

   public static ProjectSupplierVO.ProjectSupplierVOBuilder builder() {
      return new ProjectSupplierVO.ProjectSupplierVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getProjectTypeName() {
      return this.projectTypeName;
   }

   public Integer getProjectProgress() {
      return this.projectProgress;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public Integer getRound() {
      return this.round;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public Date getReleaseDate() {
      return this.releaseDate;
   }

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
   }

   public Integer getBidStatus() {
      return this.bidStatus;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getFollowNumber() {
      return this.followNumber;
   }

   public BigDecimal getBidGrossAmount() {
      return this.bidGrossAmount;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setProjectTypeName(final String projectTypeName) {
      this.projectTypeName = projectTypeName;
   }

   public void setProjectProgress(final Integer projectProgress) {
      this.projectProgress = projectProgress;
   }

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
   }

   public void setReleaseDate(final Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public void setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
   }

   public void setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
   }

   public void setBidStatus(final Integer bidStatus) {
      this.bidStatus = bidStatus;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setFollowNumber(final Integer followNumber) {
      this.followNumber = followNumber;
   }

   public void setBidGrossAmount(final BigDecimal bidGrossAmount) {
      this.bidGrossAmount = bidGrossAmount;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplierVO)) {
         return false;
      }

      ProjectSupplierVO other = (ProjectSupplierVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$projectProgress = this.getProjectProgress();
            Object other$projectProgress = other.getProjectProgress();
            if (this$projectProgress == null ? other$projectProgress == null : this$projectProgress.equals(other$projectProgress)) {
               Object this$round = this.getRound();
               Object other$round = other.getRound();
               if (this$round == null ? other$round == null : this$round.equals(other$round)) {
                  Object this$biddingType = this.getBiddingType();
                  Object other$biddingType = other.getBiddingType();
                  if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
                     Object this$bidStatus = this.getBidStatus();
                     Object other$bidStatus = other.getBidStatus();
                     if (this$bidStatus == null ? other$bidStatus == null : this$bidStatus.equals(other$bidStatus)) {
                        Object this$number = this.getNumber();
                        Object other$number = other.getNumber();
                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                           Object this$followNumber = this.getFollowNumber();
                           Object other$followNumber = other.getFollowNumber();
                           if (this$followNumber == null ? other$followNumber == null : this$followNumber.equals(other$followNumber)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$companyName = this.getCompanyName();
                                 Object other$companyName = other.getCompanyName();
                                 if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                                    Object this$projectTypeName = this.getProjectTypeName();
                                    Object other$projectTypeName = other.getProjectTypeName();
                                    if (this$projectTypeName == null ? other$projectTypeName == null : this$projectTypeName.equals(other$projectTypeName)) {
                                       Object this$contractNo = this.getContractNo();
                                       Object other$contractNo = other.getContractNo();
                                       if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                                          Object this$releaseDate = this.getReleaseDate();
                                          Object other$releaseDate = other.getReleaseDate();
                                          if (this$releaseDate == null ? other$releaseDate == null : this$releaseDate.equals(other$releaseDate)) {
                                             Object this$bidDeadline = this.getBidDeadline();
                                             Object other$bidDeadline = other.getBidDeadline();
                                             if (this$bidDeadline == null ? other$bidDeadline == null : this$bidDeadline.equals(other$bidDeadline)) {
                                                Object this$bidOpeningTime = this.getBidOpeningTime();
                                                Object other$bidOpeningTime = other.getBidOpeningTime();
                                                if (this$bidOpeningTime == null
                                                   ? other$bidOpeningTime == null
                                                   : this$bidOpeningTime.equals(other$bidOpeningTime)) {
                                                   Object this$bidGrossAmount = this.getBidGrossAmount();
                                                   Object other$bidGrossAmount = other.getBidGrossAmount();
                                                   if (this$bidGrossAmount == null
                                                      ? other$bidGrossAmount == null
                                                      : this$bidGrossAmount.equals(other$bidGrossAmount)) {
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
      return other instanceof ProjectSupplierVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $projectProgress = this.getProjectProgress();
      result = result * 59 + ($projectProgress == null ? 43 : $projectProgress.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $bidStatus = this.getBidStatus();
      result = result * 59 + ($bidStatus == null ? 43 : $bidStatus.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $followNumber = this.getFollowNumber();
      result = result * 59 + ($followNumber == null ? 43 : $followNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $projectTypeName = this.getProjectTypeName();
      result = result * 59 + ($projectTypeName == null ? 43 : $projectTypeName.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $bidGrossAmount = this.getBidGrossAmount();
      result = result * 59 + ($bidGrossAmount == null ? 43 : $bidGrossAmount.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSupplierVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", companyName="
         + this.getCompanyName()
         + ", projectTypeName="
         + this.getProjectTypeName()
         + ", projectProgress="
         + this.getProjectProgress()
         + ", contractNo="
         + this.getContractNo()
         + ", round="
         + this.getRound()
         + ", biddingType="
         + this.getBiddingType()
         + ", releaseDate="
         + this.getReleaseDate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", bidStatus="
         + this.getBidStatus()
         + ", number="
         + this.getNumber()
         + ", followNumber="
         + this.getFollowNumber()
         + ", bidGrossAmount="
         + this.getBidGrossAmount()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public ProjectSupplierVO() {
   }

   public ProjectSupplierVO(
      final Long id,
      final String name,
      final Integer projectType,
      final String companyName,
      final String projectTypeName,
      final Integer projectProgress,
      final String contractNo,
      final Integer round,
      final Integer biddingType,
      final Date releaseDate,
      final Date bidDeadline,
      final Date bidOpeningTime,
      final Integer bidStatus,
      final Integer number,
      final Integer followNumber,
      final BigDecimal bidGrossAmount,
      final Date createTime
   ) {
      this.id = id;
      this.name = name;
      this.projectType = projectType;
      this.companyName = companyName;
      this.projectTypeName = projectTypeName;
      this.projectProgress = projectProgress;
      this.contractNo = contractNo;
      this.round = round;
      this.biddingType = biddingType;
      this.releaseDate = releaseDate;
      this.bidDeadline = bidDeadline;
      this.bidOpeningTime = bidOpeningTime;
      this.bidStatus = bidStatus;
      this.number = number;
      this.followNumber = followNumber;
      this.bidGrossAmount = bidGrossAmount;
      this.createTime = createTime;
   }

   public static class ProjectSupplierVOBuilder {
      private Long id;
      private String name;
      private Integer projectType;
      private String companyName;
      private String projectTypeName;
      private Integer projectProgress;
      private String contractNo;
      private Integer round;
      private Integer biddingType;
      private Date releaseDate;
      private Date bidDeadline;
      private Date bidOpeningTime;
      private Integer bidStatus;
      private Integer number;
      private Integer followNumber;
      private BigDecimal bidGrossAmount;
      private Date createTime;

      ProjectSupplierVOBuilder() {
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder projectTypeName(final String projectTypeName) {
         this.projectTypeName = projectTypeName;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder projectProgress(final Integer projectProgress) {
         this.projectProgress = projectProgress;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder biddingType(final Integer biddingType) {
         this.biddingType = biddingType;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder releaseDate(final Date releaseDate) {
         this.releaseDate = releaseDate;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder bidStatus(final Integer bidStatus) {
         this.bidStatus = bidStatus;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder followNumber(final Integer followNumber) {
         this.followNumber = followNumber;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder bidGrossAmount(final BigDecimal bidGrossAmount) {
         this.bidGrossAmount = bidGrossAmount;
         return this;
      }

      public ProjectSupplierVO.ProjectSupplierVOBuilder createTime(final Date createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectSupplierVO build() {
         return new ProjectSupplierVO(
            this.id,
            this.name,
            this.projectType,
            this.companyName,
            this.projectTypeName,
            this.projectProgress,
            this.contractNo,
            this.round,
            this.biddingType,
            this.releaseDate,
            this.bidDeadline,
            this.bidOpeningTime,
            this.bidStatus,
            this.number,
            this.followNumber,
            this.bidGrossAmount,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "ProjectSupplierVO.ProjectSupplierVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", companyName="
            + this.companyName
            + ", projectTypeName="
            + this.projectTypeName
            + ", projectProgress="
            + this.projectProgress
            + ", contractNo="
            + this.contractNo
            + ", round="
            + this.round
            + ", biddingType="
            + this.biddingType
            + ", releaseDate="
            + this.releaseDate
            + ", bidDeadline="
            + this.bidDeadline
            + ", bidOpeningTime="
            + this.bidOpeningTime
            + ", bidStatus="
            + this.bidStatus
            + ", number="
            + this.number
            + ", followNumber="
            + this.followNumber
            + ", bidGrossAmount="
            + this.bidGrossAmount
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
