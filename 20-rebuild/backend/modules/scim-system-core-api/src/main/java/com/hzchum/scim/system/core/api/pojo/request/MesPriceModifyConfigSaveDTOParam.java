package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.common.enums.PriceModifySceneEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("价格修改配置新增类")
public class MesPriceModifyConfigSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = Update.class, message = "配置价格修改场景不能为空")
   @EnumValidator(groups = Update.class, value = PriceModifySceneEnum.class, message = "配置价格修改场景不存在")
   @ApiModelProperty(name = "configPrice", value = "配置价格修改场景", notes = "配置价格修改场景")
   private Integer configPrice;
   @ApiModelProperty(name = "configPriceSyncStartDate", value = "配置价格同步开始日期", notes = "配置价格同步开始日期")
   private LocalDateTime configPriceSyncStartDate;
   @ApiModelProperty(name = "configPriceSyncEndDate", value = "配置价格同步结束日期", notes = "配置价格同步结束日期")
   private LocalDateTime configPriceSyncEndDate;
   @EnumValidator(groups = Update.class, value = PriceModifySceneEnum.class, message = "单个价格修改场景不存在")
   @ApiModelProperty(name = "individualPrice", value = "单个价格修改场景", notes = "单个价格修改场景")
   private Integer individualPrice;
   @ApiModelProperty(name = "individualPriceSyncStartDate", value = "单个价格同步开始日期", notes = "单个价格同步开始日期")
   private LocalDateTime individualPriceSyncStartDate;
   @ApiModelProperty(name = "individualPriceSyncEndDate", value = "单个价格同步结束日期", notes = "单个价格同步结束日期")
   private LocalDateTime individualPriceSyncEndDate;

   public static MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder builder() {
      return new MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getConfigPrice() {
      return this.configPrice;
   }

   public LocalDateTime getConfigPriceSyncStartDate() {
      return this.configPriceSyncStartDate;
   }

   public LocalDateTime getConfigPriceSyncEndDate() {
      return this.configPriceSyncEndDate;
   }

   public Integer getIndividualPrice() {
      return this.individualPrice;
   }

   public LocalDateTime getIndividualPriceSyncStartDate() {
      return this.individualPriceSyncStartDate;
   }

   public LocalDateTime getIndividualPriceSyncEndDate() {
      return this.individualPriceSyncEndDate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setConfigPrice(final Integer configPrice) {
      this.configPrice = configPrice;
   }

   public void setConfigPriceSyncStartDate(final LocalDateTime configPriceSyncStartDate) {
      this.configPriceSyncStartDate = configPriceSyncStartDate;
   }

   public void setConfigPriceSyncEndDate(final LocalDateTime configPriceSyncEndDate) {
      this.configPriceSyncEndDate = configPriceSyncEndDate;
   }

   public void setIndividualPrice(final Integer individualPrice) {
      this.individualPrice = individualPrice;
   }

   public void setIndividualPriceSyncStartDate(final LocalDateTime individualPriceSyncStartDate) {
      this.individualPriceSyncStartDate = individualPriceSyncStartDate;
   }

   public void setIndividualPriceSyncEndDate(final LocalDateTime individualPriceSyncEndDate) {
      this.individualPriceSyncEndDate = individualPriceSyncEndDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPriceModifyConfigSaveDTOParam)) {
         return false;
      }

      MesPriceModifyConfigSaveDTOParam other = (MesPriceModifyConfigSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$configPrice = this.getConfigPrice();
         Object other$configPrice = other.getConfigPrice();
         if (this$configPrice == null ? other$configPrice == null : this$configPrice.equals(other$configPrice)) {
            Object this$individualPrice = this.getIndividualPrice();
            Object other$individualPrice = other.getIndividualPrice();
            if (this$individualPrice == null ? other$individualPrice == null : this$individualPrice.equals(other$individualPrice)) {
               Object this$configPriceSyncStartDate = this.getConfigPriceSyncStartDate();
               Object other$configPriceSyncStartDate = other.getConfigPriceSyncStartDate();
               if (this$configPriceSyncStartDate == null
                  ? other$configPriceSyncStartDate == null
                  : this$configPriceSyncStartDate.equals(other$configPriceSyncStartDate)) {
                  Object this$configPriceSyncEndDate = this.getConfigPriceSyncEndDate();
                  Object other$configPriceSyncEndDate = other.getConfigPriceSyncEndDate();
                  if (this$configPriceSyncEndDate == null
                     ? other$configPriceSyncEndDate == null
                     : this$configPriceSyncEndDate.equals(other$configPriceSyncEndDate)) {
                     Object this$individualPriceSyncStartDate = this.getIndividualPriceSyncStartDate();
                     Object other$individualPriceSyncStartDate = other.getIndividualPriceSyncStartDate();
                     if (this$individualPriceSyncStartDate == null
                        ? other$individualPriceSyncStartDate == null
                        : this$individualPriceSyncStartDate.equals(other$individualPriceSyncStartDate)) {
                        Object this$individualPriceSyncEndDate = this.getIndividualPriceSyncEndDate();
                        Object other$individualPriceSyncEndDate = other.getIndividualPriceSyncEndDate();
                        return this$individualPriceSyncEndDate == null
                           ? other$individualPriceSyncEndDate == null
                           : this$individualPriceSyncEndDate.equals(other$individualPriceSyncEndDate);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesPriceModifyConfigSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $configPrice = this.getConfigPrice();
      result = result * 59 + ($configPrice == null ? 43 : $configPrice.hashCode());
      Object $individualPrice = this.getIndividualPrice();
      result = result * 59 + ($individualPrice == null ? 43 : $individualPrice.hashCode());
      Object $configPriceSyncStartDate = this.getConfigPriceSyncStartDate();
      result = result * 59 + ($configPriceSyncStartDate == null ? 43 : $configPriceSyncStartDate.hashCode());
      Object $configPriceSyncEndDate = this.getConfigPriceSyncEndDate();
      result = result * 59 + ($configPriceSyncEndDate == null ? 43 : $configPriceSyncEndDate.hashCode());
      Object $individualPriceSyncStartDate = this.getIndividualPriceSyncStartDate();
      result = result * 59 + ($individualPriceSyncStartDate == null ? 43 : $individualPriceSyncStartDate.hashCode());
      Object $individualPriceSyncEndDate = this.getIndividualPriceSyncEndDate();
      return result * 59 + ($individualPriceSyncEndDate == null ? 43 : $individualPriceSyncEndDate.hashCode());
   }

   @Override
   public String toString() {
      return "MesPriceModifyConfigSaveDTOParam(id="
         + this.getId()
         + ", configPrice="
         + this.getConfigPrice()
         + ", configPriceSyncStartDate="
         + this.getConfigPriceSyncStartDate()
         + ", configPriceSyncEndDate="
         + this.getConfigPriceSyncEndDate()
         + ", individualPrice="
         + this.getIndividualPrice()
         + ", individualPriceSyncStartDate="
         + this.getIndividualPriceSyncStartDate()
         + ", individualPriceSyncEndDate="
         + this.getIndividualPriceSyncEndDate()
         + ")";
   }

   public MesPriceModifyConfigSaveDTOParam(
      final Long id,
      final Integer configPrice,
      final LocalDateTime configPriceSyncStartDate,
      final LocalDateTime configPriceSyncEndDate,
      final Integer individualPrice,
      final LocalDateTime individualPriceSyncStartDate,
      final LocalDateTime individualPriceSyncEndDate
   ) {
      this.id = id;
      this.configPrice = configPrice;
      this.configPriceSyncStartDate = configPriceSyncStartDate;
      this.configPriceSyncEndDate = configPriceSyncEndDate;
      this.individualPrice = individualPrice;
      this.individualPriceSyncStartDate = individualPriceSyncStartDate;
      this.individualPriceSyncEndDate = individualPriceSyncEndDate;
   }

   public MesPriceModifyConfigSaveDTOParam() {
   }

   public static class MesPriceModifyConfigSaveDTOParamBuilder {
      private Long id;
      private Integer configPrice;
      private LocalDateTime configPriceSyncStartDate;
      private LocalDateTime configPriceSyncEndDate;
      private Integer individualPrice;
      private LocalDateTime individualPriceSyncStartDate;
      private LocalDateTime individualPriceSyncEndDate;

      MesPriceModifyConfigSaveDTOParamBuilder() {
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder configPrice(final Integer configPrice) {
         this.configPrice = configPrice;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder configPriceSyncStartDate(final LocalDateTime configPriceSyncStartDate) {
         this.configPriceSyncStartDate = configPriceSyncStartDate;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder configPriceSyncEndDate(final LocalDateTime configPriceSyncEndDate) {
         this.configPriceSyncEndDate = configPriceSyncEndDate;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder individualPrice(final Integer individualPrice) {
         this.individualPrice = individualPrice;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder individualPriceSyncStartDate(
         final LocalDateTime individualPriceSyncStartDate
      ) {
         this.individualPriceSyncStartDate = individualPriceSyncStartDate;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder individualPriceSyncEndDate(final LocalDateTime individualPriceSyncEndDate) {
         this.individualPriceSyncEndDate = individualPriceSyncEndDate;
         return this;
      }

      public MesPriceModifyConfigSaveDTOParam build() {
         return new MesPriceModifyConfigSaveDTOParam(
            this.id,
            this.configPrice,
            this.configPriceSyncStartDate,
            this.configPriceSyncEndDate,
            this.individualPrice,
            this.individualPriceSyncStartDate,
            this.individualPriceSyncEndDate
         );
      }

      @Override
      public String toString() {
         return "MesPriceModifyConfigSaveDTOParam.MesPriceModifyConfigSaveDTOParamBuilder(id="
            + this.id
            + ", configPrice="
            + this.configPrice
            + ", configPriceSyncStartDate="
            + this.configPriceSyncStartDate
            + ", configPriceSyncEndDate="
            + this.configPriceSyncEndDate
            + ", individualPrice="
            + this.individualPrice
            + ", individualPriceSyncStartDate="
            + this.individualPriceSyncStartDate
            + ", individualPriceSyncEndDate="
            + this.individualPriceSyncEndDate
            + ")";
      }
   }
}
