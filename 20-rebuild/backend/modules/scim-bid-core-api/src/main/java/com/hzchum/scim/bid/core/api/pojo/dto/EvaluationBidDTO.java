package com.hzchum.scim.bid.core.api.pojo.dto;

import com.hzchum.scim.bid.core.api.pojo.vo.CommonVO;
import java.util.List;
import javax.validation.constraints.NotNull;

public class EvaluationBidDTO {
   @NotNull(message = "id不能为空")
   private Long projectSubjectId;
   private Long supplierId;
   private Long offerDetailId;
   private List<CommonVO> weedOuts;
   private List<CommonVO> nextRounds;

   public static EvaluationBidDTO.EvaluationBidDTOBuilder builder() {
      return new EvaluationBidDTO.EvaluationBidDTOBuilder();
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getOfferDetailId() {
      return this.offerDetailId;
   }

   public List<CommonVO> getWeedOuts() {
      return this.weedOuts;
   }

   public List<CommonVO> getNextRounds() {
      return this.nextRounds;
   }

   public void setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOfferDetailId(final Long offerDetailId) {
      this.offerDetailId = offerDetailId;
   }

   public void setWeedOuts(final List<CommonVO> weedOuts) {
      this.weedOuts = weedOuts;
   }

   public void setNextRounds(final List<CommonVO> nextRounds) {
      this.nextRounds = nextRounds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EvaluationBidDTO)) {
         return false;
      }

      EvaluationBidDTO other = (EvaluationBidDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectSubjectId = this.getProjectSubjectId();
      Object other$projectSubjectId = other.getProjectSubjectId();
      if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$offerDetailId = this.getOfferDetailId();
            Object other$offerDetailId = other.getOfferDetailId();
            if (this$offerDetailId == null ? other$offerDetailId == null : this$offerDetailId.equals(other$offerDetailId)) {
               Object this$weedOuts = this.getWeedOuts();
               Object other$weedOuts = other.getWeedOuts();
               if (this$weedOuts == null ? other$weedOuts == null : this$weedOuts.equals(other$weedOuts)) {
                  Object this$nextRounds = this.getNextRounds();
                  Object other$nextRounds = other.getNextRounds();
                  return this$nextRounds == null ? other$nextRounds == null : this$nextRounds.equals(other$nextRounds);
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
      return other instanceof EvaluationBidDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $offerDetailId = this.getOfferDetailId();
      result = result * 59 + ($offerDetailId == null ? 43 : $offerDetailId.hashCode());
      Object $weedOuts = this.getWeedOuts();
      result = result * 59 + ($weedOuts == null ? 43 : $weedOuts.hashCode());
      Object $nextRounds = this.getNextRounds();
      return result * 59 + ($nextRounds == null ? 43 : $nextRounds.hashCode());
   }

   @Override
   public String toString() {
      return "EvaluationBidDTO(projectSubjectId="
         + this.getProjectSubjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", offerDetailId="
         + this.getOfferDetailId()
         + ", weedOuts="
         + this.getWeedOuts()
         + ", nextRounds="
         + this.getNextRounds()
         + ")";
   }

   public EvaluationBidDTO() {
   }

   public EvaluationBidDTO(
      final Long projectSubjectId, final Long supplierId, final Long offerDetailId, final List<CommonVO> weedOuts, final List<CommonVO> nextRounds
   ) {
      this.projectSubjectId = projectSubjectId;
      this.supplierId = supplierId;
      this.offerDetailId = offerDetailId;
      this.weedOuts = weedOuts;
      this.nextRounds = nextRounds;
   }

   public static class EvaluationBidDTOBuilder {
      private Long projectSubjectId;
      private Long supplierId;
      private Long offerDetailId;
      private List<CommonVO> weedOuts;
      private List<CommonVO> nextRounds;

      EvaluationBidDTOBuilder() {
      }

      public EvaluationBidDTO.EvaluationBidDTOBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      public EvaluationBidDTO.EvaluationBidDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public EvaluationBidDTO.EvaluationBidDTOBuilder offerDetailId(final Long offerDetailId) {
         this.offerDetailId = offerDetailId;
         return this;
      }

      public EvaluationBidDTO.EvaluationBidDTOBuilder weedOuts(final List<CommonVO> weedOuts) {
         this.weedOuts = weedOuts;
         return this;
      }

      public EvaluationBidDTO.EvaluationBidDTOBuilder nextRounds(final List<CommonVO> nextRounds) {
         this.nextRounds = nextRounds;
         return this;
      }

      public EvaluationBidDTO build() {
         return new EvaluationBidDTO(this.projectSubjectId, this.supplierId, this.offerDetailId, this.weedOuts, this.nextRounds);
      }

      @Override
      public String toString() {
         return "EvaluationBidDTO.EvaluationBidDTOBuilder(projectSubjectId="
            + this.projectSubjectId
            + ", supplierId="
            + this.supplierId
            + ", offerDetailId="
            + this.offerDetailId
            + ", weedOuts="
            + this.weedOuts
            + ", nextRounds="
            + this.nextRounds
            + ")";
      }
   }
}
