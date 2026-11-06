package com.hzchum.scim.plan.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.vo.BimBridgeStatusDetailVO;
import com.hzchum.scim.plan.core.api.pojo.dto.BridgeElementPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("bim桥梁分段树")
public class BimBoxOrElementsVO extends BimBridgeStatusDetailVO {
   @ApiModelProperty(name = "specification", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerId", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "specification", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "surfaceArea", value = "单面积")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "productWeldCount", value = "焊缝数量")
   private Integer productWeldCount;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "techMachinePartDTOS", value = "关联的零件信息")
   private List<BridgeElementPartDTO> techMachinePartDTOS;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   private List<BimSummaryDetailsVO> processSummaryDetailsList;
   @ApiModelProperty("单元件elementIds")
   private List<String> unitElementIds;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimBoxOrElementsVO)) {
         return false;
      }

      BimBoxOrElementsVO other = (BimBoxOrElementsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productWeldCount = this.getProductWeldCount();
               Object other$productWeldCount = other.getProductWeldCount();
               if (this$productWeldCount == null ? other$productWeldCount == null : this$productWeldCount.equals(other$productWeldCount)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$areaName = this.getAreaName();
                     Object other$areaName = other.getAreaName();
                     if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$surfaceArea = this.getSurfaceArea();
                              Object other$surfaceArea = other.getSurfaceArea();
                              if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                 Object this$numbers = this.getNumbers();
                                 Object other$numbers = other.getNumbers();
                                 if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                    Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                    Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                    if (this$drawingAndSerialNumber == null
                                       ? other$drawingAndSerialNumber == null
                                       : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber)) {
                                       Object this$techMachinePartDTOS = this.getTechMachinePartDTOS();
                                       Object other$techMachinePartDTOS = other.getTechMachinePartDTOS();
                                       if (this$techMachinePartDTOS == null
                                          ? other$techMachinePartDTOS == null
                                          : this$techMachinePartDTOS.equals(other$techMachinePartDTOS)) {
                                          Object this$processSummaryDetailsList = this.getProcessSummaryDetailsList();
                                          Object other$processSummaryDetailsList = other.getProcessSummaryDetailsList();
                                          if (this$processSummaryDetailsList == null
                                             ? other$processSummaryDetailsList == null
                                             : this$processSummaryDetailsList.equals(other$processSummaryDetailsList)) {
                                             Object this$unitElementIds = this.getUnitElementIds();
                                             Object other$unitElementIds = other.getUnitElementIds();
                                             return this$unitElementIds == null
                                                ? other$unitElementIds == null
                                                : this$unitElementIds.equals(other$unitElementIds);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BimBoxOrElementsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productWeldCount = this.getProductWeldCount();
      result = result * 59 + ($productWeldCount == null ? 43 : $productWeldCount.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      result = result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
      Object $techMachinePartDTOS = this.getTechMachinePartDTOS();
      result = result * 59 + ($techMachinePartDTOS == null ? 43 : $techMachinePartDTOS.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      result = result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
      Object $unitElementIds = this.getUnitElementIds();
      return result * 59 + ($unitElementIds == null ? 43 : $unitElementIds.hashCode());
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getProductWeldCount() {
      return this.productWeldCount;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public List<BridgeElementPartDTO> getTechMachinePartDTOS() {
      return this.techMachinePartDTOS;
   }

   public List<BimSummaryDetailsVO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   public List<String> getUnitElementIds() {
      return this.unitElementIds;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setProductWeldCount(final Integer productWeldCount) {
      this.productWeldCount = productWeldCount;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public void setTechMachinePartDTOS(final List<BridgeElementPartDTO> techMachinePartDTOS) {
      this.techMachinePartDTOS = techMachinePartDTOS;
   }

   public void setProcessSummaryDetailsList(final List<BimSummaryDetailsVO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
   }

   public void setUnitElementIds(final List<String> unitElementIds) {
      this.unitElementIds = unitElementIds;
   }

   @Override
   public String toString() {
      return "BimBoxOrElementsVO(areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", productType="
         + this.getProductType()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", productWeldCount="
         + this.getProductWeldCount()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", techMachinePartDTOS="
         + this.getTechMachinePartDTOS()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ", unitElementIds="
         + this.getUnitElementIds()
         + ")";
   }
}
