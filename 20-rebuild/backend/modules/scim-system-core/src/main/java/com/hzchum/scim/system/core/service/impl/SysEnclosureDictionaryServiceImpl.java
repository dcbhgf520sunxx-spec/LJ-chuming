package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.common.enums.EnclosureDictionaryTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.SysPressureBearingPlateEnum;
import com.hzchum.scim.system.core.api.common.enums.SysProfiledPlateEnum;
import com.hzchum.scim.system.core.api.common.enums.SysSandwichBoardEnum;
import com.hzchum.scim.system.core.api.common.enums.SysTrussFloorPlateEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionaryDetail;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDetailDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysTrussFloorPlateCodeDTO;
import com.hzchum.scim.system.core.api.pojo.request.EnclosureDictionaryDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.TrussFloorPlateSaveDTOParam;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryService;
import com.hzchum.scim.system.core.mapper.SysEnclosureDictionaryDetailMapper;
import com.hzchum.scim.system.core.mapper.SysEnclosureDictionaryMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysEnclosureDictionaryServiceImpl
   extends ServiceImpl<SysEnclosureDictionaryMapper, SysEnclosureDictionary>
   implements SysEnclosureDictionaryService {
   @Resource
   private SysEnclosureDictionaryMapper enclosureDictionariesMapper;
   @Resource
   private SysEnclosureDictionaryDetailMapper enclosureDictionaryDetailMapper;
   @Resource
   private RedisUtils redisUtils;

   @Override
   public ListVO listAllDictionary(Integer type) {
      if (EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType().equals(type)) {
         return new ListVO<>(this.enclosureDictionariesMapper.listCodes(null));
      }

      List<SysEnclosureDictionarySimpleDTO> responseList = new ArrayList<>(16);
      if (EnclosureDictionaryTypeEnum.SANDWICH_BOARD.getType().equals(type)) {
         responseList = SysSandwichBoardEnum.listAll();
      }

      if (EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType().equals(type)) {
         responseList = SysProfiledPlateEnum.listAll();
      }

      if (EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType().equals(type)) {
         responseList = SysPressureBearingPlateEnum.listAll();
      }

      return new ListVO<>(responseList);
   }

   @Override
   public ListVO<SysEnclosureDictionaryDTO> listByName(String name, String code, Integer type, String label) {
      if (type.equals(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
         return new ListVO<>(this.enclosureDictionariesMapper.listByCode(code, type));
      }

      List<SysEnclosureDictionaryDTO> sysEnclosureDictionaryDTOS = this.enclosureDictionariesMapper.listByNameAndLabelLike(name, label, type);
      if (type.equals(EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType()) || type.equals(EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType())) {
         sysEnclosureDictionaryDTOS.forEach(
            s -> {
               if (s.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName())) {
                  SysEnclosureDictionaryDetail dictionaryDetail = this.enclosureDictionaryDetailMapper
                     .selectOne(Wrappers.lambdaQuery(SysEnclosureDictionaryDetail.class).eq(SysEnclosureDictionaryDetail::getEnclosureDictionaryId, s.getId()));
                  if (dictionaryDetail != null) {
                     SysEnclosureDictionaryDetailDTO detailDTO = BeanUtil.copy(dictionaryDetail, SysEnclosureDictionaryDetailDTO.class);
                     s.setDictionaryDetail(detailDTO);
                  }
               }
            }
         );
      }

      return new ListVO<>(sysEnclosureDictionaryDTOS);
   }

   @Override
   public ListVO<SysEnclosureDictionaryDTO> listByCode(String code) {
      List<SysEnclosureDictionary> dictionaryList = this.enclosureDictionariesMapper
         .selectList(
            (Wrapper<SysEnclosureDictionary>)(new LambdaQueryWrapper<SysEnclosureDictionary>()
                  .eq(SysEnclosureDictionary::getType, EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType()))
               .eq(SysEnclosureDictionary::getCode, code)
         );
      if (dictionaryList.isEmpty()) {
         return new ListVO<>();
      }

      List<SysEnclosureDictionaryDTO> dictionaryDTOS = dictionaryList.stream()
         .map(d -> BeanUtil.copy(d, SysEnclosureDictionaryDTO.class))
         .collect(Collectors.toList());
      return new ListVO<>(dictionaryDTOS);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer saveBatchDictionary(List<EnclosureDictionaryDTOParam> requestVOS) {
      int count = 0;

      for (EnclosureDictionaryDTOParam enclosureVO : requestVOS) {
         SysEnclosureDictionary enclosureDictionary = SysEnclosureDictionary.builder().build();
         Integer type = enclosureVO.getType();
         String name = enclosureVO.getName();
         if (this.enclosureDictionariesMapper.getByNameAndLabel(enclosureVO.getName(), enclosureVO.getLabel(), type) == null) {
            if (EnclosureDictionaryTypeEnum.SANDWICH_BOARD.getType().equals(type)) {
               if (!SysSandwichBoardEnum.checkName(enclosureVO.getName())) {
                  continue;
               }

               enclosureDictionary.setRemark(SysSandwichBoardEnum.getRemarkByName(name));
            }

            if (EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType().equals(type)) {
               if (!SysProfiledPlateEnum.checkName(enclosureVO.getName())) {
                  continue;
               }

               enclosureDictionary.setRemark(SysProfiledPlateEnum.getRemarkByName(name));
            }

            if (EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType().equals(type)) {
               if (!SysTrussFloorPlateEnum.checkName(enclosureVO.getName())) {
                  continue;
               }

               enclosureDictionary.setRemark(SysTrussFloorPlateEnum.getRemarkByName(name));
            }

            if (EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType().equals(type)) {
               if (!SysPressureBearingPlateEnum.checkName(enclosureVO.getName())) {
                  continue;
               }

               enclosureDictionary.setRemark(SysPressureBearingPlateEnum.getRemarkByName(name));
            }

            SysEnclosureDictionary Sort = this.enclosureDictionariesMapper.getSort(name, type);
            BeanUtil.copy(enclosureVO, enclosureDictionary);
            enclosureDictionary.setType(type);
            enclosureDictionary.setSort(Sort.getSort());
            int insert = this.enclosureDictionariesMapper.insert(enclosureDictionary);
            count += insert;
         }
      }

      return count;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveDictionary(EnclosureDictionaryDTOParam dtoParam) {
      Integer type = dtoParam.getType();
      String name = dtoParam.getName();
      SysEnclosureDictionary enclosureDictionary = SysEnclosureDictionary.builder().build();
      if (EnclosureDictionaryTypeEnum.SANDWICH_BOARD.getType().equals(type)) {
         Preconditions.checkArgument(SysSandwichBoardEnum.checkName(name), "保存失败，传入的字典名称错误");
         enclosureDictionary.setRemark(SysSandwichBoardEnum.getRemarkByName(name));
      }

      if (EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType().equals(type)) {
         Preconditions.checkArgument(SysProfiledPlateEnum.checkName(name), "保存失败，传入的字典名称错误");
         enclosureDictionary.setRemark(SysProfiledPlateEnum.getRemarkByName(name));
      }

      if (EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType().equals(type)) {
         Preconditions.checkArgument(SysPressureBearingPlateEnum.checkName(name), "保存失败，传入的字典名称错误");
         enclosureDictionary.setRemark(SysPressureBearingPlateEnum.getRemarkByName(name));
      }

      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(type));
      SysEnclosureDictionary dictionary = this.enclosureDictionariesMapper.getByNameAndLabel(name, dtoParam.getLabel(), type);
      Preconditions.checkArgument(dictionary == null, "保存失败，该字典名称下已有对应的字典标签");
      BeanUtil.copy(dtoParam, enclosureDictionary);
      this.enclosureDictionariesMapper.insert(enclosureDictionary);
      if ((type.equals(EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType()) || type.equals(EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType()))
         && enclosureDictionary.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName())) {
         SysEnclosureDictionaryDetailDTOParam dictionaryDetail = dtoParam.getDictionaryDetail();
         Preconditions.checkArgument(dictionaryDetail != null, "版型的展宽和有效宽度不能为空!");
         Preconditions.checkArgument(dictionaryDetail.getEffectiveWidth().compareTo(BigDecimal.ZERO) > 0, "有效宽度必须大于0");
         Preconditions.checkArgument(dictionaryDetail.getUnfoldedWidth().compareTo(BigDecimal.ZERO) > 0, "展宽必须大于0");
         Preconditions.checkArgument(dictionaryDetail.getEffectiveWidth().compareTo(dictionaryDetail.getUnfoldedWidth()) <= 0, "展宽不能小于有效宽度");
         SysEnclosureDictionaryDetail detail = BeanUtil.copy(dictionaryDetail, SysEnclosureDictionaryDetail.class);
         detail.setEnclosureDictionaryId(enclosureDictionary.getId());
         detail.setPlateType(enclosureDictionary.getLabel());
         this.enclosureDictionaryDetailMapper.insert(detail);
      }

      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(dtoParam.getType()));
      return enclosureDictionary.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateDictionary(EnclosureDictionaryDTOParam dtoParam) {
      SysEnclosureDictionary dictionary = this.enclosureDictionariesMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(dictionary != null, "更新失败，字典不存在!");
      if (!Objects.equals(dtoParam.getLabel(), dictionary.getLabel())) {
         SysEnclosureDictionary checkLabel = this.enclosureDictionariesMapper
            .getByNameAndLabel(dictionary.getName(), dtoParam.getLabel(), dictionary.getType());
         Preconditions.checkArgument(checkLabel == null, "保存失败，该字典名称下已有对应的字典标签");
         dictionary.setLabel(dtoParam.getLabel());
      }

      dictionary.setSort(dtoParam.getSort());
      if ((
            dtoParam.getType().equals(EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType())
               || dtoParam.getType().equals(EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType())
         )
         && dtoParam.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName())) {
         Preconditions.checkArgument(dtoParam.getDictionaryDetail() != null, "版型的详情为空!");
         Preconditions.checkArgument(dtoParam.getDictionaryDetail().getId() != null, "版型的详情id为空!");
         SysEnclosureDictionaryDetail dictionaryDetail = this.enclosureDictionaryDetailMapper.selectById(dtoParam.getDictionaryDetail().getId());
         Preconditions.checkArgument(dictionaryDetail != null, "版型的详情id有误,版型详情不存在");
         BeanUtil.copy(dtoParam.getDictionaryDetail(), dictionaryDetail);
         dictionaryDetail.setPlateType(dtoParam.getLabel());
         this.enclosureDictionaryDetailMapper.updateById(dictionaryDetail);
      }

      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(dictionary.getType()));
      return this.enclosureDictionariesMapper.updateById(dictionary) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteDictionary(Long id) {
      SysEnclosureDictionary dictionary = this.enclosureDictionariesMapper.selectById(id);
      Preconditions.checkArgument(dictionary != null, "删除失败，字典不存在!");
      if ((
            dictionary.getType().equals(EnclosureDictionaryTypeEnum.PROFILED_PLATE.getType())
               || dictionary.getType().equals(EnclosureDictionaryTypeEnum.PRESSURE_BEARING_PLATE.getType())
         )
         && dictionary.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName())) {
         this.enclosureDictionaryDetailMapper
            .delete(Wrappers.lambdaQuery(SysEnclosureDictionaryDetail.class).eq(SysEnclosureDictionaryDetail::getEnclosureDictionaryId, dictionary.getId()));
      }

      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(dictionary.getType()));
      return this.enclosureDictionariesMapper.deleteById(id) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveUpdateEnclosureDictionary(TrussFloorPlateSaveDTOParam param) {
      List<SysEnclosureDictionary> dictionaryList = this.enclosureDictionariesMapper
         .selectList(
            (Wrapper<SysEnclosureDictionary>)(new LambdaQueryWrapper<SysEnclosureDictionary>().eq(SysEnclosureDictionary::getCode, param.getCode()))
               .eq(SysEnclosureDictionary::getType, EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType())
         );
      param.getDictionaryDetails().forEach(dtoParam -> {
         if (dtoParam.getId() == null) {
            Preconditions.checkArgument(CollectionUtils.isEmpty(dictionaryList), "该编号已存在");
            Preconditions.checkArgument(param.getSort() != null, "排序不可为空");
            SysEnclosureDictionary dictionary = BeanUtil.copy(dtoParam, SysEnclosureDictionary.class);
            BeanUtil.copy(param, dictionary);
            dictionary.setStatus(true);
            dictionary.setType(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType());
            this.baseMapper.insert(dictionary);
         } else {
            SysEnclosureDictionary dictionary = this.baseMapper.selectById(dtoParam.getId());
            Preconditions.checkArgument(dictionary != null, "该编号不存在");
            dictionary.setLabel(dtoParam.getLabel());
            dictionary.setSort(param.getSort());
            this.baseMapper.updateById(dictionary);
         }
      });
      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType()));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateStatus(String code, Boolean status) {
      List<SysEnclosureDictionary> dictionaryList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(SysEnclosureDictionary.builder().code(code).type(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType()).build()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(dictionaryList), "(桁架楼承板)编号不存在");
      dictionaryList.forEach(d -> {
         d.setStatus(status);
         this.baseMapper.updateById(d);
      });
      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType()));
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteByCodes(List<String> codes) {
      codes.forEach(
         code -> {
            List<SysEnclosureDictionary> dictionaryList = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(SysEnclosureDictionary.class)
                     .eq(SysEnclosureDictionary::getCode, code)
                     .eq(SysEnclosureDictionary::getType, EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(dictionaryList), "该编号的字典不存在!");

            for (SysEnclosureDictionary d : dictionaryList) {
               this.baseMapper.deleteById(d);
            }
         }
      );
      this.redisUtils.del(EnclosureDictionaryTypeEnum.getDesByType(EnclosureDictionaryTypeEnum.TRUSS_FLOOR_PLATE.getType()));
      return Boolean.TRUE;
   }

   @Override
   public List<SysTrussFloorPlateCodeDTO> listCodes(Boolean status) {
      return this.baseMapper.listCodes(status);
   }

   @Override
   public List<String> listByTypeAndName(Integer type, String name) {
      return this.baseMapper.listByTypeAndName(type, name);
   }
}
