package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesPaintingQuotaConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("涂装定额配置DTO")
public class MesPaintingQuotaConfigDTO extends MesPaintingQuotaConfig {
   @ApiModelProperty("车间ID列表")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称列表")
   private List<String> workshopNameList;

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList == null && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesPaintingQuotaConfigDTO)) {
         return false;
      } else {
         MesPaintingQuotaConfigDTO other = (MesPaintingQuotaConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$workshopIdList = this.getWorkshopIdList();
            Object other$workshopIdList = other.getWorkshopIdList();
            if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
               Object this$workshopNameList = this.getWorkshopNameList();
               Object other$workshopNameList = other.getWorkshopNameList();
               return this$workshopNameList == null ? other$workshopNameList == null : this$workshopNameList.equals(other$workshopNameList);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesPaintingQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      return result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingQuotaConfigDTO(super="
         + super.toString()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ")";
   }
}
