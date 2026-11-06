package com.hzchum.scim.common.core.api.pojo.common;

import java.util.List;

public class IdsStatusDTO {
   private List<Long> ids;
   private String idsStr;
   private Boolean status;
   private Long dataId;
   private Integer dataType;

   public static IdsStatusDTO.IdsStatusDTOBuilder builder() {
      return new IdsStatusDTO.IdsStatusDTOBuilder();
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public String getIdsStr() {
      return this.idsStr;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setIdsStr(final String idsStr) {
      this.idsStr = idsStr;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setDataId(final Long dataId) {
      this.dataId = dataId;
   }

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdsStatusDTO)) {
         return false;
      }

      IdsStatusDTO other = (IdsStatusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$dataId = this.getDataId();
         Object other$dataId = other.getDataId();
         if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
            Object this$dataType = this.getDataType();
            Object other$dataType = other.getDataType();
            if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
               Object this$ids = this.getIds();
               Object other$ids = other.getIds();
               if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
                  Object this$idsStr = this.getIdsStr();
                  Object other$idsStr = other.getIdsStr();
                  return this$idsStr == null ? other$idsStr == null : this$idsStr.equals(other$idsStr);
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
      return other instanceof IdsStatusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $idsStr = this.getIdsStr();
      return result * 59 + ($idsStr == null ? 43 : $idsStr.hashCode());
   }

   @Override
   public String toString() {
      return "IdsStatusDTO(ids="
         + this.getIds()
         + ", idsStr="
         + this.getIdsStr()
         + ", status="
         + this.getStatus()
         + ", dataId="
         + this.getDataId()
         + ", dataType="
         + this.getDataType()
         + ")";
   }

   public IdsStatusDTO() {
   }

   public IdsStatusDTO(final List<Long> ids, final String idsStr, final Boolean status, final Long dataId, final Integer dataType) {
      this.ids = ids;
      this.idsStr = idsStr;
      this.status = status;
      this.dataId = dataId;
      this.dataType = dataType;
   }

   public static class IdsStatusDTOBuilder {
      private List<Long> ids;
      private String idsStr;
      private Boolean status;
      private Long dataId;
      private Integer dataType;

      IdsStatusDTOBuilder() {
      }

      public IdsStatusDTO.IdsStatusDTOBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public IdsStatusDTO.IdsStatusDTOBuilder idsStr(final String idsStr) {
         this.idsStr = idsStr;
         return this;
      }

      public IdsStatusDTO.IdsStatusDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public IdsStatusDTO.IdsStatusDTOBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public IdsStatusDTO.IdsStatusDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public IdsStatusDTO build() {
         return new IdsStatusDTO(this.ids, this.idsStr, this.status, this.dataId, this.dataType);
      }

      @Override
      public String toString() {
         return "IdsStatusDTO.IdsStatusDTOBuilder(ids="
            + this.ids
            + ", idsStr="
            + this.idsStr
            + ", status="
            + this.status
            + ", dataId="
            + this.dataId
            + ", dataType="
            + this.dataType
            + ")";
      }
   }
}
