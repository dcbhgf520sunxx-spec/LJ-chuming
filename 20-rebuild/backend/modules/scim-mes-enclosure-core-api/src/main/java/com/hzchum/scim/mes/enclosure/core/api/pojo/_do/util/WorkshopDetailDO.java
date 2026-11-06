package com.hzchum.scim.mes.enclosure.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WorkshopDO", description = "工厂信息")
public class WorkshopDetailDO {
   @ApiModelProperty(name = "id", notes = "车间id", value = "车间id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static WorkshopDetailDO.WorkshopDetailDOBuilder builder() {
      return new WorkshopDetailDO.WorkshopDetailDOBuilder();
   }

   public WorkshopDetailDO() {
   }

   public WorkshopDetailDO(final Long id, final String name) {
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
   public WorkshopDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public WorkshopDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopDetailDO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WorkshopDetailDO)) {
         return false;
      } else {
         WorkshopDetailDO other = (WorkshopDetailDO)o;
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
      return other instanceof WorkshopDetailDO;
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

   public static class WorkshopDetailDOBuilder {
      private Long id;
      private String name;

      WorkshopDetailDOBuilder() {
      }

      @JsonProperty("id")
      public WorkshopDetailDO.WorkshopDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public WorkshopDetailDO.WorkshopDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WorkshopDetailDO build() {
         return new WorkshopDetailDO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "WorkshopDetailDO.WorkshopDetailDOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
