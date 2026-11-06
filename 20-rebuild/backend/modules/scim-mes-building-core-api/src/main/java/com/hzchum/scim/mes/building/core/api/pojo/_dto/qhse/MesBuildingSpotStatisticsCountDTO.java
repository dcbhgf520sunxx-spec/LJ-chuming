package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingSpotStatisticsCountDTO对象", description = "抽检统计 ")
public class MesBuildingSpotStatisticsCountDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目Id", notes = "项目Id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "name", value = "项目/单体名称", notes = "项目/单体名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "spotCheckUserNames", value = "抽检人列表", notes = "抽检人列表")
   @JsonProperty("spotCheckUserNames")
   @JSONField(name = "spotCheckUserNames")
   private String spotCheckUserNames;
   @ApiModelProperty(name = "totalCompanyQuantity", value = "完成/任务总数", notes = "完成/任务总数")
   @JsonProperty("totalCompanyQuantity")
   @JSONField(name = "totalCompanyQuantity")
   private Integer totalCompanyQuantity;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数", notes = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数", notes = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   private Integer unQualifiedQuantity;
   @ApiModelProperty(name = "samplingPassRate", value = "抽检合格率", notes = "抽检合格率")
   @JsonProperty("samplingPassRate")
   @JSONField(name = "samplingPassRate")
   private BigDecimal samplingPassRate;
   @ApiModelProperty(name = "unSamplingPassRate", value = "抽检不合格率", notes = "抽检不合格率")
   @JsonProperty("unSamplingPassRate")
   @JSONField(name = "unSamplingPassRate")
   private BigDecimal unSamplingPassRate;
   @ApiModelProperty(name = "samplingRate", value = "抽检率", notes = "抽检率")
   @JsonProperty("samplingRate")
   @JSONField(name = "samplingRate")
   private BigDecimal samplingRate;
   @ApiModelProperty(name = "monomerSpotStatisticsCountDTOS", value = "抽检统计(单体)", notes = "抽检统计(单体)")
   @JsonProperty("monomerSpotStatisticsCountDTOS")
   @JSONField(name = "monomerSpotStatisticsCountDTOS")
   private List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS;

   public static MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder builder() {
      return new MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder();
   }

   public MesBuildingSpotStatisticsCountDTO() {
   }

   public MesBuildingSpotStatisticsCountDTO(
      final Long id,
      final Long projectId,
      final String name,
      final String spotCheckUserNames,
      final Integer totalCompanyQuantity,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity,
      final BigDecimal samplingPassRate,
      final BigDecimal unSamplingPassRate,
      final BigDecimal samplingRate,
      final List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS
   ) {
      this.id = id;
      this.projectId = projectId;
      this.name = name;
      this.spotCheckUserNames = spotCheckUserNames;
      this.totalCompanyQuantity = totalCompanyQuantity;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
      this.samplingPassRate = samplingPassRate;
      this.unSamplingPassRate = unSamplingPassRate;
      this.samplingRate = samplingRate;
      this.monomerSpotStatisticsCountDTOS = monomerSpotStatisticsCountDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public String getSpotCheckUserNames() {
      return this.spotCheckUserNames;
   }

   public Integer getTotalCompanyQuantity() {
      return this.totalCompanyQuantity;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public BigDecimal getSamplingPassRate() {
      return this.samplingPassRate;
   }

   public BigDecimal getUnSamplingPassRate() {
      return this.unSamplingPassRate;
   }

   public BigDecimal getSamplingRate() {
      return this.samplingRate;
   }

   public List<MesBuildingSpotStatisticsCountDTO> getMonomerSpotStatisticsCountDTOS() {
      return this.monomerSpotStatisticsCountDTOS;
   }

   @JsonProperty("id")
   public MesBuildingSpotStatisticsCountDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingSpotStatisticsCountDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSpotStatisticsCountDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("spotCheckUserNames")
   public MesBuildingSpotStatisticsCountDTO setSpotCheckUserNames(final String spotCheckUserNames) {
      this.spotCheckUserNames = spotCheckUserNames;
      return this;
   }

   @JsonProperty("totalCompanyQuantity")
   public MesBuildingSpotStatisticsCountDTO setTotalCompanyQuantity(final Integer totalCompanyQuantity) {
      this.totalCompanyQuantity = totalCompanyQuantity;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public MesBuildingSpotStatisticsCountDTO setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public MesBuildingSpotStatisticsCountDTO setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @JsonProperty("samplingPassRate")
   public MesBuildingSpotStatisticsCountDTO setSamplingPassRate(final BigDecimal samplingPassRate) {
      this.samplingPassRate = samplingPassRate;
      return this;
   }

   @JsonProperty("unSamplingPassRate")
   public MesBuildingSpotStatisticsCountDTO setUnSamplingPassRate(final BigDecimal unSamplingPassRate) {
      this.unSamplingPassRate = unSamplingPassRate;
      return this;
   }

   @JsonProperty("samplingRate")
   public MesBuildingSpotStatisticsCountDTO setSamplingRate(final BigDecimal samplingRate) {
      this.samplingRate = samplingRate;
      return this;
   }

   @JsonProperty("monomerSpotStatisticsCountDTOS")
   public MesBuildingSpotStatisticsCountDTO setMonomerSpotStatisticsCountDTOS(final List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS) {
      this.monomerSpotStatisticsCountDTOS = monomerSpotStatisticsCountDTOS;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpotStatisticsCountDTO)) {
         return false;
      }

      MesBuildingSpotStatisticsCountDTO other = (MesBuildingSpotStatisticsCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$totalCompanyQuantity = this.getTotalCompanyQuantity();
            Object other$totalCompanyQuantity = other.getTotalCompanyQuantity();
            if (this$totalCompanyQuantity == null ? other$totalCompanyQuantity == null : this$totalCompanyQuantity.equals(other$totalCompanyQuantity)) {
               Object this$qualifiedQuantity = this.getQualifiedQuantity();
               Object other$qualifiedQuantity = other.getQualifiedQuantity();
               if (this$qualifiedQuantity == null ? other$qualifiedQuantity == null : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
                  Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
                  Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
                  if (this$unQualifiedQuantity == null ? other$unQualifiedQuantity == null : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$spotCheckUserNames = this.getSpotCheckUserNames();
                        Object other$spotCheckUserNames = other.getSpotCheckUserNames();
                        if (this$spotCheckUserNames == null ? other$spotCheckUserNames == null : this$spotCheckUserNames.equals(other$spotCheckUserNames)) {
                           Object this$samplingPassRate = this.getSamplingPassRate();
                           Object other$samplingPassRate = other.getSamplingPassRate();
                           if (this$samplingPassRate == null ? other$samplingPassRate == null : this$samplingPassRate.equals(other$samplingPassRate)) {
                              Object this$unSamplingPassRate = this.getUnSamplingPassRate();
                              Object other$unSamplingPassRate = other.getUnSamplingPassRate();
                              if (this$unSamplingPassRate == null ? other$unSamplingPassRate == null : this$unSamplingPassRate.equals(other$unSamplingPassRate)
                                 )
                               {
                                 Object this$samplingRate = this.getSamplingRate();
                                 Object other$samplingRate = other.getSamplingRate();
                                 if (this$samplingRate == null ? other$samplingRate == null : this$samplingRate.equals(other$samplingRate)) {
                                    Object this$monomerSpotStatisticsCountDTOS = this.getMonomerSpotStatisticsCountDTOS();
                                    Object other$monomerSpotStatisticsCountDTOS = other.getMonomerSpotStatisticsCountDTOS();
                                    return this$monomerSpotStatisticsCountDTOS == null
                                       ? other$monomerSpotStatisticsCountDTOS == null
                                       : this$monomerSpotStatisticsCountDTOS.equals(other$monomerSpotStatisticsCountDTOS);
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
      return other instanceof MesBuildingSpotStatisticsCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $totalCompanyQuantity = this.getTotalCompanyQuantity();
      result = result * 59 + ($totalCompanyQuantity == null ? 43 : $totalCompanyQuantity.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $spotCheckUserNames = this.getSpotCheckUserNames();
      result = result * 59 + ($spotCheckUserNames == null ? 43 : $spotCheckUserNames.hashCode());
      Object $samplingPassRate = this.getSamplingPassRate();
      result = result * 59 + ($samplingPassRate == null ? 43 : $samplingPassRate.hashCode());
      Object $unSamplingPassRate = this.getUnSamplingPassRate();
      result = result * 59 + ($unSamplingPassRate == null ? 43 : $unSamplingPassRate.hashCode());
      Object $samplingRate = this.getSamplingRate();
      result = result * 59 + ($samplingRate == null ? 43 : $samplingRate.hashCode());
      Object $monomerSpotStatisticsCountDTOS = this.getMonomerSpotStatisticsCountDTOS();
      return result * 59 + ($monomerSpotStatisticsCountDTOS == null ? 43 : $monomerSpotStatisticsCountDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingSpotStatisticsCountDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", spotCheckUserNames="
         + this.getSpotCheckUserNames()
         + ", totalCompanyQuantity="
         + this.getTotalCompanyQuantity()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", samplingPassRate="
         + this.getSamplingPassRate()
         + ", unSamplingPassRate="
         + this.getUnSamplingPassRate()
         + ", samplingRate="
         + this.getSamplingRate()
         + ", monomerSpotStatisticsCountDTOS="
         + this.getMonomerSpotStatisticsCountDTOS()
         + ")";
   }

   public static class MesBuildingSpotStatisticsCountDTOBuilder {
      private Long id;
      private Long projectId;
      private String name;
      private String spotCheckUserNames;
      private Integer totalCompanyQuantity;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;
      private BigDecimal samplingPassRate;
      private BigDecimal unSamplingPassRate;
      private BigDecimal samplingRate;
      private List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS;

      MesBuildingSpotStatisticsCountDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("spotCheckUserNames")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder spotCheckUserNames(final String spotCheckUserNames) {
         this.spotCheckUserNames = spotCheckUserNames;
         return this;
      }

      @JsonProperty("totalCompanyQuantity")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder totalCompanyQuantity(final Integer totalCompanyQuantity) {
         this.totalCompanyQuantity = totalCompanyQuantity;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      @JsonProperty("samplingPassRate")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder samplingPassRate(final BigDecimal samplingPassRate) {
         this.samplingPassRate = samplingPassRate;
         return this;
      }

      @JsonProperty("unSamplingPassRate")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder unSamplingPassRate(final BigDecimal unSamplingPassRate) {
         this.unSamplingPassRate = unSamplingPassRate;
         return this;
      }

      @JsonProperty("samplingRate")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder samplingRate(final BigDecimal samplingRate) {
         this.samplingRate = samplingRate;
         return this;
      }

      @JsonProperty("monomerSpotStatisticsCountDTOS")
      public MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder monomerSpotStatisticsCountDTOS(
         final List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS
      ) {
         this.monomerSpotStatisticsCountDTOS = monomerSpotStatisticsCountDTOS;
         return this;
      }

      public MesBuildingSpotStatisticsCountDTO build() {
         return new MesBuildingSpotStatisticsCountDTO(
            this.id,
            this.projectId,
            this.name,
            this.spotCheckUserNames,
            this.totalCompanyQuantity,
            this.qualifiedQuantity,
            this.unQualifiedQuantity,
            this.samplingPassRate,
            this.unSamplingPassRate,
            this.samplingRate,
            this.monomerSpotStatisticsCountDTOS
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSpotStatisticsCountDTO.MesBuildingSpotStatisticsCountDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", name="
            + this.name
            + ", spotCheckUserNames="
            + this.spotCheckUserNames
            + ", totalCompanyQuantity="
            + this.totalCompanyQuantity
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ", samplingPassRate="
            + this.samplingPassRate
            + ", unSamplingPassRate="
            + this.unSamplingPassRate
            + ", samplingRate="
            + this.samplingRate
            + ", monomerSpotStatisticsCountDTOS="
            + this.monomerSpotStatisticsCountDTOS
            + ")";
      }
   }
}
