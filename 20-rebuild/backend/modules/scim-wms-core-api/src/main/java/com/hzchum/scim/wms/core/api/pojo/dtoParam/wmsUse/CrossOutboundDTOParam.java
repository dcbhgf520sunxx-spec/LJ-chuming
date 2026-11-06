package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import java.util.List;

public class CrossOutboundDTOParam {
   private Long projectId;
   private Long recipientId;
   private List<MaterialInventory> list;

   public static CrossOutboundDTOParam.CrossOutboundDTOParamBuilder builder() {
      return new CrossOutboundDTOParam.CrossOutboundDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public List<MaterialInventory> getList() {
      return this.list;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setList(final List<MaterialInventory> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrossOutboundDTOParam)) {
         return false;
      }

      CrossOutboundDTOParam other = (CrossOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$recipientId = this.getRecipientId();
         Object other$recipientId = other.getRecipientId();
         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
            Object this$list = this.getList();
            Object other$list = other.getList();
            return this$list == null ? other$list == null : this$list.equals(other$list);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrossOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "CrossOutboundDTOParam(projectId=" + this.getProjectId() + ", recipientId=" + this.getRecipientId() + ", list=" + this.getList() + ")";
   }

   public CrossOutboundDTOParam(final Long projectId, final Long recipientId, final List<MaterialInventory> list) {
      this.projectId = projectId;
      this.recipientId = recipientId;
      this.list = list;
   }

   public CrossOutboundDTOParam() {
   }

   public static class CrossOutboundDTOParamBuilder {
      private Long projectId;
      private Long recipientId;
      private List<MaterialInventory> list;

      CrossOutboundDTOParamBuilder() {
      }

      public CrossOutboundDTOParam.CrossOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public CrossOutboundDTOParam.CrossOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public CrossOutboundDTOParam.CrossOutboundDTOParamBuilder list(final List<MaterialInventory> list) {
         this.list = list;
         return this;
      }

      public CrossOutboundDTOParam build() {
         return new CrossOutboundDTOParam(this.projectId, this.recipientId, this.list);
      }

      @Override
      public String toString() {
         return "CrossOutboundDTOParam.CrossOutboundDTOParamBuilder(projectId="
            + this.projectId
            + ", recipientId="
            + this.recipientId
            + ", list="
            + this.list
            + ")";
      }
   }
}
