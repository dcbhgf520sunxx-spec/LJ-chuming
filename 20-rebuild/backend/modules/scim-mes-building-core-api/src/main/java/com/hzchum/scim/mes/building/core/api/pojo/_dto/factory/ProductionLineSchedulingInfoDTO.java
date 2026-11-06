package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProdcutionLineSchedulingInfoDTO", description = "产线排产信息DTO")
public class ProductionLineSchedulingInfoDTO {
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "lineLeaderName", notes = "产线负责人")
   @JsonProperty("lineLeaderName")
   @JSONField(name = "lineLeaderName")
   private String lineLeaderName;
   @ApiModelProperty(name = "totalScheduleCount", notes = "总排产数量")
   @JsonProperty("totalScheduleCount")
   @JSONField(name = "totalScheduleCount")
   private BigDecimal totalScheduleCount;
   @ApiModelProperty(name = "totalScheduleTon", notes = "总排产重量")
   @JsonProperty("totalScheduleTon")
   @JSONField(name = "totalScheduleTon")
   private BigDecimal totalScheduleTon;
   @ApiModelProperty(name = "avgScheduleCount", notes = "平均排产数量")
   @JsonProperty("avgScheduleCount")
   @JSONField(name = "avgScheduleCount")
   private BigDecimal avgScheduleCount;
   @ApiModelProperty(name = "avgScheduleTon", notes = "平均排产重量")
   @JsonProperty("avgScheduleTon")
   @JSONField(name = "avgScheduleTon")
   private BigDecimal avgScheduleTon;
   @ApiModelProperty(name = "uncompletedCount", notes = "未完成数量")
   @JsonProperty("uncompletedCount")
   @JSONField(name = "uncompletedCount")
   private BigDecimal uncompletedCount;
   @ApiModelProperty(name = "uncompletedTon", notes = "未完成重量")
   @JsonProperty("uncompletedTon")
   @JSONField(name = "uncompletedTon")
   private BigDecimal uncompletedTon;
   @ApiModelProperty(name = "thisProjectCompletedCount", notes = "当前项目完成数量")
   @JsonProperty("thisProjectCompletedCount")
   @JSONField(name = "thisProjectCompletedCount")
   private BigDecimal thisProjectCompletedCount;
   @ApiModelProperty(name = "thisProjectCompletedTon", notes = "当前项目完成重量")
   @JsonProperty("thisProjectCompletedTon")
   @JSONField(name = "thisProjectCompletedTon")
   private BigDecimal thisProjectCompletedTon;
   @ApiModelProperty("是否配置工序")
   private Boolean hasProcess;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getLineLeaderName() {
      return this.lineLeaderName;
   }

   public BigDecimal getTotalScheduleCount() {
      return this.totalScheduleCount;
   }

   public BigDecimal getTotalScheduleTon() {
      return this.totalScheduleTon;
   }

   public BigDecimal getAvgScheduleCount() {
      return this.avgScheduleCount;
   }

   public BigDecimal getAvgScheduleTon() {
      return this.avgScheduleTon;
   }

   public BigDecimal getUncompletedCount() {
      return this.uncompletedCount;
   }

   public BigDecimal getUncompletedTon() {
      return this.uncompletedTon;
   }

   public BigDecimal getThisProjectCompletedCount() {
      return this.thisProjectCompletedCount;
   }

   public BigDecimal getThisProjectCompletedTon() {
      return this.thisProjectCompletedTon;
   }

   public Boolean getHasProcess() {
      return this.hasProcess;
   }

   @JsonProperty("workshopId")
   public ProductionLineSchedulingInfoDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public ProductionLineSchedulingInfoDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public ProductionLineSchedulingInfoDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public ProductionLineSchedulingInfoDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("productType")
   public ProductionLineSchedulingInfoDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("teamId")
   public ProductionLineSchedulingInfoDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("lineLeaderName")
   public ProductionLineSchedulingInfoDTO setLineLeaderName(final String lineLeaderName) {
      this.lineLeaderName = lineLeaderName;
      return this;
   }

   @JsonProperty("totalScheduleCount")
   public ProductionLineSchedulingInfoDTO setTotalScheduleCount(final BigDecimal totalScheduleCount) {
      this.totalScheduleCount = totalScheduleCount;
      return this;
   }

   @JsonProperty("totalScheduleTon")
   public ProductionLineSchedulingInfoDTO setTotalScheduleTon(final BigDecimal totalScheduleTon) {
      this.totalScheduleTon = totalScheduleTon;
      return this;
   }

   @JsonProperty("avgScheduleCount")
   public ProductionLineSchedulingInfoDTO setAvgScheduleCount(final BigDecimal avgScheduleCount) {
      this.avgScheduleCount = avgScheduleCount;
      return this;
   }

   @JsonProperty("avgScheduleTon")
   public ProductionLineSchedulingInfoDTO setAvgScheduleTon(final BigDecimal avgScheduleTon) {
      this.avgScheduleTon = avgScheduleTon;
      return this;
   }

   @JsonProperty("uncompletedCount")
   public ProductionLineSchedulingInfoDTO setUncompletedCount(final BigDecimal uncompletedCount) {
      this.uncompletedCount = uncompletedCount;
      return this;
   }

   @JsonProperty("uncompletedTon")
   public ProductionLineSchedulingInfoDTO setUncompletedTon(final BigDecimal uncompletedTon) {
      this.uncompletedTon = uncompletedTon;
      return this;
   }

   @JsonProperty("thisProjectCompletedCount")
   public ProductionLineSchedulingInfoDTO setThisProjectCompletedCount(final BigDecimal thisProjectCompletedCount) {
      this.thisProjectCompletedCount = thisProjectCompletedCount;
      return this;
   }

   @JsonProperty("thisProjectCompletedTon")
   public ProductionLineSchedulingInfoDTO setThisProjectCompletedTon(final BigDecimal thisProjectCompletedTon) {
      this.thisProjectCompletedTon = thisProjectCompletedTon;
      return this;
   }

   public ProductionLineSchedulingInfoDTO setHasProcess(final Boolean hasProcess) {
      this.hasProcess = hasProcess;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineSchedulingInfoDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", productType="
         + this.getProductType()
         + ", teamId="
         + this.getTeamId()
         + ", lineLeaderName="
         + this.getLineLeaderName()
         + ", totalScheduleCount="
         + this.getTotalScheduleCount()
         + ", totalScheduleTon="
         + this.getTotalScheduleTon()
         + ", avgScheduleCount="
         + this.getAvgScheduleCount()
         + ", avgScheduleTon="
         + this.getAvgScheduleTon()
         + ", uncompletedCount="
         + this.getUncompletedCount()
         + ", uncompletedTon="
         + this.getUncompletedTon()
         + ", thisProjectCompletedCount="
         + this.getThisProjectCompletedCount()
         + ", thisProjectCompletedTon="
         + this.getThisProjectCompletedTon()
         + ", hasProcess="
         + this.getHasProcess()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineSchedulingInfoDTO)) {
         return false;
      }

      ProductionLineSchedulingInfoDTO other = (ProductionLineSchedulingInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$hasProcess = this.getHasProcess();
                  Object other$hasProcess = other.getHasProcess();
                  if (this$hasProcess == null ? other$hasProcess == null : this$hasProcess.equals(other$hasProcess)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$productionLineName = this.getProductionLineName();
                        Object other$productionLineName = other.getProductionLineName();
                        if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                           Object this$lineLeaderName = this.getLineLeaderName();
                           Object other$lineLeaderName = other.getLineLeaderName();
                           if (this$lineLeaderName == null ? other$lineLeaderName == null : this$lineLeaderName.equals(other$lineLeaderName)) {
                              Object this$totalScheduleCount = this.getTotalScheduleCount();
                              Object other$totalScheduleCount = other.getTotalScheduleCount();
                              if (this$totalScheduleCount == null ? other$totalScheduleCount == null : this$totalScheduleCount.equals(other$totalScheduleCount)
                                 )
                               {
                                 Object this$totalScheduleTon = this.getTotalScheduleTon();
                                 Object other$totalScheduleTon = other.getTotalScheduleTon();
                                 if (this$totalScheduleTon == null ? other$totalScheduleTon == null : this$totalScheduleTon.equals(other$totalScheduleTon)) {
                                    Object this$avgScheduleCount = this.getAvgScheduleCount();
                                    Object other$avgScheduleCount = other.getAvgScheduleCount();
                                    if (this$avgScheduleCount == null ? other$avgScheduleCount == null : this$avgScheduleCount.equals(other$avgScheduleCount)) {
                                       Object this$avgScheduleTon = this.getAvgScheduleTon();
                                       Object other$avgScheduleTon = other.getAvgScheduleTon();
                                       if (this$avgScheduleTon == null ? other$avgScheduleTon == null : this$avgScheduleTon.equals(other$avgScheduleTon)) {
                                          Object this$uncompletedCount = this.getUncompletedCount();
                                          Object other$uncompletedCount = other.getUncompletedCount();
                                          if (this$uncompletedCount == null
                                             ? other$uncompletedCount == null
                                             : this$uncompletedCount.equals(other$uncompletedCount)) {
                                             Object this$uncompletedTon = this.getUncompletedTon();
                                             Object other$uncompletedTon = other.getUncompletedTon();
                                             if (this$uncompletedTon == null ? other$uncompletedTon == null : this$uncompletedTon.equals(other$uncompletedTon)) {
                                                Object this$thisProjectCompletedCount = this.getThisProjectCompletedCount();
                                                Object other$thisProjectCompletedCount = other.getThisProjectCompletedCount();
                                                if (this$thisProjectCompletedCount == null
                                                   ? other$thisProjectCompletedCount == null
                                                   : this$thisProjectCompletedCount.equals(other$thisProjectCompletedCount)) {
                                                   Object this$thisProjectCompletedTon = this.getThisProjectCompletedTon();
                                                   Object other$thisProjectCompletedTon = other.getThisProjectCompletedTon();
                                                   return this$thisProjectCompletedTon == null
                                                      ? other$thisProjectCompletedTon == null
                                                      : this$thisProjectCompletedTon.equals(other$thisProjectCompletedTon);
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
      return other instanceof ProductionLineSchedulingInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $hasProcess = this.getHasProcess();
      result = result * 59 + ($hasProcess == null ? 43 : $hasProcess.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $lineLeaderName = this.getLineLeaderName();
      result = result * 59 + ($lineLeaderName == null ? 43 : $lineLeaderName.hashCode());
      Object $totalScheduleCount = this.getTotalScheduleCount();
      result = result * 59 + ($totalScheduleCount == null ? 43 : $totalScheduleCount.hashCode());
      Object $totalScheduleTon = this.getTotalScheduleTon();
      result = result * 59 + ($totalScheduleTon == null ? 43 : $totalScheduleTon.hashCode());
      Object $avgScheduleCount = this.getAvgScheduleCount();
      result = result * 59 + ($avgScheduleCount == null ? 43 : $avgScheduleCount.hashCode());
      Object $avgScheduleTon = this.getAvgScheduleTon();
      result = result * 59 + ($avgScheduleTon == null ? 43 : $avgScheduleTon.hashCode());
      Object $uncompletedCount = this.getUncompletedCount();
      result = result * 59 + ($uncompletedCount == null ? 43 : $uncompletedCount.hashCode());
      Object $uncompletedTon = this.getUncompletedTon();
      result = result * 59 + ($uncompletedTon == null ? 43 : $uncompletedTon.hashCode());
      Object $thisProjectCompletedCount = this.getThisProjectCompletedCount();
      result = result * 59 + ($thisProjectCompletedCount == null ? 43 : $thisProjectCompletedCount.hashCode());
      Object $thisProjectCompletedTon = this.getThisProjectCompletedTon();
      return result * 59 + ($thisProjectCompletedTon == null ? 43 : $thisProjectCompletedTon.hashCode());
   }
}
