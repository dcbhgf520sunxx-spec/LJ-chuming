package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

public class APPInboundDTOParam {
   private Long classifyId;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal area;
   private String dxfUrl;
   private String imgUrl;
   private BigDecimal thickness;
   private String specification;
   private Integer basicClass;
   private Long workshopId;
   private Long warehouseId;
   private Long projectId;
   private Boolean boolPartyA;
   private BigDecimal mete;
   @ApiModelProperty(name = "amount", value = "入库总价 含税", notes = "入库总价 含税")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '入库总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)", notes = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率(百分比)'", nullable = true)
   private BigDecimal taxRate;
   private Long materialReturnableId;
   private Boolean autoSelect;
   private List<LocalDateTime> createTime;
   private String serialNumber;

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public Boolean getAutoSelect() {
      return this.autoSelect;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("unitPrice")
   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @JsonProperty("taxRate")
   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   public void setAutoSelect(final Boolean autoSelect) {
      this.autoSelect = autoSelect;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPInboundDTOParam)) {
         return false;
      }

      APPInboundDTOParam other = (APPInboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$materialReturnableId = this.getMaterialReturnableId();
                        Object other$materialReturnableId = other.getMaterialReturnableId();
                        if (this$materialReturnableId == null
                           ? other$materialReturnableId == null
                           : this$materialReturnableId.equals(other$materialReturnableId)) {
                           Object this$autoSelect = this.getAutoSelect();
                           Object other$autoSelect = other.getAutoSelect();
                           if (this$autoSelect == null ? other$autoSelect == null : this$autoSelect.equals(other$autoSelect)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$width = this.getWidth();
                                 Object other$width = other.getWidth();
                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$dxfUrl = this.getDxfUrl();
                                       Object other$dxfUrl = other.getDxfUrl();
                                       if (this$dxfUrl == null ? other$dxfUrl == null : this$dxfUrl.equals(other$dxfUrl)) {
                                          Object this$imgUrl = this.getImgUrl();
                                          Object other$imgUrl = other.getImgUrl();
                                          if (this$imgUrl == null ? other$imgUrl == null : this$imgUrl.equals(other$imgUrl)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$amount = this.getAmount();
                                                      Object other$amount = other.getAmount();
                                                      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$unitPrice = this.getUnitPrice();
                                                            Object other$unitPrice = other.getUnitPrice();
                                                            if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$createTime = this.getCreateTime();
                                                                  Object other$createTime = other.getCreateTime();
                                                                  if (this$createTime == null
                                                                     ? other$createTime == null
                                                                     : this$createTime.equals(other$createTime)) {
                                                                     Object this$serialNumber = this.getSerialNumber();
                                                                     Object other$serialNumber = other.getSerialNumber();
                                                                     return this$serialNumber == null
                                                                        ? other$serialNumber == null
                                                                        : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof APPInboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $autoSelect = this.getAutoSelect();
      result = result * 59 + ($autoSelect == null ? 43 : $autoSelect.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "APPInboundDTOParam(classifyId="
         + this.getClassifyId()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", area="
         + this.getArea()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", thickness="
         + this.getThickness()
         + ", specification="
         + this.getSpecification()
         + ", basicClass="
         + this.getBasicClass()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", mete="
         + this.getMete()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", taxRate="
         + this.getTaxRate()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", autoSelect="
         + this.getAutoSelect()
         + ", createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
