package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("围护产品定额配置DTO")
public class MesEnclosureProductQuotaConfigDTO extends MesEnclosureProductQuotaConfig {
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称List")
   private List<String> workshopNameList;
   private List<MesEnclosureProductQuotaConfigDetailDTO> detailList;

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfigDTO)) {
         return false;
      }

      MesEnclosureProductQuotaConfigDTO other = (MesEnclosureProductQuotaConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$workshopIdList = this.getWorkshopIdList();
      Object other$workshopIdList = other.getWorkshopIdList();
      if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
         Object this$workshopNameList = this.getWorkshopNameList();
         Object other$workshopNameList = other.getWorkshopNameList();
         if (this$workshopNameList == null ? other$workshopNameList == null : this$workshopNameList.equals(other$workshopNameList)) {
            Object this$detailList = this.getDetailList();
            Object other$detailList = other.getDetailList();
            return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      result = result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public List<MesEnclosureProductQuotaConfigDetailDTO> getDetailList() {
      return this.detailList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   public void setDetailList(final List<MesEnclosureProductQuotaConfigDetailDTO> detailList) {
      this.detailList = detailList;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfigDTO(workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
