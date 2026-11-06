package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FactoryDO", description = "工厂信息")
public class FactoryDetailDO {
   @ApiModelProperty(name = "id", notes = "工厂id", value = "工厂id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工厂名", value = "工厂名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static FactoryDetailDO.FactoryDetailDOBuilder builder() {
      return new FactoryDetailDO.FactoryDetailDOBuilder();
   }

   public FactoryDetailDO() {
   }

   public FactoryDetailDO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public FactoryDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public FactoryDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "FactoryDetailDO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FactoryDetailDO)) {
         return false;
      } else {
         FactoryDetailDO other = (FactoryDetailDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FactoryDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class FactoryDetailDOBuilder {
      private Long id;
      private String name;

      FactoryDetailDOBuilder() {
      }

      @JsonProperty("id")
      public FactoryDetailDO.FactoryDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public FactoryDetailDO.FactoryDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public FactoryDetailDO build() {
         return new FactoryDetailDO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "FactoryDetailDO.FactoryDetailDOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
