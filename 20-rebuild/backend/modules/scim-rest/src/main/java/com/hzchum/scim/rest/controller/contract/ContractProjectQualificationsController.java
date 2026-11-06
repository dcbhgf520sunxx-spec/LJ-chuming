package com.hzchum.scim.rest.controller.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ContractProjectQualificationsDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "中南资质证照对接")
@RestController
@RequestMapping("/api/contract/project/qualifications")
public class ContractProjectQualificationsController {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectQualificationsController.class);
   @Resource
   private ContractProjectService contractProjectService;
   @Value("${zhongnan-qualifications.secret}")
   private String secret;

   @ApiOperation("获取项目列表")
   @GetMapping("/get/project/list")
   public ResultVO getProjectList(String secretCode) {
      log.info("API调用:获取项目列表");
      Preconditions.checkArgument(this.secret.equals(secretCode), "暂无权限!!!!!");
      List<ContractProject> contractProjects = this.contractProjectService.list();
      Map<Long, ContractProject> projectMap = contractProjects.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<ContractProjectQualificationsDTO> contractProjectQualificationsDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(contractProjects)) {
         contractProjects.forEach(
            item -> {
               String stateName = "";
               if (item.getStatus() == 1) {
                  stateName = "进行中";
               }

               if (item.getStatus() == 2) {
                  stateName = "已暂停";
               }

               if (item.getStatus() == 4) {
                  stateName = "已完工";
               }

               ContractProjectQualificationsDTO build = ContractProjectQualificationsDTO.builder()
                  .fnumber(item.getSerialNumber())
                  .name(item.getName())
                  .customerUnit(item.getCustomerUnit())
                  .work_out(LocalDateTime.of(item.getEndDate(), LocalTime.of(0, 0)))
                  .state(item.getStatus().toString())
                  .state_name(stateName)
                  .build();
               build.setAddress(StringUtils.isNotBlank(item.getAddress()) ? item.getAddress() : this.splicingAddress(item));
               if (item.getPId() != null) {
                  ContractProject contractProject = projectMap.get(item.getPId());
                  Preconditions.checkArgument(contractProject != null, "父级项目异常");
                  build.setParent_number(contractProject.getSerialNumber());
               }

               contractProjectQualificationsDTOS.add(build);
            }
         );
         return ResultBuilder.success(contractProjectQualificationsDTOS);
      } else {
         return ResultBuilder.failed("获取失败，项目列表为空!!!");
      }
   }

   public String splicingAddress(ContractProject contractProject) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(contractProject.getCountryName() == null ? "" : contractProject.getCountryName());
      stringBuilder.append(contractProject.getProvinceName() == null ? "" : contractProject.getProvinceName());
      stringBuilder.append(contractProject.getCityName() == null ? "" : contractProject.getCityName());
      stringBuilder.append(contractProject.getRegionName() == null ? "" : contractProject.getRegionName());
      return stringBuilder.toString();
   }
}
