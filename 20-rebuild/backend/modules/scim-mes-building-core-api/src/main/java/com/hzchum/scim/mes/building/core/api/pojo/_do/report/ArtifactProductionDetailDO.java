package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("构件生产详情")
public class ArtifactProductionDetailDO extends ArtifactBaseInfo {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("生产日期")
   private LocalDateTime createTime;

   @Override
   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   @Override
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactProductionDetailDO)) {
         return false;
      }

      ArtifactProductionDetailDO other = (ArtifactProductionDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactProductionDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactProductionDetailDO(createTime=" + this.getCreateTime() + ")";
   }
}
