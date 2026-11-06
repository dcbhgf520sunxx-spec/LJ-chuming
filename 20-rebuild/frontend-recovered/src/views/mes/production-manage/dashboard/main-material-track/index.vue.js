import { reactive as F } from "vue";
import { ref as f } from "vue";
import { onMounted as J } from "vue";
import { watch as A } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as z } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as s } from "vue";
import { ElCol as O } from "element-plus";
import { ElRow as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as Z, a as ee } from "../../../../../modules/main-material-track-74a129d5.js";
import { o as ae, m as te, J as le, G as _, py as m } from "../../../../../shared/runtime.js";
import { P as v } from "../../../../../modules/index-5b9e6004.js";
import oe from "./module/plate-use-record.vue.js";
import ne from "./module/stock-detail.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const se = { class: "app-container" }, re = ["onClick"], ie = ["onClick"], ce = { key: 0, class: "tc-success" }, pe = { key: 1, class: "tc-danger" }, be = { __name: "index", setup(ue) {
  const { maxHeight: S } = ae({ extraBox: [".panel-group", ".print-table"], paginate: true }), { globalProjectId: p } = te(["globalProjectId"]), i = F({ plates: 0, artifacts: 0 }), h = f(false);
  async function R() {
    if (_(m.get)) try {
      h.value = true;
      const t = await ee({ projectId: p.value });
      i.artifacts = t.artifacts, i.plates = t.plates, i.loss = t.plates - t.artifacts, i.lossRate = t.plates ? (t.plates - t.artifacts) / t.plates * 100 : 0;
    } catch (t) {
      console.log("汇总信息", t);
    } finally {
      h.value = false;
    }
  }
  const b = f(false), I = f([]), { handleSizeChange: E, handleCurrentChange: B, total: H, setTotalPage: L, queryPage: k } = le({ fetchHook: w });
  async function w() {
    if (_(m.get)) try {
      b.value = true;
      const { content: t, totalElements: u } = await Z({ projectId: p.value, ...k });
      L(u), I.value = t.map((r) => (r.diffRate = r.diffRate ? r.diffRate.toFixed(2) : 0, r));
    } catch (t) {
      console.log("用量对比列表信息", t);
    } finally {
      b.value = false;
    }
  }
  J(() => {
    R(), w();
  }), A(p, (t) => {
    R(), w();
  }, { deep: true });
  const y = f(false), C = f(false), g = f({});
  function G(t) {
    _(m.useRecordGet) && (g.value = t, y.value = true);
  }
  function T(t) {
    _(m.stockGet) && (g.value = t, C.value = true);
  }
  return (t, u) => {
    const r = O, U = Q, V = j("print-table"), n = W, $ = j("common-table"), D = X, P = Y, N = K("permission");
    return d(), x("div", se, [M((d(), z(U, { gutter: 20, class: "panel-group" }, { default: o(() => [a(r, { span: 6, class: "card-panel-col" }, { default: o(() => [a(l(v), { name: "项目领料总量", "num-color": "#1890ff", "end-val": i.plates || 0 }, null, 8, ["end-val"])]), _: 1 }), a(r, { span: 6, class: "card-panel-col" }, { default: o(() => [a(l(v), { name: "构件总重量", "num-color": "#1890ff", "end-val": i.artifacts || 0 }, null, 8, ["end-val"])]), _: 1 }), a(r, { span: 6, class: "card-panel-col" }, { default: o(() => [a(l(v), { name: "损耗", "num-color": "#1890ff", "end-val": i.loss || 0 }, null, 8, ["end-val"])]), _: 1 }), a(r, { span: 6, class: "card-panel-col" }, { default: o(() => [a(l(v), { name: "损耗率(%)", "num-color": "#1890ff", "end-val": i.lossRate || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[P, h.value]]), M(a(V, { "api-key": "mesMainMaterialTrack", params: { projectId: l(p) }, size: "default", type: "warning", class: "print-table", style: { "margin-top": "10px", "margin-bottom": "10px", float: "right" } }, null, 8, ["params"]), [[N, l(m).print]]), M((d(), z($, { data: I.value, maxHeight: l(S), style: { width: "100%" } }, { default: o(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { prop: "name", "show-overflow-tooltip": true, label: "品名", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.name), 1)]), _: 1 }), a(n, { prop: "thickness", "show-overflow-tooltip": true, label: "厚度/规格", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.thickness), 1)]), _: 1 }), a(n, { prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.material), 1)]), _: 1 }), a(n, { prop: "listMete", "show-overflow-tooltip": true, label: "清单量(kg)", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.listMete), 1)]), _: 1 }), a(n, { prop: "stockMete", "show-overflow-tooltip": true, label: "库存量(库存=公共库+项目库)", align: "center" }, { default: o(({ row: e }) => [c("span", { class: "tc-primary pointer", onClick: (q) => T(e) }, s(e.stockMete), 9, re)]), _: 1 }), a(n, { prop: "useMete", "show-overflow-tooltip": true, label: "实际领用量(kg)", align: "center" }, { default: o(({ row: e }) => [c("span", { class: "tc-primary pointer", onClick: (q) => G(e) }, s(e.useMete), 9, ie)]), _: 1 }), a(n, { prop: "diff", "show-overflow-tooltip": true, label: "差异(kg)", align: "center" }, { default: o(({ row: e }) => [e.listMete >= e.useMete ? (d(), x("span", ce, s(e.diff), 1)) : (d(), x("span", pe, s(e.diff), 1))]), _: 1 }), a(n, { prop: "diffRate", "show-overflow-tooltip": true, label: "差异率(%)", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.diffRate), 1)]), _: 1 }), a(n, { prop: "productMete", "show-overflow-tooltip": true, label: "生产量(kg)", align: "center" }, { default: o(({ row: e }) => [c("span", null, s(e.productMete), 1)]), _: 1 })]), _: 1 }, 8, ["data", "maxHeight"])), [[P, b.value]]), a(D, { total: l(H), "current-page": l(k).pageNumber, "page-size": l(k).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(E), onCurrentChange: l(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(l(oe), { visible: y.value, "onUpdate:visible": u[0] || (u[0] = (e) => y.value = e), projectId: l(p), info: g.value }, null, 8, ["visible", "projectId", "info"]), a(l(ne), { visible: C.value, "onUpdate:visible": u[1] || (u[1] = (e) => C.value = e), projectId: l(p), info: g.value }, null, 8, ["visible", "projectId", "info"])]);
  };
} };
export {
  be as default
};
