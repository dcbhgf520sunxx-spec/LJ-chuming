package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel(value = "DataConstructionLog对象", description = "施工日志")
public class DataConstructionLogDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty(name = "createUserId", value = "创建用户id")
   private Long createUserId;
   @ApiModelProperty(name = "subTime", value = "提交日期")
   @NotNull(message = "提交日期不能为空")
   private LocalDate subTime;
   @ApiModelProperty(name = "morningWeather", value = "上午天气")
   private String morningWeather;
   @ApiModelProperty(name = "afternoonWeather", value = "下午天气")
   private String afternoonWeather;
   @ApiModelProperty(name = "maxTemperature", value = "最高温度")
   private BigDecimal maxTemperature;
   @ApiModelProperty(name = "minTemperature", value = "最低温度")
   private BigDecimal minTemperature;
   @ApiModelProperty(name = "productionRecord", value = "生产情况记录")
   private String productionRecord;
   @ApiModelProperty(name = "safetyRecord", value = "安全记录")
   private String safetyRecord;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public LocalDate getSubTime() {
      return this.subTime;
   }

   public String getMorningWeather() {
      return this.morningWeather;
   }

   public String getAfternoonWeather() {
      return this.afternoonWeather;
   }

   public BigDecimal getMaxTemperature() {
      return this.maxTemperature;
   }

   public BigDecimal getMinTemperature() {
      return this.minTemperature;
   }

   public String getProductionRecord() {
      return this.productionRecord;
   }

   public String getSafetyRecord() {
      return this.safetyRecord;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setSubTime(final LocalDate subTime) {
      this.subTime = subTime;
   }

   public void setMorningWeather(final String morningWeather) {
      this.morningWeather = morningWeather;
   }

   public void setAfternoonWeather(final String afternoonWeather) {
      this.afternoonWeather = afternoonWeather;
   }

   public void setMaxTemperature(final BigDecimal maxTemperature) {
      this.maxTemperature = maxTemperature;
   }

   public void setMinTemperature(final BigDecimal minTemperature) {
      this.minTemperature = minTemperature;
   }

   public void setProductionRecord(final String productionRecord) {
      this.productionRecord = productionRecord;
   }

   public void setSafetyRecord(final String safetyRecord) {
      this.safetyRecord = safetyRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DataConstructionLogDTOParam)) {
         return false;
      }

      DataConstructionLogDTOParam other = (DataConstructionLogDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$subTime = this.getSubTime();
            Object other$subTime = other.getSubTime();
            if (this$subTime == null ? other$subTime == null : this$subTime.equals(other$subTime)) {
               Object this$morningWeather = this.getMorningWeather();
               Object other$morningWeather = other.getMorningWeather();
               if (this$morningWeather == null ? other$morningWeather == null : this$morningWeather.equals(other$morningWeather)) {
                  Object this$afternoonWeather = this.getAfternoonWeather();
                  Object other$afternoonWeather = other.getAfternoonWeather();
                  if (this$afternoonWeather == null ? other$afternoonWeather == null : this$afternoonWeather.equals(other$afternoonWeather)) {
                     Object this$maxTemperature = this.getMaxTemperature();
                     Object other$maxTemperature = other.getMaxTemperature();
                     if (this$maxTemperature == null ? other$maxTemperature == null : this$maxTemperature.equals(other$maxTemperature)) {
                        Object this$minTemperature = this.getMinTemperature();
                        Object other$minTemperature = other.getMinTemperature();
                        if (this$minTemperature == null ? other$minTemperature == null : this$minTemperature.equals(other$minTemperature)) {
                           Object this$productionRecord = this.getProductionRecord();
                           Object other$productionRecord = other.getProductionRecord();
                           if (this$productionRecord == null ? other$productionRecord == null : this$productionRecord.equals(other$productionRecord)) {
                              Object this$safetyRecord = this.getSafetyRecord();
                              Object other$safetyRecord = other.getSafetyRecord();
                              return this$safetyRecord == null ? other$safetyRecord == null : this$safetyRecord.equals(other$safetyRecord);
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
      return other instanceof DataConstructionLogDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $subTime = this.getSubTime();
      result = result * 59 + ($subTime == null ? 43 : $subTime.hashCode());
      Object $morningWeather = this.getMorningWeather();
      result = result * 59 + ($morningWeather == null ? 43 : $morningWeather.hashCode());
      Object $afternoonWeather = this.getAfternoonWeather();
      result = result * 59 + ($afternoonWeather == null ? 43 : $afternoonWeather.hashCode());
      Object $maxTemperature = this.getMaxTemperature();
      result = result * 59 + ($maxTemperature == null ? 43 : $maxTemperature.hashCode());
      Object $minTemperature = this.getMinTemperature();
      result = result * 59 + ($minTemperature == null ? 43 : $minTemperature.hashCode());
      Object $productionRecord = this.getProductionRecord();
      result = result * 59 + ($productionRecord == null ? 43 : $productionRecord.hashCode());
      Object $safetyRecord = this.getSafetyRecord();
      return result * 59 + ($safetyRecord == null ? 43 : $safetyRecord.hashCode());
   }

   @Override
   public String toString() {
      return "DataConstructionLogDTOParam(projectId="
         + this.getProjectId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", subTime="
         + this.getSubTime()
         + ", morningWeather="
         + this.getMorningWeather()
         + ", afternoonWeather="
         + this.getAfternoonWeather()
         + ", maxTemperature="
         + this.getMaxTemperature()
         + ", minTemperature="
         + this.getMinTemperature()
         + ", productionRecord="
         + this.getProductionRecord()
         + ", safetyRecord="
         + this.getSafetyRecord()
         + ")";
   }
}
