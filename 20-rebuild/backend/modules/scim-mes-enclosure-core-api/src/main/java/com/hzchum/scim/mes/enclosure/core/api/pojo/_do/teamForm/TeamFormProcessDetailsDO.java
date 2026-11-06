package com.hzchum.scim.mes.enclosure.core.api.pojo._do.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamFormProcessSummaryDO", description = "工序详情")
public class TeamFormProcessDetailsDO {
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成数量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;

   public static TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder builder() {
      return new TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder();
   }

   public TeamFormProcessDetailsDO() {
   }

   public TeamFormProcessDetailsDO(
      final String name,
      final Long id,
      final Long productionLineId,
      final Integer productType,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal taskLength,
      final BigDecimal completeLength
   ) {
      this.name = name;
      this.id = id;
      this.productionLineId = productionLineId;
      this.productType = productType;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
   }

   public String getName() {
      return this.name;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   @JsonProperty("name")
   public TeamFormProcessDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("id")
   public TeamFormProcessDetailsDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamFormProcessDetailsDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormProcessDetailsDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TeamFormProcessDetailsDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TeamFormProcessDetailsDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TeamFormProcessDetailsDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormProcessDetailsDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public TeamFormProcessDetailsDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public TeamFormProcessDetailsDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public TeamFormProcessDetailsDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public TeamFormProcessDetailsDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormProcessDetailsDO(name="
         + this.getName()
         + ", id="
         + this.getId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productType="
         + this.getProductType()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ", completeLength="
         + this.getCompleteLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormProcessDetailsDO)) {
         return false;
      }

      TeamFormProcessDetailsDO other = (TeamFormProcessDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$completeNetWeight = this.getCompleteNetWeight();
                        Object other$completeNetWeight = other.getCompleteNetWeight();
                        if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                           Object this$completeGrossWeight = this.getCompleteGrossWeight();
                           Object other$completeGrossWeight = other.getCompleteGrossWeight();
                           if (this$completeGrossWeight == null
                              ? other$completeGrossWeight == null
                              : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                              Object this$taskNetWeight = this.getTaskNetWeight();
                              Object other$taskNetWeight = other.getTaskNetWeight();
                              if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                 Object this$taskGrossWeight = this.getTaskGrossWeight();
                                 Object other$taskGrossWeight = other.getTaskGrossWeight();
                                 if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                    Object this$taskLength = this.getTaskLength();
                                    Object other$taskLength = other.getTaskLength();
                                    if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                       Object this$completeLength = this.getCompleteLength();
                                       Object other$completeLength = other.getCompleteLength();
                                       return this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength);
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
      return other instanceof TeamFormProcessDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      return result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
   }

   public static class TeamFormProcessDetailsDOBuilder {
      private String name;
      private Long id;
      private Long productionLineId;
      private Integer productType;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal taskLength;
      private BigDecimal completeLength;

      TeamFormProcessDetailsDOBuilder() {
      }

      @JsonProperty("name")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("id")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      public TeamFormProcessDetailsDO build() {
         return new TeamFormProcessDetailsDO(
            this.name,
            this.id,
            this.productionLineId,
            this.productType,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.taskLength,
            this.completeLength
         );
      }

      @Override
      public String toString() {
         return "TeamFormProcessDetailsDO.TeamFormProcessDetailsDOBuilder(name="
            + this.name
            + ", id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", productType="
            + this.productType
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ")";
      }
   }
}
