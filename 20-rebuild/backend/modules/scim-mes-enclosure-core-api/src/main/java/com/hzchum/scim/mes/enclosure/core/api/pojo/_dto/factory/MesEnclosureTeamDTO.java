package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesEnclosureTeamDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "productionLineId", notes = "产线id", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionName", notes = "产线名", value = "产线名")
   @JsonProperty("productionName")
   @JSONField(name = "productionName")
   private String productionName;
   @ApiModelProperty(name = "userId", notes = "用户id", value = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
   @ApiModelProperty(name = "userLinkList", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinkList")
   @JSONField(name = "userLinkList")
   private List<MesEnclosureTeamUserLinkDTO> userLinks;
   @ApiModelProperty(name = "price", value = "工价 每米")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder builder() {
      return new MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder();
   }

   public MesEnclosureTeamDTO() {
   }

   public MesEnclosureTeamDTO(
      final Long id,
      final Long processId,
      final String processName,
      final Long factoryId,
      final Long productionLineId,
      final String productionName,
      final Long userId,
      final Integer wageQuotaType,
      final Boolean hasMen,
      final List<MesEnclosureTeamUserLinkDTO> userLinks,
      final BigDecimal price
   ) {
      this.id = id;
      this.processId = processId;
      this.processName = processName;
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.productionName = productionName;
      this.userId = userId;
      this.wageQuotaType = wageQuotaType;
      this.hasMen = hasMen;
      this.userLinks = userLinks;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionName() {
      return this.productionName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
   }

   public List<MesEnclosureTeamUserLinkDTO> getUserLinks() {
      return this.userLinks;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesEnclosureTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesEnclosureTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTeamDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTeamDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionName")
   public MesEnclosureTeamDTO setProductionName(final String productionName) {
      this.productionName = productionName;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesEnclosureTeamDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("hasMen")
   public MesEnclosureTeamDTO setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("userLinkList")
   public MesEnclosureTeamDTO setUserLinks(final List<MesEnclosureTeamUserLinkDTO> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureTeamDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionName="
         + this.getProductionName()
         + ", userId="
         + this.getUserId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", hasMen="
         + this.getHasMen()
         + ", userLinks="
         + this.getUserLinks()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeamDTO)) {
         return false;
      }

      MesEnclosureTeamDTO other = (MesEnclosureTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$hasMen = this.getHasMen();
                        Object other$hasMen = other.getHasMen();
                        if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$productionName = this.getProductionName();
                              Object other$productionName = other.getProductionName();
                              if (this$productionName == null ? other$productionName == null : this$productionName.equals(other$productionName)) {
                                 Object this$userLinks = this.getUserLinks();
                                 Object other$userLinks = other.getUserLinks();
                                 if (this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks)) {
                                    Object this$price = this.getPrice();
                                    Object other$price = other.getPrice();
                                    return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesEnclosureTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productionName = this.getProductionName();
      result = result * 59 + ($productionName == null ? 43 : $productionName.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureTeamDTOBuilder {
      private Long id;
      private Long processId;
      private String processName;
      private Long factoryId;
      private Long productionLineId;
      private String productionName;
      private Long userId;
      private Integer wageQuotaType;
      private Boolean hasMen;
      private List<MesEnclosureTeamUserLinkDTO> userLinks;
      private BigDecimal price;

      MesEnclosureTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionName")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder productionName(final String productionName) {
         this.productionName = productionName;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("hasMen")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("userLinkList")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder userLinks(final List<MesEnclosureTeamUserLinkDTO> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureTeamDTO build() {
         return new MesEnclosureTeamDTO(
            this.id,
            this.processId,
            this.processName,
            this.factoryId,
            this.productionLineId,
            this.productionName,
            this.userId,
            this.wageQuotaType,
            this.hasMen,
            this.userLinks,
            this.price
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamDTO.MesEnclosureTeamDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", factoryId="
            + this.factoryId
            + ", productionLineId="
            + this.productionLineId
            + ", productionName="
            + this.productionName
            + ", userId="
            + this.userId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", hasMen="
            + this.hasMen
            + ", userLinks="
            + this.userLinks
            + ", price="
            + this.price
            + ")";
      }
   }
}
