package com.hzchum.scim.system.core.api.pojo._do;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KitWmsCommonConfigDTO {
   @ApiModelProperty("是否通用配置")
   @NotNull(message = "是否通用配置不可为空")
   private Boolean boolGeneralConfig;
   @ApiModelProperty("是否关联")
   private Boolean boolLink;
   @ApiModelProperty("清单误差配置详情")
   @NotEmpty(message = "清单误差配置详情不能为空")
   @Valid
   private List<KitWmsConfigurationDetailDTO> detailList;

   public static KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder builder() {
      return new KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder();
   }

   public KitWmsCommonConfigDTO() {
   }

   public KitWmsCommonConfigDTO(final Boolean boolGeneralConfig, final Boolean boolLink, final List<KitWmsConfigurationDetailDTO> detailList) {
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

      if (!(o instanceof KitWmsCommonConfigDTO)) {
         return false;
      }

      KitWmsCommonConfigDTO other = (KitWmsCommonConfigDTO)o;
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
      return other instanceof KitWmsCommonConfigDTO;
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
      return "KitWmsCommonConfigDTO(boolGeneralConfig="
         + this.getBoolGeneralConfig()
         + ", boolLink="
         + this.getBoolLink()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public static class KitWmsCommonConfigDTOBuilder {
      private Boolean boolGeneralConfig;
      private Boolean boolLink;
      private List<KitWmsConfigurationDetailDTO> detailList;

      KitWmsCommonConfigDTOBuilder() {
      }

      public KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder boolLink(final Boolean boolLink) {
         this.boolLink = boolLink;
         return this;
      }

      public KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder detailList(final List<KitWmsConfigurationDetailDTO> detailList) {
         this.detailList = detailList;
         return this;
      }

      public KitWmsCommonConfigDTO build() {
         return new KitWmsCommonConfigDTO(this.boolGeneralConfig, this.boolLink, this.detailList);
      }

      @Override
      public String toString() {
         return "KitWmsCommonConfigDTO.KitWmsCommonConfigDTOBuilder(boolGeneralConfig="
            + this.boolGeneralConfig
            + ", boolLink="
            + this.boolLink
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
