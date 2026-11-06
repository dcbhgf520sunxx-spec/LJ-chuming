import { inject as C } from "vue";
import { ref as O } from "vue";
import { reactive as le } from "vue";
import { computed as B } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as d } from "vue";
import { createBlock as j } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { createTextVNode as A } from "vue";
import { withDirectives as te } from "vue";
import { createElementBlock as b } from "vue";
import { toDisplayString as I } from "vue";
import { createElementVNode as se } from "vue";
import { Fragment as S } from "vue";
import { renderList as ae } from "vue";
import { createCommentVNode as oe } from "vue";
import { withModifiers as ne } from "vue";
import { nextTick as ie } from "vue";
import { ElTableColumn as ce } from "element-plus";
import { ElForm as re } from "element-plus";
import { vLoading as de } from "element-plus";
import { _ as ue, a_ as me, o as pe, a$ as be, i as N, aT as L, aw as fe, V as R, aI as _e } from "../../../../../../shared/runtime.js";
const ge = { key: 0 }, he = { key: 1 }, ye = { key: 0 }, xe = { key: 1 }, ve = 5, Ve = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true } }, setup(Ce) {
  const z = C("processList"), F = C("assembleTypeList"), y = C("assembleTypeListObj"), P = O(false), x = O(true), E = le({ list: [] }), M = { sysAssembleId: [{ required: true, message: "请选择单元件类型", trigger: "change" }], numerical: [{ validator: (l, e) => !(!e.minNumerical || !e.maxNumerical || e.maxNumerical < e.minNumerical), message: "请填写数值并且最大数值不得小于最小数值", trigger: "blur" }] }, v = /* @__PURE__ */ new Map([["sysAssembleId", -1]]), k = O(), { CRUD: V, crud: m, form: c } = me(E, k), w = B(() => m.bStatus.cu > V.STATUS.NORMAL), { tableValidate: Q, cleanUpData: D, wrongCellMask: H } = fe({ rules: M, ditto: v }), { maxHeight: q } = pe({ mainBox: ".rivet-weld-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, w);
  function $() {
    J(c.list), x.value = true, ie(() => {
      x.value = false;
    });
  }
  V.HOOK.beforeValidateBCU = () => {
    const { validResult: l, dealList: e } = Q(c.list);
    if (l) c.list = e;
    else return l;
  }, m.submitBatchFormFormat = async (l) => (D(l.list), l.list.map((o) => ({ sysAssembleId: o.sysAssembleId, maxNumerical: o.maxNumerical, minNumerical: o.minNumerical, structureProcessPriceList: be(o.processObj) })));
  const f = B(() => {
    var o;
    const l = {};
    if (!((o = c.list) != null && o.length)) return l;
    let e = null;
    for (let s = 0; s < c.list.length; s++) e = c.list[s].sysAssembleId !== -1 ? c.list[s].sysAssembleId : e, l[s] = e;
    return l;
  });
  function G(l, e) {
    var s, _;
    let o = {};
    N((s = y.value[l]) == null ? void 0 : s.typeProcessObj) && (o = (_ = y.value[l]) == null ? void 0 : _.typeProcessObj);
    for (const p in f.value) f.value[p] === l && (c.list[p].processObj = R(o));
  }
  function K(l, e, o) {
    for (const s in f.value) f.value[s] === f.value[e] && (c.list[Number(s)].processObj[o].wageQuotaType = l);
  }
  const J = (l) => {
    l.length = 0;
    for (let e = 0; e < ve; e++) T(l);
  }, T = (l) => {
    const e = { processObj: {} };
    e.uid = _e(), v && l.length > 0 && v.forEach((o, s) => {
      e[s] = o;
    }), l.length && N(l[l.length - 1].processObj) && (e.processObj = R(l[l.length - 1].processObj)), l.push(e);
  }, W = (l, e) => {
    l.splice(e, 1);
  };
  return (l, e) => {
    const o = h("common-button"), s = ce, _ = h("common-select"), p = h("common-input-number"), X = h("common-table"), Y = re, Z = h("common-dialog"), ee = de;
    return d(), j(Z, { fullscreen: "", "append-to-body": "", "close-on-click-modal": false, "before-close": n(m).cancelBCU, visible: w.value, title: `${n(m).bStatus.title}`, "show-close": false, "custom-class": "rivet-weld-config-batch-add", onOpened: $, top: "10vh" }, { titleRight: r(() => [i(o, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (t) => T(n(c).list)) }), i(o, { loading: n(m).bStatus.cu === n(V).STATUS.PROCESSING, type: "primary", size: "default", onClick: n(m).submitBCU }, { default: r(() => e[1] || (e[1] = [A(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), i(o, { size: "default", onClick: n(m).cancelBCU }, { default: r(() => e[2] || (e[2] = [A("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: r(() => [i(Y, { ref_key: "formRef", ref: k, model: n(c), disabled: P.value }, { default: r(() => [te((d(), j(X, { ref: "table", data: n(c).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": n(q), "default-expand-all": "", "cell-class-name": n(H), "row-key": "uid" }, { default: r(() => [i(s, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), i(s, { prop: "sysAssembleId", "show-overflow-tooltip": true, label: "单元件类型", width: "150", align: "center", fixed: "left" }, { default: r(({ row: t, $index: a }) => [i(_, { modelValue: t.sysAssembleId, "onUpdate:modelValue": (u) => t.sysAssembleId = u, options: n(F), "show-extra": a !== 0, type: "other", class: "input-underline", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "单元件类型", style: { width: "100%" }, onChange: (u) => G(u, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])]), _: 1 }), i(s, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", width: "150", align: "center", fixed: "left" }, { default: r(({ row: t, $index: a }) => {
      var u;
      return [t.sysAssembleId === -1 && a !== 0 ? (d(), b("span", ge, "同上")) : (d(), b("span", he, I(t.sysAssembleId && ((u = n(y)[t.sysAssembleId]) == null ? void 0 : u.specPrefixStr)), 1))];
    }), _: 1 }), i(s, { prop: "numerical", "show-overflow-tooltip": true, label: "数值", width: "200", align: "center", fixed: "left" }, { default: r(({ row: t }) => [i(p, { modelValue: t.minNumerical, "onUpdate:modelValue": (a) => t.minNumerical = a, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[3] || (e[3] = se("span", null, " ~ ", -1)), i(p, { modelValue: t.maxNumerical, "onUpdate:modelValue": (a) => t.maxNumerical = a, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(s, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: r(() => [(d(true), b(S, null, ae(n(z), (t) => (d(), j(s, { key: t.id, "show-overflow-tooltip": true, align: "center", label: t.name, width: "240px" }, { default: r(({ row: a, $index: u }) => {
      var U;
      return [n(N)(a == null ? void 0 : a.processObj[t.id]) ? (d(), b(S, { key: 0 }, [i(_, { modelValue: a.processObj[t.id].wageQuotaType, "onUpdate:modelValue": (g) => a.processObj[t.id].wageQuotaType = g, options: n(L).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "45%", "margin-right": "5px" }, onChange: (g) => K(g, u, t.id) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]), i(p, { modelValue: a.processObj[t.id].price, "onUpdate:modelValue": (g) => a.processObj[t.id].price = g, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), (U = a == null ? void 0 : a.processObj[t.id]) != null && U.wageQuotaType ? (d(), b("span", ye, I(n(L).V[a.processObj[t.id].wageQuotaType].unit), 1)) : oe("", true)], 64)) : (d(), b("span", xe, "-"))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), i(s, { "min-width": "1px" }), i(s, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: r(({ $index: t }) => [i(o, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: ne((a) => W(n(c).list, t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[ee, x.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ke = ue(Ve, [["__scopeId", "data-v-18eedb07"]]);
export {
  ke as default
};
