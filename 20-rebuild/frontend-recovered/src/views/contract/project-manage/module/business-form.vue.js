import { ref as g } from "vue";
import { inject as K } from "vue";
import { computed as F } from "vue";
import { watch as Q } from "vue";
import { nextTick as he } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as v } from "vue";
import { createBlock as S } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as p } from "vue";
import { createElementBlock as O } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as V } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { toDisplayString as q } from "vue";
import { ElRadioGroup as xe } from "element-plus";
import { ElMessage as le } from "element-plus";
import { ElFormItem as Ue } from "element-plus";
import { ElCascader as Me } from "element-plus";
import { ElDatePicker as Ce } from "element-plus";
import { ElInput as Le } from "element-plus";
import { ElDivider as Ne } from "element-plus";
import { ElInputNumber as Ae } from "element-plus";
import { ElRadio as we } from "element-plus";
import { ElForm as De } from "element-plus";
import { a as Pe } from "../../../../modules/technical-disclosure-config-24634047.js";
import { _ as Be, m as je, iA as w, iC as te, iD as G, bD as I, kx as h, K as m, bC as ke, iH as Fe, iz as H, T as x, iB as W, dn as u, jv as E, i as qe } from "../../../../shared/runtime.js";
import Ge from "./enclosure-form.vue.js";
import He from "./enclosure-show.vue.js";
import { s as We } from "../../../../modules/StructureTypeSelect-93c1d648.js";
import "./enclosure-table/sandwich-table.vue.js";
import "./enclosure-table/pressed-color-table.vue.js";
import "./enclosure-table/pressed-support-table.vue.js";
import "./enclosure-table/structure-table.vue.js";
import "./enclosure-table/truss-support-table.vue.js";
import "../../../../modules/structure-type-config-b977de76.js";
const Je = { id: "baseInfo" }, ze = { class: "form-row" }, Ye = { class: "form-row" }, Xe = { class: "form-row" }, $e = { key: 0 }, Ke = { class: "form-row" }, Qe = { class: "form-row" }, Ze = { key: 1, class: "form-row" }, el = { style: { float: "left", width: "90px", "text-align": "right" } }, ll = { style: { "margin-left": "2px" } }, tl = { class: "form-row" }, al = { class: "form-row" }, ol = { class: "form-row" }, nl = { class: "form-row" }, sl = { key: 1, style: { "text-align": "right", "margin-right": "20px" } }, ul = { __name: "business-form", props: { formData: { type: Object, default: () => {
} } }, setup(ae, { expose: oe }) {
  const { projectTypeEnumArr: ne, flag: rl } = je(["projectTypeEnumArr", "flag"]), R = g(), U = K("machiningData"), M = K("installData"), r = g([]), C = g([]), _ = g(false), L = g(), J = g(false), se = F(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false, multiple: true, checkStrictly: false })), z = ae, Y = { contractSignBodyId: void 0, businessType: void 0, projectType: void 0, projectContent: [], signerId: void 0, signingDate: void 0, signingAddress: void 0, structureMeasureMode: void 0, measureModeList: [], transportMode: w.HOME_DELIVERY.V, payType: te.PUBLIC_TRANSFER.V, isTax: G.YES.V, invoiceType: I.SPECIAL.V, businessTaxRate: void 0, taxRate: void 0, payTypeDesc: void 0, enclosureInfo: {}, structureSaveRequestVOS: [], profiledPlateSaveRequestVOS: [], pressureBearingPlateSaveVOS: [], trussFloorPlateSaveRequestVOS: [], sandwichBoardSaveRequestVOS: [], technologyRemark: void 0, structureTypeId: void 0, enclosureTransportMode: w.HOME_DELIVERY.V }, D = { enclosureInfo: {}, structureSaveRequestVOS: [], profiledPlateSaveRequestVOS: [], pressureBearingPlateSaveVOS: [], trussFloorPlateSaveRequestVOS: [], sandwichBoardSaveRequestVOS: [] }, e = g(JSON.parse(JSON.stringify(Y))), ue = (t, l, n) => {
    e.value.isTax && (l || n(new Error("请选择发票类型")), n()), n();
  }, re = (t, l, n) => {
    e.value.invoiceType && e.value.invoiceType !== I.RECEIPT.V && (l || n(new Error("请填写税率")), n()), n();
  }, ie = (t, l, n) => {
    l.length && (l.forEach((y) => {
      y.quantityWork || n(new Error("请填写工程量"));
    }), n()), n();
  };
  async function de() {
    try {
      const { boolRequiredInput: t = false } = await Pe();
      J.value = t;
    } catch (t) {
      console.log("获取技术交底公共配置", t);
    }
  }
  de();
  const pe = { payTypeDesc: [{ max: 2e3, message: "不能超过 2000 个字符", trigger: "blur" }], businessType: [{ required: true, message: "请选择业务类型", trigger: "change" }], projectType: [{ required: true, message: "请选择项目类型", trigger: "change" }], projectContent: [{ required: true, message: "请输入项目内容", trigger: "change" }], contractSignBodyId: [{ required: true, message: "请选择合同签订主体（签订主体可在配置管理-基础配置-分支机构中创建）", trigger: "change" }], invoiceType: [{ validator: ue, message: "请选择发票类型", trigger: "change" }], businessTaxRate: [{ validator: re, message: "请输入税率", trigger: "blur" }], quantityWork: [{ required: true, message: "请填写构件工程量", trigger: "blur" }], structureTypeId: [{ required: true, message: "请选择结构类型", trigger: "change" }], enclosureInfo: [{ validator: (t, l, n) => {
    if (!r.value || r.value.length === 0) return n();
    if (!Object.values(l || {}).some((f) => Array.isArray(f) ? f.length > 0 : !!f) && J.value) return le({ message: "请添加技术交底", type: "error" }), n(new Error("请添加技术交底"));
    n();
  }, trigger: "change" }], measureModeList: [{ validator: ie, message: "请输入围护结算与工程量", trigger: ["change", "blur"] }] }, P = g(), me = F(() => {
    if (e.value.businessType) {
      const t = e.value.businessType === h.MACHINING.V ? U.value : M.value, l = [];
      return t && t[m.STEEL.V].length > 0 && t[m.STEEL.V].map((n) => {
        n.children && n.children.length > 0 && n.children.map((y) => {
          l.push(y);
        });
      }), l;
    } else return [];
  }), ce = F(() => {
    if (e.value.projectType) switch (e.value.projectType) {
      case m.STEEL.V:
        return e.value.businessType === h.MACHINING.V ? U.value[m.STEEL.V] : M.value[m.STEEL.V];
      case m.BRIDGE.V:
        return e.value.businessType === h.MACHINING.V ? U.value[m.BRIDGE.V] : M.value[m.BRIDGE.V];
      case m.ENCLOSURE.V:
        return e.value.businessType === h.MACHINING.V ? U.value[m.ENCLOSURE.V] : M.value[m.ENCLOSURE.V];
      default:
        return e.value.businessType === h.MACHINING.V ? U.value[m.STEEL.V] : M.value[m.STEEL.V];
    }
    else return [];
  });
  Q(() => z.formData, (t) => {
    fe(t);
  }, { deep: true, immediate: true }), Q(() => e.value.projectType, (t) => {
    t === m.ENCLOSURE.V && (e.value.projectContent = 256);
  });
  function fe(t) {
    R.value && R.value.resetFields();
    let l;
    t && Object.keys(t).length > 0 ? l = JSON.parse(JSON.stringify(t)) : (l = JSON.parse(JSON.stringify(Y)), Object.assign(e.value, JSON.parse(JSON.stringify(D))), P.value = void 0), e.value = JSON.parse(JSON.stringify(l)), L.value && (L.value.tableData = []), R.value && he(() => {
      R.value.clearValidate();
    }), ke(R, e);
  }
  function ve() {
    e.value.projectContent = [], r.value = [], C.value = [], e.value.structureMeasureMode = void 0, e.value.structureTypeId = void 0, e.value.measureModeList = [], Object.assign(e.value, JSON.parse(JSON.stringify(D)));
  }
  function ye(t) {
    t !== G.YES.V && (e.value.invoiceType = void 0, e.value.businessTaxRate = void 0, e.value.taxRate = void 0);
  }
  function Te(t) {
    t === I.RECEIPT.V && (e.value.businessTaxRate = void 0, e.value.taxRate = void 0);
  }
  function Ve() {
    if (!e.value.projectContent || e.value.projectContent.length === 0) {
      le.error("请先选择项目内容");
      return;
    }
    _.value = true;
  }
  function Ee(t) {
    if (e.value.projectType === m.BRIDGE.V) return e.value.structureMeasureMode = H.THEORY.V, r.value = [], C.value = [], e.value.measureModeList = [], Object.assign(e.value, JSON.parse(JSON.stringify(D))), false;
    r.value = [], C.value = [];
    const l = [u.STRUCTURE.V, u.SANDWICH_BOARD.V, u.PROFILED_PLATE.V, u.TRUSS_FLOOR_PLATE.V, u.PRESSURE_BEARING_PLATE.V], n = [u.SANDWICH_BOARD.V, u.PROFILED_PLATE.V, u.TRUSS_FLOOR_PLATE.V, u.PRESSURE_BEARING_PLATE.V], y = [x.SANDWICH_BOARD.V, x.PROFILED_PLATE.V, x.TRUSS_FLOOR_PLATE.V, x.PRESSURE_BEARING_PLATE.V, x.BENDING.V], f = [];
    if (t.length > 0) {
      if (t.map((i) => {
        const c = me.value.find((T) => T.id === i);
        f.push(c), (c == null ? void 0 : c.categoryType) === E.STRUCTURE.V ? (r.value.indexOf(u.STRUCTURE.V) < 0 && r.value.push(u.STRUCTURE.V), C.value.push(c)) : n.indexOf(c.no) > -1 && r.value.indexOf(c.no) < 0 && r.value.push(c.no);
      }), l.forEach((i) => {
        r.value.indexOf(i) < 0 && qe(e.value.enclosureInfo) && (e.value.enclosureInfo[i] = []);
      }), e.value.structureMeasureMode = f.findIndex((i) => i.categoryType === E.STRUCTURE.V || i.categoryType === E.BOX.V) > -1 ? e.value.structureMeasureMode || H.THEORY.V : void 0, e.value.transportMode = f.findIndex((i) => i.categoryType === E.STRUCTURE.V || i.categoryType === E.BOX.V) > -1 ? e.value.transportMode || w.HOME_DELIVERY.V : void 0, e.value.structureTypeId = f.findIndex((i) => i.categoryType === E.STRUCTURE.V || i.categoryType === E.BOX.V) > -1 ? e.value.structureTypeId : void 0, e.value.quantityWork = f.findIndex((i) => i.categoryType === E.STRUCTURE.V || i.categoryType === E.BOX.V) > -1 ? e.value.quantityWork : void 0, f.length > 0) {
        const i = [];
        f.map((c) => {
          y.indexOf(c.no) > -1 && (e.value.measureModeList.findIndex((T) => T.no === c.no) < 0 ? i.push({ measureMode: W.LENGTH.V, no: c.no, quantityWork: void 0 }) : i.push(e.value.measureModeList.find((T) => T.no === c.no)));
        }), e.value.measureModeList = i;
      } else e.value.measureModeList = [];
      L.value && X();
    }
  }
  function ge(t) {
    P.value = t;
  }
  function X() {
    const t = L.value.tableData;
    t[u.STRUCTURE.V] = r.value.indexOf(u.STRUCTURE.V) > -1 ? t[u.STRUCTURE.V] : [], t[u.PROFILED_PLATE.V] = r.value.indexOf(u.PROFILED_PLATE.V) > -1 ? t[u.PROFILED_PLATE.V] : [], t[u.PRESSURE_BEARING_PLATE.V] = r.value.indexOf(u.PRESSURE_BEARING_PLATE.V) > -1 ? t[u.PRESSURE_BEARING_PLATE.V] : [], t[u.TRUSS_FLOOR_PLATE.V] = r.value.indexOf(u.TRUSS_FLOOR_PLATE.V) > -1 ? t[u.TRUSS_FLOOR_PLATE.V] : [], t[u.SANDWICH_BOARD.V] = r.value.indexOf(u.SANDWICH_BOARD.V) > -1 ? t[u.SANDWICH_BOARD.V] : [], e.value = { ...e.value, enclosureInfo: t, structureSaveRequestVOS: t[u.STRUCTURE.V], profiledPlateSaveRequestVOS: t[u.PROFILED_PLATE.V], pressureBearingPlateSaveVOS: t[u.PRESSURE_BEARING_PLATE.V], trussFloorPlateSaveRequestVOS: t[u.TRUSS_FLOOR_PLATE.V], sandwichBoardSaveRequestVOS: t[u.SANDWICH_BOARD.V] }, _.value = false;
  }
  async function Re() {
    try {
      const t = await R.value.validate();
      return t && (e.value.taxRate = e.value.businessTaxRate ? e.value.businessTaxRate / 100 : void 0, Object.assign(z.formData, JSON.parse(JSON.stringify(e.value)))), t;
    } catch (t) {
      return console.log("error", t), false;
    }
  }
  return oe({ validateForm: Re }), (t, l) => {
    const n = Ue, y = A("common-select-v2"), f = Me, i = Ce, c = Le, T = Ne, B = Ae, N = A("common-radio"), _e = we, Se = A("common-select"), j = A("common-button"), be = A("common-drawer"), Oe = De;
    return v(), S(Oe, { ref_key: "formRef", ref: R, model: e.value, rules: pe, class: "form-margin", inline: "", "label-position": "right", "label-width": "110px", size: "default" }, { default: s(() => {
      var $;
      return [d("div", null, [d("div", Je, [d("div", ze, [o(n, { label: "合同签订主体", prop: "contractSignBodyId" }, { default: s(() => [o(Fe, { modelValue: e.value.contractSignBodyId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e.value.contractSignBodyId = a), class: "input-underline", default: "", placeholder: "合同签订主体", style: { width: "550px" } }, null, 8, ["modelValue"])]), _: 1 })]), d("div", Ye, [o(n, { label: "业务类型", prop: "businessType" }, { default: s(() => [o(y, { modelValue: e.value.businessType, "onUpdate:modelValue": l[1] || (l[1] = (a) => e.value.businessType = a), options: p(h).ENUM, class: "input-underline", clearable: "", placeholder: "业务类型", size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(n, { label: "项目类型", prop: "projectType" }, { default: s(() => [o(y, { modelValue: e.value.projectType, "onUpdate:modelValue": l[2] || (l[2] = (a) => e.value.projectType = a), disabled: !e.value.businessType, options: p(ne), class: "input-underline", clearable: "", placeholder: "项目类型", size: "default", style: { width: "200px" }, type: "enum", onChange: ve }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), o(n, { label: "项目内容", prop: "projectContent" }, { default: s(() => [o(f, { ref: "cascaderRef", modelValue: e.value.projectContent, "onUpdate:modelValue": l[3] || (l[3] = (a) => e.value.projectContent = a), clearable: true, disable: !e.value.businessType || !e.value.projectType, options: ce.value || [], props: se.value, "show-all-levels": true, class: "input-underline", filterable: "", placeholder: "项目内容,可多选", style: { width: "320px" }, onChange: Ee }, null, 8, ["modelValue", "disable", "options", "props"])]), _: 1 })]), d("div", Xe, [o(n, { label: "签订日期", prop: "signingDate" }, { default: s(() => [o(i, { modelValue: e.value.signingDate, "onUpdate:modelValue": l[4] || (l[4] = (a) => e.value.signingDate = a), class: "input-underline", placeholder: "选择签订日期", style: { width: "200px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), o(n, { label: "签约地址", prop: "signingAddress" }, { default: s(() => [o(c, { modelValue: e.value.signingAddress, "onUpdate:modelValue": l[5] || (l[5] = (a) => e.value.signingAddress = a), modelModifiers: { trim: true }, class: "input-underline", maxlength: "200", placeholder: "签约地址", style: { width: "400px" } }, null, 8, ["modelValue"])]), _: 1 })]), e.value.structureMeasureMode ? (v(), O("div", $e, [o(T, null, { default: s(() => l[19] || (l[19] = [d("span", { class: "title" }, "结构", -1)])), _: 1, __: [19] }), d("div", Ke, [o(n, { label: "结构工程量", prop: "quantityWork" }, { default: s(() => [o(B, { modelValue: e.value.quantityWork, "onUpdate:modelValue": l[6] || (l[6] = (a) => e.value.quantityWork = a), controls: false, max: 99999999, min: 0, precision: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "", style: { width: "200px" } }, null, 8, ["modelValue"]), l[20] || (l[20] = b(" 吨 "))]), _: 1, __: [20] }), o(n, { label: "结构类型", prop: "structureTypeId" }, { default: s(() => [o(p(We), { modelValue: e.value.structureTypeId, "onUpdate:modelValue": l[7] || (l[7] = (a) => e.value.structureTypeId = a), projectType: e.value.projectType, class: "input-underline", "data-structure": { key: "value", label: "label", value: "value" }, size: "default", placeholder: "结构类型", style: { width: "200px" } }, null, 8, ["modelValue", "projectType"])]), _: 1 })]), d("div", Qe, [o(n, { label: "结构结算方式", prop: "structureMeasureMode" }, { default: s(() => [o(N, { modelValue: e.value.structureMeasureMode, "onUpdate:modelValue": l[8] || (l[8] = (a) => e.value.structureMeasureMode = a), disabled: !e.value.structureMeasureMode, options: p(H).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), o(n, { label: "结构运输方式", prop: "transportMode" }, { default: s(() => [o(N, { modelValue: e.value.transportMode, "onUpdate:modelValue": l[9] || (l[9] = (a) => e.value.transportMode = a), options: p(w).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })])])) : V("", true), e.value.measureModeList && e.value.measureModeList.length > 0 ? (v(), O("div", Ze, [o(T, null, { default: s(() => l[21] || (l[21] = [d("span", { class: "title" }, "围护", -1)])), _: 1, __: [21] }), o(n, { label: "围护运输方式", prop: "enclosureTransportMode" }, { default: s(() => [o(N, { modelValue: e.value.enclosureTransportMode, "onUpdate:modelValue": l[10] || (l[10] = (a) => e.value.enclosureTransportMode = a), options: p(w).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), e.value.projectType !== p(m).ENCLOSURE.V && (($ = e.value.measureModeList) == null ? void 0 : $.length) > 0 ? (v(), S(n, { key: 0, label: "围护结算方式与工程量", "label-width": "220px", prop: "measureModeList" }, { default: s(() => [e.value.measureModeList.length > 0 ? (v(true), O(Z, { key: 0 }, ee(e.value.measureModeList, (a, Ie) => (v(), O("div", { key: Ie, style: { display: "flex" } }, [d("span", el, q(p(x).VL[a.no]) + "：", 1), o(N, { modelValue: a.measureMode, "onUpdate:modelValue": (k) => a.measureMode = k, options: p(W).ENUM, style: { float: "left" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), o(B, { modelValue: a.quantityWork, "onUpdate:modelValue": (k) => a.quantityWork = k, controls: false, max: 99999999, min: 0, precision: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "工程量", style: { width: "120px", "margin-left": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), d("span", ll, q(a.measureMode === p(W).LENGTH.V ? "m" : "㎡"), 1)]))), 128)) : V("", true)]), _: 1 })) : V("", true)])) : V("", true), d("div", tl, [o(n, { label: "支付方式", prop: "payType" }, { default: s(() => [o(N, { modelValue: e.value.payType, "onUpdate:modelValue": l[11] || (l[11] = (a) => e.value.payType = a), options: p(te).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(n, { label: "合同含税", prop: "isTax" }, { default: s(() => [o(p(xe), { modelValue: e.value.isTax, "onUpdate:modelValue": l[12] || (l[12] = (a) => e.value.isTax = a), onChange: ye }, { default: s(() => [(v(true), O(Z, null, ee(p(G).ENUM, (a) => (v(), S(_e, { key: a.V, value: a.V }, { default: s(() => [b(q(a.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), d("div", al, [o(n, { label: "发票类型", prop: "invoiceType" }, { default: s(() => [o(Se, { modelValue: e.value.invoiceType, "onUpdate:modelValue": l[13] || (l[13] = (a) => e.value.invoiceType = a), disabled: !e.value.isTax, options: p(I).ENUM, class: "input-underline", placeholder: "选择发票类型", size: "default", style: { width: "200px" }, type: "enum", onChange: Te }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), e.value.isTax && e.value.invoiceType !== p(I).RECEIPT.V ? (v(), S(n, { key: 0, label: "税率", prop: "businessTaxRate" }, { label: s(() => l[22] || (l[22] = [d("span", { style: { color: "#f56c6c" } }, "*", -1), b(" 税率 ")])), default: s(() => [o(B, { modelValue: e.value.businessTaxRate, "onUpdate:modelValue": l[14] || (l[14] = (a) => e.value.businessTaxRate = a), controls: false, disabled: !e.value.isTax || e.value.invoiceType === p(I).RECEIPT.V, max: 100, min: 0, precision: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "0-100", style: { width: "80px" } }, null, 8, ["modelValue", "disabled"]), l[23] || (l[23] = b(" % "))]), _: 1, __: [23] })) : V("", true)]), d("div", ol, [o(n, { label: "支付方式描述", prop: "payTypeDesc" }, { default: s(() => [o(c, { modelValue: e.value.payTypeDesc, "onUpdate:modelValue": l[15] || (l[15] = (a) => e.value.payTypeDesc = a), modelModifiers: { trim: true }, autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", placeholder: "付款方式描述", "show-word-limit": "", style: { width: "550px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), d("div", nl, [o(n, { label: "技术要求描述", prop: "technologyRemark" }, { default: s(() => [o(c, { modelValue: e.value.technologyRemark, "onUpdate:modelValue": l[16] || (l[16] = (a) => e.value.technologyRemark = a), modelModifiers: { trim: true }, autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", placeholder: "付款方式描述", "show-word-limit": "", style: { width: "550px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])]), e.value.projectType !== p(m).BRIDGE.V ? (v(), S(T, { key: 0 }, { default: s(() => l[24] || (l[24] = [d("span", { class: "title" }, "技术交底", -1)])), _: 1, __: [24] })) : V("", true), e.value.projectType !== p(m).BRIDGE.V ? (v(), O("div", sl, [o(j, { disabled: !(r.value && r.value.length > 0), size: "default", style: { "margin-left": "20px" }, type: "success", onClick: Ve }, { default: s(() => l[25] || (l[25] = [b("添加 ")])), _: 1, __: [25] }, 8, ["disabled"])])) : V("", true), r.value && r.value.length > 0 ? (v(), S(p(He), { key: 2, "show-item": r.value, "table-data": e.value.enclosureInfo, onClickChange: ge }, null, 8, ["show-item", "table-data"])) : V("", true), o(n, { prop: "enclosureInfo", style: { display: "block" } }, { default: s(() => l[26] || (l[26] = [d("div", null, null, -1)])), _: 1, __: [26] }), o(be, { modelValue: _.value, "onUpdate:modelValue": l[18] || (l[18] = (a) => _.value = a), "before-close": () => {
        _.value = false;
      }, "show-close": false, "with-header": true, "wrapper-closable": false, direction: "rtl", size: "80%" }, { title: s(() => [l[29] || (l[29] = d("span", { class: "line-title" }, "添加技术交底", -1)), d("span", null, [r.value && r.value.length > 0 ? (v(), S(j, { key: 0, size: "default", type: "primary", onClick: X }, { default: s(() => l[27] || (l[27] = [b("保存")])), _: 1, __: [27] })) : V("", true), o(j, { size: "default", type: "info", onClick: l[17] || (l[17] = (a) => _.value = false) }, { default: s(() => l[28] || (l[28] = [b("取消")])), _: 1, __: [28] })])]), content: s(() => [o(p(Ge), { ref_key: "enclosureFormRef", ref: L, "default-type": P.value, enclosureVisible: _.value, "init-form": e.value.enclosureInfo, "show-category": C.value, "show-item": r.value }, null, 8, ["default-type", "enclosureVisible", "init-form", "show-category", "show-item"])]), _: 1 }, 8, ["modelValue", "before-close"])])];
    }), _: 1 }, 8, ["model"]);
  };
} }, Sl = Be(ul, [["__scopeId", "data-v-6b09e131"]]);
export {
  Sl as default
};
