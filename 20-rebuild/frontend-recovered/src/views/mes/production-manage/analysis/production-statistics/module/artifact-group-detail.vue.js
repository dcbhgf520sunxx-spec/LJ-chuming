import { ref as d } from "vue";
import { inject as T } from "vue";
import { watch as H } from "vue";
import { nextTick as L } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as x } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as a } from "vue";
import { unref as u } from "vue";
import { toDisplayString as n } from "vue";
import { createTextVNode as g } from "vue";
import { isRef as A } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as J } from "element-plus";
import { g as X } from "../../../../../../modules/production-statistics-0477fed6.js";
import { u as Y, o as Z, bs as m, D as c, z as ee, pu as k, ba as te } from "../../../../../../shared/runtime.js";
import oe from "./artifact-detail.vue.js";
const ae = { class: "print-wrap" }, le = { class: "project-name" }, ne = { class: "tc-success" }, ie = { class: "tc-success" }, re = { class: "tc-warning" }, se = { class: "tc-warning" }, ue = { class: "tc-danger" }, ce = { class: "tc-danger" }, i = "件/kg", fe = { __name: "artifact-group-detail", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(O, { emit: V }) {
  const M = d(), W = V, v = O, { visible: _, handleClose: B } = Y({ emit: W, props: v, field: "visible" }), { maxHeight: G } = Z({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, M), P = T("query"), R = T("permission"), f = d(false), C = d([]), Q = d();
  function D() {
    const t = document.getElementById("groupArtifactTable").getElementsByClassName("el-table__header")[0].rows[1];
    t.style.display = "none";
  }
  function K(s) {
    return te(s, { props: ["taskQuantity", ["taskMete", c.COM_WT__KG], "completeQuantity", ["completeMete", c.COM_WT__KG], "inProductionQuantity", ["inProductionMete", c.COM_WT__KG], "unProducedQuantity", ["unProducedMete", c.COM_WT__KG]] });
  }
  const w = d(false);
  function y(s) {
    Q.value = s, w.value = true;
  }
  H(() => v.visible, (s) => {
    s && (I(), j());
  }, { immediate: true });
  function j() {
    L(() => {
      D();
    });
  }
  async function I() {
    try {
      f.value = true;
      const { artifactAnalysisList: s } = await X(P);
      C.value = s.map((t, b) => (t.rowId = b + "" + Math.random(), t.taskMete = m(t.taskNetWeight, c.COM_WT__KG), t.completeMete = m(t.completeNetWeight, c.COM_WT__KG), t.inProductionMete = m(t.inProductionNetWeight, c.COM_WT__KG), t.unProducedQuantity = t.taskQuantity - t.completeQuantity - t.inProductionQuantity, t.unProducedMete = m(t.taskMete - t.completeMete - t.inProductionMete, c.COM_WT__KG), t));
    } catch (s) {
      console.log("分组获取在制品统计", s);
    } finally {
      f.value = false;
    }
  }
  return (s, t) => {
    const b = p("print-table"), l = F, h = p("common-button"), z = p("common-table"), E = p("common-drawer"), S = q("permission"), U = J;
    return x(), $(E, { ref_key: "drawerRef", ref: M, title: "在制品统计-构件", modelValue: u(_), "onUpdate:modelValue": t[4] || (t[4] = (e) => A(_) ? _.value = e : null), direction: "rtl", "before-close": u(B), size: "80%" }, { titleRight: o(() => [r("div", ae, [N(a(b, { "api-key": "mesStructureProductionStatistics", params: { ...u(P) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[S, u(R).print]])])]), content: o(() => [N((x(), $(z, { "show-summary": "", "summary-method": K, data: C.value, "max-height": u(G), "row-key": "rowId", id: "groupArtifactTable", style: { width: "100%" } }, { default: o(() => [a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(l, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "200" }, { default: o((e) => [r("span", le, n(u(ee)(e.row.project)), 1)]), _: 1 }), a(l, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: o((e) => [r("span", null, n(e.row.monomer.name), 1)]), _: 1 }), a(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: o((e) => [r("span", null, n(e.row.name), 1)]), _: 1 }), a(l, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: o((e) => [r("span", null, n(e.row.material), 1)]), _: 1 }), a(l, { label: `任务总数(${i})`, align: "center" }, { default: o(() => [a(l, { key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: `任务总数(${i})`, align: "center", width: "90" }, { default: o((e) => [r("span", null, n(e.row.taskQuantity), 1)]), _: 1 }, 8, ["label"]), a(l, { key: "taskMete", prop: "taskMete", "show-overflow-tooltip": true, label: `任务总数(${i})`, align: "center", width: "120" }, { default: o((e) => [r("span", null, n(e.row.taskMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["label"]), a(l, { label: `已完成(${i})`, align: "center" }, { header: o(() => [a(h, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: t[0] || (t[0] = (e) => y(u(k).COMPLETE.V)) }, { default: o(() => [g(" 已完成(" + n(i) + ") ")]), _: 1 })]), default: o(() => [a(l, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: `已完成(${i})`, align: "center", width: "90" }, { default: o((e) => [r("span", ne, n(e.row.completeQuantity), 1)]), _: 1 }, 8, ["label"]), a(l, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: `已完成(${i})`, align: "center", width: "120" }, { default: o((e) => [r("span", ie, n(e.row.completeMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["label"]), a(l, { label: `在制品(${i})`, align: "center" }, { header: o(() => [a(h, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: t[1] || (t[1] = (e) => y(u(k).IN_PRODUCTION.V)) }, { default: o(() => [g(" 在制品(" + n(i) + ") ")]), _: 1 })]), default: o(() => [a(l, { key: "inProductionQuantity", prop: "inProductionQuantity", "show-overflow-tooltip": true, label: `在制品(${i})`, align: "center", width: "90" }, { default: o((e) => [r("span", re, n(e.row.inProductionQuantity), 1)]), _: 1 }, 8, ["label"]), a(l, { key: "inProductionMete", prop: "inProductionMete", "show-overflow-tooltip": true, label: `在制品(${i})`, align: "center", width: "120" }, { default: o((e) => [r("span", se, n(e.row.inProductionMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["label"]), a(l, { label: `未生产(${i})`, align: "center" }, { header: o(() => [a(h, { size: "default", link: "", type: "primary", style: { "margin-left": "5px" }, onClick: t[2] || (t[2] = (e) => y(u(k).UN_PRODUCTION.V)) }, { default: o(() => [g(" 未生产(" + n(i) + ") ")]), _: 1 })]), default: o(() => [a(l, { key: "unProducedQuantity", prop: "unProducedQuantity", "show-overflow-tooltip": true, label: `未生产(${i})`, align: "center", width: "90" }, { default: o((e) => [r("span", ue, n(e.row.unProducedQuantity), 1)]), _: 1 }, 8, ["label"]), a(l, { key: "unProducedMete", prop: "unProducedMete", "show-overflow-tooltip": true, label: `未生产(${i})`, align: "center", width: "120" }, { default: o((e) => [r("span", ce, n(e.row.unProducedMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "max-height"])), [[U, f.value]]), a(u(oe), { visible: w.value, "onUpdate:visible": t[3] || (t[3] = (e) => w.value = e), reportType: Q.value }, null, 8, ["visible", "reportType"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  fe as default
};
