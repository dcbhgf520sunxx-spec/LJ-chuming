package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TechArtifactSpecAmend对象", description = "构件规格修正表 ")
public class TechArtifactSpecAmendDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "artifactId", value = "构件ID", notes = "构件ID")
   private Long artifactId;
   @ApiModelProperty(name = "name", value = "零件名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "oldSpecification", value = "原来规格", notes = "原来规格")
   private String oldSpecification;
   @ApiModelProperty(name = "oldSpecPrefix", value = "原规格前缀", notes = "原规格前缀")
   private String oldSpecPrefix;
   @ApiModelProperty(name = "newSpecification", value = "修正规格", notes = "修正规格")
   private String newSpecification;
   @ApiModelProperty(name = "newSpecPrefix", value = "修正规格前缀", notes = "修正规格前缀")
   private String newSpecPrefix;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "boolAmendStatus", value = "修正状态 true已修正 false未修正", notes = "修正状态 true已修正 false未修正")
   private Boolean boolAmendStatus;
   @ApiModelProperty(name = "amendUserId", value = "修正人ID", notes = "修正人ID")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "修正人", notes = "修正人")
   private String userName;
   @ApiModelProperty(name = "numbers", value = "产品序列号")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public static TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder builder() {
      return new TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder();
   }

   public TechArtifactSpecAmendDTO() {
   }

   public TechArtifactSpecAmendDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Long artifactId,
      final String name,
      final String serialNumber,
      final String oldSpecification,
      final String oldSpecPrefix,
      final String newSpecification,
      final String newSpecPrefix,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Boolean boolAmendStatus,
      final Long userId,
      final String userName,
      final List<Integer> numbers,
      final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.artifactId = artifactId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.oldSpecification = oldSpecification;
      this.oldSpecPrefix = oldSpecPrefix;
      this.newSpecification = newSpecification;
      this.newSpecPrefix = newSpecPrefix;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.boolAmendStatus = boolAmendStatus;
      this.userId = userId;
      this.userName = userName;
      this.numbers = numbers;
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getOldSpecification() {
      return this.oldSpecification;
   }

   public String getOldSpecPrefix() {
      return this.oldSpecPrefix;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Boolean getBoolAmendStatus() {
      return this.boolAmendStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOldSpecification(final String oldSpecification) {
      this.oldSpecification = oldSpecification;
   }

   public void setOldSpecPrefix(final String oldSpecPrefix) {
      this.oldSpecPrefix = oldSpecPrefix;
   }

   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setBoolAmendStatus(final Boolean boolAmendStatus) {
      this.boolAmendStatus = boolAmendStatus;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactSpecAmendDTO)) {
         return false;
      }

      TechArtifactSpecAmendDTO other = (TechArtifactSpecAmendDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$boolAmendStatus = this.getBoolAmendStatus();
               Object other$boolAmendStatus = other.getBoolAmendStatus();
               if (this$boolAmendStatus == null ? other$boolAmendStatus == null : this$boolAmendStatus.equals(other$boolAmendStatus)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$oldSpecification = this.getOldSpecification();
                                    Object other$oldSpecification = other.getOldSpecification();
                                    if (this$oldSpecification == null ? other$oldSpecification == null : this$oldSpecification.equals(other$oldSpecification)) {
                                       Object this$oldSpecPrefix = this.getOldSpecPrefix();
                                       Object other$oldSpecPrefix = other.getOldSpecPrefix();
                                       if (this$oldSpecPrefix == null ? other$oldSpecPrefix == null : this$oldSpecPrefix.equals(other$oldSpecPrefix)) {
                                          Object this$newSpecification = this.getNewSpecification();
                                          Object other$newSpecification = other.getNewSpecification();
                                          if (this$newSpecification == null
                                             ? other$newSpecification == null
                                             : this$newSpecification.equals(other$newSpecification)) {
                                             Object this$newSpecPrefix = this.getNewSpecPrefix();
                                             Object other$newSpecPrefix = other.getNewSpecPrefix();
                                             if (this$newSpecPrefix == null ? other$newSpecPrefix == null : this$newSpecPrefix.equals(other$newSpecPrefix)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$netWeight = this.getNetWeight();
                                                      Object other$netWeight = other.getNetWeight();
                                                      if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                         Object this$totalNetWeight = this.getTotalNetWeight();
                                                         Object other$totalNetWeight = other.getTotalNetWeight();
                                                         if (this$totalNetWeight == null
                                                            ? other$totalNetWeight == null
                                                            : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$numbers = this.getNumbers();
                                                               Object other$numbers = other.getNumbers();
                                                               if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                                  Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                  Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                  return this$drawingAndSerialNumber == null
                                                                     ? other$drawingAndSerialNumber == null
                                                                     : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactSpecAmendDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolAmendStatus = this.getBoolAmendStatus();
      result = result * 59 + ($boolAmendStatus == null ? 43 : $boolAmendStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $oldSpecification = this.getOldSpecification();
      result = result * 59 + ($oldSpecification == null ? 43 : $oldSpecification.hashCode());
      Object $oldSpecPrefix = this.getOldSpecPrefix();
      result = result * 59 + ($oldSpecPrefix == null ? 43 : $oldSpecPrefix.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      result = result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactSpecAmendDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", oldSpecification="
         + this.getOldSpecification()
         + ", oldSpecPrefix="
         + this.getOldSpecPrefix()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", boolAmendStatus="
         + this.getBoolAmendStatus()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }

   public static class TechArtifactSpecAmendDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Long artifactId;
      private String name;
      private String serialNumber;
      private String oldSpecification;
      private String oldSpecPrefix;
      private String newSpecification;
      private String newSpecPrefix;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Boolean boolAmendStatus;
      private Long userId;
      private String userName;
      private List<Integer> numbers;
      private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

      TechArtifactSpecAmendDTOBuilder() {
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder oldSpecification(final String oldSpecification) {
         this.oldSpecification = oldSpecification;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder oldSpecPrefix(final String oldSpecPrefix) {
         this.oldSpecPrefix = oldSpecPrefix;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder newSpecification(final String newSpecification) {
         this.newSpecification = newSpecification;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder newSpecPrefix(final String newSpecPrefix) {
         this.newSpecPrefix = newSpecPrefix;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder boolAmendStatus(final Boolean boolAmendStatus) {
         this.boolAmendStatus = boolAmendStatus;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder drawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
         this.drawingAndSerialNumber = drawingAndSerialNumber;
         return this;
      }

      public TechArtifactSpecAmendDTO build() {
         return new TechArtifactSpecAmendDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.artifactId,
            this.name,
            this.serialNumber,
            this.oldSpecification,
            this.oldSpecPrefix,
            this.newSpecification,
            this.newSpecPrefix,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.boolAmendStatus,
            this.userId,
            this.userName,
            this.numbers,
            this.drawingAndSerialNumber
         );
      }

      @Override
      public String toString() {
         return "TechArtifactSpecAmendDTO.TechArtifactSpecAmendDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", artifactId="
            + this.artifactId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", oldSpecification="
            + this.oldSpecification
            + ", oldSpecPrefix="
            + this.oldSpecPrefix
            + ", newSpecification="
            + this.newSpecification
            + ", newSpecPrefix="
            + this.newSpecPrefix
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", boolAmendStatus="
            + this.boolAmendStatus
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", numbers="
            + this.numbers
            + ", drawingAndSerialNumber="
            + this.drawingAndSerialNumber
            + ")";
      }
   }
}
