package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.scim.mes.building.core.api.utils.CustomBigDecimalSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "wastageDO", description = "损耗统计 ")
public class WastageDO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   private Long projectId;
   @ApiModelProperty(name = "createTime", value = "立项日期")
   @JsonProperty("createTime")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "createTimeStr", value = "立项日期")
   @JsonProperty("createTimeStr")
   @Excel(name = "立项日期", width = 20.0, orderNum = "1")
   private String createTimeStr;
   @ApiModelProperty(name = "status", notes = "项目状态  1：进行中，2：已暂停，4：已完工 ")
   @JsonProperty("status")
   @Excel(name = "项目状态", width = 20.0, orderNum = "2", replace = {"进行中_1", "已暂停_2", "已完工_4"})
   private Integer status;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @JsonProperty("projectName")
   @Excel(name = "项目名称", width = 50.0, orderNum = "3")
   private String projectName;
   @ApiModelProperty(name = "listQuantity", value = "清单量（吨）")
   @JsonProperty("listQuantity")
   @Excel(name = "清单量（吨）", width = 20.0, orderNum = "4")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal listQuantity = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalProduction", value = "累计生产（吨）")
   @JsonProperty("totalProduction")
   @Excel(name = "累计生产（吨）", width = 20.0, orderNum = "5")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalProduction = BigDecimal.ZERO;
   @ApiModelProperty(name = "steelPicking", notes = "钢板领用量（吨）")
   @JsonProperty("steelPicking")
   @Excel(name = "钢板领用量（吨）", width = 20.0, orderNum = "6")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal steelPicking = BigDecimal.ZERO;
   @ApiModelProperty(name = "sectionPicking", notes = "型材领用量（吨）")
   @JsonProperty("sectionPicking")
   @Excel(name = "型材领用量（吨）", width = 20.0, orderNum = "7")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal sectionPicking = BigDecimal.ZERO;
   @ApiModelProperty(name = "steelPlateReturn", notes = "钢板退库量（吨）")
   @JsonProperty("steelPlateReturn")
   @Excel(name = "钢板退库量（吨）", width = 20.0, orderNum = "8")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal steelPlateReturn = BigDecimal.ZERO;
   @ApiModelProperty(name = "sectionReturn", notes = "型材退库量（吨）")
   @JsonProperty("sectionReturn")
   @Excel(name = "型材退库量（吨）", width = 20.0, orderNum = "9")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal sectionReturn = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalReceive", notes = "实际领用总量（吨）")
   @JsonProperty("totalReceive")
   @Excel(name = "实际领用总量（吨）", width = 20.0, orderNum = "10")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalReceive = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalWastage", notes = "实际损耗总量（吨）")
   @JsonProperty("totalWastage")
   @Excel(name = "实际损耗总量（吨）", width = 20.0, orderNum = "11")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalWastage = BigDecimal.ZERO;
   @ApiModelProperty(name = "wastageRate", notes = "损耗率（%）")
   @JsonProperty("wastageRate")
   @Excel(name = "损耗率（%）", width = 20.0, orderNum = "12")
   private BigDecimal wastageRate;

   public static WastageDO.WastageDOBuilder builder() {
      return new WastageDO.WastageDOBuilder();
   }

   public WastageDO() {
   }

   public WastageDO(
      final Long projectId,
      final LocalDateTime createTime,
      final String createTimeStr,
      final Integer status,
      final String projectName,
      final BigDecimal listQuantity,
      final BigDecimal totalProduction,
      final BigDecimal steelPicking,
      final BigDecimal sectionPicking,
      final BigDecimal steelPlateReturn,
      final BigDecimal sectionReturn,
      final BigDecimal totalReceive,
      final BigDecimal totalWastage,
      final BigDecimal wastageRate
   ) {
      this.projectId = projectId;
      this.createTime = createTime;
      this.createTimeStr = createTimeStr;
      this.status = status;
      this.projectName = projectName;
      this.listQuantity = listQuantity;
      this.totalProduction = totalProduction;
      this.steelPicking = steelPicking;
      this.sectionPicking = sectionPicking;
      this.steelPlateReturn = steelPlateReturn;
      this.sectionReturn = sectionReturn;
      this.totalReceive = totalReceive;
      this.totalWastage = totalWastage;
      this.wastageRate = wastageRate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCreateTimeStr() {
      return this.createTimeStr;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getListQuantity() {
      return this.listQuantity;
   }

   public BigDecimal getTotalProduction() {
      return this.totalProduction;
   }

   public BigDecimal getSteelPicking() {
      return this.steelPicking;
   }

   public BigDecimal getSectionPicking() {
      return this.sectionPicking;
   }

   public BigDecimal getSteelPlateReturn() {
      return this.steelPlateReturn;
   }

   public BigDecimal getSectionReturn() {
      return this.sectionReturn;
   }

   public BigDecimal getTotalReceive() {
      return this.totalReceive;
   }

   public BigDecimal getTotalWastage() {
      return this.totalWastage;
   }

   public BigDecimal getWastageRate() {
      return this.wastageRate;
   }

   @JsonProperty("projectId")
   public WastageDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("createTime")
   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
   public WastageDO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("createTimeStr")
   public WastageDO setCreateTimeStr(final String createTimeStr) {
      this.createTimeStr = createTimeStr;
      return this;
   }

   @JsonProperty("status")
   public WastageDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("projectName")
   public WastageDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("listQuantity")
   public WastageDO setListQuantity(final BigDecimal listQuantity) {
      this.listQuantity = listQuantity;
      return this;
   }

   @JsonProperty("totalProduction")
   public WastageDO setTotalProduction(final BigDecimal totalProduction) {
      this.totalProduction = totalProduction;
      return this;
   }

   @JsonProperty("steelPicking")
   public WastageDO setSteelPicking(final BigDecimal steelPicking) {
      this.steelPicking = steelPicking;
      return this;
   }

   @JsonProperty("sectionPicking")
   public WastageDO setSectionPicking(final BigDecimal sectionPicking) {
      this.sectionPicking = sectionPicking;
      return this;
   }

   @JsonProperty("steelPlateReturn")
   public WastageDO setSteelPlateReturn(final BigDecimal steelPlateReturn) {
      this.steelPlateReturn = steelPlateReturn;
      return this;
   }

   @JsonProperty("sectionReturn")
   public WastageDO setSectionReturn(final BigDecimal sectionReturn) {
      this.sectionReturn = sectionReturn;
      return this;
   }

   @JsonProperty("totalReceive")
   public WastageDO setTotalReceive(final BigDecimal totalReceive) {
      this.totalReceive = totalReceive;
      return this;
   }

   @JsonProperty("totalWastage")
   public WastageDO setTotalWastage(final BigDecimal totalWastage) {
      this.totalWastage = totalWastage;
      return this;
   }

   @JsonProperty("wastageRate")
   public WastageDO setWastageRate(final BigDecimal wastageRate) {
      this.wastageRate = wastageRate;
      return this;
   }

   @Override
   public String toString() {
      return "WastageDO(projectId="
         + this.getProjectId()
         + ", createTime="
         + this.getCreateTime()
         + ", createTimeStr="
         + this.getCreateTimeStr()
         + ", status="
         + this.getStatus()
         + ", projectName="
         + this.getProjectName()
         + ", listQuantity="
         + this.getListQuantity()
         + ", totalProduction="
         + this.getTotalProduction()
         + ", steelPicking="
         + this.getSteelPicking()
         + ", sectionPicking="
         + this.getSectionPicking()
         + ", steelPlateReturn="
         + this.getSteelPlateReturn()
         + ", sectionReturn="
         + this.getSectionReturn()
         + ", totalReceive="
         + this.getTotalReceive()
         + ", totalWastage="
         + this.getTotalWastage()
         + ", wastageRate="
         + this.getWastageRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WastageDO)) {
         return false;
      }

      WastageDO other = (WastageDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$createTimeStr = this.getCreateTimeStr();
               Object other$createTimeStr = other.getCreateTimeStr();
               if (this$createTimeStr == null ? other$createTimeStr == null : this$createTimeStr.equals(other$createTimeStr)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$listQuantity = this.getListQuantity();
                     Object other$listQuantity = other.getListQuantity();
                     if (this$listQuantity == null ? other$listQuantity == null : this$listQuantity.equals(other$listQuantity)) {
                        Object this$totalProduction = this.getTotalProduction();
                        Object other$totalProduction = other.getTotalProduction();
                        if (this$totalProduction == null ? other$totalProduction == null : this$totalProduction.equals(other$totalProduction)) {
                           Object this$steelPicking = this.getSteelPicking();
                           Object other$steelPicking = other.getSteelPicking();
                           if (this$steelPicking == null ? other$steelPicking == null : this$steelPicking.equals(other$steelPicking)) {
                              Object this$sectionPicking = this.getSectionPicking();
                              Object other$sectionPicking = other.getSectionPicking();
                              if (this$sectionPicking == null ? other$sectionPicking == null : this$sectionPicking.equals(other$sectionPicking)) {
                                 Object this$steelPlateReturn = this.getSteelPlateReturn();
                                 Object other$steelPlateReturn = other.getSteelPlateReturn();
                                 if (this$steelPlateReturn == null ? other$steelPlateReturn == null : this$steelPlateReturn.equals(other$steelPlateReturn)) {
                                    Object this$sectionReturn = this.getSectionReturn();
                                    Object other$sectionReturn = other.getSectionReturn();
                                    if (this$sectionReturn == null ? other$sectionReturn == null : this$sectionReturn.equals(other$sectionReturn)) {
                                       Object this$totalReceive = this.getTotalReceive();
                                       Object other$totalReceive = other.getTotalReceive();
                                       if (this$totalReceive == null ? other$totalReceive == null : this$totalReceive.equals(other$totalReceive)) {
                                          Object this$totalWastage = this.getTotalWastage();
                                          Object other$totalWastage = other.getTotalWastage();
                                          if (this$totalWastage == null ? other$totalWastage == null : this$totalWastage.equals(other$totalWastage)) {
                                             Object this$wastageRate = this.getWastageRate();
                                             Object other$wastageRate = other.getWastageRate();
                                             return this$wastageRate == null ? other$wastageRate == null : this$wastageRate.equals(other$wastageRate);
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
      return other instanceof WastageDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $createTimeStr = this.getCreateTimeStr();
      result = result * 59 + ($createTimeStr == null ? 43 : $createTimeStr.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $listQuantity = this.getListQuantity();
      result = result * 59 + ($listQuantity == null ? 43 : $listQuantity.hashCode());
      Object $totalProduction = this.getTotalProduction();
      result = result * 59 + ($totalProduction == null ? 43 : $totalProduction.hashCode());
      Object $steelPicking = this.getSteelPicking();
      result = result * 59 + ($steelPicking == null ? 43 : $steelPicking.hashCode());
      Object $sectionPicking = this.getSectionPicking();
      result = result * 59 + ($sectionPicking == null ? 43 : $sectionPicking.hashCode());
      Object $steelPlateReturn = this.getSteelPlateReturn();
      result = result * 59 + ($steelPlateReturn == null ? 43 : $steelPlateReturn.hashCode());
      Object $sectionReturn = this.getSectionReturn();
      result = result * 59 + ($sectionReturn == null ? 43 : $sectionReturn.hashCode());
      Object $totalReceive = this.getTotalReceive();
      result = result * 59 + ($totalReceive == null ? 43 : $totalReceive.hashCode());
      Object $totalWastage = this.getTotalWastage();
      result = result * 59 + ($totalWastage == null ? 43 : $totalWastage.hashCode());
      Object $wastageRate = this.getWastageRate();
      return result * 59 + ($wastageRate == null ? 43 : $wastageRate.hashCode());
   }

   public static class WastageDOBuilder {
      private Long projectId;
      private LocalDateTime createTime;
      private String createTimeStr;
      private Integer status;
      private String projectName;
      private BigDecimal listQuantity;
      private BigDecimal totalProduction;
      private BigDecimal steelPicking;
      private BigDecimal sectionPicking;
      private BigDecimal steelPlateReturn;
      private BigDecimal sectionReturn;
      private BigDecimal totalReceive;
      private BigDecimal totalWastage;
      private BigDecimal wastageRate;

      WastageDOBuilder() {
      }

      @JsonProperty("projectId")
      public WastageDO.WastageDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("createTime")
      @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
      public WastageDO.WastageDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("createTimeStr")
      public WastageDO.WastageDOBuilder createTimeStr(final String createTimeStr) {
         this.createTimeStr = createTimeStr;
         return this;
      }

      @JsonProperty("status")
      public WastageDO.WastageDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("projectName")
      public WastageDO.WastageDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("listQuantity")
      public WastageDO.WastageDOBuilder listQuantity(final BigDecimal listQuantity) {
         this.listQuantity = listQuantity;
         return this;
      }

      @JsonProperty("totalProduction")
      public WastageDO.WastageDOBuilder totalProduction(final BigDecimal totalProduction) {
         this.totalProduction = totalProduction;
         return this;
      }

      @JsonProperty("steelPicking")
      public WastageDO.WastageDOBuilder steelPicking(final BigDecimal steelPicking) {
         this.steelPicking = steelPicking;
         return this;
      }

      @JsonProperty("sectionPicking")
      public WastageDO.WastageDOBuilder sectionPicking(final BigDecimal sectionPicking) {
         this.sectionPicking = sectionPicking;
         return this;
      }

      @JsonProperty("steelPlateReturn")
      public WastageDO.WastageDOBuilder steelPlateReturn(final BigDecimal steelPlateReturn) {
         this.steelPlateReturn = steelPlateReturn;
         return this;
      }

      @JsonProperty("sectionReturn")
      public WastageDO.WastageDOBuilder sectionReturn(final BigDecimal sectionReturn) {
         this.sectionReturn = sectionReturn;
         return this;
      }

      @JsonProperty("totalReceive")
      public WastageDO.WastageDOBuilder totalReceive(final BigDecimal totalReceive) {
         this.totalReceive = totalReceive;
         return this;
      }

      @JsonProperty("totalWastage")
      public WastageDO.WastageDOBuilder totalWastage(final BigDecimal totalWastage) {
         this.totalWastage = totalWastage;
         return this;
      }

      @JsonProperty("wastageRate")
      public WastageDO.WastageDOBuilder wastageRate(final BigDecimal wastageRate) {
         this.wastageRate = wastageRate;
         return this;
      }

      public WastageDO build() {
         return new WastageDO(
            this.projectId,
            this.createTime,
            this.createTimeStr,
            this.status,
            this.projectName,
            this.listQuantity,
            this.totalProduction,
            this.steelPicking,
            this.sectionPicking,
            this.steelPlateReturn,
            this.sectionReturn,
            this.totalReceive,
            this.totalWastage,
            this.wastageRate
         );
      }

      @Override
      public String toString() {
         return "WastageDO.WastageDOBuilder(projectId="
            + this.projectId
            + ", createTime="
            + this.createTime
            + ", createTimeStr="
            + this.createTimeStr
            + ", status="
            + this.status
            + ", projectName="
            + this.projectName
            + ", listQuantity="
            + this.listQuantity
            + ", totalProduction="
            + this.totalProduction
            + ", steelPicking="
            + this.steelPicking
            + ", sectionPicking="
            + this.sectionPicking
            + ", steelPlateReturn="
            + this.steelPlateReturn
            + ", sectionReturn="
            + this.sectionReturn
            + ", totalReceive="
            + this.totalReceive
            + ", totalWastage="
            + this.totalWastage
            + ", wastageRate="
            + this.wastageRate
            + ")";
      }
   }
}
