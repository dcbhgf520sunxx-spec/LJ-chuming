package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingMachinePartSeparateDO", description = " ")
public class MesBuildingMachinePartSeparateDO {
   @ApiModelProperty(name = "id", notes = "零件id", value = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "monomerId", notes = "单体id", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域Id", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "workShopId", notes = "工厂id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "工厂名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "groupId", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "groupName", value = "生产组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "boolDrillEnum", value = "是否分配到钻孔")
   @JsonProperty("boolDrillEnum")
   @JSONField(name = "boolDrillEnum")
   private Boolean boolDrillEnum;

   public static MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder builder() {
      return new MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder();
   }

   public MesBuildingMachinePartSeparateDO() {
   }

   public MesBuildingMachinePartSeparateDO(
      final Long id,
      final String serialNumber,
      final Long monomerId,
      final Long areaId,
      final Long workShopId,
      final String workShopName,
      final Long productionLineId,
      final String productionLineName,
      final Integer quantity,
      final Long groupId,
      final String groupName,
      final Boolean boolDrillEnum
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.quantity = quantity;
      this.groupId = groupId;
      this.groupName = groupName;
      this.boolDrillEnum = boolDrillEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Boolean getBoolDrillEnum() {
      return this.boolDrillEnum;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSeparateDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingMachinePartSeparateDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingMachinePartSeparateDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingMachinePartSeparateDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingMachinePartSeparateDO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public MesBuildingMachinePartSeparateDO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartSeparateDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingMachinePartSeparateDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSeparateDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("groupId")
   public MesBuildingMachinePartSeparateDO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("groupName")
   public MesBuildingMachinePartSeparateDO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("boolDrillEnum")
   public MesBuildingMachinePartSeparateDO setBoolDrillEnum(final Boolean boolDrillEnum) {
      this.boolDrillEnum = boolDrillEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSeparateDO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", quantity="
         + this.getQuantity()
         + ", groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", boolDrillEnum="
         + this.getBoolDrillEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSeparateDO)) {
         return false;
      }

      MesBuildingMachinePartSeparateDO other = (MesBuildingMachinePartSeparateDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$workShopId = this.getWorkShopId();
               Object other$workShopId = other.getWorkShopId();
               if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$groupId = this.getGroupId();
                        Object other$groupId = other.getGroupId();
                        if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
                           Object this$boolDrillEnum = this.getBoolDrillEnum();
                           Object other$boolDrillEnum = other.getBoolDrillEnum();
                           if (this$boolDrillEnum == null ? other$boolDrillEnum == null : this$boolDrillEnum.equals(other$boolDrillEnum)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$workShopName = this.getWorkShopName();
                                 Object other$workShopName = other.getWorkShopName();
                                 if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                                    Object this$productionLineName = this.getProductionLineName();
                                    Object other$productionLineName = other.getProductionLineName();
                                    if (this$productionLineName == null
                                       ? other$productionLineName == null
                                       : this$productionLineName.equals(other$productionLineName)) {
                                       Object this$groupName = this.getGroupName();
                                       Object other$groupName = other.getGroupName();
                                       return this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName);
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
      return other instanceof MesBuildingMachinePartSeparateDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $boolDrillEnum = this.getBoolDrillEnum();
      result = result * 59 + ($boolDrillEnum == null ? 43 : $boolDrillEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $groupName = this.getGroupName();
      return result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
   }

   public static class MesBuildingMachinePartSeparateDOBuilder {
      private Long id;
      private String serialNumber;
      private Long monomerId;
      private Long areaId;
      private Long workShopId;
      private String workShopName;
      private Long productionLineId;
      private String productionLineName;
      private Integer quantity;
      private Long groupId;
      private String groupName;
      private Boolean boolDrillEnum;

      MesBuildingMachinePartSeparateDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("workShopName")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("groupId")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("groupName")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("boolDrillEnum")
      public MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder boolDrillEnum(final Boolean boolDrillEnum) {
         this.boolDrillEnum = boolDrillEnum;
         return this;
      }

      public MesBuildingMachinePartSeparateDO build() {
         return new MesBuildingMachinePartSeparateDO(
            this.id,
            this.serialNumber,
            this.monomerId,
            this.areaId,
            this.workShopId,
            this.workShopName,
            this.productionLineId,
            this.productionLineName,
            this.quantity,
            this.groupId,
            this.groupName,
            this.boolDrillEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSeparateDO.MesBuildingMachinePartSeparateDOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", quantity="
            + this.quantity
            + ", groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", boolDrillEnum="
            + this.boolDrillEnum
            + ")";
      }
   }
}
