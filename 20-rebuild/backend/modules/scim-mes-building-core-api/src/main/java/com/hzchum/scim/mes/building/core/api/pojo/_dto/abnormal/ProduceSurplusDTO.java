package com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProduceSurplusDTO", description = "多余产品返回类")
public class ProduceSurplusDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "processName", value = "工序名", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "leaderName", value = "组长名", notes = "组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "handleStatus", value = "处理状态[1 未处理，2 报废, 3, 二次利用]", notes = "处理状态[1 未处理，2 报废, 3, 二次利用]")
   @JsonProperty("handleStatus")
   @JSONField(name = "handleStatus")
   private Integer handleStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "项目id")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;

   public static ProduceSurplusDTO.ProduceSurplusDTOBuilder builder() {
      return new ProduceSurplusDTO.ProduceSurplusDTOBuilder();
   }

   public ProduceSurplusDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String processName,
      final String leaderName,
      final String serialNumber,
      final Integer quantity,
      final Integer handleStatus,
      final String remark
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.processName = processName;
      this.leaderName = leaderName;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.handleStatus = handleStatus;
      this.remark = remark;
   }

   public ProduceSurplusDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getHandleStatus() {
      return this.handleStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("project")
   public ProduceSurplusDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProduceSurplusDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProduceSurplusDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("factory")
   public ProduceSurplusDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ProduceSurplusDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProduceSurplusDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("processName")
   public ProduceSurplusDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("leaderName")
   public ProduceSurplusDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProduceSurplusDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public ProduceSurplusDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("handleStatus")
   public ProduceSurplusDTO setHandleStatus(final Integer handleStatus) {
      this.handleStatus = handleStatus;
      return this;
   }

   @JsonProperty("remark")
   public ProduceSurplusDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceSurplusDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", processName="
         + this.getProcessName()
         + ", leaderName="
         + this.getLeaderName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", handleStatus="
         + this.getHandleStatus()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceSurplusDTO)) {
         return false;
      }

      ProduceSurplusDTO other = (ProduceSurplusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$handleStatus = this.getHandleStatus();
         Object other$handleStatus = other.getHandleStatus();
         if (this$handleStatus == null ? other$handleStatus == null : this$handleStatus.equals(other$handleStatus)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$factory = this.getFactory();
                     Object other$factory = other.getFactory();
                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$productionLine = this.getProductionLine();
                           Object other$productionLine = other.getProductionLine();
                           if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$leaderName = this.getLeaderName();
                                 Object other$leaderName = other.getLeaderName();
                                 if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProduceSurplusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $handleStatus = this.getHandleStatus();
      result = result * 59 + ($handleStatus == null ? 43 : $handleStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ProduceSurplusDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private String processName;
      private String leaderName;
      private String serialNumber;
      private Integer quantity;
      private Integer handleStatus;
      private String remark;

      ProduceSurplusDTOBuilder() {
      }

      @JsonProperty("project")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("factory")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("processName")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("leaderName")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("handleStatus")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder handleStatus(final Integer handleStatus) {
         this.handleStatus = handleStatus;
         return this;
      }

      @JsonProperty("remark")
      public ProduceSurplusDTO.ProduceSurplusDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProduceSurplusDTO build() {
         return new ProduceSurplusDTO(
            this.project,
            this.monomer,
            this.area,
            this.factory,
            this.workshop,
            this.productionLine,
            this.processName,
            this.leaderName,
            this.serialNumber,
            this.quantity,
            this.handleStatus,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ProduceSurplusDTO.ProduceSurplusDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", processName="
            + this.processName
            + ", leaderName="
            + this.leaderName
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", handleStatus="
            + this.handleStatus
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
