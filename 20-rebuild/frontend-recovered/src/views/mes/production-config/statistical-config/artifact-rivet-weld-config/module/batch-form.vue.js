import { inject as y } from "vue";
import { ref as O } from "vue";
import { reactive as ie } from "vue";
import { computed as L } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as d } from "vue";
import { createBlock as j } from "vue";
import { withCtx as r } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import { createTextVNode as S } from "vue";
import { withDirectives as ne } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as P } from "vue";
import { createElementVNode as ce } from "vue";
import { Fragment as R } from "vue";
import { renderList as re } from "vue";
import { createCommentVNode as de } from "vue";
import { withModifiers as ue } from "vue";
import { nextTick as pe } from "vue";
import { ElTableColumn as me } from "element-plus";
import { ElForm as fe } from "element-plus";
import { vLoading as be } from "element-plus";
import { _ as ge, t as he, a_ as _e, o as ye, a$ as ve, i as T, aT as z, aw as xe, V as F, aI as Ve } from "../../../../../../shared/runtime.js";
const Ce = { key: 0 }, Ne = { key: 1 }, Oe = { key: 0 }, je = { key: 1 }, Te = 5, ke = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true }, currentType: { type: Number, default: void 0 } }, setup(v) {
  const { decimalPrecision: E } = he(), M = v, Q = y("rivetWeldListObj"), D = y("processList"), H = y("artifactTypeList"), x = y("artifactTypeListObj"), $ = O(false), V = O(true), q = ie({ list: [] }), A = { classificationId: [{ required: true, message: "请选择构件类型", trigger: "change" }], numerical: [{ validator: (t, e) => !(!e.minNumerical || !e.maxNumerical || e.maxNumerical < e.minNumerical), message: "请填写构件截面并且最大数值不得小于最小数值", trigger: "blur" }] }, C = /* @__PURE__ */ new Map([["classificationId", -1]]), k = O(), { CRUD: N, crud: p, form: c } = _e(q, k), w = L(() => p.bStatus.cu > N.STATUS.NORMAL), { tableValidate: W, cleanUpData: G, wrongCellMask: K } = xe({ rules: A, ditto: C }), { maxHeight: J } = ye({ mainBox: ".rivet-weld-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, w);
  function X() {
    ee(c.list), V.value = true, pe(() => {
      V.value = false;
    });
  }
  N.HOOK.beforeValidateBCU = () => {
    const { validResult: t, dealList: e } = W(c.list);
    if (t) c.list = e;
    else return t;
  }, p.submitBatchFormFormat = async (t) => (G(t.list), t.list.map((o) => ({ artifactTypeId: M.currentType, classificationId: o.classificationId, maxNumerical: o.maxNumerical, minNumerical: o.minNumerical, structureProcessPriceList: ve(o.processObj) })));
  const b = L(() => {
    var o;
    const t = {};
    if (!((o = c.list) != null && o.length)) return t;
    let e = null;
    for (let i = 0; i < c.list.length; i++) e = c.list[i].classificationId !== -1 ? c.list[i].classificationId : e, t[i] = e;
    return t;
  });
  function Y(t, e) {
    var i, g;
    let o = {};
    T((i = x.value[t]) == null ? void 0 : i.typeProcessObj) && (o = (g = x.value[t]) == null ? void 0 : g.typeProcessObj);
    for (const m in b.value) b.value[m] === t && (c.list[m].processObj = F(o));
  }
  function Z(t, e) {
    for (const o in b.value) b.value[o] === b.value[e] && (c.list[Number(o)].wageQuotaType = t);
  }
  const ee = (t) => {
    t.length = 0;
    for (let e = 0; e < Te; e++) U(t);
  }, U = (t) => {
    const e = { processObj: {} };
    e.uid = Ve(), C && t.length > 0 && C.forEach((o, i) => {
      e[i] = o;
    }), t.length && T(t[t.length - 1].processObj) && (e.processObj = F(t[t.length - 1].processObj)), t.push(e);
  }, te = (t, e) => {
    t.splice(e, 1);
  };
  return (t, e) => {
    var B;
    const o = _("common-button"), i = me, g = _("common-select"), m = _("common-input-number"), ae = _("common-table"), le = fe, oe = _("common-dialog"), se = be;
    return d(), j(oe, { fullscreen: "", "append-to-body": "", "close-on-click-modal": false, "before-close": s(p).cancelBCU, visible: w.value, title: `${s(p).bStatus.title}${v.currentType ? `: ${(B = s(Q)[v.currentType]) == null ? void 0 : B.typeName}` : ""}`, "show-close": false, "custom-class": "rivet-weld-config-batch-add", onOpened: X, top: "10vh" }, { titleRight: r(() => [n(o, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (a) => U(s(c).list)) }), n(o, { loading: s(p).bStatus.cu === s(N).STATUS.PROCESSING, type: "primary", size: "default", onClick: s(p).submitBCU }, { default: r(() => e[1] || (e[1] = [S(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), n(o, { size: "default", onClick: s(p).cancelBCU }, { default: r(() => e[2] || (e[2] = [S("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: r(() => [n(le, { ref_key: "formRef", ref: k, model: s(c), disabled: $.value }, { default: r(() => [ne((d(), j(ae, { ref: "table", data: s(c).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": s(J), "default-expand-all": "", "cell-class-name": s(K), "row-key": "uid" }, { default: r(() => [n(i, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(i, { prop: "classificationId", "show-overflow-tooltip": true, label: "构件类型", width: "150", align: "center", fixed: "left" }, { default: r(({ row: a, $index: l }) => [n(g, { modelValue: a.classificationId, "onUpdate:modelValue": (u) => a.classificationId = u, options: s(H), "show-extra": l !== 0, type: "other", class: "input-underline", dataStructure: { key: "id", label: "classificationName", value: "id" }, placeholder: "构件类型", style: { width: "100%" }, onChange: (u) => Y(u, l) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])]), _: 1 }), n(i, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", width: "150", align: "center", fixed: "left" }, { default: r(({ row: a, $index: l }) => {
      var u;
      return [a.classificationId === -1 && l !== 0 ? (d(), f("span", Ce, "同上")) : (d(), f("span", Ne, P(a.classificationId && ((u = s(x)[a.classificationId]) == null ? void 0 : u.specPrefixStr)), 1))];
    }), _: 1 }), n(i, { prop: "numerical", "show-overflow-tooltip": true, label: "构件截面", width: "200", align: "center", fixed: "left" }, { default: r(({ row: a }) => [n(m, { modelValue: a.minNumerical, "onUpdate:modelValue": (l) => a.minNumerical = l, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[3] || (e[3] = ce("span", null, " ~ ", -1)), n(m, { modelValue: a.maxNumerical, "onUpdate:modelValue": (l) => a.maxNumerical = l, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(i, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: r(() => [(d(true), f(R, null, re(s(D), (a) => (d(), j(i, { key: a.id, "show-overflow-tooltip": true, align: "center", label: a.name, width: "240px" }, { default: r(({ row: l, $index: u }) => {
      var I;
      return [s(T)(l == null ? void 0 : l.processObj[a.id]) ? (d(), f(R, { key: 0 }, [n(g, { modelValue: l.processObj[a.id].wageQuotaType, "onUpdate:modelValue": (h) => l.processObj[a.id].wageQuotaType = h, options: s(z).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "45%", "margin-right": "5px" }, onChange: (h) => Z(h, u) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]), n(m, { modelValue: l.processObj[a.id].price, "onUpdate:modelValue": (h) => l.processObj[a.id].price = h, step: 1, min: 0, precision: s(E).mes, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]), (I = l == null ? void 0 : l.processObj[a.id]) != null && I.wageQuotaType ? (d(), f("span", Oe, P(s(z).V[l.processObj[a.id].wageQuotaType].unit), 1)) : de("", true)], 64)) : (d(), f("span", je, "-"))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), n(i, { "min-width": "1px" }), n(i, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: r(({ $index: a }) => [n(o, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: ue((l) => te(s(c).list, a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[se, V.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ie = ge(ke, [["__scopeId", "data-v-9c03eb12"]]);
export {
  Ie as default
};
