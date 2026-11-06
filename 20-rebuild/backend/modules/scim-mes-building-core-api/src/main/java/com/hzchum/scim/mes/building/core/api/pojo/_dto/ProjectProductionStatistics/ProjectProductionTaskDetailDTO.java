package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProjectProductionTaskDetailDTO {
   @ApiModelProperty(name = "workShopName", notes = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "productionLineName", notes = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "monomerName", notes = "单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", notes = "区域名称")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "name", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "产品长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "产品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalCompleteNetWeight", notes = "完成总净重")
   @JsonProperty("totalCompleteNetWeight")
   @JSONField(name = "totalCompleteNetWeight")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "totalCompleteGrossWeight", notes = "完成总毛重")
   @JsonProperty("totalCompleteGrossWeight")
   @JSONField(name = "totalCompleteGrossWeight")
   private BigDecimal totalCompleteGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "teamUserName", notes = "班组名称")
   @JsonProperty("teamUserName")
   @JSONField(name = "teamUserName")
   @JsonInclude(Include.NON_NULL)
   private String teamUserName;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   @JsonInclude(Include.NON_NULL)
   private String processName;
   @ApiModelProperty(name = "createTime", notes = "下发日期")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "taskCompanyStatusEnum", notes = "完成状态")
   @JsonProperty("taskCompanyStatusEnum")
   @JSONField(name = "taskCompanyStatusEnum")
   private Integer taskCompanyStatusEnum;

   public String getWorkShopName() {
      return this.workShopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getTaskCompanyStatusEnum() {
      return this.taskCompanyStatusEnum;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("productionLineName")
   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   @JsonProperty("monomerName")
   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @JsonProperty("areaName")
   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("grossWeight")
   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("totalGrossWeight")
   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @JsonProperty("totalCompleteNetWeight")
   public void setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
   }

   @JsonProperty("totalCompleteGrossWeight")
   public void setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("teamUserName")
   public void setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("createTime")
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("askCompleteTime")
   public void setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
   }

   @JsonProperty("taskCompanyStatusEnum")
   public void setTaskCompanyStatusEnum(final Integer taskCompanyStatusEnum) {
      this.taskCompanyStatusEnum = taskCompanyStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionTaskDetailDTO)) {
         return false;
      }

      ProjectProductionTaskDetailDTO other = (ProjectProductionTaskDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$taskCompanyStatusEnum = this.getTaskCompanyStatusEnum();
            Object other$taskCompanyStatusEnum = other.getTaskCompanyStatusEnum();
            if (this$taskCompanyStatusEnum == null ? other$taskCompanyStatusEnum == null : this$taskCompanyStatusEnum.equals(other$taskCompanyStatusEnum)) {
               Object this$workShopName = this.getWorkShopName();
               Object other$workShopName = other.getWorkShopName();
               if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                  Object this$productionLineName = this.getProductionLineName();
                  Object other$productionLineName = other.getProductionLineName();
                  if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$netWeight = this.getNetWeight();
                                          Object other$netWeight = other.getNetWeight();
                                          if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                             Object this$grossWeight = this.getGrossWeight();
                                             Object other$grossWeight = other.getGrossWeight();
                                             if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                if (this$totalNetWeight == null
                                                   ? other$totalNetWeight == null
                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                   Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                   Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                   if (this$totalGrossWeight == null
                                                      ? other$totalGrossWeight == null
                                                      : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                      Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                                                      Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                                                      if (this$totalCompleteNetWeight == null
                                                         ? other$totalCompleteNetWeight == null
                                                         : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                                                         Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                                                         Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                                                         if (this$totalCompleteGrossWeight == null
                                                            ? other$totalCompleteGrossWeight == null
                                                            : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight)) {
                                                            Object this$teamUserName = this.getTeamUserName();
                                                            Object other$teamUserName = other.getTeamUserName();
                                                            if (this$teamUserName == null
                                                               ? other$teamUserName == null
                                                               : this$teamUserName.equals(other$teamUserName)) {
                                                               Object this$processName = this.getProcessName();
                                                               Object other$processName = other.getProcessName();
                                                               if (this$processName == null
                                                                  ? other$processName == null
                                                                  : this$processName.equals(other$processName)) {
                                                                  Object this$createTime = this.getCreateTime();
                                                                  Object other$createTime = other.getCreateTime();
                                                                  if (this$createTime == null
                                                                     ? other$createTime == null
                                                                     : this$createTime.equals(other$createTime)) {
                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                     return this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof ProjectProductionTaskDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $taskCompanyStatusEnum = this.getTaskCompanyStatusEnum();
      result = result * 59 + ($taskCompanyStatusEnum == null ? 43 : $taskCompanyStatusEnum.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      result = result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionTaskDetailDTO(workShopName="
         + this.getWorkShopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", processName="
         + this.getProcessName()
         + ", createTime="
         + this.getCreateTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", taskCompanyStatusEnum="
         + this.getTaskCompanyStatusEnum()
         + ")";
   }
}
