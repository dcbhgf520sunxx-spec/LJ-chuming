package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.PlanOperationTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("备料清单DTO(无清单备料)")
public class PlanStockListDTO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "stockId", value = "备料单id")
   private Long stockId;
   @NotNull(message = "钢材分类配置id不能为空")
   @ApiModelProperty(name = "steelClassifyConfId", value = "钢材分类配置id")
   private Long steelClassifyConfId;
   @ApiModelProperty(name = "steelClassifyConfName", value = "钢材配置名称")
   private String steelClassifyConfName;
   @NotNull(message = "主科目分类不能为空")
   @ApiModelProperty(name = "basicClass", value = "主科目分类")
   private Integer basicClass;
   @NotBlank(message = "规格/厚度不能为空")
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @NotBlank(message = "材质不能为空")
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @NotNull(message = "清单量不能为空")
   @ApiModelProperty(name = "listMete", value = "清单量")
   private BigDecimal listMete;
   @ApiModelProperty(name = "operateType", value = "操作类型")
   @EnumValidator(value = PlanOperationTypeEnum.class, message = "操作类型错误")
   private Integer operateType;

   public static PlanStockListDTO.PlanStockListDTOBuilder builder() {
      return new PlanStockListDTO.PlanStockListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getStockId() {
      return this.stockId;
   }

   public Long getSteelClassifyConfId() {
      return this.steelClassifyConfId;
   }

   public String getSteelClassifyConfName() {
      return this.steelClassifyConfName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getListMete() {
      return this.listMete;
   }

   public Integer getOperateType() {
      return this.operateType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStockId(final Long stockId) {
      this.stockId = stockId;
   }

   public void setSteelClassifyConfId(final Long steelClassifyConfId) {
      this.steelClassifyConfId = steelClassifyConfId;
   }

   public void setSteelClassifyConfName(final String steelClassifyConfName) {
      this.steelClassifyConfName = steelClassifyConfName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setListMete(final BigDecimal listMete) {
      this.listMete = listMete;
   }

   public void setOperateType(final Integer operateType) {
      this.operateType = operateType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanStockListDTO)) {
         return false;
      }

      PlanStockListDTO other = (PlanStockListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$stockId = this.getStockId();
         Object other$stockId = other.getStockId();
         if (this$stockId == null ? other$stockId == null : this$stockId.equals(other$stockId)) {
            Object this$steelClassifyConfId = this.getSteelClassifyConfId();
            Object other$steelClassifyConfId = other.getSteelClassifyConfId();
            if (this$steelClassifyConfId == null ? other$steelClassifyConfId == null : this$steelClassifyConfId.equals(other$steelClassifyConfId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$operateType = this.getOperateType();
                  Object other$operateType = other.getOperateType();
                  if (this$operateType == null ? other$operateType == null : this$operateType.equals(other$operateType)) {
                     Object this$steelClassifyConfName = this.getSteelClassifyConfName();
                     Object other$steelClassifyConfName = other.getSteelClassifyConfName();
                     if (this$steelClassifyConfName == null
                        ? other$steelClassifyConfName == null
                        : this$steelClassifyConfName.equals(other$steelClassifyConfName)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$listMete = this.getListMete();
                              Object other$listMete = other.getListMete();
                              return this$listMete == null ? other$listMete == null : this$listMete.equals(other$listMete);
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
      return other instanceof PlanStockListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $stockId = this.getStockId();
      result = result * 59 + ($stockId == null ? 43 : $stockId.hashCode());
      Object $steelClassifyConfId = this.getSteelClassifyConfId();
      result = result * 59 + ($steelClassifyConfId == null ? 43 : $steelClassifyConfId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $operateType = this.getOperateType();
      result = result * 59 + ($operateType == null ? 43 : $operateType.hashCode());
      Object $steelClassifyConfName = this.getSteelClassifyConfName();
      result = result * 59 + ($steelClassifyConfName == null ? 43 : $steelClassifyConfName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $listMete = this.getListMete();
      return result * 59 + ($listMete == null ? 43 : $listMete.hashCode());
   }

   @Override
   public String toString() {
      return "PlanStockListDTO(id="
         + this.getId()
         + ", stockId="
         + this.getStockId()
         + ", steelClassifyConfId="
         + this.getSteelClassifyConfId()
         + ", steelClassifyConfName="
         + this.getSteelClassifyConfName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", listMete="
         + this.getListMete()
         + ", operateType="
         + this.getOperateType()
         + ")";
   }

   public PlanStockListDTO() {
   }

   public PlanStockListDTO(
      final Long id,
      final Long stockId,
      final Long steelClassifyConfId,
      final String steelClassifyConfName,
      final Integer basicClass,
      final String specification,
      final String material,
      final BigDecimal listMete,
      final Integer operateType
   ) {
      this.id = id;
      this.stockId = stockId;
      this.steelClassifyConfId = steelClassifyConfId;
      this.steelClassifyConfName = steelClassifyConfName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.material = material;
      this.listMete = listMete;
      this.operateType = operateType;
   }

   public static class PlanStockListDTOBuilder {
      private Long id;
      private Long stockId;
      private Long steelClassifyConfId;
      private String steelClassifyConfName;
      private Integer basicClass;
      private String specification;
      private String material;
      private BigDecimal listMete;
      private Integer operateType;

      PlanStockListDTOBuilder() {
      }

      public PlanStockListDTO.PlanStockListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder stockId(final Long stockId) {
         this.stockId = stockId;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder steelClassifyConfId(final Long steelClassifyConfId) {
         this.steelClassifyConfId = steelClassifyConfId;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder steelClassifyConfName(final String steelClassifyConfName) {
         this.steelClassifyConfName = steelClassifyConfName;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder listMete(final BigDecimal listMete) {
         this.listMete = listMete;
         return this;
      }

      public PlanStockListDTO.PlanStockListDTOBuilder operateType(final Integer operateType) {
         this.operateType = operateType;
         return this;
      }

      public PlanStockListDTO build() {
         return new PlanStockListDTO(
            this.id,
            this.stockId,
            this.steelClassifyConfId,
            this.steelClassifyConfName,
            this.basicClass,
            this.specification,
            this.material,
            this.listMete,
            this.operateType
         );
      }

      @Override
      public String toString() {
         return "PlanStockListDTO.PlanStockListDTOBuilder(id="
            + this.id
            + ", stockId="
            + this.stockId
            + ", steelClassifyConfId="
            + this.steelClassifyConfId
            + ", steelClassifyConfName="
            + this.steelClassifyConfName
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", listMete="
            + this.listMete
            + ", operateType="
            + this.operateType
            + ")";
      }
   }
}
