package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductProcessProgressDetail", description = "项目生产看板 - 产品工序进度详情")
public class ProductProcessProgressDetailDTO {
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private NameInfo workshop;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private NameInfo area;
   @ApiModelProperty(name = "className", value = "种类名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private String className;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "needQuantity", value = "任务数")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "completedQuantity", notes = "完成数")
   @JsonProperty("completedQuantity")
   @JSONField(name = "completedQuantity")
   private Integer completedQuantity;

   public Long getId() {
      return this.id;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getClassName() {
      return this.className;
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

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getCompletedQuantity() {
      return this.completedQuantity;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("monomer")
   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   @JsonProperty("area")
   public void setArea(final NameInfo area) {
      this.area = area;
   }

   @JsonProperty("className")
   public void setClassName(final String className) {
      this.className = className;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("taskTypeEnum")
   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   @JsonProperty("needQuantity")
   public void setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
   }

   @JsonProperty("completedQuantity")
   public void setCompletedQuantity(final Integer completedQuantity) {
      this.completedQuantity = completedQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessProgressDetailDTO)) {
         return false;
      }

      ProductProcessProgressDetailDTO other = (ProductProcessProgressDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$needQuantity = this.getNeedQuantity();
               Object other$needQuantity = other.getNeedQuantity();
               if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                  Object this$completedQuantity = this.getCompletedQuantity();
                  Object other$completedQuantity = other.getCompletedQuantity();
                  if (this$completedQuantity == null ? other$completedQuantity == null : this$completedQuantity.equals(other$completedQuantity)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$className = this.getClassName();
                              Object other$className = other.getClassName();
                              if (this$className == null ? other$className == null : this$className.equals(other$className)) {
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
                                          return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof ProductProcessProgressDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $completedQuantity = this.getCompletedQuantity();
      result = result * 59 + ($completedQuantity == null ? 43 : $completedQuantity.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessProgressDetailDTO(id="
         + this.getId()
         + ", workshop="
         + this.getWorkshop()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", className="
         + this.getClassName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", processId="
         + this.getProcessId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", completedQuantity="
         + this.getCompletedQuantity()
         + ")";
   }
}
