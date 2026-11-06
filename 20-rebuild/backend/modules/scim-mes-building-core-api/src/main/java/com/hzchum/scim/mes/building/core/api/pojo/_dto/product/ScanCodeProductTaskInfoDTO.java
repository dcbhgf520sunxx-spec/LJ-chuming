package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.TraceConfigItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApiModel("产品扫码任务信息DTO")
public class ScanCodeProductTaskInfoDTO {
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   private NameInfo area;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "车间产线名称")
   private String workShopAndProdLineName;
   @ApiModelProperty(notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(notes = "产品规格")
   private String specification;
   @ApiModelProperty(notes = "产品长度")
   private BigDecimal length;
   @ApiModelProperty(notes = "产品材质")
   private String material;
   @ApiModelProperty(notes = "产品单重")
   private BigDecimal netWeight;
   @ApiModelProperty(notes = "是否有图纸")
   private Boolean boolHavDrawing;
   @ApiModelProperty(notes = "是否匹配模型")
   private Boolean boolHavModel;
   @ApiModelProperty(notes = "构件elementIds")
   private List<String> modelElementIds;
   @ApiModelProperty("产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("产品序列号和图号")
   private List<com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @ApiModelProperty(notes = "任务详情")
   private List<ScanCodeProductTaskInfoDetailDTO> qrTaskInfoDetailDTOList;
   @ApiModelProperty(notes = "任务详情")
   private Map<String, ScanCodeProductTaskInfoDetailDTO> qrTaskInfoDetailDTOMap;
   private List<TraceConfigItemVO> configItemVOList;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getWorkShopAndProdLineName() {
      return this.workShopAndProdLineName;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Boolean getBoolHavDrawing() {
      return this.boolHavDrawing;
   }

   public Boolean getBoolHavModel() {
      return this.boolHavModel;
   }

   public List<String> getModelElementIds() {
      return this.modelElementIds;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public List<ScanCodeProductTaskInfoDetailDTO> getQrTaskInfoDetailDTOList() {
      return this.qrTaskInfoDetailDTOList;
   }

   public Map<String, ScanCodeProductTaskInfoDetailDTO> getQrTaskInfoDetailDTOMap() {
      return this.qrTaskInfoDetailDTOMap;
   }

   public List<TraceConfigItemVO> getConfigItemVOList() {
      return this.configItemVOList;
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

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWorkShopAndProdLineName(final String workShopAndProdLineName) {
      this.workShopAndProdLineName = workShopAndProdLineName;
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

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setBoolHavDrawing(final Boolean boolHavDrawing) {
      this.boolHavDrawing = boolHavDrawing;
   }

   public void setBoolHavModel(final Boolean boolHavModel) {
      this.boolHavModel = boolHavModel;
   }

   public void setModelElementIds(final List<String> modelElementIds) {
      this.modelElementIds = modelElementIds;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public void setQrTaskInfoDetailDTOList(final List<ScanCodeProductTaskInfoDetailDTO> qrTaskInfoDetailDTOList) {
      this.qrTaskInfoDetailDTOList = qrTaskInfoDetailDTOList;
   }

   public void setQrTaskInfoDetailDTOMap(final Map<String, ScanCodeProductTaskInfoDetailDTO> qrTaskInfoDetailDTOMap) {
      this.qrTaskInfoDetailDTOMap = qrTaskInfoDetailDTOMap;
   }

   public void setConfigItemVOList(final List<TraceConfigItemVO> configItemVOList) {
      this.configItemVOList = configItemVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScanCodeProductTaskInfoDTO)) {
         return false;
      }

      ScanCodeProductTaskInfoDTO other = (ScanCodeProductTaskInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolHavDrawing = this.getBoolHavDrawing();
            Object other$boolHavDrawing = other.getBoolHavDrawing();
            if (this$boolHavDrawing == null ? other$boolHavDrawing == null : this$boolHavDrawing.equals(other$boolHavDrawing)) {
               Object this$boolHavModel = this.getBoolHavModel();
               Object other$boolHavModel = other.getBoolHavModel();
               if (this$boolHavModel == null ? other$boolHavModel == null : this$boolHavModel.equals(other$boolHavModel)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$workShopAndProdLineName = this.getWorkShopAndProdLineName();
                           Object other$workShopAndProdLineName = other.getWorkShopAndProdLineName();
                           if (this$workShopAndProdLineName == null
                              ? other$workShopAndProdLineName == null
                              : this$workShopAndProdLineName.equals(other$workShopAndProdLineName)) {
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
                                          Object this$netWeight = this.getNetWeight();
                                          Object other$netWeight = other.getNetWeight();
                                          if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                             Object this$modelElementIds = this.getModelElementIds();
                                             Object other$modelElementIds = other.getModelElementIds();
                                             if (this$modelElementIds == null
                                                ? other$modelElementIds == null
                                                : this$modelElementIds.equals(other$modelElementIds)) {
                                                Object this$numbers = this.getNumbers();
                                                Object other$numbers = other.getNumbers();
                                                if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                   Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                   Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                   if (this$drawingAndSerialNumber == null
                                                      ? other$drawingAndSerialNumber == null
                                                      : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber)) {
                                                      Object this$qrTaskInfoDetailDTOList = this.getQrTaskInfoDetailDTOList();
                                                      Object other$qrTaskInfoDetailDTOList = other.getQrTaskInfoDetailDTOList();
                                                      if (this$qrTaskInfoDetailDTOList == null
                                                         ? other$qrTaskInfoDetailDTOList == null
                                                         : this$qrTaskInfoDetailDTOList.equals(other$qrTaskInfoDetailDTOList)) {
                                                         Object this$qrTaskInfoDetailDTOMap = this.getQrTaskInfoDetailDTOMap();
                                                         Object other$qrTaskInfoDetailDTOMap = other.getQrTaskInfoDetailDTOMap();
                                                         if (this$qrTaskInfoDetailDTOMap == null
                                                            ? other$qrTaskInfoDetailDTOMap == null
                                                            : this$qrTaskInfoDetailDTOMap.equals(other$qrTaskInfoDetailDTOMap)) {
                                                            Object this$configItemVOList = this.getConfigItemVOList();
                                                            Object other$configItemVOList = other.getConfigItemVOList();
                                                            return this$configItemVOList == null
                                                               ? other$configItemVOList == null
                                                               : this$configItemVOList.equals(other$configItemVOList);
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
      return other instanceof ScanCodeProductTaskInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolHavDrawing = this.getBoolHavDrawing();
      result = result * 59 + ($boolHavDrawing == null ? 43 : $boolHavDrawing.hashCode());
      Object $boolHavModel = this.getBoolHavModel();
      result = result * 59 + ($boolHavModel == null ? 43 : $boolHavModel.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workShopAndProdLineName = this.getWorkShopAndProdLineName();
      result = result * 59 + ($workShopAndProdLineName == null ? 43 : $workShopAndProdLineName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $modelElementIds = this.getModelElementIds();
      result = result * 59 + ($modelElementIds == null ? 43 : $modelElementIds.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      result = result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
      Object $qrTaskInfoDetailDTOList = this.getQrTaskInfoDetailDTOList();
      result = result * 59 + ($qrTaskInfoDetailDTOList == null ? 43 : $qrTaskInfoDetailDTOList.hashCode());
      Object $qrTaskInfoDetailDTOMap = this.getQrTaskInfoDetailDTOMap();
      result = result * 59 + ($qrTaskInfoDetailDTOMap == null ? 43 : $qrTaskInfoDetailDTOMap.hashCode());
      Object $configItemVOList = this.getConfigItemVOList();
      return result * 59 + ($configItemVOList == null ? 43 : $configItemVOList.hashCode());
   }

   @Override
   public String toString() {
      return "ScanCodeProductTaskInfoDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", workShopAndProdLineName="
         + this.getWorkShopAndProdLineName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", boolHavDrawing="
         + this.getBoolHavDrawing()
         + ", boolHavModel="
         + this.getBoolHavModel()
         + ", modelElementIds="
         + this.getModelElementIds()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", qrTaskInfoDetailDTOList="
         + this.getQrTaskInfoDetailDTOList()
         + ", qrTaskInfoDetailDTOMap="
         + this.getQrTaskInfoDetailDTOMap()
         + ", configItemVOList="
         + this.getConfigItemVOList()
         + ")";
   }
}
