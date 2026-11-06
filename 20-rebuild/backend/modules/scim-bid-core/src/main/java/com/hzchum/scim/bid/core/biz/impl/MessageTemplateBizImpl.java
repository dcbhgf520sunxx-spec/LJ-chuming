package com.hzchum.scim.bid.core.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.SmsUtil;
import com.hzchum.scim.bid.core.api.biz.MessageTemplateBiz;
import com.hzchum.scim.bid.core.api.enums.BiddingTypeEnum;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectProgressEnum;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingSupplierVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderingSupplierVO;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingSupplierService;
import com.hzchum.scim.bid.core.api.service.SupplierSubjectService;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class MessageTemplateBizImpl implements MessageTemplateBiz {
   @Resource
   private SmsUtil smsUtil;
   @Resource
   private ConfigService configService;
   @Resource
   private ProjectTenderingSupplierService projectTenderingSupplierService;
   @Resource
   private ProjectSubjectService projectSubjectService;
   @Resource
   private BiddingSupplierService biddingSupplierService;
   @Resource
   private SupplierSubjectService supplierSubjectService;

   @Override
   public void sendSupplier(ProjectTendering projectTendering, List<Long> ids, Date bidDeadline) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      JSONObject message = new JSONObject();
      message.put("name", projectTendering.getName());
      message.put("companyName", projectTendering.getCompanyName());
      message.put("bidDeadline", DateTimeUtil.dateToStringDd(bidDeadline));
      message.put("contractNo", projectTendering.getContractNo());
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         List<TenderingSupplierVO> suppliers = this.projectTenderingSupplierService.getSupplierByProjectId(projectTendering.getId(), ids);
         suppliers.forEach(e -> this.smsUtil.sendSmsBid(e.getPhone(), message.toJSONString(), "SMS_257810184"));
      } else {
         Set<Long> subjects = this.projectSubjectService
            .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, projectTendering.getId()))
            .stream()
            .map(ProjectSubject::getSubjectId)
            .collect(Collectors.toSet());
         List<BiddingSupplierVO> biddingSuppliers = this.biddingSupplierService.getList(null, null, subjects, null, CommonEnum.FALSE.getType(), uuid);
         if (CollectionUtils.isNotEmpty(biddingSuppliers)) {
            biddingSuppliers.forEach(e -> this.smsUtil.sendSmsBid(e.getContactPhone(), message.toJSONString(), "SMS_257810184"));
         }
      }
   }

   @Override
   public void sendSupplierOffer(ProjectTendering projectTendering, Integer round, String bidDead) {
      List<SupplierSubject> supplierOfferRound = this.projectTenderingSupplierService.getSupplierOfferRound(projectTendering.getId(), round);
      Map<Long, List<SupplierSubject>> supplierSubjectMap = supplierOfferRound.stream()
         .collect(Collectors.toMap(SupplierSubject::getSupplierId, e -> new ArrayList<>(Collections.singleton((SupplierSubject)e)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      Set<Long> collect = supplierOfferRound.stream().map(SupplierSubject::getSupplierId).collect(Collectors.toSet());
      Map<Long, List<SupplierSubject>> listMap = this.supplierSubjectService
         .list(
            (Wrapper<SupplierSubject>)(new LambdaQueryWrapper<SupplierSubject>().eq(SupplierSubject::getProjectId, projectTendering.getId()))
               .in(SupplierSubject::getSupplierId, collect)
         )
         .stream()
         .collect(Collectors.toMap(SupplierSubject::getSupplierId, e -> new ArrayList<>(Collections.singleton((SupplierSubject)e)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      Map<Long, TenderingSupplierVO> projectTenderingSupplierMap = this.projectTenderingSupplierService
         .getSupplierByProjectId(projectTendering.getId(), null)
         .stream()
         .collect(Collectors.toMap(TenderingSupplierVO::getId, e -> (TenderingSupplierVO)e));
      JSONObject message = new JSONObject();
      message.put("name", projectTendering.getName());
      message.put("companyName", projectTendering.getCompanyName());
      message.put("contractNo", projectTendering.getContractNo());
      supplierSubjectMap.forEach(
         (supplierId, supplierSubjectList) -> {
            List<SupplierSubject> supplierSubjects = listMap.get(supplierId);
            Map<Integer, List<SupplierSubject>> followMap = supplierSubjects.stream()
               .collect(Collectors.toMap(SupplierSubject::getIsFollow, e -> new ArrayList<>(Collections.singleton((SupplierSubject)e)), (oldList, newList) -> {
                  oldList.addAll(newList);
                  return oldList;
               }));
            if (followMap.size() == 1) {
               for (Integer key : followMap.keySet()) {
                  if (projectTendering.getProjectProgress().equals(ProjectProgressEnum.OBSOLETE.getType())) {
                     Preconditions.checkArgument(key != null, "项目已结束,不能存在未淘汰的报价供应商");
                  }

                  if (!projectTendering.getProjectProgress().equals(ProjectProgressEnum.OBSOLETE.getType()) && null == key) {
                     message.put("bidDeadline", bidDead);
                     this.smsUtil.sendSmsBid(projectTenderingSupplierMap.get(supplierId).getPhone(), message.toJSONString(), "SMS_257830206");
                     return;
                  }

                  if (CommonEnum.FALSE.getType().equals(key)) {
                     this.smsUtil.sendSmsBid(projectTenderingSupplierMap.get(supplierId).getPhone(), message.toJSONString(), "SMS_228116820");
                     return;
                  }

                  if (CommonEnum.TRUE.getType().equals(key)) {
                     this.smsUtil.sendSmsBid(projectTenderingSupplierMap.get(supplierId).getPhone(), message.toJSONString(), "SMS_227255874");
                     return;
                  }
               }
            } else {
               this.smsUtil.sendSmsBid(projectTenderingSupplierMap.get(supplierId).getPhone(), message.toJSONString(), "SMS_257830208");
            }
         }
      );
   }
}
