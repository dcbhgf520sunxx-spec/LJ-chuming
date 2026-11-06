package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.update;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save.SupplierPriceCarLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(description = "物流管理")
public class SupplierPriceUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "物流供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "priceType", value = "计价方式 [1 重量, 2 车次]")
   @NotNull(message = "计价方式不能为空")
   private Integer priceType;
   @ApiModelProperty(name = "price", value = "价格")
   @NotNull(message = "价格不能为空")
   private BigDecimal price;
   @ApiModelProperty(name = "invoiceTypeEnum", value = "发票类型[1 增值税专用发票 2 增值税普通发票 4 收据]", notes = "发票类型[1 增值税专用发票 2 增值税普通发票 4 收据]")
   @JsonProperty("invoiceTypeEnum")
   @JSONField(name = "invoiceTypeEnum")
   private Integer invoiceTypeEnum;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   private String licensePlate;
   @ApiModelProperty(name = "tax", value = "税率")
   private BigDecimal tax;
   @ApiModelProperty(name = "linkList", value = "车型价格", notes = "车型价格")
   @JsonProperty("linkList")
   @JSONField(name = "linkList")
   private List<SupplierPriceCarLinkDTOParam> linkList;

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getInvoiceTypeEnum() {
      return this.invoiceTypeEnum;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public List<SupplierPriceCarLinkDTOParam> getLinkList() {
      return this.linkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @JsonProperty("invoiceTypeEnum")
   public void setInvoiceTypeEnum(final Integer invoiceTypeEnum) {
      this.invoiceTypeEnum = invoiceTypeEnum;
   }

   @JsonProperty("licensePlate")
   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setTax(final BigDecimal tax) {
      this.tax = tax;
   }

   @JsonProperty("linkList")
   public void setLinkList(final List<SupplierPriceCarLinkDTOParam> linkList) {
      this.linkList = linkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceUpdateDTOParam)) {
         return false;
      }

      SupplierPriceUpdateDTOParam other = (SupplierPriceUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$priceType = this.getPriceType();
               Object other$priceType = other.getPriceType();
               if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                  Object this$invoiceTypeEnum = this.getInvoiceTypeEnum();
                  Object other$invoiceTypeEnum = other.getInvoiceTypeEnum();
                  if (this$invoiceTypeEnum == null ? other$invoiceTypeEnum == null : this$invoiceTypeEnum.equals(other$invoiceTypeEnum)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$tax = this.getTax();
                           Object other$tax = other.getTax();
                           if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                              Object this$linkList = this.getLinkList();
                              Object other$linkList = other.getLinkList();
                              return this$linkList == null ? other$linkList == null : this$linkList.equals(other$linkList);
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
      return other instanceof SupplierPriceUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $invoiceTypeEnum = this.getInvoiceTypeEnum();
      result = result * 59 + ($invoiceTypeEnum == null ? 43 : $invoiceTypeEnum.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $linkList = this.getLinkList();
      return result * 59 + ($linkList == null ? 43 : $linkList.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPriceUpdateDTOParam(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectId="
         + this.getProjectId()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ", invoiceTypeEnum="
         + this.getInvoiceTypeEnum()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", tax="
         + this.getTax()
         + ", linkList="
         + this.getLinkList()
         + ")";
   }
}
