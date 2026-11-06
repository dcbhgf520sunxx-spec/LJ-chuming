package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingAssistProductDTO", description = "工序协同-部件列表(构件展开)")
public class MesBuildingAssistProductFromArtifactDTO {
   @ApiModelProperty(name = "构件任务id", value = "构件任务id", notes = "构件任务id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "构件id", value = "构件id", notes = "构件id")
   @JsonProperty("artifactProductId")
   @JSONField(name = "artifactProductId")
   private Long artifactProductId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "totalTaskMete", value = "任务量", notes = "任务量")
   @JsonProperty("totalTaskMete")
   @JSONField(name = "totalTaskMete")
   private QuantityAndWeightDetailDO totalTaskMete;
   @ApiModelProperty(name = "totalCompleteMete", value = "完成量", notes = "完成量")
   @JsonProperty("totalCompleteMete")
   @JSONField(name = "totalCompleteMete")
   private QuantityAndWeightDetailDO totalCompleteMete;
   @ApiModelProperty(name = "totalCanAssistMete", value = "总可协同量", notes = "总可协同量")
   @JsonProperty("totalCanAssistMete")
   @JSONField(name = "totalCanAssistMete")
   @JsonInclude(Include.NON_NULL)
   private QuantityAndWeightDetailDO totalCanAssistMete;
   @ApiModelProperty(name = "totalAssistQuantity", value = "总协同数", notes = "总协同数")
   @JsonProperty("totalAssistQuantity")
   @JSONField(name = "totalAssistQuantity")
   private Integer totalAssistQuantity;
   @ApiModelProperty(name = "assistProductDTOList", notes = "部件可协同列表")
   @JsonProperty("assistProductDTOList")
   @JSONField(name = "assistProductDTOList")
   private List<MesBuildingAssistProductDTO> assistProductDTOList;

   public static MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder builder() {
      return new MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder();
   }

   public MesBuildingAssistProductFromArtifactDTO() {
   }

