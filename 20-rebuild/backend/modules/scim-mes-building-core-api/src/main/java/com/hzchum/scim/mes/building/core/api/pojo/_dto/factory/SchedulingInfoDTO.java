package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "schedulingInfoDTO", description = "产线排产信息")
public class SchedulingInfoDTO {
   private Long lineId;
   private String lineName;
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

   public static SchedulingInfoDTO.SchedulingInfoDTOBuilder builder() {
      return new SchedulingInfoDTO.SchedulingInfoDTOBuilder();
   }

   public SchedulingInfoDTO() {
   }

   public SchedulingInfoDTO(
      final Long lineId,
      final String lineName,
      final BigDecimal totalScheduleCount,
      final BigDecimal totalScheduleTon,
      final BigDecimal avgScheduleCount,
      final BigDecimal avgScheduleTon,
      final BigDecimal uncompletedCount,
      final BigDecimal uncompletedTon,
      final BigDecimal thisProjectCompletedCount,
      final BigDecimal thisProjectCompletedTon
   ) {
      this.lineId = lineId;
      this.lineName = lineName;
      this.totalScheduleCount = totalScheduleCount;
      this.totalScheduleTon = totalScheduleTon;
      this.avgScheduleCount = avgScheduleCount;
      this.avgScheduleTon = avgScheduleTon;
      this.uncompletedCount = uncompletedCount;
      this.uncompletedTon = uncompletedTon;
      this.thisProjectCompletedCount = thisProjectCompletedCount;
      this.thisProjectCompletedTon = thisProjectCompletedTon;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
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

   public SchedulingInfoDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   public SchedulingInfoDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("totalScheduleCount")
   public SchedulingInfoDTO setTotalScheduleCount(final BigDecimal totalScheduleCount) {
      this.totalScheduleCount = totalScheduleCount;
      return this;
   }

   @JsonProperty("totalScheduleTon")
   public SchedulingInfoDTO setTotalScheduleTon(final BigDecimal totalScheduleTon) {
      this.totalScheduleTon = totalScheduleTon;
      return this;
   }

   @JsonProperty("avgScheduleCount")
   public SchedulingInfoDTO setAvgScheduleCount(final BigDecimal avgScheduleCount) {
      this.avgScheduleCount = avgScheduleCount;
      return this;
   }

   @JsonProperty("avgScheduleTon")
   public SchedulingInfoDTO setAvgScheduleTon(final BigDecimal avgScheduleTon) {
      this.avgScheduleTon = avgScheduleTon;
      return this;
   }

   @JsonProperty("uncompletedCount")
   public SchedulingInfoDTO setUncompletedCount(final BigDecimal uncompletedCount) {
      this.uncompletedCount = uncompletedCount;
      return this;
   }

   @JsonProperty("uncompletedTon")
   public SchedulingInfoDTO setUncompletedTon(final BigDecimal uncompletedTon) {
      this.uncompletedTon = uncompletedTon;
      return this;
   }

   @JsonProperty("thisProjectCompletedCount")
   public SchedulingInfoDTO setThisProjectCompletedCount(final BigDecimal thisProjectCompletedCount) {
      this.thisProjectCompletedCount = thisProjectCompletedCount;
      return this;
   }

   @JsonProperty("thisProjectCompletedTon")
   public SchedulingInfoDTO setThisProjectCompletedTon(final BigDecimal thisProjectCompletedTon) {
      this.thisProjectCompletedTon = thisProjectCompletedTon;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingInfoDTO(lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingInfoDTO)) {
         return false;
      }

      SchedulingInfoDTO other = (SchedulingInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lineId = this.getLineId();
      Object other$lineId = other.getLineId();
      if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
         Object this$lineName = this.getLineName();
         Object other$lineName = other.getLineName();
         if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
            Object this$totalScheduleCount = this.getTotalScheduleCount();
            Object other$totalScheduleCount = other.getTotalScheduleCount();
            if (this$totalScheduleCount == null ? other$totalScheduleCount == null : this$totalScheduleCount.equals(other$totalScheduleCount)) {
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
                        if (this$uncompletedCount == null ? other$uncompletedCount == null : this$uncompletedCount.equals(other$uncompletedCount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
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

   public static class SchedulingInfoDTOBuilder {
      private Long lineId;
      private String lineName;
      private BigDecimal totalScheduleCount;
      private BigDecimal totalScheduleTon;
      private BigDecimal avgScheduleCount;
      private BigDecimal avgScheduleTon;
      private BigDecimal uncompletedCount;
      private BigDecimal uncompletedTon;
      private BigDecimal thisProjectCompletedCount;
      private BigDecimal thisProjectCompletedTon;

      SchedulingInfoDTOBuilder() {
      }

      public SchedulingInfoDTO.SchedulingInfoDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      public SchedulingInfoDTO.SchedulingInfoDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("totalScheduleCount")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder totalScheduleCount(final BigDecimal totalScheduleCount) {
         this.totalScheduleCount = totalScheduleCount;
         return this;
      }

      @JsonProperty("totalScheduleTon")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder totalScheduleTon(final BigDecimal totalScheduleTon) {
         this.totalScheduleTon = totalScheduleTon;
         return this;
      }

      @JsonProperty("avgScheduleCount")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder avgScheduleCount(final BigDecimal avgScheduleCount) {
         this.avgScheduleCount = avgScheduleCount;
         return this;
      }

      @JsonProperty("avgScheduleTon")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder avgScheduleTon(final BigDecimal avgScheduleTon) {
         this.avgScheduleTon = avgScheduleTon;
         return this;
      }

      @JsonProperty("uncompletedCount")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder uncompletedCount(final BigDecimal uncompletedCount) {
         this.uncompletedCount = uncompletedCount;
         return this;
      }

      @JsonProperty("uncompletedTon")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder uncompletedTon(final BigDecimal uncompletedTon) {
         this.uncompletedTon = uncompletedTon;
         return this;
      }

      @JsonProperty("thisProjectCompletedCount")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder thisProjectCompletedCount(final BigDecimal thisProjectCompletedCount) {
         this.thisProjectCompletedCount = thisProjectCompletedCount;
         return this;
      }

      @JsonProperty("thisProjectCompletedTon")
      public SchedulingInfoDTO.SchedulingInfoDTOBuilder thisProjectCompletedTon(final BigDecimal thisProjectCompletedTon) {
         this.thisProjectCompletedTon = thisProjectCompletedTon;
         return this;
      }

      public SchedulingInfoDTO build() {
         return new SchedulingInfoDTO(
            this.lineId,
            this.lineName,
            this.totalScheduleCount,
            this.totalScheduleTon,
            this.avgScheduleCount,
            this.avgScheduleTon,
            this.uncompletedCount,
            this.uncompletedTon,
            this.thisProjectCompletedCount,
            this.thisProjectCompletedTon
         );
      }

      @Override
      public String toString() {
         return "SchedulingInfoDTO.SchedulingInfoDTOBuilder(lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", totalScheduleCount="
            + this.totalScheduleCount
            + ", totalScheduleTon="
            + this.totalScheduleTon
            + ", avgScheduleCount="
            + this.avgScheduleCount
            + ", avgScheduleTon="
            + this.avgScheduleTon
            + ", uncompletedCount="
            + this.uncompletedCount
            + ", uncompletedTon="
            + this.uncompletedTon
            + ", thisProjectCompletedCount="
            + this.thisProjectCompletedCount
            + ", thisProjectCompletedTon="
            + this.thisProjectCompletedTon
            + ")";
      }
   }
}
