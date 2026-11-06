import { inject as O } from "vue";
import { ref as _ } from "vue";
import { reactive as Z } from "vue";
import { computed as ee } from "vue";
import { watch as te } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as d } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as g } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as I } from "vue";
import { vShow as M } from "vue";
import { unref as f } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as N } from "vue";
import { Fragment as ne } from "vue";
import { mergeProps as ae } from "vue";
import { isRef as oe } from "vue";
import { ElInput as se } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { InfoFilled as re } from "@element-plus/icons-vue";
import { ElIcon as de } from "element-plus";
import { ElTooltip as ue } from "element-plus";
import { vLoading as ce } from "element-plus";
import { _ as me, u as fe, o as pe } from "../../../../../shared/runtime.js";
import { u as _e } from "../../../../../modules/use-table-change-32e98420.js";
import { _ as ve } from "./config-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const ge = { class: "class-unit-config" }, be = { class: "query-content" }, ye = { class: "classify-name" }, he = { class: "classify-name" }, we = { style: { margin: "0 10px" } }, xe = { class: "classify-name" }, Ce = { key: 1 }, Ve = { __name: "config", props: { classificationList: { type: Array, default: () => [] }, level: { type: Number, default: 2 }, visible: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(b, { emit: H }) {
  const z = H, u = b, L = O("sourceMap"), U = O("permission"), E = _(), w = _([]), x = Z({ nameOrCode: "" }), C = _(false), c = _(false), V = _(false), { visible: k, handleClose: q } = fe({ emit: z, props: u, field: "visible", closeHook: B }), { changedCellMask: D } = _e({ fieldMap: L }), { maxHeight: T } = pe({ mainBox: ".common-drawer", extraBox: [".el-drawer__header", ".query-content"], wrapperBox: [".el-drawer__body", ".class-unit-config"], navbar: false, clientHRepMainH: true, extraHeight: 50, minHeight: 300 }, () => E.value.loaded), j = ee(() => {
    const o = x.nameOrCode, e = w.value.filter((i) => i.fullName.some((s) => s.indexOf(o) > -1) || i.fullSerialNumber.some((s) => s.indexOf(o) > -1));
    return A(e);
  });
  te([() => u.visible, () => u.classificationList, () => u.level], ([o]) => {
    o && $();
  }, { immediate: true });
  function $() {
    V.value = true, w.value = u.classificationList, V.value = false;
  }
  function B() {
    c.value = false, $();
  }
  function F() {
    C.value = true;
  }
  function A(o) {
    if (o.length === 0) return o;
    const e = [[], []], i = [-1, -1];
    return o.forEach((s) => {
      for (let t = 0; t < e.length; t++) {
        const m = s.fullId[t], p = i.length > t ? i[t] : void 0;
        m === p ? e[t][e[t].length - 1]++ : (e[t].push(1), i[t] = m);
      }
    }), e[0].reduce((s, t) => (o[s].name1_rowSpan = t, s += t, s), 0), e[1].reduce((s, t) => (o[s].name2_rowSpan = t, s += t, s), 0), o;
  }
  function P({ row: o, column: e, rowIndex: i, columnIndex: s }) {
    if (u.level > 1) {
      if (e.property === "first") return { rowspan: o.name1_rowSpan || 0, colspan: 1 };
      if (u.level > 2 && e.property === "second") return { rowspan: o.name2_rowSpan || 0, colspan: 1 };
    }
  }
  function G() {
    c.value = false;
  }
  return (o, e) => {
    const i = y("common-button"), s = se, t = ie, m = re, p = de, R = ue, J = y("common-input-number"), K = y("common-table"), Q = y("common-drawer"), W = le("permission"), X = ce;
    return d(), v(Q, { ref_key: "drawerRef", ref: E, modelValue: f(k), "onUpdate:modelValue": e[3] || (e[3] = (l) => oe(k) ? k.value = l : null), direction: "rtl", size: "75%", title: "研发费用占比配置", "wrapper-closable": false, "before-close": f(q) }, { titleRight: n(() => [g((d(), S("span", null, [g(a(i, { size: "default", type: "primary", onClick: F }, { default: n(() => e[4] || (e[4] = [I("保存预览")])), _: 1, __: [4] }, 512), [[M, c.value]]), g(a(i, { size: "default", type: "danger", onClick: B }, { default: n(() => e[5] || (e[5] = [I("退出编辑")])), _: 1, __: [5] }, 512), [[M, c.value]]), g(a(i, { size: "default", type: "primary", onClick: e[0] || (e[0] = (l) => c.value = true) }, { default: n(() => e[6] || (e[6] = [I("编辑")])), _: 1, __: [6] }, 512), [[M, !c.value]])])), [[W, f(U).set]])]), content: n(() => [r("div", ge, [r("div", be, [a(s, { modelValue: x.nameOrCode, "onUpdate:modelValue": e[1] || (e[1] = (l) => x.nameOrCode = l), modelModifiers: { trim: true }, placeholder: "输入科目名称、编号搜索", class: "filter-item", style: { width: "200px", "margin-bottom": "15px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), g((d(), v(K, { ref: "table", border: "", data: j.value, "cell-class-name": f(D), "max-height": f(T), "highlight-current-row": false, "span-method": P, "row-key": "id" }, { default: n(() => [a(t, { type: "index", label: "序号", align: "center", width: "60" }), a(t, { key: "first", prop: "first", label: "一级", align: "left", "min-width": "160px" }, { header: n(() => [a(R, { effect: "light", content: "一级科目（名称-编号）", placement: "top" }, { default: n(() => [r("div", null, [e[7] || (e[7] = r("span", null, "一级科目", -1)), a(p, null, { default: n(() => [a(m)]), _: 1 })])]), _: 1 })]), default: n(({ row: l }) => [r("span", ye, h(`${l.fullName[0]}-${l.fullCode[0]}`), 1)]), _: 1 }), b.level > 1 ? (d(), v(t, { key: "second", prop: "second", label: "二级", align: "left", "min-width": "160px" }, { header: n(() => [a(R, { effect: "light", content: "二级科目（名称-编号）", placement: "top" }, { default: n(() => [r("div", null, [e[8] || (e[8] = r("span", null, "二级科目", -1)), a(p, null, { default: n(() => [a(m)]), _: 1 })])]), _: 1 })]), default: n(({ row: l }) => [r("span", he, h(`${l.fullName[1]}-${l.fullCode[1]}`), 1)]), _: 1 })) : N("", true), b.level > 2 ? (d(), v(t, { key: "third", prop: "third", label: "三级", align: "left", "min-width": "160px" }, { header: n(() => [a(R, { effect: "light", content: "三级科目（名称-编号）", placement: "top" }, { default: n(() => [r("div", we, [e[9] || (e[9] = r("span", null, "三级科目", -1)), a(p, null, { default: n(() => [a(m)]), _: 1 })])]), _: 1 })]), default: n(({ row: l }) => [r("span", xe, h(`${l.fullName[2]}-${l.fullCode[2]}`), 1)]), _: 1 })) : N("", true), a(t, { key: "sourceRdRate", prop: "sourceRdRate", "show-overflow-tooltip": true, label: "研发费用占比（%）", "min-width": "100px", align: "center" }, { default: n(({ row: l }) => [c.value ? (d(), S(ne, { key: 0 }, [l.sourceRow ? (d(), v(J, { key: 0, modelValue: l.sourceRow.rdRate, "onUpdate:modelValue": (Y) => l.sourceRow.rdRate = Y, step: 1, min: 0, max: 100, precision: 2, size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : N("", true)], 64)) : (d(), S("div", Ce, h(l.rdRate), 1))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[X, V.value]]), a(f(ve), ae(o.$attrs, { visible: C.value, "onUpdate:visible": e[2] || (e[2] = (l) => C.value = l), data: w.value, level: b.level, onSaveSuccess: G }), null, 16, ["visible", "data", "level"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ne = me(Ve, [["__scopeId", "data-v-fd8c55ec"]]);
export {
  Ne as default
};
