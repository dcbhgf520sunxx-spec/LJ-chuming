package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaSchedulingDetailDO", description = "区域排期信息 ")
public class AreaSchedulingTreeDO {
   @ApiModelProperty(name = "id", notes = "区域id", value = "区域id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "区域名", value = "区域id")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public AreaSchedulingTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public AreaSchedulingTreeDO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "AreaSchedulingTreeDO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AreaSchedulingTreeDO)) {
         return false;
      } else {
         AreaSchedulingTreeDO other = (AreaSchedulingTreeDO)o;
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
      return other instanceof AreaSchedulingTreeDO;
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
}
