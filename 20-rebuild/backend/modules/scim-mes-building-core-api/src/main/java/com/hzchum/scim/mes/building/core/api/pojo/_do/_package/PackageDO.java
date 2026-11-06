package com.hzchum.scim.mes.building.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "包 ")
public class PackageDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("包单号")
   private String serialNumber;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("状态 [0 未装车, 1 已装车, 2发运]")
   private Integer status;
   @ApiModelProperty("是否发运")
   private Boolean boolShip;
   @ApiModelProperty("存储仓库id")
   private Long warehouseId;
   @ApiModelProperty("存储仓库")
   private NameInfo warehouse;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("打印状态 [0 未打印, 1 已打印]")
   private Boolean printType;
   @ApiModelProperty("打印数量")
   private BigDecimal printQuantity;
   @ApiModelProperty("操作人")
   private Long userId;
   @ApiModelProperty("操作人名")
   private String userName;
   @ApiModelProperty("打包日期")
   private LocalDateTime createTime;
   @ApiModelProperty("单体名称(多个以逗号分隔)")
   private String monomerName;
   @ApiModelProperty("批次名称(多个以逗号分隔)")
   private String areaBatchName;
   @ApiModelProperty(name = "attachmentDTOS", value = "附件")
   private List<AttachmentDTO> attachmentDTOS;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getBoolShip() {
      return this.boolShip;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public NameInfo getWarehouse() {
      return this.warehouse;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getPrintType() {
      return this.printType;
   }

   public BigDecimal getPrintQuantity() {
      return this.printQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setBoolShip(final Boolean boolShip) {
      this.boolShip = boolShip;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWarehouse(final NameInfo warehouse) {
      this.warehouse = warehouse;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPrintType(final Boolean printType) {
      this.printType = printType;
   }

   public void setPrintQuantity(final BigDecimal printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageDO)) {
         return false;
      }

      PackageDO other = (PackageDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$boolShip = this.getBoolShip();
               Object other$boolShip = other.getBoolShip();
               if (this$boolShip == null ? other$boolShip == null : this$boolShip.equals(other$boolShip)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$printType = this.getPrintType();
                     Object other$printType = other.getPrintType();
                     if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$warehouse = this.getWarehouse();
                                 Object other$warehouse = other.getWarehouse();
                                 if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$printQuantity = this.getPrintQuantity();
                                       Object other$printQuantity = other.getPrintQuantity();
                                       if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                          Object this$userName = this.getUserName();
                                          Object other$userName = other.getUserName();
                                          if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                             Object this$createTime = this.getCreateTime();
                                             Object other$createTime = other.getCreateTime();
                                             if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                Object this$monomerName = this.getMonomerName();
                                                Object other$monomerName = other.getMonomerName();
                                                if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                   Object this$areaBatchName = this.getAreaBatchName();
                                                   Object other$areaBatchName = other.getAreaBatchName();
                                                   if (this$areaBatchName == null
                                                      ? other$areaBatchName == null
                                                      : this$areaBatchName.equals(other$areaBatchName)) {
                                                      Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                      Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                      return this$attachmentDTOS == null
                                                         ? other$attachmentDTOS == null
                                                         : this$attachmentDTOS.equals(other$attachmentDTOS);
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
      return other instanceof PackageDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolShip = this.getBoolShip();
      result = result * 59 + ($boolShip == null ? 43 : $boolShip.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "PackageDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", status="
         + this.getStatus()
         + ", boolShip="
         + this.getBoolShip()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouse="
         + this.getWarehouse()
         + ", remark="
         + this.getRemark()
         + ", printType="
         + this.getPrintType()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }
}
