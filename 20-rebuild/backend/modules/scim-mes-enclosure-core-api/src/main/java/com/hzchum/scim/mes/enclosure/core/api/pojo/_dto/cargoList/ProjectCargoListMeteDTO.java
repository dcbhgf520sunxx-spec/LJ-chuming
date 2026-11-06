package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class ProjectCargoListMeteDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "清单重量", notes = "清单重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "sendQuantity", value = "发运数量", notes = "发运数量")
   @JsonProperty("sendQuantity")
   @JSONField(name = "sendQuantity")
   private Integer sendQuantity;
   @ApiModelProperty(name = "sendMete", value = "发运重量", notes = "发运重量")
   @JsonProperty("sendMete")
   @JSONField(name = "sendMete")
   private BigDecimal sendMete;
   @ApiModelProperty(name = "ratio", value = "比率", notes = "比率")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;
   @ApiModelProperty(name = "cargoQuantity", value = "车次", notes = "车次")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;

   public static ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder builder() {
      return new ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder();
   }

   public ProjectCargoListMeteDTO(
      final ProjectDetailDO project,
      final Integer quantity,
      final BigDecimal mete,
      final Integer sendQuantity,
      final BigDecimal sendMete,
      final BigDecimal ratio,
      final Integer cargoQuantity
   ) {
      this.project = project;
      this.quantity = quantity;
      this.mete = mete;
      this.sendQuantity = sendQuantity;
      this.sendMete = sendMete;
      this.ratio = ratio;
      this.cargoQuantity = cargoQuantity;
   }

   public ProjectCargoListMeteDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getSendQuantity() {
      return this.sendQuantity;
   }

   public BigDecimal getSendMete() {
      return this.sendMete;
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

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("sendQuantity")
   public void setSendQuantity(final Integer sendQuantity) {
      this.sendQuantity = sendQuantity;
   }

   @JsonProperty("sendMete")
   public void setSendMete(final BigDecimal sendMete) {
      this.sendMete = sendMete;
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

      if (!(o instanceof ProjectCargoListMeteDTO)) {
         return false;
      }

      ProjectCargoListMeteDTO other = (ProjectCargoListMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$sendQuantity = this.getSendQuantity();
         Object other$sendQuantity = other.getSendQuantity();
         if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
            Object this$cargoQuantity = this.getCargoQuantity();
            Object other$cargoQuantity = other.getCargoQuantity();
            if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$sendMete = this.getSendMete();
                     Object other$sendMete = other.getSendMete();
                     if (this$sendMete == null ? other$sendMete == null : this$sendMete.equals(other$sendMete)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectCargoListMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $sendMete = this.getSendMete();
      result = result * 59 + ($sendMete == null ? 43 : $sendMete.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListMeteDTO(project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", sendQuantity="
         + this.getSendQuantity()
         + ", sendMete="
         + this.getSendMete()
         + ", ratio="
         + this.getRatio()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ")";
   }

   public static class ProjectCargoListMeteDTOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private BigDecimal mete;
      private Integer sendQuantity;
      private BigDecimal sendMete;
      private BigDecimal ratio;
      private Integer cargoQuantity;

      ProjectCargoListMeteDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      @JsonProperty("sendMete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendMete(final BigDecimal sendMete) {
         this.sendMete = sendMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public ProjectCargoListMeteDTO build() {
         return new ProjectCargoListMeteDTO(this.project, this.quantity, this.mete, this.sendQuantity, this.sendMete, this.ratio, this.cargoQuantity);
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder(project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", sendQuantity="
            + this.sendQuantity
            + ", sendMete="
            + this.sendMete
            + ", ratio="
            + this.ratio
            + ", cargoQuantity="
            + this.cargoQuantity
            + ")";
      }
   }
}
