package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;
import java.util.Map;

public class InboundQualityTestingDTOParam {
   private Long inboundId;
   private String qualityTestingRemark;
   private List<Long> attachments;
   private Map<Long, Integer> detail;

   public static InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder builder() {
      return new InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder();
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getQualityTestingRemark() {
      return this.qualityTestingRemark;
   }

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public Map<Long, Integer> getDetail() {
      return this.detail;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setQualityTestingRemark(final String qualityTestingRemark) {
      this.qualityTestingRemark = qualityTestingRemark;
   }

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   public void setDetail(final Map<Long, Integer> detail) {
      this.detail = detail;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundQualityTestingDTOParam)) {
         return false;
      }

      InboundQualityTestingDTOParam other = (InboundQualityTestingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundId = this.getInboundId();
      Object other$inboundId = other.getInboundId();
      if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
         Object this$qualityTestingRemark = this.getQualityTestingRemark();
         Object other$qualityTestingRemark = other.getQualityTestingRemark();
         if (this$qualityTestingRemark == null ? other$qualityTestingRemark == null : this$qualityTestingRemark.equals(other$qualityTestingRemark)) {
            Object this$attachments = this.getAttachments();
            Object other$attachments = other.getAttachments();
            if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
               Object this$detail = this.getDetail();
               Object other$detail = other.getDetail();
               return this$detail == null ? other$detail == null : this$detail.equals(other$detail);
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
      return other instanceof InboundQualityTestingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $qualityTestingRemark = this.getQualityTestingRemark();
      result = result * 59 + ($qualityTestingRemark == null ? 43 : $qualityTestingRemark.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $detail = this.getDetail();
      return result * 59 + ($detail == null ? 43 : $detail.hashCode());
   }

   @Override
   public String toString() {
      return "InboundQualityTestingDTOParam(inboundId="
         + this.getInboundId()
         + ", qualityTestingRemark="
         + this.getQualityTestingRemark()
         + ", attachments="
         + this.getAttachments()
         + ", detail="
         + this.getDetail()
         + ")";
   }

   public InboundQualityTestingDTOParam(final Long inboundId, final String qualityTestingRemark, final List<Long> attachments, final Map<Long, Integer> detail) {
      this.inboundId = inboundId;
      this.qualityTestingRemark = qualityTestingRemark;
      this.attachments = attachments;
      this.detail = detail;
   }

   public InboundQualityTestingDTOParam() {
   }

   public static class InboundQualityTestingDTOParamBuilder {
      private Long inboundId;
      private String qualityTestingRemark;
      private List<Long> attachments;
      private Map<Long, Integer> detail;

      InboundQualityTestingDTOParamBuilder() {
      }

      public InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder qualityTestingRemark(final String qualityTestingRemark) {
         this.qualityTestingRemark = qualityTestingRemark;
         return this;
      }

      public InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder attachments(final List<Long> attachments) {
         this.attachments = attachments;
         return this;
      }

      public InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder detail(final Map<Long, Integer> detail) {
         this.detail = detail;
         return this;
      }

      public InboundQualityTestingDTOParam build() {
         return new InboundQualityTestingDTOParam(this.inboundId, this.qualityTestingRemark, this.attachments, this.detail);
      }

      @Override
      public String toString() {
         return "InboundQualityTestingDTOParam.InboundQualityTestingDTOParamBuilder(inboundId="
            + this.inboundId
            + ", qualityTestingRemark="
            + this.qualityTestingRemark
            + ", attachments="
            + this.attachments
            + ", detail="
            + this.detail
            + ")";
      }
   }
}
