package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdAndSerialNumberDO", description = "id和SerialNumber通用类")
public class IdAndSerialNumberDO {
   @ApiModelProperty(name = "id", notes = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;

   protected IdAndSerialNumberDO(final IdAndSerialNumberDO.IdAndSerialNumberDOBuilder<?, ?> b) {
      this.id = b.id;
      this.serialNumber = b.serialNumber;
   }

   public static IdAndSerialNumberDO.IdAndSerialNumberDOBuilder<?, ?> builder() {
      return new IdAndSerialNumberDO.IdAndSerialNumberDOBuilderImpl();
   }

   public IdAndSerialNumberDO() {
   }

   public IdAndSerialNumberDO(final Long id, final String serialNumber) {
      this.id = id;
      this.serialNumber = serialNumber;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   @JsonProperty("id")
   public IdAndSerialNumberDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public IdAndSerialNumberDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "IdAndSerialNumberDO(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof IdAndSerialNumberDO)) {
         return false;
      } else {
         IdAndSerialNumberDO other = (IdAndSerialNumberDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdAndSerialNumberDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public abstract static class IdAndSerialNumberDOBuilder<C extends IdAndSerialNumberDO, B extends IdAndSerialNumberDO.IdAndSerialNumberDOBuilder<C, B>> {
      private Long id;
      private String serialNumber;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("id")
      public B id(final Long id) {
         this.id = id;
         return this.self();
      }

      @JsonProperty("serialNumber")
      public B serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this.self();
      }

      @Override
      public String toString() {
         return "IdAndSerialNumberDO.IdAndSerialNumberDOBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ")";
      }
   }

   private static final class IdAndSerialNumberDOBuilderImpl
      extends IdAndSerialNumberDO.IdAndSerialNumberDOBuilder<IdAndSerialNumberDO, IdAndSerialNumberDO.IdAndSerialNumberDOBuilderImpl> {
      private IdAndSerialNumberDOBuilderImpl() {
      }

      protected IdAndSerialNumberDO.IdAndSerialNumberDOBuilderImpl self() {
         return this;
      }

      @Override
      public IdAndSerialNumberDO build() {
         return new IdAndSerialNumberDO(this);
      }
   }
}
