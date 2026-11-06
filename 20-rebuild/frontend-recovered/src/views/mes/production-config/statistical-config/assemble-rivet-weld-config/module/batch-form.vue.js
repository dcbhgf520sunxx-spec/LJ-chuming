import { inject as C } from "vue";
import { ref as O } from "vue";
import { reactive as te } from "vue";
import { computed as B } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as d } from "vue";
import { createBlock as N } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { createTextVNode as A } from "vue";
import { withDirectives as ae } from "vue";
import { createElementBlock as b } from "vue";
import { toDisplayString as I } from "vue";
import { createElementVNode as se } from "vue";
import { Fragment as S } from "vue";
import { renderList as oe } from "vue";
import { createCommentVNode as ne } from "vue";
import { withModifiers as ie } from "vue";
import { nextTick as ce } from "vue";
import { ElTableColumn as re } from "element-plus";
import { ElForm as de } from "element-plus";
import { vLoading as ue } from "element-plus";
import { _ as me, t as pe, a_ as be, o as fe, a$ as _e, i as j, aT as L, aw as ge, V as P, aI as he } from "../../../../../../shared/runtime.js";
const ye = { key: 0 }, xe = { key: 1 }, ve = { key: 0 }, Ve = { key: 1 }, Ce = 5, Oe = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true } }, setup(Ne) {
  const { decimalPrecision: R } = pe(), z = C("processList"), F = C("assembleTypeList"), y = C("assembleTypeListObj"), E = O(false), x = O(true), M = te({ list: [] }), Q = { sysAssembleId: [{ required: true, message: "请选择部件类型", trigger: "change" }], numerical: [{ validator: (l, e) => !(!e.minNumerical || !e.maxNumerical || e.maxNumerical < e.minNumerical), message: "请填写部件截面并且最大数值不得小于最小数值", trigger: "blur" }] }, v = /* @__PURE__ */ new Map([["sysAssembleId", -1]]), k = O(), { CRUD: V, crud: m, form: c } = be(M, k), w = B(() => m.bStatus.cu > V.STATUS.NORMAL), { tableValidate: D, cleanUpData: H, wrongCellMask: q } = ge({ rules: Q, ditto: v }), { maxHeight: $ } = fe({ mainBox: ".rivet-weld-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, w);
  function G() {
    W(c.list), x.value = true, ce(() => {
      x.value = false;
    });
  }
  V.HOOK.beforeValidateBCU = () => {
    const { validResult: l, dealList: e } = D(c.list);
    if (l) c.list = e;
    else return l;
  }, m.submitBatchFormFormat = async (l) => (H(l.list), l.list.map((s) => ({ sysAssembleId: s.sysAssembleId, maxNumerical: s.maxNumerical, minNumerical: s.minNumerical, structureProcessPriceList: _e(s.processObj) })));
  const f = B(() => {
    var s;
    const l = {};
    if (!((s = c.list) != null && s.length)) return l;
    let e = null;
    for (let o = 0; o < c.list.length; o++) e = c.list[o].sysAssembleId !== -1 ? c.list[o].sysAssembleId : e, l[o] = e;
    return l;
  });
  function K(l, e) {
    var o, _;
    let s = {};
    j((o = y.value[l]) == null ? void 0 : o.typeProcessObj) && (s = (_ = y.value[l]) == null ? void 0 : _.typeProcessObj);
    for (const p in f.value) f.value[p] === l && (c.list[p].processObj = P(s));
  }
  function J(l, e) {
    for (const s in f.value) f.value[s] === f.value[e] && (c.list[Number(s)].wageQuotaType = l);
  }
  const W = (l) => {
    l.length = 0;
    for (let e = 0; e < Ce; e++) T(l);
  }, T = (l) => {
    const e = { processObj: {} };
    e.uid = he(), v && l.length > 0 && v.forEach((s, o) => {
      e[o] = s;
    }), l.length && j(l[l.length - 1].processObj) && (e.processObj = P(l[l.length - 1].processObj)), l.push(e);
  }, X = (l, e) => {
    l.splice(e, 1);
  };
  return (l, e) => {
    const s = h("common-button"), o = re, _ = h("common-select"), p = h("common-input-number"), Y = h("common-table"), Z = de, ee = h("common-dialog"), le = ue;
    return d(), N(ee, { fullscreen: "", "append-to-body": "", "close-on-click-modal": false, "before-close": n(m).cancelBCU, visible: w.value, title: `${n(m).bStatus.title}`, "show-close": false, "custom-class": "rivet-weld-config-batch-add", onOpened: G, top: "10vh" }, { titleRight: r(() => [i(s, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (t) => T(n(c).list)) }), i(s, { loading: n(m).bStatus.cu === n(V).STATUS.PROCESSING, type: "primary", size: "default", onClick: n(m).submitBCU }, { default: r(() => e[1] || (e[1] = [A(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), i(s, { size: "default", onClick: n(m).cancelBCU }, { default: r(() => e[2] || (e[2] = [A("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: r(() => [i(Z, { ref_key: "formRef", ref: k, model: n(c), disabled: E.value }, { default: r(() => [ae((d(), N(Y, { ref: "table", data: n(c).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": n($), "default-expand-all": "", "cell-class-name": n(q), "row-key": "uid" }, { default: r(() => [i(o, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), i(o, { prop: "sysAssembleId", "show-overflow-tooltip": true, label: "部件类型", width: "150", align: "center", fixed: "left" }, { default: r(({ row: t, $index: a }) => [i(_, { modelValue: t.sysAssembleId, "onUpdate:modelValue": (u) => t.sysAssembleId = u, options: n(F), "show-extra": a !== 0, type: "other", class: "input-underline", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "部件类型", style: { width: "100%" }, onChange: (u) => K(u, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])]), _: 1 }), i(o, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", width: "150", align: "center", fixed: "left" }, { default: r(({ row: t, $index: a }) => {
      var u;
      return [t.sysAssembleId === -1 && a !== 0 ? (d(), b("span", ye, "同上")) : (d(), b("span", xe, I(t.sysAssembleId && ((u = n(y)[t.sysAssembleId]) == null ? void 0 : u.specPrefixStr)), 1))];
    }), _: 1 }), i(o, { prop: "numerical", "show-overflow-tooltip": true, label: "部件截面", width: "200", align: "center", fixed: "left" }, { default: r(({ row: t }) => [i(p, { modelValue: t.minNumerical, "onUpdate:modelValue": (a) => t.minNumerical = a, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[3] || (e[3] = se("span", null, " ~ ", -1)), i(p, { modelValue: t.maxNumerical, "onUpdate:modelValue": (a) => t.maxNumerical = a, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(o, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: r(() => [(d(true), b(S, null, oe(n(z), (t) => (d(), N(o, { key: t.id, "show-overflow-tooltip": true, align: "center", label: t.name, width: "240px" }, { default: r(({ row: a, $index: u }) => {
      var U;
      return [n(j)(a == null ? void 0 : a.processObj[t.id]) ? (d(), b(S, { key: 0 }, [i(_, { modelValue: a.processObj[t.id].wageQuotaType, "onUpdate:modelValue": (g) => a.processObj[t.id].wageQuotaType = g, options: n(L).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "45%", "margin-right": "5px" }, onChange: (g) => J(g, u) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]), i(p, { modelValue: a.processObj[t.id].price, "onUpdate:modelValue": (g) => a.processObj[t.id].price = g, step: 1, min: 0, precision: n(R).mes, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]), (U = a == null ? void 0 : a.processObj[t.id]) != null && U.wageQuotaType ? (d(), b("span", ve, I(n(L).V[a.processObj[t.id].wageQuotaType].unit), 1)) : ne("", true)], 64)) : (d(), b("span", Ve, "-"))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), i(o, { "min-width": "1px" }), i(o, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: r(({ $index: t }) => [i(s, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: ie((a) => X(n(c).list, t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[le, x.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Te = me(Oe, [["__scopeId", "data-v-ba2d0ea9"]]);
export {
  Te as default
};
