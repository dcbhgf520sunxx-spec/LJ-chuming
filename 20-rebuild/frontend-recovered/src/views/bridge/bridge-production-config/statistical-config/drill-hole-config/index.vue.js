import { ref as s } from "vue";
import { provide as L } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as h } from "vue";
import { unref as e } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as M } from "vue";
import { ElTableColumn as F } from "element-plus";
import { ElCard as G } from "element-plus";
import { ElCol as K } from "element-plus";
import { ElRow as U } from "element-plus";
import { vLoading as $ } from "element-plus";
import j from "./drill-detail/index.vue.js";
import { l as d, aA as q, x as z, b3 as g, i as J, o as Q, G as W, an as X } from "../../../../../shared/runtime.js";
import Y from "./module/form.vue.js";
import "./drill-detail/module/form.vue.js";
function Z(t) {
  return d({ module: "bridge", url: "borehole", method: "get", params: t });
}
function ee(t) {
  return d({ module: "bridge", url: "borehole", method: "post", data: [t] });
}
function te(t) {
  return d({ module: "bridge", url: "borehole", method: "post", data: t });
}
function oe(t) {
  return d({ module: "bridge", url: "borehole", method: "put", data: t });
}
function ae(t) {
  return d({ module: "bridge", url: "borehole", method: "delete", data: t });
}
const ne = { get: Z, add: ee, batchAdd: te, del: ae, edit: oe }, le = { class: "app-container" }, ie = { style: { "line-height": "28px" } }, me = { __name: "index", setup(t) {
  const R = s(), i = s({}), b = s({}), k = { batchAdd: false, add: false, edit: false, del: false, download: false }, x = s(), D = s([...q]), { crud: r, CRUD: S } = z({ title: "钻孔配置", hasPagination: true, formStore: true, formStoreKey: "MES_STATISTICAL_DRILL_HOLE_CONFIG", sort: [], permission: { ...g }, optShow: { ...k }, crudApi: { ...ne }, dataPath: "" }, x);
  function A(n) {
    n && (i.value = n, b.value = {});
  }
  function O(n) {
    console.log("handleChangeCutConfig", n), n && (b.value = n);
  }
  S.HOOK.handleRefresh = (n, l) => {
    J(i.value) && (i.value = l.data.find((p) => p.id === i.value.id));
  };
  const { maxHeight: C } = Q({ wrapperBox: [".app-container", "#laying-off-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  return L("maxHeight", C), (n, l) => {
    const p = y("common-button"), c = F, T = y("common-table"), B = G, w = K, E = U, H = P("permission"), N = $;
    return m(), I("div", le, [o(E, { gutter: 10, id: "laying-off-content" }, { default: a(() => [o(w, { xs: 24, sm: 24, md: 24, lg: 12, xl: 12, style: { "margin-bottom": "10px" } }, { default: a(() => [o(B, { class: "line-box box-card" }, { header: a(() => [f("span", ie, h(e(r).title) + "列表", 1), v((m(), _(p, { style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(r).toAdd }, { default: a(() => l[0] || (l[0] = [V(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[H, e(g).add]])]), default: a(() => [v((m(), _(T, { ref_key: "tableRef", ref: x, data: e(r).data, "highlight-current-row": "", "data-format": D.value, "show-empty-symbol": false, "max-height": e(C), style: { width: "100%" }, "row-key": "id", onCurrentChange: A }, { default: a(() => [o(c, { label: "序号", type: "index", align: "center", width: "60" }), o(c, { prop: "specPrefix", "show-overflow-tooltip": true, label: "零件规格前缀", align: "center", width: "160px" }), o(c, { "show-overflow-tooltip": true, label: "板厚数值（毫米）", align: "center", "min-width": "200px" }, { default: a(({ row: u }) => [f("span", null, h(u.minThickness), 1), l[1] || (l[1] = f("span", null, " ~ ", -1)), f("span", null, h(u.maxThickness), 1)]), _: 1 }), e(W)(e(g).del) ? (m(), _(c, { key: 0, label: "操作", width: "130px", align: "center" }, { default: a(({ row: u }) => [o(e(X), { "show-edit": true, "show-del": true, data: u }, null, 8, ["data"])]), _: 1 })) : M("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[N, e(r).loading]]), o(Y)]), _: 1 })]), _: 1 }), o(w, { xs: 24, sm: 24, md: 24, lg: 12, xl: 12, style: { "margin-bottom": "10px" } }, { default: a(() => [o(e(j), { ref_key: "drillDetailRef", ref: R, onDrillDetail: O, layingOffRow: i.value, onRefresh: e(r).refresh }, null, 8, ["layingOffRow", "onRefresh"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  me as default
};
