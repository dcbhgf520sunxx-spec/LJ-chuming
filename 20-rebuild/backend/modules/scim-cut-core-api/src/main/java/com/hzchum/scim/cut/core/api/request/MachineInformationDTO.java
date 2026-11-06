package com.hzchum.scim.cut.core.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "MachineInformation对象", description = "")
@Entity
@TableName("machine_information")
public class MachineInformationDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "fileName", notes = "文件名")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name")
   private String fileName;
   @ApiModelProperty(name = "cutState", notes = "状态")
   @JsonProperty("cutState")
   @JSONField(name = "cutState")
   @TableField("cut_state")
   @Column(name = "cut_state")
   private String cutState;
   @ApiModelProperty(name = "currentLineNum", notes = "行号")
   @JsonProperty("currentLineNum")
   @JSONField(name = "currentLineNum")
   @TableField("current_line_num")
   @Column(name = "current_line_num")
   private String currentLineNum;
   @ApiModelProperty(name = "currentHoleNum", notes = "孔号")
   @JsonProperty("currentHoleNum")
   @JSONField(name = "currentHoleNum")
   @TableField("current_hole_num")
   @Column(name = "current_hole_num")
   private String currentHoleNum;
   @ApiModelProperty(name = "cutSpeed", notes = "切割速度")
   @JsonProperty("cutSpeed")
   @JSONField(name = "cutSpeed")
   @TableField("cut_speed")
   @Column(name = "cut_speed")
   private String cutSpeed;
   @ApiModelProperty(name = "totalPierceCount", notes = "穿孔次数")
   @JsonProperty("totalPierceCount")
   @JSONField(name = "totalPierceCount")
   @TableField("total_pierce_count")
   @Column(name = "total_pierce_count")
   private String totalPierceCount;
   @ApiModelProperty(name = "moveFixedDistanc", notes = "定长距离")
   @JsonProperty("moveFixedDistanc")
   @JSONField(name = "moveFixedDistanc")
   @TableField("move_fixed_distanc")
   @Column(name = "move_fixed_distanc")
   private Double moveFixedDistanc;
   @ApiModelProperty(name = "totalCutLength", notes = "切割长度/距离")
   @JsonProperty("totalCutLength")
   @JSONField(name = "totalCutLength")
   @TableField("total_cut_length")
   @Column(name = "total_cut_length")
   private Double totalCutLength;
   @ApiModelProperty(name = "kerf", notes = "割缝值")
   @JsonProperty("kerf")
   @JSONField(name = "kerf")
   @TableField("kerf")
   @Column(name = "kerf")
   private Double kerf;
   @ApiModelProperty(name = "estimateCutTime", notes = "预估切割时间")
   @JsonProperty("estimateCutTime")
   @JSONField(name = "estimateCutTime")
   @TableField("estimate_cut_time")
   @Column(name = "estimate_cut_time")
   private String estimateCutTime;
   @ApiModelProperty(name = "currentCutTime", notes = "当前切割时间")
   @JsonProperty("currentCutTime")
   @JSONField(name = "currentCutTime")
   @TableField("current_cut_time")
   @Column(name = "current_cut_time")
   private String currentCutTime;
   @ApiModelProperty(name = "softRunTime", notes = "当前运行时间")
   @JsonProperty("softRunTime")
   @JSONField(name = "softRunTime")
   @TableField("soft_run_time")
   @Column(name = "soft_run_time")
   private String softRunTime;
   @ApiModelProperty(name = "motionVersion", notes = "轴卡软件版本")
   @JsonProperty("motionVersion")
   @JSONField(name = "motionVersion")
   @TableField("motion_version")
   @Column(name = "motion_version")
   private String motionVersion;
   @ApiModelProperty(name = "partx", notes = "x")
   @JsonProperty("partx")
   @JSONField(name = "partx")
   @TableField("partx")
   @Column(name = "partx")
   private Double partx;
   @ApiModelProperty(name = "party", notes = "y")
   @JsonProperty("party")
   @JSONField(name = "party")
   @TableField("party")
   @Column(name = "party")
   private Double party;
   @ApiModelProperty(name = "currentLineGod", notes = "当前运行的g代码")
   @JsonProperty("currentLineGod")
   @JSONField(name = "currentLineGod")
   @TableField("current_line_god")
   @Column(name = "current_line_god")
   private String currentLineGod;
   @ApiModelProperty(name = "mac", notes = "mac地址")
   @JsonProperty("mac")
   @JSONField(name = "mac")
   @TableField("mac")
   @Column(name = "mac")
   private String mac;

   public static MachineInformationDTO.MachineInformationDTOBuilder builder() {
      return new MachineInformationDTO.MachineInformationDTOBuilder();
   }

   public MachineInformationDTO() {
   }

   public MachineInformationDTO(
      final Long id,
      final String fileName,
      final String cutState,
      final String currentLineNum,
      final String currentHoleNum,
      final String cutSpeed,
      final String totalPierceCount,
      final Double moveFixedDistanc,
      final Double totalCutLength,
      final Double kerf,
      final String estimateCutTime,
      final String currentCutTime,
      final String softRunTime,
      final String motionVersion,
      final Double partx,
      final Double party,
      final String currentLineGod,
      final String mac
   ) {
      this.id = id;
      this.fileName = fileName;
      this.cutState = cutState;
      this.currentLineNum = currentLineNum;
      this.currentHoleNum = currentHoleNum;
      this.cutSpeed = cutSpeed;
      this.totalPierceCount = totalPierceCount;
      this.moveFixedDistanc = moveFixedDistanc;
      this.totalCutLength = totalCutLength;
      this.kerf = kerf;
      this.estimateCutTime = estimateCutTime;
      this.currentCutTime = currentCutTime;
      this.softRunTime = softRunTime;
      this.motionVersion = motionVersion;
      this.partx = partx;
      this.party = party;
      this.currentLineGod = currentLineGod;
      this.mac = mac;
   }

   public Long getId() {
      return this.id;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getCutState() {
      return this.cutState;
   }

   public String getCurrentLineNum() {
      return this.currentLineNum;
   }

   public String getCurrentHoleNum() {
      return this.currentHoleNum;
   }

   public String getCutSpeed() {
      return this.cutSpeed;
   }

   public String getTotalPierceCount() {
      return this.totalPierceCount;
   }

   public Double getMoveFixedDistanc() {
      return this.moveFixedDistanc;
   }

   public Double getTotalCutLength() {
      return this.totalCutLength;
   }

   public Double getKerf() {
      return this.kerf;
   }

   public String getEstimateCutTime() {
      return this.estimateCutTime;
   }

   public String getCurrentCutTime() {
      return this.currentCutTime;
   }

   public String getSoftRunTime() {
      return this.softRunTime;
   }

   public String getMotionVersion() {
      return this.motionVersion;
   }

   public Double getPartx() {
      return this.partx;
   }

   public Double getParty() {
      return this.party;
   }

   public String getCurrentLineGod() {
      return this.currentLineGod;
   }

   public String getMac() {
      return this.mac;
   }

   @JsonProperty("id")
   public MachineInformationDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("fileName")
   public MachineInformationDTO setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("cutState")
   public MachineInformationDTO setCutState(final String cutState) {
      this.cutState = cutState;
      return this;
   }

   @JsonProperty("currentLineNum")
   public MachineInformationDTO setCurrentLineNum(final String currentLineNum) {
      this.currentLineNum = currentLineNum;
      return this;
   }

   @JsonProperty("currentHoleNum")
   public MachineInformationDTO setCurrentHoleNum(final String currentHoleNum) {
      this.currentHoleNum = currentHoleNum;
      return this;
   }

   @JsonProperty("cutSpeed")
   public MachineInformationDTO setCutSpeed(final String cutSpeed) {
      this.cutSpeed = cutSpeed;
      return this;
   }

   @JsonProperty("totalPierceCount")
   public MachineInformationDTO setTotalPierceCount(final String totalPierceCount) {
      this.totalPierceCount = totalPierceCount;
      return this;
   }

   @JsonProperty("moveFixedDistanc")
   public MachineInformationDTO setMoveFixedDistanc(final Double moveFixedDistanc) {
      this.moveFixedDistanc = moveFixedDistanc;
      return this;
   }

   @JsonProperty("totalCutLength")
   public MachineInformationDTO setTotalCutLength(final Double totalCutLength) {
      this.totalCutLength = totalCutLength;
      return this;
   }

   @JsonProperty("kerf")
   public MachineInformationDTO setKerf(final Double kerf) {
      this.kerf = kerf;
      return this;
   }

   @JsonProperty("estimateCutTime")
   public MachineInformationDTO setEstimateCutTime(final String estimateCutTime) {
      this.estimateCutTime = estimateCutTime;
      return this;
   }

   @JsonProperty("currentCutTime")
   public MachineInformationDTO setCurrentCutTime(final String currentCutTime) {
      this.currentCutTime = currentCutTime;
      return this;
   }

   @JsonProperty("softRunTime")
   public MachineInformationDTO setSoftRunTime(final String softRunTime) {
      this.softRunTime = softRunTime;
      return this;
   }

   @JsonProperty("motionVersion")
   public MachineInformationDTO setMotionVersion(final String motionVersion) {
      this.motionVersion = motionVersion;
      return this;
   }

   @JsonProperty("partx")
   public MachineInformationDTO setPartx(final Double partx) {
      this.partx = partx;
      return this;
   }

   @JsonProperty("party")
   public MachineInformationDTO setParty(final Double party) {
      this.party = party;
      return this;
   }

   @JsonProperty("currentLineGod")
   public MachineInformationDTO setCurrentLineGod(final String currentLineGod) {
      this.currentLineGod = currentLineGod;
      return this;
   }

   @JsonProperty("mac")
   public MachineInformationDTO setMac(final String mac) {
      this.mac = mac;
      return this;
   }

   @Override
   public String toString() {
      return "MachineInformationDTO(id="
         + this.getId()
         + ", fileName="
         + this.getFileName()
         + ", cutState="
         + this.getCutState()
         + ", currentLineNum="
         + this.getCurrentLineNum()
         + ", currentHoleNum="
         + this.getCurrentHoleNum()
         + ", cutSpeed="
         + this.getCutSpeed()
         + ", totalPierceCount="
         + this.getTotalPierceCount()
         + ", moveFixedDistanc="
         + this.getMoveFixedDistanc()
         + ", totalCutLength="
         + this.getTotalCutLength()
         + ", kerf="
         + this.getKerf()
         + ", estimateCutTime="
         + this.getEstimateCutTime()
         + ", currentCutTime="
         + this.getCurrentCutTime()
         + ", softRunTime="
         + this.getSoftRunTime()
         + ", motionVersion="
         + this.getMotionVersion()
         + ", partx="
         + this.getPartx()
         + ", party="
         + this.getParty()
         + ", currentLineGod="
         + this.getCurrentLineGod()
         + ", mac="
         + this.getMac()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachineInformationDTO)) {
         return false;
      }

      MachineInformationDTO other = (MachineInformationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$moveFixedDistanc = this.getMoveFixedDistanc();
         Object other$moveFixedDistanc = other.getMoveFixedDistanc();
         if (this$moveFixedDistanc == null ? other$moveFixedDistanc == null : this$moveFixedDistanc.equals(other$moveFixedDistanc)) {
            Object this$totalCutLength = this.getTotalCutLength();
            Object other$totalCutLength = other.getTotalCutLength();
            if (this$totalCutLength == null ? other$totalCutLength == null : this$totalCutLength.equals(other$totalCutLength)) {
               Object this$kerf = this.getKerf();
               Object other$kerf = other.getKerf();
               if (this$kerf == null ? other$kerf == null : this$kerf.equals(other$kerf)) {
                  Object this$partx = this.getPartx();
                  Object other$partx = other.getPartx();
                  if (this$partx == null ? other$partx == null : this$partx.equals(other$partx)) {
                     Object this$party = this.getParty();
                     Object other$party = other.getParty();
                     if (this$party == null ? other$party == null : this$party.equals(other$party)) {
                        Object this$fileName = this.getFileName();
                        Object other$fileName = other.getFileName();
                        if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                           Object this$cutState = this.getCutState();
                           Object other$cutState = other.getCutState();
                           if (this$cutState == null ? other$cutState == null : this$cutState.equals(other$cutState)) {
                              Object this$currentLineNum = this.getCurrentLineNum();
                              Object other$currentLineNum = other.getCurrentLineNum();
                              if (this$currentLineNum == null ? other$currentLineNum == null : this$currentLineNum.equals(other$currentLineNum)) {
                                 Object this$currentHoleNum = this.getCurrentHoleNum();
                                 Object other$currentHoleNum = other.getCurrentHoleNum();
                                 if (this$currentHoleNum == null ? other$currentHoleNum == null : this$currentHoleNum.equals(other$currentHoleNum)) {
                                    Object this$cutSpeed = this.getCutSpeed();
                                    Object other$cutSpeed = other.getCutSpeed();
                                    if (this$cutSpeed == null ? other$cutSpeed == null : this$cutSpeed.equals(other$cutSpeed)) {
                                       Object this$totalPierceCount = this.getTotalPierceCount();
                                       Object other$totalPierceCount = other.getTotalPierceCount();
                                       if (this$totalPierceCount == null
                                          ? other$totalPierceCount == null
                                          : this$totalPierceCount.equals(other$totalPierceCount)) {
                                          Object this$estimateCutTime = this.getEstimateCutTime();
                                          Object other$estimateCutTime = other.getEstimateCutTime();
                                          if (this$estimateCutTime == null ? other$estimateCutTime == null : this$estimateCutTime.equals(other$estimateCutTime)
                                             )
                                           {
                                             Object this$currentCutTime = this.getCurrentCutTime();
                                             Object other$currentCutTime = other.getCurrentCutTime();
                                             if (this$currentCutTime == null ? other$currentCutTime == null : this$currentCutTime.equals(other$currentCutTime)) {
                                                Object this$softRunTime = this.getSoftRunTime();
                                                Object other$softRunTime = other.getSoftRunTime();
                                                if (this$softRunTime == null ? other$softRunTime == null : this$softRunTime.equals(other$softRunTime)) {
                                                   Object this$motionVersion = this.getMotionVersion();
                                                   Object other$motionVersion = other.getMotionVersion();
                                                   if (this$motionVersion == null
                                                      ? other$motionVersion == null
                                                      : this$motionVersion.equals(other$motionVersion)) {
                                                      Object this$currentLineGod = this.getCurrentLineGod();
                                                      Object other$currentLineGod = other.getCurrentLineGod();
                                                      if (this$currentLineGod == null
                                                         ? other$currentLineGod == null
                                                         : this$currentLineGod.equals(other$currentLineGod)) {
                                                         Object this$mac = this.getMac();
                                                         Object other$mac = other.getMac();
                                                         return this$mac == null ? other$mac == null : this$mac.equals(other$mac);
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
      return other instanceof MachineInformationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $moveFixedDistanc = this.getMoveFixedDistanc();
      result = result * 59 + ($moveFixedDistanc == null ? 43 : $moveFixedDistanc.hashCode());
      Object $totalCutLength = this.getTotalCutLength();
      result = result * 59 + ($totalCutLength == null ? 43 : $totalCutLength.hashCode());
      Object $kerf = this.getKerf();
      result = result * 59 + ($kerf == null ? 43 : $kerf.hashCode());
      Object $partx = this.getPartx();
      result = result * 59 + ($partx == null ? 43 : $partx.hashCode());
      Object $party = this.getParty();
      result = result * 59 + ($party == null ? 43 : $party.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $cutState = this.getCutState();
      result = result * 59 + ($cutState == null ? 43 : $cutState.hashCode());
      Object $currentLineNum = this.getCurrentLineNum();
      result = result * 59 + ($currentLineNum == null ? 43 : $currentLineNum.hashCode());
      Object $currentHoleNum = this.getCurrentHoleNum();
      result = result * 59 + ($currentHoleNum == null ? 43 : $currentHoleNum.hashCode());
      Object $cutSpeed = this.getCutSpeed();
      result = result * 59 + ($cutSpeed == null ? 43 : $cutSpeed.hashCode());
      Object $totalPierceCount = this.getTotalPierceCount();
      result = result * 59 + ($totalPierceCount == null ? 43 : $totalPierceCount.hashCode());
      Object $estimateCutTime = this.getEstimateCutTime();
      result = result * 59 + ($estimateCutTime == null ? 43 : $estimateCutTime.hashCode());
      Object $currentCutTime = this.getCurrentCutTime();
      result = result * 59 + ($currentCutTime == null ? 43 : $currentCutTime.hashCode());
      Object $softRunTime = this.getSoftRunTime();
      result = result * 59 + ($softRunTime == null ? 43 : $softRunTime.hashCode());
      Object $motionVersion = this.getMotionVersion();
      result = result * 59 + ($motionVersion == null ? 43 : $motionVersion.hashCode());
      Object $currentLineGod = this.getCurrentLineGod();
      result = result * 59 + ($currentLineGod == null ? 43 : $currentLineGod.hashCode());
      Object $mac = this.getMac();
      return result * 59 + ($mac == null ? 43 : $mac.hashCode());
   }

   public static class MachineInformationDTOBuilder {
      private Long id;
      private String fileName;
      private String cutState;
      private String currentLineNum;
      private String currentHoleNum;
      private String cutSpeed;
      private String totalPierceCount;
      private Double moveFixedDistanc;
      private Double totalCutLength;
      private Double kerf;
      private String estimateCutTime;
      private String currentCutTime;
      private String softRunTime;
      private String motionVersion;
      private Double partx;
      private Double party;
      private String currentLineGod;
      private String mac;

      MachineInformationDTOBuilder() {
      }

      @JsonProperty("id")
      public MachineInformationDTO.MachineInformationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("fileName")
      public MachineInformationDTO.MachineInformationDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("cutState")
      public MachineInformationDTO.MachineInformationDTOBuilder cutState(final String cutState) {
         this.cutState = cutState;
         return this;
      }

      @JsonProperty("currentLineNum")
      public MachineInformationDTO.MachineInformationDTOBuilder currentLineNum(final String currentLineNum) {
         this.currentLineNum = currentLineNum;
         return this;
      }

      @JsonProperty("currentHoleNum")
      public MachineInformationDTO.MachineInformationDTOBuilder currentHoleNum(final String currentHoleNum) {
         this.currentHoleNum = currentHoleNum;
         return this;
      }

      @JsonProperty("cutSpeed")
      public MachineInformationDTO.MachineInformationDTOBuilder cutSpeed(final String cutSpeed) {
         this.cutSpeed = cutSpeed;
         return this;
      }

      @JsonProperty("totalPierceCount")
      public MachineInformationDTO.MachineInformationDTOBuilder totalPierceCount(final String totalPierceCount) {
         this.totalPierceCount = totalPierceCount;
         return this;
      }

      @JsonProperty("moveFixedDistanc")
      public MachineInformationDTO.MachineInformationDTOBuilder moveFixedDistanc(final Double moveFixedDistanc) {
         this.moveFixedDistanc = moveFixedDistanc;
         return this;
      }

      @JsonProperty("totalCutLength")
      public MachineInformationDTO.MachineInformationDTOBuilder totalCutLength(final Double totalCutLength) {
         this.totalCutLength = totalCutLength;
         return this;
      }

      @JsonProperty("kerf")
      public MachineInformationDTO.MachineInformationDTOBuilder kerf(final Double kerf) {
         this.kerf = kerf;
         return this;
      }

      @JsonProperty("estimateCutTime")
      public MachineInformationDTO.MachineInformationDTOBuilder estimateCutTime(final String estimateCutTime) {
         this.estimateCutTime = estimateCutTime;
         return this;
      }

      @JsonProperty("currentCutTime")
      public MachineInformationDTO.MachineInformationDTOBuilder currentCutTime(final String currentCutTime) {
         this.currentCutTime = currentCutTime;
         return this;
      }

      @JsonProperty("softRunTime")
      public MachineInformationDTO.MachineInformationDTOBuilder softRunTime(final String softRunTime) {
         this.softRunTime = softRunTime;
         return this;
      }

      @JsonProperty("motionVersion")
      public MachineInformationDTO.MachineInformationDTOBuilder motionVersion(final String motionVersion) {
         this.motionVersion = motionVersion;
         return this;
      }

      @JsonProperty("partx")
      public MachineInformationDTO.MachineInformationDTOBuilder partx(final Double partx) {
         this.partx = partx;
         return this;
      }

      @JsonProperty("party")
      public MachineInformationDTO.MachineInformationDTOBuilder party(final Double party) {
         this.party = party;
         return this;
      }

      @JsonProperty("currentLineGod")
      public MachineInformationDTO.MachineInformationDTOBuilder currentLineGod(final String currentLineGod) {
         this.currentLineGod = currentLineGod;
         return this;
      }

      @JsonProperty("mac")
      public MachineInformationDTO.MachineInformationDTOBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      public MachineInformationDTO build() {
         return new MachineInformationDTO(
            this.id,
            this.fileName,
            this.cutState,
            this.currentLineNum,
            this.currentHoleNum,
            this.cutSpeed,
            this.totalPierceCount,
            this.moveFixedDistanc,
            this.totalCutLength,
            this.kerf,
            this.estimateCutTime,
            this.currentCutTime,
            this.softRunTime,
            this.motionVersion,
            this.partx,
            this.party,
            this.currentLineGod,
            this.mac
         );
      }

      @Override
      public String toString() {
         return "MachineInformationDTO.MachineInformationDTOBuilder(id="
            + this.id
            + ", fileName="
            + this.fileName
            + ", cutState="
            + this.cutState
            + ", currentLineNum="
            + this.currentLineNum
            + ", currentHoleNum="
            + this.currentHoleNum
            + ", cutSpeed="
            + this.cutSpeed
            + ", totalPierceCount="
            + this.totalPierceCount
            + ", moveFixedDistanc="
            + this.moveFixedDistanc
            + ", totalCutLength="
            + this.totalCutLength
            + ", kerf="
            + this.kerf
            + ", estimateCutTime="
            + this.estimateCutTime
            + ", currentCutTime="
            + this.currentCutTime
            + ", softRunTime="
            + this.softRunTime
            + ", motionVersion="
            + this.motionVersion
            + ", partx="
            + this.partx
            + ", party="
            + this.party
            + ", currentLineGod="
            + this.currentLineGod
            + ", mac="
            + this.mac
            + ")";
      }
   }
}
