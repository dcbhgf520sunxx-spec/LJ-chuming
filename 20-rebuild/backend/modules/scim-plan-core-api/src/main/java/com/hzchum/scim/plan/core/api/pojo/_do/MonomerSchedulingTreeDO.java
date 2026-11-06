package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MonomerSchedulingDetailDO", description = "单体信息 ")
public class MonomerSchedulingTreeDO {
   @ApiModelProperty(name = "id", notes = "单体id", value = "单体id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名", value = "单体名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "areaSchedulingDetailDO", notes = "区域信息")
   @JsonProperty("areaSchedulingDetailDO")
   @JSONField(name = "areaSchedulingDetailDO")
   private List<AreaSchedulingTreeDO> areaSchedulingTreeDO;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AreaSchedulingTreeDO> getAreaSchedulingTreeDO() {
      return this.areaSchedulingTreeDO;
   }

   @JsonProperty("id")
   public MonomerSchedulingTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MonomerSchedulingTreeDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("areaSchedulingDetailDO")
   public MonomerSchedulingTreeDO setAreaSchedulingTreeDO(final List<AreaSchedulingTreeDO> areaSchedulingTreeDO) {
      this.areaSchedulingTreeDO = areaSchedulingTreeDO;
      return this;
   }

   @Override
   public String toString() {
      return "MonomerSchedulingTreeDO(id=" + this.getId() + ", name=" + this.getName() + ", areaSchedulingTreeDO=" + this.getAreaSchedulingTreeDO() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerSchedulingTreeDO)) {
         return false;
      }

      MonomerSchedulingTreeDO other = (MonomerSchedulingTreeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$areaSchedulingTreeDO = this.getAreaSchedulingTreeDO();
            Object other$areaSchedulingTreeDO = other.getAreaSchedulingTreeDO();
            return this$areaSchedulingTreeDO == null ? other$areaSchedulingTreeDO == null : this$areaSchedulingTreeDO.equals(other$areaSchedulingTreeDO);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerSchedulingTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $areaSchedulingTreeDO = this.getAreaSchedulingTreeDO();
      return result * 59 + ($areaSchedulingTreeDO == null ? 43 : $areaSchedulingTreeDO.hashCode());
   }
}
