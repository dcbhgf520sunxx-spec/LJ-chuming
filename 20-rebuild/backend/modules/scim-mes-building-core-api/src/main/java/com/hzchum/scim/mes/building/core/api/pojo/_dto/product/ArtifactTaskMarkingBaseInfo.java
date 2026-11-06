package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("构件任务基本信息")
public class ArtifactTaskMarkingBaseInfo {
   @ApiModelProperty(name = "id", value = "产品id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "taskDetailBaseInfo", value = "任务信息")
   private List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoList;

   public Long getId() {
      return this.id;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public List<ArtifactTaskDetailBaseInfo> getTaskDetailBaseInfoList() {
      return this.taskDetailBaseInfoList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   public void setTaskDetailBaseInfoList(final List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoList) {
      this.taskDetailBaseInfoList = taskDetailBaseInfoList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactTaskMarkingBaseInfo)) {
         return false;
      }

      ArtifactTaskMarkingBaseInfo other = (ArtifactTaskMarkingBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolOneCode = this.getBoolOneCode();
         Object other$boolOneCode = other.getBoolOneCode();
         if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$taskDetailBaseInfoList = this.getTaskDetailBaseInfoList();
                           Object other$taskDetailBaseInfoList = other.getTaskDetailBaseInfoList();
                           return this$taskDetailBaseInfoList == null
                              ? other$taskDetailBaseInfoList == null
                              : this$taskDetailBaseInfoList.equals(other$taskDetailBaseInfoList);
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
      return other instanceof ArtifactTaskMarkingBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $taskDetailBaseInfoList = this.getTaskDetailBaseInfoList();
      return result * 59 + ($taskDetailBaseInfoList == null ? 43 : $taskDetailBaseInfoList.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactTaskMarkingBaseInfo(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", taskDetailBaseInfoList="
         + this.getTaskDetailBaseInfoList()
         + ")";
   }
}
