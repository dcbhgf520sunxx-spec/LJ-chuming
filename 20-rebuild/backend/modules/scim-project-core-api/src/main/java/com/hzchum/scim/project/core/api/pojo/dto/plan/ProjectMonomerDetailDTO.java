package com.hzchum.scim.project.core.api.pojo.dto.plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("单体详情")
public class ProjectMonomerDetailDTO {
   @ApiModelProperty(name = "id", value = "详情ID")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "type", value = "类型 产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件")
   private Integer type;
   @ApiModelProperty(name = "date", value = "计划完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "mete", value = "计划量(t/m) ")
   private BigDecimal mete;
   @ApiModelProperty("清单数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "deepenMete", value = "深化量/清单量(t/m) ")
   private BigDecimal deepenMete;
   @ApiModelProperty(name = "startDate", value = "总计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "总计划结束日期")
   private LocalDate endDate;
   @ApiModelProperty("区域列表")
   private List<ProjectAreaDTO> areaList;

   public static ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder builder() {
      return new ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder();
   }

   public ProjectMonomerDetailDTO() {
   }

   public ProjectMonomerDetailDTO(
      final Long id,
      final Long monomerId,
      final Integer type,
      final LocalDate date,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal deepenMete,
      final LocalDate startDate,
      final LocalDate endDate,
      final List<ProjectAreaDTO> areaList
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.type = type;
      this.date = date;
      this.mete = mete;
      this.quantity = quantity;
      this.deepenMete = deepenMete;
      this.startDate = startDate;
      this.endDate = endDate;
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

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
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

   public List<ProjectAreaDTO> getAreaList() {
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

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final BigDecimal quantity) {
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

   public void setAreaList(final List<ProjectAreaDTO> areaList) {
      this.areaList = areaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMonomerDetailDTO)) {
         return false;
      }

      ProjectMonomerDetailDTO other = (ProjectMonomerDetailDTO)o;
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
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$deepenMete = this.getDeepenMete();
                        Object other$deepenMete = other.getDeepenMete();
                        if (this$deepenMete == null ? other$deepenMete == null : this$deepenMete.equals(other$deepenMete)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$endDate = this.getEndDate();
                              Object other$endDate = other.getEndDate();
                              if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectMonomerDetailDTO;
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
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $deepenMete = this.getDeepenMete();
      result = result * 59 + ($deepenMete == null ? 43 : $deepenMete.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $areaList = this.getAreaList();
      return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMonomerDetailDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", type="
         + this.getType()
         + ", date="
         + this.getDate()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", deepenMete="
         + this.getDeepenMete()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", areaList="
         + this.getAreaList()
         + ")";
   }

   public static class ProjectMonomerDetailDTOBuilder {
      private Long id;
      private Long monomerId;
      private Integer type;
      private LocalDate date;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal deepenMete;
      private LocalDate startDate;
      private LocalDate endDate;
      private List<ProjectAreaDTO> areaList;

      ProjectMonomerDetailDTOBuilder() {
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder deepenMete(final BigDecimal deepenMete) {
         this.deepenMete = deepenMete;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder areaList(final List<ProjectAreaDTO> areaList) {
         this.areaList = areaList;
         return this;
      }

      public ProjectMonomerDetailDTO build() {
         return new ProjectMonomerDetailDTO(
            this.id, this.monomerId, this.type, this.date, this.mete, this.quantity, this.deepenMete, this.startDate, this.endDate, this.areaList
         );
      }

      @Override
      public String toString() {
         return "ProjectMonomerDetailDTO.ProjectMonomerDetailDTOBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", type="
            + this.type
            + ", date="
            + this.date
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", deepenMete="
            + this.deepenMete
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", areaList="
            + this.areaList
            + ")";
      }
   }
}
