package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectPainingPriceDO", description = "项目涂装价格 ")
public class ProjectPainingPriceDO {
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "mete", value = "重量(kg)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "area", value = "面积(mm2)")
   @JsonProperty("area")
   @JSONField(name = "area")
   private BigDecimal area;
   @ApiModelProperty(name = "price", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static ProjectPainingPriceDO.ProjectPainingPriceDOBuilder builder() {
      return new ProjectPainingPriceDO.ProjectPainingPriceDOBuilder();
   }

   public ProjectPainingPriceDO() {
   }

   public ProjectPainingPriceDO(final ProjectDetailDO project, final BigDecimal mete, final BigDecimal area, final BigDecimal price) {
      this.project = project;
      this.mete = mete;
      this.area = area;
      this.price = price;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("project")
   public ProjectPainingPriceDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("mete")
   public ProjectPainingPriceDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("area")
   public ProjectPainingPriceDO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("price")
   public ProjectPainingPriceDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectPainingPriceDO(project="
         + this.getProject()
         + ", mete="
         + this.getMete()
         + ", area="
         + this.getArea()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPainingPriceDO)) {
         return false;
      }

      ProjectPainingPriceDO other = (ProjectPainingPriceDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$area = this.getArea();
            Object other$area = other.getArea();
            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof ProjectPainingPriceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProjectPainingPriceDOBuilder {
      private ProjectDetailDO project;
      private BigDecimal mete;
      private BigDecimal area;
      private BigDecimal price;

      ProjectPainingPriceDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectPainingPriceDO.ProjectPainingPriceDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("mete")
      public ProjectPainingPriceDO.ProjectPainingPriceDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("area")
      public ProjectPainingPriceDO.ProjectPainingPriceDOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("price")
      public ProjectPainingPriceDO.ProjectPainingPriceDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProjectPainingPriceDO build() {
         return new ProjectPainingPriceDO(this.project, this.mete, this.area, this.price);
      }

      @Override
      public String toString() {
         return "ProjectPainingPriceDO.ProjectPainingPriceDOBuilder(project="
            + this.project
            + ", mete="
            + this.mete
            + ", area="
            + this.area
            + ", price="
            + this.price
            + ")";
      }
   }
}
