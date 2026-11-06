package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("栓钉套筒新增类")
public class MesBoltSleeveSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotEmpty(groups = {Add.class, Update.class}, message = "类型不能为空")
   @ApiModelProperty(name = "typeNameList", value = "类型集合", notes = "类型集合")
   private List<String> typeNameList;
   @NotNull(groups = {Add.class, Update.class}, message = "工序ID不能为空")
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   private Long processId;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "单价要大于0")
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;

   public static MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder builder() {
      return new MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<String> getTypeNameList() {
      return this.typeNameList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTypeNameList(final List<String> typeNameList) {
      this.typeNameList = typeNameList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBoltSleeveSaveDTOParam)) {
         return false;
      }

      MesBoltSleeveSaveDTOParam other = (MesBoltSleeveSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$typeNameList = this.getTypeNameList();
            Object other$typeNameList = other.getTypeNameList();
            if (this$typeNameList == null ? other$typeNameList == null : this$typeNameList.equals(other$typeNameList)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBoltSleeveSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $typeNameList = this.getTypeNameList();
      result = result * 59 + ($typeNameList == null ? 43 : $typeNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesBoltSleeveSaveDTOParam(id="
         + this.getId()
         + ", typeNameList="
         + this.getTypeNameList()
         + ", processId="
         + this.getProcessId()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }

   public MesBoltSleeveSaveDTOParam(final Long id, final List<String> typeNameList, final Long processId, final String unit, final BigDecimal price) {
      this.id = id;
      this.typeNameList = typeNameList;
      this.processId = processId;
      this.unit = unit;
      this.price = price;
   }

   public MesBoltSleeveSaveDTOParam() {
   }

   public static class MesBoltSleeveSaveDTOParamBuilder {
      private Long id;
      private List<String> typeNameList;
      private Long processId;
      private String unit;
      private BigDecimal price;

      MesBoltSleeveSaveDTOParamBuilder() {
      }

      public MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder typeNameList(final List<String> typeNameList) {
         this.typeNameList = typeNameList;
         return this;
      }

      public MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBoltSleeveSaveDTOParam build() {
         return new MesBoltSleeveSaveDTOParam(this.id, this.typeNameList, this.processId, this.unit, this.price);
      }

      @Override
      public String toString() {
         return "MesBoltSleeveSaveDTOParam.MesBoltSleeveSaveDTOParamBuilder(id="
            + this.id
            + ", typeNameList="
            + this.typeNameList
            + ", processId="
            + this.processId
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ")";
      }
   }
}
