package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.change;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureTaskChangeDO", description = "零件工单 ")
public class MesEnclosureTaskChangeDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "configId", notes = "产品配置id")
   @JsonProperty("configId")
   @JSONField(name = "configId")
   private Long configId;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   @JsonInclude(Include.NON_NULL)
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @JsonInclude(Include.NON_NULL)
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   @JsonInclude(Include.NON_NULL)
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   @JsonInclude(Include.NON_NULL)
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "pdfUrl", value = "PDF路径", notes = "PDF路径")
   @JsonProperty("pdfUrl")
   @JSONField(name = "pdfUrl")
   @JsonInclude(Include.NON_NULL)
   private String pdfUrl;
   @ApiModelProperty(name = "cutNumber", value = "切割编号", notes = "切割编号")
   @JsonProperty("cutNumber")
   @JSONField(name = "cutNumber")
   @JsonInclude(Include.NON_NULL)
   private String cutNumber;

   public static MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder builder() {
      return new MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder();
   }

   public MesEnclosureTaskChangeDO() {
   }

   public MesEnclosureTaskChangeDO(
      final Long id,
      final String serialNumber,
      final String specification,
      final LocalDateTime askCompleteTime,
      final AreaDetailDO area,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer taskTypeEnum,
      final BigDecimal length,
      final Long configId,
      final GroupsCurrencyDO groups,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final FactoryDetailDO factory,
      final String pdfUrl,
      final String cutNumber
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.askCompleteTime = askCompleteTime;
      this.area = area;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.taskTypeEnum = taskTypeEnum;
      this.length = length;
      this.configId = configId;
      this.groups = groups;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.factory = factory;
      this.pdfUrl = pdfUrl;
      this.cutNumber = cutNumber;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Long getConfigId() {
      return this.configId;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public String getPdfUrl() {
      return this.pdfUrl;
   }

   public String getCutNumber() {
      return this.cutNumber;
   }

   @JsonProperty("id")
   public MesEnclosureTaskChangeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureTaskChangeDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureTaskChangeDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskChangeDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureTaskChangeDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskChangeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureTaskChangeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureTaskChangeDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesEnclosureTaskChangeDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureTaskChangeDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("configId")
   public MesEnclosureTaskChangeDO setConfigId(final Long configId) {
      this.configId = configId;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureTaskChangeDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureTaskChangeDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureTaskChangeDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("factory")
   public MesEnclosureTaskChangeDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("pdfUrl")
   public MesEnclosureTaskChangeDO setPdfUrl(final String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesEnclosureTaskChangeDO setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskChangeDO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", area="
         + this.getArea()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", length="
         + this.getLength()
         + ", configId="
         + this.getConfigId()
         + ", groups="
         + this.getGroups()
         + ", productionLine="
         + this.getProductionLine()
         + ", workshop="
         + this.getWorkshop()
         + ", factory="
         + this.getFactory()
         + ", pdfUrl="
         + this.getPdfUrl()
         + ", cutNumber="
         + this.getCutNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskChangeDO)) {
         return false;
      }

      MesEnclosureTaskChangeDO other = (MesEnclosureTaskChangeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$configId = this.getConfigId();
               Object other$configId = other.getConfigId();
               if (this$configId == null ? other$configId == null : this$configId.equals(other$configId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$askCompleteTime = this.getAskCompleteTime();
                        Object other$askCompleteTime = other.getAskCompleteTime();
                        if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$totalGrossWeight = this.getTotalGrossWeight();
                                 Object other$totalGrossWeight = other.getTotalGrossWeight();
                                 if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$groups = this.getGroups();
                                       Object other$groups = other.getGroups();
                                       if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                          Object this$productionLine = this.getProductionLine();
                                          Object other$productionLine = other.getProductionLine();
                                          if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                             Object this$workshop = this.getWorkshop();
                                             Object other$workshop = other.getWorkshop();
                                             if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                Object this$factory = this.getFactory();
                                                Object other$factory = other.getFactory();
                                                if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                                   Object this$pdfUrl = this.getPdfUrl();
                                                   Object other$pdfUrl = other.getPdfUrl();
                                                   if (this$pdfUrl == null ? other$pdfUrl == null : this$pdfUrl.equals(other$pdfUrl)) {
                                                      Object this$cutNumber = this.getCutNumber();
                                                      Object other$cutNumber = other.getCutNumber();
                                                      return this$cutNumber == null ? other$cutNumber == null : this$cutNumber.equals(other$cutNumber);
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
      return other instanceof MesEnclosureTaskChangeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $configId = this.getConfigId();
      result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $pdfUrl = this.getPdfUrl();
      result = result * 59 + ($pdfUrl == null ? 43 : $pdfUrl.hashCode());
      Object $cutNumber = this.getCutNumber();
      return result * 59 + ($cutNumber == null ? 43 : $cutNumber.hashCode());
   }

   public static class MesEnclosureTaskChangeDOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private LocalDateTime askCompleteTime;
      private AreaDetailDO area;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer taskTypeEnum;
      private BigDecimal length;
      private Long configId;
      private GroupsCurrencyDO groups;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private FactoryDetailDO factory;
      private String pdfUrl;
      private String cutNumber;

      MesEnclosureTaskChangeDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("configId")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder configId(final Long configId) {
         this.configId = configId;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("factory")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("pdfUrl")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder pdfUrl(final String pdfUrl) {
         this.pdfUrl = pdfUrl;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      public MesEnclosureTaskChangeDO build() {
         return new MesEnclosureTaskChangeDO(
            this.id,
            this.serialNumber,
            this.specification,
            this.askCompleteTime,
            this.area,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.taskTypeEnum,
            this.length,
            this.configId,
            this.groups,
            this.productionLine,
            this.workshop,
            this.factory,
            this.pdfUrl,
            this.cutNumber
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskChangeDO.MesEnclosureTaskChangeDOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", area="
            + this.area
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", length="
            + this.length
            + ", configId="
            + this.configId
            + ", groups="
            + this.groups
            + ", productionLine="
            + this.productionLine
            + ", workshop="
            + this.workshop
            + ", factory="
            + this.factory
            + ", pdfUrl="
            + this.pdfUrl
            + ", cutNumber="
            + this.cutNumber
            + ")";
      }
   }
}
