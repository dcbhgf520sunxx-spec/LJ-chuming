import { ref as p } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as m } from "vue";
import { createBlock as h } from "vue";
import { withCtx as w } from "vue";
import { unref as l } from "vue";
import { createTextVNode as ae } from "vue";
import { createCommentVNode as A } from "vue";
import { createVNode as I } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as T } from "vue";
import { toDisplayString as te } from "vue";
import { ElTag as oe } from "element-plus";
import { i as le, a as ne, b as ie, d as ue } from "../../../../../modules/project-information-ad6c6e75.js";
import { f as se } from "../../../../../modules/project-information-053c195b.js";
import { u as re, dA as t, lv as S, R as ce, S as de, p as pe, b as ve, lP as me, lq as fe } from "../../../../../shared/runtime.js";
import { u as Te } from "../../../../../modules/use-form-config-data-098a0552.js";
import _e from "../../../components/information-description/index.vue.js";
import Re from "./approval-status.vue.js";
const Ie = { key: 0 }, Ne = { class: "head-container" }, Ee = { key: 0 }, Oe = { style: { "margin-top": "15px" } }, Ce = { style: { "font-size": "18px", "font-weight": "bold", "margin-bottom": "10px" } }, Ve = { key: 1, class: "red-tip", style: { "font-size": "14px" } }, ye = { key: 2, class: "red-tip", style: { "font-size": "14px" } }, he = { key: 1, class: "red-tip", style: { "font-size": "14px" } }, Fe = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "submit-success"], setup(P, { emit: j }) {
  const E = p([]), u = p(), U = p(""), O = p([]), a = p(), _ = p([]), R = p({}), C = p([]), s = p(), k = p({}), D = p({}), r = P, J = j, { visible: x, handleClose: G } = re({ emit: J, props: r, showHook: B, closeHook: Q }), { fetchFormItemList: K, fetchFormDetail: M, formItemList: g, serchFormDetail: n } = Te();
  function B() {
    a.value = void 0, s.value = void 0, u.value = void 0, V(), y(), q();
  }
  function Q() {
    a.value = void 0, s.value = void 0, u.value = void 0, n.value = {}, g.value = [];
  }
  async function z(o) {
    s.value = void 0, u.value = void 0, a.value = o, a.value === t.PROJECT_TRACK_DOWN.V && $(), a.value === t.APPLICATION_TENDER.V && await Z(), await V(), await y(), a.value !== t.PROJECT_TRACK_DOWN.V && await b(), await L();
  }
  async function V() {
    var o, e, i, c, v, f;
    if (!(!a.value || a.value === t.PROJECT_TRACK_DOWN.V && !s.value || a.value === t.APPLICATION_TENDER.V && !u.value)) try {
      await M({ pageEnum: a.value, params: s.value ? k.value : r.currentRow, tenderType: a.value === t.APPLICATION_TENDER.V && u.value ? u.value : void 0, countryType: a.value === t.PROJECT_SIGN_IN_CONFIG.V ? (o = r.currentRow) == null ? void 0 : o.crmCountryTypeEnum : void 0 }), a.value === t.PROJECT_SIGN_IN_CONFIG.V ? n.value.attachmentDTOList = ((e = n.value) == null ? void 0 : e.projectAttachmentList) || [] : a.value === t.PROJECT_TRACK_DOWN.V ? (n.value.attachmentDTOList = ((i = n.value) == null ? void 0 : i.followUpAttachment) || [], n.value = Object.assign(n.value, D.value, { projectSerialNumber: r.currentRow.serialNumber, projectName: r.currentRow.projectName, followUpMethods: (c = n.value) == null ? void 0 : c.followUpMethodsName })) : a.value === t.QUALIFICATION_REVIEW.V && (n.value.attachmentDTOList = ((v = n.value) == null ? void 0 : v.attachmentList) || [], n.value = Object.assign(n.value, D.value, { projectSerialNumber: r.currentRow.serialNumber, projectName: r.currentRow.projectName, followUpMethods: (f = n.value) == null ? void 0 : f.followUpMethodsName })), console.log(n.value, "serchFormDetail");
    } catch (d) {
      console.log(d);
    }
  }
  async function y() {
    var o;
    if (!(!a.value || a.value === t.PROJECT_TRACK_DOWN.V && !s.value)) try {
      await K({ pageEnum: a.value, countryType: a.value === t.PROJECT_SIGN_IN_CONFIG.V ? (o = r.currentRow) == null ? void 0 : o.crmCountryTypeEnum : void 0 }), console.log(g.value);
    } catch (e) {
      console.log(e);
    }
  }
  async function H() {
    var e;
    if (a.value !== t.PROJECT_TRACK_DOWN.V && a.value !== t.QUALIFICATION_REVIEW.V) return;
    const o = await se({ crmProjectInformationWarehousingId: a.value === t.PROJECT_TRACK_DOWN.V || a.value === t.QUALIFICATION_REVIEW.V ? (e = r.currentRow) == null ? void 0 : e.id : void 0 });
    D.value = o;
  }
  async function q() {
    try {
      _.value = [];
      const o = await le({ id: r.currentRow.id });
      R.value = o || {};
      for (const e in R.value) switch (e) {
        case "haveFollowUp":
          R.value[e] || _.value.push(t.PROJECT_TRACK_DOWN.V);
          break;
        case "havePreQualification":
          R.value[e] || _.value.push(t.QUALIFICATION_REVIEW.V);
          break;
        case "haveApplyForBidRecord":
          R.value[e] || _.value.push(t.APPLICATION_TENDER.V);
          break;
        default:
          break;
      }
    } catch (o) {
      console.log(o, "获取当前项目可操作类型失败");
    }
  }
  async function $() {
    var o;
    try {
      const e = await ne({ projectId: r.currentRow.id });
      C.value = e || [], (o = C.value) == null || o.forEach((i) => {
        i.flllowUpTime = pe(i.followUpDate, "{y}-{m}-{d} {h}:{i}");
      });
    } catch (e) {
      console.log(e, "获取项目跟进的时间历史记录列表失败");
    }
  }
  async function X(o) {
    var e, i;
    s.value = o, k.value = Object.assign({}, { id: s.value }), await V(), await y(), (a.value === t.PROJECT_TRACK_DOWN.V || a.value === t.QUALIFICATION_REVIEW.V) && H(), a.value === t.PROJECT_TRACK_DOWN.V && (n.value.approveRecordId = (i = (e = C.value) == null ? void 0 : e.find((c) => c.id === s.value)) == null ? void 0 : i.approveRecordId, await b()), await L();
  }
  async function Y(o) {
    u.value = o, await V(), await y(), a.value === t.APPLICATION_TENDER.V && await b(), await L();
  }
  async function b() {
    var o, e, i;
    if (!ve((o = n.value) == null ? void 0 : o.approveRecordId) && (O.value = [], !(a.value === t.APPLICATION_TENDER.V && !u.value))) try {
      const c = await me((e = n.value) == null ? void 0 : e.approveRecordId);
      console.log(c, "data"), (i = c == null ? void 0 : c.wmsApproveFlowDTOS) == null || i.forEach((v) => {
        var f;
        (f = v == null ? void 0 : v.wmsApproveRecordDetailDTOS) == null || f.forEach((d) => {
          d.typeName = v.typeName, O.value.push(d);
        });
      }), console.log(O.value, "list");
    } catch (c) {
      console.log(c, "获取审批状态失败");
    }
  }
  async function L() {
    var o;
    if (!(a.value === t.APPLICATION_TENDER.V && !u.value)) try {
      const e = await ie({ id: (o = n.value) == null ? void 0 : o.approveRecordId });
      U.value = e || "";
    } catch (e) {
      console.log(e, "获取审批流程编号失败");
    }
  }
  async function Z() {
    var o;
    try {
      const e = await ue({ crmProjectInformationWarehousingId: r.currentRow.id });
      E.value = e || [], E.value = (o = E.value) == null ? void 0 : o.map((i) => ({ id: i, name: fe.VL[i] }));
    } catch (e) {
      console.log(e, "获取审批的标书类型的列表失败");
    }
  }
  return (o, e) => {
    const i = oe, c = F("common-radio"), v = F("common-select"), f = F("common-drawer");
    return m(), h(f, { "destroy-on-close": "", "close-on-click-modal": false, visible: l(x), "before-close": l(G), size: "70%", title: r.currentRow.projectName }, { titleAfter: w(() => {
      var d, W;
      return [((d = P.currentRow) == null ? void 0 : d.crmProjectScheduleTypeEnum) === l(S).FINISH.V ? (m(), h(i, { key: 0, type: "danger", effect: "plain", style: { "margin-right": "15px" } }, { default: w(() => e[4] || (e[4] = [ae(" 项目已终止 ")])), _: 1, __: [4] })) : A("", true), I(c, { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (ee) => a.value = ee), options: l(t).ENUM, type: "other", unshowVal: [l(t).FIRM_RECORD_CONFIG.V, l(t).GOVERNMENT_RECORD_CONFIG.V, l(t).PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V, l(t).SUPPLIER_INTO_RECORD_CONFIG.V, l(t).PROJECT_GIVE_UP.V], disabled: ((W = P.currentRow) == null ? void 0 : W.crmProjectScheduleTypeEnum) === l(S).FINISH.V, disabledVal: _.value, "data-structure": { key: "V", label: "SL", value: "V" }, onChange: z }, null, 8, ["modelValue", "options", "unshowVal", "disabled", "disabledVal"])];
    }), content: w(() => [a.value ? (m(), N("div", Ie, [T("div", Ne, [a.value === l(t).PROJECT_TRACK_DOWN.V ? (m(), h(v, { key: 0, type: "other", modelValue: s.value, "onUpdate:modelValue": e[1] || (e[1] = (d) => s.value = d), options: C.value, "data-structure": { key: "id", label: "flllowUpTime", value: "id" }, placeholder: "选择历史创建记录", noDataText: "暂无历史创建数据", style: { width: "200px" }, class: "filter-item", clearable: "", onChange: X }, null, 8, ["modelValue", "options"])) : A("", true), a.value === l(t).APPLICATION_TENDER.V ? (m(), h(v, { key: 1, type: "other", modelValue: u.value, "onUpdate:modelValue": e[2] || (e[2] = (d) => u.value = d), options: E.value, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "选择审批流程", noDataText: "暂无历史审批流程", style: { width: "200px" }, class: "filter-item", clearable: "", onChange: Y }, null, 8, ["modelValue", "options"])) : A("", true)]), a.value && (a.value === l(t).PROJECT_SIGN_IN_CONFIG.V || a.value === l(t).QUALIFICATION_REVIEW.V) || a.value === l(t).PROJECT_TRACK_DOWN.V && s.value || a.value !== l(t).PROJECT_TRACK_DOWN.V && a.value === l(t).APPLICATION_TENDER.V && u.value ? (m(), N("div", Ee, [I(_e, { "descriptions-list": l(g), "form-detail": l(n), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), I(ce, { showView: "", "show-download": "", files: l(n).attachmentDTOList, "onUpdate:files": e[3] || (e[3] = (d) => l(n).attachmentDTOList = d), "file-classify": l(de).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"]), T("div", Oe, [T("div", Ce, [e[6] || (e[6] = T("span", { style: { "margin-right": "10px" } }, "审批状态", -1)), I(i, { type: "primary", size: "small" }, { default: w(() => [e[5] || (e[5] = T("span", null, "流程编号：", -1)), T("span", null, te(U.value || "-"), 1)]), _: 1, __: [5] })]), I(Re, { list: O.value }, null, 8, ["list"])])])) : a.value === l(t).PROJECT_TRACK_DOWN.V && !s.value ? (m(), N("div", Ve, "* 请选择跟进时间记录查看")) : a.value === l(t).APPLICATION_TENDER.V && !u.value ? (m(), N("div", ye, "* 请选择审批流程记录查看")) : A("", true)])) : (m(), N("div", he, "* 请选择查看类型"))]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} };
export {
  Fe as default
};
