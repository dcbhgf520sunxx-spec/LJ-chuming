package com.hzchum.scim.mes.building.core.api.pojo._dto.util;

import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "IdAndNameDTO", description = "id和name通用类")
public class IdAndNameDTO extends IdAndNameDO {
   protected IdAndNameDTO(final IdAndNameDTO.IdAndNameDTOBuilder<?, ?> b) {
      super(b);
   }

   public static IdAndNameDTO.IdAndNameDTOBuilder<?, ?> builder() {
      return new IdAndNameDTO.IdAndNameDTOBuilderImpl();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdAndNameDTO)) {
         return false;
      }

      IdAndNameDTO other = (IdAndNameDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof IdAndNameDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "IdAndNameDTO()";
   }

   public abstract static class IdAndNameDTOBuilder<C extends IdAndNameDTO, B extends IdAndNameDTO.IdAndNameDTOBuilder<C, B>>
      extends IdAndNameDO.IdAndNameDOBuilder<C, B> {
      protected abstract B self();

      public abstract C build();

      @Override
      public String toString() {
         return "IdAndNameDTO.IdAndNameDTOBuilder(super=" + super.toString() + ")";
      }
   }

   private static final class IdAndNameDTOBuilderImpl extends IdAndNameDTO.IdAndNameDTOBuilder<IdAndNameDTO, IdAndNameDTO.IdAndNameDTOBuilderImpl> {
      private IdAndNameDTOBuilderImpl() {
      }

      protected IdAndNameDTO.IdAndNameDTOBuilderImpl self() {
         return this;
      }

      @Override
      public IdAndNameDTO build() {
         return new IdAndNameDTO(this);
      }
   }
}
