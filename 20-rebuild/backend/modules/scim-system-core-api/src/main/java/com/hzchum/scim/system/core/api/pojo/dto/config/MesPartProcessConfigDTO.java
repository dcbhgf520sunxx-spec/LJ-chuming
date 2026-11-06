package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MesPartProcessConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "productCategoryType", value = "零件科目类型[1 板材零件 2 型材零件]", notes = "零件科目类型[1 板材零件 2 型材零件]")
   @NotNull("零件科目类型不能为空")
   private Integer productCategoryType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式[1 数控切割 2 半自动切割]", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @NotNull("零件生产方式不能为空")
   private Integer partProdMode;
   @ApiModelProperty(name = "processConfigId", value = "关联零件工序", notes = "关联零件工序")
   @NotNull("关联零件工序")
   private List<MesPartProcessConfigLinkDTO> processConfigLinkList;

   public static MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder builder() {
      return new MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder();
   }

   public MesPartProcessConfigDTO() {
   }

   public MesPartProcessConfigDTO(
      final Long id,
      @NotNull("零件科目类型不能为空") final Integer productCategoryType,
      @NotNull("零件生产方式不能为空") final Integer partProdMode,
      @NotNull("关联零件工序") final List<MesPartProcessConfigLinkDTO> processConfigLinkList
   ) {
      if (productCategoryType == null) {
         throw new NullPointerException("productCategoryType is marked non-null but is null");
      }

      if (partProdMode == null) {
         throw new NullPointerException("partProdMode is marked non-null but is null");
      }

      if (processConfigLinkList == null) {
         throw new NullPointerException("processConfigLinkList is marked non-null but is null");
      }

      this.id = id;
      this.productCategoryType = productCategoryType;
      this.partProdMode = partProdMode;
      this.processConfigLinkList = processConfigLinkList;
   }

   public Long getId() {
      return this.id;
   }

   @NotNull("零件科目类型不能为空")
   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   @NotNull("零件生产方式不能为空")
   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   @NotNull("关联零件工序")
   public List<MesPartProcessConfigLinkDTO> getProcessConfigLinkList() {
      return this.processConfigLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductCategoryType(@NotNull("零件科目类型不能为空") final Integer productCategoryType) {
      if (productCategoryType == null) {
         throw new NullPointerException("productCategoryType is marked non-null but is null");
      }

      this.productCategoryType = productCategoryType;
   }

   public void setPartProdMode(@NotNull("零件生产方式不能为空") final Integer partProdMode) {
      if (partProdMode == null) {
         throw new NullPointerException("partProdMode is marked non-null but is null");
      }

      this.partProdMode = partProdMode;
   }

   public void setProcessConfigLinkList(@NotNull("关联零件工序") final List<MesPartProcessConfigLinkDTO> processConfigLinkList) {
      if (processConfigLinkList == null) {
         throw new NullPointerException("processConfigLinkList is marked non-null but is null");
      }

      this.processConfigLinkList = processConfigLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPartProcessConfigDTO)) {
         return false;
      }

      MesPartProcessConfigDTO other = (MesPartProcessConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productCategoryType = this.getProductCategoryType();
         Object other$productCategoryType = other.getProductCategoryType();
         if (this$productCategoryType == null ? other$productCategoryType == null : this$productCategoryType.equals(other$productCategoryType)) {
            Object this$partProdMode = this.getPartProdMode();
            Object other$partProdMode = other.getPartProdMode();
            if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
               Object this$processConfigLinkList = this.getProcessConfigLinkList();
               Object other$processConfigLinkList = other.getProcessConfigLinkList();
               return this$processConfigLinkList == null ? other$processConfigLinkList == null : this$processConfigLinkList.equals(other$processConfigLinkList);
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
      return other instanceof MesPartProcessConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $processConfigLinkList = this.getProcessConfigLinkList();
      return result * 59 + ($processConfigLinkList == null ? 43 : $processConfigLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPartProcessConfigDTO(id="
         + this.getId()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", processConfigLinkList="
         + this.getProcessConfigLinkList()
         + ")";
   }

   public static class MesPartProcessConfigDTOBuilder {
      private Long id;
      private Integer productCategoryType;
      private Integer partProdMode;
      private List<MesPartProcessConfigLinkDTO> processConfigLinkList;

      MesPartProcessConfigDTOBuilder() {
      }

      public MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder productCategoryType(@NotNull("零件科目类型不能为空") final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      public MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder partProdMode(@NotNull("零件生产方式不能为空") final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder processConfigLinkList(
         @NotNull("关联零件工序") final List<MesPartProcessConfigLinkDTO> processConfigLinkList
      ) {
         this.processConfigLinkList = processConfigLinkList;
         return this;
      }

      public MesPartProcessConfigDTO build() {
         return new MesPartProcessConfigDTO(this.id, this.productCategoryType, this.partProdMode, this.processConfigLinkList);
      }

      @Override
      public String toString() {
         return "MesPartProcessConfigDTO.MesPartProcessConfigDTOBuilder(id="
            + this.id
            + ", productCategoryType="
            + this.productCategoryType
            + ", partProdMode="
            + this.partProdMode
            + ", processConfigLinkList="
            + this.processConfigLinkList
            + ")";
      }
   }
}
