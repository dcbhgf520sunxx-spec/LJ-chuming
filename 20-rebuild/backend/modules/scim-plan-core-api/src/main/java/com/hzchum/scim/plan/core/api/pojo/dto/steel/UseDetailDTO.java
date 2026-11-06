package com.hzchum.scim.plan.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UseDetailDTO {
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("厚度/规格")
   private String thickness;
   @ApiModelProperty("配置id")
   private String configId;
   @ApiModelProperty("重量")
   private BigDecimal mete;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("办理人")
   private String reviewerName;
   @ApiModelProperty("领用人")
   private String userName;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("车间名")
   private String workshopName;
   @ApiModelProperty("时间")
   private LocalDateTime time;
   @ApiModelProperty("长度")
   private BigDecimal length;
   @ApiModelProperty("宽度")
   private BigDecimal width;

   public static UseDetailDTO.UseDetailDTOBuilder builder() {
      return new UseDetailDTO.UseDetailDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getConfigId() {
      return this.configId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setConfigId(final String configId) {
      this.configId = configId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setTime(final LocalDateTime time) {
      this.time = time;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UseDetailDTO)) {
         return false;
      }

      UseDetailDTO other = (UseDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$configId = this.getConfigId();
                     Object other$configId = other.getConfigId();
                     if (this$configId == null ? other$configId == null : this$configId.equals(other$configId)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$reviewerName = this.getReviewerName();
                           Object other$reviewerName = other.getReviewerName();
                           if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$workshopName = this.getWorkshopName();
                                 Object other$workshopName = other.getWorkshopName();
                                 if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                    Object this$time = this.getTime();
                                    Object other$time = other.getTime();
                                    if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          return this$width == null ? other$width == null : this$width.equals(other$width);
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
      return other instanceof UseDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $configId = this.getConfigId();
      result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      return result * 59 + ($width == null ? 43 : $width.hashCode());
   }

   @Override
   public String toString() {
      return "UseDetailDTO(name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", configId="
         + this.getConfigId()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", reviewerName="
         + this.getReviewerName()
         + ", userName="
         + this.getUserName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", time="
         + this.getTime()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ")";
   }

   public UseDetailDTO(
      final String name,
      final String material,
      final String thickness,
      final String configId,
      final BigDecimal mete,
      final Integer quantity,
      final String reviewerName,
      final String userName,
      final Long workshopId,
      final String workshopName,
      final LocalDateTime time,
      final BigDecimal length,
      final BigDecimal width
   ) {
      this.name = name;
      this.material = material;
      this.thickness = thickness;
      this.configId = configId;
      this.mete = mete;
      this.quantity = quantity;
      this.reviewerName = reviewerName;
      this.userName = userName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.time = time;
      this.length = length;
      this.width = width;
   }

   public UseDetailDTO() {
   }

   public static class UseDetailDTOBuilder {
      private String name;
      private String material;
      private String thickness;
      private String configId;
      private BigDecimal mete;
      private Integer quantity;
      private String reviewerName;
      private String userName;
      private Long workshopId;
      private String workshopName;
      private LocalDateTime time;
      private BigDecimal length;
      private BigDecimal width;

      UseDetailDTOBuilder() {
      }

      public UseDetailDTO.UseDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder configId(final String configId) {
         this.configId = configId;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder time(final LocalDateTime time) {
         this.time = time;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public UseDetailDTO.UseDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public UseDetailDTO build() {
         return new UseDetailDTO(
            this.name,
            this.material,
            this.thickness,
            this.configId,
            this.mete,
            this.quantity,
            this.reviewerName,
            this.userName,
            this.workshopId,
            this.workshopName,
            this.time,
            this.length,
            this.width
         );
      }

      @Override
      public String toString() {
         return "UseDetailDTO.UseDetailDTOBuilder(name="
            + this.name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", configId="
            + this.configId
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", reviewerName="
            + this.reviewerName
            + ", userName="
            + this.userName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", time="
            + this.time
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ")";
      }
   }
}
