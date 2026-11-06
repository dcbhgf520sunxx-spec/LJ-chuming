package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.Date;

public class BiddingRoundsVO {
   private Long id;
   private Long projectId;
   private Integer round;
   private Date releaseDate;
   private Date bidDeadline;
   private Date bidOpeningTime;

   public static BiddingRoundsVO.BiddingRoundsVOBuilder builder() {
      return new BiddingRoundsVO.BiddingRoundsVOBuilder();
   }

   public BiddingRoundsVO() {
   }

   public BiddingRoundsVO(final Long id, final Long projectId, final Integer round, final Date releaseDate, final Date bidDeadline, final Date bidOpeningTime) {
      this.id = id;
      this.projectId = projectId;
      this.round = round;
      this.releaseDate = releaseDate;
      this.bidDeadline = bidDeadline;
      this.bidOpeningTime = bidOpeningTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRound() {
      return this.round;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRound(final Integer round) {
      this.round = round;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingRoundsVO)) {
         return false;
      }

      BiddingRoundsVO other = (BiddingRoundsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$round = this.getRound();
            Object other$round = other.getRound();
            if (this$round == null ? other$round == null : this$round.equals(other$round)) {
               Object this$releaseDate = this.getReleaseDate();
               Object other$releaseDate = other.getReleaseDate();
               if (this$releaseDate == null ? other$releaseDate == null : this$releaseDate.equals(other$releaseDate)) {
                  Object this$bidDeadline = this.getBidDeadline();
                  Object other$bidDeadline = other.getBidDeadline();
                  if (this$bidDeadline == null ? other$bidDeadline == null : this$bidDeadline.equals(other$bidDeadline)) {
                     Object this$bidOpeningTime = this.getBidOpeningTime();
                     Object other$bidOpeningTime = other.getBidOpeningTime();
                     return this$bidOpeningTime == null ? other$bidOpeningTime == null : this$bidOpeningTime.equals(other$bidOpeningTime);
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
      return other instanceof BiddingRoundsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      return result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingRoundsVO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", round="
         + this.getRound()
         + ", releaseDate="
         + this.getReleaseDate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ")";
   }

   public static class BiddingRoundsVOBuilder {
      private Long id;
      private Long projectId;
      private Integer round;
      private Date releaseDate;
      private Date bidDeadline;
      private Date bidOpeningTime;

      BiddingRoundsVOBuilder() {
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder releaseDate(final Date releaseDate) {
         this.releaseDate = releaseDate;
         return this;
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      public BiddingRoundsVO.BiddingRoundsVOBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      public BiddingRoundsVO build() {
         return new BiddingRoundsVO(this.id, this.projectId, this.round, this.releaseDate, this.bidDeadline, this.bidOpeningTime);
      }

      @Override
      public String toString() {
         return "BiddingRoundsVO.BiddingRoundsVOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", round="
            + this.round
            + ", releaseDate="
            + this.releaseDate
            + ", bidDeadline="
            + this.bidDeadline
            + ", bidOpeningTime="
            + this.bidOpeningTime
            + ")";
      }
   }
}
