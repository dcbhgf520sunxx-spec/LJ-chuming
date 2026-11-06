package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.common.enums.PriceModifySceneEnum;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("项目统计配置关联新增类")
public class MesContractProjectStatisticsConfigLinkSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   private Long contractProjectId;
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   @NotNull(groups = Add.class, message = "统计模式不能为空")
   @EnumValidator(groups = Add.class, value = StatisticsConfigStatisticsModeEnum.class, message = "统计模式不存在")
   private Integer statisticsMode;
   @ApiModelProperty(name = "statisticsDeadline", value = "统计截止日期", notes = "统计截止日期")
   private LocalDateTime statisticsDeadline;
   @ApiModelProperty(name = "configPrice", value = "配置价格修改场景", notes = "配置价格修改场景")
   @NotNull(groups = {Add.class, Update.class}, message = "配置价格修改场景不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = PriceModifySceneEnum.class, message = "配置价格修改场景不存在")
   private Integer configPrice;
   @ApiModelProperty(name = "configPriceSyncStartDate", value = "配置价格同步开始日期", notes = "配置价格同步开始日期")
   private LocalDateTime configPriceSyncStartDate;
   @ApiModelProperty(name = "configPriceSyncEndDate", value = "配置价格同步结束日期", notes = "配置价格同步结束日期")
   private LocalDateTime configPriceSyncEndDate;
   @ApiModelProperty(name = "individualPrice", value = "单个价格修改场景", notes = "单个价格修改场景")
   @NotNull(groups = {Add.class, Update.class}, message = "单个价格修改场景不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = PriceModifySceneEnum.class, message = "单个价格修改场景不存在")
   private Integer individualPrice;
   @ApiModelProperty(name = "individualPriceSyncStartDate", value = "单个价格同步开始日期", notes = "单个价格同步开始日期")
   private LocalDateTime individualPriceSyncStartDate;
   @ApiModelProperty(name = "individualPriceSyncEndDate", value = "单个价格同步结束日期", notes = "单个价格同步结束日期")
   private LocalDateTime individualPriceSyncEndDate;

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
   }

   public LocalDateTime getStatisticsDeadline() {
      return this.statisticsDeadline;
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

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
   }

   public void setStatisticsDeadline(final LocalDateTime statisticsDeadline) {
      this.statisticsDeadline = statisticsDeadline;
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

      if (!(o instanceof MesContractProjectStatisticsConfigLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectStatisticsConfigLinkSaveDTOParam other = (MesContractProjectStatisticsConfigLinkSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$statisticsMode = this.getStatisticsMode();
            Object other$statisticsMode = other.getStatisticsMode();
            if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
               Object this$configPrice = this.getConfigPrice();
               Object other$configPrice = other.getConfigPrice();
               if (this$configPrice == null ? other$configPrice == null : this$configPrice.equals(other$configPrice)) {
                  Object this$individualPrice = this.getIndividualPrice();
                  Object other$individualPrice = other.getIndividualPrice();
                  if (this$individualPrice == null ? other$individualPrice == null : this$individualPrice.equals(other$individualPrice)) {
                     Object this$statisticsDeadline = this.getStatisticsDeadline();
                     Object other$statisticsDeadline = other.getStatisticsDeadline();
                     if (this$statisticsDeadline == null ? other$statisticsDeadline == null : this$statisticsDeadline.equals(other$statisticsDeadline)) {
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
      return other instanceof MesContractProjectStatisticsConfigLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $configPrice = this.getConfigPrice();
      result = result * 59 + ($configPrice == null ? 43 : $configPrice.hashCode());
      Object $individualPrice = this.getIndividualPrice();
      result = result * 59 + ($individualPrice == null ? 43 : $individualPrice.hashCode());
      Object $statisticsDeadline = this.getStatisticsDeadline();
      result = result * 59 + ($statisticsDeadline == null ? 43 : $statisticsDeadline.hashCode());
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
      return "MesContractProjectStatisticsConfigLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", statisticsDeadline="
         + this.getStatisticsDeadline()
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
}
