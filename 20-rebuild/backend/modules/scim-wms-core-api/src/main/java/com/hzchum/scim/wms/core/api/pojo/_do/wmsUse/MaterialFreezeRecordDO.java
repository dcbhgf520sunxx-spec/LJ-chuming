package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

public class MaterialFreezeRecordDO extends MaterialFreezeRecord {
   private String idList;

   public String getIdList() {
      return this.idList;
   }

   public void setIdList(final String idList) {
      this.idList = idList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreezeRecordDO)) {
         return false;
      }

      MaterialFreezeRecordDO other = (MaterialFreezeRecordDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$idList = this.getIdList();
      Object other$idList = other.getIdList();
      return this$idList == null ? other$idList == null : this$idList.equals(other$idList);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MaterialFreezeRecordDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $idList = this.getIdList();
      return result * 59 + ($idList == null ? 43 : $idList.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialFreezeRecordDO(idList=" + this.getIdList() + ")";
   }

   public MaterialFreezeRecordDO(final String idList) {
      this.idList = idList;
   }
}
