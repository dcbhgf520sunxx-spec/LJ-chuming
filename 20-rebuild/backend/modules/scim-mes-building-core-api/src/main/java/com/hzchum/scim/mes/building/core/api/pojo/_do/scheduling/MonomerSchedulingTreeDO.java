package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MonomerSchedulingDetailDO", description = "单体信息 ")
public class MonomerSchedulingTreeDO extends MonomerDetailDO {
   @ApiModelProperty(name = "areaSchedulingDetailDO", notes = "区域信息")
   @JsonProperty("areaSchedulingDetailDO")
   @JSONField(name = "areaSchedulingDetailDO")
   private List<AreaSchedulingTreeDO> areaSchedulingTreeDO;

   public List<AreaSchedulingTreeDO> getAreaSchedulingTreeDO() {
      return this.areaSchedulingTreeDO;
   }

   @JsonProperty("areaSchedulingDetailDO")
   public MonomerSchedulingTreeDO setAreaSchedulingTreeDO(final List<AreaSchedulingTreeDO> areaSchedulingTreeDO) {
      this.areaSchedulingTreeDO = areaSchedulingTreeDO;
      return this;
   }

   @Override
   public String toString() {
      return "MonomerSchedulingTreeDO(areaSchedulingTreeDO=" + this.getAreaSchedulingTreeDO() + ")";
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

      Object this$areaSchedulingTreeDO = this.getAreaSchedulingTreeDO();
      Object other$areaSchedulingTreeDO = other.getAreaSchedulingTreeDO();
      return this$areaSchedulingTreeDO == null ? other$areaSchedulingTreeDO == null : this$areaSchedulingTreeDO.equals(other$areaSchedulingTreeDO);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MonomerSchedulingTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaSchedulingTreeDO = this.getAreaSchedulingTreeDO();
      return result * 59 + ($areaSchedulingTreeDO == null ? 43 : $areaSchedulingTreeDO.hashCode());
   }
}
