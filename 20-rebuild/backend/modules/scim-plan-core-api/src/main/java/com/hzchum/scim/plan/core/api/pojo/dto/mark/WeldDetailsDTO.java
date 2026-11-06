package com.hzchum.scim.plan.core.api.pojo.dto.mark;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "WeldDetailsDTO", description = "单体焊缝详细信息")
public class WeldDetailsDTO {
   @Excel(name = "序号", orderNum = "0")
   private int index;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名")
   private String areaName;
   @ApiModelProperty(name = "monId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monName", value = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件 2构件 16组立")
   private Integer productType;
   @ApiModelProperty("产品id")
   private String productId;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   private Integer dataType;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "sign", value = "是否有焊缝")
   private Integer sign;
   @ApiModelProperty(name = "createUser", value = "操作人")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "specification", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "createTime", value = "最后修改时间")
   private LocalDateTime updateTime;
   @ApiModelProperty(name = "weldIds", value = "焊缝ids")
   private List<Long> weldIds;

   public static WeldDetailsDTO.WeldDetailsDTOBuilder builder() {
      return new WeldDetailsDTO.WeldDetailsDTOBuilder();
   }

   public WeldDetailsDTO() {
   }

   public WeldDetailsDTO(
      final int index,
      final Long projectId,
      final Long areaId,
      final String areaName,
      final Long monomerId,
      final String monomerName,
      final Integer productType,
      final String productId,
      final String serialNumber,
      final Integer dataType,
      final Integer quantity,
      final Integer sign,
      final String userName,
      final LocalDateTime createTime,
      final String specification,
      final LocalDateTime updateTime,
      final List<Long> weldIds
   ) {
      this.index = index;
      this.projectId = projectId;
      this.areaId = areaId;
      this.areaName = areaName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.productType = productType;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.dataType = dataType;
      this.quantity = quantity;
      this.sign = sign;
      this.userName = userName;
      this.createTime = createTime;
      this.specification = specification;
      this.updateTime = updateTime;
      this.weldIds = weldIds;
   }

   public int getIndex() {
      return this.index;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSign() {
      return this.sign;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSpecification() {
      return this.specification;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public List<Long> getWeldIds() {
      return this.weldIds;
   }

   public void setIndex(final int index) {
      this.index = index;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final String productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSign(final Integer sign) {
      this.sign = sign;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setWeldIds(final List<Long> weldIds) {
      this.weldIds = weldIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeldDetailsDTO)) {
         return false;
      }

      WeldDetailsDTO other = (WeldDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getIndex() != other.getIndex()) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$dataType = this.getDataType();
                  Object other$dataType = other.getDataType();
                  if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$sign = this.getSign();
                        Object other$sign = other.getSign();
                        if (this$sign == null ? other$sign == null : this$sign.equals(other$sign)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$monomerName = this.getMonomerName();
                              Object other$monomerName = other.getMonomerName();
                              if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$updateTime = this.getUpdateTime();
                                                Object other$updateTime = other.getUpdateTime();
                                                if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                                   Object this$weldIds = this.getWeldIds();
                                                   Object other$weldIds = other.getWeldIds();
                                                   return this$weldIds == null ? other$weldIds == null : this$weldIds.equals(other$weldIds);
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
      return other instanceof WeldDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getIndex();
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sign = this.getSign();
      result = result * 59 + ($sign == null ? 43 : $sign.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $weldIds = this.getWeldIds();
      return result * 59 + ($weldIds == null ? 43 : $weldIds.hashCode());
   }

   @Override
   public String toString() {
      return "WeldDetailsDTO(index="
         + this.getIndex()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", dataType="
         + this.getDataType()
         + ", quantity="
         + this.getQuantity()
         + ", sign="
         + this.getSign()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", specification="
         + this.getSpecification()
         + ", updateTime="
         + this.getUpdateTime()
         + ", weldIds="
         + this.getWeldIds()
         + ")";
   }

   public static class WeldDetailsDTOBuilder {
      private int index;
      private Long projectId;
      private Long areaId;
      private String areaName;
      private Long monomerId;
      private String monomerName;
      private Integer productType;
      private String productId;
      private String serialNumber;
      private Integer dataType;
      private Integer quantity;
      private Integer sign;
      private String userName;
      private LocalDateTime createTime;
      private String specification;
      private LocalDateTime updateTime;
      private List<Long> weldIds;

      WeldDetailsDTOBuilder() {
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder index(final int index) {
         this.index = index;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder productId(final String productId) {
         this.productId = productId;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder sign(final Integer sign) {
         this.sign = sign;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public WeldDetailsDTO.WeldDetailsDTOBuilder weldIds(final List<Long> weldIds) {
         this.weldIds = weldIds;
         return this;
      }

      public WeldDetailsDTO build() {
         return new WeldDetailsDTO(
            this.index,
            this.projectId,
            this.areaId,
            this.areaName,
            this.monomerId,
            this.monomerName,
            this.productType,
            this.productId,
            this.serialNumber,
            this.dataType,
            this.quantity,
            this.sign,
            this.userName,
            this.createTime,
            this.specification,
            this.updateTime,
            this.weldIds
         );
      }

      @Override
      public String toString() {
         return "WeldDetailsDTO.WeldDetailsDTOBuilder(index="
            + this.index
            + ", projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", dataType="
            + this.dataType
            + ", quantity="
            + this.quantity
            + ", sign="
            + this.sign
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ", specification="
            + this.specification
            + ", updateTime="
            + this.updateTime
            + ", weldIds="
            + this.weldIds
            + ")";
      }
   }
}
