import { ref as E } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as i } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as F } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as v } from "vue";
import { isRef as ve } from "vue";
import { ElMessageBox as Te } from "element-plus";
import { ElMessage as Ee } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { ElFormItem as _e } from "element-plus";
import { ElDatePicker as we } from "element-plus";
import { ElForm as Be } from "element-plus";
import { ElDescriptionsItem as Ie } from "element-plus";
import { ElInput as De } from "element-plus";
import { ElDescriptions as Re } from "element-plus";
import { u as Me } from "../../../../../modules/user-template-config-16e71de8.js";
import { g as he } from "../../../../../modules/bid-list-077bf24b.js";
import { _ as Ve, u as ke, dA as Y, lq as O, lF as Fe, dK as $, dE as K, lu as z, G as L, L as Se, lw as je, p as Ne, dw as Oe, R as X, S as Z, ly as ee } from "../../../../../shared/runtime.js";
import { u as Pe } from "../../../../../modules/use-crm-project-information-18afe991.js";
import { u as Ce } from "../../../../../modules/use-form-config-data-098a0552.js";
import Le from "../../../components/information-description/index.vue.js";
import { _ as Ue } from "../../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../../modules/project-information-053c195b.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const xe = { key: 1, class: "single-line-ellipsis" }, qe = { key: 1, style: { display: "inline-block", width: "220px" } }, Ae = { key: 1, style: { display: "inline-block", width: "200px" } }, ze = { key: 1 }, He = { key: 1 }, Je = { key: 1 }, Ge = { key: 1 }, Qe = { key: 1, style: { "margin-bottom": "10px" } }, We = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, tenderType: { type: Number, default: void 0 }, crmSpecialBubmissionStatusEnum: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(T, { emit: ae }) {
  const r = T, H = ae, { visible: U, handleClose: J } = ke({ emit: H, props: r, showHook: re, closeHook: se }), { projectInformationMap: G } = Pe(), Q = E([]), l = E({ projectBidManagerUserIdList: [], projectBidManagerFinishDate: void 0, difficultyFactorId: void 0, crmProjectInformationWarehousingId: void 0, crmTenderRequirementTypeEnum: void 0 }), R = E(), x = E(false), M = E({}), j = E(), c = E({ technologyBidManagerJobDescriptionId: void 0, contactPerson: void 0, visualizationQuantity: void 0, technologyBidManagerRemarks: void 0 }), u = E(false), b = E({}), te = { projectBidManagerUserIdList: [{ required: true, message: "请选择负责人", trigger: "change" }], projectBidManagerFinishDate: [{ required: true, message: "请选择完成日期", trigger: "change" }], difficultyFactorId: [{ required: true, message: "请选择难度系数", trigger: "change" }] }, ne = { technologyBidManagerJobDescriptionId: [{ required: true, message: "请选择工作内容", trigger: "change" }] }, { fetchFormItemList: le, fetchFormDetail: oe, formItemList: W, serchFormDetail: f, chargePersonalDatail: h, fetchUserChargeDetail: ie } = Ce();
  async function re() {
    var t, e;
    u.value = false, h.value = {}, (t = R.value) == null || t.clearValidate(), await ue(), await me(), await de(), await ce(), await q(), Q.value = ((e = M.value) == null ? void 0 : e.userSimpleInfoDTOS) || [];
  }
  async function se() {
    var t, e, d, y;
    await ((t = R.value) == null ? void 0 : t.resetFields()), await ((e = R.value) == null ? void 0 : e.clearValidate()), await ((d = j.value) == null ? void 0 : d.resetFields()), await ((y = j.value) == null ? void 0 : y.clearValidate());
  }
  async function ue() {
    var t, e, d;
    try {
      await oe({ pageEnum: Y.APPLICATION_TENDER.V, params: r.currentRow, tenderType: (t = r.currentRow) == null ? void 0 : t.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = r.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === O.SETTLEMENT_METHOD.V ? (d = r.currentRow) == null ? void 0 : d.crmSpecialBubmissionStatusEnum : void 0, crmSettlementBusinessTypeEnum: Fe.NON_DIRECT.V, crmApplyTechnologyBiddingRecordId: r.currentRow?.crmApplyTechnologyBiddingRecordId }), console.log(f.value, "serchFormDetail"), c.value.technologyBidManagerJobDescriptionId = f.value.technologyBidManagerJobDescriptionId || void 0, c.value.contactPerson = f.value.contactPerson || void 0, c.value.visualizationQuantity = f.value.visualizationQuantity || void 0, c.value.technologyBidManagerRemarks = f.value.technologyBidManagerRemarks || void 0;
    } catch (y) {
      console.log(y);
    }
  }
  async function q() {
    var t, e, d, y, B, m, I, V, N, g, k;
    try {
      await ie({ params: r.currentRow, tenderType: (t = r.currentRow) == null ? void 0 : t.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = r.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === O.SETTLEMENT_METHOD.V ? (d = r.currentRow) == null ? void 0 : d.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: r.currentRow?.crmApplyTechnologyBiddingRecordId }), console.log(h.value, "chargePersonalDatail"), M.value && M.value.crmPersonOperateTypeEnum === $.ROUTINE_OPERATIONS.V ? (l.value.projectBidManagerUserIdList = ((y = h.value) == null ? void 0 : y.projectBidManagerUserIdList) || [], l.value.projectBidManagerUserNameList = ((B = h.value) == null ? void 0 : B.projectBidManagerUserName) || void 0) : (l.value.projectBidManagerUserIdList = ((I = (m = M.value) == null ? void 0 : m.userSimpleInfoDTOS) == null ? void 0 : I.map((_) => _.userId)) || [], l.value.projectBidManagerUserNameList = ((V = h.value) == null ? void 0 : V.projectBidManagerUserName) || void 0), l.value.projectBidManagerFinishDate = h.value.projectBidManagerFinishDate || void 0, l.value.difficultyFactorId = h.value.difficultyFactorId || void 0, l.value.difficultyFactorName = (k = (g = (N = G.value[K.DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : N.crmProjectInformationConfigDTOS) == null ? void 0 : g.find((_) => _.id === l.value.difficultyFactorId)) == null ? void 0 : k.name;
    } catch (_) {
      console.log(_);
    }
  }
  async function de() {
    try {
      await le({ pageEnum: Y.APPLICATION_TENDER.V }), console.log(W.value);
    } catch (t) {
      console.log(t);
    }
  }
  async function ce() {
    var t;
    try {
      const e = await Me({ crmPersonTemplateEnum: (t = r.currentRow) == null ? void 0 : t.crmTenderRequirementTypeEnum });
      M.value = e || {};
    } catch (e) {
      console.log(e, "获取人员模板配置详情失败");
    }
  }
  async function me() {
    var t;
    if (r.tenderType === z.BIDDING_METHOD.V) try {
      const e = await he({ crmTenderRequirementTypeEnum: z.BIDDING_METHOD.V, id: (t = r.currentRow) == null ? void 0 : t.id });
      b.value = e || {};
    } catch (e) {
      console.log(e, "获取投标报价字段回显失败");
    }
  }
  async function pe() {
    R.value.validate(async (t) => {
      var d, y, B, m, I;
      if (!(!(((d = r.currentRow) == null ? void 0 : d.crmTenderRequirementTypeEnum) !== O.SETTLEMENT_METHOD.V || await ((y = j.value) == null ? void 0 : y.validate())) || !t)) try {
        x.value = true, await Te.confirm("是否确认当前选择的配置？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), l.value.crmProjectInformationWarehousingId = r.currentRow.id, l.value.crmTenderRequirementTypeEnum = (B = r.currentRow) == null ? void 0 : B.crmTenderRequirementTypeEnum, ((m = r.currentRow) == null ? void 0 : m.crmTenderRequirementTypeEnum) === O.SETTLEMENT_METHOD.V ? await ee({ ...l.value, crmApplyTechnologyBiddingRecordId: r.currentRow?.crmApplyTechnologyBiddingRecordId, crmSpecialBubmissionStatusEnum: (I = r.currentRow) == null ? void 0 : I.crmSpecialBubmissionStatusEnum, ...c.value }) : await ee({ ...l.value, crmApplyTechnologyBiddingRecordId: r.currentRow?.crmApplyTechnologyBiddingRecordId }), Ee.success("设置成功"), H("success"), J();
      } catch (V) {
        console.log(V, "设置失败");
      } finally {
        x.value = false;
      }
    });
  }
  async function fe() {
    u.value = false, await q();
  }
  async function ye() {
    var t, e;
    u.value = true, await ((t = R.value) == null ? void 0 : t.clearValidate()), await ((e = j.value) == null ? void 0 : e.clearValidate()), await q();
  }
  return (t, e) => {
    const d = P("common-button"), y = P("common-select-v2"), B = be, m = _e, I = we, V = P("common-select"), N = Be, g = Ie, k = De, _ = Re, ge = P("common-drawer");
    return i(), p(ge, { modelValue: n(U), "onUpdate:modelValue": e[9] || (e[9] = (D) => ve(U) ? U.value = D : null), "before-close": n(J), "close-on-click-modal": false, size: "100%", title: "非直营业务详情" }, { titleAfter: a(() => e[10] || (e[10] = [])), titleRight: a(() => {
      var D;
      return [n(L)(T.permission.save) && !u.value ? (i(), p(d, { key: 0, type: "primary", onClick: ye }, { default: a(() => e[11] || (e[11] = [C(" 编辑 ")])), _: 1, __: [11] })) : F("", true), n(L)(T.permission.save) && u.value ? (i(), p(d, { key: 1, type: "warning", onClick: fe }, { default: a(() => e[12] || (e[12] = [C(" 取消编辑 ")])), _: 1, __: [12] })) : F("", true), n(L)(T.permission.save) ? (i(), p(d, { key: 2, type: "success", disabled: !u.value, loading: x.value, onClick: pe }, { default: a(() => e[13] || (e[13] = [C(" 保存 ")])), _: 1, __: [13] }, 8, ["disabled", "loading"])) : F("", true), n(L)(T.permission.export) ? (i(), p(Se, { key: 3, fn: n(je), params: { id: r.currentRow.id, crmTenderRequirementTypeEnum: (D = r.currentRow) == null ? void 0 : D.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: T.crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum: Fe.NON_DIRECT.V, crmApplyTechnologyBiddingRecordId: r.currentRow.crmApplyTechnologyBiddingRecordId }, size: "default" }, { default: a(() => e[14] || (e[14] = [C(" 下载 ")])), _: 1, __: [14] }, 8, ["fn", "params"])) : F("", true)];
    }), content: a(() => {
      var D;
      return [o(N, { ref_key: "formRef", ref: R, "label-position": "left", model: l.value, inline: "", rules: te, style: { "margin-bottom": "30px" } }, { default: a(() => [o(m, { label: u.value ? "选择负责人：" : "当前负责人：", prop: "projectBidManagerUserIdList" }, { default: a(() => {
        var s;
        return [u.value ? (i(), p(y, { key: 0, modelValue: l.value.projectBidManagerUserIdList, "onUpdate:modelValue": e[0] || (e[0] = (A) => l.value.projectBidManagerUserIdList = A), options: Q.value, filterable: "", clearable: "", multiple: "", "collapse-tags-tooltip": "", "collapse-tags": "", "max-collapse-tags": 2, dataStructure: { value: "userId", label: "userName", key: "userId" }, type: "other", class: "input-underline", placeholder: "请选择负责人", disabled: ((s = M.value) == null ? void 0 : s.crmPersonOperateTypeEnum) === n($).NOT_MODIFIABLE.V, style: { "margin-right": "10px", width: "360px" } }, null, 8, ["modelValue", "options", "disabled"])) : (i(), w("div", xe, [o(B, { effect: "light", content: `${l.value.projectBidManagerUserNameList}`, placement: "top" }, { default: a(() => [S("span", null, v(l.value.projectBidManagerUserNameList), 1)]), _: 1 }, 8, ["content"])]))];
      }), _: 1 }, 8, ["label"]), o(m, { label: u.value ? "选择完成日期：" : "当前完成日期：", prop: "projectBidManagerFinishDate" }, { default: a(() => [u.value ? (i(), p(I, { key: 0, placeholder: "请选择完成日期", style: { "margin-right": "10px" }, clearable: "", class: "input-underline", modelValue: l.value.projectBidManagerFinishDate, "onUpdate:modelValue": e[1] || (e[1] = (s) => l.value.projectBidManagerFinishDate = s), "value-format": "x" }, null, 8, ["modelValue"])) : (i(), w("span", qe, v(n(Ne)(l.value.projectBidManagerFinishDate, "{y}-{m}-{d}")), 1))]), _: 1 }, 8, ["label"]), o(m, { label: u.value ? "选择难度系数：" : "当前难度系数：", prop: "difficultyFactorId" }, { default: a(() => {
        var s;
        return [u.value ? (i(), p(V, { key: 0, placeholder: "请选择难度系数", clearable: "", class: "input-underline", modelValue: l.value.difficultyFactorId, "onUpdate:modelValue": e[2] || (e[2] = (A) => l.value.difficultyFactorId = A), options: (s = n(G)[n(K).DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : s.crmProjectInformationConfigDTOS }, null, 8, ["modelValue", "options"])) : (i(), w("span", Ae, v(l.value.difficultyFactorName), 1))];
      }), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["model"]), ((D = T.currentRow) == null ? void 0 : D.crmTenderRequirementTypeEnum) === n(O).SETTLEMENT_METHOD.V ? (i(), p(N, { key: 0, ref_key: "newFormRef", ref: j, model: c.value, rules: ne, "label-position": "right", style: { "margin-bottom": "15px" }, size: "default" }, { default: a(() => [o(_, { column: 2, border: "" }, { default: a(() => [o(g, { label: "工作内容", "label-class-name": "my-label" }, { default: a(() => [o(m, { label: "", prop: "technologyBidManagerJobDescriptionId" }, { default: a(() => [u.value ? (i(), p(Ue, { key: 0, modelValue: c.value.technologyBidManagerJobDescriptionId, "onUpdate:modelValue": e[3] || (e[3] = (s) => c.value.technologyBidManagerJobDescriptionId = s), crmTenderRequestConfigEnum: n(Oe).WORK_CONTENT_TYPE.V, crmSpecialBubmissionStatusEnum: T.currentRow.crmSpecialBubmissionStatusEnum, clearable: "", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "crmTenderRequestConfigEnum", "crmSpecialBubmissionStatusEnum"])) : (i(), w("span", ze, v(n(f).technologyBidManagerJobDescriptionName), 1))]), _: 1 })]), _: 1 }), o(g, { label: "对接人" }, { default: a(() => [o(m, { label: "", prop: "contactPerson" }, { default: a(() => [u.value ? (i(), p(k, { key: 0, modelValue: c.value.contactPerson, "onUpdate:modelValue": e[4] || (e[4] = (s) => c.value.contactPerson = s), type: "text", maxlength: "15", placeholder: "填写对接人", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (i(), w("span", He, v(n(f).contactPerson), 1))]), _: 1 })]), _: 1 }), o(g, { label: "可视化数量" }, { default: a(() => [o(m, { label: "", prop: "visualizationQuantity" }, { default: a(() => [u.value ? (i(), p(k, { key: 0, modelValue: c.value.visualizationQuantity, "onUpdate:modelValue": e[5] || (e[5] = (s) => c.value.visualizationQuantity = s), type: "number", min: 1, max: 999999999, placeholder: "填写可视化数量", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (i(), w("span", Je, v(n(f).visualizationQuantity), 1))]), _: 1 })]), _: 1 }), o(g, { label: "备注" }, { default: a(() => [o(m, { label: "", prop: "technologyBidManagerRemarks" }, { default: a(() => [u.value ? (i(), p(k, { key: 0, modelValue: c.value.technologyBidManagerRemarks, "onUpdate:modelValue": e[6] || (e[6] = (s) => c.value.technologyBidManagerRemarks = s), type: "text", maxlength: "15", placeholder: "填写备注", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (i(), w("span", Ge, v(n(f).technologyBidManagerRemarks), 1))]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])) : F("", true), T.tenderType === n(z).BIDDING_METHOD.V ? (i(), w("div", Qe, [o(_, { column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: a(() => [o(g, { label: "投标报价(万元)" }, { default: a(() => [S("span", null, v(b.value.businessProjectBidManagerQuote), 1)]), _: 1 }), o(g, { label: "工程量(吨)" }, { default: a(() => [S("span", null, v(b.value.businessProjectBidManagerEstimatedWorks), 1)]), _: 1 }), o(g, { label: "成本(万元)" }, { default: a(() => [S("span", null, v(b.value.businessProjectBidManagerCost), 1)]), _: 1 }), o(g, { label: "毛利(%)" }, { default: a(() => [S("span", null, v(b.value.businessProjectBidManagerGrossProfit), 1)]), _: 1 }), o(g, { label: "备注", span: 2 }, { default: a(() => [S("span", null, v(b.value.businessProjectBidManagerRemark), 1)]), _: 1 })]), _: 1 })])) : F("", true), o(X, { showView: "", "show-download": "", files: h.value.bidManagerAttachments, "onUpdate:files": e[7] || (e[7] = (s) => h.value.bidManagerAttachments = s), "file-classify": n(Z).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"]), o(n(Le), { "descriptions-list": n(W), "form-detail": n(f), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), o(X, { showView: "", "show-download": "", files: n(f).attachmentDTOList, "onUpdate:files": e[8] || (e[8] = (s) => n(f).attachmentDTOList = s), "file-classify": n(Z).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, oa = Ve(We, [["__scopeId", "data-v-71b90305"]]);
export {
  oa as default
};
