package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class ProjectCargoListMeteDO {
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

   public static ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder builder() {
      return new ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder();
   }

   public ProjectCargoListMeteDO(
      final ProjectDetailDO project,
      final Integer quantity,
      final BigDecimal mete,
      final Integer sendQuantity,
      final BigDecimal sendMete,
      final BigDecimal ratio
   ) {
      this.project = project;
      this.quantity = quantity;
      this.mete = mete;
      this.sendQuantity = sendQuantity;
      this.sendMete = sendMete;
      this.ratio = ratio;
   }

   public ProjectCargoListMeteDO() {
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListMeteDO)) {
         return false;
      }

      ProjectCargoListMeteDO other = (ProjectCargoListMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$sendQuantity = this.getSendQuantity();
         Object other$sendQuantity = other.getSendQuantity();
         if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectCargoListMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
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
      return "ProjectCargoListMeteDO(project="
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
         + ")";
   }

   public static class ProjectCargoListMeteDOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private BigDecimal mete;
      private Integer sendQuantity;
      private BigDecimal sendMete;
      private BigDecimal ratio;

      ProjectCargoListMeteDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      @JsonProperty("sendMete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder sendMete(final BigDecimal sendMete) {
         this.sendMete = sendMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public ProjectCargoListMeteDO build() {
         return new ProjectCargoListMeteDO(this.project, this.quantity, this.mete, this.sendQuantity, this.sendMete, this.ratio);
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder(project="
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
            + ")";
      }
   }
}
