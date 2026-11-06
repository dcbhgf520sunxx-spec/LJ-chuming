import { ref as d } from "vue";
import { inject as S } from "vue";
import { watch as A } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as C } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as n } from "vue";
import { unref as u } from "vue";
import { toDisplayString as l } from "vue";
import { createTextVNode as h } from "vue";
import { isRef as J } from "vue";
import { ElTableColumn as K } from "element-plus";
import { vLoading as W } from "element-plus";
import { g as X } from "../../../../../../modules/production-statistics-0477fed6.js";
import { u as Y, o as Z, c as M, D as p, z as ee, pu as g, ba as te } from "../../../../../../shared/runtime.js";
import oe from "./enclosure-detail.vue.js";
const ae = { class: "print-wrap" }, ne = { class: "project-name" }, le = { class: "tc-success" }, re = { class: "tc-success" }, ie = { class: "tc-warning" }, se = { class: "tc-warning" }, ue = { class: "tc-danger" }, ce = { class: "tc-danger" }, s = "件/m", we = { __name: "enclosure-group-detail", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(x, { emit: R }) {
  const k = d(), U = R, E = x, { visible: _, handleClose: O } = Y({ emit: U, props: E, field: "visible" }), { maxHeight: V } = Z({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, k), v = S("query"), $ = S("permission"), w = d(false), P = d([]), L = d();
  function T() {
    const e = document.getElementById("groupEnclosureTable").getElementsByClassName("el-table__header")[0].rows[0].cells, c = [5, 7, 9, 11];
    for (let a = 0; a < c.length; a++) e[c[a]].colSpan = 2, e[c[a] + 1].style.display = "none";
  }
  A(() => E.visible, (i) => {
    i && (j(), B());
  }, { immediate: true });
  function B() {
    F(() => {
      T();
    });
  }
  function D(i) {
    return te(i, { props: ["taskQuantity", ["taskMete", p.MES_ENCLOSURE_L__M], "completeQuantity", ["completeMete", p.MES_ENCLOSURE_L__M], "inProductionQuantity", ["inProductionMete", p.MES_ENCLOSURE_L__M], "unProducedQuantity", ["unProducedMete", p.MES_ENCLOSURE_L__M]] });
  }
  const f = d(false);
  function y(i) {
    L.value = i, f.value = true;
  }
  async function j() {
    try {
      w.value = true;
      const { enclosureAnalysisList: i } = await X(v);
      P.value = i.map((e, c) => (e.rowId = c + "" + Math.random(), e.taskMete = M(e.taskLength, "mm", "m", p.MES_ENCLOSURE_L__M), e.completeMete = M(e.completeLength, "mm", "m", p.MES_ENCLOSURE_L__M), e.inProductionMete = M(e.inProductionLength, "mm", "m", p.MES_ENCLOSURE_L__M), e.unProducedQuantity = e.taskQuantity - e.completeQuantity - e.inProductionQuantity, e.unProducedMete = e.taskMete - e.completeMete - e.inProductionMete, e));
    } catch (i) {
      console.log("分组获取在制品统计", i);
    } finally {
      w.value = false;
    }
  }
  return (i, e) => {
    const c = m("print-table"), a = K, b = m("common-button"), I = m("common-table"), z = m("common-drawer"), H = G("permission"), q = W;
    return C(), Q(z, { ref_key: "drawerRef", ref: k, title: "在制品统计-围护", modelValue: u(_), "onUpdate:modelValue": e[4] || (e[4] = (t) => J(_) ? _.value = t : null), direction: "rtl", "before-close": u(O), size: "80%" }, { titleRight: o(() => [r("div", ae, [N(n(c, { "api-key": "mesEnclosureProductionStatistics", params: { ...u(v) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[H, u($).print]])])]), content: o(() => [N((C(), Q(I, { "summary-method": D, "show-summary": "", data: P.value, "max-height": u(V), "row-key": "rowId", id: "groupEnclosureTable", style: { width: "100%" } }, { default: o(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(a, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "200" }, { default: o((t) => [r("span", ne, l(u(ee)(t.row.project)), 1)]), _: 1 }), n(a, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: o((t) => [r("span", null, l(t.row.monomer.name), 1)]), _: 1 }), n(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: o((t) => [r("span", null, l(t.row.name), 1)]), _: 1 }), n(a, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: o((t) => [r("span", null, l(t.row.material), 1)]), _: 1 }), n(a, { key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: `任务总数(${s})`, align: "center", width: "90" }, { default: o((t) => [r("span", null, l(t.row.taskQuantity), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "taskMete", prop: "taskMete", "show-overflow-tooltip": true, label: `任务总数(${s})`, align: "center", width: "120" }, { default: o((t) => [r("span", null, l(t.row.taskMete), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: `已完成(${s})`, align: "center", width: "90" }, { header: o(() => [n(b, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: e[0] || (e[0] = (t) => y(u(g).COMPLETE.V)) }, { default: o(() => [h(" 已完成(" + l(s) + ") ")]), _: 1 })]), default: o((t) => [r("span", le, l(t.row.completeQuantity), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: `已完成(${s})`, align: "center", width: "120" }, { default: o((t) => [r("span", re, l(t.row.completeMete), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "inProductionQuantity", prop: "inProductionQuantity", "show-overflow-tooltip": true, label: `在制品(${s})`, align: "center", width: "90" }, { header: o(() => [n(b, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: e[1] || (e[1] = (t) => y(u(g).IN_PRODUCTION.V)) }, { default: o(() => [h(" 在制品(" + l(s) + ") ")]), _: 1 })]), default: o((t) => [r("span", ie, l(t.row.inProductionQuantity), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "inProductionMete", prop: "inProductionMete", "show-overflow-tooltip": true, label: `在制品(${s})`, align: "center", width: "120" }, { default: o((t) => [r("span", se, l(t.row.inProductionMete), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "unProducedQuantity", prop: "unProducedQuantity", "show-overflow-tooltip": true, label: `未生产(${s})`, align: "center", width: "90" }, { header: o(() => [n(b, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: e[2] || (e[2] = (t) => y(u(g).UN_PRODUCTION.V)) }, { default: o(() => [h(" 未生产(" + l(s) + ") ")]), _: 1 })]), default: o((t) => [r("span", ue, l(t.row.unProducedQuantity), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "unProducedMete", prop: "unProducedMete", "show-overflow-tooltip": true, label: `未生产(${s})`, align: "center", width: "120" }, { default: o((t) => [r("span", ce, l(t.row.unProducedMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "max-height"])), [[q, w.value]]), n(u(oe), { visible: f.value, "onUpdate:visible": e[3] || (e[3] = (t) => f.value = t), reportType: L.value }, null, 8, ["visible", "reportType"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  we as default
};
