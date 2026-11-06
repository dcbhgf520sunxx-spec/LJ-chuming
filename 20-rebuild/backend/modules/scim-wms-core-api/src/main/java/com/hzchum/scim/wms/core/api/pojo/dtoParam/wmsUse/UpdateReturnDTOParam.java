package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;
import javax.validation.constraints.NotNull;

public class UpdateReturnDTOParam {
   private Long id;
   @NotNull(message = "退库目的地不能为空")
   private Integer returnDestination;
   private List<MaterialReturnDTOParam> list;

   public static UpdateReturnDTOParam.UpdateReturnDTOParamBuilder builder() {
      return new UpdateReturnDTOParam.UpdateReturnDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getReturnDestination() {
      return this.returnDestination;
   }

   public List<MaterialReturnDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReturnDestination(final Integer returnDestination) {
      this.returnDestination = returnDestination;
   }

   public void setList(final List<MaterialReturnDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateReturnDTOParam)) {
         return false;
      }

      UpdateReturnDTOParam other = (UpdateReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$returnDestination = this.getReturnDestination();
         Object other$returnDestination = other.getReturnDestination();
         if (this$returnDestination == null ? other$returnDestination == null : this$returnDestination.equals(other$returnDestination)) {
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
      return other instanceof UpdateReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $returnDestination = this.getReturnDestination();
      result = result * 59 + ($returnDestination == null ? 43 : $returnDestination.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateReturnDTOParam(id=" + this.getId() + ", returnDestination=" + this.getReturnDestination() + ", list=" + this.getList() + ")";
   }

   public UpdateReturnDTOParam(final Long id, final Integer returnDestination, final List<MaterialReturnDTOParam> list) {
      this.id = id;
      this.returnDestination = returnDestination;
      this.list = list;
   }

   public UpdateReturnDTOParam() {
   }

   public static class UpdateReturnDTOParamBuilder {
      private Long id;
      private Integer returnDestination;
      private List<MaterialReturnDTOParam> list;

      UpdateReturnDTOParamBuilder() {
      }

      public UpdateReturnDTOParam.UpdateReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public UpdateReturnDTOParam.UpdateReturnDTOParamBuilder returnDestination(final Integer returnDestination) {
         this.returnDestination = returnDestination;
         return this;
      }

      public UpdateReturnDTOParam.UpdateReturnDTOParamBuilder list(final List<MaterialReturnDTOParam> list) {
         this.list = list;
         return this;
      }

      public UpdateReturnDTOParam build() {
         return new UpdateReturnDTOParam(this.id, this.returnDestination, this.list);
      }

      @Override
      public String toString() {
         return "UpdateReturnDTOParam.UpdateReturnDTOParamBuilder(id="
            + this.id
            + ", returnDestination="
            + this.returnDestination
            + ", list="
            + this.list
            + ")";
      }
   }
}
