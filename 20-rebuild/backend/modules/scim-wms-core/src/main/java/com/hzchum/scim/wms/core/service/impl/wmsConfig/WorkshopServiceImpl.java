package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WorkshopDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WorkshopDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WorkshopMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkshopServiceImpl extends ServiceImpl<WorkshopMapper, Workshop> implements WorkshopService {
   @Resource
   WorkshopMapper workshopMapper;
   @Resource
   MesBuildingFactoryService mesBuildingFactoryService;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   UserService userService;

   @Override
   public PageVO<WorkshopDTO> pageInfo(Boolean enabled, Integer page, Integer size, List<String> sorts, Long factoryId, String name, Integer workshopType) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      String sort = StringUtils.analyzeSortConditions(sorts);
      Page<WorkshopDTO> workshopDTOSPage = PageHelper.startPage(page, size, sort);
      List<WorkshopDTO> workshopDTOS = this.listInfo(enabled, factoryId, name, workshopType, null, currentUserId);
      List<Long> userIds = new ArrayList<>();

      for (WorkshopDTO workshopDTO : workshopDTOS) {
         if (ObjectUtil.isNotEmpty(workshopDTO.getWorkshopUser())) {
            String workshopUser = workshopDTO.getWorkshopUser();
            List<Long> collect = Arrays.stream(workshopUser.split(",")).map(u -> Long.parseLong(u.trim())).collect(Collectors.toList());
            userIds.addAll(collect);
         }
      }

      if (CollectionUtils.isNotEmpty(userIds)) {
         List<Long> userIdsDst = userIds.stream().distinct().collect(Collectors.toList());
         List<UserSimpleResponseVO> users = this.userService.getSimpleUserByIds(userIdsDst);

         for (WorkshopDTO workshopDTO : workshopDTOS) {
            if (ObjectUtil.isNotEmpty(workshopDTO.getWorkshopUser())) {
               String workshopUser = workshopDTO.getWorkshopUser();
               List<Long> workUserIds = Arrays.stream(workshopUser.split(",")).map(u -> Long.parseLong(u.trim())).collect(Collectors.toList());
               List<UserSimpleResponseVO> simpleResponseVOS = users.stream().filter(u -> workUserIds.contains(u.getId())).collect(Collectors.toList());
               workshopDTO.setUserSimpleResponseVO(simpleResponseVOS);
            }
         }
      }

      return new PageVO<>(workshopDTOSPage, workshopDTOS);
   }

   private List<WorkshopDTO> listInfo(Boolean enabled, Long factoryId, String name, Integer workshopType, Long workShopId, Long currentUserId) {
      List<WorkshopDTO> workshopDTOS = new ArrayList<>();
      List<Workshop> workshops = this.workshopMapper
         .selectList(
            ((((new LambdaQueryWrapper<Workshop>()
                           .eq(enabled != null, Workshop::getEnabled, enabled))
                        .eq(factoryId != null, Workshop::getFactoryId, factoryId))
                     .eq(workShopId != null, Workshop::getId, workShopId))
                  .like(name != null, Workshop::getName, name))
               .last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)")
         );
      if (CollectionUtils.isNotEmpty(workshops)) {
         List<Long> workshopIds = workshops.stream().map(Workshop::getId).collect(Collectors.toList());
         List<Warehouse> warehouses = this.warehouseMapper.selectList((Wrapper<Warehouse>)new LambdaQueryWrapper<Warehouse>().in(Warehouse::getWorkshopId, workshopIds));
         workshopDTOS = BeanUtil.copyToList(workshops, WorkshopDTO.class);

         for (WorkshopDTO workshopDTO : workshopDTOS) {
            List<Warehouse> warehouseList = warehouses.stream().filter(w -> w.getWorkshopId().equals(workshopDTO.getId())).collect(Collectors.toList());
            workshopDTO.setIfExist(CollectionUtils.isNotEmpty(warehouseList));
            if (StrUtil.isNotBlank(workshopDTO.getMesWorkshopIds())) {
               List<Long> ids = Arrays.stream(workshopDTO.getMesWorkshopIds().split(",")).map(String::trim).map(Long::parseLong).collect(Collectors.toList());
               List<MesBuildingWorkshop> mesBuildingWorkshops = this.mesBuildingWorkshopService.listByIds(ids);
               if (CollectionUtils.isNotEmpty(mesBuildingWorkshops)) {
                  List<IdAndNameDTO> idAndNameDTOS = mesBuildingWorkshops.stream().map(m -> {
                     IdAndNameDTO idAndNameDTO = new IdAndNameDTO();
                     idAndNameDTO.setId(m.getId());
                     idAndNameDTO.setName(m.getName());
                     return idAndNameDTO;
                  }).collect(Collectors.toList());
                  workshopDTO.setMesWorkshop(idAndNameDTOS);
               }
            }
         }
      }

      return workshopDTOS;
   }

   @Override
   public Boolean updateWorkshop(WorkshopDTOParam workshopDTOParam) {
      Workshop workshopLocation = this.workshopMapper.selectById(workshopDTOParam.getId());
      if (!ObjectUtil.notEqual(workshopDTOParam.getFactoryId(), workshopLocation.getFactoryId())
         && ObjectUtil.notEqual(workshopDTOParam.getName(), workshopLocation.getName())) {
      }

      if (ObjectUtil.notEqual(workshopDTOParam.getName(), workshopLocation.getName())) {
         Preconditions.checkArgument(
            this.workshopMapper
                  .selectOne(
                     (Wrapper<Workshop>)(Wrappers.<Workshop>lambdaQuery().eq(Workshop::getName, workshopDTOParam.getName()))
                        .ne(Workshop::getId, workshopDTOParam.getId())
                  )
               == null,
            "新增仓库失败，仓库名称--" + workshopDTOParam.getName() + "--已存在"
         );
      }

      Workshop workshop = com.hzchum.pangu.common.util.BeanUtil.copy(workshopDTOParam, Workshop.class);
      if (workshopDTOParam.getSort() != null) {
         Preconditions.checkArgument(workshopDTOParam.getSort() >= 1 && workshopDTOParam.getSort() < 10000, "修改失败,排序范围[1-9999]");
      }

      if (CollectionUtils.isNotEmpty(workshopDTOParam.getWorkshopUsers())) {
         workshop.setWorkshopUser(StringUtils.list2String(workshopDTOParam.getWorkshopUsers(), ","));
      }

      if (CollectionUtils.isNotEmpty(workshopDTOParam.getMesWorkshopId())) {
         String join = String.join(",", workshopDTOParam.getMesWorkshopId().stream().map(String::valueOf).collect(Collectors.toList()));
         workshop.setMesWorkshopIds(join);
      }

      return this.workshopMapper.updateById(workshop) == 1;
   }

   @Override
   public Boolean delWorkshop(List<Long> ids) {
      for (Long id : ids) {
         Workshop workshop = this.workshopMapper.selectById(id);
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(this.warehouseMapper.selectList((Wrapper<Warehouse>)Wrappers.<Warehouse>lambdaQuery().eq(Warehouse::getWorkshopId, id))),
            workshop.getName() + "仓库下已创建存储位置，请先删除存储位置"
         );
         this.workshopMapper.deleteById(id);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAddWorkshop(List<WarehouseDTOParam> list) {
      List<String> collect = list.stream()
         .collect(Collectors.groupingBy(WarehouseDTOParam::getName, Collectors.counting()))
         .entrySet()
         .stream()
         .filter(e -> e.getValue() > 1L)
         .map(Entry::getKey)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isEmpty(collect), "添加信息中存在相同名称的仓库，请修改后重试");

      for (WarehouseDTOParam param : list) {
         String trim = StrUtil.trim(param.getName());
         Preconditions.checkArgument(trim.length() <= 20, "[" + trim + "]添加失败,仓库位置名称长度不能大于20");
         if (ObjectUtil.isNotEmpty(param.getSort())) {
            Preconditions.checkArgument(param.getSort() >= 1 && param.getSort() < 10000, "添加失败,排序范围[1-9999]");
         }

         param.setName(trim);
         Workshop workshop = com.hzchum.pangu.common.util.BeanUtil.copy(param, Workshop.class);
         if (CollectionUtils.isNotEmpty(param.getWorkshopUsers())) {
            workshop.setWorkshopUser(StringUtils.list2String(param.getWorkshopUsers(), ","));
         }

         workshop.setEnabled(true);
         Preconditions.checkArgument(
            this.workshopMapper.selectCount((Wrapper<Workshop>)Wrappers.<Workshop>lambdaQuery().eq(Workshop::getName, param.getName())) == 0,
            "新增仓库失败，仓库名称[" + param.getName() + "]已存在"
         );
         if (CollectionUtils.isNotEmpty(param.getMesWorkshopId())) {
            for (Long mesWorkshopId : param.getMesWorkshopId()) {
               MesBuildingWorkshop buildingWorkshop = this.mesBuildingWorkshopService.getById(mesWorkshopId);
               Preconditions.checkArgument(buildingWorkshop != null, "新增仓库失败，车间ID[" + param.getWorkshopId() + "]不存在");
            }

            workshop.setMesWorkshopIds(String.join(",", param.getMesWorkshopId().stream().map(String::valueOf).collect(Collectors.toList())));
            Preconditions.checkArgument(
               this.workshopMapper.selectOne((Wrapper<Workshop>)Wrappers.<Workshop>lambdaQuery().eq(Workshop::getName, param.getName())) == null,
               "新增仓库失败，仓库名称[" + param.getName() + "]已存在"
            );
         }

         this.workshopMapper.insert(workshop);
      }

      return true;
   }

   @Override
   public Boolean workshopEditEnabled(Long id, Boolean enabled) {
      return this.workshopMapper
            .update(null, (Wrapper<Workshop>)(new LambdaUpdateWrapper<Workshop>().set(Workshop::getEnabled, enabled)).eq(Workshop::getId, id))
         == 1;
   }

   @Override
   public List<WorkshopDTO> getWorkshopByUser(Long workShopId) {
      SecurityUser user = UserUtil.getCurrentUser();
      Long currentUserId = user.getId();
      if (CollectionUtils.isNotEmpty(user.getRoles())) {
         boolean isAdmin = user.getRoles().stream().anyMatch(role -> "admin".equals(role.getPermission()));
         if (isAdmin) {
            currentUserId = null;
         }
      }

      List<WorkshopDTO> workshopDTOS = this.listInfo(null, null, null, null, workShopId, currentUserId);
      List<Long> userIds = new ArrayList<>();

      for (WorkshopDTO workshopDTO : workshopDTOS) {
         if (ObjectUtil.isNotEmpty(workshopDTO.getWorkshopUser())) {
            String workshopUser = workshopDTO.getWorkshopUser();
            List<Long> collect = Arrays.stream(workshopUser.split(",")).map(u -> Long.parseLong(u.trim())).collect(Collectors.toList());
            userIds.addAll(collect);
         }
      }

      if (CollectionUtils.isNotEmpty(userIds)) {
         List<Long> userIdsDst = userIds.stream().distinct().collect(Collectors.toList());
         List<UserSimpleResponseVO> users = this.userService.getSimpleUserByIds(userIdsDst);

         for (WorkshopDTO workshopDTO : workshopDTOS) {
            if (ObjectUtil.isNotEmpty(workshopDTO.getWorkshopUser())) {
               String workshopUser = workshopDTO.getWorkshopUser();
               List<Long> workUserIds = Arrays.stream(workshopUser.split(",")).map(u -> Long.parseLong(u.trim())).collect(Collectors.toList());
               List<UserSimpleResponseVO> simpleResponseVOS = users.stream().filter(u -> workUserIds.contains(u.getId())).collect(Collectors.toList());
               workshopDTO.setUserSimpleResponseVO(simpleResponseVOS);
            }
         }
      }

      return workshopDTOS;
   }
}
