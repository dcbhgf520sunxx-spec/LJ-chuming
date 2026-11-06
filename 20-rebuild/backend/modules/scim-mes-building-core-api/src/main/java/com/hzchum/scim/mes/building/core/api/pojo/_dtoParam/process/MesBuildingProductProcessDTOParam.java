package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingProductProcessDTOParam", description = "")
public class MesBuildingProductProcessDTOParam {
   @ApiModelProperty(name = "typeId", notes = "类型id")
   @JsonProperty("typeId")
   @JSONField(name = "typeId")
   private Long typeId;
   @ApiModelProperty(name = "shopId", value = "车间id", notes = "车间id")
   @JsonProperty("shopId")
   @JSONField(name = "shopId")
   @NotNull(message = "车间id不能为空")
   private Long shopId;
   @ApiModelProperty(name = "shopName", value = "车间名", notes = "车间名")
   @JsonProperty("shopName")
   @JSONField(name = "shopName")
   private String shopName;
   @ApiModelProperty(name = "lineId", value = "'产线id'", notes = "'产线id'")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   @NotNull(message = "产线id不能为空")
   private Long lineId;
   @ApiModelProperty(name = "lineName", value = "产线名", notes = "产线名")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "classId", notes = "类型id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   @NotNull(message = "类型id不能为空")
   private Long classId;
   @ApiModelProperty(name = "className", notes = "类型名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private Long className;
   @ApiModelProperty(name = "productType", notes = "产品类型 [1箱体 2单元件 4零件]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "productType不能为空")
   private Integer productType;
   @ApiModelProperty(name = "processLinkList", notes = "工序")
   @JsonProperty("processLinkList")
   @JSONField(name = "processLinkList")
   @NotNull(message = "传递工序不能存在空选项")
   private List<MesBuildingProductProcessLinkDTOParam> processLinkList;

   public static MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder builder() {
      return new MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder();
   }

   public MesBuildingProductProcessDTOParam() {
   }

   public MesBuildingProductProcessDTOParam(
      final Long typeId,
      final Long shopId,
      final String shopName,
      final Long lineId,
      final String lineName,
      final Long classId,
      final Long className,
      final Integer productType,
      final List<MesBuildingProductProcessLinkDTOParam> processLinkList
   ) {
      this.typeId = typeId;
      this.shopId = shopId;
      this.shopName = shopName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.classId = classId;
      this.className = className;
      this.productType = productType;
      this.processLinkList = processLinkList;
   }

   public Long getTypeId() {
      return this.typeId;
   }

   public Long getShopId() {
      return this.shopId;
   }

   public String getShopName() {
      return this.shopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getClassName() {
      return this.className;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<MesBuildingProductProcessLinkDTOParam> getProcessLinkList() {
      return this.processLinkList;
   }

   @JsonProperty("typeId")
   public MesBuildingProductProcessDTOParam setTypeId(final Long typeId) {
      this.typeId = typeId;
      return this;
   }

   @JsonProperty("shopId")
   public MesBuildingProductProcessDTOParam setShopId(final Long shopId) {
      this.shopId = shopId;
      return this;
   }

   @JsonProperty("shopName")
   public MesBuildingProductProcessDTOParam setShopName(final String shopName) {
      this.shopName = shopName;
      return this;
   }

   @JsonProperty("lineId")
   public MesBuildingProductProcessDTOParam setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public MesBuildingProductProcessDTOParam setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("classId")
   public MesBuildingProductProcessDTOParam setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("className")
   public MesBuildingProductProcessDTOParam setClassName(final Long className) {
      this.className = className;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("processLinkList")
   public MesBuildingProductProcessDTOParam setProcessLinkList(final List<MesBuildingProductProcessLinkDTOParam> processLinkList) {
      this.processLinkList = processLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessDTOParam(typeId="
         + this.getTypeId()
         + ", shopId="
         + this.getShopId()
         + ", shopName="
         + this.getShopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", classId="
         + this.getClassId()
         + ", className="
         + this.getClassName()
         + ", productType="
         + this.getProductType()
         + ", processLinkList="
         + this.getProcessLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessDTOParam)) {
         return false;
      }

      MesBuildingProductProcessDTOParam other = (MesBuildingProductProcessDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeId = this.getTypeId();
      Object other$typeId = other.getTypeId();
      if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
         Object this$shopId = this.getShopId();
         Object other$shopId = other.getShopId();
         if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
            Object this$lineId = this.getLineId();
            Object other$lineId = other.getLineId();
            if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
               Object this$classId = this.getClassId();
               Object other$classId = other.getClassId();
               if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                  Object this$className = this.getClassName();
                  Object other$className = other.getClassName();
                  if (this$className == null ? other$className == null : this$className.equals(other$className)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$shopName = this.getShopName();
                        Object other$shopName = other.getShopName();
                        if (this$shopName == null ? other$shopName == null : this$shopName.equals(other$shopName)) {
                           Object this$lineName = this.getLineName();
                           Object other$lineName = other.getLineName();
                           if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                              Object this$processLinkList = this.getProcessLinkList();
                              Object other$processLinkList = other.getProcessLinkList();
                              return this$processLinkList == null ? other$processLinkList == null : this$processLinkList.equals(other$processLinkList);
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
      return other instanceof MesBuildingProductProcessDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $shopName = this.getShopName();
      result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $processLinkList = this.getProcessLinkList();
      return result * 59 + ($processLinkList == null ? 43 : $processLinkList.hashCode());
   }

   public static class MesBuildingProductProcessDTOParamBuilder {
      private Long typeId;
      private Long shopId;
      private String shopName;
      private Long lineId;
      private String lineName;
      private Long classId;
      private Long className;
      private Integer productType;
      private List<MesBuildingProductProcessLinkDTOParam> processLinkList;

      MesBuildingProductProcessDTOParamBuilder() {
      }

      @JsonProperty("typeId")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder typeId(final Long typeId) {
         this.typeId = typeId;
         return this;
      }

      @JsonProperty("shopId")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder shopId(final Long shopId) {
         this.shopId = shopId;
         return this;
      }

      @JsonProperty("shopName")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder shopName(final String shopName) {
         this.shopName = shopName;
         return this;
      }

      @JsonProperty("lineId")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("classId")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("className")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder className(final Long className) {
         this.className = className;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processLinkList")
      public MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder processLinkList(
         final List<MesBuildingProductProcessLinkDTOParam> processLinkList
      ) {
         this.processLinkList = processLinkList;
         return this;
      }

      public MesBuildingProductProcessDTOParam build() {
         return new MesBuildingProductProcessDTOParam(
            this.typeId, this.shopId, this.shopName, this.lineId, this.lineName, this.classId, this.className, this.productType, this.processLinkList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessDTOParam.MesBuildingProductProcessDTOParamBuilder(typeId="
            + this.typeId
            + ", shopId="
            + this.shopId
            + ", shopName="
            + this.shopName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", classId="
            + this.classId
            + ", className="
            + this.className
            + ", productType="
            + this.productType
            + ", processLinkList="
            + this.processLinkList
            + ")";
      }
   }
}
