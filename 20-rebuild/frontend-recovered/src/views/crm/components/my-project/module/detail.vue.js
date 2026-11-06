import { ref as k } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as w } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { unref as a } from "vue";
import { createTextVNode as D } from "vue";
import { createCommentVNode as M } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as V } from "vue";
import J from "moment";
import { isRef as K } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTag as Z } from "element-plus";
import { ElDivider as $ } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElCol as ne } from "element-plus";
import { ElRow as te } from "element-plus";
import { ElForm as ae } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElInput as oe } from "element-plus";
import { _ as le, u as re, dA as x, lq as y, lv as C, G as ie, lF as ue, R as N, S as A, lL as de } from "../../../../../shared/runtime.js";
import { u as me } from "../../../../../modules/use-form-config-data-098a0552.js";
import ce from "../../information-description/index.vue.js";
import "../../../../../modules/project-information-053c195b.js";
const pe = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, tenderType: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(b, { emit: O }) {
  const s = b, I = O, L = k(), o = k({ businessProjectBidManagerQuote: void 0, businessProjectBidManagerEstimatedWorks: void 0, businessProjectBidManagerCost: void 0, businessProjectBidManagerGrossProfit: void 0, businessProjectBidManagerRemark: void 0 }), { visible: P, handleClose: h } = re({ emit: I, props: s, showHook: H }), { fetchFormItemList: F, fetchFormDetail: q, fetchUserChargeDetail: U, formItemList: S, serchFormDetail: d, chargePersonalDatail: c } = me();
  function H() {
    G(), W();
  }
  async function G() {
    var m, e, p, f, g, r, i, E, R, T;
    try {
      await q({ pageEnum: x.APPLICATION_TENDER.V, params: s.currentRow, tenderType: (m = s.currentRow) == null ? void 0 : m.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = s.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (p = s.currentRow) == null ? void 0 : p.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: ((f = s.currentRow) == null ? void 0 : f.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (g = s.currentRow) == null ? void 0 : g.crmApplyTechnologyBiddingRecordId : void 0 }), await U({ params: s.currentRow, tenderType: (r = s.currentRow) == null ? void 0 : r.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((i = s.currentRow) == null ? void 0 : i.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (E = s.currentRow) == null ? void 0 : E.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: ((R = s.currentRow) == null ? void 0 : R.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (T = s.currentRow) == null ? void 0 : T.crmApplyTechnologyBiddingRecordId : void 0 }), o.value.businessProjectBidManagerQuote = d.value.businessProjectBidManagerQuote || void 0, o.value.businessProjectBidManagerEstimatedWorks = d.value.businessProjectBidManagerEstimatedWorks || void 0, o.value.businessProjectBidManagerCost = d.value.businessProjectBidManagerCost || void 0, o.value.businessProjectBidManagerGrossProfit = d.value.businessProjectBidManagerGrossProfit || void 0, o.value.businessProjectBidManagerRemark = d.value.businessProjectBidManagerRemark || void 0;
    } catch (v) {
      console.log(v);
    }
  }
  async function W() {
    try {
      await F({ pageEnum: x.APPLICATION_TENDER.V }), console.log(S.value);
    } catch (m) {
      console.log(m);
    }
  }
  async function Q() {
    var m, e, p, f;
    try {
      await de({ attachmentDTOList: c.value.bidManagerAttachments, crmTenderRequirementTypeEnum: (m = s.currentRow) == null ? void 0 : m.crmTenderRequirementTypeEnum, crmProjectInformationWarehousingId: s.currentRow.id, crmSpecialBubmissionStatusEnum: ((e = s.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (p = s.currentRow) == null ? void 0 : p.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: (f = s.currentRow) == null ? void 0 : f.crmApplyTechnologyBiddingRecordId, ...o.value }), X.success("保存成功"), I("success"), h();
    } catch (g) {
      console.log(g);
    }
  }
  return (m, e) => {
    const p = Z, f = j("common-button"), g = $, r = ee, i = ne, E = te, R = ae, T = j("common-input-number"), v = se, Y = oe, z = j("common-drawer");
    return w(), B(z, { modelValue: a(P), "onUpdate:modelValue": e[7] || (e[7] = (u) => K(P) ? P.value = u : null), "close-on-click-modal": false, "before-close": a(h), size: "100%", title: "我的项目" }, { titleAfter: n(() => {
      var u;
      return [((u = b.currentRow) == null ? void 0 : u.crmProjectScheduleTypeEnum) === a(C).FINISH.V ? (w(), B(p, { key: 0, type: "danger", effect: "plain", style: { "margin-right": "15px" } }, { default: n(() => e[8] || (e[8] = [D(" 项目已终止 ")])), _: 1, __: [8] })) : M("", true)];
    }), titleRight: n(() => {
      var u;
      return [a(ie)(b.permission.save) ? (w(), B(f, { key: 0, disabled: ((u = b.currentRow) == null ? void 0 : u.crmProjectScheduleTypeEnum) === a(C).FINISH.V, type: "success", size: "default", onClick: Q }, { default: n(() => e[9] || (e[9] = [D("保存")])), _: 1, __: [9] }, 8, ["disabled"])) : M("", true)];
    }), content: n(() => {
      var u;
      return [t(g, null, { default: n(() => e[10] || (e[10] = [_("span", { class: "title" }, "项目负责人", -1)])), _: 1, __: [10] }), t(R, null, { default: n(() => {
        var l;
        return [t(E, { gutter: 20 }, { default: n(() => [t(i, { span: 8 }, { default: n(() => [t(r, { label: "负责人" }, { default: n(() => [_("span", null, V(a(c).projectBidManagerUserName || "-"), 1)]), _: 1 })]), _: 1 }), t(i, { span: 8 }, { default: n(() => [t(r, { label: "完成日期" }, { default: n(() => [_("span", null, V(a(J)(a(c).projectBidManagerFinishDate).format("YYYY-MM-DD")), 1)]), _: 1 })]), _: 1 }), t(i, { span: 8 }, { default: n(() => [t(r, { label: "难度系数" }, { default: n(() => [_("span", null, V(a(c).difficultyFactorName || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), ((l = b.currentRow) == null ? void 0 : l.crmSettlementBusinessTypeEnum) === a(ue).DIRECT.V ? (w(), B(E, { key: 0, gutter: 20 }, { default: n(() => [t(i, { span: 20 }, { default: n(() => [t(r, { label: "业务要点" }, { default: n(() => [_("span", null, V(a(c).businessEssentials || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 })) : M("", true)];
      }), _: 1 }), t(N, { showView: "", "show-download": "", delDisabled: true, files: a(c).bidManagerAttachments, "onUpdate:files": e[0] || (e[0] = (l) => a(c).bidManagerAttachments = l), "file-classify": a(A).RECORD_ATT.V }, null, 8, ["files", "file-classify"]), ((u = b.currentRow) == null ? void 0 : u.crmTenderRequirementTypeEnum) === a(y).BIDDING_METHOD.V ? (w(), B(R, { key: 0, ref_key: "formRef", ref: L, model: o.value, inline: "", "label-width": "120", "label-position": "right", size: "default", style: { "margin-top": "15px" } }, { default: n(() => [t(E, { gutter: 20 }, { default: n(() => [t(i, { span: 8 }, { default: n(() => [t(r, { label: "投标报价(万元)" }, { default: n(() => [t(T, { modelValue: o.value.businessProjectBidManagerQuote, "onUpdate:modelValue": e[1] || (e[1] = (l) => o.value.businessProjectBidManagerQuote = l), step: 0.01, min: 0.01, max: 999999999, precision: 2, controls: false, placeholder: "填写投标报价(万元)", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(i, { span: 8 }, { default: n(() => [t(r, { label: "工程量(吨)" }, { default: n(() => [t(T, { modelValue: o.value.businessProjectBidManagerEstimatedWorks, "onUpdate:modelValue": e[2] || (e[2] = (l) => o.value.businessProjectBidManagerEstimatedWorks = l), step: 0.01, min: 0.01, max: 999999999, precision: 2, controls: false, placeholder: "填写工程量(吨)", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(i, { span: 8 }, { default: n(() => [t(r, { label: "成本(万元)" }, { default: n(() => [t(T, { modelValue: o.value.businessProjectBidManagerCost, "onUpdate:modelValue": e[3] || (e[3] = (l) => o.value.businessProjectBidManagerCost = l), step: 0.01, min: 0.01, max: 999999999, precision: 2, controls: false, placeholder: "填写成本(万元)", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(i, { span: 8 }, { default: n(() => [t(r, { label: "毛利" }, { default: n(() => [t(v, { modelValue: o.value.businessProjectBidManagerGrossProfit, "onUpdate:modelValue": e[4] || (e[4] = (l) => o.value.businessProjectBidManagerGrossProfit = l), step: 0.01, min: 0.01, max: 999999999, precision: 2, controls: false, placeholder: "填写毛利", style: { width: "270px" } }, { suffix: n(() => e[11] || (e[11] = [D("%")])), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(i, { span: 16 }, { default: n(() => [t(r, { label: "备注" }, { default: n(() => [t(Y, { modelValue: o.value.businessProjectBidManagerRemark, "onUpdate:modelValue": e[5] || (e[5] = (l) => o.value.businessProjectBidManagerRemark = l), type: "text", maxlength: "25", placeholder: "填写备注", style: { width: "900px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])) : M("", true), t(g, null, { default: n(() => e[12] || (e[12] = [_("span", { class: "title" }, "投标信息", -1)])), _: 1, __: [12] }), t(a(ce), { "descriptions-list": a(S), "form-detail": a(d), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), t(N, { showView: "", "show-download": "", files: a(d).attachmentDTOList, "onUpdate:files": e[6] || (e[6] = (l) => a(d).attachmentDTOList = l), "file-classify": a(A).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, _e = le(pe, [["__scopeId", "data-v-ca677315"]]);
export {
  _e as default
};
