package com.hzchum.scim.scm.core.api.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AreaDTO {
   private Long id;
   private String name;
   private String axis;
   private String monomerName;
   private BigDecimal mete;
   private BigDecimal totalArea;
   private Integer productType;
   private boolean boolGenerateOrder;
   private Integer modelType;
   private LocalDateTime completeDate;
   private List<ArtifactAndAssembleDTO> detailList;

   public static AreaDTO.AreaDTOBuilder builder() {
      return new AreaDTO.AreaDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAxis() {
      return this.axis;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public boolean isBoolGenerateOrder() {
      return this.boolGenerateOrder;
   }

   public Integer getModelType() {
      return this.modelType;
   }

   public LocalDateTime getCompleteDate() {
      return this.completeDate;
   }

   public List<ArtifactAndAssembleDTO> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setBoolGenerateOrder(final boolean boolGenerateOrder) {
      this.boolGenerateOrder = boolGenerateOrder;
   }

   public void setModelType(final Integer modelType) {
      this.modelType = modelType;
   }

   public void setCompleteDate(final LocalDateTime completeDate) {
      this.completeDate = completeDate;
   }

   public void setDetailList(final List<ArtifactAndAssembleDTO> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaDTO)) {
         return false;
      }

      AreaDTO other = (AreaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolGenerateOrder() != other.isBoolGenerateOrder()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$modelType = this.getModelType();
            Object other$modelType = other.getModelType();
            if (this$modelType == null ? other$modelType == null : this$modelType.equals(other$modelType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$axis = this.getAxis();
                  Object other$axis = other.getAxis();
                  if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$totalArea = this.getTotalArea();
                           Object other$totalArea = other.getTotalArea();
                           if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                              Object this$completeDate = this.getCompleteDate();
                              Object other$completeDate = other.getCompleteDate();
                              if (this$completeDate == null ? other$completeDate == null : this$completeDate.equals(other$completeDate)) {
                                 Object this$detailList = this.getDetailList();
                                 Object other$detailList = other.getDetailList();
                                 return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof AreaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolGenerateOrder() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $modelType = this.getModelType();
      result = result * 59 + ($modelType == null ? 43 : $modelType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "AreaDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", axis="
         + this.getAxis()
         + ", monomerName="
         + this.getMonomerName()
         + ", mete="
         + this.getMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", productType="
         + this.getProductType()
         + ", boolGenerateOrder="
         + this.isBoolGenerateOrder()
         + ", modelType="
         + this.getModelType()
         + ", completeDate="
         + this.getCompleteDate()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public AreaDTO(
      final Long id,
      final String name,
      final String axis,
      final String monomerName,
      final BigDecimal mete,
      final BigDecimal totalArea,
      final Integer productType,
      final boolean boolGenerateOrder,
      final Integer modelType,
      final LocalDateTime completeDate,
      final List<ArtifactAndAssembleDTO> detailList
   ) {
      this.id = id;
      this.name = name;
      this.axis = axis;
      this.monomerName = monomerName;
      this.mete = mete;
      this.totalArea = totalArea;
      this.productType = productType;
      this.boolGenerateOrder = boolGenerateOrder;
      this.modelType = modelType;
      this.completeDate = completeDate;
      this.detailList = detailList;
   }

   public AreaDTO() {
   }

   public static class AreaDTOBuilder {
      private Long id;
      private String name;
      private String axis;
      private String monomerName;
      private BigDecimal mete;
      private BigDecimal totalArea;
      private Integer productType;
      private boolean boolGenerateOrder;
      private Integer modelType;
      private LocalDateTime completeDate;
      private List<ArtifactAndAssembleDTO> detailList;

      AreaDTOBuilder() {
      }

      public AreaDTO.AreaDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AreaDTO.AreaDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AreaDTO.AreaDTOBuilder axis(final String axis) {
         this.axis = axis;
         return this;
      }

      public AreaDTO.AreaDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public AreaDTO.AreaDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public AreaDTO.AreaDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public AreaDTO.AreaDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public AreaDTO.AreaDTOBuilder boolGenerateOrder(final boolean boolGenerateOrder) {
         this.boolGenerateOrder = boolGenerateOrder;
         return this;
      }

      public AreaDTO.AreaDTOBuilder modelType(final Integer modelType) {
         this.modelType = modelType;
         return this;
      }

      public AreaDTO.AreaDTOBuilder completeDate(final LocalDateTime completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      public AreaDTO.AreaDTOBuilder detailList(final List<ArtifactAndAssembleDTO> detailList) {
         this.detailList = detailList;
         return this;
      }

      public AreaDTO build() {
         return new AreaDTO(
            this.id,
            this.name,
            this.axis,
            this.monomerName,
            this.mete,
            this.totalArea,
            this.productType,
            this.boolGenerateOrder,
            this.modelType,
            this.completeDate,
            this.detailList
         );
      }

      @Override
      public String toString() {
         return "AreaDTO.AreaDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", axis="
            + this.axis
            + ", monomerName="
            + this.monomerName
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ", productType="
            + this.productType
            + ", boolGenerateOrder="
            + this.boolGenerateOrder
            + ", modelType="
            + this.modelType
            + ", completeDate="
            + this.completeDate
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
