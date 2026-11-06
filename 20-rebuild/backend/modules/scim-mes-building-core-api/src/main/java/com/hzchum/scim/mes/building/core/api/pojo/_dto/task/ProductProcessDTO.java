package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ArtifactProcessDTO", description = "生产跟踪")
public class ProductProcessDTO {
   @ApiModelProperty(name = "id", notes = "构件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "构件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "status", notes = "构件状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "specification", notes = "构件规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "netWeight", notes = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "classId", notes = "配置id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completedQuantity", notes = "完成数量")
   @JsonProperty("completedQuantity")
   @JSONField(name = "completedQuantity")
   private Integer completedQuantity;
   @ApiModelProperty(name = "producedQuantity", notes = "进入生产数量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionName", notes = "产线名称")
   @JsonProperty("productionName")
   @JSONField(name = "productionName")
   private String productionName;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private List<ProductProcessQuantityDTO> process;

   public static ProductProcessDTO.ProductProcessDTOBuilder builder() {
      return new ProductProcessDTO.ProductProcessDTOBuilder();
   }

   public ProductProcessDTO() {
   }

   public ProductProcessDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final Integer status,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Long classId,
      final Integer quantity,
      final Integer taskQuantity,
      final Integer completedQuantity,
      final Integer producedQuantity,
      final Long productionLineId,
      final String productionName,
      final List<ProductProcessQuantityDTO> process
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.status = status;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.classId = classId;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.completedQuantity = completedQuantity;
      this.producedQuantity = producedQuantity;
      this.productionLineId = productionLineId;
      this.productionName = productionName;
      this.process = process;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompletedQuantity() {
      return this.completedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionName() {
      return this.productionName;
   }

   public List<ProductProcessQuantityDTO> getProcess() {
      return this.process;
   }

   @JsonProperty("id")
   public ProductProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductProcessDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("status")
   public ProductProcessDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("specification")
   public ProductProcessDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ProductProcessDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ProductProcessDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductProcessDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ProductProcessDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("classId")
   public ProductProcessDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("quantity")
   public ProductProcessDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ProductProcessDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completedQuantity")
   public ProductProcessDTO setCompletedQuantity(final Integer completedQuantity) {
      this.completedQuantity = completedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public ProductProcessDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("productionLineId")
   public ProductProcessDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionName")
   public ProductProcessDTO setProductionName(final String productionName) {
      this.productionName = productionName;
      return this;
   }

   @JsonProperty("process")
   public ProductProcessDTO setProcess(final List<ProductProcessQuantityDTO> process) {
      this.process = process;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessDTO)) {
         return false;
      }

      ProductProcessDTO other = (ProductProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$classId = this.getClassId();
            Object other$classId = other.getClassId();
            if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$completedQuantity = this.getCompletedQuantity();
                     Object other$completedQuantity = other.getCompletedQuantity();
                     if (this$completedQuantity == null ? other$completedQuantity == null : this$completedQuantity.equals(other$completedQuantity)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$grossWeight = this.getGrossWeight();
                                                Object other$grossWeight = other.getGrossWeight();
                                                if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                   Object this$productionName = this.getProductionName();
                                                   Object other$productionName = other.getProductionName();
                                                   if (this$productionName == null
                                                      ? other$productionName == null
                                                      : this$productionName.equals(other$productionName)) {
                                                      Object this$process = this.getProcess();
                                                      Object other$process = other.getProcess();
                                                      return this$process == null ? other$process == null : this$process.equals(other$process);
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
      return other instanceof ProductProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completedQuantity = this.getCompletedQuantity();
      result = result * 59 + ($completedQuantity == null ? 43 : $completedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $productionName = this.getProductionName();
      result = result * 59 + ($productionName == null ? 43 : $productionName.hashCode());
      Object $process = this.getProcess();
      return result * 59 + ($process == null ? 43 : $process.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", status="
         + this.getStatus()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", classId="
         + this.getClassId()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completedQuantity="
         + this.getCompletedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionName="
         + this.getProductionName()
         + ", process="
         + this.getProcess()
         + ")";
   }

   public static class ProductProcessDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private Integer status;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Long classId;
      private Integer quantity;
      private Integer taskQuantity;
      private Integer completedQuantity;
      private Integer producedQuantity;
      private Long productionLineId;
      private String productionName;
      private List<ProductProcessQuantityDTO> process;

      ProductProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public ProductProcessDTO.ProductProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductProcessDTO.ProductProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductProcessDTO.ProductProcessDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("status")
      public ProductProcessDTO.ProductProcessDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("specification")
      public ProductProcessDTO.ProductProcessDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ProductProcessDTO.ProductProcessDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProductProcessDTO.ProductProcessDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductProcessDTO.ProductProcessDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ProductProcessDTO.ProductProcessDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("classId")
      public ProductProcessDTO.ProductProcessDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("quantity")
      public ProductProcessDTO.ProductProcessDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProductProcessDTO.ProductProcessDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completedQuantity")
      public ProductProcessDTO.ProductProcessDTOBuilder completedQuantity(final Integer completedQuantity) {
         this.completedQuantity = completedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public ProductProcessDTO.ProductProcessDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("productionLineId")
      public ProductProcessDTO.ProductProcessDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionName")
      public ProductProcessDTO.ProductProcessDTOBuilder productionName(final String productionName) {
         this.productionName = productionName;
         return this;
      }

      @JsonProperty("process")
      public ProductProcessDTO.ProductProcessDTOBuilder process(final List<ProductProcessQuantityDTO> process) {
         this.process = process;
         return this;
      }

      public ProductProcessDTO build() {
         return new ProductProcessDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.status,
            this.specification,
            this.length,
            this.material,
            this.netWeight,
            this.grossWeight,
            this.classId,
            this.quantity,
            this.taskQuantity,
            this.completedQuantity,
            this.producedQuantity,
            this.productionLineId,
            this.productionName,
            this.process
         );
      }

      @Override
      public String toString() {
         return "ProductProcessDTO.ProductProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", status="
            + this.status
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", classId="
            + this.classId
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completedQuantity="
            + this.completedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", productionLineId="
            + this.productionLineId
            + ", productionName="
            + this.productionName
            + ", process="
            + this.process
            + ")";
      }
   }
}
