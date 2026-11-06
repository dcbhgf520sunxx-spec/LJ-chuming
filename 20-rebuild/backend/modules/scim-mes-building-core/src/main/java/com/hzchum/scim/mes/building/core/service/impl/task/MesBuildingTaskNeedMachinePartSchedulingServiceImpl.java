package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.MonomerAndArea;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuPartDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.third_party_api.BoChuNesting;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskFastBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.enums.MachinePartSchedulingIssueStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.ApproveTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutSendEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.IssuedToNestingSoftwareStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskNeedMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.PickingPartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.SpecificationMaterialKey;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.SpecificationMaterialPartKey;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestingApprove;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartNoProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingGuidDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingJobDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingPdfDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingProductInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestCutFileTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestPartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestPdfDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestingQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestingTaskFailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.PartInfoNestingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.PropsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.TaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkshopTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ApprovePartRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CreateDto;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CutTaskRequestData;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuNestingResultNewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestTeamConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingPartCheckDrillDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.NestResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.PicturePathDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BoChuDXFUploadDataParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BoChuDXFUploadParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BoChuDXFUploadPropParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BoChuJobAddParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobUpdateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuNestingJobByGuidDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuNestingResultByGuidJob;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuNestingResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuSteelPlateByGuidDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuSteelPlateByJobIdDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingExportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingLXDSExportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingNCExportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestTeamConfigService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestingApproveService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartNoProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.biz.impl.utils.Rectangle;
import com.hzchum.scim.mes.building.core.client.CutTaskClient;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingMapper;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestTeamConfigMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingJson;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingPlateFileJson;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingPlateJson;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.PartDrawingLayerSettingDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingJsonService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingPlateFileJsonService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingPlateJsonService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.PickingStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialFreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingService;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Service
public class MesBuildingTaskNeedMachinePartSchedulingServiceImpl
   extends ServiceImpl<MesBuildingTaskNeedMachinePartSchedulingMapper, MesBuildingTaskNeedMachinePartScheduling>
   implements MesBuildingTaskNeedMachinePartSchedulingService {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskNeedMachinePartSchedulingServiceImpl.class);
   @Value("${chum.bochuNestingDiagramPath}")
   private String bochuNestingDiagramPath;
   private static final String TEAM_CODE = "N6Y1RZ";
   private static String URLONE = "ws://pulsar-ws.fscut.com/ws/v2/consumer/non-persistent/prod/cloudnest/open_platform_";
   private static String URLTWO = "/Exclusive1?consumerName=gc-client1&receiverQueueSize=30&subscriptionType=Exclusive";
   @Resource
   WmsPickingService wmsPickingService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   private MesBuildingMachinePartNoProcessService mesBuildingMachinePartNoProcessService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private NestBiz nestBiz;
   @Resource
   BasicConfigService basicConfigService;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;
   @Autowired
   private MesBuildingCutConfigBiz mesBuildingCutConfigService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Resource
   private MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;
   @Autowired
   private MesBuildingNestingTeamService mesBuildingNestingTeamService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;
   @Value("${chum.config.url}")
   private String ip;
   @Value("${chum.config.filePath}")
   private String dxfPath;
   @Value("${chum.config.filePath}")
   private String nestPath;
   @Resource
   private CutTaskClient cutTaskClient;
   @Resource
   private SysDictionaryService sysDictionaryService;
   @Autowired
   private MesBuildingNestingJsonService mesBuildingNestingJsonService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Value("${chum.config.filePath}")
   private String filePath;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Resource
   private MesBuildingNestTeamConfigMapper mesBuildingNestTeamConfigMapper;
   @Resource
   private OutboundService outboundService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private MesBuildingMachinePartSchedulingMapper mesBuildingMachinePartSchedulingMapper;
   @Resource
   private UserService userService;
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Resource
   private MesBuildingNestTeamConfigService mesBuildingNestTeamConfigService;
   @Resource
   private SysSteelClassificationService steelClassificationService;
   @Resource
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Autowired
   private MesBuildingMachinePartSchedulingService mesBuildingMachinePartSchedulingService;
   @Autowired
   private MesBuildingNestCutPlateService mesBuildingNestCutPlateService;
   @Autowired
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Autowired
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Resource
   private MesBuildingTaskFastBiz taskFastBiz;
   @Resource
   private MesBuildingNestTaskBiz mesBuildingNestTaskBiz;
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingNestingApproveService mesBuildingNestingApproveService;
   @Autowired
   private MesBuildingNestingPlateFileJsonService mesBuildingNestingPlateFileJsonService;
   @Resource
   private MesBuildingTeamUserLinkService mesBuildingTeamUserLinkService;
   @Resource
   private MesBuildingTeamService teamService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Resource
   private ConfigService configService;
   @Autowired
   private InitializationService sqlService;
   @Resource
   private MesBuildingNestingPlateJsonService mesBuildingNestingPlateJsonService;

   private static void formatGetYearMonthArrayStr(MachinePartNestingTeamDTOParam param) {
      List<Long> monthList = param.getYearMonthArray();
      String yearMonth = monthList.stream()
         .map(ts -> Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM")))
         .collect(Collectors.joining(","));
      param.setYearMonth(yearMonth);
      param.setYearMonthArrayStr(Arrays.asList(yearMonth.split(",")));
   }

   private static void formatGetYearMonthArrayStrTwo(MachinePartNestingProductDetailDTOParam param) {
      List<Long> monthList = param.getYearMonthArray();
      String yearMonth = monthList.stream()
         .map(ts -> Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM")))
         .collect(Collectors.joining(","));
      param.setYearMonth(yearMonth);
      param.setYearMonthArrayStr(Arrays.asList(yearMonth.split(",")));
   }

   public static Integer checkNestingStatus(List<MachinePartNestingJobDetailDTO> machinePartNestingJobDetailDTOList) {
      boolean allFinished = true;
      boolean allNotStarted = true;
      boolean anyNotFinished = false;

      for (MachinePartNestingJobDetailDTO detail : machinePartNestingJobDetailDTOList) {
         int amount = detail.getAmount();
         int unNestAmount = detail.getUn_nest_amount();
         int finishNestAmount = detail.getFinish_nest_amount();
         if (unNestAmount > 0) {
            allFinished = false;
            anyNotFinished = true;
         }

         if (finishNestAmount > 0) {
            allNotStarted = false;
         }

         if (finishNestAmount < amount) {
            anyNotFinished = true;
         }
      }

      if (allFinished) {
         return 1;
      } else if (allNotStarted) {
         return 0;
      } else {
         return anyNotFinished ? 2 : 3;
      }
   }

   public static List<MesBuildingBoChuJobDirectoryDTO> mergeDirectories(List<MesBuildingBoChuJobDirectoryDTO> directories) {
      Map<String, MesBuildingBoChuJobDirectoryDTO> mergedDirectories = new LinkedHashMap<>();

      for (MesBuildingBoChuJobDirectoryDTO directory : directories) {
         if (mergedDirectories.containsKey(directory.getJobName())) {
            addSecondLevelDirectories(mergedDirectories.get(directory.getJobName()), directory.getChildren());
         } else {
            mergedDirectories.put(directory.getJobName(), directory);
         }
      }

      return new ArrayList<>(mergedDirectories.values());
   }

   private static void addSecondLevelDirectories(MesBuildingBoChuJobDirectoryDTO parent, List<MesBuildingBoChuJobDirectoryDTO> children) {
      if (children != null && !children.isEmpty()) {
         for (MesBuildingBoChuJobDirectoryDTO child : children) {
            boolean exists = false;

            for (MesBuildingBoChuJobDirectoryDTO existingChild : parent.getChildren()) {
               if (existingChild.getJobName().equals(child.getJobName())) {
                  addThirdLevelDirectories(existingChild, child.getChildren());
                  exists = true;
                  break;
               }
            }

            if (!exists) {
               parent.getChildren().add(child);
            }
         }
      }
   }

   private static void addThirdLevelDirectories(MesBuildingBoChuJobDirectoryDTO secondLevel, List<MesBuildingBoChuJobDirectoryDTO> thirdLevelChildren) {
      if (thirdLevelChildren != null && !thirdLevelChildren.isEmpty()) {
         for (MesBuildingBoChuJobDirectoryDTO thirdLevelChild : thirdLevelChildren) {
            boolean exists = false;

            for (MesBuildingBoChuJobDirectoryDTO existingThirdLevel : secondLevel.getChildren()) {
               if (existingThirdLevel.getJobName().equals(thirdLevelChild.getJobName())) {
                  exists = true;
                  break;
               }
            }

            secondLevel.getChildren().add(thirdLevelChild);
         }
      }
   }

   public static List<MesBuildingBoChuNestingResult> removeDuplicatesByGuid(List<MesBuildingBoChuNestingResult> resultList) {
      return resultList.stream()
         .collect(
            Collectors.toMap(MesBuildingBoChuNestingResult::getGuid, result -> (MesBuildingBoChuNestingResult)result, (existing, replacement) -> existing)
         )
         .values()
         .stream()
         .collect(Collectors.toList());
   }

   public static void main(String[] args) throws IOException {
      String wsJson = "{\"messageId\":\"CAAQADAA\",\"payload\":\"eyJ0eXBlIjogIlJlc3VsdFB1c2hNZXMiLCAib3BlcmF0aW9uIjogInVwZGF0ZSIsICJvcGVyYXRlX3RpbWUiOiAxNzMxMzA4MDUyLjk5NDU1MjEsICJvYmplY3RfaWQiOiBbIjNBQzkyNDdDLUIyRTktNDk0Mi1BQ0ZGLUE0NkE4RDZFQUQ2NSIsICJBQ0U3NTZFMC00M0JDLTQ2N0YtOUU4MS0yQ0FEMENFMjc0QUQiXSwgInRlYW1fY29kZSI6ICJONlkxUloiLCAidXNlcl9pZCI6IDIwMjE5NiwgImpvYl9pZCI6ICIxNzE2OTk4In0=\",\"properties\":{},\"publishTime\":\"2024-11-11T14:54:12.999+08:00\",\"redeliveryCount\":0}";
      JSONObject jsonObject = JSONObject.parseObject(wsJson);
      String payload = jsonObject.get("payload").toString();
      byte[] decode = Base64.getDecoder().decode(payload);
      String result = new String(decode);
      JSONObject resultObject = JSONObject.parseObject(result);
      String objectId = resultObject.get("object_id").toString();
      String jobId = resultObject.get("job_id").toString();
      JSONArray jsonGuidArray = JSONArray.parseArray(objectId);
      String systemTeamCode = "N6Y1RZ";
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/nspf_list/v2";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)response.getBody());
      JSONArray dataObject = j.getJSONArray("data");
      List<MesBuildingBoChuNestingResultDTO> mesBuildingBoChuNestingResultDTOList = JSON.parseObject(
         dataObject.toString(), new TypeReference<List<MesBuildingBoChuNestingResultDTO>>() {}
      );
      log.info("mesBuildingBoChuNestingResultDTOList:" + mesBuildingBoChuNestingResultDTOList);
   }

   public static byte[] readFileToByteArray(File file) throws IOException {
      try (
         InputStream inputStream = new FileInputStream(file);
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      ) {
         byte[] buffer = new byte[1024];

         int bytesRead;
         while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
         }

         return outputStream.toByteArray();
      }
   }

   public static <T> PageVO<T> listPage(Integer pageNum, Integer pageSize, List<T> collect) {
      Page<T> pages = new Page<>(pageNum, pageSize);
      int total = collect.size();
      pages.setTotal(total);
      int startIndex = (pageNum - 1) * pageSize;
      int endIndex = Math.min(startIndex + pageSize, total);
      pages.addAll(collect.subList(startIndex, endIndex));
      return new PageVO<>(pages);
   }

   public static void exportMistakeList(List<NestingTaskFailDTO> nestingTaskFailDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(nestingTaskFailDTOList)) {
         String title = "套料任务下发失败表";
         String sheetName = "套料任务下发失败表";
         String fileName = "套料任务下发失败表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("套料任务下发失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(nestingTaskFailDTOList, title, sheetName, NestingTaskFailDTO.class, fileName, ExcelType.XSSF, response);
      }

      try {
         response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "result");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
   }

   public static String[][] listToArray(List<List<String>> list) {
      int rows = list.size();
      if (rows == 0) {
         return new String[0][0];
      }

      int cols = list.stream().mapToInt(List::size).max().orElse(0);
      String[][] array = new String[rows][cols];

      for (int i = 0; i < rows; i++) {
         List<String> rowList = list.get(i);

         for (int j = 0; j < rowList.size(); j++) {
            array[i][j] = rowList.get(j);
         }
      }

      return array;
   }

   private static MachinePartNestingPdfDTO getNestingReportData(String resultId) {
      MachinePartNestingPdfDTO dto = new MachinePartNestingPdfDTO();
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(resultId);
      jsonObject.put("result_guid_list", jobIdArray);
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/web_report/nest_result_data";
      HttpHeaders headers = BoChuNesting.headers("N6Y1RZ");
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      log.info("Response from server: " + responseResult);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      JSONObject dataObject = j.getJSONObject("data");
      new ObjectMapper();

      try {
         log.info(dataObject.toString());
         dto = dataObject.toJavaObject(MachinePartNestingPdfDTO.class);
         System.out.println("Name: " + dto);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return dto;
   }

   public static String removeTrailingZeros(String str) {
      if (str.contains(".")) {
         BigDecimal number = new BigDecimal(str).stripTrailingZeros();
         return number.toPlainString();
      } else {
         return str.replaceAll("0+$", "");
      }
   }

   public static byte[] downloadImage(String imageUrl) throws IOException {
      URL url = new URL(imageUrl);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      if (connection.getResponseCode() != 200) {
         throw new IOException("Failed to fetch image: " + connection.getResponseMessage());
      }

      InputStream inputStream = connection.getInputStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[8192];

      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
         byteArrayOutputStream.write(buffer, 0, bytesRead);
      }

      byte[] imageBytes = byteArrayOutputStream.toByteArray();
      inputStream.close();
      byteArrayOutputStream.close();
      return imageBytes;
   }

   public static List<MesBuildingBoChuJobDirectoryDTO> mergeDirectoriesJobId(List<MesBuildingBoChuJobDirectoryDTO> directories) {
      Map<Integer, MesBuildingBoChuJobDirectoryDTO> mergedDirectories = new LinkedHashMap<>();

      for (MesBuildingBoChuJobDirectoryDTO directory : directories) {
         if (mergedDirectories.containsKey(directory.getJobId())) {
            addSubdirectoriesJobId(mergedDirectories.get(directory.getJobId()), directory);
         } else {
            mergedDirectories.put(directory.getJobId(), directory);
         }
      }

      return new ArrayList<>(mergedDirectories.values());
   }

   private static void addSubdirectoriesJobId(MesBuildingBoChuJobDirectoryDTO parent, MesBuildingBoChuJobDirectoryDTO child) {
      if (child.getChildren() != null && !child.getChildren().isEmpty()) {
         for (MesBuildingBoChuJobDirectoryDTO grandChild : child.getChildren()) {
            if (grandChild.getChildren() != null && !grandChild.getChildren().isEmpty()) {
               addSubdirectoriesToChildJobId(parent, grandChild);
            } else {
               addSubdirectoriesToThirdLevelJobId(parent, grandChild);
            }
         }
      }
   }

   private static void addSubdirectoriesToChildJobId(MesBuildingBoChuJobDirectoryDTO parent, MesBuildingBoChuJobDirectoryDTO child) {
      if (!containsJobId(parent.getChildren(), child.getJobId())) {
         parent.getChildren().add(child);
      } else {
         parent.getChildren().add(child);
      }
   }

   private static void addSubdirectoriesToThirdLevelJobId(MesBuildingBoChuJobDirectoryDTO parent, MesBuildingBoChuJobDirectoryDTO child) {
      if (!containsJobId(parent.getChildren(), child.getJobId())) {
         parent.getChildren().add(child);
      }
   }

   private static boolean containsJobId(List<MesBuildingBoChuJobDirectoryDTO> children, int jobId) {
      for (MesBuildingBoChuJobDirectoryDTO child : children) {
         if (child.getJobId() == jobId) {
            return true;
         }
      }

      return false;
   }

   @Override
   public List<MesBuildingTaskNeedMachinePartSchedulingDO> getNeedDetailByIds(List<Long> ids) {
      return this.baseMapper.getNeedDetailByIds(ids);
   }

   @Override
   public List<WorkshopDetailDO> getWorkShopList(MachinePartNestingTeamDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getYearMonthArray())) {
         List<Long> monthList = param.getYearMonthArray();
         String yearMonth = monthList.stream()
            .map(ts -> Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM")))
            .collect(Collectors.joining(","));
         param.setYearMonth(yearMonth);
      }

      List<ProjectSimpleInfoDTO> dtoList = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> !e.getStatus().equals(ProjectStatusEnum.COMPLETED.getType()))
         .collect(Collectors.toList());
      List<Long> projectIds = dtoList.stream().map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      }

      param.setProjectIds(projectIds);
      return this.baseMapper.getWorkShopList(param).stream().distinct().collect(Collectors.toList());
   }

   @Override
   public List<ProjectInfo> getProjectList(MachinePartNestingTeamDTOParam param) {
      Preconditions.checkArgument(param.getSendNestingStatus() != null, "下发状态不能为空");
      if (null != param.getYearMonthArray() && null != param.getWorkshopId()) {
         formatGetYearMonthArrayStr(param);
         List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList = this.baseMapper.getNeedMachinePartOrderList(param);
         return CollUtil.isNotEmpty(machinePartNestingTeamDTOList)
            ? machinePartNestingTeamDTOList.stream().map(MachinePartNestingTeamDTO::getProject).distinct().collect(Collectors.toList())
            : Collections.emptyList();
      } else {
         return Collections.emptyList();
      }
   }

   @Override
   public List<MachinePartNestingTeamDTO> getTeamList(MachinePartNestingTeamDTOParam param) {
      this.sqlService.updateSql("SET SESSION group_concat_max_len = 4194304");
      Preconditions.checkArgument(param.getSendNestingStatus() != null, "下发状态不能为空");
      if (null != param.getYearMonthArray() && null != param.getWorkshopId()) {
         formatGetYearMonthArrayStr(param);
         List<MachinePartNestingTeamDTO> needMachinePartOrderList = this.baseMapper.getNeedMachinePartOrderList(param);
         if (CollectionUtil.isNotEmpty(needMachinePartOrderList)) {
            List<Long> projectIdList = needMachinePartOrderList.stream().map(i -> i.getProject().getId()).distinct().collect(Collectors.toList());
            Map<Long, String> monomerNameMap = this.monomerService
               .lambdaQuery()
               .in(PlanMonomer::getProjectId, projectIdList)
               .list()
               .stream()
               .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
            Map<Long, String> areaNameMap = this.areaService
               .lambdaQuery()
               .in(PlanArea::getProjectId, projectIdList)
               .list()
               .stream()
               .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));

            for (MachinePartNestingTeamDTO machinePartNestingTeamDTO : needMachinePartOrderList) {
               List<TaskOrderDTO> taskOrderDTOList = new ArrayList<>();
               Long projectId = machinePartNestingTeamDTO.getProject().getId();

               for (MachinePartNestingTeamDTO machinePartNestingTeamDTO1 : needMachinePartOrderList) {
                  if (machinePartNestingTeamDTO1.getProject().getId().equals(projectId)) {
                     List<MonomerAndArea> monomerAndAreaList = StrUtil.split(machinePartNestingTeamDTO1.getMonomerAndAreaIds(), ",")
                        .stream()
                        .map(monomerAndAreaId -> {
                           List<Long> cMonomerAndAreaIdList = Convert.toList(Long.class, StrUtil.split(monomerAndAreaId, "&"));
                           Long monomerId = cMonomerAndAreaIdList.get(0);
                           Long areaId = cMonomerAndAreaIdList.get(1);
                           MonomerAndArea monomerAndArea = new MonomerAndArea();
                           monomerAndArea.setMonomerId(monomerId);
                           monomerAndArea.setMonomerName(monomerNameMap.get(monomerId));
                           monomerAndArea.setAreaId(areaId);
                           monomerAndArea.setAreaName(areaNameMap.get(areaId));
                           return monomerAndArea;
                        })
                        .collect(Collectors.toList());
                     TaskOrderDTO taskOrderDTO = machinePartNestingTeamDTO1.getTaskOrderDTO();
                     taskOrderDTO.setMonomerAndAreaList(monomerAndAreaList);
                     taskOrderDTOList.add(taskOrderDTO);
                  }
               }

               machinePartNestingTeamDTO.setTaskOrderDTOList(taskOrderDTOList);
            }

            Integer projectCount = 0;
            Integer needSchedulingQuantity = 0;
            Integer schedulingQuantity = 0;
            BigDecimal schedulingWeight = BigDecimal.ZERO;
            Integer scheduledQuantity = 0;
            BigDecimal scheduledWeight = BigDecimal.ZERO;

            for (MachinePartNestingTeamDTO dto : needMachinePartOrderList) {
               projectCount = projectCount + dto.getProjectCount();
               needSchedulingQuantity = needSchedulingQuantity + dto.getNeedSchedulingQuantity();
               schedulingQuantity = schedulingQuantity + dto.getSchedulingQuantity();
               schedulingWeight = schedulingWeight.add(dto.getSchedulingWeight());
               scheduledQuantity = scheduledQuantity + dto.getScheduledQuantity();
               scheduledWeight = scheduledWeight.add(dto.getScheduledWeight());
            }

            needMachinePartOrderList.get(0).setNeedSchedulingQuantity(needSchedulingQuantity);
            if (!param.getSendNestingStatus()) {
               needMachinePartOrderList.get(0).setSchedulingQuantity(schedulingQuantity);
               needMachinePartOrderList.get(0).setSchedulingWeight(schedulingWeight);
            } else {
               needMachinePartOrderList.get(0).setSchedulingQuantity(scheduledQuantity);
               needMachinePartOrderList.get(0).setSchedulingWeight(scheduledWeight);
            }

            needMachinePartOrderList = needMachinePartOrderList.stream()
               .collect(Collectors.toMap(dtox -> dtox.getProject().getId(), Function.identity(), (existing, replacement) -> existing))
               .values()
               .stream()
               .collect(Collectors.toList());
            needMachinePartOrderList.get(0).setProjectCount(needMachinePartOrderList.size());
         }

         return needMachinePartOrderList;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<MachinePartNestingDetailDTO> getNeedMachinePartDetailList(MachinePartNestingProductDetailDTOParam param, Integer pageNumber, Integer pageSize) {
      this.sqlService.updateSql("SET SESSION group_concat_max_len = 4194304");
      formatGetYearMonthArrayStrTwo(param);
      new ArrayList();
      if (CollectionUtils.isNotEmpty(param.getTaskTypeEnum())) {
         List<SysSteelClassification> sysSteelClassifications = this.steelClassificationService
            .list((Wrapper<SysSteelClassification>)new LambdaQueryWrapper<SysSteelClassification>().in(SysSteelClassification::getSteelPlateTypeEnum, param.getTaskTypeEnum()));
         if (CollectionUtils.isNotEmpty(sysSteelClassifications)) {
            List<Long> ids = sysSteelClassifications.stream().map(SysSteelClassification::getId).collect(Collectors.toList());
            param.setTaskTypeEnum(ids.stream().map(Long::intValue).collect(Collectors.toList()));
         }
      }

      List<MachinePartNestingDetailDTO> machinePartNestingDetailDTOList = this.baseMapper.getNeedMachinePartDetailList(param);
      if (!param.getSendNestingStatus()) {
         machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(i -> i.getQuantity() > 0).collect(Collectors.toList());
      } else {
         machinePartNestingDetailDTOList.forEach(i -> i.setQuantity(i.getSchedulingQuantity()));
      }

      Map<Long, String> pictureMap = new HashMap<>(10);
      Map<Long, Long> drwaingIdMap = new HashMap<>(10);
      if (CollectionUtils.isNotEmpty(machinePartNestingDetailDTOList)) {
         List<Long> machinePartIds = machinePartNestingDetailDTOList.stream().map(MachinePartNestingDetailDTO::getPartId).collect(Collectors.toList());

         for (PicturePathDTO picturePathDTO : (List<PicturePathDTO>)this.techDrawingService.selectMachDrawing(machinePartIds)) {
            pictureMap.put(picturePathDTO.getProductId(), picturePathDTO.getPicturePath());
            drwaingIdMap.put(picturePathDTO.getProductId(), picturePathDTO.getDrwaingId());
            if (picturePathDTO.getPicturePath() != null) {
               String picturePath = picturePathDTO.getPicturePath().replace("\\", "/");
               pictureMap.put(picturePathDTO.getProductId(), picturePath);
            }
         }

         machinePartNestingDetailDTOList.forEach(i -> {
            if (pictureMap.get(i.getPartId()) != null) {
               String filePath = this.dxfPath + pictureMap.get(i.getPartId());
               filePath = filePath.replace(".svg", ".dxf");
               File file = new File(filePath);
               if (file.isFile()) {
                  try {
                     i.setIsRectangle(Rectangle.isRectangleDXF(filePath, 2.0));
                  } catch (Exception e) {
                     log.info("dxf文件解析失败:{}", filePath);
                     i.setIsRectangle(-1);
                  }
               }
            } else {
               i.setIsRectangle(-1);
            }

            i.setPicturePath(pictureMap.get(i.getPartId()) == null ? null : this.ip + "files/" + pictureMap.get(i.getPartId()));
         });
         machinePartNestingDetailDTOList.forEach(i -> i.setDrwaingId(drwaingIdMap.get(i.getPartId()) == null ? null : drwaingIdMap.get(i.getPartId())));
      }

      Integer totalNeedQuantity = machinePartNestingDetailDTOList.stream().mapToInt(MachinePartNestingDetailDTO::getQuantity).sum();
      BigDecimal totalNeedWeight = machinePartNestingDetailDTOList.stream()
         .map(item -> item.getWeight().multiply(BigDecimal.valueOf(item.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      if (CollectionUtils.isNotEmpty(machinePartNestingDetailDTOList)) {
         machinePartNestingDetailDTOList.forEach(i -> i.setTotalSchedulingQuantity(totalNeedQuantity));
         machinePartNestingDetailDTOList.forEach(i -> i.setTotalNeedWeight(totalNeedWeight));
      }

      List<Integer> isRectangle = param.getIsRectangle();
      machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream()
         .filter(e -> isRectangle == null || isRectangle.contains(e.getIsRectangle()))
         .collect(Collectors.toList());
      machinePartNestingDetailDTOList.forEach(i -> {
         BigDecimal length1 = i.getLength();
         if (i.getPartType().equals("翼腹板")) {
            BigDecimal length = i.getLength();
            BigDecimal width = i.getWidth();
            i.setArea(length.multiply(width).multiply(new BigDecimal(i.getNeedQuantity())).divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
         }
      });
      Boolean boolDxfEnum = param.getBoolDxfEnum();
      if (boolDxfEnum == null) {
         return listPage(
            param.getPageNumber(),
            param.getPageSize(),
            machinePartNestingDetailDTOList.stream()
               .sorted(Comparator.comparing(MachinePartNestingDetailDTO::getIssuedToNestingSoftwareStatus).reversed())
               .collect(Collectors.toList())
         );
      }

      if (boolDxfEnum) {
         machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(e -> e.getPicturePath() != null).collect(Collectors.toList());
      } else {
         machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(e -> e.getPicturePath() == null).collect(Collectors.toList());
      }

      return listPage(
         param.getPageNumber(),
         param.getPageSize(),
         machinePartNestingDetailDTOList.stream()
            .sorted(Comparator.comparing(MachinePartNestingDetailDTO::getIssuedToNestingSoftwareStatus).reversed())
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<String> getThickList(MachinePartNestingProductDetailDTOParam param) {
      new ArrayList();
      List<MachinePartNestingDetailDTO> machinePartNestingDetailDTOList = this.baseMapper.getNeedMachinePartDetailList(param);
      List<String> thickList = machinePartNestingDetailDTOList.stream().map(MachinePartNestingDetailDTO::getThick).distinct().collect(Collectors.toList());
      thickList.sort(Comparator.naturalOrder());
      return thickList;
   }

   @Override
   public List<String> getMaterialList(MachinePartNestingProductDetailDTOParam param) {
      new ArrayList();
      List<MachinePartNestingDetailDTO> machinePartNestingDetailDTOList = this.baseMapper.getNeedMachinePartDetailList(param);
      return machinePartNestingDetailDTOList.stream().map(MachinePartNestingDetailDTO::getMaterial).distinct().collect(Collectors.toList());
   }

   @Override
   public List<SteelClassificationDTO> getPartTypeList(MachinePartNestingProductDetailDTOParam param) {
      List<MachinePartNestingDetailDTO> machinePartNestingDetailDTOList = this.baseMapper.getNeedMachinePartDetailList(param);
      List<Long> partTypeIds = machinePartNestingDetailDTOList.stream().map(MachinePartNestingDetailDTO::getPartTypeId).distinct().collect(Collectors.toList());
      return Optional.ofNullable(partTypeIds).filter(CollUtil::isNotEmpty).map(this.steelClassificationService::listSteel).orElseGet(Collections::emptyList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String sendToNestingTwo(MesBuildingMachinePartNestingParam mesBuildingMachinePartNestingParam, HttpServletResponse response) {
      Preconditions.checkArgument(mesBuildingMachinePartNestingParam.getTeamCode() != null, "团队码不能为空");
      Preconditions.checkArgument(mesBuildingMachinePartNestingParam.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(mesBuildingMachinePartNestingParam.getCompletionDate() != null, "完成日期不能为空");
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingMachinePartNestingParam.getMachinePartList()), "需要套料的零件集合不能为空");
      Long teamCode = mesBuildingMachinePartNestingParam.getTeamCode();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCode);
      String sysTemTeamCode = mesBuildingNestingTeam.getTeamCode();
      User nestingChargePerson = this.userService.getById(mesBuildingNestingTeam.getNestingChargePerson());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingChargePerson), "套料团队负责人不存在, 请检查套料团队配置");
      List<MachinePartParam> machineParts = mesBuildingMachinePartNestingParam.getMachinePartList();
      Map<Long, List<MachinePartParam>> machinePartListMap = machineParts.stream().collect(Collectors.groupingBy(MachinePartParam::getTaskOrderId));
      List<NestingTaskFailDTO> nestingTaskFailResultDTOList = new ArrayList<>();
      AtomicReference<Long> mesBuildingNestTeamConfigId = new AtomicReference<>(0L);
      List<MachinePartParam> machinePartList = mesBuildingMachinePartNestingParam.getMachinePartList();
      Boolean isSuccess = false;

      for (MachinePartParam machinePartParam : machinePartList) {
         List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigList = this.mesBuildingNestTeamConfigService
            .list(
               (Wrapper<MesBuildingNestTeamConfig>)(new LambdaQueryWrapper<MesBuildingNestTeamConfig>()
                     .eq(MesBuildingNestTeamConfig::getTeamId, machinePartParam.getTeamId()))
                  .eq(MesBuildingNestTeamConfig::getWorkshopId, machinePartParam.getWorkshopId())
            );
         MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(machinePartParam.getWorkshopId());
         MesBuildingNestTeamConfigDTO mesBuildingNestTeamConfigDTO = this.mesBuildingNestTeamConfigMapper
            .selectNeedNestTeamConfig(machinePartParam.getTeamId())
            .get(0);
         if (CollectionUtil.isEmpty(mesBuildingNestTeamConfigList)) {
            try {
               response.setHeader(
                  "result",
                  "code=400;message="
                     + URLEncoder.encode(
                        "未找到班组代号配置，请先到配置管理中配置套料切割配置:车间："
                           + mesBuildingWorkshop.getName()
                           + "，工序："
                           + mesBuildingNestTeamConfigDTO.getProcessName()
                           + "，班组："
                           + mesBuildingNestTeamConfigDTO.getTeamName(),
                        "UTF-8"
                     )
               );
               response.setHeader("Access-Control-Expose-Headers", "result");
            } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
            }

            isSuccess = true;
            break;
         }
      }

      if (isSuccess) {
         return "未找到班组代号配置";
      }

      List<MesBuildingBoChuJobDirectory> allJobDirectorieList = this.mesBuildingBoChuJobDirectoryService.list();
      machinePartListMap.forEach(
         (taskOrderId, machinePartParamList) -> {
            List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingListByTaskOrder = this.baseMapper
               .selectList(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                        .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId))
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, 1)
               );
            List<BoChuDXFUploadParam> boChuDXFUploadParamList = new ArrayList<>();
            List<String> fileList = new ArrayList<>();
            MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
            machinePartParamList.forEach(
               machinePart -> {
                  if (!mesBuildingTaskNeedMachinePartSchedulingListByTaskOrder.stream().anyMatch(e -> e.getProductId().equals(machinePart.getMachinePartId()))) {
                     BoChuDXFUploadParam boChuJobUploadParam = new BoChuDXFUploadParam();
                     TechMachinePart techMachinePart = this.techMachinePartService.getById(machinePart.getMachinePartId());
                     Preconditions.checkArgument(techMachinePart != null, "零件未找到，零件id：" + machinePart.getMachinePartId());
                     String serialNumber = techMachinePart.getSerialNumber();
                     Long monomerId = techMachinePart.getMonomerId();
                     List<TechDrawing> techDrawingList = this.techDrawingService
                        .list(
                           new LambdaQueryWrapper<>(TechDrawing.class).eq(TechDrawing::getMonomerId, monomerId).eq(TechDrawing::getSerialNumber, serialNumber)
                        );
                     if (CollectionUtils.isNotEmpty(techDrawingList)) {
                        TechDrawing techDrawing = techDrawingList.get(0);
                        String filePathNext = techDrawing.getFilePath();
                        String filePathNextWithSeparator = filePathNext.replace("/", File.separator);
                        String fileName = techDrawing.getFileName();
                        String fileFinal = this.filePath + filePathNextWithSeparator + fileName;
                        if (!FileUtil.exist(fileFinal)) {
                           try {
                              response.setHeader("result", "code=400;message=" + URLEncoder.encode("文件不存在，文件路径：" + fileFinal, "UTF-8"));
                              response.setHeader("Access-Control-Expose-Headers", "result");
                           } catch (UnsupportedEncodingException e) {
                              throw new RuntimeException(e);
                           }

                           Preconditions.checkArgument(FileUtil.exist(fileFinal), "文件不存在，文件路径：" + fileFinal);
                        }

                        boChuJobUploadParam.setFilename(fileName);
                        BoChuDXFUploadDataParam boChuDXFUploadDataParam = new BoChuDXFUploadDataParam();
                        boChuDXFUploadDataParam.setAmount(new BigDecimal(machinePart.getQuantity()));
                        boChuDXFUploadDataParam.setGas("Air");
                        boChuDXFUploadDataParam.setMaterial(techMachinePart.getMaterial());
                        boChuDXFUploadDataParam.setRotate_lock(0);
                        boChuDXFUploadDataParam.setThickness(new BigDecimal(techMachinePart.getThick()));
                        Long teamId = machinePart.getTeamId();
                        List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigListx = this.mesBuildingNestTeamConfigService
                           .list(
                              (Wrapper<MesBuildingNestTeamConfig>)(new LambdaQueryWrapper<MesBuildingNestTeamConfig>()
                                    .eq(MesBuildingNestTeamConfig::getTeamId, teamId))
                                 .eq(MesBuildingNestTeamConfig::getWorkshopId, machinePart.getWorkshopId())
                           );
                        MesBuildingWorkshop mesBuildingWorkshopxx = this.mesBuildingWorkshopService.getById(machinePart.getWorkshopId());
                        MesBuildingNestTeamConfigDTO mesBuildingNestTeamConfigDTOx = this.mesBuildingNestTeamConfigMapper
                           .selectNeedNestTeamConfig(teamId)
                           .get(0);
                        if (CollectionUtil.isEmpty(mesBuildingNestTeamConfigListx)) {
                           try {
                              response.setHeader(
                                 "result",
                                 "code=400;message="
                                    + URLEncoder.encode(
                                       "未找到班组代号配置，请先到配置管理中配置套料切割配置:车间："
                                          + mesBuildingWorkshopxx.getName()
                                          + "，工序："
                                          + mesBuildingNestTeamConfigDTOx.getProcessName()
                                          + "，班组："
                                          + mesBuildingNestTeamConfigDTOx.getTeamName(),
                                       "UTF-8"
                                    )
                              );
                              response.setHeader("Access-Control-Expose-Headers", "result");
                           } catch (UnsupportedEncodingException e) {
                              e.printStackTrace();
                           }
                        }

                        boChuDXFUploadDataParam.setPart_name(techMachinePart.getSerialNumber());
                        if (CollectionUtil.isNotEmpty(mesBuildingNestTeamConfigListx)) {
                           MesBuildingNestTeamConfig mesBuildingNestTeamConfig = mesBuildingNestTeamConfigListx.get(0);
                           mesBuildingNestTeamConfigId.set(mesBuildingNestTeamConfig.getId());
                           if (mesBuildingNestTeamConfig.getBoolShowCodename()) {
                              String codeName = mesBuildingNestTeamConfig.getCodeName();
                              if (mesBuildingNestTeamConfig.getDisplayRule()) {
                                 if (mesBuildingNestTeamConfig.getCodeRule()) {
                                    codeName = "-" + codeName;
                                 } else {
                                    codeName = codeName + "-";
                                 }
                              } else {
                                 codeName = "(" + codeName + ")";
                              }

                              if (mesBuildingNestTeamConfig.getCodeRule()) {
                                 boChuDXFUploadDataParam.setPart_name(techMachinePart.getSerialNumber() + codeName);
                              } else {
                                 boChuDXFUploadDataParam.setPart_name(codeName + techMachinePart.getSerialNumber());
                              }
                           }
                        }

                        List<MesBuildingTeamUserLink> mesBuildingTeamUserLinkList = this.baseMapper.getTeamLeaderName(teamId);
                        if (CollectionUtils.isNotEmpty(mesBuildingTeamUserLinkList)) {
                           BoChuDXFUploadPropParam boChuDXFUploadPropParam = new BoChuDXFUploadPropParam();
                           boChuDXFUploadPropParam.set班组(mesBuildingTeamUserLinkList.get(0).getUserName());
                           boChuDXFUploadPropParam.setProductId(machinePart.getMachinePartId());
                           boChuDXFUploadPropParam.setProjectId(machinePart.getProjectId());
                           boChuDXFUploadPropParam.setTaskOrderId(machinePart.getTaskOrderId());
                           boChuDXFUploadPropParam.setTechDrawingId(techDrawing.getId());
                           boChuDXFUploadDataParam.setProp(boChuDXFUploadPropParam);
                        }

                        boChuJobUploadParam.setDatas(boChuDXFUploadDataParam);
                        boChuDXFUploadParamList.add(boChuJobUploadParam);
                        fileList.add(fileFinal);
                     } else {
                        log.info("未找到零件图纸，零件id：" + machinePart.getSerialNumber());
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(techDrawingList), "未找到零件图纸，零件id：" + machinePart.getSerialNumber());
                     }
                  }
               }
            );
            if (!CollectionUtils.isEmpty(boChuDXFUploadParamList)) {
               MesBuildingWorkshop mesBuildingWorkshopx = this.mesBuildingWorkshopService.getById(mesBuildingMachinePartNestingParam.getWorkshopId());
               Preconditions.checkArgument(mesBuildingWorkshopx != null, "车间不存在");
               String workshopName = mesBuildingWorkshopx.getName();
               Long workshopId = mesBuildingWorkshopx.getId();
               List<Long> projectIds = machinePartParamList.stream().map(MachinePartParam::getProjectId).distinct().collect(Collectors.toList());
               List<Long> teamIds = machinePartParamList.stream().map(MachinePartParam::getTeamId).distinct().collect(Collectors.toList());
               String teamIdsStr = teamIds.stream().map(String::valueOf).collect(Collectors.joining(","));
               Preconditions.checkArgument(teamIds.size() > 0, "未找到班组信息");
               BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
               String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
               StringBuilder projectIdsStr = new StringBuilder();
               StringBuilder titleFolder = new StringBuilder();
               StringBuilder titleFile = new StringBuilder();
               if (projectIds.size() == 1) {
                  ContractProject project = this.projectService.getById(projectIds.get(0));
                  String shortName = project.getShortName();
                  projectIdsStr = projectIdsStr.append(project.getId());
                  titleFolder = titleFolder.append(shortName);
               }

               titleFile = titleFile.append(mesBuildingTaskOrder.getOrderNumber());
               List<Integer> jobIds = new ArrayList<>();
               List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryWorkshopList = this.baseMapper
                  .getMesBuildingBoChuJobDirectoryByWorkshopId(workshopId.toString(), teamCode);
               Integer workFileId;
               if (CollectionUtil.isEmpty(mesBuildingBoChuJobDirectoryWorkshopList)) {
                  boChuJobAddParam.setParent_id(-1);
                  boChuJobAddParam.setType(0);
                  boChuJobAddParam.setRead_only(0);
                  boChuJobAddParam.setTitle(workshopName + "(" + nestingChargePerson.getName() + ")");
                  workFileId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                  jobIds.add(workFileId);
                  MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = new MesBuildingBoChuJobDirectory();
                  mesBuildingBoChuJobDirectory.setJobName(workshopName + "(" + nestingChargePerson.getName() + ")");
                  mesBuildingBoChuJobDirectory.setJobId(workFileId);
                  mesBuildingBoChuJobDirectory.setParentId(-1);
                  mesBuildingBoChuJobDirectory.setJobType(0);
                  mesBuildingBoChuJobDirectory.setWorkshopId(workshopId.toString());
                  mesBuildingBoChuJobDirectory.setTeamCodeId(teamCode);
                  this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectory);
               } else {
                  workFileId = mesBuildingBoChuJobDirectoryWorkshopList.get(0).getJobId();
                  jobIds.add(workFileId);
               }

               List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.baseMapper
                  .getMesBuildingBoChuJobDirectoryByProjectId(projectIdsStr.toString(), workshopId.toString(), teamCode);
               Integer jobFileId;
               if (CollectionUtil.isNotEmpty(mesBuildingBoChuJobDirectoryList)) {
                  MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryFirst = mesBuildingBoChuJobDirectoryList.get(0);
                  Integer parentId = mesBuildingBoChuJobDirectoryFirst.getParentId();
                  List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryChildList = this.mesBuildingBoChuJobDirectoryService
                     .list(
                        (Wrapper<MesBuildingBoChuJobDirectory>)(((new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
                                    .eq(MesBuildingBoChuJobDirectory::getJobName, titleFile.toString()))
                                 .eq(MesBuildingBoChuJobDirectory::getWorkshopId, workshopId))
                              .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, teamCode))
                           .eq(MesBuildingBoChuJobDirectory::getParentId, parentId)
                     );
                  if (CollectionUtil.isNotEmpty(mesBuildingBoChuJobDirectoryChildList)) {
                     jobFileId = mesBuildingBoChuJobDirectoryChildList.get(0).getJobId();
                  } else {
                     boChuJobAddParam.setParent_id(parentId);
                     boChuJobAddParam.setType(1);
                     boChuJobAddParam.setRead_only(0);
                     boChuJobAddParam.setTitle(titleFile.toString());
                     jobFileId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                     if (jobFileId == null) {
                        boChuJobAddParam.setParent_id(workFileId);
                        boChuJobAddParam.setType(0);
                        boChuJobAddParam.setRead_only(0);
                        boChuJobAddParam.setTitle(titleFolder.toString());
                        Integer jobFolderId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                        jobIds.add(jobFolderId);
                        MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryFolder = new MesBuildingBoChuJobDirectory();
                        mesBuildingBoChuJobDirectoryFolder.setJobName(titleFolder.toString());
                        mesBuildingBoChuJobDirectoryFolder.setJobId(jobFolderId);
                        mesBuildingBoChuJobDirectoryFolder.setParentId(workFileId);
                        mesBuildingBoChuJobDirectoryFolder.setProjectId(projectIdsStr.toString());
                        mesBuildingBoChuJobDirectoryFolder.setJobType(0);
                        mesBuildingBoChuJobDirectoryFolder.setWorkshopId(workshopId.toString());
                        mesBuildingBoChuJobDirectoryFolder.setTeamCodeId(teamCode);
                        this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectoryFolder);
                        boChuJobAddParam.setParent_id(jobFolderId);
                        boChuJobAddParam.setType(1);
                        boChuJobAddParam.setRead_only(0);
                        boChuJobAddParam.setTitle(titleFile.toString());
                        jobFileId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                     }

                     jobIds.add(jobFileId);
                     MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = new MesBuildingBoChuJobDirectory();
                     mesBuildingBoChuJobDirectory.setJobName(titleFile.toString());
                     mesBuildingBoChuJobDirectory.setJobId(jobFileId);
                     mesBuildingBoChuJobDirectory.setParentId(parentId);
                     mesBuildingBoChuJobDirectory.setProjectId(projectIdsStr.toString());
                     mesBuildingBoChuJobDirectory.setJobType(1);
                     mesBuildingBoChuJobDirectory.setWorkshopId(workshopId.toString());
                     mesBuildingBoChuJobDirectory.setTeamId(teamIdsStr);
                     mesBuildingBoChuJobDirectory.setTeamCodeId(teamCode);
                     this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectory);
                  }
               } else {
                  boChuJobAddParam.setParent_id(workFileId);
                  boChuJobAddParam.setType(0);
                  boChuJobAddParam.setRead_only(0);
                  boChuJobAddParam.setTitle(titleFolder.toString());
                  Integer jobFolderId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                  jobIds.add(jobFolderId);
                  MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryFolder = new MesBuildingBoChuJobDirectory();
                  mesBuildingBoChuJobDirectoryFolder.setJobName(titleFolder.toString());
                  mesBuildingBoChuJobDirectoryFolder.setJobId(jobFolderId);
                  mesBuildingBoChuJobDirectoryFolder.setParentId(workFileId);
                  mesBuildingBoChuJobDirectoryFolder.setProjectId(projectIdsStr.toString());
                  mesBuildingBoChuJobDirectoryFolder.setJobType(0);
                  mesBuildingBoChuJobDirectoryFolder.setWorkshopId(workshopId.toString());
                  mesBuildingBoChuJobDirectoryFolder.setTeamCodeId(teamCode);
                  this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectoryFolder);
                  boChuJobAddParam.setParent_id(jobFolderId);
                  boChuJobAddParam.setType(1);
                  boChuJobAddParam.setRead_only(0);
                  boChuJobAddParam.setTitle(titleFile.toString());
                  jobFileId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                  jobIds.add(jobFileId);
                  MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryJob = new MesBuildingBoChuJobDirectory();
                  mesBuildingBoChuJobDirectoryJob.setJobName(titleFile.toString());
                  mesBuildingBoChuJobDirectoryJob.setJobId(jobFileId);
                  mesBuildingBoChuJobDirectoryJob.setParentId(jobFolderId);
                  mesBuildingBoChuJobDirectoryJob.setProjectId(projectIdsStr.toString());
                  mesBuildingBoChuJobDirectoryJob.setJobType(1);
                  mesBuildingBoChuJobDirectoryJob.setWorkshopId(workshopId.toString());
                  mesBuildingBoChuJobDirectoryJob.setTeamId(teamIdsStr);
                  mesBuildingBoChuJobDirectoryJob.setTeamCodeId(teamCode);
                  this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectoryJob);
               }

               Integer finalJobFileId = jobFileId;
               boChuDXFUploadParamList.forEach(boChuDXFUploadParam -> boChuDXFUploadParam.setJobId(finalJobFileId));
               RestTemplate restTemplate = new RestTemplate();
               String url = "https://cloudnest.fscut.com/api/part/file2part";
               HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
               headers.setContentType(MediaType.MULTIPART_FORM_DATA);
               headers.set("X-FS-Encode", "utf-8");
               List<Boolean> flagList = new ArrayList<>();
               int totalDataSize = boChuDXFUploadParamList.size();

               for (int i = 0; i < totalDataSize; i += 50) {
                  int endIndex = Math.min(i + 50, totalDataSize);
                  List<BoChuDXFUploadParam> currentBatch = boChuDXFUploadParamList.subList(i, endIndex);
                  String jsonString = JSONObject.toJSONString(currentBatch);
                  jsonString = jsonString.replace(",{\"$ref\":\"$[0]\"}", "");
                  System.out.println(jsonString);
                  MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
                  body.add("data", jsonString);
                  List<String> cFileNameList = currentBatch.stream().map(BoChuDXFUploadParam::getFilename).collect(Collectors.toList());

                  for (int j = 0; j < fileList.size(); j++) {
                     String cFilePath = fileList.get(j);
                     String cFileName = StrUtil.subAfter(cFilePath, File.separator, true);
                     if (cFileNameList.contains(cFileName)) {
                        File fileR = new File(cFilePath);
                        body.add("files", new FileSystemResource(fileR));
                     }
                  }

                  body.add("ignore_error", 0);
                  HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
                  log.info("套料任务下发请求参数：" + body);
                  StopWatch stopWatch = new StopWatch();
                  stopWatch.start();

                  JSONObject jsonObject;
                  try {
                     jsonObject = new JSONObject((Map<String, Object>)restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class).getBody());
                  } catch (Exception e) {
                     log.error("调用 https://cloudnest.fscut.com/api/part/file2part 报错");
                     flagList.add(false);
                     continue;
                  }

                  stopWatch.stop();
                  log.info("套料任务下发耗时：" + stopWatch.getTotalTimeMillis() + "ms");
                  log.info("套料任务下发结果：" + jsonObject);
                  if (jsonObject.getIntValue("status") == 0) {
                     flagList.add(true);
                  } else {
                     flagList.add(false);
                     JSONArray failJson = jsonObject.getJSONArray("fail");
                     if (failJson != null && !failJson.isEmpty()) {
                        List<ContractProject> contractProjectList = this.projectService.listByIds(projectIds);
                        List<Long> taskOrderIds = machinePartParamList.stream().map(MachinePartParam::getTaskOrderId).distinct().collect(Collectors.toList());
                        List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService.listByIds(taskOrderIds);
                        String taskOrderIdsStr = mesBuildingTaskOrderList.stream().map(MesBuildingTaskOrder::getOrderNumber).collect(Collectors.joining(","));
                        String projectNameStr = contractProjectList.stream().map(ContractProject::getShortName).collect(Collectors.joining(","));
                        List<NestingTaskFailDTO> nestingTaskFailDTOList = failJson.toJavaList(NestingTaskFailDTO.class);
                        nestingTaskFailDTOList.forEach(nestingTaskFailDTO -> {
                           nestingTaskFailDTO.setProjectName(projectNameStr);
                           nestingTaskFailDTO.setTaskOrderNumber(taskOrderIdsStr);
                        });
                        nestingTaskFailResultDTOList.addAll(nestingTaskFailDTOList);
                     }
                  }
               }

               if (CollUtil.isNotEmpty(flagList) && flagList.stream().allMatch(f -> f)) {
                  machinePartParamList.forEach(
                     machinePart -> {
                        List<Long> taskOrderIdsx = machinePartParamList.stream().map(MachinePartParam::getTaskOrderId).distinct().collect(Collectors.toList());
                        List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingBiz
                           .list(
                              (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                    .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, machinePart.getMachinePartId()))
                                 .in(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderIdsx)
                           );
                        if (CollectionUtils.isNotEmpty(mesBuildingTaskNeedMachinePartSchedulingList)) {
                           mesBuildingTaskNeedMachinePartSchedulingList.forEach(mesBuildingTaskNeedMachinePartScheduling -> {
                              mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(UserUtil.getCurrentUserId());
                              mesBuildingTaskNeedMachinePartScheduling.setNestingJobId(finalJobFileId);
                              mesBuildingTaskNeedMachinePartScheduling.setSendNestingStatus(true);
                              mesBuildingTaskNeedMachinePartScheduling.setSchedulingDate(LocalDateTime.now());
                              mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(UserUtil.getCurrentUserId());
                              mesBuildingTaskNeedMachinePartScheduling.setNestTeamConfigId(mesBuildingNestTeamConfigId.get());
                              this.taskNeedMachinePartSchedulingBiz.updateById(mesBuildingTaskNeedMachinePartScheduling);
                           });
                        }
                     }
                  );
               } else {
                  jobIds.sort(Comparator.reverseOrder());
                  if (CollUtil.isNotEmpty(allJobDirectorieList) && allJobDirectorieList.stream().allMatch(jd -> jobIds.contains(jd.getJobId()))) {
                     List<MesBuildingBoChuJobDirectory> cjbList = allJobDirectorieList.stream()
                        .filter(jd -> jobIds.contains(jd.getJobId()))
                        .filter(jd -> Objects.equals(jd.getJobType(), 1))
                        .collect(Collectors.toList());
                     List<MachinePartNestingJobDetailDTO> machinePartNestingJobDetailDTOList = new ArrayList<>();
                     cjbList.forEach(cjb -> machinePartNestingJobDetailDTOList.addAll(this.getNestingJobPart(cjb.getJobId(), sysTemTeamCode)));
                     if (CollUtil.isNotEmpty(machinePartNestingJobDetailDTOList)) {
                        List<String> partNameList = boChuDXFUploadParamList.stream()
                           .map(boChuDXFUploadParam -> boChuDXFUploadParam.getDatas().getPart_name())
                           .collect(Collectors.toList());
                        JSONArray ja = new JSONArray();

                        for (MachinePartNestingJobDetailDTO mpnjd : machinePartNestingJobDetailDTOList) {
                           if (partNameList.contains(mpnjd.getPartName())) {
                              JSONObject jo = new JSONObject();
                              jo.put("guid", mpnjd.getGuid());
                              jo.put("is_delete", 1);
                              ja.add(jo);
                           }
                        }

                        if (!ja.isEmpty()) {
                           this.deleteNestingJobPart(ja, sysTemTeamCode);
                        }
                     }
                  } else {
                     jobIds.forEach(jobId -> this.deleteNestingJob(jobId, sysTemTeamCode));
                  }

                  Preconditions.checkArgument(false, "套料任务下发失败!");
               }
            }
         }
      );
      exportMistakeList(nestingTaskFailResultDTOList, response);
      return "套料任务下发成功";
   }

   private MistakeExportDTO buildMistakeDTO(String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(null);
      mistake.setErrorMessage(message);
      return mistake;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void sendToNestingV3(MesBuildingMachinePartNestingParam param, HttpServletResponse response) {
      if (param.getTeamCode() == null) {
         this.responseResult(response, "50000", "团队码不能为空");
         throw new BusinessException("团队码不能为空");
      }

      if (param.getWorkshopId() == null) {
         this.responseResult(response, "50000", "车间不能为空");
         throw new BusinessException("车间不能为空");
      }

      if (param.getCompletionDate() == null) {
         this.responseResult(response, "50000", "完成日期不能为空");
         throw new BusinessException("完成日期不能为空");
      }

      if (CollUtil.isEmpty(param.getMachinePartList())) {
         this.responseResult(response, "50000", "需要套料的零件集合不能为空");
         throw new BusinessException("需要套料的零件集合不能为空");
      }

      MesBuildingNestingTeam nestingTeam = this.mesBuildingNestingTeamService.getById(param.getTeamCode());
      if (BeanUtil.isEmpty(nestingTeam)) {
         this.responseResult(response, "50000", "套料团队不存在, 请检查套料团队配置");
         throw new BusinessException("套料团队不存在, 请检查套料团队配置");
      }

      String sysTemTeamCode = nestingTeam.getTeamCode();
      User nestingChargePerson = this.userService.getById(nestingTeam.getNestingChargePerson());
      if (BeanUtil.isEmpty(nestingChargePerson)) {
         this.responseResult(response, "50000", "套料团队负责人不存在, 请检查套料团队配置");
         throw new BusinessException("套料团队负责人不存在, 请检查套料团队配置");
      }

      List<Long> taskNeedMachinePartSchedulingIdList = param.getMachinePartList()
         .stream()
         .map(MachinePartParam::getTaskNeedMachinePartSchedulingIdList)
         .filter(Objects::nonNull)
         .flatMap(Collection::stream)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(taskNeedMachinePartSchedulingIdList)) {
         this.responseResult(response, "50000", "需要套料的零件集合不能为空");
         throw new BusinessException("需要套料的零件集合不能为空");
      }

      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
               .in(MesBuildingTaskNeedMachinePartScheduling::getId, taskNeedMachinePartSchedulingIdList)
         );
      if (taskNeedMachinePartSchedulingList.stream().anyMatch(tnmps -> (tnmps.getIssuedToNestingSoftwareStatus() & 6) > 0)) {
         this.responseResult(response, "50000", "需要套料的零件集合中存在下发中或已下发的数据, 请刷新后重试");
         throw new BusinessException("需要套料的零件集合中存在下发中或已下发的数据, 请刷新后重试");
      }

      List<MesBuildingWorkshop> workshopList = this.mesBuildingWorkshopService.list();
      Map<Long, MesBuildingWorkshop> workshopMap = workshopList.stream().collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      MesBuildingWorkshop workshop = workshopMap.get(param.getWorkshopId());
      if (BeanUtil.isEmpty(workshop)) {
         this.responseResult(response, "50000", "车间不存在");
         throw new BusinessException("车间不存在");
      }

      List<MesBuildingTeam> teamList = this.teamService.list();
      List<Long> teamIdList = param.getMachinePartList().stream().map(MachinePartParam::getTeamId).distinct().collect(Collectors.toList());
      if (CollUtil.isEmpty(teamIdList)) {
         this.responseResult(response, "50000", "未找到班组信息");
         throw new BusinessException("未找到班组信息");
      }

      List<MesBuildingTeam> matchedTeamList = teamList.stream().filter(t -> teamIdList.contains(t.getId())).collect(Collectors.toList());
      if (teamIdList.size() != matchedTeamList.size()) {
         this.responseResult(response, "50000", "包含不存在班组");
         throw new BusinessException("包含不存在班组");
      }

      Map<Long, MesBuildingTeam> teamMap = teamList.stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      Map<Long, String> teamNameMap = this.mesBuildingTeamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)new LambdaUpdateWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true))
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
      Map<String, List<MesBuildingNestTeamConfig>> nestTeamConfigGroup = this.mesBuildingNestTeamConfigService
         .list()
         .stream()
         .collect(Collectors.groupingBy(k -> k.getWorkshopId() + "&" + k.getTeamId()));
      List<MesBuildingProcess> processList = this.mesBuildingProcessService.list();
      Map<Long, MesBuildingProcess> processMap = processList.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      List<Long> taskOrderIdList = param.getMachinePartList().stream().map(MachinePartParam::getTaskOrderId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = this.mesBuildingTaskOrderService.listByIds(taskOrderIdList);
      Map<Long, MesBuildingTaskOrder> taskOrderMap = taskOrderList.stream().collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<Long> machinePartIdList = param.getMachinePartList().stream().map(MachinePartParam::getMachinePartId).collect(Collectors.toList());
      List<String> machinePartSerialNumberList = param.getMachinePartList().stream().map(MachinePartParam::getSerialNumber).collect(Collectors.toList());
      List<TechMachinePart> machinePartList = this.techMachinePartService.listByIds(machinePartIdList);
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      List<Long> monomerIdList = machinePartList.stream().map(TechMachinePart::getMonomerId).distinct().collect(Collectors.toList());
      List<Long> areaIdList = machinePartList.stream().map(TechMachinePart::getAreaId).distinct().collect(Collectors.toList());
      List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIdList);
      Map<Long, PlanMonomer> monomerMap = monomerList.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      List<TechDrawing> drawingList = this.techDrawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaUpdateWrapper<TechDrawing>()
                        .isNull(TechDrawing::getProductType))
                     .in(TechDrawing::getMonomerId, monomerIdList))
                  .in(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaIdList))
               .in(TechDrawing::getSerialNumber, machinePartSerialNumberList)
         );
      new HashMap();
      Map drawingGroup;
      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
         drawingGroup = drawingList.stream().collect(Collectors.groupingBy(k -> k.getAreaId() + "&" + k.getSerialNumber()));
      } else {
         drawingGroup = drawingList.stream().collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      }

      List<MistakeExportDTO> errorMsgList = new ArrayList<>();
      Map<String, List<TechDrawing>> finalDrawingGroup = drawingGroup;
      param.getMachinePartList()
         .forEach(
            machinePartParam -> {
               if (!machinePartMap.containsKey(machinePartParam.getMachinePartId())) {
                  String errorMsg = "零件编号: " + machinePartParam.getSerialNumber() + ", 未找到该零件";
                  errorMsgList.add(this.buildMistakeDTO(errorMsg));
               }

               if (!nestTeamConfigGroup.containsKey(machinePartParam.getWorkshopId() + "&" + machinePartParam.getTeamId())) {
                  MesBuildingTeam nowTeam = teamMap.getOrDefault(machinePartParam.getTeamId(), new MesBuildingTeam());
                  String errorMsg = "零件编号: "
                     + machinePartParam.getSerialNumber()
                     + ", 未找到班组代号配置，请先到配置管理中配置套料切割配置:车间："
                     + workshopMap.getOrDefault(machinePartParam.getWorkshopId(), new MesBuildingWorkshop()).getName()
                     + "，工序："
                     + processMap.getOrDefault(nowTeam.getProcessId(), new MesBuildingProcess()).getName()
                     + "，班组："
                     + teamNameMap.get(machinePartParam.getTeamId());
                  errorMsgList.add(this.buildMistakeDTO(errorMsg));
               }

               if (!CollectionUtils.isNotEmpty(errorMsgList)) {
                  TechMachinePart machinePart = machinePartMap.get(machinePartParam.getMachinePartId());
                  List<TechDrawing> nowDrawingList = finalDrawingGroup.get(machinePartParam.getMonomerId() + "&" + machinePartParam.getSerialNumber());
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     nowDrawingList = finalDrawingGroup.get(machinePart.getAreaId() + "&" + machinePartParam.getSerialNumber());
                  }

                  if (CollUtil.isNotEmpty(nowDrawingList)) {
                     TechDrawing nowDrawing = nowDrawingList.get(0);
                     String filePathNext = nowDrawing.getFilePath();
                     String filePathNextWithSeparator = filePathNext.replace("/", File.separator);
                     String fileName = nowDrawing.getFileName();
                     String fileFinal = this.filePath + filePathNextWithSeparator + fileName;
                     if (!FileUtil.exist(fileFinal)) {
                        String errorMsg = "零件编号: " + machinePartParam.getSerialNumber() + ", 文件不存在，文件路径：" + fileFinal;
                        errorMsgList.add(this.buildMistakeDTO(errorMsg));
                     }
                  }
               }
            }
         );
      if (CollUtil.isNotEmpty(errorMsgList)) {
         TechUtils.exportMistakeListV2(errorMsgList, response);
      } else {
         MesBuildingBoChuJobDirectory workshopJobDirectoryLocal = this.mesBuildingBoChuJobDirectoryService
            .getOne(
               (Wrapper<MesBuildingBoChuJobDirectory>)(((new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>()
                           .eq(MesBuildingBoChuJobDirectory::getJobType, 0))
                        .eq(MesBuildingBoChuJobDirectory::getParentId, -1))
                     .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode()))
                  .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId())
            );
         Integer workshopJobId;
         if (BeanUtil.isNotEmpty(workshopJobDirectoryLocal)) {
            workshopJobId = workshopJobDirectoryLocal.getJobId();
         } else {
            String title = workshop.getName() + "(" + nestingChargePerson.getName() + ")";
            BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
            boChuJobAddParam.setParent_id(-1);
            boChuJobAddParam.setType(0);
            boChuJobAddParam.setRead_only(0);
            boChuJobAddParam.setTitle(title);
            workshopJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
            MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = new MesBuildingBoChuJobDirectory();
            mesBuildingBoChuJobDirectory.setJobName(title);
            mesBuildingBoChuJobDirectory.setJobId(workshopJobId);
            mesBuildingBoChuJobDirectory.setParentId(-1);
            mesBuildingBoChuJobDirectory.setJobType(0);
            mesBuildingBoChuJobDirectory.setWorkshopId(param.getWorkshopId().toString());
            mesBuildingBoChuJobDirectory.setTeamCodeId(param.getTeamCode());
            this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectory);
         }

         List<String> projectIdList = param.getMachinePartList()
            .stream()
            .map(mpp -> String.valueOf(mpp.getProjectId()))
            .distinct()
            .collect(Collectors.toList());
         Map<String, MesBuildingBoChuJobDirectory> projectJobDirectoryMap = this.mesBuildingBoChuJobDirectoryService
            .list(
               (Wrapper<MesBuildingBoChuJobDirectory>)((((new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>()
                              .eq(MesBuildingBoChuJobDirectory::getJobType, 0))
                           .eq(MesBuildingBoChuJobDirectory::getParentId, workshopJobId))
                        .in(MesBuildingBoChuJobDirectory::getProjectId, projectIdList))
                     .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId().toString()))
                  .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingBoChuJobDirectory::getProjectId, Function.identity()));
         Map<Long, Map<Long, List<MachinePartParam>>> machinePartParamGroup = param.getMachinePartList()
            .stream()
            .collect(Collectors.groupingBy(MachinePartParam::getProjectId, Collectors.groupingBy(MachinePartParam::getTaskOrderId)));
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(machinePartParamGroup.keySet())
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));

         for (Entry<Long, Map<Long, List<MachinePartParam>>> entry : machinePartParamGroup.entrySet()) {
            Long projectIdNow = entry.getKey();
            Map<Long, List<MachinePartParam>> machinePartParamByTaskOrderIdGroup = entry.getValue();
            ContractProject projectNow = projectMap.get(projectIdNow);
            MesBuildingBoChuJobDirectory projectJobDirectory = projectJobDirectoryMap.get(projectIdNow.toString());
            Integer projectJobId;
            if (BeanUtil.isNotEmpty(projectJobDirectory)) {
               projectJobId = projectJobDirectory.getJobId();
            } else {
               String title = projectNow.getShortName();
               BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
               boChuJobAddParam.setParent_id(workshopJobId);
               boChuJobAddParam.setType(0);
               boChuJobAddParam.setRead_only(0);
               boChuJobAddParam.setTitle(title);
               projectJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
               MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryFolder = new MesBuildingBoChuJobDirectory();
               mesBuildingBoChuJobDirectoryFolder.setJobName(title);
               mesBuildingBoChuJobDirectoryFolder.setJobId(projectJobId);
               mesBuildingBoChuJobDirectoryFolder.setParentId(workshopJobId);
               mesBuildingBoChuJobDirectoryFolder.setProjectId(projectIdNow.toString());
               mesBuildingBoChuJobDirectoryFolder.setJobType(0);
               mesBuildingBoChuJobDirectoryFolder.setWorkshopId(param.getWorkshopId().toString());
               mesBuildingBoChuJobDirectoryFolder.setTeamCodeId(param.getTeamCode());
               this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectoryFolder);
            }

            Map<Long, MesBuildingBoChuJobDirectory> taskOrderJobDirectoryMap = this.mesBuildingBoChuJobDirectoryService
               .list(
                  (Wrapper<MesBuildingBoChuJobDirectory>)(((((new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>()
                                    .eq(MesBuildingBoChuJobDirectory::getJobType, 1))
                                 .eq(MesBuildingBoChuJobDirectory::getParentId, projectJobId))
                              .in(MesBuildingBoChuJobDirectory::getTaskOrderId, machinePartParamByTaskOrderIdGroup.keySet()))
                           .eq(MesBuildingBoChuJobDirectory::getProjectId, projectIdNow.toString()))
                        .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId().toString()))
                     .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode())
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingBoChuJobDirectory::getTaskOrderId, Function.identity()));

            for (Entry<Long, List<MachinePartParam>> machinePartParamByTaskOrderId : machinePartParamByTaskOrderIdGroup.entrySet()) {
               Long taskOrderIdNow = machinePartParamByTaskOrderId.getKey();
               List<MachinePartParam> machinePartParamListNow = machinePartParamByTaskOrderId.getValue();
               MesBuildingTaskOrder taskOrder = taskOrderMap.get(taskOrderIdNow);
               MesBuildingBoChuJobDirectory taskOrderJobDirectory = taskOrderJobDirectoryMap.get(taskOrderIdNow);
               Integer taskOrderJobId;
               if (BeanUtil.isNotEmpty(taskOrderJobDirectory)) {
                  taskOrderJobId = taskOrderJobDirectory.getJobId();
               } else {
                  String teamIdsNow = machinePartParamListNow.stream()
                     .map(machinePartParamNow -> String.valueOf(machinePartParamNow.getTeamId()))
                     .distinct()
                     .collect(Collectors.joining(","));
                  String title = taskOrder.getOrderNumber();
                  BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
                  boChuJobAddParam.setParent_id(projectJobId);
                  boChuJobAddParam.setType(1);
                  boChuJobAddParam.setRead_only(0);
                  boChuJobAddParam.setTitle(title);
                  taskOrderJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
                  MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryJob = new MesBuildingBoChuJobDirectory();
                  mesBuildingBoChuJobDirectoryJob.setJobName(title);
                  mesBuildingBoChuJobDirectoryJob.setJobId(taskOrderJobId);
                  mesBuildingBoChuJobDirectoryJob.setParentId(projectJobId);
                  mesBuildingBoChuJobDirectoryJob.setProjectId(projectIdNow.toString());
                  mesBuildingBoChuJobDirectoryJob.setJobType(1);
                  mesBuildingBoChuJobDirectoryJob.setTeamId(teamIdsNow);
                  mesBuildingBoChuJobDirectoryJob.setTaskOrderId(taskOrderIdNow);
                  mesBuildingBoChuJobDirectoryJob.setWorkshopId(param.getWorkshopId().toString());
                  mesBuildingBoChuJobDirectoryJob.setTeamCodeId(param.getTeamCode());
                  this.baseMapper.insertMesBuildingBoChuJobDirectory(mesBuildingBoChuJobDirectoryJob);
               }

               machinePartParamListNow.forEach(mpp -> mpp.setJobId(taskOrderJobId));
            }
         }

         param.getMachinePartList()
            .forEach(
               mp -> this.mesBuildingTaskNeedMachinePartSchedulingService
                  .update(
                     (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                 .in(MesBuildingTaskNeedMachinePartScheduling::getId, mp.getTaskNeedMachinePartSchedulingIdList()))
                              .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, mp.getJobId()))
                           .set(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareOperationTime, LocalDateTime.now()))
                        .set(
                           MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                           IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType()
                        )
                  )
            );
         SecurityUser currentUser = UserUtil.getCurrentUser();
         new Thread(() -> this.machinePartSendToNestingSoftware(param, currentUser)).start();
         this.responseResult(response, "20000", "套料任务下发操作成功");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void sendToNestingModeTwo(MesBuildingMachinePartNestingParam param, HttpServletResponse response) {
      if (param.getTeamCode() == null) {
         this.responseResult(response, "50000", "团队码不能为空");
         throw new BusinessException("团队码不能为空");
      }

      if (param.getWorkshopId() == null) {
         this.responseResult(response, "50000", "车间不能为空");
         throw new BusinessException("车间不能为空");
      }

      if (param.getCompletionDate() == null) {
         this.responseResult(response, "50000", "完成日期不能为空");
         throw new BusinessException("完成日期不能为空");
      }

      if (CollUtil.isEmpty(param.getMachinePartList())) {
         this.responseResult(response, "50000", "需要套料的零件集合不能为空");
         throw new BusinessException("需要套料的零件集合不能为空");
      }

      MesBuildingNestingTeam nestingTeam = this.mesBuildingNestingTeamService.getById(param.getTeamCode());
      if (BeanUtil.isEmpty(nestingTeam)) {
         this.responseResult(response, "50000", "套料团队不存在, 请检查套料团队配置");
         throw new BusinessException("套料团队不存在, 请检查套料团队配置");
      }

      String sysTemTeamCode = nestingTeam.getTeamCode();
      User nestingChargePerson = this.userService.getById(nestingTeam.getNestingChargePerson());
      if (BeanUtil.isEmpty(nestingChargePerson)) {
         this.responseResult(response, "50000", "套料团队负责人不存在, 请检查套料团队配置");
         throw new BusinessException("套料团队负责人不存在, 请检查套料团队配置");
      }

      List<Long> taskNeedMachinePartSchedulingIdList = param.getMachinePartList()
         .stream()
         .map(MachinePartParam::getTaskNeedMachinePartSchedulingIdList)
         .filter(Objects::nonNull)
         .flatMap(Collection::stream)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(taskNeedMachinePartSchedulingIdList)) {
         this.responseResult(response, "50000", "需要套料的零件集合不能为空");
         throw new BusinessException("需要套料的零件集合不能为空");
      }

      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
               .in(MesBuildingTaskNeedMachinePartScheduling::getId, taskNeedMachinePartSchedulingIdList)
         );
      if (taskNeedMachinePartSchedulingList.stream().anyMatch(tnmps -> tnmps.getSendNestingStatus() || (tnmps.getIssuedToNestingSoftwareStatus() & 6) > 0)) {
         this.responseResult(response, "50000", "需要套料的零件集合中存在下发中或已下发的数据, 请刷新后重试");
         throw new BusinessException("需要套料的零件集合中存在下发中或已下发的数据, 请刷新后重试");
      }

      List<MesBuildingWorkshop> workshopList = this.mesBuildingWorkshopService.list();
      Map<Long, MesBuildingWorkshop> workshopMap = workshopList.stream().collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      MesBuildingWorkshop workshop = workshopMap.get(param.getWorkshopId());
      if (BeanUtil.isEmpty(workshop)) {
         this.responseResult(response, "50000", "车间不存在");
         throw new BusinessException("车间不存在");
      }

      List<MesBuildingTeam> teamList = this.teamService.list();
      List<Long> teamIdList = param.getMachinePartList().stream().map(MachinePartParam::getTeamId).distinct().collect(Collectors.toList());
      if (CollUtil.isEmpty(teamIdList)) {
         this.responseResult(response, "50000", "未找到班组信息");
         throw new BusinessException("未找到班组信息");
      }

      List<MesBuildingTeam> matchedTeamList = teamList.stream().filter(t -> teamIdList.contains(t.getId())).collect(Collectors.toList());
      if (teamIdList.size() != matchedTeamList.size()) {
         this.responseResult(response, "50000", "包含不存在班组");
         throw new BusinessException("包含不存在班组");
      }

      Map<Long, MesBuildingTeam> teamMap = teamList.stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      Map<Long, String> teamNameMap = this.mesBuildingTeamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)new LambdaUpdateWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true))
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
      Map<String, List<MesBuildingNestTeamConfig>> nestTeamConfigGroup = this.mesBuildingNestTeamConfigService
         .list()
         .stream()
         .collect(Collectors.groupingBy(k -> k.getWorkshopId() + "&" + k.getTeamId()));
      List<MesBuildingProcess> processList = this.mesBuildingProcessService.list();
      Map<Long, MesBuildingProcess> processMap = processList.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      List<Long> taskOrderIdList = param.getMachinePartList().stream().map(MachinePartParam::getTaskOrderId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = this.mesBuildingTaskOrderService.listByIds(taskOrderIdList);
      Map<Long, MesBuildingTaskOrder> taskOrderMap = taskOrderList.stream().collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<Long> machinePartIdList = param.getMachinePartList().stream().map(MachinePartParam::getMachinePartId).collect(Collectors.toList());
      List<String> machinePartSerialNumberList = param.getMachinePartList().stream().map(MachinePartParam::getSerialNumber).collect(Collectors.toList());
      List<TechMachinePart> machinePartList = this.techMachinePartService.listByIds(machinePartIdList);
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Integer, List<Long>> machinePartIdBySteelPlateTypeEnumGroup = machinePartList.stream()
         .collect(Collectors.groupingBy(TechMachinePart::getSteelPlateTypeEnum, Collectors.mapping(TechMachinePart::getId, Collectors.toList())));
      List<Long> monomerIdList = machinePartList.stream().map(TechMachinePart::getMonomerId).distinct().collect(Collectors.toList());
      List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIdList);
      Map<Long, PlanMonomer> monomerMap = monomerList.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<String, List<TechDrawing>> drawingGroup = this.techDrawingService
         .list(
            (Wrapper<TechDrawing>)((new LambdaUpdateWrapper<TechDrawing>().isNull(TechDrawing::getProductType))
                  .in(TechDrawing::getMonomerId, monomerIdList))
               .in(TechDrawing::getSerialNumber, machinePartSerialNumberList)
         )
         .stream()
         .collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      List<MistakeExportDTO> errorMsgList = new ArrayList<>();
      param.getMachinePartList()
         .forEach(
            machinePartParam -> {
               if (!machinePartMap.containsKey(machinePartParam.getMachinePartId())) {
                  String errorMsg = "零件编号: " + machinePartParam.getSerialNumber() + ", 未找到该零件";
                  errorMsgList.add(this.buildMistakeDTO(errorMsg));
               }

               if (!nestTeamConfigGroup.containsKey(machinePartParam.getWorkshopId() + "&" + machinePartParam.getTeamId())) {
                  MesBuildingTeam nowTeam = teamMap.getOrDefault(machinePartParam.getTeamId(), new MesBuildingTeam());
                  String errorMsg = "零件编号: "
                     + machinePartParam.getSerialNumber()
                     + ", 未找到班组代号配置，请先到配置管理中配置套料切割配置:车间："
                     + workshopMap.getOrDefault(machinePartParam.getWorkshopId(), new MesBuildingWorkshop()).getName()
                     + "，工序："
                     + processMap.getOrDefault(nowTeam.getProcessId(), new MesBuildingProcess()).getName()
                     + "，班组："
                     + teamNameMap.get(machinePartParam.getTeamId());
                  errorMsgList.add(this.buildMistakeDTO(errorMsg));
               }

               List<TechDrawing> nowDrawingList = drawingGroup.get(machinePartParam.getMonomerId() + "&" + machinePartParam.getSerialNumber());
               if (CollUtil.isNotEmpty(nowDrawingList)) {
                  TechDrawing nowDrawing = nowDrawingList.get(0);
                  String filePathNext = nowDrawing.getFilePath();
                  String filePathNextWithSeparator = filePathNext.replace("/", File.separator);
                  String fileName = nowDrawing.getFileName();
                  String fileFinal = this.filePath + filePathNextWithSeparator + fileName;
                  if (!FileUtil.exist(fileFinal)) {
                     String errorMsg = "零件编号: " + machinePartParam.getSerialNumber() + ", 文件不存在，文件路径：" + fileFinal;
                     errorMsgList.add(this.buildMistakeDTO(errorMsg));
                  }
               }
            }
         );
      if (CollUtil.isNotEmpty(errorMsgList)) {
         TechUtils.exportMistakeListV2(errorMsgList, response);
      } else {
         MesBuildingBoChuJobDirectory workshopJobDirectoryLocal = this.mesBuildingBoChuJobDirectoryService
            .getOne(
               (Wrapper<MesBuildingBoChuJobDirectory>)(((new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>()
                           .eq(MesBuildingBoChuJobDirectory::getJobType, 0))
                        .eq(MesBuildingBoChuJobDirectory::getParentId, -1))
                     .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode()))
                  .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId())
            );
         Integer workshopJobId;
         if (BeanUtil.isNotEmpty(workshopJobDirectoryLocal)) {
            workshopJobId = workshopJobDirectoryLocal.getJobId();
         } else {
            String title = workshop.getName() + "(" + nestingChargePerson.getName() + ")";
            BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
            boChuJobAddParam.setParent_id(-1);
            boChuJobAddParam.setType(0);
            boChuJobAddParam.setRead_only(0);
            boChuJobAddParam.setTitle(title);
            workshopJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
            MesBuildingBoChuJobDirectory jobDirectory = new MesBuildingBoChuJobDirectory();
            jobDirectory.setJobName(title);
            jobDirectory.setJobId(workshopJobId);
            jobDirectory.setParentId(-1);
            jobDirectory.setJobType(0);
            jobDirectory.setWorkshopId(param.getWorkshopId().toString());
            jobDirectory.setTeamCodeId(param.getTeamCode());
            this.baseMapper.insertMesBuildingBoChuJobDirectory(jobDirectory);
         }

         List<String> projectIdList = param.getMachinePartList()
            .stream()
            .map(mpp -> String.valueOf(mpp.getProjectId()))
            .distinct()
            .collect(Collectors.toList());
         Map<String, MesBuildingBoChuJobDirectory> projectJobDirectoryMap = this.mesBuildingBoChuJobDirectoryService
            .list(
               (Wrapper<MesBuildingBoChuJobDirectory>)((((new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>()
                              .eq(MesBuildingBoChuJobDirectory::getJobType, 0))
                           .eq(MesBuildingBoChuJobDirectory::getParentId, workshopJobId))
                        .in(MesBuildingBoChuJobDirectory::getProjectId, projectIdList))
                     .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId().toString()))
                  .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingBoChuJobDirectory::getProjectId, Function.identity()));
         Map<Long, Map<Integer, List<MachinePartParam>>> machinePartParamGroup = param.getMachinePartList().stream().peek(pmp -> {
            Integer steelPlateTypeEnum = machinePartMap.get(pmp.getMachinePartId()).getSteelPlateTypeEnum();
            Preconditions.checkArgument(!Objects.equals(steelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType()), "所选零件存在成品型材");
            pmp.setSteelPlateTypeEnum(steelPlateTypeEnum);
         }).collect(Collectors.groupingBy(MachinePartParam::getProjectId, Collectors.groupingBy(MachinePartParam::getSteelPlateTypeEnum)));
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(machinePartParamGroup.keySet())
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));

         for (Entry<Long, Map<Integer, List<MachinePartParam>>> entry : machinePartParamGroup.entrySet()) {
            Long projectIdNow = entry.getKey();
            Map<Integer, List<MachinePartParam>> machinePartParamBySteelPlateTypeEnumGroup = entry.getValue();
            ContractProject projectNow = projectMap.get(projectIdNow);
            MesBuildingBoChuJobDirectory projectJobDirectory = projectJobDirectoryMap.get(projectIdNow.toString());
            Integer projectJobId;
            if (BeanUtil.isNotEmpty(projectJobDirectory)) {
               projectJobId = projectJobDirectory.getJobId();
            } else {
               String title = projectNow.getShortName();
               BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
               boChuJobAddParam.setParent_id(workshopJobId);
               boChuJobAddParam.setType(0);
               boChuJobAddParam.setRead_only(0);
               boChuJobAddParam.setTitle(title);
               projectJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
               MesBuildingBoChuJobDirectory jobDirectory = new MesBuildingBoChuJobDirectory();
               jobDirectory.setJobName(title);
               jobDirectory.setJobId(projectJobId);
               jobDirectory.setParentId(workshopJobId);
               jobDirectory.setProjectId(projectIdNow.toString());
               jobDirectory.setJobType(0);
               jobDirectory.setWorkshopId(param.getWorkshopId().toString());
               jobDirectory.setTeamCodeId(param.getTeamCode());
               this.baseMapper.insertMesBuildingBoChuJobDirectory(jobDirectory);
            }

            Map<Integer, Long> steelPlateTypeJobDirectoryCountGroup = this.mesBuildingBoChuJobDirectoryService
               .lambdaQuery()
               .eq(MesBuildingBoChuJobDirectory::getJobType, 1)
               .eq(MesBuildingBoChuJobDirectory::getParentId, projectJobId)
               .eq(MesBuildingBoChuJobDirectory::getProjectId, projectIdNow.toString())
               .eq(MesBuildingBoChuJobDirectory::getWorkshopId, param.getWorkshopId().toString())
               .eq(MesBuildingBoChuJobDirectory::getTeamCodeId, param.getTeamCode())
               .in(MesBuildingBoChuJobDirectory::getSteelPlateTypeEnum, machinePartParamBySteelPlateTypeEnumGroup.keySet())
               .list()
               .stream()
               .collect(Collectors.groupingBy(MesBuildingBoChuJobDirectory::getSteelPlateTypeEnum, Collectors.counting()));

            for (Entry<Integer, List<MachinePartParam>> machinePartParamBySteelPlateTypeEnum : machinePartParamBySteelPlateTypeEnumGroup.entrySet()) {
               Integer steelPlateTypeEnumNow = machinePartParamBySteelPlateTypeEnum.getKey();
               List<MachinePartParam> machinePartParamListNow = machinePartParamBySteelPlateTypeEnum.getValue();
               Long countNow = steelPlateTypeJobDirectoryCountGroup.getOrDefault(steelPlateTypeEnumNow, 0L);
               String teamIdsNow = machinePartParamListNow.stream()
                  .map(machinePartParamNow -> String.valueOf(machinePartParamNow.getTeamId()))
                  .distinct()
                  .collect(Collectors.joining(","));
               String title = SteelPlateTypeEnum.getNameByType(steelPlateTypeEnumNow) + (countNow + 1L);
               BoChuJobAddParam boChuJobAddParam = new BoChuJobAddParam();
               boChuJobAddParam.setParent_id(projectJobId);
               boChuJobAddParam.setType(1);
               boChuJobAddParam.setRead_only(0);
               boChuJobAddParam.setTitle(title);
               Integer steelPlateTypeEnumJobId = this.getJobId(boChuJobAddParam, sysTemTeamCode);
               MesBuildingBoChuJobDirectory jobDirectory = new MesBuildingBoChuJobDirectory();
               jobDirectory.setJobName(title);
               jobDirectory.setJobId(steelPlateTypeEnumJobId);
               jobDirectory.setParentId(projectJobId);
               jobDirectory.setProjectId(projectIdNow.toString());
               jobDirectory.setJobType(1);
               jobDirectory.setTeamId(teamIdsNow);
               jobDirectory.setWorkshopId(param.getWorkshopId().toString());
               jobDirectory.setTeamCodeId(param.getTeamCode());
               jobDirectory.setSteelPlateTypeEnum(steelPlateTypeEnumNow);
               this.baseMapper.insertMesBuildingBoChuJobDirectory(jobDirectory);
               machinePartParamListNow.forEach(mpp -> mpp.setJobId(steelPlateTypeEnumJobId));
            }
         }

         param.getMachinePartList()
            .forEach(
               mp -> this.mesBuildingTaskNeedMachinePartSchedulingService
                  .update(
                     (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                 .in(MesBuildingTaskNeedMachinePartScheduling::getId, mp.getTaskNeedMachinePartSchedulingIdList()))
                              .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, mp.getJobId()))
                           .set(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareOperationTime, LocalDateTime.now()))
                        .set(
                           MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                           IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType()
                        )
                  )
            );
         SecurityUser currentUser = UserUtil.getCurrentUser();
         new Thread(() -> this.machinePartSendToNestingSoftware(param, currentUser)).start();
         this.responseResult(response, "20000", "套料任务下发操作成功");
      }
   }

   private void responseResult(HttpServletResponse response, String code, String message) {
      try {
         response.setHeader("result", "code=" + code + ";message=" + URLEncoder.encode(message, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "result");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
   }

   private void machinePartSendToNestingSoftware(MesBuildingMachinePartNestingParam param, SecurityUser currentUser) {
      List<MesBuildingTeam> teamList = this.teamService.list();
      Map<Long, MesBuildingTeam> teamMap = teamList.stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      Map<Long, String> teamNameMap = this.mesBuildingTeamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)new LambdaUpdateWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true))
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
      AtomicReference<Long> mesBuildingNestTeamConfigId = new AtomicReference<>(0L);
      Map<String, List<MesBuildingNestTeamConfig>> nestTeamConfigGroup = this.mesBuildingNestTeamConfigService
         .list()
         .stream()
         .collect(Collectors.groupingBy(k -> k.getWorkshopId() + "&" + k.getTeamId()));
      List<Long> machinePartIdList = param.getMachinePartList().stream().map(MachinePartParam::getMachinePartId).collect(Collectors.toList());
      List<String> machinePartSerialNumberList = param.getMachinePartList().stream().map(MachinePartParam::getSerialNumber).collect(Collectors.toList());
      List<TechMachinePart> machinePartList = this.techMachinePartService.listByIds(machinePartIdList);
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      List<Long> monomerIdList = machinePartList.stream().map(TechMachinePart::getMonomerId).distinct().collect(Collectors.toList());
      List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIdList);
      Map<Long, PlanMonomer> monomerMap = monomerList.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<String, List<TechDrawing>> drawingGroup = this.techDrawingService
         .list(
            (Wrapper<TechDrawing>)((new LambdaUpdateWrapper<TechDrawing>().isNull(TechDrawing::getProductType))
                  .in(TechDrawing::getMonomerId, monomerIdList))
               .in(TechDrawing::getSerialNumber, machinePartSerialNumberList)
         )
         .stream()
         .collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      MesBuildingNestingTeam nestingTeam = this.mesBuildingNestingTeamService.getById(param.getTeamCode());
      HttpHeaders headers = BoChuNesting.headers(nestingTeam.getTeamCode());
      headers.setContentType(MediaType.MULTIPART_FORM_DATA);
      headers.set("X-FS-Encode", "utf-8");
      param.getMachinePartList()
         .stream()
         .collect(Collectors.groupingBy(MachinePartParam::getJobId))
         .forEach(
            (jobId, MachinePartParamList) -> {
               int totalDataSize = MachinePartParamList.size();

               for (int i = 0; i < totalDataSize; i += 50) {
                  int endIndex = Math.min(i + 50, totalDataSize);
                  List<MachinePartParam> currentBatch = MachinePartParamList.subList(i, endIndex);
                  List<Long> thisBatchTaskNeedMachinePartSchedulingIdListList = currentBatch.stream()
                     .map(MachinePartParam::getTaskNeedMachinePartSchedulingIdList)
                     .flatMap(s -> Optional.ofNullable(s).map(Collection::stream).orElse(Stream.empty()))
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
                  List<BoChuDXFUploadParam> boChuDXFUploadParamList = new ArrayList<>();
                  List<String> fileList = new ArrayList<>();
                  currentBatch.forEach(
                     machinePartParam -> {
                        BoChuDXFUploadParam boChuJobUploadParam = new BoChuDXFUploadParam();
                        boChuJobUploadParam.setJobId(machinePartParam.getJobId());
                        TechMachinePart machinePart = machinePartMap.get(machinePartParam.getMachinePartId());
                        String serialNumber = machinePart.getSerialNumber();
                        Long monomerId = machinePart.getMonomerId();
                        PlanMonomer monomer = monomerMap.get(machinePart.getMonomerId());
                        List<TechDrawing> drawingList = drawingGroup.get(monomerId + "&" + serialNumber);
                        if (CollUtil.isNotEmpty(drawingList)) {
                           TechDrawing drawing = drawingList.get(0);
                           String filePathNextWithSeparator = drawing.getFilePath().replace("/", File.separator);
                           String fileName = drawing.getFileName();
                           String fileFinal = this.filePath + filePathNextWithSeparator + fileName;
                           boChuJobUploadParam.setFilename(fileName);
                           BoChuDXFUploadDataParam boChuDXFUploadDataParam = new BoChuDXFUploadDataParam();
                           boChuDXFUploadDataParam.setAmount(new BigDecimal(machinePartParam.getQuantity()));
                           boChuDXFUploadDataParam.setGas("Air");
                           boChuDXFUploadDataParam.setMaterial(machinePart.getMaterial());
                           boChuDXFUploadDataParam.setRotate_lock(0);
                           boChuDXFUploadDataParam.setThickness(new BigDecimal(machinePart.getThick()));
                           boChuDXFUploadDataParam.setPart_name(machinePart.getSerialNumber());
                           List<MesBuildingNestTeamConfig> nestTeamConfigList = nestTeamConfigGroup.get(
                              machinePartParam.getWorkshopId() + "&" + machinePartParam.getTeamId()
                           );
                           if (CollectionUtil.isNotEmpty(nestTeamConfigList)) {
                              MesBuildingNestTeamConfig mesBuildingNestTeamConfig = nestTeamConfigList.get(0);
                              mesBuildingNestTeamConfigId.set(mesBuildingNestTeamConfig.getId());
                              if (mesBuildingNestTeamConfig.getBoolShowCodename()) {
                                 String codeName = mesBuildingNestTeamConfig.getCodeName();
                                 if (mesBuildingNestTeamConfig.getDisplayRule()) {
                                    if (mesBuildingNestTeamConfig.getCodeRule()) {
                                       codeName = "-" + codeName;
                                    } else {
                                       codeName = codeName + "-";
                                    }
                                 } else {
                                    codeName = "(" + codeName + ")";
                                 }

                                 if (mesBuildingNestTeamConfig.getCodeRule()) {
                                    boChuDXFUploadDataParam.setPart_name(machinePart.getSerialNumber() + codeName);
                                 } else {
                                    boChuDXFUploadDataParam.setPart_name(codeName + machinePart.getSerialNumber());
                                 }
                              }
                           }

                           if (teamMap.containsKey(machinePartParam.getTeamId())) {
                              String teamName = teamNameMap.get(machinePartParam.getTeamId());
                              BoChuDXFUploadPropParam boChuDXFUploadPropParam = new BoChuDXFUploadPropParam();
                              boChuDXFUploadPropParam.setProductId(machinePartParam.getMachinePartId());
                              boChuDXFUploadPropParam.setProjectId(machinePartParam.getProjectId());
                              boChuDXFUploadPropParam.setTaskOrderId(machinePartParam.getTaskOrderId());
                              boChuDXFUploadPropParam.setTechDrawingId(drawing.getId());
                              boChuDXFUploadPropParam.setTeamId(machinePartParam.getTeamId());
                              boChuDXFUploadPropParam.setTeamName(teamName);
                              boChuDXFUploadPropParam.setTaskNeedMachinePartSchedulingIds(machinePartParam.getTaskNeedMachinePartSchedulingIds());
                              boChuDXFUploadPropParam.setBoolSendDirectly(machinePartParam.getBoolSendDirectly());
                              boChuDXFUploadPropParam.setBoolSendDirectlyStr(machinePartParam.getBoolSendDirectly() ? "是" : "否");
                              String requiredCompletionDateStr = DateTimeUtil.timestampToLocalDateTime(param.getCompletionDate()).toLocalDate().toString();
                              boChuDXFUploadPropParam.setRequiredCompletionDate(requiredCompletionDateStr);
                              boChuDXFUploadPropParam.setPrompt("不能编辑或删除");
                              boChuDXFUploadDataParam.setProp(boChuDXFUploadPropParam);
                           }

                           boChuJobUploadParam.setDatas(boChuDXFUploadDataParam);
                           cn.hutool.json.JSONArray optimizationParm = JSONUtil.createArray();
                           List<PartDrawingLayerSettingDTO> partDrawingLayerSettingList = this.configService.getPartDrawingLayerSetting();
                           if (CollUtil.isNotEmpty(partDrawingLayerSettingList)) {
                              cn.hutool.json.JSONObject layerMap = JSONUtil.createObj().set("type", "layer_map_2");
                              List<cn.hutool.json.JSONObject> layerMapParams = partDrawingLayerSettingList.stream()
                                 .map(
                                    pdls -> JSONUtil.createObj()
                                       .set("layer_idx", pdls.getLayerName())
                                       .set("map_type", pdls.getProcessMethod())
                                       .set("object_type", pdls.getObjectType())
                                 )
                                 .collect(Collectors.toList());
                              layerMap.set("params", layerMapParams);
                              optimizationParm.set(layerMap);
                           }

                           if (CollUtil.isNotEmpty(optimizationParm)) {
                              boChuJobUploadParam.setOptimization_parm(optimizationParm);
                           }

                           boChuDXFUploadParamList.add(boChuJobUploadParam);
                           fileList.add(fileFinal);
                        }
                     }
                  );
                  String data = JSONObject.toJSONString(boChuDXFUploadParamList).replace(",{\"$ref\":\"$[0]\"}", "");
                  File[] files = fileList.stream().map(File::new).toArray(File[]::new);
                  log.info("开始发送数据到套料软件.........................");

                  try (HttpResponse response = HttpRequest.post("https://cloudnest.fscut.com/api/part/file2part")
                        .header(headers)
                        .form("data", data)
                        .form("ignore_error", 1)
                        .form("files", files)
                        .execute()) {
                     if (response.isOk()) {
                        JSONObject resultJson = JSONObject.parseObject(response.body());
                        if (Objects.equals(resultJson.getIntValue("status"), 0)) {
                           List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
                              .listByIds(thisBatchTaskNeedMachinePartSchedulingIdListList);
                           taskNeedMachinePartSchedulingList.forEach(tnmps -> {
                              tnmps.setNestingJobId(jobId);
                              tnmps.setSendNestingStatus(true);
                              tnmps.setSchedulingDate(LocalDateTime.now());
                              tnmps.setSchedulingUserId(currentUser.getId());
                              tnmps.setNestTeamConfigId(mesBuildingNestTeamConfigId.get());
                              tnmps.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.ISSUED.getType());
                           });
                           this.mesBuildingTaskNeedMachinePartSchedulingService.updateBatchById(taskNeedMachinePartSchedulingList);
                        } else {
                           log.error("零件下发到套料软件失败信息: " + resultJson.toJSONString());
                           JSONArray failArr = resultJson.getJSONArray("fail");
                           log.error("零件下发到套料软件失败信息-失败零件列表: " + failArr.toJSONString());
                           if (CollUtil.isNotEmpty(failArr)) {
                              List<Long> failTaskNeedMachinePartSchedulingIdList = failArr.stream()
                                 .map(
                                    failo -> {
                                       String taskNeedMachinePartSchedulingIds = JSONObject.parseObject(failo.toString())
                                          .getJSONObject("datas")
                                          .getJSONObject("prop")
                                          .getString("taskNeedMachinePartSchedulingIds");
                                       return Convert.toList(Long.class, StrUtil.split(taskNeedMachinePartSchedulingIds, ","));
                                    }
                                 )
                                 .flatMap(Collection::stream)
                                 .filter(Objects::nonNull)
                                 .collect(Collectors.toList());
                              this.mesBuildingTaskNeedMachinePartSchedulingService
                                 .update(
                                    (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                             .in(MesBuildingTaskNeedMachinePartScheduling::getId, failTaskNeedMachinePartSchedulingIdList))
                                          .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null))
                                       .set(
                                          MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                                          IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType()
                                       )
                                 );
                           }

                           JSONArray dataArr = resultJson.getJSONArray("data");
                           log.error("零件下发到套料软件失败信息-成功零件列表: " + dataArr.toJSONString());
                           if (CollUtil.isNotEmpty(dataArr)) {
                              List<Long> dataTaskNeedMachinePartSchedulingIdList = dataArr.stream()
                                 .map(
                                    dataObj -> {
                                       String taskNeedMachinePartSchedulingIds = JSONObject.parseObject(dataObj.toString())
                                          .getJSONObject("datas")
                                          .getJSONObject("prop")
                                          .getString("taskNeedMachinePartSchedulingIds");
                                       return Convert.toList(Long.class, StrUtil.split(taskNeedMachinePartSchedulingIds, ","));
                                    }
                                 )
                                 .flatMap(Collection::stream)
                                 .filter(Objects::nonNull)
                                 .collect(Collectors.toList());
                              this.mesBuildingTaskNeedMachinePartSchedulingService
                                 .update(
                                    (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((((((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                                         .in(MesBuildingTaskNeedMachinePartScheduling::getId, dataTaskNeedMachinePartSchedulingIdList))
                                                      .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId))
                                                   .set(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, true))
                                                .set(MesBuildingTaskNeedMachinePartScheduling::getSchedulingDate, LocalDateTime.now()))
                                             .set(MesBuildingTaskNeedMachinePartScheduling::getSchedulingUserId, currentUser.getId()))
                                          .set(MesBuildingTaskNeedMachinePartScheduling::getNestTeamConfigId, mesBuildingNestTeamConfigId.get()))
                                       .set(
                                          MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                                          IssuedToNestingSoftwareStatusEnum.ISSUED.getType()
                                       )
                                 );
                           }
                        }
                     } else {
                        this.mesBuildingTaskNeedMachinePartSchedulingService
                           .update(
                              (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                       .in(MesBuildingTaskNeedMachinePartScheduling::getId, thisBatchTaskNeedMachinePartSchedulingIdListList))
                                    .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null))
                                 .set(
                                    MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                                    IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType()
                                 )
                           );
                     }
                  } catch (Exception e) {
                     log.error("零件下发到套料软件失败!");
                     this.mesBuildingTaskNeedMachinePartSchedulingService
                        .update(
                           (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                    .in(MesBuildingTaskNeedMachinePartScheduling::getId, thisBatchTaskNeedMachinePartSchedulingIdListList))
                                 .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null))
                              .set(
                                 MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                                 IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType()
                              )
                        );
                  }
               }
            }
         );
      log.info("零件下发到套料软件结束.........................");
   }

   private void removeEmptyChildren(MesBuildingBoChuJobDirectoryDTO node) {
      if (CollUtil.isNotEmpty(node.getChildren())) {
         if (Objects.equals(node.getChildren().get(0).getJobType(), 1)) {
            return;
         }

         List<MesBuildingBoChuJobDirectoryDTO> validChildren = node.getChildren()
            .stream()
            .filter(child -> CollUtil.isNotEmpty(child.getChildren()))
            .collect(Collectors.toList());
         node.setChildren(validChildren);
         validChildren.forEach(this::removeEmptyChildren);
      }
   }

   private List<MesBuildingBoChuJobDirectoryDTO> getWorkTreeV2(WorkTreeDTO workTreeDTO) {
      List<MesBuildingBoChuJobDirectoryDTO> mesBuildingBoChuJobDirectoryList = this.baseMapper.getWorkList(workTreeDTO);
      Map<Integer, List<MesBuildingBoChuJobDirectoryDTO>> directoryGroup = mesBuildingBoChuJobDirectoryList.stream()
         .collect(Collectors.groupingBy(MesBuildingBoChuJobDirectoryDTO::getParentId));
      return mesBuildingBoChuJobDirectoryList.stream()
         .peek(i -> {
            i.setChildren(directoryGroup.get(i.getJobId()));
            if (Objects.equals(i.getJobType(), 1)) {
               NestingQuantityDTO nestingQuantity = this.getJobMaterial(i.getJobId());
               if (Objects.equals(nestingQuantity.getPartQuantity(), nestingQuantity.getNestingQuantity())) {
                  i.setPartSchedulingStatus(1);
               } else if (nestingQuantity.getPartQuantity() > nestingQuantity.getNestingQuantity()) {
                  i.setPartSchedulingStatus(2);
               } else if (nestingQuantity.getNestingQuantity().equals(0)) {
                  i.setPartSchedulingStatus(0);
               }
            }
         })
         .filter(i -> Objects.equals(i.getParentId(), -1))
         .collect(Collectors.toList())
         .stream()
         .peek(this::removeEmptyChildren)
         .filter(i -> CollUtil.isNotEmpty(i.getChildren()))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingBoChuJobDirectoryDTO> getWorkTree(WorkTreeDTO workTreeDTO) {
      return this.getWorkTreeV2(workTreeDTO);
   }

   private void changeBoChuJobDirectoryStatus() {
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService.list();
      mesBuildingBoChuJobDirectoryList.forEach(
         mesBuildingBoChuJobDirectory -> {
            Long teamCodeId = mesBuildingBoChuJobDirectory.getTeamCodeId();
            MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
            List<MachinePartNestingJobDetailDTO> machinePartNestingJobDetailDTOList = this.getNestingJobPart(
               mesBuildingBoChuJobDirectory.getJobId(), mesBuildingNestingTeam.getTeamCode()
            );
            if (CollectionUtils.isNotEmpty(machinePartNestingJobDetailDTOList)) {
               Integer partSchedulingStatus = checkNestingStatus(machinePartNestingJobDetailDTOList);
               mesBuildingBoChuJobDirectory.setPartSchedulingStatus(partSchedulingStatus);
            } else {
               mesBuildingBoChuJobDirectory.setPartSchedulingStatus(3);
            }

            try {
               this.mesBuildingBoChuJobDirectoryService.updateById(mesBuildingBoChuJobDirectory);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      );
   }

   private void changeBoChuJobDirectoryStatusByJobId(Integer jobId) {
      MesBuildingBoChuJobDirectory jobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      if (BeanUtil.isNotEmpty(jobDirectory)) {
         MesBuildingNestingTeam nestingTeam = this.mesBuildingNestingTeamService.getById(jobDirectory.getTeamCodeId());
         List<MachinePartNestingJobDetailDTO> machinePartNestingJobDetailDTOList = this.getNestingJobPart(jobId, nestingTeam.getTeamCode());
         if (CollectionUtils.isNotEmpty(machinePartNestingJobDetailDTOList)) {
            Integer partSchedulingStatus = checkNestingStatus(machinePartNestingJobDetailDTOList);
            jobDirectory.setPartSchedulingStatus(partSchedulingStatus);
         } else {
            jobDirectory.setPartSchedulingStatus(3);
         }

         try {
            this.mesBuildingBoChuJobDirectoryService.updateById(jobDirectory);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   public List<MesBuildingBoChuJobDirectoryDTO> buildTree(List<MesBuildingBoChuJobDirectoryDTO> data) {
      for (MesBuildingBoChuJobDirectoryDTO rootNode : data) {
         List<MesBuildingBoChuJobDirectoryDTO> validChildren = new ArrayList<>();

         for (MesBuildingBoChuJobDirectoryDTO secondLevelNode : rootNode.getChildren()) {
            if (!secondLevelNode.getChildren().isEmpty()) {
               validChildren.add(secondLevelNode);
            }
         }

         rootNode.setChildren(validChildren);
      }

      return data;
   }

   @Override
   public List<MesBuildingBoChuNestingResult> getWorkMachinePartListFromNesting(Integer jobId, Integer cutStatus, Integer cutSendStatus) {
      return new ArrayList<>();
   }

   private List<MachinePartNestingGuidDetailDTO> getBoChuNestingMachinePartDetailByJobIdListAndGuidList(
      List<Integer> jobIdList, String teamCode, List<String> guidList
   ) {
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      JSONObject bodyJson = new JSONObject();
      bodyJson.put("job_id", jobIdList);
      String resultStr = HttpRequest.post(url)
         .header(Header.CONTENT_TYPE.toString(), ContentType.JSON.toString())
         .header(BoChuNesting.headers(teamCode))
         .body(bodyJson.toJSONString())
         .execute()
         .body();
      JSONObject resultJson = JSONObject.parseObject(resultStr);
      if (Objects.equals(resultJson.getInteger("status"), 0)) {
         List<MachinePartNestingGuidDetailDTO> resultList = resultJson.getJSONArray("data")
            .stream()
            .map(i -> JSONUtil.toBean(i.toString(), MachinePartNestingGuidDetailDTO.class))
            .collect(Collectors.toList());
         return CollUtil.isNotEmpty(guidList) ? resultList.stream().filter(i -> guidList.contains(i.getGuid())).collect(Collectors.toList()) : resultList;
      } else {
         return Collections.emptyList();
      }
   }

   @Override
   public List<MesBuildingBoChuNestingResultNewDTO> getWorkMachinePartListFromNestingLocal(
      Integer jobId, Integer cutStatus, Integer cutSendStatus, String material, BigDecimal thickness
   ) {
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      Long teamCodeId = mesBuildingBoChuJobDirectoryList.get(0).getTeamCodeId();
      Long projectId = Long.valueOf(mesBuildingBoChuJobDirectoryList.get(0).getProjectId());
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      Preconditions.checkArgument(mesBuildingNestingTeam != null, "该工单没有指定团队");
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      List<MesBuildingBoChuNestingResultNewDTO> mesBuildingBoChuNestingResultNewDTOList = new ArrayList<>();
      LambdaQueryWrapper<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultLambdaQueryWrapper = new LambdaQueryWrapper<>();
      if (null != material) {
         mesBuildingBoChuNestingResultLambdaQueryWrapper.eq(MesBuildingBoChuNestingResult::getMaterial, material);
      }

      if (null != thickness) {
         mesBuildingBoChuNestingResultLambdaQueryWrapper.eq(MesBuildingBoChuNestingResult::getThickness, thickness);
      }

      if (null != cutSendStatus) {
         mesBuildingBoChuNestingResultLambdaQueryWrapper.eq(MesBuildingBoChuNestingResult::getCutSendStatus, cutSendStatus);
      }

      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
         .list(
            mesBuildingBoChuNestingResultLambdaQueryWrapper.eq(MesBuildingBoChuNestingResult::getJobId, jobId)
               .eq(MesBuildingBoChuNestingResult::getCutStatus, cutStatus)
         );
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultListAll = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getJobId, jobId));
      List<String> distinctGuidList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultList)) {
         distinctGuidList = mesBuildingBoChuNestingResultListAll.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      }

      JSONArray jsonGuidArray = new JSONArray();

      for (String guid : distinctGuidList) {
         jsonGuidArray.add(guid);
      }

      List<MachinePartNestingGuidDetailDTO> machinePartNestingGuidDetailDTOList = this.getBoChuNestingMachinePartDetailByJobIdListAndGuidList(
         CollUtil.newArrayList(jobId), systemTeamCode, distinctGuidList
      );
      machinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOList.stream().filter(dto -> dto != null).collect(Collectors.toList());
      List<MachinePartNestingGuidDetailDTO> distinctMachinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOList.stream()
         .collect(
            Collectors.collectingAndThen(
               Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MachinePartNestingGuidDetailDTO::getGuid))), ArrayList::new
            )
         );
      Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> needMachinePartSchedulingMap = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>().eq(MesBuildingTaskNeedMachinePartScheduling::getProjectId, projectId)
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getTaskOrderId() + "-" + e.getProductId()));
      Map<Long, TechMachinePart> techMachinePartMap = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

      for (MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult : mesBuildingBoChuNestingResultList) {
         String guid = mesBuildingBoChuNestingResult.getGuid();

         for (MachinePartNestingGuidDetailDTO machinePartNestingGuidDetailDTO : distinctMachinePartNestingGuidDetailDTOList) {
            if (machinePartNestingGuidDetailDTO.getGuid().equals(guid)) {
               MesBuildingBoChuNestingResultNewDTO mesBuildingBoChuNestingResultNewDTO = new MesBuildingBoChuNestingResultNewDTO();
               BeanUtils.copyProperties(mesBuildingBoChuNestingResult, mesBuildingBoChuNestingResultNewDTO);
               List<NestPartDTO> parts = machinePartNestingGuidDetailDTO.getParts();
               List<MesBuildingPartCheckDrillDTO> partList = new ArrayList<>();

               for (NestPartDTO part : parts) {
                  if (CollectionUtil.isNotEmpty(part.getProps())) {
                     Map<String, String> keyValueProps = part.getProps().stream().collect(Collectors.toMap(PropsDTO::getProp_name, PropsDTO::getProp_value));
                     String productId = keyValueProps.get("productId");
                     String taskOrderId = keyValueProps.get("taskOrderId");
                     Integer amount = part.getAmount();
                     TechMachinePart techMachinePart = techMachinePartMap.get(Long.valueOf(productId));
                     if (techMachinePart == null) {
                        techMachinePart = this.techMachinePartService.getById(productId);
                     }

                     MesBuildingPartCheckDrillDTO mesBuildingPartCheckDrillDTO = new MesBuildingPartCheckDrillDTO();
                     mesBuildingPartCheckDrillDTO.setId(Long.valueOf(productId));
                     mesBuildingPartCheckDrillDTO.setQuantity(amount);
                     mesBuildingPartCheckDrillDTO.setThick(techMachinePart.getThick());
                     mesBuildingPartCheckDrillDTO.setTaskOrderId(Long.valueOf(taskOrderId));
                     partList.add(mesBuildingPartCheckDrillDTO);
                  }
               }

               mesBuildingBoChuNestingResultNewDTO.setIsMixNest(Boolean.FALSE);
               StringBuilder nestJobName = new StringBuilder();
               Set<Long> taskOrderIds = new HashSet<>();

               for (MesBuildingPartCheckDrillDTO part : partList) {
                  taskOrderIds.add(part.getTaskOrderId());
                  if (taskOrderIds.size() > 1) {
                     mesBuildingBoChuNestingResultNewDTO.setIsMixNest(Boolean.TRUE);
                  }
               }

               for (Long taskOrderId : taskOrderIds) {
                  if (nestJobName.length() > 0) {
                     nestJobName.append(",");
                  }

                  nestJobName.append(this.mesBuildingTaskOrderService.getById(taskOrderId).getOrderNumber());
               }

               mesBuildingBoChuNestingResultNewDTO.setNestJobName(nestJobName.toString());
               mesBuildingBoChuNestingResultNewDTO.setPartList(partList);
               mesBuildingBoChuNestingResultNewDTOList.add(mesBuildingBoChuNestingResultNewDTO);
               break;
            }
         }
      }

      List<MesBuildingBoChuNestingResultNewDTO> distinctList = mesBuildingBoChuNestingResultNewDTOList.stream()
         .collect(
            Collectors.toMap(MesBuildingBoChuNestingResultNewDTO::getId, dto -> (MesBuildingBoChuNestingResultNewDTO)dto, (existing, replacement) -> existing)
         )
         .values()
         .stream()
         .collect(Collectors.toList());
      distinctList.sort(Comparator.comparing(MesBuildingBoChuNestingResultNewDTO::getThickness));
      return distinctList;
   }

   private List<MesBuildingBoChuNestingResultDTO> getMesBuildingBoChuNestingResultDTOList(String systemTeamCode, JSONArray jsonGuidArray) {
      List<MesBuildingBoChuNestingResultDTO> mesBuildingBoChuNestingResultDTOList = new ArrayList<>();

      for (MesBuildingBoChuNestingJobByGuidDTO mesBuildingBoChuNestingJobByGuidDTO : this.getJobByGuid(jsonGuidArray, systemTeamCode)) {
         Integer jobId1 = mesBuildingBoChuNestingJobByGuidDTO.getJob_list().get(0).getJob_id();
         mesBuildingBoChuNestingResultDTOList.addAll(this.getNestingJobPlate(jobId1, systemTeamCode));
      }

      return mesBuildingBoChuNestingResultDTOList;
   }

   @Override
   public Boolean exportMachinePartListFromNesting(
      MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam, HttpServletResponse response
   ) {
      Preconditions.checkArgument(mesBuildingMachinePartNestingExportParam.getMachineToolId() != null, "参数不能为空");
      String machineToolId = mesBuildingMachinePartNestingExportParam.getMachineToolId();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(machineToolId);
      Preconditions.checkArgument(mesBuildingMachinePartTeamDetail != null, "机床不存在");
      Integer ncFileFormat = mesBuildingMachinePartTeamDetail.getNcFileFormat();
      String ncFileType = this.baseMapper.getDictionaryByNameAndSort("nc_file_type", ncFileFormat);
      Integer jobId = mesBuildingMachinePartNestingExportParam.getJobId();
      String guid = mesBuildingMachinePartNestingExportParam.getResultList().get(0);
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      String teamCodeId = mesBuildingBoChuJobDirectoryList.get(0).getTeamCodeId().toString();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      List<NestCutFileTypeDTO> nestCutFileTypeDTOList = this.getNestCutFileType(systemTeamCode);
      List<String> titles = nestCutFileTypeDTOList.stream().map(NestCutFileTypeDTO::getTitle).collect(Collectors.toList());
      List<String> extensions = nestCutFileTypeDTOList.stream().map(NestCutFileTypeDTO::getExtension).collect(Collectors.toList());
      String extensionsStr = String.join(",", extensions);
      if (!ncFileType.equals(".LXDS")) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(nestCutFileTypeDTOList), systemTeamCode + "团队未配置除.LXDS类型外的其他套料切割文件导出");
         Preconditions.checkArgument(extensions.contains(ncFileType), systemTeamCode + "团队未配置该类型套料切割文件导出目前支持的切割文件格式后缀有:" + extensionsStr);
      }

      Map<String, List<MesBuildingNestingPlateFileJson>> mesBuildingNestingPlateFileJsonMap = this.mesBuildingNestingPlateFileJsonService
         .list(
            (Wrapper<MesBuildingNestingPlateFileJson>)((new LambdaQueryWrapper<MesBuildingNestingPlateFileJson>()
                     .eq(MesBuildingNestingPlateFileJson::getGuid, guid))
                  .eq(MesBuildingNestingPlateFileJson::getJobId, jobId))
               .eq(MesBuildingNestingPlateFileJson::getFileSuffix, ".LXDS")
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingNestingPlateFileJson::getGuid));
      List<String> titleList = nestCutFileTypeDTOList.stream()
         .filter(ex -> ex.getExtension().equals(ncFileType))
         .map(NestCutFileTypeDTO::getTitle)
         .collect(Collectors.toList());
      Map<String, List<MesBuildingNestingPlateFileJson>> nestingPlateFileJsonMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(titleList)) {
         nestingPlateFileJsonMap = this.mesBuildingNestingPlateFileJsonService
            .list(
               (Wrapper<MesBuildingNestingPlateFileJson>)((new LambdaQueryWrapper<MesBuildingNestingPlateFileJson>()
                        .eq(MesBuildingNestingPlateFileJson::getGuid, guid))
                     .eq(MesBuildingNestingPlateFileJson::getJobId, jobId))
                  .in(MesBuildingNestingPlateFileJson::getFileType, titleList)
            )
            .stream()
            .collect(Collectors.groupingBy(ex -> ex.getGuid() + "-" + ex.getFileType()));
      }

      if (ncFileType.equals(".LXDS")) {
         byte[] zipFileBytes = this.getNestCutFileLXDS(jobId, guid, systemTeamCode, mesBuildingNestingPlateFileJsonMap);
         response.setContentType("apply/octet-stream;charset=UTF-8");
         response.setContentType("application/zip");

         try {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("数控文件.zip", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
         } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
         }

         if (zipFileBytes != null) {
            try (OutputStream out = response.getOutputStream()) {
               out.write(zipFileBytes);
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         }

         return Boolean.TRUE;
      } else if (extensions.contains(ncFileType)) {
         AtomicReference<String> type = new AtomicReference<>();
         nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
            if (nestCutFileTypeDTO.getExtension().equals(ncFileType)) {
               type.set(nestCutFileTypeDTO.getTitle());
            }
         });
         byte[] zipFileBytes = this.getNestCutFileNC(jobId, guid, systemTeamCode, type.get(), nestingPlateFileJsonMap);
         response.setContentType("apply/octet-stream;charset=UTF-8");
         response.setContentType("application/zip");

         try {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("数控文件.zip", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
         } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
         }

         if (zipFileBytes != null) {
            try (OutputStream out = response.getOutputStream()) {
               out.write(zipFileBytes);
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         }

         return Boolean.TRUE;
      } else {
         Preconditions.checkArgument(false, "暂未支持的套料切割文件类型，目前支持的切割文件格式后缀有:", extensionsStr);
         return Boolean.FALSE;
      }
   }

   @Override
   public void exportMachinePartList(MachinePartNestingProductDetailDTOParam param, HttpServletResponse response) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getWorkshopIds()), "车间不能为空");
      Preconditions.checkArgument(param.getSendNestingStatus() != null, "下发状态不能为空");
      new ArrayList();
      List<MachinePartNestingDetailDTO> machinePartNestingDetailDTOList = this.baseMapper.getNeedMachinePartDetailList(param);
      if (!param.getSendNestingStatus()) {
         machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(i -> i.getQuantity() > 0).collect(Collectors.toList());
      } else {
         machinePartNestingDetailDTOList.forEach(i -> i.setQuantity(i.getSchedulingQuantity()));
      }

      Map<Long, String> pictureMap = new HashMap<>(10);
      Map<Long, Long> drwaingIdMap = new HashMap<>(10);
      if (CollectionUtils.isNotEmpty(machinePartNestingDetailDTOList)) {
         List<Long> machinePartIds = machinePartNestingDetailDTOList.stream().map(MachinePartNestingDetailDTO::getPartId).collect(Collectors.toList());

         for (PicturePathDTO picturePathDTO : (List<PicturePathDTO>)this.techDrawingService.selectMachDrawing(machinePartIds)) {
            pictureMap.put(picturePathDTO.getProductId(), picturePathDTO.getPicturePath());
            drwaingIdMap.put(picturePathDTO.getProductId(), picturePathDTO.getDrwaingId());
            if (picturePathDTO.getPicturePath() != null) {
               String picturePath = picturePathDTO.getPicturePath().replace("\\", "/");
               pictureMap.put(picturePathDTO.getProductId(), picturePath);
            }
         }

         machinePartNestingDetailDTOList.forEach(i -> {
            if (pictureMap.get(i.getPartId()) != null) {
               String filePath = this.dxfPath + pictureMap.get(i.getPartId());
               filePath = filePath.replace(".svg", ".dxf");
               File file = new File(filePath);
               if (file.isFile()) {
                  try {
                     i.setIsRectangle(Rectangle.isRectangleDXF(filePath, 2.0));
                  } catch (Exception e) {
                     log.info("dxf文件解析失败:{}", filePath);
                     i.setIsRectangle(-1);
                  }
               }
            } else {
               i.setIsRectangle(-1);
            }

            i.setPicturePath(pictureMap.get(i.getPartId()) == null ? null : this.ip + "files/" + pictureMap.get(i.getPartId()));
         });
         machinePartNestingDetailDTOList.forEach(i -> i.setDrwaingId(drwaingIdMap.get(i.getPartId()) == null ? null : drwaingIdMap.get(i.getPartId())));
      }

      Integer totalNeedQuantity = machinePartNestingDetailDTOList.stream().mapToInt(MachinePartNestingDetailDTO::getQuantity).sum();
      BigDecimal totalNeedWeight = machinePartNestingDetailDTOList.stream()
         .map(item -> item.getWeight().multiply(BigDecimal.valueOf(item.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      if (CollectionUtils.isNotEmpty(machinePartNestingDetailDTOList)) {
         machinePartNestingDetailDTOList.forEach(i -> i.setTotalSchedulingQuantity(totalNeedQuantity));
         machinePartNestingDetailDTOList.forEach(i -> i.setTotalNeedWeight(totalNeedWeight));
      }

      List<Integer> isRectangle = param.getIsRectangle();
      machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream()
         .filter(e -> isRectangle == null || isRectangle.contains(e.getIsRectangle()))
         .collect(Collectors.toList());
      Boolean boolDxfEnum = param.getBoolDxfEnum();
      if (boolDxfEnum != null) {
         if (boolDxfEnum) {
            machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(e -> e.getPicturePath() != null).collect(Collectors.toList());
         } else {
            machinePartNestingDetailDTOList = machinePartNestingDetailDTOList.stream().filter(e -> e.getPicturePath() == null).collect(Collectors.toList());
         }
      }

      ExportParams exportParams = new ExportParams();
      exportParams.setType(ExcelType.XSSF);
      exportParams.setFixedTitle(false);
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, MachinePartNestingDetailDTO.class, machinePartNestingDetailDTOList);
      PoiUtils.downLoadExcel("零件排产详情.xlsx", response, workbook);
   }

   private byte[] unzipSingleFile(byte[] zipFileBytes, String fileName, String idNumber) throws IOException {
      try (
         InputStream zipInputStream = new ByteArrayInputStream(zipFileBytes);
         ZipInputStream zis = new ZipInputStream(zipInputStream);
      ) {
         ZipEntry entry = zis.getNextEntry();
         if (entry == null) {
            throw new IOException("ZIP 文件为空或没有文件");
         }

         String fileNameNest = entry.getName();
         List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
            .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getChildGuid, idNumber));
         if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultList)) {
            for (MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult : mesBuildingBoChuNestingResultList) {
               mesBuildingBoChuNestingResult.setFileName(fileName);
               mesBuildingBoChuNestingResult.setFileNameNest(fileNameNest);
            }

            this.mesBuildingBoChuNestingResultService.updateBatchById(mesBuildingBoChuNestingResultList);
         }

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         byte[] buffer = new byte[1024];

         int bytesRead;
         while ((bytesRead = zis.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
         }

         return byteArrayOutputStream.toByteArray();
      }
   }

   @Override
   public void setMachineTool(MachinePartNestingCutJobParam machinePartNestingCutJobParam) {
      if (machinePartNestingCutJobParam != null) {
         String id = machinePartNestingCutJobParam.getId();
         MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = this.mesBuildingBoChuNestingResultService.getById(id);
         if (mesBuildingBoChuNestingResult != null) {
            mesBuildingBoChuNestingResult.setMachineToolId(machinePartNestingCutJobParam.getMachineToolId());
            this.mesBuildingBoChuNestingResultService.updateById(mesBuildingBoChuNestingResult);
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<MesBuildingTaskNeedMachinePartScheduling> saveMachinePartNestingCut(MachinePartNestingCutParam machinePartNestingCutParam) {
      Preconditions.checkArgument(machinePartNestingCutParam.getJobId() != null, "作业为空");
      LocalDateTime finishDate = machinePartNestingCutParam.getFinishDate();
      Integer jobId = machinePartNestingCutParam.getJobId();
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      Long teamCodeId = mesBuildingBoChuJobDirectoryList.get(0).getTeamCodeId();
      String projectId = mesBuildingBoChuJobDirectoryList.get(0).getProjectId();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingBoChuJobDirectoryList), "作业不存在");
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryProjectList = this.mesBuildingBoChuJobDirectoryService
         .list(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
               .eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuJobDirectory.getParentId())
         );
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryWorkShopList = this.mesBuildingBoChuJobDirectoryService
         .list(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
               .eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuJobDirectoryProjectList.get(0).getParentId())
         );
      Long machineTool = machinePartNestingCutParam.getMachineTool();
      List<MachinePartNestingCutJobParam> machinePartNestingCutJobParamList = machinePartNestingCutParam.getMachinePartNestingCutJobParamList();
      Optional<MachinePartNestingCutJobParam> maxThickObject = machinePartNestingCutJobParamList.stream()
         .max(Comparator.comparing(param -> new BigDecimal(param.getThick())));
      List<String> guids = machinePartNestingCutJobParamList.stream().map(MachinePartNestingCutJobParam::getGuid).collect(Collectors.toList());
      List<String> childGuids = machinePartNestingCutJobParamList.stream().map(MachinePartNestingCutJobParam::getChildGuid).collect(Collectors.toList());
      this.nestBiz.generateSurplus(childGuids);
      CutTaskRequestData cutTaskRequestData = new CutTaskRequestData();
      cutTaskRequestData.setOrderType(1L);
      cutTaskRequestData.setWorkshopLevelName(mesBuildingBoChuJobDirectoryWorkShopList.get(0).getJobName());
      cutTaskRequestData.setProjectLevelName(mesBuildingBoChuJobDirectoryProjectList.get(0).getJobName());
      cutTaskRequestData.setGroupTaskLevelName(mesBuildingBoChuJobDirectory.getJobName());
      cutTaskRequestData.setCode(machinePartNestingCutParam.getJobId().toString());
      cutTaskRequestData.setWorkshopId(machinePartNestingCutParam.getWorkshop());
      List<CreateDto> createDtos = new ArrayList<>();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService
         .getById(machinePartNestingCutParam.getMachineTool());
      cutTaskRequestData.setMid(mesBuildingMachinePartTeamDetail.getMID());
      Integer ncFileFormat = mesBuildingMachinePartTeamDetail.getNcFileFormat();
      Integer deviceTypeFormat = mesBuildingMachinePartTeamDetail.getDeviceType();
      String ncFileTitleType = this.baseMapper.getDictionaryByNameAndSort("nc_file_type", ncFileFormat);
      String ncFileTitle = StrUtil.subBefore(ncFileTitleType, ".", true);
      String ncFileType = StrUtil.concat(true, ".", StrUtil.subAfter(ncFileTitleType, ".", true));
      String deviceType = this.baseMapper.getDictionaryByNameAndSort("device_type", deviceTypeFormat);
      Preconditions.checkArgument(mesBuildingMachinePartTeamDetail != null, "机床不存在");
      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "所选切割方式的钻孔工艺配置不存在");
      MesBuildingCutConfig mesBuildingCutConfig = mesBuildingCutConfigList.get(0);
      Preconditions.checkArgument(mesBuildingCutConfig != null, "所选切割方式的钻孔工艺配置不存在");
      MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingCutConfig.getName());
      String think = maxThickObject.get().getThick();
      BigDecimal minThickness = new BigDecimal(mesBuildingCutConfig.getMinThickness());
      BigDecimal maxThickness = new BigDecimal(mesBuildingCutConfig.getMaxThickness());
      BigDecimal partThickness = new BigDecimal(think);
      Preconditions.checkArgument(
         partThickness.compareTo(minThickness) >= 0 && partThickness.compareTo(maxThickness) <= 0,
         "操作失败,厚度" + think + "不在" + minThickness + "-" + maxThickness + "的厚度范围中"
      );
      List<NestCutFileTypeDTO> nestCutFileTypeDTOList = this.getNestCutFileType(systemTeamCode);
      List<String> extensions = nestCutFileTypeDTOList.stream().map(NestCutFileTypeDTO::getExtension).collect(Collectors.toList());
      String extensionsStr = String.join(",", extensions);
      if (!ncFileType.equals(".LXDS")) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(nestCutFileTypeDTOList), systemTeamCode + "团队未配置除.LXDS类型外的其他套料切割文件导出");
         Preconditions.checkArgument(extensions.contains(ncFileType), systemTeamCode + "团队未配置该类型套料切割文件导出目前支持的切割文件格式后缀有:" + extensionsStr);
      }

      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultListAll = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getJobId, jobId));
      List<String> distinctGuidList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultListAll)) {
         distinctGuidList = mesBuildingBoChuNestingResultListAll.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      }

      Map<Long, List<MesBuildingNestTeamConfig>> mesBuildingNestTeamConfigMap = this.mesBuildingNestTeamConfigService
         .list()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingNestTeamConfig::getTeamId));
      List<MachinePartNestingGuidDetailDTO> machinePartNestingGuidDetailDTOList = this.getBoChuNestingMachinePartDetailByJobIdListAndGuidList(
         ListUtil.toList(jobId), systemTeamCode, distinctGuidList
      );
      machinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOList.stream().filter(dto -> dto != null).collect(Collectors.toList());
      List<MachinePartNestingGuidDetailDTO> distinctMachinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOList.stream()
         .collect(
            Collectors.collectingAndThen(
               Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MachinePartNestingGuidDetailDTO::getGuid))), ArrayList::new
            )
         );
      Map<Long, MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultMap = this.mesBuildingBoChuNestingResultService
         .listByIds(machinePartNestingCutJobParamList.stream().map(MachinePartNestingCutJobParam::getId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingBoChuNestingResult::getId, Function.identity()));
      Map<String, List<MesBuildingNestingPlateFileJson>> mesBuildingNestingPlateFileJsonMap = this.mesBuildingNestingPlateFileJsonService
         .list(
            (Wrapper<MesBuildingNestingPlateFileJson>)((new LambdaQueryWrapper<MesBuildingNestingPlateFileJson>()
                     .in(
                        MesBuildingNestingPlateFileJson::getGuid,
                        mesBuildingBoChuNestingResultMap.values().stream().map(MesBuildingBoChuNestingResult::getGuid).collect(Collectors.toList())
                     ))
                  .eq(MesBuildingNestingPlateFileJson::getJobId, jobId))
               .eq(MesBuildingNestingPlateFileJson::getFileSuffix, ".LXDS")
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingNestingPlateFileJson::getGuid));
      List<String> titleList = nestCutFileTypeDTOList.stream()
         .filter(ex -> ex.getExtension().equals(ncFileType))
         .map(NestCutFileTypeDTO::getTitle)
         .collect(Collectors.toList());
      Map<String, List<MesBuildingNestingPlateFileJson>> NestingPlateFileJsonMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(titleList)) {
         NestingPlateFileJsonMap = this.mesBuildingNestingPlateFileJsonService
            .list(
               (Wrapper<MesBuildingNestingPlateFileJson>)((new LambdaQueryWrapper<MesBuildingNestingPlateFileJson>()
                        .in(
                           MesBuildingNestingPlateFileJson::getGuid,
                           mesBuildingBoChuNestingResultMap.values().stream().map(MesBuildingBoChuNestingResult::getGuid).collect(Collectors.toList())
                        ))
                     .eq(MesBuildingNestingPlateFileJson::getJobId, jobId))
                  .in(MesBuildingNestingPlateFileJson::getFileType, titleList)
            )
            .stream()
            .collect(Collectors.groupingBy(ex -> ex.getGuid() + "-" + ex.getFileType()));
      }

      List<Long> scheduleIds = new ArrayList<>();
      distinctMachinePartNestingGuidDetailDTOList.forEach(
         machinePartNestingGuidDetailDTO -> {
            String guid = machinePartNestingGuidDetailDTO.getGuid();
            if (guids.contains(guid)) {
               machinePartNestingCutJobParamList.forEach(
                  machinePartNestingCutJobParam -> {
                     MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = mesBuildingBoChuNestingResultMap.get(
                        Long.valueOf(machinePartNestingCutJobParam.getId())
                     );
                     if (mesBuildingBoChuNestingResult != null) {
                        String chuChildGuid = mesBuildingBoChuNestingResult.getChildGuid();
                        machinePartNestingCutJobParam.setChildGuid(chuChildGuid);
                        if (chuChildGuid.contains(guid)) {
                           List<NestPartDTO> parts = machinePartNestingGuidDetailDTO.getParts();
                           MesBuildingMachinePartSchedulingDTOParam mesBuildingMachinePartSchedulingDTOParam = new MesBuildingMachinePartSchedulingDTOParam();
                           List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList = new ArrayList<>();
                           mesBuildingMachinePartSchedulingDTOParam.setCutConfigId(machineTool);
                           mesBuildingMachinePartSchedulingDTOParam.setBcGuid(chuChildGuid);
                           mesBuildingMachinePartSchedulingDTOParam.setGroupsId(mesBuildingMachinePartTeamDetail.getGroupsId());
                           mesBuildingMachinePartSchedulingDTOParam.setSaveType(1);
                           mesBuildingMachinePartSchedulingDTOParam.setChildOrderNumber(mesBuildingBoChuNestingResult.getChildOrderNumber());
                           mesBuildingMachinePartSchedulingDTOParam.setJobId(jobId);
                           mesBuildingMachinePartSchedulingDTOParam.setAskCompleteTime(machinePartNestingCutParam.getFinishDate());
                           mesBuildingMachinePartSchedulingDTOParam.setDrillCutConfigId(machinePartNestingCutParam.getDrillCutConfigId());
                           mesBuildingMachinePartSchedulingDTOParam.setDrillGroupsId(machinePartNestingCutParam.getDrillGroupsId());
                           mesBuildingMachinePartSchedulingDTOParam.setDrillAskCompleteTime(machinePartNestingCutParam.getDrillAskCompleteTime());
                           mesBuildingMachinePartSchedulingDTOParam.setBoolOffLine(false);
                           mesBuildingMachinePartSchedulingDTOParam.setProductionLineId(machinePartNestingCutParam.getProductionLineId());
                           mesBuildingMachinePartSchedulingDTOParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
                           Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> needMachinePartSchedulingMap = this.baseMapper
                              .selectList(
                                 (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                       .eq(MesBuildingTaskNeedMachinePartScheduling::getProjectId, projectId))
                                    .apply("need_quantity - scheduling_quantity >= 0")
                              )
                              .stream()
                              .collect(Collectors.groupingBy(ex -> ex.getTaskOrderId() + "-" + ex.getProductId()));
                           List<Long> duplicatePartIdList = new ArrayList<>();
                           parts.stream()
                              .map(
                                 partx -> partx.getProps()
                                    .stream()
                                    .filter(prop -> prop.getProp_name().equals("productId"))
                                    .map(PropsDTO::getProp_value)
                                    .collect(Collectors.toList())
                              )
                              .flatMap(Collection::stream)
                              .collect(Collectors.groupingBy(key -> (String)key, Collectors.counting()))
                              .forEach((k, v) -> {
                                 if (StrUtil.isNotBlank(k) && v > 1L) {
                                    duplicatePartIdList.add(Long.valueOf(k));
                                 }
                              });

                           for (NestPartDTO part : parts) {
                              if (CollectionUtil.isNotEmpty(part.getProps())) {
                                 Integer amount = part.getAmount();
                                 if (CollectionUtil.isNotEmpty(part.getProps())) {
                                    Map<String, String> keyValueProps = part.getProps()
                                       .stream()
                                       .collect(Collectors.toMap(PropsDTO::getProp_name, PropsDTO::getProp_value));
                                    String productId = keyValueProps.get("productId");
                                    String taskOrderId = keyValueProps.get("taskOrderId");
                                    List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = needMachinePartSchedulingMap.get(
                                       taskOrderId + "-" + productId
                                    );
                                    if (CollectionUtils.isEmpty(mesBuildingTaskNeedMachinePartSchedulingList)) {
                                       mesBuildingTaskNeedMachinePartSchedulingList = this.baseMapper
                                          .selectList(
                                             (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                                   .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId))
                                                .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productId)
                                          );
                                    }

                                    int sum = mesBuildingTaskNeedMachinePartSchedulingList.stream()
                                       .mapToInt(ex -> ex.getNeedQuantity() - ex.getSchedulingQuantity())
                                       .sum();
                                    String partIdStr = part.getProps()
                                       .stream()
                                       .filter(prop -> prop.getProp_name().equals("productId"))
                                       .map(PropsDTO::getProp_value)
                                       .findFirst()
                                       .orElse(null);
                                    Preconditions.checkArgument(StrUtil.isNotBlank(partIdStr), "套料数据异常, 请联系管理员");
                                    if (!duplicatePartIdList.contains(Long.valueOf(partIdStr))) {
                                       Preconditions.checkArgument(sum >= amount, "套料可排产数量不足，请联系管理员");
                                    }

                                    if (CollectionUtils.isNotEmpty(mesBuildingTaskNeedMachinePartSchedulingList)) {
                                       for (MesBuildingTaskNeedMachinePartScheduling mesBuildingTaskNeedMachinePartScheduling : mesBuildingTaskNeedMachinePartSchedulingList) {
                                          MesBuildingMachinePartSchedulingLinkDTOParam mesBuildingMachinePartSchedulingLinkDTOParam = new MesBuildingMachinePartSchedulingLinkDTOParam();
                                          mesBuildingMachinePartSchedulingLinkDTOParam.setId(mesBuildingTaskNeedMachinePartScheduling.getId());
                                          mesBuildingMachinePartSchedulingLinkDTOParam.setProjectId(Long.valueOf(projectId));
                                          mesBuildingMachinePartSchedulingLinkDTOParam.setProductId(Long.valueOf(keyValueProps.get("productId")));
                                          mesBuildingMachinePartSchedulingLinkDTOParam.setOrderId(
                                             mesBuildingTaskNeedMachinePartScheduling.getTaskOrderId().toString()
                                          );
                                          mesBuildingMachinePartSchedulingLinkDTOParam.setNeedSchedulingMonth(finishDate);
                                          Integer schedulingQuantity = mesBuildingTaskNeedMachinePartScheduling.getSchedulingQuantity();
                                          if (amount
                                             > mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity()
                                                - mesBuildingTaskNeedMachinePartScheduling.getSchedulingQuantity()) {
                                             mesBuildingMachinePartSchedulingLinkDTOParam.setQuantity(
                                                mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity()
                                                   - mesBuildingTaskNeedMachinePartScheduling.getSchedulingQuantity()
                                             );
                                             mesBuildingTaskNeedMachinePartScheduling.setSchedulingQuantity(
                                                mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity()
                                             );
                                             amount = amount - (mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity() - schedulingQuantity);
                                             this.baseMapper.updateById(mesBuildingTaskNeedMachinePartScheduling);
                                             linkList.add(mesBuildingMachinePartSchedulingLinkDTOParam);
                                          }

                                          if (amount
                                                - (
                                                   mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity()
                                                      - mesBuildingTaskNeedMachinePartScheduling.getSchedulingQuantity()
                                                )
                                             <= 0) {
                                             mesBuildingMachinePartSchedulingLinkDTOParam.setQuantity(amount);
                                             mesBuildingTaskNeedMachinePartScheduling.setSchedulingQuantity(schedulingQuantity + amount);
                                             this.baseMapper.updateById(mesBuildingTaskNeedMachinePartScheduling);
                                             linkList.add(mesBuildingMachinePartSchedulingLinkDTOParam);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           mesBuildingMachinePartSchedulingDTOParam.setLinkList(linkList);
                           if (CollectionUtil.isNotEmpty(linkList)) {
                              Long aLong = this.machinePartSchedulingBiz.saveMachinePartNestCutNew(mesBuildingMachinePartSchedulingDTOParam);
                              scheduleIds.add(aLong);
                           }
                        }
                     }
                  }
               );
            }
         }
      );
      Map<String, List<MesBuildingNestingPlateFileJson>> finalNestingPlateFileJsonMap = NestingPlateFileJsonMap;
      machinePartNestingCutJobParamList.forEach(
         machinePartNestingCutJobParam -> {
            String guid = machinePartNestingCutJobParam.getGuid();
            CreateDto createDto = new CreateDto();
            createDto.setCuttingWay(deviceType);
            mesBuildingMachinePartTeamDetail.getPartType();
            createDto.setTexture(machinePartNestingCutJobParam.getMaterial());
            createDto.setPartNum(machinePartNestingCutJobParam.getPartQuantity());
            createDto.setNum(machinePartNestingCutJobParam.getQuantity());
            createDto.setLength(machinePartNestingCutJobParam.getLength());
            createDto.setIdNumber(machinePartNestingCutJobParam.getChildGuid());
            createDto.setBreadth(machinePartNestingCutJobParam.getWidth());
            createDto.setThickness(machinePartNestingCutJobParam.getThick());
            createDto.setPartNum(machinePartNestingCutJobParam.getPartQuantity());
            byte[] zipFileBytes = null;
            if (ncFileType.equals(".LXDS")) {
               zipFileBytes = this.getNestCutFileLXDSV2(jobId, guid, systemTeamCode, mesBuildingNestingPlateFileJsonMap);
            } else {
               if (!extensions.contains(ncFileType)) {
                  throw new RuntimeException("团队码：" + systemTeamCode + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType);
               }

               AtomicReference<String> type = new AtomicReference<>();
               if (StrUtil.isNotBlank(ncFileTitle)) {
                  nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                     if (Objects.equals(nestCutFileTypeDTO.getExtension(), ncFileType) && Objects.equals(nestCutFileTypeDTO.getTitle(), ncFileTitle)) {
                        type.set(nestCutFileTypeDTO.getTitle());
                     }
                  });
               } else {
                  nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                     if (nestCutFileTypeDTO.getExtension().equals(ncFileType)) {
                        type.set(nestCutFileTypeDTO.getTitle());
                     }
                  });
               }

               Preconditions.checkArgument(StrUtil.isNotBlank(type.get()), "团队码：" + systemTeamCode + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType);
               zipFileBytes = this.getNestCutFileNCV2(jobId, guid, systemTeamCode, type.get(), finalNestingPlateFileJsonMap);
            }

            try {
               String toDay = LocalDate.now().format(DatePattern.PURE_DATE_FORMATTER);
               if (!this.redisUtils.hasKey("program_name_serial_no" + toDay)) {
                  List<MesBuildingBoChuNestingResult> list = this.mesBuildingBoChuNestingResultService
                     .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().like(MesBuildingBoChuNestingResult::getFileName, toDay));
                  Integer serialNo = list.stream().map(i -> {
                     String name = StrUtil.subBefore(i.getFileName(), ".", true);
                     return StrUtil.subAfter(name, toDay, true);
                  }).filter(NumberUtil::isNumber).map(Integer::parseInt).max(Integer::compareTo).orElse(0);
                  this.redisUtils.set("program_name_serial_no" + toDay, Long.valueOf(toDay + String.format("%03d", serialNo)), 86400L);
               }

               Long filename = this.redisUtils.incr("program_name_serial_no" + toDay, 1L);
               createDto.setFileName(filename + ncFileType);
               String fileName = createDto.getFileName();
               String idNumber = createDto.getIdNumber();
               byte[] fileBytes = this.unzipSingleFile(zipFileBytes, fileName, idNumber);
               createDto.setFile(fileBytes);
            } catch (IOException e) {
               throw new RuntimeException("下发物联时柏楚切割文件解析出错：" + e.getMessage());
            }

            createDtos.add(createDto);
         }
      );
      cutTaskRequestData.setCreateDtos(createDtos);

      try {
         NestResultDTO nestResultDTO = this.cutTaskClient.insertCuttingOrder(cutTaskRequestData);
         log.info("套料下发调用物联接口返回结果：{}", nestResultDTO);
         if (nestResultDTO.getCode().equals("000000")) {
            List<MesBuildingMachinePartScheduling> mesBuildingMachinePartSchedulingList = this.mesBuildingMachinePartSchedulingService.listByIds(scheduleIds);
            machinePartNestingCutJobParamList.forEach(
               machinePartNestingCutJobParam -> {
                  MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = this.mesBuildingBoChuNestingResultService
                     .getById(machinePartNestingCutJobParam.getId());
                  mesBuildingBoChuNestingResult.setCutSendStatus(CutSendEnum.DISPATCHED.getCode());
                  mesBuildingBoChuNestingResult.setCutSendTime(LocalDateTime.now());
                  mesBuildingBoChuNestingResult.setMachineToolId(machineTool);
                  mesBuildingBoChuNestingResult.setCutSendUserId(UserUtil.getCurrentUserId());
                  mesBuildingBoChuNestingResult.setCutSendUserName(UserUtil.getCurrentName());
                  mesBuildingBoChuNestingResult.setCutStatus(CutStatusEnum.NOT_CUT.getCode());
                  this.mesBuildingBoChuNestingResultService.updateById(mesBuildingBoChuNestingResult);
               }
            );
            return null;
         } else {
            log.info("物联接口调用异常");
            throw new RuntimeException("切割任务下发失败,调用物联接口异常: ");
         }
      } catch (Exception e) {
         log.info("物联接口调用异常");
         throw new RuntimeException("调用物联接口异常:" + e.getMessage());
      }
   }

   private List<MachinePartNestingGuidDetailDTO> getNestPartDetail(Integer jobId) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      HttpHeaders headers = BoChuNesting.headers("N6Y1RZ");
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      JSONArray result = j.getJSONArray("data");
      List<MachinePartNestingGuidDetailDTO> machinePartNestingGuidDetailDTOList = new ArrayList<>();

      for (int i = 0; i < result.size(); i++) {
         JSONObject item = result.getJSONObject(i);
         new ObjectMapper();

         try {
            String resultStr = item.toString();
            resultStr = resultStr.substring(1, resultStr.length() - 1);
            log.info(item.toString());
            MachinePartNestingGuidDetailDTO machinePartNestingDetailDTO = item.toJavaObject(MachinePartNestingGuidDetailDTO.class);
            System.out.println("Name: " + machinePartNestingDetailDTO);
            machinePartNestingGuidDetailDTOList.add(machinePartNestingDetailDTO);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      return machinePartNestingGuidDetailDTOList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateMachinePartNestingCutJob(MachinePartNestingCutJobUpdateParam machinePartNestingCutJobUpdateParam) {
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
         .list(
            (Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>()
               .eq(MesBuildingBoChuNestingResult::getChildGuid, machinePartNestingCutJobUpdateParam.getId())
         );
      if (CollectionUtils.isNotEmpty(mesBuildingBoChuNestingResultList)) {
         mesBuildingBoChuNestingResultList.forEach(
            mesBuildingBoChuNestingResult -> {
               mesBuildingBoChuNestingResult.setCutStatus(machinePartNestingCutJobUpdateParam.getCutStatus());
               mesBuildingBoChuNestingResult.setTaskRate(machinePartNestingCutJobUpdateParam.getTaskRate());
               this.mesBuildingBoChuNestingResultService.updateById(mesBuildingBoChuNestingResult);
               if (mesBuildingBoChuNestingResult.getTaskRate().compareTo(new BigDecimal("100")) == 0) {
                  List<MesBuildingMachinePartScheduling> mesBuildingMachinePartSchedulingList = this.mesBuildingMachinePartSchedulingService
                     .list(
                        (Wrapper<MesBuildingMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingMachinePartScheduling>()
                           .eq(MesBuildingMachinePartScheduling::getBcGuid, mesBuildingBoChuNestingResult.getChildGuid())
                     );
                  if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSchedulingList)) {
                     MesBuildingMachinePartScheduling mesBuildingMachinePartScheduling = mesBuildingMachinePartSchedulingList.get(0);
                     Long cutConfigId = mesBuildingMachinePartScheduling.getCutConfigId();
                     MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
                     Long userIdNest;
                     if (mesBuildingMachinePartTeamDetail != null) {
                        Long groupsId = mesBuildingMachinePartTeamDetail.getGroupsId();
                        MesBuildingTeamUserLink mesBuildingTeamUserLink = this.mesBuildingTeamUserLinkService.getTeamLeaderNameByTeamId(groupsId);
                        userIdNest = mesBuildingTeamUserLink.getUserId();
                     } else {
                        userIdNest = null;
                     }

                     Long machinePartSchedulingId = mesBuildingMachinePartScheduling.getId();
                     List<MesBuildingNestCutPlate> mesBuildingNestCutPlateList = this.mesBuildingNestCutPlateService
                        .list(
                           (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
                              .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, machinePartSchedulingId)
                        );
                     MesBuildingNestCutPlate mesBuildingNestCutPlate = mesBuildingNestCutPlateList.get(0);
                     mesBuildingNestCutPlate.setBoolProductionEunm(Boolean.TRUE);
                     Long mesBuildingNestCutPlateId = mesBuildingNestCutPlate.getId();
                     List<MesBuildingNestCutPlatePart> mesBuildingNestCutPlatePartList = this.mesBuildingNestCutPlatePartService
                        .list(
                           (Wrapper<MesBuildingNestCutPlatePart>)new LambdaQueryWrapper<MesBuildingNestCutPlatePart>()
                              .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, mesBuildingNestCutPlateId)
                        );
                     if (CollectionUtils.isNotEmpty(mesBuildingNestCutPlatePartList)) {
                        mesBuildingNestCutPlatePartList.forEach(
                           mesBuildingNestCutPlatePart -> {
                              List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
                                 .list(
                                    (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                                          .eq(MesBuildingTaskProcess::getProductId, mesBuildingNestCutPlatePart.getPartId()))
                                       .eq(MesBuildingTaskProcess::getNestCutPlateId, mesBuildingNestCutPlateId)
                                 );
                              List<Long> partIds = new ArrayList<>();
                              List<IdAndRecelveQuantityDTO> idAndRecelveQuantityDTOS = new ArrayList<>();
                              Long partId = mesBuildingNestCutPlatePart.getPartId();
                              partIds.add(partId);
                              Integer quantity = mesBuildingNestCutPlatePart.getQuantity();
                              idAndRecelveQuantityDTOS.add(new IdAndRecelveQuantityDTO(partId, quantity));
                              if (CollectionUtils.isNotEmpty(mesBuildingTaskProcessList)) {
                                 Long taskId = mesBuildingTaskProcessList.get(0).getTaskId();
                                 mesBuildingTaskProcessList.forEach(
                                    mesBuildingTaskProcess -> {
                                       Integer needQuantity = mesBuildingTaskProcess.getNeedQuantity();
                                       if (mesBuildingTaskProcess.getSequence() == 0 && null == mesBuildingTaskProcess.getCompleteTime()) {
                                          this.taskFastBiz
                                             .saveNestCutPlateReportFast(
                                                mesBuildingNestCutPlateId, partIds, null, true, idAndRecelveQuantityDTOS, userIdNest, null
                                             );
                                       }

                                       if (mesBuildingTaskProcess.getSequence() == 1 && null == mesBuildingTaskProcess.getCompleteTime()) {
                                          this.taskFastBiz
                                             .saveDrillNestCutPlateReportFast(mesBuildingNestCutPlateId, idAndRecelveQuantityDTOS, true, userIdNest);
                                       }
                                    }
                                 );
                              }
                           }
                        );
                     }
                  }
               }
            }
         );
         return true;
      } else {
         return false;
      }
   }

   private void updateQuantity(Long taskId, Integer reportQuantity) {
      MesBuildingTask task = this.taskService.getById(taskId);
      if (task.getInProductionTime() == null) {
         task.setInProductionTime(LocalDateTime.now());
         ContractProject project = this.projectService.getById(task.getProjectId());
         if (project != null && project.getMesStartDate() == null) {
            project.setMesStartDate(LocalDateTime.now());
            this.projectService.updateById(project);
         }
      }

      task.setInProductionQuantity(task.getInProductionQuantity() + reportQuantity);
      Preconditions.checkArgument(this.taskService.updateById(task), "上报中,请刷新页面");
      this.productionSummaryService
         .updateRecord(
            ProductProductionSummaryDTOParam.builder()
               .projectId(task.getProjectId())
               .monomerId(task.getMonomerId())
               .productId(task.getProductId())
               .productType(task.getTaskTypeEnum())
               .inProductionQuantity(reportQuantity)
               .build()
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void downloadPdf(HttpServletResponse response, String resultId, Long machineToolId) {
      try {
         this.generatePdf(response, resultId, machineToolId);
      } catch (IOException e) {
         throw new BusinessException("报告单下载失败");
      }
   }

   @Override
   public NestPdfDataDTO getNestPdfData(String resultId, Long machineToolId) throws IOException {
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getGuid, resultId));
      Integer jobId = mesBuildingBoChuNestingResultList.get(0).getJobId();
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      String teamCodeId = mesBuildingBoChuJobDirectoryList.get(0).getTeamCodeId().toString();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      List<MesBuildingNestingPlateJson> mesBuildingNestingJsonList = this.mesBuildingNestingPlateJsonService
         .list((Wrapper<MesBuildingNestingPlateJson>)new LambdaQueryWrapper<MesBuildingNestingPlateJson>().eq(MesBuildingNestingPlateJson::getGuid, resultId));
      MachinePartNestingPdfDTO dto = new MachinePartNestingPdfDTO();
      Image img = null;
      if (CollectionUtil.isNotEmpty(mesBuildingNestingJsonList)) {
         String jobPatJson = null;

         try {
            jobPatJson = new String(mesBuildingNestingJsonList.get(0).getJobPartJson(), "UTF-8");
         } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
         }

         JSONObject j = JSON.parseObject(jobPatJson);
         if (j.get("status").equals("-1")) {
            dto = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         }

         JSONObject dataObject = j.getJSONObject("data");

         try {
            dto = dataObject.toJavaObject(MachinePartNestingPdfDTO.class);
         } catch (Exception e) {
            e.printStackTrace();
         }

         if (null == dto) {
            dto = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         }

         img = this.byteArrayToITextImage(mesBuildingNestingJsonList.get(0).getPlateDrawing());
      } else {
         dto = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, dto.getResult_info().get(0).getUuid());
         img = new Image(ImageDataFactory.create(imagePath));
         img.setHorizontalAlignment(HorizontalAlignment.LEFT);
         img.setWidth(525.0F);
         img.setHeight(180.0F);
      }

      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .list(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
               .eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuNestingResultList.get(0).getJobId())
         )
         .get(0);
      String[] projectIdArray = mesBuildingBoChuJobDirectory.getProjectId().split(",");
      String[] teamIdArray = mesBuildingBoChuJobDirectory.getTeamId().split(",");
      List<ContractProject> contractProjectList = new ArrayList<>();

      for (int i = 0; i < projectIdArray.length; i++) {
         contractProjectList.add(this.contractProjectService.getById(projectIdArray[i]));
      }

      List<MesBuildingNestTeamConfigDTO> mesBuildingNestTeamConfigDTOList = new ArrayList<>();

      for (int i = 0; i < teamIdArray.length; i++) {
         mesBuildingNestTeamConfigDTOList.add(this.mesBuildingNestTeamConfigService.selectNeedNestTeamConfig(Long.valueOf(teamIdArray[i])).get(0));
      }

      String projectName = "";

      for (int i = 0; i < contractProjectList.size(); i++) {
         projectName = projectName + contractProjectList.get(i).getName();
         if (i != contractProjectList.size() - 1) {
            projectName = projectName + ",";
         }
      }

      String teamName = "";

      for (int i = 0; i < mesBuildingNestTeamConfigDTOList.size(); i++) {
         teamName = teamName + mesBuildingNestTeamConfigDTOList.get(i).getTeamName();
         if (i != mesBuildingNestTeamConfigDTOList.size() - 1) {
            teamName = teamName + ",";
         }
      }

      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(machineToolId);
      List<MachinePartNestingProductInfoDTO> jobInfoByJobId = this.mesBuildingTaskNeedMachinePartSchedulingService
         .getJobInfoByJobId(mesBuildingBoChuJobDirectory.getJobId());
      NestPdfDataDTO nestPdfDataDTO = new NestPdfDataDTO();
      nestPdfDataDTO.setProjectName(projectName);
      nestPdfDataDTO.setTeamName(teamName);
      nestPdfDataDTO.setJobName(mesBuildingBoChuJobDirectory.getJobName());
      nestPdfDataDTO.setDeviceName(mesBuildingMachinePartTeamDetail.getDeviceName());
      nestPdfDataDTO.setSchedulingDate(jobInfoByJobId.get(0).getSchedulingDate());
      nestPdfDataDTO.setSchedulingUser(jobInfoByJobId.get(0).getSchedulingUserName());
      nestPdfDataDTO.setThickness(dto.getResult_info().get(0).getThickness());
      nestPdfDataDTO.setMaterial(dto.getResult_info().get(0).getMaterial());
      nestPdfDataDTO.setSpecification(dto.getResult_info().get(0).getWidth() + "*" + dto.getResult_info().get(0).getHeight());
      nestPdfDataDTO.setUtilization(dto.getResult_info().get(0).getUtilization());
      nestPdfDataDTO.setCutLength(dto.getResult_info().get(0).getCurve_length());
      nestPdfDataDTO.setCutTime(this.getHourMinudeSecond(dto.getResult_info().get(0).getCurve_time()));
      String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, dto.getResult_info().get(0).getUuid());
      String nestFileNamePath = "nesting" + File.separator + jobId + File.separator;
      String nestFileName = resultId + ".png";
      String allPath = this.nestPath + nestFileNamePath + nestFileName;
      File outputFile = new File(allPath);
      if (!outputFile.exists()) {
         this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
      }

      nestPdfDataDTO.setImageUrl(allPath);
      List<PartInfoNestingDTO> partInfo = dto.getTotal_info().getPart_info();
      List<List<String>> data2List = new ArrayList<>();

      for (int i = 0; i < partInfo.size(); i++) {
         List<String> stringList2 = new ArrayList<>();
         stringList2.add(String.valueOf(i + 1));
         stringList2.add(partInfo.get(i).getName());
         String height = String.valueOf(partInfo.get(i).getHeight()).replaceAll("0+$", "");
         height = height.endsWith(".") ? height.substring(0, height.length() - 1) : height;
         String width = String.valueOf(partInfo.get(i).getWidth()).replaceAll("0+$", "");
         width = width.endsWith(".") ? width.substring(0, width.length() - 1) : width;
         stringList2.add(width + "*" + height);
         stringList2.add(String.valueOf(partInfo.get(i).getAmount()));
         stringList2.add(
            new BigDecimal(partInfo.get(i).getWeight_exclude_comp()).divide(BigDecimal.valueOf(1000L)).setScale(3, RoundingMode.HALF_UP).toString()
         );
         data2List.add(stringList2);
      }

      nestPdfDataDTO.setPartInfoList(data2List);
      return nestPdfDataDTO;
   }

   @Override
   public List<MachinePartNestingProductInfoDTO> getJobInfoByJobId(Integer jobId) {
      return this.baseMapper.getJobInfoByJobId(jobId);
   }

   @Override
   public List<WorkshopTeamDTO> getJobWorkShopInfo() {
      List<WorkshopTeamDTO> workshopDetailDOList = this.baseMapper.getWorkShopNestingList();
      return CollectionUtils.isNotEmpty(workshopDetailDOList) ? workshopDetailDOList : new ArrayList<>();
   }

   @Override
   public NestingQuantityDTO getJobMaterial(Integer jobId) {
      List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>().eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId)
         );
      Integer partQuantity = mesBuildingTaskNeedMachinePartSchedulingList.stream().mapToInt(MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity).sum();
      List<Long> masterTaskOrderIdList = mesBuildingTaskNeedMachinePartSchedulingList.stream()
         .map(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, Integer> productQuantityMap = mesBuildingTaskNeedMachinePartSchedulingList.stream()
         .collect(
            Collectors.toMap(MesBuildingTaskNeedMachinePartScheduling::getProductId, MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity, Integer::sum)
         );
      Integer nestingQuantity = 0;
      Integer cutQuantity = 0;
      MesBuildingBoChuJobDirectory jobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(mesBuildingNestingTeam != null, "该工单没有指定团队");
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultListAll = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().apply("FIND_IN_SET({0}, mixed_job_ids) > 0", jobId));
      List<String> distinctGuidList = mesBuildingBoChuNestingResultListAll.stream()
         .map(MesBuildingBoChuNestingResult::getGuid)
         .distinct()
         .collect(Collectors.toList());
      List<MachinePartNestingGuidDetailDTO> machinePartNestingGuidDetailDTOList = this.getBoChuNestingMachinePartDetailByJobIdListAndGuidList(
         ListUtil.toList(jobId), mesBuildingNestingTeam.getTeamCode(), distinctGuidList
      );
      Map<String, List<MachinePartNestingGuidDetailDTO>> machinePartNestingGuidDetailDTOGroup = machinePartNestingGuidDetailDTOList.stream()
         .collect(Collectors.groupingBy(MachinePartNestingGuidDetailDTO::getGuid));

      for (MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult : mesBuildingBoChuNestingResultListAll) {
         String guid = mesBuildingBoChuNestingResult.getGuid();
         List<MachinePartNestingGuidDetailDTO> cMachinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOGroup.get(guid);
         if (CollUtil.isNotEmpty(cMachinePartNestingGuidDetailDTOList)) {
            Iterator var18 = cMachinePartNestingGuidDetailDTOList.iterator();
            if (var18.hasNext()) {
               MachinePartNestingGuidDetailDTO machinePartNestingGuidDetailDTO = (MachinePartNestingGuidDetailDTO)var18.next();
               List<NestPartDTO> parts = machinePartNestingGuidDetailDTO.getParts();
               Map<String, Integer> nestingQuantityMap = new HashMap<>();
               Map<String, Integer> cutQuantityMap = new HashMap<>();

               for (NestPartDTO part : parts) {
                  if (CollectionUtil.isNotEmpty(part.getProps())) {
                     Map<String, String> keyValueProps = part.getProps().stream().collect(Collectors.toMap(PropsDTO::getProp_name, PropsDTO::getProp_value));
                     String productId = keyValueProps.get("productId");
                     String taskOrderId = keyValueProps.get("taskOrderId");
                     Integer amount = part.getAmount();
                     Integer cNeedQuantity = productQuantityMap.get(Long.valueOf(productId));
                     if (masterTaskOrderIdList.contains(Long.valueOf(taskOrderId))) {
                        if (nestingQuantityMap.containsKey(productId)) {
                           Integer recordedQuantity = nestingQuantityMap.get(productId);
                           if (recordedQuantity < cNeedQuantity) {
                              int newRecordedQuantity = recordedQuantity + amount;
                              if (newRecordedQuantity >= cNeedQuantity) {
                                 nestingQuantity = nestingQuantity + (amount - (newRecordedQuantity - cNeedQuantity));
                                 nestingQuantityMap.put(productId, cNeedQuantity);
                              } else {
                                 nestingQuantity = nestingQuantity + amount;
                                 nestingQuantityMap.put(productId, newRecordedQuantity);
                              }
                           }
                        } else {
                           nestingQuantity = nestingQuantity + amount;
                           nestingQuantityMap.put(productId, amount);
                        }
                     }

                     if (mesBuildingBoChuNestingResult.getCutStatus() == CutStatusEnum.CUT_COMPLETED.getCode()
                        && masterTaskOrderIdList.contains(Long.valueOf(taskOrderId))) {
                        if (cutQuantityMap.containsKey(productId)) {
                           Integer recordedQuantity = cutQuantityMap.get(productId);
                           if (recordedQuantity < cNeedQuantity) {
                              int newRecordedQuantity = recordedQuantity + amount;
                              if (newRecordedQuantity >= cNeedQuantity) {
                                 cutQuantity = cutQuantity + (amount - (newRecordedQuantity - cNeedQuantity));
                                 cutQuantityMap.put(productId, cNeedQuantity);
                              } else {
                                 cutQuantity = cutQuantity + amount;
                                 cutQuantityMap.put(productId, newRecordedQuantity);
                              }
                           }
                        } else {
                           cutQuantity = cutQuantity + amount;
                           cutQuantityMap.put(productId, amount);
                        }
                     }
                  }
               }
            }
         }
      }

      NestingQuantityDTO nestingQuantityDTO = new NestingQuantityDTO();
      nestingQuantityDTO.setPartQuantity(partQuantity);
      nestingQuantityDTO.setNestingQuantity(nestingQuantity);
      nestingQuantityDTO.setCutQuantity(cutQuantity);
      return nestingQuantityDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String deleteMachinePartNestingJob(Integer jobId) {
      Preconditions.checkArgument(jobId != null, "作业ID不能为空");
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
         .list(
            (Wrapper<MesBuildingBoChuNestingResult>)(new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getJobId, jobId))
               .eq(MesBuildingBoChuNestingResult::getCutSendStatus, CutSendEnum.DISPATCHED.getCode())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingBoChuNestingResultList), "该排产单下已存在下发的作业单，无法删除!");
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
      Long teamCodeId = mesBuildingBoChuJobDirectory.getTeamCodeId();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      List<MesBuildingBoChuNestingResultDTO> mesBuildingBoChuNestingResultDTOList = this.getNestingJobPlate(jobId, systemTeamCode);
      if (CollectionUtils.isNotEmpty(mesBuildingBoChuNestingResultDTOList)) {
         JSONArray jsonArray = new JSONArray();

         for (MesBuildingBoChuNestingResultDTO mesBuildingBoChuNestingResultDTO : mesBuildingBoChuNestingResultDTOList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("guid", mesBuildingBoChuNestingResultDTO.getGuid());
            jsonObject.put("is_delete", 1);
            jsonArray.add(jsonObject);
         }

         this.deleteNestingJobPlate(jsonArray, systemTeamCode);
      }

      List<MachinePartNestingJobDetailDTO> machinePartNestingJobDetailDTOList = this.getNestingJobPart(jobId, systemTeamCode);
      if (CollectionUtils.isNotEmpty(machinePartNestingJobDetailDTOList)) {
         JSONArray jsonArray = new JSONArray();

         for (MachinePartNestingJobDetailDTO machinePartNestingJobDetailDTO : machinePartNestingJobDetailDTOList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("guid", machinePartNestingJobDetailDTO.getGuid());
            jsonObject.put("is_delete", 1);
            jsonArray.add(jsonObject);
         }

         this.deleteNestingJobPart(jsonArray, systemTeamCode);
      }

      this.deleteNestingJob(jobId, systemTeamCode);
      mesBuildingBoChuJobDirectoryList.forEach(e -> {
         Integer parentId = e.getParentId();
         this.deleteNestingJob(parentId, systemTeamCode);
      });
      List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>().eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId)
         );
      mesBuildingTaskNeedMachinePartSchedulingList.forEach(mesBuildingTaskNeedMachinePartScheduling -> {
         mesBuildingTaskNeedMachinePartScheduling.setSchedulingDate(null);
         mesBuildingTaskNeedMachinePartScheduling.setSendNestingStatus(false);
         mesBuildingTaskNeedMachinePartScheduling.setNestingJobId(null);
         mesBuildingTaskNeedMachinePartScheduling.setSchedulingQuantity(0);
         mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(null);
         mesBuildingTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
         mesBuildingTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareOperationTime(null);
         this.baseMapper.updateById(mesBuildingTaskNeedMachinePartScheduling);
      });
      return "删除成功";
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String deleteMachinePartNestingJobList(MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam) {
      Integer jobId = mesBuildingMachinePartNestingExportParam.getJobId();
      Preconditions.checkArgument(jobId != null, "作业ID不能为空");
      List<String> resultList = mesBuildingMachinePartNestingExportParam.getResultList();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(resultList), "删除的记录不能为空");
      resultList = resultList.stream().distinct().collect(Collectors.toList());
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
      Long teamCodeId = mesBuildingBoChuJobDirectory.getTeamCodeId();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();

      for (String guid : resultList) {
         this.mesBuildingBoChuNestingResultService
            .remove(
               (Wrapper<MesBuildingBoChuNestingResult>)(new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getGuid, guid))
                  .eq(MesBuildingBoChuNestingResult::getJobId, jobId)
            );
         this.nestBiz.deleteNesting(guid);
      }

      List<MachinePartNestingGuidDetailDTO> machinePartNestingGuidDetailDTOList = this.getBoChuNestingMachinePartDetailByJobIdListAndGuidList(
         ListUtil.toList(jobId), mesBuildingNestingTeam.getTeamCode(), resultList
      );
      if (CollUtil.isNotEmpty(machinePartNestingGuidDetailDTOList)) {
         Map<String, List<MachinePartNestingGuidDetailDTO>> machinePartNestingGuidDetailDTOGroup = machinePartNestingGuidDetailDTOList.stream()
            .collect(Collectors.groupingBy(MachinePartNestingGuidDetailDTO::getGuid));
         List<Long> productIdList = new ArrayList<>();

         for (String guid : resultList) {
            List<MachinePartNestingGuidDetailDTO> cMachinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOGroup.get(guid);
            if (CollUtil.isNotEmpty(cMachinePartNestingGuidDetailDTOList)) {
               Iterator var15 = cMachinePartNestingGuidDetailDTOList.iterator();
               if (var15.hasNext()) {
                  MachinePartNestingGuidDetailDTO machinePartNestingGuidDetailDTO = (MachinePartNestingGuidDetailDTO)var15.next();

                  for (NestPartDTO part : machinePartNestingGuidDetailDTO.getParts()) {
                     if (CollectionUtil.isNotEmpty(part.getProps())) {
                        Map<String, String> keyValueProps = part.getProps().stream().collect(Collectors.toMap(PropsDTO::getProp_name, PropsDTO::getProp_value));
                        String productId = keyValueProps.get("productId");
                        if (StrUtil.isNotBlank(productId)) {
                           productIdList.add(Long.parseLong(productId));
                        }
                     }
                  }
               }
            }
         }

         if (CollUtil.isNotEmpty(productIdList)) {
            List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.baseMapper
               .selectList(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                        .eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId))
                     .in(MesBuildingTaskNeedMachinePartScheduling::getProductId, productIdList)
               );
            mesBuildingTaskNeedMachinePartSchedulingList.forEach(mesBuildingTaskNeedMachinePartScheduling -> {
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingDate(null);
               mesBuildingTaskNeedMachinePartScheduling.setSendNestingStatus(false);
               mesBuildingTaskNeedMachinePartScheduling.setNestingJobId(null);
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingQuantity(0);
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(null);
               mesBuildingTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
               mesBuildingTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareOperationTime(null);
               this.baseMapper.updateById(mesBuildingTaskNeedMachinePartScheduling);
            });
         }
      }

      if (CollectionUtils.isNotEmpty(resultList)) {
         JSONArray jsonArray = new JSONArray();

         for (String guid : resultList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("guid", guid);
            jsonObject.put("is_delete", 1);
            jsonArray.add(jsonObject);
         }

         this.deleteNestingJobPlate(jsonArray, systemTeamCode);
         this.deleteNestingJobPart(jsonArray, systemTeamCode);
      }

      return "删除成功";
   }

   @Override
   public synchronized String updateMachinePartNestingJobStatus(String wsJson) {
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      log.info("柏楚返回的wsJson" + wsJson);
      JSONObject jsonObject = JSONObject.parseObject(wsJson);
      String payload = jsonObject.get("payload").toString();
      byte[] decode = Base64.getDecoder().decode(payload);
      String result = new String(decode);
      JSONObject resultObject = JSONObject.parseObject(result);
      String objectId = resultObject.get("object_id").toString();
      String jobId = resultObject.get("job_id").toString();
      String userId = resultObject.get("user_id").toString();
      JSONArray jsonGuidArray = JSONArray.parseArray(objectId);
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, Integer.parseInt(jobId)));
      if (CollectionUtils.isEmpty(mesBuildingBoChuJobDirectoryList)) {
         log.info("本地服务器该作业不存在，jobid:{}" + jobId);
      }

      this.changeBoChuJobDirectoryStatusByJobId(Integer.valueOf(jobId));
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
      String jobName = mesBuildingBoChuJobDirectory.getJobName();
      List<Long> jobIds = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobName, jobName))
         .stream()
         .map(MesBuildingBoChuJobDirectory::getId)
         .filter(id -> id != null)
         .collect(Collectors.toList());
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultOrderNumberList = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().in(MesBuildingBoChuNestingResult::getJobId, jobIds));
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(mesBuildingBoChuJobDirectory.getTeamCodeId());
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      List<MesBuildingBoChuNestingJobByGuidDTO> mesBuildingBoChuNestingJobByGuidDTOList = this.getJobByGuid(jsonGuidArray, systemTeamCode);
      List<MesBuildingBoChuNestingResultDTO> mesBuildingBoChuNestingResultDTOList = new ArrayList<>();

      for (MesBuildingBoChuNestingJobByGuidDTO mesBuildingBoChuNestingJobByGuidDTO : mesBuildingBoChuNestingJobByGuidDTOList) {
         Integer jobId1 = mesBuildingBoChuNestingJobByGuidDTO.getJob_list().get(0).getJob_id();
         mesBuildingBoChuNestingResultDTOList.addAll(this.getNestingJobPlate(jobId1, systemTeamCode));
      }

      Map<String, MesBuildingBoChuNestingJobByGuidDTO> boChuNestingJobByGuidDTOMap = mesBuildingBoChuNestingJobByGuidDTOList.stream()
         .collect(Collectors.toMap(MesBuildingBoChuNestingJobByGuidDTO::getUuid, Function.identity(), (existing, replacement) -> existing));
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = new ArrayList<>();
      log.info("返回的排版guid:{}", jsonGuidArray);
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      List<String> thisPushGuidList = JSONUtil.toList(jsonGuidArray.toJSONString(), String.class);
      List<MesBuildingBoChuNestingResult> boChuNestingResultOldList = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().in(MesBuildingBoChuNestingResult::getGuid, thisPushGuidList));
      List<String> oldChildGuidList = boChuNestingResultOldList.stream().map(MesBuildingBoChuNestingResult::getChildGuid).collect(Collectors.toList());
      List<MesBuildingBoChuNestingResultDTO> finalMesBuildingBoChuNestingResultDTOList = mesBuildingBoChuNestingResultDTOList;
      AtomicInteger count = new AtomicInteger();
      jsonGuidArray.forEach(
         object -> {
            String guid = object.toString();
            MesBuildingBoChuNestingResultDTO mesBuildingBoChuNestingResultDTO1 = finalMesBuildingBoChuNestingResultDTOList.stream()
               .filter(mesBuildingBoChuNestingResultDTO2 -> mesBuildingBoChuNestingResultDTO2.getGuid().equals(guid))
               .findFirst()
               .orElse(null);
            if (mesBuildingBoChuNestingResultDTO1 != null) {
               MesBuildingBoChuNestingJobByGuidDTO boChuNestingJobByGuidDTO = boChuNestingJobByGuidDTOMap.get(guid);
               int amount = mesBuildingBoChuNestingResultDTO1.getAmount();

               for (int i = 1; i < amount + 1; i++) {
                  MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = new MesBuildingBoChuNestingResult();
                  BeanUtils.copyProperties(mesBuildingBoChuNestingResultDTO1, mesBuildingBoChuNestingResult);
                  mesBuildingBoChuNestingResult.setThickness(new BigDecimal(mesBuildingBoChuNestingResultDTO1.getThickness()));
                  mesBuildingBoChuNestingResult.setAmount(BigDecimal.ONE);
                  mesBuildingBoChuNestingResult.setUtilization(
                     new BigDecimal(mesBuildingBoChuNestingResultDTO1.getUtilization()).setScale(2, RoundingMode.HALF_UP)
                  );
                  mesBuildingBoChuNestingResult.setPartAmount(new BigDecimal(mesBuildingBoChuNestingResultDTO1.getPartAmount()).divide(new BigDecimal(amount)));
                  mesBuildingBoChuNestingResult.setPlateHeight(new BigDecimal(mesBuildingBoChuNestingResultDTO1.getPlateHeight()));
                  mesBuildingBoChuNestingResult.setPlateWidth(new BigDecimal(mesBuildingBoChuNestingResultDTO1.getPlateWidth()));
                  String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, mesBuildingBoChuNestingResultDTO1.getGuid());
                  mesBuildingBoChuNestingResult.setThumbnailUrl(imagePath);
                  mesBuildingBoChuNestingResult.setAmount(new BigDecimal(1));
                  mesBuildingBoChuNestingResult.setCutStatus(0);
                  mesBuildingBoChuNestingResult.setCutSendStatus(0);
                  if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultOrderNumberList)) {
                     int orderNumberCun = count.get() + mesBuildingBoChuNestingResultOrderNumberList.size();
                     mesBuildingBoChuNestingResult.setChildOrderNumber(mesBuildingBoChuJobDirectory.getJobName() + "-" + orderNumberCun);
                     count.incrementAndGet();
                  } else {
                     int orderNumberCun = count.get() + i;
                     mesBuildingBoChuNestingResult.setChildOrderNumber(mesBuildingBoChuJobDirectory.getJobName() + "-" + orderNumberCun);
                     count.incrementAndGet();
                  }

                  mesBuildingBoChuNestingResult.setJobId(Integer.valueOf(jobId));
                  mesBuildingBoChuNestingResult.setRealJobId(mesBuildingBoChuNestingResultDTO1.getJobId());
                  mesBuildingBoChuNestingResult.setChildGuid(mesBuildingBoChuNestingResultDTO1.getGuid() + "-" + i);
                  mesBuildingBoChuNestingResult.setNestUserId(userId);
                  mesBuildingBoChuNestingResult.setMixedJobIds(jobId);
                  if (BeanUtil.isNotEmpty(boChuNestingJobByGuidDTO) && CollUtil.isNotEmpty(boChuNestingJobByGuidDTO.getJob_list())) {
                     List<Integer> mixedJobIdList = boChuNestingJobByGuidDTO.getJob_list()
                        .stream()
                        .map(MesBuildingBoChuNestingResultByGuidJob::getJob_id)
                        .collect(Collectors.toList());
                     mesBuildingBoChuNestingResult.setMixedJobIds(StrUtil.join(",", mixedJobIdList));
                  }

                  mesBuildingBoChuNestingResult.setInventoryGainType(inventoryTypeConfig.getInventoryGainType());
                  if (!oldChildGuidList.contains(mesBuildingBoChuNestingResult.getChildGuid())) {
                     mesBuildingBoChuNestingResultList.add(mesBuildingBoChuNestingResult);
                  }
               }
            }
         }
      );
      List<MesBuildingBoChuNestingResult> distinctList = mesBuildingBoChuNestingResultList.stream()
         .collect(Collectors.toMap(MesBuildingBoChuNestingResult::getChildGuid, dto -> (MesBuildingBoChuNestingResult)dto, (existing, replacement) -> existing))
         .values()
         .stream()
         .collect(Collectors.toList());
      log.info("mesBuildingBoChuNestingResultList:" + mesBuildingBoChuNestingResultList);

      for (MesBuildingBoChuNestingResult result2 : distinctList) {
         try {
            this.mesBuildingBoChuNestingResultService.save(result2);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      CompletableFuture.runAsync(() -> {
         try {
            this.getAllNestingMessage(Integer.valueOf(jobId), jsonGuidArray, systemTeamCode);
         } catch (Exception e) {
            log.error("异步任务执行失败: " + e.getMessage());
         }
      });
      stopWatch.stop();
      log.info("套料任务消息已接收成功用时: " + stopWatch.getTotalTimeMillis());
      return "套料任务消息已接收成功";
   }

   @Override
   public synchronized String updateMachinePartNestingJobStatusV2(String wsJson) {
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      log.info("柏楚返回的wsJson" + wsJson);
      String payload = cn.hutool.core.codec.Base64.decodeStr(JSONUtil.parseObj(wsJson).getStr("payload"));
      cn.hutool.json.JSONObject payloadJ = JSONUtil.parseObj(payload);
      log.info("柏楚返回的payload" + payloadJ.toStringPretty());
      List<String> guidList = payloadJ.getJSONArray("object_id").toList(String.class);
      String teamCode = payloadJ.getStr("team_code");
      Integer selectedJobId = payloadJ.getInt("job_id");
      String nestUserId = payloadJ.getStr("user_id");
      MesBuildingBoChuJobDirectory selectedJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, selectedJobId)
         .one();
      if (BeanUtil.isEmpty(selectedJobDirectory)) {
         log.error("本地未找到作业: " + selectedJobId);
         return "本地未找到作业: " + selectedJobId;
      } else {
         List<MesBuildingBoChuSteelPlateByGuidDTO> boChuSteelPlateByGuidDTOList = this.boChuGetJobByGuidList(teamCode, guidList);
         if (CollUtil.isEmpty(boChuSteelPlateByGuidDTOList)) {
            log.error("柏楚未找到钢板: " + guidList);
            return "柏楚未找到钢板: " + guidList;
         } else {
            List<Integer> jobIdList = boChuSteelPlateByGuidDTOList.stream()
               .map(bcspbg -> bcspbg.getJobList().stream().map(JobSimpleInfo::getJobId))
               .flatMap(Stream::distinct)
               .collect(Collectors.toList());
            List<MesBuildingBoChuJobDirectory> localJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
               .lambdaQuery()
               .in(MesBuildingBoChuJobDirectory::getJobId, jobIdList)
               .list();
            if (CollUtil.isEmpty(localJobDirectoryList)) {
               log.error("本地未找到作业: " + jobIdList);
               return "本地未找到作业: " + jobIdList;
            } else {
               List<Integer> localJobDirectoryJobIdList = localJobDirectoryList.stream()
                  .map(MesBuildingBoChuJobDirectory::getJobId)
                  .distinct()
                  .collect(Collectors.toList());
               Map<String, MesBuildingBoChuSteelPlateByGuidDTO> boChuSteelPlateByGuidDTOMap = boChuSteelPlateByGuidDTOList.stream()
                  .collect(Collectors.toMap(MesBuildingBoChuSteelPlateByGuidDTO::getUuid, Function.identity(), (existing, replacement) -> existing));
               MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
               localJobDirectoryList.forEach(
                  ljd -> {
                     Integer nowJobId = ljd.getJobId();
                     this.changeBoChuJobDirectoryStatusByJobId(nowJobId);
                     List<MesBuildingBoChuNestingResult> boChuNestingResultListLocal = this.mesBuildingBoChuNestingResultService.list();
                     List<MesBuildingBoChuSteelPlateByJobIdDTO> boChuSteelPlateByJobIdDTOList = this.boChuJobNspfListV2(teamCode, ListUtil.toList(nowJobId));
                     if (CollUtil.isEmpty(boChuSteelPlateByJobIdDTOList)) {
                        log.error("jobId: " + nowJobId + ", 未找到钢板");
                     } else {
                        Map<String, MesBuildingBoChuSteelPlateByJobIdDTO> boChuSteelPlateByJobIdDTOMap = boChuSteelPlateByJobIdDTOList.stream()
                           .collect(Collectors.toMap(MesBuildingBoChuSteelPlateByJobIdDTO::getGuid, Function.identity(), (existing, replacement) -> existing));
                        List<String> localChildGuidList = boChuNestingResultListLocal.stream()
                           .filter(lcg -> guidList.contains(lcg.getGuid()))
                           .map(MesBuildingBoChuNestingResult::getChildGuid)
                           .collect(Collectors.toList());
                        List<MesBuildingBoChuNestingResult> addBoChuNestingResultList = new ArrayList<>();
                        guidList.forEach(
                           guid -> {
                              MesBuildingBoChuSteelPlateByJobIdDTO nowBoChuSteelPlateByJobIdDTO = boChuSteelPlateByJobIdDTOMap.get(guid);
                              if (BeanUtil.isNotEmpty(nowBoChuSteelPlateByJobIdDTO)) {
                                 MesBuildingBoChuSteelPlateByGuidDTO nowBoChuSteelPlateByGuidDTO = boChuSteelPlateByGuidDTOMap.get(guid);
                                 Integer amount = nowBoChuSteelPlateByJobIdDTO.getAmount();

                                 for (int i = 1; i <= amount; i++) {
                                    String childGuid = nowBoChuSteelPlateByJobIdDTO.getGuid() + "-" + i;
                                    if (!localChildGuidList.contains(childGuid)) {
                                       MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = new MesBuildingBoChuNestingResult();
                                       BeanUtils.copyProperties(nowBoChuSteelPlateByJobIdDTO, mesBuildingBoChuNestingResult);
                                       mesBuildingBoChuNestingResult.setThickness(nowBoChuSteelPlateByJobIdDTO.getThickness());
                                       mesBuildingBoChuNestingResult.setAmount(BigDecimal.ONE);
                                       mesBuildingBoChuNestingResult.setUtilization(
                                          nowBoChuSteelPlateByJobIdDTO.getUtilization().setScale(2, RoundingMode.HALF_UP)
                                       );
                                       mesBuildingBoChuNestingResult.setPartAmount(
                                          new BigDecimal(nowBoChuSteelPlateByJobIdDTO.getPartAmount()).divide(new BigDecimal(amount))
                                       );
                                       mesBuildingBoChuNestingResult.setPlateHeight(nowBoChuSteelPlateByJobIdDTO.getPlateHeight());
                                       mesBuildingBoChuNestingResult.setPlateWidth(nowBoChuSteelPlateByJobIdDTO.getPlateWidth());
                                       String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, nowBoChuSteelPlateByJobIdDTO.getGuid());
                                       mesBuildingBoChuNestingResult.setThumbnailUrl(imagePath);
                                       mesBuildingBoChuNestingResult.setAmount(new BigDecimal(1));
                                       mesBuildingBoChuNestingResult.setCutStatus(0);
                                       mesBuildingBoChuNestingResult.setCutSendStatus(0);
                                       Integer selectedJobIdCount = this.mesBuildingBoChuNestingResultService
                                          .lambdaQuery()
                                          .eq(MesBuildingBoChuNestingResult::getJobId, selectedJobId)
                                          .count();
                                       mesBuildingBoChuNestingResult.setChildOrderNumber(selectedJobDirectory.getJobName() + "-" + (selectedJobIdCount + 1));
                                       mesBuildingBoChuNestingResult.setChildGuid(childGuid);
                                       mesBuildingBoChuNestingResult.setNestUserId(nestUserId);
                                       mesBuildingBoChuNestingResult.setJobId(selectedJobId);
                                       mesBuildingBoChuNestingResult.setRealJobId(selectedJobId);
                                       mesBuildingBoChuNestingResult.setMixedJobIds(selectedJobId.toString());
                                       mesBuildingBoChuNestingResult.setInventoryGainType(inventoryTypeConfig.getInventoryGainType());
                                       if (BeanUtil.isNotEmpty(nowBoChuSteelPlateByGuidDTO) && CollUtil.isNotEmpty(nowBoChuSteelPlateByGuidDTO.getJobList())) {
                                          List<Integer> mixedJobIdList = nowBoChuSteelPlateByGuidDTO.getJobList()
                                             .stream()
                                             .map(JobSimpleInfo::getJobId)
                                             .collect(Collectors.toList());
                                          if (!mixedJobIdList.contains(selectedJobId)) {
                                             Integer nJobId = CollUtil.intersection(mixedJobIdList, localJobDirectoryJobIdList)
                                                .stream()
                                                .findFirst()
                                                .orElse(null);
                                             if (nJobId == null) {
                                                log.error("未在本地找到对应jobId");
                                                return;
                                             }

                                             MesBuildingBoChuJobDirectory nJobDirectory = this.mesBuildingBoChuJobDirectoryService
                                                .lambdaQuery()
                                                .eq(MesBuildingBoChuJobDirectory::getJobId, nJobId)
                                                .one();
                                             Integer nJobIdCount = this.mesBuildingBoChuNestingResultService
                                                .lambdaQuery()
                                                .eq(MesBuildingBoChuNestingResult::getJobId, nJobId)
                                                .count();
                                             mesBuildingBoChuNestingResult.setChildOrderNumber(nJobDirectory.getJobName() + "-" + (nJobIdCount + 1));
                                             mesBuildingBoChuNestingResult.setJobId(nJobId);
                                             mesBuildingBoChuNestingResult.setRealJobId(nJobId);
                                          }

                                          mesBuildingBoChuNestingResult.setMixedJobIds(StrUtil.join(",", mixedJobIdList));
                                          addBoChuNestingResultList.add(mesBuildingBoChuNestingResult);
                                       }
                                    }
                                 }
                              }
                           }
                        );
                        if (CollUtil.isNotEmpty(addBoChuNestingResultList)) {
                           addBoChuNestingResultList.forEach(boChuNestingResult -> {
                              try {
                                 this.mesBuildingBoChuNestingResultService.save(boChuNestingResult);
                              } catch (Exception e) {
                                 log.error("保存钢板(" + boChuNestingResult.getGuid() + ")失败: " + e.getMessage());
                              }
                           });
                           CompletableFuture.runAsync(() -> {
                              try {
                                 this.getAllNestingMessage(nowJobId, JSONArray.parseArray(JSON.toJSONString(guidList)), teamCode);
                              } catch (Exception e) {
                                 log.error("异步任务执行失败: " + e.getMessage());
                              }
                           });
                        }
                     }
                  }
               );
               stopWatch.stop();
               log.info("套料任务消息已接收成功用时: " + stopWatch.getTotalTimeMillis());
               return "套料任务消息已接收成功";
            }
         }
      }
   }

   public void getAllNestingMessage(Integer jobId, JSONArray guidJsonArray, String teamCode) {
      if (CollectionUtils.isNotEmpty(guidJsonArray)) {
         guidJsonArray.forEach(e -> {
            String guid = e.toString();
            this.getNestingReportDataSaveMessage(jobId, guid, teamCode);
            this.getNestPartDetailSaveMessage(jobId, guid, teamCode);
            List<NestCutFileTypeDTO> nestCutFileTypeDTOList = this.getNestCutFileType(teamCode);
            nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
               String type = nestCutFileTypeDTO.getTitle();
               this.getNestCutFileNC(jobId, guid, teamCode, type, new HashMap<>());
            });
            this.getNestCutFileLXDS(jobId, guid, teamCode, new HashMap<>());
         });
      }
   }

   private List<MesBuildingBoChuSteelPlateByGuidDTO> boChuGetJobByGuidList(String teamCode, List<String> guidList) {
      String url = "https://cloudnest.fscut.com/api/result/get_job";
      HttpHeaders headers = BoChuNesting.headers(teamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      cn.hutool.json.JSONObject bodyJ = JSONUtil.createObj().set("guid_list", guidList);
      log.info("请求参数: " + bodyJ);

      try (HttpResponse execute = HttpRequest.post(url).header(headers).body(bodyJ.toString()).execute()) {
         if (execute.isOk()) {
            cn.hutool.json.JSONObject resultJ = JSONUtil.parseObj(execute.body());
            if (Objects.equals(resultJ.getInt("status"), 0)) {
               return resultJ.getJSONArray("data").toList(MesBuildingBoChuSteelPlateByGuidDTO.class);
            }
         }
      } catch (Exception e) {
         log.error("调用柏楚API: /api/result/get_job 失败, 参数: " + bodyJ);
      }

      log.error("调用柏楚API: /api/result/get_job 失败, 参数: " + bodyJ);
      return null;
   }

   private List<MesBuildingBoChuSteelPlateByJobIdDTO> boChuJobNspfListV2(String teamCode, List<Integer> jobIdList) {
      String url = "https://cloudnest.fscut.com/api/job/nspf_list/v2";
      HttpHeaders headers = BoChuNesting.headers(teamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      cn.hutool.json.JSONObject bodyJ = JSONUtil.createObj().set("job_id", jobIdList);
      log.info("请求参数: " + bodyJ);

      try (HttpResponse execute = HttpRequest.post(url).header(headers).body(bodyJ.toString()).execute()) {
         if (execute.isOk()) {
            cn.hutool.json.JSONObject resultJ = JSONUtil.parseObj(execute.body());
            if (Objects.equals(resultJ.getInt("status"), 0)) {
               log.info(resultJ.getJSONArray("data").toString());
               return resultJ.getJSONArray("data").toList(MesBuildingBoChuSteelPlateByJobIdDTO.class);
            }
         }
      } catch (Exception e) {
         log.error("调用柏楚API: /api/job/nspf_list/v2 失败, 参数: " + bodyJ);
      }

      log.error("调用柏楚API: /api/job/nspf_list/v2 失败, 参数: " + bodyJ);
      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Long saveMachinePartDirectScheduling(MesBuildingMachinePartSchedulingDTOParam mesBuildingMachinePartSchedulingDTOParam) {
      Long aLong = null;
      List<MesBuildingMachinePartSchedulingLinkDTOParam> mesBuildingMachinePartSchedulingLinkDTOParamList = mesBuildingMachinePartSchedulingDTOParam.getLinkList();
      List<MesBuildingMachinePartSchedulingLinkDTOParam> mesBuildingMachinePartSchedulingLinkDTOParamNewList = new ArrayList<>();
      mesBuildingMachinePartSchedulingLinkDTOParamList.forEach(
         e -> {
            String orderId = e.getOrderId();
            Long productIdx = e.getProductId();
            List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
               .list(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                           .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, Long.valueOf(orderId)))
                        .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productIdx))
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, Boolean.FALSE)
               );
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingTaskNeedMachinePartSchedulingList), "该零件已经排产请勿重复下发");
            mesBuildingTaskNeedMachinePartSchedulingList.forEach(mesBuildingTaskNeedMachinePartScheduling -> {
               MesBuildingMachinePartSchedulingLinkDTOParam mesBuildingMachinePartSchedulingLinkDTOParamx = new MesBuildingMachinePartSchedulingLinkDTOParam();
               mesBuildingMachinePartSchedulingLinkDTOParamx.setId(mesBuildingTaskNeedMachinePartScheduling.getId());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setOrderId(mesBuildingTaskNeedMachinePartScheduling.getTaskOrderId().toString());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setProductId(mesBuildingTaskNeedMachinePartScheduling.getProductId());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setQuantity(mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setProjectId(mesBuildingTaskNeedMachinePartScheduling.getProjectId());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setNeedSchedulingMonth(mesBuildingMachinePartSchedulingDTOParam.getAskCompleteTime());
               mesBuildingMachinePartSchedulingLinkDTOParamx.setWastageRate(e.getWastageRate());
               mesBuildingMachinePartSchedulingLinkDTOParamNewList.add(mesBuildingMachinePartSchedulingLinkDTOParamx);
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(UserUtil.getCurrentUserId());
               mesBuildingTaskNeedMachinePartScheduling.setNestingJobId(null);
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingQuantity(mesBuildingTaskNeedMachinePartScheduling.getNeedQuantity());
               mesBuildingTaskNeedMachinePartScheduling.setSendNestingStatus(true);
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingDate(LocalDateTime.now());
               mesBuildingTaskNeedMachinePartScheduling.setSchedulingUserId(UserUtil.getCurrentUserId());
               mesBuildingTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
               this.taskNeedMachinePartSchedulingBiz.updateById(mesBuildingTaskNeedMachinePartScheduling);
            });
         }
      );
      mesBuildingMachinePartSchedulingDTOParam.setLinkList(mesBuildingMachinePartSchedulingLinkDTOParamNewList);
      mesBuildingMachinePartSchedulingDTOParam.setSaveType(1);
      if (mesBuildingMachinePartSchedulingDTOParam.getBoolProcess()) {
         Long productionLineId = mesBuildingMachinePartSchedulingDTOParam.getProductionLineId();
         Preconditions.checkArgument(productionLineId != null, "产线id不能为空");
         Long cutConfigId = mesBuildingMachinePartSchedulingDTOParam.getCutConfigId();
         Preconditions.checkArgument(cutConfigId != null, "切割配置id不能为空");
         MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
         Long teamId = mesBuildingMachinePartTeamDetail.getGroupsId();
         if (mesBuildingMachinePartSchedulingDTOParam.getProductClassificationEnum().equals(8)) {
            List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
               .list(
                  (Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType())
               );
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在，请到钻孔工艺配置中配置该切割配置");
            MesBuildingCutConfig mesBuildingCutConfig = mesBuildingCutConfigList.get(0);
            Preconditions.checkArgument(mesBuildingCutConfig != null, "切割配置不存在，请到钻孔工艺配置中配置该切割配置");
            MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingCutConfig.getName());
            String think = mesBuildingMachinePartSchedulingDTOParam.getThick();
            BigDecimal minThickness = new BigDecimal(mesBuildingCutConfig.getMinThickness());
            BigDecimal maxThickness = new BigDecimal(mesBuildingCutConfig.getMaxThickness());
            BigDecimal partThickness = new BigDecimal(mesBuildingMachinePartSchedulingDTOParam.getThick());
            Preconditions.checkArgument(
               partThickness.compareTo(minThickness) >= 0 && partThickness.compareTo(maxThickness) <= 0,
               "操作失败,厚度" + think + "不在" + minThickness + "-" + maxThickness + "的厚度范围中"
            );
            mesBuildingMachinePartSchedulingDTOParam.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
         } else {
            mesBuildingMachinePartSchedulingDTOParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
         }

         MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService
            .getById(mesBuildingMachinePartTeamDetail.getProductionLineId());
         mesBuildingMachinePartSchedulingDTOParam.setGroupsId(teamId);
         aLong = this.machinePartSchedulingBiz.saveMachinePartNestCutNew(mesBuildingMachinePartSchedulingDTOParam);
         MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService
            .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getSchedulingId, aLong))
            .get(0);
         List<BatchSchedulingOutboundDetailDTOParam> batchOutboundDetailDTOParamList = mesBuildingMachinePartSchedulingDTOParam.getBatchOutboundDTOParam()
            .getList();
         mesBuildingMachinePartSchedulingDTOParam.getBatchOutboundDTOParam().setRecipientId(UserUtil.getCurrentUser().getId());
         if (CollectionUtils.isNotEmpty(batchOutboundDetailDTOParamList)) {
            Long finalALong = aLong;
            batchOutboundDetailDTOParamList.forEach(e -> {
               e.setTaskOrderId(mesBuildingTaskOrder.getId());
               e.setSchedulingId(finalALong);
               e.setWorkshopId(mesBuildingProductionLine.getWorkshopId());
               e.setTaskOrderNumber(mesBuildingTaskOrder.getOrderNumber());
            });
            this.outboundService.BatchNestingDockingOutbound(mesBuildingMachinePartSchedulingDTOParam.getBatchOutboundDTOParam());
         }

         if (null != aLong) {
            List var35 = this.nestCutPlateBiz
               .list((Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>().eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, aLong));
         }
      }

      List<MesBuildingMachinePartSchedulingLinkDTOParam> mesBuildingMachinePartSchedulingDTOParamLinkList = mesBuildingMachinePartSchedulingDTOParam.getLinkList();
      Long projectId = mesBuildingMachinePartSchedulingDTOParamLinkList.get(0).getProjectId();
      String projectName = this.projectService.getById(projectId).getName();
      String orderNumber = "";
      Long mesBuildingMachinePartSchedulingId = 0L;
      if (null != aLong) {
         MesBuildingMachinePartScheduling mesBuildingMachinePartScheduling = this.mesBuildingMachinePartSchedulingService.getById(aLong);
         orderNumber = mesBuildingMachinePartScheduling.getOrderNumber();
         mesBuildingMachinePartSchedulingId = mesBuildingMachinePartScheduling.getId();
      } else {
         MesBuildingMachinePartScheduling scheduling = MesBuildingMachinePartScheduling.builder()
            .issueStatusEnum(MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType())
            .material("")
            .thick("")
            .userId(UserUtil.getCurrentUserId())
            .taskStatusEnum(1)
            .status(Boolean.TRUE)
            .quantity(mesBuildingMachinePartSchedulingDTOParamLinkList.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .build();
         int cun = this.mesBuildingMachinePartSchedulingService.passDeleteCount(LocalDateTime.now()) + 1;
         orderNumber = projectName + "-(型)" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + cun;
         scheduling.setOrderNumber(orderNumber);
         this.mesBuildingMachinePartSchedulingService.save(scheduling);
         mesBuildingMachinePartSchedulingId = scheduling.getId();
      }

      List<Long> productIdList = mesBuildingMachinePartSchedulingDTOParamLinkList.stream()
         .map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId)
         .collect(Collectors.toList());
      List<TechMachinePart> techMachinePartList = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, productIdList));
      Map<Long, TechMachinePart> techMachinePartMap = techMachinePartList.stream()
         .collect(Collectors.toMap(TechMachinePart::getId, techMachinePartx -> techMachinePartx));
      List<MesBuildingMachinePartNoProcess> mesBuildingMachinePartNoProcessList = new ArrayList<>();

      for (MesBuildingMachinePartSchedulingLinkDTOParam mesBuildingMachinePartSchedulingLinkDTOParam : mesBuildingMachinePartSchedulingDTOParamLinkList) {
         Long productId = mesBuildingMachinePartSchedulingLinkDTOParam.getProductId();
         MesBuildingMachinePartNoProcess mesBuildingMachinePartNoProcess = new MesBuildingMachinePartNoProcess();
         TechMachinePart techMachinePart = techMachinePartMap.get(productId);
         mesBuildingMachinePartNoProcess.setTeamId(mesBuildingMachinePartSchedulingDTOParam.getGroupsId());
         mesBuildingMachinePartNoProcess.setOrderNumber(orderNumber);
         mesBuildingMachinePartNoProcess.setMachinePartSchedulingId(mesBuildingMachinePartSchedulingId);
         mesBuildingMachinePartNoProcess.setProjectId(mesBuildingMachinePartSchedulingLinkDTOParam.getProjectId());
         mesBuildingMachinePartNoProcess.setProductId(mesBuildingMachinePartSchedulingLinkDTOParam.getProductId());
         mesBuildingMachinePartNoProcess.setProductClassificationEnum(techMachinePart.getProductClassificationEnum());
         mesBuildingMachinePartNoProcess.setWastageRate(mesBuildingMachinePartSchedulingLinkDTOParam.getWastageRate());
         mesBuildingMachinePartNoProcess.setQuantity(mesBuildingMachinePartSchedulingLinkDTOParam.getQuantity());
         mesBuildingMachinePartNoProcess.setSingleWeight(techMachinePart.getNetWeight());
         mesBuildingMachinePartNoProcess.setTotalWeight(
            new BigDecimal(mesBuildingMachinePartSchedulingLinkDTOParam.getQuantity()).multiply(techMachinePart.getNetWeight())
         );
         mesBuildingMachinePartNoProcess.setSingleLength(techMachinePart.getLength());
         mesBuildingMachinePartNoProcess.setTotalLength(
            new BigDecimal(mesBuildingMachinePartSchedulingLinkDTOParam.getQuantity())
               .multiply(techMachinePart.getLength())
               .multiply(mesBuildingMachinePartSchedulingLinkDTOParam.getWastageRate())
         );
         mesBuildingMachinePartNoProcess.setTotalRequestLength(
            new BigDecimal(mesBuildingMachinePartSchedulingLinkDTOParam.getQuantity()).multiply(techMachinePart.getLength())
         );
         mesBuildingMachinePartNoProcess.setAskCompleteTime(mesBuildingMachinePartSchedulingDTOParam.getAskCompleteTime());
         mesBuildingMachinePartNoProcess.setProductionLineId(mesBuildingMachinePartSchedulingDTOParam.getProductionLineId());
         mesBuildingMachinePartNoProcess.setSpecification(techMachinePart.getSpecification());
         mesBuildingMachinePartNoProcess.setThick(techMachinePart.getThick());
         mesBuildingMachinePartNoProcess.setMaterial(techMachinePart.getMaterial());
         mesBuildingMachinePartNoProcess.setBoolRequest(Boolean.FALSE);
         mesBuildingMachinePartNoProcess.setSchedulingUserId(UserUtil.getCurrentUserId());
         mesBuildingMachinePartNoProcess.setBoolProcess(mesBuildingMachinePartSchedulingDTOParam.getBoolProcess());
         mesBuildingMachinePartNoProcessList.add(mesBuildingMachinePartNoProcess);
      }

      this.mesBuildingMachinePartNoProcessService.saveBatch(mesBuildingMachinePartNoProcessList);
      return aLong;
   }

   @Override
   public WmsApproveRecord createPartApprovalRecord(Long schedulingId, String orderNumber) {
      Preconditions.checkArgument(schedulingId != null, "排产id不能为空");
      MesBuildingMachinePartScheduling mesBuildingMachinePartScheduling = this.mesBuildingMachinePartSchedulingService.getById(schedulingId);
      Preconditions.checkArgument(mesBuildingMachinePartScheduling != null, "排产id不存在");
      return this.wmsApproveRecordService
         .createRecord(
            schedulingId,
            mesBuildingMachinePartScheduling.getOrderNumber(),
            ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public WmsApproveRecord createAutoPartApprovalRecord(List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(appAutoCutSchedulingDetailList), "数据不能为空");
      String jobId = appAutoCutSchedulingDetailList.get(0).getOrderNumber();
      Preconditions.checkArgument(StringUtils.isNotBlank(jobId), "工单号不能为空");
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      Preconditions.checkArgument(mesBuildingBoChuJobDirectory != null, "工单号不存在");
      List<WmsApproveRecord> wmsApproveRecordList = this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataSerialNumber, jobId.toString()))
               .eq(WmsApproveRecord::getReviewStatus, 16)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(wmsApproveRecordList), "存在未审批的领料记录，无法提交下一批");
      List<MesBuildingNestingApprove> mesBuildingNestingApproveList = new ArrayList<>();
      Long timestamp = System.currentTimeMillis();

      for (APPAutoCutSchedulingDetail appAutoCutSchedulingDetail : appAutoCutSchedulingDetailList) {
         MesBuildingNestingApprove mesBuildingNestingApprove = new MesBuildingNestingApprove();
         mesBuildingNestingApprove.setSchedulingId(appAutoCutSchedulingDetail.getSchedulingId());
         mesBuildingNestingApprove.setWmsApproveRecordId(timestamp);
         mesBuildingNestingApprove.setJobId(Long.parseLong(jobId));
         mesBuildingNestingApprove.setOrderNumber(mesBuildingBoChuJobDirectory.getJobName());
         mesBuildingNestingApproveList.add(mesBuildingNestingApprove);
      }

      this.mesBuildingNestingApproveService.saveBatch(mesBuildingNestingApproveList);
      WmsApproveRecord approveRecord = this.wmsApproveRecordService
         .createRecord(
            timestamp, mesBuildingBoChuJobDirectory.getJobName(), ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType(), null, null, null, true, null, null, null
         );
      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvePart(Long id, Integer decision, String serialNumber) {
      Boolean result = this.wmsApproveRecordService.commonApproveStep(id, decision, null, serialNumber, null);
      if (result) {
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(id);
         Long approveId = wmsApproveRecord.getApplicantId();
         Long dataId = wmsApproveRecord.getDataId();
         List<PickingPartDO> pickingPartDOList = this.baseMapper.getWmsPickingDTOParam(dataId);
         MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService
            .getOne((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getSchedulingId, dataId));
         Long taskOrderId = mesBuildingTaskOrder.getId();
         String orderNumber = mesBuildingTaskOrder.getOrderNumber();
         WmsPickingDTOParam wmsPickingDTOParam = new WmsPickingDTOParam();
         wmsPickingDTOParam.setProjectId(pickingPartDOList.get(0).getProjectId());
         wmsPickingDTOParam.setMesWorkshopId(pickingPartDOList.get(0).getWorkshopId());
         wmsPickingDTOParam.setTaskOrderId(taskOrderId);
         wmsPickingDTOParam.setTaskOrderNumber(orderNumber);
         wmsPickingDTOParam.setApplicantId(approveId);
         wmsPickingDTOParam.setTransactStatus(PickingStatusEnum.NOT_PROCESSED.getType());
         if (mesBuildingTaskOrder.getOrderNumber().contains("(型)")) {
            wmsPickingDTOParam.setMaterialType("型材");
            Map<SpecificationMaterialKey, List<PickingPartDO>> grouped = pickingPartDOList.stream()
               .collect(Collectors.groupingBy(part -> new SpecificationMaterialKey(part.getSpecification(), part.getMaterial(), part.getPartType())));
            List<WmsPickingDetailDTOParam> wmsPickingDetailDTOParamList = new ArrayList<>();
            BigDecimal pickingMete = BigDecimal.ZERO;
            BigDecimal pickingLength = BigDecimal.ZERO;

            for (Entry<SpecificationMaterialKey, List<PickingPartDO>> entry : grouped.entrySet()) {
               SpecificationMaterialKey key = entry.getKey();
               List<PickingPartDO> value = entry.getValue();
               BigDecimal totalWeight = value.stream()
                  .map(part -> part.getNetWeight().multiply(new BigDecimal(part.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalLength = value.stream()
                  .map(part -> part.getLength().multiply(new BigDecimal(part.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalQuantity = value.stream().map(part -> new BigDecimal(part.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add);
               WmsPickingDetailDTOParam wmsPickingDetailDTOParam = new WmsPickingDetailDTOParam();
               wmsPickingDetailDTOParam.setSpecification(key.getSpecification());
               wmsPickingDetailDTOParam.setMaterial(key.getMaterial());
               wmsPickingDetailDTOParam.setPickingAmount(totalWeight);
               wmsPickingDetailDTOParam.setUnit("kg");
               wmsPickingDetailDTOParam.setVolume(new BigDecimal(0));
               wmsPickingDetailDTOParam.setTaskOrderId(taskOrderId);
               wmsPickingDetailDTOParam.setQuantity(totalQuantity);
               wmsPickingDetailDTOParam.setPickingType(key.getPartType());
               wmsPickingDetailDTOParam.setPickingLength(totalLength);
               wmsPickingDetailDTOParam.setHandlingLength(new BigDecimal(0));
               pickingMete = pickingMete.add(totalWeight);
               pickingLength = pickingLength.add(totalLength);
               wmsPickingDetailDTOParamList.add(wmsPickingDetailDTOParam);
            }

            wmsPickingDTOParam.setPickingLength(pickingLength);
            wmsPickingDTOParam.setPickingMete(pickingMete);
            wmsPickingDTOParam.setOutboundMete(BigDecimal.ZERO);
            wmsPickingDTOParam.setList(wmsPickingDetailDTOParamList);
            log.info("调用物料保存出库单参数：{}", wmsPickingDTOParam);
            this.wmsPickingService.saveWmsPicking(wmsPickingDTOParam);
         } else if (mesBuildingTaskOrder.getOrderNumber().contains("(直)")) {
            wmsPickingDTOParam.setMaterialType("钢板");
            Map<SpecificationMaterialPartKey, List<PickingPartDO>> pickedPartDOListMap = pickingPartDOList.stream()
               .collect(Collectors.groupingBy(part -> new SpecificationMaterialPartKey(part.getMaterial(), part.getThick())));
            List<WmsPickingDetailDTOParam> wmsPickingDetailDTOParamList = new ArrayList<>();
            BigDecimal pickingMete = BigDecimal.ZERO;
            BigDecimal pickingArea = BigDecimal.ZERO;

            for (Entry<SpecificationMaterialPartKey, List<PickingPartDO>> entry : pickedPartDOListMap.entrySet()) {
               SpecificationMaterialPartKey key = entry.getKey();
               List<PickingPartDO> value = entry.getValue();
               BigDecimal totalWeight = value.stream()
                  .map(part -> part.getNetWeight().multiply(new BigDecimal(part.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalArea = value.stream()
                  .map(part -> part.getSurfaceArea().multiply(new BigDecimal(part.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalQuantity = value.stream().map(part -> new BigDecimal(part.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add);
               WmsPickingDetailDTOParam wmsPickingDetailDTOParam = new WmsPickingDetailDTOParam();
               wmsPickingDetailDTOParam.setMaterial(key.getMaterial());
               wmsPickingDetailDTOParam.setThick(new BigDecimal(key.getThick()));
               wmsPickingDetailDTOParam.setPickingAmount(totalWeight);
               wmsPickingDetailDTOParam.setUnit("kg");
               wmsPickingDetailDTOParam.setVolume(new BigDecimal(0));
               wmsPickingDetailDTOParam.setTaskOrderId(taskOrderId);
               wmsPickingDetailDTOParam.setQuantity(totalQuantity);
               wmsPickingDetailDTOParam.setPickingType("钢板");
               wmsPickingDetailDTOParam.setPickingArea(totalArea);
               wmsPickingDetailDTOParam.setHandlingArea(new BigDecimal(0));
               pickingMete = pickingMete.add(totalWeight);
               pickingArea = pickingArea.add(totalArea);
               wmsPickingDetailDTOParamList.add(wmsPickingDetailDTOParam);
            }

            wmsPickingDTOParam.setPickingArea(pickingArea);
            wmsPickingDTOParam.setPickingMete(pickingMete);
            wmsPickingDTOParam.setOutboundMete(BigDecimal.ZERO);
            wmsPickingDTOParam.setList(wmsPickingDetailDTOParamList);
            this.wmsPickingService.saveWmsPicking(wmsPickingDTOParam);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approveAutoCut(Long wmsApproveRecordId) {
      for (WmsApproveRecord wmsApproveRecord : this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataId, wmsApproveRecordId))
               .eq(WmsApproveRecord::getReviewStatus, 16)
         )) {
         Long id = wmsApproveRecord.getId();
         String serialNumber = wmsApproveRecord.getSerialNumber();
         List<MesBuildingNestingApprove> mesBuildingNestingApproveList = this.mesBuildingNestingApproveService
            .list((Wrapper<MesBuildingNestingApprove>)new LambdaQueryWrapper<MesBuildingNestingApprove>().eq(MesBuildingNestingApprove::getWmsApproveRecordId, wmsApproveRecordId));
         List<Long> schedulingIds = mesBuildingNestingApproveList.stream().map(MesBuildingNestingApprove::getSchedulingId).collect(Collectors.toList());
         List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService
            .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().in(MesBuildingTaskOrder::getSchedulingId, schedulingIds));
         Integer decision = 2;
         Boolean result = this.wmsApproveRecordService.commonApproveStep(id, decision, null, serialNumber, null);

         for (MesBuildingTaskOrder mesBuildingTaskOrder : mesBuildingTaskOrderList) {
            if (result) {
               Long approveId = wmsApproveRecord.getApplicantId();
               Long dataId = wmsApproveRecord.getDataId();
               List<PickingPartDO> pickingPartDOList = this.baseMapper.getWmsPickingDTOParam(mesBuildingTaskOrder.getSchedulingId());
               if (pickingPartDOList.size() != 0) {
                  Long taskOrderId = mesBuildingTaskOrder.getId();
                  String orderNumber = mesBuildingTaskOrder.getOrderNumber();
                  WmsPickingDTOParam wmsPickingDTOParam = new WmsPickingDTOParam();
                  wmsPickingDTOParam.setProjectId(pickingPartDOList.get(0).getProjectId());
                  wmsPickingDTOParam.setMesWorkshopId(pickingPartDOList.get(0).getWorkshopId());
                  wmsPickingDTOParam.setTaskOrderId(taskOrderId);
                  wmsPickingDTOParam.setTaskOrderNumber(orderNumber);
                  wmsPickingDTOParam.setApplicantId(approveId);
                  wmsPickingDTOParam.setTransactStatus(PickingStatusEnum.NOT_PROCESSED.getType());
                  if (mesBuildingTaskOrder.getOrderNumber().contains("(套)")) {
                     wmsPickingDTOParam.setMaterialType("钢板");
                     MaterialFreezeDTO nestingFreezeDetail = this.materialFreezeService.getNestingFreezeDetail(taskOrderId);
                     if (nestingFreezeDetail == null) {
                        log.info("该钢板未冻结");
                        wmsPickingDTOParam.setPickingMete(BigDecimal.ZERO);
                        wmsPickingDTOParam.setOutboundMete(BigDecimal.ZERO);
                     } else {
                        wmsPickingDTOParam.setPickingMete(nestingFreezeDetail.getFrozenMete().divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP));
                        wmsPickingDTOParam.setOutboundMete(nestingFreezeDetail.getFrozenMete());
                     }

                     wmsPickingDTOParam.setBoolAuto(true);
                     this.wmsPickingService.saveWmsPicking(wmsPickingDTOParam);
                  }
               }
            }
         }
      }

      return true;
   }

   @Override
   public PageVO<ApprovePartRecordDTO> approvePartList(Integer type, Integer status, Integer pageNumber, Integer pageSize) {
      WmsApproveRecordDTOParam wmsApproveRecordDTOParam = new WmsApproveRecordDTOParam();
      if (status == 1) {
         wmsApproveRecordDTOParam.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
         wmsApproveRecordDTOParam.setWaitMeCheck(Boolean.TRUE);
      } else {
         wmsApproveRecordDTOParam.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      }

      Map<Long, String> projectMap = this.contractProjectService
         .list()
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getShortName));
      wmsApproveRecordDTOParam.setApproveProcessType(type);
      PageVO<WmsApproveRecordDTO> pageVO = this.wmsApproveRecordService.getList(wmsApproveRecordDTOParam, pageNumber, Integer.MAX_VALUE, null, 0);
      List<ApprovePartRecordDTO> approvePartRecordDTOList = new ArrayList<>();
      List<WmsApproveRecordDTO> wmsApproveRecordDTOList = pageVO.getContent();
      wmsApproveRecordDTOList = wmsApproveRecordDTOList.stream()
         .sorted((o1, o2) -> o2.getStartTime().compareTo(o1.getStartTime()))
         .collect(Collectors.toList());
      List<Long> dataIdList = pageVO.getContent().stream().map(WmsApproveRecord::getDataId).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(wmsApproveRecordDTOList)) {
         return new PageVO<>();
      }

      List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService
         .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getTaskTypeEnum, 1));
      Map<Long, MesBuildingTaskOrder> mesBuildingTaskOrderMap = mesBuildingTaskOrderList.stream()
         .collect(Collectors.toMap(MesBuildingTaskOrder::getSchedulingId, Function.identity()));

      for (WmsApproveRecordDTO wmsApproveRecordDTO : wmsApproveRecordDTOList) {
         Long dataId = wmsApproveRecordDTO.getDataId();
         String approveRecordSerialNumber = wmsApproveRecordDTO.getDataSerialNumber();
         List<WmsApproveRecord> wmsApproveRecordList = this.wmsApproveRecordService
            .list((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, approveRecordSerialNumber));
         ApprovePartRecordDTO approvePartRecordDTO = this.baseMapper.resultByApprovePartList(dataId);
         if (CollectionUtils.isNotEmpty(wmsApproveRecordList)) {
            approvePartRecordDTO.setId(wmsApproveRecordList.get(0).getId());
         }

         MesBuildingTaskOrder mesBuildingTaskOrder = mesBuildingTaskOrderMap.get(dataId);
         if (mesBuildingTaskOrder == null) {
            MesBuildingNestingApprove mesBuildingNestingApprove = this.mesBuildingNestingApproveService
               .list((Wrapper<MesBuildingNestingApprove>)new LambdaQueryWrapper<MesBuildingNestingApprove>().eq(MesBuildingNestingApprove::getWmsApproveRecordId, dataId))
               .get(0);
            approvePartRecordDTO = this.baseMapper.resultByApprovePartList(mesBuildingNestingApprove.getSchedulingId());
            dataId = mesBuildingNestingApprove.getSchedulingId();
            mesBuildingTaskOrder = mesBuildingTaskOrderMap.get(mesBuildingNestingApprove.getSchedulingId());
            approvePartRecordDTO.setApproveType(ApproveTypeEnum.AutoCut.getType());
            approvePartRecordDTO.setWmsApproveRecordId(mesBuildingNestingApprove.getWmsApproveRecordId());
         } else if (mesBuildingTaskOrder.getOrderNumber().contains("(型)")) {
            approvePartRecordDTO.setApproveType(ApproveTypeEnum.FinishCut.getType());
         } else if (mesBuildingTaskOrder.getOrderNumber().contains("(直)")) {
            approvePartRecordDTO.setApproveType(ApproveTypeEnum.SemiAuto.getType());
         }

         Long projectId = this.mesBuildingTaskProcessService
            .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getMachinePartSchedulingId, dataId))
            .get(0)
            .getProjectId();
         ContractProject contractProject = this.projectService.getById(projectId);
         approvePartRecordDTO.setProjectName(contractProject.getShortName());
         approvePartRecordDTO.setProjectSerialNumber(contractProject.getSerialNumber());
         approvePartRecordDTO.setProjectId(projectId);
         approvePartRecordDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
         approvePartRecordDTO.setJobId(mesBuildingTaskOrder.getJobId());
         List<MesBuildingMachinePartNoProcess> mesBuildingMachinePartNoProcessList = this.mesBuildingMachinePartNoProcessService
            .list((Wrapper<MesBuildingMachinePartNoProcess>)new LambdaQueryWrapper<MesBuildingMachinePartNoProcess>().eq(MesBuildingMachinePartNoProcess::getBoolRequest, Boolean.TRUE));
         approvePartRecordDTO.setSchedulingId(dataId);
         approvePartRecordDTO.setApproveDate(wmsApproveRecordDTO.getCreateTime());
         approvePartRecordDTO.setStatus(wmsApproveRecordDTO.getStatus());
         if (CollectionUtils.isNotEmpty(mesBuildingMachinePartNoProcessList)) {
            approvePartRecordDTO.setBoolRequest(Boolean.TRUE);
         }

         if (approvePartRecordDTO.getOrderNumber().startsWith("(套)")) {
            String result = approvePartRecordDTO.getOrderNumber().replaceAll("\\(套\\)", "");
            int lastDashIndex = result.lastIndexOf("-");
            if (lastDashIndex != -1) {
               result = result.substring(0, lastDashIndex);
               approvePartRecordDTO.setOrderNumber(result);
            }
         }

         approvePartRecordDTOList.add(approvePartRecordDTO);
      }

      return listPage(pageNumber, pageSize, approvePartRecordDTOList);
   }

   @Override
   public WmsApproveRecordFlowDTO approvePartDetail(Long id) {
      return this.wmsApproveRecordService.getApproveRecordDTO(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean manuallyProcessingMachinePartIssuedToNestingSoftwareAbnormalData(List<Long> taskOrderIdList) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(taskOrderIdList), "任务工单id不能为空");
      LocalDateTime tenMinutesAgo = LocalDateTime.now().plusMinutes(-10L);
      List<MesBuildingTaskNeedMachinePartScheduling> issuedInProgressList = this.mesBuildingTaskNeedMachinePartSchedulingService
         .lambdaQuery()
         .in(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderIdList)
         .eq(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, false)
         .eq(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType())
         .apply("DATE_FORMAT(issued_to_nesting_software_operation_time, '%Y-%m-%d %H:%i') <= DATE_FORMAT({0}, '%Y-%m-%d %H:%i') ", tenMinutesAgo)
         .list();
      Preconditions.checkArgument(CollUtil.isNotEmpty(issuedInProgressList), "没有需要处理的数据(下发中且下发时间超过10分钟)");
      List<Integer> jobIdList = issuedInProgressList.stream()
         .map(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId)
         .distinct()
         .collect(Collectors.toList());
      List<MesBuildingBoChuJobDirectory> jobList = Optional.of(jobIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.mesBuildingBoChuJobDirectoryService::listByIds)
         .orElseGet(Collections::emptyList);
      if (CollUtil.isEmpty(jobList)) {
         this.mesBuildingTaskNeedMachinePartSchedulingService
            .update(
               (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(((((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                                 .in(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderIdList))
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, false))
                           .eq(
                              MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus,
                              IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType()
                           ))
                        .apply("DATE_FORMAT(issued_to_nesting_software_operation_time, '%Y-%m-%d %H:%i') <= DATE_FORMAT({0}, '%Y-%m-%d %H:%i') ", tenMinutesAgo))
                     .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null))
                  .set(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType())
            );
      } else {
         Map<Integer, List<MesBuildingTaskNeedMachinePartScheduling>> issuedInProgressGroup = issuedInProgressList.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId));
         Map<Long, String> teamCodeMap = this.mesBuildingNestingTeamService
            .list()
            .stream()
            .collect(Collectors.toMap(MesBuildingNestingTeam::getId, MesBuildingNestingTeam::getTeamCode));
         List<Long> allSuccessIdList = new ArrayList<>();
         List<Long> allFailIdList = new ArrayList<>();
         jobList.forEach(
            job -> {
               List<MesBuildingTaskNeedMachinePartScheduling> jobIssuedInProgressList = issuedInProgressGroup.get(job.getJobId());
               if (!CollUtil.isEmpty(jobIssuedInProgressList)) {
                  String teamCode = teamCodeMap.get(job.getTeamCodeId());
                  if (StrUtil.isBlank(teamCode)) {
                     List<Long> failIdList = jobIssuedInProgressList.stream().map(MesBuildingTaskNeedMachinePartScheduling::getId).collect(Collectors.toList());
                     allFailIdList.addAll(failIdList);
                  } else {
                     List<BoChuPartDetailDTO> successPartDetailList = BoChuNesting.getPartDetailList(teamCode, CollUtil.toList(job.getJobId()));
                     List<Long> successIdList = successPartDetailList.stream()
                        .filter(spd -> CollUtil.isNotEmpty(spd.getPropMap()))
                        .filter(spd -> spd.getPropMap().containsKey("productId") && spd.getPropMap().containsKey("taskOrderId"))
                        .map(
                           spd -> {
                              Long productId = MapUtil.getLong(spd.getPropMap(), "productId");
                              Long taskOrderId = MapUtil.getLong(spd.getPropMap(), "taskOrderId");
                              return jobIssuedInProgressList.stream()
                                 .filter(jiip -> ObjectUtil.equals(jiip.getTaskOrderId(), taskOrderId))
                                 .filter(jiip -> ObjectUtil.equals(jiip.getProductId(), productId))
                                 .map(MesBuildingTaskNeedMachinePartScheduling::getId)
                                 .collect(Collectors.toList());
                           }
                        )
                        .flatMap(Collection::stream)
                        .filter(ObjectUtil::isNotNull)
                        .collect(Collectors.toList());
                     allSuccessIdList.addAll(successIdList);
                     List<Long> failIdList = jobIssuedInProgressList.stream()
                        .map(MesBuildingTaskNeedMachinePartScheduling::getId)
                        .filter(id -> !successIdList.contains(id))
                        .collect(Collectors.toList());
                     allFailIdList.addAll(failIdList);
                  }
               }
            }
         );
         if (CollUtil.isNotEmpty(allSuccessIdList)) {
            this.mesBuildingTaskNeedMachinePartSchedulingService
               .update(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                        .in(MesBuildingTaskNeedMachinePartScheduling::getId, allSuccessIdList))
                     .set(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.ISSUED.getType())
               );
         }

         if (CollUtil.isNotEmpty(allFailIdList)) {
            this.mesBuildingTaskNeedMachinePartSchedulingService
               .update(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)((new LambdaUpdateWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                           .in(MesBuildingTaskNeedMachinePartScheduling::getId, allFailIdList))
                        .set(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null))
                     .set(
                        MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType()
                     )
               );
         }
      }

      return true;
   }

   private Integer getJobId(BoChuJobAddParam boChuJobAddParam, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/add";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<BoChuJobAddParam> entity = new HttpEntity<>(boChuJobAddParam, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject jsonObject = new JSONObject((Map<String, Object>)response.getBody());
      if (jsonObject.getIntValue("status") != 0) {
         log.info("套料作业添加失败：" + jsonObject.get("msg"));
         Integer parent_id = boChuJobAddParam.getParent_id();
         List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
            .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, parent_id));
         if (CollectionUtils.isNotEmpty(mesBuildingBoChuJobDirectoryList)) {
            this.mesBuildingBoChuJobDirectoryService
               .removeByIds(mesBuildingBoChuJobDirectoryList.stream().map(MesBuildingBoChuJobDirectory::getId).collect(Collectors.toList()));
            log.info("套料作业删除成功");
         }

         return null;
      } else {
         JSONObject dataObject = jsonObject.getJSONObject("data");
         return dataObject.getIntValue("job_id");
      }
   }

   private void deleteNestingJob(Integer jobId, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/update";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject boChuJobAddParam = new JSONObject();
      boChuJobAddParam.put("id", jobId);
      boChuJobAddParam.put("is_delete", 1);
      HttpEntity<JSONObject> entity = new HttpEntity<>(boChuJobAddParam, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject jsonObject = new JSONObject((Map<String, Object>)response.getBody());
      if (jsonObject.getIntValue("status") != 0) {
         log.info("套料作业删除失败：" + jsonObject.get("msg"));
      } else {
         List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
            .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
         if (CollectionUtils.isNotEmpty(mesBuildingBoChuJobDirectoryList)) {
            MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
            List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryListParent = this.mesBuildingBoChuJobDirectoryService
               .list(
                  (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
                     .eq(MesBuildingBoChuJobDirectory::getParentId, mesBuildingBoChuJobDirectory.getJobId())
               );
            if (CollectionUtils.isEmpty(mesBuildingBoChuJobDirectoryListParent)) {
               this.mesBuildingBoChuJobDirectoryService.removeById(mesBuildingBoChuJobDirectory);
            }

            log.info("套料作业删除成功");
         } else {
            log.info("未找到需要删除的作业：{}", jobId);
         }
      }
   }

   private List<MachinePartNestingJobDetailDTO> getNestingJobPart(Integer jobId, String sysTemTeamCode) {
      String url = "https://cloudnest.fscut.com/api/job/part_list";
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      String resultAll = HttpRequest.post(url)
         .header(Header.CONTENT_TYPE.toString(), ContentType.JSON.toString())
         .header(BoChuNesting.headers(sysTemTeamCode))
         .body(jsonObject.toJSONString())
         .execute()
         .body();
      JSONObject j = JSONObject.parseObject(resultAll);
      JSONArray result = j.getJSONArray("data");
      List<MachinePartNestingJobDetailDTO> machinePartNestingGuidDetailDTOList = new ArrayList<>();
      if (jsonObject.getIntValue("status") != 0) {
         return machinePartNestingGuidDetailDTOList;
      }

      for (int i = 0; i < result.size(); i++) {
         JSONObject item = result.getJSONObject(i);
         MachinePartNestingJobDetailDTO machinePartNestingDetailDTO = item.toJavaObject(MachinePartNestingJobDetailDTO.class);
         machinePartNestingGuidDetailDTOList.add(machinePartNestingDetailDTO);
      }

      return machinePartNestingGuidDetailDTOList;
   }

   private List<NestCutFileTypeDTO> getNestCutFileType(String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/open_platform/nc_config";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<String> entity = new HttpEntity<>(headers);
      ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
      JSONObject jsonObject = JSON.parseObject(response.getBody());
      JSONArray result = jsonObject.getJSONArray("data");
      List<NestCutFileTypeDTO> nestCutFileTypeDTOArrayList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(result)) {
         for (int i = 0; i < result.size(); i++) {
            JSONObject item = result.getJSONObject(i);
            NestCutFileTypeDTO machinePartNestingDetailDTO = item.toJavaObject(NestCutFileTypeDTO.class);
            nestCutFileTypeDTOArrayList.add(machinePartNestingDetailDTO);
         }
      }

      return nestCutFileTypeDTOArrayList;
   }

   private byte[] getNestCutFileLXDS(
      Integer jobId, String guid, String systemTeamCode, Map<String, List<MesBuildingNestingPlateFileJson>> mesBuildingNestingPlateFileJsonMap
   ) {
      List<MesBuildingNestingPlateFileJson> mesBuildingNestingPlateFileJsonList = mesBuildingNestingPlateFileJsonMap.get(guid);
      if (CollectionUtils.isEmpty(mesBuildingNestingPlateFileJsonList)) {
         RestTemplate restTemplate = new RestTemplate();
         String url = "https://cloudnest.fscut.com/api/nspf/lxds_export";
         HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.set("X-FS-Encode", "utf-8");
         List<String> guidList = new ArrayList<>();
         guidList.add(guid);
         MesBuildingMachinePartNestingLXDSExportParam mesBuildingMachinePartNestingLXDSExportParam = new MesBuildingMachinePartNestingLXDSExportParam();
         mesBuildingMachinePartNestingLXDSExportParam.setResult_list(guidList);
         mesBuildingMachinePartNestingLXDSExportParam.setJob_id(jobId);
         HttpEntity<MesBuildingMachinePartNestingLXDSExportParam> entity = new HttpEntity<>(mesBuildingMachinePartNestingLXDSExportParam, headers);
         ResponseEntity<byte[]> responseResult = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
         MesBuildingNestingPlateFileJson mesBuildingNestingPlateFileJson = new MesBuildingNestingPlateFileJson();
         mesBuildingNestingPlateFileJson.setFileSuffix(".LXDS");
         mesBuildingNestingPlateFileJson.setGuid(guid);
         mesBuildingNestingPlateFileJson.setJobId(jobId);
         mesBuildingNestingPlateFileJson.setJobPartJson(responseResult.getBody());
         mesBuildingNestingPlateFileJson.setJobPatFileName(guid + mesBuildingNestingPlateFileJson.getFileSuffix());
         this.mesBuildingNestingPlateFileJsonService.save(mesBuildingNestingPlateFileJson);
         log.info("同步LXDS切割文件getNestCutFileLXDS：jobId{},guid{}", jobId, guid);
         return responseResult.getBody();
      } else {
         return mesBuildingNestingPlateFileJsonList.get(0).getJobPartJson();
      }
   }

   private byte[] getNestCutFileLXDSV2(
      Integer jobId, String guid, String systemTeamCode, Map<String, List<MesBuildingNestingPlateFileJson>> mesBuildingNestingPlateFileJsonMap
   ) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/nspf/lxds_export";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      List<String> guidList = new ArrayList<>();
      guidList.add(guid);
      MesBuildingMachinePartNestingLXDSExportParam mesBuildingMachinePartNestingLXDSExportParam = new MesBuildingMachinePartNestingLXDSExportParam();
      mesBuildingMachinePartNestingLXDSExportParam.setResult_list(guidList);
      mesBuildingMachinePartNestingLXDSExportParam.setJob_id(jobId);
      HttpEntity<MesBuildingMachinePartNestingLXDSExportParam> entity = new HttpEntity<>(mesBuildingMachinePartNestingLXDSExportParam, headers);
      ResponseEntity<byte[]> responseResult = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
      log.info("同步LXDS切割文件getNestCutFileLXDS：jobId{},guid{}", jobId, guid);
      return responseResult.getBody();
   }

   private byte[] getNestCutFileNC(
      Integer jobId, String guid, String systemTeamCode, String type, Map<String, List<MesBuildingNestingPlateFileJson>> NestingPlateFileJsonMap
   ) {
      List<MesBuildingNestingPlateFileJson> mesBuildingNestingPlateFileJsonList = NestingPlateFileJsonMap.get(guid + "-" + type);
      if (CollectionUtils.isEmpty(mesBuildingNestingPlateFileJsonList)) {
         RestTemplate restTemplate = new RestTemplate();
         String url = "https://cloudnest.fscut.com/api/nspf/nc_export";
         HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.set("X-FS-Encode", "utf-8");
         List<String> guidList = new ArrayList<>();
         guidList.add(guid);
         MesBuildingMachinePartNestingNCExportParam mesBuildingMachinePartNestingNCExportParam = new MesBuildingMachinePartNestingNCExportParam();
         mesBuildingMachinePartNestingNCExportParam.setResult_list(guidList);
         mesBuildingMachinePartNestingNCExportParam.setType(type);
         mesBuildingMachinePartNestingNCExportParam.setJob_id(jobId);
         mesBuildingMachinePartNestingNCExportParam.setName_filter_flag(false);
         HttpEntity<MesBuildingMachinePartNestingNCExportParam> entity = new HttpEntity<>(mesBuildingMachinePartNestingNCExportParam, headers);
         ResponseEntity<byte[]> responseResult = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
         MesBuildingNestingPlateFileJson mesBuildingNestingPlateFileJson = new MesBuildingNestingPlateFileJson();
         mesBuildingNestingPlateFileJson.setFileType(type);
         mesBuildingNestingPlateFileJson.setGuid(guid);
         mesBuildingNestingPlateFileJson.setJobId(jobId);
         mesBuildingNestingPlateFileJson.setJobPartJson(responseResult.getBody());
         String nestFileNamePath = "nesting" + File.separator + jobId + File.separator;
         mesBuildingNestingPlateFileJson.setJobPatFileName(guid + mesBuildingNestingPlateFileJson.getFileType());
         String allPath = this.nestPath + nestFileNamePath + mesBuildingNestingPlateFileJson.getJobPatFileName();

         try {
            this.saveFileFromResponse(responseResult, allPath);
         } catch (IOException e) {
            log.error("保存NC切割文件失败：jobId{},guid{},type:{}", jobId, guid, type);
            throw new RuntimeException(e);
         }

         this.mesBuildingNestingPlateFileJsonService.save(mesBuildingNestingPlateFileJson);
         log.info("同步NC切割文件getNestCutFileNC:：jobId{},guid{},type:{}", jobId, guid, type);
         return responseResult.getBody();
      } else {
         MesBuildingNestingPlateFileJson mesBuildingNestingPlateFileJson = mesBuildingNestingPlateFileJsonList.get(0);
         return mesBuildingNestingPlateFileJson.getJobPartJson();
      }
   }

   private byte[] getNestCutFileNCV2(
      Integer jobId, String guid, String systemTeamCode, String type, Map<String, List<MesBuildingNestingPlateFileJson>> NestingPlateFileJsonMap
   ) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/nspf/nc_export";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      List<String> guidList = new ArrayList<>();
      guidList.add(guid);
      MesBuildingMachinePartNestingNCExportParam mesBuildingMachinePartNestingNCExportParam = new MesBuildingMachinePartNestingNCExportParam();
      mesBuildingMachinePartNestingNCExportParam.setResult_list(guidList);
      mesBuildingMachinePartNestingNCExportParam.setType(type);
      mesBuildingMachinePartNestingNCExportParam.setJob_id(jobId);
      mesBuildingMachinePartNestingNCExportParam.setName_filter_flag(false);
      HttpEntity<MesBuildingMachinePartNestingNCExportParam> entity = new HttpEntity<>(mesBuildingMachinePartNestingNCExportParam, headers);
      ResponseEntity<byte[]> responseResult = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
      log.info("同步NC切割文件getNestCutFileNC:：jobId{},guid{},type:{}", jobId, guid, type);
      return responseResult.getBody();
   }

   public void saveFileFromResponse(ResponseEntity<byte[]> responseResult, String filePath) throws IOException {
      byte[] fileBytes = responseResult.getBody();
      if (fileBytes == null) {
         throw new IOException("Response body is empty");
      }

      String directoryPath = Paths.get(filePath).getParent().toString();
      if (directoryPath != null && !directoryPath.isEmpty()) {
         Files.createDirectories(Paths.get(directoryPath));
      }

      try (FileOutputStream fos = new FileOutputStream(filePath)) {
         fos.write(fileBytes);
      }
   }

   private void deleteNestingJobPart(JSONArray jsonArray, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/part/update";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONArray> entity = new HttpEntity<>(jsonArray, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject jsonObject = new JSONObject((Map<String, Object>)response.getBody());
      if (jsonObject.getIntValue("status") != 0) {
         throw new RuntimeException("删除失败");
      }
   }

   private List<MesBuildingBoChuNestingJobByGuidDTO> getJobByGuid(JSONArray jsonArray, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/result/get_job";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("guid_list", jsonArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)response.getBody());
      JSONArray result = j.getJSONArray("data");
      List<MesBuildingBoChuNestingJobByGuidDTO> mesBuildingBoChuNestingJobByGuidDTOList = new ArrayList<>();

      for (int i = 0; i < result.size(); i++) {
         JSONObject item = result.getJSONObject(i);

         try {
            MesBuildingBoChuNestingJobByGuidDTO mesBuildingBoChuNestingJobByGuidDTO = item.toJavaObject(MesBuildingBoChuNestingJobByGuidDTO.class);
            mesBuildingBoChuNestingJobByGuidDTOList.add(mesBuildingBoChuNestingJobByGuidDTO);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      return mesBuildingBoChuNestingJobByGuidDTOList;
   }

   private List<MesBuildingBoChuNestingResultDTO> getNestingJobPlate(Integer jobId, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/nspf_list/v2";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)response.getBody());
      JSONArray result = j.getJSONArray("data");
      List<MesBuildingBoChuNestingResultDTO> mesBuildingBoChuNestingResultDTOList = new ArrayList<>();

      for (int i = 0; i < result.size(); i++) {
         JSONObject item = result.getJSONObject(i);

         try {
            MesBuildingBoChuNestingResultDTO machinePartNestingDetailDTO = item.toJavaObject(MesBuildingBoChuNestingResultDTO.class);
            machinePartNestingDetailDTO.setJobId(jobId);
            mesBuildingBoChuNestingResultDTOList.add(machinePartNestingDetailDTO);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      return mesBuildingBoChuNestingResultDTOList;
   }

   private void deleteNestingJobPlate(JSONArray jsonArray, String sysTemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/nspf/update";
      HttpHeaders headers = BoChuNesting.headers(sysTemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONArray> entity = new HttpEntity<>(jsonArray, headers);
      ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject jsonObject = new JSONObject((Map<String, Object>)response.getBody());
      if (jsonObject.getIntValue("status") != 0) {
         throw new RuntimeException("删除失败");
      }
   }

   private String getErrorDXF(String dataJson) {
      String regex = "\"filename\":\"([^\"]*)\"";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(dataJson);
      return matcher.find() ? matcher.group(1) : null;
   }

   private Image byteArrayToITextImage(byte[] imageBytes) throws IOException {
      ImageData imageData = ImageDataFactory.create(imageBytes);
      Image img = new Image(imageData);
      img.setWidth(525.0F);
      img.setHeight(180.0F);
      img.setHorizontalAlignment(HorizontalAlignment.LEFT);
      return img;
   }

   public void generatePdf(HttpServletResponse response, String resultId, Long machineToolId) throws IOException {
      List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
         .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getGuid, resultId));
      Integer jobId = mesBuildingBoChuNestingResultList.get(0).getJobId();
      String fileName = mesBuildingBoChuNestingResultList.get(0).getFileName();
      String fileNameNest = mesBuildingBoChuNestingResultList.get(0).getFileNameNest();
      BigDecimal utilization = mesBuildingBoChuNestingResultList.get(0).getUtilization();
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      String teamCodeId = mesBuildingBoChuJobDirectoryList.get(0).getTeamCodeId().toString();
      MesBuildingNestingTeam mesBuildingNestingTeam = this.mesBuildingNestingTeamService.getById(teamCodeId);
      String systemTeamCode = mesBuildingNestingTeam.getTeamCode();
      List<MesBuildingNestingPlateJson> mesBuildingNestingJsonList = this.mesBuildingNestingPlateJsonService
         .list((Wrapper<MesBuildingNestingPlateJson>)new LambdaQueryWrapper<MesBuildingNestingPlateJson>().eq(MesBuildingNestingPlateJson::getGuid, resultId));
      MachinePartNestingPdfDTO machinePartNestingPdfDTO = new MachinePartNestingPdfDTO();
      Image img = null;
      if (CollectionUtil.isNotEmpty(mesBuildingNestingJsonList)) {
         String jobPatJson = null;

         try {
            jobPatJson = new String(mesBuildingNestingJsonList.get(0).getJobPartJson(), "UTF-8");
         } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
         }

         JSONObject j = JSON.parseObject(jobPatJson);
         if (j.get("status").equals("-1")) {
            machinePartNestingPdfDTO = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         }

         JSONObject dataObject = j.getJSONObject("data");

         try {
            machinePartNestingPdfDTO = dataObject.toJavaObject(MachinePartNestingPdfDTO.class);
         } catch (Exception e) {
            e.printStackTrace();
         }

         if (null == machinePartNestingPdfDTO) {
            machinePartNestingPdfDTO = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         }

         img = this.byteArrayToITextImage(mesBuildingNestingJsonList.get(0).getPlateDrawing());
      } else {
         machinePartNestingPdfDTO = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
         String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, machinePartNestingPdfDTO.getResult_info().get(0).getUuid());
         img = new Image(ImageDataFactory.create(imagePath));
         img.setHorizontalAlignment(HorizontalAlignment.LEFT);
         img.setWidth(525.0F);
         img.setHeight(180.0F);
      }

      machinePartNestingPdfDTO = this.getNestingReportDataSaveMessage(jobId, resultId, systemTeamCode);
      String imagePath111 = StrUtil.indexedFormat(this.bochuNestingDiagramPath, machinePartNestingPdfDTO.getResult_info().get(0).getUuid());
      img = new Image(ImageDataFactory.create(imagePath111));
      img.setHorizontalAlignment(HorizontalAlignment.LEFT);
      img.setWidth(525.0F);
      img.setHeight(180.0F);
      response.setContentType("application/pdf");
      response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("报告单.PDF", "UTF-8"));
      response.setHeader("Access-Control-Expose-Headers", "*");
      PdfWriter writer = new PdfWriter(response.getOutputStream());
      PdfDocument pdfDoc = new PdfDocument(writer);
      Document document = new Document(pdfDoc);
      pdfDoc.setDefaultPageSize(PageSize.A4);
      PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
      document.setFont(font);
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .list(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
               .eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuNestingResultList.get(0).getJobId())
         )
         .get(0);
      String[] projectIdArray = mesBuildingBoChuJobDirectory.getProjectId().split(",");
      String[] teamIdArray = mesBuildingBoChuJobDirectory.getTeamId().split(",");
      List<ContractProject> contractProjectList = new ArrayList<>();

      for (int i = 0; i < projectIdArray.length; i++) {
         contractProjectList.add(this.contractProjectService.getById(projectIdArray[i]));
      }

      List<MesBuildingNestTeamConfigDTO> mesBuildingNestTeamConfigDTOList = new ArrayList<>();

      for (int i = 0; i < teamIdArray.length; i++) {
         mesBuildingNestTeamConfigDTOList.add(this.mesBuildingNestTeamConfigService.selectNeedNestTeamConfig(Long.valueOf(teamIdArray[i])).get(0));
      }

      String projectName = "";

      for (int i = 0; i < contractProjectList.size(); i++) {
         projectName = projectName + contractProjectList.get(i).getShortName();
         if (i != contractProjectList.size() - 1) {
            projectName = projectName + ",";
         }
      }

      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(machineToolId);
      String deviceName = "";
      if (null != mesBuildingMachinePartTeamDetail) {
         deviceName = mesBuildingMachinePartTeamDetail.getDeviceName();
      }

      MesBuildingTeamUserLink mesBuildingTeamUserLink = new MesBuildingTeamUserLink();
      if (null != mesBuildingMachinePartTeamDetail) {
         Long groupsId = mesBuildingMachinePartTeamDetail.getGroupsId();
         mesBuildingTeamUserLink = this.mesBuildingTeamUserLinkService.getTeamLeaderNameByTeamId(groupsId);
      }

      String teamUserName = "";
      if (null != mesBuildingTeamUserLink.getUserName()) {
         teamUserName = mesBuildingTeamUserLink.getUserName();
      }

      String imagePath = "img/logo.png";
      URL imageUrl = this.getClass().getResource(imagePath);
      if (imageUrl != null) {
         String imageFilePath = imageUrl.getPath();
         Image logoImg = new Image(ImageDataFactory.create(imageFilePath));
         logoImg.setHorizontalAlignment(HorizontalAlignment.LEFT);
         logoImg.setWidth(50.0F);
         logoImg.setHeight(50.0F);
         document.add(logoImg);
      } else {
         System.out.println("Image not found: " + imagePath);
      }

      Paragraph title = new Paragraph("套料文件").setFont(font).setFontSize(16.0F).setTextAlignment(TextAlignment.CENTER);
      document.add(title);
      document.add(new Paragraph("项目信息"));
      float[] columnWidths3 = new float[]{5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F};
      Table table3 = new Table(UnitValue.createPercentArray(columnWidths3)).useAllAvailableWidth();
      table3.addHeaderCell("项目名称");
      table3.addHeaderCell("班组");
      table3.addHeaderCell("任务");
      table3.addHeaderCell("设备名称");
      table3.addHeaderCell("排产日期");
      table3.addHeaderCell("排产人");
      List<List<String>> data3List = new ArrayList<>();
      List<String> string3List = new ArrayList<>();
      string3List.add(projectName);
      string3List.add(teamUserName);
      string3List.add(mesBuildingBoChuJobDirectory.getJobName());
      string3List.add(deviceName);
      List<MachinePartNestingProductInfoDTO> jobInfoByJobId = this.mesBuildingTaskNeedMachinePartSchedulingService
         .getJobInfoByJobId(mesBuildingBoChuJobDirectory.getJobId());
      string3List.add(jobInfoByJobId.get(0).getSchedulingDate());
      string3List.add(jobInfoByJobId.get(0).getSchedulingUserName());
      data3List.add(string3List);

      for (List<String> stringList : data3List) {
         for (String s : stringList) {
            table3.addCell(StrUtil.blankToDefault(s, ""));
         }
      }

      Table tableFour = new Table(4).useAllAvailableWidth();
      Cell headerCell = new Cell(1, 1).add(new Paragraph("项目"));
      tableFour.addCell(headerCell);
      tableFour.addCell(new Cell(1, 3).add(new Paragraph(projectName)));
      tableFour.addCell(new Cell().add(new Paragraph("任务")));
      tableFour.addCell(new Cell().add(new Paragraph(mesBuildingBoChuJobDirectory.getJobName())));
      tableFour.addCell(new Cell().add(new Paragraph("设备名称")));
      tableFour.addCell(new Cell().add(new Paragraph(deviceName)));
      Cell headerCellThree = new Cell(1, 1).add(new Paragraph("程序名"));
      tableFour.addCell(headerCellThree);
      tableFour.addCell(new Cell(1, 3).add(new Paragraph(null != fileName ? fileName : "")));
      Cell headerCellFour = new Cell(1, 1).add(new Paragraph("班组信息"));
      tableFour.addCell(headerCellFour);
      tableFour.addCell(new Cell(1, 3).add(new Paragraph(teamUserName)));
      tableFour.addCell(new Cell().add(new Paragraph("排产日期")));
      tableFour.addCell(new Cell().add(new Paragraph(jobInfoByJobId.get(0).getSchedulingDate())));
      tableFour.addCell(new Cell().add(new Paragraph("排产人")));
      tableFour.addCell(new Cell().add(new Paragraph(jobInfoByJobId.get(0).getSchedulingUserName())));
      tableFour.addCell(new Cell().add(new Paragraph("厚度（mm）")));
      tableFour.addCell(new Cell().add(new Paragraph(machinePartNestingPdfDTO.getResult_info().get(0).getThickness())));
      tableFour.addCell(new Cell().add(new Paragraph("材质")));
      tableFour.addCell(new Cell().add(new Paragraph(machinePartNestingPdfDTO.getResult_info().get(0).getMaterial())));
      tableFour.addCell(new Cell().add(new Paragraph("规格（mm）")));
      tableFour.addCell(
         new Cell()
            .add(
               new Paragraph(machinePartNestingPdfDTO.getResult_info().get(0).getWidth() + "*" + machinePartNestingPdfDTO.getResult_info().get(0).getHeight())
            )
      );
      tableFour.addCell(new Cell().add(new Paragraph("利用率")));
      tableFour.addCell(new Cell().add(new Paragraph(utilization.setScale(2, RoundingMode.HALF_UP).toString() + "%")));
      tableFour.addCell(new Cell().add(new Paragraph("切割长度（mm）")));
      tableFour.addCell(new Cell().add(new Paragraph(machinePartNestingPdfDTO.getResult_info().get(0).getCurve_length())));
      tableFour.addCell(new Cell().add(new Paragraph("切割时长")));
      tableFour.addCell(new Cell().add(new Paragraph(this.getHourMinudeSecond(machinePartNestingPdfDTO.getResult_info().get(0).getCurve_time()))));
      document.add(tableFour);
      document.add(new Paragraph("排样图"));
      document.add(img);
      document.add(new Paragraph("零件列表"));
      float[] columnWidths2 = new float[]{2.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F};
      Table table2 = new Table(UnitValue.createPercentArray(columnWidths2)).useAllAvailableWidth();
      table2.addHeaderCell("序号");
      table2.addHeaderCell("项目");
      table2.addHeaderCell("零件编号");
      table2.addHeaderCell("规格");
      table2.addHeaderCell("零件数量");
      table2.addHeaderCell("重量（kg）");
      List<PartInfoNestingDTO> partInfo = machinePartNestingPdfDTO.getTotal_info().getPart_info();
      List<List<String>> data2List = new ArrayList<>();

      for (int i = 0; i < partInfo.size(); i++) {
         List<String> stringList2 = new ArrayList<>();
         stringList2.add(String.valueOf(i + 1));
         List<PropsDTO> props = partInfo.get(i).getProps();
         if (CollectionUtil.isNotEmpty(props)) {
            Map<String, String> keyValueProps = props.stream().collect(Collectors.toMap(PropsDTO::getProp_name, PropsDTO::getProp_value));
            String projectId = keyValueProps.get("projectId");
            if (null != projectId) {
               ContractProject contractProject = this.contractProjectService.getById(Long.valueOf(projectId));
               stringList2.add(contractProject.getShortName());
            } else {
               stringList2.add("");
            }
         }

         stringList2.add(partInfo.get(i).getName());
         String height = String.valueOf(partInfo.get(i).getHeight()).replaceAll("0+$", "");
         height = height.endsWith(".") ? height.substring(0, height.length() - 1) : height;
         String width = String.valueOf(partInfo.get(i).getWidth()).replaceAll("0+$", "");
         width = width.endsWith(".") ? width.substring(0, width.length() - 1) : width;
         width = new BigDecimal(width).setScale(0, RoundingMode.HALF_UP).toString();
         height = new BigDecimal(height).setScale(0, RoundingMode.HALF_UP).toString();
         stringList2.add(width + "*" + height);
         stringList2.add(String.valueOf(partInfo.get(i).getAmount_used()));
         String weight = new BigDecimal(partInfo.get(i).getWeight_exclude_comp())
            .divide(BigDecimal.valueOf(1000L))
            .setScale(3, RoundingMode.HALF_UP)
            .toString();
         stringList2.add(weight);
         data2List.add(stringList2);
      }

      String[][] data2Array = listToArray(data2List);

      for (String[] row : data2Array) {
         for (String cellValue : row) {
            table2.addCell(new Cell().add(new Paragraph(cellValue).setFont(font)));
         }
      }

      document.add(table2);
      document.close();
   }

   public String getHourMinudeSecond(String curve_time) {
      double totalSeconds = Double.valueOf(curve_time);
      int hours = (int)(totalSeconds / 3600.0);
      double remainingSeconds = totalSeconds % 3600.0;
      int minutes = (int)(remainingSeconds / 60.0);
      int seconds = (int)Math.round(remainingSeconds % 60.0);
      return hours + "时" + minutes + "分" + seconds + "秒";
   }

   private MachinePartNestingGuidDetailDTO getNestPartDetailSaveMessage(Integer jobId, String guid, String systemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      String resultJson = j.toString();
      List<MesBuildingNestingJson> mesBuildingNestingJsonList = this.mesBuildingNestingJsonService
         .list(
            ((new LambdaQueryWrapper<MesBuildingNestingJson>().eq(MesBuildingNestingJson::getJobId, jobId))
                  .eq(MesBuildingNestingJson::getGuid, guid))
               .select(MesBuildingNestingJson::getId)
         );
      if (CollectionUtils.isEmpty(mesBuildingNestingJsonList)) {
         MesBuildingNestingJson mesBuildingNestingJson = MesBuildingNestingJson.builder()
            .jobId(jobId)
            .guid(guid)
            .jobPartJson(resultJson.getBytes())
            .teamCode(systemTeamCode)
            .build();
         this.mesBuildingNestingJsonService.save(mesBuildingNestingJson);
      }

      JSONArray result = j.getJSONArray("data");

      for (int i = 0; i < result.size(); i++) {
         JSONObject item = result.getJSONObject(i);

         try {
            log.info(item.toString());
            MachinePartNestingGuidDetailDTO machinePartNestingDetailDTO = item.toJavaObject(MachinePartNestingGuidDetailDTO.class);
            if (null != machinePartNestingDetailDTO && machinePartNestingDetailDTO.getGuid().equals(guid)) {
               return machinePartNestingDetailDTO;
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      return null;
   }

   private JSONObject getNestPartDetailMessageList(Integer jobId, String systemTeamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      return new JSONObject((Map<String, Object>)responseResult.getBody());
   }

   private MachinePartNestingPdfDTO getNestingReportDataSaveMessage(Integer jobId, String guid, String systemTeamCode) {
      MachinePartNestingPdfDTO machinePartNestingPdfDTO = new MachinePartNestingPdfDTO();
      JSONObject jsonObject = new JSONObject();
      JSONArray guidJsonArray = new JSONArray();
      guidJsonArray.add(guid);
      jsonObject.put("result_guid_list", guidJsonArray);
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/web_report/nest_result_data";
      HttpHeaders headers = BoChuNesting.headers(systemTeamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      log.info("Response from server: " + responseResult);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, guid);
      String resultJson = j.toString();
      byte[] imagBytes = new byte[0];

      try {
         imagBytes = downloadImage(imagePath);
      } catch (IOException e) {
         throw new RuntimeException("套料图片异常：" + e.getMessage());
      }

      List<MesBuildingNestingPlateJson> mesBuildingNestingPlateJsonList = this.mesBuildingNestingPlateJsonService
         .list(
            (((new LambdaQueryWrapper<MesBuildingNestingPlateJson>().eq(MesBuildingNestingPlateJson::getJobId, jobId))
                     .eq(MesBuildingNestingPlateJson::getTeamCode, systemTeamCode))
                  .eq(MesBuildingNestingPlateJson::getGuid, guid))
               .select(MesBuildingNestingPlateJson::getId)
         );
      if (CollectionUtils.isEmpty(mesBuildingNestingPlateJsonList)) {
         MesBuildingNestingPlateJson mesBuildingNestingPlateJson = MesBuildingNestingPlateJson.builder()
            .jobId(jobId)
            .guid(guid)
            .teamCode(systemTeamCode)
            .jobPartJson(resultJson.getBytes())
            .teamCode(systemTeamCode)
            .build();
         mesBuildingNestingPlateJson.setPlateDrawing(imagBytes);
         this.mesBuildingNestingPlateJsonService.save(mesBuildingNestingPlateJson);
      }

      String nestFileNamePath = "nesting" + File.separator + jobId + File.separator;
      String nestFileName = guid + ".png";
      String allPath = this.nestPath + nestFileNamePath + nestFileName;
      File outputFile = new File(allPath);
      if (!outputFile.exists()) {
         try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imagBytes);
            BufferedImage image = ImageIO.read(byteArrayInputStream);
            File outputDir = new File(this.nestPath + nestFileNamePath);
            if (!outputDir.exists()) {
               if (outputDir.mkdirs()) {
                  log.info("目标目录创建成功: " + outputDir.getAbsolutePath());
               } else {
                  log.info("目标目录创建失败: " + outputDir.getAbsolutePath());
               }
            }

            if (image != null) {
               ImageIO.write(image, "PNG", outputFile);
            } else {
               log.info("套料图片为空");
            }
         } catch (Exception e) {
            e.printStackTrace();
            log.info("保存图片时发生错误。");
         }
      }

      JSONObject dataObject = j.getJSONObject("data");

      try {
         log.info("柏楚返回的PDF清单数据获取成功：{}", dataObject.toString());
         machinePartNestingPdfDTO = dataObject.toJavaObject(MachinePartNestingPdfDTO.class);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return machinePartNestingPdfDTO;
   }
}
