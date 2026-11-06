package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.pangu.common.valid.Add;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SurplusDTOParam {
   @ApiModelProperty(name = "id", value = "单据id")
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "包含的基础科目", notes = "包含的基础科目")
   @NotNull(groups = Add.class, message = "包含的基础科目不能为空！")
   private Integer basicClass;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @NotNull(groups = Add.class, message = "是否甲供物料不能为空！")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   @NotNull(groups = Add.class, message = "发票类型不能为空！")
   private Integer invoiceType;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   private LocalDateTime clickTime;
   @NotEmpty(groups = Add.class, message = "盘盈详情不能为空！")
   List<SurplusDetailDTOParam> list;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public LocalDateTime getClickTime() {
      return this.clickTime;
   }

   public List<SurplusDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setClickTime(final LocalDateTime clickTime) {
      this.clickTime = clickTime;
   }

   public void setList(final List<SurplusDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SurplusDTOParam)) {
         return false;
      }

      SurplusDTOParam other = (SurplusDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$taxRate = this.getTaxRate();
                  Object other$taxRate = other.getTaxRate();
                  if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                     Object this$clickTime = this.getClickTime();
                     Object other$clickTime = other.getClickTime();
                     if (this$clickTime == null ? other$clickTime == null : this$clickTime.equals(other$clickTime)) {
                        Object this$list = this.getList();
                        Object other$list = other.getList();
                        return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof SurplusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $clickTime = this.getClickTime();
      result = result * 59 + ($clickTime == null ? 43 : $clickTime.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "SurplusDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", clickTime="
         + this.getClickTime()
         + ", list="
         + this.getList()
         + ")";
   }
}
