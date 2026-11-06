package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class StatisticsDTO {
   private Long id;
   private List<Long> ids;
   private Boolean boolPartyA;
   private Long classifyId;
   private String classifySerialNumber;
   private String classifyName;
   private Integer basicClass;
   private String specs;
   private List<String> specifications;
   private BigDecimal thickness;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private Integer invoiceType;
   private ProjectInfo project;
   private Long wapId;
   private BriefIdAndNameDTO workshop;
   private DetailDTO beginPeriod;
   private DetailDTO endPeriod;
   private DetailDTO inbound;
   private DetailDTO transfer;
   private DetailDTO outbound;
   private Long statId;
   private List<Long> statIds;
   private String nationalStandard;
   private Long standardId;
   private Measure measure;
   private String detailKey;
   private Integer weightedPriceType;
   @ApiModelProperty(name = "outboundUnitType", value = "出库方式[1 计量, 2 核算]", notes = "出库方式[1 计量, 2 核算]")
   private Integer outboundUnitType;
   private String materialSnNew;
   private Long statisticsId;

   public static StatisticsDTO.StatisticsDTOBuilder builder() {
      return new StatisticsDTO.StatisticsDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecs() {
      return this.specs;
   }

   public List<String> getSpecifications() {
      return this.specifications;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public DetailDTO getBeginPeriod() {
      return this.beginPeriod;
   }

   public DetailDTO getEndPeriod() {
      return this.endPeriod;
   }

   public DetailDTO getInbound() {
      return this.inbound;
   }

   public DetailDTO getTransfer() {
      return this.transfer;
   }

   public DetailDTO getOutbound() {
      return this.outbound;
   }

   public Long getStatId() {
      return this.statId;
   }

   public List<Long> getStatIds() {
      return this.statIds;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public String getDetailKey() {
      return this.detailKey;
   }

   public Integer getWeightedPriceType() {
      return this.weightedPriceType;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public Long getStatisticsId() {
      return this.statisticsId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecs(final String specs) {
      this.specs = specs;
   }

   public void setSpecifications(final List<String> specifications) {
      this.specifications = specifications;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWapId(final Long wapId) {
      this.wapId = wapId;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setBeginPeriod(final DetailDTO beginPeriod) {
      this.beginPeriod = beginPeriod;
   }

   public void setEndPeriod(final DetailDTO endPeriod) {
      this.endPeriod = endPeriod;
   }

   public void setInbound(final DetailDTO inbound) {
      this.inbound = inbound;
   }

   public void setTransfer(final DetailDTO transfer) {
      this.transfer = transfer;
   }

   public void setOutbound(final DetailDTO outbound) {
      this.outbound = outbound;
   }

   public void setStatId(final Long statId) {
      this.statId = statId;
   }

   public void setStatIds(final List<Long> statIds) {
      this.statIds = statIds;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setDetailKey(final String detailKey) {
      this.detailKey = detailKey;
   }

   public void setWeightedPriceType(final Integer weightedPriceType) {
      this.weightedPriceType = weightedPriceType;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setStatisticsId(final Long statisticsId) {
      this.statisticsId = statisticsId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsDTO)) {
         return false;
      }

      StatisticsDTO other = (StatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$wapId = this.getWapId();
                     Object other$wapId = other.getWapId();
                     if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                        Object this$statId = this.getStatId();
                        Object other$statId = other.getStatId();
                        if (this$statId == null ? other$statId == null : this$statId.equals(other$statId)) {
                           Object this$standardId = this.getStandardId();
                           Object other$standardId = other.getStandardId();
                           if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                              Object this$weightedPriceType = this.getWeightedPriceType();
                              Object other$weightedPriceType = other.getWeightedPriceType();
                              if (this$weightedPriceType == null ? other$weightedPriceType == null : this$weightedPriceType.equals(other$weightedPriceType)) {
                                 Object this$outboundUnitType = this.getOutboundUnitType();
                                 Object other$outboundUnitType = other.getOutboundUnitType();
                                 if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                                    Object this$statisticsId = this.getStatisticsId();
                                    Object other$statisticsId = other.getStatisticsId();
                                    if (this$statisticsId == null ? other$statisticsId == null : this$statisticsId.equals(other$statisticsId)) {
                                       Object this$ids = this.getIds();
                                       Object other$ids = other.getIds();
                                       if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
                                          Object this$classifySerialNumber = this.getClassifySerialNumber();
                                          Object other$classifySerialNumber = other.getClassifySerialNumber();
                                          if (this$classifySerialNumber == null
                                             ? other$classifySerialNumber == null
                                             : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                             Object this$classifyName = this.getClassifyName();
                                             Object other$classifyName = other.getClassifyName();
                                             if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                Object this$specs = this.getSpecs();
                                                Object other$specs = other.getSpecs();
                                                if (this$specs == null ? other$specs == null : this$specs.equals(other$specs)) {
                                                   Object this$specifications = this.getSpecifications();
                                                   Object other$specifications = other.getSpecifications();
                                                   if (this$specifications == null
                                                      ? other$specifications == null
                                                      : this$specifications.equals(other$specifications)) {
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$color = this.getColor();
                                                            Object other$color = other.getColor();
                                                            if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                               Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                               Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                               if (this$heatNoAndBatchNo == null
                                                                  ? other$heatNoAndBatchNo == null
                                                                  : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                  Object this$project = this.getProject();
                                                                  Object other$project = other.getProject();
                                                                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                     Object this$workshop = this.getWorkshop();
                                                                     Object other$workshop = other.getWorkshop();
                                                                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                        Object this$beginPeriod = this.getBeginPeriod();
                                                                        Object other$beginPeriod = other.getBeginPeriod();
                                                                        if (this$beginPeriod == null
                                                                           ? other$beginPeriod == null
                                                                           : this$beginPeriod.equals(other$beginPeriod)) {
                                                                           Object this$endPeriod = this.getEndPeriod();
                                                                           Object other$endPeriod = other.getEndPeriod();
                                                                           if (this$endPeriod == null
                                                                              ? other$endPeriod == null
                                                                              : this$endPeriod.equals(other$endPeriod)) {
                                                                              Object this$inbound = this.getInbound();
                                                                              Object other$inbound = other.getInbound();
                                                                              if (this$inbound == null
                                                                                 ? other$inbound == null
                                                                                 : this$inbound.equals(other$inbound)) {
                                                                                 Object this$transfer = this.getTransfer();
                                                                                 Object other$transfer = other.getTransfer();
                                                                                 if (this$transfer == null
                                                                                    ? other$transfer == null
                                                                                    : this$transfer.equals(other$transfer)) {
                                                                                    Object this$outbound = this.getOutbound();
                                                                                    Object other$outbound = other.getOutbound();
                                                                                    if (this$outbound == null
                                                                                       ? other$outbound == null
                                                                                       : this$outbound.equals(other$outbound)) {
                                                                                       Object this$statIds = this.getStatIds();
                                                                                       Object other$statIds = other.getStatIds();
                                                                                       if (this$statIds == null
                                                                                          ? other$statIds == null
                                                                                          : this$statIds.equals(other$statIds)) {
                                                                                          Object this$nationalStandard = this.getNationalStandard();
                                                                                          Object other$nationalStandard = other.getNationalStandard();
                                                                                          if (this$nationalStandard == null
                                                                                             ? other$nationalStandard == null
                                                                                             : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                             Object this$measure = this.getMeasure();
                                                                                             Object other$measure = other.getMeasure();
                                                                                             if (this$measure == null
                                                                                                ? other$measure == null
                                                                                                : this$measure.equals(other$measure)) {
                                                                                                Object this$detailKey = this.getDetailKey();
                                                                                                Object other$detailKey = other.getDetailKey();
                                                                                                if (this$detailKey == null
                                                                                                   ? other$detailKey == null
                                                                                                   : this$detailKey.equals(other$detailKey)) {
                                                                                                   Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                   Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                   return this$materialSnNew == null
                                                                                                      ? other$materialSnNew == null
                                                                                                      : this$materialSnNew.equals(other$materialSnNew);
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
      return other instanceof StatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $statId = this.getStatId();
      result = result * 59 + ($statId == null ? 43 : $statId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $weightedPriceType = this.getWeightedPriceType();
      result = result * 59 + ($weightedPriceType == null ? 43 : $weightedPriceType.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $statisticsId = this.getStatisticsId();
      result = result * 59 + ($statisticsId == null ? 43 : $statisticsId.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specs = this.getSpecs();
      result = result * 59 + ($specs == null ? 43 : $specs.hashCode());
      Object $specifications = this.getSpecifications();
      result = result * 59 + ($specifications == null ? 43 : $specifications.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $beginPeriod = this.getBeginPeriod();
      result = result * 59 + ($beginPeriod == null ? 43 : $beginPeriod.hashCode());
      Object $endPeriod = this.getEndPeriod();
      result = result * 59 + ($endPeriod == null ? 43 : $endPeriod.hashCode());
      Object $inbound = this.getInbound();
      result = result * 59 + ($inbound == null ? 43 : $inbound.hashCode());
      Object $transfer = this.getTransfer();
      result = result * 59 + ($transfer == null ? 43 : $transfer.hashCode());
      Object $outbound = this.getOutbound();
      result = result * 59 + ($outbound == null ? 43 : $outbound.hashCode());
      Object $statIds = this.getStatIds();
      result = result * 59 + ($statIds == null ? 43 : $statIds.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $detailKey = this.getDetailKey();
      result = result * 59 + ($detailKey == null ? 43 : $detailKey.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "StatisticsDTO(id="
         + this.getId()
         + ", ids="
         + this.getIds()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specs="
         + this.getSpecs()
         + ", specifications="
         + this.getSpecifications()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", project="
         + this.getProject()
         + ", wapId="
         + this.getWapId()
         + ", workshop="
         + this.getWorkshop()
         + ", beginPeriod="
         + this.getBeginPeriod()
         + ", endPeriod="
         + this.getEndPeriod()
         + ", inbound="
         + this.getInbound()
         + ", transfer="
         + this.getTransfer()
         + ", outbound="
         + this.getOutbound()
         + ", statId="
         + this.getStatId()
         + ", statIds="
         + this.getStatIds()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", standardId="
         + this.getStandardId()
         + ", measure="
         + this.getMeasure()
         + ", detailKey="
         + this.getDetailKey()
         + ", weightedPriceType="
         + this.getWeightedPriceType()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", statisticsId="
         + this.getStatisticsId()
         + ")";
   }

   public StatisticsDTO(
      final Long id,
      final List<Long> ids,
      final Boolean boolPartyA,
      final Long classifyId,
      final String classifySerialNumber,
      final String classifyName,
      final Integer basicClass,
      final String specs,
      final List<String> specifications,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final Integer invoiceType,
      final ProjectInfo project,
      final Long wapId,
      final BriefIdAndNameDTO workshop,
      final DetailDTO beginPeriod,
      final DetailDTO endPeriod,
      final DetailDTO inbound,
      final DetailDTO transfer,
      final DetailDTO outbound,
      final Long statId,
      final List<Long> statIds,
      final String nationalStandard,
      final Long standardId,
      final Measure measure,
      final String detailKey,
      final Integer weightedPriceType,
      final Integer outboundUnitType,
      final String materialSnNew,
      final Long statisticsId
   ) {
      this.id = id;
      this.ids = ids;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifySerialNumber = classifySerialNumber;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specs = specs;
      this.specifications = specifications;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.invoiceType = invoiceType;
      this.project = project;
      this.wapId = wapId;
      this.workshop = workshop;
      this.beginPeriod = beginPeriod;
      this.endPeriod = endPeriod;
      this.inbound = inbound;
      this.transfer = transfer;
      this.outbound = outbound;
      this.statId = statId;
      this.statIds = statIds;
      this.nationalStandard = nationalStandard;
      this.standardId = standardId;
      this.measure = measure;
      this.detailKey = detailKey;
      this.weightedPriceType = weightedPriceType;
      this.outboundUnitType = outboundUnitType;
      this.materialSnNew = materialSnNew;
      this.statisticsId = statisticsId;
   }

   public StatisticsDTO() {
   }

   public static class StatisticsDTOBuilder {
      private Long id;
      private List<Long> ids;
      private Boolean boolPartyA;
      private Long classifyId;
      private String classifySerialNumber;
      private String classifyName;
      private Integer basicClass;
      private String specs;
      private List<String> specifications;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private Integer invoiceType;
      private ProjectInfo project;
      private Long wapId;
      private BriefIdAndNameDTO workshop;
      private DetailDTO beginPeriod;
      private DetailDTO endPeriod;
      private DetailDTO inbound;
      private DetailDTO transfer;
      private DetailDTO outbound;
      private Long statId;
      private List<Long> statIds;
      private String nationalStandard;
      private Long standardId;
      private Measure measure;
      private String detailKey;
      private Integer weightedPriceType;
      private Integer outboundUnitType;
      private String materialSnNew;
      private Long statisticsId;

      StatisticsDTOBuilder() {
      }

      public StatisticsDTO.StatisticsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder specs(final String specs) {
         this.specs = specs;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder specifications(final List<String> specifications) {
         this.specifications = specifications;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder beginPeriod(final DetailDTO beginPeriod) {
         this.beginPeriod = beginPeriod;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder endPeriod(final DetailDTO endPeriod) {
         this.endPeriod = endPeriod;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder inbound(final DetailDTO inbound) {
         this.inbound = inbound;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder transfer(final DetailDTO transfer) {
         this.transfer = transfer;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder outbound(final DetailDTO outbound) {
         this.outbound = outbound;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder statId(final Long statId) {
         this.statId = statId;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder statIds(final List<Long> statIds) {
         this.statIds = statIds;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder detailKey(final String detailKey) {
         this.detailKey = detailKey;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder weightedPriceType(final Integer weightedPriceType) {
         this.weightedPriceType = weightedPriceType;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public StatisticsDTO.StatisticsDTOBuilder statisticsId(final Long statisticsId) {
         this.statisticsId = statisticsId;
         return this;
      }

      public StatisticsDTO build() {
         return new StatisticsDTO(
            this.id,
            this.ids,
            this.boolPartyA,
            this.classifyId,
            this.classifySerialNumber,
            this.classifyName,
            this.basicClass,
            this.specs,
            this.specifications,
            this.thickness,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.invoiceType,
            this.project,
            this.wapId,
            this.workshop,
            this.beginPeriod,
            this.endPeriod,
            this.inbound,
            this.transfer,
            this.outbound,
            this.statId,
            this.statIds,
            this.nationalStandard,
            this.standardId,
            this.measure,
            this.detailKey,
            this.weightedPriceType,
            this.outboundUnitType,
            this.materialSnNew,
            this.statisticsId
         );
      }

      @Override
      public String toString() {
         return "StatisticsDTO.StatisticsDTOBuilder(id="
            + this.id
            + ", ids="
            + this.ids
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifySerialNumber="
            + this.classifySerialNumber
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specs="
            + this.specs
            + ", specifications="
            + this.specifications
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", invoiceType="
            + this.invoiceType
            + ", project="
            + this.project
            + ", wapId="
            + this.wapId
            + ", workshop="
            + this.workshop
            + ", beginPeriod="
            + this.beginPeriod
            + ", endPeriod="
            + this.endPeriod
            + ", inbound="
            + this.inbound
            + ", transfer="
            + this.transfer
            + ", outbound="
            + this.outbound
            + ", statId="
            + this.statId
            + ", statIds="
            + this.statIds
            + ", nationalStandard="
            + this.nationalStandard
            + ", standardId="
            + this.standardId
            + ", measure="
            + this.measure
            + ", detailKey="
            + this.detailKey
            + ", weightedPriceType="
            + this.weightedPriceType
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", materialSnNew="
            + this.materialSnNew
            + ", statisticsId="
            + this.statisticsId
            + ")";
      }
   }
}
