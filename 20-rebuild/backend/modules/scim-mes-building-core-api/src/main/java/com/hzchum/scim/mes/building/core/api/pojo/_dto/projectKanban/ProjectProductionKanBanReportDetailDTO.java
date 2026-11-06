package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class ProjectProductionKanBanReportDetailDTO {
   @ApiModelProperty(name = "name", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "workShopName", notes = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "teamUserName", notes = "班组长名称")
   @JsonProperty("teamUserName")
   @JSONField(name = "teamUserName")
   private String teamUserName;
   @ApiModelProperty(name = "createUserName", notes = "上报/质检人名称")
   @JsonProperty("createUserName")
   @JSONField(name = "createUserName")
   private String createUserName;
   @ApiModelProperty(name = "createTime", notes = "上报/质检时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private String createTime;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "boolAssist", notes = "是否协同")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   private Boolean boolAssist;
   @ApiModelProperty(name = "boolCompleted", notes = "是否上报/质检")
   @JsonProperty("boolCompleted")
   @JSONField(name = "boolCompleted")
   private Boolean boolCompleted;

   public static ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder builder() {
      return new ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public Boolean getBoolCompleted() {
      return this.boolCompleted;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("productionLineName")
   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("teamUserName")
   public void setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
   }

   @JsonProperty("createUserName")
   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   @JsonProperty("createTime")
   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("boolAssist")
   public void setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
   }

   @JsonProperty("boolCompleted")
   public void setBoolCompleted(final Boolean boolCompleted) {
      this.boolCompleted = boolCompleted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionKanBanReportDetailDTO)) {
         return false;
      }

      ProjectProductionKanBanReportDetailDTO other = (ProjectProductionKanBanReportDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$boolAssist = this.getBoolAssist();
         Object other$boolAssist = other.getBoolAssist();
         if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
            Object this$boolCompleted = this.getBoolCompleted();
            Object other$boolCompleted = other.getBoolCompleted();
            if (this$boolCompleted == null ? other$boolCompleted == null : this$boolCompleted.equals(other$boolCompleted)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$productionLineName = this.getProductionLineName();
                        Object other$productionLineName = other.getProductionLineName();
                        if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                           Object this$workShopName = this.getWorkShopName();
                           Object other$workShopName = other.getWorkShopName();
                           if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                              Object this$teamUserName = this.getTeamUserName();
                              Object other$teamUserName = other.getTeamUserName();
                              if (this$teamUserName == null ? other$teamUserName == null : this$teamUserName.equals(other$teamUserName)) {
                                 Object this$createUserName = this.getCreateUserName();
                                 Object other$createUserName = other.getCreateUserName();
                                 if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof ProjectProductionKanBanReportDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $boolCompleted = this.getBoolCompleted();
      result = result * 59 + ($boolCompleted == null ? 43 : $boolCompleted.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionKanBanReportDetailDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", workShopName="
         + this.getWorkShopName()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", boolAssist="
         + this.getBoolAssist()
         + ", boolCompleted="
         + this.getBoolCompleted()
         + ")";
   }

   public ProjectProductionKanBanReportDetailDTO() {
   }

   public ProjectProductionKanBanReportDetailDTO(
      final String name,
      final String serialNumber,
      final String specification,
      final String productionLineName,
      final String workShopName,
      final String teamUserName,
      final String createUserName,
      final String createTime,
      final Integer quantity,
      final Boolean boolAssist,
      final Boolean boolCompleted
   ) {
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.productionLineName = productionLineName;
      this.workShopName = workShopName;
      this.teamUserName = teamUserName;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.quantity = quantity;
      this.boolAssist = boolAssist;
      this.boolCompleted = boolCompleted;
   }

   public static class ProjectProductionKanBanReportDetailDTOBuilder {
      private String name;
      private String serialNumber;
      private String specification;
      private String productionLineName;
      private String workShopName;
      private String teamUserName;
      private String createUserName;
      private String createTime;
      private Integer quantity;
      private Boolean boolAssist;
      private Boolean boolCompleted;

      ProjectProductionKanBanReportDetailDTOBuilder() {
      }

      @JsonProperty("name")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productionLineName")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("workShopName")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("teamUserName")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      @JsonProperty("createUserName")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      @JsonProperty("createTime")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("boolAssist")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      @JsonProperty("boolCompleted")
      public ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder boolCompleted(final Boolean boolCompleted) {
         this.boolCompleted = boolCompleted;
         return this;
      }

      public ProjectProductionKanBanReportDetailDTO build() {
         return new ProjectProductionKanBanReportDetailDTO(
            this.name,
            this.serialNumber,
            this.specification,
            this.productionLineName,
            this.workShopName,
            this.teamUserName,
            this.createUserName,
            this.createTime,
            this.quantity,
            this.boolAssist,
            this.boolCompleted
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionKanBanReportDetailDTO.ProjectProductionKanBanReportDetailDTOBuilder(name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", productionLineName="
            + this.productionLineName
            + ", workShopName="
            + this.workShopName
            + ", teamUserName="
            + this.teamUserName
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", quantity="
            + this.quantity
            + ", boolAssist="
            + this.boolAssist
            + ", boolCompleted="
            + this.boolCompleted
            + ")";
      }
   }
}
