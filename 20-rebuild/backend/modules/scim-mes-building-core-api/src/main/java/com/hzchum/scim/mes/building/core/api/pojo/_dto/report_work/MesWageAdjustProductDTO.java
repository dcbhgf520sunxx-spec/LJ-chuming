package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("工价调整产品DTO")
public class MesWageAdjustProductDTO extends MesWageAdjustProduct {
   @ApiModelProperty("产品信息")
   private ProductInfo product;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("班组ids")
   private String teamIds;
   @ApiModelProperty("班组id列表")
   private List<Long> teamIdList;

   public List<Long> getTeamIdList() {
      return CollUtil.isEmpty(this.teamIdList) && StrUtil.isNotBlank(this.teamIds) ? Convert.toList(Long.class, this.teamIds.split(",")) : this.teamIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustProductDTO)) {
         return false;
      }

      MesWageAdjustProductDTO other = (MesWageAdjustProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$product = this.getProduct();
            Object other$product = other.getProduct();
            if (this$product == null ? other$product == null : this$product.equals(other$product)) {
               Object this$teamIds = this.getTeamIds();
               Object other$teamIds = other.getTeamIds();
               if (this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds)) {
                  Object this$teamIdList = this.getTeamIdList();
                  Object other$teamIdList = other.getTeamIdList();
                  return this$teamIdList == null ? other$teamIdList == null : this$teamIdList.equals(other$teamIdList);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $teamIds = this.getTeamIds();
      result = result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
      Object $teamIdList = this.getTeamIdList();
      return result * 59 + ($teamIdList == null ? 43 : $teamIdList.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustProductDTO(super="
         + super.toString()
         + ", product="
         + this.getProduct()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamIds="
         + this.getTeamIds()
         + ", teamIdList="
         + this.getTeamIdList()
         + ")";
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getTeamIds() {
      return this.teamIds;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamIds(final String teamIds) {
      this.teamIds = teamIds;
   }

   public void setTeamIdList(final List<Long> teamIdList) {
      this.teamIdList = teamIdList;
   }
}
