package com.hzchum.scim.mes.enclosure.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdAndNameDO", description = "id和name通用类")
public class IdAndNameDO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "leaderId", notes = "班组长id")
   @JsonProperty("leaderId")
   @JSONField(name = "leaderId")
   private Long leaderId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   protected IdAndNameDO(final IdAndNameDO.IdAndNameDOBuilder<?, ?> b) {
      this.id = b.id;
      this.leaderId = b.leaderId;
      this.name = b.name;
   }

   public static IdAndNameDO.IdAndNameDOBuilder<?, ?> builder() {
      return new IdAndNameDO.IdAndNameDOBuilderImpl();
   }

   public IdAndNameDO() {
   }

   public IdAndNameDO(final Long id, final Long leaderId, final String name) {
      this.id = id;
      this.leaderId = leaderId;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLeaderId() {
      return this.leaderId;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public IdAndNameDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("leaderId")
   public IdAndNameDO setLeaderId(final Long leaderId) {
      this.leaderId = leaderId;
      return this;
   }

   @JsonProperty("name")
   public IdAndNameDO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "IdAndNameDO(id=" + this.getId() + ", leaderId=" + this.getLeaderId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdAndNameDO)) {
         return false;
      }

      IdAndNameDO other = (IdAndNameDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$leaderId = this.getLeaderId();
         Object other$leaderId = other.getLeaderId();
         if (this$leaderId == null ? other$leaderId == null : this$leaderId.equals(other$leaderId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdAndNameDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $leaderId = this.getLeaderId();
      result = result * 59 + ($leaderId == null ? 43 : $leaderId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public abstract static class IdAndNameDOBuilder<C extends IdAndNameDO, B extends IdAndNameDO.IdAndNameDOBuilder<C, B>> {
      private Long id;
      private Long leaderId;
      private String name;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("id")
      public B id(final Long id) {
         this.id = id;
         return this.self();
      }

      @JsonProperty("leaderId")
      public B leaderId(final Long leaderId) {
         this.leaderId = leaderId;
         return this.self();
      }

      @JsonProperty("name")
      public B name(final String name) {
         this.name = name;
         return this.self();
      }

      @Override
      public String toString() {
         return "IdAndNameDO.IdAndNameDOBuilder(id=" + this.id + ", leaderId=" + this.leaderId + ", name=" + this.name + ")";
      }
   }

   private static final class IdAndNameDOBuilderImpl extends IdAndNameDO.IdAndNameDOBuilder<IdAndNameDO, IdAndNameDO.IdAndNameDOBuilderImpl> {
      private IdAndNameDOBuilderImpl() {
      }

      protected IdAndNameDO.IdAndNameDOBuilderImpl self() {
         return this;
      }

      @Override
      public IdAndNameDO build() {
         return new IdAndNameDO(this);
      }
   }
}
