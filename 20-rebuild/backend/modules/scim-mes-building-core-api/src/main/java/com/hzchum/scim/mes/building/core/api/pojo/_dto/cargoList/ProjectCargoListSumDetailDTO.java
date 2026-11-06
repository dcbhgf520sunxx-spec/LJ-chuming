package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目发运分类信息")
public class ProjectCargoListSumDetailDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目基础信息", notes = "项目基础信息")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "mete", value = "清单总量(净重)", notes = "清单总量(净重)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "grossMete", value = "清单总量(毛重)", notes = "清单总量(毛重)")
   @JsonProperty("grossMete")
   @JSONField(name = "grossMete")
   private BigDecimal grossMete;
   @ApiModelProperty(name = "quantity", value = "清单总数", notes = "清单总数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产总数", notes = "排产总数")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingMete", value = "排产总量(净重)", notes = "排产总量(净重)")
   @JsonProperty("schedulingMete")
   @JSONField(name = "schedulingMete")
   private BigDecimal schedulingMete;
   @ApiModelProperty(name = "schedulingGrossMete", value = "排产总量(毛重)", notes = "排产总量(毛重)")
   @JsonProperty("schedulingGrossMete")
   @JSONField(name = "schedulingGrossMete")
   private BigDecimal schedulingGrossMete;
   @ApiModelProperty(name = "inBoundQuantity", value = "入库总数", notes = "入库总数")
   @JsonProperty("inBoundQuantity")
   @JSONField(name = "inBoundQuantity")
   private Integer inBoundQuantity;
   @ApiModelProperty(name = "inBoundMete", value = "入库总量(净重)", notes = "入库总量(净重)")
   @JsonProperty("inBoundMete")
   @JSONField(name = "inBoundMete")
   private BigDecimal inBoundMete;
   @ApiModelProperty(name = "inBoundGrossMete", value = "入库总量(毛重)", notes = "入库总量(毛重)")
   @JsonProperty("inBoundGrossMete")
   @JSONField(name = "inBoundGrossMete")
   private BigDecimal inBoundGrossMete;
   @ApiModelProperty(name = "outBoundQuantity", value = "发运总数", notes = "发运总数")
   @JsonProperty("outBoundQuantity")
   @JSONField(name = "outBoundQuantity")
   private Integer outBoundQuantity;
   @ApiModelProperty(name = "outBoundMete", value = "发运总量(净重)", notes = "发运总量(净重)")
   @JsonProperty("outBoundMete")
   @JSONField(name = "outBoundMete")
   private BigDecimal outBoundMete;
   @ApiModelProperty(name = "outBoundGrossMete", value = "发运总量(毛重)", notes = "发运总量(毛重)")
   @JsonProperty("outBoundGrossMete")
   @JSONField(name = "outBoundGrossMete")
   private BigDecimal outBoundGrossMete;
   @ApiModelProperty(name = "outMounthBoundQuantity", value = "本月发运总数", notes = "本月发运总数")
   @JsonProperty("outMounthBoundQuantity")
   @JSONField(name = "outMounthBoundQuantity")
   private Integer outMounthBoundQuantity;
   @ApiModelProperty(name = "outMounthBoundMete", value = "本月发运总量(净重)", notes = "本月发运总量(净重)")
   @JsonProperty("outMounthBoundMete")
   @JSONField(name = "outMounthBoundMete")
   private BigDecimal outMounthBoundMete;
   @ApiModelProperty(name = "outMounthBoundGrossMete", value = "本月发运总量(毛重)", notes = "本月发运总量(毛重)")
   @JsonProperty("outMounthBoundGrossMete")
   @JSONField(name = "outMounthBoundGrossMete")
   private BigDecimal outMounthBoundGrossMete;
   @ApiModelProperty(name = "stockQuantity", notes = "库存数量", value = "库存数量")
   @JsonProperty("stockQuantity")
   @JSONField(name = "stockQuantity")
   private Integer stockQuantity;
   @ApiModelProperty(name = "stockMete", notes = "库存总量(净重)", value = "库存总量(净重)")
   @JsonProperty("stockMete")
   @JSONField(name = "stockMete")
   private BigDecimal stockMete;
   @ApiModelProperty(name = "stockGrossMete", notes = "库存总量(毛重)", value = "库存总量(毛重)")
   @JsonProperty("stockGrossMete")
   @JSONField(name = "stockGrossMete")
   private BigDecimal stockGrossMete;
   @ApiModelProperty(name = "packageQuantity", notes = "打包未装车数量", value = "打包未装车数量")
   @JsonProperty("packageQuantity")
   @JSONField(name = "packageQuantity")
   private Integer packageQuantity;
   @ApiModelProperty(name = "packageMete", notes = "打包总净重", value = "打包总净重")
   @JsonProperty("packageMete")
   @JSONField(name = "packageMete")
   private BigDecimal packageMete;
   @ApiModelProperty(name = "packageGrossMete", notes = "打包总毛重", value = "打包总毛重")
   @JsonProperty("packageGrossMete")
   @JSONField(name = "packageGrossMete")
   private BigDecimal packageGrossMete;
   @ApiModelProperty(name = "trainNumber", notes = "累计车次", value = "累计车次")
   @JsonProperty("trainNumber")
   @JSONField(name = "trainNumber")
   private Integer trainNumber;

   public static ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder builder() {
      return new ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder();
   }

   public ProjectCargoListSumDetailDTO(
      final ProjectInfo projectInfo,
      final WorkshopDetailDO workshop,
      final BigDecimal mete,
      final BigDecimal grossMete,
      final Integer quantity,
      final Integer schedulingQuantity,
      final BigDecimal schedulingMete,
      final BigDecimal schedulingGrossMete,
      final Integer inBoundQuantity,
      final BigDecimal inBoundMete,
      final BigDecimal inBoundGrossMete,
      final Integer outBoundQuantity,
      final BigDecimal outBoundMete,
      final BigDecimal outBoundGrossMete,
      final Integer outMounthBoundQuantity,
      final BigDecimal outMounthBoundMete,
      final BigDecimal outMounthBoundGrossMete,
      final Integer stockQuantity,
      final BigDecimal stockMete,
      final BigDecimal stockGrossMete,
      final Integer packageQuantity,
      final BigDecimal packageMete,
      final BigDecimal packageGrossMete,
      final Integer trainNumber
   ) {
      this.projectInfo = projectInfo;
      this.workshop = workshop;
      this.mete = mete;
      this.grossMete = grossMete;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.schedulingMete = schedulingMete;
      this.schedulingGrossMete = schedulingGrossMete;
      this.inBoundQuantity = inBoundQuantity;
      this.inBoundMete = inBoundMete;
      this.inBoundGrossMete = inBoundGrossMete;
      this.outBoundQuantity = outBoundQuantity;
      this.outBoundMete = outBoundMete;
      this.outBoundGrossMete = outBoundGrossMete;
      this.outMounthBoundQuantity = outMounthBoundQuantity;
      this.outMounthBoundMete = outMounthBoundMete;
      this.outMounthBoundGrossMete = outMounthBoundGrossMete;
      this.stockQuantity = stockQuantity;
      this.stockMete = stockMete;
      this.stockGrossMete = stockGrossMete;
      this.packageQuantity = packageQuantity;
      this.packageMete = packageMete;
      this.packageGrossMete = packageGrossMete;
      this.trainNumber = trainNumber;
   }

   public ProjectCargoListSumDetailDTO() {
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getGrossMete() {
      return this.grossMete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingMete() {
      return this.schedulingMete;
   }

   public BigDecimal getSchedulingGrossMete() {
      return this.schedulingGrossMete;
   }

   public Integer getInBoundQuantity() {
      return this.inBoundQuantity;
   }

   public BigDecimal getInBoundMete() {
      return this.inBoundMete;
   }

   public BigDecimal getInBoundGrossMete() {
      return this.inBoundGrossMete;
   }

   public Integer getOutBoundQuantity() {
      return this.outBoundQuantity;
   }

   public BigDecimal getOutBoundMete() {
      return this.outBoundMete;
   }

   public BigDecimal getOutBoundGrossMete() {
      return this.outBoundGrossMete;
   }

   public Integer getOutMounthBoundQuantity() {
      return this.outMounthBoundQuantity;
   }

   public BigDecimal getOutMounthBoundMete() {
      return this.outMounthBoundMete;
   }

   public BigDecimal getOutMounthBoundGrossMete() {
      return this.outMounthBoundGrossMete;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public BigDecimal getStockGrossMete() {
      return this.stockGrossMete;
   }

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getPackageMete() {
      return this.packageMete;
   }

   public BigDecimal getPackageGrossMete() {
      return this.packageGrossMete;
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

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("grossMete")
   public void setGrossMete(final BigDecimal grossMete) {
      this.grossMete = grossMete;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("schedulingQuantity")
   public void setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
   }

   @JsonProperty("schedulingMete")
   public void setSchedulingMete(final BigDecimal schedulingMete) {
      this.schedulingMete = schedulingMete;
   }

   @JsonProperty("schedulingGrossMete")
   public void setSchedulingGrossMete(final BigDecimal schedulingGrossMete) {
      this.schedulingGrossMete = schedulingGrossMete;
   }

   @JsonProperty("inBoundQuantity")
   public void setInBoundQuantity(final Integer inBoundQuantity) {
      this.inBoundQuantity = inBoundQuantity;
   }

   @JsonProperty("inBoundMete")
   public void setInBoundMete(final BigDecimal inBoundMete) {
      this.inBoundMete = inBoundMete;
   }

   @JsonProperty("inBoundGrossMete")
   public void setInBoundGrossMete(final BigDecimal inBoundGrossMete) {
      this.inBoundGrossMete = inBoundGrossMete;
   }

   @JsonProperty("outBoundQuantity")
   public void setOutBoundQuantity(final Integer outBoundQuantity) {
      this.outBoundQuantity = outBoundQuantity;
   }

   @JsonProperty("outBoundMete")
   public void setOutBoundMete(final BigDecimal outBoundMete) {
      this.outBoundMete = outBoundMete;
   }

   @JsonProperty("outBoundGrossMete")
   public void setOutBoundGrossMete(final BigDecimal outBoundGrossMete) {
      this.outBoundGrossMete = outBoundGrossMete;
   }

   @JsonProperty("outMounthBoundQuantity")
   public void setOutMounthBoundQuantity(final Integer outMounthBoundQuantity) {
      this.outMounthBoundQuantity = outMounthBoundQuantity;
   }

   @JsonProperty("outMounthBoundMete")
   public void setOutMounthBoundMete(final BigDecimal outMounthBoundMete) {
      this.outMounthBoundMete = outMounthBoundMete;
   }

   @JsonProperty("outMounthBoundGrossMete")
   public void setOutMounthBoundGrossMete(final BigDecimal outMounthBoundGrossMete) {
      this.outMounthBoundGrossMete = outMounthBoundGrossMete;
   }

   @JsonProperty("stockQuantity")
   public void setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
   }

   @JsonProperty("stockMete")
   public void setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
   }

   @JsonProperty("stockGrossMete")
   public void setStockGrossMete(final BigDecimal stockGrossMete) {
      this.stockGrossMete = stockGrossMete;
   }

   @JsonProperty("packageQuantity")
   public void setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
   }

   @JsonProperty("packageMete")
   public void setPackageMete(final BigDecimal packageMete) {
      this.packageMete = packageMete;
   }

   @JsonProperty("packageGrossMete")
   public void setPackageGrossMete(final BigDecimal packageGrossMete) {
      this.packageGrossMete = packageGrossMete;
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

      if (!(o instanceof ProjectCargoListSumDetailDTO)) {
         return false;
      }

      ProjectCargoListSumDetailDTO other = (ProjectCargoListSumDetailDTO)o;
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
                                    Object this$mete = this.getMete();
                                    Object other$mete = other.getMete();
                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                       Object this$grossMete = this.getGrossMete();
                                       Object other$grossMete = other.getGrossMete();
                                       if (this$grossMete == null ? other$grossMete == null : this$grossMete.equals(other$grossMete)) {
                                          Object this$schedulingMete = this.getSchedulingMete();
                                          Object other$schedulingMete = other.getSchedulingMete();
                                          if (this$schedulingMete == null ? other$schedulingMete == null : this$schedulingMete.equals(other$schedulingMete)) {
                                             Object this$schedulingGrossMete = this.getSchedulingGrossMete();
                                             Object other$schedulingGrossMete = other.getSchedulingGrossMete();
                                             if (this$schedulingGrossMete == null
                                                ? other$schedulingGrossMete == null
                                                : this$schedulingGrossMete.equals(other$schedulingGrossMete)) {
                                                Object this$inBoundMete = this.getInBoundMete();
                                                Object other$inBoundMete = other.getInBoundMete();
                                                if (this$inBoundMete == null ? other$inBoundMete == null : this$inBoundMete.equals(other$inBoundMete)) {
                                                   Object this$inBoundGrossMete = this.getInBoundGrossMete();
                                                   Object other$inBoundGrossMete = other.getInBoundGrossMete();
                                                   if (this$inBoundGrossMete == null
                                                      ? other$inBoundGrossMete == null
                                                      : this$inBoundGrossMete.equals(other$inBoundGrossMete)) {
                                                      Object this$outBoundMete = this.getOutBoundMete();
                                                      Object other$outBoundMete = other.getOutBoundMete();
                                                      if (this$outBoundMete == null ? other$outBoundMete == null : this$outBoundMete.equals(other$outBoundMete)
                                                         )
                                                       {
                                                         Object this$outBoundGrossMete = this.getOutBoundGrossMete();
                                                         Object other$outBoundGrossMete = other.getOutBoundGrossMete();
                                                         if (this$outBoundGrossMete == null
                                                            ? other$outBoundGrossMete == null
                                                            : this$outBoundGrossMete.equals(other$outBoundGrossMete)) {
                                                            Object this$outMounthBoundMete = this.getOutMounthBoundMete();
                                                            Object other$outMounthBoundMete = other.getOutMounthBoundMete();
                                                            if (this$outMounthBoundMete == null
                                                               ? other$outMounthBoundMete == null
                                                               : this$outMounthBoundMete.equals(other$outMounthBoundMete)) {
                                                               Object this$outMounthBoundGrossMete = this.getOutMounthBoundGrossMete();
                                                               Object other$outMounthBoundGrossMete = other.getOutMounthBoundGrossMete();
                                                               if (this$outMounthBoundGrossMete == null
                                                                  ? other$outMounthBoundGrossMete == null
                                                                  : this$outMounthBoundGrossMete.equals(other$outMounthBoundGrossMete)) {
                                                                  Object this$stockMete = this.getStockMete();
                                                                  Object other$stockMete = other.getStockMete();
                                                                  if (this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete)
                                                                     )
                                                                   {
                                                                     Object this$stockGrossMete = this.getStockGrossMete();
                                                                     Object other$stockGrossMete = other.getStockGrossMete();
                                                                     if (this$stockGrossMete == null
                                                                        ? other$stockGrossMete == null
                                                                        : this$stockGrossMete.equals(other$stockGrossMete)) {
                                                                        Object this$packageMete = this.getPackageMete();
                                                                        Object other$packageMete = other.getPackageMete();
                                                                        if (this$packageMete == null
                                                                           ? other$packageMete == null
                                                                           : this$packageMete.equals(other$packageMete)) {
                                                                           Object this$packageGrossMete = this.getPackageGrossMete();
                                                                           Object other$packageGrossMete = other.getPackageGrossMete();
                                                                           return this$packageGrossMete == null
                                                                              ? other$packageGrossMete == null
                                                                              : this$packageGrossMete.equals(other$packageGrossMete);
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
      return other instanceof ProjectCargoListSumDetailDTO;
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
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $grossMete = this.getGrossMete();
      result = result * 59 + ($grossMete == null ? 43 : $grossMete.hashCode());
      Object $schedulingMete = this.getSchedulingMete();
      result = result * 59 + ($schedulingMete == null ? 43 : $schedulingMete.hashCode());
      Object $schedulingGrossMete = this.getSchedulingGrossMete();
      result = result * 59 + ($schedulingGrossMete == null ? 43 : $schedulingGrossMete.hashCode());
      Object $inBoundMete = this.getInBoundMete();
      result = result * 59 + ($inBoundMete == null ? 43 : $inBoundMete.hashCode());
      Object $inBoundGrossMete = this.getInBoundGrossMete();
      result = result * 59 + ($inBoundGrossMete == null ? 43 : $inBoundGrossMete.hashCode());
      Object $outBoundMete = this.getOutBoundMete();
      result = result * 59 + ($outBoundMete == null ? 43 : $outBoundMete.hashCode());
      Object $outBoundGrossMete = this.getOutBoundGrossMete();
      result = result * 59 + ($outBoundGrossMete == null ? 43 : $outBoundGrossMete.hashCode());
      Object $outMounthBoundMete = this.getOutMounthBoundMete();
      result = result * 59 + ($outMounthBoundMete == null ? 43 : $outMounthBoundMete.hashCode());
      Object $outMounthBoundGrossMete = this.getOutMounthBoundGrossMete();
      result = result * 59 + ($outMounthBoundGrossMete == null ? 43 : $outMounthBoundGrossMete.hashCode());
      Object $stockMete = this.getStockMete();
      result = result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
      Object $stockGrossMete = this.getStockGrossMete();
      result = result * 59 + ($stockGrossMete == null ? 43 : $stockGrossMete.hashCode());
      Object $packageMete = this.getPackageMete();
      result = result * 59 + ($packageMete == null ? 43 : $packageMete.hashCode());
      Object $packageGrossMete = this.getPackageGrossMete();
      return result * 59 + ($packageGrossMete == null ? 43 : $packageGrossMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListSumDetailDTO(projectInfo="
         + this.getProjectInfo()
         + ", workshop="
         + this.getWorkshop()
         + ", mete="
         + this.getMete()
         + ", grossMete="
         + this.getGrossMete()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingMete="
         + this.getSchedulingMete()
         + ", schedulingGrossMete="
         + this.getSchedulingGrossMete()
         + ", inBoundQuantity="
         + this.getInBoundQuantity()
         + ", inBoundMete="
         + this.getInBoundMete()
         + ", inBoundGrossMete="
         + this.getInBoundGrossMete()
         + ", outBoundQuantity="
         + this.getOutBoundQuantity()
         + ", outBoundMete="
         + this.getOutBoundMete()
         + ", outBoundGrossMete="
         + this.getOutBoundGrossMete()
         + ", outMounthBoundQuantity="
         + this.getOutMounthBoundQuantity()
         + ", outMounthBoundMete="
         + this.getOutMounthBoundMete()
         + ", outMounthBoundGrossMete="
         + this.getOutMounthBoundGrossMete()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", stockMete="
         + this.getStockMete()
         + ", stockGrossMete="
         + this.getStockGrossMete()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", packageMete="
         + this.getPackageMete()
         + ", packageGrossMete="
         + this.getPackageGrossMete()
         + ", trainNumber="
         + this.getTrainNumber()
         + ")";
   }

   public static class ProjectCargoListSumDetailDTOBuilder {
      private ProjectInfo projectInfo;
      private WorkshopDetailDO workshop;
      private BigDecimal mete;
      private BigDecimal grossMete;
      private Integer quantity;
      private Integer schedulingQuantity;
      private BigDecimal schedulingMete;
      private BigDecimal schedulingGrossMete;
      private Integer inBoundQuantity;
      private BigDecimal inBoundMete;
      private BigDecimal inBoundGrossMete;
      private Integer outBoundQuantity;
      private BigDecimal outBoundMete;
      private BigDecimal outBoundGrossMete;
      private Integer outMounthBoundQuantity;
      private BigDecimal outMounthBoundMete;
      private BigDecimal outMounthBoundGrossMete;
      private Integer stockQuantity;
      private BigDecimal stockMete;
      private BigDecimal stockGrossMete;
      private Integer packageQuantity;
      private BigDecimal packageMete;
      private BigDecimal packageGrossMete;
      private Integer trainNumber;

      ProjectCargoListSumDetailDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("workshop")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("mete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("grossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder grossMete(final BigDecimal grossMete) {
         this.grossMete = grossMete;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("schedulingMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder schedulingMete(final BigDecimal schedulingMete) {
         this.schedulingMete = schedulingMete;
         return this;
      }

      @JsonProperty("schedulingGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder schedulingGrossMete(final BigDecimal schedulingGrossMete) {
         this.schedulingGrossMete = schedulingGrossMete;
         return this;
      }

      @JsonProperty("inBoundQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder inBoundQuantity(final Integer inBoundQuantity) {
         this.inBoundQuantity = inBoundQuantity;
         return this;
      }

      @JsonProperty("inBoundMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder inBoundMete(final BigDecimal inBoundMete) {
         this.inBoundMete = inBoundMete;
         return this;
      }

      @JsonProperty("inBoundGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder inBoundGrossMete(final BigDecimal inBoundGrossMete) {
         this.inBoundGrossMete = inBoundGrossMete;
         return this;
      }

      @JsonProperty("outBoundQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outBoundQuantity(final Integer outBoundQuantity) {
         this.outBoundQuantity = outBoundQuantity;
         return this;
      }

      @JsonProperty("outBoundMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outBoundMete(final BigDecimal outBoundMete) {
         this.outBoundMete = outBoundMete;
         return this;
      }

      @JsonProperty("outBoundGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outBoundGrossMete(final BigDecimal outBoundGrossMete) {
         this.outBoundGrossMete = outBoundGrossMete;
         return this;
      }

      @JsonProperty("outMounthBoundQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outMounthBoundQuantity(final Integer outMounthBoundQuantity) {
         this.outMounthBoundQuantity = outMounthBoundQuantity;
         return this;
      }

      @JsonProperty("outMounthBoundMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outMounthBoundMete(final BigDecimal outMounthBoundMete) {
         this.outMounthBoundMete = outMounthBoundMete;
         return this;
      }

      @JsonProperty("outMounthBoundGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder outMounthBoundGrossMete(final BigDecimal outMounthBoundGrossMete) {
         this.outMounthBoundGrossMete = outMounthBoundGrossMete;
         return this;
      }

      @JsonProperty("stockQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder stockQuantity(final Integer stockQuantity) {
         this.stockQuantity = stockQuantity;
         return this;
      }

      @JsonProperty("stockMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      @JsonProperty("stockGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder stockGrossMete(final BigDecimal stockGrossMete) {
         this.stockGrossMete = stockGrossMete;
         return this;
      }

      @JsonProperty("packageQuantity")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      @JsonProperty("packageMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder packageMete(final BigDecimal packageMete) {
         this.packageMete = packageMete;
         return this;
      }

      @JsonProperty("packageGrossMete")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder packageGrossMete(final BigDecimal packageGrossMete) {
         this.packageGrossMete = packageGrossMete;
         return this;
      }

      @JsonProperty("trainNumber")
      public ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder trainNumber(final Integer trainNumber) {
         this.trainNumber = trainNumber;
         return this;
      }

      public ProjectCargoListSumDetailDTO build() {
         return new ProjectCargoListSumDetailDTO(
            this.projectInfo,
            this.workshop,
            this.mete,
            this.grossMete,
            this.quantity,
            this.schedulingQuantity,
            this.schedulingMete,
            this.schedulingGrossMete,
            this.inBoundQuantity,
            this.inBoundMete,
            this.inBoundGrossMete,
            this.outBoundQuantity,
            this.outBoundMete,
            this.outBoundGrossMete,
            this.outMounthBoundQuantity,
            this.outMounthBoundMete,
            this.outMounthBoundGrossMete,
            this.stockQuantity,
            this.stockMete,
            this.stockGrossMete,
            this.packageQuantity,
            this.packageMete,
            this.packageGrossMete,
            this.trainNumber
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListSumDetailDTO.ProjectCargoListSumDetailDTOBuilder(projectInfo="
            + this.projectInfo
            + ", workshop="
            + this.workshop
            + ", mete="
            + this.mete
            + ", grossMete="
            + this.grossMete
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", schedulingMete="
            + this.schedulingMete
            + ", schedulingGrossMete="
            + this.schedulingGrossMete
            + ", inBoundQuantity="
            + this.inBoundQuantity
            + ", inBoundMete="
            + this.inBoundMete
            + ", inBoundGrossMete="
            + this.inBoundGrossMete
            + ", outBoundQuantity="
            + this.outBoundQuantity
            + ", outBoundMete="
            + this.outBoundMete
            + ", outBoundGrossMete="
            + this.outBoundGrossMete
            + ", outMounthBoundQuantity="
            + this.outMounthBoundQuantity
            + ", outMounthBoundMete="
            + this.outMounthBoundMete
            + ", outMounthBoundGrossMete="
            + this.outMounthBoundGrossMete
            + ", stockQuantity="
            + this.stockQuantity
            + ", stockMete="
            + this.stockMete
            + ", stockGrossMete="
            + this.stockGrossMete
            + ", packageQuantity="
            + this.packageQuantity
            + ", packageMete="
            + this.packageMete
            + ", packageGrossMete="
            + this.packageGrossMete
            + ", trainNumber="
            + this.trainNumber
            + ")";
      }
   }
}
