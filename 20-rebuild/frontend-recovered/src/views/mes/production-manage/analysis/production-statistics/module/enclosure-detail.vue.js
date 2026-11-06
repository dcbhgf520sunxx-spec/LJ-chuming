import { ref as M } from "vue";
import { inject as S } from "vue";
import { computed as H } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as f } from "vue";
import { createBlock as L } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as n } from "vue";
import { unref as u } from "vue";
import { toDisplayString as l } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as C } from "vue";
import { createCommentVNode as y } from "vue";
import { isRef as F } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as K } from "element-plus";
import { a as G, b as J, d as W } from "../../../../../../modules/production-statistics-0477fed6.js";
import { u as X, o as Y, pu as c, c as P, D as g, z as Z } from "../../../../../../shared/runtime.js";
const ee = { class: "print-wrap" }, te = { class: "project-name" }, oe = ["innerHTML"], le = { __name: "enclosure-detail", props: { visible: { type: Boolean, default: false }, reportType: { type: Number, default: void 0 } }, emits: ["update:visible"], setup(d, { emit: V }) {
  const O = M(), Q = V, _ = d, { visible: h, handleClose: R } = X({ emit: Q, props: _, field: "visible" }), { maxHeight: U } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, O), I = S("permission"), T = S("query"), N = M(false), v = M([]), x = H(() => {
    switch (_.reportType) {
      case c.IN_PRODUCTION.V:
        return "mesEnclosureProductionStatisticsIn";
      case c.UN_PRODUCTION.V:
        return "mesEnclosureProductionStatisticsUn";
      case c.COMPLETE.V:
        return "mesEnclosureProductionStatisticsComplete";
      default:
        return "";
    }
  });
  $(() => _.visible, (i) => {
    i && q();
  }, { immediate: true });
  function j(i) {
    const { columns: w, data: t } = i, o = [];
    return w.forEach((p, s) => {
      if (s === 0) {
        o[s] = "合计";
        return;
      }
      if (s === 6 && s === 7) {
        const b = t.map((m) => Number(m[p.property]));
        b.every((m) => isNaN(m)) || (o[s] = b.reduce((m, e) => {
          const B = Number(e);
          return isNaN(B) ? m : m + e;
        }, 0));
      }
    }), o;
  }
  async function q() {
    try {
      N.value = true;
      let i;
      switch (_.reportType) {
        case c.COMPLETE.V:
          i = W;
          break;
        case c.IN_PRODUCTION.V:
          i = J;
          break;
        case c.UN_PRODUCTION.V:
          i = G;
          break;
        default:
          break;
      }
      if (!i) return;
      const { enclosureDetailsAnalysisList: w } = await i(T);
      v.value = w.map((t, o) => (t.rowId = o + "" + Math.random(), t.totalQuantity = t.taskQuantity, t.totalMete = P(t.taskLength, "mm", "m", g.MES_ENCLOSURE_L__M), t.completeMete = t.completeLength && P(t.completeLength, "mm", "m", g.MES_ENCLOSURE_L__M), t.inProductionMete = t.inProductionLength && P(t.inProductionLength, "mm", "m", g.MES_ENCLOSURE_L__M), t.unProductionMete = t.unProductionLength && P(t.unProductionLength, "mm", "m", g.MES_ENCLOSURE_L__M), t.processSequence = t.processSummaryList && t.processSummaryList.map((p) => {
        let s = "";
        return p.completeQuantity === t.totalQuantity ? s = "tc-success" : p.completeQuantity ? s = "tc-warning" : s = "", `<span>【${p.name} │ <span class="${s}">${p.inspectionQuantity}</span>】</span>`;
      }).join("<span> </span>"), t));
    } catch (i) {
      console.log("分组获取在制品统计", i);
    } finally {
      N.value = false;
    }
  }
  return (i, w) => {
    const t = k("print-table"), o = A, p = k("common-table"), s = k("common-drawer"), b = z("permission"), m = K;
    return f(), L(s, { ref_key: "drawerRef", ref: O, title: `${u(c).VL[d.reportType]}统计明细-围护`, modelValue: u(h), "onUpdate:modelValue": w[0] || (w[0] = (e) => F(h) ? h.value = e : null), direction: "rtl", "before-close": u(R), size: "80%" }, { titleRight: a(() => [r("div", ee, [D(n(t, { "api-key": x.value, params: { ...u(T) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[b, u(I).printDetail]])])]), content: a(() => [u(h) ? D((f(), L(p, { key: 0, "summary-method": j, "show-summary": "", data: v.value, "row-key": "rowId", "max-height": u(U), style: { width: "100%" } }, { default: a(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "200" }, { default: a((e) => [r("span", te, l(u(Z)(e.row.project)), 1)]), _: 1 }), n(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: a((e) => [r("span", null, l(e.row.monomer.name), 1)]), _: 1 }), n(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: a((e) => [r("span", null, l(e.row.name), 1)]), _: 1 }), n(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { default: a((e) => [r("span", null, l(e.row.serialNumber), 1)]), _: 1 }), n(o, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: a((e) => [r("span", null, l(e.row.material), 1)]), _: 1 }), n(o, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "任务总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.totalQuantity), 1)]), _: 1 }), n(o, { key: "totalMete", prop: "totalMete", "show-overflow-tooltip": true, label: "任务总量", align: "center", width: "120" }, { default: a((e) => [r("span", null, l(e.row.totalMete), 1)]), _: 1 }), d.reportType & u(c).COMPLETE.V ? (f(), E(C, { key: 0 }, [n(o, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.completeQuantity), 1)]), _: 1 }), n(o, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: "完成总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.completeMete), 1)]), _: 1 })], 64)) : y("", true), d.reportType & u(c).IN_PRODUCTION.V ? (f(), E(C, { key: 1 }, [n(o, { key: "inProductionQuantity", prop: "inProductionQuantity", "show-overflow-tooltip": true, label: "在制品总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.inProductionQuantity), 1)]), _: 1 }), n(o, { key: "inProductionMete", prop: "inProductionMete", "show-overflow-tooltip": true, label: "在制品总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.inProductionMete), 1)]), _: 1 })], 64)) : y("", true), d.reportType & u(c).UN_PRODUCTION.V ? (f(), E(C, { key: 2 }, [n(o, { key: "unProductionQuantity", prop: "unProductionQuantity", "show-overflow-tooltip": true, label: "未生产总数", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.unProductionQuantity), 1)]), _: 1 }), n(o, { key: "unProductionMete", prop: "unProductionMete", "show-overflow-tooltip": true, label: "未生产总量", align: "center", width: "90" }, { default: a((e) => [r("span", null, l(e.row.unProductionMete), 1)]), _: 1 })], 64)) : y("", true), d.reportType & u(c).IN_PRODUCTION.V ? (f(), L(o, { key: "processSequence", prop: "processSequence", "show-overflow-tooltip": true, label: "【工序 │ 数量】", "min-width": "400px" }, { default: a((e) => [r("span", { innerHTML: e.row.processSequence }, null, 8, oe)]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "max-height"])), [[m, N.value]]) : y("", true)]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  le as default
};
