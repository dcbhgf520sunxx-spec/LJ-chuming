package com.hzchum.scim.bim.core.api.pojo.vo;

import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("bim集成模型模型返回类VO")
public class BimModelFileMonomerVO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "fileId", value = "单体模型文件id")
   private Long fileId;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("构件基础信息")
   List<BimArtifactStatusDetailVO> basicsVOS;

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getFileId() {
      return this.fileId;
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

   public List<BimArtifactStatusDetailVO> getBasicsVOS() {
      return this.basicsVOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setFileId(final Long fileId) {
      this.fileId = fileId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setBasicsVOS(final List<BimArtifactStatusDetailVO> basicsVOS) {
      this.basicsVOS = basicsVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelFileMonomerVO)) {
         return false;
      }

      BimModelFileMonomerVO other = (BimModelFileMonomerVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$fileId = this.getFileId();
            Object other$fileId = other.getFileId();
            if (this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                           Object this$basicsVOS = this.getBasicsVOS();
                           Object other$basicsVOS = other.getBasicsVOS();
                           return this$basicsVOS == null ? other$basicsVOS == null : this$basicsVOS.equals(other$basicsVOS);
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
      return other instanceof BimModelFileMonomerVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $fileId = this.getFileId();
      result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $basicsVOS = this.getBasicsVOS();
      return result * 59 + ($basicsVOS == null ? 43 : $basicsVOS.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelFileMonomerVO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", fileId="
         + this.getFileId()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", basicsVOS="
         + this.getBasicsVOS()
         + ")";
   }
}
