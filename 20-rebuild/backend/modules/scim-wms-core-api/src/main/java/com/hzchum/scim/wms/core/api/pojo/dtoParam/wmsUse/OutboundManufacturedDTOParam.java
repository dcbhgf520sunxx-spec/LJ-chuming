package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class OutboundManufacturedDTOParam {
   private Long id;
   private Boolean boolSubmitCheck;
   private Integer reviewStatus;
   private List<OutboundDetailManufacturedDTOParam> list;

   public static OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder builder() {
      return new OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolSubmitCheck() {
      return this.boolSubmitCheck;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public List<OutboundDetailManufacturedDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolSubmitCheck(final Boolean boolSubmitCheck) {
      this.boolSubmitCheck = boolSubmitCheck;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setList(final List<OutboundDetailManufacturedDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundManufacturedDTOParam)) {
         return false;
      }

      OutboundManufacturedDTOParam other = (OutboundManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSubmitCheck = this.getBoolSubmitCheck();
         Object other$boolSubmitCheck = other.getBoolSubmitCheck();
         if (this$boolSubmitCheck == null ? other$boolSubmitCheck == null : this$boolSubmitCheck.equals(other$boolSubmitCheck)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof OutboundManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSubmitCheck = this.getBoolSubmitCheck();
      result = result * 59 + ($boolSubmitCheck == null ? 43 : $boolSubmitCheck.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundManufacturedDTOParam(id="
         + this.getId()
         + ", boolSubmitCheck="
         + this.getBoolSubmitCheck()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", list="
         + this.getList()
         + ")";
   }

   public OutboundManufacturedDTOParam(
      final Long id, final Boolean boolSubmitCheck, final Integer reviewStatus, final List<OutboundDetailManufacturedDTOParam> list
   ) {
      this.id = id;
      this.boolSubmitCheck = boolSubmitCheck;
      this.reviewStatus = reviewStatus;
      this.list = list;
   }

   public OutboundManufacturedDTOParam() {
   }

   public static class OutboundManufacturedDTOParamBuilder {
      private Long id;
      private Boolean boolSubmitCheck;
      private Integer reviewStatus;
      private List<OutboundDetailManufacturedDTOParam> list;

      OutboundManufacturedDTOParamBuilder() {
      }

      public OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder boolSubmitCheck(final Boolean boolSubmitCheck) {
         this.boolSubmitCheck = boolSubmitCheck;
         return this;
      }

      public OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder list(final List<OutboundDetailManufacturedDTOParam> list) {
         this.list = list;
         return this;
      }

      public OutboundManufacturedDTOParam build() {
         return new OutboundManufacturedDTOParam(this.id, this.boolSubmitCheck, this.reviewStatus, this.list);
      }

      @Override
      public String toString() {
         return "OutboundManufacturedDTOParam.OutboundManufacturedDTOParamBuilder(id="
            + this.id
            + ", boolSubmitCheck="
            + this.boolSubmitCheck
            + ", reviewStatus="
            + this.reviewStatus
            + ", list="
            + this.list
            + ")";
      }
   }
}
