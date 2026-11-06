package com.hzchum.scim.system.core.api.pojo.vo;

import com.hzchum.scim.system.core.api.pojo._do.KitWmsConfigurationDetailDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class KitWmsCommonConfigVO {
   @ApiModelProperty("是否通用配置")
   @NotNull(message = "是否通用配置不可为空")
   private Boolean boolGeneralConfig;
   @ApiModelProperty("是否关联")
   private Boolean boolLink;
   @ApiModelProperty("清单误差配置详情")
   private List<KitWmsConfigurationDetailDTO> detailList;

   public static KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder builder() {
      return new KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder();
   }

   public KitWmsCommonConfigVO() {
   }

   public KitWmsCommonConfigVO(final Boolean boolGeneralConfig, final Boolean boolLink, final List<KitWmsConfigurationDetailDTO> detailList) {
      this.boolGeneralConfig = boolGeneralConfig;
      this.boolLink = boolLink;
      this.detailList = detailList;
   }

   public Boolean getBoolGeneralConfig() {
      return this.boolGeneralConfig;
   }

   public Boolean getBoolLink() {
      return this.boolLink;
   }

   public List<KitWmsConfigurationDetailDTO> getDetailList() {
      return this.detailList;
   }

   public void setBoolGeneralConfig(final Boolean boolGeneralConfig) {
      this.boolGeneralConfig = boolGeneralConfig;
   }

   public void setBoolLink(final Boolean boolLink) {
      this.boolLink = boolLink;
   }

   public void setDetailList(final List<KitWmsConfigurationDetailDTO> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof KitWmsCommonConfigVO)) {
         return false;
      }

      KitWmsCommonConfigVO other = (KitWmsCommonConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolGeneralConfig = this.getBoolGeneralConfig();
      Object other$boolGeneralConfig = other.getBoolGeneralConfig();
      if (this$boolGeneralConfig == null ? other$boolGeneralConfig == null : this$boolGeneralConfig.equals(other$boolGeneralConfig)) {
         Object this$boolLink = this.getBoolLink();
         Object other$boolLink = other.getBoolLink();
         if (this$boolLink == null ? other$boolLink == null : this$boolLink.equals(other$boolLink)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof KitWmsCommonConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolGeneralConfig = this.getBoolGeneralConfig();
      result = result * 59 + ($boolGeneralConfig == null ? 43 : $boolGeneralConfig.hashCode());
      Object $boolLink = this.getBoolLink();
      result = result * 59 + ($boolLink == null ? 43 : $boolLink.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "KitWmsCommonConfigVO(boolGeneralConfig="
         + this.getBoolGeneralConfig()
         + ", boolLink="
         + this.getBoolLink()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public static class KitWmsCommonConfigVOBuilder {
      private Boolean boolGeneralConfig;
      private Boolean boolLink;
      private List<KitWmsConfigurationDetailDTO> detailList;

      KitWmsCommonConfigVOBuilder() {
      }

      public KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder boolLink(final Boolean boolLink) {
         this.boolLink = boolLink;
         return this;
      }

      public KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder detailList(final List<KitWmsConfigurationDetailDTO> detailList) {
         this.detailList = detailList;
         return this;
      }

      public KitWmsCommonConfigVO build() {
         return new KitWmsCommonConfigVO(this.boolGeneralConfig, this.boolLink, this.detailList);
      }

      @Override
      public String toString() {
         return "KitWmsCommonConfigVO.KitWmsCommonConfigVOBuilder(boolGeneralConfig="
            + this.boolGeneralConfig
            + ", boolLink="
            + this.boolLink
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
