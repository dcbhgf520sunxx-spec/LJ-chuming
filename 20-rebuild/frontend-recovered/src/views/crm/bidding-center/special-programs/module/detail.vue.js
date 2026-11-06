import { ref as b } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as r } from "vue";
import { createBlock as y } from "vue";
import { withCtx as a } from "vue";
import { unref as l } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as j } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as ve } from "vue";
import { ElMessageBox as Te } from "element-plus";
import { ElMessage as Ee } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { ElFormItem as _e } from "element-plus";
import { ElDatePicker as Re } from "element-plus";
import { ElForm as we } from "element-plus";
import { ElDescriptionsItem as Be } from "element-plus";
import { ElInput as Ie } from "element-plus";
import { ElDescriptions as he } from "element-plus";
import { u as De } from "../../../../../modules/user-template-config-16e71de8.js";
import { g as Me } from "../../../../../modules/bid-list-077bf24b.js";
import { _ as Ve, u as ke, dA as $, lq as P, lF as Fe, dK as K, dE as X, lu as H, G as U, L as Se, lw as je, p as Oe, dw as Ne, R as Z, S as ee, ly as ae } from "../../../../../shared/runtime.js";
import { u as Pe } from "../../../../../modules/use-crm-project-information-18afe991.js";
import { u as Ce } from "../../../../../modules/use-form-config-data-098a0552.js";
import Le from "../../../components/information-description/index.vue.js";
import { _ as Ue } from "../../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../../modules/project-information-053c195b.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const xe = { key: 1, class: "single-line-ellipsis" }, qe = { key: 1, style: { display: "inline-block", width: "220px" } }, Ae = { key: 1, style: { display: "inline-block", width: "200px" } }, ze = { style: { display: "inline-block" } }, He = { key: 1 }, Je = { key: 1 }, Ge = { key: 1 }, Qe = { key: 1 }, We = { key: 1, style: { "margin-bottom": "10px" } }, Ye = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, tenderType: { type: Number, default: void 0 }, crmSpecialBubmissionStatusEnum: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(T, { emit: te }) {
  const i = T, J = te, { visible: x, handleClose: G } = ke({ emit: J, props: i, showHook: se, closeHook: ue }), { projectInformationMap: Q } = Pe(), W = b([]), t = b({ projectBidManagerUserIdList: [], projectBidManagerFinishDate: void 0, difficultyFactorId: void 0, crmProjectInformationWarehousingId: void 0, crmTenderRequirementTypeEnum: void 0 }), k = b(), q = b(false), F = b({}), O = b(), c = b({ technologyBidManagerJobDescriptionId: void 0, contactPerson: void 0, visualizationQuantity: void 0, technologyBidManagerRemarks: void 0 }), u = b(false), _ = b({}), ne = { projectBidManagerUserIdList: [{ required: true, message: "请选择负责人", trigger: "change" }], projectBidManagerFinishDate: [{ required: true, message: "请选择完成日期", trigger: "change" }], difficultyFactorId: [{ required: true, message: "请选择难度系数", trigger: "change" }] }, le = { technologyBidManagerJobDescriptionId: [{ required: true, message: "请选择工作内容", trigger: "change" }] }, { fetchFormItemList: oe, fetchFormDetail: ie, formItemList: Y, serchFormDetail: v, chargePersonalDatail: B, fetchUserChargeDetail: re } = Ce();
  async function se() {
    var n, e;
    u.value = false, B.value = {}, (n = k.value) == null || n.clearValidate(), await de(), await pe(), await ce(), await me(), await A(), W.value = ((e = F.value) == null ? void 0 : e.userSimpleInfoDTOS) || [];
  }
  async function ue() {
    var n, e, d, f;
    await ((n = k.value) == null ? void 0 : n.resetFields()), await ((e = k.value) == null ? void 0 : e.clearValidate()), await ((d = O.value) == null ? void 0 : d.resetFields()), await ((f = O.value) == null ? void 0 : f.clearValidate());
  }
  async function de() {
    var n, e, d, f;
    try {
      await ie({ pageEnum: $.APPLICATION_TENDER.V, params: i.currentRow, tenderType: (n = i.currentRow) == null ? void 0 : n.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = i.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === P.SETTLEMENT_METHOD.V ? (d = i.currentRow) == null ? void 0 : d.crmSpecialBubmissionStatusEnum : void 0, crmSettlementBusinessTypeEnum: Fe.DIRECT.V, crmApplyTechnologyBiddingRecordId: (f = i.currentRow) == null ? void 0 : f.crmApplyTechnologyBiddingRecordId }), console.log(v.value, "serchFormDetail"), c.value.technologyBidManagerJobDescriptionId = v.value.technologyBidManagerJobDescriptionId || void 0, c.value.contactPerson = v.value.contactPerson || void 0, c.value.visualizationQuantity = v.value.visualizationQuantity || void 0, c.value.technologyBidManagerRemarks = v.value.technologyBidManagerRemarks || void 0;
    } catch (E) {
      console.log(E);
    }
  }
  async function A() {
    var n, e, d, f, E, m, I, h, R, p, S, N;
    try {
      await re({ params: i.currentRow, tenderType: (n = i.currentRow) == null ? void 0 : n.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = i.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === P.SETTLEMENT_METHOD.V ? (d = i.currentRow) == null ? void 0 : d.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: (f = i.currentRow) == null ? void 0 : f.crmApplyTechnologyBiddingRecordId }), console.log(B.value, "chargePersonalDatail"), F.value && F.value.crmPersonOperateTypeEnum === K.ROUTINE_OPERATIONS.V ? (t.value.projectBidManagerUserIdList = ((E = B.value) == null ? void 0 : E.projectBidManagerUserIdList) || [], t.value.projectBidManagerUserNameList = ((m = B.value) == null ? void 0 : m.projectBidManagerUserName) || void 0) : (t.value.projectBidManagerUserIdList = ((h = (I = F.value) == null ? void 0 : I.userSimpleInfoDTOS) == null ? void 0 : h.map((D) => D.userId)) || [], t.value.projectBidManagerUserNameList = ((R = B.value) == null ? void 0 : R.projectBidManagerUserName) || void 0), t.value.businessEssentials = B.value.businessEssentials || void 0, t.value.projectBidManagerFinishDate = B.value.projectBidManagerFinishDate || void 0, t.value.difficultyFactorId = B.value.difficultyFactorId || void 0, t.value.difficultyFactorName = (N = (S = (p = Q.value[X.DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : p.crmProjectInformationConfigDTOS) == null ? void 0 : S.find((D) => D.id === t.value.difficultyFactorId)) == null ? void 0 : N.name;
    } catch (D) {
      console.log(D);
    }
  }
  async function ce() {
    try {
      await oe({ pageEnum: $.APPLICATION_TENDER.V }), console.log(Y.value);
    } catch (n) {
      console.log(n);
    }
  }
  async function me() {
    var n;
    try {
      const e = await De({ crmPersonTemplateEnum: (n = i.currentRow) == null ? void 0 : n.crmTenderRequirementTypeEnum });
      F.value = e || {};
    } catch (e) {
      console.log(e, "获取人员模板配置详情失败");
    }
  }
  async function pe() {
    var n;
    if (i.tenderType === H.BIDDING_METHOD.V) try {
      const e = await Me({ crmTenderRequirementTypeEnum: H.BIDDING_METHOD.V, id: (n = i.currentRow) == null ? void 0 : n.id });
      _.value = e || {};
    } catch (e) {
      console.log(e, "获取投标报价字段回显失败");
    }
  }
  async function fe() {
    k.value.validate(async (n) => {
      var d, f, E, m, I, h, R;
      if (!(!(((d = i.currentRow) == null ? void 0 : d.crmTenderRequirementTypeEnum) !== P.SETTLEMENT_METHOD.V || await ((f = O.value) == null ? void 0 : f.validate())) || !n)) try {
        q.value = true, await Te.confirm("是否确认当前选择的配置？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), t.value.crmProjectInformationWarehousingId = i.currentRow.id, t.value.crmTenderRequirementTypeEnum = (E = i.currentRow) == null ? void 0 : E.crmTenderRequirementTypeEnum, ((m = i.currentRow) == null ? void 0 : m.crmTenderRequirementTypeEnum) === P.SETTLEMENT_METHOD.V ? await ae({ ...t.value, crmSpecialBubmissionStatusEnum: (I = i.currentRow) == null ? void 0 : I.crmSpecialBubmissionStatusEnum, crmApplyTechnologyBiddingRecordId: (h = i.currentRow) == null ? void 0 : h.crmApplyTechnologyBiddingRecordId, ...c.value }) : await ae({ ...t.value, crmApplyTechnologyBiddingRecordId: (R = i.currentRow) == null ? void 0 : R.crmApplyTechnologyBiddingRecordId }), Ee.success("设置成功"), J("success"), G();
      } catch (p) {
        console.log(p, "设置失败");
      } finally {
        q.value = false;
      }
    });
  }
  async function ye() {
    u.value = false, await A();
  }
  async function ge() {
    var n, e;
    u.value = true, await ((n = k.value) == null ? void 0 : n.clearValidate()), await ((e = O.value) == null ? void 0 : e.clearValidate()), await A();
  }
  return (n, e) => {
    const d = C("common-button"), f = C("common-select-v2"), E = be, m = _e, I = Re, h = C("common-select"), R = we, p = Be, S = Ie, N = he, D = C("common-drawer");
    return r(), y(D, { modelValue: l(x), "onUpdate:modelValue": e[9] || (e[9] = (M) => ve(x) ? x.value = M : null), "before-close": l(G), "close-on-click-modal": false, size: "100%", title: "直营业务详情" }, { titleAfter: a(() => e[10] || (e[10] = [])), titleRight: a(() => {
      var M;
      return [l(U)(T.permission.save) && !u.value ? (r(), y(d, { key: 0, type: "primary", onClick: ge }, { default: a(() => e[11] || (e[11] = [L(" 编辑 ")])), _: 1, __: [11] })) : j("", true), l(U)(T.permission.save) && u.value ? (r(), y(d, { key: 1, type: "warning", onClick: ye }, { default: a(() => e[12] || (e[12] = [L(" 取消编辑 ")])), _: 1, __: [12] })) : j("", true), l(U)(T.permission.save) ? (r(), y(d, { key: 2, type: "success", disabled: !u.value, loading: q.value, onClick: fe }, { default: a(() => e[13] || (e[13] = [L(" 保存 ")])), _: 1, __: [13] }, 8, ["disabled", "loading"])) : j("", true), l(U)(T.permission.export) ? (r(), y(Se, { key: 3, fn: l(je), params: { id: i.currentRow.id, crmTenderRequirementTypeEnum: (M = i.currentRow) == null ? void 0 : M.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: T.crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum: Fe.DIRECT.V, crmApplyTechnologyBiddingRecordId: i.currentRow.crmApplyTechnologyBiddingRecordId }, size: "default" }, { default: a(() => e[14] || (e[14] = [L(" 下载 ")])), _: 1, __: [14] }, 8, ["fn", "params"])) : j("", true)];
    }), content: a(() => {
      var M;
      return [o(R, { ref_key: "formRef", ref: k, "label-position": "left", model: t.value, inline: "", rules: ne, style: { "margin-bottom": "30px" } }, { default: a(() => [o(m, { label: u.value ? "选择负责人：" : "当前负责人：", prop: "projectBidManagerUserIdList" }, { default: a(() => {
        var s;
        return [u.value ? (r(), y(f, { key: 0, modelValue: t.value.projectBidManagerUserIdList, "onUpdate:modelValue": e[0] || (e[0] = (z) => t.value.projectBidManagerUserIdList = z), options: W.value, filterable: "", clearable: "", multiple: "", "collapse-tags-tooltip": "", "collapse-tags": "", "max-collapse-tags": 2, dataStructure: { value: "userId", label: "userName", key: "userId" }, type: "other", class: "input-underline", placeholder: "请选择负责人", disabled: ((s = F.value) == null ? void 0 : s.crmPersonOperateTypeEnum) === l(K).NOT_MODIFIABLE.V, style: { "margin-right": "10px", width: "360px" } }, null, 8, ["modelValue", "options", "disabled"])) : (r(), w("div", xe, [o(E, { effect: "light", content: `${t.value.projectBidManagerUserNameList}`, placement: "top" }, { default: a(() => [V("span", null, g(t.value.projectBidManagerUserNameList), 1)]), _: 1 }, 8, ["content"])]))];
      }), _: 1 }, 8, ["label"]), o(m, { label: u.value ? "选择完成日期：" : "当前完成日期：", prop: "projectBidManagerFinishDate" }, { default: a(() => [u.value ? (r(), y(I, { key: 0, placeholder: "请选择完成日期", style: { "margin-right": "10px" }, clearable: "", class: "input-underline", modelValue: t.value.projectBidManagerFinishDate, "onUpdate:modelValue": e[1] || (e[1] = (s) => t.value.projectBidManagerFinishDate = s), "value-format": "x" }, null, 8, ["modelValue"])) : (r(), w("span", qe, g(l(Oe)(t.value.projectBidManagerFinishDate, "{y}-{m}-{d}")), 1))]), _: 1 }, 8, ["label"]), o(m, { label: u.value ? "选择难度系数：" : "当前难度系数：", prop: "difficultyFactorId" }, { default: a(() => {
        var s;
        return [u.value ? (r(), y(h, { key: 0, placeholder: "请选择难度系数", clearable: "", class: "input-underline", modelValue: t.value.difficultyFactorId, "onUpdate:modelValue": e[2] || (e[2] = (z) => t.value.difficultyFactorId = z), options: (s = l(Q)[l(X).DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : s.crmProjectInformationConfigDTOS }, null, 8, ["modelValue", "options"])) : (r(), w("span", Ae, g(t.value.difficultyFactorName), 1))];
      }), _: 1 }, 8, ["label"]), o(m, { label: "业务要点：", prop: "businessEssentials", style: { width: "100%" } }, { default: a(() => [V("span", ze, g(t.value.businessEssentials || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["model"]), ((M = T.currentRow) == null ? void 0 : M.crmTenderRequirementTypeEnum) === l(P).SETTLEMENT_METHOD.V ? (r(), y(R, { key: 0, ref_key: "newFormRef", ref: O, model: c.value, rules: le, "label-position": "right", style: { "margin-bottom": "15px" }, size: "default" }, { default: a(() => [o(N, { column: 2, border: "" }, { default: a(() => [o(p, { label: "工作内容", "label-class-name": "my-label" }, { default: a(() => [o(m, { label: "", prop: "technologyBidManagerJobDescriptionId" }, { default: a(() => [u.value ? (r(), y(Ue, { key: 0, modelValue: c.value.technologyBidManagerJobDescriptionId, "onUpdate:modelValue": e[3] || (e[3] = (s) => c.value.technologyBidManagerJobDescriptionId = s), crmTenderRequestConfigEnum: l(Ne).WORK_CONTENT_TYPE.V, crmSpecialBubmissionStatusEnum: T.currentRow.crmSpecialBubmissionStatusEnum, clearable: "", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "crmTenderRequestConfigEnum", "crmSpecialBubmissionStatusEnum"])) : (r(), w("span", He, g(l(v).technologyBidManagerJobDescriptionName), 1))]), _: 1 })]), _: 1 }), o(p, { label: "对接人" }, { default: a(() => [o(m, { label: "", prop: "contactPerson" }, { default: a(() => [u.value ? (r(), y(S, { key: 0, modelValue: c.value.contactPerson, "onUpdate:modelValue": e[4] || (e[4] = (s) => c.value.contactPerson = s), type: "text", maxlength: "15", placeholder: "填写对接人", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (r(), w("span", Je, g(l(v).contactPerson), 1))]), _: 1 })]), _: 1 }), o(p, { label: "可视化数量" }, { default: a(() => [o(m, { label: "", prop: "visualizationQuantity" }, { default: a(() => [u.value ? (r(), y(S, { key: 0, modelValue: c.value.visualizationQuantity, "onUpdate:modelValue": e[5] || (e[5] = (s) => c.value.visualizationQuantity = s), type: "number", min: 1, max: 999999999, placeholder: "填写可视化数量", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (r(), w("span", Ge, g(l(v).visualizationQuantity), 1))]), _: 1 })]), _: 1 }), o(p, { label: "备注" }, { default: a(() => [o(m, { label: "", prop: "technologyBidManagerRemarks" }, { default: a(() => [u.value ? (r(), y(S, { key: 0, modelValue: c.value.technologyBidManagerRemarks, "onUpdate:modelValue": e[6] || (e[6] = (s) => c.value.technologyBidManagerRemarks = s), type: "text", maxlength: "15", placeholder: "填写备注", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (r(), w("span", Qe, g(l(v).technologyBidManagerRemarks), 1))]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])) : j("", true), T.tenderType === l(H).BIDDING_METHOD.V ? (r(), w("div", We, [o(N, { column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: a(() => [o(p, { label: "投标报价(万元)" }, { default: a(() => [V("span", null, g(_.value.businessProjectBidManagerQuote), 1)]), _: 1 }), o(p, { label: "工程量(吨)" }, { default: a(() => [V("span", null, g(_.value.businessProjectBidManagerEstimatedWorks), 1)]), _: 1 }), o(p, { label: "成本(万元)" }, { default: a(() => [V("span", null, g(_.value.businessProjectBidManagerCost), 1)]), _: 1 }), o(p, { label: "毛利(%)" }, { default: a(() => [V("span", null, g(_.value.businessProjectBidManagerGrossProfit), 1)]), _: 1 }), o(p, { label: "备注", span: 2 }, { default: a(() => [V("span", null, g(_.value.businessProjectBidManagerRemark), 1)]), _: 1 })]), _: 1 })])) : j("", true), o(Z, { showView: "", "show-download": "", files: B.value.bidManagerAttachments, "onUpdate:files": e[7] || (e[7] = (s) => B.value.bidManagerAttachments = s), "file-classify": l(ee).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"]), o(l(Le), { "descriptions-list": l(Y), "form-detail": l(v), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), o(Z, { showView: "", "show-download": "", files: l(v).attachmentDTOList, "onUpdate:files": e[8] || (e[8] = (s) => l(v).attachmentDTOList = s), "file-classify": l(ee).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ia = Ve(Ye, [["__scopeId", "data-v-7e267090"]]);
export {
  ia as default
};
