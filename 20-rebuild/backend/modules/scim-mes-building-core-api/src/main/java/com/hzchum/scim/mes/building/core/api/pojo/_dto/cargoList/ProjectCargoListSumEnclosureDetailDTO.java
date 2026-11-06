package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目发运分类信息-围护")
public class ProjectCargoListSumEnclosureDetailDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目基础信息", notes = "项目基础信息")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "totalLength", value = "清单总长度", notes = "清单总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "清单总面积", notes = "清单总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "quantity", value = "清单总数", notes = "清单总数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产总数", notes = "排产总数")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalLength", value = "排产总长度", notes = "排产总长度")
   @JsonProperty("schedulingTotalLength")
   @JSONField(name = "schedulingTotalLength")
   private BigDecimal schedulingTotalLength;
   @ApiModelProperty(name = "schedulingTotalArea", value = "排产总面积", notes = "排产总面积")
   @JsonProperty("schedulingTotalArea")
   @JSONField(name = "schedulingTotalArea")
   private BigDecimal schedulingTotalArea;
   @ApiModelProperty(name = "inBoundQuantity", value = "入库总数", notes = "入库总数")
   @JsonProperty("inBoundQuantity")
   @JSONField(name = "inBoundQuantity")
   private Integer inBoundQuantity;
   @ApiModelProperty(name = "inBoundTotalLength", value = "入库总长度", notes = "入库总长度")
   @JsonProperty("inBoundTotalLength")
   @JSONField(name = "inBoundTotalLength")
   private BigDecimal inBoundTotalLength;
   @ApiModelProperty(name = "inBoundTotalArea", value = "入库总面积", notes = "入库总面积")
   @JsonProperty("inBoundTotalArea")
   @JSONField(name = "inBoundTotalArea")
   private BigDecimal inBoundTotalArea;
   @ApiModelProperty(name = "outBoundQuantity", value = "发运总数", notes = "发运总数")
   @JsonProperty("outBoundQuantity")
   @JSONField(name = "outBoundQuantity")
   private Integer outBoundQuantity;
   @ApiModelProperty(name = "outBoundTotalLength", value = "发运总长度", notes = "发运总长度")
   @JsonProperty("outBoundTotalLength")
   @JSONField(name = "outBoundTotalLength")
   private BigDecimal outBoundTotalLength;
   @ApiModelProperty(name = "outBoundTotalArea", value = "发运总面积", notes = "发运总面积")
   @JsonProperty("outBoundTotalArea")
   @JSONField(name = "outBoundTotalArea")
   private BigDecimal outBoundTotalArea;
   @ApiModelProperty(name = "outMounthBoundQuantity", value = "本月发运总数", notes = "本月发运总数")
   @JsonProperty("outMounthBoundQuantity")
   @JSONField(name = "outMounthBoundQuantity")
   private Integer outMounthBoundQuantity;
   @ApiModelProperty(name = "outMounthBoundTotalLength", value = "本月发运总长度", notes = "本月发运总长度")
   @JsonProperty("outMounthBoundTotalLength")
   @JSONField(name = "outMounthBoundTotalLength")
   private BigDecimal outMounthBoundTotalLength;
   @ApiModelProperty(name = "outMounthBoundTotalArea", value = "本月发运总面积", notes = "本月发运总面积")
   @JsonProperty("outMounthBoundTotalArea")
   @JSONField(name = "outMounthBoundTotalArea")
   private BigDecimal outMounthBoundTotalArea;
   @ApiModelProperty(name = "stockQuantity", notes = "库存数量", value = "库存数量")
   @JsonProperty("stockQuantity")
   @JSONField(name = "stockQuantity")
   private Integer stockQuantity;
   @ApiModelProperty(name = "stockTotalLength", value = "库存总长度", notes = "库存总长度")
   @JsonProperty("stockTotalLength")
   @JSONField(name = "stockTotalLength")
   private BigDecimal stockTotalLength;
   @ApiModelProperty(name = "stockTotalArea", value = "库存总面积", notes = "库存总面积")
   @JsonProperty("stockTotalArea")
   @JSONField(name = "stockTotalArea")
   private BigDecimal stockTotalArea;
   @ApiModelProperty(name = "packageQuantity", notes = "打包数", value = "打包数")
   private Integer packageQuantity;
   @ApiModelProperty(name = "packageTotalLength", value = "打包总长度", notes = "打包总长度")
   private BigDecimal packageTotalLength;
   @ApiModelProperty(name = "packageTotalArea", value = "打包总面积", notes = "打包总面积")
   private BigDecimal packageTotalArea;
   @ApiModelProperty(name = "trainNumber", notes = "累计车次", value = "累计车次")
   @JsonProperty("trainNumber")
   @JSONField(name = "trainNumber")
   private Integer trainNumber;

   public static ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder builder() {
      return new ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder();
   }

   public ProjectCargoListSumEnclosureDetailDTO(
      final ProjectInfo projectInfo,
      final WorkshopDetailDO workshop,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer quantity,
      final Integer schedulingQuantity,
      final BigDecimal schedulingTotalLength,
      final BigDecimal schedulingTotalArea,
      final Integer inBoundQuantity,
      final BigDecimal inBoundTotalLength,
      final BigDecimal inBoundTotalArea,
      final Integer outBoundQuantity,
      final BigDecimal outBoundTotalLength,
      final BigDecimal outBoundTotalArea,
      final Integer outMounthBoundQuantity,
      final BigDecimal outMounthBoundTotalLength,
      final BigDecimal outMounthBoundTotalArea,
      final Integer stockQuantity,
      final BigDecimal stockTotalLength,
      final BigDecimal stockTotalArea,
      final Integer packageQuantity,
      final BigDecimal packageTotalLength,
      final BigDecimal packageTotalArea,
      final Integer trainNumber
   ) {
      this.projectInfo = projectInfo;
      this.workshop = workshop;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.schedulingTotalLength = schedulingTotalLength;
      this.schedulingTotalArea = schedulingTotalArea;
      this.inBoundQuantity = inBoundQuantity;
      this.inBoundTotalLength = inBoundTotalLength;
      this.inBoundTotalArea = inBoundTotalArea;
      this.outBoundQuantity = outBoundQuantity;
      this.outBoundTotalLength = outBoundTotalLength;
      this.outBoundTotalArea = outBoundTotalArea;
      this.outMounthBoundQuantity = outMounthBoundQuantity;
      this.outMounthBoundTotalLength = outMounthBoundTotalLength;
      this.outMounthBoundTotalArea = outMounthBoundTotalArea;
      this.stockQuantity = stockQuantity;
      this.stockTotalLength = stockTotalLength;
      this.stockTotalArea = stockTotalArea;
      this.packageQuantity = packageQuantity;
      this.packageTotalLength = packageTotalLength;
      this.packageTotalArea = packageTotalArea;
      this.trainNumber = trainNumber;
   }

   public ProjectCargoListSumEnclosureDetailDTO() {
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingTotalLength() {
      return this.schedulingTotalLength;
   }

   public BigDecimal getSchedulingTotalArea() {
      return this.schedulingTotalArea;
   }

   public Integer getInBoundQuantity() {
      return this.inBoundQuantity;
   }

   public BigDecimal getInBoundTotalLength() {
      return this.inBoundTotalLength;
   }

   public BigDecimal getInBoundTotalArea() {
      return this.inBoundTotalArea;
   }

   public Integer getOutBoundQuantity() {
      return this.outBoundQuantity;
   }

   public BigDecimal getOutBoundTotalLength() {
      return this.outBoundTotalLength;
   }

   public BigDecimal getOutBoundTotalArea() {
      return this.outBoundTotalArea;
   }

   public Integer getOutMounthBoundQuantity() {
      return this.outMounthBoundQuantity;
   }

   public BigDecimal getOutMounthBoundTotalLength() {
      return this.outMounthBoundTotalLength;
   }

   public BigDecimal getOutMounthBoundTotalArea() {
      return this.outMounthBoundTotalArea;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getStockTotalLength() {
      return this.stockTotalLength;
   }

   public BigDecimal getStockTotalArea() {
      return this.stockTotalArea;
   }

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getPackageTotalLength() {
      return this.packageTotalLength;
   }

   public BigDecimal getPackageTotalArea() {
      return this.packageTotalArea;
   }

   public Integer getTrainNumber() {
      return this.trainNumber;
   }

   @JsonProperty("projectInfo")
   public void setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("totalArea")
   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("schedulingQuantity")
   public void setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
   }

   @JsonProperty("schedulingTotalLength")
   public void setSchedulingTotalLength(final BigDecimal schedulingTotalLength) {
      this.schedulingTotalLength = schedulingTotalLength;
   }

   @JsonProperty("schedulingTotalArea")
   public void setSchedulingTotalArea(final BigDecimal schedulingTotalArea) {
      this.schedulingTotalArea = schedulingTotalArea;
   }

   @JsonProperty("inBoundQuantity")
   public void setInBoundQuantity(final Integer inBoundQuantity) {
      this.inBoundQuantity = inBoundQuantity;
   }

   @JsonProperty("inBoundTotalLength")
   public void setInBoundTotalLength(final BigDecimal inBoundTotalLength) {
      this.inBoundTotalLength = inBoundTotalLength;
   }

   @JsonProperty("inBoundTotalArea")
   public void setInBoundTotalArea(final BigDecimal inBoundTotalArea) {
      this.inBoundTotalArea = inBoundTotalArea;
   }

   @JsonProperty("outBoundQuantity")
   public void setOutBoundQuantity(final Integer outBoundQuantity) {
      this.outBoundQuantity = outBoundQuantity;
   }

   @JsonProperty("outBoundTotalLength")
   public void setOutBoundTotalLength(final BigDecimal outBoundTotalLength) {
      this.outBoundTotalLength = outBoundTotalLength;
   }

   @JsonProperty("outBoundTotalArea")
   public void setOutBoundTotalArea(final BigDecimal outBoundTotalArea) {
      this.outBoundTotalArea = outBoundTotalArea;
   }

   @JsonProperty("outMounthBoundQuantity")
   public void setOutMounthBoundQuantity(final Integer outMounthBoundQuantity) {
      this.outMounthBoundQuantity = outMounthBoundQuantity;
   }

   @JsonProperty("outMounthBoundTotalLength")
   public void setOutMounthBoundTotalLength(final BigDecimal outMounthBoundTotalLength) {
      this.outMounthBoundTotalLength = outMounthBoundTotalLength;
   }

   @JsonProperty("outMounthBoundTotalArea")
   public void setOutMounthBoundTotalArea(final BigDecimal outMounthBoundTotalArea) {
      this.outMounthBoundTotalArea = outMounthBoundTotalArea;
   }

   @JsonProperty("stockQuantity")
   public void setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
   }

   @JsonProperty("stockTotalLength")
   public void setStockTotalLength(final BigDecimal stockTotalLength) {
      this.stockTotalLength = stockTotalLength;
   }

   @JsonProperty("stockTotalArea")
   public void setStockTotalArea(final BigDecimal stockTotalArea) {
      this.stockTotalArea = stockTotalArea;
   }

   public void setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
   }

   public void setPackageTotalLength(final BigDecimal packageTotalLength) {
      this.packageTotalLength = packageTotalLength;
   }

   public void setPackageTotalArea(final BigDecimal packageTotalArea) {
      this.packageTotalArea = packageTotalArea;
   }

   @JsonProperty("trainNumber")
   public void setTrainNumber(final Integer trainNumber) {
      this.trainNumber = trainNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListSumEnclosureDetailDTO)) {
         return false;
      }

      ProjectCargoListSumEnclosureDetailDTO other = (ProjectCargoListSumEnclosureDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$inBoundQuantity = this.getInBoundQuantity();
            Object other$inBoundQuantity = other.getInBoundQuantity();
            if (this$inBoundQuantity == null ? other$inBoundQuantity == null : this$inBoundQuantity.equals(other$inBoundQuantity)) {
               Object this$outBoundQuantity = this.getOutBoundQuantity();
               Object other$outBoundQuantity = other.getOutBoundQuantity();
               if (this$outBoundQuantity == null ? other$outBoundQuantity == null : this$outBoundQuantity.equals(other$outBoundQuantity)) {
                  Object this$outMounthBoundQuantity = this.getOutMounthBoundQuantity();
                  Object other$outMounthBoundQuantity = other.getOutMounthBoundQuantity();
                  if (this$outMounthBoundQuantity == null
                     ? other$outMounthBoundQuantity == null
                     : this$outMounthBoundQuantity.equals(other$outMounthBoundQuantity)) {
                     Object this$stockQuantity = this.getStockQuantity();
                     Object other$stockQuantity = other.getStockQuantity();
                     if (this$stockQuantity == null ? other$stockQuantity == null : this$stockQuantity.equals(other$stockQuantity)) {
                        Object this$packageQuantity = this.getPackageQuantity();
                        Object other$packageQuantity = other.getPackageQuantity();
                        if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                           Object this$trainNumber = this.getTrainNumber();
                           Object other$trainNumber = other.getTrainNumber();
                           if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
                              Object this$projectInfo = this.getProjectInfo();
                              Object other$projectInfo = other.getProjectInfo();
                              if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$totalLength = this.getTotalLength();
                                    Object other$totalLength = other.getTotalLength();
                                    if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                       Object this$totalArea = this.getTotalArea();
                                       Object other$totalArea = other.getTotalArea();
                                       if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                          Object this$schedulingTotalLength = this.getSchedulingTotalLength();
                                          Object other$schedulingTotalLength = other.getSchedulingTotalLength();
                                          if (this$schedulingTotalLength == null
                                             ? other$schedulingTotalLength == null
                                             : this$schedulingTotalLength.equals(other$schedulingTotalLength)) {
                                             Object this$schedulingTotalArea = this.getSchedulingTotalArea();
                                             Object other$schedulingTotalArea = other.getSchedulingTotalArea();
                                             if (this$schedulingTotalArea == null
                                                ? other$schedulingTotalArea == null
                                                : this$schedulingTotalArea.equals(other$schedulingTotalArea)) {
                                                Object this$inBoundTotalLength = this.getInBoundTotalLength();
                                                Object other$inBoundTotalLength = other.getInBoundTotalLength();
                                                if (this$inBoundTotalLength == null
                                                   ? other$inBoundTotalLength == null
                                                   : this$inBoundTotalLength.equals(other$inBoundTotalLength)) {
                                                   Object this$inBoundTotalArea = this.getInBoundTotalArea();
                                                   Object other$inBoundTotalArea = other.getInBoundTotalArea();
                                                   if (this$inBoundTotalArea == null
                                                      ? other$inBoundTotalArea == null
                                                      : this$inBoundTotalArea.equals(other$inBoundTotalArea)) {
                                                      Object this$outBoundTotalLength = this.getOutBoundTotalLength();
                                                      Object other$outBoundTotalLength = other.getOutBoundTotalLength();
                                                      if (this$outBoundTotalLength == null
                                                         ? other$outBoundTotalLength == null
                                                         : this$outBoundTotalLength.equals(other$outBoundTotalLength)) {
                                                         Object this$outBoundTotalArea = this.getOutBoundTotalArea();
                                                         Object other$outBoundTotalArea = other.getOutBoundTotalArea();
                                                         if (this$outBoundTotalArea == null
                                                            ? other$outBoundTotalArea == null
                                                            : this$outBoundTotalArea.equals(other$outBoundTotalArea)) {
                                                            Object this$outMounthBoundTotalLength = this.getOutMounthBoundTotalLength();
                                                            Object other$outMounthBoundTotalLength = other.getOutMounthBoundTotalLength();
                                                            if (this$outMounthBoundTotalLength == null
                                                               ? other$outMounthBoundTotalLength == null
                                                               : this$outMounthBoundTotalLength.equals(other$outMounthBoundTotalLength)) {
                                                               Object this$outMounthBoundTotalArea = this.getOutMounthBoundTotalArea();
                                                               Object other$outMounthBoundTotalArea = other.getOutMounthBoundTotalArea();
                                                               if (this$outMounthBoundTotalArea == null
                                                                  ? other$outMounthBoundTotalArea == null
                                                                  : this$outMounthBoundTotalArea.equals(other$outMounthBoundTotalArea)) {
                                                                  Object this$stockTotalLength = this.getStockTotalLength();
                                                                  Object other$stockTotalLength = other.getStockTotalLength();
                                                                  if (this$stockTotalLength == null
                                                                     ? other$stockTotalLength == null
                                                                     : this$stockTotalLength.equals(other$stockTotalLength)) {
                                                                     Object this$stockTotalArea = this.getStockTotalArea();
                                                                     Object other$stockTotalArea = other.getStockTotalArea();
                                                                     if (this$stockTotalArea == null
                                                                        ? other$stockTotalArea == null
                                                                        : this$stockTotalArea.equals(other$stockTotalArea)) {
                                                                        Object this$packageTotalLength = this.getPackageTotalLength();
                                                                        Object other$packageTotalLength = other.getPackageTotalLength();
                                                                        if (this$packageTotalLength == null
                                                                           ? other$packageTotalLength == null
                                                                           : this$packageTotalLength.equals(other$packageTotalLength)) {
                                                                           Object this$packageTotalArea = this.getPackageTotalArea();
                                                                           Object other$packageTotalArea = other.getPackageTotalArea();
                                                                           return this$packageTotalArea == null
                                                                              ? other$packageTotalArea == null
                                                                              : this$packageTotalArea.equals(other$packageTotalArea);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectCargoListSumEnclosureDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $inBoundQuantity = this.getInBoundQuantity();
      result = result * 59 + ($inBoundQuantity == null ? 43 : $inBoundQuantity.hashCode());
      Object $outBoundQuantity = this.getOutBoundQuantity();
      result = result * 59 + ($outBoundQuantity == null ? 43 : $outBoundQuantity.hashCode());
      Object $outMounthBoundQuantity = this.getOutMounthBoundQuantity();
      result = result * 59 + ($outMounthBoundQuantity == null ? 43 : $outMounthBoundQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $schedulingTotalLength = this.getSchedulingTotalLength();
      result = result * 59 + ($schedulingTotalLength == null ? 43 : $schedulingTotalLength.hashCode());
      Object $schedulingTotalArea = this.getSchedulingTotalArea();
      result = result * 59 + ($schedulingTotalArea == null ? 43 : $schedulingTotalArea.hashCode());
      Object $inBoundTotalLength = this.getInBoundTotalLength();
      result = result * 59 + ($inBoundTotalLength == null ? 43 : $inBoundTotalLength.hashCode());
      Object $inBoundTotalArea = this.getInBoundTotalArea();
      result = result * 59 + ($inBoundTotalArea == null ? 43 : $inBoundTotalArea.hashCode());
      Object $outBoundTotalLength = this.getOutBoundTotalLength();
      result = result * 59 + ($outBoundTotalLength == null ? 43 : $outBoundTotalLength.hashCode());
      Object $outBoundTotalArea = this.getOutBoundTotalArea();
      result = result * 59 + ($outBoundTotalArea == null ? 43 : $outBoundTotalArea.hashCode());
      Object $outMounthBoundTotalLength = this.getOutMounthBoundTotalLength();
      result = result * 59 + ($outMounthBoundTotalLength == null ? 43 : $outMounthBoundTotalLength.hashCode());
      Object $outMounthBoundTotalArea = this.getOutMounthBoundTotalArea();
      result = result * 59 + ($outMounthBoundTotalArea == null ? 43 : $outMounthBoundTotalArea.hashCode());
      Object $stockTotalLength = this.getStockTotalLength();
      result = result * 59 + ($stockTotalLength == null ? 43 : $stockTotalLength.hashCode());
      Object $stockTotalArea = this.getStockTotalArea();
      result = result * 59 + ($stockTotalArea == null ? 43 : $stockTotalArea.hashCode());
      Object $packageTotalLength = this.getPackageTotalLength();
      result = result * 59 + ($packageTotalLength == null ? 43 : $packageTotalLength.hashCode());
      Object $packageTotalArea = this.getPackageTotalArea();
      return result * 59 + ($packageTotalArea == null ? 43 : $packageTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListSumEnclosureDetailDTO(projectInfo="
         + this.getProjectInfo()
         + ", workshop="
         + this.getWorkshop()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalLength="
         + this.getSchedulingTotalLength()
         + ", schedulingTotalArea="
         + this.getSchedulingTotalArea()
         + ", inBoundQuantity="
         + this.getInBoundQuantity()
         + ", inBoundTotalLength="
         + this.getInBoundTotalLength()
         + ", inBoundTotalArea="
         + this.getInBoundTotalArea()
         + ", outBoundQuantity="
         + this.getOutBoundQuantity()
         + ", outBoundTotalLength="
         + this.getOutBoundTotalLength()
         + ", outBoundTotalArea="
         + this.getOutBoundTotalArea()
         + ", outMounthBoundQuantity="
         + this.getOutMounthBoundQuantity()
         + ", outMounthBoundTotalLength="
         + this.getOutMounthBoundTotalLength()
         + ", outMounthBoundTotalArea="
         + this.getOutMounthBoundTotalArea()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", stockTotalLength="
         + this.getStockTotalLength()
         + ", stockTotalArea="
         + this.getStockTotalArea()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", packageTotalLength="
         + this.getPackageTotalLength()
         + ", packageTotalArea="
         + this.getPackageTotalArea()
         + ", trainNumber="
         + this.getTrainNumber()
         + ")";
   }

   public static class ProjectCargoListSumEnclosureDetailDTOBuilder {
      private ProjectInfo projectInfo;
      private WorkshopDetailDO workshop;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer quantity;
      private Integer schedulingQuantity;
      private BigDecimal schedulingTotalLength;
      private BigDecimal schedulingTotalArea;
      private Integer inBoundQuantity;
      private BigDecimal inBoundTotalLength;
      private BigDecimal inBoundTotalArea;
      private Integer outBoundQuantity;
      private BigDecimal outBoundTotalLength;
      private BigDecimal outBoundTotalArea;
      private Integer outMounthBoundQuantity;
      private BigDecimal outMounthBoundTotalLength;
      private BigDecimal outMounthBoundTotalArea;
      private Integer stockQuantity;
      private BigDecimal stockTotalLength;
      private BigDecimal stockTotalArea;
      private Integer packageQuantity;
      private BigDecimal packageTotalLength;
      private BigDecimal packageTotalArea;
      private Integer trainNumber;

      ProjectCargoListSumEnclosureDetailDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("workshop")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("totalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("schedulingTotalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder schedulingTotalLength(final BigDecimal schedulingTotalLength) {
         this.schedulingTotalLength = schedulingTotalLength;
         return this;
      }

      @JsonProperty("schedulingTotalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder schedulingTotalArea(final BigDecimal schedulingTotalArea) {
         this.schedulingTotalArea = schedulingTotalArea;
         return this;
      }

      @JsonProperty("inBoundQuantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder inBoundQuantity(final Integer inBoundQuantity) {
         this.inBoundQuantity = inBoundQuantity;
         return this;
      }

      @JsonProperty("inBoundTotalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder inBoundTotalLength(final BigDecimal inBoundTotalLength) {
         this.inBoundTotalLength = inBoundTotalLength;
         return this;
      }

      @JsonProperty("inBoundTotalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder inBoundTotalArea(final BigDecimal inBoundTotalArea) {
         this.inBoundTotalArea = inBoundTotalArea;
         return this;
      }

      @JsonProperty("outBoundQuantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outBoundQuantity(final Integer outBoundQuantity) {
         this.outBoundQuantity = outBoundQuantity;
         return this;
      }

      @JsonProperty("outBoundTotalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outBoundTotalLength(final BigDecimal outBoundTotalLength) {
         this.outBoundTotalLength = outBoundTotalLength;
         return this;
      }

      @JsonProperty("outBoundTotalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outBoundTotalArea(final BigDecimal outBoundTotalArea) {
         this.outBoundTotalArea = outBoundTotalArea;
         return this;
      }

      @JsonProperty("outMounthBoundQuantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outMounthBoundQuantity(final Integer outMounthBoundQuantity) {
         this.outMounthBoundQuantity = outMounthBoundQuantity;
         return this;
      }

      @JsonProperty("outMounthBoundTotalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outMounthBoundTotalLength(
         final BigDecimal outMounthBoundTotalLength
      ) {
         this.outMounthBoundTotalLength = outMounthBoundTotalLength;
         return this;
      }

      @JsonProperty("outMounthBoundTotalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder outMounthBoundTotalArea(
         final BigDecimal outMounthBoundTotalArea
      ) {
         this.outMounthBoundTotalArea = outMounthBoundTotalArea;
         return this;
      }

      @JsonProperty("stockQuantity")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder stockQuantity(final Integer stockQuantity) {
         this.stockQuantity = stockQuantity;
         return this;
      }

      @JsonProperty("stockTotalLength")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder stockTotalLength(final BigDecimal stockTotalLength) {
         this.stockTotalLength = stockTotalLength;
         return this;
      }

      @JsonProperty("stockTotalArea")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder stockTotalArea(final BigDecimal stockTotalArea) {
         this.stockTotalArea = stockTotalArea;
         return this;
      }

      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder packageTotalLength(final BigDecimal packageTotalLength) {
         this.packageTotalLength = packageTotalLength;
         return this;
      }

      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder packageTotalArea(final BigDecimal packageTotalArea) {
         this.packageTotalArea = packageTotalArea;
         return this;
      }

      @JsonProperty("trainNumber")
      public ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder trainNumber(final Integer trainNumber) {
         this.trainNumber = trainNumber;
         return this;
      }

      public ProjectCargoListSumEnclosureDetailDTO build() {
         return new ProjectCargoListSumEnclosureDetailDTO(
            this.projectInfo,
            this.workshop,
            this.totalLength,
            this.totalArea,
            this.quantity,
            this.schedulingQuantity,
            this.schedulingTotalLength,
            this.schedulingTotalArea,
            this.inBoundQuantity,
            this.inBoundTotalLength,
            this.inBoundTotalArea,
            this.outBoundQuantity,
            this.outBoundTotalLength,
            this.outBoundTotalArea,
            this.outMounthBoundQuantity,
            this.outMounthBoundTotalLength,
            this.outMounthBoundTotalArea,
            this.stockQuantity,
            this.stockTotalLength,
            this.stockTotalArea,
            this.packageQuantity,
            this.packageTotalLength,
            this.packageTotalArea,
            this.trainNumber
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListSumEnclosureDetailDTO.ProjectCargoListSumEnclosureDetailDTOBuilder(projectInfo="
            + this.projectInfo
            + ", workshop="
            + this.workshop
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", schedulingTotalLength="
            + this.schedulingTotalLength
            + ", schedulingTotalArea="
            + this.schedulingTotalArea
            + ", inBoundQuantity="
            + this.inBoundQuantity
            + ", inBoundTotalLength="
            + this.inBoundTotalLength
            + ", inBoundTotalArea="
            + this.inBoundTotalArea
            + ", outBoundQuantity="
            + this.outBoundQuantity
            + ", outBoundTotalLength="
            + this.outBoundTotalLength
            + ", outBoundTotalArea="
            + this.outBoundTotalArea
            + ", outMounthBoundQuantity="
            + this.outMounthBoundQuantity
            + ", outMounthBoundTotalLength="
            + this.outMounthBoundTotalLength
            + ", outMounthBoundTotalArea="
            + this.outMounthBoundTotalArea
            + ", stockQuantity="
            + this.stockQuantity
            + ", stockTotalLength="
            + this.stockTotalLength
            + ", stockTotalArea="
            + this.stockTotalArea
            + ", packageQuantity="
            + this.packageQuantity
            + ", packageTotalLength="
            + this.packageTotalLength
            + ", packageTotalArea="
            + this.packageTotalArea
            + ", trainNumber="
            + this.trainNumber
            + ")";
      }
   }
}
