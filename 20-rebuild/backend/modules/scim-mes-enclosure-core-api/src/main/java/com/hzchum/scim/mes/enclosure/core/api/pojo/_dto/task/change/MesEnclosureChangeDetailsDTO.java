package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.change;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureChangeDetailsDTO", description = "零件工单 ")
public class MesEnclosureChangeDetailsDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "orderNumber", notes = "任务编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
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

   public static MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder builder() {
      return new MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder();
   }

   public MesEnclosureChangeDetailsDTO() {
   }

   public MesEnclosureChangeDetailsDTO(
      final Long id,
      final String orderNumber,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal netWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal grossWeight,
      final Integer taskTypeEnum,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final AreaDetailDO area,
      final String pdfUrl,
      final String cutNumber
   ) {
      this.id = id;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.netWeight = netWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.grossWeight = grossWeight;
      this.taskTypeEnum = taskTypeEnum;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.area = area;
      this.pdfUrl = pdfUrl;
      this.cutNumber = cutNumber;
   }

   public Long getId() {
      return this.id;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
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

   public AreaDetailDO getArea() {
      return this.area;
   }

   public String getPdfUrl() {
      return this.pdfUrl;
   }

   public String getCutNumber() {
      return this.cutNumber;
   }

   @JsonProperty("id")
   public MesEnclosureChangeDetailsDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureChangeDetailsDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureChangeDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureChangeDetailsDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureChangeDetailsDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureChangeDetailsDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureChangeDetailsDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesEnclosureChangeDetailsDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureChangeDetailsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureChangeDetailsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureChangeDetailsDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureChangeDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureChangeDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureChangeDetailsDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureChangeDetailsDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("pdfUrl")
   public MesEnclosureChangeDetailsDTO setPdfUrl(final String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesEnclosureChangeDetailsDTO setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureChangeDetailsDTO(id="
         + this.getId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", area="
         + this.getArea()
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

      if (!(o instanceof MesEnclosureChangeDetailsDTO)) {
         return false;
      }

      MesEnclosureChangeDetailsDTO other = (MesEnclosureChangeDetailsDTO)o;
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
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                     Object this$netWeight = this.getNetWeight();
                     Object other$netWeight = other.getNetWeight();
                     if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                           Object this$grossWeight = this.getGrossWeight();
                           Object other$grossWeight = other.getGrossWeight();
                           if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                              Object this$workshop = this.getWorkshop();
                              Object other$workshop = other.getWorkshop();
                              if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                 Object this$productionLine = this.getProductionLine();
                                 Object other$productionLine = other.getProductionLine();
                                 if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                    Object this$groups = this.getGroups();
                                    Object other$groups = other.getGroups();
                                    if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$area = this.getArea();
                                                Object other$area = other.getArea();
                                                if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
      return other instanceof MesEnclosureChangeDetailsDTO;
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
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $pdfUrl = this.getPdfUrl();
      result = result * 59 + ($pdfUrl == null ? 43 : $pdfUrl.hashCode());
      Object $cutNumber = this.getCutNumber();
      return result * 59 + ($cutNumber == null ? 43 : $cutNumber.hashCode());
   }

   public static class MesEnclosureChangeDetailsDTOBuilder {
      private Long id;
      private String orderNumber;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal netWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal grossWeight;
      private Integer taskTypeEnum;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private AreaDetailDO area;
      private String pdfUrl;
      private String cutNumber;

      MesEnclosureChangeDetailsDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("pdfUrl")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder pdfUrl(final String pdfUrl) {
         this.pdfUrl = pdfUrl;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      public MesEnclosureChangeDetailsDTO build() {
         return new MesEnclosureChangeDetailsDTO(
            this.id,
            this.orderNumber,
            this.quantity,
            this.totalNetWeight,
            this.netWeight,
            this.totalGrossWeight,
            this.grossWeight,
            this.taskTypeEnum,
            this.workshop,
            this.productionLine,
            this.groups,
            this.serialNumber,
            this.specification,
            this.length,
            this.area,
            this.pdfUrl,
            this.cutNumber
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureChangeDetailsDTO.MesEnclosureChangeDetailsDTOBuilder(id="
            + this.id
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", netWeight="
            + this.netWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", grossWeight="
            + this.grossWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", area="
            + this.area
            + ", pdfUrl="
            + this.pdfUrl
            + ", cutNumber="
            + this.cutNumber
            + ")";
      }
   }
}
