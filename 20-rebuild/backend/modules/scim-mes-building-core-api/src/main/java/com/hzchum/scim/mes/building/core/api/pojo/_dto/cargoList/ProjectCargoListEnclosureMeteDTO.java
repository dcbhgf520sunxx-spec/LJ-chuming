package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "围护发运量")
public class ProjectCargoListEnclosureMeteDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "sendQuantity", value = "发运数量", notes = "发运数量")
   @JsonProperty("sendQuantity")
   @JSONField(name = "sendQuantity")
   private Integer sendQuantity;
   @ApiModelProperty(name = "totalLength", value = "清单总长度", notes = "清单总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "sendTotalLength", value = "发运总长度", notes = "发运总长度")
   @JsonProperty("sendTotalLength")
   @JSONField(name = "sendTotalLength")
   private Integer sendTotalLength;
   @ApiModelProperty(name = "totalArea", value = "清单总面积", notes = "清单总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "sendTotalArea", value = "发运总面积", notes = "发运总面积")
   @JsonProperty("sendTotalArea")
   @JSONField(name = "sendTotalArea")
   private Integer sendTotalArea;
   @ApiModelProperty(name = "ratio", value = "比率", notes = "比率")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;
   @ApiModelProperty(name = "cargoQuantity", value = "车次", notes = "车次")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;

   public static ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder builder() {
      return new ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder();
   }

   public ProjectCargoListEnclosureMeteDTO(
      final ProjectDetailDO project,
      final Integer quantity,
      final Integer sendQuantity,
      final BigDecimal totalLength,
      final Integer sendTotalLength,
      final BigDecimal totalArea,
      final Integer sendTotalArea,
      final BigDecimal ratio,
      final Integer cargoQuantity
   ) {
      this.project = project;
      this.quantity = quantity;
      this.sendQuantity = sendQuantity;
      this.totalLength = totalLength;
      this.sendTotalLength = sendTotalLength;
      this.totalArea = totalArea;
      this.sendTotalArea = sendTotalArea;
      this.ratio = ratio;
      this.cargoQuantity = cargoQuantity;
   }

   public ProjectCargoListEnclosureMeteDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSendQuantity() {
      return this.sendQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getSendTotalLength() {
      return this.sendTotalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getSendTotalArea() {
      return this.sendTotalArea;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   @JsonProperty("project")
   public void setProject(final ProjectDetailDO project) {
      this.project = project;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("sendQuantity")
   public void setSendQuantity(final Integer sendQuantity) {
      this.sendQuantity = sendQuantity;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("sendTotalLength")
   public void setSendTotalLength(final Integer sendTotalLength) {
      this.sendTotalLength = sendTotalLength;
   }

   @JsonProperty("totalArea")
   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @JsonProperty("sendTotalArea")
   public void setSendTotalArea(final Integer sendTotalArea) {
      this.sendTotalArea = sendTotalArea;
   }

   @JsonProperty("ratio")
   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListEnclosureMeteDTO)) {
         return false;
      }

      ProjectCargoListEnclosureMeteDTO other = (ProjectCargoListEnclosureMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$sendQuantity = this.getSendQuantity();
         Object other$sendQuantity = other.getSendQuantity();
         if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
            Object this$sendTotalLength = this.getSendTotalLength();
            Object other$sendTotalLength = other.getSendTotalLength();
            if (this$sendTotalLength == null ? other$sendTotalLength == null : this$sendTotalLength.equals(other$sendTotalLength)) {
               Object this$sendTotalArea = this.getSendTotalArea();
               Object other$sendTotalArea = other.getSendTotalArea();
               if (this$sendTotalArea == null ? other$sendTotalArea == null : this$sendTotalArea.equals(other$sendTotalArea)) {
                  Object this$cargoQuantity = this.getCargoQuantity();
                  Object other$cargoQuantity = other.getCargoQuantity();
                  if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$totalLength = this.getTotalLength();
                        Object other$totalLength = other.getTotalLength();
                        if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                           Object this$totalArea = this.getTotalArea();
                           Object other$totalArea = other.getTotalArea();
                           if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                              Object this$ratio = this.getRatio();
                              Object other$ratio = other.getRatio();
                              return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
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
      return other instanceof ProjectCargoListEnclosureMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
      Object $sendTotalLength = this.getSendTotalLength();
      result = result * 59 + ($sendTotalLength == null ? 43 : $sendTotalLength.hashCode());
      Object $sendTotalArea = this.getSendTotalArea();
      result = result * 59 + ($sendTotalArea == null ? 43 : $sendTotalArea.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListEnclosureMeteDTO(project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", sendQuantity="
         + this.getSendQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", sendTotalLength="
         + this.getSendTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", sendTotalArea="
         + this.getSendTotalArea()
         + ", ratio="
         + this.getRatio()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ")";
   }

   public static class ProjectCargoListEnclosureMeteDTOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private Integer sendQuantity;
      private BigDecimal totalLength;
      private Integer sendTotalLength;
      private BigDecimal totalArea;
      private Integer sendTotalArea;
      private BigDecimal ratio;
      private Integer cargoQuantity;

      ProjectCargoListEnclosureMeteDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      @JsonProperty("totalLength")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("sendTotalLength")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder sendTotalLength(final Integer sendTotalLength) {
         this.sendTotalLength = sendTotalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("sendTotalArea")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder sendTotalArea(final Integer sendTotalArea) {
         this.sendTotalArea = sendTotalArea;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public ProjectCargoListEnclosureMeteDTO build() {
         return new ProjectCargoListEnclosureMeteDTO(
            this.project,
            this.quantity,
            this.sendQuantity,
            this.totalLength,
            this.sendTotalLength,
            this.totalArea,
            this.sendTotalArea,
            this.ratio,
            this.cargoQuantity
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListEnclosureMeteDTO.ProjectCargoListEnclosureMeteDTOBuilder(project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", sendQuantity="
            + this.sendQuantity
            + ", totalLength="
            + this.totalLength
            + ", sendTotalLength="
            + this.sendTotalLength
            + ", totalArea="
            + this.totalArea
            + ", sendTotalArea="
            + this.sendTotalArea
            + ", ratio="
            + this.ratio
            + ", cargoQuantity="
            + this.cargoQuantity
            + ")";
      }
   }
}
