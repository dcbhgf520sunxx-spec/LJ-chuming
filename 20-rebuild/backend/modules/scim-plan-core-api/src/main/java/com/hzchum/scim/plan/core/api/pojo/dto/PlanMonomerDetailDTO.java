package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("单体详情")
public class PlanMonomerDetailDTO {
   @ApiModelProperty(name = "id", value = "详情ID")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "type", value = "类型 产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件 64配套件 128箱体件")
   private Integer type;
   @ApiModelProperty(name = "productCategory", notes = "单体产品类型 2构件 4围护 8配套件 16箱体件")
   private Integer productCategory;
   @ApiModelProperty(name = "date", value = "计划完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "mete", value = "计划量(t/m) ")
   private BigDecimal mete;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("清单数量")
   private Integer quantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "deepenMete", value = "深化量/清单量(t/m) ")
   private BigDecimal deepenMete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "startDate", value = "总计划开始日期")
   private LocalDate startDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "endDate", value = "总计划结束日期")
   private LocalDate endDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("单体详情计划列表")
   private List<PlanDetailTraceDTO> detailTraceList;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("区域列表")
   private List<PlanAreaDTO> areaList;

   public static PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder builder() {
      return new PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder();
   }

   public PlanMonomerDetailDTO() {
   }

   public PlanMonomerDetailDTO(
      final Long id,
      final Long monomerId,
      final Integer type,
      final Integer productCategory,
      final LocalDate date,
      final BigDecimal mete,
      final String remark,
      final Integer quantity,
      final BigDecimal deepenMete,
      final LocalDate startDate,
      final LocalDate endDate,
      final List<PlanDetailTraceDTO> detailTraceList,
      final List<PlanAreaDTO> areaList
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.type = type;
      this.productCategory = productCategory;
      this.date = date;
      this.mete = mete;
      this.remark = remark;
      this.quantity = quantity;
      this.deepenMete = deepenMete;
      this.startDate = startDate;
      this.endDate = endDate;
      this.detailTraceList = detailTraceList;
      this.areaList = areaList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getDeepenMete() {
      return this.deepenMete;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public List<PlanDetailTraceDTO> getDetailTraceList() {
      return this.detailTraceList;
   }

   public List<PlanAreaDTO> getAreaList() {
      return this.areaList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setDeepenMete(final BigDecimal deepenMete) {
      this.deepenMete = deepenMete;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setDetailTraceList(final List<PlanDetailTraceDTO> detailTraceList) {
      this.detailTraceList = detailTraceList;
   }

   public void setAreaList(final List<PlanAreaDTO> areaList) {
      this.areaList = areaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerDetailDTO)) {
         return false;
      }

      PlanMonomerDetailDTO other = (PlanMonomerDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$productCategory = this.getProductCategory();
               Object other$productCategory = other.getProductCategory();
               if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$date = this.getDate();
                     Object other$date = other.getDate();
                     if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$deepenMete = this.getDeepenMete();
                              Object other$deepenMete = other.getDeepenMete();
                              if (this$deepenMete == null ? other$deepenMete == null : this$deepenMete.equals(other$deepenMete)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                       Object this$detailTraceList = this.getDetailTraceList();
                                       Object other$detailTraceList = other.getDetailTraceList();
                                       if (this$detailTraceList == null ? other$detailTraceList == null : this$detailTraceList.equals(other$detailTraceList)) {
                                          Object this$areaList = this.getAreaList();
                                          Object other$areaList = other.getAreaList();
                                          return this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList);
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
      return other instanceof PlanMonomerDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $deepenMete = this.getDeepenMete();
      result = result * 59 + ($deepenMete == null ? 43 : $deepenMete.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $detailTraceList = this.getDetailTraceList();
      result = result * 59 + ($detailTraceList == null ? 43 : $detailTraceList.hashCode());
      Object $areaList = this.getAreaList();
      return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerDetailDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", type="
         + this.getType()
         + ", productCategory="
         + this.getProductCategory()
         + ", date="
         + this.getDate()
         + ", mete="
         + this.getMete()
         + ", remark="
         + this.getRemark()
         + ", quantity="
         + this.getQuantity()
         + ", deepenMete="
         + this.getDeepenMete()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", detailTraceList="
         + this.getDetailTraceList()
         + ", areaList="
         + this.getAreaList()
         + ")";
   }

   public static class PlanMonomerDetailDTOBuilder {
      private Long id;
      private Long monomerId;
      private Integer type;
      private Integer productCategory;
      private LocalDate date;
      private BigDecimal mete;
      private String remark;
      private Integer quantity;
      private BigDecimal deepenMete;
      private LocalDate startDate;
      private LocalDate endDate;
      private List<PlanDetailTraceDTO> detailTraceList;
      private List<PlanAreaDTO> areaList;

      PlanMonomerDetailDTOBuilder() {
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder deepenMete(final BigDecimal deepenMete) {
         this.deepenMete = deepenMete;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder detailTraceList(final List<PlanDetailTraceDTO> detailTraceList) {
         this.detailTraceList = detailTraceList;
         return this;
      }

      public PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder areaList(final List<PlanAreaDTO> areaList) {
         this.areaList = areaList;
         return this;
      }

      public PlanMonomerDetailDTO build() {
         return new PlanMonomerDetailDTO(
            this.id,
            this.monomerId,
            this.type,
            this.productCategory,
            this.date,
            this.mete,
            this.remark,
            this.quantity,
            this.deepenMete,
            this.startDate,
            this.endDate,
            this.detailTraceList,
            this.areaList
         );
      }

      @Override
      public String toString() {
         return "PlanMonomerDetailDTO.PlanMonomerDetailDTOBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", type="
            + this.type
            + ", productCategory="
            + this.productCategory
            + ", date="
            + this.date
            + ", mete="
            + this.mete
            + ", remark="
            + this.remark
            + ", quantity="
            + this.quantity
            + ", deepenMete="
            + this.deepenMete
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", detailTraceList="
            + this.detailTraceList
            + ", areaList="
            + this.areaList
            + ")";
      }
   }
}
