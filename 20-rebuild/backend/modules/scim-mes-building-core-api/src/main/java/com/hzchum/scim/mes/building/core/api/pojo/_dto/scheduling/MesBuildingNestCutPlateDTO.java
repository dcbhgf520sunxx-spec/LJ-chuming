package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingNestCutPlateDTO", description = "")
public class MesBuildingNestCutPlateDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "machinePartSchedulingId", value = "零件工单id", notes = "零件工单id")
   @JsonProperty("machinePartSchedulingId")
   @JSONField(name = "machinePartSchedulingId")
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   private Long nestCutPlateId;
   @ApiModelProperty(name = "length")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "mac")
   @JsonProperty("mac")
   @JSONField(name = "mac")
   private String mac;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "ncName")
   @JsonProperty("ncName")
   @JSONField(name = "ncName")
   private String ncName;
   @ApiModelProperty(name = "ncCode", value = "nc文件编号==mes切割指令号", notes = "nc文件编号==mes切割指令号")
   @JsonProperty("ncCode")
   @JSONField(name = "ncCode")
   private String ncCode;
   @ApiModelProperty(name = "ncUrl", value = "nc文件地址", notes = "nc文件地址")
   @JsonProperty("ncUrl")
   @JSONField(name = "ncUrl")
   private String ncUrl;
   @ApiModelProperty(name = "ossKey", value = "oss地址", notes = "oss地址")
   @JsonProperty("ossKey")
   @JSONField(name = "ossKey")
   private String ossKey;
   @ApiModelProperty(name = "plateNo", value = "钢板编号", notes = "钢板编号")
   @JsonProperty("plateNo")
   @JSONField(name = "plateNo")
   private String plateNo;
   @ApiModelProperty(name = "allocateTime")
   @JsonProperty("allocateTime")
   @JSONField(name = "allocateTime")
   private LocalDateTime allocateTime;
   @ApiModelProperty(name = "sendTime")
   @JsonProperty("sendTime")
   @JSONField(name = "sendTime")
   private LocalDateTime sendTime;
   @ApiModelProperty(name = "source", value = "来源：0 本地 1 物料系统", notes = "来源：0 本地 1 物料系统")
   @JsonProperty("source")
   @JSONField(name = "source")
   private String source;
   @ApiModelProperty(name = "thick", value = "厚", notes = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private BigDecimal thick;
   @ApiModelProperty(name = "cutInstructionId", value = "切割指令号=nc文件编号", notes = "切割指令号=nc文件编号")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   private String cutInstructionId;
   @ApiModelProperty(name = "num")
   @JsonProperty("num")
   @JSONField(name = "num")
   private String num;
   @ApiModelProperty(name = "width")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "weight")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "boolHaveSurplus")
   @JsonProperty("boolHaveSurplus")
   @JSONField(name = "boolHaveSurplus")
   private String boolHaveSurplus;
   @ApiModelProperty(name = "pdfName")
   @JsonProperty("pdfName")
   @JSONField(name = "pdfName")
   private String pdfName;
   @ApiModelProperty(name = "cutName")
   @JsonProperty("cutName")
   @JSONField(name = "cutName")
   private String cutName;
   @ApiModelProperty(name = "pdfUrl")
   @JsonProperty("pdfUrl")
   @JSONField(name = "pdfUrl")
   private String pdfUrl;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "boolIssueEnum", value = "下发状态 [0 未下发 1 已下发]", notes = "下发状态 [0 未下发 1 已下发]")
   @JsonProperty("boolIssueEnum")
   @JSONField(name = "boolIssueEnum")
   private Boolean boolIssueEnum;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "cutNumber", value = "切割指令号")
   @JsonProperty("cutNumber")
   @JSONField(name = "cutNumber")
   private String cutNumber;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "boolBindingEnum", value = "是否绑定钢板", notes = "是否绑定钢板")
   @JsonProperty("boolBindingEnum")
   @JSONField(name = "boolBindingEnum")
   private Boolean boolBindingEnum;
   @ApiModelProperty(name = "taskOrderId", value = "最顶级任务工单id", notes = "最顶级任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;

   public static MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder builder() {
      return new MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder();
   }

   public MesBuildingNestCutPlateDTO() {
   }

   public MesBuildingNestCutPlateDTO(
      final Long id,
      final Long machinePartSchedulingId,
      final Long nestCutPlateId,
      final BigDecimal length,
      final String mac,
      final String material,
      final String ncName,
      final String ncCode,
      final String ncUrl,
      final String ossKey,
      final String plateNo,
      final LocalDateTime allocateTime,
      final LocalDateTime sendTime,
      final String source,
      final BigDecimal thick,
      final String cutInstructionId,
      final String num,
      final BigDecimal width,
      final BigDecimal weight,
      final String boolHaveSurplus,
      final String pdfName,
      final String cutName,
      final String pdfUrl,
      final LocalDateTime askCompleteTime,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long userId,
      final Boolean boolIssueEnum,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final String cutNumber,
      final Boolean boolNestCutEnum,
      final Boolean boolBindingEnum,
      final Long taskOrderId
   ) {
      this.id = id;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.nestCutPlateId = nestCutPlateId;
      this.length = length;
      this.mac = mac;
      this.material = material;
      this.ncName = ncName;
      this.ncCode = ncCode;
      this.ncUrl = ncUrl;
      this.ossKey = ossKey;
      this.plateNo = plateNo;
      this.allocateTime = allocateTime;
      this.sendTime = sendTime;
      this.source = source;
      this.thick = thick;
      this.cutInstructionId = cutInstructionId;
      this.num = num;
      this.width = width;
      this.weight = weight;
      this.boolHaveSurplus = boolHaveSurplus;
      this.pdfName = pdfName;
      this.cutName = cutName;
      this.pdfUrl = pdfUrl;
      this.askCompleteTime = askCompleteTime;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.userId = userId;
      this.boolIssueEnum = boolIssueEnum;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.cutNumber = cutNumber;
      this.boolNestCutEnum = boolNestCutEnum;
      this.boolBindingEnum = boolBindingEnum;
      this.taskOrderId = taskOrderId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMac() {
      return this.mac;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getNcName() {
      return this.ncName;
   }

   public String getNcCode() {
      return this.ncCode;
   }

   public String getNcUrl() {
      return this.ncUrl;
   }

   public String getOssKey() {
      return this.ossKey;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public LocalDateTime getAllocateTime() {
      return this.allocateTime;
   }

   public LocalDateTime getSendTime() {
      return this.sendTime;
   }

   public String getSource() {
      return this.source;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getNum() {
      return this.num;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getBoolHaveSurplus() {
      return this.boolHaveSurplus;
   }

   public String getPdfName() {
      return this.pdfName;
   }

   public String getCutName() {
      return this.cutName;
   }

   public String getPdfUrl() {
      return this.pdfUrl;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolIssueEnum() {
      return this.boolIssueEnum;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public String getCutNumber() {
      return this.cutNumber;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Boolean getBoolBindingEnum() {
      return this.boolBindingEnum;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   @JsonProperty("id")
   public MesBuildingNestCutPlateDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingNestCutPlateDTO setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingNestCutPlateDTO setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingNestCutPlateDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("mac")
   public MesBuildingNestCutPlateDTO setMac(final String mac) {
      this.mac = mac;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingNestCutPlateDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("ncName")
   public MesBuildingNestCutPlateDTO setNcName(final String ncName) {
      this.ncName = ncName;
      return this;
   }

   @JsonProperty("ncCode")
   public MesBuildingNestCutPlateDTO setNcCode(final String ncCode) {
      this.ncCode = ncCode;
      return this;
   }

   @JsonProperty("ncUrl")
   public MesBuildingNestCutPlateDTO setNcUrl(final String ncUrl) {
      this.ncUrl = ncUrl;
      return this;
   }

   @JsonProperty("ossKey")
   public MesBuildingNestCutPlateDTO setOssKey(final String ossKey) {
      this.ossKey = ossKey;
      return this;
   }

   @JsonProperty("plateNo")
   public MesBuildingNestCutPlateDTO setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
      return this;
   }

   @JsonProperty("allocateTime")
   public MesBuildingNestCutPlateDTO setAllocateTime(final LocalDateTime allocateTime) {
      this.allocateTime = allocateTime;
      return this;
   }

   @JsonProperty("sendTime")
   public MesBuildingNestCutPlateDTO setSendTime(final LocalDateTime sendTime) {
      this.sendTime = sendTime;
      return this;
   }

   @JsonProperty("source")
   public MesBuildingNestCutPlateDTO setSource(final String source) {
      this.source = source;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingNestCutPlateDTO setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public MesBuildingNestCutPlateDTO setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("num")
   public MesBuildingNestCutPlateDTO setNum(final String num) {
      this.num = num;
      return this;
   }

   @JsonProperty("width")
   public MesBuildingNestCutPlateDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingNestCutPlateDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("boolHaveSurplus")
   public MesBuildingNestCutPlateDTO setBoolHaveSurplus(final String boolHaveSurplus) {
      this.boolHaveSurplus = boolHaveSurplus;
      return this;
   }

   @JsonProperty("pdfName")
   public MesBuildingNestCutPlateDTO setPdfName(final String pdfName) {
      this.pdfName = pdfName;
      return this;
   }

   @JsonProperty("cutName")
   public MesBuildingNestCutPlateDTO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   @JsonProperty("pdfUrl")
   public MesBuildingNestCutPlateDTO setPdfUrl(final String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingNestCutPlateDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingNestCutPlateDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNestCutPlateDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingNestCutPlateDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingNestCutPlateDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingNestCutPlateDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("boolIssueEnum")
   public MesBuildingNestCutPlateDTO setBoolIssueEnum(final Boolean boolIssueEnum) {
      this.boolIssueEnum = boolIssueEnum;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingNestCutPlateDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingNestCutPlateDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingNestCutPlateDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesBuildingNestCutPlateDTO setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingNestCutPlateDTO setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("boolBindingEnum")
   public MesBuildingNestCutPlateDTO setBoolBindingEnum(final Boolean boolBindingEnum) {
      this.boolBindingEnum = boolBindingEnum;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingNestCutPlateDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutPlateDTO(id="
         + this.getId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", length="
         + this.getLength()
         + ", mac="
         + this.getMac()
         + ", material="
         + this.getMaterial()
         + ", ncName="
         + this.getNcName()
         + ", ncCode="
         + this.getNcCode()
         + ", ncUrl="
         + this.getNcUrl()
         + ", ossKey="
         + this.getOssKey()
         + ", plateNo="
         + this.getPlateNo()
         + ", allocateTime="
         + this.getAllocateTime()
         + ", sendTime="
         + this.getSendTime()
         + ", source="
         + this.getSource()
         + ", thick="
         + this.getThick()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", num="
         + this.getNum()
         + ", width="
         + this.getWidth()
         + ", weight="
         + this.getWeight()
         + ", boolHaveSurplus="
         + this.getBoolHaveSurplus()
         + ", pdfName="
         + this.getPdfName()
         + ", cutName="
         + this.getCutName()
         + ", pdfUrl="
         + this.getPdfUrl()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", userId="
         + this.getUserId()
         + ", boolIssueEnum="
         + this.getBoolIssueEnum()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", cutNumber="
         + this.getCutNumber()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", boolBindingEnum="
         + this.getBoolBindingEnum()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestCutPlateDTO)) {
         return false;
      }

      MesBuildingNestCutPlateDTO other = (MesBuildingNestCutPlateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
         Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
         if (this$machinePartSchedulingId == null ? other$machinePartSchedulingId == null : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$groupsId = this.getGroupsId();
                        Object other$groupsId = other.getGroupsId();
                        if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$boolIssueEnum = this.getBoolIssueEnum();
                              Object other$boolIssueEnum = other.getBoolIssueEnum();
                              if (this$boolIssueEnum == null ? other$boolIssueEnum == null : this$boolIssueEnum.equals(other$boolIssueEnum)) {
                                 Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                 Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                 if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                    Object this$boolBindingEnum = this.getBoolBindingEnum();
                                    Object other$boolBindingEnum = other.getBoolBindingEnum();
                                    if (this$boolBindingEnum == null ? other$boolBindingEnum == null : this$boolBindingEnum.equals(other$boolBindingEnum)) {
                                       Object this$taskOrderId = this.getTaskOrderId();
                                       Object other$taskOrderId = other.getTaskOrderId();
                                       if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$mac = this.getMac();
                                             Object other$mac = other.getMac();
                                             if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$ncName = this.getNcName();
                                                   Object other$ncName = other.getNcName();
                                                   if (this$ncName == null ? other$ncName == null : this$ncName.equals(other$ncName)) {
                                                      Object this$ncCode = this.getNcCode();
                                                      Object other$ncCode = other.getNcCode();
                                                      if (this$ncCode == null ? other$ncCode == null : this$ncCode.equals(other$ncCode)) {
                                                         Object this$ncUrl = this.getNcUrl();
                                                         Object other$ncUrl = other.getNcUrl();
                                                         if (this$ncUrl == null ? other$ncUrl == null : this$ncUrl.equals(other$ncUrl)) {
                                                            Object this$ossKey = this.getOssKey();
                                                            Object other$ossKey = other.getOssKey();
                                                            if (this$ossKey == null ? other$ossKey == null : this$ossKey.equals(other$ossKey)) {
                                                               Object this$plateNo = this.getPlateNo();
                                                               Object other$plateNo = other.getPlateNo();
                                                               if (this$plateNo == null ? other$plateNo == null : this$plateNo.equals(other$plateNo)) {
                                                                  Object this$allocateTime = this.getAllocateTime();
                                                                  Object other$allocateTime = other.getAllocateTime();
                                                                  if (this$allocateTime == null
                                                                     ? other$allocateTime == null
                                                                     : this$allocateTime.equals(other$allocateTime)) {
                                                                     Object this$sendTime = this.getSendTime();
                                                                     Object other$sendTime = other.getSendTime();
                                                                     if (this$sendTime == null ? other$sendTime == null : this$sendTime.equals(other$sendTime)) {
                                                                        Object this$source = this.getSource();
                                                                        Object other$source = other.getSource();
                                                                        if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                                                                           Object this$thick = this.getThick();
                                                                           Object other$thick = other.getThick();
                                                                           if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                              Object this$cutInstructionId = this.getCutInstructionId();
                                                                              Object other$cutInstructionId = other.getCutInstructionId();
                                                                              if (this$cutInstructionId == null
                                                                                 ? other$cutInstructionId == null
                                                                                 : this$cutInstructionId.equals(other$cutInstructionId)) {
                                                                                 Object this$num = this.getNum();
                                                                                 Object other$num = other.getNum();
                                                                                 if (this$num == null ? other$num == null : this$num.equals(other$num)) {
                                                                                    Object this$width = this.getWidth();
                                                                                    Object other$width = other.getWidth();
                                                                                    if (this$width == null
                                                                                       ? other$width == null
                                                                                       : this$width.equals(other$width)) {
                                                                                       Object this$weight = this.getWeight();
                                                                                       Object other$weight = other.getWeight();
                                                                                       if (this$weight == null
                                                                                          ? other$weight == null
                                                                                          : this$weight.equals(other$weight)) {
                                                                                          Object this$boolHaveSurplus = this.getBoolHaveSurplus();
                                                                                          Object other$boolHaveSurplus = other.getBoolHaveSurplus();
                                                                                          if (this$boolHaveSurplus == null
                                                                                             ? other$boolHaveSurplus == null
                                                                                             : this$boolHaveSurplus.equals(other$boolHaveSurplus)) {
                                                                                             Object this$pdfName = this.getPdfName();
                                                                                             Object other$pdfName = other.getPdfName();
                                                                                             if (this$pdfName == null
                                                                                                ? other$pdfName == null
                                                                                                : this$pdfName.equals(other$pdfName)) {
                                                                                                Object this$cutName = this.getCutName();
                                                                                                Object other$cutName = other.getCutName();
                                                                                                if (this$cutName == null
                                                                                                   ? other$cutName == null
                                                                                                   : this$cutName.equals(other$cutName)) {
                                                                                                   Object this$pdfUrl = this.getPdfUrl();
                                                                                                   Object other$pdfUrl = other.getPdfUrl();
                                                                                                   if (this$pdfUrl == null
                                                                                                      ? other$pdfUrl == null
                                                                                                      : this$pdfUrl.equals(other$pdfUrl)) {
                                                                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                      if (this$askCompleteTime == null
                                                                                                         ? other$askCompleteTime == null
                                                                                                         : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                                         Object this$workshop = this.getWorkshop();
                                                                                                         Object other$workshop = other.getWorkshop();
                                                                                                         if (this$workshop == null
                                                                                                            ? other$workshop == null
                                                                                                            : this$workshop.equals(other$workshop)) {
                                                                                                            Object this$productionLine = this.getProductionLine();
                                                                                                            Object other$productionLine = other.getProductionLine();
                                                                                                            if (this$productionLine == null
                                                                                                               ? other$productionLine == null
                                                                                                               : this$productionLine.equals(
                                                                                                                  other$productionLine
                                                                                                               )) {
                                                                                                               Object this$groups = this.getGroups();
                                                                                                               Object other$groups = other.getGroups();
                                                                                                               if (this$groups == null
                                                                                                                  ? other$groups == null
                                                                                                                  : this$groups.equals(other$groups)) {
                                                                                                                  Object this$cutNumber = this.getCutNumber();
                                                                                                                  Object other$cutNumber = other.getCutNumber();
                                                                                                                  return this$cutNumber == null
                                                                                                                     ? other$cutNumber == null
                                                                                                                     : this$cutNumber.equals(other$cutNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNestCutPlateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolIssueEnum = this.getBoolIssueEnum();
      result = result * 59 + ($boolIssueEnum == null ? 43 : $boolIssueEnum.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolBindingEnum = this.getBoolBindingEnum();
      result = result * 59 + ($boolBindingEnum == null ? 43 : $boolBindingEnum.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $ncName = this.getNcName();
      result = result * 59 + ($ncName == null ? 43 : $ncName.hashCode());
      Object $ncCode = this.getNcCode();
      result = result * 59 + ($ncCode == null ? 43 : $ncCode.hashCode());
      Object $ncUrl = this.getNcUrl();
      result = result * 59 + ($ncUrl == null ? 43 : $ncUrl.hashCode());
      Object $ossKey = this.getOssKey();
      result = result * 59 + ($ossKey == null ? 43 : $ossKey.hashCode());
      Object $plateNo = this.getPlateNo();
      result = result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
      Object $allocateTime = this.getAllocateTime();
      result = result * 59 + ($allocateTime == null ? 43 : $allocateTime.hashCode());
      Object $sendTime = this.getSendTime();
      result = result * 59 + ($sendTime == null ? 43 : $sendTime.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $boolHaveSurplus = this.getBoolHaveSurplus();
      result = result * 59 + ($boolHaveSurplus == null ? 43 : $boolHaveSurplus.hashCode());
      Object $pdfName = this.getPdfName();
      result = result * 59 + ($pdfName == null ? 43 : $pdfName.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $pdfUrl = this.getPdfUrl();
      result = result * 59 + ($pdfUrl == null ? 43 : $pdfUrl.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $cutNumber = this.getCutNumber();
      return result * 59 + ($cutNumber == null ? 43 : $cutNumber.hashCode());
   }

   public static class MesBuildingNestCutPlateDTOBuilder {
      private Long id;
      private Long machinePartSchedulingId;
      private Long nestCutPlateId;
      private BigDecimal length;
      private String mac;
      private String material;
      private String ncName;
      private String ncCode;
      private String ncUrl;
      private String ossKey;
      private String plateNo;
      private LocalDateTime allocateTime;
      private LocalDateTime sendTime;
      private String source;
      private BigDecimal thick;
      private String cutInstructionId;
      private String num;
      private BigDecimal width;
      private BigDecimal weight;
      private String boolHaveSurplus;
      private String pdfName;
      private String cutName;
      private String pdfUrl;
      private LocalDateTime askCompleteTime;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long userId;
      private Boolean boolIssueEnum;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private String cutNumber;
      private Boolean boolNestCutEnum;
      private Boolean boolBindingEnum;
      private Long taskOrderId;

      MesBuildingNestCutPlateDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("mac")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("ncName")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder ncName(final String ncName) {
         this.ncName = ncName;
         return this;
      }

      @JsonProperty("ncCode")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder ncCode(final String ncCode) {
         this.ncCode = ncCode;
         return this;
      }

      @JsonProperty("ncUrl")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder ncUrl(final String ncUrl) {
         this.ncUrl = ncUrl;
         return this;
      }

      @JsonProperty("ossKey")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder ossKey(final String ossKey) {
         this.ossKey = ossKey;
         return this;
      }

      @JsonProperty("plateNo")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      @JsonProperty("allocateTime")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder allocateTime(final LocalDateTime allocateTime) {
         this.allocateTime = allocateTime;
         return this;
      }

      @JsonProperty("sendTime")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder sendTime(final LocalDateTime sendTime) {
         this.sendTime = sendTime;
         return this;
      }

      @JsonProperty("source")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder source(final String source) {
         this.source = source;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("num")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder num(final String num) {
         this.num = num;
         return this;
      }

      @JsonProperty("width")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("boolHaveSurplus")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder boolHaveSurplus(final String boolHaveSurplus) {
         this.boolHaveSurplus = boolHaveSurplus;
         return this;
      }

      @JsonProperty("pdfName")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder pdfName(final String pdfName) {
         this.pdfName = pdfName;
         return this;
      }

      @JsonProperty("cutName")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      @JsonProperty("pdfUrl")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder pdfUrl(final String pdfUrl) {
         this.pdfUrl = pdfUrl;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("boolIssueEnum")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder boolIssueEnum(final Boolean boolIssueEnum) {
         this.boolIssueEnum = boolIssueEnum;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("boolBindingEnum")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder boolBindingEnum(final Boolean boolBindingEnum) {
         this.boolBindingEnum = boolBindingEnum;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesBuildingNestCutPlateDTO build() {
         return new MesBuildingNestCutPlateDTO(
            this.id,
            this.machinePartSchedulingId,
            this.nestCutPlateId,
            this.length,
            this.mac,
            this.material,
            this.ncName,
            this.ncCode,
            this.ncUrl,
            this.ossKey,
            this.plateNo,
            this.allocateTime,
            this.sendTime,
            this.source,
            this.thick,
            this.cutInstructionId,
            this.num,
            this.width,
            this.weight,
            this.boolHaveSurplus,
            this.pdfName,
            this.cutName,
            this.pdfUrl,
            this.askCompleteTime,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.userId,
            this.boolIssueEnum,
            this.workshop,
            this.productionLine,
            this.groups,
            this.cutNumber,
            this.boolNestCutEnum,
            this.boolBindingEnum,
            this.taskOrderId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutPlateDTO.MesBuildingNestCutPlateDTOBuilder(id="
            + this.id
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", length="
            + this.length
            + ", mac="
            + this.mac
            + ", material="
            + this.material
            + ", ncName="
            + this.ncName
            + ", ncCode="
            + this.ncCode
            + ", ncUrl="
            + this.ncUrl
            + ", ossKey="
            + this.ossKey
            + ", plateNo="
            + this.plateNo
            + ", allocateTime="
            + this.allocateTime
            + ", sendTime="
            + this.sendTime
            + ", source="
            + this.source
            + ", thick="
            + this.thick
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", num="
            + this.num
            + ", width="
            + this.width
            + ", weight="
            + this.weight
            + ", boolHaveSurplus="
            + this.boolHaveSurplus
            + ", pdfName="
            + this.pdfName
            + ", cutName="
            + this.cutName
            + ", pdfUrl="
            + this.pdfUrl
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", userId="
            + this.userId
            + ", boolIssueEnum="
            + this.boolIssueEnum
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", cutNumber="
            + this.cutNumber
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", boolBindingEnum="
            + this.boolBindingEnum
            + ", taskOrderId="
            + this.taskOrderId
            + ")";
      }
   }
}
