import { ref as x } from "vue";
import { computed as te } from "vue";
import { watch as ke } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as s } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as r } from "vue";
import { createBlock as h } from "vue";
import { toDisplayString as g } from "vue";
import { createTextVNode as N } from "vue";
import { unref as d } from "vue";
import { Fragment as w } from "vue";
import { renderList as $ } from "vue";
import { createCommentVNode as M } from "vue";
import { ElRadioGroup as je } from "element-plus";
import { nextTick as Be } from "vue";
import { ElFormItem as De } from "element-plus";
import { InfoFilled as Fe } from "@element-plus/icons-vue";
import { ElIcon as Ge } from "element-plus";
import { ElTooltip as He } from "element-plus";
import { ElCascader as We } from "element-plus";
import { ElDatePicker as qe } from "element-plus";
import { ElInput as Je } from "element-plus";
import { ElDivider as ze } from "element-plus";
import { ElInputNumber as Ye } from "element-plus";
import { ElRadio as $e } from "element-plus";
import { ElForm as Ke } from "element-plus";
import { ElMessage as Qe } from "element-plus";
import { a as Xe } from "../../../modules/technical-disclosure-config-24634047.js";
import { _ as Ze, m as et, iz as H, iA as B, iC as le, iD as K, bD as U, bN as S, K as T, jr as tt, js as lt, dn as p, jt as me, iH as ot, i as D, p as at, ju as fe, T as j, iB as W, bC as st, jv as oe } from "../../../shared/runtime.js";
import nt from "../project-manage/module/enclosure-show.vue.js";
import it from "../project-manage/module/enclosure-form.vue.js";
import { s as ut } from "../../../modules/StructureTypeSelect-93c1d648.js";
import "../project-manage/module/enclosure-table/structure-table.vue.js";
import "../project-manage/module/enclosure-table/sandwich-table.vue.js";
import "../project-manage/module/enclosure-table/pressed-color-table.vue.js";
import "../project-manage/module/enclosure-table/pressed-support-table.vue.js";
import "../project-manage/module/enclosure-table/truss-support-table.vue.js";
import "../../../modules/structure-type-config-b977de76.js";
const rt = { id: "businessContainer", class: "app-container" }, dt = { id: "baseInfo" }, pt = { class: "form-row" }, ct = { class: "input-underline", style: { width: "550px" } }, mt = { key: 1 }, ft = { class: "form-row" }, yt = { style: { width: "200px" } }, vt = { key: 1 }, Tt = { style: { width: "200px" } }, Vt = { key: 1 }, gt = { style: { width: "320px" } }, Et = { class: "form-row" }, _t = { style: { width: "200px" } }, Lt = { key: 0 }, ht = { style: { width: "400px" } }, Rt = { key: 1, class: "detail-break" }, Mt = { key: 0 }, bt = { key: 0 }, xt = { class: "form-row" }, It = { class: "form-row" }, St = { key: 1, class: "form-row" }, Ct = { style: { float: "left", width: "90px", "text-align": "right" } }, Nt = { style: { "margin-left": "2px" } }, wt = { key: 1 }, Ut = { key: 0 }, Ot = { class: "form-row" }, At = { class: "form-row" }, Pt = { key: 1, class: "form-row" }, kt = { style: { float: "left", width: "90px", "text-align": "right" } }, jt = { style: { "margin-left": "5px" } }, Bt = { style: { "margin-left": "2px" } }, Dt = { class: "form-row" }, Ft = { key: 1 }, Gt = { style: { width: "200px" } }, Ht = { key: 1 }, Wt = { class: "form-row" }, qt = { class: "input-underline form-row", style: { width: "200px" } }, Jt = { key: 1 }, zt = { key: 0 }, Yt = { class: "form-row" }, $t = { class: "input-underline", style: { width: "600px" } }, Kt = { key: 1, class: "detail-break", style: { "max-height": "220px", "overflow-y": "auto" } }, Qt = { class: "form-row" }, Xt = { class: "input-underline", style: { width: "600px" } }, Zt = { key: 1, class: "detail-break", style: { "max-height": "220px", "overflow-y": "auto" } }, el = { style: { "text-align": "right", "margin-right": "20px" } }, tl = { __name: "business", props: { projectId: { type: [Number, String], default: void 0 }, isModify: { type: Boolean, default: false } }, setup(_, { expose: ye }) {
  const { projectTypeEnumArr: ve, flag: q } = et(["projectTypeEnumArr", "flag"]), O = x();
  let A = [], P = [];
  const E = x([]), F = x([]), k = x(false), Q = x(), ae = x(false), Te = te(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false, multiple: true, checkStrictly: false })), se = { contractSignBodyId: void 0, businessType: void 0, projectType: void 0, projectContent: [], projectContentList: [], signingDate: void 0, signingAddress: void 0, structureMeasureMode: H.THEORY.V, measureModeList: [], transportMode: B.HOME_DELIVERY.V, payType: le.PUBLIC_TRANSFER.V, isTax: K.YES.V, invoiceType: U.SPECIAL.V, businessTaxRate: void 0, taxRate: void 0, payTypeDesc: void 0, enclosureInfo: {}, structureList: [], profiledPlateList: [], pressureBearingPlateList: [], trussFloorPlateList: [], sandwichBoardList: [], technologyRemark: void 0, structureTypeId: void 0, enclosureTransportMode: B.HOME_DELIVERY.V }, ne = { enclosureInfo: {}, structureList: [], profiledPlateList: [], pressureBearingPlateList: [], trussFloorPlateList: [], sandwichBoardList: [] }, e = x(JSON.parse(JSON.stringify(se))), n = x(JSON.parse(JSON.stringify(se))), Ve = x(), J = x([]), ie = x(), ge = (o, t, a) => {
    t.length <= 0 && a(new Error("请选择项目内容")), a();
  }, Ee = (o, t, a) => {
    e.value.isTax && (t || a(new Error("请选择发票类型")), a()), a();
  }, _e = (o, t, a) => {
    e.value.invoiceType && e.value.invoiceType !== U.RECEIPT.V && (t || a(new Error("请填写税率")), a()), a();
  }, Le = (o, t, a) => {
    t.length && (t.forEach((L) => {
      L.quantityWork || a(new Error("请填写工程量"));
    }), a()), a();
  };
  async function he() {
    try {
      const { boolRequiredInput: o = false } = await Xe();
      ae.value = o;
    } catch (o) {
      console.log("获取技术交底公共配置", o);
    }
  }
  he();
  const Re = { payTypeDesc: [{ max: 2e3, message: "不能超过 2000 个字符", trigger: "blur" }], businessType: [{ required: true, message: "请选择业务类型", trigger: "change" }], projectType: [{ required: true, message: "请选择项目类型", trigger: "change" }], projectContent: [{ required: true, validator: ge, trigger: "change" }], contractSignBodyId: [{ required: true, message: "请选择合同签订主体（签订主体可在配置管理-基础配置-分支机构中创建）", trigger: "change" }], invoiceType: [{ validator: Ee, message: "请选择发票类型", trigger: "change" }], businessTaxRate: [{ validator: _e, message: "请输入税率", trigger: "blur" }], quantityWork: [{ required: true, message: "请填写构件工程量", trigger: "blur" }], structureTypeId: [{ required: true, message: "请选择结构类型", trigger: "change" }], measureModeList: [{ validator: Le, message: "请输入围护结算与工程量", trigger: ["change", "blur"] }], enclosureInfo: [{ validator: (o, t, a) => {
    if (!E.value || E.value.length === 0) return a();
    if (!Object.values(t || {}).some((R) => Array.isArray(R) ? R.length > 0 : !!R) && ae.value) return Qe({ message: "请添加技术交底", type: "error" }), a(new Error("请添加技术交底"));
    a();
  }, trigger: "change" }] }, z = _, Me = te(() => {
    var o;
    if (e.value.businessType) {
      const t = e.value.businessType === S.MACHINING.V ? A : P, a = [];
      return t && ((o = t[T.STEEL.V]) == null ? void 0 : o.length) > 0 && t[T.STEEL.V].map((L) => {
        L.children && L.children.length > 0 && L.children.map((R) => {
          a.push(R);
        });
      }), a;
    } else return [];
  }), be = te(() => {
    if (e.value.projectType) switch (e.value.projectType) {
      case T.STEEL.V:
        return e.value.businessType === S.MACHINING.V ? A[T.STEEL.V] : P[T.STEEL.V];
      case T.BRIDGE.V:
        return e.value.businessType === S.MACHINING.V ? A[T.BRIDGE.V] : P[T.BRIDGE.V];
      case T.ENCLOSURE.V:
        return e.value.businessType === S.MACHINING.V ? A[T.ENCLOSURE.V] : P[T.ENCLOSURE.V];
      default:
        return e.value.businessType === S.MACHINING.V ? A[T.STEEL.V] : P[T.STEEL.V];
    }
    else return [];
  }), xe = x([S.MACHINING, S.INSTALLATION]);
  ke(() => z.projectId, (o) => {
    de();
  }, { deep: true, immediate: true });
  function ue() {
    O.value && O.value.resetFields(), e.value = JSON.parse(JSON.stringify(n.value)), e.value.projectContent = [], n.value.projectContentList && n.value.projectContentList.length > 0 && n.value.projectContentList.forEach((o) => {
      e.value.projectContent.push(o.id);
    }), X(e.value.projectContent, "detail"), O.value && Be(() => {
      O.value.clearValidate();
    }), st(O, e);
  }
  function Ie() {
    e.value.projectContent = [], E.value = [], F.value = [], e.value.structureMeasureMode = void 0, e.value.structureTypeId = void 0, e.value.measureModeList = [], Object.assign(e.value, JSON.parse(JSON.stringify(ne)));
  }
  function Se(o) {
    o !== K.YES.V && (e.value.invoiceType = void 0, e.value.businessTaxRate = void 0, e.value.taxRate = void 0);
  }
  function Ce(o) {
    o === U.RECEIPT.V && (e.value.businessTaxRate = void 0, e.value.taxRate = void 0);
  }
  function Ne() {
    e.value.taxRate = e.value.businessTaxRate ? e.value.businessTaxRate / 100 : void 0;
  }
  function X(o, t) {
    if (e.value.projectType === T.BRIDGE.V) {
      e.value.structureMeasureMode = H.THEORY.V, E.value = [], F.value = [], e.value.measureModeList = [], Object.assign(e.value, JSON.parse(JSON.stringify(ne)));
      return;
    }
    E.value = [], F.value = [];
    const a = [p.STRUCTURE.V, p.SANDWICH_BOARD.V, p.PROFILED_PLATE.V, p.TRUSS_FLOOR_PLATE.V, p.PRESSURE_BEARING_PLATE.V];
    let L = [];
    n.value.monomerQuantity > 0 ? a.forEach((y) => {
      J.value && J.value.indexOf(y) < 0 && L.push(y);
    }) : L = a;
    const R = [p.SANDWICH_BOARD.V, p.PROFILED_PLATE.V, p.TRUSS_FLOOR_PLATE.V, p.PRESSURE_BEARING_PLATE.V], I = [j.SANDWICH_BOARD.V, j.PROFILED_PLATE.V, j.TRUSS_FLOOR_PLATE.V, j.PRESSURE_BEARING_PLATE.V, j.BENDING.V], m = [];
    if (o.length > 0) {
      if (o.map((y) => {
        const c = Me.value.find((v) => v.id === y);
        m.push(c), (c == null ? void 0 : c.categoryType) === oe.STRUCTURE.V ? (E.value.indexOf(p.STRUCTURE.V) < 0 && E.value.push(p.STRUCTURE.V), F.value.push(c)) : R.indexOf(c == null ? void 0 : c.no) > -1 && E.value.indexOf(c == null ? void 0 : c.no) < 0 && E.value.push(c.no);
      }), L.forEach((y) => {
        E.value.indexOf(y) < 0 && D(e.value.enclosureInfo) && (e.value.enclosureInfo[y] = []);
      }), e.value.structureMeasureMode = m.findIndex((y) => y.categoryType === oe.STRUCTURE.V || y.categoryType === oe.BOX.V) > -1 ? e.value.structureMeasureMode || H.THEORY.V : void 0, m.length > 0) {
        if (t !== "detail") {
          const y = [];
          m.map((c) => {
            var v;
            I.indexOf(c.no) > -1 && (((v = e.value.measureModeList) == null ? void 0 : v.findIndex((V) => V.no === c.no)) < 0 ? y.push({ measureMode: W.LENGTH.V, no: c.no }) : y.push(e.value.measureModeList.find((V) => V.no === c.no)));
          }), e.value.measureModeList = y;
        }
      } else e.value.measureModeList = [];
      Q.value && re();
    }
  }
  function we(o) {
    ie.value = o;
  }
  function re() {
    const o = Q.value.tableData;
    o[p.STRUCTURE.V] = E.value.indexOf(p.STRUCTURE.V) > -1 ? o[p.STRUCTURE.V] : [], o[p.PROFILED_PLATE.V] = E.value.indexOf(p.PROFILED_PLATE.V) > -1 ? o[p.PROFILED_PLATE.V] : [], o[p.PRESSURE_BEARING_PLATE.V] = E.value.indexOf(p.PRESSURE_BEARING_PLATE.V) > -1 ? o[p.PRESSURE_BEARING_PLATE.V] : [], o[p.TRUSS_FLOOR_PLATE.V] = E.value.indexOf(p.TRUSS_FLOOR_PLATE.V) > -1 ? o[p.TRUSS_FLOOR_PLATE.V] : [], o[p.SANDWICH_BOARD.V] = E.value.indexOf(p.SANDWICH_BOARD.V) > -1 ? o[p.SANDWICH_BOARD.V] : [], e.value = { ...e.value, enclosureInfo: o, structureList: o[p.STRUCTURE.V], profiledPlateList: o[p.PROFILED_PLATE.V], pressureBearingPlateList: o[p.PRESSURE_BEARING_PLATE.V], trussFloorPlateList: o[p.TRUSS_FLOOR_PLATE.V], sandwichBoardList: o[p.SANDWICH_BOARD.V] }, k.value = false;
  }
  async function Ue() {
    try {
      return await O.value.validate();
    } catch (o) {
      return console.log("error", o), false;
    }
  }
  async function de() {
    var t, a, L, R;
    if (!z.projectId) return;
    let o = {};
    try {
      const I = await tt(z.projectId);
      o = JSON.parse(JSON.stringify(I));
      const m = await lt(z.projectId);
      o.enclosureInfo = { [p.STRUCTURE.V]: m.structureList ? m.structureList : [], [p.PROFILED_PLATE.V]: m.profiledPlateList ? m.profiledPlateList : [], [p.TRUSS_FLOOR_PLATE.V]: m.trussFloorPlateList ? m.trussFloorPlateList : [], [p.PRESSURE_BEARING_PLATE.V]: m.pressureBearingPlateList ? m.pressureBearingPlateList : [], [p.SANDWICH_BOARD.V]: m.sandwichBoardList ? m.sandwichBoardList : [] }, (t = m == null ? void 0 : m.sandwichBoardList) == null || t.map((c) => {
        const v = c.attachments && c.attachments.map((V) => V.id);
        c.attachmentIds = v ? v.join(",") : void 0;
      }), o.structureList = m.structureList ? m.structureList : [], o.profiledPlateList = m.profiledPlateList ? m.profiledPlateList : [], o.trussFloorPlateList = m.trussFloorPlateList ? m.trussFloorPlateList : [], o.pressureBearingPlateList = m.pressureBearingPlateList ? m.pressureBearingPlateList : [], o.sandwichBoardList = m.sandwichBoardList ? m.sandwichBoardList : [], A = await me({ businessType: S.MACHINING.V, flag: q.value }), P = await me({ businessType: S.INSTALLATION.V, flag: q.value });
      const y = [A, P];
      for (let c = 0; c < y.length; c++) y[c] && ((a = y[c][T.STEEL.V]) == null ? void 0 : a.length) > 0 && y[c][T.STEEL.V].map((v) => {
        v.name = v.categoryName, v.children.map((V) => {
          var b;
          V.disabled = ((b = o.projectContentNoList) == null ? void 0 : b.indexOf(V.no)) > -1;
        });
      }), y[c] && ((L = y[c][T.BRIDGE.V]) == null ? void 0 : L.length) > 0 && y[c][T.BRIDGE.V].map((v) => {
        v.name = v.categoryName, v.children.map((V) => {
          var b;
          V.disabled = ((b = o.projectContentNoList) == null ? void 0 : b.indexOf(V.no)) > -1;
        });
      }), y[c] && ((R = y[c][T.ENCLOSURE.V]) == null ? void 0 : R.length) > 0 && y[c][T.ENCLOSURE.V].map((v) => {
        v.name = v.categoryName, v.children.map((V) => {
          var b;
          V.disabled = ((b = o.projectContentNoList) == null ? void 0 : b.indexOf(V.no)) > -1;
        });
      });
      o.businessTaxRate = o.taxRate ? o.taxRate * 100 : void 0;
    } catch (I) {
      console.log("error", I);
    } finally {
      n.value = o, ue(), e.value.projectContent = [], J.value = [], n.value.projectContentList && n.value.projectContentList.length > 0 && n.value.projectContentList.forEach((I) => {
        e.value.projectContent.push(I.id), J.value.push(I.no);
      }), Ve.value = JSON.parse(JSON.stringify(e.value.projectContent)), n.value.projectContent = JSON.parse(JSON.stringify(e.value.projectContent)), X(e.value.projectContent, "detail");
    }
  }
  return ye({ form: e, validateForm: Ue, fetchDetail: de, resetForm: ue, detail: n }), (o, t) => {
    const a = De, L = Fe, R = Ge, I = He, m = Y("common-select"), y = We, c = qe, v = Je, V = ze, b = Ye, C = Y("common-radio"), Oe = $e, Z = Y("common-button"), Ae = Y("common-drawer"), Pe = Ke;
    return i(), f("div", rt, [s(Pe, { ref_key: "formRef", ref: O, model: e.value, rules: Re, inline: "", size: "default", "label-position": "right", "label-width": "130px" }, { default: u(() => {
      var pe, ce;
      return [r("div", null, [r("div", dt, [r("div", pt, [s(a, { label: "合同签订主体", prop: "contractSignBodyId" }, { default: u(() => [r("div", ct, [_.isModify ? (i(), h(ot, { key: 0, modelValue: e.value.contractSignBodyId, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.contractSignBodyId = l), default: "", class: "input-underline", placeholder: "合同签订主体", style: { width: "550px" } }, null, 8, ["modelValue"])) : (i(), f("span", mt, g(n.value.contractSignBodyName), 1))])]), _: 1 })]), r("div", ft, [s(a, { label: "业务类型", prop: "businessType" }, { label: u(() => [t[23] || (t[23] = N(" 业务类型 ")), s(I, { effect: "light", content: "已创建工作计划时不能修改", placement: "top" }, { default: u(() => [s(R, null, { default: u(() => [s(L)]), _: 1 })]), _: 1 })]), default: u(() => [r("div", yt, [_.isModify ? (i(), h(m, { key: 0, modelValue: e.value.businessType, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.businessType = l), options: xe.value, type: "enum", size: "default", clearable: "", placeholder: "业务类型", class: "input-underline", disabled: d(D)(n.value.projectContentNoList) }, null, 8, ["modelValue", "options", "disabled"])) : (i(), f("span", vt, g(n.value.businessType ? d(S).VL[n.value.businessType] : "-"), 1))])]), _: 1 }), s(a, { label: "项目类型", prop: "projectType" }, { label: u(() => [t[24] || (t[24] = N(" 项目类型 ")), s(I, { effect: "light", content: "已创建工作计划时不能修改", placement: "top" }, { default: u(() => [s(R, null, { default: u(() => [s(L)]), _: 1 })]), _: 1 })]), default: u(() => [r("div", Tt, [_.isModify ? (i(), h(m, { key: 0, modelValue: e.value.projectType, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.projectType = l), options: d(ve), type: "enum", size: "default", clearable: "", placeholder: "项目类型", style: { width: "200px" }, class: "input-underline", onChange: Ie, disabled: d(D)(n.value.projectContentNoList) }, null, 8, ["modelValue", "options", "disabled"])) : (i(), f("span", Vt, g(n.value.projectType ? d(T).VL[n.value.projectType] : "-"), 1))])]), _: 1 }), s(a, { label: "项目内容", prop: "projectContent" }, { default: u(() => [r("div", gt, [_.isModify ? (i(), h(y, { key: 0, ref: "cascaderRef", modelValue: e.value.projectContent, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.projectContent = l), placeholder: "项目内容,可多选", options: be.value, class: "input-underline", props: Te.value, "show-all-levels": true, clearable: !d(D)(n.value.projectContentNoList), style: { width: "320px" }, onChange: X, filterable: "" }, null, 8, ["modelValue", "options", "props", "clearable"])) : (i(true), f(w, { key: 1 }, $(n.value.projectContentList, (l) => (i(), f("span", { key: l.id }, g(l.name) + " ", 1))), 128))])]), _: 1 })]), r("div", Et, [s(a, { label: "签订日期", prop: "signingDate" }, { default: u(() => [r("div", _t, [_.isModify ? (i(), h(c, { key: 0, modelValue: e.value.signingDate, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.signingDate = l), type: "date", "value-format": "x", placeholder: "选择签订日期", class: "input-underline", style: { width: "200px" } }, null, 8, ["modelValue"])) : (i(), f(w, { key: 1 }, [n.value.signingDate ? (i(), f("span", Lt, g(d(at)(n.value.signingDate, "{y}-{m}-{d}")), 1)) : M("", true)], 64))])]), _: 1 }), s(a, { label: "签约地址", prop: "signingAddress" }, { default: u(() => [r("div", ht, [_.isModify ? (i(), h(v, { key: 0, modelValue: e.value.signingAddress, "onUpdate:modelValue": t[5] || (t[5] = (l) => e.value.signingAddress = l), modelModifiers: { trim: true }, class: "input-underline", placeholder: "签约地址", style: { width: "400px" } }, null, 8, ["modelValue"])) : (i(), f("span", Rt, g(n.value.signingAddress), 1))])]), _: 1 })]), _.isModify ? (i(), f("div", Mt, [e.value.structureMeasureMode ? (i(), f("div", bt, [s(V, null, { default: u(() => t[25] || (t[25] = [r("span", { class: "title" }, "结构", -1)])), _: 1, __: [25] }), r("div", xt, [s(a, { label: "结构工程量", prop: "quantityWork" }, { default: u(() => [s(b, { modelValue: e.value.quantityWork, "onUpdate:modelValue": t[6] || (t[6] = (l) => e.value.quantityWork = l), step: 1, min: 0, max: 99999999, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "200px" }, placeholder: "" }, null, 8, ["modelValue"]), t[26] || (t[26] = N("吨 "))]), _: 1, __: [26] }), s(a, { label: "结构类型", prop: "structureStatus" }, { default: u(() => [s(d(ut), { modelValue: e.value.structureTypeId, "onUpdate:modelValue": t[7] || (t[7] = (l) => e.value.structureTypeId = l), projectType: e.value.projectType, class: "input-underline", "data-structure": { key: "value", label: "label", value: "value" }, size: "default", placeholder: "结构类型", style: { width: "200px" } }, null, 8, ["modelValue", "projectType"])]), _: 1 })]), r("div", It, [s(a, { label: "结构结算方式", prop: "structureMeasureMode" }, { default: u(() => [s(C, { modelValue: e.value.structureMeasureMode, "onUpdate:modelValue": t[8] || (t[8] = (l) => e.value.structureMeasureMode = l), options: d(H).ENUM, type: "enum", disabled: !e.value.structureMeasureMode }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), s(a, { label: "结构运输方式", prop: "transportMode" }, { default: u(() => [s(C, { modelValue: e.value.transportMode, "onUpdate:modelValue": t[9] || (t[9] = (l) => e.value.transportMode = l), options: d(B).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })])])) : M("", true), e.value.measureModeList && e.value.measureModeList.length > 0 && d(q) === d(fe).YES.V ? (i(), f("div", St, [s(V, null, { default: u(() => t[27] || (t[27] = [r("span", { class: "title" }, "围护", -1)])), _: 1, __: [27] }), s(a, { label: "围护运输方式", prop: "enclosureTransportMode" }, { default: u(() => [s(C, { modelValue: e.value.enclosureTransportMode, "onUpdate:modelValue": t[10] || (t[10] = (l) => e.value.enclosureTransportMode = l), options: d(B).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), ((pe = e.value.measureModeList) == null ? void 0 : pe.length) > 0 ? (i(), h(a, { key: 0, label: "围护结算方式与工程量", prop: "measureModeList", "label-width": "220px" }, { default: u(() => [e.value.measureModeList.length > 0 ? (i(true), f(w, { key: 0 }, $(e.value.measureModeList, (l, ee) => (i(), f("div", { key: ee, style: { display: "flex" } }, [r("span", Ct, g(d(j).VL[l.no]) + "：", 1), s(C, { style: { float: "left" }, modelValue: l.measureMode, "onUpdate:modelValue": (G) => l.measureMode = G, options: d(W).ENUM, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), s(b, { modelValue: l.quantityWork, "onUpdate:modelValue": (G) => l.quantityWork = G, step: 1, min: 0, max: 99999999, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "120px", "margin-left": "10px" }, placeholder: "工程量" }, null, 8, ["modelValue", "onUpdate:modelValue"]), r("span", Nt, g(l.measureMode === d(W).LENGTH.V ? "m" : "㎡"), 1)]))), 128)) : M("", true)]), _: 1 })) : M("", true)])) : M("", true)])) : (i(), f("div", wt, [n.value.structureMeasureMode ? (i(), f("div", Ut, [s(V, null, { default: u(() => t[28] || (t[28] = [r("span", { class: "title" }, "结构", -1)])), _: 1, __: [28] }), r("div", Ot, [s(a, { label: "结构工程量", prop: "quantityWork" }, { default: u(() => [r("span", null, g(n.value.quantityWork), 1), t[29] || (t[29] = r("span", null, "吨", -1))]), _: 1, __: [29] }), s(a, { label: "结构类型", prop: "structureStatus" }, { default: u(() => [r("span", null, g(n.value.structureTypeName || "-"), 1)]), _: 1 })]), r("div", At, [s(a, { label: "结构结算方式", prop: "structureMeasureMode" }, { default: u(() => [s(C, { modelValue: n.value.structureMeasureMode, "onUpdate:modelValue": t[11] || (t[11] = (l) => n.value.structureMeasureMode = l), options: d(H).ENUM, type: "enum", disabled: true }, null, 8, ["modelValue", "options"])]), _: 1 }), s(a, { label: "结构运输方式", prop: "transportMode" }, { default: u(() => [s(C, { modelValue: e.value.transportMode, "onUpdate:modelValue": t[12] || (t[12] = (l) => e.value.transportMode = l), options: d(B).ENUM, type: "enum", disabled: true }, null, 8, ["modelValue", "options"])]), _: 1 })])])) : M("", true), n.value.measureModeList && n.value.measureModeList.length > 0 && d(q) === d(fe).YES.V ? (i(), f("div", Pt, [s(V, null, { default: u(() => t[30] || (t[30] = [r("span", { class: "title" }, "围护", -1)])), _: 1, __: [30] }), s(a, { label: "围护运输方式", prop: "enclosureTransportMode" }, { default: u(() => [s(C, { modelValue: n.value.enclosureTransportMode, "onUpdate:modelValue": t[13] || (t[13] = (l) => n.value.enclosureTransportMode = l), options: d(B).ENUM, type: "enum", disabled: true }, null, 8, ["modelValue", "options"])]), _: 1 }), ((ce = n.value.measureModeList) == null ? void 0 : ce.length) > 0 ? (i(), h(a, { key: 0, label: "围护结算方式与工程量", prop: "measureModeList", "label-width": "220px" }, { default: u(() => [n.value.measureModeList.length > 0 ? (i(true), f(w, { key: 0 }, $(n.value.measureModeList, (l, ee) => (i(), f("div", { key: ee, style: { display: "flex" } }, [r("span", kt, g(d(j).VL[l.no]) + "：", 1), s(C, { style: { float: "left" }, modelValue: l.measureMode, "onUpdate:modelValue": (G) => l.measureMode = G, options: d(W).ENUM, type: "enum", disabled: true }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), r("span", jt, "工程量：" + g(l.quantityWork), 1), r("span", Bt, g(l.measureMode === d(W).LENGTH.V ? "m" : "㎡"), 1)]))), 128)) : M("", true)]), _: 1 })) : M("", true)])) : M("", true)])), r("div", Dt, [s(a, { label: "支付方式", prop: "payType" }, { default: u(() => [r("div", null, [_.isModify ? (i(), h(C, { key: 0, modelValue: e.value.payType, "onUpdate:modelValue": t[14] || (t[14] = (l) => e.value.payType = l), options: d(le).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])) : (i(), f("span", Ft, g(d(D)(n.value.payType) ? d(le).VL[n.value.payType] : ""), 1))])]), _: 1 }), s(a, { label: "合同含税", prop: "isTax" }, { default: u(() => [r("div", Gt, [_.isModify ? (i(), h(d(je), { key: 0, modelValue: e.value.isTax, "onUpdate:modelValue": t[15] || (t[15] = (l) => e.value.isTax = l), onChange: Se }, { default: u(() => [(i(true), f(w, null, $(d(K).ENUM, (l) => (i(), h(Oe, { key: l.V, value: l.V }, { default: u(() => [N(g(l.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])) : (i(), f("span", Ht, g(d(D)(n.value.isTax) ? d(K).VL[n.value.isTax] : ""), 1))])]), _: 1 })]), r("div", Wt, [s(a, { label: "发票类型", prop: "invoiceType" }, { default: u(() => [r("div", qt, [_.isModify ? (i(), h(m, { key: 0, type: "enum", size: "default", modelValue: e.value.invoiceType, "onUpdate:modelValue": t[16] || (t[16] = (l) => e.value.invoiceType = l), options: d(U).ENUM, disabled: !e.value.isTax, class: "input-underline", placeholder: "选择发票类型", style: { width: "200px" }, onChange: Ce }, null, 8, ["modelValue", "options", "disabled"])) : (i(), f("span", Jt, g(n.value.invoiceType ? d(U).VL[n.value.invoiceType] : ""), 1))])]), _: 1 }), !_.isModify || _.isModify && e.value.isTax && e.value.invoiceType !== d(U).RECEIPT.V ? (i(), h(a, { key: 0, label: "税率", prop: "businessTaxRate" }, { default: u(() => [_.isModify ? (i(), f(w, { key: 0 }, [s(b, { modelValue: e.value.businessTaxRate, "onUpdate:modelValue": t[17] || (t[17] = (l) => e.value.businessTaxRate = l), step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "80px" }, placeholder: "0-100", onChange: Ne, disabled: !e.value.isTax || e.value.invoiceType === d(U).RECEIPT.V }, null, 8, ["modelValue", "disabled"]), t[31] || (t[31] = N("% "))], 64)) : (i(), f(w, { key: 1 }, [n.value.isTax && n.value.invoiceType !== d(U).RECEIPT.V ? (i(), f("span", zt, g(n.value.businessTaxRate ? n.value.businessTaxRate + "%" : ""), 1)) : M("", true)], 64))]), _: 1 })) : M("", true)]), r("div", Yt, [s(a, { label: "付款方式描述", prop: "payTypeDesc" }, { default: u(() => [r("div", $t, [_.isModify ? (i(), h(v, { key: 0, modelValue: e.value.payTypeDesc, "onUpdate:modelValue": t[18] || (t[18] = (l) => e.value.payTypeDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 4, maxRows: 8 }, maxlength: "2000", "show-word-limit": "", placeholder: "付款方式描述" }, null, 8, ["modelValue"])) : (i(), f("div", Kt, g(n.value.payTypeDesc), 1))])]), _: 1 })]), r("div", Qt, [s(a, { label: "技术要求描述", prop: "technologyRemark" }, { default: u(() => [r("div", Xt, [_.isModify ? (i(), h(v, { key: 0, modelValue: e.value.technologyRemark, "onUpdate:modelValue": t[19] || (t[19] = (l) => e.value.technologyRemark = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", "show-word-limit": "", style: { width: "550px" }, placeholder: "付款方式描述" }, null, 8, ["modelValue"])) : (i(), f("div", Zt, g(n.value.technologyRemark), 1))])]), _: 1 })])]), e.value.projectType !== d(T).ENCLOSURE.V ? (i(), f(w, { key: 0 }, [s(V, null, { default: u(() => t[32] || (t[32] = [r("span", { class: "title" }, "技术交底", -1)])), _: 1, __: [32] }), r("div", el, [_.isModify ? (i(), h(Z, { key: 0, style: { "margin-left": "20px" }, type: "success", size: "default", onClick: t[20] || (t[20] = (l) => k.value = true), disabled: !(E.value && E.value.length > 0) }, { default: u(() => t[33] || (t[33] = [N("添加")])), _: 1, __: [33] }, 8, ["disabled"])) : M("", true)]), s(d(nt), { "table-data": _.isModify ? e.value.enclosureInfo : n.value.enclosureInfo, "show-item": E.value, onClickChange: we }, null, 8, ["table-data", "show-item"]), s(a, { prop: "enclosureInfo", style: { display: "block" } }, { default: u(() => t[34] || (t[34] = [r("div", null, null, -1)])), _: 1, __: [34] })], 64)) : M("", true), s(Ae, { modelValue: k.value, "onUpdate:modelValue": t[22] || (t[22] = (l) => k.value = l), "with-header": true, "show-close": false, "wrapper-closable": false, direction: "rtl", size: "80%", "before-close": () => {
        k.value = false;
      } }, { title: u(() => [t[37] || (t[37] = r("span", { class: "line-title" }, "添加技术交底", -1)), r("span", null, [s(Z, { size: "default", type: "primary", onClick: re }, { default: u(() => t[35] || (t[35] = [N("保存")])), _: 1, __: [35] }), s(Z, { size: "default", type: "info", onClick: t[21] || (t[21] = (l) => k.value = false) }, { default: u(() => t[36] || (t[36] = [N("取消")])), _: 1, __: [36] })])]), content: u(() => [s(d(it), { ref_key: "enclosureFormRef", ref: Q, "show-item": E.value, "show-category": F.value, "init-form": e.value.enclosureInfo, "default-type": ie.value, enclosureVisible: k.value }, null, 8, ["show-item", "show-category", "init-form", "default-type", "enclosureVisible"])]), _: 1 }, 8, ["modelValue", "before-close"])])];
    }), _: 1 }, 8, ["model"])]);
  };
} }, vl = Ze(tl, [["__scopeId", "data-v-117f1f3c"]]);
export {
  vl as default
};
