package com.hzchum.scim.mes.building.core.service.impl.craft;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigImportExcel;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintConfigService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesPaintConfigMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesPaintConfigServiceImpl extends ServiceImpl<MesPaintConfigMapper, MesPaintConfig> implements MesPaintConfigService {
   @Override
   public PageVO<MesPaintConfigDTO> pageInfo(MesPaintConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesPaintConfigDTO> list = this.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesPaintConfigDTO> listInfo(MesPaintConfigQuery query) {
      return this.baseMapper.listInfo(query);
   }

   private void verifyParam(MesPaintConfigParam param) {
      Preconditions.checkArgument(UNIT_LIST.contains(param.getUnit()), "单位参数有误");
      Preconditions.checkArgument(PACKAGE_UNIT.contains(param.getPackageUnit()), "包装单位参数有误");
      List<MesPaintConfig> list = this.list(
         Wrappers.lambdaQuery(MesPaintConfig.class)
            .ne(param.getId() != null, MesPaintConfig::getId, param.getId())
            .eq(MesPaintConfig::getPaintingTypeEnum, param.getPaintingTypeEnum())
            .eq(MesPaintConfig::getPaintBrand, param.getPaintBrand())
            .eq(MesPaintConfig::getPaintType, param.getPaintType())
      );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "涂装类型+油漆品牌+油漆类型重复");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesPaintConfigParam param) {
      this.verifyParam(param);
      MesPaintConfig paintConfig = BeanUtil.toBean(param, MesPaintConfig.class);
      this.save(paintConfig);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesPaintConfigParam param) {
      MesPaintConfig oldPaintConfig = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldPaintConfig), "数据不存在, 请刷新后重试");
      this.verifyParam(param);
      MesPaintConfig paintConfig = BeanUtil.toBean(param, MesPaintConfig.class);
      this.updateById(paintConfig);
      return true;
   }

   @Override
   public void templateDownload(HttpServletResponse response) {
      ExportParams exportParams = new ExportParams(null, null, ExcelType.XSSF);
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, MesPaintConfigImportExcel.class, new ArrayList());
      PoiUtils.downLoadExcel("油漆配置导入模板.xlsx", response, workbook);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importData(MultipartFile file, HttpServletResponse response) {
      List<MesPaintConfigImportExcel> excelList = PoiUtils.importExcel(file, 0, 1, 0, MesPaintConfigImportExcel.class);
      if (CollUtil.isEmpty(excelList)) {
         this.errorResponse(response, "导入数据不能为空");
         Preconditions.checkArgument(CollUtil.isNotEmpty(excelList), "导入数据不能为空");
      }

      Map<Integer, String> errorMap = new HashMap<>();
      excelList.stream()
         .collect(Collectors.groupingBy(k -> StrUtil.concat(true, k.getPaintingTypeName(), "&", k.getPaintBrand(), "&", k.getPaintType())))
         .entrySet()
         .stream()
         .filter(entry -> entry.getValue().size() > 1)
         .forEach(entry -> {
            List<Integer> errorOrderNoList = entry.getValue().stream().map(MesPaintConfigImportExcel::getOrderNo).distinct().collect(Collectors.toList());
            entry.getValue().forEach(value -> errorMap.put(value.getOrderNo(), "序号: " + CollUtil.join(errorOrderNoList, ",") + "; 涂装类型+油漆品牌+油漆类型重复\n"));
         });
      LambdaQueryWrapper<MesPaintConfig> qw = Wrappers.lambdaQuery(MesPaintConfig.class);
      qw.and(
         q -> excelList.forEach(
            e -> {
               Integer paintingTypeEnum = PaintingTypeEnum.getTypeByName(e.getPaintingTypeName());
               q.or(
                  wq -> {
                     LambdaQueryWrapper var10000 = ((wq.eq(
                              MesPaintConfig::getPaintingTypeEnum, paintingTypeEnum
                           ))
                           .eq(MesPaintConfig::getPaintBrand, e.getPaintBrand()))
                        .eq(MesPaintConfig::getPaintType, e.getPaintType());
                  }
               );
            }
         )
      );
      List<MesPaintConfig> list = this.list(qw);
      excelList.forEach(
         item -> {
            StringBuilder eMsg = new StringBuilder(errorMap.getOrDefault(item.getOrderNo(), ""));
            boolean allIsNotEmpty = BeanUtil.beanToMap(item).values().stream().allMatch(ObjectUtil::isNotEmpty);
            if (!allIsNotEmpty) {
               eMsg.append("存在空值\n");
            }

            if (item.getVolumeSolidContent().compareTo(BigDecimal.ZERO) <= 0) {
               eMsg.append("体积固含量不能小于等于0\n");
            }

            if (item.getSpecificGravity().compareTo(BigDecimal.ZERO) <= 0) {
               eMsg.append("比重不能小于等于0\n");
            }

            if (item.getPackageWeight().compareTo(BigDecimal.ZERO) <= 0) {
               eMsg.append("包装重量不能小于等于0\n");
            }

            MesPaintConfig paintConfig = BeanUtil.toBean(item, MesPaintConfig.class);
            Integer paintingTypeEnum = PaintingTypeEnum.getTypeByName(item.getPaintingTypeName());
            if (paintingTypeEnum == null) {
               eMsg.append("涂装类型参数有误\n");
            }

            if (!UNIT_LIST.contains(item.getUnit())) {
               eMsg.append("单位参数有误\n");
            }

            if (!PACKAGE_UNIT.contains(item.getPackageUnit())) {
               eMsg.append("包装单位参数有误\n");
            }

            List<MesPaintConfig> querylist = list.stream()
               .filter(
                  current -> Objects.equals(current.getPaintingTypeEnum(), paintConfig.getPaintingTypeEnum())
                     && Objects.equals(current.getPaintBrand(), paintConfig.getPaintBrand())
                     && Objects.equals(current.getPaintType(), paintConfig.getPaintType())
               )
               .collect(Collectors.toList());
            if (CollUtil.isNotEmpty(querylist)) {
               eMsg.append("油漆类型与已有数据重复\n");
            }

            if (StrUtil.isNotBlank(eMsg)) {
               errorMap.put(item.getOrderNo(), eMsg.toString());
            }

            if (!MapUtil.isNotEmpty(errorMap)) {
               paintConfig.setPaintingTypeEnum(paintingTypeEnum);
               this.save(paintConfig);
            }
         }
      );
      if (MapUtil.isNotEmpty(errorMap)) {
         response.reset();
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         String name = "油漆配置导入错误";
         List<MistakeExportDTO> errorExcelList = new ArrayList<>();
         errorMap.forEach((k, v) -> {
            MistakeExportDTO error = new MistakeExportDTO();
            error.setOrderNo(k);
            error.setErrorMessage(v);
            errorExcelList.add(error);
         });
         List<MistakeExportDTO> errorExcelSortList = CollUtil.sort(errorExcelList, Comparator.comparing(MistakeExportDTO::getOrderNo));
         PoiUtils.exportExcel(errorExcelSortList, name, name, MistakeExportDTO.class, name + "." + "xlsx", response);
      } else {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
      }
   }

   private void errorResponse(HttpServletResponse response, String message) {
      response.reset();
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Access-Control-Expose-Headers", "*");
      response.setHeader("Access-Control-Allow-Origin", "*");

      try {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(message, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesPaintConfig oldPaintConfig = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldPaintConfig), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }

   @Override
   public List<MesPaintConfigDTO> paintingCraftSelectList(MesPaintConfigQuery query) {
      Preconditions.checkArgument(query.getPaintingTypeEnum() != null, "涂装类型不能为空");
      return this.baseMapper.listInfo(query);
   }

   @Override
   public List<String> paintBrandList(String paintBrand) {
      return this.baseMapper.paintBrandList(paintBrand);
   }

   @Override
   public List<String> paintTypeList(String paintType) {
      return this.baseMapper.paintTypeList(paintType);
   }

   @Override
   public List<NameInfo> paintSelectList(Integer paintingTypeEnum) {
      Map<Integer, Map<String, Set<String>>> paintMap = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesPaintConfig.class).eq(paintingTypeEnum != null, MesPaintConfig::getPaintingTypeEnum, paintingTypeEnum))
         .stream()
         .collect(
            Collectors.groupingBy(
               MesPaintConfig::getPaintingTypeEnum,
               Collectors.groupingBy(MesPaintConfig::getPaintBrand, Collectors.mapping(MesPaintConfig::getPaintType, Collectors.toSet()))
            )
         );
      return Arrays.stream(PaintingTypeEnum.values()).map(paintingType -> {
         NameInfo pt = new NameInfo();
         pt.setId((long)paintingType.getType());
         pt.setName(paintingType.getName());
         Map<String, Set<String>> paintBrandMap = paintMap.getOrDefault(paintingType.getType(), Collections.emptyMap());
         List<NameInfo> pbs = new ArrayList<>();
         paintBrandMap.forEach((paintBrand, paintTypes) -> {
            NameInfo pb = new NameInfo();
            pb.setName(paintBrand);
            List<NameInfo> paintTypeList = paintTypes.stream().map(paintType -> {
               NameInfo ptni = new NameInfo();
               ptni.setName(paintType);
               return ptni;
            }).collect(Collectors.toList());
            pb.setNameInfos(paintTypeList);
            pbs.add(pb);
         });
         pt.setNameInfos(pbs);
         return pt;
      }).collect(Collectors.toList());
   }
}
