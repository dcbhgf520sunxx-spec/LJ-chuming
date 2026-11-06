import { ref as P } from "vue";
import { inject as D } from "vue";
import { computed as q } from "vue";
import { watch as B } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as c } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as V } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import { toDisplayString as l } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as M } from "vue";
import { createCommentVNode as m } from "vue";
import { isRef as K } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as z } from "element-plus";
import { a as F, b as $, d as A } from "../../../../../../modules/production-statistics-0477fed6.js";
import { u as J, o as X, pu as u, bs as _, D as h, z as Y, ba as Z } from "../../../../../../shared/runtime.js";
const ee = { class: "print-wrap" }, te = { class: "project-name" }, oe = ["innerHTML"], le = { __name: "artifact-detail", props: { visible: { type: Boolean, default: false }, reportType: { type: Number, default: void 0 } }, emits: ["update:visible"], setup(p, { emit: v }) {
  const T = P(), I = v, d = p, { visible: w, handleClose: Q } = J({ emit: I, props: d, field: "visible" }), { maxHeight: S } = X({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, T), R = D("permission"), C = D("query"), b = P(false), O = P([]), x = q(() => {
    switch (d.reportType) {
      case u.IN_PRODUCTION.V:
        return "mesStructureProductionStatisticsIn";
      case u.UN_PRODUCTION.V:
        return "mesStructureProductionStatisticsUn";
      case u.COMPLETE.V:
        return "mesStructureProductionStatisticsComplete";
      default:
        return "";
    }
  });
  B(() => d.visible, (i) => {
    i && L();
  }, { immediate: true });
  function U(i) {
    return Z(i, { props: ["totalQuantity", "totalMete"] });
  }
  async function L() {
    try {
      b.value = true;
      let i;
      switch (d.reportType) {
        case u.COMPLETE.V:
          i = A;
          break;
        case u.IN_PRODUCTION.V:
          i = $;
          break;
        case u.UN_PRODUCTION.V:
          i = F;
          break;
        default:
          break;
      }
      if (!i) return;
      const { artifactDetailsAnalysisDTOList: y } = await i(C);
      O.value = y.map((t, o) => (t.rowId = o + "" + Math.random(), t.totalQuantity = t.taskQuantity, t.totalMete = _(t.taskNetWeight, h.COM_WT__KG), t.completeMete = t.completeNetWeight && _(t.completeNetWeight, h.COM_WT__KG), t.inProductionMete = t.inProductionNetWeight && _(t.inProductionNetWeight, h.COM_WT__KG), t.unProductionMete = t.unProductionNetWeight && _(t.unProductionNetWeight, h.COM_WT__KG), t.processSequence = t.processSummaryList && t.processSummaryList.map((f) => `<span>【${f.name} │ <span style="color: #67C23A;">${f.inspectionQuantity}</span>】</span>`).join("<span> </span>"), t));
    } catch (i) {
      console.log("分组获取在制品统计", i);
    } finally {
      b.value = false;
    }
  }
  return (i, y) => {
    const t = g("print-table"), o = G, f = g("common-table"), W = g("common-drawer"), E = H("permission"), j = z;
    return c(), k(W, { ref_key: "drawerRef", ref: T, title: `${s(u).VL[p.reportType]}统计明细-构件`, modelValue: s(w), "onUpdate:modelValue": y[0] || (y[0] = (e) => K(w) ? w.value = e : null), direction: "rtl", "before-close": s(Q), size: "80%" }, { titleRight: a(() => [r("div", ee, [V(n(t, { "api-key": x.value, params: { ...s(C) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[E, s(R).printDetail]])])]), content: a(() => [s(w) ? V((c(), k(f, { key: 0, "summary-method": U, "show-summary": "", data: O.value, "max-height": s(S), "row-key": "rowId", style: { width: "100%" } }, { default: a(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "200" }, { default: a((e) => [r("span", te, l(s(Y)(e.row.project)), 1)]), _: 1 }), n(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: a((e) => [r("span", null, l(e.row.monomer.name), 1)]), _: 1 }), n(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: a((e) => [r("span", null, l(e.row.name), 1)]), _: 1 }), n(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { default: a((e) => [r("span", null, l(e.row.serialNumber), 1)]), _: 1 }), n(o, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: a((e) => [r("span", null, l(e.row.material), 1)]), _: 1 }), n(o, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "任务总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.totalQuantity), 1)]), _: 1 }), n(o, { key: "totalMete", prop: "totalMete", "show-overflow-tooltip": true, label: "任务总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.totalMete), 1)]), _: 1 }), p.reportType & s(u).COMPLETE.V ? (c(), N(M, { key: 0 }, [n(o, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.completeQuantity), 1)]), _: 1 }), n(o, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: "完成总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.completeMete), 1)]), _: 1 })], 64)) : m("", true), p.reportType & s(u).IN_PRODUCTION.V ? (c(), N(M, { key: 1 }, [n(o, { key: "inProductionQuantity", prop: "inProductionQuantity", "show-overflow-tooltip": true, label: "在制品总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.inProductionQuantity), 1)]), _: 1 }), n(o, { key: "inProductionMete", prop: "inProductionMete", "show-overflow-tooltip": true, label: "在制品总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.inProductionMete), 1)]), _: 1 })], 64)) : m("", true), p.reportType & s(u).UN_PRODUCTION.V ? (c(), N(M, { key: 2 }, [n(o, { key: "unProductionQuantity", prop: "unProductionQuantity", "show-overflow-tooltip": true, label: "未生产总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.unProductionQuantity), 1)]), _: 1 }), n(o, { key: "unProductionMete", prop: "unProductionMete", "show-overflow-tooltip": true, label: "未生产总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.unProductionMete), 1)]), _: 1 })], 64)) : m("", true), p.reportType & s(u).IN_PRODUCTION.V ? (c(), k(o, { key: "processSequence", prop: "processSequence", "show-overflow-tooltip": true, label: "【工序 │ 数量】", "min-width": "400px" }, { default: a((e) => [r("span", { innerHTML: e.row.processSequence }, null, 8, oe)]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "max-height"])), [[j, b.value]]) : m("", true)]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  le as default
};
