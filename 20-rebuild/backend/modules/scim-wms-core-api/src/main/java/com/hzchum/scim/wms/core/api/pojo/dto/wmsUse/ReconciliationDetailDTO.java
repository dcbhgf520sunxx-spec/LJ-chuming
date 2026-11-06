package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.time.LocalDateTime;

public class ReconciliationDetailDTO {
   private Long id;
   private Long purchaseId;
   private Long purchaseDetailId;
   private Integer type;
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReconciliationDetailDTO)) {
         return false;
      }

      ReconciliationDetailDTO other = (ReconciliationDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$purchaseDetailId = this.getPurchaseDetailId();
            Object other$purchaseDetailId = other.getPurchaseDetailId();
            if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReconciliationDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ReconciliationDetailDTO(id="
         + this.getId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", type="
         + this.getType()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public ReconciliationDetailDTO(final Long id, final Long purchaseId, final Long purchaseDetailId, final Integer type, final LocalDateTime createTime) {
      this.id = id;
      this.purchaseId = purchaseId;
      this.purchaseDetailId = purchaseDetailId;
      this.type = type;
      this.createTime = createTime;
   }

   public ReconciliationDetailDTO() {
   }
}
