package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("零工配置新增类")
public class MesContractProjectOddJobConfigLinkSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   private Long contractProjectId;
   @NotBlank(groups = {Add.class, Update.class}, message = "零工类型不能为空")
   @Size(max = 20, groups = {Add.class, Update.class}, message = "零工类型名称过长")
   @ApiModelProperty(name = "oddJobType", value = "零工类型", notes = "零工类型")
   private String oddJobType;
   @ApiModelProperty(name = "unit", value = "计算单位（统一为小时）", notes = "计算单位")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.01", message = "单价不能小于0.01")
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @NotNull(groups = Update.class, message = "状态不能为空")
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   private Boolean status;

   public static MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder builder() {
      return new MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public String getOddJobType() {
      return this.oddJobType;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setOddJobType(final String oddJobType) {
      this.oddJobType = oddJobType;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectOddJobConfigLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectOddJobConfigLinkSaveDTOParam other = (MesContractProjectOddJobConfigLinkSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$oddJobType = this.getOddJobType();
               Object other$oddJobType = other.getOddJobType();
               if (this$oddJobType == null ? other$oddJobType == null : this$oddJobType.equals(other$oddJobType)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesContractProjectOddJobConfigLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $oddJobType = this.getOddJobType();
      result = result * 59 + ($oddJobType == null ? 43 : $oddJobType.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectOddJobConfigLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", oddJobType="
         + this.getOddJobType()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public MesContractProjectOddJobConfigLinkSaveDTOParam(
      final Long id, final Long contractProjectId, final String oddJobType, final String unit, final BigDecimal price, final Boolean status
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.oddJobType = oddJobType;
      this.unit = unit;
      this.price = price;
      this.status = status;
   }

   public MesContractProjectOddJobConfigLinkSaveDTOParam() {
   }

   public static class MesContractProjectOddJobConfigLinkSaveDTOParamBuilder {
      private Long id;
      private Long contractProjectId;
      private String oddJobType;
      private String unit;
      private BigDecimal price;
      private Boolean status;

      MesContractProjectOddJobConfigLinkSaveDTOParamBuilder() {
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder contractProjectId(
         final Long contractProjectId
      ) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder oddJobType(final String oddJobType) {
         this.oddJobType = oddJobType;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesContractProjectOddJobConfigLinkSaveDTOParam build() {
         return new MesContractProjectOddJobConfigLinkSaveDTOParam(this.id, this.contractProjectId, this.oddJobType, this.unit, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesContractProjectOddJobConfigLinkSaveDTOParam.MesContractProjectOddJobConfigLinkSaveDTOParamBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", oddJobType="
            + this.oddJobType
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
