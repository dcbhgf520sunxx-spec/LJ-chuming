package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmFollowUpSimpleListDTO {
   @ApiModelProperty(name = "id", notes = "跟进id")
   private Long id;
   @ApiModelProperty(name = "approveRecordId", notes = "审核id")
   private Long approveRecordId;
   @ApiModelProperty(name = "followUpDate", value = "本次跟进日期", notes = "本次跟进日期")
   private LocalDateTime followUpDate;

   public static CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder builder() {
      return new CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder();
   }

   public CrmFollowUpSimpleListDTO() {
   }

   public CrmFollowUpSimpleListDTO(final Long id, final Long approveRecordId, final LocalDateTime followUpDate) {
      this.id = id;
      this.approveRecordId = approveRecordId;
      this.followUpDate = followUpDate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public LocalDateTime getFollowUpDate() {
      return this.followUpDate;
   }

   public CrmFollowUpSimpleListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmFollowUpSimpleListDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmFollowUpSimpleListDTO setFollowUpDate(final LocalDateTime followUpDate) {
      this.followUpDate = followUpDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmFollowUpSimpleListDTO(id="
         + this.getId()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", followUpDate="
         + this.getFollowUpDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmFollowUpSimpleListDTO)) {
         return false;
      }

      CrmFollowUpSimpleListDTO other = (CrmFollowUpSimpleListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$approveRecordId = this.getApproveRecordId();
         Object other$approveRecordId = other.getApproveRecordId();
         if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
            Object this$followUpDate = this.getFollowUpDate();
            Object other$followUpDate = other.getFollowUpDate();
            return this$followUpDate == null ? other$followUpDate == null : this$followUpDate.equals(other$followUpDate);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmFollowUpSimpleListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $followUpDate = this.getFollowUpDate();
      return result * 59 + ($followUpDate == null ? 43 : $followUpDate.hashCode());
   }

   public static class CrmFollowUpSimpleListDTOBuilder {
      private Long id;
      private Long approveRecordId;
      private LocalDateTime followUpDate;

      CrmFollowUpSimpleListDTOBuilder() {
      }

      public CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder followUpDate(final LocalDateTime followUpDate) {
         this.followUpDate = followUpDate;
         return this;
      }

      public CrmFollowUpSimpleListDTO build() {
         return new CrmFollowUpSimpleListDTO(this.id, this.approveRecordId, this.followUpDate);
      }

      @Override
      public String toString() {
         return "CrmFollowUpSimpleListDTO.CrmFollowUpSimpleListDTOBuilder(id="
            + this.id
            + ", approveRecordId="
            + this.approveRecordId
            + ", followUpDate="
            + this.followUpDate
            + ")";
      }
   }
}
