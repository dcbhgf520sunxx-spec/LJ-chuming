import { ref as p } from "vue";
import { watch as M } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as f } from "vue";
import { withCtx as u } from "vue";
import { createStaticVNode as B } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElSegmented as T } from "element-plus";
import { ElProgress as j } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as F } from "../../../../../modules/ship-summary-d5d4a58f.js";
import { _ as I, cM as v, x as V, o as U, i as q } from "../../../../../shared/runtime.js";
import { q as w } from "../../../../../modules/ship-manage-3066b2ed.js";
import N from "./module/header.vue.js";
import W from "./module/project-shipment-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail.vue.js";
import "./module/direct-detail.vue.js";
import "./module/ship-list.vue.js";
import "./module/package-detail-drawer.vue.js";
import "./module/train-number-list.vue.js";
import "./module/detail-drawer.vue.js";
const Y = { class: "app-container" }, O = { style: { display: "flex" } }, Q = { style: { width: "30%", "padding-right": "10px" } }, K = { class: "head-container" }, L = { style: { flex: "1", overflow: "hidden", "padding-left": "10px" } }, $ = { key: 1, class: "my-code" }, z = { __name: "index", setup(G) {
  const b = { add: false, edit: false, del: false, download: false }, x = [{ label: "按重量", value: "weight" }, { label: "按数量", value: "quantity" }], n = p(v.get("MES_SHIP_SUMMARY_DATA_TYPE") || "weight"), y = p([["project", "parse-project"]]), _ = p(), m = p({});
  M(() => n.value, (d) => {
    v.set("MES_SHIP_SUMMARY_DATA_TYPE", d);
  }, { immediate: true });
  const { crud: r, CRUD: S } = V({ title: "发运管理", sort: [], permission: { ...w }, dataPath: "", optShow: { ...b }, crudApi: { ...F }, hasPagination: false }, _), { maxHeight: k } = U({ extraBox: [".head-container"], wrapperBox: [".app-container"], paginate: false, extraHeight: 70 });
  S.HOOK.handleRefresh = (d, { data: t }) => {
    t.forEach((e) => {
      var l;
      e.projectId = (l = e.project) == null ? void 0 : l.id, e.rate = e.sendMete && e.mete ? (e.sendMete / e.mete * 100).toFixed(2) : 0;
    });
  };
  function R(d) {
    m.value = d;
  }
  return (d, t) => {
    const e = H, l = T, h = j, C = A("common-table"), E = D;
    return c(), g("div", Y, [i("div", O, [i("div", Q, [i("div", K, [o(a(N))]), P((c(), f(C, { ref_key: "tableRef", ref: _, data: a(r).data, "data-format": y.value, "empty-text": a(r).emptyText, onCurrentChange: R, "highlight-current-row": "", "max-height": a(k), style: { width: "100%" }, stripe: false, showEmptySymbol: false }, { default: u(() => [o(e, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), o(e, { key: "project", prop: "project", label: "项目", align: "left", "min-width": "160" }), o(e, { key: "ratio", prop: "ratio", label: "发运数据", align: "center", "min-width": "130", "show-overflow-tooltip": "" }, { header: u(() => [o(l, { modelValue: n.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => n.value = s), options: x }, null, 8, ["modelValue"])]), default: u((s) => [o(h, { color: "#409EFF", "stroke-width": 14, percentage: n.value === "weight" ? s.row.sendWarehouseWeightRatio || 0 : s.row.sendWarehouseQuantityRatio || 0, style: { "margin-bottom": "5px" } }, null, 8, ["percentage"]), o(h, { color: "#F56C6C", "stroke-width": 14, percentage: n.value === "weight" ? s.row.sendInventoryWeightRatio || 0 : s.row.sendInventoryQuantityRatio || 0 }, null, 8, ["percentage"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[E, a(r).loading]]), t[1] || (t[1] = B('<div class="info-box" data-v-d9a55d4b><div class="item" data-v-d9a55d4b><span class="block" data-v-d9a55d4b></span><span class="title" data-v-d9a55d4b>发货进度：</span><span data-v-d9a55d4b>发货量 / 入库量</span></div><div class="item" data-v-d9a55d4b><span class="block" style="background:#f56c6c;" data-v-d9a55d4b></span><span class="title" data-v-d9a55d4b>总发运进度：</span><span data-v-d9a55d4b>发货量 / 清单量</span></div></div>', 1))]), t[2] || (t[2] = i("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 130px)" } }, null, -1)), i("div", L, [a(q)(m.value) ? (c(), f(W, { key: 0, weightStatus: a(r).query.weightStatus, currentRow: m.value, permission: a(w) }, null, 8, ["weightStatus", "currentRow", "permission"])) : (c(), g("div", $, "*点击左表操作查看明细"))])])]);
  };
} }, me = I(z, [["__scopeId", "data-v-d9a55d4b"]]);
export {
  me as default
};
