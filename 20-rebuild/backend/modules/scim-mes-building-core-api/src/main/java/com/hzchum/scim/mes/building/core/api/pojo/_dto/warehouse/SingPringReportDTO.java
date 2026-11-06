package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("外协可入库详细信息")
public class SingPringReportDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名", notes = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   private String areaName;
   @ApiModelProperty(value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(value = "车间名", notes = "车间名")
   private String workshopName;
   @ApiModelProperty(value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(value = "工厂名", notes = "工厂名")
   private String factoryName;
   @ApiModelProperty(value = "已打印数量", notes = "打印数量")
   private Integer printQuantity;
   @ApiModelProperty(value = "一物一码号", notes = "一物一码号")
   private Integer number;
   @ApiModelProperty(value = "一物一码号", notes = "一物一码号")
   private List<Integer> numbers;
   @ApiModelProperty(value = "打印人ID", notes = "打印人ID")
   private Long printUserId;
   @ApiModelProperty(value = "打印人名", notes = "打印人名")
   private String printUserName;
   @ApiModelProperty(value = "打印时间", notes = "打印时间")
   private LocalDateTime printTime;

   public static SingPringReportDTO.SingPringReportDTOBuilder builder() {
      return new SingPringReportDTO.SingPringReportDTOBuilder();
   }

   public SingPringReportDTO() {
   }

   public SingPringReportDTO(
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Long workshopId,
      final String workshopName,
      final Long factoryId,
      final String factoryName,
      final Integer printQuantity,
      final Integer number,
      final List<Integer> numbers,
      final Long printUserId,
      final String printUserName,
      final LocalDateTime printTime
   ) {
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.printQuantity = printQuantity;
      this.number = number;
      this.numbers = numbers;
      this.printUserId = printUserId;
      this.printUserName = printUserName;
      this.printTime = printTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getProductId() {
      return this.productId;
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

   public String getMaterial() {
      return this.material;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Integer getNumber() {
      return this.number;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public Long getPrintUserId() {
      return this.printUserId;
   }

   public String getPrintUserName() {
      return this.printUserName;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setPrintUserId(final Long printUserId) {
      this.printUserId = printUserId;
   }

   public void setPrintUserName(final String printUserName) {
      this.printUserName = printUserName;
   }

   public void setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SingPringReportDTO)) {
         return false;
      }

      SingPringReportDTO other = (SingPringReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$printQuantity = this.getPrintQuantity();
                     Object other$printQuantity = other.getPrintQuantity();
                     if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                        Object this$number = this.getNumber();
                        Object other$number = other.getNumber();
                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                           Object this$printUserId = this.getPrintUserId();
                           Object other$printUserId = other.getPrintUserId();
                           if (this$printUserId == null ? other$printUserId == null : this$printUserId.equals(other$printUserId)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomerName = this.getMonomerName();
                                 Object other$monomerName = other.getMonomerName();
                                 if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                    Object this$areaName = this.getAreaName();
                                    Object other$areaName = other.getAreaName();
                                    if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$workshopName = this.getWorkshopName();
                                                   Object other$workshopName = other.getWorkshopName();
                                                   if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                                      Object this$factoryName = this.getFactoryName();
                                                      Object other$factoryName = other.getFactoryName();
                                                      if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                                         Object this$numbers = this.getNumbers();
                                                         Object other$numbers = other.getNumbers();
                                                         if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                            Object this$printUserName = this.getPrintUserName();
                                                            Object other$printUserName = other.getPrintUserName();
                                                            if (this$printUserName == null
                                                               ? other$printUserName == null
                                                               : this$printUserName.equals(other$printUserName)) {
                                                               Object this$printTime = this.getPrintTime();
                                                               Object other$printTime = other.getPrintTime();
                                                               return this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime);
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
      return other instanceof SingPringReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $printUserId = this.getPrintUserId();
      result = result * 59 + ($printUserId == null ? 43 : $printUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $printUserName = this.getPrintUserName();
      result = result * 59 + ($printUserName == null ? 43 : $printUserName.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   @Override
   public String toString() {
      return "SingPringReportDTO(project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", number="
         + this.getNumber()
         + ", numbers="
         + this.getNumbers()
         + ", printUserId="
         + this.getPrintUserId()
         + ", printUserName="
         + this.getPrintUserName()
         + ", printTime="
         + this.getPrintTime()
         + ")";
   }

   public static class SingPringReportDTOBuilder {
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Long workshopId;
      private String workshopName;
      private Long factoryId;
      private String factoryName;
      private Integer printQuantity;
      private Integer number;
      private List<Integer> numbers;
      private Long printUserId;
      private String printUserName;
      private LocalDateTime printTime;

      SingPringReportDTOBuilder() {
      }

      public SingPringReportDTO.SingPringReportDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder printUserId(final Long printUserId) {
         this.printUserId = printUserId;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder printUserName(final String printUserName) {
         this.printUserName = printUserName;
         return this;
      }

      public SingPringReportDTO.SingPringReportDTOBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public SingPringReportDTO build() {
         return new SingPringReportDTO(
            this.project,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.workshopId,
            this.workshopName,
            this.factoryId,
            this.factoryName,
            this.printQuantity,
            this.number,
            this.numbers,
            this.printUserId,
            this.printUserName,
            this.printTime
         );
      }

      @Override
      public String toString() {
         return "SingPringReportDTO.SingPringReportDTOBuilder(project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", printQuantity="
            + this.printQuantity
            + ", number="
            + this.number
            + ", numbers="
            + this.numbers
            + ", printUserId="
            + this.printUserId
            + ", printUserName="
            + this.printUserName
            + ", printTime="
            + this.printTime
            + ")";
      }
   }
}
