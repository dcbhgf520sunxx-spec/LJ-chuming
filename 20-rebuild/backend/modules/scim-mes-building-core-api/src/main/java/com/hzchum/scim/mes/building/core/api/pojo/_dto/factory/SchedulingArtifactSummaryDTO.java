package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "SchedulingArtifactSummaryDTO", description = "排产汇总信息")
public class SchedulingArtifactSummaryDTO {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目编号")
   @JsonProperty("projectSerialNumber")
   @JSONField(name = "projectSerialNumber")
   private String projectSerialNumber;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerId", notes = " monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", notes = " monomerName")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", notes = " 区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", notes = " 区域名称")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "date", notes = " 日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "taskQuantity", notes = " 任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "totalNetWeight", notes = " 总净重（吨）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "unScheTaskQuantity", notes = " 未排产任务数量")
   @JsonProperty("unScheTaskQuantity")
   @JSONField(name = "unScheTaskQuantity")
   private Integer unScheTaskQuantity;
   @ApiModelProperty(name = "unScheTotalNetWeight", notes = " 未排产总净重（吨）")
   @JsonProperty("unScheTotalNetWeight")
   @JSONField(name = "unScheTotalNetWeight")
   private BigDecimal unScheTotalNetWeight;
   @ApiModelProperty(name = "expectedWorkHours", notes = " 预计工时")
   @JsonProperty("expectedWorkHours")
   @JSONField(name = "expectedWorkHours")
   private Integer expectedWorkHours;
   @ApiModelProperty(name = "createUserName", notes = " 创建人名称")
   @JsonProperty("createUserName")
   @JSONField(name = "createUserName")
   private String createUserName;
   @ApiModelProperty(name = "createTime", notes = " 创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getUnScheTaskQuantity() {
      return this.unScheTaskQuantity;
   }

   public BigDecimal getUnScheTotalNetWeight() {
      return this.unScheTotalNetWeight;
   }

   public Integer getExpectedWorkHours() {
      return this.expectedWorkHours;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   @JsonProperty("projectId")
   public SchedulingArtifactSummaryDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectSerialNumber")
   public SchedulingArtifactSummaryDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("projectName")
   public SchedulingArtifactSummaryDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerId")
   public SchedulingArtifactSummaryDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("monomerName")
   public SchedulingArtifactSummaryDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaId")
   public SchedulingArtifactSummaryDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public SchedulingArtifactSummaryDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("date")
   public SchedulingArtifactSummaryDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("taskQuantity")
   public SchedulingArtifactSummaryDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public SchedulingArtifactSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("unScheTaskQuantity")
   public SchedulingArtifactSummaryDTO setUnScheTaskQuantity(final Integer unScheTaskQuantity) {
      this.unScheTaskQuantity = unScheTaskQuantity;
      return this;
   }

   @JsonProperty("unScheTotalNetWeight")
   public SchedulingArtifactSummaryDTO setUnScheTotalNetWeight(final BigDecimal unScheTotalNetWeight) {
      this.unScheTotalNetWeight = unScheTotalNetWeight;
      return this;
   }

   @JsonProperty("expectedWorkHours")
   public SchedulingArtifactSummaryDTO setExpectedWorkHours(final Integer expectedWorkHours) {
      this.expectedWorkHours = expectedWorkHours;
      return this;
   }

   @JsonProperty("createUserName")
   public SchedulingArtifactSummaryDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @JsonProperty("createTime")
   public SchedulingArtifactSummaryDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingArtifactSummaryDTO(projectId="
         + this.getProjectId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", date="
         + this.getDate()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", unScheTaskQuantity="
         + this.getUnScheTaskQuantity()
         + ", unScheTotalNetWeight="
         + this.getUnScheTotalNetWeight()
         + ", expectedWorkHours="
         + this.getExpectedWorkHours()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingArtifactSummaryDTO)) {
         return false;
      }

      SchedulingArtifactSummaryDTO other = (SchedulingArtifactSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$unScheTaskQuantity = this.getUnScheTaskQuantity();
                  Object other$unScheTaskQuantity = other.getUnScheTaskQuantity();
                  if (this$unScheTaskQuantity == null ? other$unScheTaskQuantity == null : this$unScheTaskQuantity.equals(other$unScheTaskQuantity)) {
                     Object this$expectedWorkHours = this.getExpectedWorkHours();
                     Object other$expectedWorkHours = other.getExpectedWorkHours();
                     if (this$expectedWorkHours == null ? other$expectedWorkHours == null : this$expectedWorkHours.equals(other$expectedWorkHours)) {
                        Object this$projectSerialNumber = this.getProjectSerialNumber();
                        Object other$projectSerialNumber = other.getProjectSerialNumber();
                        if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                              Object this$monomerName = this.getMonomerName();
                              Object other$monomerName = other.getMonomerName();
                              if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                 Object this$areaName = this.getAreaName();
                                 Object other$areaName = other.getAreaName();
                                 if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                    Object this$date = this.getDate();
                                    Object other$date = other.getDate();
                                    if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                       Object this$totalNetWeight = this.getTotalNetWeight();
                                       Object other$totalNetWeight = other.getTotalNetWeight();
                                       if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                          Object this$unScheTotalNetWeight = this.getUnScheTotalNetWeight();
                                          Object other$unScheTotalNetWeight = other.getUnScheTotalNetWeight();
                                          if (this$unScheTotalNetWeight == null
                                             ? other$unScheTotalNetWeight == null
                                             : this$unScheTotalNetWeight.equals(other$unScheTotalNetWeight)) {
                                             Object this$createUserName = this.getCreateUserName();
                                             Object other$createUserName = other.getCreateUserName();
                                             if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof SchedulingArtifactSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $unScheTaskQuantity = this.getUnScheTaskQuantity();
      result = result * 59 + ($unScheTaskQuantity == null ? 43 : $unScheTaskQuantity.hashCode());
      Object $expectedWorkHours = this.getExpectedWorkHours();
      result = result * 59 + ($expectedWorkHours == null ? 43 : $expectedWorkHours.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $unScheTotalNetWeight = this.getUnScheTotalNetWeight();
      result = result * 59 + ($unScheTotalNetWeight == null ? 43 : $unScheTotalNetWeight.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }
}
