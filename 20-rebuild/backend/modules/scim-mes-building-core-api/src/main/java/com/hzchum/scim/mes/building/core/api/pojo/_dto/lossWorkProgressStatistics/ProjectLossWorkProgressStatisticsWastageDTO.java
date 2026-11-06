package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class ProjectLossWorkProgressStatisticsWastageDTO {
   @ApiModelProperty(name = "projectId", notes = "项目Id")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", notes = "车间Id")
   private Long workShopId;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "totalArtifactQuantity", notes = "构件清单总数量")
   private Integer totalArtifactQuantity;
   @ApiModelProperty(name = "totalArtifactNetWeight", notes = "构件清单总净重(吨)")
   private BigDecimal totalArtifactNetWeight;
   @ApiModelProperty(name = "totalArtifactGrossWeight", notes = "构件清单总毛重(吨)")
   private BigDecimal totalArtifactGrossWeight;
   @ApiModelProperty(name = "totalArtifactTaskQuantity", notes = "构件排产总数量")
   private Integer totalArtifactTaskQuantity;
   @ApiModelProperty(name = "totalArtifactTaskNetWeight", notes = "构件排产总净重(吨)")
   private BigDecimal totalArtifactTaskNetWeight;
   @ApiModelProperty(name = "totalArtifactTaskGrossWeight", notes = "构件排产总毛重(吨)")
   private BigDecimal totalArtifactTaskGrossWeight;
   @ApiModelProperty(name = "totalArtifactCompleteQuantity", notes = "构件制成品总数量")
   private Integer totalArtifactCompleteQuantity;
   @ApiModelProperty(name = "totalArtifactCompleteNetWeight", notes = "构件制成品总净重(吨)")
   private BigDecimal totalArtifactCompleteNetWeight;
   @ApiModelProperty(name = "totalArtifactCompleteGrossWeight", notes = "构件制成品总毛重(吨)")
   private BigDecimal totalArtifactCompleteGrossWeight;
   @ApiModelProperty(name = "artifactProcessWorkProgressStatisticsDetailList", notes = "构件任务工序生产详情")
   private ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO;
   @ApiModelProperty(name = "assembleProcessProgressStatisticsDetailList", notes = "部件任务工序生产详情")
   private ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO;
   @ApiModelProperty(name = "partProcessProgressStatisticsDetailList", notes = "零件任务工序生产详情")
   private ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO;

   public static ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder builder() {
      return new ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getTotalArtifactQuantity() {
      return this.totalArtifactQuantity;
   }

   public BigDecimal getTotalArtifactNetWeight() {
      return this.totalArtifactNetWeight;
   }

   public BigDecimal getTotalArtifactGrossWeight() {
      return this.totalArtifactGrossWeight;
   }

   public Integer getTotalArtifactTaskQuantity() {
      return this.totalArtifactTaskQuantity;
   }

   public BigDecimal getTotalArtifactTaskNetWeight() {
      return this.totalArtifactTaskNetWeight;
   }

   public BigDecimal getTotalArtifactTaskGrossWeight() {
      return this.totalArtifactTaskGrossWeight;
   }

   public Integer getTotalArtifactCompleteQuantity() {
      return this.totalArtifactCompleteQuantity;
   }

   public BigDecimal getTotalArtifactCompleteNetWeight() {
      return this.totalArtifactCompleteNetWeight;
   }

   public BigDecimal getTotalArtifactCompleteGrossWeight() {
      return this.totalArtifactCompleteGrossWeight;
   }

   public ProductProcessWorkProgressStatisticsDTO getArtifactProgressStatisticsDTO() {
      return this.artifactProgressStatisticsDTO;
   }

   public ProductProcessWorkProgressStatisticsDTO getAssembleProgressStatisticsDTO() {
      return this.assembleProgressStatisticsDTO;
   }

   public ProductProcessWorkProgressStatisticsDTO getPartProgressStatisticsDTO() {
      return this.partProgressStatisticsDTO;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setTotalArtifactQuantity(final Integer totalArtifactQuantity) {
      this.totalArtifactQuantity = totalArtifactQuantity;
   }

   public void setTotalArtifactNetWeight(final BigDecimal totalArtifactNetWeight) {
      this.totalArtifactNetWeight = totalArtifactNetWeight;
   }

   public void setTotalArtifactGrossWeight(final BigDecimal totalArtifactGrossWeight) {
      this.totalArtifactGrossWeight = totalArtifactGrossWeight;
   }

   public void setTotalArtifactTaskQuantity(final Integer totalArtifactTaskQuantity) {
      this.totalArtifactTaskQuantity = totalArtifactTaskQuantity;
   }

   public void setTotalArtifactTaskNetWeight(final BigDecimal totalArtifactTaskNetWeight) {
      this.totalArtifactTaskNetWeight = totalArtifactTaskNetWeight;
   }

   public void setTotalArtifactTaskGrossWeight(final BigDecimal totalArtifactTaskGrossWeight) {
      this.totalArtifactTaskGrossWeight = totalArtifactTaskGrossWeight;
   }

   public void setTotalArtifactCompleteQuantity(final Integer totalArtifactCompleteQuantity) {
      this.totalArtifactCompleteQuantity = totalArtifactCompleteQuantity;
   }

   public void setTotalArtifactCompleteNetWeight(final BigDecimal totalArtifactCompleteNetWeight) {
      this.totalArtifactCompleteNetWeight = totalArtifactCompleteNetWeight;
   }

   public void setTotalArtifactCompleteGrossWeight(final BigDecimal totalArtifactCompleteGrossWeight) {
      this.totalArtifactCompleteGrossWeight = totalArtifactCompleteGrossWeight;
   }

   public void setArtifactProgressStatisticsDTO(final ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO) {
      this.artifactProgressStatisticsDTO = artifactProgressStatisticsDTO;
   }

   public void setAssembleProgressStatisticsDTO(final ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO) {
      this.assembleProgressStatisticsDTO = assembleProgressStatisticsDTO;
   }

   public void setPartProgressStatisticsDTO(final ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO) {
      this.partProgressStatisticsDTO = partProgressStatisticsDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLossWorkProgressStatisticsWastageDTO)) {
         return false;
      }

      ProjectLossWorkProgressStatisticsWastageDTO other = (ProjectLossWorkProgressStatisticsWastageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$totalArtifactQuantity = this.getTotalArtifactQuantity();
            Object other$totalArtifactQuantity = other.getTotalArtifactQuantity();
            if (this$totalArtifactQuantity == null ? other$totalArtifactQuantity == null : this$totalArtifactQuantity.equals(other$totalArtifactQuantity)) {
               Object this$totalArtifactTaskQuantity = this.getTotalArtifactTaskQuantity();
               Object other$totalArtifactTaskQuantity = other.getTotalArtifactTaskQuantity();
               if (this$totalArtifactTaskQuantity == null
                  ? other$totalArtifactTaskQuantity == null
                  : this$totalArtifactTaskQuantity.equals(other$totalArtifactTaskQuantity)) {
                  Object this$totalArtifactCompleteQuantity = this.getTotalArtifactCompleteQuantity();
                  Object other$totalArtifactCompleteQuantity = other.getTotalArtifactCompleteQuantity();
                  if (this$totalArtifactCompleteQuantity == null
                     ? other$totalArtifactCompleteQuantity == null
                     : this$totalArtifactCompleteQuantity.equals(other$totalArtifactCompleteQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$totalArtifactNetWeight = this.getTotalArtifactNetWeight();
                              Object other$totalArtifactNetWeight = other.getTotalArtifactNetWeight();
                              if (this$totalArtifactNetWeight == null
                                 ? other$totalArtifactNetWeight == null
                                 : this$totalArtifactNetWeight.equals(other$totalArtifactNetWeight)) {
                                 Object this$totalArtifactGrossWeight = this.getTotalArtifactGrossWeight();
                                 Object other$totalArtifactGrossWeight = other.getTotalArtifactGrossWeight();
                                 if (this$totalArtifactGrossWeight == null
                                    ? other$totalArtifactGrossWeight == null
                                    : this$totalArtifactGrossWeight.equals(other$totalArtifactGrossWeight)) {
                                    Object this$totalArtifactTaskNetWeight = this.getTotalArtifactTaskNetWeight();
                                    Object other$totalArtifactTaskNetWeight = other.getTotalArtifactTaskNetWeight();
                                    if (this$totalArtifactTaskNetWeight == null
                                       ? other$totalArtifactTaskNetWeight == null
                                       : this$totalArtifactTaskNetWeight.equals(other$totalArtifactTaskNetWeight)) {
                                       Object this$totalArtifactTaskGrossWeight = this.getTotalArtifactTaskGrossWeight();
                                       Object other$totalArtifactTaskGrossWeight = other.getTotalArtifactTaskGrossWeight();
                                       if (this$totalArtifactTaskGrossWeight == null
                                          ? other$totalArtifactTaskGrossWeight == null
                                          : this$totalArtifactTaskGrossWeight.equals(other$totalArtifactTaskGrossWeight)) {
                                          Object this$totalArtifactCompleteNetWeight = this.getTotalArtifactCompleteNetWeight();
                                          Object other$totalArtifactCompleteNetWeight = other.getTotalArtifactCompleteNetWeight();
                                          if (this$totalArtifactCompleteNetWeight == null
                                             ? other$totalArtifactCompleteNetWeight == null
                                             : this$totalArtifactCompleteNetWeight.equals(other$totalArtifactCompleteNetWeight)) {
                                             Object this$totalArtifactCompleteGrossWeight = this.getTotalArtifactCompleteGrossWeight();
                                             Object other$totalArtifactCompleteGrossWeight = other.getTotalArtifactCompleteGrossWeight();
                                             if (this$totalArtifactCompleteGrossWeight == null
                                                ? other$totalArtifactCompleteGrossWeight == null
                                                : this$totalArtifactCompleteGrossWeight.equals(other$totalArtifactCompleteGrossWeight)) {
                                                Object this$artifactProgressStatisticsDTO = this.getArtifactProgressStatisticsDTO();
                                                Object other$artifactProgressStatisticsDTO = other.getArtifactProgressStatisticsDTO();
                                                if (this$artifactProgressStatisticsDTO == null
                                                   ? other$artifactProgressStatisticsDTO == null
                                                   : this$artifactProgressStatisticsDTO.equals(other$artifactProgressStatisticsDTO)) {
                                                   Object this$assembleProgressStatisticsDTO = this.getAssembleProgressStatisticsDTO();
                                                   Object other$assembleProgressStatisticsDTO = other.getAssembleProgressStatisticsDTO();
                                                   if (this$assembleProgressStatisticsDTO == null
                                                      ? other$assembleProgressStatisticsDTO == null
                                                      : this$assembleProgressStatisticsDTO.equals(other$assembleProgressStatisticsDTO)) {
                                                      Object this$partProgressStatisticsDTO = this.getPartProgressStatisticsDTO();
                                                      Object other$partProgressStatisticsDTO = other.getPartProgressStatisticsDTO();
                                                      return this$partProgressStatisticsDTO == null
                                                         ? other$partProgressStatisticsDTO == null
                                                         : this$partProgressStatisticsDTO.equals(other$partProgressStatisticsDTO);
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
      return other instanceof ProjectLossWorkProgressStatisticsWastageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $totalArtifactQuantity = this.getTotalArtifactQuantity();
      result = result * 59 + ($totalArtifactQuantity == null ? 43 : $totalArtifactQuantity.hashCode());
      Object $totalArtifactTaskQuantity = this.getTotalArtifactTaskQuantity();
      result = result * 59 + ($totalArtifactTaskQuantity == null ? 43 : $totalArtifactTaskQuantity.hashCode());
      Object $totalArtifactCompleteQuantity = this.getTotalArtifactCompleteQuantity();
      result = result * 59 + ($totalArtifactCompleteQuantity == null ? 43 : $totalArtifactCompleteQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $totalArtifactNetWeight = this.getTotalArtifactNetWeight();
      result = result * 59 + ($totalArtifactNetWeight == null ? 43 : $totalArtifactNetWeight.hashCode());
      Object $totalArtifactGrossWeight = this.getTotalArtifactGrossWeight();
      result = result * 59 + ($totalArtifactGrossWeight == null ? 43 : $totalArtifactGrossWeight.hashCode());
      Object $totalArtifactTaskNetWeight = this.getTotalArtifactTaskNetWeight();
      result = result * 59 + ($totalArtifactTaskNetWeight == null ? 43 : $totalArtifactTaskNetWeight.hashCode());
      Object $totalArtifactTaskGrossWeight = this.getTotalArtifactTaskGrossWeight();
      result = result * 59 + ($totalArtifactTaskGrossWeight == null ? 43 : $totalArtifactTaskGrossWeight.hashCode());
      Object $totalArtifactCompleteNetWeight = this.getTotalArtifactCompleteNetWeight();
      result = result * 59 + ($totalArtifactCompleteNetWeight == null ? 43 : $totalArtifactCompleteNetWeight.hashCode());
      Object $totalArtifactCompleteGrossWeight = this.getTotalArtifactCompleteGrossWeight();
      result = result * 59 + ($totalArtifactCompleteGrossWeight == null ? 43 : $totalArtifactCompleteGrossWeight.hashCode());
      Object $artifactProgressStatisticsDTO = this.getArtifactProgressStatisticsDTO();
      result = result * 59 + ($artifactProgressStatisticsDTO == null ? 43 : $artifactProgressStatisticsDTO.hashCode());
      Object $assembleProgressStatisticsDTO = this.getAssembleProgressStatisticsDTO();
      result = result * 59 + ($assembleProgressStatisticsDTO == null ? 43 : $assembleProgressStatisticsDTO.hashCode());
      Object $partProgressStatisticsDTO = this.getPartProgressStatisticsDTO();
      return result * 59 + ($partProgressStatisticsDTO == null ? 43 : $partProgressStatisticsDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLossWorkProgressStatisticsWastageDTO(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", totalArtifactQuantity="
         + this.getTotalArtifactQuantity()
         + ", totalArtifactNetWeight="
         + this.getTotalArtifactNetWeight()
         + ", totalArtifactGrossWeight="
         + this.getTotalArtifactGrossWeight()
         + ", totalArtifactTaskQuantity="
         + this.getTotalArtifactTaskQuantity()
         + ", totalArtifactTaskNetWeight="
         + this.getTotalArtifactTaskNetWeight()
         + ", totalArtifactTaskGrossWeight="
         + this.getTotalArtifactTaskGrossWeight()
         + ", totalArtifactCompleteQuantity="
         + this.getTotalArtifactCompleteQuantity()
         + ", totalArtifactCompleteNetWeight="
         + this.getTotalArtifactCompleteNetWeight()
         + ", totalArtifactCompleteGrossWeight="
         + this.getTotalArtifactCompleteGrossWeight()
         + ", artifactProgressStatisticsDTO="
         + this.getArtifactProgressStatisticsDTO()
         + ", assembleProgressStatisticsDTO="
         + this.getAssembleProgressStatisticsDTO()
         + ", partProgressStatisticsDTO="
         + this.getPartProgressStatisticsDTO()
         + ")";
   }

   public ProjectLossWorkProgressStatisticsWastageDTO(
      final Long projectId,
      final Long workShopId,
      final String name,
      final String serialNumber,
      final String shortName,
      final Integer totalArtifactQuantity,
      final BigDecimal totalArtifactNetWeight,
      final BigDecimal totalArtifactGrossWeight,
      final Integer totalArtifactTaskQuantity,
      final BigDecimal totalArtifactTaskNetWeight,
      final BigDecimal totalArtifactTaskGrossWeight,
      final Integer totalArtifactCompleteQuantity,
      final BigDecimal totalArtifactCompleteNetWeight,
      final BigDecimal totalArtifactCompleteGrossWeight,
      final ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO,
      final ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO,
      final ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.shortName = shortName;
      this.totalArtifactQuantity = totalArtifactQuantity;
      this.totalArtifactNetWeight = totalArtifactNetWeight;
      this.totalArtifactGrossWeight = totalArtifactGrossWeight;
      this.totalArtifactTaskQuantity = totalArtifactTaskQuantity;
      this.totalArtifactTaskNetWeight = totalArtifactTaskNetWeight;
      this.totalArtifactTaskGrossWeight = totalArtifactTaskGrossWeight;
      this.totalArtifactCompleteQuantity = totalArtifactCompleteQuantity;
      this.totalArtifactCompleteNetWeight = totalArtifactCompleteNetWeight;
      this.totalArtifactCompleteGrossWeight = totalArtifactCompleteGrossWeight;
      this.artifactProgressStatisticsDTO = artifactProgressStatisticsDTO;
      this.assembleProgressStatisticsDTO = assembleProgressStatisticsDTO;
      this.partProgressStatisticsDTO = partProgressStatisticsDTO;
   }

   public ProjectLossWorkProgressStatisticsWastageDTO() {
   }

   public static class ProjectLossWorkProgressStatisticsWastageDTOBuilder {
      private Long projectId;
      private Long workShopId;
      private String name;
      private String serialNumber;
      private String shortName;
      private Integer totalArtifactQuantity;
      private BigDecimal totalArtifactNetWeight;
      private BigDecimal totalArtifactGrossWeight;
      private Integer totalArtifactTaskQuantity;
      private BigDecimal totalArtifactTaskNetWeight;
      private BigDecimal totalArtifactTaskGrossWeight;
      private Integer totalArtifactCompleteQuantity;
      private BigDecimal totalArtifactCompleteNetWeight;
      private BigDecimal totalArtifactCompleteGrossWeight;
      private ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO;
      private ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO;
      private ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO;

      ProjectLossWorkProgressStatisticsWastageDTOBuilder() {
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactQuantity(
         final Integer totalArtifactQuantity
      ) {
         this.totalArtifactQuantity = totalArtifactQuantity;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactNetWeight(
         final BigDecimal totalArtifactNetWeight
      ) {
         this.totalArtifactNetWeight = totalArtifactNetWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactGrossWeight(
         final BigDecimal totalArtifactGrossWeight
      ) {
         this.totalArtifactGrossWeight = totalArtifactGrossWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactTaskQuantity(
         final Integer totalArtifactTaskQuantity
      ) {
         this.totalArtifactTaskQuantity = totalArtifactTaskQuantity;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactTaskNetWeight(
         final BigDecimal totalArtifactTaskNetWeight
      ) {
         this.totalArtifactTaskNetWeight = totalArtifactTaskNetWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactTaskGrossWeight(
         final BigDecimal totalArtifactTaskGrossWeight
      ) {
         this.totalArtifactTaskGrossWeight = totalArtifactTaskGrossWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactCompleteQuantity(
         final Integer totalArtifactCompleteQuantity
      ) {
         this.totalArtifactCompleteQuantity = totalArtifactCompleteQuantity;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactCompleteNetWeight(
         final BigDecimal totalArtifactCompleteNetWeight
      ) {
         this.totalArtifactCompleteNetWeight = totalArtifactCompleteNetWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder totalArtifactCompleteGrossWeight(
         final BigDecimal totalArtifactCompleteGrossWeight
      ) {
         this.totalArtifactCompleteGrossWeight = totalArtifactCompleteGrossWeight;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder artifactProgressStatisticsDTO(
         final ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO
      ) {
         this.artifactProgressStatisticsDTO = artifactProgressStatisticsDTO;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder assembleProgressStatisticsDTO(
         final ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO
      ) {
         this.assembleProgressStatisticsDTO = assembleProgressStatisticsDTO;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder partProgressStatisticsDTO(
         final ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO
      ) {
         this.partProgressStatisticsDTO = partProgressStatisticsDTO;
         return this;
      }

      public ProjectLossWorkProgressStatisticsWastageDTO build() {
         return new ProjectLossWorkProgressStatisticsWastageDTO(
            this.projectId,
            this.workShopId,
            this.name,
            this.serialNumber,
            this.shortName,
            this.totalArtifactQuantity,
            this.totalArtifactNetWeight,
            this.totalArtifactGrossWeight,
            this.totalArtifactTaskQuantity,
            this.totalArtifactTaskNetWeight,
            this.totalArtifactTaskGrossWeight,
            this.totalArtifactCompleteQuantity,
            this.totalArtifactCompleteNetWeight,
            this.totalArtifactCompleteGrossWeight,
            this.artifactProgressStatisticsDTO,
            this.assembleProgressStatisticsDTO,
            this.partProgressStatisticsDTO
         );
      }

      @Override
      public String toString() {
         return "ProjectLossWorkProgressStatisticsWastageDTO.ProjectLossWorkProgressStatisticsWastageDTOBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", shortName="
            + this.shortName
            + ", totalArtifactQuantity="
            + this.totalArtifactQuantity
            + ", totalArtifactNetWeight="
            + this.totalArtifactNetWeight
            + ", totalArtifactGrossWeight="
            + this.totalArtifactGrossWeight
            + ", totalArtifactTaskQuantity="
            + this.totalArtifactTaskQuantity
            + ", totalArtifactTaskNetWeight="
            + this.totalArtifactTaskNetWeight
            + ", totalArtifactTaskGrossWeight="
            + this.totalArtifactTaskGrossWeight
            + ", totalArtifactCompleteQuantity="
            + this.totalArtifactCompleteQuantity
            + ", totalArtifactCompleteNetWeight="
            + this.totalArtifactCompleteNetWeight
            + ", totalArtifactCompleteGrossWeight="
            + this.totalArtifactCompleteGrossWeight
            + ", artifactProgressStatisticsDTO="
            + this.artifactProgressStatisticsDTO
            + ", assembleProgressStatisticsDTO="
            + this.assembleProgressStatisticsDTO
            + ", partProgressStatisticsDTO="
            + this.partProgressStatisticsDTO
            + ")";
      }
   }
}
