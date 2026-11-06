package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(description = "CAPP 焊接数据采集记录列表 响应参数")
public class CappCraftCardWeldingGatherVO {
   @ApiModelProperty(name = "passId", value = "焊道任务id", notes = "焊道任务id")
   private Long passId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productName", value = "产品名称", notes = "产品名称")
   private String productName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   private String weldingSerialNumber;
   @ApiModelProperty(name = "techCappCraftCardStorehouseSerialNumber", value = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "weldingCraftParameterPass", value = "道次", notes = "道次")
   private String weldingCraftParameterPass;
   @ApiModelProperty(name = "equimentSerialNumber", value = "设备编号", notes = "设备编号")
   private String equimentSerialNumber;
   @ApiModelProperty(name = "equimentName", value = "设备名称", notes = "设备名称")
   private String equimentName;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   private String equimentCode;
   @ApiModelProperty(name = "weldUserName", value = "实际焊接人名称", notes = "实际焊接人名称")
   private String weldUserName;
   @ApiModelProperty(name = "startTime", value = "焊接开始时间", notes = "焊接开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "焊接结束时间", notes = "焊接结束时间")
   private LocalDateTime endTime;
   @ApiModelProperty(name = "actualTime", value = "焊接实际时长 h:mm", notes = "焊接实际时长 h:mm")
   private String actualTime;
   @ApiModelProperty(name = "ratedElectricity", value = "额定电流(A)", notes = "额定电流(A)")
   private String ratedElectricity;
   @ApiModelProperty(name = "ratedVoltage", value = "额定电压(V)", notes = "额定电压(V)")
   private String ratedVoltage;
   @ApiModelProperty(name = "actualElectricity", value = "实际电流(A)", notes = "实际电流(A)")
   private String actualElectricity;
   @ApiModelProperty(name = "actualVoltage", value = "实际电压(V)", notes = "实际电压(V)")
   private String actualVoltage;

   public Long getPassId() {
      return this.passId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public String getWeldingBaseWeldingPosition() {
      return this.weldingBaseWeldingPosition;
   }

   public String getWeldingCraftParameterPass() {
      return this.weldingCraftParameterPass;
   }

   public String getEquimentSerialNumber() {
      return this.equimentSerialNumber;
   }

   public String getEquimentName() {
      return this.equimentName;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getWeldUserName() {
      return this.weldUserName;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public String getActualTime() {
      return this.actualTime;
   }

   public String getRatedElectricity() {
      return this.ratedElectricity;
   }

   public String getRatedVoltage() {
      return this.ratedVoltage;
   }

   public String getActualElectricity() {
      return this.actualElectricity;
   }

   public String getActualVoltage() {
      return this.actualVoltage;
   }

   public void setPassId(final Long passId) {
      this.passId = passId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setWeldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
   }

   public void setWeldingCraftParameterPass(final String weldingCraftParameterPass) {
      this.weldingCraftParameterPass = weldingCraftParameterPass;
   }

   public void setEquimentSerialNumber(final String equimentSerialNumber) {
      this.equimentSerialNumber = equimentSerialNumber;
   }

   public void setEquimentName(final String equimentName) {
      this.equimentName = equimentName;
   }

   public void setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
   }

   public void setWeldUserName(final String weldUserName) {
      this.weldUserName = weldUserName;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setActualTime(final String actualTime) {
      this.actualTime = actualTime;
   }

   public void setRatedElectricity(final String ratedElectricity) {
      this.ratedElectricity = ratedElectricity;
   }

   public void setRatedVoltage(final String ratedVoltage) {
      this.ratedVoltage = ratedVoltage;
   }

   public void setActualElectricity(final String actualElectricity) {
      this.actualElectricity = actualElectricity;
   }

   public void setActualVoltage(final String actualVoltage) {
      this.actualVoltage = actualVoltage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingGatherVO)) {
         return false;
      }

      CappCraftCardWeldingGatherVO other = (CappCraftCardWeldingGatherVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$passId = this.getPassId();
      Object other$passId = other.getPassId();
      if (this$passId == null ? other$passId == null : this$passId.equals(other$passId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productSerialNumber = this.getProductSerialNumber();
               Object other$productSerialNumber = other.getProductSerialNumber();
               if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
                  Object this$productName = this.getProductName();
                  Object other$productName = other.getProductName();
                  if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                     Object this$weldingSerialNumber = this.getWeldingSerialNumber();
                     Object other$weldingSerialNumber = other.getWeldingSerialNumber();
                     if (this$weldingSerialNumber == null ? other$weldingSerialNumber == null : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
                        Object this$techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
                        Object other$techCappCraftCardStorehouseSerialNumber = other.getTechCappCraftCardStorehouseSerialNumber();
                        if (this$techCappCraftCardStorehouseSerialNumber == null
                           ? other$techCappCraftCardStorehouseSerialNumber == null
                           : this$techCappCraftCardStorehouseSerialNumber.equals(other$techCappCraftCardStorehouseSerialNumber)) {
                           Object this$weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
                           Object other$weldingBaseWeldingPosition = other.getWeldingBaseWeldingPosition();
                           if (this$weldingBaseWeldingPosition == null
                              ? other$weldingBaseWeldingPosition == null
                              : this$weldingBaseWeldingPosition.equals(other$weldingBaseWeldingPosition)) {
                              Object this$weldingCraftParameterPass = this.getWeldingCraftParameterPass();
                              Object other$weldingCraftParameterPass = other.getWeldingCraftParameterPass();
                              if (this$weldingCraftParameterPass == null
                                 ? other$weldingCraftParameterPass == null
                                 : this$weldingCraftParameterPass.equals(other$weldingCraftParameterPass)) {
                                 Object this$equimentSerialNumber = this.getEquimentSerialNumber();
                                 Object other$equimentSerialNumber = other.getEquimentSerialNumber();
                                 if (this$equimentSerialNumber == null
                                    ? other$equimentSerialNumber == null
                                    : this$equimentSerialNumber.equals(other$equimentSerialNumber)) {
                                    Object this$equimentName = this.getEquimentName();
                                    Object other$equimentName = other.getEquimentName();
                                    if (this$equimentName == null ? other$equimentName == null : this$equimentName.equals(other$equimentName)) {
                                       Object this$equimentCode = this.getEquimentCode();
                                       Object other$equimentCode = other.getEquimentCode();
                                       if (this$equimentCode == null ? other$equimentCode == null : this$equimentCode.equals(other$equimentCode)) {
                                          Object this$weldUserName = this.getWeldUserName();
                                          Object other$weldUserName = other.getWeldUserName();
                                          if (this$weldUserName == null ? other$weldUserName == null : this$weldUserName.equals(other$weldUserName)) {
                                             Object this$startTime = this.getStartTime();
                                             Object other$startTime = other.getStartTime();
                                             if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                                                Object this$endTime = this.getEndTime();
                                                Object other$endTime = other.getEndTime();
                                                if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                                                   Object this$actualTime = this.getActualTime();
                                                   Object other$actualTime = other.getActualTime();
                                                   if (this$actualTime == null ? other$actualTime == null : this$actualTime.equals(other$actualTime)) {
                                                      Object this$ratedElectricity = this.getRatedElectricity();
                                                      Object other$ratedElectricity = other.getRatedElectricity();
                                                      if (this$ratedElectricity == null
                                                         ? other$ratedElectricity == null
                                                         : this$ratedElectricity.equals(other$ratedElectricity)) {
                                                         Object this$ratedVoltage = this.getRatedVoltage();
                                                         Object other$ratedVoltage = other.getRatedVoltage();
                                                         if (this$ratedVoltage == null
                                                            ? other$ratedVoltage == null
                                                            : this$ratedVoltage.equals(other$ratedVoltage)) {
                                                            Object this$actualElectricity = this.getActualElectricity();
                                                            Object other$actualElectricity = other.getActualElectricity();
                                                            if (this$actualElectricity == null
                                                               ? other$actualElectricity == null
                                                               : this$actualElectricity.equals(other$actualElectricity)) {
                                                               Object this$actualVoltage = this.getActualVoltage();
                                                               Object other$actualVoltage = other.getActualVoltage();
                                                               return this$actualVoltage == null
                                                                  ? other$actualVoltage == null
                                                                  : this$actualVoltage.equals(other$actualVoltage);
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
      return other instanceof CappCraftCardWeldingGatherVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $passId = this.getPassId();
      result = result * 59 + ($passId == null ? 43 : $passId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      result = result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
      Object $weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
      result = result * 59 + ($weldingBaseWeldingPosition == null ? 43 : $weldingBaseWeldingPosition.hashCode());
      Object $weldingCraftParameterPass = this.getWeldingCraftParameterPass();
      result = result * 59 + ($weldingCraftParameterPass == null ? 43 : $weldingCraftParameterPass.hashCode());
      Object $equimentSerialNumber = this.getEquimentSerialNumber();
      result = result * 59 + ($equimentSerialNumber == null ? 43 : $equimentSerialNumber.hashCode());
      Object $equimentName = this.getEquimentName();
      result = result * 59 + ($equimentName == null ? 43 : $equimentName.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $weldUserName = this.getWeldUserName();
      result = result * 59 + ($weldUserName == null ? 43 : $weldUserName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $actualTime = this.getActualTime();
      result = result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
      Object $ratedElectricity = this.getRatedElectricity();
      result = result * 59 + ($ratedElectricity == null ? 43 : $ratedElectricity.hashCode());
      Object $ratedVoltage = this.getRatedVoltage();
      result = result * 59 + ($ratedVoltage == null ? 43 : $ratedVoltage.hashCode());
      Object $actualElectricity = this.getActualElectricity();
      result = result * 59 + ($actualElectricity == null ? 43 : $actualElectricity.hashCode());
      Object $actualVoltage = this.getActualVoltage();
      return result * 59 + ($actualVoltage == null ? 43 : $actualVoltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingGatherVO(passId="
         + this.getPassId()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", productType="
         + this.getProductType()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", weldingBaseWeldingPosition="
         + this.getWeldingBaseWeldingPosition()
         + ", weldingCraftParameterPass="
         + this.getWeldingCraftParameterPass()
         + ", equimentSerialNumber="
         + this.getEquimentSerialNumber()
         + ", equimentName="
         + this.getEquimentName()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", weldUserName="
         + this.getWeldUserName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", actualTime="
         + this.getActualTime()
         + ", ratedElectricity="
         + this.getRatedElectricity()
         + ", ratedVoltage="
         + this.getRatedVoltage()
         + ", actualElectricity="
         + this.getActualElectricity()
         + ", actualVoltage="
         + this.getActualVoltage()
         + ")";
   }
}
