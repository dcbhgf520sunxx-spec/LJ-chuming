package com.hzchum.scim.contract.core.api.pojo.vo.largeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectDataVO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "inventoryTon", value = "清单量（t）")
   private BigDecimal inventoryTon;
   @ApiModelProperty(name = "produceTon", value = "生产量（t）")
   private BigDecimal produceTon;
   @ApiModelProperty(name = "produceRate", value = "生产占比")
   private BigDecimal produceRate;
   @ApiModelProperty(name = "outTon", value = "发运量（t）")
   private BigDecimal outTon;
   @ApiModelProperty(name = "outRate", value = "发运占比")
   private BigDecimal outRate;

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getInventoryTon() {
      return this.inventoryTon;
   }

   public BigDecimal getProduceTon() {
      return this.produceTon;
   }

   public BigDecimal getProduceRate() {
      return this.produceRate;
   }

   public BigDecimal getOutTon() {
      return this.outTon;
   }

   public BigDecimal getOutRate() {
      return this.outRate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setInventoryTon(final BigDecimal inventoryTon) {
      this.inventoryTon = inventoryTon;
   }

   public void setProduceTon(final BigDecimal produceTon) {
      this.produceTon = produceTon;
   }

   public void setProduceRate(final BigDecimal produceRate) {
      this.produceRate = produceRate;
   }

   public void setOutTon(final BigDecimal outTon) {
      this.outTon = outTon;
   }

   public void setOutRate(final BigDecimal outRate) {
      this.outRate = outRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectDataVO)) {
         return false;
      }

      ProjectDataVO other = (ProjectDataVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$inventoryTon = this.getInventoryTon();
            Object other$inventoryTon = other.getInventoryTon();
            if (this$inventoryTon == null ? other$inventoryTon == null : this$inventoryTon.equals(other$inventoryTon)) {
               Object this$produceTon = this.getProduceTon();
               Object other$produceTon = other.getProduceTon();
               if (this$produceTon == null ? other$produceTon == null : this$produceTon.equals(other$produceTon)) {
                  Object this$produceRate = this.getProduceRate();
                  Object other$produceRate = other.getProduceRate();
                  if (this$produceRate == null ? other$produceRate == null : this$produceRate.equals(other$produceRate)) {
                     Object this$outTon = this.getOutTon();
                     Object other$outTon = other.getOutTon();
                     if (this$outTon == null ? other$outTon == null : this$outTon.equals(other$outTon)) {
                        Object this$outRate = this.getOutRate();
                        Object other$outRate = other.getOutRate();
                        return this$outRate == null ? other$outRate == null : this$outRate.equals(other$outRate);
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
      return other instanceof ProjectDataVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $inventoryTon = this.getInventoryTon();
      result = result * 59 + ($inventoryTon == null ? 43 : $inventoryTon.hashCode());
      Object $produceTon = this.getProduceTon();
      result = result * 59 + ($produceTon == null ? 43 : $produceTon.hashCode());
      Object $produceRate = this.getProduceRate();
      result = result * 59 + ($produceRate == null ? 43 : $produceRate.hashCode());
      Object $outTon = this.getOutTon();
      result = result * 59 + ($outTon == null ? 43 : $outTon.hashCode());
      Object $outRate = this.getOutRate();
      return result * 59 + ($outRate == null ? 43 : $outRate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectDataVO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", inventoryTon="
         + this.getInventoryTon()
         + ", produceTon="
         + this.getProduceTon()
         + ", produceRate="
         + this.getProduceRate()
         + ", outTon="
         + this.getOutTon()
         + ", outRate="
         + this.getOutRate()
         + ")";
   }
}
