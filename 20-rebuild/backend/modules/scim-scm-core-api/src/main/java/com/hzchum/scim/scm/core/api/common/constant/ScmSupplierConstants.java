package com.hzchum.scim.scm.core.api.common.constant;

import com.hzchum.scim.scm.core.api.pojo.dto.scm.ReviewTemplateDTO;
import java.util.Arrays;
import java.util.List;

public class ScmSupplierConstants {
   public static final List<ReviewTemplateDTO> GOODS_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder().assessmentProject("产品质量").assessmentContents("全部批次物资符合合同质量约定且全部验收合格得20分，出现不合格的，每批次扣减2分，扣完为止。").fraction("20").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("产品质量")
         .assessmentContents("全部批次进场物资的产品合格证书、材质证明、检测报告均齐全得10分，出现资料不齐全的，每批次扣减1分，扣完为止。")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder().assessmentProject("产品质量").assessmentContents("全部批次物资符合环保要求得5分，出现一次环保投诉的得0分。").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("全部批次物资均送货及时得10分，出现未及时送达的，每批次扣减1分，扣完为止。").fraction("10").build(),
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("全部批次物资送货数量均准确得10分，出现送货数量不准确的，每批次扣减2分，扣完为止。").fraction("10").build(),
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("服务过程中均能配合需求部门工作的得5分，每发生一次不服从需求部门安排，又无合理理由的扣减1分，扣完为止。").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("售后服务均能及时响应得10分，每发生一次延误退换货或售后服务不及时等情况的扣减1分，扣完为止。").fraction("10").build(),
      ReviewTemplateDTO.builder().assessmentProject("履约能力").assessmentContents("垫资能力满足合同要求的得8分，每发生一次曲解合同内容或未按合同约定垫资等情况的扣减4分，扣完为止。").fraction("8").build(),
      ReviewTemplateDTO.builder().assessmentProject("履约能力").assessmentContents("履约过程中能够配合需求部门施工进度的得7分，每发生一次延误施工情况的扣减2分，延误达到三次得0分。").fraction("7").build(),
      ReviewTemplateDTO.builder().assessmentProject("履约能力").assessmentContents("生产/供应能力满足合同要求的得8分，每发生一次停工待料情况的扣减2分，达到3次得0分。").fraction("8").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("履约能力")
         .assessmentContents("过程及最终结算能够按合同约定执行的得7分，每发生一次违反合同约定情况的扣减1分，扣完为止。未按照合同执行得0分，发生诉讼纠纷得0分")
         .fraction("7")
         .build()
   );
   public static final List<ReviewTemplateDTO> PURCHASE_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder()
         .assessmentProject("产品质量")
         .assessmentContents("全部批次进场材料符合合同质量约定且全部验收合格，产品合格证书、材质证明、检测报告均齐全得30分，出现质量不合格或资料不齐全的，每批次扣减2分，扣完为止。")
         .fraction("30")
         .build(),
      ReviewTemplateDTO.builder().assessmentProject("产品质量").assessmentContents("全部批次材料符合环保要求得5分，出现一次环保投诉的得0分。").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("全部批次材料均送货及时、送货数量均准确得25分，出现未及时送达或数量有误的，每批次扣减2分，扣完为止。").fraction("25").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务质量")
         .assessmentContents("服务过程中均能配合需求部门工作且售后服务均能及时响应的得10分，每发生一次不服从需求部门安排或售后服务未及时响应，又无合理理由的扣减2分，扣完为止。")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("履约能力")
         .assessmentContents("垫资能力、生产（供应）能力、对账结算效率满足合同要求的得25分，每发生一次未按合同要求执行或曲解合同条款等情况的扣减5分，扣完为止。")
         .fraction("25")
         .build(),
      ReviewTemplateDTO.builder().assessmentProject("履约能力").assessmentContents("履约过程中能够配合需求部门施工进度的得5分，每发生一次延误施工情况的扣减2分，扣完为止。").fraction("5").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("否决项")
         .assessmentContents("在合作过程中存在行贿、舞弊、恶意竞价、严重合同违约、恶意诉讼等各种性质恶劣的不诚信行为的，直接列入黑名单。")
         .hasVeto(false)
         .fraction("")
         .build()
   );
   public static final List<ReviewTemplateDTO> SERVICE_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder().assessmentProject("服务质量").assessmentContents("服务质量符合合同要求质量的得15分，出现不合格的，每次扣减3分（情节严重的可加倍扣分），扣完为止。").fraction("15").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务质量")
         .assessmentContents("所有服务均能按约定的时间节点完成且均能按照需求部门合理要求进行工作且及时响应的得20分，服务中出现未按时完成的或未按照需求部门合理要求进行工作或未及时响应的，每次扣减4分（情节严重的可加倍扣分），扣完为止。 ")
         .fraction("20")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务保障")
         .assessmentContents("服务中所配备的各类服务人员数量均符合合同约定的得15分，服务中出现未按合同约定配备服务人员情况的，每次扣减3分（情节严重的可加倍扣分），扣完为止。 ")
         .fraction("15")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务保障")
         .assessmentContents("服务中所配备的设备（材料）种类及数量均符合合同约定的得20分，服务中出现未按合同约定配备服务设备情况的，每次扣减4分（情节严重的可加倍扣分），扣完为止。 ")
         .fraction("20")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("履约能力")
         .assessmentContents("垫资能力、服务能力、对账结算效率满足合同要求的得25分，发生曲解合同内容或未按合同约定垫资、无故暂停服务，每次扣减5分，扣完为止。")
         .fraction("25")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("履约能力")
         .assessmentContents("安全文明管理满足合同要求的得5分，出现重伤及以上事故的得0分，轻伤事故每次扣2分，隐患整改不到位每次扣1分，不文明施工每次扣1分，扣完为止。")
         .fraction("5")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("否决项")
         .assessmentContents("在合作过程中存在行贿、舞弊、恶意竞价、严重合同违约、恶意诉讼等各种性质恶劣的不诚信行为的，直接列入黑名单。")
         .hasVeto(false)
         .fraction("")
         .build()
   );
   public static final List<ReviewTemplateDTO> LABOR_SUBCONTRACT_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder().assessmentProject("基本信息-(企业资质)").assessmentContents("营业执照、建筑业劳务分包资质证书、安全生产许可证齐全有效，资质等级符合建筑劳务作业要求").fraction("4").build(),
      ReviewTemplateDTO.builder().assessmentProject("基本信息-(注册信息)").assessmentContents("法人、注册地址、经营范围与实际经营一致，无虚假注册、挂靠等违规情况").fraction("3").build(),
      ReviewTemplateDTO.builder().assessmentProject("基本信息-(备案情况)").assessmentContents("完成项目所在地住建部门劳务备案、农民工工资专用账户备案，资料提交及时、完整").fraction("3").build(),
      ReviewTemplateDTO.builder().assessmentProject("人员配置-(项目负责人)").assessmentContents("具有5年以上建筑业劳务施工管理经验").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("人员配置-(现场管理人员)").assessmentContents("各工种管理人员齐备").fraction("6").build(),
      ReviewTemplateDTO.builder().assessmentProject("人员配置-(技术工人)").assessmentContents("完成项目所在地住建部门劳务备案、农民工工资专用账户备案，资料提交及时、完整").fraction("6").build(),
      ReviewTemplateDTO.builder().assessmentProject("人员配置-(实名制管理)").assessmentContents("农民工花名册、考勤记录、工资发放记录（银行代发）完整，接入住建部门实名制管理平台").fraction("3").build(),
      ReviewTemplateDTO.builder().assessmentProject("业绩与信誉-(过往业绩)").assessmentContents("近3年有同类建筑劳务作业业绩（提供合同复印件），累计合同额不低于500万元，无违约记录").fraction("6").build(),
      ReviewTemplateDTO.builder().assessmentProject("业绩与信誉-(工程质量)").assessmentContents("已完建筑劳务工程质量合格，无重大质量返修、返工记录，符合建筑工程施工质量验收规范").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("业绩与信誉-(信誉状况)").assessmentContents("无拖欠农民工工资、违法分包、转包等违规行为，无住建部门不良监管记录、无诉讼纠纷").fraction("4").build(),
      ReviewTemplateDTO.builder().assessmentProject("施工能力-(施工进度)").assessmentContents("严格按照建筑施工进度计划完成各节点作业，无无故延误，特殊情况提前报备并制定补救措施").fraction("6").build(),
      ReviewTemplateDTO.builder().assessmentProject("施工能力-(机械设备)").assessmentContents("施工机具配备齐全，性能良好，定期检修，符合建筑施工安全要求").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("施工能力-(材料管理)").assessmentContents("建筑材料领用、堆放、使用规范，无浪费、偷工减料现象，材料损耗控制在行业标准范围内").fraction("4").build(),
      ReviewTemplateDTO.builder().assessmentProject("施工能力-(文明施工)").assessmentContents("施工现场整洁，物料堆放有序，扬尘、噪音控制符合环保要求，落实建筑施工文明工地标准").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("质量安全-(质量体系)").assessmentContents("建立完善的建筑劳务质量管控制度，工序检验、隐蔽工程验收到位，资料完整可追溯").fraction("7").build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("质量安全-(安全管理)")
         .assessmentContents("安全生产管理制度健全，安全技术交底、安全教育培训落实到位，施工现场安全防护设施齐全，人员佩戴安全防护用品")
         .fraction("7")
         .build(),
      ReviewTemplateDTO.builder().assessmentProject("质量安全-(事故记录)").assessmentContents("无建筑工程质量安全事故、无人员伤亡事故，无住建部门安全通报、处罚记录").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("质量安全-(整改落实)").assessmentContents("对总包单位、监理单位及监管部门提出的质量安全问题，整改及时、闭环有效，无逾期未整改情况").fraction("5").build(),
      ReviewTemplateDTO.builder().assessmentProject("综合管理-(配合协调)").assessmentContents("服从总包单位、监理单位管理，沟通顺畅，积极配合现场检查、验收等工作，无推诿扯皮现象").fraction("4").build(),
      ReviewTemplateDTO.builder().assessmentProject("综合管理-(资料管理)").assessmentContents("施工日志、劳务资料、报验资料、质量安全资料完整、真实、及时，符合建筑工程资料管理规范").fraction("3").build(),
      ReviewTemplateDTO.builder().assessmentProject("综合管理-(成本控制)").assessmentContents("无违规签证、超合同范围作业，成本管控合理，无恶意索赔、漫天要价等行为").fraction("3").build()
   );
   public static final List<ReviewTemplateDTO> LOGISTICS_OUTSOURCING_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(准时送达率)")
         .assessmentContents("99% 及以上得 15 分；95%-98% 得 10 分；90%-94% 得 5 分；低于 90% 得 0 分")
         .remarks("以月度 / 季度统计数据为准")
         .fraction("15")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(订单完成率)")
         .assessmentContents("100% 得 10 分；95%-99% 得 7 分；90%-94% 得 3 分；低于 90% 得 0 分")
         .remarks("未完成订单需说明合理原因")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(应急响应速度)")
         .assessmentContents("2 小时内响应得 5 分；2-4 小时响应得 3 分；4 小时以上响应得 0 分")
         .remarks("针对突发物流问题（如延误、破损）")
         .fraction("5")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务质量-(货物完好率)")
         .assessmentContents("99.5% 及以上得 10 分；99%-99.4% 得 7 分；98%-98.9% 得 3 分；低于 98% 得 0 分")
         .remarks("统计破损、丢失、污染等情况")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务质量-(物流信息反馈)")
         .assessmentContents("实时同步物流轨迹得 8 分；每日更新得 5 分；需主动询问得 2 分；不反馈得 0 分")
         .remarks("含发货通知、在途状态、到货提醒")
         .fraction("8")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("服务质量-(投诉处理效率)")
         .assessmentContents("3 日内解决并反馈得 7 分；3-5 日解决得 4 分；5 日以上解决得 1 分；未解决得 0 分")
         .remarks("以投诉闭环时间为准")
         .fraction("7")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("成本合理性-(报价竞争力)")
         .assessmentContents("低于行业平均价得 10 分；与行业平均价持平得 7 分；高于行业平均价 5% 以内得 3 分；高于 5% 得 0 分")
         .remarks("对比同期同线路市场报价")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("成本合理性-(费用透明度)")
         .assessmentContents("无隐性收费、明细清晰得 10 分；有少量隐性收费但可解释得 5 分；隐性收费较多得 0 分")
         .remarks("含运输费、装卸费、保险费等")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("合作合规性-(资质齐全度)")
         .assessmentContents("营业执照、道路运输许可证等齐全有效得 8 分；缺少非核心资质得 4 分；核心资质缺失得 0 分")
         .remarks("需提供资质复印件备案")
         .fraction("8")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("合作合规性-(合同履约率)")
         .assessmentContents("100% 按合同条款执行得 7 分；90%-99% 履约得 4 分；低于 90% 得 0 分")
         .remarks("含运输时效、责任划分等条款")
         .fraction("7")
         .build()
   );
   public static final List<ReviewTemplateDTO> OUTSOURCING_TEMPLATE = Arrays.asList(
      ReviewTemplateDTO.builder()
         .assessmentProject("产品质量-(合格率)")
         .assessmentContents("99.5% 及以上得 15 分；99%-99.4% 得 10 分；98%-98.9% 得 5 分；低于 98% 得 0 分")
         .remarks("按抽样检测 / 全检数据统计")
         .fraction("15")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("产品质量-(工艺符合性)")
         .assessmentContents("100% 符合技术图纸要求得 10 分；95%-99% 符合得 7 分；90%-94% 符合得 3 分；低于 90% 得 0 分")
         .remarks("含尺寸精度、表面处理、材质要求")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("产品质量-(质量稳定性)")
         .assessmentContents("月度合格率波动≤1% 得 10 分；波动 1%-3% 得 6 分；波动＞3% 得 0 分")
         .remarks("统计月度质量数据波动情况")
         .fraction("10")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(准时交付率)")
         .assessmentContents("99% 及以上得 12 分；95%-98% 得 8 分；90%-94% 得 4 分；低于 90% 得 0 分")
         .remarks("以约定交付日期为准，不含合理延期")
         .fraction("12")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(交付批量准确性)")
         .assessmentContents("100% 按订单数量交付得 8 分；98%-99% 准确得 5 分；95%-97% 准确得 2 分；低于 95% 得 0 分")
         .remarks("不含合理损耗范围内的差异")
         .fraction("8")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("交付能力-(交付配套性)")
         .assessmentContents("随货附带质检报告、合格证等齐全得 5 分；缺少部分文件得 2 分；无任何文件得 0 分")
         .remarks("按采购要求提供相关证明材料")
         .fraction("5")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("成本与报价-(报价合理性)")
         .assessmentContents("报价低于行业平均水平得 8 分；与行业持平得 5 分；高于 5% 以内得 2 分；高于 5% 得 0 分")
         .remarks("对比同类加工产品市场报价")
         .fraction("8")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("成本与报价-(成本控制能力)")
         .assessmentContents("年度报价涨幅≤3% 得 7 分；3%-5% 得 4 分；高于 5% 得 0 分")
         .remarks("需提供合理涨价依据")
         .fraction("7")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("合作配合度-(订单响应速度)")
         .assessmentContents("24 小时内确认订单得 5 分；24-48 小时得 3 分；超过 48 小时得 0 分")
         .remarks("含订单确认、产能反馈")
         .fraction("5")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("合作配合度-(沟通协作效率)")
         .assessmentContents("询、主动同步生产进度得 5 分；需多次催促得 2 分；不配合得 0 分")
         .remarks("含技术对接、异常情况沟通")
         .fraction("5")
         .build(),
      ReviewTemplateDTO.builder()
         .assessmentProject("合作配合度-(柔性生产能力)")
         .assessmentContents("能满足小批量定制、紧急订单得 5 分；部分满足得 3 分；无法满足得 0 分")
         .remarks("按实际合作案例评估")
         .fraction("5")
         .build()
   );
}
