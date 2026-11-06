package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("涂装定额配置新增修改Param")
public class MesPaintingQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty("车间IDs")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("漆膜厚度基数(µm)")
   @NotNull(groups = {Add.class, Update.class}, message = "漆膜厚度基数不能为空")
   private BigDecimal paintFilmThicknessBase;
   @ApiModelProperty("起步单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起步单价不能为空")
   private BigDecimal startPrice;
   @ApiModelProperty("起加漆膜厚度(µm)")
   @NotNull(groups = {Add.class, Update.class}, message = "起加漆膜厚度不能为空")
   private BigDecimal startAddPaintFilmThickness;
   @ApiModelProperty("起加单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起加单价不能为空")
   private BigDecimal startAddPrice;

   public Long getId() {
      return this.id;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public BigDecimal getPaintFilmThicknessBase() {
      return this.paintFilmThicknessBase;
   }

   public BigDecimal getStartPrice() {
      return this.startPrice;
   }

   public BigDecimal getStartAddPaintFilmThickness() {
      return this.startAddPaintFilmThickness;
   }

   public BigDecimal getStartAddPrice() {
      return this.startAddPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setPaintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
      this.paintFilmThicknessBase = paintFilmThicknessBase;
   }

   public void setStartPrice(final BigDecimal startPrice) {
      this.startPrice = startPrice;
   }

   public void setStartAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
   }

   public void setStartAddPrice(final BigDecimal startAddPrice) {
      this.startAddPrice = startAddPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingQuotaConfigParam)) {
         return false;
      }

      MesPaintingQuotaConfigParam other = (MesPaintingQuotaConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopIdList = this.getWorkshopIdList();
         Object other$workshopIdList = other.getWorkshopIdList();
         if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
            Object this$paintFilmThicknessBase = this.getPaintFilmThicknessBase();
            Object other$paintFilmThicknessBase = other.getPaintFilmThicknessBase();
            if (this$paintFilmThicknessBase == null ? other$paintFilmThicknessBase == null : this$paintFilmThicknessBase.equals(other$paintFilmThicknessBase)) {
               Object this$startPrice = this.getStartPrice();
               Object other$startPrice = other.getStartPrice();
               if (this$startPrice == null ? other$startPrice == null : this$startPrice.equals(other$startPrice)) {
                  Object this$startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
                  Object other$startAddPaintFilmThickness = other.getStartAddPaintFilmThickness();
                  if (this$startAddPaintFilmThickness == null
                     ? other$startAddPaintFilmThickness == null
                     : this$startAddPaintFilmThickness.equals(other$startAddPaintFilmThickness)) {
                     Object this$startAddPrice = this.getStartAddPrice();
                     Object other$startAddPrice = other.getStartAddPrice();
                     return this$startAddPrice == null ? other$startAddPrice == null : this$startAddPrice.equals(other$startAddPrice);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesPaintingQuotaConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $paintFilmThicknessBase = this.getPaintFilmThicknessBase();
      result = result * 59 + ($paintFilmThicknessBase == null ? 43 : $paintFilmThicknessBase.hashCode());
      Object $startPrice = this.getStartPrice();
      result = result * 59 + ($startPrice == null ? 43 : $startPrice.hashCode());
      Object $startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
      result = result * 59 + ($startAddPaintFilmThickness == null ? 43 : $startAddPaintFilmThickness.hashCode());
      Object $startAddPrice = this.getStartAddPrice();
      return result * 59 + ($startAddPrice == null ? 43 : $startAddPrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingQuotaConfigParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", paintFilmThicknessBase="
         + this.getPaintFilmThicknessBase()
         + ", startPrice="
         + this.getStartPrice()
         + ", startAddPaintFilmThickness="
         + this.getStartAddPaintFilmThickness()
         + ", startAddPrice="
         + this.getStartAddPrice()
         + ")";
   }
}
