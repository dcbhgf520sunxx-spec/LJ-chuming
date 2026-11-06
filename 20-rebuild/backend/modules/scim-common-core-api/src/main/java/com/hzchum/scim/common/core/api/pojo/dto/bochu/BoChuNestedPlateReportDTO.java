package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiModel("柏楚套料板报告DTO")
public class BoChuNestedPlateReportDTO {
   @JsonProperty("total_info")
   @Alias("total_info")
   private BoChuNestedPlateReportDTO.TotalInfoDTO totalInfo;
   @JsonProperty("result_info")
   @Alias("result_info")
   private List<BoChuNestedPlateReportDTO.ResultInfoDTO> resultInfoList;

   public BoChuNestedPlateReportDTO.TotalInfoDTO getTotalInfo() {
      return this.totalInfo;
   }

   public List<BoChuNestedPlateReportDTO.ResultInfoDTO> getResultInfoList() {
      return this.resultInfoList;
   }

   @JsonProperty("total_info")
   public void setTotalInfo(final BoChuNestedPlateReportDTO.TotalInfoDTO totalInfo) {
      this.totalInfo = totalInfo;
   }

   @JsonProperty("result_info")
   public void setResultInfoList(final List<BoChuNestedPlateReportDTO.ResultInfoDTO> resultInfoList) {
      this.resultInfoList = resultInfoList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BoChuNestedPlateReportDTO)) {
         return false;
      } else {
         BoChuNestedPlateReportDTO other = (BoChuNestedPlateReportDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalInfo = this.getTotalInfo();
            Object other$totalInfo = other.getTotalInfo();
            if (this$totalInfo == null ? other$totalInfo == null : this$totalInfo.equals(other$totalInfo)) {
               Object this$resultInfoList = this.getResultInfoList();
               Object other$resultInfoList = other.getResultInfoList();
               return this$resultInfoList == null ? other$resultInfoList == null : this$resultInfoList.equals(other$resultInfoList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BoChuNestedPlateReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalInfo = this.getTotalInfo();
      result = result * 59 + ($totalInfo == null ? 43 : $totalInfo.hashCode());
      Object $resultInfoList = this.getResultInfoList();
      return result * 59 + ($resultInfoList == null ? 43 : $resultInfoList.hashCode());
   }

   @Override
   public String toString() {
      return "BoChuNestedPlateReportDTO(totalInfo=" + this.getTotalInfo() + ", resultInfoList=" + this.getResultInfoList() + ")";
   }

   public static class ResultInfoDTO {
      @JsonProperty("IDHash")
      @Alias("IDHash")
      private String idHash;
      @JsonProperty("amount")
      @Alias("amount")
      private BigDecimal amount;
      @JsonProperty("area")
      @Alias("area")
      private BigDecimal area;
      @JsonProperty("coedge_volume")
      @Alias("coedge_volume")
      private BigDecimal coedgeVolume;
      @JsonProperty("contours_count")
      @Alias("contours_count")
      private BigDecimal contoursCount;
      @JsonProperty("curve_length")
      @Alias("curve_length")
      private BigDecimal curveLength;
      @JsonProperty("curve_time")
      @Alias("curve_time")
      private String curveTime;
      @JsonProperty("delay_time")
      @Alias("delay_time")
      private String delayTime;
      @JsonProperty("guid")
      @Alias("guid")
      private String guid;
      @JsonProperty("height")
      @Alias("height")
      private BigDecimal height;
      @JsonProperty("mark_length")
      @Alias("mark_length")
      private BigDecimal markLength;
      @JsonProperty("mark_point")
      @Alias("mark_point")
      private BigDecimal markPoint;
      @JsonProperty("marks_Count")
      @Alias("marks_Count")
      private BigDecimal marksCount;
      @JsonProperty("move_length")
      @Alias("move_length")
      private BigDecimal moveLength;
      @JsonProperty("move_time")
      @Alias("move_time")
      private String moveTime;
      @JsonProperty("name")
      @Alias("name")
      private String name;
      @JsonProperty("nest_area")
      @Alias("nest_area")
      private BigDecimal nestArea;
      @JsonProperty("nest_x")
      @Alias("nest_x")
      private BigDecimal nestX;
      @JsonProperty("nest_y")
      @Alias("nest_y")
      private BigDecimal nestY;
      @JsonProperty("nestedrec_area")
      @Alias("nestedrec_area")
      private BigDecimal nestedrecArea;
      @JsonProperty("part_amount")
      @Alias("part_amount")
      private BigDecimal partAmount;
      @JsonProperty("part_info")
      @Alias("part_info")
      private List<BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO> partInfoList;
      @JsonProperty("partnet_area")
      @Alias("partnet_area")
      private BigDecimal partnetArea;
      @JsonProperty("pierce_count")
      @Alias("pierce_count")
      private BigDecimal pierceCount;
      @JsonProperty("pierce_time")
      @Alias("pierce_time")
      private String pierceTime;
      @JsonProperty("remnant_area")
      @Alias("remnant_area")
      private BigDecimal remnantArea;
      @JsonProperty("total_time")
      @Alias("total_time")
      private String totalTime;
      @JsonProperty("utilization")
      @Alias("utilization")
      private String utilization;
      @JsonProperty("uuid")
      @Alias("uuid")
      private String uuid;
      @JsonProperty("width")
      @Alias("width")
      private BigDecimal width;
      @JsonProperty("nest_name")
      @Alias("nest_name")
      private String nestName;
      @JsonProperty("material")
      @Alias("material")
      private String material;
      @JsonProperty("thickness")
      @Alias("thickness")
      private BigDecimal thickness;
      @JsonProperty("gas")
      @Alias("gas")
      private String gas;
      @JsonProperty("utilization_slab")
      @Alias("utilization_slab")
      private String utilizationSlab;
      @JsonProperty("utilization_nestedrec")
      @Alias("utilization_nestedrec")
      private String utilizationNestedrec;
      @JsonProperty("utilization_nestedrec_slab")
      @Alias("utilization_nestedrec_slab")
      private String utilizationNestedrecSlab;
      @JsonProperty("plate_guid")
      @Alias("plate_guid")
      private String plateGuid;
      @JsonProperty("density")
      @Alias("density")
      private BigDecimal density;

      public String getIdHash() {
         return this.idHash;
      }

      public BigDecimal getAmount() {
         return this.amount;
      }

      public BigDecimal getArea() {
         return this.area;
      }

      public BigDecimal getCoedgeVolume() {
         return this.coedgeVolume;
      }

      public BigDecimal getContoursCount() {
         return this.contoursCount;
      }

      public BigDecimal getCurveLength() {
         return this.curveLength;
      }

      public String getCurveTime() {
         return this.curveTime;
      }

      public String getDelayTime() {
         return this.delayTime;
      }

      public String getGuid() {
         return this.guid;
      }

      public BigDecimal getHeight() {
         return this.height;
      }

      public BigDecimal getMarkLength() {
         return this.markLength;
      }

      public BigDecimal getMarkPoint() {
         return this.markPoint;
      }

      public BigDecimal getMarksCount() {
         return this.marksCount;
      }

      public BigDecimal getMoveLength() {
         return this.moveLength;
      }

      public String getMoveTime() {
         return this.moveTime;
      }

      public String getName() {
         return this.name;
      }

      public BigDecimal getNestArea() {
         return this.nestArea;
      }

      public BigDecimal getNestX() {
         return this.nestX;
      }

      public BigDecimal getNestY() {
         return this.nestY;
      }

      public BigDecimal getNestedrecArea() {
         return this.nestedrecArea;
      }

      public BigDecimal getPartAmount() {
         return this.partAmount;
      }

      public List<BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO> getPartInfoList() {
         return this.partInfoList;
      }

      public BigDecimal getPartnetArea() {
         return this.partnetArea;
      }

      public BigDecimal getPierceCount() {
         return this.pierceCount;
      }

      public String getPierceTime() {
         return this.pierceTime;
      }

      public BigDecimal getRemnantArea() {
         return this.remnantArea;
      }

      public String getTotalTime() {
         return this.totalTime;
      }

      public String getUtilization() {
         return this.utilization;
      }

      public String getUuid() {
         return this.uuid;
      }

      public BigDecimal getWidth() {
         return this.width;
      }

      public String getNestName() {
         return this.nestName;
      }

      public String getMaterial() {
         return this.material;
      }

      public BigDecimal getThickness() {
         return this.thickness;
      }

      public String getGas() {
         return this.gas;
      }

      public String getUtilizationSlab() {
         return this.utilizationSlab;
      }

      public String getUtilizationNestedrec() {
         return this.utilizationNestedrec;
      }

      public String getUtilizationNestedrecSlab() {
         return this.utilizationNestedrecSlab;
      }

      public String getPlateGuid() {
         return this.plateGuid;
      }

      public BigDecimal getDensity() {
         return this.density;
      }

      @JsonProperty("IDHash")
      public void setIdHash(final String idHash) {
         this.idHash = idHash;
      }

      @JsonProperty("amount")
      public void setAmount(final BigDecimal amount) {
         this.amount = amount;
      }

      @JsonProperty("area")
      public void setArea(final BigDecimal area) {
         this.area = area;
      }

      @JsonProperty("coedge_volume")
      public void setCoedgeVolume(final BigDecimal coedgeVolume) {
         this.coedgeVolume = coedgeVolume;
      }

      @JsonProperty("contours_count")
      public void setContoursCount(final BigDecimal contoursCount) {
         this.contoursCount = contoursCount;
      }

      @JsonProperty("curve_length")
      public void setCurveLength(final BigDecimal curveLength) {
         this.curveLength = curveLength;
      }

      @JsonProperty("curve_time")
      public void setCurveTime(final String curveTime) {
         this.curveTime = curveTime;
      }

      @JsonProperty("delay_time")
      public void setDelayTime(final String delayTime) {
         this.delayTime = delayTime;
      }

      @JsonProperty("guid")
      public void setGuid(final String guid) {
         this.guid = guid;
      }

      @JsonProperty("height")
      public void setHeight(final BigDecimal height) {
         this.height = height;
      }

      @JsonProperty("mark_length")
      public void setMarkLength(final BigDecimal markLength) {
         this.markLength = markLength;
      }

      @JsonProperty("mark_point")
      public void setMarkPoint(final BigDecimal markPoint) {
         this.markPoint = markPoint;
      }

      @JsonProperty("marks_Count")
      public void setMarksCount(final BigDecimal marksCount) {
         this.marksCount = marksCount;
      }

      @JsonProperty("move_length")
      public void setMoveLength(final BigDecimal moveLength) {
         this.moveLength = moveLength;
      }

      @JsonProperty("move_time")
      public void setMoveTime(final String moveTime) {
         this.moveTime = moveTime;
      }

      @JsonProperty("name")
      public void setName(final String name) {
         this.name = name;
      }

      @JsonProperty("nest_area")
      public void setNestArea(final BigDecimal nestArea) {
         this.nestArea = nestArea;
      }

      @JsonProperty("nest_x")
      public void setNestX(final BigDecimal nestX) {
         this.nestX = nestX;
      }

      @JsonProperty("nest_y")
      public void setNestY(final BigDecimal nestY) {
         this.nestY = nestY;
      }

      @JsonProperty("nestedrec_area")
      public void setNestedrecArea(final BigDecimal nestedrecArea) {
         this.nestedrecArea = nestedrecArea;
      }

      @JsonProperty("part_amount")
      public void setPartAmount(final BigDecimal partAmount) {
         this.partAmount = partAmount;
      }

      @JsonProperty("part_info")
      public void setPartInfoList(final List<BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO> partInfoList) {
         this.partInfoList = partInfoList;
      }

      @JsonProperty("partnet_area")
      public void setPartnetArea(final BigDecimal partnetArea) {
         this.partnetArea = partnetArea;
      }

      @JsonProperty("pierce_count")
      public void setPierceCount(final BigDecimal pierceCount) {
         this.pierceCount = pierceCount;
      }

      @JsonProperty("pierce_time")
      public void setPierceTime(final String pierceTime) {
         this.pierceTime = pierceTime;
      }

      @JsonProperty("remnant_area")
      public void setRemnantArea(final BigDecimal remnantArea) {
         this.remnantArea = remnantArea;
      }

      @JsonProperty("total_time")
      public void setTotalTime(final String totalTime) {
         this.totalTime = totalTime;
      }

      @JsonProperty("utilization")
      public void setUtilization(final String utilization) {
         this.utilization = utilization;
      }

      @JsonProperty("uuid")
      public void setUuid(final String uuid) {
         this.uuid = uuid;
      }

      @JsonProperty("width")
      public void setWidth(final BigDecimal width) {
         this.width = width;
      }

      @JsonProperty("nest_name")
      public void setNestName(final String nestName) {
         this.nestName = nestName;
      }

      @JsonProperty("material")
      public void setMaterial(final String material) {
         this.material = material;
      }

      @JsonProperty("thickness")
      public void setThickness(final BigDecimal thickness) {
         this.thickness = thickness;
      }

      @JsonProperty("gas")
      public void setGas(final String gas) {
         this.gas = gas;
      }

      @JsonProperty("utilization_slab")
      public void setUtilizationSlab(final String utilizationSlab) {
         this.utilizationSlab = utilizationSlab;
      }

      @JsonProperty("utilization_nestedrec")
      public void setUtilizationNestedrec(final String utilizationNestedrec) {
         this.utilizationNestedrec = utilizationNestedrec;
      }

      @JsonProperty("utilization_nestedrec_slab")
      public void setUtilizationNestedrecSlab(final String utilizationNestedrecSlab) {
         this.utilizationNestedrecSlab = utilizationNestedrecSlab;
      }

      @JsonProperty("plate_guid")
      public void setPlateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
      }

      @JsonProperty("density")
      public void setDensity(final BigDecimal density) {
         this.density = density;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof BoChuNestedPlateReportDTO.ResultInfoDTO)) {
            return false;
         }

         BoChuNestedPlateReportDTO.ResultInfoDTO other = (BoChuNestedPlateReportDTO.ResultInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$idHash = this.getIdHash();
         Object other$idHash = other.getIdHash();
         if (this$idHash == null ? other$idHash == null : this$idHash.equals(other$idHash)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$area = this.getArea();
               Object other$area = other.getArea();
               if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                  Object this$coedgeVolume = this.getCoedgeVolume();
                  Object other$coedgeVolume = other.getCoedgeVolume();
                  if (this$coedgeVolume == null ? other$coedgeVolume == null : this$coedgeVolume.equals(other$coedgeVolume)) {
                     Object this$contoursCount = this.getContoursCount();
                     Object other$contoursCount = other.getContoursCount();
                     if (this$contoursCount == null ? other$contoursCount == null : this$contoursCount.equals(other$contoursCount)) {
                        Object this$curveLength = this.getCurveLength();
                        Object other$curveLength = other.getCurveLength();
                        if (this$curveLength == null ? other$curveLength == null : this$curveLength.equals(other$curveLength)) {
                           Object this$curveTime = this.getCurveTime();
                           Object other$curveTime = other.getCurveTime();
                           if (this$curveTime == null ? other$curveTime == null : this$curveTime.equals(other$curveTime)) {
                              Object this$delayTime = this.getDelayTime();
                              Object other$delayTime = other.getDelayTime();
                              if (this$delayTime == null ? other$delayTime == null : this$delayTime.equals(other$delayTime)) {
                                 Object this$guid = this.getGuid();
                                 Object other$guid = other.getGuid();
                                 if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                    Object this$height = this.getHeight();
                                    Object other$height = other.getHeight();
                                    if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                                       Object this$markLength = this.getMarkLength();
                                       Object other$markLength = other.getMarkLength();
                                       if (this$markLength == null ? other$markLength == null : this$markLength.equals(other$markLength)) {
                                          Object this$markPoint = this.getMarkPoint();
                                          Object other$markPoint = other.getMarkPoint();
                                          if (this$markPoint == null ? other$markPoint == null : this$markPoint.equals(other$markPoint)) {
                                             Object this$marksCount = this.getMarksCount();
                                             Object other$marksCount = other.getMarksCount();
                                             if (this$marksCount == null ? other$marksCount == null : this$marksCount.equals(other$marksCount)) {
                                                Object this$moveLength = this.getMoveLength();
                                                Object other$moveLength = other.getMoveLength();
                                                if (this$moveLength == null ? other$moveLength == null : this$moveLength.equals(other$moveLength)) {
                                                   Object this$moveTime = this.getMoveTime();
                                                   Object other$moveTime = other.getMoveTime();
                                                   if (this$moveTime == null ? other$moveTime == null : this$moveTime.equals(other$moveTime)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$nestArea = this.getNestArea();
                                                         Object other$nestArea = other.getNestArea();
                                                         if (this$nestArea == null ? other$nestArea == null : this$nestArea.equals(other$nestArea)) {
                                                            Object this$nestX = this.getNestX();
                                                            Object other$nestX = other.getNestX();
                                                            if (this$nestX == null ? other$nestX == null : this$nestX.equals(other$nestX)) {
                                                               Object this$nestY = this.getNestY();
                                                               Object other$nestY = other.getNestY();
                                                               if (this$nestY == null ? other$nestY == null : this$nestY.equals(other$nestY)) {
                                                                  Object this$nestedrecArea = this.getNestedrecArea();
                                                                  Object other$nestedrecArea = other.getNestedrecArea();
                                                                  if (this$nestedrecArea == null
                                                                     ? other$nestedrecArea == null
                                                                     : this$nestedrecArea.equals(other$nestedrecArea)) {
                                                                     Object this$partAmount = this.getPartAmount();
                                                                     Object other$partAmount = other.getPartAmount();
                                                                     if (this$partAmount == null
                                                                        ? other$partAmount == null
                                                                        : this$partAmount.equals(other$partAmount)) {
                                                                        Object this$partInfoList = this.getPartInfoList();
                                                                        Object other$partInfoList = other.getPartInfoList();
                                                                        if (this$partInfoList == null
                                                                           ? other$partInfoList == null
                                                                           : this$partInfoList.equals(other$partInfoList)) {
                                                                           Object this$partnetArea = this.getPartnetArea();
                                                                           Object other$partnetArea = other.getPartnetArea();
                                                                           if (this$partnetArea == null
                                                                              ? other$partnetArea == null
                                                                              : this$partnetArea.equals(other$partnetArea)) {
                                                                              Object this$pierceCount = this.getPierceCount();
                                                                              Object other$pierceCount = other.getPierceCount();
                                                                              if (this$pierceCount == null
                                                                                 ? other$pierceCount == null
                                                                                 : this$pierceCount.equals(other$pierceCount)) {
                                                                                 Object this$pierceTime = this.getPierceTime();
                                                                                 Object other$pierceTime = other.getPierceTime();
                                                                                 if (this$pierceTime == null
                                                                                    ? other$pierceTime == null
                                                                                    : this$pierceTime.equals(other$pierceTime)) {
                                                                                    Object this$remnantArea = this.getRemnantArea();
                                                                                    Object other$remnantArea = other.getRemnantArea();
                                                                                    if (this$remnantArea == null
                                                                                       ? other$remnantArea == null
                                                                                       : this$remnantArea.equals(other$remnantArea)) {
                                                                                       Object this$totalTime = this.getTotalTime();
                                                                                       Object other$totalTime = other.getTotalTime();
                                                                                       if (this$totalTime == null
                                                                                          ? other$totalTime == null
                                                                                          : this$totalTime.equals(other$totalTime)) {
                                                                                          Object this$utilization = this.getUtilization();
                                                                                          Object other$utilization = other.getUtilization();
                                                                                          if (this$utilization == null
                                                                                             ? other$utilization == null
                                                                                             : this$utilization.equals(other$utilization)) {
                                                                                             Object this$uuid = this.getUuid();
                                                                                             Object other$uuid = other.getUuid();
                                                                                             if (this$uuid == null
                                                                                                ? other$uuid == null
                                                                                                : this$uuid.equals(other$uuid)) {
                                                                                                Object this$width = this.getWidth();
                                                                                                Object other$width = other.getWidth();
                                                                                                if (this$width == null
                                                                                                   ? other$width == null
                                                                                                   : this$width.equals(other$width)) {
                                                                                                   Object this$nestName = this.getNestName();
                                                                                                   Object other$nestName = other.getNestName();
                                                                                                   if (this$nestName == null
                                                                                                      ? other$nestName == null
                                                                                                      : this$nestName.equals(other$nestName)) {
                                                                                                      Object this$material = this.getMaterial();
                                                                                                      Object other$material = other.getMaterial();
                                                                                                      if (this$material == null
                                                                                                         ? other$material == null
                                                                                                         : this$material.equals(other$material)) {
                                                                                                         Object this$thickness = this.getThickness();
                                                                                                         Object other$thickness = other.getThickness();
                                                                                                         if (this$thickness == null
                                                                                                            ? other$thickness == null
                                                                                                            : this$thickness.equals(other$thickness)) {
                                                                                                            Object this$gas = this.getGas();
                                                                                                            Object other$gas = other.getGas();
                                                                                                            if (this$gas == null
                                                                                                               ? other$gas == null
                                                                                                               : this$gas.equals(other$gas)) {
                                                                                                               Object this$utilizationSlab = this.getUtilizationSlab();
                                                                                                               Object other$utilizationSlab = other.getUtilizationSlab();
                                                                                                               if (this$utilizationSlab == null
                                                                                                                  ? other$utilizationSlab == null
                                                                                                                  : this$utilizationSlab.equals(
                                                                                                                     other$utilizationSlab
                                                                                                                  )) {
                                                                                                                  Object this$utilizationNestedrec = this.getUtilizationNestedrec();
                                                                                                                  Object other$utilizationNestedrec = other.getUtilizationNestedrec();
                                                                                                                  if (this$utilizationNestedrec == null
                                                                                                                     ? other$utilizationNestedrec == null
                                                                                                                     : this$utilizationNestedrec.equals(
                                                                                                                        other$utilizationNestedrec
                                                                                                                     )) {
                                                                                                                     Object this$utilizationNestedrecSlab = this.getUtilizationNestedrecSlab();
                                                                                                                     Object other$utilizationNestedrecSlab = other.getUtilizationNestedrecSlab();
                                                                                                                     if (this$utilizationNestedrecSlab == null
                                                                                                                        ? other$utilizationNestedrecSlab
                                                                                                                           == null
                                                                                                                        : this$utilizationNestedrecSlab.equals(
                                                                                                                           other$utilizationNestedrecSlab
                                                                                                                        )) {
                                                                                                                        Object this$plateGuid = this.getPlateGuid();
                                                                                                                        Object other$plateGuid = other.getPlateGuid();
                                                                                                                        if (this$plateGuid == null
                                                                                                                           ? other$plateGuid == null
                                                                                                                           : this$plateGuid.equals(
                                                                                                                              other$plateGuid
                                                                                                                           )) {
                                                                                                                           Object this$density = this.getDensity();
                                                                                                                           Object other$density = other.getDensity();
                                                                                                                           return this$density == null
                                                                                                                              ? other$density == null
                                                                                                                              : this$density.equals(
                                                                                                                                 other$density
                                                                                                                              );
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
         return other instanceof BoChuNestedPlateReportDTO.ResultInfoDTO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $idHash = this.getIdHash();
         result = result * 59 + ($idHash == null ? 43 : $idHash.hashCode());
         Object $amount = this.getAmount();
         result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
         Object $area = this.getArea();
         result = result * 59 + ($area == null ? 43 : $area.hashCode());
         Object $coedgeVolume = this.getCoedgeVolume();
         result = result * 59 + ($coedgeVolume == null ? 43 : $coedgeVolume.hashCode());
         Object $contoursCount = this.getContoursCount();
         result = result * 59 + ($contoursCount == null ? 43 : $contoursCount.hashCode());
         Object $curveLength = this.getCurveLength();
         result = result * 59 + ($curveLength == null ? 43 : $curveLength.hashCode());
         Object $curveTime = this.getCurveTime();
         result = result * 59 + ($curveTime == null ? 43 : $curveTime.hashCode());
         Object $delayTime = this.getDelayTime();
         result = result * 59 + ($delayTime == null ? 43 : $delayTime.hashCode());
         Object $guid = this.getGuid();
         result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
         Object $height = this.getHeight();
         result = result * 59 + ($height == null ? 43 : $height.hashCode());
         Object $markLength = this.getMarkLength();
         result = result * 59 + ($markLength == null ? 43 : $markLength.hashCode());
         Object $markPoint = this.getMarkPoint();
         result = result * 59 + ($markPoint == null ? 43 : $markPoint.hashCode());
         Object $marksCount = this.getMarksCount();
         result = result * 59 + ($marksCount == null ? 43 : $marksCount.hashCode());
         Object $moveLength = this.getMoveLength();
         result = result * 59 + ($moveLength == null ? 43 : $moveLength.hashCode());
         Object $moveTime = this.getMoveTime();
         result = result * 59 + ($moveTime == null ? 43 : $moveTime.hashCode());
         Object $name = this.getName();
         result = result * 59 + ($name == null ? 43 : $name.hashCode());
         Object $nestArea = this.getNestArea();
         result = result * 59 + ($nestArea == null ? 43 : $nestArea.hashCode());
         Object $nestX = this.getNestX();
         result = result * 59 + ($nestX == null ? 43 : $nestX.hashCode());
         Object $nestY = this.getNestY();
         result = result * 59 + ($nestY == null ? 43 : $nestY.hashCode());
         Object $nestedrecArea = this.getNestedrecArea();
         result = result * 59 + ($nestedrecArea == null ? 43 : $nestedrecArea.hashCode());
         Object $partAmount = this.getPartAmount();
         result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
         Object $partInfoList = this.getPartInfoList();
         result = result * 59 + ($partInfoList == null ? 43 : $partInfoList.hashCode());
         Object $partnetArea = this.getPartnetArea();
         result = result * 59 + ($partnetArea == null ? 43 : $partnetArea.hashCode());
         Object $pierceCount = this.getPierceCount();
         result = result * 59 + ($pierceCount == null ? 43 : $pierceCount.hashCode());
         Object $pierceTime = this.getPierceTime();
         result = result * 59 + ($pierceTime == null ? 43 : $pierceTime.hashCode());
         Object $remnantArea = this.getRemnantArea();
         result = result * 59 + ($remnantArea == null ? 43 : $remnantArea.hashCode());
         Object $totalTime = this.getTotalTime();
         result = result * 59 + ($totalTime == null ? 43 : $totalTime.hashCode());
         Object $utilization = this.getUtilization();
         result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
         Object $uuid = this.getUuid();
         result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
         Object $width = this.getWidth();
         result = result * 59 + ($width == null ? 43 : $width.hashCode());
         Object $nestName = this.getNestName();
         result = result * 59 + ($nestName == null ? 43 : $nestName.hashCode());
         Object $material = this.getMaterial();
         result = result * 59 + ($material == null ? 43 : $material.hashCode());
         Object $thickness = this.getThickness();
         result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
         Object $gas = this.getGas();
         result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
         Object $utilizationSlab = this.getUtilizationSlab();
         result = result * 59 + ($utilizationSlab == null ? 43 : $utilizationSlab.hashCode());
         Object $utilizationNestedrec = this.getUtilizationNestedrec();
         result = result * 59 + ($utilizationNestedrec == null ? 43 : $utilizationNestedrec.hashCode());
         Object $utilizationNestedrecSlab = this.getUtilizationNestedrecSlab();
         result = result * 59 + ($utilizationNestedrecSlab == null ? 43 : $utilizationNestedrecSlab.hashCode());
         Object $plateGuid = this.getPlateGuid();
         result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
         Object $density = this.getDensity();
         return result * 59 + ($density == null ? 43 : $density.hashCode());
      }

      @Override
      public String toString() {
         return "BoChuNestedPlateReportDTO.ResultInfoDTO(idHash="
            + this.getIdHash()
            + ", amount="
            + this.getAmount()
            + ", area="
            + this.getArea()
            + ", coedgeVolume="
            + this.getCoedgeVolume()
            + ", contoursCount="
            + this.getContoursCount()
            + ", curveLength="
            + this.getCurveLength()
            + ", curveTime="
            + this.getCurveTime()
            + ", delayTime="
            + this.getDelayTime()
            + ", guid="
            + this.getGuid()
            + ", height="
            + this.getHeight()
            + ", markLength="
            + this.getMarkLength()
            + ", markPoint="
            + this.getMarkPoint()
            + ", marksCount="
            + this.getMarksCount()
            + ", moveLength="
            + this.getMoveLength()
            + ", moveTime="
            + this.getMoveTime()
            + ", name="
            + this.getName()
            + ", nestArea="
            + this.getNestArea()
            + ", nestX="
            + this.getNestX()
            + ", nestY="
            + this.getNestY()
            + ", nestedrecArea="
            + this.getNestedrecArea()
            + ", partAmount="
            + this.getPartAmount()
            + ", partInfoList="
            + this.getPartInfoList()
            + ", partnetArea="
            + this.getPartnetArea()
            + ", pierceCount="
            + this.getPierceCount()
            + ", pierceTime="
            + this.getPierceTime()
            + ", remnantArea="
            + this.getRemnantArea()
            + ", totalTime="
            + this.getTotalTime()
            + ", utilization="
            + this.getUtilization()
            + ", uuid="
            + this.getUuid()
            + ", width="
            + this.getWidth()
            + ", nestName="
            + this.getNestName()
            + ", material="
            + this.getMaterial()
            + ", thickness="
            + this.getThickness()
            + ", gas="
            + this.getGas()
            + ", utilizationSlab="
            + this.getUtilizationSlab()
            + ", utilizationNestedrec="
            + this.getUtilizationNestedrec()
            + ", utilizationNestedrecSlab="
            + this.getUtilizationNestedrecSlab()
            + ", plateGuid="
            + this.getPlateGuid()
            + ", density="
            + this.getDensity()
            + ")";
      }

      public static class PartInfoDTO {
         @JsonProperty("amount")
         @Alias("amount")
         private BigDecimal amount;
         @JsonProperty("guid")
         @Alias("guid")
         private String guid;

         public BigDecimal getAmount() {
            return this.amount;
         }

         public String getGuid() {
            return this.guid;
         }

         @JsonProperty("amount")
         public void setAmount(final BigDecimal amount) {
            this.amount = amount;
         }

         @JsonProperty("guid")
         public void setGuid(final String guid) {
            this.guid = guid;
         }

         @Override
         public boolean equals(final Object o) {
            if (o == this) {
               return true;
            } else if (!(o instanceof BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO)) {
               return false;
            } else {
               BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO other = (BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO)o;
               if (!other.canEqual(this)) {
                  return false;
               } else {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$guid = this.getGuid();
                     Object other$guid = other.getGuid();
                     return this$guid == null ? other$guid == null : this$guid.equals(other$guid);
                  } else {
                     return false;
                  }
               }
            }
         }

         protected boolean canEqual(final Object other) {
            return other instanceof BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO;
         }

         @Override
         public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Object $amount = this.getAmount();
            result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
            Object $guid = this.getGuid();
            return result * 59 + ($guid == null ? 43 : $guid.hashCode());
         }

         @Override
         public String toString() {
            return "BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO(amount=" + this.getAmount() + ", guid=" + this.getGuid() + ")";
         }
      }
   }

   public static class TotalInfoDTO {
      @JsonProperty("plate_info_detail")
      @Alias("plate_info_detail")
      private List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO> plateInfoDetailList;
      @JsonProperty("plate_info")
      @Alias("plate_info")
      private List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO> plateInfoList;
      @JsonProperty("part_info")
      @Alias("part_info")
      private List<BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO> partInfoList;

      public List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO> getPlateInfoDetailList() {
         return this.plateInfoDetailList;
      }

      public List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO> getPlateInfoList() {
         return this.plateInfoList;
      }

      public List<BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO> getPartInfoList() {
         return this.partInfoList;
      }

      @JsonProperty("plate_info_detail")
      public void setPlateInfoDetailList(final List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO> plateInfoDetailList) {
         this.plateInfoDetailList = plateInfoDetailList;
      }

      @JsonProperty("plate_info")
      public void setPlateInfoList(final List<BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO> plateInfoList) {
         this.plateInfoList = plateInfoList;
      }

      @JsonProperty("part_info")
      public void setPartInfoList(final List<BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO> partInfoList) {
         this.partInfoList = partInfoList;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof BoChuNestedPlateReportDTO.TotalInfoDTO)) {
            return false;
         }

         BoChuNestedPlateReportDTO.TotalInfoDTO other = (BoChuNestedPlateReportDTO.TotalInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$plateInfoDetailList = this.getPlateInfoDetailList();
         Object other$plateInfoDetailList = other.getPlateInfoDetailList();
         if (this$plateInfoDetailList == null ? other$plateInfoDetailList == null : this$plateInfoDetailList.equals(other$plateInfoDetailList)) {
            Object this$plateInfoList = this.getPlateInfoList();
            Object other$plateInfoList = other.getPlateInfoList();
            if (this$plateInfoList == null ? other$plateInfoList == null : this$plateInfoList.equals(other$plateInfoList)) {
               Object this$partInfoList = this.getPartInfoList();
               Object other$partInfoList = other.getPartInfoList();
               return this$partInfoList == null ? other$partInfoList == null : this$partInfoList.equals(other$partInfoList);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof BoChuNestedPlateReportDTO.TotalInfoDTO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $plateInfoDetailList = this.getPlateInfoDetailList();
         result = result * 59 + ($plateInfoDetailList == null ? 43 : $plateInfoDetailList.hashCode());
         Object $plateInfoList = this.getPlateInfoList();
         result = result * 59 + ($plateInfoList == null ? 43 : $plateInfoList.hashCode());
         Object $partInfoList = this.getPartInfoList();
         return result * 59 + ($partInfoList == null ? 43 : $partInfoList.hashCode());
      }

      @Override
      public String toString() {
         return "BoChuNestedPlateReportDTO.TotalInfoDTO(plateInfoDetailList="
            + this.getPlateInfoDetailList()
            + ", plateInfoList="
            + this.getPlateInfoList()
            + ", partInfoList="
            + this.getPartInfoList()
            + ")";
      }

      public static class PartInfoDTO {
         @JsonProperty("ID")
         @Alias("ID")
         private String id;
         @JsonProperty("amount")
         @Alias("amount")
         private Integer amount;
         @JsonProperty("amount_used")
         @Alias("amount_used")
         private Integer amountUsed;
         @JsonProperty("area")
         @Alias("area")
         private BigDecimal area;
         @JsonProperty("area_exclude_comp")
         @Alias("area_exclude_comp")
         private BigDecimal areaExcludeComp;
         @JsonProperty("curve_length")
         @Alias("curve_length")
         private BigDecimal curveLength;
         @JsonProperty("curve_time")
         @Alias("curve_time")
         private String curveTime;
         @JsonProperty("height")
         @Alias("height")
         private BigDecimal height;
         @JsonProperty("inner_area")
         @Alias("inner_area")
         private BigDecimal innerArea;
         @JsonProperty("inner_count")
         @Alias("inner_count")
         private BigDecimal innerCount;
         @JsonProperty("inner_length")
         @Alias("inner_length")
         private BigDecimal innerLength;
         @JsonProperty("mark_count")
         @Alias("mark_count")
         private BigDecimal markCount;
         @JsonProperty("mark_length")
         @Alias("mark_length")
         private BigDecimal markLength;
         @JsonProperty("mark_point")
         @Alias("mark_point")
         private BigDecimal markPoint;
         @JsonProperty("name")
         @Alias("name")
         private String name;
         @JsonProperty("out_area")
         @Alias("out_area")
         private BigDecimal outArea;
         @JsonProperty("out_area_exclude_comp")
         @Alias("out_area_exclude_comp")
         private BigDecimal outAreaExcludeComp;
         @JsonProperty("outline_length")
         @Alias("outline_length")
         private BigDecimal outlineLength;
         @JsonProperty("pierce_count")
         @Alias("pierce_count")
         private BigDecimal pierceCount;
         @JsonProperty("width")
         @Alias("width")
         private BigDecimal width;
         @JsonProperty("guid")
         @Alias("guid")
         private String guid;
         @JsonProperty("material")
         @Alias("material")
         private String material;
         @JsonProperty("thickness")
         @Alias("thickness")
         private BigDecimal thickness;
         @JsonProperty("gas")
         @Alias("gas")
         private String gas;
         @JsonProperty("material_price")
         @Alias("material_price")
         private BigDecimal materialPrice;
         @JsonProperty("hole_price")
         @Alias("hole_price")
         private BigDecimal holePrice;
         @JsonProperty("cut_price")
         @Alias("cut_price")
         private BigDecimal cutPrice;
         @JsonProperty("mark_price")
         @Alias("mark_price")
         private BigDecimal markPrice;
         @JsonProperty("thumbnail_url")
         @Alias("thumbnail_url")
         private String thumbnailUrl;
         @JsonProperty("job_name")
         @Alias("job_name")
         private String jobName;
         @JsonProperty("job_amount")
         @Alias("job_amount")
         private BigDecimal jobAmount;
         @JsonProperty("finish_nest_amount")
         @Alias("finish_nest_amount")
         private BigDecimal finishNestAmount;
         @JsonProperty("rect_area")
         @Alias("rect_area")
         private BigDecimal rectArea;
         @JsonProperty("out_line")
         @Alias("out_line")
         private String outLine;
         @JsonProperty("inner_line")
         @Alias("inner_line")
         private String innerLine;
         @JsonProperty("contours_count")
         @Alias("contours_count")
         private BigDecimal contoursCount;
         @JsonProperty("weight")
         @Alias("weight")
         private BigDecimal weight;
         @JsonProperty("weight_exclude_comp")
         @Alias("weight_exclude_comp")
         private BigDecimal weightExcludeComp;
         @JsonProperty("density")
         @Alias("density")
         private BigDecimal density;
         @JsonProperty("props")
         @Alias("props")
         private List<PropDTO> propList;
         private Map<String, Object> propMap;

         public Map<String, Object> getPropMap() {
            return CollUtil.isEmpty(this.propMap) && CollUtil.isNotEmpty(this.getPropList())
               ? this.getPropList().stream().collect(Collectors.toMap(PropDTO::getPropName, PropDTO::getPropValue))
               : this.propMap;
         }

         public String getId() {
            return this.id;
         }

         public Integer getAmount() {
            return this.amount;
         }

         public Integer getAmountUsed() {
            return this.amountUsed;
         }

         public BigDecimal getArea() {
            return this.area;
         }

         public BigDecimal getAreaExcludeComp() {
            return this.areaExcludeComp;
         }

         public BigDecimal getCurveLength() {
            return this.curveLength;
         }

         public String getCurveTime() {
            return this.curveTime;
         }

         public BigDecimal getHeight() {
            return this.height;
         }

         public BigDecimal getInnerArea() {
            return this.innerArea;
         }

         public BigDecimal getInnerCount() {
            return this.innerCount;
         }

         public BigDecimal getInnerLength() {
            return this.innerLength;
         }

         public BigDecimal getMarkCount() {
            return this.markCount;
         }

         public BigDecimal getMarkLength() {
            return this.markLength;
         }

         public BigDecimal getMarkPoint() {
            return this.markPoint;
         }

         public String getName() {
            return this.name;
         }

         public BigDecimal getOutArea() {
            return this.outArea;
         }

         public BigDecimal getOutAreaExcludeComp() {
            return this.outAreaExcludeComp;
         }

         public BigDecimal getOutlineLength() {
            return this.outlineLength;
         }

         public BigDecimal getPierceCount() {
            return this.pierceCount;
         }

         public BigDecimal getWidth() {
            return this.width;
         }

         public String getGuid() {
            return this.guid;
         }

         public String getMaterial() {
            return this.material;
         }

         public BigDecimal getThickness() {
            return this.thickness;
         }

         public String getGas() {
            return this.gas;
         }

         public BigDecimal getMaterialPrice() {
            return this.materialPrice;
         }

         public BigDecimal getHolePrice() {
            return this.holePrice;
         }

         public BigDecimal getCutPrice() {
            return this.cutPrice;
         }

         public BigDecimal getMarkPrice() {
            return this.markPrice;
         }

         public String getThumbnailUrl() {
            return this.thumbnailUrl;
         }

         public String getJobName() {
            return this.jobName;
         }

         public BigDecimal getJobAmount() {
            return this.jobAmount;
         }

         public BigDecimal getFinishNestAmount() {
            return this.finishNestAmount;
         }

         public BigDecimal getRectArea() {
            return this.rectArea;
         }

         public String getOutLine() {
            return this.outLine;
         }

         public String getInnerLine() {
            return this.innerLine;
         }

         public BigDecimal getContoursCount() {
            return this.contoursCount;
         }

         public BigDecimal getWeight() {
            return this.weight;
         }

         public BigDecimal getWeightExcludeComp() {
            return this.weightExcludeComp;
         }

         public BigDecimal getDensity() {
            return this.density;
         }

         public List<PropDTO> getPropList() {
            return this.propList;
         }

         @JsonProperty("ID")
         public void setId(final String id) {
            this.id = id;
         }

         @JsonProperty("amount")
         public void setAmount(final Integer amount) {
            this.amount = amount;
         }

         @JsonProperty("amount_used")
         public void setAmountUsed(final Integer amountUsed) {
            this.amountUsed = amountUsed;
         }

         @JsonProperty("area")
         public void setArea(final BigDecimal area) {
            this.area = area;
         }

         @JsonProperty("area_exclude_comp")
         public void setAreaExcludeComp(final BigDecimal areaExcludeComp) {
            this.areaExcludeComp = areaExcludeComp;
         }

         @JsonProperty("curve_length")
         public void setCurveLength(final BigDecimal curveLength) {
            this.curveLength = curveLength;
         }

         @JsonProperty("curve_time")
         public void setCurveTime(final String curveTime) {
            this.curveTime = curveTime;
         }

         @JsonProperty("height")
         public void setHeight(final BigDecimal height) {
            this.height = height;
         }

         @JsonProperty("inner_area")
         public void setInnerArea(final BigDecimal innerArea) {
            this.innerArea = innerArea;
         }

         @JsonProperty("inner_count")
         public void setInnerCount(final BigDecimal innerCount) {
            this.innerCount = innerCount;
         }

         @JsonProperty("inner_length")
         public void setInnerLength(final BigDecimal innerLength) {
            this.innerLength = innerLength;
         }

         @JsonProperty("mark_count")
         public void setMarkCount(final BigDecimal markCount) {
            this.markCount = markCount;
         }

         @JsonProperty("mark_length")
         public void setMarkLength(final BigDecimal markLength) {
            this.markLength = markLength;
         }

         @JsonProperty("mark_point")
         public void setMarkPoint(final BigDecimal markPoint) {
            this.markPoint = markPoint;
         }

         @JsonProperty("name")
         public void setName(final String name) {
            this.name = name;
         }

         @JsonProperty("out_area")
         public void setOutArea(final BigDecimal outArea) {
            this.outArea = outArea;
         }

         @JsonProperty("out_area_exclude_comp")
         public void setOutAreaExcludeComp(final BigDecimal outAreaExcludeComp) {
            this.outAreaExcludeComp = outAreaExcludeComp;
         }

         @JsonProperty("outline_length")
         public void setOutlineLength(final BigDecimal outlineLength) {
            this.outlineLength = outlineLength;
         }

         @JsonProperty("pierce_count")
         public void setPierceCount(final BigDecimal pierceCount) {
            this.pierceCount = pierceCount;
         }

         @JsonProperty("width")
         public void setWidth(final BigDecimal width) {
            this.width = width;
         }

         @JsonProperty("guid")
         public void setGuid(final String guid) {
            this.guid = guid;
         }

         @JsonProperty("material")
         public void setMaterial(final String material) {
            this.material = material;
         }

         @JsonProperty("thickness")
         public void setThickness(final BigDecimal thickness) {
            this.thickness = thickness;
         }

         @JsonProperty("gas")
         public void setGas(final String gas) {
            this.gas = gas;
         }

         @JsonProperty("material_price")
         public void setMaterialPrice(final BigDecimal materialPrice) {
            this.materialPrice = materialPrice;
         }

         @JsonProperty("hole_price")
         public void setHolePrice(final BigDecimal holePrice) {
            this.holePrice = holePrice;
         }

         @JsonProperty("cut_price")
         public void setCutPrice(final BigDecimal cutPrice) {
            this.cutPrice = cutPrice;
         }

         @JsonProperty("mark_price")
         public void setMarkPrice(final BigDecimal markPrice) {
            this.markPrice = markPrice;
         }

         @JsonProperty("thumbnail_url")
         public void setThumbnailUrl(final String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
         }

         @JsonProperty("job_name")
         public void setJobName(final String jobName) {
            this.jobName = jobName;
         }

         @JsonProperty("job_amount")
         public void setJobAmount(final BigDecimal jobAmount) {
            this.jobAmount = jobAmount;
         }

         @JsonProperty("finish_nest_amount")
         public void setFinishNestAmount(final BigDecimal finishNestAmount) {
            this.finishNestAmount = finishNestAmount;
         }

         @JsonProperty("rect_area")
         public void setRectArea(final BigDecimal rectArea) {
            this.rectArea = rectArea;
         }

         @JsonProperty("out_line")
         public void setOutLine(final String outLine) {
            this.outLine = outLine;
         }

         @JsonProperty("inner_line")
         public void setInnerLine(final String innerLine) {
            this.innerLine = innerLine;
         }

         @JsonProperty("contours_count")
         public void setContoursCount(final BigDecimal contoursCount) {
            this.contoursCount = contoursCount;
         }

         @JsonProperty("weight")
         public void setWeight(final BigDecimal weight) {
            this.weight = weight;
         }

         @JsonProperty("weight_exclude_comp")
         public void setWeightExcludeComp(final BigDecimal weightExcludeComp) {
            this.weightExcludeComp = weightExcludeComp;
         }

         @JsonProperty("density")
         public void setDensity(final BigDecimal density) {
            this.density = density;
         }

         @JsonProperty("props")
         public void setPropList(final List<PropDTO> propList) {
            this.propList = propList;
         }

         public void setPropMap(final Map<String, Object> propMap) {
            this.propMap = propMap;
         }

         @Override
         public boolean equals(final Object o) {
            if (o == this) {
               return true;
            }

            if (!(o instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO)) {
               return false;
            }

            BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO other = (BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO)o;
            if (!other.canEqual(this)) {
               return false;
            }

            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountUsed = this.getAmountUsed();
               Object other$amountUsed = other.getAmountUsed();
               if (this$amountUsed == null ? other$amountUsed == null : this$amountUsed.equals(other$amountUsed)) {
                  Object this$id = this.getId();
                  Object other$id = other.getId();
                  if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$areaExcludeComp = this.getAreaExcludeComp();
                        Object other$areaExcludeComp = other.getAreaExcludeComp();
                        if (this$areaExcludeComp == null ? other$areaExcludeComp == null : this$areaExcludeComp.equals(other$areaExcludeComp)) {
                           Object this$curveLength = this.getCurveLength();
                           Object other$curveLength = other.getCurveLength();
                           if (this$curveLength == null ? other$curveLength == null : this$curveLength.equals(other$curveLength)) {
                              Object this$curveTime = this.getCurveTime();
                              Object other$curveTime = other.getCurveTime();
                              if (this$curveTime == null ? other$curveTime == null : this$curveTime.equals(other$curveTime)) {
                                 Object this$height = this.getHeight();
                                 Object other$height = other.getHeight();
                                 if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                                    Object this$innerArea = this.getInnerArea();
                                    Object other$innerArea = other.getInnerArea();
                                    if (this$innerArea == null ? other$innerArea == null : this$innerArea.equals(other$innerArea)) {
                                       Object this$innerCount = this.getInnerCount();
                                       Object other$innerCount = other.getInnerCount();
                                       if (this$innerCount == null ? other$innerCount == null : this$innerCount.equals(other$innerCount)) {
                                          Object this$innerLength = this.getInnerLength();
                                          Object other$innerLength = other.getInnerLength();
                                          if (this$innerLength == null ? other$innerLength == null : this$innerLength.equals(other$innerLength)) {
                                             Object this$markCount = this.getMarkCount();
                                             Object other$markCount = other.getMarkCount();
                                             if (this$markCount == null ? other$markCount == null : this$markCount.equals(other$markCount)) {
                                                Object this$markLength = this.getMarkLength();
                                                Object other$markLength = other.getMarkLength();
                                                if (this$markLength == null ? other$markLength == null : this$markLength.equals(other$markLength)) {
                                                   Object this$markPoint = this.getMarkPoint();
                                                   Object other$markPoint = other.getMarkPoint();
                                                   if (this$markPoint == null ? other$markPoint == null : this$markPoint.equals(other$markPoint)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$outArea = this.getOutArea();
                                                         Object other$outArea = other.getOutArea();
                                                         if (this$outArea == null ? other$outArea == null : this$outArea.equals(other$outArea)) {
                                                            Object this$outAreaExcludeComp = this.getOutAreaExcludeComp();
                                                            Object other$outAreaExcludeComp = other.getOutAreaExcludeComp();
                                                            if (this$outAreaExcludeComp == null
                                                               ? other$outAreaExcludeComp == null
                                                               : this$outAreaExcludeComp.equals(other$outAreaExcludeComp)) {
                                                               Object this$outlineLength = this.getOutlineLength();
                                                               Object other$outlineLength = other.getOutlineLength();
                                                               if (this$outlineLength == null
                                                                  ? other$outlineLength == null
                                                                  : this$outlineLength.equals(other$outlineLength)) {
                                                                  Object this$pierceCount = this.getPierceCount();
                                                                  Object other$pierceCount = other.getPierceCount();
                                                                  if (this$pierceCount == null
                                                                     ? other$pierceCount == null
                                                                     : this$pierceCount.equals(other$pierceCount)) {
                                                                     Object this$width = this.getWidth();
                                                                     Object other$width = other.getWidth();
                                                                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                        Object this$guid = this.getGuid();
                                                                        Object other$guid = other.getGuid();
                                                                        if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                                                           Object this$material = this.getMaterial();
                                                                           Object other$material = other.getMaterial();
                                                                           if (this$material == null
                                                                              ? other$material == null
                                                                              : this$material.equals(other$material)) {
                                                                              Object this$thickness = this.getThickness();
                                                                              Object other$thickness = other.getThickness();
                                                                              if (this$thickness == null
                                                                                 ? other$thickness == null
                                                                                 : this$thickness.equals(other$thickness)) {
                                                                                 Object this$gas = this.getGas();
                                                                                 Object other$gas = other.getGas();
                                                                                 if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                                                                                    Object this$materialPrice = this.getMaterialPrice();
                                                                                    Object other$materialPrice = other.getMaterialPrice();
                                                                                    if (this$materialPrice == null
                                                                                       ? other$materialPrice == null
                                                                                       : this$materialPrice.equals(other$materialPrice)) {
                                                                                       Object this$holePrice = this.getHolePrice();
                                                                                       Object other$holePrice = other.getHolePrice();
                                                                                       if (this$holePrice == null
                                                                                          ? other$holePrice == null
                                                                                          : this$holePrice.equals(other$holePrice)) {
                                                                                          Object this$cutPrice = this.getCutPrice();
                                                                                          Object other$cutPrice = other.getCutPrice();
                                                                                          if (this$cutPrice == null
                                                                                             ? other$cutPrice == null
                                                                                             : this$cutPrice.equals(other$cutPrice)) {
                                                                                             Object this$markPrice = this.getMarkPrice();
                                                                                             Object other$markPrice = other.getMarkPrice();
                                                                                             if (this$markPrice == null
                                                                                                ? other$markPrice == null
                                                                                                : this$markPrice.equals(other$markPrice)) {
                                                                                                Object this$thumbnailUrl = this.getThumbnailUrl();
                                                                                                Object other$thumbnailUrl = other.getThumbnailUrl();
                                                                                                if (this$thumbnailUrl == null
                                                                                                   ? other$thumbnailUrl == null
                                                                                                   : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                                                   Object this$jobName = this.getJobName();
                                                                                                   Object other$jobName = other.getJobName();
                                                                                                   if (this$jobName == null
                                                                                                      ? other$jobName == null
                                                                                                      : this$jobName.equals(other$jobName)) {
                                                                                                      Object this$jobAmount = this.getJobAmount();
                                                                                                      Object other$jobAmount = other.getJobAmount();
                                                                                                      if (this$jobAmount == null
                                                                                                         ? other$jobAmount == null
                                                                                                         : this$jobAmount.equals(other$jobAmount)) {
                                                                                                         Object this$finishNestAmount = this.getFinishNestAmount();
                                                                                                         Object other$finishNestAmount = other.getFinishNestAmount();
                                                                                                         if (this$finishNestAmount == null
                                                                                                            ? other$finishNestAmount == null
                                                                                                            : this$finishNestAmount.equals(
                                                                                                               other$finishNestAmount
                                                                                                            )) {
                                                                                                            Object this$rectArea = this.getRectArea();
                                                                                                            Object other$rectArea = other.getRectArea();
                                                                                                            if (this$rectArea == null
                                                                                                               ? other$rectArea == null
                                                                                                               : this$rectArea.equals(other$rectArea)) {
                                                                                                               Object this$outLine = this.getOutLine();
                                                                                                               Object other$outLine = other.getOutLine();
                                                                                                               if (this$outLine == null
                                                                                                                  ? other$outLine == null
                                                                                                                  : this$outLine.equals(other$outLine)) {
                                                                                                                  Object this$innerLine = this.getInnerLine();
                                                                                                                  Object other$innerLine = other.getInnerLine();
                                                                                                                  if (this$innerLine == null
                                                                                                                     ? other$innerLine == null
                                                                                                                     : this$innerLine.equals(other$innerLine)) {
                                                                                                                     Object this$contoursCount = this.getContoursCount();
                                                                                                                     Object other$contoursCount = other.getContoursCount();
                                                                                                                     if (this$contoursCount == null
                                                                                                                        ? other$contoursCount == null
                                                                                                                        : this$contoursCount.equals(
                                                                                                                           other$contoursCount
                                                                                                                        )) {
                                                                                                                        Object this$weight = this.getWeight();
                                                                                                                        Object other$weight = other.getWeight();
                                                                                                                        if (this$weight == null
                                                                                                                           ? other$weight == null
                                                                                                                           : this$weight.equals(other$weight)) {
                                                                                                                           Object this$weightExcludeComp = this.getWeightExcludeComp();
                                                                                                                           Object other$weightExcludeComp = other.getWeightExcludeComp();
                                                                                                                           if (this$weightExcludeComp == null
                                                                                                                              ? other$weightExcludeComp == null
                                                                                                                              : this$weightExcludeComp.equals(
                                                                                                                                 other$weightExcludeComp
                                                                                                                              )) {
                                                                                                                              Object this$density = this.getDensity();
                                                                                                                              Object other$density = other.getDensity();
                                                                                                                              if (this$density == null
                                                                                                                                 ? other$density == null
                                                                                                                                 : this$density.equals(
                                                                                                                                    other$density
                                                                                                                                 )) {
                                                                                                                                 Object this$propList = this.getPropList();
                                                                                                                                 Object other$propList = other.getPropList();
                                                                                                                                 if (this$propList == null
                                                                                                                                    ? other$propList == null
                                                                                                                                    : this$propList.equals(
                                                                                                                                       other$propList
                                                                                                                                    )) {
                                                                                                                                    Object this$propMap = this.getPropMap();
                                                                                                                                    Object other$propMap = other.getPropMap();
                                                                                                                                    return this$propMap == null
                                                                                                                                       ? other$propMap == null
                                                                                                                                       : this$propMap.equals(
                                                                                                                                          other$propMap
                                                                                                                                       );
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
            return other instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO;
         }

         @Override
         public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Object $amount = this.getAmount();
            result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
            Object $amountUsed = this.getAmountUsed();
            result = result * 59 + ($amountUsed == null ? 43 : $amountUsed.hashCode());
            Object $id = this.getId();
            result = result * 59 + ($id == null ? 43 : $id.hashCode());
            Object $area = this.getArea();
            result = result * 59 + ($area == null ? 43 : $area.hashCode());
            Object $areaExcludeComp = this.getAreaExcludeComp();
            result = result * 59 + ($areaExcludeComp == null ? 43 : $areaExcludeComp.hashCode());
            Object $curveLength = this.getCurveLength();
            result = result * 59 + ($curveLength == null ? 43 : $curveLength.hashCode());
            Object $curveTime = this.getCurveTime();
            result = result * 59 + ($curveTime == null ? 43 : $curveTime.hashCode());
            Object $height = this.getHeight();
            result = result * 59 + ($height == null ? 43 : $height.hashCode());
            Object $innerArea = this.getInnerArea();
            result = result * 59 + ($innerArea == null ? 43 : $innerArea.hashCode());
            Object $innerCount = this.getInnerCount();
            result = result * 59 + ($innerCount == null ? 43 : $innerCount.hashCode());
            Object $innerLength = this.getInnerLength();
            result = result * 59 + ($innerLength == null ? 43 : $innerLength.hashCode());
            Object $markCount = this.getMarkCount();
            result = result * 59 + ($markCount == null ? 43 : $markCount.hashCode());
            Object $markLength = this.getMarkLength();
            result = result * 59 + ($markLength == null ? 43 : $markLength.hashCode());
            Object $markPoint = this.getMarkPoint();
            result = result * 59 + ($markPoint == null ? 43 : $markPoint.hashCode());
            Object $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Object $outArea = this.getOutArea();
            result = result * 59 + ($outArea == null ? 43 : $outArea.hashCode());
            Object $outAreaExcludeComp = this.getOutAreaExcludeComp();
            result = result * 59 + ($outAreaExcludeComp == null ? 43 : $outAreaExcludeComp.hashCode());
            Object $outlineLength = this.getOutlineLength();
            result = result * 59 + ($outlineLength == null ? 43 : $outlineLength.hashCode());
            Object $pierceCount = this.getPierceCount();
            result = result * 59 + ($pierceCount == null ? 43 : $pierceCount.hashCode());
            Object $width = this.getWidth();
            result = result * 59 + ($width == null ? 43 : $width.hashCode());
            Object $guid = this.getGuid();
            result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
            Object $material = this.getMaterial();
            result = result * 59 + ($material == null ? 43 : $material.hashCode());
            Object $thickness = this.getThickness();
            result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
            Object $gas = this.getGas();
            result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
            Object $materialPrice = this.getMaterialPrice();
            result = result * 59 + ($materialPrice == null ? 43 : $materialPrice.hashCode());
            Object $holePrice = this.getHolePrice();
            result = result * 59 + ($holePrice == null ? 43 : $holePrice.hashCode());
            Object $cutPrice = this.getCutPrice();
            result = result * 59 + ($cutPrice == null ? 43 : $cutPrice.hashCode());
            Object $markPrice = this.getMarkPrice();
            result = result * 59 + ($markPrice == null ? 43 : $markPrice.hashCode());
            Object $thumbnailUrl = this.getThumbnailUrl();
            result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
            Object $jobName = this.getJobName();
            result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
            Object $jobAmount = this.getJobAmount();
            result = result * 59 + ($jobAmount == null ? 43 : $jobAmount.hashCode());
            Object $finishNestAmount = this.getFinishNestAmount();
            result = result * 59 + ($finishNestAmount == null ? 43 : $finishNestAmount.hashCode());
            Object $rectArea = this.getRectArea();
            result = result * 59 + ($rectArea == null ? 43 : $rectArea.hashCode());
            Object $outLine = this.getOutLine();
            result = result * 59 + ($outLine == null ? 43 : $outLine.hashCode());
            Object $innerLine = this.getInnerLine();
            result = result * 59 + ($innerLine == null ? 43 : $innerLine.hashCode());
            Object $contoursCount = this.getContoursCount();
            result = result * 59 + ($contoursCount == null ? 43 : $contoursCount.hashCode());
            Object $weight = this.getWeight();
            result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
            Object $weightExcludeComp = this.getWeightExcludeComp();
            result = result * 59 + ($weightExcludeComp == null ? 43 : $weightExcludeComp.hashCode());
            Object $density = this.getDensity();
            result = result * 59 + ($density == null ? 43 : $density.hashCode());
            Object $propList = this.getPropList();
            result = result * 59 + ($propList == null ? 43 : $propList.hashCode());
            Object $propMap = this.getPropMap();
            return result * 59 + ($propMap == null ? 43 : $propMap.hashCode());
         }

         @Override
         public String toString() {
            return "BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO(id="
               + this.getId()
               + ", amount="
               + this.getAmount()
               + ", amountUsed="
               + this.getAmountUsed()
               + ", area="
               + this.getArea()
               + ", areaExcludeComp="
               + this.getAreaExcludeComp()
               + ", curveLength="
               + this.getCurveLength()
               + ", curveTime="
               + this.getCurveTime()
               + ", height="
               + this.getHeight()
               + ", innerArea="
               + this.getInnerArea()
               + ", innerCount="
               + this.getInnerCount()
               + ", innerLength="
               + this.getInnerLength()
               + ", markCount="
               + this.getMarkCount()
               + ", markLength="
               + this.getMarkLength()
               + ", markPoint="
               + this.getMarkPoint()
               + ", name="
               + this.getName()
               + ", outArea="
               + this.getOutArea()
               + ", outAreaExcludeComp="
               + this.getOutAreaExcludeComp()
               + ", outlineLength="
               + this.getOutlineLength()
               + ", pierceCount="
               + this.getPierceCount()
               + ", width="
               + this.getWidth()
               + ", guid="
               + this.getGuid()
               + ", material="
               + this.getMaterial()
               + ", thickness="
               + this.getThickness()
               + ", gas="
               + this.getGas()
               + ", materialPrice="
               + this.getMaterialPrice()
               + ", holePrice="
               + this.getHolePrice()
               + ", cutPrice="
               + this.getCutPrice()
               + ", markPrice="
               + this.getMarkPrice()
               + ", thumbnailUrl="
               + this.getThumbnailUrl()
               + ", jobName="
               + this.getJobName()
               + ", jobAmount="
               + this.getJobAmount()
               + ", finishNestAmount="
               + this.getFinishNestAmount()
               + ", rectArea="
               + this.getRectArea()
               + ", outLine="
               + this.getOutLine()
               + ", innerLine="
               + this.getInnerLine()
               + ", contoursCount="
               + this.getContoursCount()
               + ", weight="
               + this.getWeight()
               + ", weightExcludeComp="
               + this.getWeightExcludeComp()
               + ", density="
               + this.getDensity()
               + ", propList="
               + this.getPropList()
               + ", propMap="
               + this.getPropMap()
               + ")";
         }
      }

      public static class PlateInfoDTO {
         @JsonProperty("amount")
         @Alias("amount")
         private BigDecimal amount;
         @JsonProperty("area")
         @Alias("area")
         private BigDecimal area;
         @JsonProperty("extmax_x")
         @Alias("extmax_x")
         private BigDecimal extmaxX;
         @JsonProperty("extmax_y")
         @Alias("extmax_y")
         private BigDecimal extmaxY;
         @JsonProperty("gap")
         @Alias("gap")
         private String gap;
         @JsonProperty("guid")
         @Alias("guid")
         private String guid;
         @JsonProperty("name")
         @Alias("name")
         private String name;
         @JsonProperty("material")
         @Alias("material")
         private String material;
         @JsonProperty("thickness")
         @Alias("thickness")
         private BigDecimal thickness;
         @JsonProperty("coedge_volume")
         @Alias("coedge_volume")
         private BigDecimal coedgeVolume;
         @JsonProperty("density")
         @Alias("density")
         private BigDecimal density;
         @JsonProperty("utilization")
         @Alias("utilization")
         private String utilization;
         @JsonProperty("utilization_slab")
         @Alias("utilization_slab")
         private String utilizationSlab;
         @JsonProperty("utilization_nestedrec")
         @Alias("utilization_nestedrec")
         private String utilizationNestedrec;
         @JsonProperty("utilization_nestedrec_slab")
         @Alias("utilization_nestedrec_slab")
         private String utilizationNestedrecSlab;

         public BigDecimal getAmount() {
            return this.amount;
         }

         public BigDecimal getArea() {
            return this.area;
         }

         public BigDecimal getExtmaxX() {
            return this.extmaxX;
         }

         public BigDecimal getExtmaxY() {
            return this.extmaxY;
         }

         public String getGap() {
            return this.gap;
         }

         public String getGuid() {
            return this.guid;
         }

         public String getName() {
            return this.name;
         }

         public String getMaterial() {
            return this.material;
         }

         public BigDecimal getThickness() {
            return this.thickness;
         }

         public BigDecimal getCoedgeVolume() {
            return this.coedgeVolume;
         }

         public BigDecimal getDensity() {
            return this.density;
         }

         public String getUtilization() {
            return this.utilization;
         }

         public String getUtilizationSlab() {
            return this.utilizationSlab;
         }

         public String getUtilizationNestedrec() {
            return this.utilizationNestedrec;
         }

         public String getUtilizationNestedrecSlab() {
            return this.utilizationNestedrecSlab;
         }

         @JsonProperty("amount")
         public void setAmount(final BigDecimal amount) {
            this.amount = amount;
         }

         @JsonProperty("area")
         public void setArea(final BigDecimal area) {
            this.area = area;
         }

         @JsonProperty("extmax_x")
         public void setExtmaxX(final BigDecimal extmaxX) {
            this.extmaxX = extmaxX;
         }

         @JsonProperty("extmax_y")
         public void setExtmaxY(final BigDecimal extmaxY) {
            this.extmaxY = extmaxY;
         }

         @JsonProperty("gap")
         public void setGap(final String gap) {
            this.gap = gap;
         }

         @JsonProperty("guid")
         public void setGuid(final String guid) {
            this.guid = guid;
         }

         @JsonProperty("name")
         public void setName(final String name) {
            this.name = name;
         }

         @JsonProperty("material")
         public void setMaterial(final String material) {
            this.material = material;
         }

         @JsonProperty("thickness")
         public void setThickness(final BigDecimal thickness) {
            this.thickness = thickness;
         }

         @JsonProperty("coedge_volume")
         public void setCoedgeVolume(final BigDecimal coedgeVolume) {
            this.coedgeVolume = coedgeVolume;
         }

         @JsonProperty("density")
         public void setDensity(final BigDecimal density) {
            this.density = density;
         }

         @JsonProperty("utilization")
         public void setUtilization(final String utilization) {
            this.utilization = utilization;
         }

         @JsonProperty("utilization_slab")
         public void setUtilizationSlab(final String utilizationSlab) {
            this.utilizationSlab = utilizationSlab;
         }

         @JsonProperty("utilization_nestedrec")
         public void setUtilizationNestedrec(final String utilizationNestedrec) {
            this.utilizationNestedrec = utilizationNestedrec;
         }

         @JsonProperty("utilization_nestedrec_slab")
         public void setUtilizationNestedrecSlab(final String utilizationNestedrecSlab) {
            this.utilizationNestedrecSlab = utilizationNestedrecSlab;
         }

         @Override
         public boolean equals(final Object o) {
            if (o == this) {
               return true;
            }

            if (!(o instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO)) {
               return false;
            }

            BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO other = (BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO)o;
            if (!other.canEqual(this)) {
               return false;
            }

            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$area = this.getArea();
               Object other$area = other.getArea();
               if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                  Object this$extmaxX = this.getExtmaxX();
                  Object other$extmaxX = other.getExtmaxX();
                  if (this$extmaxX == null ? other$extmaxX == null : this$extmaxX.equals(other$extmaxX)) {
                     Object this$extmaxY = this.getExtmaxY();
                     Object other$extmaxY = other.getExtmaxY();
                     if (this$extmaxY == null ? other$extmaxY == null : this$extmaxY.equals(other$extmaxY)) {
                        Object this$gap = this.getGap();
                        Object other$gap = other.getGap();
                        if (this$gap == null ? other$gap == null : this$gap.equals(other$gap)) {
                           Object this$guid = this.getGuid();
                           Object other$guid = other.getGuid();
                           if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$coedgeVolume = this.getCoedgeVolume();
                                       Object other$coedgeVolume = other.getCoedgeVolume();
                                       if (this$coedgeVolume == null ? other$coedgeVolume == null : this$coedgeVolume.equals(other$coedgeVolume)) {
                                          Object this$density = this.getDensity();
                                          Object other$density = other.getDensity();
                                          if (this$density == null ? other$density == null : this$density.equals(other$density)) {
                                             Object this$utilization = this.getUtilization();
                                             Object other$utilization = other.getUtilization();
                                             if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                                Object this$utilizationSlab = this.getUtilizationSlab();
                                                Object other$utilizationSlab = other.getUtilizationSlab();
                                                if (this$utilizationSlab == null
                                                   ? other$utilizationSlab == null
                                                   : this$utilizationSlab.equals(other$utilizationSlab)) {
                                                   Object this$utilizationNestedrec = this.getUtilizationNestedrec();
                                                   Object other$utilizationNestedrec = other.getUtilizationNestedrec();
                                                   if (this$utilizationNestedrec == null
                                                      ? other$utilizationNestedrec == null
                                                      : this$utilizationNestedrec.equals(other$utilizationNestedrec)) {
                                                      Object this$utilizationNestedrecSlab = this.getUtilizationNestedrecSlab();
                                                      Object other$utilizationNestedrecSlab = other.getUtilizationNestedrecSlab();
                                                      return this$utilizationNestedrecSlab == null
                                                         ? other$utilizationNestedrecSlab == null
                                                         : this$utilizationNestedrecSlab.equals(other$utilizationNestedrecSlab);
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
            return other instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO;
         }

         @Override
         public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Object $amount = this.getAmount();
            result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
            Object $area = this.getArea();
            result = result * 59 + ($area == null ? 43 : $area.hashCode());
            Object $extmaxX = this.getExtmaxX();
            result = result * 59 + ($extmaxX == null ? 43 : $extmaxX.hashCode());
            Object $extmaxY = this.getExtmaxY();
            result = result * 59 + ($extmaxY == null ? 43 : $extmaxY.hashCode());
            Object $gap = this.getGap();
            result = result * 59 + ($gap == null ? 43 : $gap.hashCode());
            Object $guid = this.getGuid();
            result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
            Object $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Object $material = this.getMaterial();
            result = result * 59 + ($material == null ? 43 : $material.hashCode());
            Object $thickness = this.getThickness();
            result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
            Object $coedgeVolume = this.getCoedgeVolume();
            result = result * 59 + ($coedgeVolume == null ? 43 : $coedgeVolume.hashCode());
            Object $density = this.getDensity();
            result = result * 59 + ($density == null ? 43 : $density.hashCode());
            Object $utilization = this.getUtilization();
            result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
            Object $utilizationSlab = this.getUtilizationSlab();
            result = result * 59 + ($utilizationSlab == null ? 43 : $utilizationSlab.hashCode());
            Object $utilizationNestedrec = this.getUtilizationNestedrec();
            result = result * 59 + ($utilizationNestedrec == null ? 43 : $utilizationNestedrec.hashCode());
            Object $utilizationNestedrecSlab = this.getUtilizationNestedrecSlab();
            return result * 59 + ($utilizationNestedrecSlab == null ? 43 : $utilizationNestedrecSlab.hashCode());
         }

         @Override
         public String toString() {
            return "BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDTO(amount="
               + this.getAmount()
               + ", area="
               + this.getArea()
               + ", extmaxX="
               + this.getExtmaxX()
               + ", extmaxY="
               + this.getExtmaxY()
               + ", gap="
               + this.getGap()
               + ", guid="
               + this.getGuid()
               + ", name="
               + this.getName()
               + ", material="
               + this.getMaterial()
               + ", thickness="
               + this.getThickness()
               + ", coedgeVolume="
               + this.getCoedgeVolume()
               + ", density="
               + this.getDensity()
               + ", utilization="
               + this.getUtilization()
               + ", utilizationSlab="
               + this.getUtilizationSlab()
               + ", utilizationNestedrec="
               + this.getUtilizationNestedrec()
               + ", utilizationNestedrecSlab="
               + this.getUtilizationNestedrecSlab()
               + ")";
         }
      }

      public static class PlateInfoDetailDTO {
         @JsonProperty("guid")
         @Alias("guid")
         private String guid;
         @JsonProperty("plate_name")
         @Alias("plate_name")
         private String plateName;
         @JsonProperty("thickness")
         @Alias("thickness")
         private BigDecimal thickness;
         @JsonProperty("plate_type")
         @Alias("plate_type")
         private Integer plateType;
         @JsonProperty("width")
         @Alias("width")
         private BigDecimal width;
         @JsonProperty("height")
         @Alias("height")
         private BigDecimal height;
         @JsonProperty("sync_id")
         @Alias("sync_id")
         private String syncId;

         public String getGuid() {
            return this.guid;
         }

         public String getPlateName() {
            return this.plateName;
         }

         public BigDecimal getThickness() {
            return this.thickness;
         }

         public Integer getPlateType() {
            return this.plateType;
         }

         public BigDecimal getWidth() {
            return this.width;
         }

         public BigDecimal getHeight() {
            return this.height;
         }

         public String getSyncId() {
            return this.syncId;
         }

         @JsonProperty("guid")
         public void setGuid(final String guid) {
            this.guid = guid;
         }

         @JsonProperty("plate_name")
         public void setPlateName(final String plateName) {
            this.plateName = plateName;
         }

         @JsonProperty("thickness")
         public void setThickness(final BigDecimal thickness) {
            this.thickness = thickness;
         }

         @JsonProperty("plate_type")
         public void setPlateType(final Integer plateType) {
            this.plateType = plateType;
         }

         @JsonProperty("width")
         public void setWidth(final BigDecimal width) {
            this.width = width;
         }

         @JsonProperty("height")
         public void setHeight(final BigDecimal height) {
            this.height = height;
         }

         @JsonProperty("sync_id")
         public void setSyncId(final String syncId) {
            this.syncId = syncId;
         }

         @Override
         public boolean equals(final Object o) {
            if (o == this) {
               return true;
            }

            if (!(o instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO)) {
               return false;
            }

            BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO other = (BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO)o;
            if (!other.canEqual(this)) {
               return false;
            }

            Object this$plateType = this.getPlateType();
            Object other$plateType = other.getPlateType();
            if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
               Object this$guid = this.getGuid();
               Object other$guid = other.getGuid();
               if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                  Object this$plateName = this.getPlateName();
                  Object other$plateName = other.getPlateName();
                  if (this$plateName == null ? other$plateName == null : this$plateName.equals(other$plateName)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$width = this.getWidth();
                        Object other$width = other.getWidth();
                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                           Object this$height = this.getHeight();
                           Object other$height = other.getHeight();
                           if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                              Object this$syncId = this.getSyncId();
                              Object other$syncId = other.getSyncId();
                              return this$syncId == null ? other$syncId == null : this$syncId.equals(other$syncId);
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
            return other instanceof BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO;
         }

         @Override
         public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Object $plateType = this.getPlateType();
            result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
            Object $guid = this.getGuid();
            result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
            Object $plateName = this.getPlateName();
            result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
            Object $thickness = this.getThickness();
            result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
            Object $width = this.getWidth();
            result = result * 59 + ($width == null ? 43 : $width.hashCode());
            Object $height = this.getHeight();
            result = result * 59 + ($height == null ? 43 : $height.hashCode());
            Object $syncId = this.getSyncId();
            return result * 59 + ($syncId == null ? 43 : $syncId.hashCode());
         }

         @Override
         public String toString() {
            return "BoChuNestedPlateReportDTO.TotalInfoDTO.PlateInfoDetailDTO(guid="
               + this.getGuid()
               + ", plateName="
               + this.getPlateName()
               + ", thickness="
               + this.getThickness()
               + ", plateType="
               + this.getPlateType()
               + ", width="
               + this.getWidth()
               + ", height="
               + this.getHeight()
               + ", syncId="
               + this.getSyncId()
               + ")";
         }
      }
   }
}
