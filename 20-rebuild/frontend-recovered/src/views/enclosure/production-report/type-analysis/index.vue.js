import { ref as n } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as p } from "vue";
import { unref as l } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as m } from "vue";
import { withCtx as S } from "vue";
import { createCommentVNode as _ } from "vue";
import { normalizeStyle as b } from "vue";
import { ElTableColumn as F } from "element-plus";
import { ElDivider as K } from "element-plus";
import { vLoading as $ } from "element-plus";
import { l as N, kA as T, D as R, o as z, x as G, ba as J } from "../../../../shared/runtime.js";
import { j as Q } from "../../../../modules/enclosure-365a2177.js";
import W from "./module/header.vue.js";
import { u as M } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
function X(u) {
  return N({ module: "enclosure", url: "produce/overview/order/category/produce/analysis", method: "get", params: u });
}
function Y(u) {
  return N({ module: "enclosure", url: "produce/overview/order/plate/produce/analysis", method: "get", params: u });
}
const V = { get: X, detail: Y }, Z = { class: "app-container" }, ee = { class: "type-analysis", style: { display: "flex" } }, te = { style: { display: "flex" } }, re = { __name: "index", setup(u) {
  const B = { add: false, edit: false, del: false, download: false }, w = n(), C = n(), f = n(false), g = n({}), L = n(Object.values(T.V)), h = n(false), k = n([]), A = n([["proportion", ["suffix", "%"]], ["completeLength", ["to-fixed", R.MES_ENCLOSURE_L__M]]]), { maxHeight: E } = z({ extraBox: [".head-container", ".type-analysis", ".el-divider"], minHeight: 200, paginate: false }, C);
  function O(e) {
    return J(e, { props: [["completeLength", R.MES_ENCLOSURE_L__M]] });
  }
  const { CRUD: I, crud: c, columns: v } = G({ title: "类型分析", sort: [], permission: { ...Q }, optShow: { ...B }, crudApi: { ...V }, hasPagination: false }, w), { getMyChart: H } = M({ elementId: "typeAnalysisChart", initOption: { legend: { show: false }, title: { text: "单位：m" }, yAxis: { type: "category", axisTick: { show: false }, data: L.value.reverse().map((e) => e.L) }, xAxis: { type: "value" }, series: [{ name: "产量", type: "bar", data: [] }] } }), { getMyChart: P } = M({ elementId: "typeSpecificationChart", initOption: { legend: { show: false }, title: { text: "单位：m" }, yAxis: { type: "category", axisTick: { show: false }, data: [] }, xAxis: { type: "value" }, series: [{ name: "产量", type: "bar", data: [] }] } });
  async function U() {
    try {
      h.value = true;
      const e = await V.detail({ category: g.value.category, ...c.query }) || [], o = [], t = [];
      k.value = e.map((a) => (o.push(a.completeLength), t.push(a.plate), a));
      const i = P(), s = i.getOption();
      s.series[0].data = o.reverse(), s.yAxis[0].data = t.reverse(), s.title[0].text = `${g.value.name} 单位：m`, i.setOption(s);
    } catch (e) {
      console.log("获取类型规格分析", e);
    } finally {
      h.value = false;
    }
  }
  function j(e = {}) {
    !(e != null && e.category) || e.category === T.FOLDING_PIECE.V ? f.value = false : (f.value = true, g.value = { ...e }, U());
  }
  return I.HOOK.handleRefresh = async (e, { data: o }) => {
    const t = {};
    o.content = o.map((a) => (t[a.category] = a, a));
    const i = H(), s = i.getOption();
    s.series[0].data = L.value.map((a) => {
      var D;
      return ((D = t[a.V]) == null ? void 0 : D.completeLength) || 0;
    }), i.setOption(s);
  }, (e, o) => {
    const t = F, i = q("common-table"), s = K, a = $;
    return r(), x("div", Z, [p(l(W), { class: "head-container" }), d("div", ee, [y((r(), m(i, { ref_key: "tableRef", ref: w, data: l(c).data, "empty-text": l(c).emptyText, "max-height": 311, "data-format": A.value, "highlight-current-row": "", "show-summary": "", "summary-method": O, style: { width: "404px", "margin-right": "20px" }, onCurrentChange: j }, { default: S(() => [p(t, { label: "序号", type: "index", align: "center", width: "60" }), l(v).visible("name") ? (r(), m(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "类型", align: "center" })) : _("", true), l(v).visible("completeLength") ? (r(), m(t, { key: "completeLength", prop: "completeLength", "show-overflow-tooltip": true, label: "产量(米)", align: "center" })) : _("", true), l(v).visible("proportion") ? (r(), m(t, { key: "proportion", prop: "proportion", "show-overflow-tooltip": true, label: "占比", align: "center" })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format"])), [[a, l(c).loading]]), y((r(), x("div", { style: b([{ height: "311px" }, { flex: "1" }]) }, o[0] || (o[0] = [d("div", { id: "typeAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[a, l(c).loading]])]), d("div", { style: b({ opacity: f.value ? 100 : 0 }) }, [p(s), d("div", te, [y((r(), m(i, { ref_key: "detailTableRef", ref: C, data: k.value, "max-height": l(E), "data-format": A.value, "show-summary": "", "summary-method": O, style: { width: "404px", "margin-right": "20px" } }, { default: S(() => [p(t, { label: "序号", type: "index", align: "center", width: "60" }), p(t, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" }), p(t, { "show-overflow-tooltip": "", prop: "completeLength", key: "completeLength", label: "产量(米)", align: "center" }), p(t, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[a, h.value]]), y((r(), x("div", { style: b([{ height: l(E) + "px" }, { flex: "1" }]) }, o[1] || (o[1] = [d("div", { id: "typeSpecificationChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, h.value]])])], 4)]);
  };
} };
export {
  re as default
};