   public MesBuildingAssistProductFromArtifactDTO(
      final Long artifactTaskId,
      final Long artifactProductId,
      final Integer taskTypeEnum,
      final AreaDetailDO area,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final Integer totalAssistQuantity,
      final List<MesBuildingAssistProductDTO> assistProductDTOList
   ) {
      this.artifactTaskId = artifactTaskId;
      this.artifactProductId = artifactProductId;
      this.taskTypeEnum = taskTypeEnum;
      this.area = area;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.totalAssistQuantity = totalAssistQuantity;
      this.assistProductDTOList = assistProductDTOList;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getArtifactProductId() {
      return this.artifactProductId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public AreaDetailDO getArea() {
      return this.area;
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

   public QuantityAndWeightDetailDO getTotalTaskMete() {
      return this.totalTaskMete;
   }

   public QuantityAndWeightDetailDO getTotalCompleteMete() {
      return this.totalCompleteMete;
   }

   public QuantityAndWeightDetailDO getTotalCanAssistMete() {
      return this.totalCanAssistMete;
   }

   public Integer getTotalAssistQuantity() {
      return this.totalAssistQuantity;
   }

   public List<MesBuildingAssistProductDTO> getAssistProductDTOList() {
      return this.assistProductDTOList;
   }

   @JsonProperty("artifactTaskId")
   public MesBuildingAssistProductFromArtifactDTO setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @JsonProperty("artifactProductId")
   public MesBuildingAssistProductFromArtifactDTO setArtifactProductId(final Long artifactProductId) {
      this.artifactProductId = artifactProductId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingAssistProductFromArtifactDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingAssistProductFromArtifactDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssistProductFromArtifactDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingAssistProductFromArtifactDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingAssistProductFromArtifactDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesBuildingAssistProductFromArtifactDTO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesBuildingAssistProductFromArtifactDTO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesBuildingAssistProductFromArtifactDTO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("totalAssistQuantity")
   public MesBuildingAssistProductFromArtifactDTO setTotalAssistQuantity(final Integer totalAssistQuantity) {
      this.totalAssistQuantity = totalAssistQuantity;
      return this;
   }

   @JsonProperty("assistProductDTOList")
   public MesBuildingAssistProductFromArtifactDTO setAssistProductDTOList(final List<MesBuildingAssistProductDTO> assistProductDTOList) {
      this.assistProductDTOList = assistProductDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistProductFromArtifactDTO(artifactTaskId="
         + this.getArtifactTaskId()
         + ", artifactProductId="
         + this.getArtifactProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", totalTaskMete="
         + this.getTotalTaskMete()
         + ", totalCompleteMete="
         + this.getTotalCompleteMete()
         + ", totalCanAssistMete="
         + this.getTotalCanAssistMete()
         + ", totalAssistQuantity="
         + this.getTotalAssistQuantity()
         + ", assistProductDTOList="
         + this.getAssistProductDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistProductFromArtifactDTO)) {
         return false;
      }

      MesBuildingAssistProductFromArtifactDTO other = (MesBuildingAssistProductFromArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactTaskId = this.getArtifactTaskId();
      Object other$artifactTaskId = other.getArtifactTaskId();
      if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
         Object this$artifactProductId = this.getArtifactProductId();
         Object other$artifactProductId = other.getArtifactProductId();
         if (this$artifactProductId == null ? other$artifactProductId == null : this$artifactProductId.equals(other$artifactProductId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$totalAssistQuantity = this.getTotalAssistQuantity();
               Object other$totalAssistQuantity = other.getTotalAssistQuantity();
               if (this$totalAssistQuantity == null ? other$totalAssistQuantity == null : this$totalAssistQuantity.equals(other$totalAssistQuantity)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$totalTaskMete = this.getTotalTaskMete();
                              Object other$totalTaskMete = other.getTotalTaskMete();
                              if (this$totalTaskMete == null ? other$totalTaskMete == null : this$totalTaskMete.equals(other$totalTaskMete)) {
                                 Object this$totalCompleteMete = this.getTotalCompleteMete();
                                 Object other$totalCompleteMete = other.getTotalCompleteMete();
                                 if (this$totalCompleteMete == null ? other$totalCompleteMete == null : this$totalCompleteMete.equals(other$totalCompleteMete)) {
                                    Object this$totalCanAssistMete = this.getTotalCanAssistMete();
                                    Object other$totalCanAssistMete = other.getTotalCanAssistMete();
                                    if (this$totalCanAssistMete == null
                                       ? other$totalCanAssistMete == null
                                       : this$totalCanAssistMete.equals(other$totalCanAssistMete)) {
                                       Object this$assistProductDTOList = this.getAssistProductDTOList();
                                       Object other$assistProductDTOList = other.getAssistProductDTOList();
                                       return this$assistProductDTOList == null
                                          ? other$assistProductDTOList == null
                                          : this$assistProductDTOList.equals(other$assistProductDTOList);
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
      return other instanceof MesBuildingAssistProductFromArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $artifactProductId = this.getArtifactProductId();
      result = result * 59 + ($artifactProductId == null ? 43 : $artifactProductId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $totalAssistQuantity = this.getTotalAssistQuantity();
      result = result * 59 + ($totalAssistQuantity == null ? 43 : $totalAssistQuantity.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalTaskMete = this.getTotalTaskMete();
      result = result * 59 + ($totalTaskMete == null ? 43 : $totalTaskMete.hashCode());
      Object $totalCompleteMete = this.getTotalCompleteMete();
      result = result * 59 + ($totalCompleteMete == null ? 43 : $totalCompleteMete.hashCode());
      Object $totalCanAssistMete = this.getTotalCanAssistMete();
      result = result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
      Object $assistProductDTOList = this.getAssistProductDTOList();
      return result * 59 + ($assistProductDTOList == null ? 43 : $assistProductDTOList.hashCode());
   }

   public static class MesBuildingAssistProductFromArtifactDTOBuilder {
      private Long artifactTaskId;
      private Long artifactProductId;
      private Integer taskTypeEnum;
      private AreaDetailDO area;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private Integer totalAssistQuantity;
      private List<MesBuildingAssistProductDTO> assistProductDTOList;

      MesBuildingAssistProductFromArtifactDTOBuilder() {
      }

      @JsonProperty("artifactTaskId")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      @JsonProperty("artifactProductId")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder artifactProductId(final Long artifactProductId) {
         this.artifactProductId = artifactProductId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder totalCompleteMete(
         final QuantityAndWeightDetailDO totalCompleteMete
      ) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder totalCanAssistMete(
         final QuantityAndWeightDetailDO totalCanAssistMete
      ) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("totalAssistQuantity")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder totalAssistQuantity(final Integer totalAssistQuantity) {
         this.totalAssistQuantity = totalAssistQuantity;
         return this;
      }

      @JsonProperty("assistProductDTOList")
      public MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder assistProductDTOList(
         final List<MesBuildingAssistProductDTO> assistProductDTOList
      ) {
         this.assistProductDTOList = assistProductDTOList;
         return this;
      }

      public MesBuildingAssistProductFromArtifactDTO build() {
         return new MesBuildingAssistProductFromArtifactDTO(
            this.artifactTaskId,
            this.artifactProductId,
            this.taskTypeEnum,
            this.area,
            this.serialNumber,
            this.specification,
            this.length,
            this.totalTaskMete,
            this.totalCompleteMete,
            this.totalCanAssistMete,
            this.totalAssistQuantity,
            this.assistProductDTOList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistProductFromArtifactDTO.MesBuildingAssistProductFromArtifactDTOBuilder(artifactTaskId="
            + this.artifactTaskId
            + ", artifactProductId="
            + this.artifactProductId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", totalTaskMete="
            + this.totalTaskMete
            + ", totalCompleteMete="
            + this.totalCompleteMete
            + ", totalCanAssistMete="
            + this.totalCanAssistMete
            + ", totalAssistQuantity="
            + this.totalAssistQuantity
            + ", assistProductDTOList="
            + this.assistProductDTOList
            + ")";
      }
   }
}
