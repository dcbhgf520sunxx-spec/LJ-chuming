package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目统计类")
public class ProjectFeedingStateDTO {
   @ApiModelProperty("时间")
   private String dateTime;
   @ApiModelProperty("投料量")
   private BigDecimal feedingMete;
   @ApiModelProperty("产量")
   private BigDecimal produceMete;

   public static ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder builder() {
      return new ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder();
   }

   public ProjectFeedingStateDTO() {
   }

   public ProjectFeedingStateDTO(final String dateTime, final BigDecimal feedingMete, final BigDecimal produceMete) {
      this.dateTime = dateTime;
      this.feedingMete = feedingMete;
      this.produceMete = produceMete;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getFeedingMete() {
      return this.feedingMete;
   }

   public BigDecimal getProduceMete() {
      return this.produceMete;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setFeedingMete(final BigDecimal feedingMete) {
      this.feedingMete = feedingMete;
   }

   public void setProduceMete(final BigDecimal produceMete) {
      this.produceMete = produceMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectFeedingStateDTO)) {
         return false;
      }

      ProjectFeedingStateDTO other = (ProjectFeedingStateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
         Object this$feedingMete = this.getFeedingMete();
         Object other$feedingMete = other.getFeedingMete();
         if (this$feedingMete == null ? other$feedingMete == null : this$feedingMete.equals(other$feedingMete)) {
            Object this$produceMete = this.getProduceMete();
            Object other$produceMete = other.getProduceMete();
            return this$produceMete == null ? other$produceMete == null : this$produceMete.equals(other$produceMete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectFeedingStateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $feedingMete = this.getFeedingMete();
      result = result * 59 + ($feedingMete == null ? 43 : $feedingMete.hashCode());
      Object $produceMete = this.getProduceMete();
      return result * 59 + ($produceMete == null ? 43 : $produceMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectFeedingStateDTO(dateTime="
         + this.getDateTime()
         + ", feedingMete="
         + this.getFeedingMete()
         + ", produceMete="
         + this.getProduceMete()
         + ")";
   }

   public static class ProjectFeedingStateDTOBuilder {
      private String dateTime;
      private BigDecimal feedingMete;
      private BigDecimal produceMete;

      ProjectFeedingStateDTOBuilder() {
      }

      public ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder feedingMete(final BigDecimal feedingMete) {
         this.feedingMete = feedingMete;
         return this;
      }

      public ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder produceMete(final BigDecimal produceMete) {
         this.produceMete = produceMete;
         return this;
      }

      public ProjectFeedingStateDTO build() {
         return new ProjectFeedingStateDTO(this.dateTime, this.feedingMete, this.produceMete);
      }

      @Override
      public String toString() {
         return "ProjectFeedingStateDTO.ProjectFeedingStateDTOBuilder(dateTime="
            + this.dateTime
            + ", feedingMete="
            + this.feedingMete
            + ", produceMete="
            + this.produceMete
            + ")";
      }
   }
}
